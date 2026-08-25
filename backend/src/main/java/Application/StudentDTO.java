package Application;

public class StudentDTO {


	    private Long id;
	    private String registerNumber;
	    private String studentName;
	    private String email;
	    private String phone;
	    private double cgpa;

	    private Long departmentId;
	    private Long courseId;
	    private Long semesterId;

	    public StudentDTO() {}

	    public StudentDTO(Long id, String registerNumber, String studentName,
	                      String email, String phone, double cgpa,
	                      Long departmentId, Long courseId, Long semesterId) {

	        this.id = id;
	        this.registerNumber = registerNumber;
	        this.studentName = studentName;
	        this.email = email;
	        this.phone = phone;
	        this.cgpa = cgpa;
	        this.departmentId = departmentId;
	        this.courseId = courseId;
	        this.semesterId = semesterId;
	    }

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

		public Long getDepartmentId() {
			return departmentId;
		}

		public void setDepartmentId(Long departmentId) {
			this.departmentId = departmentId;
		}

		public Long getCourseId() {
			return courseId;
		}

		public void setCourseId(Long courseId) {
			this.courseId = courseId;
		}

		public Long getSemesterId() {
			return semesterId;
		}

		public void setSemesterId(Long semesterId) {
			this.semesterId = semesterId;
		}
		

	}

