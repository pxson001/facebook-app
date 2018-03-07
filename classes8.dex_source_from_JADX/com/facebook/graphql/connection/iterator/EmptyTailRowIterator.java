package com.facebook.graphql.connection.iterator;

import com.facebook.graphql.connection.ConnectionTailLoaderManager.RowIterator;
import com.facebook.graphql.connection.configuration.TailFetchLocation;
import com.facebook.graphql.cursor.database.GraphCursorDatabase.BufferRowMapper;
import com.facebook.graphql.cursor.database.PageInfo;
import com.google.common.collect.ImmutableList;
import java.nio.ByteBuffer;

/* compiled from: webview_type */
public class EmptyTailRowIterator implements RowIterator {
    private final TailFetchLocation f263a;
    private final ImmutableList<PageInfo> f264b;

    public EmptyTailRowIterator(TailFetchLocation tailFetchLocation) {
        this(tailFetchLocation, null, false);
    }

    private EmptyTailRowIterator(TailFetchLocation tailFetchLocation, String str, boolean z) {
        this.f263a = TailFetchLocation.m239a(tailFetchLocation, str, z);
        this.f264b = ImmutableList.of(TailFetchLocation.m240a(this.f263a, 0));
    }

    public final TailFetchLocation mo14d() {
        return this.f263a;
    }

    public final boolean mo15e() {
        return false;
    }

    public final ByteBuffer m242a() {
        return null;
    }

    public final BufferRowMapper m243b() {
        return null;
    }

    public final ImmutableList<PageInfo> m244c() {
        return this.f264b;
    }
}
