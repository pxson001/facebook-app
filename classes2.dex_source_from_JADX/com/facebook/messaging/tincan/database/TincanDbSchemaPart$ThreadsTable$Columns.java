package com.facebook.messaging.tincan.database;

import com.facebook.database.sqlite.SqlColumn;

/* compiled from: mSyncQueueTracker %s */
final class TincanDbSchemaPart$ThreadsTable$Columns {
    public static final SqlColumn f15363a = new SqlColumn("thread_key", "TEXT");
    public static final SqlColumn f15364b = new SqlColumn("other_user_fbid", "INTEGER");
    public static final SqlColumn f15365c = new SqlColumn("thread_name", "TEXT");
    public static final SqlColumn f15366d = new SqlColumn("timestamp_ms", "INTEGER");
    public static final SqlColumn f15367e = new SqlColumn("last_read_timestamp_ms", "INTEGER");
    public static final SqlColumn f15368f = new SqlColumn("session_state", "BLOB");
    public static final SqlColumn f15369g = new SqlColumn("draft", "TEXT");
    public static final SqlColumn f15370h = new SqlColumn("snippet", "TEXT");
    public static final SqlColumn f15371i = new SqlColumn("snippet_sender_fbid", "INTEGER");
    public static final SqlColumn f15372j = new SqlColumn("admin_snippet", "TEXT");
    public static final SqlColumn f15373k = new SqlColumn("can_reply", "INTEGER");
    public static final SqlColumn f15374l = new SqlColumn("outgoing_message_lifetime_ms", "INTEGER");
    public static final SqlColumn f15375m = new SqlColumn("last_read_receipt_time_ms", "INTEGER");
    public static final SqlColumn f15376n = new SqlColumn("last_delivered_receipt_time_ms", "INTEGER");
    public static final SqlColumn f15377o = new SqlColumn("encryption_key", "BLOB");
}
