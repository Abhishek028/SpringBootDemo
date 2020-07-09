package ashwini.abhishek.courses;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.sql.SQLException;
import java.util.List;

@RestController
public class TopicController {
    @Autowired
    public TopicService topicService;

    @RequestMapping("courses/{id}/topics")
    public List<Topic> getAllTopics(@PathVariable("id") int id) throws SQLException {
        return topicService.getAllTopics(id);
    }

    @RequestMapping(method = RequestMethod.POST,value = "courses/{id}/topics")
    public ResponseMessage addTopic(@PathVariable("id") int id, @RequestBody Topic topic) throws SQLException {
        return topicService.addTopic(id,topic);
    }
}
