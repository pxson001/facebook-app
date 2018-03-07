package com.facebook.crudolib.dbquery.loader.inprocess;

import android.content.Context;
import android.database.Cursor;
import android.support.v4.content.Loader;
import com.facebook.crudolib.dbquery.QueryExecutor;
import com.facebook.crudolib.dbquery.QueryProvider;
import com.facebook.crudolib.dbquery.direct.DirectQueryExecutor;
import com.facebook.saved2.model.Saved2DatabaseProvider;
import java.util.concurrent.ExecutorService;

/* compiled from: ccu_ref */
public final class NoContentProviderQueryExecutor implements QueryExecutor<Loader<Cursor>> {
    private final Context f17867a;
    private final ExecutorService f17868b;
    private final DirectQueryExecutor f17869c;

    public NoContentProviderQueryExecutor(Context context, ExecutorService executorService, Saved2DatabaseProvider saved2DatabaseProvider) {
        this.f17867a = context;
        this.f17868b = executorService;
        this.f17869c = new DirectQueryExecutor(saved2DatabaseProvider);
    }

    public final Object mo1380a(QueryProvider queryProvider) {
        return new NoContentProviderCursorLoader(this.f17867a, this.f17868b, this.f17869c, queryProvider);
    }
}
