package Application;
import java.util.List;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/courses")
public class CourseController {
	

	    private final CourseService courseService;

	    public CourseController(CourseService courseService) {
	        this.courseService = courseService;
	    }

	    @PostMapping
	    public CourseDTO createCourse(@RequestBody CourseDTO courseDTO) {
	        return courseService.createCourse(courseDTO);
	    }

	    @GetMapping
	    public List<CourseDTO> getAllCourses() {
	        return courseService.getAllCourses();
	    }

	    @GetMapping("/{id}")
	    public CourseDTO getCourseById(@PathVariable Long id) {
	        return courseService.getCourseById(id);
	    }

	    @PutMapping("/{id}")
	    public CourseDTO updateCourse(@PathVariable Long id,
	                                  @RequestBody CourseDTO courseDTO) {
	        return courseService.updateCourse(id, courseDTO);
	    }

	    @DeleteMapping("/{id}")
	    public String deleteCourse(@PathVariable Long id) {
	        courseService.deleteCourse(id);
	        return "Course deleted successfully";
	    }
	}

