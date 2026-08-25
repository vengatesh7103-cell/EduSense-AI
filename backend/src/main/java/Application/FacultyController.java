package Application;
import java.util.List;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/faculty")
public class FacultyController {
	

	    private final FacultyService facultyService;

	    public FacultyController(FacultyService facultyService) {
	        this.facultyService = facultyService;
	    }

	    @PostMapping
	    public FacultyDTO createFaculty(@RequestBody FacultyDTO facultyDTO) {
	        return facultyService.createFaculty(facultyDTO);
	    }

	    @GetMapping
	    public List<FacultyDTO> getAllFaculty() {
	        return facultyService.getAllFaculty();
	    }

	    @GetMapping("/{id}")
	    public FacultyDTO getFacultyById(@PathVariable Long id) {
	        return facultyService.getFacultyById(id);
	    }

	    @PutMapping("/{id}")
	    public FacultyDTO updateFaculty(@PathVariable Long id,
	                                    @RequestBody FacultyDTO facultyDTO) {
	        return facultyService.updateFaculty(id, facultyDTO);
	    }

	    @DeleteMapping("/{id}")
	    public String deleteFaculty(@PathVariable Long id) {
	        facultyService.deleteFaculty(id);
	        return "Faculty deleted successfully";
	    }
	}

