package fr.lernejo.travelsite;


import java.util.List;

public record PredictionRest(String country, List<Prediction> temperatures) {
}
