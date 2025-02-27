package com.dam.armoniabills.model;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import java.util.ArrayList;

public class Usuario implements Parcelable {

	double balance;
	ArrayList<String> grupos;
	private String id, nombre, email, tlf, imagenPerfil;

	public Usuario(String id, String nombre, String email, String tlf, String imagenPerfil, double balance, ArrayList<String> grupos) {
		this.id = id;
		this.nombre = nombre;
		this.email = email;
		this.tlf = tlf;
		this.imagenPerfil = imagenPerfil;
		this.balance = balance;
		this.grupos = grupos;
	}

	public Usuario() {
	}

	public static final Creator<Usuario> CREATOR = new Creator<Usuario>() {
		@Override
		public Usuario createFromParcel(Parcel in) {
			return new Usuario(in);
		}

		@Override
		public Usuario[] newArray(int size) {
			return new Usuario[size];
		}
	};

	protected Usuario(Parcel in) {
		id = in.readString();
		nombre = in.readString();
		email = in.readString();
		tlf = in.readString();
		imagenPerfil = in.readString();
		balance = in.readDouble();
		grupos = in.createStringArrayList();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public String getEmail() {
		return email;
	}

	public double getBalance() {
		return balance;
	}

	public String getTlf() {
		return tlf;
	}

	public String getImagenPerfil() {
		return imagenPerfil;
	}

	public ArrayList<String> getGrupos() {
		return grupos;
	}

	public void setGrupos(ArrayList<String> grupos) {
		this.grupos = grupos;
	}

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(@NonNull Parcel dest, int flags) {
		dest.writeString(id);
		dest.writeString(nombre);
		dest.writeString(email);
		dest.writeString(tlf);
		dest.writeString(imagenPerfil);
		dest.writeDouble(balance);
		dest.writeStringList(grupos);
	}
}
