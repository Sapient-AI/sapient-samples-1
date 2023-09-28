package demo.mockito;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(@Autowired(required = false) UserRepository userRepository, @Autowired(required = false) PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public boolean isValidUser(String userId, String password) {
        if (userId==null) {
            throw new IllegalArgumentException("Invalid UserId");
        }
        User user = userRepository.findById(userId);

        if (user == null) {
            return false;
        }
        if (user.isEnabled()) {
            String encodedPassword = passwordEncoder.encode(password);
            return encodedPassword.equals(user.getPasswordHash());
        }
        return false;
    }

    public User findById(String id) {
        return userRepository.findById(id);
    }

    public List<User> findByIds(List<String> ids) {
        return ids.stream().map(userRepository::findById).collect(Collectors.toList());
    }

    public void create(User user) {
        userRepository.create(user);
    }

    public void update(User user) {
        userRepository.update(user);
    }

    @SuppressWarnings("SameReturnValue")
    public String greet() {
        return "Hello, I'm UserService";
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public List<String> findAllIds() {
        return userRepository.findAll().stream().map(User::getId).collect(Collectors.toList());
    }
}
