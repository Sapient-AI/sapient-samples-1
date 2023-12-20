package demo.mockito;

public class UserServiceCallInExternalConstructor {


    private final User user;

    public UserServiceCallInExternalConstructor(UserRepository userRepository) {
        UserServiceDependency dependency = new UserServiceDependency(userRepository);
        this.user = dependency.getUser();
    }

    public User getUser() {
        return user;
    }

}
