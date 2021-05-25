import javax.swing.*;
import java.awt.*;

/**
 * Classe main de lancement
 *
 * @author arnoux23u
 */
public class LancerScribbl {

    public static void main(String[] args) {
        JFrame fenetre = new JFrame("Scribbl");
        fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Scribbl sc = new Scribbl();
        sc.setPreferredSize(new Dimension(700, 800));
        fenetre.setContentPane(sc);
        fenetre.pack();
        fenetre.setVisible(true);
    }


}
