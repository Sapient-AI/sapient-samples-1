package demo.mockito;

public class UserServiceDependency {


    private final User user;

    public UserServiceDependency(UserRepository userRepository) {
        user = userRepository.findById("1");
    }

    public User getUser() {
        return user;
    }
}
