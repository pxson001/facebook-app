package com.facebook.database.sqlite;

import com.facebook.database.sqlite.SqlExpression.Expression;
import com.google.common.base.Preconditions;

/* compiled from: user_storage_key */
class SqlExpression$NotExpression extends Expression {
    private Expression f13296a;

    public SqlExpression$NotExpression(Expression expression) {
        Preconditions.checkNotNull(expression);
        this.f13296a = expression;
    }

    public final String m14183a() {
        return "NOT (" + this.f13296a.a() + ")";
    }

    public final String[] m14184b() {
        return this.f13296a.b();
    }

    final Iterable<String> m14185c() {
        return this.f13296a.c();
    }
}
