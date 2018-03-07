package com.facebook.bookmark.ipc;

import android.net.Uri;
import com.facebook.database.sqlite.SqlColumn;

/* compiled from: refetchMostRecentMessages returned null new message */
public final class BookmarkContract$BookmarksTable {
    public static final Uri f5666a = Uri.parse(BookmarkContract.d + "bookmarks");
    public static final Uri f5667b = Uri.parse(BookmarkContract.d + "BookmarkUnreadCount");

    /* compiled from: refetchMostRecentMessages returned null new message */
    public final class Columns {
        public static final SqlColumn f5654a = new SqlColumn("_id", "INTEGER PRIMARY KEY");
        public static final SqlColumn f5655b = new SqlColumn("bookmark_fbid", "INTEGER");
        public static final SqlColumn f5656c = new SqlColumn("bookmark_name", "TEXT");
        public static final SqlColumn f5657d = new SqlColumn("bookmark_url", "TEXT");
        public static final SqlColumn f5658e = new SqlColumn("bookmark_pic", "TEXT");
        public static final SqlColumn f5659f = new SqlColumn("bookmark_type", "TEXT");
        public static final SqlColumn f5660g = new SqlColumn("bookmark_unread_count", "INTEGER");
        public static final SqlColumn f5661h = new SqlColumn("bookmark_count_string", "TEXT");
        public static final SqlColumn f5662i = new SqlColumn("bookmark_client_token", "TEXT");
        public static final SqlColumn f5663j = new SqlColumn("group_id", "TEXT");
        public static final SqlColumn f5664k = new SqlColumn("group_index", "INTEGER");
        public static final SqlColumn f5665l = new SqlColumn("visible_in_group", "INTEGER");
    }
}
