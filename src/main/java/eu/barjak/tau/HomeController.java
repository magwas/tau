package eu.barjak.tau;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    private WeatherService weatherService;

    @Autowired
    public void getWeatherService(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    private void extracted(Model model) {
        model.addAttribute("indexOfMeasuredTemperatures", weatherService.weather());
        model.addAttribute("temperatures", weatherService.temperatures);
        model.addAttribute("startDate", weatherService.startDateString);
        model.addAttribute("endDate", weatherService.endDateString);
        model.addAttribute("initialRoomTemperature", weatherService.initialRoomTemperature);
    }

    @GetMapping("/")
    public String neu(Model model) {
        extracted(model);
        return "index";
    }
}
