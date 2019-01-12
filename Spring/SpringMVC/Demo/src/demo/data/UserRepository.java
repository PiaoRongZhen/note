package demo.data;

import demo.User;

public interface UserRepository {
    void save(User user);
    User findByUsername(String username);
}
