package com.example.courseapidata.lessons;

import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface LessonRepository extends CrudRepository<Lesson, String> {

    List<Lesson> findByCourseId(String courseId);

    Optional<Lesson> findByCourseIdAndId(String courseId, String id);
}
