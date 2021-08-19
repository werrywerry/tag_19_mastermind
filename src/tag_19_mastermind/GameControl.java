
package tag_19_mastermind;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author jbradley
 */
class GameControl implements ActionListener{

    GameBoard gameBoard;

    public GameControl(GameBoard gameBoard) {
        this.gameBoard = gameBoard;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {

        ClueButton justPressed;
        justPressed = (ClueButton) e.getSource();
        System.out.println(justPressed.column);
        gameBoard.solutionRow.turnTaken(justPressed.column);

        
    }
    
}
