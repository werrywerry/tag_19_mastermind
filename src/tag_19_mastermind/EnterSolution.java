package tag_19_mastermind;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author jbradley
 */
public class EnterSolution implements ActionListener {

    GameBoard gameBoard;
    GameRow gRow;
    
    public EnterSolution(GameBoard gameBoard) {
        this.gameBoard = gameBoard;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
//        gRow = gameBoard.gameRow[gameBoard.currentLevel];
//        for (int i = 0; i < 4; i++) {
//            System.out.println(SolutionRow.solutionSlot[i].getBackground());
//            gRow.rowSlot[i].setBackground(SolutionRow.solutionSlot[i].getBackground());
//        }
//            //GameRow.ConstructSolvedGameRow(SolutionRow.solutionSlot);
//        gameBoard.currentLevel--;
        this.gameBoard.UpdateGameRows();
    }


}
