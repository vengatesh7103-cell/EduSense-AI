package Application;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

@Service
public class StudentServiceimpl implements StudentServices {

	    private final StudentRepo studentRepository;
	    private final DepartmentRepo departmentRepository;
	    private final CourseRepo courseRepository;
	    private final SemesterRepo semesterRepository;

	    public StudentServiceimpl(StudentRepo studentRepository,
	                              DepartmentRepo departmentRepository,
	                              CourseRepo courseRepository,
	                              SemesterRepo semesterRepository) {

	        this.studentRepository = studentRepository;
	        this.departmentRepository = departmentRepository;
	        this.courseRepository = courseRepository;
	        this.semesterRepository = semesterRepository;
	    }

	    @Override
	    public StudentDTO createStudent(StudentDTO dto) {

	        DepartmentEntity department = departmentRepository.findById(dto.getDepartmentId())
	                .orElseThrow(() -> new RuntimeException("Department not found"));

	        CourseEntity course = courseRepository.findById(dto.getCourseId())
	                .orElseThrow(() -> new RuntimeException("Course not found"));

	        SemesterEntity semester = semesterRepository.findById(dto.getSemesterId())
	                .orElseThrow(() -> new RuntimeException("Semester not found"));

	        StudentEntity student = new StudentEntity();

	        student.setRegisterNumber(dto.getRegisterNumber());
	        student.setStudentName(dto.getStudentName());
	        student.setEmail(dto.getEmail());
	        student.setPhone(dto.getPhone());
	        student.setCgpa(dto.getCgpa());

	        student.setDepartment(department);
	        student.setCourse(course);
	        student.setSemester(semester);

	        StudentEntity saved = studentRepository.save(student);

	        return mapToDTO(saved);
	    }

	    @Override
	    public List<StudentDTO> getAllStudents() {

	        return studentRepository.findAll()
	                .stream()
	                .map(this::mapToDTO)
	                .collect(Collectors.toList());
	    }

	    @Override
	    public StudentDTO getStudentById(Long id) {

	        StudentEntity student = studentRepository.findById(id)
	                .orElseThrow(() -> new RuntimeException("Student not found"));

	        return mapToDTO(student);
	    }

	    @Override
	    public StudentDTO updateStudent(Long id, StudentDTO dto) {

	        StudentEntity student = studentRepository.findById(id)
	                .orElseThrow(() -> new RuntimeException("Student not found"));

	        DepartmentEntity department = departmentRepository.findById(dto.getDepartmentId())
	                .orElseThrow(() -> new RuntimeException("Department not found"));

	        CourseEntity course = courseRepository.findById(dto.getCourseId())
	                .orElseThrow(() -> new RuntimeException("Course not found"));

	        SemesterEntity semester = semesterRepository.findById(dto.getSemesterId())
	                .orElseThrow(() -> new RuntimeException("Semester not found"));

	        student.setRegisterNumber(dto.getRegisterNumber());
	        student.setStudentName(dto.getStudentName());
	        student.setEmail(dto.getEmail());
	        student.setPhone(dto.getPhone());
	        student.setCgpa(dto.getCgpa());

	        student.setDepartment(department);
	        student.setCourse(course);
	        student.setSemester(semester);

	        StudentEntity updated = studentRepository.save(student);

	        return mapToDTO(updated);
	    }

	    @Override
	    public void deleteStudent(Long id) {

	        StudentEntity student = studentRepository.findById(id)
	                .orElseThrow(() -> new RuntimeException("Student not found"));

	        studentRepository.delete(student);
	    }

	    private StudentDTO mapToDTO(StudentEntity student) {

	        return new StudentDTO(
	                student.getId(),
	                student.getRegisterNumber(),
	                student.getStudentName(),
	                student.getEmail(),
	                student.getPhone(),
	                student.getCgpa(),
	                student.getDepartment().getId(),
	                student.getCourse().getId(),
	                student.getSemester().getId()
	        );
	    }
	}

