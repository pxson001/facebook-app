package com.facebook.graphql.executor.cache;

import com.facebook.database.sqlite.SqlColumn;

/* compiled from: saved_for_later */
public interface GraphQLDBContract$QueriesTable$Columns {
    public static final SqlColumn f6129a = new SqlColumn("rowid", "INTEGER PRIMARY KEY");
    public static final SqlColumn f6130b = new SqlColumn("query_id", "TEXT NOT NULL");
    public static final SqlColumn f6131c = new SqlColumn("user_id", "TEXT");
    public static final SqlColumn f6132d = new SqlColumn("data", "BLOB");
    public static final SqlColumn f6133e = new SqlColumn("timestamp", "INTEGER NOT NULL");
    public static final SqlColumn f6134f = new SqlColumn("readstamp", "INTEGER NOT NULL");
    public static final SqlColumn f6135g = new SqlColumn("class", "TEXT NOT NULL");
    public static final SqlColumn f6136h = new SqlColumn("mapped", "INTEGER");
    public static final SqlColumn f6137i = new SqlColumn("exports", "BLOB");
    public static final SqlColumn f6138j = new SqlColumn("max_age_ms", "INTEGER NOT NULL");
    public static final SqlColumn f6139k = new SqlColumn("mutation_data", "BLOB");
    public static final SqlColumn f6140l = new SqlColumn("extra_data", "BLOB");
}
