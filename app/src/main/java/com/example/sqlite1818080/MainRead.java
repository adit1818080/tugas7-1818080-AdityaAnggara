package com.example.sqlite1818080;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;

public class MainRead extends AppCompatActivity implements
        AdapterView.OnItemClickListener{
    private ListView mListView;
    private CustomListAdapter adapter_off;
    private MyDatabase db;
    private List<Kamera> ListKamera = new ArrayList<Kamera>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_read);
        db = new MyDatabase(this);
        adapter_off = new CustomListAdapter(this, ListKamera );
        mListView = (ListView) findViewById(R.id.list_kamera);
        mListView.setAdapter(adapter_off);
        mListView.setOnItemClickListener(this);
        mListView.setClickable(true);
        ListKamera.clear();
        List<Kamera> contacts = db.ReadKamera();
        for (Kamera cn : contacts) {
            Kamera judulModel = new Kamera();
            judulModel.set_id(cn.get_id());
            judulModel.set_merk(cn.get_merk());
            judulModel.set_tipe(cn.get_tipe());
            judulModel.set_status(cn.get_status());
            ListKamera.add(judulModel);
            if ((ListKamera.isEmpty()))
                Toast.makeText(MainRead.this, "Tidak ada data",
                        Toast.LENGTH_SHORT).show();
            else {
            }
        }
    }
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
        Object o = mListView.getItemAtPosition(i);
        Kamera obj_itemDetails = (Kamera) o;
        String Sid = obj_itemDetails.get_id();
        String Smerk = obj_itemDetails.get_merk();
        String Stipe = obj_itemDetails.get_tipe();
        String Sstatus = obj_itemDetails.get_status();
        Intent goUpdel = new Intent(MainRead.this, MainUpdel.class);
        goUpdel.putExtra("Iid", Sid);
        goUpdel.putExtra("Imerk", Smerk);
        goUpdel.putExtra("Itipe", Stipe);
        goUpdel.putExtra("Istatus", Sstatus);
        startActivity(goUpdel);
    }
    @Override
    protected void onResume() {
        super.onResume();
        ListKamera.clear();
        mListView.setAdapter(adapter_off);
        List<Kamera> contacts = db.ReadKamera();
        for (Kamera cn : contacts) {
            Kamera judulModel = new Kamera();
            judulModel.set_id(cn.get_id());
            judulModel.set_merk(cn.get_merk());
            judulModel.set_tipe(cn.get_tipe());
            judulModel.set_status(cn.get_status());
            ListKamera.add(judulModel);
            if ((ListKamera.isEmpty()))
                Toast.makeText(MainRead.this, "Tidak ada data",
                        Toast.LENGTH_SHORT).show();
            else {
            }
        }
    }
}
