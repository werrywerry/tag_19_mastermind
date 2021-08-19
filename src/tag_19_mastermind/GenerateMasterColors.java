package tag_19_mastermind;

import java.awt.Color;
import java.util.ArrayList;

/**
 *
 * @author jbradley
 */
public class GenerateMasterColors {

//    Color[] masterColors = new Color[4];
    static ArrayList<Color> masterColors = new ArrayList<>();
    Color insertColor;

    public GenerateMasterColors() {

        System.out.println(Math.round(Math.random() * 6) - 1);

        for (int i = 0; i < 4; i++) {
            insertColor = Colors.colors[((int) Math.floor(Math.random() * 6))];
            masterColors.add(insertColor);
        }

        for (int i = 0; i < 4; i++) {
            System.out.println(masterColors.get(i));
        }

    }

    void NewColors() {
        masterColors = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            insertColor = Colors.colors[((int) Math.floor(Math.random() * 6))];
            masterColors.add(insertColor);
        }

    }

}
