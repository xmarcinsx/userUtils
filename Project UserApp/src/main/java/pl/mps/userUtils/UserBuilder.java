package pl.mps.userUtils;

import java.util.Collection;

public class UserBuilder {

    private int idUser;
    private String firstName;
    private String lastName;
    private String email;
    private String company;
    private Collection<Car> cars;

    public UserBuilder setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public UserBuilder setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public UserBuilder setEmail(String email) {
        this.email = email;
        return this;
    }

    public UserBuilder setCompany(String company) {
        this.company = company;
        return this;
    }

    public UserBuilder setCars(Collection<Car> cars) {
        this.cars = cars;
        return this;
    }

    public User build() {
        return new User(firstName, lastName, email, company);
    }

}
