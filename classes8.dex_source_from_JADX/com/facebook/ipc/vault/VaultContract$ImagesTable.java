package com.facebook.ipc.vault;

import android.net.Uri;
import com.facebook.database.sqlite.SqlColumn;

/* compiled from: edit_and_share_abandoned */
public final class VaultContract$ImagesTable {
    public static final Uri f14939a = Uri.parse("content://" + VaultContract.a + "/images");

    /* compiled from: edit_and_share_abandoned */
    public final class Columns {
        public static final SqlColumn f14930a = new SqlColumn("image_hash", "STRING PRIMARY KEY");
        public static final SqlColumn f14931b = new SqlColumn("image_fbid", "INTEGER");
        public static final SqlColumn f14932c = new SqlColumn("date_taken", "INTEGER");
        public static final SqlColumn f14933d = new SqlColumn("upload_date", "INTEGER");
        public static final SqlColumn f14934e = new SqlColumn("failure_count", "INTEGER");
        public static final SqlColumn f14935f = new SqlColumn("upload_state", "INTEGER");
        public static final SqlColumn f14936g = new SqlColumn("shared", "INTEGER");
        public static final SqlColumn f14937h = new SqlColumn("queue_state", "INTEGER");
        public static final SqlColumn f14938i = new SqlColumn("last_attempt", "INTEGER");
    }
}
