package Application;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PredictionResponse {

    @JsonProperty("predicted_semester_gpa")
    private double predictedSemesterGpa;

    public PredictionResponse() {
    }

    public double getPredictedSemesterGpa() {
        return predictedSemesterGpa;
    }

    public void setPredictedSemesterGpa(double predictedSemesterGpa) {
        this.predictedSemesterGpa = predictedSemesterGpa;
    }
}