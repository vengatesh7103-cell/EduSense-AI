package Application;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

@Service
public class SubjectServiceImpl implements SubjectService {


	    private final SubjectRepo subjectRepository;
	    private final DepartmentRepo departmentRepository;
	    private final SemesterRepo semesterRepository;
	    private final FacultyRepo facultyRepository;

	    public SubjectServiceImpl(
	            SubjectRepo subjectRepository,
	            DepartmentRepo departmentRepository,
	            SemesterRepo semesterRepository,
	            FacultyRepo facultyRepository) {

	        this.subjectRepository = subjectRepository;
	        this.departmentRepository = departmentRepository;
	        this.semesterRepository = semesterRepository;
	        this.facultyRepository = facultyRepository;
	    }

	    @Override
	    public SubjectDTO createSubject(SubjectDTO dto) {

	        DepartmentEntity department = departmentRepository.findById(dto.getDepartmentId())
	                .orElseThrow(() -> new RuntimeException("Department not found"));

	        SemesterEntity semester = semesterRepository.findById(dto.getSemesterId())
	                .orElseThrow(() -> new RuntimeException("Semester not found"));

	        FacultyEntity faculty = facultyRepository.findById(dto.getFacultyId())
	                .orElseThrow(() -> new RuntimeException("Faculty not found"));

	        SubjectEntity subject = new SubjectEntity();

	        subject.setSubjectCode(dto.getSubjectCode());
	        subject.setSubjectName(dto.getSubjectName());
	        subject.setCredits(dto.getCredits());

	        subject.setDepartment(department);
	        subject.setSemester(semester);
	        subject.setFaculty(faculty);

	        SubjectEntity saved = subjectRepository.save(subject);

	        return mapToDTO(saved);
	    }

	    @Override
	    public List<SubjectDTO> getAllSubjects() {

	        return subjectRepository.findAll()
	                .stream()
	                .map(this::mapToDTO)
	                .collect(Collectors.toList());
	    }

	    @Override
	    public SubjectDTO getSubjectById(Long id) {

	        SubjectEntity subject = subjectRepository.findById(id)
	                .orElseThrow(() -> new RuntimeException("Subject not found"));

	        return mapToDTO(subject);
	    }

	    @Override
	    public SubjectDTO updateSubject(Long id, SubjectDTO dto) {

	        SubjectEntity subject = subjectRepository.findById(id)
	                .orElseThrow(() -> new RuntimeException("Subject not found"));

	        DepartmentEntity department = departmentRepository.findById(dto.getDepartmentId())
	                .orElseThrow(() -> new RuntimeException("Department not found"));

	        SemesterEntity semester = semesterRepository.findById(dto.getSemesterId())
	                .orElseThrow(() -> new RuntimeException("Semester not found"));

	        FacultyEntity faculty = facultyRepository.findById(dto.getFacultyId())
	                .orElseThrow(() -> new RuntimeException("Faculty not found"));

	        subject.setSubjectCode(dto.getSubjectCode());
	        subject.setSubjectName(dto.getSubjectName());
	        subject.setCredits(dto.getCredits());

	        subject.setDepartment(department);
	        subject.setSemester(semester);
	        subject.setFaculty(faculty);

	        SubjectEntity updated = subjectRepository.save(subject);

	        return mapToDTO(updated);
	    }

	    @Override
	    public void deleteSubject(Long id) {

	        SubjectEntity subject = subjectRepository.findById(id)
	                .orElseThrow(() -> new RuntimeException("Subject not found"));

	        subjectRepository.delete(subject);
	    }

	    private SubjectDTO mapToDTO(SubjectEntity subject) {

	        return new SubjectDTO(
	                subject.getId(),
	                subject.getSubjectCode(),
	                subject.getSubjectName(),
	                subject.getCredits(),
	                subject.getDepartment().getId(),
	                subject.getSemester().getId(),
	                subject.getFaculty().getId()
	        );
	    }
	}

