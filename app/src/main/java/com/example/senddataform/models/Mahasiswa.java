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
    
    public Mahasiswa(){
    }
    
    public String getNama(){
        return nama;
    }
    
    public void setNama(String nama){
        this.nama = nama;
    }
    
    public String getNim(){
        return nim;
    }
    
    public void setNim(String nim){
        this.nim = nim;
    }
    
    public String getTanggal(){
        return tanggal;
    }
    
    public void setTanggal(String tanggal){
        this.tanggal = tanggal;
    }
    
    public String getGender(){
        return gender;
    }
    
    public void setGender(String gender){
        this.gender = gender;
    }
    
    public String getJurusan(){
        return jurusan;
    }
    
    public void setJurusan(String jurusan){
        this.jurusan = jurusan;
    }
    
    protected Mahasiswa(Parcel in) {
        this.nama = in.readString();
        this.nim = in.readString();
        this.tanggal = in.readString();
        this.gender = in.readString();
        this.jurusan = in.readString();
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

    public static final Parcelable.Creator<Mahasiswa> CREATOR = new Parcelable.Creator<Mahasiswa>() {
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
