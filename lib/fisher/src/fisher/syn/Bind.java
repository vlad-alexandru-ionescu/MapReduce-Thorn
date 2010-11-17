package fisher.syn;
/* Beware!  This is a generated file.  Change the generator's dataset! */
import java.util.*;
import fisher.syn.visitor.*;
import fisher.syn.*;
import fisher.statics.*;
import fisher.syn.core.*;
import fisher.syn.interfaces.*;
import fisher.parser.Token;
import fisher.syn.chart.*;
import fisher.runtime.*;
import fisher.statics.purity.PurityStatus;
public  class Bind extends Cmd implements ModuleFileMember, ClassMember, ObjectMember, ProcMember, LocalMember {
 public  Pat pat; 
 public  Cmd exp; 
public Bind(Token start, Token end, Pat pat, Cmd exp){
    super(start, end);
    this.pat = pat;
    if(pat != null) children.add(pat);
    this.exp = exp;
    if(exp != null) children.add(exp);
}
public <ARG, RET,  EXN extends Exception> RET accept(Visitor<ARG,RET,  EXN> vis, ARG arg) throws EXN {
   return vis.visit((Bind)this, arg);
}
public <ARG,  EXN extends Exception> void accept(Walker<ARG, EXN> vis, ARG arg) throws EXN {
    vis.visit((Bind)this, arg);
}
public <ARG, RET,  EXN extends Exception> RET accept(VisitCmd<ARG,RET,  EXN> vis, ARG arg) throws EXN {
   return vis.visit((Bind)this, arg);
}






public <ARG, RET,  EXN extends Exception> RET accept(ClassMemberVisitor<ARG,RET,  EXN> vis, ARG arg) throws EXN {
   return vis.visit((Bind)this, arg);
}
public <ARG,  EXN extends Exception> void accept(ClassMemberWalker<ARG, EXN> vis, ARG arg) throws EXN {
    vis.visit((Bind)this, arg);
}
public <ARG, RET,  EXN extends Exception> RET accept(ObjectMemberVisitor<ARG,RET,  EXN> vis, ARG arg) throws EXN {
   return vis.visit((Bind)this, arg);
}
public <ARG,  EXN extends Exception> void accept(ObjectMemberWalker<ARG, EXN> vis, ARG arg) throws EXN {
    vis.visit((Bind)this, arg);
}
public <ARG, RET,  EXN extends Exception> RET accept(ProcMemberVisitor<ARG,RET,  EXN> vis, ARG arg) throws EXN {
   return vis.visit((Bind)this, arg);
}
public <ARG,  EXN extends Exception> void accept(ProcMemberWalker<ARG, EXN> vis, ARG arg) throws EXN {
    vis.visit((Bind)this, arg);
}
public <ARG, RET,  EXN extends Exception> RET accept(LocalMemberVisitor<ARG,RET,  EXN> vis, ARG arg) throws EXN {
   return vis.visit((Bind)this, arg);
}
public <ARG,  EXN extends Exception> void accept(LocalMemberWalker<ARG, EXN> vis, ARG arg) throws EXN {
    vis.visit((Bind)this, arg);
}
public <ARG, RET,  EXN extends Exception> RET accept(ModuleFileMemberVisitor<ARG,RET,  EXN> vis, ARG arg) throws EXN {
   return vis.visit((Bind)this, arg);
}
public <ARG,  EXN extends Exception> void accept(ModuleFileMemberWalker<ARG, EXN> vis, ARG arg) throws EXN {
    vis.visit((Bind)this, arg);
}
public String details(){
return "Bind("
    + "pat=" + Syntax.detailsome(this.pat)
    + " "
    + "exp=" + Syntax.detailsome(this.exp)
    +")";
}
public static String detstr(
Object pat, Object exp
) {
return "Bind(" + 
"pat=" + pat+" "+"exp=" + exp
+ ")";}
public String toString() {return  pat + 
     (exp == null ? "" : " = " + exp) ;}


 
          public Object getChild(int field, int index) { 
             Object ret = null;
             switch(field) {
          
                     case 0: ret = this.pat; 
            {if (ret == null) 
                fisher.util.Doom.internalCatastrophe("Non-nullable field (pat) was null", this, field, index);}                
            ; break;
                     case 1: ret = this.exp; ; break;

           default: fisher.util.Doom.internalCatastrophe("bad field number in getChild", this, field, index);
           }
           return ret;
        }
        

            public List<SynPtr> synPtrs() {
               List<SynPtr> ptrs = new ArrayList<SynPtr>();
            
              // 0 : pat
              if (pat != null) ptrs.add(new SynPtr(this, 0, -1)); 
              // 1 : exp
              if (exp != null) ptrs.add(new SynPtr(this, 1, -1)); 
              return ptrs;
              }

        public void internalReplace(int field, int index, Object newval) {
	   switch (field) {
        
		 case 0: this.pat = (Pat) newval; break;
		 case 1: this.exp = (Cmd) newval; break;

        default:
         fisher.util.Doom.internalCatastrophe("bad field number in internalReplace", this, field, index, newval);
		}
	}
        


          public String genericName(){return "Bind";}
        
public Syntax internalDeepCopy(Token start, Token end)  {
Syntax copy = new Bind(start, end, 
(pat == null ? null : (Pat)pat.internalDeepCopy(start,end)), 
(exp == null ? null : (Cmd)exp.internalDeepCopy(start,end)));

return copy;
}

public boolean explike(){return true;}

        public boolean reallyAnAssignmentToAPatVariable = false;
        public boolean reallyAnInitializingAssignmentToAValField = false;
     
}