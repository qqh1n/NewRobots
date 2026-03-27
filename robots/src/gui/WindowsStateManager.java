package gui;

import java.awt.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;
import java.util.List;

public class WindowsStateManager {
    private final File CONFIG_FILE = new File("window_state_config.properties");
    private final List<RecoverableWindow> windows = new ArrayList<>();
    private final Set<String> registeredID = new HashSet<>();

    public void register(RecoverableWindow window) {
        String id = window.getID();
        if (id == null || !registeredID.add(id)) {
            throw new IllegalStateException("Invalid or duplicate id:" + id);
        }
        windows.add(window);
    }

    private Properties loadProperties() {
        Properties props = new Properties();
        if (CONFIG_FILE.exists()) {
            try (FileInputStream fis = new FileInputStream(CONFIG_FILE)) {
                props.load(fis);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return props;
    }

    private void saveProperties(Properties props) {
        try (FileOutputStream fos = new FileOutputStream(CONFIG_FILE)) {
            props.store(fos, "Window State Configuration");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void saveAll() {
        Properties props = loadProperties();

        for (RecoverableWindow window : windows) {
            String id = window.getID();
            WindowState state = window.getState();

            props.setProperty(id + ".x", String.valueOf(state.rectangle.x));
            props.setProperty(id + ".y", String.valueOf(state.rectangle.y));
            props.setProperty(id + ".width", String.valueOf(state.rectangle.width));
            props.setProperty(id + ".height", String.valueOf(state.rectangle.height));
            props.setProperty(id + ".isClosed", String.valueOf(state.isClosed));
        }

        saveProperties(props);
    }

    public void loadAll() {
        Properties props = loadProperties();

        for (RecoverableWindow window : windows) {
            restoreWindow(window, props);
        }
    }

    private void restoreWindow(RecoverableWindow window, Properties props) {
        String key = window.getID();

        String xStr = props.getProperty(key + ".x");
        String yStr = props.getProperty(key + ".y");
        String wStr = props.getProperty(key + ".width");
        String hStr = props.getProperty(key + ".height");
        String eStr = props.getProperty(key + ".isClosed");

        WindowState state;

        if (xStr != null && yStr != null && wStr != null && hStr != null && eStr != null) {
            try {
                Rectangle rect = new Rectangle(Integer.parseInt(xStr),
                        Integer.parseInt(yStr),
                        Integer.parseInt(wStr),
                        Integer.parseInt(hStr));
                boolean extendedState = Boolean.parseBoolean(eStr);
                state = new WindowState(rect, extendedState);
            } catch (NumberFormatException e) {
                state = window.getDefaultWindowState();
            }
        } else {
            state = window.getDefaultWindowState();
        }

        window.setState(state);
    }

    public void setDefaultWindowState(String ID, int x, int y, int height, int width, boolean isClosed) {
        for (RecoverableWindow rw : windows) {
            if (rw.getID().equals(ID)) {
                rw.setDefaultWindowState(
                        new WindowState(
                                new Rectangle(x, y, width, height), isClosed));
                return;
            }
        }
        throw new NoSuchElementException(String.format("ID: %s was not found", ID));
    }


}
