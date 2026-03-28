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

        m_gameModel.addListener(m_gameView);

        JPanel panel = new JPanel(new BorderLayout());
        panel.add(m_gameView, BorderLayout.CENTER);
        getContentPane().add(panel);
        pack();
    }
}
