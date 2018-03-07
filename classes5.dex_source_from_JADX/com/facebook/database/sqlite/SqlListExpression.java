package com.facebook.database.sqlite;

import com.facebook.database.sqlite.SqlExpression.Expression;
import com.google.common.base.Function;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import java.util.List;

/* compiled from: secondary_action_text */
public class SqlListExpression extends Expression {
    private final List<Expression> f2873a = Lists.a();

    /* compiled from: secondary_action_text */
    class C02041 implements Function<Expression, Iterable<String>> {
        final /* synthetic */ SqlListExpression f2872a;

        C02041(SqlListExpression sqlListExpression) {
            this.f2872a = sqlListExpression;
        }

        public Object apply(Object obj) {
            return ((Expression) obj).c();
        }
    }

    public final void m4008a(Expression expression) {
        this.f2873a.add(expression);
    }

    public final String m4007a() {
        if (this.f2873a.isEmpty()) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        Object obj = 1;
        for (Expression expression : this.f2873a) {
            if (obj == null) {
                stringBuilder.append(",");
            }
            stringBuilder.append(expression.a());
            obj = null;
        }
        return stringBuilder.toString();
    }

    public final String[] m4009b() {
        return (String[]) Iterables.a(m4010c(), String.class);
    }

    final Iterable<String> m4010c() {
        return Iterables.f(Iterables.a(this.f2873a, new C02041(this)));
    }
}
