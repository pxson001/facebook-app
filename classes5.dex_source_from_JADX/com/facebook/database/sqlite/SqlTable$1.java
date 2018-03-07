package com.facebook.database.sqlite;

import com.google.common.base.Function;
import com.google.common.collect.ImmutableMap;
import javax.annotation.Nullable;

/* compiled from: second_metaline */
final class SqlTable$1 implements Function<SqlColumn, String> {
    final /* synthetic */ ImmutableMap f2874a;

    SqlTable$1(ImmutableMap immutableMap) {
        this.f2874a = immutableMap;
    }

    @Nullable
    public final Object apply(Object obj) {
        SqlColumn sqlColumn = (SqlColumn) obj;
        Function function = (Function) this.f2874a.get(sqlColumn);
        if (function == null) {
            function = SqlColumn.c;
        }
        return (String) function.apply(sqlColumn);
    }
}
