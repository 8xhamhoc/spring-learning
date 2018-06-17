package spring.entity;

import javax.persistence.*;

@Entity
@Embeddable
@Table(name = "employee")
public class Employee {

    @Id
    @Column(name = "empId")
    private Integer id;

    @Column(name = "name")
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
