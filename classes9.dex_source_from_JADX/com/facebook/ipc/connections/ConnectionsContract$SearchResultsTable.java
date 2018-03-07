package com.facebook.ipc.connections;

import android.net.Uri;
import com.facebook.database.sqlite.SqlColumn;

/* compiled from: p2p_pin_set */
public final class ConnectionsContract$SearchResultsTable {
    public static final Uri f7547a = Uri.parse(ConnectionsContract.c + "search_results");

    /* compiled from: p2p_pin_set */
    public class Columns {
        public static final SqlColumn f7543a = new SqlColumn("_id", "INTEGER PRIMARY KEY");
        public static final SqlColumn f7544b = new SqlColumn("user_id", "INT");
        public static final SqlColumn f7545c = new SqlColumn("display_name", "TEXT");
        public static final SqlColumn f7546d = new SqlColumn("user_image_url", "TEXT");
    }
}
