package com.example.TP.Controller;
import com.example.TP.Model.Etalab;
import com.example.TP.Model.Feature;
import com.example.TP.Model.MeteoConcept;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;


import java.util.Collections;
@Controller
public class MeteoController {
    @Autowired
    private RestTemplate resttemplate;

    public static String API_KEY = "c086d3f81cf042c37ccabaac61a4b1a4f73021fb2826e16b3fc3e96e51b4f34e";

    @GetMapping("/meteo")
    public String meteoGet(){
        return "meteo";
    }

    @PostMapping("/meteo")
    public String meteoPost(
            @RequestParam(name="address", required=true) String address,
            Model model
    ){
        String link = address.toLowerCase().replace(" ", "+");

        Etalab etalabAPIAddress = resttemplate.getForObject("https://api-adresse.data.gouv.fr/search/?q=" + link + "&limit=1", Etalab.class);

        Feature feature = etalabAPIAddress.features.get(0);
        float Lat = feature.getGeometry().getCoordinates().get(1);
        float Lon = feature.getGeometry().getCoordinates().get(0);




        //
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

        HttpEntity<String> requestEntity = new HttpEntity<>(headers);

        String meteo_url = "https://api.meteo-concept.com/api/forecast/daily/0?token=" + API_KEY + "&latlng=" + Lat + "," + Lon;

        ResponseEntity<MeteoConcept> response = resttemplate.exchange(meteo_url, HttpMethod.GET, requestEntity, MeteoConcept.class);

        //Coordinates and general information fed to the meteo.html
        model.addAttribute("Long", Lon);
        model.addAttribute("Lat", Lat);
        model.addAttribute("Address", address);
        model.addAttribute("Alt",response.getBody().getCity().get("altitude"));
        model.addAttribute("Country",response.getBody().getCity().get("country"));
        model.addAttribute("City",response.getBody().getCity().get("city"));


        // Specific information displayedabout the weather conditon in the located area
        model.addAttribute("datetime", response.getBody().getForecast().get("datetime") );
        model.addAttribute("fog_Prob", response.getBody().getForecast().get("probafog") + "%");
        model.addAttribute("Wind_Speed", response.getBody().getForecast().get("wind10m") + " km/h");
        model.addAttribute("rain_Prob", response.getBody().getForecast().get("probarain") + " %");
        model.addAttribute("minimum_Temperature", response.getBody().getForecast().get("tmin") + " °C");
        model.addAttribute("maximum_Temperature", response.getBody().getForecast().get("tmax") + " °C");
        model.addAttribute("Sun", response.getBody().getForecast().get("sun_hours") + " heures");

        return "meteo";
    }
}


