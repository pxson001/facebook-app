package com.facebook.graphql.connection.iterator;

import com.facebook.graphql.connection.ConnectionTailLoaderManager.RowIterator;
import com.facebook.graphql.connection.configuration.TailFetchLocation;
import com.facebook.graphql.cursor.database.GraphCursorDatabase.BufferRowMapper;
import com.facebook.graphql.cursor.database.PageInfo;
import com.facebook.graphql.cursor.database.SortKeyHelper;
import com.google.common.collect.ImmutableList;
import java.nio.ByteBuffer;

/* compiled from: webview_total */
public class RetryTailRowIterator implements RowIterator {
    private final TailFetchLocation f265a;
    private final ImmutableList<PageInfo> f266b = ImmutableList.of(TailFetchLocation.m240a(this.f265a, 0));

    public RetryTailRowIterator(TailFetchLocation tailFetchLocation) {
        this.f265a = new TailFetchLocation(SortKeyHelper.b(tailFetchLocation.f260a), tailFetchLocation.f261b, tailFetchLocation.f262c);
    }

    public final TailFetchLocation mo14d() {
        return this.f265a;
    }

    public final boolean mo15e() {
        return false;
    }

    public final ByteBuffer m247a() {
        return null;
    }

    public final BufferRowMapper m248b() {
        return null;
    }

    public final ImmutableList<PageInfo> m249c() {
        return this.f266b;
    }
}
