package com.estudos.listacompras.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import com.estudos.listacompras.R;
import com.estudos.listacompras.dao.ListaCompraDAO;
import com.estudos.listacompras.model.ListaCompra;

import java.util.List;

public class ListasComprasActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listas_compras);

        buscarListasCompras();
        incluirNovaListaCompra();
    }

    @Override
    protected void onResume() {
        buscarListasCompras();
        super.onResume();
    }

    private void buscarListasCompras(){
        ListaCompraDAO listaCompraDAO = new ListaCompraDAO(this);
        List<ListaCompra> listaCompras = listaCompraDAO.buscarListasCompras();
        listaCompraDAO.close();

        ListView lista = (ListView) findViewById(R.id.lista_compras);
        ArrayAdapter<ListaCompra> adapter = new ArrayAdapter<ListaCompra>(this, android.R.layout.simple_list_item_1, listaCompras);
        lista.setAdapter(adapter);
    }

    private void incluirNovaListaCompra(){
        Button incluirNovaLista = (Button) findViewById(R.id.adicionarNovaLista);
        incluirNovaLista.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ListasComprasActivity.this, NovaListaCompraActivity.class);
                startActivity(intent);
            }
        });
    }
}
