package com.example.sqlite1818080;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class MyDatabase extends SQLiteOpenHelper {
    private static int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "db_kamera";
    private static final String tb_kamera = "tb_kamera";
    private static final String tb_tk_id = "id";
    private static final String tb_tk_merk = "merk";
    private static final String tb_tk_tipe = "tipe";
    private static final String tb_tk_status = "status";
    private static final String CREATE_TABLE_KAMERA = "CREATE TABLE " +
            tb_kamera + "("
            + tb_tk_id + " INTEGER PRIMARY KEY ,"
            + tb_tk_merk + " TEXT,"
            + tb_tk_tipe + " TEXT,"
            + tb_tk_status + " TEXT " + ")";

    public MyDatabase (Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_KAMERA);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void CreateKamera (Kamera mdNotif) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(tb_tk_id, mdNotif.get_id());
        values.put(tb_tk_merk, mdNotif.get_merk());
        values.put(tb_tk_tipe, mdNotif.get_tipe());
        values.put(tb_tk_status, mdNotif.get_status());
        db.insert(tb_kamera, null, values);
        db.close();
    }

    public List<Kamera> ReadKamera() {
        List<Kamera> judulModelList = new ArrayList<Kamera>();
        String selectQuery = "SELECT * FROM " + tb_kamera;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                Kamera mdKontak = new Kamera();
                mdKontak.set_id(cursor.getString(0));
                mdKontak.set_merk(cursor.getString(1));
                mdKontak.set_tipe(cursor.getString(2));
                mdKontak.set_status(cursor.getString(3));
                judulModelList.add(mdKontak);
            } while (cursor.moveToNext());
        }
        db.close();
        return judulModelList;
    }
    public int UpdateKamera (Kamera mdNotif) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(tb_tk_merk, mdNotif.get_merk());
        values.put(tb_tk_tipe, mdNotif.get_tipe());
        values.put(tb_tk_status, mdNotif.get_status());
        return db.update(tb_kamera, values, tb_tk_id + " = ?",
                new String[] { String.valueOf(mdNotif.get_id())});
    }
    public void DeleteKamera (Kamera mdNotif) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(tb_kamera, tb_tk_id+ " = ?",
                new String[]{String.valueOf(mdNotif.get_id())});
        db.close();
    }
}
