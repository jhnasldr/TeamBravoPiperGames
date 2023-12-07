package org.teambravo.JavaFxGUI;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableView;
import org.teambravo.entity.TeamClass; // Assuming Team is your entity class for teams
public class ScenebuilderGUI {



    @FXML
    private ChoiceBox<TeamClass> teamChoiceBox;

    @FXML
    private TableView<TeamClass> teamTableView;

    private ObservableList<TeamClass> teamList = FXCollections.observableArrayList();
    private TeamClass TeamName;

    // This method can be called from your console input to add a team
    public void addTeamFromConsole(String teamName) {
        // Create a new Team object with the provided name (assuming Team has a constructor that accepts the name)
        TeamClass newTeam = new TeamClass(teamName);

        // Add the new team to the observable list
        teamList.add(TeamName);

        // Update the TableView to reflect the changes
        teamTableView.setItems(teamList);
    }

    // Other initialization methods, event handlers, etc.
}
