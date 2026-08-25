package Application;
import java.util.List;
public interface FacultyService {


	    FacultyDTO createFaculty(FacultyDTO facultyDTO);

	    List<FacultyDTO> getAllFaculty();

	    FacultyDTO getFacultyById(Long id);

	    FacultyDTO updateFaculty(Long id, FacultyDTO facultyDTO);

	    void deleteFaculty(Long id);
	}

