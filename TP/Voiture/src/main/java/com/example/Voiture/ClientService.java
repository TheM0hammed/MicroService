package com.example.Voiture;


import com.example.Voiture.entities.Client;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "SERVICE-CLIENT", url = "http://localhost:8088")
public interface ClientService {

    @GetMapping(path = "/client/{id}")
    public Client clientById(@PathVariable Long id);
}
