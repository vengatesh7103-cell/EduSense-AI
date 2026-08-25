package Application;
import jakarta.persistence.*;

@Entity
@Table(name = "students")
public class StudentEntity {


	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    private String registerNumber;
	    private String studentName;
	    private String email;
	    private String phone;
	    private double cgpa;

	    @ManyToOne
	    @JoinColumn(name = "department_id")
	    private DepartmentEntity department;

	    @ManyToOne
	    @JoinColumn(name = "course_id")
	    private CourseEntity course;

	    @ManyToOne
	    @JoinColumn(name = "semester_id")
	    private SemesterEntity semester;

	    public StudentEntity() {}

	    public Long getId() {
	        return id;
	    }

	    public void setId(Long id) {
	        this.id = id;
	    }

	    public String getRegisterNumber() {
	        return registerNumber;
	    }

	    public void setRegisterNumber(String registerNumber) {
	        this.registerNumber = registerNumber;
	    }

	    public String getStudentName() {
	        return studentName;
	    }

	    public void setStudentName(String studentName) {
	        this.studentName = studentName;
	    }

	    public String getEmail() {
	        return email;
	    }

	    public void setEmail(String email) {
	        this.email = email;
	    }

	    public String getPhone() {
	        return phone;
	    }

	    public void setPhone(String phone) {
	        this.phone = phone;
	    }

	    public double getCgpa() {
	        return cgpa;
	    }

	    public void setCgpa(double cgpa) {
	        this.cgpa = cgpa;
	    }

	    public DepartmentEntity getDepartment() {
	        return department;
	    }

	    public void setDepartment(DepartmentEntity department) {
	        this.department = department;
	    }

	    public CourseEntity getCourse() {
	        return course;
	    }

	    public void setCourse(CourseEntity course) {
	    	
	        this.course = course;
	    }

	    public SemesterEntity getSemester() {
	        return semester;
	    }

	    public void setSemester(SemesterEntity semester) {
	        this.semester = semester;
	    }
	}

