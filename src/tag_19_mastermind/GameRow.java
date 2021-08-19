/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tag_19_mastermind;

import java.awt.GridLayout;
import javax.swing.JPanel;

/**
 *
 * @author jbradley
 */
public class GameRow extends JPanel {

        RowSlot[] rowSlot;
        ClueBoard clueBoard;

        public GameRow() {

        setLayout(new GridLayout(1, 5, 2, 2));
        rowSlot = new RowSlot[4];
        
        for (int column = 0; column < 4; column++) {
            rowSlot[column] = new RowSlot();
            add(rowSlot[column]);
        }
        
        clueBoard = new ClueBoard();
        add(clueBoard);
    }
    
    
}
