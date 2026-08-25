package Application;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/prediction")
public class PredictionController {

    private final PredictionService predictionService;

    public PredictionController(PredictionService predictionService) {
        this.predictionService = predictionService;
    }

    @PostMapping("/predict/{studentId}")
    public PredictionResponse predict(
            @PathVariable Long studentId,
            @RequestBody PredictionRequest request) {

        return predictionService.predictGPA(
                studentId,
                request
        );
    }
}