package com.facebook.database.sqlite;

import com.google.common.base.Joiner;
import com.google.common.collect.Collections2;
import com.google.common.collect.ImmutableList;

/* compiled from: saved_dashboard_undo_button_clicked */
public class SqlKeys$PrimaryKey implements SqlKeys$SqlKey {
    private final ImmutableList<SqlColumn> f6144a;

    public SqlKeys$PrimaryKey(ImmutableList<SqlColumn> immutableList) {
        this.f6144a = immutableList;
    }

    public final String mo1456a() {
        StringBuilder stringBuilder = new StringBuilder();
        if (this.f6144a == null || this.f6144a.isEmpty()) {
            throw new UnsupportedOperationException("Columns for primary key must be specified");
        }
        stringBuilder.append("PRIMARY KEY (");
        stringBuilder.append(Joiner.on(", ").join(Collections2.m847a(this.f6144a, SqlColumn.f1024c)));
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}
