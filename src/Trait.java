import java.awt.*;

/**
 * Classe trait
 *
 * @author arnoux23u
 */
public class Trait {

    /**
     * Point debut
     */
    private final Point init;

    /**
     * Point fin
     */
    private final Point end;

    /**
     * Couleur
     */
    private final Color color;

    /**
     * Taille
     */
    private final int size;

    /**
     * Constructeur par defaut
     *
     * @param one    point debut
     * @param second point fin
     * @param c      couleur
     * @param s      taille
     */
    public Trait(Point one, Point second, Color c, int s) {
        init = one;
        end = second;
        color = c;
        size = s;
    }

    /**
     * Methode getInit
     *
     * @return point de depart
     */
    public Point getInit() {
        return init;
    }

    /**
     * Methode getEnd
     *
     * @return point d'arrivee
     */
    public Point getEnd() {
        return end;
    }

    /**
     * Methode getColor
     *
     * @return couleur du trait
     */
    public Color getColor() {
        return color;
    }

    /**
     * Methode getSize
     *
     * @return epaisseur du trait
     */
    public int getSize() {
        return size;
    }

}