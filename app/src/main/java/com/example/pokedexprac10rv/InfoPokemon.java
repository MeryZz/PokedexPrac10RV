package com.example.pokedexprac10rv;

import java.util.ArrayList;
import java.util.List;

public class InfoPokemon {
    private List<Pokemon> ListaDePokemons;

    public InfoPokemon() {
        ListaDePokemons = new ArrayList<>();
        ListaDePokemons.add(new Pokemon("Charmander", "Charizard", "Fuego", R.drawable.charmander));
        ListaDePokemons.add(new Pokemon("Pikachu", "Raichu", "Eléctrico", R.drawable.pikachu));
        ListaDePokemons.add(new Pokemon("Cindaquil", "Typhlosion", "Fuego", R.drawable.cindaquil));
        ListaDePokemons.add(new Pokemon("Ponyta", "Orphegasus", "Fuego", R.drawable.ponyta));
        ListaDePokemons.add(new Pokemon("Chikorita", "Meganium", "Hierba", R.drawable.chikorita));
        ListaDePokemons.add(new Pokemon("Treecko", "Sceptile", "Hierba", R.drawable.treecko));
        ListaDePokemons.add(new Pokemon("Riolu", "Lucario", "Lucha y Acero", R.drawable.riolu));
    }

    public List<Pokemon> obtener() {
        return ListaDePokemons;
    }
}
