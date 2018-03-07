package com.facebook.database.sqlite;

import com.facebook.database.sqlite.SqlExpression.Expression;
import java.util.Collections;

/* compiled from: user_storage_key */
class SqlExpression$FieldNotNullExpression extends Expression {
    private final String f13295a;

    public SqlExpression$FieldNotNullExpression(String str) {
        this.f13295a = str;
    }

    public final String m14180a() {
        return this.f13295a + " NOT NULL";
    }

    public final String[] m14181b() {
        return new String[0];
    }

    final Iterable<String> m14182c() {
        return Collections.emptyList();
    }
}
