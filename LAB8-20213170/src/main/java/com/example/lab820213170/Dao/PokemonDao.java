package com.example.lab820213170.Dao;

import com.example.lab820213170.Entity.Pokemon;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class PokemonDao {

    public List<Pokemon> listarPokemonporRegion(int id) {

        List<Pokemon> lista = new ArrayList<>();

        RestTemplate restTemplate = new RestTemplate();

        String endPoint = "https://pokeapi.co/api/v2/location-area/" + id;

        //Parseo lo que extraigo en un arreglo de objetos
        ResponseEntity<Pokemon[]> responseEntity = restTemplate.getForEntity(endPoint, Pokemon[].class);

        //200 y algo siempre es succesfull

        if(responseEntity.getStatusCode().is2xxSuccessful()){
            Pokemon[] body = responseEntity.getBody();
            //Convertimos de arreglo a lista
            lista = Arrays.asList(body);
        }

        return lista;
    }













}
