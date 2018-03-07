package com.facebook.bookmark.ipc;

import android.net.Uri;
import com.facebook.database.sqlite.SqlColumn;

/* compiled from: refetchMostRecentMessages returned null new message */
public final class BookmarkContract$BookmarkSyncStatusTable {
    public static final Uri f5653a = Uri.parse(BookmarkContract.d + "bookmark_sync_status");

    /* compiled from: refetchMostRecentMessages returned null new message */
    public final class Columns {
        public static final SqlColumn f5651a = new SqlColumn("last_sync_timestamp", "INTEGER");
        public static final SqlColumn f5652b = new SqlColumn("local_update_timestamp", "INTEGER");
    }
}
