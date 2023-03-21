package eu.barjak.tau;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    private WeatherService weatherService;

    private Data data = Data.getInstance();

    @Autowired
    public void getWeatherService(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    private void extracted(Model model) {
        model.addAttribute("startDate", data.getStartDateString().replace("-", ".") + ".");
        model.addAttribute("startTime", data.getStartTimeString());
        model.addAttribute("endDate", data.getEndDateString().replace("-", ".") + ".");
        model.addAttribute("initRoomTemp", data.getInitRoomTemp());
        model.addAttribute("indexOfMeasuredTemperatures", data.getIndexOfMeasuredTemperatures());
        model.addAttribute("temperatures", data.getTemperatures());
        model.addAttribute("omszId", data.getOmszId());
        model.addAttribute("thermalTimeConstant", data.getThermalTimeConstant());
    }

    @GetMapping("/")
    public String neu(Model model) {
        weatherService.weather();
        extracted(model);
        return "index";
    }

}