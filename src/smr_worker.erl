
-module(smr_worker).

-behaviour(gen_server).

-export([start_link/1, do_job/5, run_thorn_job/2]).
-export([init/1, handle_cast/2, handle_call/3, handle_info/2, terminate/2,
        code_change/3]).

%------------------------------------------------------------------------------
% API
%------------------------------------------------------------------------------

start_link(Node) ->
    Parent = self(),
    Pid = proc_lib:spawn_link(
             Node,
             fun () ->
                     {ok, State} = ?MODULE:init([]),
                     Parent ! {init_done, self()},
                     gen_server:enter_loop(?MODULE, [], State)
             end),
    MonitorRef = erlang:monitor(process, Pid),
    receive {init_done, Pid} ->
                erlang:demonitor(MonitorRef),
                {ok, Pid};
            {'DOWN', MonitorRef, process, Pid, Reason} ->
                {error, Reason}
    end.

do_job(Worker, JobPid, JobType, Fun, Input) ->
    gen_server:cast(Worker, {do_job, JobPid, JobType, Fun, Input}).

%------------------------------------------------------------------------------
% Handlers
%------------------------------------------------------------------------------

init([]) ->
    {ok, none}.

handle_call(Call, _From, State) ->
    {stop, {unexpected_call, Call}, State}.

handle_cast({do_job, JobPid, map, MapFun, MapInput}, State) ->
    smr_job:result(JobPid, self(), lists:flatmap(MapFun, MapInput)),
    {noreply, State};
handle_cast({do_job, JobPid, reduce, ReduceFun, ReduceInput}, State) ->
    smr_job:result(JobPid, self(),
                   lists:map(fun (KV = {K, _}) -> {K, ReduceFun(KV)} end,
                             ReduceInput)),
    {noreply, State}.

handle_info(Msg, State) ->
    {stop, {unexpected_message, Msg}, State}.

code_change(_OldVsn, State, _Extra) ->
    {ok, State}.

terminate(_Reason, _State) ->
    ok.

run_thorn_job(Code, Input) ->
    Temp = os:cmd("mktemp /tmp/XXXXXXXXXX-tmp.th"),
    EscCode = re:replace(Code, "'", "'\"'\"'", [{return, list}, global]),
    os:cmd("echo '" ++ EscCode ++ "' > " ++ Temp),
    EscInput = re:replace(Input, "'", "'\"'\"'", [{return, list}, global]),
    Output = os:cmd("echo '" ++ EscInput ++ "' | $TH -f " ++ Temp),
    os:cmd("rm -f " ++ Temp),
    Output.
