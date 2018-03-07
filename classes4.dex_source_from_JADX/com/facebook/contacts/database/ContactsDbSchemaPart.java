package com.facebook.contacts.database;

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
import javax.inject.Singleton;

@Singleton
/* compiled from: markers */
public class ContactsDbSchemaPart extends TablesDbSchemaPart {
    private static volatile ContactsDbSchemaPart f8251a;

    /* compiled from: markers */
    public final class ContactsDbPropertiesTable extends SqlTable {
        private static final ImmutableList<SqlColumn> f8252a = ImmutableList.of(DbPropertyUtil.f8245a, DbPropertyUtil.f8246b);

        public ContactsDbPropertiesTable() {
            super("contacts_db_properties", f8252a);
        }
    }

    /* compiled from: markers */
    public final class ContactsTable extends SqlTable {
        private static final ImmutableList<SqlColumn> f8253a = ImmutableList.of(Columns.f8257a, Columns.f8258b, Columns.f8259c, Columns.f8260d, Columns.f8261e, Columns.f8262f, Columns.f8263g, Columns.f8264h, Columns.f8265i, Columns.f8266j, Columns.f8267k, Columns.f8268l, new SqlColumn[]{Columns.f8269m, Columns.f8270n, Columns.f8271o, Columns.f8272p, Columns.f8273q, Columns.f8274r, Columns.f8275s, Columns.f8276t, Columns.f8277u, Columns.f8278v, Columns.f8279w, Columns.f8280x, Columns.f8281y, Columns.f8282z, Columns.f8255A, Columns.f8256B});
        private static final String f8254b = SqlTable.a("contacts", "contact_index_by_fbid", ImmutableList.of(Columns.f8259c));

        /* compiled from: markers */
        class Columns {
            public static final SqlColumn f8255A = new SqlColumn("messenger_invite_priority", "REAL");
            public static final SqlColumn f8256B = new SqlColumn("last_fetch_time_ms", "INTEGER");
            public static final SqlColumn f8257a = new SqlColumn("internal_id", "INTEGER PRIMARY KEY AUTOINCREMENT");
            public static final SqlColumn f8258b = new SqlColumn("contact_id", "TEXT UNIQUE");
            public static final SqlColumn f8259c = new SqlColumn("fbid", "TEXT");
            public static final SqlColumn f8260d = new SqlColumn("first_name", "TEXT");
            public static final SqlColumn f8261e = new SqlColumn("last_name", "TEXT");
            public static final SqlColumn f8262f = new SqlColumn("display_name", "TEXT");
            public static final SqlColumn f8263g = new SqlColumn("small_picture_url", "TEXT");
            public static final SqlColumn f8264h = new SqlColumn("big_picture_url", "TEXT");
            public static final SqlColumn f8265i = new SqlColumn("huge_picture_url", "TEXT");
            public static final SqlColumn f8266j = new SqlColumn("small_picture_size", "INTEGER");
            public static final SqlColumn f8267k = new SqlColumn("big_picture_size", "INTEGER");
            public static final SqlColumn f8268l = new SqlColumn("huge_picture_size", "INTEGER");
            public static final SqlColumn f8269m = new SqlColumn("communication_rank", "REAL");
            public static final SqlColumn f8270n = new SqlColumn("is_mobile_pushable", "INTEGER");
            public static final SqlColumn f8271o = new SqlColumn("is_messenger_user", "TEXT");
            public static final SqlColumn f8272p = new SqlColumn("messenger_install_time_ms", "INTEGER");
            public static final SqlColumn f8273q = new SqlColumn("added_time_ms", "INTEGER");
            public static final SqlColumn f8274r = new SqlColumn("phonebook_section_key", "TEXT");
            public static final SqlColumn f8275s = new SqlColumn("is_on_viewer_contact_list", "TEXT");
            public static final SqlColumn f8276t = new SqlColumn("type", "TEXT");
            public static final SqlColumn f8277u = new SqlColumn("link_type", "TEXT");
            public static final SqlColumn f8278v = new SqlColumn("is_indexed", "INTEGER");
            public static final SqlColumn f8279w = new SqlColumn("data", "TEXT");
            public static final SqlColumn f8280x = new SqlColumn("bday_day", "INTEGER");
            public static final SqlColumn f8281y = new SqlColumn("bday_month", "INTEGER");
            public static final SqlColumn f8282z = new SqlColumn("is_partial", "INTEGER");
        }

        public static void m8568h(SQLiteDatabase sQLiteDatabase) {
            SQLiteDetour.a(-1191262311);
            sQLiteDatabase.execSQL("ALTER TABLE contacts ADD COLUMN messenger_invite_priority REAL");
            SQLiteDetour.a(-1443395123);
        }

        public ContactsTable() {
            super("contacts", f8253a);
        }

        public final void m8569a(SQLiteDatabase sQLiteDatabase) {
            super.a(sQLiteDatabase);
            String str = f8254b;
            SQLiteDetour.a(1549497997);
            sQLiteDatabase.execSQL(str);
            SQLiteDetour.a(1383916523);
        }
    }

    /* compiled from: markers */
    public final class ContactsIndexedDataTable extends SqlTable {
        private static final ImmutableList<SqlColumn> f8285a = ImmutableList.of(Columns.f8288a, Columns.f8289b, Columns.f8290c);
        private static final String f8286b = SqlTable.a("contacts_indexed_data", "contacts_type_index", ImmutableList.of(Columns.f8288a, Columns.f8289b));
        private static final String f8287c = SqlTable.a("contacts_indexed_data", "contacts_data_index", ImmutableList.of(Columns.f8288a, Columns.f8290c));

        /* compiled from: markers */
        public class Columns {
            public static final SqlColumn f8288a = new SqlColumn("type", "TEXT");
            public static final SqlColumn f8289b = new SqlColumn("contact_internal_id", "INTEGER");
            public static final SqlColumn f8290c = new SqlColumn("indexed_data", "TEXT");
        }

        public ContactsIndexedDataTable() {
            super("contacts_indexed_data", f8285a);
        }

        public final void m8570a(SQLiteDatabase sQLiteDatabase) {
            super.a(sQLiteDatabase);
            String str = f8286b;
            SQLiteDetour.a(847199386);
            sQLiteDatabase.execSQL(str);
            SQLiteDetour.a(-1546394127);
            str = f8287c;
            SQLiteDetour.a(-2114632649);
            sQLiteDatabase.execSQL(str);
            SQLiteDetour.a(1899117632);
        }
    }

    /* compiled from: markers */
    public final class EphemeralDataTable extends SqlTable {
        private static final ImmutableList<SqlColumn> f8291a = ImmutableList.of(Columns.f8293a, Columns.f8294b, Columns.f8295c);
        private static final SqlKey f8292b = new PrimaryKey(ImmutableList.of(Columns.f8293a));

        /* compiled from: markers */
        class Columns {
            public static final SqlColumn f8293a = new SqlColumn("fbid", "TEXT");
            public static final SqlColumn f8294b = new SqlColumn("type", "TEXT");
            public static final SqlColumn f8295c = new SqlColumn("data", "TEXT");
        }

        public EphemeralDataTable() {
            super("ephemeral_data", f8291a, f8292b);
        }
    }

    /* compiled from: markers */
    public final class FavoriteContactsTable extends SqlTable {
        private static final ImmutableList<SqlColumn> f8296a = ImmutableList.of(Columns.f8299a, Columns.f8300b);
        private static final SqlKey f8297b = new PrimaryKey(ImmutableList.of(Columns.f8299a));
        private static final String f8298c = ("CREATE INDEX favorite_contacts_order_index on favorite_contacts (" + Columns.f8300b.d + " ASC)");

        /* compiled from: markers */
        class Columns {
            public static final SqlColumn f8299a = new SqlColumn("fbid", "TEXT");
            public static final SqlColumn f8300b = new SqlColumn("display_order", "INTEGER");
        }

        public FavoriteContactsTable() {
            super("favorite_contacts", f8296a, f8297b);
        }

        public final void m8571a(SQLiteDatabase sQLiteDatabase) {
            super.a(sQLiteDatabase);
            String str = f8298c;
            SQLiteDetour.a(-740644178);
            sQLiteDatabase.execSQL(str);
            SQLiteDetour.a(-1758685823);
        }
    }

    /* compiled from: markers */
    public final class FavoriteSmsContactsTable extends SqlTable {
        private static final ImmutableList<SqlColumn> f8301a = ImmutableList.of(Columns.f8303a, Columns.f8304b);
        private static final SqlKey f8302b = new PrimaryKey(ImmutableList.of(Columns.f8303a));

        /* compiled from: markers */
        public class Columns {
            public static final SqlColumn f8303a = new SqlColumn("raw_phone_number", "TEXT");
            public static final SqlColumn f8304b = new SqlColumn("display_order", "REAL");
        }

        public FavoriteSmsContactsTable() {
            super("favorite_sms_contacts", f8301a, f8302b);
        }
    }

    public static com.facebook.contacts.database.ContactsDbSchemaPart m8564a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find immediate dominator for block B:24:0x003a in {17, 19, 21, 23, 26, 28} preds:[]
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.computeDominators(BlockProcessor.java:129)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.processBlocksTree(BlockProcessor.java:48)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.rerun(BlockProcessor.java:44)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.visit(BlockFinallyExtract.java:57)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r0 = f8251a;
        if (r0 != 0) goto L_0x0031;
    L_0x0004:
        r1 = com.facebook.contacts.database.ContactsDbSchemaPart.class;
        monitor-enter(r1);
        r0 = f8251a;	 Catch:{ all -> 0x0039 }
        if (r0 != 0) goto L_0x0030;	 Catch:{ all -> 0x0039 }
    L_0x000b:
        if (r5 == 0) goto L_0x0030;	 Catch:{ all -> 0x0039 }
    L_0x000d:
        r2 = com.facebook.inject.ScopeSet.a();	 Catch:{ all -> 0x0039 }
        r3 = r2.b();	 Catch:{ all -> 0x0039 }
        r0 = com.facebook.inject.SingletonScope.class;	 Catch:{ all -> 0x0039 }
        r0 = r5.getInstance(r0);	 Catch:{ all -> 0x0039 }
        r0 = (com.facebook.inject.SingletonScope) r0;	 Catch:{ all -> 0x0039 }
        r4 = r0.enterScope();	 Catch:{ all -> 0x0039 }
        r5.getApplicationInjector();	 Catch:{ all -> 0x0034 }
        r0 = m8565d();	 Catch:{ all -> 0x0034 }
        f8251a = r0;	 Catch:{ all -> 0x0034 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0030:
        monitor-exit(r1);	 Catch:{  }
    L_0x0031:
        r0 = f8251a;
        return r0;
    L_0x0034:
        r0 = move-exception;
        com.facebook.inject.SingletonScope.a(r4);	 Catch:{ all -> 0x0034 }
        throw r0;	 Catch:{ all -> 0x0034 }
    L_0x0039:
        r0 = move-exception;
        r2.c(r3);	 Catch:{ all -> 0x0039 }
        throw r0;	 Catch:{ all -> 0x0039 }
    L_0x003e:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x0039 }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.contacts.database.ContactsDbSchemaPart.a(com.facebook.inject.InjectorLike):com.facebook.contacts.database.ContactsDbSchemaPart");
    }

    private static ContactsDbSchemaPart m8565d() {
        return new ContactsDbSchemaPart();
    }

    @Inject
    public ContactsDbSchemaPart() {
        super("contacts", 70, ImmutableList.of(new ContactsDbPropertiesTable(), new ContactsTable(), new ContactsIndexedDataTable(), new EphemeralDataTable(), new FavoriteContactsTable(), new FavoriteSmsContactsTable()));
    }

    public final void m8566a(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        String a = SqlTable.a("contact_summaries");
        SQLiteDetour.a(-1039397340);
        sQLiteDatabase.execSQL(a);
        SQLiteDetour.a(-540081326);
        a = SqlTable.a("contact_details");
        SQLiteDetour.a(1044006148);
        sQLiteDatabase.execSQL(a);
        SQLiteDetour.a(-1883414339);
        if (i == 68 && i2 == 70) {
            new FavoriteSmsContactsTable().a(sQLiteDatabase);
            ContactsTable.m8568h(sQLiteDatabase);
        } else if (i == 69 && i2 == 70) {
            ContactsTable.m8568h(sQLiteDatabase);
        } else {
            super.a(sQLiteDatabase, i, i2);
        }
    }

    public final void m8567b(SQLiteDatabase sQLiteDatabase) {
    }
}
