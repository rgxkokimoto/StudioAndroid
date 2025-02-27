package com.example.a02listasandroid;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class UserListAdapter extends BaseAdapter {

    private Context context;

    private List<User> userList;

    // Constructor necesario para instaciar UserListAdapter
    public UserListAdapter(Context context, List<User> userList) {
        this.context = context;
        this.userList = userList;
    }

    // Retorna el numero de elementos de la lista
    @Override
    public int getCount() {
        return userList.size();
    }

    @Override
    public Object getItem(int position) {
        return userList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    // Inflar el diseño del elemento del xml que le pasemos
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        // Inflar la vista/Diseño con LayoutInflater, que recibe un xml, el parent y un paramtro que debemos de pone en false, para que la vista no se cree de forma automatica

        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false);
        }

        ImageView imgProfile = convertView.findViewById(R.id.imgProfile);
        TextView tvFirstNameLastName = convertView.findViewById(R.id.tvFirstNameLastName);
        TextView tvUsername = convertView.findViewById(R.id.tvUsername);
        TextView tvEmail = convertView.findViewById(R.id.tvEmail);
        TextView tvAge = convertView.findViewById(R.id.tvAge);

        User user = userList.get(position);

        imgProfile.setImageResource(user.getProfileImage());
        tvFirstNameLastName.setText(user.getFirstName() + " " + user.getLastName());
        tvUsername.setText(user.getUsername());
        tvEmail.setText(user.getEmail());
        tvAge.setText(String.valueOf(user.getAge()));

        return convertView;
    }
}
