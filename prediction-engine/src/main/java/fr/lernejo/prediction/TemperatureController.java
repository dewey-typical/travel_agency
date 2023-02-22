package fr.lernejo.prediction;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.*;

@RestController
@RequestMapping(value = "temperature")
public class TemperatureController {
    TemperatureService temperatureService;
    private final long MILLIS_IN_A_DAY = 1000 * 60 * 60 * 24;
    private final SimpleDateFormat DateFormat = new SimpleDateFormat("yyyy-MM-dd");
    public TemperatureController(TemperatureService temperatureService) {
        this.temperatureService = temperatureService;
    }

    @GetMapping
    public PredictionRest GetTemperature(@RequestParam String country) {
        Date today = new Date();
        Date yesterday = new Date(today.getTime() - MILLIS_IN_A_DAY);
        Date twoDayBefore = new Date(today.getTime() - MILLIS_IN_A_DAY*2);
        List<Prediction> temperatures = new ArrayList<Prediction>();
        // Add prediction
        temperatures.add(new Prediction(DateFormat.format(yesterday), temperatureService.getTemperature(country)));
        temperatures.add(new Prediction(DateFormat.format(twoDayBefore), temperatureService.getTemperature(country)));
        return new PredictionRest(country, temperatures);
    }
}
