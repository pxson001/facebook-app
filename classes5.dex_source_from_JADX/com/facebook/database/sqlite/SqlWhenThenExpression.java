package com.facebook.database.sqlite;

import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.database.sqlite.SqlExpression.Expression;
import com.google.common.collect.Iterables;
import java.util.Collections;

/* compiled from: search_suggest_query */
public class SqlWhenThenExpression extends Expression {
    private Expression f2883a;
    private String f2884b;

    /* compiled from: search_suggest_query */
    public class SqlWhenThenExpressionBuilder {
        public Expression f2881a;
        public String f2882b;

        public final SqlWhenThenExpression m4015a() {
            return new SqlWhenThenExpression(this);
        }
    }

    public SqlWhenThenExpression(SqlWhenThenExpressionBuilder sqlWhenThenExpressionBuilder) {
        this.f2883a = sqlWhenThenExpressionBuilder.f2881a;
        this.f2884b = sqlWhenThenExpressionBuilder.f2882b;
    }

    public final String m4016a() {
        return StringFormatUtil.formatStrLocaleSafe("WHEN %1$s THEN ?", this.f2883a.a());
    }

    public final String[] m4017b() {
        return (String[]) Iterables.a(m4018c(), String.class);
    }

    final Iterable<String> m4018c() {
        return Iterables.b(this.f2883a.c(), Collections.singleton(this.f2884b));
    }
}
