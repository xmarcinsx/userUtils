package pl.mps.userUtils;

public class EmailService {
    private final UsersRepository usersRepository;

    public EmailService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    public String getEmailByName(String name) {
        return usersRepository.findAllUsers()
                .stream()
                .filter(user -> user.getName().equals(name))
                .map(User::getEmail)
                .findFirst()
                .orElse(null);
    }
}
