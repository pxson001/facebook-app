package com.facebook.graphql.cursor.database;

import com.facebook.database.sqlite.SqlColumn;

/* compiled from: metadataLoader could not be null. */
public final class GraphCursorDatabaseContract$ChunksTable$Columns {
    public static final SqlColumn f7875a = new SqlColumn("_id", "INTEGER PRIMARY KEY");
    public static final SqlColumn f7876b = new SqlColumn("session_id", "TEXT NOT NULL");
    public static final SqlColumn f7877c = new SqlColumn("sort_key", "TEXT NOT NULL");
    public static final SqlColumn f7878d = new SqlColumn("cursor", "TEXT");
    public static final SqlColumn f7879e = new SqlColumn("has_additional_page", "TINYINT");
    public static final SqlColumn f7880f = new SqlColumn("row_count", "INTEGER NOT NULL");
    public static final SqlColumn f7881g = new SqlColumn("timestamp", "INTEGER NOT NULL");
}
