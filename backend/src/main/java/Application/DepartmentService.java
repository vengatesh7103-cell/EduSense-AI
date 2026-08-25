package Application;
import java.util.List;

public interface DepartmentService {


	    DepartmentDto createDepartment(DepartmentDto departmentDTO);

	    List<DepartmentDto> getAllDepartments();

	    DepartmentDto getDepartmentById(Long id);

	    DepartmentDto updateDepartment(Long id, DepartmentDto departmentDTO);

	    void deleteDepartment(Long id);
	}
