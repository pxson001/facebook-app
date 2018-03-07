package com.facebook.graphql.executor.cache;

import com.facebook.database.sqlite.SqlColumn;

/* compiled from: saved_for_later */
public interface GraphQLDBContract$ConsistencyIndexTable$Columns {
    public static final SqlColumn f6154a = new SqlColumn("rowid_ref", "INTEGER NOT NULL REFERENCES queries(rowid) ON DELETE CASCADE");
    public static final SqlColumn f6155b = new SqlColumn("id", "TEXT NOT NULL");
    public static final SqlColumn f6156c = new SqlColumn("field_path", "TEXT NOT NULL");
    public static final SqlColumn f6157d = new SqlColumn("position_in_buffer", "INTEGER NOT NULL");
    public static final SqlColumn f6158e = new SqlColumn("field_index", "INTEGER NOT NULL");
}
