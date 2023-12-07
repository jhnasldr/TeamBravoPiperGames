package org.teambravo.entity;


import javax.persistence.*;

@Entity
@Table(name = "Teams")
public class TeamClass {
    //Primary key
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column (name = "team_id")
    private int team_id;

    @Column(name = "team_name" , length = 50)
    private String name;

    @Id
    @Column (name = "game_id")
    private int game_id;

    // @OneToMany (fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy ="team")
    //private List<TeamClass> teamList = new ArrayList<>();
    public TeamClass() {

    }

    public TeamClass(int id, String name) {
        this.team_id = id;
        this.name = name;
    }

    public TeamClass(String teamName) {
        this.name = teamName;
    }

    public int getTeamId() {
        return team_id;
    }

    public String getTeamName() {
        return name;
    }

    // public void setId(int id) {
    //  this.id = id;
    // }


    }


