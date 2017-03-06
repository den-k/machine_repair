package edu.machine.repair.db.entity;

import javax.persistence.*;

@Entity
@Table(name = "machine_types")
public class MachineType {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "trademark")
    private String trademark;

    @Column(name = "country")
    private int country;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTrademark() {
        return trademark;
    }

    public void setTrademark(String trademark) {
        this.trademark = trademark;
    }

    public int getCountry() {
        return country;
    }

    public void setCountry(int country) {
        this.country = country;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MachineType that = (MachineType) o;

        return id == that.id;
    }

    @Override
    public int hashCode() {
        return id;
    }

    @Override
    public String toString() {
        return "MachineType{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", trademark='" + trademark + '\'' +
                ", country=" + country +
                '}';
    }
}
