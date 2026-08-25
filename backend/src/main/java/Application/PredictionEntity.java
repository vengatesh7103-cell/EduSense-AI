package Application;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "predictions")
public class PredictionEntity {


	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    private int attendance;
	    private int internalMarks;
	    private int assignmentMarks;
	    private double previousGpa;
	    private double studyHours;
	    private int backlogs;

	    private double predictedSemesterGpa;

	    private LocalDateTime predictedAt;

	    @ManyToOne
	    @JoinColumn(name = "student_id")
	    private StudentEntity student;

	    public PredictionEntity() {
	    }

	    public Long getId() {
	        return id;
	    }

	    public void setId(Long id) {
	        this.id = id;
	    }

	    public int getAttendance() {
	        return attendance;
	    }

	    public void setAttendance(int attendance) {
	        this.attendance = attendance;
	    }

	    public int getInternalMarks() {
	        return internalMarks;
	    }

	    public void setInternalMarks(int internalMarks) {
	        this.internalMarks = internalMarks;
	    }

	    public int getAssignmentMarks() {
	        return assignmentMarks;
	    }

	    public void setAssignmentMarks(int assignmentMarks) {
	        this.assignmentMarks = assignmentMarks;
	    }

	    public double getPreviousGpa() {
	        return previousGpa;
	    }

	    public void setPreviousGpa(double previousGpa) {
	        this.previousGpa = previousGpa;
	    }

	    public double getStudyHours() {
	        return studyHours;
	    }

	    public void setStudyHours(double studyHours) {
	        this.studyHours = studyHours;
	    }

	    public int getBacklogs() {
	        return backlogs;
	    }

	    public void setBacklogs(int backlogs) {
	        this.backlogs = backlogs;
	    }

	    public double getPredictedSemesterGpa() {
	        return predictedSemesterGpa;
	    }

	    public void setPredictedSemesterGpa(double predictedSemesterGpa) {
	        this.predictedSemesterGpa = predictedSemesterGpa;
	    }

	    public LocalDateTime getPredictedAt() {
	        return predictedAt;
	    }

	    public void setPredictedAt(LocalDateTime predictedAt) {
	        this.predictedAt = predictedAt;
	    }

	    public StudentEntity getStudent() {
	        return student;
	    }

	    public void setStudent(StudentEntity student) {
	        this.student = student;
	    }
	}

