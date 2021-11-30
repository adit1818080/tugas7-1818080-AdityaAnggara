package com.example.sqlite1818080;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainUpdel extends AppCompatActivity {
    private MyDatabase db;
    private String Sid, Smerk, Stipe, Sstatus;
    private EditText Emerk, Etipe, Estatus;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_updel);
        db = new MyDatabase(this);
        Intent i = this.getIntent();
        Sid = i.getStringExtra("Iid");
        Smerk = i.getStringExtra("Imerk");
        Stipe = i.getStringExtra("Itipe");
        Sstatus = i.getStringExtra("Istatus");

        Emerk = (EditText) findViewById(R.id.updel_merk);
        Etipe = (EditText) findViewById(R.id.updel_tipe);
        Estatus = (EditText) findViewById(R.id.updel_status);

        Emerk.setText(Smerk);
        Etipe.setText(Stipe);
        Estatus.setText(Sstatus);

        Button btnUpdate = (Button) findViewById(R.id.btn_up);
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Smerk = String.valueOf(Emerk.getText());
                Stipe = String.valueOf(Etipe.getText());
                Sstatus = String.valueOf(Estatus.getText());
                if (Smerk.equals("")){
                    Emerk.requestFocus();
                    Toast.makeText(MainUpdel.this, "Silahkan isi merk kamera",
                            Toast.LENGTH_SHORT).show();
                } else if (Stipe.equals("")){
                    Etipe.requestFocus();
                    Toast.makeText(MainUpdel.this, "Silahkan isi tipe kamera",
                            Toast.LENGTH_SHORT).show();
                } else if (Sstatus.equals("")){
                    Etipe.requestFocus();
                    Toast.makeText(MainUpdel.this, "Silahkan isi status kamera",
                            Toast.LENGTH_SHORT).show();
                } else {
                    db.UpdateKamera(new Kamera(Sid, Smerk, Stipe, Sstatus));
                    Toast.makeText(MainUpdel.this, "Data telah diupdate",
                            Toast.LENGTH_SHORT).show();
                    finish();
                }
            }
        });
        Button btnDelete = (Button) findViewById(R.id.btn_del);
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db.DeleteKamera(new Kamera(Sid, Smerk, Stipe, Sstatus));
                Toast.makeText(MainUpdel.this, "Data telah dihapus",
                        Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }
}
