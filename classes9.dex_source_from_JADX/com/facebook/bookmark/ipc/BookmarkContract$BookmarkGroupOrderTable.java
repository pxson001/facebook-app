package com.facebook.bookmark.ipc;

import android.net.Uri;
import com.facebook.database.sqlite.SqlColumn;

/* compiled from: refetchMostRecentMessages returned null new message */
public final class BookmarkContract$BookmarkGroupOrderTable {
    public static final Uri f5650a = Uri.parse(BookmarkContract.d + "bookmark_group");

    /* compiled from: refetchMostRecentMessages returned null new message */
    public final class Columns {
        public static final SqlColumn f5645a = new SqlColumn("group_id", "TEXT PRIMARY KEY");
        public static final SqlColumn f5646b = new SqlColumn("group_name", "TEXT");
        public static final SqlColumn f5647c = new SqlColumn("group_order", "INTEGER");
        public static final SqlColumn f5648d = new SqlColumn("group_total_count", "INTEGER");
        public static final SqlColumn f5649e = new SqlColumn("group_visible_count", "INTEGER");
    }
}
