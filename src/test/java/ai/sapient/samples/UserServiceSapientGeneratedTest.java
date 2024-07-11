package ai.sapient.samples;

import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInRelativeOrder;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.mockito.Mockito.mock;
import static org.hamcrest.core.IsInstanceOf.instanceOf;
import static org.mockito.Mockito.doReturn;
import static org.hamcrest.Matchers.is;

@Timeout(value = 5, threadMode = Timeout.ThreadMode.SEPARATE_THREAD)
class UserServiceSapientGeneratedTest {

    private final UserRepository userRepositoryMock = mock(UserRepository.class, "userRepository");

    private final PasswordEncoder passwordEncoderMock = mock(PasswordEncoder.class, "passwordEncoder");

    private final User userMock = mock(User.class);

    private final User userMock2 = mock(User.class);

    //Sapient generated method id: ${isValidUserWhenUserIdIsNullThrowsIllegalArgumentException}, hash: E98C293A153165468D2632102C27DE04
    @Test()
    void isValidUserWhenUserIdIsNullThrowsIllegalArgumentException() {
        /* Branches:
         * (userId == null) : true
         */
         //Arrange Statement(s)
        UserService target = new UserService(userRepositoryMock, passwordEncoderMock);
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Invalid UserId");
        //Act Statement(s)
        final IllegalArgumentException result = assertThrows(IllegalArgumentException.class, () -> {
            target.isValidUser((String) null, "password1");
        });
        
        //Assert statement(s)
        assertAll("result", () -> {
            assertThat(result, is(notNullValue()));
            assertThat(result.getMessage(), equalTo(illegalArgumentException.getMessage()));
        });
    }

    //Sapient generated method id: ${isValidUserWhenUserIsNull}, hash: 0CD2735111031EC9F870A8F25ADEF69D
    @Test()
    void isValidUserWhenUserIsNull() {
        /* Branches:
         * (userId == null) : false
         * (user == null) : true
         */
         //Arrange Statement(s)
        UserService target = new UserService(userRepositoryMock, passwordEncoderMock);
        doReturn(null).when(userRepositoryMock).findById("userId1");
        
        //Act Statement(s)
        boolean result = target.isValidUser("userId1", "password1");
        
        //Assert statement(s)
        assertAll("result", () -> {
            assertThat(result, equalTo(Boolean.FALSE));
            verify(userRepositoryMock).findById("userId1");
        });
    }

    //Sapient generated method id: ${isValidUserWhenUserNotIsEnabled}, hash: 94D1D322D5DD36917C54F2C0041A7561
    @Test()
    void isValidUserWhenUserNotIsEnabled() {
        /* Branches:
         * (userId == null) : false
         * (user == null) : false
         * (user.isEnabled()) : false
         */
         //Arrange Statement(s)
        UserService target = new UserService(userRepositoryMock, passwordEncoderMock);
        User user = new User("id1", "passwordHash1", false);
        doReturn(user).when(userRepositoryMock).findById("userId1");
        
        //Act Statement(s)
        boolean result = target.isValidUser("userId1", "password1");
        
        //Assert statement(s)
        assertAll("result", () -> {
            assertThat(result, equalTo(Boolean.FALSE));
            verify(userRepositoryMock).findById("userId1");
        });
    }

    //Sapient generated method id: ${isValidUserWhenEncodedPasswordEqualsUserGetPasswordHash}, hash: D360C182FF9374AA22D2C13A349C39A7
    @Test()
    void isValidUserWhenEncodedPasswordEqualsUserGetPasswordHash() {
        /* Branches:
         * (userId == null) : false
         * (user == null) : false
         * (user.isEnabled()) : true
         * (encodedPassword.equals(user.getPasswordHash())) : true
         */
         //Arrange Statement(s)
        UserService target = new UserService(userRepositoryMock, passwordEncoderMock);
        User user = new User("id1", "", true);
        doReturn(user).when(userRepositoryMock).findById("userId1");
        doReturn("").when(passwordEncoderMock).encode("");
        
        //Act Statement(s)
        boolean result = target.isValidUser("userId1", "A");
        
        //Assert statement(s)
        assertAll("result", () -> {
            assertThat(result, equalTo(Boolean.TRUE));
            verify(userRepositoryMock).findById("userId1");
            verify(passwordEncoderMock).encode("");
        });
    }

    //Sapient generated method id: ${isValidUserWhenEncodedPasswordNotEqualsUserGetPasswordHash}, hash: E2F67227360DAFBCA914D32483FB516B
    @Test()
    void isValidUserWhenEncodedPasswordNotEqualsUserGetPasswordHash() {
        /* Branches:
         * (userId == null) : false
         * (user == null) : false
         * (user.isEnabled()) : true
         * (encodedPassword.equals(user.getPasswordHash())) : false
         */
         //Arrange Statement(s)
        UserService target = new UserService(userRepositoryMock, passwordEncoderMock);
        User user = new User("id1", "C", true);
        doReturn(user).when(userRepositoryMock).findById("userId1");
        doReturn("").when(passwordEncoderMock).encode("");
        
        //Act Statement(s)
        boolean result = target.isValidUser("userId1", "A");
        
        //Assert statement(s)
        assertAll("result", () -> {
            assertThat(result, equalTo(Boolean.FALSE));
            verify(userRepositoryMock).findById("userId1");
            verify(passwordEncoderMock).encode("");
        });
    }

    //Sapient generated method id: ${findByIdTest}, hash: 2C6F5F583B2C57B9E9958BFB42C4248C
    @Test()
    void findByIdTest() {
        //Arrange Statement(s)
        UserService target = new UserService(userRepositoryMock, passwordEncoderMock);
        doReturn(userMock).when(userRepositoryMock).findById("id1");
        
        //Act Statement(s)
        User result = target.findById("id1");
        
        //Assert statement(s)
        assertAll("result", () -> {
            assertThat(result, equalTo(userMock));
            verify(userRepositoryMock).findById("id1");
        });
    }

    //Sapient generated method id: ${findByIdsTest}, hash: 7E01825A7F2C51704875A8B30702B733
    @Test()
    void findByIdsTest() {
        //Arrange Statement(s)
        UserService target = new UserService(userRepositoryMock, passwordEncoderMock);
        doReturn(userMock).when(userRepositoryMock).findById("idsItem1");
        List<String> stringList = new ArrayList<>();
        stringList.add("idsItem1");
        
        //Act Statement(s)
        List<User> result = target.findByIds(stringList);
        
        //Assert statement(s)
        assertAll("result", () -> {
            assertThat(result.size(), equalTo(1));
            assertThat(result.get(0), is(instanceOf(User.class)));
            verify(userRepositoryMock).findById("idsItem1");
        });
    }

    //Sapient generated method id: ${createTest}, hash: 7F175F5854EA2420AACF3E276999BDCF
    @Test()
    void createTest() {
        //Arrange Statement(s)
        UserService target = new UserService(userRepositoryMock, passwordEncoderMock);
        doReturn(userMock).when(userRepositoryMock).create(userMock2);
        
        //Act Statement(s)
        target.create(userMock2);
        
        //Assert statement(s)
        assertAll("result", () -> verify(userRepositoryMock).create(userMock2));
    }

    //Sapient generated method id: ${updateTest}, hash: 84170BE9101370988941A46568487AD4
    @Test()
    void updateTest() {
        //Arrange Statement(s)
        UserService target = new UserService(userRepositoryMock, passwordEncoderMock);
        doReturn(userMock).when(userRepositoryMock).update(userMock2);
        
        //Act Statement(s)
        target.update(userMock2);
        
        //Assert statement(s)
        assertAll("result", () -> verify(userRepositoryMock).update(userMock2));
    }

    //Sapient generated method id: ${greetTest}, hash: A45B8C5DF21C52390782EDBFC42261C4
    @Test()
    void greetTest() {
        //Arrange Statement(s)
        UserService target = new UserService(userRepositoryMock, passwordEncoderMock);
        
        //Act Statement(s)
        String result = target.greet();
        
        //Assert statement(s)
        assertAll("result", () -> assertThat(result, equalTo("Hello, I'm UserService")));
    }

    //Sapient generated method id: ${findAllTest}, hash: 9AB27BD0222ED0DC1BD575CB5C7DC916
    @Test()
    void findAllTest() {
        //Arrange Statement(s)
        UserService target = new UserService(userRepositoryMock, passwordEncoderMock);
        List<User> userList = new ArrayList<>();
        doReturn(userList).when(userRepositoryMock).findAll();
        
        //Act Statement(s)
        List<User> result = target.findAll();
        
        //Assert statement(s)
        assertAll("result", () -> {
            assertThat(result, equalTo(userList));
            verify(userRepositoryMock).findAll();
        });
    }

    //Sapient generated method id: ${findAllIdsTest}, hash: E87FC4AAB367187227DD6BA5D7749C32
    @Test()
    void findAllIdsTest() {
        //Arrange Statement(s)
        UserService target = new UserService(userRepositoryMock, passwordEncoderMock);
        User user = new User("id1", "passwordHash1", false);
        List<User> userList = new ArrayList<>();
        userList.add(user);
        doReturn(userList).when(userRepositoryMock).findAll();
        
        //Act Statement(s)
        List<String> result = target.findAllIds();
        List<String> stringResultList = new ArrayList<>(Arrays.asList("id1"));
        
        //Assert statement(s)
        assertAll("result", () -> {
            assertThat(result.size(), equalTo(1));
            assertThat(result, containsInRelativeOrder(stringResultList.toArray()));
            verify(userRepositoryMock).findAll();
        });
    }
}
