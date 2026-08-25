package Application;
import java.util.List;

public interface SemesterServicde {



	    SemseterDTO createSemester(SemseterDTO semesterDTO);

	    List<SemseterDTO> getAllSemesters();

	    SemseterDTO getSemesterById(Long id);

	    SemseterDTO updateSemester(Long id, SemseterDTO semesterDTO);

	    void deleteSemester(Long id);
	}

