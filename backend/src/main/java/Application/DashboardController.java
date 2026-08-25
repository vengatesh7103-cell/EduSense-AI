package Application;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import Application.DashboardResponse;
import Application.DashboardServiceImpl;
import Application.DashboardService;


@RestController
@RequestMapping("/dashboard")
@CrossOrigin(origins = "http://localhost:5173")
public class DashboardController {

    @Autowired
    private DashboardService dashboardService;

    @GetMapping("/admin")
    public DashboardResponse getAdminDashboard() {
        return dashboardService.getAdminDashboard();
    }

}