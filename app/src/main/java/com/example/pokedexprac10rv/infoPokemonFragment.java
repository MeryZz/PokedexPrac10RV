package com.example.pokedexprac10rv;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProvider;

import com.bumptech.glide.Glide;
import com.example.pokedexprac10rv.databinding.FragmentInfoPokemonBinding;

public class infoPokemonFragment extends Fragment {
    private FragmentInfoPokemonBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return (binding = FragmentInfoPokemonBinding.inflate(inflater,container,false)).getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        PokemonsViewModel pokemonsViewModel = new ViewModelProvider(requireActivity()).get(PokemonsViewModel.class);

        pokemonsViewModel.seleccionado().observe(getViewLifecycleOwner(), pokemon -> {
            binding.nombre.setText(pokemon.getNombre());
            Glide.with(requireContext()).load(pokemon.getImagen()).into(binding.imagen);
            binding.tipo.setText(pokemon.getTipo());
            binding.ultimaEvolucion.setText(pokemon.getUltimaEvolucion());
        });
    }

}