package org.teambravo.entity;


import javax.persistence.*;

@Entity
@Table(name = "Teams")
public class TeamClass {
    //Primary key
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column (name = "team_id")
    private int id;

    @Column(name = "team_name" , length = 50)
    private String name;

    //@OneToMany (fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy ="team")

    public TeamClass() {

    }

    public TeamClass(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public TeamClass(String teamName) {
        this.name = teamName;
    }

    public int getTeamId() {
        return id;
    }

    public String getTeamName() {
        return name;
    }

    public void setId(int id) {
        this.id = id;
    }


    }


