package com.example.kalorimakanan;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class hitung extends AppCompatActivity {

    int hasil = 0 ;
    CardView btnCount;
    EditText tinggi, berat, umur;
    RadioGroup RgGender;
    String RbGender, data1, data2, data3;
    TextView txhasil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hitung);

        RgGender = findViewById(R.id.Gender);
        tinggi = findViewById(R.id.txTinggi);
        berat = findViewById(R.id.txBerat);
        umur = findViewById(R.id.txUmur);

        txhasil = findViewById(R.id.textView5);

        btnCount = findViewById(R.id.btnHitung);

        RgGender.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (RgGender.getCheckedRadioButtonId()) {
                    case R.id.laki:
                        RbGender = "Laki-laki";
                        break;
                    case R.id.wanita:
                        RbGender = "Wanita";
                        break;
                }
            }
        });

        btnCount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (umur.getText().toString().isEmpty()){
                    Toast.makeText(getApplicationContext(), "Umur tidak boleh kosong!", Toast.LENGTH_SHORT).show();
                }else if(RbGender.isEmpty()){
                    Toast.makeText(getApplicationContext(), "Gender tidak boleh kosong!", Toast.LENGTH_SHORT).show();
                }else if(tinggi.getText().toString().isEmpty()){
                    Toast.makeText(getApplicationContext(), "Tinggi tidak boleh kosong!", Toast.LENGTH_SHORT).show();
                }else if(berat.getText().toString().isEmpty()){
                    Toast.makeText(getApplicationContext(), "Berat tidak boleh kosong!", Toast.LENGTH_SHORT).show();
                }else {
                    int kg = 0, tall = 0, old = 0;
                    kg = Integer.parseInt(berat.getText().toString().trim());
                    old = Integer.parseInt(umur.getText().toString().trim());
                    tall = Integer.parseInt(tinggi.getText().toString().trim());
                        if(RbGender.equals("Laki-laki")){
                            hasil = (int) Math.round(1.2 * (66 + (13.7 * kg) + (5 * tall) - (6.8 * old)));
                            txhasil.setText(String.valueOf("Kalori Yang Dibutuhkan "+hasil +" /Hari"));
                        }else if(RbGender.equals("Wanita")){
                            hasil = (int) Math.round(1.2*(655 + (9.6 * kg) + (1.8 * tall) - (4.7 * old)));
                            txhasil.setText(String.valueOf("Kalori Yang Dibutuhkan "+hasil +" /Hari"));
                        }
                }
            }
        });



    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(hitung.this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}
