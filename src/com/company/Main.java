package com.company;

import gui.controller.GuiController;
import gui.model.GuiModel;
import gui.view.GuiView;
import javax.swing.SwingUtilities;

public class Main {

    public static void main(String[] args){ SwingUtilities.invokeLater(() -> {
        GuiModel model = new GuiModel(0);
        GuiView view = new GuiView("-");
        GuiController controller = new GuiController(model,view);
        controller.contol();
    });
    }
}
