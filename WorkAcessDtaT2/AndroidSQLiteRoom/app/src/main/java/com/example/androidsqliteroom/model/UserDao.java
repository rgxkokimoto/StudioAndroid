package com.example.androidsqliteroom.model;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import java.util.List;

@Dao
public interface UserDao {
    // Insertar un nuevo usario en la base de datos SQLite
    @Insert
    void insertRecord(User user);

    // Método para obtener todos los usuarios de la base de datos
    @Query("SELECT * FROM User")
    List<User> getAllUsers();

    @Query("DELETE FROM User")
    void deleteAll();

    // es necesario al borrar datos para que se reinicie el id
    @Query("DELETE FROM sqlite_sequence") // update sqlite_sequence SET  seq=() WHERE name = 'User';
    void restartSync();

    // Conseguir id de usuario por username
    @Query("SELECT COUNT(*) FROM User WHERE username = :username")
    boolean userExist(String username);

    // Actualizar usuario por username
    @Query("UPDATE User SET first_name = :firstName, last_name = :lastName, age = :age WHERE username = :username")
    void updateByUserName(String firstName, String lastName, int age, String username);

    // Borrar usuario por username
    @Query("DELETE FROM User WHERE username = :username")
    void deleteByUserName(String username);

    // RESTABLECE LA SECUENCIA DEL ID PARA NO COMPROMENTER LA LISTA AFECTANDO A LA TABLA ENCAGRAGDA DE AUTOGENERARLOS
    @Query("UPDATE sqlite_sequence SET seq =(SELECT COUNT(*) FROM User) -1 WHERE name = 'User';")
    void updateSeg();

    // El id no es lo mismo que sec recuerda que un es para saver la cantidad y otro es para identificar un registro

    // Obtener usuarios mayores de X años
    @Query("SELECT * FROM User WHERE age > :edad")
    List<User> usuariosMayores(int edad);

    // Obtener usuarios por apellido
    @Query("SELECT * FROM User WHERE last_name = :apellido")
    List<User> usuariosApellidos(String apellido);

    @Query("DELETE FROM User WHERE age < :edad")
    void eliminarMenores(int edad);

    @Query("SELECT COUNT(*) FROM User WHERE age > :edad")
    int usuariosEliminados(int edad);

    @Query("SELECT COUNT(*) FROM User")
    int contarUsuarios();

    // Usuarios con id mas alto
    @Query("SELECT * FROM User ORDER BY id DESC LIMIT 1;")
    List<User> usuariosConIdMasAlto();

    @Query("SELECT * FROM User WHERE username LIKE 'J%'")
    List<User> empiezanPorJ();

    @Query("SELECT AVG(age) FROM User")
    int edadPromedio();

    @Query("SELECT * FROM User ORDER BY age ASC LIMIT 1;")
    List<User> usuarioMasJoven();


    @Query("SELECT * FROM User WHERE LENGTH(first_name) = (SELECT MAX(LENGTH(first_name)) FROM User)")
    List<User> nombreMasLargo();


}
