package com.example.pokedexprac10rv;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.pokedexprac10rv.databinding.FragmentRecyclerPokemonBinding;
import com.example.pokedexprac10rv.databinding.ViewholderPokemonBinding;

import java.util.List;


public class recyclerPokemonFragment extends Fragment {
    private FragmentRecyclerPokemonBinding binding;
    private PokemonsViewModel pokemonViewModel;
    private NavController navController;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return (binding = FragmentRecyclerPokemonBinding.inflate(inflater,container,false)).getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        pokemonViewModel = new ViewModelProvider(requireActivity()).get(PokemonsViewModel.class);
        navController = Navigation.findNavController(view);

        PokemonsAdapter pokemonsAdapter = new PokemonsAdapter();
        binding.recyclerView.setAdapter(pokemonsAdapter);

        pokemonViewModel.obtener().observe(getViewLifecycleOwner(), pokemonsAdapter::establecerLista);


    }

    class PokemonsAdapter extends RecyclerView.Adapter<PokemonViewHolder>{
        List<Pokemon> pokemons;

        @NonNull
        @Override
        public PokemonViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            // Aquí usamos ViewholderPokemonBinding.inflate en lugar de PokemonViewHolder.inflate
            ViewholderPokemonBinding binding = ViewholderPokemonBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
            return new PokemonViewHolder(binding);
        }

        @Override
        public void onBindViewHolder(@NonNull PokemonViewHolder holder, int position) {
            Pokemon pokemon = pokemons.get(position);
            Glide.with(holder.binding.imagen.getContext()).load(pokemon.imagen).into(holder.binding.imagen);
            holder.binding.nombre.setText(pokemon.nombre);

            holder.itemView.setOnClickListener(view -> {
                pokemonViewModel.seleccionar(pokemon);
                navController.navigate(R.id.action_recyclerPokemonFragment_to_infoPokemonFragment);
            });
        }

        @Override
        public int getItemCount() {
            return pokemons != null ? pokemons.size() : 0;
        }

        public void establecerLista(List<Pokemon> pokemons){
            this.pokemons = pokemons;
            notifyDataSetChanged();
        }

        public Pokemon obtenerPokemon(int posicion){
            return pokemons.get(posicion);
        }
    }

}