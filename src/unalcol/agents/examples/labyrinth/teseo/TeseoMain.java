package unalcol.agents.examples.labyrinth.teseo;
import unalcol.agents.Agent;

import unalcol.agents.examples.labyrinth.*;
import unalcol.agents.labyrinth.cai.TeseoCai;
import unalcol.agents.labyrinth.cai.TesoCai;
import unalcol.agents.simulate.util.*;

public class TeseoMain {
  private static SimpleLanguage getLanguage(){
    return new SimpleLanguage( new String[]{"front", "right", "back", "left", "exit",
        "afront", "aright", "aback", "aleft"},
                                   new String[]{"no_op", "die", "advance", "rotate"}
                                   );
  }

  public static void main( String[] argv ){
    LabyrinthDrawer.DRAW_AREA_SIZE = 600;
    LabyrinthDrawer.CELL_SIZE = 40;
    Labyrinth.DEFAULT_SIZE = 15;
    
//    TeseoCai teseo = new TeseoCai();
//    teseo.setLanguage(getLanguage());
    
    TesoCai teso = new TesoCai();
    teso.setLanguage(getLanguage());
    
//    Agent agent = new Agent( teseo );
    Agent agent = new Agent( teso );
    TeseoMainFrame frame = new TeseoMainFrame( agent, getLanguage() );
    frame.setVisible(true);  
  }
}
