package Application;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import Application.DashboardResponse;
import Application.CourseRepo;
import Application.DepartmentRepo;
import Application.FacultyRepo;
import Application.SemesterRepo;
import Application.StudentRepo;
import Application.SubjectRepo;
@Service
public class DashboardServiceImpl implements DashboardService {

    @Autowired
    private StudentRepo studentRepository;

    @Autowired
    private FacultyRepo facultyRepository;

    @Autowired
    private DepartmentRepo departmentRepository;

    @Autowired
    private CourseRepo courseRepository;

    @Autowired
    private SemesterRepo semesterRepository;

    @Autowired
    private SubjectRepo subjectRepository;

    @Override
    public DashboardResponse getAdminDashboard() {

        DashboardResponse response = new DashboardResponse();

        response.setTotalStudents(studentRepository.count());
        response.setTotalFaculty(facultyRepository.count());
        response.setTotalDepartments(departmentRepository.count());
        response.setTotalCourses(courseRepository.count());
        response.setTotalSemesters(semesterRepository.count());
        response.setTotalSubjects(subjectRepository.count());

        return response;
    }
}
