package demo.mockito;

public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public boolean isValidUser(String userId, String password) {
        if (userId==null) {
            throw new IllegalArgumentException("Invalid UserId");
        }
        User user = userRepository.findById(userId);

//        NullPointer handling - uncomment to show case source code reconciliation
//        if (user == null) {
//            return false;
//        }

        if (user.isEnabled()) {
            String encodedPassword = passwordEncoder.encode(password);
            return encodedPassword.equals(user.getPasswordHash());
        }
        return false;
    }
}
