package pl.mps.userUtils

import spock.lang.Specification

class EmailServiceSpec extends Specification {
    UsersRepository usersRepository = Mock(UsersRepository)
    EmailService emailService = new EmailService(usersRepository)

    def "Should find email for given user"() {
        given:
        usersRepository.findAllUsers() >> [new User("Adam", "Kowalski", "adam.kowalski@gmail.com", "Gmail"),
                                           new User("Jan", "Biały", "jan.bialy@op.pl", "XYZ"),
                                           new User("Paweł", "Grajewski", "p.g@gmail.com", "BMS")]

        expect:
        emailService.getEmailByName("Adam Kowalski") == "adam.kowalski@gmail.com"
    }

    def "Should return null if there is no user with this name in database" () {
        given:
        usersRepository.findAllUsers() >> [new User("Adam", "Kowalski", "adam.kowalski@gmail.com", "Gmail"),
                                           new User("Jan", "Biały", "jan.bialy@op.pl", "XYZ"),
                                           new User("Paweł", "Grajewski", "p.g@gmail.com", "BMS")]

        expect:
        emailService.getEmailByName("Anna Kowalska") == null
    }

    def "Should throw an exception if there is more that one user with this name" () {
        given:
        usersRepository.findAllUsers() >> [new User("Adam", "Kowalski", "adam.kowalski@gmail.com", "Gmail"),
                                           new User("Jan", "Biały", "jan.bialy@op.pl", "XYZ"),
                                           new User("Anna", "Kowalska", "anna.kowalska@onet.pl","AJK"),
                                           new User("Paweł", "Grajewski", "p.g@gmail.com", "BMS"),
                                           new User("Anna", "Kowalska", "a.kowalska@wp.pl","WP")]

        expect:
        emailService.getEmailByName("Anna Kowalska") == "anna.kowalska@onet.pl"
    }

}
