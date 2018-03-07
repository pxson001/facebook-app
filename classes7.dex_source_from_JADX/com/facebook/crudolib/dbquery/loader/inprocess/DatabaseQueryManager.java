package com.facebook.crudolib.dbquery.loader.inprocess;

import android.database.Cursor;
import android.support.v4.app.LoaderManager;
import android.support.v4.app.LoaderManager.LoaderCallbacks;
import android.support.v4.content.Loader;
import com.facebook.crudolib.dao.DAOItem;
import com.facebook.crudolib.dbquery.QueryExecutor;
import com.facebook.crudolib.dbquery.QueryProvider;
import com.facebook.crudolib.mutableprimitive.MutableInt;

/* compiled from: center item's drawable hierarchy was not properly set up */
public class DatabaseQueryManager {
    public final LoaderManager f17848a;
    private final MutableInt f17849b;
    public final QueryExecutor<Loader<Cursor>> f17850c;

    public DatabaseQueryManager(LoaderManager loaderManager, QueryExecutor<Loader<Cursor>> queryExecutor, MutableInt mutableInt) {
        this.f17848a = loaderManager;
        this.f17850c = queryExecutor;
        this.f17849b = mutableInt;
    }

    public final <T extends DAOItem> int m21700a(final QueryProvider<T> queryProvider, final OnDataCallback<? super T> onDataCallback) {
        MutableInt mutableInt = this.f17849b;
        int i = mutableInt.f17881a;
        mutableInt.f17881a = i + 1;
        this.f17848a.a(i, null, new LoaderCallbacks<Cursor>(this) {
            final /* synthetic */ DatabaseQueryManager f17847c;

            public final void m21699a(Loader loader, Object obj) {
                onDataCallback.m21722a(queryProvider.m21694a((Cursor) obj));
            }

            public final Loader<Cursor> n_(int i) {
                return (Loader) this.f17847c.f17850c.mo1380a(queryProvider);
            }

            public final void gA_() {
                onDataCallback.m21721a();
            }
        });
        return i;
    }
}
