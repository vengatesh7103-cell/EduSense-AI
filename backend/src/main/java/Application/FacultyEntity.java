package Application;
import jakarta.persistence.*;

@Entity
@Table(name = "faculty")
public class FacultyEntity {


	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    private String facultyName;
	    private String email;
	    private String phone;
	    private String designation;

	    public FacultyEntity() {
	    }

	    public FacultyEntity(Long id, String facultyName, String email, String phone, String designation) {
	        this.id = id;
	        this.facultyName = facultyName;
	        this.email = email;
	        this.phone = phone;
	        this.designation = designation;
	    }

	    public Long getId() {
	        return id;
	    }

	    public void setId(Long id) {
	        this.id = id;
	    }

	    public String getFacultyName() {
	        return facultyName;
	    }

	    public void setFacultyName(String facultyName) {
	        this.facultyName = facultyName;
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

	    public String getDesignation() {
	        return designation;
	    }

	    public void setDesignation(String designation) {
	        this.designation = designation;
	    }
	}

