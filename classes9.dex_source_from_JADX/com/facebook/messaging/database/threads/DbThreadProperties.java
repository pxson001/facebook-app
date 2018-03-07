package com.facebook.messaging.database.threads;

import com.facebook.messaging.model.folders.FolderName;

/* compiled from: me/blocked */
public class DbThreadProperties {
    public static final DbThreadPropertyKey f10468a;
    public static final DbThreadPropertyKey f10469b;
    public static final DbThreadPropertyKey f10470c = ((DbThreadPropertyKey) f10468a.a("last_fetch_pinned_threads_client_time_ms"));
    public static final DbThreadPropertyKey f10471d = ((DbThreadPropertyKey) f10468a.a("last_fetch_pinned_thread_suggestions_time_ms"));
    public static final DbThreadPropertyKey f10472e = ((DbThreadPropertyKey) f10468a.a("last_fetch_ranked_threads_time_ms"));
    public static final DbThreadPropertyKey f10473f = ((DbThreadPropertyKey) f10468a.a("user_info_fetch_latest_thread_timestamp"));
    public static final DbThreadPropertyKey f10474g = ((DbThreadPropertyKey) f10468a.a("sync_latest_user_info_fetch_action_id"));
    public static final DbThreadPropertyKey f10475h = ((DbThreadPropertyKey) f10468a.a("sync_latest_user_info_fetch_timestamp_ms"));
    public static final DbThreadPropertyKey f10476i = new DbThreadPropertyKey("sync_token");
    public static final DbThreadPropertyKey f10477j = new DbThreadPropertyKey("last_sequence_id");
    public static final DbThreadPropertyKey f10478k = new DbThreadPropertyKey("last_sync_full_refresh_ms");
    public static final DbThreadPropertyKey f10479l = new DbThreadPropertyKey("needs_full_refresh");
    public static final DbThreadPropertyKey f10480m = new DbThreadPropertyKey("full_refresh_reason");

    static {
        DbThreadPropertyKey dbThreadPropertyKey = new DbThreadPropertyKey("/sync/");
        f10468a = dbThreadPropertyKey;
        f10469b = (DbThreadPropertyKey) dbThreadPropertyKey.a("last_get_pinned_threads_update_time_ms");
    }

    public static DbThreadPropertyKey m11128a(FolderName folderName) {
        return (DbThreadPropertyKey) ((DbThreadPropertyKey) f10468a.a(folderName.dbName)).a("/last_get_threads_client_time_ms");
    }

    public static DbThreadPropertyKey m11129b(FolderName folderName) {
        return (DbThreadPropertyKey) ((DbThreadPropertyKey) f10468a.a(folderName.dbName)).a("/last_get_threads_action_id");
    }

    public static DbThreadPropertyKey m11130c(FolderName folderName) {
        return (DbThreadPropertyKey) ((DbThreadPropertyKey) f10468a.a(folderName.dbName)).a("/threads_table_out_of_date");
    }
}
