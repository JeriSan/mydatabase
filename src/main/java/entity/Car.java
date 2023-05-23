package entity;

import javax.persistence.*;

@Entity
@Table(name = "car")
public class Car {
//marca - modelo
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column (name = "brand")
    private String brand;

    @Column (name = "modelo")
    private String model;

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

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
