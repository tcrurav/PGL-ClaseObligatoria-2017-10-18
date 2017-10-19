package com.example.tiburcio.galletas.Galletas;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tiburcio.galletas.ProveedorDeContenido.Contrato;
import com.example.tiburcio.galletas.R;

public class GalletasFragmentList extends ListFragment
    implements LoaderManager.LoaderCallbacks<Cursor>{

    GalletasAdapter mAdapter;
    LoaderManager.LoaderCallbacks<Cursor> mCallbacks;

    public GalletasFragmentList() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_galletas, container, false);

        mAdapter = new GalletasAdapter(getActivity());
        setListAdapter(mAdapter);
        return v;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        mCallbacks = this;

        getLoaderManager().initLoader(0, null, mCallbacks);

    }

    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {

        String[] campos = {
                Contrato.Galleta._ID,
                Contrato.Galleta.MARCA,
                Contrato.Galleta.STOCK
        };

        Uri baseUri = Contrato.Galleta.CONTENT_URI;

        String selection = null;

        return new CursorLoader(getActivity(), baseUri,
                campos, selection, null, null);
    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor data) {
        Uri laUriBase = Contrato.Galleta.CONTENT_URI;
        data.setNotificationUri(getActivity().getContentResolver(), laUriBase);

        mAdapter.swapCursor(data);
    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {
        mAdapter.swapCursor(null);
    }
}
