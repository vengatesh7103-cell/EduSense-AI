package Application;
import java.util.List;

public interface CourseService {
	

	    CourseDTO createCourse(CourseDTO courseDTO);

	    List<CourseDTO> getAllCourses();

	    CourseDTO getCourseById(Long id);

	    CourseDTO updateCourse(Long id, CourseDTO courseDTO);

	    void deleteCourse(Long id);
	}

