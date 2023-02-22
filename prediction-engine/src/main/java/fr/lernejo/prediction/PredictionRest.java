package fr.lernejo.prediction;


import java.util.List;

public record PredictionRest(String country, List<Prediction> temperatures) {
}
