package com.facebook.messaging.inbox2.data.unitstore;

import android.database.sqlite.SQLiteDatabase;
import com.facebook.database.properties.DbPropertyUtil;
import com.facebook.database.sqlite.SqlColumn;
import com.facebook.database.sqlite.SqlKeys.PrimaryKey;
import com.facebook.database.sqlite.SqlKeys.SqlKey;
import com.facebook.database.sqlite.SqlTable;
import com.facebook.database.supplier.TablesDbSchemaPart;
import com.facebook.tools.dextr.runtime.detour.SQLiteDetour;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;

/* compiled from: sender_notifications_enabled */
public class UnitStoreSchemaPart extends TablesDbSchemaPart {

    /* compiled from: sender_notifications_enabled */
    public final class PropertiesTable extends SqlTable {
        private static final ImmutableList<SqlColumn> f2835a = ImmutableList.of(DbPropertyUtil.a, DbPropertyUtil.b);

        public PropertiesTable() {
            super("properties", f2835a);
        }

        public final void m2789a(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        }
    }

    /* compiled from: sender_notifications_enabled */
    public final class UnitsTable extends SqlTable {
        private static final SqlKey f2841a = new PrimaryKey(ImmutableList.of(Columns.f2836a));
        private static final ImmutableList<SqlColumn> f2842b = ImmutableList.of(Columns.f2836a, Columns.f2837b, Columns.f2838c, Columns.f2839d, Columns.f2840e);
        private static final String f2843c = SqlTable.b("units", "units_position_index", ImmutableList.of(Columns.f2838c.d));

        /* compiled from: sender_notifications_enabled */
        public class Columns {
            public static final SqlColumn f2836a = new SqlColumn("id", "TEXT");
            public static final SqlColumn f2837b = new SqlColumn("blob", "TEXT");
            public static final SqlColumn f2838c = new SqlColumn("pos", "INTEGER");
            public static final SqlColumn f2839d = new SqlColumn("update_ts_ms", "INTEGER");
            public static final SqlColumn f2840e = new SqlColumn("before_threads", "INTEGER");
        }

        public UnitsTable() {
            super("units", f2842b, f2841a);
        }

        public final void m2790a(SQLiteDatabase sQLiteDatabase) {
            super.a(sQLiteDatabase);
            String str = f2843c;
            SQLiteDetour.a(-2056448604);
            sQLiteDatabase.execSQL(str);
            SQLiteDetour.a(-1696873919);
        }

        public final void m2791a(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        }
    }

    @Inject
    public UnitStoreSchemaPart() {
        super("units", 4, ImmutableList.of(new PropertiesTable(), new UnitsTable()));
    }

    public final void m2792a(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        Integer.valueOf(i);
        Integer.valueOf(i2);
        while (i < i2) {
            String a = SqlTable.a("properties");
            SQLiteDetour.a(-1889933480);
            sQLiteDatabase.execSQL(a);
            SQLiteDetour.a(-758415459);
            a = SqlTable.a("units");
            SQLiteDetour.a(439872622);
            sQLiteDatabase.execSQL(a);
            SQLiteDetour.a(-1525660733);
            a(sQLiteDatabase);
            i = i2;
        }
    }

    public final void m2793b(SQLiteDatabase sQLiteDatabase) {
    }
}
