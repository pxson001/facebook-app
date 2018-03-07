package com.facebook.timeline.cache.db;

import com.facebook.database.sqlite.SqlColumn;

/* compiled from: use getComposerButtonForOverflow to get a button for the overflow */
public final class TimelineContract$CacheTable$Columns {
    public static final SqlColumn f804a = new SqlColumn("cachekey", "TEXT PRIMARY KEY");
    public static final SqlColumn f805b = new SqlColumn("timestamp", "INT64");
    public static final SqlColumn f806c = new SqlColumn("data", "BLOB");
    public static final SqlColumn f807d = new SqlColumn("pin", "BYTE");
}
