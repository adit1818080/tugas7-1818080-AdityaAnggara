package com.example.sqlite1818080;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainCreate extends AppCompatActivity {
    private MyDatabase db;
    private EditText Emerk, Etipe, Estatus;
    private String Smerk, Stipe, Sstatus;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_create);
        db = new MyDatabase(this);
        Emerk = (EditText) findViewById(R.id.create_merk);
        Etipe = (EditText) findViewById(R.id.create_tipe);
        Estatus = (EditText) findViewById(R.id.create_status);
        Button btnCreate = (Button) findViewById(R.id.create_btn);

        btnCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Smerk = String.valueOf(Emerk.getText());
                Stipe = String.valueOf(Etipe.getText());
                Sstatus = String.valueOf(Estatus.getText());
                if (Smerk.equals("")){
                    Emerk.requestFocus();
                    Toast.makeText(MainCreate.this, "Silahkan isi merk kamera",
                            Toast.LENGTH_SHORT).show();
                } else if (Stipe.equals("")){
                    Etipe.requestFocus();
                    Toast.makeText(MainCreate.this, "Silahkan isi tipe kamera",
                            Toast.LENGTH_SHORT).show();
                } else if (Sstatus.equals("")){
                    Estatus.requestFocus();
                    Toast.makeText(MainCreate.this, "Silahkan isi status kamera",
                            Toast.LENGTH_SHORT).show();
                } else {
                    Emerk.setText("");
                    Etipe.setText("");
                    Estatus.setText("");
                    Toast.makeText(MainCreate.this, "Data berhasil ditambah",
                            Toast.LENGTH_SHORT).show();
                    db.CreateKamera(new Kamera(null, Smerk, Stipe, Sstatus));
                    Intent a = new Intent(MainCreate.this, MainActivity.class);
                    startActivity(a);
                }
            }
        });
    }
}
