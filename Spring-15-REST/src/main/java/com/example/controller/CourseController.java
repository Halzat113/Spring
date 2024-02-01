package com.example.controller;

import com.example.dto.CourseDto;
import com.example.entity.Course;
import com.example.service.CourseService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController //@Controller + @ResponseBody
@RequestMapping("/courses/api/v1")
public class CourseController {
    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping
    public List<CourseDto> getAllCourses(){
        return courseService.getCourses();
    }
    @GetMapping("{id}")
    public CourseDto getCourseById(@PathVariable("id") Long courseId){
        return courseService.getCourseById(courseId);
    }

    @GetMapping("/category/{name}")
    public List<CourseDto> getCourseByCategory(@PathVariable("name") String category){
        return courseService.getCourseByCategory(category);
    }
    @PostMapping
    public CourseDto createCourse(@RequestBody CourseDto course){
        return courseService.createCourse(course);
    }

    @PutMapping("{id}")
    public void updateCourse(@PathVariable("id")Long courseId,@RequestBody CourseDto courseDto){
        courseService.updateCourse(courseId,courseDto);
    }

    @DeleteMapping("{id}")
    public void deleteCourseById(@PathVariable("id")Long courseId){
        courseService.deleteCourseById(courseId);
    }

    @DeleteMapping
    public void deleteCourses(){
        courseService.deleteCourses();
    }
}
