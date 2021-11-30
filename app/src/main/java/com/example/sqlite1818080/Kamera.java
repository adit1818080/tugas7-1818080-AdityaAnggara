package com.example.sqlite1818080;

public class Kamera
{
    private String _id, _merk, _tipe, _status;
    public Kamera(String id, String merk, String tipe, String status)
    {
        this._id = id;
        this._merk = merk;
        this._tipe = tipe;
        this._status = status;
    }
    public Kamera(){
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String get_merk() {
        return _merk;
    }

    public void set_merk(String _merk) {
        this._merk = _merk;
    }

    public String get_tipe() {
        return _tipe;
    }

    public void set_tipe(String _tipe) {
        this._tipe = _tipe;
    }

    public String get_status() {
        return _status;
    }

    public void set_status(String _status) {
        this._status = _status;
    }
}
