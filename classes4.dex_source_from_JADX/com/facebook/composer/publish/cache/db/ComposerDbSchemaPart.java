package com.facebook.composer.publish.cache.db;

import android.database.sqlite.SQLiteDatabase;
import com.facebook.database.sqlite.SqlColumn;
import com.facebook.database.sqlite.SqlTable;
import com.facebook.database.supplier.TablesDbSchemaPart;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;

/* compiled from: unregisterPushTokenParams */
public class ComposerDbSchemaPart extends TablesDbSchemaPart {

    /* compiled from: unregisterPushTokenParams */
    public final class PendingStoryTable extends SqlTable {
        public static final ImmutableList<SqlColumn> f558a = ImmutableList.of(Columns.f553a, Columns.f554b, Columns.f555c);

        /* compiled from: unregisterPushTokenParams */
        public class Columns {
            public static final SqlColumn f553a = new SqlColumn("request_id", "TEXT PRIMARY KEY");
            public static final SqlColumn f554b = new SqlColumn("serialized_publish_data", "TEXT");
            public static final SqlColumn f555c = new SqlColumn("serialized_story_data", "TEXT");
        }

        PendingStoryTable() {
            super("pending_story", f558a);
        }

        public final void m853a(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            if (i != 2 || i2 != 3) {
                if (i != 2 || i2 != 4) {
                    if (i != 3 || i2 != 4) {
                        super.a(sQLiteDatabase, i, i2);
                    }
                }
            }
        }
    }

    /* compiled from: unregisterPushTokenParams */
    public final class PrivacyOptionsTable extends SqlTable {
        public static final ImmutableList<SqlColumn> f559a = ImmutableList.of(Columns.f551a);

        /* compiled from: unregisterPushTokenParams */
        public class Columns {
            public static final SqlColumn f551a = new SqlColumn("serialized_privacy_data", "TEXT");
        }

        PrivacyOptionsTable() {
            super("privacy_options", f559a);
        }

        public final void m854a(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            if (i < 2 || i2 > 4) {
                super.a(sQLiteDatabase, i, i2);
            }
        }
    }

    /* compiled from: unregisterPushTokenParams */
    public final class SessionsTable extends SqlTable {
        public static final ImmutableList<SqlColumn> f560a = ImmutableList.of(Columns.f552a);

        /* compiled from: unregisterPushTokenParams */
        public class Columns {
            public static final SqlColumn f552a = new SqlColumn("serialized_draft", "TEXT");
        }

        SessionsTable() {
            super("drafts", f560a);
        }

        public final void m855a(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            if (i != 3 || i2 != 4) {
                super.a(sQLiteDatabase, i, i2);
            }
        }
    }

    @Inject
    public ComposerDbSchemaPart() {
        super("composer", 5, ImmutableList.of(new PendingStoryTable(), new PrivacyOptionsTable(), new SessionsTable()));
    }
}
