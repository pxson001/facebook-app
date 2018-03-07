package com.facebook.database.sqlite;

import com.facebook.common.util.SqlUtil;
import com.facebook.database.sqlite.SqlExpression.Expression;
import com.google.common.base.Functions.ToStringFunction;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.google.common.collect.Iterables;
import java.util.Collection;
import java.util.Collections;

/* compiled from: user_storage_key */
class SqlExpression$InExpression extends Expression {
    private final String f11231a;
    private final Collection<?> f11232b;
    private final Collection<?> f11233c;
    private final boolean f11234d;

    public SqlExpression$InExpression(String str, Collection<?> collection, boolean z) {
        this.f11231a = (String) Preconditions.checkNotNull(str);
        Preconditions.checkNotNull(collection);
        this.f11232b = collection.size() < 450 ? collection : Collections.emptyList();
        if (collection.size() < 450) {
            collection = Collections.emptyList();
        }
        this.f11233c = collection;
        this.f11234d = z;
    }

    public SqlExpression$InExpression(String str, Collection<?> collection) {
        this(str, collection, false);
    }

    public final String m11650a() {
        return this.f11231a + (this.f11234d ? " NOT" : "") + " IN " + (this.f11232b.isEmpty() ? SqlUtil.m14313a(this.f11233c) : "(?" + Strings.repeat(",?", this.f11232b.size() - 1) + ")");
    }

    public final String[] m11651b() {
        return (String[]) Iterables.a(m11652c(), String.class);
    }

    final Iterable<String> m11652c() {
        return Iterables.a(this.f11232b, ToStringFunction.INSTANCE);
    }
}
