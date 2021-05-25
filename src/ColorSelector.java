import javax.swing.*;
import java.awt.*;

/**
 * classe de selection des couleurs
 *
 * @author arnoux23u
 */
public class ColorSelector extends JPanel {

    /**
     * couleur actuelle
     */
    private Color color;

    /**
     * reference parente
     */
    private final Scribbl parent;

    /**
     * mode aleatoire
     */
    private boolean random;

    /**
     * epaisseur actuelle
     */
    private int thick;

    /**
     * Constructeur par defaut
     *
     * @param c reference parente
     */
    public ColorSelector(Scribbl c) {

        this.parent = c;

        color = Color.black;
        this.random = false;

        //Button effacer
        JButton effacer = new JButton("Effacer");
        effacer.addActionListener(e -> parent.effacerDessin());

        //Box
        JColorChooser jc = new JColorChooser(Color.black);

        //Bouton couleur
        JButton color = new JButton();
        color.setPreferredSize(new Dimension(40, 40));
        color.setBackground(Color.black);
        color.addActionListener(e -> {
            this.color = JColorChooser.showDialog(jc, "Choix couleur", this.color);
            color.setBackground(this.color);
        });

        JCheckBox random = new JCheckBox("Random");
        random.addActionListener(e -> this.random = random.isSelected());

        JSlider thickSelect = new JSlider(JSlider.HORIZONTAL, 1, 50, 5);
        thick = thickSelect.getValue();
        thickSelect.addChangeListener(ch -> thick = thickSelect.getValue());

        this.setBorder(BorderFactory.createLineBorder(Color.black, 4, true));
        this.add(effacer);
        this.add(color);
        this.add(random);
        this.add(thickSelect);
    }

    /**
     * Methode getColor
     *
     * @return color ou null
     */
    public Color getColor() {
        return random ? null : color;
    }

    /**
     * Methode getEpaisseur
     *
     * @return epaisseur
     */
    public int getThick() {
        return thick;
    }
}
