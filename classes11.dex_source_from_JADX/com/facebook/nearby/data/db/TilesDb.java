package com.facebook.nearby.data.db;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.facebook.cache.DiskCacheManager;
import com.facebook.common.disk.DiskTrimmable;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.debug.log.BLog;
import com.facebook.inject.InjectorLike;
import com.facebook.nearby.data.NearbyTilesSerialization;
import com.facebook.nearby.data.db.NearbyTilesDbSchemaPart.NearbyTilesTable.Columns;
import com.facebook.nearby.data.db.NearbyTilesDbSchemaPart.TileVersionTable;
import com.facebook.nearby.model.MapTile;
import com.facebook.nearby.model.TilesCacheRecord;
import com.facebook.nearby.protocol.NearbyTilesWithLayoutsResult;
import com.facebook.tools.dextr.runtime.detour.SQLiteDetour;
import com.google.common.collect.Lists;
import java.io.IOException;
import java.util.List;
import java.util.Set;
import javax.annotation.concurrent.ThreadSafe;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
@ThreadSafe
/* compiled from: use_react_native */
public class TilesDb implements DiskTrimmable {
    private static final Class<?> f352a = TilesDb.class;
    private static final String[] f353b = new String[]{Columns.f335a.d, Columns.f342h.d, Columns.f344j.d, Columns.f336b.d, Columns.f337c.d};
    private static volatile TilesDb f354i;
    private final int f355c = 100;
    private final int f356d = 10;
    private final Clock f357e;
    public final NearbyTilesDatabaseSupplier f358f;
    private final NearbyTilesSerialization f359g;
    private String f360h;

    public static com.facebook.nearby.data.db.TilesDb m430a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r0 = f354i;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.nearby.data.db.TilesDb.class;
        monitor-enter(r1);
        r0 = f354i;	 Catch:{ all -> 0x003a }
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
        r0 = m431b(r0);	 Catch:{ all -> 0x0035 }
        f354i = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f354i;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.nearby.data.db.TilesDb.a(com.facebook.inject.InjectorLike):com.facebook.nearby.data.db.TilesDb");
    }

    private static TilesDb m431b(InjectorLike injectorLike) {
        return new TilesDb((Clock) SystemClockMethodAutoProvider.a(injectorLike), NearbyTilesDatabaseSupplier.m425a(injectorLike), NearbyTilesSerialization.m399a(injectorLike), DiskCacheManager.a(injectorLike));
    }

    @Inject
    public TilesDb(Clock clock, NearbyTilesDatabaseSupplier nearbyTilesDatabaseSupplier, NearbyTilesSerialization nearbyTilesSerialization, DiskCacheManager diskCacheManager) {
        this.f357e = clock;
        this.f358f = nearbyTilesDatabaseSupplier;
        this.f359g = nearbyTilesSerialization;
        diskCacheManager.a(this);
    }

    public final void m436a(NearbyTilesWithLayoutsResult nearbyTilesWithLayoutsResult) {
        String str = nearbyTilesWithLayoutsResult.f646c;
        m434e();
        if (this.f360h == null || !str.equals(this.f360h)) {
            this.f360h = str;
            this.f358f.e();
            m433d();
        }
        SQLiteDatabase a = this.f358f.a();
        long a2 = this.f357e.a();
        for (MapTile mapTile : nearbyTilesWithLayoutsResult.f645b) {
            NearbyTilesSerialization nearbyTilesSerialization = this.f359g;
            String c = NearbyTilesSerialization.m401c((Set) nearbyTilesWithLayoutsResult.f647d);
            NearbyTilesSerialization nearbyTilesSerialization2 = this.f359g;
            String c2 = NearbyTilesSerialization.m401c((Set) nearbyTilesWithLayoutsResult.f648e);
            ContentValues contentValues = new ContentValues();
            contentValues.put(Columns.f335a.d, mapTile.id);
            contentValues.put(Columns.f336b.d, c);
            contentValues.put(Columns.f337c.d, c2);
            contentValues.put(Columns.f338d.d, Double.valueOf(mapTile.bounds.j()));
            contentValues.put(Columns.f339e.d, Double.valueOf(mapTile.bounds.k()));
            contentValues.put(Columns.f340f.d, Double.valueOf(mapTile.bounds.a()));
            contentValues.put(Columns.f341g.d, Double.valueOf(mapTile.bounds.l()));
            contentValues.put(Columns.f343i.d, Long.valueOf(mapTile.m483a()));
            contentValues.put(Columns.f344j.d, Long.valueOf(a2));
            contentValues.put(Columns.f342h.d, this.f359g.f316a.a(mapTile));
            if (a.update("nearby_tiles", contentValues, Columns.f335a.d + " = ? AND " + Columns.f336b.d + " = ? AND " + Columns.f337c.d + " = ? ", new String[]{mapTile.id, c, c2}) == 0) {
                SQLiteDetour.a(1745234236);
                a.insertOrThrow("nearby_tiles", null, contentValues);
                SQLiteDetour.a(-508142509);
            }
        }
    }

    public final synchronized NearbyDbTilesResult m438c() {
        List a;
        m434e();
        m435f();
        m432b(100);
        a = Lists.a();
        Cursor query = this.f358f.a().query("nearby_tiles", f353b, null, null, null, null, null);
        try {
            int a2 = Columns.f342h.a(query);
            int a3 = Columns.f336b.a(query);
            int a4 = Columns.f337c.a(query);
            int a5 = Columns.f344j.a(query);
            while (query.moveToNext()) {
                try {
                    String string = query.getString(a2);
                    String string2 = query.getString(a3);
                    String string3 = query.getString(a4);
                    a.add(new TilesCacheRecord(this.f359g.m402a(string), query.getLong(a5), this.f359g.m403b(string2), this.f359g.m404c(string3)));
                } catch (IOException e) {
                    BLog.b(f352a, "There is corrupt tiles JSON data");
                }
            }
        } catch (Throwable e2) {
            BLog.b(f352a, "Nearby Tiles database corrupted", e2);
        } finally {
            query.close();
        }
        return new NearbyDbTilesResult(this.f360h, a);
    }

    private void m433d() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(TileVersionTable.Columns.f348a.d, this.f360h);
        SQLiteDetour.a(-1923209148);
        this.f358f.a().insertOrThrow("nearby_tiles_version", null, contentValues);
        SQLiteDetour.a(911487842);
    }

    private void m434e() {
        if (this.f360h == null) {
            Cursor query = this.f358f.a().query("nearby_tiles_version", new String[]{TileVersionTable.Columns.f348a.a()}, null, null, null, null, null);
            try {
                if (query.moveToNext()) {
                    this.f360h = query.getString(TileVersionTable.Columns.f348a.a(query));
                }
                query.close();
            } catch (Throwable th) {
                query.close();
            }
        }
    }

    private void m435f() {
        this.f358f.a().delete("nearby_tiles", Columns.f343i.d + " + " + Columns.f344j.d + " < " + this.f357e.a(), null);
    }

    private void m432b(int i) {
        m435f();
        SQLiteDatabase a = this.f358f.a();
        String str = "DELETE FROM nearby_tiles WHERE " + Columns.f335a.d + " NOT IN (SELECT " + Columns.f335a.d + " FROM nearby_tiles" + " ORDER BY " + Columns.f344j.d + " DESC LIMIT " + i + ")";
        SQLiteDetour.a(905050680);
        a.execSQL(str);
        SQLiteDetour.a(-129956323);
    }

    public final void ai_() {
        m432b(10);
    }

    public final void m437b() {
        m432b(1);
    }
}
