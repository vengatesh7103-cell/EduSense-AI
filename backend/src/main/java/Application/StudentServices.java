package Application;
import java.util.List;
public interface StudentServices {

	    StudentDTO createStudent(StudentDTO dto);

	    List<StudentDTO> getAllStudents();

	    StudentDTO getStudentById(Long id);

	    StudentDTO updateStudent(Long id, StudentDTO dto);

	    void deleteStudent(Long id);

	}

