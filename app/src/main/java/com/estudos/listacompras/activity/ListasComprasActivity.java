package com.estudos.listacompras.activity;


import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;
import com.estudos.listacompras.R;
import com.estudos.listacompras.dao.ListaCompraDAO;
import com.estudos.listacompras.model.ListaCompra;

import java.util.List;

public class ListasComprasActivity extends AppCompatActivity {

    private ListView lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listas_compras);

        lista = (ListView) findViewById(R.id.lista_compras);

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ListaCompra listaCompra = (ListaCompra) lista.getItemAtPosition(position);
                Intent intent = new Intent(ListasComprasActivity.this, NovaListaCompraActivity.class);
                intent.putExtra("ListaCompras", listaCompra);
                startActivity(intent);
            }
        });

        buscarListasCompras();
        incluirNovaListaCompra();
        registerForContextMenu(lista);
    }

    @Override
    protected void onResume() {
        buscarListasCompras();
        super.onResume();
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, final ContextMenu.ContextMenuInfo menuInfo) {
       MenuItem deletar =  menu.add("Deletar");
       deletar.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
           @Override
           public boolean onMenuItemClick(MenuItem item) {

               AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) menuInfo;
               ListaCompra listaCompra = (ListaCompra) lista.getItemAtPosition(info.position);


               ListaCompraDAO litaDao = new ListaCompraDAO(ListasComprasActivity.this);
               litaDao.deletarListaCompras(listaCompra);
               litaDao.close();
               buscarListasCompras();
               Toast.makeText(ListasComprasActivity.this, "Lista " + listaCompra.getNome() + " deletada comm sucesso!", Toast.LENGTH_SHORT).show();



               return false;
           }
       });
    }

    private void buscarListasCompras(){
        ListaCompraDAO listaCompraDAO = new ListaCompraDAO(this);
        List<ListaCompra> listaCompras = listaCompraDAO.buscarListasCompras();
        listaCompraDAO.close();


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
