package co.develhope.demo_esercizio1709;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/v1")
public class PersonaController {

    Map<Integer, Persona> mappaPersone = Map.of(1, new Persona("Mario"),2, new Persona("Luigi"));

    @GetMapping("nome/{id}")
    public Persona getPersonaById (@PathVariable ("id") int id)
    {
        return mappaPersone.get(id);
    }


}
//post che accetta un json di persona e lo salva in una mappa/lista e get lo recupera ritorna

//dato un /id lo recupera dalla mappa e lo ritorna