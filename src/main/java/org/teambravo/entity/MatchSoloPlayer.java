package org.teambravo.entity;

import javax.persistence.*;

@Entity
@Table(name = "solo_matches")


public class MatchSoloPlayer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "solo_match_id")
    private int id;


    @ManyToOne
    @JoinColumn(name = "player1_id", referencedColumnName = "id")
    private Player player1;

    @ManyToOne
    @JoinColumn(name = "player2_id", referencedColumnName = "id")
    private Player player2;

    @Column(name  = "date")
    private int date;


    public MatchSoloPlayer() {
    }

    public MatchSoloPlayer(int id, Player player1, Player player2, int date) {
        this.id = id;
        this.player1 = player1;
        this.player2 = player2;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Player getPlayer1() {
        return player1;
    }

    public void setPlayer1(Player player1) {
        this.player1 = player1;
    }

    public Player getPlayer2() {
        return player2;
    }

    public void setPlayer2(Player player2) {
        this.player2 = player2;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }
}
