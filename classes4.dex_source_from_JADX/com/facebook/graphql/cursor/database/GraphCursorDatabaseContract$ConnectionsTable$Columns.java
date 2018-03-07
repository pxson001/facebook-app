package com.facebook.graphql.cursor.database;

import com.facebook.database.sqlite.SqlColumn;

/* compiled from: metadataLoader could not be null. */
public final class GraphCursorDatabaseContract$ConnectionsTable$Columns {
    public static final SqlColumn f7866a = new SqlColumn("_id", "INTEGER PRIMARY KEY");
    public static final SqlColumn f7867b = new SqlColumn("confirmed_model", "INTEGER NOT NULL");
    public static final SqlColumn f7868c = new SqlColumn("optimistic_model", "INTEGER NOT NULL");
    public static final SqlColumn f7869d = new SqlColumn("session_id", "TEXT NOT NULL");
    public static final SqlColumn f7870e = new SqlColumn("flags", "INTEGER");
    public static final SqlColumn f7871f = new SqlColumn("version", "INTEGER NOT NULL");
    public static final SqlColumn f7872g = new SqlColumn("sort_key", "TEXT NOT NULL");
    public static final SqlColumn f7873h = new SqlColumn("tags", "TEXT");
}
