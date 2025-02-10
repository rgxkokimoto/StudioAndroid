package com.example.a02listasrecicleview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class UserRecyclerAdapter extends RecyclerView.Adapter<UserRecyclerAdapter.UserViewHolder> {


    // Lista de usuarios que mostrar en el RecyclerView
    private List<User> userList;

    public UserRecyclerAdapter(List<User> userList) {
        this.userList = userList;
    }

    // 1. Inflado Layout

    @NonNull
    @Override
    public UserRecyclerAdapter.UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_item, parent, false);
        return  new UserViewHolder(view);
    }

    // 2. Asignar datos a los componentes
    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {

        User user = userList.get(position);

        // Libreria picasso para cargar imagenes
        Picasso.get().load(user.getProfileImage())
                .placeholder(R.drawable.imagen) // Imagen por defecto por si no carga
                .error(R.drawable.imagen) // Imagen por si falla
                .into(holder.imgProfile);

        holder.tvFirstNameLastName.setText(user.getFirstName() + " " + user.getLastName());
        holder.tvUsername.setText(user.getUsername());
        holder.tvEmail.setText(user.getEmail());
        holder.tvAge.setText(String.valueOf(user.getAge()));

    }

    @Override
    public int getItemCount() {
        return userList.size();
    }

    static class UserViewHolder extends RecyclerView.ViewHolder {

        ImageView imgProfile;
        TextView tvFirstNameLastName , tvUsername , tvEmail , tvAge;

        public UserViewHolder(@NonNull View itemView) {
            super(itemView);

            // Asignar listas a los elementos de la vista

            imgProfile = itemView.findViewById(R.id.imgProfile);
            tvFirstNameLastName = itemView.findViewById(R.id.tvFirstNameLastName);
            tvUsername = itemView.findViewById(R.id.tvUsername);
            tvEmail = itemView.findViewById(R.id.tvEmail);
            tvAge = itemView.findViewById(R.id.tvAge);

        }
    }

}
