package Application;

import java.time.LocalDateTime;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class PredictionService {

    private final RestTemplate restTemplate = new RestTemplate();

    private final PredictionRepository predictionRepository;

    private final String FASTAPI_URL = "http://127.0.0.1:8000/predict";

	private final StudentRepo studentRepo;

    public PredictionService(PredictionRepository predictionRepository, StudentRepo studentRepo) {
        this.predictionRepository = predictionRepository;
        this.studentRepo=studentRepo;
    }

    public PredictionResponse predictGPA(Long studentId,PredictionRequest request) {
    	StudentEntity student = studentRepo.findById(studentId)
                .orElseThrow(() ->
                    new RuntimeException("Student not found"));

        // 1. Send student data to FastAPI
        ResponseEntity<PredictionResponse> response =
                restTemplate.postForEntity(
                        FASTAPI_URL,
                        request,
                        PredictionResponse.class
                );

        // 2. Get prediction response
        PredictionResponse predictionResponse = response.getBody();

        // 3. Create prediction entity
        PredictionEntity prediction = new PredictionEntity();

        prediction.setAttendance(request.getAttendance());
        prediction.setInternalMarks(request.getInternal_Marks());
        prediction.setAssignmentMarks(request.getAssignment_Marks());
        prediction.setPreviousGpa(request.getPrevious_GPA());
        prediction.setStudyHours(request.getStudy_Hours());
        prediction.setBacklogs(request.getBacklogs());

        prediction.setPredictedSemesterGpa(
                predictionResponse.getPredictedSemesterGpa()
        );

        prediction.setPredictedAt(LocalDateTime.now());

        // 4. Save prediction to MySQL
        predictionRepository.save(prediction);

        // 5. Return prediction
        return predictionResponse;
    }
}

