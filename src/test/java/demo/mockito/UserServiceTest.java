package demo.mockito;

import org.mockito.Mock;
import org.mockito.InjectMocks;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.MockitoAnnotations;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.mockito.Mockito.mock;
import org.junit.jupiter.api.Test;

public class UserServiceTest {

    @Mock(name = "userRepository")
    private UserRepository userRepositoryMock;

    @Mock(name = "passwordEncoder")
    private PasswordEncoder passwordEncoderMock;

    @InjectMocks()
    private UserService object;

    @BeforeEach()
    public void beforeTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test()
    public void testTestIsValidUserPath0() {
        /* Branches:
         * (userId==null) : false
         * (userId.matches("^[a-zA-Z0-9_]+$")) : true
         * (user==null) : true
         */
        when(userRepositoryMock.findById("userId1")).thenReturn(null);
        boolean result = object.isValidUser("userId1", "password1");
        assertAll("result", () -> {
            assertThat(result, equalTo(Boolean.FALSE));
            verify(userRepositoryMock).findById("userId1");
        });
    }

    @Test()
    public void disabledUser() {
        /* Branches:
         * (userId==null) : false
         * (userId.matches("^[a-zA-Z0-9_]+$")) : true
         * (user==null) : false
         * (user.isEnabled()) : false
         */
        User userMock = mock(User.class);
        when(userRepositoryMock.findById("userId1")).thenReturn(userMock);
        when(userMock.isEnabled()).thenReturn(false);
        boolean result = object.isValidUser("userId1", "password1");
        assertAll("result", () -> {
            assertThat(result, equalTo(Boolean.FALSE));
            verify(userRepositoryMock).findById("userId1");
            verify(userMock).isEnabled();
        });
    }

    @Test()
    public void validUserAndPassword() {
        /* Branches:
         * (userId==null) : false
         * (userId.matches("^[a-zA-Z0-9_]+$")) : true
         * (user==null) : false
         * (user.isEnabled()) : true
         * (encodedPassword.equals(user.getPasswordHash())): true
         */
        User userMock = mock(User.class);
        when(userRepositoryMock.findById("userid1")).thenReturn(userMock);
        when(userMock.isEnabled()).thenReturn(true);
        when(passwordEncoderMock.encode("password1")).thenReturn("passwordhash1");
        when(userMock.getPasswordHash()).thenReturn("passwordhash1");
        boolean result = object.isValidUser("userid1", "password1");
        assertAll("result", () -> {
            assertThat(result, equalTo(Boolean.TRUE));
            verify(userRepositoryMock).findById("userid1");
            verify(userMock).isEnabled();
            verify(passwordEncoderMock).encode("password1");
            verify(userMock).getPasswordHash();
            verify(userMock).getPasswordHash();
        });
    }

    @Test()
    public void invalidPassword() {
        /* Branches:
         * (userId==null) : false
         * (userId.matches("^[a-zA-Z0-9_]+$")) : true
         * (user==null) : false
         * (user.isEnabled()) : true
         * (encodedPassword.equals(user.getPasswordHash())): false
         */
        User userMock = mock(User.class);
        when(userRepositoryMock.findById("userid1")).thenReturn(userMock);
        when(userMock.isEnabled()).thenReturn(true);
        when(passwordEncoderMock.encode("password1")).thenReturn("passwordhash1");
        when(userMock.getPasswordHash()).thenReturn("passwordhash2");
        boolean result = object.isValidUser("userid1", "password1");
        assertAll("result", () -> {
            assertThat(result, equalTo(Boolean.FALSE));
            verify(userRepositoryMock).findById("userid1");
            verify(userMock).isEnabled();
            verify(passwordEncoderMock).encode("password1");
            verify(userMock).getPasswordHash();
            verify(userMock).getPasswordHash();
        });
    }

    @Test()
    public void testTestIsValidUserPath4() {
        /* Branches:
         * (userId==null) : true
         */
        assertThrows(IllegalArgumentException.class, () -> {
            object.isValidUser(null, "password1");
        });
    }

    @Test()
    public void testTestIsValidUserPath5() {
        /* Branches:
         * (userId==null) : false
         * (userId.matches("^[a-zA-Z0-9_]+$")) : false
         */
        assertThrows(IllegalArgumentException.class, () -> {
            object.isValidUser("u&123", "password1");
        });
    }

}
