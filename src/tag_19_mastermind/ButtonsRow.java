
package tag_19_mastermind;

import java.awt.GridLayout;
import javax.swing.JPanel;

/**
 *
 * @author jbradley
 */
public class ButtonsRow extends JPanel {


    GameControl gamcon;

    
    public ButtonsRow(GameControl gamcon) {

        this.gamcon = gamcon;
        setLayout(new GridLayout(1, 4));
        ClueButton button;

        for (int column = 0; column < 4; column++) {
            button = new ClueButton(column);
            button.addActionListener(gamcon);
            add(button);
        }

    }


    
}
