package Application;

public class CourseDTO {

	    private Long id;
	    private String courseName;
	    private int duration;
	    private Long departmentId;

	    public CourseDTO() {
	    }

	    public CourseDTO(Long id, String courseName, int duration, Long departmentId) {
	        this.id = id;
	        this.courseName = courseName;
	        this.duration = duration;
	        this.departmentId = departmentId;
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

	    public Long getDepartmentId() {
	        return departmentId;
	    }

	    public void setDepartmentId(Long departmentId) {
	        this.departmentId = departmentId;
	    }
	}
