package com.example.courseapidata.lessons;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LessonController {

    @Autowired
    private LessonService lessonService;

    @GetMapping("/topics/{topicId}/courses/{id}/lessons")
    public List<Lesson> getAllLessons(@PathVariable String topicId, @PathVariable String id) {
        return lessonService.getAllLessons(topicId, id);
    }

    @GetMapping("/topics/{topicId}/courses/{courseId}/lessons/{id}")
    public Lesson getLessonById(@PathVariable String topicId, @PathVariable String courseId,
                                @PathVariable String id) {
        return lessonService.getLessonById(topicId, courseId, id);
    }

    @PostMapping("/topics/{topicId}/courses/{id}/lessons")
    public void createLesson(@PathVariable String topicId, @PathVariable String id,
                             @RequestBody Lesson lesson) {
        lessonService.createLesson(topicId, id, lesson);
    }

    @PutMapping("/topics/{topicId}/courses/{courseId}/lessons/{id}")
    public void updateLesson(@PathVariable String topicId, @PathVariable String courseId,
                             @PathVariable String id, @RequestBody Lesson lesson) {
        lessonService.updateLesson(topicId, courseId, id, lesson);
    }

    @DeleteMapping("/topics/{topicId}/courses/{courseId}/lessons/{id}")
    public void deleteLesson(@PathVariable String topicId, @PathVariable String courseId,
                             @PathVariable String id) {
        lessonService.deleteLesson(topicId, courseId, id);
    }
}
