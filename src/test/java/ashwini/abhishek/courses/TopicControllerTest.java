package ashwini.abhishek.courses;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@SpringBootTest
@AutoConfigureMockMvc
public class TopicControllerTest {

    @Autowired
    private MockMvc mockMvc;
    ObjectMapper om = new ObjectMapper();

    @Test
    void getAllTopicsTest() throws Exception {
        mockMvc.perform(get("/courses/1/topics"))
                .andExpect(status().isOk());
    }

    @Test
    void addTopicTest() throws Exception {
        Topic topic = new Topic();
        topic.setId(3);
        topic.setName("Threading");
        String jsonRequest = om.writeValueAsString(topic);

        mockMvc.perform(post("/courses/3/topics").content(jsonRequest).contentType(MediaType.APPLICATION_JSON_VALUE)).andExpect(status().isOk());
    }
}