package com.tphedi.tp.service;


import com.tphedi.tp.response.EtalabAddressResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class EtalabApiService {

    public EtalabAddressResponse getAddressInfo(String address) {
        String apiUrl = "https://api-adresse.data.gouv.fr/search/?q=" + address + "&limit=1";

        RestTemplate restTemplate = new RestTemplate();

        EtalabAddressResponse response = restTemplate.getForObject(apiUrl, EtalabAddressResponse.class);

        return response;
    }
}


