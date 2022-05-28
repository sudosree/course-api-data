package com.example.courseapidata.lessons;

import com.example.courseapidata.course.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class LessonService {

    @Autowired
    private LessonRepository lessonRepository;
    @Autowired
    private CourseRepository courseRepository;

    public List<Lesson> getAllLessons(String topicId, String courseId) {
        return courseRepository.findByTopicId(topicId).stream().filter(course ->
                course.getId().equalsIgnoreCase(courseId))
                .map(course -> lessonRepository.findByCourseId(course.getId())
                ).findFirst().get();
    }

    public Lesson getLessonById(String topicId, String courseId, String id) {
        return courseRepository.findByTopicIdAndId(topicId, courseId).map(
                course -> lessonRepository.findByCourseIdAndId(course.getId(), id)
        ).get().get();
    }

    public void createLesson(String topicId, String id, Lesson lesson) {
        courseRepository.findByTopicIdAndId(topicId, id).map(course -> {
           lesson.setCourse(course);
           return lessonRepository.save(lesson);
        });
    }

    public void updateLesson(String topicId, String courseId, String id, Lesson lesson) {
        courseRepository.findByTopicIdAndId(topicId, courseId).map(course ->
            lessonRepository.findByCourseIdAndId(course.getId(), id).map(l -> {
                l.setName(lesson.getName());
                l.setDescription(lesson.getDescription());
                return lessonRepository.save(l);
        }));
    }

    public void deleteLesson(String topicId, String courseId, String id) {
        courseRepository.findByTopicIdAndId(topicId, courseId).map(course ->
                lessonRepository.findByCourseIdAndId(course.getId(), id).map(l -> {
                    lessonRepository.delete(l);
                    return null;
                }));
    }
}
