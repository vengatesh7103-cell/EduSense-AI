package Application;
import jakarta.persistence.*;


@Entity
public class Student {
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    private String name;

	    private int attendance;

	    private double internalMarks;

	    private double cgpa;

	    public Student() {
	    }

	    public Student(Long id, String name, int attendance, double internalMarks, double cgpa) {
	        this.id = id;
	        this.name = name;
	        this.attendance = attendance;
	        this.internalMarks = internalMarks;
	        this.cgpa = cgpa;
	    }

	    public Long getId() {
	        return id;
	    }

	    public void setId(Long id) {
	        this.id = id;
	    }

	    public String getName() {
	        return name;
	    }

	    public void setName(String name) {
	        this.name = name;
	    }

	    public int getAttendance() {
	        return attendance;
	    }

	    public void setAttendance(int attendance) {
	        this.attendance = attendance;
	    }

	    public double getInternalMarks() {
	        return internalMarks;
	    }

	    public void setInternalMarks(double internalMarks) {
	        this.internalMarks = internalMarks;
	    }

	    public double getCgpa() {
	        return cgpa;
	    }

	    public void setCgpa(double cgpa) {
	        this.cgpa = cgpa;
	    }
	}

