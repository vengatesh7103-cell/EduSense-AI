package Application;
import java.util.List;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/students")
public class StudentCotroller {


	    private final StudentServices studentService;

	    public StudentCotroller(StudentServices studentService) {
	        this.studentService = studentService;
	    }

	    @PostMapping
	    public StudentDTO createStudent(@RequestBody StudentDTO dto) {
	        return studentService.createStudent(dto);
	    }

	    @GetMapping
	    public List<StudentDTO> getAllStudents() {
	        return studentService.getAllStudents();
	    }

	    @GetMapping("/{id}")
	    public StudentDTO getStudentById(@PathVariable Long id) {
	        return studentService.getStudentById(id);
	    }

	    @PutMapping("/{id}")
	    public StudentDTO updateStudent(@PathVariable Long id,
	                                    @RequestBody StudentDTO dto) {
	        return studentService.updateStudent(id, dto);
	        
	    }
	    @GetMapping("/test")
	    public String test() {
	        return "Student API Working";
	    }

	    @PostMapping("/test")
	    public String postTest() {
	        return "POST Student API Working";
	    }

	    @DeleteMapping("/{id}")
	    public String deleteStudent(@PathVariable Long id) {

	        studentService.deleteStudent(id);

	        return "Student deleted successfully";
	    }
	}

