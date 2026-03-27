package gui;

import java.awt.*;

public class WindowState {
    public Rectangle rectangle;
    public boolean isClosed;

    public WindowState(Rectangle rectangle, boolean isClosed) {
        this.rectangle = rectangle;
        this.isClosed = isClosed;
    }
}
