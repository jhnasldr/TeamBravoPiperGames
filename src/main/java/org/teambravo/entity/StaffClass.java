package org.teambravo.entity;


import javax.persistence.*;

@Entity
@Table(name = "Staff")
public class StaffClass {
    // Primary key
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "staff_id")
    private int staff_id;

    @ManyToOne
    @JoinColumn(name = "person_id")
    private Person person;

    public StaffClass() {
    }

    public StaffClass(int staff_id, Person person) {
        this.staff_id = staff_id;
        this.person = person;
    }

    // Getters och setters
    public int getStaff_id() {
        return staff_id;
    }

    public void setStaff_id(int staff_id) {
        this.staff_id = staff_id;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}



