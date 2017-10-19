package com.example.tiburcio.galletas.ProveedorDeContenido;

import android.net.Uri;
import android.provider.BaseColumns;

/**
 * Created by Tiburcio on 18/10/2017.
 */

public class Contrato {
    public final static String AUTORIDAD = "com.example.tiburcio.galletas.ProveedorDeContenido.Proveedor";

    public static class Galleta implements BaseColumns{
        public final static String NOMBRE_TABLA = "Galleta";
        public final static Uri CONTENT_URI = Uri.parse("content://" +
                AUTORIDAD + "/" + NOMBRE_TABLA);

        public final static String MARCA = "Marca";
        public final static String STOCK = "Stock";
    }
}
