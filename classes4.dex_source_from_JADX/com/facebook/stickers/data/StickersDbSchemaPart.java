package com.facebook.stickers.data;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.facebook.database.properties.DbPropertyUtil;
import com.facebook.database.sqlite.SqlColumn;
import com.facebook.database.sqlite.SqlExpression;
import com.facebook.database.sqlite.SqlExpression.ConjunctionExpression;
import com.facebook.database.sqlite.SqlExpression.Expression;
import com.facebook.database.sqlite.SqlKeys.PrimaryKey;
import com.facebook.database.sqlite.SqlKeys.SqlKey;
import com.facebook.database.sqlite.SqlTable;
import com.facebook.database.supplier.TablesDbSchemaPart;
import com.facebook.debug.log.BLog;
import com.facebook.inject.InjectorLike;
import com.facebook.tools.dextr.runtime.detour.SQLiteDetour;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: reaction_context */
public class StickersDbSchemaPart extends TablesDbSchemaPart {
    private static volatile StickersDbSchemaPart f3828a;

    /* compiled from: reaction_context */
    public final class PropertiesTable extends SqlTable {
        private static final ImmutableList<SqlColumn> f3832a = ImmutableList.of(DbPropertyUtil.f8245a, DbPropertyUtil.f8246b);

        public PropertiesTable() {
            super("stickers_db_properties", f3832a);
        }

        public final void m4280a(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        }
    }

    /* compiled from: reaction_context */
    public final class PackTypesTable extends SqlTable {
        public static final SqlKey f3833a;
        public static final ImmutableList<SqlKey> f3834b;
        private static final ImmutableList<SqlColumn> f3835c = ImmutableList.of(Columns.f3836a, Columns.f3837b, Columns.f3838c);

        /* compiled from: reaction_context */
        public class Columns {
            public static final SqlColumn f3836a = new SqlColumn("type", "INTEGER");
            public static final SqlColumn f3837b = new SqlColumn("id", "TEXT");
            public static final SqlColumn f3838c = new SqlColumn("pack_order", "INTEGER");
        }

        static {
            PrimaryKey primaryKey = new PrimaryKey(ImmutableList.of(Columns.f3837b, Columns.f3836a));
            f3833a = primaryKey;
            f3834b = ImmutableList.of(primaryKey);
        }

        PackTypesTable() {
            super("pack_types", f3835c, f3834b);
        }

        public final void m4281a(SQLiteDatabase sQLiteDatabase) {
            super.a(sQLiteDatabase);
            String a = SqlTable.a("pack_types", "pack_types_type_index", ImmutableList.of(Columns.f3836a));
            SQLiteDetour.a(1390017932);
            sQLiteDatabase.execSQL(a);
            SQLiteDetour.a(-223515173);
        }

        public final void m4282a(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        }
    }

    /* compiled from: reaction_context */
    public final class StickerPacksTable extends SqlTable {
        private static final ImmutableList<SqlColumn> f3839a = ImmutableList.of(Columns.f3792a, Columns.f3793b, Columns.f3794c, Columns.f3795d, Columns.f3796e, Columns.f3797f, Columns.f3798g, Columns.f3799h, Columns.f3800i, Columns.f3802k, Columns.f3803l, Columns.f3804m, new SqlColumn[]{Columns.f3805n, Columns.f3806o, Columns.f3807p, Columns.f3808q, Columns.f3809r, Columns.f3810s, Columns.f3811t, Columns.f3801j, Columns.f3812u, Columns.f3813v});

        /* compiled from: reaction_context */
        public class Columns {
            public static final SqlColumn f3792a = new SqlColumn("id", "TEXT PRIMARY KEY");
            public static final SqlColumn f3793b = new SqlColumn("name", "TEXT");
            public static final SqlColumn f3794c = new SqlColumn("artist", "TEXT");
            public static final SqlColumn f3795d = new SqlColumn("description", "TEXT");
            public static final SqlColumn f3796e = new SqlColumn("thumbnail", "TEXT");
            public static final SqlColumn f3797f = new SqlColumn("thumbnail_disk_uri", "TEXT");
            public static final SqlColumn f3798g = new SqlColumn("preview_uri", "TEXT");
            public static final SqlColumn f3799h = new SqlColumn("tab_icon_uri", "TEXT");
            public static final SqlColumn f3800i = new SqlColumn("price", "INTEGER");
            public static final SqlColumn f3801j = new SqlColumn("updated_time", "INT64");
            public static final SqlColumn f3802k = new SqlColumn("hasAssets", "INTEGER");
            public static final SqlColumn f3803l = new SqlColumn("is_auto_downloadable", "INTEGER");
            public static final SqlColumn f3804m = new SqlColumn("is_comments_capable", "INTEGER");
            public static final SqlColumn f3805n = new SqlColumn("is_composer_capable", "INTEGER");
            public static final SqlColumn f3806o = new SqlColumn("is_messenger_capable", "INTEGER");
            public static final SqlColumn f3807p = new SqlColumn("is_featured", "INTEGER");
            public static final SqlColumn f3808q = new SqlColumn("is_promoted", "INTEGER");
            public static final SqlColumn f3809r = new SqlColumn("in_sticker_tray", "INTEGER");
            public static final SqlColumn f3810s = new SqlColumn("copyrights", "TEXT");
            public static final SqlColumn f3811t = new SqlColumn("sticker_id_list", "TEXT");
            public static final SqlColumn f3812u = new SqlColumn("is_messenger_only", "INTEGER");
            public static final SqlColumn f3813v = new SqlColumn("is_sms_capable", "INTEGER");
        }

        StickerPacksTable() {
            super("sticker_packs", f3839a);
        }

        public final void m4283a(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        }
    }

    /* compiled from: reaction_context */
    public final class RecentStickersTable extends SqlTable {
        private static final ImmutableList<SqlColumn> f3840a = ImmutableList.of(Columns.f3841a);

        /* compiled from: reaction_context */
        public class Columns {
            public static final SqlColumn f3841a = new SqlColumn("list", "TEXT");
        }

        RecentStickersTable() {
            super("recent_stickers", f3840a);
        }

        public final void m4284a(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        }
    }

    /* compiled from: reaction_context */
    public final class StickersTable extends SqlTable {
        private static final ImmutableList<SqlColumn> f3842a = ImmutableList.of(Columns.f3814a, Columns.f3815b, Columns.f3816c, Columns.f3817d, Columns.f3818e);

        /* compiled from: reaction_context */
        public class Columns {
            public static final SqlColumn f3814a = new SqlColumn("id", "TEXT PRIMARY KEY");
            public static final SqlColumn f3815b = new SqlColumn("pack_id", "TEXT");
            public static final SqlColumn f3816c = new SqlColumn("uri", "TEXT");
            public static final SqlColumn f3817d = new SqlColumn("animated_uri", "TEXT");
            public static final SqlColumn f3818e = new SqlColumn("preview_uri", "TEXT");
        }

        StickersTable() {
            super("stickers", f3842a);
        }

        public final void m4285a(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        }
    }

    /* compiled from: reaction_context */
    public final class StickerTagsTable extends SqlTable {
        public static final ImmutableList<SqlColumn> f3843a = ImmutableList.of(Columns.f3845a, Columns.f3846b, Columns.f3847c, Columns.f3848d, Columns.f3849e, Columns.f3850f);
        public static final SqlKey f3844b = new PrimaryKey(ImmutableList.of(Columns.f3845a));

        /* compiled from: reaction_context */
        public class Columns {
            public static final SqlColumn f3845a = new SqlColumn("id", "TEXT");
            public static final SqlColumn f3846b = new SqlColumn("tag", "TEXT");
            public static final SqlColumn f3847c = new SqlColumn("color_code", "TEXT");
            public static final SqlColumn f3848d = new SqlColumn("is_featured", "INTEGER");
            public static final SqlColumn f3849e = new SqlColumn("display_order", "INTEGER");
            public static final SqlColumn f3850f = new SqlColumn("thumbnail_uri", "TEXT");
        }

        StickerTagsTable() {
            super("sticker_tags", f3843a, ImmutableList.of(f3844b));
        }

        public final void m4286a(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        }
    }

    /* compiled from: reaction_context */
    public final class ClosedDownloadPreviewStickerPacksTable extends SqlTable {
        public static final ImmutableList<SqlColumn> f3851a = ImmutableList.of(Columns.f3853a);
        public static final SqlKey f3852b = new PrimaryKey(ImmutableList.of(Columns.f3853a));

        /* compiled from: reaction_context */
        public class Columns {
            public static final SqlColumn f3853a = new SqlColumn("pack_id", "TEXT");
        }

        ClosedDownloadPreviewStickerPacksTable() {
            super("closed_download_preview_sticker_packs", f3851a, f3852b);
        }

        public final void m4287a(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        }
    }

    /* compiled from: reaction_context */
    public final class AssetsTable extends SqlTable {
        private static final ImmutableList<SqlColumn> f3854b = ImmutableList.of(Columns.f3819a, Columns.f3821c, Columns.f3822d, Columns.f3823e, Columns.f3824f, Columns.f3820b, Columns.f3825g, Columns.f3826h);
        private static final SqlKey f3855c = new PrimaryKey(ImmutableList.of(Columns.f3819a, Columns.f3820b));
        private final StickersAssetTablePopulator f3856a;

        /* compiled from: reaction_context */
        public class Columns {
            public static final SqlColumn f3819a = new SqlColumn("sticker_id", "TEXT");
            public static final SqlColumn f3820b = new SqlColumn("type", "TEXT");
            public static final SqlColumn f3821c = new SqlColumn("pack_id", "TEXT");
            public static final SqlColumn f3822d = new SqlColumn("width", "INTEGER");
            public static final SqlColumn f3823e = new SqlColumn("height", "INTEGER");
            public static final SqlColumn f3824f = new SqlColumn("size", "INTEGER");
            public static final SqlColumn f3825g = new SqlColumn("_data", "TEXT");
            public static final SqlColumn f3826h = new SqlColumn("mime_type", "TEXT");
        }

        AssetsTable(StickersAssetTablePopulator stickersAssetTablePopulator) {
            super("sticker_asserts", f3854b, ImmutableList.of(f3855c));
            this.f3856a = stickersAssetTablePopulator;
        }

        public final void m4288a(SQLiteDatabase sQLiteDatabase) {
            super.a(sQLiteDatabase);
            this.f3856a.m4279a(sQLiteDatabase);
        }

        public final void m4289a(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        }
    }

    public static com.facebook.stickers.data.StickersDbSchemaPart m4270a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f3828a;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.stickers.data.StickersDbSchemaPart.class;
        monitor-enter(r1);
        r0 = f3828a;	 Catch:{ all -> 0x003a }
        if (r0 != 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000b:
        if (r5 == 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000d:
        r2 = com.facebook.inject.ScopeSet.a();	 Catch:{ all -> 0x003a }
        r3 = r2.b();	 Catch:{ all -> 0x003a }
        r0 = com.facebook.inject.SingletonScope.class;	 Catch:{ all -> 0x003a }
        r0 = r5.getInstance(r0);	 Catch:{ all -> 0x003a }
        r0 = (com.facebook.inject.SingletonScope) r0;	 Catch:{ all -> 0x003a }
        r4 = r0.enterScope();	 Catch:{ all -> 0x003a }
        r0 = r5.getApplicationInjector();	 Catch:{ all -> 0x0035 }
        r0 = m4272b(r0);	 Catch:{ all -> 0x0035 }
        f3828a = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f3828a;
        return r0;
    L_0x0035:
        r0 = move-exception;
        com.facebook.inject.SingletonScope.a(r4);	 Catch:{ all -> 0x0035 }
        throw r0;	 Catch:{ all -> 0x0035 }
    L_0x003a:
        r0 = move-exception;
        r2.c(r3);	 Catch:{ all -> 0x003a }
        throw r0;	 Catch:{ all -> 0x003a }
    L_0x003f:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x003a }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.stickers.data.StickersDbSchemaPart.a(com.facebook.inject.InjectorLike):com.facebook.stickers.data.StickersDbSchemaPart");
    }

    private static StickersDbSchemaPart m4272b(InjectorLike injectorLike) {
        return new StickersDbSchemaPart(StickersAssetTablePopulator.m4277a(injectorLike));
    }

    @Inject
    public StickersDbSchemaPart(StickersAssetTablePopulator stickersAssetTablePopulator) {
        super("stickers", 32, ImmutableList.of(new PropertiesTable(), new PackTypesTable(), new StickerPacksTable(), new RecentStickersTable(), new StickersTable(), new StickerTagsTable(), new ClosedDownloadPreviewStickerPacksTable(), new AssetsTable(stickersAssetTablePopulator)));
    }

    public final void m4276a(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        while (i < i2) {
            i = m4271b(sQLiteDatabase, i, i2);
        }
        String a = SqlTable.a("pack_lists");
        SQLiteDetour.a(75840064);
        sQLiteDatabase.execSQL(a);
        SQLiteDetour.a(1925574947);
    }

    private int m4271b(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        int i3 = i + 1;
        String a;
        if (i == 31) {
            a = SqlTable.a("sticker_packs", Columns.f3813v);
            SQLiteDetour.a(-475762167);
            sQLiteDatabase.execSQL(a);
            SQLiteDetour.a(1909660704);
            sQLiteDatabase.delete("sticker_packs", null, null);
            sQLiteDatabase.delete("pack_types", null, null);
            return i3;
        } else if (i == 30) {
            a = SqlTable.a("sticker_packs", Columns.f3797f);
            SQLiteDetour.a(-1575261367);
            sQLiteDatabase.execSQL(a);
            SQLiteDetour.a(-1352544656);
            return i3;
        } else if (i == 29) {
            a = SqlTable.a("closed_download_preview_sticker_packs", ClosedDownloadPreviewStickerPacksTable.f3851a, ImmutableList.of(ClosedDownloadPreviewStickerPacksTable.f3852b));
            SQLiteDetour.a(-1498802475);
            sQLiteDatabase.execSQL(a);
            SQLiteDetour.a(-816840481);
            return i3;
        } else if (i == 28) {
            m4274f(sQLiteDatabase);
            return i3;
        } else if (i == 27) {
            m4273e(sQLiteDatabase);
            return i3;
        } else if (i == 24) {
            a = SqlTable.a("sticker_tags", StickerTagsTable.f3843a, ImmutableList.of(StickerTagsTable.f3844b));
            SQLiteDetour.a(-131661600);
            sQLiteDatabase.execSQL(a);
            SQLiteDetour.a(-1576604310);
            return i3;
        } else {
            m4275j(sQLiteDatabase);
            a(sQLiteDatabase);
            return i2;
        }
    }

    private static void m4273e(SQLiteDatabase sQLiteDatabase) {
        Object obj;
        SQLiteDetour.a(sQLiteDatabase, -841684886);
        try {
            Expression a = SqlExpression.a(Columns.f3837b.a(), "227877430692340");
            sQLiteDatabase.delete("pack_types", a.a(), a.b());
            a = SqlExpression.a(Columns.f3792a.a(), "227877430692340");
            sQLiteDatabase.delete("sticker_packs", a.a(), a.b());
            sQLiteDatabase.setTransactionSuccessful();
            obj = 1;
        } catch (Exception e) {
            obj = null;
        } finally {
            SQLiteDetour.b(sQLiteDatabase, 1213707418);
        }
        if (obj == null) {
            m4275j(sQLiteDatabase);
        }
    }

    private static void m4274f(SQLiteDatabase sQLiteDatabase) {
        String[] strArr = new String[]{Columns.f3836a.a()};
        String str = Columns.f3836a + " DESC";
        Cursor query = sQLiteDatabase.query(true, "pack_types", strArr, null, null, null, null, str, null);
        int a = Columns.f3836a.a(query);
        List<Integer> a2 = Lists.a();
        while (query.moveToNext()) {
            a2.add(Integer.valueOf(query.getInt(a)));
        }
        query.close();
        for (Integer num : a2) {
            Expression a3 = SqlExpression.a(Columns.f3836a.a(), num.toString());
            List a4 = Lists.a();
            Cursor query2 = sQLiteDatabase.query("pack_types", null, a3.a(), a3.b(), null, null, Columns.f3838c + " DESC");
            int a5 = Columns.f3837b.a(query2);
            while (query2.moveToNext()) {
                a4.add(query2.getString(a5));
            }
            query2.close();
            SQLiteDetour.a(sQLiteDatabase, 1827751702);
            a5 = 0;
            while (a5 < a4.size()) {
                try {
                    ConjunctionExpression a6 = SqlExpression.a();
                    a6.a(SqlExpression.a(Columns.f3836a.a(), num.toString()));
                    a6.a(SqlExpression.a(Columns.f3837b.a(), (String) a4.get(a5)));
                    ContentValues contentValues = new ContentValues();
                    contentValues.put(Columns.f3838c.a(), Integer.valueOf(a5));
                    sQLiteDatabase.update("pack_types", contentValues, a6.a(), a6.b());
                    a5++;
                } catch (Throwable th) {
                    SQLiteDetour.b(sQLiteDatabase, 459300631);
                }
            }
            sQLiteDatabase.setTransactionSuccessful();
            SQLiteDetour.b(sQLiteDatabase, -572754157);
        }
        BLog.b("Database", "Upgraded");
    }

    private static void m4275j(SQLiteDatabase sQLiteDatabase) {
        String a = SqlTable.a("stickers_db_properties");
        SQLiteDetour.a(-1060811871);
        sQLiteDatabase.execSQL(a);
        SQLiteDetour.a(579536645);
        a = SqlTable.a("pack_types");
        SQLiteDetour.a(-1290419547);
        sQLiteDatabase.execSQL(a);
        SQLiteDetour.a(1147607833);
        a = SqlTable.a("sticker_packs");
        SQLiteDetour.a(1775354907);
        sQLiteDatabase.execSQL(a);
        SQLiteDetour.a(1773946925);
        a = SqlTable.a("recent_stickers");
        SQLiteDetour.a(118502299);
        sQLiteDatabase.execSQL(a);
        SQLiteDetour.a(2092642845);
        a = SqlTable.a("stickers");
        SQLiteDetour.a(-2115483871);
        sQLiteDatabase.execSQL(a);
        SQLiteDetour.a(688240363);
        a = SqlTable.a("sticker_tags");
        SQLiteDetour.a(-1415297716);
        sQLiteDatabase.execSQL(a);
        SQLiteDetour.a(1173690063);
        a = SqlTable.a("sticker_asserts");
        SQLiteDetour.a(-1423116972);
        sQLiteDatabase.execSQL(a);
        SQLiteDetour.a(-1879643377);
        a = SqlTable.a("closed_download_preview_sticker_packs");
        SQLiteDetour.a(-975398108);
        sQLiteDatabase.execSQL(a);
        SQLiteDetour.a(-1356120997);
    }
}
