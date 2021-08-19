
package tag_19_mastermind;

import java.awt.GridLayout;
import javax.swing.JPanel;

/**
 *
 * @author jbradley
 */
public class SolvedGameRow extends JPanel{

    public SolvedGameRow() {

            setLayout(new GridLayout(1, 5, 2, 2));
        RowSlot rowSlot;
        ClueBoard clueBoard;
        
        for (int column = 0; column < 4; column++) {
            rowSlot = new RowSlot();
//            rowSlot = new RowSlot(column);
            rowSlot.setBackground(SolutionRow.solutionSlot[column].getBackground());
            add(rowSlot);
        }
        
        clueBoard = new ClueBoard();
        add(clueBoard);

        
    }
    
    
    
}
