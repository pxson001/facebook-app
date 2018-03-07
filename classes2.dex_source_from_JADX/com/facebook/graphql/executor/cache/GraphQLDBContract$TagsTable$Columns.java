package com.facebook.graphql.executor.cache;

import com.facebook.database.sqlite.SqlColumn;

/* compiled from: saved_for_later */
public interface GraphQLDBContract$TagsTable$Columns {
    public static final SqlColumn f6142a = new SqlColumn("rowid_ref", "INTEGER NOT NULL REFERENCES queries(rowid) ON DELETE CASCADE");
    public static final SqlColumn f6143b = new SqlColumn("tag", "TEXT NOT NULL");
}
