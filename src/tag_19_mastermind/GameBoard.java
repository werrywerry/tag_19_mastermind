package tag_19_mastermind;

import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author jbradley
 */
class GameBoard extends JPanel {

    EnterSolution enterSolution;
    SolutionRow solutionRow;
    GameControl gamcon;
    static int rows = 12;
    static int currentLevel = 11;
    //GameRow lastSolvedRow;
    static GameRow gameRow[] = new GameRow[rows];
    int correctColor = 0;
    static int correctPlace = 0;
    static int previousPlace = 0;
    static int previousColor = 0;
    ClueBoard clueBoard[] = new ClueBoard[4];
    static GameRow masterRow;
    static int gameLevel = 1;
    static GenerateMasterColors gmc;
    static JButton applySolution;
    int clue;

    public GameBoard() {

        setLayout(new GridLayout(16, 1, 2, 2));
        ButtonsRow buttonsRow;
//        JButton applySolution;

        gamcon = new GameControl(this);

        for (int row = 0; row < rows; row++) {
            gameRow[row] = new GameRow();
            add(gameRow[row]);
        }

        buttonsRow = new ButtonsRow(gamcon);
        add(buttonsRow);

        solutionRow = new SolutionRow();

        add(solutionRow);
        System.out.println(solutionRow);

        gmc = new GenerateMasterColors();

        enterSolution = new EnterSolution(this);
        applySolution = new JButton("Enter");
        applySolution.addActionListener(enterSolution);
        add(applySolution);

        masterRow = new GameRow();
        add(masterRow);

    }

    void UpdateGameRows() {

        // Displays the masterRow if not solved by last level
        if (currentLevel == 0) {
            for (int i = 0; i < 4; i++) {
                System.out.println(SolutionRow.solutionSlot[i].getBackground());
                gameRow[0].rowSlot[i].setBackground(SolutionRow.solutionSlot[i].getBackground());
            }
            for (int i = 0; i < 4; i++) {
                masterRow.rowSlot[i].setBackground(GenerateMasterColors.masterColors.get(i));
            }
            for (clue = 0; clue < previousPlace; clue++) {
                masterRow.clueBoard.clueSlot[clue].setBackground(Color.RED);

            }

            int clueCounter = clue;
            for (clue = 0; clue < previousColor; clue++) {
                masterRow.clueBoard.clueSlot[clueCounter].setBackground(Color.WHITE);
                clueCounter++;
            }
            disableButton();

        }

//        ArrayList<Color> solutionColors = new ArrayList<>();
        boolean[] singleCheck = new boolean[4];
        ArrayList<Color> alreadyChecked = new ArrayList<>();

        // paints solution row on currentLevel
        for (int i = 0; i < 4; i++) {
            System.out.println(SolutionRow.solutionSlot[i].getBackground());
            gameRow[currentLevel].rowSlot[i].setBackground(SolutionRow.solutionSlot[i].getBackground());
//            solutionColors.add(SolutionRow.solutionSlot[i].getBackground());
        }

        // checks masterColors<> for occurances of color solutionRow[i]
        // but only one time per each solutionSlot
        // increments correctColor per hit
        for (int i = 0; i < 4; i++) {
            if (GenerateMasterColors.masterColors.contains(SolutionRow.solutionSlot[i].getBackground())
                    && alreadyChecked.contains(SolutionRow.solutionSlot[i].getBackground()) == false) {
                correctColor++;
                alreadyChecked.add(SolutionRow.solutionSlot[i].getBackground());
            }
        }

        // checks for exact position of colors and increments correctPlace per hit
        for (int i = 0; i < 4; i++) {
            if (SolutionRow.solutionSlot[i].getBackground() == GenerateMasterColors.masterColors.get(i)) {
                correctPlace++;
            }
        }

        // removes all hits from correctColor that are already counted in correctPlace
        correctColor = correctColor - correctPlace;

        // paints clueBoard with a red square per correctPlace hit
        for (clue = 0; clue < correctPlace; clue++) {
            gameRow[currentLevel].clueBoard.clueSlot[clue].setBackground(Color.RED);

        }

        // paints clueBoard a white square per remaining correctColor hit
        // clueCounter ensures red squares are not repainted white
        int clueCounter = clue;
        for (clue = 0; clue < correctColor; clue++) {
            gameRow[currentLevel].clueBoard.clueSlot[clueCounter].setBackground(Color.WHITE);
            clueCounter++;
        }

        // winner winner chicken dinner
        // prints master colors on bottom row
        if (correctPlace == 4) {
            System.out.println("We have a winner on level " + gameLevel);
            for (int i = 0; i < 4; i++) {
                masterRow.rowSlot[i].setBackground(GenerateMasterColors.masterColors.get(i));
                masterRow.clueBoard.clueSlot[i].setBackground(Color.RED);
            }
            disableButton();
        }

        System.out.println(correctColor + " colours correct, but not necessarily in the right spot");
        System.out.println(correctPlace + " colours in the right spot");
        currentLevel--;
        gameLevel++;
        previousPlace = correctPlace;
        previousColor = correctColor;
        correctColor = 0;
        correctPlace = 0;

    }

    static void newGame() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < 4; j++) {
                gameRow[i].rowSlot[j].setBackground(Color.DARK_GRAY);
                gameRow[i].clueBoard.clueSlot[j].setBackground(Color.DARK_GRAY);
            }
        }
        for (int i = 0; i < 4; i++) {
            SolutionRow.solutionSlot[i].setBackground(Color.DARK_GRAY);
            masterRow.rowSlot[i].setBackground(Color.DARK_GRAY);
            masterRow.clueBoard.clueSlot[i].setBackground(Color.DARK_GRAY);
        }
        currentLevel = 11;
        gameLevel = 1;
        SolutionRow.colorCounter = 0;
        gmc.NewColors();
        enableButton();
    }

    void disableButton() {
        JButton thisButton = applySolution;
        thisButton.setEnabled(false);
    }

    static void enableButton() {
        JButton thisButton = applySolution;
        thisButton.setEnabled(true);
    }



}
