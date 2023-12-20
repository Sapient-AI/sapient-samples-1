package demo.mockito;

public class UserServiceDependency2 {


    private final String passwordHash;

    public UserServiceDependency2(UserRepository userRepository) {
        User user = userRepository.findById("1");
        this.passwordHash = user.getPasswordHash();
    }

    public String getPasswordHash() {
        return passwordHash;
    }
}
