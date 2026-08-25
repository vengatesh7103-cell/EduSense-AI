package Application;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/api/departments")
public class DepartmentContoller {

	    @Autowired
	    private DepartmentService departmentService;

	    @PostMapping
	    public DepartmentDto createDepartment(@RequestBody DepartmentDto departmentDTO) {
	        return departmentService.createDepartment(departmentDTO);
	    }

	    @GetMapping
	    public List<DepartmentDto> getAllDepartments() {
	        return departmentService.getAllDepartments();
	    }

	    @GetMapping("/{id}")
	    public DepartmentDto getDepartmentById(@PathVariable Long id) {
	        return departmentService.getDepartmentById(id);
	    }

	    @PutMapping("/{id}")
	    public DepartmentDto updateDepartment(@PathVariable Long id,
	                                          @RequestBody DepartmentDto departmentDTO) {
	        return departmentService.updateDepartment(id, departmentDTO);
	    }

	    @DeleteMapping("/{id}")
	    public String deleteDepartment(@PathVariable Long id) {
	        departmentService.deleteDepartment(id);
	        return "Department deleted successfully";
	    }
	}

