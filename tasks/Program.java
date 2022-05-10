package tasks;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Path2D;

public class Program {

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Снеговик");
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setBounds(dim.width / 2 - 200, dim.height / 2 - 350, 500, 700);
        Canvas m = new SnowMan();
        frame.add(m);
        frame.setVisible(true);

        JFrame frame1 = new JFrame();
        frame1.setTitle("Светофор");
        frame1.setBounds(dim.width / 2 - 150, dim.height / 2 - 215, 300, 430);
        Canvas m1 = new TrafficLight();
        frame1.add(m1);
        frame1.setVisible(true);

        JFrame frame2 = new JFrame();
        frame1.setTitle("Автомобиль");
        frame2.setBounds(dim.width / 2 - 600, dim.height / 2 - 350, 1200, 700);
        Canvas m2 = new Car();
        frame2.add(m2);
        frame2.setVisible(true);

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


class SnowMan extends Canvas {
    public void paint(Graphics g) {
        Graphics2D g2 = (Graphics2D) g; //преобразуем Graphics в Graphics2D (для сглаживания)
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON); //сглаживание
        g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC));
        g2.setStroke(new BasicStroke(3));
        drawArm(new int[]{480 - 50, 480 - 150, 480 - 155, 480 - 55, 480 - 45, 480 - 40, 480 - 43, 480 - 25, 480 - 23, 480 - 40, 480 - 30, 480 - 35}, new int[]{290, 330, 315, 280, 260, 263, 275, 270, 277, 285, 300, 305}, Color.WHITE, Color.black, g2);
        drawOvalWithBorder(100, 400, 280, 230, Color.WHITE, Color.black, g2);//низ
        drawOvalWithBorder(130, 250, 220, 200, Color.WHITE, Color.black, g2);//середина
        drawOvalWithBorder(160, 140, 160, 140, Color.WHITE, Color.black, g2);//голова
        drawOvalWithBorder(150, 140, 180, 20, Color.WHITE, Color.black, g2);//низ шляпы
        g2.setColor(Color.white);
        g2.fillRoundRect(190, 70, 100, 75, 20, 15);//заливка шляпы
        g2.setColor(Color.black);
        g2.drawRoundRect(190, 70, 100, 75, 20, 15);//контур шляпы
        g2.drawLine(190, 130, 290, 130);
        drawArm(new int[]{50, 150, 155, 55, 45, 40, 43, 25, 23, 40, 30, 35}, new int[]{290, 330, 315, 280, 260, 263, 275, 270, 277, 285, 300, 305}, Color.WHITE, Color.black, g2);//рука левая
        g2.setStroke(new BasicStroke(2));//ширина бордюров
        for (int i = 0; i < 90; i = i + 30)
            drawOvalWithBorder(260, 320 + i, 10, 10, Color.red, Color.black, g2);//пуговицы
        for (int i = 0; i < 80; i = i + 40) {
            drawOvalWithBorder(230 + i, 180, 20, 15, Color.CYAN, Color.black, g2);//глаз
            drawOvalWithoutBorder(240 + i, 182, 10, 10, Color.black, g2);//зрачок
        }
        drawOvalWithoutBorder(230, 230, 60, 30, Color.BLACK, g2);//рот
        drawOvalWithoutBorder(220, 228, 80, 20, Color.WHITE, g2);//перекрытие рта
        g2.setColor(Color.ORANGE);
        g2.fillPolygon(new int[]{260, 350, 255}, new int[]{230, 220, 215}, 3);//заливка носа
        g2.setColor(Color.black);
        g2.drawPolyline(new int[]{260, 350, 255}, new int[]{230, 220, 215}, 3);//контур носа

    }

    public void drawOvalWithBorder(int x, int y, int width, int height, Color colorOval, Color colorBorder, Graphics2D g2) {//метод для рисования залитого овала и его бордюра разными цветами
        g2.setColor(colorOval);
        g2.fillOval(x, y, width, height);
        g2.setColor(colorBorder);
        g2.drawOval(x, y, width, height);
    }

    public void drawArm(int[] i, int[] y, Color colorOval, Color colorBorder, Graphics2D g2) {//метод для рисования рук
        g2.setColor(colorOval);
        g2.fillPolygon(i, y, i.length);
        g2.setColor(colorBorder);
        g2.drawPolygon(i, y, i.length);
    }

    public void drawOvalWithoutBorder(int x, int y, int width, int height, Color colorOval, Graphics2D g2) {//метод для рисования залитого овала без бордера
        g2.setColor(colorOval);
        g2.fillOval(x, y, width, height);
    }

    public void drawOvalBorder(int x, int y, int width, int height, Color colorOval, Graphics2D g2) {//метод для рисования залитого овала без бордера
        g2.setColor(colorOval);
        g2.drawOval(x, y, width, height);
    }
}

class Car extends Canvas {
    public void paint(Graphics g) {
        Graphics2D g2 = (Graphics2D) g; //преобразуем Graphics в Graphics2D (для сглаживания)
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON); //сглаживание
        g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC));//выставляем способ наложения фигур
        //рисуем колеса
        drawWheel(200, 450, 150, 50, new Color(112, 148, 144), Color.black, g2);//колесо 1
        drawWheel(750, 450, 150, 50, new Color(112, 148, 144), Color.black, g2);//колесо 2
        //рисуем кузов
        Path2D.Double path = new Path2D.Double();
        double x = 165, y = 525;//стартовая точка кузова машины - первая колесная арка, идем против часовой
        path.moveTo(x, y);//задаем стартовую точку
        path.curveTo(x, y - 150, x + 220, y - 150, x + 220, y);//арка первого колеса
        path.lineTo(x += 550, y);//днище
        path.curveTo(x, y - 150, x += 220, y - 150, x, y);//арка второго колеса
        path.lineTo(x += 120, y);//низ передка
        path.quadTo(x + 100, y - 15, x + 60, y - 70);//передний бампер
        path.quadTo(x + 100, y - 200, x -= 180, y -= 250);//капот
        double xGlass = x, yGlass = y;//запоминаем эти координаты для рисования стекол в дальнейшем
        path.quadTo(x - 400, y - 330, x -= 700, y -= 30);//крыша
        path.quadTo(x - 100, y + 20, x -= 100, y += 190);//багажник
        path.quadTo(x - 50, y + 20, x + 15, 525);//задний бампер, финиш
        path.closePath(); //соединяем линии
        g2.setColor(Color.cyan);
        g2.fill(path);//рисуем созданный кузов
        g2.setColor(Color.BLACK);
        g2.setStroke(new BasicStroke(6));//ширина бордюров
        g2.draw(path);//рисуем окантовку кузова
        path.reset();//очищаем путь
        //рисуем переднее стекло
        path.moveTo(xGlass - 50, yGlass);//начальная точка стекла
        path.quadTo(xGlass - 220, yGlass - 140, xGlass - 370, yGlass - 145);//первая линия
        path.lineTo(xGlass -= 370, yGlass);//вторая линия
        path.closePath();//соединяем
        g2.setColor(new Color(255, 228, 196));
        g2.fill(path);//рисуем стекло
        g2.setColor(Color.black);
        g2.draw(path);//рисуем окантовку стекла
        path.reset();//очищаем путь
        //рисуем заднее стекло
        path.moveTo(xGlass - 30, yGlass - 145);//начальная точка стекла
        path.quadTo(xGlass - 180, yGlass - 140, xGlass - 280, yGlass - 40);//первая линия
        path.lineTo(xGlass - 280 + 60, yGlass);//вторая линия
        path.lineTo(xGlass - 30, yGlass);//третья линия
        path.closePath();//соединяем
        g2.setColor(new Color(255, 228, 196));
        g2.fill(path);//рисуем стекло
        g2.setColor(Color.black);
        g2.draw(path);//рисуем окантовку стекла
        path.reset();//очищаем путь
        //рисуем ручки
        g2.setStroke(new BasicStroke(6));//ширина бордюров
        g2.drawLine(520, 320, 550, 320);//ручка передней двери
        g2.drawLine(240, 320, 270, 320);//ручка задней двери
        //рисуем переднюю фару
        path.moveTo(1116, 400);
        path.quadTo(1130, 350, 1080, 350);
        path.quadTo(1100, 420, 1116, 400);
        g2.setColor(Color.yellow);
        g2.fill(path);//рисуем фару
        g2.setColor(Color.black);
        g2.draw(path);//рисуем окантовку фары
        path.reset();//очищаем путь
        //рисуем заднюю фару
        path.moveTo(114, 280);
        path.quadTo(80, 280, 80, 362);
        path.quadTo(120, 290, 114, 280);
        // path.quadTo(1100,420, 50,400);
        g2.setColor(Color.red);
        g2.fill(path);//рисуем фару
        g2.setColor(Color.black);
        g2.draw(path);//рисуем окантовку фары
        path.reset();//очищаем путь
    }

    public void drawWheel(int x, int y, int diameter, int border, Color colorOval, Color colorBorder, Graphics2D g2) {//метод для рисования колеса
        g2.setColor(colorOval);//цвет диска
        g2.fillOval(x, y, diameter, diameter);//диск
        g2.setColor(colorBorder);//цвет шины
        g2.setStroke(new BasicStroke(border));//ширина шины
        g2.fillOval(x + diameter / 2 - diameter / 10 / 2, y + diameter / 2 - diameter / 10 / 2, diameter / 10, diameter / 10);//ось колеса
        g2.drawOval(x, y, diameter, diameter);//шина
    }

}