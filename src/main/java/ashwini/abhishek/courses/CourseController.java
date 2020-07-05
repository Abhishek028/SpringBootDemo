package ashwini.abhishek.courses;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CourseController {
    @Autowired
    public CourseService courseService;

    @RequestMapping("/courses")
    public List<Course> getAllCourses() {
        return courseService.getAllCourses();
    }

    @RequestMapping(method=RequestMethod.POST,value="/courses")
    public void addCourse(@RequestBody Course course) {
        courseService.addCourse(course);
    }

    @RequestMapping(method = RequestMethod.DELETE,value ="/courses/{id}")
    public void deleteCourse(@PathVariable("id") int id) {
        courseService.deleteCourse(id);
    }

}
