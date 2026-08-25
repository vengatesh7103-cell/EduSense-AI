package Application;
import jakarta.persistence.*;

@Entity
@Table(name = "courses")

public class CourseEntity {

	 

	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    private String courseName;

	    private int duration;

	    @ManyToOne
	    @JoinColumn(name = "department_id")
	    private DepartmentEntity department;

	    public CourseEntity() {
	    }

	    public CourseEntity(Long id, String courseName, int duration, DepartmentEntity department) {
	        this.id = id;
	        this.courseName = courseName;
	        this.duration = duration;
	        this.department = department;
	    }

	    public Long getId() {
	        return id;
	    }

	    public void setId(Long id) {
	        this.id = id;
	    }

	    public String getCourseName() {
	        return courseName;
	    }

	    public void setCourseName(String courseName) {
	        this.courseName = courseName;
	    }

	    public int getDuration() {
	        return duration;
	    }

	    public void setDuration(int duration) {
	        this.duration = duration;
	    }

	    public DepartmentEntity getDepartment() {
	        return department;
	    }

	    public void setDepartment(DepartmentEntity department) {
	        this.department = department;
	    }
	}

