package com.estudos.listacompras;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ListasComprasActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listas_compras);

        incluirNovaListaCompra();
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
