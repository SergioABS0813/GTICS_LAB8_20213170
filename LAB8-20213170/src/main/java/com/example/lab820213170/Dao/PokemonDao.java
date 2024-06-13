package com.example.lab820213170.Dao;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class PokemonDao {

    public List<Product> listar() {

        List<Product> lista = new ArrayList<>();

        RestTemplate restTemplate = new RestTemplate();

        String endPoint = "http://localhost:8080/product";

        //Parseo lo que extraigo en un arreglo de objetos
        ResponseEntity<Product[]> responseEntity = restTemplate.getForEntity(endPoint, Product[].class);

        //200 y algo siempre es succesfull para usar de solo un numero de codigo debe ser isSameCodeas

        if(responseEntity.getStatusCode().is2xxSuccessful()){
            Product[] body = responseEntity.getBody();
            //Convertimos de arreglo a lista
            lista = Arrays.asList(body);
        }

        return lista;
    }












}
