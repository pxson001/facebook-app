package com.facebook.api.feedcache.db;

import android.database.sqlite.SQLiteDatabase;
import com.facebook.common.udppriming.client.ColdStartPrimingInformation;
import com.facebook.database.sqlite.SqlColumn;
import com.facebook.database.sqlite.SqlKeys$PrimaryKey;
import com.facebook.database.sqlite.SqlKeys$SqlKey;
import com.facebook.database.sqlite.SqlTable;
import com.facebook.database.supplier.TablesDbSchemaPart;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.tools.dextr.runtime.detour.SQLiteDetour;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: set_hscroll_unit_visible_item_index */
public class FeedDbSchemaPart extends TablesDbSchemaPart {
    private static volatile FeedDbSchemaPart f6352a;

    /* compiled from: set_hscroll_unit_visible_item_index */
    public final class HomeStoriesTable extends SqlTable {
        private static final SqlKeys$SqlKey f6353a = new SqlKeys$PrimaryKey(ImmutableList.of(Columns.f5265a, Columns.f5268d));
        private static final ImmutableList<SqlColumn> f6354b = ImmutableList.of(Columns.f5265a, Columns.f5266b, Columns.f5267c, Columns.f5268d, Columns.f5269e, Columns.f5270f, Columns.f5271g, Columns.f5272h, Columns.f5273i, Columns.f5274j, Columns.f5276l, Columns.f5275k, Columns.f5277m, Columns.f5278n, Columns.f5279o, Columns.f5280p, Columns.f5281q, Columns.f5282r, Columns.f5283s, Columns.f5284t, Columns.f5285u, Columns.f5286v, Columns.f5287w, Columns.f5288x, Columns.f5289y, Columns.f5290z);
        private static final ImmutableList<SqlKeys$SqlKey> f6355c = ImmutableList.of(f6353a);
        private final boolean f6356d;

        /* compiled from: set_hscroll_unit_visible_item_index */
        public class Columns {
            public static final SqlColumn f5265a = new SqlColumn("feed_type", "TEXT");
            public static final SqlColumn f5266b = new SqlColumn("fetched_at", "TEXT");
            public static final SqlColumn f5267c = new SqlColumn("cursor", "TEXT");
            public static final SqlColumn f5268d = new SqlColumn("dedup_key", "TEXT");
            public static final SqlColumn f5269e = new SqlColumn("sort_key", "TEXT");
            public static final SqlColumn f5270f = new SqlColumn("ranking_weight", "REAL");
            public static final SqlColumn f5271g = new SqlColumn("features_meta", "TEXT");
            public static final SqlColumn f5272h = new SqlColumn("disallow_first", "INTEGER");
            public static final SqlColumn f5273i = new SqlColumn("seen_state", "INTEGER");
            public static final SqlColumn f5274j = new SqlColumn("image_seen_state", "INTEGER");
            public static final SqlColumn f5275k = new SqlColumn("see_first_state", "INTEGER");
            public static final SqlColumn f5276l = new SqlColumn("image_cache_state", "INTEGER");
            public static final SqlColumn f5277m = new SqlColumn("row_type", "INTEGER");
            public static final SqlColumn f5278n = new SqlColumn("story_data", "BLOB");
            public static final SqlColumn f5279o = new SqlColumn("story_type", "TEXT");
            public static final SqlColumn f5280p = new SqlColumn("cache_file_path", "TEXT");
            public static final SqlColumn f5281q = new SqlColumn("cache_file_offset", "INTEGER");
            public static final SqlColumn f5282r = new SqlColumn("cache_file_data_length", "INTEGER");
            public static final SqlColumn f5283s = new SqlColumn("unit_position_in_flatbuffer", "INTEGER");
            public static final SqlColumn f5284t = new SqlColumn("mutation_data", "BLOB");
            public static final SqlColumn f5285u = new SqlColumn("extra_data", "BLOB");
            public static final SqlColumn f5286v = new SqlColumn("mutation_supported", "INTEGER");
            public static final SqlColumn f5287w = new SqlColumn("client_sort_key", "TEXT");
            public static final SqlColumn f5288x = new SqlColumn("client_cursor", "TEXT");
            public static final SqlColumn f5289y = new SqlColumn("cache_id", "TEXT");
            public static final SqlColumn f5290z = new SqlColumn("story_ranking_time", "TEXT");
        }

        HomeStoriesTable(boolean z) {
            super("home_stories", f6354b, f6355c);
            this.f6356d = z;
        }

        public final void mo1453a(SQLiteDatabase sQLiteDatabase) {
            super.mo1453a(sQLiteDatabase);
            String a = SqlTable.m2073a("home_stories", "home_stories_cursor_index", ImmutableList.of(Columns.f5267c));
            SQLiteDetour.a(1068546251);
            sQLiteDatabase.execSQL(a);
            SQLiteDetour.a(374135549);
            a = SqlTable.m2073a("home_stories", "home_stories_sort_key_index", ImmutableList.of(Columns.f5269e));
            SQLiteDetour.a(1790312271);
            sQLiteDatabase.execSQL(a);
            SQLiteDetour.a(1520870953);
            a = SqlTable.m2073a("home_stories", "home_stories_seen_state_index", ImmutableList.of(Columns.f5273i));
            SQLiteDetour.a(449690731);
            sQLiteDatabase.execSQL(a);
            SQLiteDetour.a(-1700010393);
            a = SqlTable.m2073a("home_stories", "home_stories_client_sort_key_index", ImmutableList.of(Columns.f5287w));
            SQLiteDetour.a(-2057638794);
            sQLiteDatabase.execSQL(a);
            SQLiteDetour.a(203161457);
            a = SqlTable.m2073a("home_stories", "home_stories_client_cursor_key_index", ImmutableList.of(Columns.f5288x));
            SQLiteDetour.a(-838809157);
            sQLiteDatabase.execSQL(a);
            SQLiteDetour.a(1675239681);
            a = SqlTable.m2073a("home_stories", "home_stories_story_type_index", ImmutableList.of(Columns.f5279o));
            SQLiteDetour.a(-228764746);
            sQLiteDatabase.execSQL(a);
            SQLiteDetour.a(335619327);
            a = SqlTable.m2073a("home_stories", "cache_id_index", ImmutableList.of(Columns.f5289y));
            SQLiteDetour.a(-234798335);
            sQLiteDatabase.execSQL(a);
            SQLiteDetour.a(1175290167);
        }

        public final void mo1479b(SQLiteDatabase sQLiteDatabase) {
            if (!this.f6356d) {
                SQLiteDetour.a(1003873315);
                sQLiteDatabase.execSQL("DELETE FROM home_stories");
                SQLiteDetour.a(1815872855);
                ColdStartPrimingInformation.a.a(null);
            }
        }
    }

    /* compiled from: set_hscroll_unit_visible_item_index */
    public final class HomeStoriesMediaTable extends SqlTable {
        private static final SqlKeys$SqlKey f6357a = new SqlKeys$PrimaryKey(ImmutableList.of(Columns.f5397a, Columns.f5399c));
        private static final ImmutableList<SqlColumn> f6358b = ImmutableList.of(Columns.f5397a, Columns.f5398b, Columns.f5399c);
        private static final ImmutableList<SqlKeys$SqlKey> f6359c = ImmutableList.of(f6357a);
        private final boolean f6360d;

        /* compiled from: set_hscroll_unit_visible_item_index */
        public class Columns {
            public static final SqlColumn f5397a = new SqlColumn("cache_id", "TEXT");
            public static final SqlColumn f5398b = new SqlColumn("image_cache_state", "INTEGER");
            public static final SqlColumn f5399c = new SqlColumn("image_url", "TEXT");
        }

        HomeStoriesMediaTable(boolean z) {
            super("home_stories_media", f6358b, f6359c);
            this.f6360d = z;
        }

        public final void mo1453a(SQLiteDatabase sQLiteDatabase) {
            super.mo1453a(sQLiteDatabase);
            String a = SqlTable.m2073a("home_stories_media", "cache_id_index", ImmutableList.of(Columns.f5397a));
            SQLiteDetour.a(-846048348);
            sQLiteDatabase.execSQL(a);
            SQLiteDetour.a(-384730063);
        }

        public final void mo1479b(SQLiteDatabase sQLiteDatabase) {
            if (!this.f6360d) {
                SQLiteDetour.a(-862200092);
                sQLiteDatabase.execSQL("DELETE FROM home_stories_media");
                SQLiteDetour.a(1824695428);
            }
        }
    }

    public static com.facebook.api.feedcache.db.FeedDbSchemaPart m10753a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find immediate dominator for block B:24:0x003b in {17, 19, 21, 23, 26, 28} preds:[]
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
        r0 = f6352a;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.api.feedcache.db.FeedDbSchemaPart.class;
        monitor-enter(r1);
        r0 = f6352a;	 Catch:{ all -> 0x003a }
        if (r0 != 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000b:
        if (r5 == 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000d:
        r2 = com.facebook.inject.ScopeSet.m1499a();	 Catch:{ all -> 0x003a }
        r3 = r2.m1503b();	 Catch:{ all -> 0x003a }
        r0 = com.facebook.inject.SingletonScope.class;	 Catch:{ all -> 0x003a }
        r0 = r5.getInstance(r0);	 Catch:{ all -> 0x003a }
        r0 = (com.facebook.inject.SingletonScope) r0;	 Catch:{ all -> 0x003a }
        r4 = r0.enterScope();	 Catch:{ all -> 0x003a }
        r0 = r5.getApplicationInjector();	 Catch:{ all -> 0x0035 }
        r0 = m10754b(r0);	 Catch:{ all -> 0x0035 }
        f6352a = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f6352a;
        return r0;
    L_0x0035:
        r0 = move-exception;
        com.facebook.inject.SingletonScope.m1338a(r4);	 Catch:{ all -> 0x0035 }
        throw r0;	 Catch:{ all -> 0x0035 }
    L_0x003a:
        r0 = move-exception;
        r2.m1505c(r3);	 Catch:{ all -> 0x003a }
        throw r0;	 Catch:{ all -> 0x003a }
    L_0x003f:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x003a }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.api.feedcache.db.FeedDbSchemaPart.a(com.facebook.inject.InjectorLike):com.facebook.api.feedcache.db.FeedDbSchemaPart");
    }

    private static FeedDbSchemaPart m10754b(InjectorLike injectorLike) {
        return new FeedDbSchemaPart(Boolean.valueOf(GatekeeperStoreImplMethodAutoProvider.m2131a(injectorLike).m2189a(808, false)));
    }

    protected final void mo319a(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        super.mo319a(sQLiteDatabase, i, i2);
        if (i <= 34) {
            SQLiteDetour.a(888895332);
            sQLiteDatabase.execSQL("drop table if exists feed_unit_partial;");
            SQLiteDetour.a(-1642987176);
            SQLiteDetour.a(1197216804);
            sQLiteDatabase.execSQL("drop table if exists feedback;");
            SQLiteDetour.a(-1968079991);
            SQLiteDetour.a(992003832);
            sQLiteDatabase.execSQL("drop table if exists feed_unit_impression;");
            SQLiteDetour.a(-955256801);
            SQLiteDetour.a(-2022928781);
            sQLiteDatabase.execSQL("drop table if exists feed_unit_low_engagement;");
            SQLiteDetour.a(1859132783);
        }
    }

    @Inject
    FeedDbSchemaPart(Boolean bool) {
        boolean z = true;
        String str = "feed";
        boolean z2 = bool != null && bool.booleanValue();
        HomeStoriesTable homeStoriesTable = new HomeStoriesTable(z2);
        if (bool == null || !bool.booleanValue()) {
            z = false;
        }
        super(str, 50, ImmutableList.of(homeStoriesTable, new HomeStoriesMediaTable(z)));
    }
}
