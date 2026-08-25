package Application;
import com.fasterxml.jackson.annotation.JsonProperty;
public class PredictionRequest {
	

	@JsonProperty("Attendance")
	private int Attendance;

	@JsonProperty("Internal_Marks")
	private int Internal_Marks;

	@JsonProperty("Assignment_Marks")
	private int Assignment_Marks;

	@JsonProperty("Previous_GPA")
	private double Previous_GPA;

	@JsonProperty("Study_Hours")
	private double Study_Hours;

	@JsonProperty("Backlogs")
	private int Backlogs;

	    public int getAttendance() {
	        return Attendance;
	    }

	    public void setAttendance(int attendance) {
	        Attendance = attendance;
	    }

	    public int getInternal_Marks() {
	        return Internal_Marks;
	    }

	    public void setInternal_Marks(int internal_Marks) {
	        Internal_Marks = internal_Marks;
	    }

	    public int getAssignment_Marks() {
	        return Assignment_Marks;
	    }

	    public void setAssignment_Marks(int assignment_Marks) {
	        Assignment_Marks = assignment_Marks;
	    }

	    public double getPrevious_GPA() {
	        return Previous_GPA;
	    }

	    public void setPrevious_GPA(double previous_GPA) {
	        Previous_GPA = previous_GPA;
	    }

	    public double getStudy_Hours() {
	        return Study_Hours;
	    }

	    public void setStudy_Hours(double study_Hours) {
	        Study_Hours = study_Hours;
	    }

	    public int getBacklogs() {
	        return Backlogs;
	    }

	    public void setBacklogs(int backlogs) {
	        Backlogs = backlogs;
	    }
	}

