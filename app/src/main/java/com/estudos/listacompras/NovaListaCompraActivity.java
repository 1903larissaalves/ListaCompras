package com.estudos.listacompras;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.estudos.listacompras.model.ListaCompra;
import com.estudos.listacompras.model.ItemMercado;

import java.util.ArrayList;

public class NovaListaCompraActivity extends AppCompatActivity {

    private NovaListaCompraHelper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nova_lista_compra);

        ListView lista = (ListView) findViewById(R.id.lista_mercado);
        ArrayAdapter adapter = new MercadoAdapter(this, mostrarItensMercado());
        lista.setAdapter(adapter);

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(), "Item movido para sacola", Toast.LENGTH_SHORT).show();
            }
        });

        helper = new NovaListaCompraHelper(this);

    }

    private ArrayList<ItemMercado> mostrarItensMercado(){
        ArrayList<ItemMercado> itens = new ArrayList<ItemMercado>();

        ItemMercado itemArroz = new ItemMercado(1,"Arroz", "R$: 10,00", R.drawable.arroz);
        itens.add(itemArroz);
        ItemMercado itemFeijao = new ItemMercado(2,"Feijão", "R$: 8,00", R.drawable.feijao);
        itens.add(itemFeijao);
        ItemMercado itemBatata = new ItemMercado(3,"Batata", "R$: 10,00", R.drawable.batata);
        itens.add(itemBatata);
        ItemMercado itemPolenta = new ItemMercado(4,"Polenta", "R$: 12,00", R.drawable.polenta);
        itens.add(itemPolenta);

        return itens;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_novo_item_activity, menu);


        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.salvar_lista_compra){
            ListaCompra listaCompra = helper.pegaCompra();
            Toast.makeText(getApplicationContext(), "ListaCompra " + listaCompra.getId(), Toast.LENGTH_SHORT).show();
            finish();

        }
        return super.onOptionsItemSelected(item);
    }

}
