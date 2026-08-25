package Application;
import java.util.List;
import java.util.stream.Collectors;
import Application.DepartmentDto;
import Application.DepartmentEntity;
import Application.DepartmentRepo;
import org.springframework.stereotype.Service;
@Service
public class DepartmentServiceImpl implements DepartmentService{


	    private final DepartmentRepo departmentRepository;

	    public DepartmentServiceImpl(DepartmentRepo departmentRepository) {
	        this.departmentRepository = departmentRepository;
	    }

	    @Override
	    public DepartmentDto createDepartment(DepartmentDto departmentDTO) {

	        DepartmentEntity department = new DepartmentEntity();

	        department.setName(departmentDTO.getName());
	        department.setCode(departmentDTO.getCode());
	        department.setHod(departmentDTO.getHod());
	        department.setDescription(departmentDTO.getDescription());

	        DepartmentEntity savedDepartment = departmentRepository.save(department);

	        return mapToDTO(savedDepartment);
	    }

	    @Override
	    public List<DepartmentDto> getAllDepartments() {

	        return departmentRepository.findAll()
	                .stream()
	                .map(this::mapToDTO)
	                .collect(Collectors.toList());
	    }

	    @Override
	    public DepartmentDto getDepartmentById(Long id) {

	    	DepartmentEntity department = departmentRepository.findById(id)
	                .orElseThrow(() -> new RuntimeException("Department not found"));

	        return mapToDTO(department);
	    }

	    @Override
	    public DepartmentDto updateDepartment(Long id, DepartmentDto departmentDTO) {

	    	DepartmentEntity department = departmentRepository.findById(id)
	                .orElseThrow(() -> new RuntimeException("Department not found"));

	        department.setName(departmentDTO.getName());
	        department.setCode(departmentDTO.getCode());
	        department.setHod(departmentDTO.getHod());
	        department.setDescription(departmentDTO.getDescription());

	        DepartmentEntity updatedDepartment = departmentRepository.save(department);

	        return mapToDTO(updatedDepartment);
	    }

	    @Override
	    public void deleteDepartment(Long id) {

	    	DepartmentEntity department = departmentRepository.findById(id)
	                .orElseThrow(() -> new RuntimeException("Department not found"));

	        departmentRepository.delete(department);
	    }

	    private DepartmentDto mapToDTO(DepartmentEntity department) {

	        return new DepartmentDto(
	                department.getId(),
	                department.getName(),
	                department.getCode(),
	                department.getHod(),
	                department.getDescription());
	    }
	}

