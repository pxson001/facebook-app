package com.facebook.controller.connectioncontroller.diskstore;

import com.facebook.controller.connectioncontroller.common.ConnectionPage;
import com.facebook.flatbuffers.MutableFlattenable;
import com.facebook.graphql.cursor.database.SortKeyHelper;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import java.util.Collection;
import javax.annotation.Nullable;

/* compiled from: ordered_images */
public class ConnectionPageRowIterator {
    private final ConnectionPage<?> f8605a;
    private final String f8606b;
    @Nullable
    private final Function<Object, String> f8607c;
    private int f8608d = -1;

    ConnectionPageRowIterator(ConnectionPage<?> connectionPage, String str, @Nullable Function<Object, String> function) {
        this.f8605a = (ConnectionPage) Preconditions.checkNotNull(connectionPage);
        this.f8606b = str;
        this.f8607c = function;
    }

    public final boolean m12408a() {
        this.f8608d++;
        return this.f8608d < this.f8605a.f8599b.size();
    }

    public final MutableFlattenable m12409b() {
        return (MutableFlattenable) this.f8605a.f8599b.get(this.f8608d);
    }

    public final String m12410c() {
        return SortKeyHelper.m17615b(this.f8606b, this.f8608d);
    }

    public final Collection<String> m12411d() {
        return ConnectionPageRowMapper.m12421a(m12409b(), this.f8607c);
    }

    public final int m12412e() {
        return 0;
    }
}
