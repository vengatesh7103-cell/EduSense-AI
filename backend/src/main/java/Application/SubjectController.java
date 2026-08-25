package Application;

import java.util.List;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/subjects")
public class SubjectController {


	    private final SubjectService subjectService;

	    public SubjectController(SubjectService subjectService) {
	        this.subjectService = subjectService;
	    }

	    @PostMapping
	    public SubjectDTO createSubject(@RequestBody SubjectDTO dto) {
	        return subjectService.createSubject(dto);
	    }

	    @GetMapping
	    public List<SubjectDTO> getAllSubjects() {
	        return subjectService.getAllSubjects();
	    }

	    @GetMapping("/{id}")
	    public SubjectDTO getSubjectById(@PathVariable Long id) {
	        return subjectService.getSubjectById(id);
	    }

	    @PutMapping("/{id}")
	    public SubjectDTO updateSubject(@PathVariable Long id,
	                                    @RequestBody SubjectDTO dto) {
	        return subjectService.updateSubject(id, dto);
	    }

	    @DeleteMapping("/{id}")
	    public void deleteSubject(@PathVariable Long id) {
	        subjectService.deleteSubject(id);
	    }
	}

