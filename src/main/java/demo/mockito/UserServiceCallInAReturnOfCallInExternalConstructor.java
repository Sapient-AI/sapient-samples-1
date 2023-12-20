package demo.mockito;

public class UserServiceCallInAReturnOfCallInExternalConstructor {


    private final UserServiceDependency2 dependency;

    private String myStringNull;

    public UserServiceCallInAReturnOfCallInExternalConstructor(UserRepository userRepository) {
        this.dependency = new UserServiceDependency2(userRepository);
    }

    public String getPasswordHash() {
        return dependency.getPasswordHash();
    }

    public String returnMyStringNull() {
        return myStringNull;
    }

}
