package entity;

import javax.persistence.*;

@Entity
@Table(name = "computer")
public class Computer {
    //marca
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "brand")
    private String brand;


    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn (name = "person_fk")
    private Person person;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Person getPerson(){
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
