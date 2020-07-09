package ashwini.abhishek.courses;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
public class TopicServiceTest {
    @MockBean
    private TopicRepository topicRepository;
    @Autowired
    private TopicService topicService;

    @Test
    void getAllTopicsTest() throws SQLException {
        ArrayList<Topic> al = new ArrayList<>();
        al.add(new Topic(1,"collection",null));
        al.add(new Topic(2,"threading",null));

        when(topicRepository.getAllTopics(1)).thenReturn(al);
        List<Topic> al2 = topicService.getAllTopics(1);
        assertArrayEquals(al.toArray(),al2.toArray());
    }

    @Test
    void addTopicTest() throws SQLException {
        Topic topic = new Topic();
        topic.setId(4);
        topic.setName("lamda");
        when(topicRepository.addTopic(1,topic)).thenReturn(new ResponseMessage(200,"ok"));
        ResponseMessage responseMessage = topicService.addTopic(1,topic);
        assertEquals(responseMessage,new ResponseMessage(200,"ok"));
    }
}
