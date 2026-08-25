package Application;

public class SemseterDTO {


	    private Long id;
	    private int semesterNumber;
	    private String academicYear;
	    private Long courseId;

	    public SemseterDTO() {
	    }

	    public SemseterDTO(Long id, int semesterNumber, String academicYear, Long courseId) {
	        this.id = id;
	        this.semesterNumber = semesterNumber;
	        this.academicYear = academicYear;
	        this.courseId = courseId;
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

	    public Long getCourseId() {
	        return courseId;
	    }

	    public void setCourseId(Long courseId) {
	        this.courseId = courseId;
	    }
	}
