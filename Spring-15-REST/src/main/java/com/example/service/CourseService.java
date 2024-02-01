package com.example.service;

import com.example.dto.CourseDto;
import org.springframework.stereotype.Service;

import java.util.List;
public interface CourseService {
    CourseDto createCourse(CourseDto courseDto);
    CourseDto getCourseById(Long courseId);
    List<CourseDto> getCourseByCategory(String category);
    List<CourseDto> getCourses();
    void updateCourse(Long courseId,CourseDto courseDto);
    void deleteCourseById(Long courseId);
    void deleteCourses();
}
