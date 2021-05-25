import javax.swing.*;
import java.awt.*;

/**
 * Classe generale
 */
public class Scribbl extends JPanel {

    /**
     * Objet dessin
     */
    Dessin ds;

    /**
     * Objet selecteur
     */
    ColorSelector cs;

    /**
     * Constructeur par defaut
     */
    public Scribbl() {
        cs = new ColorSelector(this);
        cs.setPreferredSize(new Dimension(700, 100));
        ds = new Dessin(this);
        ds.setPreferredSize(new Dimension(700, 700));
        this.setLayout(new BorderLayout());

        this.add(cs, BorderLayout.NORTH);
        this.add(ds, BorderLayout.SOUTH);
    }

    /**
     * Methode surchargee paint
     * @param g graphics
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int h = getHeight();
        int tranche = h / 9;
        int w = getWidth();
        cs.setPreferredSize(new Dimension(w, tranche));
        ds.setPreferredSize(new Dimension(w, tranche * 8));
        cs.repaint();
        ds.repaint();
    }

    /**
     * Methode effacerdessin
     */
    public void effacerDessin() {
        ds.effacer();
    }

    /**
     * Methode getColor
     * @return color du dessin actuelle
     */
    public Color getColor() {
        return cs.getColor();
    }

    /**
     * Methode getEpaisseur
     * @return epaisseur du dessin
     */
    public int getThick() {
        return cs.getThick();
    }
}
