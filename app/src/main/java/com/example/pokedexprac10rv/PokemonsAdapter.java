package com.example.pokedexprac10rv;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.pokedexprac10rv.databinding.ViewholderPokemonBinding;

import java.util.ArrayList;
import java.util.List;

class PokemonsAdapter extends RecyclerView.Adapter<PokemonViewHolder> {
    private List<Pokemon> pokemons = new ArrayList<>();

    @NonNull
    @Override
    public PokemonViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ViewholderPokemonBinding binding = ViewholderPokemonBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new PokemonViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull PokemonViewHolder holder, int position) {
        Pokemon pokemon = pokemons.get(position);

        // Cargar la imagen del Pokémon con Glide
        Glide.with(holder.binding.imagen.getContext()).load(pokemon.getImagen()).into(holder.binding.imagen);
        holder.binding.nombre.setText(pokemon.getNombre());

        // Configurar el clic en el item
        holder.itemView.setOnClickListener(view -> {
            // Seleccionar el Pokémon y navegar al fragmento de detalle
            PokemonsViewModel viewModel = new ViewModelProvider((FragmentActivity) view.getContext()).get(PokemonsViewModel.class);
            viewModel.seleccionar(pokemon); // Usar el método 'seleccionar()' que tienes en el ViewModel
            Navigation.findNavController(view).navigate(R.id.action_recyclerPokemonFragment_to_infoPokemonFragment);
        });
    }

    @Override
    public int getItemCount() {
        return pokemons.size();
    }

    public void actualizarLista(List<Pokemon> pokemons) {
        this.pokemons = pokemons;
        notifyDataSetChanged();
    }
}