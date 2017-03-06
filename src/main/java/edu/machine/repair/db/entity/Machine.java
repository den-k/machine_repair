package edu.machine.repair.db.entity;

import javax.persistence.*;

@Entity
@Table(name = "machines")
public class Machine {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "serial_number")
    private String serialNumber;

    @Column(name = "year")
    private int year;

    @Column(name = "times_repaired")
    private int timesRepaired;

    @ManyToOne
    @JoinColumn(name = "machine_type_id", referencedColumnName = "id")
    private MachineType machineType;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getTimesRepaired() {
        return timesRepaired;
    }

    public void setTimesRepaired(int timesRepaired) {
        this.timesRepaired = timesRepaired;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Machine machine = (Machine) o;

        return id == machine.id && (serialNumber != null ? serialNumber.equals(machine.serialNumber) : machine.serialNumber == null);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (serialNumber != null ? serialNumber.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Machine{" +
                "id=" + id +
                ", serialNumber='" + serialNumber + '\'' +
                ", year=" + year +
                ", timesRepaired=" + timesRepaired +
                '}';
    }
}
