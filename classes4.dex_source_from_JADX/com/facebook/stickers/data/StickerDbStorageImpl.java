package com.facebook.stickers.data;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;
import android.database.sqlite.SQLiteStatement;
import android.net.Uri;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.util.StringUtil;
import com.facebook.common.util.TriState;
import com.facebook.database.sqlite.SqlExpression;
import com.facebook.database.sqlite.SqlExpression.ConjunctionExpression;
import com.facebook.database.sqlite.SqlExpression.Expression;
import com.facebook.debug.log.BLog;
import com.facebook.inject.InjectorLike;
import com.facebook.stickers.data.StickersDbSchemaPart.AssetsTable;
import com.facebook.stickers.data.StickersDbSchemaPart.ClosedDownloadPreviewStickerPacksTable;
import com.facebook.stickers.data.StickersDbSchemaPart.PackTypesTable;
import com.facebook.stickers.data.StickersDbSchemaPart.RecentStickersTable;
import com.facebook.stickers.data.StickersDbSchemaPart.StickerPacksTable.Columns;
import com.facebook.stickers.data.StickersDbSchemaPart.StickerTagsTable;
import com.facebook.stickers.data.StickersDbSchemaPart.StickersTable;
import com.facebook.stickers.model.Sticker;
import com.facebook.stickers.model.StickerAssetType;
import com.facebook.stickers.model.StickerBuilder;
import com.facebook.stickers.model.StickerPack;
import com.facebook.stickers.model.StickerPackBuilder;
import com.facebook.stickers.model.StickerPackType;
import com.facebook.stickers.model.StickerTag;
import com.facebook.stickers.model.StickerTagBuilder;
import com.facebook.tools.dextr.runtime.detour.SQLiteDetour;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.google.common.base.Throwables;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.io.Files;
import java.io.File;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import javax.annotation.Nullable;
import javax.annotation.concurrent.ThreadSafe;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
@ThreadSafe
/* compiled from: reaction_count */
public class StickerDbStorageImpl {
    private static final Class<?> f3783a = StickerDbStorageImpl.class;
    private static final String[] f3784b = new String[]{"sticker_packs." + Columns.f3792a.d, Columns.f3793b.d, Columns.f3794c.d, Columns.f3795d.d, Columns.f3796e.d, Columns.f3797f.d, Columns.f3798g.d, Columns.f3799h.d, Columns.f3800i.d, Columns.f3801j.d, Columns.f3802k.d, Columns.f3803l.d, Columns.f3804m.d, Columns.f3805n.d, Columns.f3806o.d, Columns.f3807p.d, Columns.f3808q.d, Columns.f3809r.d, Columns.f3810s.d, Columns.f3811t.d, Columns.f3812u.d, Columns.f3813v.d};
    private static final ImmutableMap<StickerPackType, Integer> f3785c = ImmutableMap.of(StickerPackType.OWNED_PACKS, Integer.valueOf(0), StickerPackType.STORE_PACKS, Integer.valueOf(1), StickerPackType.DOWNLOADED_PACKS, Integer.valueOf(2), StickerPackType.AUTODOWNLOADED_PACKS, Integer.valueOf(3));
    private static final String f3786d = ("SELECT " + StickersTable.Columns.f3815b.d + " FROM stickers" + " WHERE " + StickersTable.Columns.f3814a + " = ?");
    private static final String f3787e = StringFormatUtil.a("INSERT OR REPLACE INTO sticker_asserts (" + AssetsTable.Columns.f3819a.d + ", " + AssetsTable.Columns.f3820b.d + ", " + AssetsTable.Columns.f3821c.d + ", " + AssetsTable.Columns.f3825g.d + ", " + AssetsTable.Columns.f3826h.d + ") VALUES (?, ?, (%s), ?, ?)", new Object[]{f3786d});
    private static final String f3788f = ("SELECT s." + StickersTable.Columns.f3814a.d + " as sticker_id, s." + StickersTable.Columns.f3815b.d + " as sticker_pack_id, s." + StickersTable.Columns.f3816c.d + " as static_uri, s." + StickersTable.Columns.f3817d.d + " as animated_uri, s." + StickersTable.Columns.f3818e.d + " as preview_uri, static_assets." + AssetsTable.Columns.f3825g.d + " as static_asset, animated_assets." + AssetsTable.Columns.f3825g.d + " as animated_asset, preview_assets." + AssetsTable.Columns.f3825g.d + " as preview_asset FROM " + "stickers AS s " + "LEFT OUTER JOIN sticker_asserts" + " as static_assets ON (" + "static_assets." + AssetsTable.Columns.f3820b.d + " = '" + StickerAssetType.STATIC.getDbName() + "' AND static_assets." + AssetsTable.Columns.f3819a.d + " = s." + StickersTable.Columns.f3814a.d + ") LEFT OUTER JOIN " + "sticker_asserts as animated_assets " + "ON (animated_assets." + AssetsTable.Columns.f3820b.d + " = '" + StickerAssetType.ANIMATED.getDbName() + "' AND animated_assets." + AssetsTable.Columns.f3819a.d + " = s." + StickersTable.Columns.f3814a.d + ") LEFT OUTER JOIN " + "sticker_asserts as preview_assets " + "ON (preview_assets." + AssetsTable.Columns.f3820b.d + " = '" + StickerAssetType.PREVIEW.getDbName() + "' AND preview_assets." + AssetsTable.Columns.f3819a.d + " = s." + StickersTable.Columns.f3814a.d + ") ");
    private static volatile StickerDbStorageImpl f3789i;
    private final StickersDatabaseSupplier f3790g;
    private final StickerPackSerialization f3791h;

    public static com.facebook.stickers.data.StickerDbStorageImpl m4229a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f3789i;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.stickers.data.StickerDbStorageImpl.class;
        monitor-enter(r1);
        r0 = f3789i;	 Catch:{ all -> 0x003a }
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
        r0 = m4236b(r0);	 Catch:{ all -> 0x0035 }
        f3789i = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f3789i;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.stickers.data.StickerDbStorageImpl.a(com.facebook.inject.InjectorLike):com.facebook.stickers.data.StickerDbStorageImpl");
    }

    private static StickerDbStorageImpl m4236b(InjectorLike injectorLike) {
        return new StickerDbStorageImpl(StickersDatabaseSupplier.m4268a(injectorLike), StickerPackSerialization.m4290a(injectorLike));
    }

    @Inject
    public StickerDbStorageImpl(StickersDatabaseSupplier stickersDatabaseSupplier, StickerPackSerialization stickerPackSerialization) {
        this.f3790g = stickersDatabaseSupplier;
        this.f3791h = stickerPackSerialization;
    }

    public final ImmutableList<StickerPack> m4249a(StickerPackType stickerPackType) {
        int e = m4246e(stickerPackType);
        Builder builder = new Builder();
        SQLiteQueryBuilder sQLiteQueryBuilder = new SQLiteQueryBuilder();
        sQLiteQueryBuilder.setTables("pack_types INNER JOIN sticker_packs ON pack_types." + PackTypesTable.Columns.f3837b.a() + "=sticker_packs" + "." + Columns.f3792a.a());
        Expression a = SqlExpression.a(PackTypesTable.Columns.f3836a.a(), Integer.toString(e));
        SQLiteDatabase a2 = this.f3790g.a();
        SQLiteDetour.a(a2, -734629868);
        Cursor query = sQLiteQueryBuilder.query(this.f3790g.a(), f3784b, a.a(), a.b(), null, null, PackTypesTable.Columns.f3838c + " DESC");
        while (query.moveToNext()) {
            try {
                builder.c(m4230a(query));
            } finally {
                query.close();
                SQLiteDetour.b(a2, 872052996);
            }
        }
        a2.setTransactionSuccessful();
        return builder.b();
    }

    @Nullable
    public final StickerPack m4258b(String str) {
        StickerPack stickerPack = null;
        Expression a = SqlExpression.a(Columns.f3792a.a(), str);
        SQLiteDatabase a2 = this.f3790g.a();
        SQLiteDetour.a(a2, -24068053);
        Cursor query = a2.query("sticker_packs", null, a.a(), a.b(), null, null, null);
        try {
            if (query.getCount() > 0) {
                query.moveToNext();
                stickerPack = m4230a(query);
            }
            a2.setTransactionSuccessful();
            return stickerPack;
        } finally {
            query.close();
            int i = 375959097;
            SQLiteDetour.b(a2, 375959097);
        }
    }

    public final void m4251a(StickerPack stickerPack) {
        if (m4238c(stickerPack) != 1) {
            throw new IllegalArgumentException("Cannot update a sticker pack not originally in the table.");
        }
    }

    private StickerPack m4230a(Cursor cursor) {
        int a = Columns.f3792a.a(cursor);
        int a2 = Columns.f3793b.a(cursor);
        int a3 = Columns.f3794c.a(cursor);
        int a4 = Columns.f3795d.a(cursor);
        int a5 = Columns.f3796e.a(cursor);
        int a6 = Columns.f3797f.a(cursor);
        int a7 = Columns.f3798g.a(cursor);
        int a8 = Columns.f3799h.a(cursor);
        int a9 = Columns.f3800i.a(cursor);
        int a10 = Columns.f3801j.a(cursor);
        int a11 = Columns.f3802k.a(cursor);
        int a12 = Columns.f3803l.a(cursor);
        int a13 = Columns.f3804m.a(cursor);
        int a14 = Columns.f3805n.a(cursor);
        int a15 = Columns.f3806o.a(cursor);
        int a16 = Columns.f3807p.a(cursor);
        int a17 = Columns.f3808q.a(cursor);
        int a18 = Columns.f3809r.a(cursor);
        int a19 = Columns.f3810s.a(cursor);
        int a20 = Columns.f3811t.a(cursor);
        int a21 = Columns.f3812u.a(cursor);
        int a22 = Columns.f3813v.a(cursor);
        String string = cursor.getString(a);
        ImmutableList a23 = this.f3791h.m4294a(cursor.getString(a19));
        ImmutableList c = this.f3791h.m4297c(cursor.getString(a20));
        String string2 = cursor.getString(a6);
        return new StickerPackBuilder().a(string).b(cursor.getString(a2)).c(cursor.getString(a3)).d(cursor.getString(a4)).a(Uri.parse(cursor.getString(a5))).b(string2 == null ? null : Uri.parse(string2)).c(Uri.parse(cursor.getString(a7))).d(Uri.parse(cursor.getString(a8))).a(cursor.getInt(a9)).a((long) cursor.getInt(a10)).a(cursor.getInt(a11) == 1).b(cursor.getInt(a12) == 1).c(cursor.getInt(a13) == 1).d(cursor.getInt(a14) == 1).e(cursor.getInt(a15) == 1).f(cursor.getInt(a16) == 1).g(cursor.getInt(a17) == 1).h(cursor.getInt(a18) == 1).a(a23).b(c).i(cursor.getInt(a21) == 1).j(cursor.getInt(a22) == 1).w();
    }

    public final boolean m4257a(String str) {
        Expression a = SqlExpression.a(Columns.f3792a.a(), str);
        SQLiteDatabase a2 = this.f3790g.a();
        SQLiteDetour.a(a2, -1601018749);
        Cursor query = a2.query("sticker_packs", null, a.a(), a.b(), null, null, null);
        try {
            boolean z = query.getCount() > 0;
            a2.setTransactionSuccessful();
            return z;
        } finally {
            query.close();
            SQLiteDetour.b(a2, -1353956915);
        }
    }

    public final TriState m4265c(String str) {
        if (m4264b(StickerPackType.DOWNLOADED_PACKS)) {
            return m4235a(str, StickerPackType.DOWNLOADED_PACKS) ? TriState.YES : TriState.NO;
        } else {
            return TriState.UNSET;
        }
    }

    public final void m4252a(StickerPackType stickerPackType, List<StickerPack> list) {
        SQLiteDatabase a = this.f3790g.a();
        SQLiteDetour.a(a, -1977894866);
        try {
            m4239c(stickerPackType);
            m4240c(stickerPackType, list);
            a.setTransactionSuccessful();
        } finally {
            SQLiteDetour.b(a, 2066068050);
        }
    }

    private void m4239c(StickerPackType stickerPackType) {
        m4241c(m4243d(stickerPackType));
        Expression a = SqlExpression.a(PackTypesTable.Columns.f3836a.a(), Integer.toString(m4246e(stickerPackType)));
        SQLiteDatabase a2 = this.f3790g.a();
        SQLiteDetour.a(a2, -1734856277);
        try {
            a2.delete("pack_types", a.a(), a.b());
            a2.setTransactionSuccessful();
        } finally {
            SQLiteDetour.b(a2, 1042494797);
        }
    }

    private List<String> m4243d(StickerPackType stickerPackType) {
        Map a = Maps.a(f3785c);
        a.remove(stickerPackType);
        Collection a2 = Lists.a();
        for (Integer intValue : a.values()) {
            a2.add(Integer.toString(intValue.intValue()));
        }
        int e = m4246e(stickerPackType);
        ConjunctionExpression a3 = SqlExpression.a(new Expression[]{SqlExpression.a(PackTypesTable.Columns.f3836a.a(), Integer.toString(e)), SqlExpression.a(SqlExpression.a(PackTypesTable.Columns.f3836a.a(), a2))});
        List<String> a4 = Lists.a();
        SQLiteDatabase a5 = this.f3790g.a();
        SQLiteDetour.a(a5, 1463723186);
        Cursor query = a5.query("pack_types", null, a3.a(), a3.b(), null, null, null);
        try {
            int a6 = Columns.f3792a.a(query);
            while (query.moveToNext()) {
                a4.add(query.getString(a6));
            }
            a5.setTransactionSuccessful();
            return a4;
        } finally {
            query.close();
            SQLiteDetour.b(a5, 701986176);
        }
    }

    private void m4241c(List<String> list) {
        if (!list.isEmpty()) {
            Expression a = SqlExpression.a(Columns.f3792a.a(), list);
            SQLiteDatabase a2 = this.f3790g.a();
            SQLiteDetour.a(a2, 497567804);
            try {
                a2.delete("sticker_packs", a.a(), a.b());
                a2.setTransactionSuccessful();
            } finally {
                SQLiteDetour.b(a2, -678841754);
            }
        }
    }

    public final boolean m4264b(StickerPackType stickerPackType) {
        Expression a = SqlExpression.a(PackTypesTable.Columns.f3836a.a(), Integer.toString(m4246e(stickerPackType)));
        SQLiteDatabase a2 = this.f3790g.a();
        SQLiteDetour.a(a2, -559435036);
        Cursor query = a2.query("pack_types", null, a.a(), a.b(), null, null, null);
        try {
            boolean z = query.getCount() > 0;
            a2.setTransactionSuccessful();
            return z;
        } finally {
            query.close();
            SQLiteDetour.b(a2, 1356362677);
        }
    }

    public final void m4261b(StickerPackType stickerPackType, List<StickerPack> list) {
        SQLiteDatabase a = this.f3790g.a();
        SQLiteDetour.a(a, 1929041336);
        try {
            m4240c(stickerPackType, list);
            a.setTransactionSuccessful();
        } finally {
            SQLiteDetour.b(a, -307647331);
        }
    }

    private void m4240c(StickerPackType stickerPackType, List<StickerPack> list) {
        SQLiteDatabase a = this.f3790g.a();
        Expression a2 = SqlExpression.a(PackTypesTable.Columns.f3836a.a(), Integer.toString(m4246e(stickerPackType)));
        SQLiteDetour.a(a, -1294706790);
        try {
            Cursor query = a.query("pack_types", new String[]{PackTypesTable.Columns.f3838c.a()}, a2.a(), a2.b(), null, null, PackTypesTable.Columns.f3838c.a() + " DESC");
            long j = 0;
            if (query.moveToFirst()) {
                j = query.getLong(PackTypesTable.Columns.f3838c.a(query)) + 1;
            }
            query.close();
            for (StickerPack stickerPack : Lists.a(list)) {
                if (!m4235a(stickerPack.a(), stickerPackType)) {
                    m4234a(stickerPackType, stickerPack, j);
                    j++;
                }
                m4244d(stickerPack);
            }
            a.setTransactionSuccessful();
        } finally {
            SQLiteDetour.b(a, -726616124);
        }
    }

    private void m4234a(StickerPackType stickerPackType, StickerPack stickerPack, long j) {
        int e = m4246e(stickerPackType);
        SQLiteDatabase a = this.f3790g.a();
        SQLiteDetour.a(a, -619541328);
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put(PackTypesTable.Columns.f3836a.a(), Integer.valueOf(e));
            contentValues.put(PackTypesTable.Columns.f3837b.a(), stickerPack.a());
            contentValues.put(PackTypesTable.Columns.f3838c.a(), Long.valueOf(j));
            SQLiteDetour.a(437796523);
            a.insertOrThrow("pack_types", null, contentValues);
            SQLiteDetour.a(-978768181);
            a.setTransactionSuccessful();
        } finally {
            SQLiteDetour.b(a, 869414784);
        }
    }

    private int m4238c(StickerPack stickerPack) {
        Expression a = SqlExpression.a(Columns.f3792a.a(), stickerPack.a());
        SQLiteDatabase a2 = this.f3790g.a();
        SQLiteDetour.a(a2, 1434288916);
        try {
            int update = a2.update("sticker_packs", m4247e(stickerPack), a.a(), a.b());
            a2.setTransactionSuccessful();
            return update;
        } finally {
            SQLiteDetour.b(a2, -1198439997);
        }
    }

    private void m4244d(StickerPack stickerPack) {
        SQLiteDatabase a = this.f3790g.a();
        SQLiteDetour.a(a, -593430578);
        try {
            ContentValues e = m4247e(stickerPack);
            SQLiteDetour.a(-701675056);
            a.replaceOrThrow("sticker_packs", null, e);
            SQLiteDetour.a(1185240202);
            a.setTransactionSuccessful();
        } finally {
            SQLiteDetour.b(a, -1597726728);
        }
    }

    private ContentValues m4247e(StickerPack stickerPack) {
        int i;
        String str;
        int i2 = 1;
        String c = this.f3791h.m4298c((List) stickerPack.t);
        ContentValues contentValues = new ContentValues();
        contentValues.put(Columns.f3792a.d, stickerPack.a);
        contentValues.put(Columns.f3793b.d, stickerPack.b);
        contentValues.put(Columns.f3794c.d, stickerPack.c);
        contentValues.put(Columns.f3795d.d, stickerPack.d);
        contentValues.put(Columns.f3796e.d, m4231a(stickerPack.e));
        contentValues.put(Columns.f3797f.d, m4231a(stickerPack.f));
        contentValues.put(Columns.f3798g.d, m4231a(stickerPack.g));
        contentValues.put(Columns.f3799h.d, m4231a(stickerPack.h));
        contentValues.put(Columns.f3795d.d, stickerPack.d);
        contentValues.put(Columns.f3800i.d, Integer.valueOf(stickerPack.i));
        contentValues.put(Columns.f3801j.d, Long.valueOf(stickerPack.j()));
        contentValues.put(Columns.f3802k.d, Boolean.valueOf(stickerPack.k));
        String str2 = Columns.f3803l.d;
        if (stickerPack.l) {
            i = 1;
        } else {
            i = 0;
        }
        contentValues.put(str2, Integer.valueOf(i));
        str2 = Columns.f3804m.d;
        if (stickerPack.m) {
            i = 1;
        } else {
            i = 0;
        }
        contentValues.put(str2, Integer.valueOf(i));
        str2 = Columns.f3805n.d;
        if (stickerPack.n) {
            i = 1;
        } else {
            i = 0;
        }
        contentValues.put(str2, Integer.valueOf(i));
        str2 = Columns.f3806o.d;
        if (stickerPack.o) {
            i = 1;
        } else {
            i = 0;
        }
        contentValues.put(str2, Integer.valueOf(i));
        str2 = Columns.f3807p.d;
        if (stickerPack.p) {
            i = 1;
        } else {
            i = 0;
        }
        contentValues.put(str2, Integer.valueOf(i));
        str2 = Columns.f3808q.d;
        if (stickerPack.q) {
            i = 1;
        } else {
            i = 0;
        }
        contentValues.put(str2, Integer.valueOf(i));
        str2 = Columns.f3809r.d;
        if (stickerPack.r) {
            i = 1;
        } else {
            i = 0;
        }
        contentValues.put(str2, Integer.valueOf(i));
        String str3 = Columns.f3810s.d;
        StickerPackSerialization stickerPackSerialization = this.f3791h;
        List<String> list = stickerPack.s;
        if (list == null) {
            str = null;
        } else {
            ArrayNode arrayNode = new ArrayNode(JsonNodeFactory.a);
            for (String h : list) {
                arrayNode.h(h);
            }
            str = arrayNode.toString();
        }
        contentValues.put(str3, str);
        contentValues.put(Columns.f3811t.d, c);
        c = Columns.f3812u.d;
        if (stickerPack.u) {
            i = 1;
        } else {
            i = 0;
        }
        contentValues.put(c, Integer.valueOf(i));
        str3 = Columns.f3813v.d;
        if (!stickerPack.v) {
            i2 = 0;
        }
        contentValues.put(str3, Integer.valueOf(i2));
        return contentValues;
    }

    private static int m4246e(StickerPackType stickerPackType) {
        Integer num = (Integer) f3785c.get(stickerPackType);
        if (num != null) {
            return num.intValue();
        }
        throw new IllegalArgumentException("Unknown sticker pack type " + stickerPackType);
    }

    public final ImmutableList<Sticker> m4248a() {
        SQLiteDatabase a = this.f3790g.a();
        SQLiteDetour.a(a, -504685115);
        Cursor query = a.query("recent_stickers", null, null, null, null, null, null);
        ImmutableList<Sticker> of = ImmutableList.of();
        try {
            if (query.moveToFirst()) {
                of = this.f3791h.m4295b(query.getString(RecentStickersTable.Columns.f3841a.a(query)));
            }
            a.setTransactionSuccessful();
            return of;
        } finally {
            query.close();
            SQLiteDetour.b(a, -1149933243);
        }
    }

    public final void m4256a(List<Sticker> list) {
        String b = this.f3791h.m4296b((List) list);
        SQLiteDatabase a = this.f3790g.a();
        SQLiteDetour.a(a, 602274731);
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put(RecentStickersTable.Columns.f3841a.a(), b);
            if (a.update("recent_stickers", contentValues, null, new String[0]) == 0) {
                SQLiteDetour.a(-1563952017);
                a.insertOrThrow("recent_stickers", null, contentValues);
                SQLiteDetour.a(1534822020);
            }
            a.setTransactionSuccessful();
        } finally {
            SQLiteDetour.b(a, -681016729);
        }
    }

    public final ImmutableList<String> m4259b() {
        Builder builder = new Builder();
        SQLiteDatabase a = this.f3790g.a();
        SQLiteDetour.a(a, -345348889);
        Cursor query = a.query("closed_download_preview_sticker_packs", null, null, null, null, null, null);
        try {
            int columnIndex = query.getColumnIndex(ClosedDownloadPreviewStickerPacksTable.Columns.f3853a.a());
            while (query.moveToNext()) {
                builder.c(query.getString(columnIndex));
            }
            a.setTransactionSuccessful();
            return builder.b();
        } finally {
            query.close();
            SQLiteDetour.b(a, 810117392);
        }
    }

    public final void m4260b(StickerPack stickerPack) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(ClosedDownloadPreviewStickerPacksTable.Columns.f3853a.a(), stickerPack.a());
        SQLiteDatabase a = this.f3790g.a();
        SQLiteDetour.a(a, 1916136803);
        try {
            SQLiteDetour.a(-722596585);
            a.insertWithOnConflict("closed_download_preview_sticker_packs", null, contentValues, 4);
            SQLiteDetour.a(605879535);
            a.setTransactionSuccessful();
        } finally {
            SQLiteDetour.b(a, 1072533483);
        }
    }

    public final ImmutableList<Sticker> m4250a(Collection<String> collection) {
        Expression a = SqlExpression.a(StickersTable.Columns.f3814a.a(), collection);
        SQLiteDatabase a2 = this.f3790g.a();
        SQLiteDetour.a(a2, 1505290184);
        Cursor rawQuery = this.f3790g.a().rawQuery(f3788f + "WHERE s." + a.a(), a.b());
        Builder builder = ImmutableList.builder();
        try {
            int columnIndex = rawQuery.getColumnIndex("sticker_id");
            int columnIndex2 = rawQuery.getColumnIndex("sticker_pack_id");
            int columnIndex3 = rawQuery.getColumnIndex("static_uri");
            int columnIndex4 = rawQuery.getColumnIndex("animated_uri");
            int columnIndex5 = rawQuery.getColumnIndex("static_asset");
            int columnIndex6 = rawQuery.getColumnIndex("animated_asset");
            int columnIndex7 = rawQuery.getColumnIndex("preview_uri");
            int columnIndex8 = rawQuery.getColumnIndex("preview_asset");
            StickerBuilder newBuilder = StickerBuilder.newBuilder();
            while (rawQuery.moveToNext()) {
                String string = rawQuery.getString(columnIndex);
                String string2 = rawQuery.getString(columnIndex2);
                Uri parse = Uri.parse(rawQuery.getString(columnIndex3));
                Uri d = m4242d(rawQuery.getString(columnIndex4));
                newBuilder.a(string).b(string2).a(parse).c(d).e(m4242d(rawQuery.getString(columnIndex7)));
                string = rawQuery.getString(columnIndex5);
                string2 = rawQuery.getString(columnIndex6);
                String string3 = rawQuery.getString(columnIndex8);
                if (string != null) {
                    newBuilder.b(Uri.fromFile(new File(string)));
                }
                if (string2 != null) {
                    newBuilder.d(Uri.fromFile(new File(string2)));
                }
                if (string3 != null) {
                    newBuilder.f(Uri.fromFile(new File(string3)));
                }
                builder.c(newBuilder.a());
                newBuilder.b();
            }
            a2.setTransactionSuccessful();
            return builder.b();
        } finally {
            rawQuery.close();
            SQLiteDetour.b(a2, -1367386827);
        }
    }

    private static Uri m4242d(@Nullable String str) {
        try {
            return Uri.parse(str);
        } catch (Exception e) {
            return null;
        }
    }

    public final void m4262b(Collection<Sticker> collection) {
        SQLiteDatabase a = this.f3790g.a();
        SQLiteDetour.a(a, -1086388569);
        try {
            for (Sticker a2 : collection) {
                m4233a(a2);
            }
            a.setTransactionSuccessful();
        } finally {
            SQLiteDetour.b(a, -286294064);
        }
    }

    public final void m4267c(Collection<String> collection) {
        SQLiteDatabase a = this.f3790g.a();
        SQLiteDetour.a(a, -1579201186);
        try {
            Expression a2 = SqlExpression.a(StickersTable.Columns.f3814a.a(), collection);
            a.delete("stickers", a2.a(), a2.b());
            m4245d((Collection) collection);
            a.setTransactionSuccessful();
        } finally {
            SQLiteDetour.b(a, 437141234);
        }
    }

    private void m4233a(Sticker sticker) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(StickersTable.Columns.f3814a.a(), sticker.a);
        contentValues.put(StickersTable.Columns.f3815b.a(), sticker.b);
        contentValues.put(StickersTable.Columns.f3816c.a(), m4231a(sticker.c));
        contentValues.put(StickersTable.Columns.f3817d.a(), m4231a(sticker.e));
        contentValues.put(StickersTable.Columns.f3818e.a(), m4231a(sticker.g));
        SQLiteDatabase a = this.f3790g.a();
        SQLiteDetour.a(a, -1351028626);
        try {
            SQLiteDetour.a(1458439043);
            a.replaceOrThrow("stickers", null, contentValues);
            SQLiteDetour.a(-1208168229);
            a.setTransactionSuccessful();
        } finally {
            SQLiteDetour.b(a, -1867919245);
        }
    }

    private static String m4231a(Uri uri) {
        return uri != null ? uri.toString() : null;
    }

    private boolean m4235a(String str, StickerPackType stickerPackType) {
        ConjunctionExpression a = SqlExpression.a();
        a.a(SqlExpression.a(PackTypesTable.Columns.f3836a.a(), String.valueOf(m4246e(stickerPackType))));
        a.a(SqlExpression.a(PackTypesTable.Columns.f3837b.a(), str));
        SQLiteDatabase a2 = this.f3790g.a();
        SQLiteDetour.a(a2, 222876330);
        Cursor query = a2.query("pack_types", null, a.a(), a.b(), null, null, null);
        try {
            boolean z = query.getCount() > 0;
            a2.setTransactionSuccessful();
            return z;
        } finally {
            query.close();
            SQLiteDetour.b(a2, -32942305);
        }
    }

    public final ImmutableList<StickerTag> m4266c() {
        Builder builder = new Builder();
        SQLiteDatabase a = this.f3790g.a();
        SQLiteDetour.a(a, 704934162);
        Cursor query = a.query("sticker_tags", null, null, null, null, null, null);
        try {
            int columnIndex = query.getColumnIndex(StickerTagsTable.Columns.f3845a.a());
            int columnIndex2 = query.getColumnIndex(StickerTagsTable.Columns.f3846b.a());
            int columnIndex3 = query.getColumnIndex(StickerTagsTable.Columns.f3847c.a());
            int columnIndex4 = query.getColumnIndex(StickerTagsTable.Columns.f3848d.a());
            int columnIndex5 = query.getColumnIndex(StickerTagsTable.Columns.f3849e.a());
            int columnIndex6 = query.getColumnIndex(StickerTagsTable.Columns.f3850f.a());
            while (query.moveToNext()) {
                StickerTagBuilder newBuilder = StickerTag.newBuilder();
                newBuilder.b(query.getString(columnIndex));
                newBuilder.a(query.getString(columnIndex2));
                newBuilder.c(query.getString(columnIndex3));
                newBuilder.a(query.getInt(columnIndex4) > 0);
                newBuilder.a(query.getInt(columnIndex5));
                newBuilder.d(query.getString(columnIndex6));
                builder.c(newBuilder.a());
            }
            a.setTransactionSuccessful();
            return builder.b();
        } finally {
            query.close();
            SQLiteDetour.b(a, 134957668);
        }
    }

    public final void m4253a(ImmutableList<StickerTag> immutableList) {
        SQLiteDatabase a = this.f3790g.a();
        SQLiteDetour.a(a, 858656878);
        try {
            a.delete("sticker_tags", null, null);
            int size = immutableList.size();
            for (int i = 0; i < size; i++) {
                int i2;
                StickerTag stickerTag = (StickerTag) immutableList.get(i);
                ContentValues contentValues = new ContentValues();
                contentValues.put(StickerTagsTable.Columns.f3845a.a(), stickerTag.b());
                contentValues.put(StickerTagsTable.Columns.f3846b.a(), stickerTag.a());
                contentValues.put(StickerTagsTable.Columns.f3847c.a(), stickerTag.c());
                String a2 = StickerTagsTable.Columns.f3848d.a();
                if (stickerTag.d()) {
                    i2 = 1;
                } else {
                    i2 = 0;
                }
                contentValues.put(a2, Integer.valueOf(i2));
                contentValues.put(StickerTagsTable.Columns.f3849e.a(), Integer.valueOf(stickerTag.e()));
                contentValues.put(StickerTagsTable.Columns.f3850f.a(), stickerTag.f());
                SQLiteDetour.a(1145427554);
                a.insertOrThrow("sticker_tags", null, contentValues);
                SQLiteDetour.a(-1623278942);
            }
            a.setTransactionSuccessful();
        } finally {
            SQLiteDetour.b(a, 1859533927);
        }
    }

    public final void m4255a(String str, StickerAssetType stickerAssetType, File file) {
        SQLiteDatabase a = this.f3790g.a();
        SQLiteDetour.a(a, -1097725142);
        File file2 = null;
        SQLiteStatement compileStatement = a.compileStatement(f3787e);
        try {
            file2 = m4237b(str, stickerAssetType);
            if (file2 != null && Files.m11928b(file2, file)) {
                return;
            }
            if (file2 == null || !file2.getAbsolutePath().equals(file.getAbsolutePath())) {
                compileStatement.bindString(1, str);
                compileStatement.bindString(2, stickerAssetType.getDbName());
                compileStatement.bindString(3, str);
                compileStatement.bindString(4, file.getPath());
                String a2 = m4232a(file);
                if (a2 != null) {
                    compileStatement.bindString(5, a2);
                } else {
                    compileStatement.bindNull(5);
                }
                SQLiteDetour.a(-1304373199);
                compileStatement.executeInsert();
                SQLiteDetour.a(-1832578708);
                a.setTransactionSuccessful();
                compileStatement.close();
                SQLiteDetour.b(a, 868746866);
                if (file2 != null && !file2.delete()) {
                    BLog.a(f3783a, "cannot delete old asset file: %s", new Object[]{file2});
                    return;
                }
                return;
            }
            compileStatement.close();
            SQLiteDetour.b(a, -158516589);
        } catch (Throwable th) {
            BLog.a(f3783a, "failed saving file", th);
            Throwables.propagate(th);
        } finally {
            compileStatement.close();
            int i = 629174528;
            SQLiteDetour.b(a, 629174528);
        }
    }

    private File m4237b(String str, StickerAssetType stickerAssetType) {
        File file = null;
        ConjunctionExpression a = SqlExpression.a();
        a.a(SqlExpression.a(AssetsTable.Columns.f3819a.a(), str));
        a.a(SqlExpression.a(AssetsTable.Columns.f3820b.a(), stickerAssetType.getDbName()));
        SQLiteDatabase a2 = this.f3790g.a();
        SQLiteDetour.a(a2, -2133840770);
        Cursor query = a2.query("sticker_asserts", new String[]{AssetsTable.Columns.f3825g.a()}, a.a(), a.b(), null, null, null);
        try {
            String string;
            if (query.getCount() > 0) {
                query.moveToNext();
                string = query.getString(0);
            } else {
                string = null;
            }
            a2.setTransactionSuccessful();
            if (string != null) {
                file = new File(string);
            }
            query.close();
            SQLiteDetour.b(a2, -55542774);
            return file;
        } catch (Throwable e) {
            BLog.a(f3783a, "error deleting old asset file.", e);
            throw Throwables.propagate(e);
        } catch (Throwable th) {
            query.close();
            SQLiteDetour.b(a2, -967717865);
        }
    }

    private static String m4232a(File file) {
        String name = file.getName();
        if (name != null) {
            int lastIndexOf = name.lastIndexOf(".");
            if (lastIndexOf != -1) {
                name = name.substring(lastIndexOf + 1);
                if (StringUtil.a(new CharSequence[]{name})) {
                    return name;
                }
                return null;
            }
        }
        name = null;
        if (StringUtil.a(new CharSequence[]{name})) {
            return name;
        }
        return null;
    }

    public final void m4263b(List<StickerPack> list) {
        if (!list.isEmpty()) {
            Builder builder = ImmutableList.builder();
            for (StickerPack stickerPack : list) {
                builder.b(stickerPack.t);
            }
            m4245d(builder.b());
        }
    }

    private void m4245d(Collection<String> collection) {
        Expression a = SqlExpression.a(AssetsTable.Columns.f3819a.a(), collection);
        SQLiteDatabase a2 = this.f3790g.a();
        SQLiteDetour.a(a2, 624024444);
        try {
            a2.delete("sticker_asserts", a.a(), a.b());
            a2.setTransactionSuccessful();
            SQLiteDetour.b(a2, 1423556537);
        } catch (Throwable e) {
            BLog.a(f3783a, "error deleting old assets files.", e);
            throw Throwables.propagate(e);
        } catch (Throwable th) {
            SQLiteDetour.b(a2, -1797119802);
        }
    }

    public final void m4254a(String str, StickerAssetType stickerAssetType) {
        ConjunctionExpression a = SqlExpression.a();
        a.a(SqlExpression.a(AssetsTable.Columns.f3819a.a(), str));
        a.a(SqlExpression.a(AssetsTable.Columns.f3820b.a(), stickerAssetType.getDbName()));
        SQLiteDatabase a2 = this.f3790g.a();
        SQLiteDetour.a(a2, 833762871);
        try {
            a2.delete("sticker_asserts", a.a(), a.b());
            a2.setTransactionSuccessful();
            SQLiteDetour.b(a2, -92498310);
        } catch (Throwable e) {
            BLog.a(f3783a, "error deleting one asset file.", e);
            throw Throwables.propagate(e);
        } catch (Throwable th) {
            SQLiteDetour.b(a2, 1689871981);
        }
    }
}
