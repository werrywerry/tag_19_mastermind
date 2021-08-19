
package tag_19_mastermind;

import java.awt.GridLayout;
import javax.swing.JPanel;

/**
 *
 * @author jbradley
 */
class ClueBoard extends JPanel{

    ClueSlot[] clueSlot = new ClueSlot[4];

    public ClueBoard() {

        setLayout(new GridLayout(2, 2, 2, 2));
        
        for (int i = 0; i < 4; i++) {
            clueSlot[i] = new ClueSlot();
            add(clueSlot[i]);
        }
        
    }
    
    
    
}
