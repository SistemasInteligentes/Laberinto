package unalcol.agents.examples.sudoku.naive;
import unalcol.agents.*;
import unalcol.agents.examples.sudoku.*;
import unalcol.agents.search.classic.*;
import unalcol.agents.search.util.*;
import unalcol.types.collection.vector.*;

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
public class NaiveSudokuAgentProgram implements AgentProgram{
  Vector<Action> cmd = new Vector<Action>();
  public NaiveSudokuAgentProgram() {
  }

  public void init(){
    cmd.clear();
  }

  public Action compute( Percept percept ){
    if( cmd.size() == 0 ){
      NaiveSudokuBoardState initial_state = new NaiveSudokuBoardState((SudokuPercept)percept);
      int depth = initial_state.board.emptyPlaces();
      DepthFirstSearch search = new DepthFirstSearch(depth);
      cmd = search.apply( initial_state, new NaiveSudokuSearchSpace(),
                          new NaiveSudokuGoalTest(), new ConstantCost() );
      if( cmd == null ){ cmd = new Vector<Action>(); }
    }
    if( cmd.size() > 0 ){
      Action action = cmd.get(0);
      cmd.remove(0);
      return action;
    }
    return null;
  }

   

    @Override
    public int accion(boolean PF, boolean PD, boolean PA, boolean PI, boolean AF, boolean AD, boolean AA, boolean AI, boolean MT) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
