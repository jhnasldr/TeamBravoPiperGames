package org.teambravo.entity;


import javax.persistence.*;

@Entity
@Table(name = "Staff")
public class StaffClass {
    //Primary key
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column (name = "staff_id")
    private int staff_id;

    @Id
    @Column (name = "person_id")
    private int person_id;

    // @OneToMany (fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy ="team")
    //private List<TeamClass> teamList = new ArrayList<>();
    public StaffClass() {

    }

    public StaffClass(int staff_id, int person_id) {
        this.staff_id = staff_id;
        this.person_id = person_id;
    }


    public int getStaff_id() {
        return staff_id;
    }

    public int getPerson_id() {
        return person_id;
    }

    // public void setId(int id) {
    //  this.id = id;
    // }


}


