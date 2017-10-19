package com.example.tiburcio.galletas.Galletas;

import android.content.Context;
import android.database.Cursor;
import android.support.v4.widget.CursorAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.tiburcio.galletas.ProveedorDeContenido.Contrato;
import com.example.tiburcio.galletas.R;

/**
 * Created by Tiburcio on 18/10/2017.
 */

public class GalletasAdapter extends CursorAdapter {
    public GalletasAdapter(Context context) {
        super(context, null, false);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View v = inflater.inflate(R.layout.galletas_item, parent, false);
        bindView(v, context, cursor);
        return v;
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        String marca = cursor.getString(cursor.getColumnIndex(Contrato.Galleta.MARCA));
        int stock = cursor.getInt(cursor.getColumnIndex(Contrato.Galleta.STOCK));

        ((TextView)view.findViewById(R.id.textViewMarca)).setText(marca);
        ((TextView)view.findViewById(R.id.textViewStock)).setText(String.valueOf(stock));
    }
}
