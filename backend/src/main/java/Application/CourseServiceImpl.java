package Application;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

@Service
public class CourseServiceImpl implements CourseService{

	


	    private final CourseRepo courseRepository;
	    private final DepartmentRepo departmentRepository;

	    public CourseServiceImpl(CourseRepo courseRepository,
	                             DepartmentRepo departmentRepository) {
	        this.courseRepository = courseRepository;
	        this.departmentRepository = departmentRepository;
	    }

	    @Override
	    public CourseDTO createCourse(CourseDTO courseDTO) {

	        DepartmentEntity department = departmentRepository.findById(courseDTO.getDepartmentId())
	                .orElseThrow(() -> new RuntimeException("Department not found"));

	        CourseEntity course = new CourseEntity();
	        course.setCourseName(courseDTO.getCourseName());
	        course.setDuration(courseDTO.getDuration());
	        course.setDepartment(department);

	        CourseEntity saved = courseRepository.save(course);

	        return mapToDTO(saved);
	    }

	    @Override
	    public List<CourseDTO> getAllCourses() {
	        return courseRepository.findAll()
	                .stream()
	                .map(this::mapToDTO)
	                .collect(Collectors.toList());
	    }

	    @Override
	    public CourseDTO getCourseById(Long id) {

	        CourseEntity course = courseRepository.findById(id)
	                .orElseThrow(() -> new RuntimeException("Course not found"));

	        return mapToDTO(course);
	    }

	    @Override
	    public CourseDTO updateCourse(Long id, CourseDTO courseDTO) {

	        CourseEntity course = courseRepository.findById(id)
	                .orElseThrow(() -> new RuntimeException("Course not found"));

	        DepartmentEntity department = departmentRepository.findById(courseDTO.getDepartmentId())
	                .orElseThrow(() -> new RuntimeException("Department not found"));

	        course.setCourseName(courseDTO.getCourseName());
	        course.setDuration(courseDTO.getDuration());
	        course.setDepartment(department);

	        CourseEntity updated = courseRepository.save(course);

	        return mapToDTO(updated);
	    }

	    @Override
	    public void deleteCourse(Long id) {

	        CourseEntity course = courseRepository.findById(id)
	                .orElseThrow(() -> new RuntimeException("Course not found"));

	        courseRepository.delete(course);
	    }

	    private CourseDTO mapToDTO(CourseEntity course) {

	        return new CourseDTO(
	                course.getId(),
	                course.getCourseName(),
	                course.getDuration(),
	                course.getDepartment().getId());
	    }
	}

