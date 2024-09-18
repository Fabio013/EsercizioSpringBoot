package co.develhope.demo_esercizio1709;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Persona {

    @JsonProperty("nome")
    private String nome;

    @JsonCreator
    public Persona(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }
}
