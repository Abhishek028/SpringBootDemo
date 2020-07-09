package ashwini.abhishek.courses;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class TopicService {
    @Autowired
    private TopicRepository topicRepository;
    public List<Topic> getAllTopics(int id) throws SQLException {
        return topicRepository.getAllTopics(id);
    }
    public ResponseMessage addTopic(int id,Topic topic) throws SQLException {
        return topicRepository.addTopic(id,topic);
    }
}
