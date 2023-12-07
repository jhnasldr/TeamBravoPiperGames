package org.teambravo;

import org.teambravo.controller.TeamClassController;
import org.teambravo.view.Menu;

public class Main {
    public static void main(String[] args) {
        TeamClassController teamClassController = new TeamClassController();
        Menu menu = new Menu();
        menu.showMenu(teamClassController);
    }
}
