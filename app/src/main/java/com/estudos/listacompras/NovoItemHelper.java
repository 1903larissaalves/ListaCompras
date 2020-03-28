package com.estudos.listacompras;

import android.widget.EditText;

import com.estudos.listacompras.model.Compra;

public class NovoItemHelper {

    private final EditText nome;
    private final EditText data;

    public NovoItemHelper(NovoItemActivity activity){
        nome = activity.findViewById(R.id.etNome);
        data = activity.findViewById(R.id.etData);
    }

    public Compra pegaCompra() {
        Compra compra = new Compra();
        compra.setNome(nome.getText().toString());
        compra.setNome(nome.getText().toString());
        return compra;
    }
}
