package com.facebook.ipc.userstatus;

import android.net.Uri;
import com.facebook.database.sqlite.SqlColumn;

/* compiled from: via_graph_after_mqtt_failure */
public final class UserStatusContract$UserStatusesTable {
    public static final Uri f524a = Uri.parse("content://" + UserStatusContract.a + "/user_statuses");

    /* compiled from: via_graph_after_mqtt_failure */
    public final class Columns {
        public static final SqlColumn f515a = new SqlColumn("_id", "INTEGER PRIMARY KEY");
        public static final SqlColumn f516b = new SqlColumn("user_id", "INT");
        public static final SqlColumn f517c = new SqlColumn("first_name", "TEXT");
        public static final SqlColumn f518d = new SqlColumn("last_name", "TEXT");
        public static final SqlColumn f519e = new SqlColumn("display_name", "TEXT");
        public static final SqlColumn f520f = new SqlColumn("user_pic", "TEXT");
        public static final SqlColumn f521g = new SqlColumn("timestamp", "INT");
        public static final SqlColumn f522h = new SqlColumn("message", "TEXT");
        public static final SqlColumn f523i = new SqlColumn("status_id", "INT");
    }
}
