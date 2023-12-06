package org.teambravo;

import org.teambravo.controller.CustomerController;
import org.teambravo.view.Menu;

public class Main {
    public static void main(String[] args) {
        CustomerController controller = new CustomerController();
        Menu menu = new Menu(controller);
        menu.showMenu();
    }
}