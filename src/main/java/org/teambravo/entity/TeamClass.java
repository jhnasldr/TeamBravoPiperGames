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

    // @Id
    @Column (name = "game_id")
    private int game_id;

    // @OneToMany (fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy ="team")
    // private List<TeamMember> teamMembers = new ArrayList<>();
    public TeamClass() {

    }

    public TeamClass(int id, String name, int game_id) {
        this.team_id = id;
        this.name = name;
        this.game_id = game_id;
    }

    public TeamClass(String teamName) {
        this.name = teamName;
    }

    public int getTeamId() {
        return team_id;
    }

    public int getGame_id() {
        return game_id;
    }

    public String getTeamName() {
        return name;
    }



    }


