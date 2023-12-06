package org.teamBravo;

import org.teamBravo.controller.CustomerController;
import org.teamBravo.view.Menu;

public class Main {
    public static void main(String[] args) {
        CustomerController controller = new CustomerController();
        Menu menu = new Menu(controller);
        menu.showMenu();
    }
}