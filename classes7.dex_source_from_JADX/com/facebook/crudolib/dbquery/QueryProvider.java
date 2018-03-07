package com.facebook.crudolib.dbquery;

import android.database.Cursor;
import com.facebook.crudolib.dao.DAOItem;

/* compiled from: cf9dfdfb89b551be6a9138fc4e1e51ae */
public interface QueryProvider<T extends DAOItem> {
    T m21694a(Cursor cursor);

    Object[] m21695a();

    Object[] m21696b();
}
