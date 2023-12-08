package org.teambravo.entity;


import javax.persistence.*;

@Entity
@Table(name = "Staff")
public class Staff {
    // Primary key
    @Id
    // @GeneratedValue(strategy = GenerationType.IDENTITY)
    // @Column(name = "staff_id")
    private int id;


    @OneToOne(fetch = FetchType.EAGER)
    @MapsId
    private Person person;


    //@ManyToOne
    // @OneToOne
    // @JoinColumn(name = "person_id")
    // private Person person;

    public Staff() {
    }

    public Staff(int id, Person person) {
        this.id = id;
        this.person = person;
    }
    
    // Getters och setters
    public int getStaff_id() {
        return id;
    }

    public void setStaff_id(int staff_id) {
        this.id = id;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}



