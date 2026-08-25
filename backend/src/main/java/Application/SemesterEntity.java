package Application;
import jakarta.persistence.*;

@Entity
@Table(name = "semesters")
public class SemesterEntity {




	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    private int semesterNumber;

	    private String academicYear;

	    @ManyToOne
	    @JoinColumn(name = "course_id")
	    private CourseEntity course;

	    public SemesterEntity() {
	    }

	    public SemesterEntity(Long id, int semesterNumber, String academicYear, CourseEntity course) {
	        this.id = id;
	        this.semesterNumber = semesterNumber;
	        this.academicYear = academicYear;
	        this.course = course;
	    }

	    public Long getId() {
	        return id;
	    }

	    public void setId(Long id) {
	        this.id = id;
	    }

	    public int getSemesterNumber() {
	        return semesterNumber;
	    }

	    public void setSemesterNumber(int semesterNumber) {
	        this.semesterNumber = semesterNumber;
	    }

	    public String getAcademicYear() {
	        return academicYear;
	    }

	    public void setAcademicYear(String academicYear) {
	        this.academicYear = academicYear;
	    }

	    public CourseEntity getCourse() {
	        return course;
	    }

	    public void setCourse(CourseEntity course) {
	        this.course = course;
	    }
	}

