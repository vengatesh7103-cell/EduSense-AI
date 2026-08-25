package Application;
import jakarta.persistence.*;

@Entity
@Table(name = "departments")
public class DepartmentEntity {

	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    @Column(nullable = false)
	    private String name;

	    @Column(nullable = false, unique = true)
	    private String code;

	    private String hod;

	    private String description;

	    public DepartmentEntity() {
	    }

	    public DepartmentEntity(Long id, String name, String code, String hod, String description) {
	        this.id = id;
	        this.name = name;
	        this.code = code;
	        this.hod = hod;
	        this.description = description;
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

	    public String getCode() {
	        return code;
	    }

	    public void setCode(String code) {
	        this.code = code;
	    }

	    public String getHod() {
	        return hod;
	    }

	    public void setHod(String hod) {
	        this.hod = hod;
	    }

	    public String getDescription() {
	        return description;
	    }

	    public void setDescription(String description) {
	        this.description = description;
	    }
	}

