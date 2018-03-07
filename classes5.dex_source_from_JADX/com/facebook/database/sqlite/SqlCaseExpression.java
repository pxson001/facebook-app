package com.facebook.database.sqlite;

import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.database.sqlite.SqlExpression.Expression;
import com.google.common.base.Function;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import java.util.List;

/* compiled from: secondary_button_intent_url */
public class SqlCaseExpression extends Expression {
    private String f2868a;
    private ImmutableList<Expression> f2869b;

    /* compiled from: secondary_button_intent_url */
    class C02031 implements Function<Expression, Iterable<String>> {
        final /* synthetic */ SqlCaseExpression f2865a;

        C02031(SqlCaseExpression sqlCaseExpression) {
            this.f2865a = sqlCaseExpression;
        }

        public Object apply(Object obj) {
            return ((Expression) obj).c();
        }
    }

    /* compiled from: secondary_button_intent_url */
    public class SqlCaseExpressionBuilder {
        public String f2866a;
        public final List<Expression> f2867b = Lists.a();

        public final SqlCaseExpressionBuilder m3999a(Expression expression) {
            this.f2867b.add(expression);
            return this;
        }

        public final SqlCaseExpression m4000a() {
            return new SqlCaseExpression(this);
        }
    }

    public SqlCaseExpression(SqlCaseExpressionBuilder sqlCaseExpressionBuilder) {
        this.f2868a = sqlCaseExpressionBuilder.f2866a;
        this.f2869b = ImmutableList.copyOf(sqlCaseExpressionBuilder.f2867b);
    }

    public final String m4001a() {
        if (this.f2869b.isEmpty()) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(StringFormatUtil.formatStrLocaleSafe("%1$s = CASE ", this.f2868a));
        int size = this.f2869b.size();
        for (int i = 0; i < size; i++) {
            stringBuilder.append(((Expression) this.f2869b.get(i)).a());
            stringBuilder.append(" ");
        }
        stringBuilder.append("END");
        return stringBuilder.toString();
    }

    public final String[] m4002b() {
        return (String[]) Iterables.a(m4003c(), String.class);
    }

    final Iterable<String> m4003c() {
        return Iterables.f(Iterables.a(this.f2869b, new C02031(this)));
    }
}
