package gui;

import javax.swing.*;
import java.awt.*;

public class BotCoordinatesVisualizer extends JPanel implements GameModelListener {
    private final GameModel gameModel;

    public BotCoordinatesVisualizer(GameModel gameModel) {
        this.gameModel = gameModel;
        setPreferredSize(new Dimension(50, 100));
        repaint();
        setDoubleBuffered(true);
    }

    public void onRedrawEvent()
    {
        EventQueue.invokeLater(this::repaint);
    }

    @Override
    public void paint(Graphics g)
    {
        super.paint(g);
        Graphics2D g2d = (Graphics2D)g;
        drawCoordinates(g2d, gameModel.getRoundedRobotPositionX(),
                gameModel.getRoundedRobotPositionY());
    }

    private void drawCoordinates(Graphics g, int x, int y) {
        g.setColor(Color.MAGENTA);
        g.setFont(new Font("Arial", Font.BOLD, 18));
        g.drawString(String.format("X: %d   Y: %d", x, y), 50, 50);
    }
}
