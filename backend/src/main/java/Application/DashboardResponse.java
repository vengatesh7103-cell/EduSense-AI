package Application;

public class DashboardResponse {


	    private long totalStudents;
	    private long totalFaculty;
	    private long totalDepartments;
	    private long totalCourses;
	    private long totalSemesters;
	    private long totalSubjects;
	    
	    public DashboardResponse() {
	    }
		public DashboardResponse(long totalStudents, long totalFaculty, long totalDepartments, long totalCourses,
				long totalSemesters, long totalSubjects) {
			this.totalStudents = totalStudents;
			this.totalFaculty = totalFaculty;
			this.totalDepartments = totalDepartments;
			this.totalCourses = totalCourses;
			this.totalSemesters = totalSemesters;
			this.totalSubjects = totalSubjects;
		}
		public long getTotalStudents() {
			return totalStudents;
		}
		public void setTotalStudents(long totalStudents) {
			this.totalStudents = totalStudents;
		}
		public long getTotalFaculty() {
			return totalFaculty;
		}
		public void setTotalFaculty(long totalFaculty) {
			this.totalFaculty = totalFaculty;
		}
		public long getTotalDepartments() {
			return totalDepartments;
		}
		public void setTotalDepartments(long totalDepartments) {
			this.totalDepartments = totalDepartments;
		}
		public long getTotalCourses() {
			return totalCourses;
		}
		public void setTotalCourses(long totalCourses) {
			this.totalCourses = totalCourses;
		}
		public long getTotalSemesters() {
			return totalSemesters;
		}
		public void setTotalSemesters(long totalSemesters) {
			this.totalSemesters = totalSemesters;
		}
		public long getTotalSubjects() {
			return totalSubjects;
		}
		public void setTotalSubjects(long totalSubjects) {
			this.totalSubjects = totalSubjects;
		}

	    
	
}
