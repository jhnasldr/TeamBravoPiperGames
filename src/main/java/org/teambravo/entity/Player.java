package org.teambravo.entity;
import javax.persistence.*;

@Entity
@Table(name = "players")
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "player_id")
    private int playerId;
    @Column(name = "person_id")
    private int personId;
    @Column(name = "team_id")
    private int teamId;

    /*private List<TeamClass> teamMembership = new ArrayList<>();*/

    public Player(int playerId, int personId, int teamId) {
        this.playerId = playerId;
        this.personId = personId;
        this.teamId = teamId;
    }

    public Player() {

    }
    /*


    }
    public void addTeamClass(TeamClass teamClass){
        teamClass.setPlayer(this);
        teamMembership.add(teamClass);
    }

    public List<TeamClass> getTeamMembership() {
        return teamMembership;
    }

    public void setTeamMembership(List<TeamClass> teamMembership) {
        this.teamMembership = teamMembership;
    }*/

    public int getPlayerId() {
        return playerId;
    }

    public void setPlayerId(int playerId) {
        this.playerId = playerId;
    }

    public int getPersonId() {
        return personId;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }

    public int getTeamId() {
        return teamId;
    }

    public void setTeamId(int teamId) {
        this.teamId = teamId;

    }
}