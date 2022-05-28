package com.example.courseapidata.course;

import com.example.courseapidata.topic.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {

    @Autowired
    private TopicRepository topicRepository;

    @Autowired
    private CourseRepository courseRepository;

    public List<Course> getAllCourses(String topicId) {
        return courseRepository.findByTopicId(topicId);
    }

    public Course getCourseById(String topicId, String id) {
        return courseRepository.findByTopicIdAndId(topicId, id).get();
    }

    public void createCourse(String topicId, Course course) {
        topicRepository.findById(topicId).map(topic -> {
            course.setTopic(topic);
            return courseRepository.save(course);
        });
    }

    public void updateCourse(String topicId, String id, Course course) {
        courseRepository.findByTopicIdAndId(topicId, id).map(c -> {
            c.setName(course.getName());
            c.setDescription(course.getDescription());
            return courseRepository.save(c);
        });
    }

    public void deleteCourse(String topicId, String id) {
        courseRepository.findByTopicIdAndId(topicId, id).map(c -> {
            courseRepository.delete(c);
            return null;
        });
    }
}
