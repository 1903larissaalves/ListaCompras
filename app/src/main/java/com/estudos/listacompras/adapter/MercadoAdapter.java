package com.estudos.listacompras.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.estudos.listacompras.R;
import com.estudos.listacompras.model.ItemMercado;
import java.util.ArrayList;

public class MercadoAdapter extends ArrayAdapter<ItemMercado> {


    private Context context;
    private ArrayList<ItemMercado> elementos;

    public MercadoAdapter(Context context, ArrayList<ItemMercado> elementos){
        super(context, R.layout.item_mercado, elementos);
        this.context = context;
        this.elementos = elementos;

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.item_mercado, parent, false);

        TextView produto = (TextView) rowView.findViewById(R.id.item_produto);
        TextView preco = (TextView) rowView.findViewById(R.id.item_preco);
        ImageView imagem = (ImageView) rowView.findViewById(R.id.item_imagem);

        produto.setText(elementos.get(position).getProduto());
        preco.setText(elementos.get(position).getPreco());
        imagem.setImageResource(elementos.get(position).getImagem());

        return rowView;

    }
}
