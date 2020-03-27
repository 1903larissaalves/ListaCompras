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
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class NovoItemActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_novo_item);

        ListView lista = (ListView) findViewById(R.id.lista_mercado);
        ArrayAdapter adapter = new MercadoAdapter(this, adicionarItens());
        lista.setAdapter(adapter);

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(), "Item movido para sacola", Toast.LENGTH_SHORT).show();
            }
        });

    }

    private ArrayList<Mercado> adicionarItens(){
        ArrayList<Mercado> itens = new ArrayList<Mercado>();

        Mercado itemArroz = new Mercado(1,"Arroz", "R$: 10,00", R.drawable.arroz);
        itens.add(itemArroz);
        Mercado itemFeijao = new Mercado(2,"Feijão", "R$: 8,00", R.drawable.feijao);
        itens.add(itemFeijao);
        Mercado itemBatata = new Mercado(3,"Batata", "R$: 10,00", R.drawable.batata);
        itens.add(itemBatata);
        Mercado itemPolenta = new Mercado(4,"Polenta", "R$: 12,00", R.drawable.polenta);
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
        if (id == R.id.salvar_itens_sacola){
            if(verificarCamposPreenchidos()){
                Toast.makeText(getApplicationContext(), R.string.preencher_campos_obrigatorios, Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(getApplicationContext(), R.string.compra_salva_com_sucesso, Toast.LENGTH_SHORT).show();
                finish();
            }

        }
        return super.onOptionsItemSelected(item);
    }

    private boolean verificarCamposPreenchidos(){

        Boolean verificarCampos= false;

        EditText nome = (EditText) findViewById(R.id.etNome);
        String recuperarNome = nome.getText().toString();

        EditText data = (EditText) findViewById(R.id.etData);
        String recuperarData = data.getText().toString();

        if (recuperarNome.equals("")){
            verificarCampos = true;
            nome.setError("Campo nome obrigatório");
        }

        if (recuperarData.equals("")){
            verificarCampos = true;
            data.setError("Campo data obrigatório");
        }

        return verificarCampos;
    }

}
