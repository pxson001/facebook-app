package com.facebook.messaging.tincan.database;

import com.facebook.database.sqlite.SqlColumn;

/* compiled from: mSyncQueueTracker %s */
public final class TincanDbSchemaPart$MessagesTable$Columns {
    public static final SqlColumn f15400a = new SqlColumn("msg_id", "TEXT");
    public static final SqlColumn f15401b = new SqlColumn("thread_key", "TEXT");
    public static final SqlColumn f15402c = new SqlColumn("encrypted_content", "BLOB");
    public static final SqlColumn f15403d = new SqlColumn("sender_fbid", "INTEGER");
    public static final SqlColumn f15404e = new SqlColumn("timestamp_ms", "INTEGER");
    public static final SqlColumn f15405f = new SqlColumn("timestamp_sent_ms", "INTEGER");
    public static final SqlColumn f15406g = new SqlColumn("attachments_encrypted", "TEXT");
    public static final SqlColumn f15407h = new SqlColumn("msg_type", "INTEGER");
    public static final SqlColumn f15408i = new SqlColumn("offline_threading_id", "TEXT");
    public static final SqlColumn f15409j = new SqlColumn("pending_send_media_attachment", "STRING");
    public static final SqlColumn f15410k = new SqlColumn("client_expiration_time_ms", "INTEGER");
    public static final SqlColumn f15411l = new SqlColumn("send_error", "STRING");
    public static final SqlColumn f15412m = new SqlColumn("send_error_message", "STRING");
    public static final SqlColumn f15413n = new SqlColumn("send_error_timestamp_ms", "INTEGER");
}
