package demo.mockito;

public interface UserRepository {
    User findById(String id);

    User create(User user);

    User update(User user);
}
