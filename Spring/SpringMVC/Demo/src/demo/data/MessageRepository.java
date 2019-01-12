package demo.data;

import demo.Message;

import java.util.List;

public interface MessageRepository {
    List<Message> findMessage(int count);
}
