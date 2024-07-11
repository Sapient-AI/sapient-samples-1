package ai.sapient.samples;

import java.util.List;

@SuppressWarnings("UnusedReturnValue")
public interface UserRepository {

    User findById(String id);

    User create(User user);

    User update(User user);

    List<User> findAll();

}
