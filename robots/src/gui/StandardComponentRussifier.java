package gui;

import javax.swing.*;

public class StandardComponentRussifier {
    private static String INTERNAL_FRAME_PREFIX = "InternalFrame.";
    private static String INTERNAL_FRAME_TITLE_PANE_PREFIX = "InternalFrameTitlePane.";
    private static String OPTION_PANE_PREFIX = "OptionPane.";

    public static void russify() {
        russifyInternalFrame();
        russifyInternalFrameTitlePane();
        russifyOptionPane();
    }

    private static void russifyInternalFrame() {
        UIManager.put(INTERNAL_FRAME_PREFIX + "closeButtonToolTip", "Закрыть");
        UIManager.put(INTERNAL_FRAME_PREFIX + "iconButtonToolTip", "Свернуть");
        UIManager.put(INTERNAL_FRAME_PREFIX + "maxButtonToolTip", "Развернуть");
        UIManager.put(INTERNAL_FRAME_PREFIX + "restoreButtonToolTip", "Восстановить");
    }

    private static void russifyInternalFrameTitlePane() {
        UIManager.put(INTERNAL_FRAME_TITLE_PANE_PREFIX +
                "closeButtonAccessibleName", "Закрыть");
        UIManager.put(INTERNAL_FRAME_TITLE_PANE_PREFIX +
                "closeButtonText", "Закрыть");
        UIManager.put(INTERNAL_FRAME_TITLE_PANE_PREFIX +
                "iconifyButtonAccessibleName", "Свернуть");
        UIManager.put(INTERNAL_FRAME_TITLE_PANE_PREFIX +
                "maximizeButtonAccessibleName", "Развернуть");
        UIManager.put(INTERNAL_FRAME_TITLE_PANE_PREFIX +
                "maximizeButtonText", "Развернуть");
        UIManager.put(INTERNAL_FRAME_TITLE_PANE_PREFIX +
                "minimizeButtonText", "Свернуть");
        UIManager.put(INTERNAL_FRAME_TITLE_PANE_PREFIX +
                "moveButtonText", "Переместить");
        UIManager.put(INTERNAL_FRAME_TITLE_PANE_PREFIX +
                "restoreButtonText", "Восстановить");
        UIManager.put(INTERNAL_FRAME_TITLE_PANE_PREFIX +
                "sizeButtonText", "Размер");
    }

    private static void russifyOptionPane() {
        UIManager.put(OPTION_PANE_PREFIX + "cancelButtonMnemonic", "0");
        UIManager.put(OPTION_PANE_PREFIX + "cancelButtonText", "Отмена");
        UIManager.put(OPTION_PANE_PREFIX + "inputDialogTitle", "Ввод");
        UIManager.put(OPTION_PANE_PREFIX + "messageDialogTitle", "Сообщение");
        UIManager.put(OPTION_PANE_PREFIX + "noButtonMnemonic", "78");
        UIManager.put(OPTION_PANE_PREFIX + "noButtonText", "Нет");
        UIManager.put(OPTION_PANE_PREFIX + "okButtonMnemonic", "0");
        UIManager.put(OPTION_PANE_PREFIX + "okButtonText", "OK");
        UIManager.put(OPTION_PANE_PREFIX + "titleText", "Выберите значение");
        UIManager.put(OPTION_PANE_PREFIX + "yesButtonMnemonic", "89");
        UIManager.put(OPTION_PANE_PREFIX + "yesButtonText", "Да");
    }
}
