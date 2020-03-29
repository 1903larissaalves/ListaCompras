package com.estudos.listacompras.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.estudos.listacompras.model.ListaCompra;
import java.util.ArrayList;
import java.util.List;


public class ListaCompraDAO extends SQLiteOpenHelper {

    public ListaCompraDAO( Context context) {
        super(context, "ListaCompras", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase bancoDados) {
        String sql = "CREATE TABLE ListaCompras (id INTEGER PRIMARY KEY, nome TEXT NOT NULL, data TEXT);";
        bancoDados.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase bancoDados, int oldVersion, int newVersion) {
        String sql ="DROP TABLE IF EXISTS ListaCompras";
        bancoDados.execSQL(sql);
        onCreate(bancoDados);
    }

    public void inserirNovaListaCompras(ListaCompra novaListaCompras) {
        SQLiteDatabase bancoDados = getWritableDatabase();
        ContentValues novaLista = new ContentValues();
        novaLista.put("nome", novaListaCompras.getNome());
        novaLista.put("data", novaListaCompras.getData());

        bancoDados.insert("ListaCompras", null, novaLista);
    }

    public List<ListaCompra> buscarListasCompras() {

        String sql = "SELECT * FROM ListaCompras;";
        SQLiteDatabase bancoDados = getReadableDatabase();
        Cursor cursor = bancoDados.rawQuery(sql, null);

        List<ListaCompra> listasCompras = new ArrayList<ListaCompra>();
        while (cursor.moveToNext()){
            ListaCompra novaListaCompras = new ListaCompra();
            novaListaCompras.setId(cursor.getLong(cursor.getColumnIndex("id")));
            novaListaCompras.setNome(cursor.getString(cursor.getColumnIndex("nome")));
            novaListaCompras.setData(cursor.getString(cursor.getColumnIndex("data")));

            listasCompras.add(novaListaCompras);
        }
        cursor.close();

        return listasCompras;
    }
}
