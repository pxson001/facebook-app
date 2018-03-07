package com.facebook.graphql.connection.iterator;

import com.facebook.flatbuffers.MutableFlattenable;
import com.facebook.graphql.connection.ConnectionTailLoaderManager.RowIterator;
import com.facebook.graphql.connection.configuration.TailFetchLocation;
import com.facebook.graphql.cursor.database.GraphCursorDatabase.BufferRowMapper;
import com.facebook.graphql.cursor.database.PageInfo;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import java.nio.ByteBuffer;

/* compiled from: webview_URL */
public class TailRowIterator implements RowIterator {
    private final MutableFlattenable f269a;
    private final BufferRowMapper f270b;
    private final boolean f271c;
    private final TailFetchLocation f272d;
    private final ImmutableList<PageInfo> f273e;

    public TailRowIterator(MutableFlattenable mutableFlattenable, BufferRowMapper bufferRowMapper, ImmutableList<PageInfo> immutableList, boolean z, TailFetchLocation tailFetchLocation) {
        this.f269a = (MutableFlattenable) Preconditions.checkNotNull(mutableFlattenable);
        Preconditions.checkNotNull(mutableFlattenable.w_());
        this.f270b = (BufferRowMapper) Preconditions.checkNotNull(bufferRowMapper);
        this.f273e = (ImmutableList) Preconditions.checkNotNull(immutableList);
        this.f271c = z;
        this.f272d = (TailFetchLocation) Preconditions.checkNotNull(tailFetchLocation);
    }

    public final ByteBuffer m258a() {
        return this.f269a.w_().a;
    }

    public final BufferRowMapper m259b() {
        return this.f270b;
    }

    public final ImmutableList<PageInfo> m260c() {
        return this.f273e;
    }

    public final TailFetchLocation mo14d() {
        return this.f272d;
    }

    public final boolean mo15e() {
        return this.f271c;
    }
}
