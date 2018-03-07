package com.facebook.database.sqlite;

import com.google.common.base.Function;
import com.google.common.base.Joiner;
import com.google.common.base.Strings;
import com.google.common.collect.Collections2;
import com.google.common.collect.ImmutableList;
import javax.annotation.Nullable;

/* compiled from: to */
public final class SqlKeys {
    public static final Function<SqlKey, String> f932a = new C00611();

    /* compiled from: to */
    final class C00611 implements Function<SqlKey, String> {
        C00611() {
        }

        public final Object apply(@Nullable Object obj) {
            return ((SqlKey) obj).a();
        }
    }

    /* compiled from: to */
    public class ForeignKey implements SqlKey {
        private final ImmutableList<SqlColumn> f11265a;
        private final String f11266b;
        private final ImmutableList<SqlColumn> f11267c;
        @Nullable
        private final String f11268d;

        public ForeignKey(ImmutableList<SqlColumn> immutableList, String str, ImmutableList<SqlColumn> immutableList2) {
            this(immutableList, str, immutableList2, null);
        }

        public ForeignKey(ImmutableList<SqlColumn> immutableList, String str, ImmutableList<SqlColumn> immutableList2, @Nullable String str2) {
            this.f11265a = immutableList;
            this.f11266b = str;
            this.f11267c = immutableList2;
            this.f11268d = str2;
        }

        public final String m11681a() {
            StringBuilder stringBuilder = new StringBuilder();
            if (this.f11265a == null || this.f11265a.isEmpty() || this.f11266b == null || this.f11267c == null || this.f11267c.isEmpty()) {
                throw new UnsupportedOperationException("All fields for foreign key must be specified");
            }
            stringBuilder.append("FOREIGN KEY (");
            stringBuilder.append(Joiner.on(", ").join(Collections2.a(this.f11265a, SqlColumn.c)));
            stringBuilder.append(") REFERENCES ");
            stringBuilder.append(this.f11266b);
            stringBuilder.append(" (");
            stringBuilder.append(Joiner.on(", ").join(Collections2.a(this.f11267c, SqlColumn.c)));
            stringBuilder.append(")");
            if (!Strings.isNullOrEmpty(this.f11268d)) {
                stringBuilder.append(" ").append(this.f11268d);
            }
            return stringBuilder.toString();
        }
    }
}
