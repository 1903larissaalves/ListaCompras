package com.estudos.listacompras.helper;

import android.widget.EditText;
import com.estudos.listacompras.R;
import com.estudos.listacompras.activity.NovaListaCompraActivity;
import com.estudos.listacompras.model.ListaCompra;

public class NovaListaCompraHelper {

    private final EditText nome;
    private final EditText data;

    private ListaCompra listaCompra;

    public NovaListaCompraHelper(NovaListaCompraActivity activity){
        nome = activity.findViewById(R.id.etNome);
        data = activity.findViewById(R.id.etData);

        listaCompra = new ListaCompra();

    }

    public ListaCompra pegarCompra() {
        listaCompra.setNome(nome.getText().toString());
        listaCompra.setData(data.getText().toString());
        return listaCompra;
    }


    public void preencherDadosListaCompra(ListaCompra listaCompra) {

        nome.setText(listaCompra.getNome());
        data.setText(listaCompra.getData());

        this.listaCompra = listaCompra;

    }
}
