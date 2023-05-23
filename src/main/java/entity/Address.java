package entity;

import javax.persistence.*;

@Entity
@Table (name = "direccion")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "address")
    private String address;

    @Column(name = "floor_numb")
    private Integer floorNumb;

    @Column(name = "department")
    private String department;

    @Column(name = "province")
    private String province;

    @Column(name = "district")
    private String district;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getFloorNumb() {
        return floorNumb;
    }

    public void setFloorNumb(Integer floorNumb) {
        this.floorNumb = floorNumb;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }







}
