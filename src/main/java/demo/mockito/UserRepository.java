package demo.mockito;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

public interface UserRepository {

    User findById(String id);

    Optional<User> findUserByIdOptional(String id);

    Optional<List<User>> findUserByIdsOptional(List<String> ids);

    User findById(int id);

    @SuppressWarnings("RedundantThrows")
    User findByIdWithException(String id) throws Exception;

    @SuppressWarnings("RedundantThrows")
    User findByIdWithException(String id1, String id2) throws Exception;

    void find();

    String findUsername(String name);

    User  create(User user);

    User create2(User user, String id);

    User update(User user);

    List<User> createAll(List<User> users);

    List<User> findByIds(List<String> ids);

    List<User> findAll();

    List<? extends User> findAll2();

    @SuppressWarnings("rawtypes")
    List findAll3();

    List<?> findAll4();

    Set<User> findAllSet();

    Map<String, User> findAllMap();

    Map<String, ? extends User> findAllMapChild();

    Set<Integer> findDistinctAges();

    Map<String, Integer> findAgesGroupedByName();

    List<String> findAllUserName();

    String[] findAllUserNameAsArray();

    User[] createAllArray(User[] users);

    User[] findByIdsArray(String[] ids);

    User[] findAllArray();

    String[] findAllUserNameArray();

}
