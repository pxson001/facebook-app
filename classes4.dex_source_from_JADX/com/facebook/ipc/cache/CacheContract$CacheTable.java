package com.facebook.ipc.cache;

import android.net.Uri;
import com.facebook.database.sqlite.SqlColumn;

/* compiled from: substories_grouping_reasons */
public final class CacheContract$CacheTable {
    public static final Uri f1602a = Uri.parse("content://" + CacheContract.a + "/cache");
    public static final Uri f1603b = Uri.parse("content://" + CacheContract.a + "/cache/name");
    public static final Uri f1604c = Uri.parse("content://" + CacheContract.a + "/cache/sweep_prefix");
    public static final Uri f1605d = Uri.parse("content://" + CacheContract.a + "/cache/prefix");

    /* compiled from: substories_grouping_reasons */
    public class Columns {
        public static final SqlColumn f1597a = new SqlColumn("_id", "INTEGER PRIMARY KEY");
        public static final SqlColumn f1598b = new SqlColumn("name", "TEXT UNIQUE");
        public static final SqlColumn f1599c = new SqlColumn("value", "TEXT");
        public static final SqlColumn f1600d = new SqlColumn("timestamp", "INTEGER DEFAULT 0");
    }
}
