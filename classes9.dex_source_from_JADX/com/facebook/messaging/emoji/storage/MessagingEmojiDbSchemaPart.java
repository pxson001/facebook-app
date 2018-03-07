package com.facebook.messaging.emoji.storage;

import com.facebook.database.sqlite.SqlColumn;
import com.facebook.database.sqlite.SqlTable;
import com.facebook.database.supplier.TablesDbSchemaPart;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;

/* compiled from: mVerificationSucceeded */
public class MessagingEmojiDbSchemaPart extends TablesDbSchemaPart {

    /* compiled from: mVerificationSucceeded */
    public final class RecentEmojiTable extends SqlTable {
        private static final ImmutableList<SqlColumn> f11012a = ImmutableList.of(Columns.f11011a);

        /* compiled from: mVerificationSucceeded */
        public class Columns {
            public static final SqlColumn f11011a = new SqlColumn("list", "TEXT");
        }

        RecentEmojiTable() {
            super("recent_emoji", f11012a);
        }
    }

    @Inject
    public MessagingEmojiDbSchemaPart() {
        super("messaging_emoji_schema", 1, ImmutableList.of(new RecentEmojiTable()));
    }
}
