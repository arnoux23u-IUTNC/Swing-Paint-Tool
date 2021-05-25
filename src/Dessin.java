import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

/**
 * Classe dessin
 *
 * @author arnoux23u
 */
public class Dessin extends JPanel {

    /**
     * reference parente
     */
    private final Scribbl parent;

    /**
     * dernier point
     */
    private Point lastPoint;

    /**
     * liste de traits
     */
    private final ArrayList<Trait> list;

    /**
     * valeur de couleur Rouge
     */
    public static int colorR;

    /**
     * valeur de couleur Verte
     */
    public static int colorG;

    /**
     * valeur de couleur Bleue
     */
    public static int colorB;

    /**
     * Variation rouge
     */
    static int newR = 0;

    /**
     * Variation verte
     */
    static int newG = 0;

    /**
     * Variation bleue
     */
    static int newB = 0;

    /**
     * Constructeur par defaut
     *
     * @param scribbl reference parente
     */
    public Dessin(Scribbl scribbl) {
        list = new ArrayList<Trait>();

        colorR = 255;
        colorG = 0;
        colorB = 0;

        this.parent = scribbl;
        this.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {
                lastPoint = e.getPoint();
            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

        this.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                Point newPoint = e.getPoint();
                Color c = parent.getColor();
                Trait t = new Trait(lastPoint, newPoint, (c != null ? c : betterNiceColor()), parent.getThick());
                lastPoint = newPoint;
                list.add(t);
                repaint();
            }
        });
    }

    /**
     * Methode surchargee paint
     *
     * @param g graphics
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Trait trait : list) {
            g.setColor(trait.getColor());
            Graphics2D g2d = (Graphics2D) g;
            int size = trait.getSize();
            g2d.setStroke(new BasicStroke(size, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
            g2d.drawLine(trait.getInit().x, trait.getInit().y, trait.getEnd().x, trait.getEnd().y);
        }
    }

    /**
     * Methode effacer
     */
    public void effacer() {
        this.getGraphics().clearRect(0, 0, getWidth(), getHeight());
        list.clear();
        repaint();
    }

    /**
     * Methode de creation de couleur aleatoire dirigee
     *
     * @return Color generee
     */
    public static Color betterNiceColor() {

        if (colorR == 255 && colorB == colorG) {
            newR = 0;
            newG = 5;
            newB = 0;
        }
        if (colorR == 255 && colorG == 255) {
            newR = -5;
            newG = 0;
            newB = 0;
        }
        if (colorG == 255 && colorB == colorR) {
            newR = 0;
            newG = 0;
            newB = 5;
        }
        if (colorB == 255 && colorG == 255) {
            newR = 0;
            newG = -5;
            newB = 0;
        }
        if (colorB == 255 && colorG == colorR) {
            newR = 5;
            newG = 0;
            newB = 0;
        }
        if (colorB == 255 && 255 == colorR) {
            newR = 0;
            newG = 0;
            newB = -5;
        }
        colorR += newR;
        colorG += newG;
        colorB += newB;
        return new Color(colorR, colorG, colorB);
    }

}
