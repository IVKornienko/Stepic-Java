package tasks;

import javax.swing.*;
import java.awt.*;

public class Program extends Canvas {

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setTitle("Светофор");
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setBounds(dim.width / 2 - 150, dim.height / 2 - 215, 300, 430);
        TrafficLight m = new TrafficLight();
        frame.add(m);
        frame.setVisible(true);
    }

}

class TrafficLight extends Canvas {
    public void paint(Graphics g) {
        Graphics2D g2 = (Graphics2D) g; //преобразуем Graphics в Graphics2D (для сглаживания)
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON); //сглаживание
        g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

        //устанавливаем цвет и рисуем фигуру такого цвета
        g.setColor(Color.DARK_GRAY);
        g.fillRoundRect(100, 50, 100, 280, 50, 50);

        g.setColor(Color.red);
        g.fillOval(120, 70, 60, 60);
        g.setColor(Color.yellow);
        g.fillOval(120, 160, 60, 60);
        g.setColor(Color.green);
        g.fillOval(120, 250, 60, 60);

        g.setColor(Color.DARK_GRAY);
        g.fillRect(130, 335, 40, 50);

        g.fillPolygon(new int[]{50, 95, 95}, new int[]{80, 80, 120}, 3);
        g.fillPolygon(new int[]{50, 95, 95}, new int[]{170, 170, 210}, 3);
        g.fillPolygon(new int[]{50, 95, 95}, new int[]{260, 260, 300}, 3);

        g.fillPolygon(new int[]{205, 250, 205}, new int[]{80, 80, 120}, 3);
        g.fillPolygon(new int[]{205, 250, 205}, new int[]{170, 170, 210}, 3);
        g.fillPolygon(new int[]{205, 250, 205}, new int[]{260, 260, 300}, 3);

        g.fillArc(120, 25, 60, 40, 0, 180);
    }
}
