package com.facebook.ipc.notifications;

import android.net.Uri;
import com.facebook.database.sqlite.SqlColumn;
import com.facebook.inject.InjectorLike;
import com.google.common.base.Preconditions;
import javax.inject.Inject;

/* compiled from: model_row_type */
public class GraphQLNotificationsContract {
    public final String f7610a;
    public final Uri f7611b = Uri.parse("content://" + this.f7610a + "/gql_notifications");
    public final Uri f7612c = Uri.parse("content://" + this.f7610a + "/clear_all_data");

    /* compiled from: model_row_type */
    public final class GraphQLNotificationsTable {
        public static final String[] f7792a = new String[]{Columns.f7588b.d};

        /* compiled from: model_row_type */
        public final class Columns {
            public static final SqlColumn f7587a = new SqlColumn("_id", "INTEGER PRIMARY KEY");
            public static final SqlColumn f7588b = new SqlColumn("notif_id", "TEXT UNIQUE ON CONFLICT REPLACE");
            public static final SqlColumn f7589c = new SqlColumn("recipient_id", "INT");
            public static final SqlColumn f7590d = new SqlColumn("seen_state", "TEXT");
            public static final SqlColumn f7591e = new SqlColumn("updated", "INT");
            public static final SqlColumn f7592f = new SqlColumn("cache_id", "TEXT");
            public static final SqlColumn f7593g = new SqlColumn("cursor", "TEXT");
            public static final SqlColumn f7594h = new SqlColumn("gql_payload", "BLOB");
            public static final SqlColumn f7595i = new SqlColumn("profile_picture_uri", "TEXT");
            public static final SqlColumn f7596j = new SqlColumn("icon_uri", "TEXT");
            public static final SqlColumn f7597k = new SqlColumn("summary_graphql_text_with_entities", "BLOB");
            public static final SqlColumn f7598l = new SqlColumn("short_summary_graphql_text_with_entities", "BLOB");
            public static final SqlColumn f7599m = new SqlColumn("notif_option_row", "BLOB");
            public static final SqlColumn f7600n = new SqlColumn("highlight_state", "TEXT");
            public static final SqlColumn f7601o = new SqlColumn("importance_reason_text", "TEXT");
            public static final SqlColumn f7602p = new SqlColumn("importance_score", "TEXT");
            public static final SqlColumn f7603q = new SqlColumn("importance_type", "TEXT");
            public static final SqlColumn f7604r = new SqlColumn("like_count", "INT");
            public static final SqlColumn f7605s = new SqlColumn("reaction_unit", "BLOB");
            public static final SqlColumn f7606t = new SqlColumn("is_rich_notif_collapsed", "INT");
            public static final SqlColumn f7607u = new SqlColumn("notif_option_sets", "BLOB");
            public static final SqlColumn f7608v = new SqlColumn("seen_state_session_number", "TEXT");
            public static final SqlColumn f7609w = new SqlColumn("highlight_operations", "BLOB");
        }
    }

    public static GraphQLNotificationsContract m7921b(InjectorLike injectorLike) {
        return new GraphQLNotificationsContract(NotificationsIpcModule.f7613a);
    }

    @Inject
    public GraphQLNotificationsContract(String str) {
        this.f7610a = (String) Preconditions.checkNotNull(str);
    }

    public static GraphQLNotificationsContract m7920a(InjectorLike injectorLike) {
        return m7921b(injectorLike);
    }
}
