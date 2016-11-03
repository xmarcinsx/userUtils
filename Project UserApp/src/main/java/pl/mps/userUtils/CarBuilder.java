package pl.mps.userUtils;

public class CarBuilder{

    private int idCar;
    private String nameCar;
    private User owner;

    public String getNameCar() {
        return nameCar;
    }

    public CarBuilder setNameCar(String nameCar) {
        this.nameCar = nameCar;
        return this;
    }

    public CarBuilder setOwner(User owner) {
        this.owner = owner;
        return this;
    }

    public Car build() {
        return new Car(nameCar, owner);
    }
}
