package entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table (name = "person")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column (name = "first_name")
    private String firstName;

    @Column (name = "last_name")
    private String lastName;

    @Column (name = "doc_number")
    private String docNumber;

    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn (name = "doc_type_fk")
    private DocType docType;

    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn (name = "address_fk")
    private Address address;

    //una persona tiene muchos carros y puede tener muchas computadoras
    @OneToMany(mappedBy = "person", fetch = FetchType.LAZY)
    private List<Car> cars;

    @OneToMany(mappedBy = "person", fetch = FetchType.LAZY)
    private List<Computer> computers;

    public DocType getDocType() {
        return docType;
    }

    public void setDocType(DocType docType) {
        this.docType = docType;
    }


    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDocNumber() {
        return docNumber;
    }

    public void setDocNumber(String docNumber) {
        this.docNumber = docNumber;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }

    public List<Computer> getComputers() {
        return computers;
    }

    public void setComputers(List<Computer> computers) {
        this.computers = computers;
    }

}
