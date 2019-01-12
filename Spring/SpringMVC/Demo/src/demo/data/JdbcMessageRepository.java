package demo.data;

import demo.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class JdbcMessageRepository implements MessageRepository {

    @Autowired
    private JdbcOperations jdbc;

    @Override
    public List<Message> findMessage(int count) {
        return jdbc.query("select id, message, created_at, longitude, latitude from message"
                + " order by created_at desc limit ?", new RowMapper<Message>() {
            @Override
            public Message mapRow(ResultSet rs, int rowNum) throws SQLException {
                return new Message(rs.getLong("id"), rs.getString("message"), rs.getDate("created_at"),
                        rs.getDouble("longitude"), rs.getDouble("latitude"));
            }
        }, count);
    }
}
