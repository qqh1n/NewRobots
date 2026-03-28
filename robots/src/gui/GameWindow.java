package gui;

import java.awt.BorderLayout;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;

public class GameWindow extends JInternalFrame
{
    public GameWindow() 
    {
        super("Игровое поле", true, true, true, true);

        GameModel m_gameModel = new GameModel();
        GameView m_gameView = new GameView(m_gameModel);
        BotCoordinatesVisualizer m_BCV = new BotCoordinatesVisualizer(m_gameModel);

        m_gameModel.addListener(m_gameView);
        m_gameModel.addListener(m_BCV);

        JPanel panel = new JPanel(new BorderLayout());
        panel.add(m_gameView, BorderLayout.CENTER);
        panel.add(m_BCV, BorderLayout.SOUTH);
        getContentPane().add(panel);
        pack();
    }
}
