package com.example.senddataform;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import android.os.Bundle;
import com.example.senddataform.models.Mahasiswa;
public class MainActivity extends AppCompatActivity {
    Calendar myCalendar;
    DatePickerDialog.OnDateSetListener date;
    EditText nama;
    EditText nim;
    EditText tanggallahir;
    RadioButton radioButton;
    Spinner jurusan;
    Button savedata;
    RadioGroup sex;
    Mahasiswa mhs;
    TextView birthdate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        birthdate = findViewById(R.id.birthDate);
        savedata = findViewById(R.id.btnSave);

        myCalendar = Calendar.getInstance();
        date = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, month);
                myCalendar.set(Calendar.DAY_OF_MONTH, day);

                TextView tglLahir = findViewById(R.id.birthDate);
                String myFormat = "dd-MMMM-yyyy";
                SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);
                tglLahir.setText(sdf.format(myCalendar.getTime()));
            }
        };

        birthdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new DatePickerDialog(MainActivity.this, date,
                        myCalendar.get(Calendar.YEAR),
                        myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });
        savedata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openResultActivity();
            }
        });

    }

    public void checkButton(){
        int radiobtnId = sex.getCheckedRadioButtonId();
        radioButton = findViewById(radiobtnId);
    }

    public void openResultActivity() {
        nama = (EditText)findViewById(R.id.txtName);
        nim = (EditText)findViewById(R.id.txtNim);
        birthdate = (EditText)findViewById(R.id.birthDate);
        jurusan = (Spinner)findViewById(R.id.spJurusan);
        sex = (RadioGroup)findViewById((R.id.rgGender));

        String name = nama.getText().toString();
        String no = nim.getText().toString();
        String date = birthdate.getText().toString();
        checkButton();
        String sex = radioButton.getText().toString();
        String major = jurusan.getSelectedItem().toString();
        Intent intent = new Intent(this, ResultActivity.class);
        intent.putExtra("name", name);
        intent.putExtra("NIM", no);
        intent.putExtra("tanggal", date);
        intent.putExtra("gender", sex);
        intent.putExtra("jurusan", major);

        mhs = new Mahasiswa(name,no,date,sex,major);

        intent.putExtra("MHSOBJ",mhs);

        mhs = new Mahasiswa(name,no,date,sex,major);
        intent.putExtra("parcellable", mhs);

        startActivity(intent);
    }
}