package com.facebook.crudolib.dbquery.direct;

import android.database.Cursor;
import com.facebook.crudolib.dbquery.QueryExecutor;
import com.facebook.crudolib.dbquery.QueryProvider;
import com.facebook.saved2.model.Saved2DatabaseProvider;

/* compiled from: center_location */
public class DirectQueryExecutor implements QueryExecutor<Cursor> {
    private final Saved2DatabaseProvider f17844a;

    public final /* synthetic */ Object mo1380a(QueryProvider queryProvider) {
        return m21698b(queryProvider);
    }

    public DirectQueryExecutor(Saved2DatabaseProvider saved2DatabaseProvider) {
        this.f17844a = saved2DatabaseProvider;
    }

    public final Cursor m21698b(QueryProvider queryProvider) {
        Object[] b = queryProvider.m21696b();
        return this.f17844a.a().query((String) b[0], (String[]) b[1], (String) b[2], (String[]) b[3], null, null, (String) b[4]);
    }
}
