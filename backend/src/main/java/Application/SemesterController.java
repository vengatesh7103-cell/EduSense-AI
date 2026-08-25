package Application;
import java.util.List;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/semesters")
public class SemesterController {
	

	    private final SemesterServicde semesterService;

	    public SemesterController(SemesterServicde semesterService) {
	        this.semesterService = semesterService;
	    }

	    @PostMapping
	    public SemseterDTO createSemester(@RequestBody SemseterDTO semesterDTO) {
	        return semesterService.createSemester(semesterDTO);
	    }

	    @GetMapping
	    public List<SemseterDTO> getAllSemesters() {
	        return semesterService.getAllSemesters();
	    }

	    @GetMapping("/{id}")
	    public SemseterDTO getSemesterById(@PathVariable Long id) {
	        return semesterService.getSemesterById(id);
	    }

	    @PutMapping("/{id}")
	    public SemseterDTO updateSemester(@PathVariable Long id,
	                                      @RequestBody SemseterDTO semesterDTO) {
	        return semesterService.updateSemester(id, semesterDTO);
	    }

	    @DeleteMapping("/{id}")
	    public String deleteSemester(@PathVariable Long id) {
	        semesterService.deleteSemester(id);
	        return "Semester deleted successfully";
	    }
	}

