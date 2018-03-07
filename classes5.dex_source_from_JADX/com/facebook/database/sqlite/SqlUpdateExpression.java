package com.facebook.database.sqlite;

import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.database.sqlite.SqlExpression.Expression;
import com.google.common.collect.Iterables;

/* compiled from: searchable */
public class SqlUpdateExpression extends Expression {
    private String f2878a;
    private SqlListExpression f2879b;
    private Expression f2880c;

    /* compiled from: searchable */
    public class SqlUpdateExpressionBuilder {
        public String f2875a;
        public SqlListExpression f2876b;
        public Expression f2877c;

        public final SqlUpdateExpression m4011a() {
            return new SqlUpdateExpression(this);
        }
    }

    public SqlUpdateExpression(SqlUpdateExpressionBuilder sqlUpdateExpressionBuilder) {
        this.f2878a = sqlUpdateExpressionBuilder.f2875a;
        this.f2879b = sqlUpdateExpressionBuilder.f2876b;
        this.f2880c = sqlUpdateExpressionBuilder.f2877c;
    }

    public final String m4012a() {
        return StringFormatUtil.formatStrLocaleSafe("UPDATE %1$s SET %2$s WHERE %3$s", this.f2878a, this.f2879b.a(), this.f2880c.a());
    }

    public final String[] m4013b() {
        return (String[]) Iterables.a(m4014c(), String.class);
    }

    final Iterable<String> m4014c() {
        return Iterables.b(this.f2879b.m4010c(), this.f2880c.c());
    }
}
