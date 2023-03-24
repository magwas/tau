package eu.barjak.tau;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {
    private WeatherService weatherService;

    private Data data = Data.getInstance();

    @Autowired
    public void getWeatherService(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    private void extracted(Model model) {
        model.addAttribute("data", data);
    }

    @GetMapping("/")
    public String neu(Model model) {
        weatherService.weather();
        extracted(model);
        return "index";
    }

    // public String adatok(Model model) {
    //     extracted(model);
    //     return "message/list";
    // }

    @PostMapping("/nemkell")
    public String dataForm(@ModelAttribute(value = "data") Data data) {
        return "nemkell";
    }

}