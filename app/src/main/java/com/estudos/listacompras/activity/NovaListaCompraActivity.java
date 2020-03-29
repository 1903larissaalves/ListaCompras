package com.estudos.listacompras.activity;

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
import com.estudos.listacompras.adapter.MercadoAdapter;
import com.estudos.listacompras.helper.NovaListaCompraHelper;
import com.estudos.listacompras.R;
import com.estudos.listacompras.dao.ListaCompraDAO;
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
        ItemMercado itemCebola = new ItemMercado(5,"Cebola", "R$: 2,00", R.drawable.cebola);
        itens.add(itemCebola);
        ItemMercado itemBife = new ItemMercado(6,"Bife", "R$: 22,00", R.drawable.bife);
        itens.add(itemBife);
        ItemMercado itemSuco = new ItemMercado(7,"Suco", "R$: 3,00", R.drawable.suco);
        itens.add(itemSuco);

        return itens;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_novo_item_activity, menu);


        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.salvar_lista_compra){
            ListaCompra listaCompra = helper.pegarCompra();

            ListaCompraDAO novaListaCompras = new ListaCompraDAO(this);
            novaListaCompras.inserirNovaListaCompras(listaCompra);
            novaListaCompras.close();

            Toast.makeText(getApplicationContext(), "Lista salva com sucesso! " + listaCompra.getNome(), Toast.LENGTH_SHORT).show();
            finish();

        }
        return super.onOptionsItemSelected(item);
    }

}
