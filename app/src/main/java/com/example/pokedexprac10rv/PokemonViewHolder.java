package com.example.pokedexprac10rv;

import androidx.recyclerview.widget.RecyclerView;

import com.example.pokedexprac10rv.databinding.ViewholderPokemonBinding;

public class PokemonViewHolder extends RecyclerView.ViewHolder {
    //Binding del layout de cada item
    public ViewholderPokemonBinding binding;

    public PokemonViewHolder(ViewholderPokemonBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }
}
