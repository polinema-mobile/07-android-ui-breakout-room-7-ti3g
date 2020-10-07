package com.example.senddataform.models;

import android.os.Parcel;
import android.os.Parcelable;

public class Mahasiswa implements Parcelable {
    private String nama, nim, tanggal, gender, jurusan;

    public Mahasiswa(String nama, String nim, String tanggal, String gender, String jurusan) {
        this.nama = nama;
        this.nim = nim;
        this.tanggal = tanggal;
        this.gender = gender;
        this.jurusan = jurusan;
    }

    protected Mahasiswa(Parcel in) {
        nama = in.readString();
        nim = in.readString();
        tanggal = in.readString();
        gender = in.readString();
        jurusan = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(nama);
        dest.writeString(nim);
        dest.writeString(tanggal);
        dest.writeString(gender);
        dest.writeString(jurusan);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Mahasiswa> CREATOR = new Creator<Mahasiswa>() {
        @Override
        public Mahasiswa createFromParcel(Parcel in) {
            return new Mahasiswa(in);
        }

        @Override
        public Mahasiswa[] newArray(int size) {
            return new Mahasiswa[size];
        }
    };
}
