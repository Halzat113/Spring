package com.example.service.serviceImpl;

import com.example.dto.CourseDto;
import com.example.entity.Course;
import com.example.repository.CourseRepository;
import com.example.service.CourseService;
import com.example.util.MapperUtil;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CourseServiceImpl implements CourseService {
    private final CourseRepository courseRepository;
    private final MapperUtil mapperUtil;

    public CourseServiceImpl(CourseRepository courseRepository, MapperUtil mapperUtil) {
        this.courseRepository = courseRepository;
        this.mapperUtil = mapperUtil;
    }

    @Override
    public CourseDto createCourse(CourseDto courseDto) {
      courseRepository.save(mapperUtil.convert(courseDto,new Course()));
      return courseDto;
    }

    @Override
    public CourseDto getCourseById(Long courseId) {
       Course course = courseRepository.findById(courseId).get();
       return mapperUtil.convert(course,new CourseDto());
    }

    @Override
    public List<CourseDto> getCourseByCategory(String category) {
      return courseRepository.findByCategory(category).stream()
              .map(c->mapperUtil.convert(c,new CourseDto())).collect(Collectors.toList());
    }

    @Override
    public List<CourseDto> getCourses() {
       return courseRepository.findAll().stream().map(c->mapperUtil.convert(c,new CourseDto())).collect(Collectors.toList());
    }

    @Override
    public void updateCourse(Long courseId, CourseDto courseDto) {
        Course course = mapperUtil.convert(courseDto,new Course());
        courseRepository.findById(courseId).ifPresent(c->{
            c.setName(course.getName());
            c.setDescription(course.getDescription());
            c.setCategory(course.getCategory());
            c.setRating(course.getRating());
            courseRepository.save(c);
        }
        );
    }

    @Override
    public void deleteCourseById(Long courseId) {
        courseRepository.deleteById(courseId);
    }

    @Override
    public void deleteCourses() {
        courseRepository.deleteAll();
    }
}
