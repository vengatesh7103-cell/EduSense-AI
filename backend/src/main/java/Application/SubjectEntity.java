package Application;
import jakarta.persistence.*;

@Entity
@Table(name = "subjects")
public class SubjectEntity {

	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    private String subjectCode;
	    private String subjectName;
	    private Integer credits;

	    @ManyToOne
	    @JoinColumn(name = "department_id")
	    private DepartmentEntity department;

	    @ManyToOne
	    @JoinColumn(name = "semester_id")
	    private SemesterEntity semester;

	    @ManyToOne
	    @JoinColumn(name = "faculty_id")
	    private FacultyEntity faculty;

	    public SubjectEntity() {
	    }

	    public Long getId() {
	        return id;
	    }

	    public void setId(Long id) {
	        this.id = id;
	    }

	    public String getSubjectCode() {
	        return subjectCode;
	    }

	    public void setSubjectCode(String subjectCode) {
	        this.subjectCode = subjectCode;
	    }

	    public String getSubjectName() {
	        return subjectName;
	    }

	    public void setSubjectName(String subjectName) {
	        this.subjectName = subjectName;
	    }

	    public Integer getCredits() {
	        return credits;
	    }

	    public void setCredits(Integer credits) {
	        this.credits = credits;
	    }

	    public DepartmentEntity getDepartment() {
	        return department;
	    }

	    public void setDepartment(DepartmentEntity department) {
	        this.department = department;
	    }

	    public SemesterEntity getSemester() {
	        return semester;
	    }

	    public void setSemester(SemesterEntity semester) {
	        this.semester = semester;
	    }

	    public FacultyEntity getFaculty() {
	        return faculty;
	    }

	    public void setFaculty(FacultyEntity faculty) {
	        this.faculty = faculty;
	    }
	}

