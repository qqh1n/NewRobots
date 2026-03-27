package gui;

import java.awt.*;

public interface RecoverableWindow {

    public String getID();

    public WindowState getState();

    public void setState(WindowState ws);

    public void setDefaultWindowState(WindowState ws);

    public WindowState getDefaultWindowState();
}
