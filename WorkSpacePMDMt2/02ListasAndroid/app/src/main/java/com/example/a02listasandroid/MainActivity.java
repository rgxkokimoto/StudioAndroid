package com.example.a02listasandroid;

import android.os.Bundle;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    private ListView lvUsers;
    private List<User> userList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        lvUsers = findViewById(R.id.lvUsers);
        userList = new ArrayList<>();

        userList.add(new User(R.drawable.alexbarreiros, "alexbarreiros", "Alejandro", "Barreiros", "william.henry.harrison@example-pet-store.com", 13));
        userList.add(new User(R.drawable.img2, "alexbarreiros", "Alejandro", "Barreiros", "john.mckinley@examplepetstore.com", 13));
        userList.add(new User(R.drawable.jose, "jose", "nete", "popo", "nete.moore.wayne@example.com", 27));
        userList.add(new User(R.drawable.jaimito, "jaimito", "Trote", "Numpi", "jaimito.moore.wayne@example-pet-store.com", 27));
        userList.add(new User(R.drawable.pepe,"alexbarreiros","Alex", "Barreiros", "alexbarrei03@gmail.com", 45));
        userList.add(new User(R.drawable.img2,"dianawalls","Diana", "Walls", "dianawall04@gmail.com", 22));
        userList.add(new User(R.drawable.pepe, "marcosruiz", "Marcos", "Ruiz", "marcosruiz91@gmail.com", 30));
        userList.add(new User(R.drawable.ic_launcher_foreground, "carlasanchez", "Carla", "Sánchez", "carla_sanchez99@gmail.com", 28));
        userList.add(new User(R.drawable.nulet, "pedrogarcia", "Pedro", "García", "pedrog91@gmail.com", 35));
        userList.add(new User(R.drawable.jaimito, "luciasilva", "Lucía", "Silva", "lucia_silva@hotmail.com", 26));
        userList.add(new User(R.drawable.img2, "mariofernandez", "Mario", "Fernández", "mariofernandez89@yahoo.com", 29));
        userList.add(new User(R.drawable.jose, "martamoreno", "Marta", "Moreno", "marta_moreno@mail.com", 24));
        userList.add(new User(R.drawable.alexbarreiros, "juangomez", "Juan", "Gómez", "juangomez74@gmail.com", 40));

        UserListAdapter adapter = new UserListAdapter(this, userList);
        lvUsers.setAdapter(adapter); // Asiganar el adaptador al ListView

    }
}