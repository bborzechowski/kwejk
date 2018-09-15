package akademiakodu.controller;


import akademiakodu.data.GifRepository;
import akademiakodu.model.Gif;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


@Controller
public class GifController {

    @Autowired
    private GifRepository gifRepository;

    @RequestMapping("/")
    public String listGifs(ModelMap modelMap){
        List<Gif> gifs = gifRepository.getAllGifs();
        modelMap.put("gifs", gifs);
        return "home";
    }

    @RequestMapping("/gif/{name}")
    public String gifDetails(@PathVariable String name, ModelMap modelmap){
        Gif gif = gifRepository.findByName(name);
        modelmap.put("gif", gif);
        return "gif-details";
    }

    @RequestMapping("/favorites")
    public String getFavorites(ModelMap modelMap){
        List<Gif> gifs = gifRepository.getFavorites();
        modelMap.put("gifs", gifs);
        return "favorites";
    }
}
