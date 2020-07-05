package ashwini.abhishek.courses;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

@Repository
class TopicRepository {
//    public Connection getConnection() throws SQLException {
//
//        Connection conn = null;
//        Properties connectionProps = new Properties();
//        connectionProps.put("user","postgres");
//        connectionProps.put("password", "password");
//        conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/testdb",
//                    connectionProps);
//        return conn;
//    }
    @Autowired
    public DataSource ds;

    @Autowired
    CourseRepository cr;

    public Connection conn = null;


    public TopicRepository() throws SQLException {

    }

    public List<Topic> getAllTopics(int courseId) throws SQLException {
        conn = ds.getConnection();
        Statement stmt = conn.createStatement();
        String query = "select * from topic where course_id="+courseId;
        ResultSet rs = stmt.executeQuery(query);
        List<Topic> list = new ArrayList<>();
        while(rs.next()) {
            int id = rs.getInt("id");
            String name = rs.getString("name");
            list.add(new Topic(id,name,cr.findById(courseId).get()));
        }
        return list;
    }

    public void addTopic(int id,Topic topic) throws SQLException {
        conn = ds.getConnection();
        String query = "INSERT INTO topic (id,name,course_id) VALUES (?,?,?)";
        PreparedStatement stmt = conn.prepareStatement(query);
        stmt.setInt(1,topic.getId());
        stmt.setString(2,topic.getName());
        stmt.setInt(3,id);
        stmt.executeUpdate();
    }


}
