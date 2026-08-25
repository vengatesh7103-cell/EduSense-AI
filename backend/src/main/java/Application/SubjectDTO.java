package Application;

public class SubjectDTO {


	    private Long id;
	    private String subjectCode;
	    private String subjectName;
	    private Integer credits;

	    private Long departmentId;
	    private Long semesterId;
	    private Long facultyId;

	    public SubjectDTO() {
	    }

	    public SubjectDTO(Long id,
	                      String subjectCode,
	                      String subjectName,
	                      Integer credits,
	                      Long departmentId,
	                      Long semesterId,
	                      Long facultyId) {

	        this.id = id;
	        this.subjectCode = subjectCode;
	        this.subjectName = subjectName;
	        this.credits = credits;
	        this.departmentId = departmentId;
	        this.semesterId = semesterId;
	        this.facultyId = facultyId;
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

	    public Long getDepartmentId() {
	        return departmentId;
	    }

	    public void setDepartmentId(Long departmentId) {
	        this.departmentId = departmentId;
	    }

	    public Long getSemesterId() {
	        return semesterId;
	    }

	    public void setSemesterId(Long semesterId) {
	        this.semesterId = semesterId;
	    }

	    public Long getFacultyId() {
	        return facultyId;
	    }

	    public void setFacultyId(Long facultyId) {
	        this.facultyId = facultyId;
	    }
	}

