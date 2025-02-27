package com.example.a03firebasestorage;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.a03firebasestorage.databinding.RecyclerItemBinding;
import com.squareup.picasso.Picasso;

import java.util.List;

public class UserRecyclerAdapter extends RecyclerView.Adapter<UserRecyclerAdapter.UserViewHolder> {

    private final List<User> userList;

    public UserRecyclerAdapter(List<User> userList) {
        this.userList = userList;
    }

    @NonNull
    @Override
    public UserRecyclerAdapter.UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        RecyclerItemBinding binding = RecyclerItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return  new UserViewHolder(binding);

    }

    // Asigna datos a cada vista, dentro del UserViewHolder.
    @Override
    public void onBindViewHolder(@NonNull UserRecyclerAdapter.UserViewHolder holder, int position) {

        // Obtenemos el objeto User correspondiente a la posición actual
        User user = userList.get(position);

        // Cargar imagen a traves de piccaso
        Picasso.get()
                .load(user.getImageUrl())
                .placeholder(R.drawable.ic_launcher_foreground)
                .into(holder.binding.imgProfile);

        holder.binding.tvFirstNameLastName.setText(user.getFirstName() + " " + user.getLasteName());
        holder.binding.tvUsername.setText(user.getUserName());
        holder.binding.tvEmail.setText(user.getEmail());
        holder.binding.tvAge.setText(String.valueOf(user.getAge()));

        // Un Onclick para poder adceder a la Imagen.
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i  = new Intent(v.getContext(), UserDetailActivity.class);
                i.putExtra("firstName", user.getFirstName());
                i.putExtra("lastName", user.getLasteName());
                i.putExtra("username", user.getUserName());
                i.putExtra("email", user.getEmail());
                i.putExtra("imageUrl", user.getImageUrl());
                i.putExtra("age", user.getAge());
                v.getContext().startActivity(i);
            }
        });

    }

    @Override
    public int getItemCount() {
        return userList.size();
    }

    // Clase interna que representa la vista de cada elemento
    public class UserViewHolder extends RecyclerView.ViewHolder {

        private final RecyclerItemBinding binding;

        // Constructor que binding como parámetro
        public UserViewHolder(RecyclerItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }

}
