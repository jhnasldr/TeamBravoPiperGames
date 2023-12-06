package org.teambravo;

import org.teambravo.controller.CustomerController;
import org.teambravo.controller.TeamClassController;
import org.teambravo.view.Menu;

public class Main {
    public static void main(String[] args) {
        CustomerController controller = new CustomerController();
        Menu menu = new Menu(controller);
        TeamClassController teamClassController = new TeamClassController();
        menu.showMenu();
    }
}