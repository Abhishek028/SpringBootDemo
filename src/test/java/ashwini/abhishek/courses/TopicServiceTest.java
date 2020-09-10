package ashwini.abhishek.courses;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

/*Prior to JUnit 5, we would use MockitoJUnitRunner to run our unit test.
In the new JUnit version, the runner behaviors have been replaced by Extensions.
This one, the MockitoExtension, is provided by Mockito and adds some useful functionalities:
detects that we’re using the framework, that there are no unused stubs, and initializes for us all the fields annotated with @Mock,
so we don’t need to call the Mockito.initMocks() method.*/

@ExtendWith(MockitoExtension.class)
public class TopicServiceTest {
    @Mock
    private TopicRepository topicRepository;
    @InjectMocks
    private TopicService topicService;

    @Test
    void getAllTopicsTest() throws SQLException {
        ArrayList<Topic> al = new ArrayList<>();
        al.add(new Topic(1, "collection", null));
        al.add(new Topic(2, "threading", null));

        when(topicRepository.getAllTopics(1)).thenReturn(al);
        List<Topic> al2 = topicService.getAllTopics(1);
        assertArrayEquals(al.toArray(), al2.toArray());
    }

    @Test
    void addTopicTest() throws SQLException {
        Topic topic = new Topic();
        topic.setId(4);
        topic.setName("lamda");
        when(topicRepository.addTopic(1, topic)).thenReturn(new ResponseMessage(200, "ok"));
        ResponseMessage responseMessage = topicService.addTopic(1, topic);
        assertEquals(responseMessage, new ResponseMessage(200, "ok"));
    }
}
