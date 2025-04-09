package com.tphedi.tp.Controller;
import com.tphedi.tp.model.Feature;

import com.tphedi.tp.model.MeteoConceptResponse;
import com.tphedi.tp.response.EtalabAddressResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;

@Controller
@RequestMapping("/meteo")
public class MeteoController {
    private static final Logger log = LoggerFactory.getLogger(MeteoController.class);


    @Autowired
    RestTemplate rt;

    public static String KEY = "3d26207694fe21805515b85da12d7d199498b6462edfa1ef4c552e704b9c49c5";
    @PostMapping
    public String getWeather(@RequestParam ("address") String address, Model model) {

            String addressmeteo = address.toLowerCase().replace(" ", "+");
            EtalabAddressResponse etalabAPIAddress = rt.getForObject("https://api-adresse.data.gouv.fr/search/?q=" + addressmeteo + "&limit=1", EtalabAddressResponse.class);
            Feature feature = etalabAPIAddress.features.get(0);
            //récuperer les informations du localisation
            float longitude = feature.getGeometry().getCoordinates().get(0);
            float latitude = feature.getGeometry().getCoordinates().get(1);
            model.addAttribute("address", address);
            model.addAttribute("longitude", longitude);
            model.addAttribute("latitude", latitude);
            //Méteo API
            HttpHeaders httpheader = new HttpHeaders();
            httpheader.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
            HttpEntity<String> Entity = new HttpEntity<>(httpheader);
            String link = "https://api.meteo-concept.com/api/forecast/daily/0?token=" + KEY + "&latlng=" + latitude + "," + longitude;
            ResponseEntity<MeteoConceptResponse> meteoresponse = rt.exchange(link, HttpMethod.GET, Entity, MeteoConceptResponse.class);
            //récuperer les informations du meteo
            model.addAttribute("temperature_minimale", meteoresponse.getBody().getForecast().get("tmin") + " °");
            model.addAttribute("temperature_maximale", meteoresponse.getBody().getForecast().get("tmax") + " °");
            model.addAttribute("probabilite_pluie", meteoresponse.getBody().getForecast().get("probarain"));
            return "meteo";

    }

}
