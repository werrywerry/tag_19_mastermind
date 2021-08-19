
package tag_19_mastermind;

import java.awt.GridLayout;
import javax.swing.JPanel;

/**
 *
 * @author jbradley
 */
public class SolutionRow extends JPanel {


        static int colorCounter = 0;
        static RowSlot[] solutionSlot = new RowSlot[4];

        public SolutionRow() {

        setLayout(new GridLayout(1, 4, 2, 2));

        for (int column = 0; column < 4; column++) {
            solutionSlot[column] = new RowSlot();
            add(solutionSlot[column]);
        }

    }

    void turnTaken(int column) {

        solutionSlot[column].setBackground(Colors.colors[colorCounter %6]);
        colorCounter++;
        
        
    }

}
