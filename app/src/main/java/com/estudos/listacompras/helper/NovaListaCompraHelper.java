package com.estudos.listacompras.helper;

import android.widget.EditText;
import com.estudos.listacompras.R;
import com.estudos.listacompras.activity.NovaListaCompraActivity;
import com.estudos.listacompras.model.ListaCompra;

public class NovaListaCompraHelper {

    private final EditText nome;
    private final EditText data;

    public NovaListaCompraHelper(NovaListaCompraActivity activity){
        nome = activity.findViewById(R.id.etNome);
        data = activity.findViewById(R.id.etData);
    }

    public ListaCompra pegarCompra() {
        ListaCompra listaCompra = new ListaCompra();
        listaCompra.setNome(nome.getText().toString());
        listaCompra.setData(data.getText().toString());
        return listaCompra;
    }
}
