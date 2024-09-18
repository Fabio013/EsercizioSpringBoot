package co.develhope.demo_esercizio1709;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/v1")
public class PersonaController {

    Map<Integer, Persona> mappaPersone = new HashMap<>();

    @GetMapping("persone/{id}")
    public CustomResponse<Persona> getPersonaById(@PathVariable("id") int id) {
        Persona persona = mappaPersone.get(id);
        if (persona == null) {
            return new CustomResponse(404, HttpStatus.NOT_FOUND);
        } else {
            return new CustomResponse<>(200, HttpStatus.OK, persona);
        }
    }

    @GetMapping("persone")
    public List<Persona> getPersonaByNome(@RequestParam("nome") String nome) {

        return mappaPersone.entrySet().stream().filter(i -> i.getValue().getNome().equals(nome)).map(map -> map.getValue()).toList();
    }

    @PostMapping("/persone/{id}")
    public CustomResponse<?> addPerson(@RequestBody Persona p, @PathVariable ("id") int id){

        if(mappaPersone.containsKey(id)){
          return new CustomResponse(409, HttpStatus.CONFLICT, "La persona già esiste!");
       } else{
           mappaPersone.put(id, p);
           return new CustomResponse<>(200, HttpStatus.OK,p);
       }
    }




}
//post che accetta un json di persona e lo salva in una mappa/lista e get lo recupera ritorna

//dato un /id lo recupera dalla mappa e lo ritorna