package com.example.lab820213170.Controller;

import com.example.lab820213170.Dao.PokemonDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/home")
public class HomeController {

    final PokemonDao pokemonDao;

    public ProductController(PokemonDao pokemonDao) {
        this.pokemonDao = pokemonDao;
    }

    @GetMapping({"/list"})
    public String listarProductos(Model model) {
        //model.addAttribute("listaProductos", productRepository.findAll());
        //Ahora lo sacamos del Dao y ya no del repositorio
        model.addAttribute("listaProductos", productoDao.listar());
        return "product/list";
    }




}
