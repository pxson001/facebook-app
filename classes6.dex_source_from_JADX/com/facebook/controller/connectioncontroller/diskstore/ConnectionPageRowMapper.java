package com.facebook.controller.connectioncontroller.diskstore;

import com.facebook.common.util.StringUtil;
import com.facebook.controller.connectioncontroller.common.ConnectionPage;
import com.facebook.flatbuffers.MutableFlattenable;
import com.facebook.graphql.cursor.database.GraphCursorDatabase$BufferRowMapper;
import com.facebook.graphql.cursor.database.SortKeyHelper;
import com.facebook.graphql.executor.GraphQLResponseParser;
import com.google.common.base.Function;
import com.google.common.collect.ImmutableList;
import java.nio.ByteBuffer;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import javax.annotation.Nullable;

/* compiled from: order_time_for_display */
class ConnectionPageRowMapper implements GraphCursorDatabase$BufferRowMapper {
    private final ConnectionPage f8609a;
    private final String f8610b;
    @Nullable
    private final Function<Object, String> f8611c;

    @Nullable
    public static ByteBuffer m12420a(ImmutableList immutableList) {
        int size = immutableList.size();
        int i = 0;
        ByteBuffer byteBuffer = null;
        while (i < size) {
            Object obj = immutableList.get(i);
            if (!(obj instanceof MutableFlattenable)) {
                return null;
            }
            MutableFlattenable mutableFlattenable = (MutableFlattenable) obj;
            if (mutableFlattenable.w_() == null || mutableFlattenable.u_() == 0) {
                return null;
            }
            ByteBuffer byteBuffer2 = mutableFlattenable.w_().a;
            if (byteBuffer2 == null) {
                return null;
            }
            if (byteBuffer != null && byteBuffer != byteBuffer2) {
                return null;
            }
            i++;
            byteBuffer = byteBuffer2;
        }
        return byteBuffer;
    }

    public static String m12419a(String str) {
        return "cc_dedupe_key:" + str;
    }

    public static Collection<String> m12421a(Object obj, @Nullable Function<Object, String> function) {
        Collection<String> a = GraphQLResponseParser.a(obj);
        if (function != null) {
            String str = (String) function.apply(obj);
            if (!StringUtil.a(str)) {
                Set hashSet = new HashSet(a);
                hashSet.add(m12419a(str));
                return hashSet;
            }
        }
        return a;
    }

    ConnectionPageRowMapper(ConnectionPage<?> connectionPage, String str, @Nullable Function<Object, String> function) {
        this.f8609a = connectionPage;
        this.f8610b = str;
        this.f8611c = function;
    }

    public final int mo955a() {
        return this.f8609a.f8599b.size();
    }

    private MutableFlattenable m12422f(int i) {
        return (MutableFlattenable) this.f8609a.f8599b.get(i);
    }

    public final int mo956a(int i) {
        return m12422f(i).u_();
    }

    public final Class<? extends MutableFlattenable> mo957b(int i) {
        return m12422f(i).getClass();
    }

    public final String mo958c(int i) {
        return SortKeyHelper.m17615b(this.f8610b, i);
    }

    public final Collection<String> mo959d(int i) {
        return m12421a(m12422f(i), this.f8611c);
    }

    public final int mo960e(int i) {
        return 0;
    }
}
