package com.example.androidsqliteroom;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import com.example.androidsqliteroom.databinding.ActivityMainBinding;
import com.example.androidsqliteroom.model.AppDatabase;
import com.example.androidsqliteroom.model.User;
import com.example.androidsqliteroom.model.UserDao;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    private AppDatabase db;

    private UserDao userDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Iniciar la base de datos SQLite.
        // getApplicationContext() -> recoje la clase que debe sobrevivir a la destruccion de la actividad.
        // allowMainThreadQueries() -> Permite ejecutar las consultas a las bases de datos en el hilo principal. // Puede dar error pero puedes meter nuevos hilos para solucionarlo
        db = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "users_db")
                .allowMainThreadQueries().build();

        // Iniciar el DAO
        userDao = db.userDao();

        binding.btnInsertar.setOnClickListener(V -> insertUser());
        binding.btnConsultar.setOnClickListener(V -> showUsers());
        binding.btnBorrarTodo.setOnClickListener(V -> borrarTodo());
        binding.btnActualizarUsuario.setOnClickListener(V -> updateUser());
        binding.btnEliminarUsuario.setOnClickListener(V -> eliminarUsuario());
        binding.btnFindUserByEdad.setOnClickListener(V -> findUserByEdad());
        binding.btnFindUserByApellido.setOnClickListener(V -> findUserByApellido());
        binding.btnDeleteByAge.setOnClickListener(V -> deleteUserByAge());
        binding.btnCountUsers.setOnClickListener(V -> countUsers());
        binding.btn5LastUser.setOnClickListener(V -> lastUser());
        binding.btn7MediaAge.setOnClickListener(V -> mediaAge());
        binding.btn6UsersWithJ.setOnClickListener(V -> usersWithJ());
        // Sin probar TODO
        binding.btn8Youngest.setOnClickListener(V -> youngestUser());
        binding.btn9LongestName.setOnClickListener(V -> longestName());
        binding.btn10Palindromos.setOnClickListener(V -> palindromos());


    }

    private void palindromos() {
        List<User> userList = userDao.getAllUsers();;
        int countP = 0;
        String word, wordIn;

        for (User user : userList) {
            word = user.getFirstName().toLowerCase();
            wordIn = reverse(word);

            if (user.getFirstName().equals(wordIn)) {
                countP++;
            }

        }

        Toast.makeText(this, "Hay " + countP + " nombres palindromos", Toast.LENGTH_SHORT).show();
    }

    private String reverse(String firstName) {
        return new StringBuilder(firstName).reverse().toString(); // Al crearlo dentro del método no va a consumir memoria ya que se destruye al salir del método
    }

    private void longestName() {
        List<User> users = userDao.nombreMasLargo();
        tvListupdate(users);
    }

    private void youngestUser() {
        List<User> user = userDao.usuarioMasJoven();
        tvListupdate(user);
    }

    private void mediaAge() {
        int media = userDao.edadPromedio();
        Toast.makeText(this, "La media de edad es " + media, Toast.LENGTH_SHORT).show();
    }

    private void lastUser() {
        List<User> users = userDao.usuariosConIdMasAlto();
        tvListupdate(users);
    }

    private void usersWithJ() {
        List<User> users = userDao.empiezanPorJ();
        tvListupdate(users);
    }

    private void countUsers() {
        int count = userDao.contarUsuarios();
        Toast.makeText(this, "Hay " + count + " usuarios", Toast.LENGTH_SHORT).show();
    }

    private void deleteUserByAge() {

        int edad = Integer.parseInt(binding.etEdad.getText().toString());
        userDao.eliminarMenores(edad);
        userDao.usuariosEliminados(edad);
        userDao.updateSeg();

        showUsers();
    }

    private void findUserByApellido() {

        String apellido = binding.etLastName.getText().toString();
        List<User> users = userDao.usuariosApellidos(apellido);

        tvListupdate(users);

    }

    private void findUserByEdad() {
        int edad = Integer.parseInt(binding.etEdad.getText().toString());
        List<User> users = userDao.usuariosMayores(edad);

        tvListupdate(users);

    }

    private void updateUser() {

        String username = binding.etUsername.getText().toString();

        // Valido si el usario existe
        if (!userDao.userExist(username)) {
            Toast.makeText(this, "Usuario " + username + " no no existe", Toast.LENGTH_SHORT).show();
        }

        // Si existe actualizo los datos
        userDao.updateByUserName(
                binding.etFirstName.getText().toString(),
                binding.etLastName.getText().toString(),
                Integer.parseInt(binding.etEdad.getText().toString()),
                username
        );

    }

    private void borrarTodo() {

        userDao.deleteAll();
        userDao.restartSync();
        binding.tvListadoUsuarios.setText("");
        Toast.makeText(this, "Todos los usuarios han sido borrados", Toast.LENGTH_SHORT).show();

    }

    private void showUsers() {

        // Creamos una lista de usarios leída
        List<User> users = userDao.getAllUsers();

        tvListupdate(users);
    }

    private void tvListupdate(List<User> users) {

        // Creamos un StringBuilder para concatenar los usuarios aunque lo mejor serria usar un recycler view
        StringBuilder userData = new StringBuilder();

        // Recorremos la lista de usuarios y los añadimos al StringBuilder
        for (User user : users) {
            userData.append("ID: ")
                    .append(user.getId()).append(") ")
                    .append("Nombre: ").append(user.getFirstName())
                    .append(" || ")
                    .append("Apellido: ").append(user.getLastName())
                    .append(" || ")
                    .append("Edad: ").append(user.getAge())
                    .append(" || ")
                    .append("Username: ").append(user.getUserName())
                    .append("\n\n");
        }

        binding.tvListadoUsuarios.setText(userData.toString());

    }

// Para pocos datos si se bloquea pasar a método 2 que usa hilos
//    private void insertUser() {
//        userDao.insertRecord(new User(
//                binding.etFirstName.getText().toString(),
//                binding.etLastName.getText().toString(),
//                Integer.parseInt(binding.etEdad.getText().toString()),
//                binding.etUsername.getText().toString()
//        ));
//        Toast.makeText(this, "Usuario " + binding.etUsername.getText().toString() + " insertado", Toast.LENGTH_SHORT).show();
//    }

    //Insert user pero con hilo que soporta mucha más carga
    private void insertUser() {
        new Thread( () -> {
                userDao.insertRecord(new User(
                        binding.etFirstName.getText().toString().trim(),
                        binding.etLastName.getText().toString(),
                        Integer.parseInt(binding.etEdad.getText().toString()),
                        binding.etUsername.getText().toString()
        ));

            // Recordatorio al usar hilos: Solo puedes ineractuar con la UI y sus componentes desde el hilo principal.
            runOnUiThread( () -> {
                Toast.makeText(this, "Usuario " + binding.etUsername
                        .getText()
                        .toString() + " insertado", Toast.LENGTH_SHORT)
                        .show();

                clearFields();
                showUsers();
            });



        }).start();

    }

    private void clearFields() {
        binding.etFirstName.setText("");
        binding.etLastName.setText("");
        binding.etEdad.setText("");
        binding.etUsername.setText("");
    }

    private void eliminarUsuario() {
        String username = binding.etUsername.getText().toString();
        // Valido si el usario existe
        if (!userDao.userExist(username)) {
            Toast.makeText(this, "Usuario " + username + " no existe", Toast.LENGTH_SHORT).show();
        } else {
            userDao.deleteByUserName(username);
            Toast.makeText(this, "Usuario " + username + " eliminado", Toast.LENGTH_SHORT).show();

            // Disminuir en 1 la secuencia de ids
            userDao.updateSeg();
        }
    }





}