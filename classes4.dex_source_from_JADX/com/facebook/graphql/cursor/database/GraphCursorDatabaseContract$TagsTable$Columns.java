package com.facebook.graphql.cursor.database;

import com.facebook.database.sqlite.SqlColumn;

/* compiled from: metadataLoader could not be null. */
public final class GraphCursorDatabaseContract$TagsTable$Columns {
    public static final SqlColumn f7889a = new SqlColumn("tag", "TEXT NOT NULL");
    public static final SqlColumn f7890b = new SqlColumn("node_id", "INTEGER NOT NULL REFERENCES connections(_id) ON DELETE CASCADE");
}
