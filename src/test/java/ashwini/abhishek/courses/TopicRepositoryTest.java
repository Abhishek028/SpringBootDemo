package ashwini.abhishek.courses;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.Rollback;

import javax.sql.DataSource;
import javax.transaction.Transactional;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class TopicRepositoryTest {
    @Autowired
    CourseRepository cr;
    @Autowired
    TopicRepository tr;

    @Test
    public void getAllTopicsTest() throws SQLException {
        cr.save(new Course(5, "java"));
        tr.addTopic(5, new Topic(1, "lamda", null));
        assertEquals(new Topic(1, "lamda", null), tr.getAllTopics(5).get(0));
    }

    @Test
    public void addTopicTest() throws SQLException {
        cr.save(new Course(5, "java"));
        ResponseMessage rm = tr.addTopic(5, new Topic(1, "lamda", null));
        assertEquals(new ResponseMessage(200, "ok"), rm);
    }
}


