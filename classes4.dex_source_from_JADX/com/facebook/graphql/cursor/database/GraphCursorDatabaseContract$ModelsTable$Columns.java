package com.facebook.graphql.cursor.database;

import com.facebook.database.sqlite.SqlColumn;

/* compiled from: metadataLoader could not be null. */
public final class GraphCursorDatabaseContract$ModelsTable$Columns {
    public static final SqlColumn f7883a = new SqlColumn("_id", "INTEGER PRIMARY KEY");
    public static final SqlColumn f7884b = new SqlColumn("file", "TEXT");
    public static final SqlColumn f7885c = new SqlColumn("offset", "INTEGER");
    public static final SqlColumn f7886d = new SqlColumn("mutation_data", "BLOB");
    public static final SqlColumn f7887e = new SqlColumn("class", "TEXT NOT NULL");
}
