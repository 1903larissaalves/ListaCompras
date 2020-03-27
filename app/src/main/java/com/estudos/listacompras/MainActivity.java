package com.estudos.listacompras;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        incluirNovoItemLista();
    }

    private void incluirNovoItemLista(){
        Button incluirItem = (Button) findViewById(R.id.adicionarNovoItem);
        incluirItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, NovoItemActivity.class);
                startActivity(intent);
            }
        });
    }
}
