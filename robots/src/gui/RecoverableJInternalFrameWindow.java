package gui;

import javax.swing.*;
import java.awt.*;
import java.beans.PropertyVetoException;

public class RecoverableJInternalFrameWindow implements RecoverableWindow{

    private final String ID;
    private final JInternalFrame window;
    private WindowState defaultWindowState;

    public RecoverableJInternalFrameWindow(JInternalFrame window, String ID) {
        this.window = window;
        this.ID = ID;
        defaultWindowState = new WindowState(
                new Rectangle(500, 500, 500, 500), true);
    }

    @Override
    public String getID() {
        return ID;
    }

    @Override
    public WindowState getState() {
        return new WindowState(
                window.getBounds(),
                window.isIcon()
        );
    }

    @Override
    public void setState(WindowState ws) {
        window.setBounds(ws.rectangle);
        try {
            window.setIcon(ws.isClosed);
        }
        catch (PropertyVetoException es) {
            //pass
        }
    }

    @Override
    public void setDefaultWindowState(WindowState ws) {
        defaultWindowState = ws;
    }

    @Override
    public WindowState getDefaultWindowState() {
        return defaultWindowState;
    }
}
