package com.example.pokedexprac10rv;


import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import java.util.List;

public class PokemonsViewModel extends AndroidViewModel {
    private MutableLiveData<List<Pokemon>> listPokemonsMutableLiveData;
    private MutableLiveData<Pokemon> pokemonSeleccionado;


    public PokemonsViewModel(@NonNull Application application) {
        super(application);
        listPokemonsMutableLiveData = new MutableLiveData<>();
        pokemonSeleccionado = new MutableLiveData<>();
        // Inicializa la lista de Pokémon
        listPokemonsMutableLiveData.setValue(new InfoPokemon().obtener());
    }

    public MutableLiveData<List<Pokemon>> obtener() {
        return listPokemonsMutableLiveData;
    }

    public MutableLiveData<Pokemon> seleccionado() {
        return pokemonSeleccionado;
    }

    public void seleccionar(Pokemon pokemon) {
        pokemonSeleccionado.setValue(pokemon);
    }
}
