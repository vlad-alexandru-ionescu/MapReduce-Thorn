// testing needs to be done when server side is done
// test data in /js/testworkers.js
// url would be changed once know specific location

function getNodes() {

var url = "http://localhost:8081/smr/smr_http:get_workers";

$.get(url,
  function(data){
    var number = data.length;
    var current;
    var result = new Array();
    for(current = 0; current<number; current++) {
      var temp = data[current];
      var worker = new Object();
      worker.node = temp.node;
      worker.exec = temp.num_exec;
      worker.succ = temp.num_succ;
      worker.fail = temp.num_failed;
      worker.busy = temp.busy_time;
      worker.map = temp.num_map_tasks;
      worker.red = temp.num_reduce_tasks;
      result[current] = worker;
    }
    return result;
});

}

