package com.facebook.messaging.sms.database;

import android.database.sqlite.SQLiteDatabase;
import com.facebook.database.sqlite.SqlColumn;
import com.facebook.database.sqlite.SqlKeys.PrimaryKey;
import com.facebook.database.sqlite.SqlKeys.SqlKey;
import com.facebook.database.sqlite.SqlTable;
import com.facebook.database.supplier.TablesDbSchemaPart;
import com.facebook.tools.dextr.runtime.detour.SQLiteDetour;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;

/* compiled from: commerceOrderId */
public class SmsTakeoverDbSchemaPart extends TablesDbSchemaPart {

    /* compiled from: commerceOrderId */
    public final class ThreadReadStateTable extends SqlTable {
        public static final SqlColumn f17526a = new SqlColumn("threadid", "INTEGER DEFAULT 0");
        public static final SqlColumn f17527b = new SqlColumn("state", "INTEGER DEFAULT 0");
        public static final SqlColumn f17528c = new SqlColumn("ts", "INTEGER DEFAULT 0");
        private static final ImmutableList<SqlColumn> f17529d = ImmutableList.of(f17526a, f17527b, f17528c);
        private static final SqlKey f17530e;
        private static final ImmutableList<SqlKey> f17531f;

        static {
            PrimaryKey primaryKey = new PrimaryKey(ImmutableList.of(f17526a));
            f17530e = primaryKey;
            f17531f = ImmutableList.of(primaryKey);
        }

        ThreadReadStateTable() {
            super("thread_read_stat", f17529d, f17531f);
        }

        public final void m17512a(SQLiteDatabase sQLiteDatabase) {
            super.a(sQLiteDatabase);
            String a = SqlTable.a("thread_read_stat", "INDEX_THREAD_ID", ImmutableList.of(f17527b));
            SQLiteDetour.a(-1624436058);
            sQLiteDatabase.execSQL(a);
            SQLiteDetour.a(592549915);
        }
    }

    @Inject
    public SmsTakeoverDbSchemaPart() {
        super("smstakeover_schema", 2, ImmutableList.of(new ThreadReadStateTable()));
    }
}
