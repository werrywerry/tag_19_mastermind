package tag_19_mastermind;

import java.awt.Color;
import javax.swing.JPanel;

/**
 *
 * @author jbradley
 */
public class RowSlot extends JPanel {

    int column;
    
    public RowSlot() {
//    public RowSlot(int column) {

        this.column = column;
        setBackground(Color.DARK_GRAY);

    }

}
