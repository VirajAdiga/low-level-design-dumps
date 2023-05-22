package lld;

import java.util.Objects;

public class User {
    private String name;
    private Location location;

    public User(String pName, Location pLoc) {
        name = pName;
        location = pLoc;
    }

    public Location getLocation() {
        return location;
    }

    public String getId() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return Objects.equals(name, user.name) &&
                Objects.equals(location, user.location);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, location);
    }
}

