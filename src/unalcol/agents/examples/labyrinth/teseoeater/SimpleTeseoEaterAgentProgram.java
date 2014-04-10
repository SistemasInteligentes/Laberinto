package unalcol.agents.examples.labyrinth.teseoeater;

import unalcol.agents.examples.labyrinth.teseo.simple.*;
import unalcol.agents.AgentProgram;
import unalcol.agents.Percept;
import unalcol.agents.simulate.util.SimpleLanguage;
import unalcol.types.collection.vector.*;
import unalcol.agents.Action;

/**
 * <p>Title: </p>
 *
 * <p>Description: </p>
 *
 * <p>Copyright: Copyright (c) 2007</p>
 *
 * <p>Company: Universidad Nacional de Colombia</p>
 *
 * @author Jonatan Gómez
 * @version 1.0
 */
public abstract class SimpleTeseoEaterAgentProgram  implements AgentProgram{
  protected SimpleLanguage language;
  protected Vector<String> cmd = new Vector<String>();
  public SimpleTeseoEaterAgentProgram() {
  }

  public void setLanguage(  SimpleLanguage _language ){
    language = _language;
  }

  public void init(){
    cmd.clear();
  }

 public abstract int accion( boolean PF, boolean PD, boolean PA, boolean PI, boolean T,  boolean R, String RC, String RSh, String RSz, String RW, String RT, String E);


  public Action compute(Percept p){
    if( cmd.size() == 0 ){

      boolean PF = ( (Boolean) p.getAttribute(language.getPercept(0))).booleanValue();
      boolean PD = ( (Boolean) p.getAttribute(language.getPercept(1))).booleanValue();
      boolean PA = ( (Boolean) p.getAttribute(language.getPercept(2))).booleanValue();
      boolean PI = ( (Boolean) p.getAttribute(language.getPercept(3))).booleanValue();
      boolean T = ( (Boolean) p.getAttribute(language.getPercept(4))).booleanValue();
      boolean R = ((Boolean)p.getAttribute(language.getPercept(5))).booleanValue();
      //atributos de la comida
      String RC = ((String)(p.getAttribute(language.getPercept(6)).toString()));
      String RSh = ((String)(p.getAttribute(language.getPercept(7)).toString()));
      String RSz = ((String)(p.getAttribute(language.getPercept(8)).toString()));
      String RW = ((String)(p.getAttribute(language.getPercept(9)).toString()));
      //atributos de la comida
      //Atributo de percepcion de estado de la comida
      String RT = ((String)(p.getAttribute(language.getPercept(10)).toString()));
      //Atributo de energía
      String E = ((String)(p.getAttribute(language.getPercept(11)).toString()));

      int d = accion(PF, PD, PA, PI, T, R, RC, RSh, RSz, RW, RT, E);
      //int d = accion(PF, PD, PA, PI, T);
      if (d==5){
          cmd.add(language.getAction(4));
      }
      if (0 <= d && d < 4) {
        for (int i = 1; i <= d; i++) {
          cmd.add(language.getAction(3)); 
        }
        cmd.add(language.getAction(2)); 
      }
      else {
        cmd.add(language.getAction(0));
      }
    }
    String x = cmd.get(0);
    cmd.remove(0);
    return new Action(x);
  }

  public boolean goalAchieved( Percept p ){
    return (((Boolean)p.getAttribute(language.getPercept(4))).booleanValue());
  }  
}
