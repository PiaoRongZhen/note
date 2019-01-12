package demo.data;

import demo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class JdbcUserRepository implements UserRepository{

    @Autowired
    private JdbcOperations jdbc;

    @Override
    public void save(User user) {
        jdbc.update("insert into user (username, password, first_name, last_name, email) values (?, ?, ?, ?, ?)",
                user.getUsername(), user.getPassword(), user.getFirstName(), user.getLastName(), user.getEmail());
    }

    @Override
    public User findByUsername(String username) {
        return jdbc.queryForObject("select id, username, first_name, last_name, email from user where username = ?",
                new RowMapper<User>() {
                    @Override
                    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
                        return new User(rs.getLong("id"),
                                rs.getString("username"), null,
                                rs.getString("first_name"),
                                rs.getString("last_name"),
                                rs.getString("email"));
                    }
                }, username);

    }
}
