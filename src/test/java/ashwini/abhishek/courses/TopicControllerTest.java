package ashwini.abhishek.courses;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.io.DataInput;
import java.util.ArrayList;
import java.util.LinkedHashMap;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;



@SpringBootTest
@AutoConfigureMockMvc
public class TopicControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private TopicService topicService;

    ObjectMapper om = new ObjectMapper();

    @Test
    void getAllTopicsTest() throws Exception {
        ArrayList<Topic> al = new ArrayList<>();
        al.add(new Topic(1,"collection",null));
        al.add(new Topic(2,"threading",null));
        when(topicService.getAllTopics(1)).thenReturn(al);
        MvcResult result = mockMvc.perform(get("/courses/1/topics"))
                .andExpect(status().isOk()).andReturn();
        ArrayList<LinkedHashMap<String,Object>> response = om.readValue(result.getResponse().getContentAsString(),ArrayList.class);
        ArrayList<Topic> al2 = new ArrayList<>();
        for(LinkedHashMap<String,Object> lhm:response) {
            Topic topic = new Topic();
            topic.setId((int)lhm.get("id"));
            topic.setName((String)lhm.get("name"));
            al2.add(topic);
        }
        assertArrayEquals(al.toArray(),al2.toArray());
    }

    @Test
    void addTopicTest() throws Exception {
        Topic topic = new Topic();
        topic.setId(4);
        topic.setName("lamda");
        String jsonData = om.writeValueAsString(topic);
        when(topicService.addTopic(5,topic)).thenReturn(new ResponseMessage(200,"ok"));
        MvcResult result = mockMvc.perform(post("/courses/5/topics").content(jsonData).contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk()).andReturn();
        ResponseMessage response = om.readValue(result.getResponse().getContentAsString(),ResponseMessage.class);
        assertEquals(response,new ResponseMessage(200,"ok"));
    }
}