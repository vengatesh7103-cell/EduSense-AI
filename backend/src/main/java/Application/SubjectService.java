package Application;
import java.util.List;

public interface SubjectService {
	

	    SubjectDTO createSubject(SubjectDTO dto);

	    List<SubjectDTO> getAllSubjects();

	    SubjectDTO getSubjectById(Long id);

	    SubjectDTO updateSubject(Long id, SubjectDTO dto);

	    void deleteSubject(Long id);
	}

