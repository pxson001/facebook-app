package com.facebook.database.sqlite;

import com.google.common.base.Function;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/* compiled from: rtt_variance */
public class SqlExpression {

    /* compiled from: rtt_variance */
    class AndExpression extends ConjunctionExpression {
        public AndExpression() {
            super("AND");
        }
    }

    /* compiled from: rtt_variance */
    public class ConjunctionExpression extends Expression {
        private final String f6346a;
        private final List<Expression> f6347b = Lists.m1296a();

        /* compiled from: rtt_variance */
        class C02791 implements Function<Expression, Iterable<String>> {
            final /* synthetic */ ConjunctionExpression f6364a;

            C02791(ConjunctionExpression conjunctionExpression) {
                this.f6364a = conjunctionExpression;
            }

            public Object apply(Object obj) {
                return ((Expression) obj).mo1478c();
            }
        }

        public ConjunctionExpression(String str) {
            this.f6346a = str;
        }

        public final void m10741a(Expression expression) {
            this.f6347b.add(expression);
        }

        public final String mo1476a() {
            if (this.f6347b.isEmpty()) {
                return "";
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("(");
            Object obj = 1;
            for (Expression expression : this.f6347b) {
                if (obj == null) {
                    stringBuilder.append(" ");
                    stringBuilder.append(this.f6346a);
                    stringBuilder.append(" ");
                }
                stringBuilder.append(expression.mo1476a());
                obj = null;
            }
            stringBuilder.append(")");
            return stringBuilder.toString();
        }

        public final String[] mo1477b() {
            return (String[]) Iterables.m957a(mo1478c(), String.class);
        }

        final Iterable<String> mo1478c() {
            return Iterables.m972f(Iterables.m945a(this.f6347b, new C02791(this)));
        }
    }

    /* compiled from: rtt_variance */
    public abstract class Expression {
        public abstract String mo1476a();

        public abstract String[] mo1477b();

        abstract Iterable<String> mo1478c();
    }

    /* compiled from: rtt_variance */
    class EqualityExpression extends BinaryExpression {
        public EqualityExpression(String str, String str2) {
            super(str, str2, "=");
        }
    }

    /* compiled from: rtt_variance */
    class BinaryExpression extends Expression {
        private final String f6348a;
        private final String f6349b;
        private final String f6350c;

        public BinaryExpression(String str, String str2, String str3) {
            this.f6348a = str;
            this.f6349b = str2;
            this.f6350c = str3;
        }

        public final String mo1476a() {
            return this.f6348a + this.f6350c + "?";
        }

        public final String[] mo1477b() {
            return new String[]{this.f6349b};
        }

        final Iterable mo1478c() {
            return Collections.singleton(this.f6349b);
        }
    }

    /* compiled from: rtt_variance */
    class GteExpression extends BinaryExpression {
        public GteExpression(String str, String str2) {
            super(str, str2, ">=");
        }
    }

    public static ConjunctionExpression m10722a() {
        return new AndExpression();
    }

    public static ConjunctionExpression m10723a(Expression... expressionArr) {
        ConjunctionExpression andExpression = new AndExpression();
        for (Expression a : expressionArr) {
            andExpression.m10741a(a);
        }
        return andExpression;
    }

    public static ConjunctionExpression m10730b() {
        return new OrExpression();
    }

    public static ConjunctionExpression m10731b(Expression... expressionArr) {
        OrExpression orExpression = new OrExpression();
        for (Expression a : expressionArr) {
            orExpression.m10741a(a);
        }
        return orExpression;
    }

    public static Expression m10727a(String str, String str2) {
        return new EqualityExpression(str, str2);
    }

    public static Expression m10733b(String str, String str2) {
        return new LtExpression(str, str2);
    }

    public static Expression m10736c(String str, String str2) {
        return new LteExpression(str, str2);
    }

    public static Expression m10737d(String str, String str2) {
        return new LikeExpression(str, str2);
    }

    public static Expression m10738e(String str, String str2) {
        return new GtExpression(str, str2);
    }

    public static Expression m10739f(String str, String str2) {
        return new GteExpression(str, str2);
    }

    public static Expression m10728a(String str, Collection<?> collection) {
        return new InExpression(str, collection);
    }

    public static Expression m10729a(String str, String... strArr) {
        return m10728a(str, Arrays.asList(strArr));
    }

    public static Expression m10726a(String str, Iterable<?> iterable) {
        return m10728a(str, Lists.m1298a((Iterable) iterable));
    }

    public static Expression m10734b(String str, Collection<?> collection) {
        return new InExpression(str, collection, true);
    }

    public static Expression m10735b(String str, String... strArr) {
        return m10734b(str, Arrays.asList(strArr));
    }

    public static Expression m10724a(Expression expression) {
        return new NotExpression(expression);
    }

    public static Expression m10725a(String str) {
        return new FieldNotNullExpression(str);
    }

    public static Expression m10732b(String str) {
        return new RawExpression(str);
    }
}
