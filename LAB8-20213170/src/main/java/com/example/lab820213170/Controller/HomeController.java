package com.example.lab820213170.Controller;

import com.example.lab820213170.Dao.PokemonDao;
import com.example.lab820213170.Entity.Pokemon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/home")
public class HomeController {

    final PokemonDao pokemonDao;

    public HomeController(PokemonDao pokemonDao) {
        this.pokemonDao = pokemonDao;
    }

    @GetMapping({"/list"})
    @ResponseBody
    public String listarProductos(Model model,
                                  @PathVariable("id") int id) {


        List<Pokemon> listaPokemon = pokemonDao.listarPokemonporRegion(id);

        return listaPokemon.toString();
    }




}
