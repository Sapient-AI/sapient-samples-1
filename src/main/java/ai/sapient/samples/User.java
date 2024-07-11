package ai.sapient.samples;

import java.io.Serializable;
import java.util.Objects;

public class User implements Comparable<User>, Serializable {

    private final String id;
    private final String passwordHash;
    private final boolean enabled;

    public User(String id, String passwordHash, boolean enabled) {
        this.id = id;
        this.passwordHash = passwordHash;
        this.enabled = enabled;
    }

    @Override
    public int compareTo(User user) {
        if(id != null)
            return this.id.compareTo(user.getId());
        return 0;
    }

    public String getId() {
        return id;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public boolean isEnabled() {
        return enabled;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return enabled == user.enabled && Objects.equals(id, user.id) && Objects.equals(passwordHash,
                user.passwordHash);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, passwordHash, enabled);
    }
}
