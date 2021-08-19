package tag_19_mastermind;

import java.awt.HeadlessException;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

/**
 *
 * @author jbradley
 */
class Fenster extends JFrame {

    public Fenster() throws HeadlessException {

        super("Mastermind");
        setSize(600, 800);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        // adds game field
        GameBoard gameBoard = new GameBoard();
        add(gameBoard);
        gameBoard.setFocusable(true);

        MenuBar menuBar = new MenuBar();
        Menu menu;
        MenuItem menueEintrag;

        //settings menu
        menu = new Menu("File");

        menueEintrag = new MenuItem("New Game");
        menu.add(menueEintrag);
        menueEintrag.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                GameBoard.newGame();
            }
        });

        menuBar.add(menu);
        setMenuBar(menuBar);
        setVisible(true);

    }

}
