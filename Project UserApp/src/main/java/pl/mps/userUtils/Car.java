package pl.mps.userUtils;

import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;

@Entity
@Table(name="cars")
public class Car {

    @Id
    @GenericGenerator(name="idCar", strategy="increment")
    @GeneratedValue(generator="idCar")
    @Column(name="idCar")
    private int idCar;

    @Column(name="nameCar")
    private String nameCar;

    @ManyToOne
    @JoinColumn(name="idUser")
    private User owner;

    Car() {
    }

    Car(String nameCar, User owner) {
        this.nameCar = nameCar;
        this.owner = owner;
    }

    public String getNameCar() {
        return nameCar;
    }

    public void setNameCar(String nameCar) {
        this.nameCar = nameCar;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public int getIdCar() {
        return idCar;
    }

    public void setIdCar(int idCar) {
        this.idCar = idCar;
    }

    @Override
    public String toString() {
        return "Car{" +
                "idCar=" + idCar +
                ", nameCar='" + nameCar + '\'' +
                ", owner=" + owner +
                '}';
    }
}
