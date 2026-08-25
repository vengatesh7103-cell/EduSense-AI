package Application;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

@Service
public class FacultyServiceImpl implements FacultyService{

	    private final FacultyRepo facultyRepository;

	    public FacultyServiceImpl(FacultyRepo facultyRepository) {
	        this.facultyRepository = facultyRepository;
	    }

	    @Override
	    public FacultyDTO createFaculty(FacultyDTO facultyDTO) {

	        FacultyEntity faculty = new FacultyEntity();
	        faculty.setFacultyName(facultyDTO.getFacultyName());
	        faculty.setEmail(facultyDTO.getEmail());
	        faculty.setPhone(facultyDTO.getPhone());
	        faculty.setDesignation(facultyDTO.getDesignation());

	        FacultyEntity saved = facultyRepository.save(faculty);

	        return mapToDTO(saved);
	    }

	    @Override
	    public List<FacultyDTO> getAllFaculty() {
	        return facultyRepository.findAll()
	                .stream()
	                .map(this::mapToDTO)
	                .collect(Collectors.toList());
	    }

	    @Override
	    public FacultyDTO getFacultyById(Long id) {

	        FacultyEntity faculty = facultyRepository.findById(id)
	                .orElseThrow(() -> new RuntimeException("Faculty not found"));

	        return mapToDTO(faculty);
	    }

	    @Override
	    public FacultyDTO updateFaculty(Long id, FacultyDTO facultyDTO) {

	        FacultyEntity faculty = facultyRepository.findById(id)
	                .orElseThrow(() -> new RuntimeException("Faculty not found"));

	        faculty.setFacultyName(facultyDTO.getFacultyName());
	        faculty.setEmail(facultyDTO.getEmail());
	        faculty.setPhone(facultyDTO.getPhone());
	        faculty.setDesignation(facultyDTO.getDesignation());

	        FacultyEntity updated = facultyRepository.save(faculty);

	        return mapToDTO(updated);
	    }

	    @Override
	    public void deleteFaculty(Long id) {

	        FacultyEntity faculty = facultyRepository.findById(id)
	                .orElseThrow(() -> new RuntimeException("Faculty not found"));

	        facultyRepository.delete(faculty);
	    }

	    private FacultyDTO mapToDTO(FacultyEntity faculty) {

	        return new FacultyDTO(
	                faculty.getId(),
	                faculty.getFacultyName(),
	                faculty.getEmail(),
	                faculty.getPhone(),
	                faculty.getDesignation());
	    }
	}

