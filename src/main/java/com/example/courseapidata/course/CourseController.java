package com.example.courseapidata.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class CourseController {

    @Autowired
    private CourseService courseService;

    @GetMapping("/topics/{id}/courses")
    public List<Course> getAllCourses(@PathVariable String id) {
        return courseService.getAllCourses(id);
    }

    @GetMapping("/topics/{topicId}/courses/{id}")
    public Course getCourseById(@PathVariable String topicId, @PathVariable String id) {
        return courseService.getCourseById(topicId, id);
    }

    @PostMapping("/topics/{id}/courses")
    public void createCourse(@PathVariable String id, @RequestBody Course course) {
        courseService.createCourse(id, course);
    }

    @PutMapping("/topics/{topicId}/courses/{id}")
    public void updateCourse(@PathVariable String topicId, @PathVariable String id,
                               @RequestBody Course course) {
        courseService.updateCourse(topicId, id, course);
    }

    @DeleteMapping("/topics/{topicId}/courses/{id}")
    public void deleteCourse(@PathVariable String topicId, @PathVariable String id) {
        courseService.deleteCourse(topicId, id);
    }
}
