package Application;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;


@Service
public  class SemesterServiceImpl implements SemesterServicde{
	
	    private final SemesterRepo semesterRepository;
	    private final CourseRepo courseRepository;

	    public SemesterServiceImpl(SemesterRepo semesterRepository,
	                               CourseRepo courseRepository) {
	        this.semesterRepository = semesterRepository;
	        this.courseRepository = courseRepository;
	    }

	    @Override
	    public SemseterDTO createSemester(SemseterDTO semesterDTO) {

	        System.out.println("Semester Number: " + semesterDTO.getSemesterNumber());
	        System.out.println("Academic Year: " + semesterDTO.getAcademicYear());
	        System.out.println("Course ID: " + semesterDTO.getCourseId());

	        CourseEntity course = courseRepository.findById(semesterDTO.getCourseId())
	                .orElseThrow(() -> new RuntimeException("Course not found"));

	        SemesterEntity semester = new SemesterEntity();
	        semester.setSemesterNumber(semesterDTO.getSemesterNumber());
	        semester.setAcademicYear(semesterDTO.getAcademicYear());
	        semester.setCourse(course);

	        SemesterEntity saved = semesterRepository.save(semester);

	        return mapToDTO(saved);
	    }

	    @Override
	    public List<SemseterDTO> getAllSemesters() {

	        return semesterRepository.findAll()
	                .stream()
	                .map(this::mapToDTO)
	                .collect(Collectors.toList());
	    }

	    @Override
	    public SemseterDTO getSemesterById(Long id) {

	    	SemesterEntity semester = semesterRepository.findById(id)
	                .orElseThrow(() -> new RuntimeException("Semester not found"));

	        return mapToDTO(semester);
	    }

	    @Override
	    public SemseterDTO updateSemester(Long id, SemseterDTO semesterDTO) {

	    	SemesterEntity semester = semesterRepository.findById(id)
	                .orElseThrow(() -> new RuntimeException("Semester not found"));

	        CourseEntity course = courseRepository.findById(semesterDTO.getCourseId())
	                .orElseThrow(() -> new RuntimeException("Course not found"));

	        semester.setSemesterNumber(semesterDTO.getSemesterNumber());
	        semester.setAcademicYear(semesterDTO.getAcademicYear());
	        semester.setCourse(course);

	        SemesterEntity updated = semesterRepository.save(semester);

	        return mapToDTO(updated);
	    }
	    

	    @Override
	    public void deleteSemester(Long id) {

	    	SemesterEntity semester = semesterRepository.findById(id)
	                .orElseThrow(() -> new RuntimeException("Semester not found"));

	        semesterRepository.delete(semester);
	    }

	    private SemseterDTO mapToDTO(SemesterEntity semester) {

	        return new SemseterDTO(
	                semester.getId(),
	                semester.getSemesterNumber(),
	                semester.getAcademicYear(),
	                semester.getCourse().getId());
	    }
	}

