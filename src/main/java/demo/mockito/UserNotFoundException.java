package demo.mockito;

public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException() {
        super("Could not find user with this id");
    }
}
