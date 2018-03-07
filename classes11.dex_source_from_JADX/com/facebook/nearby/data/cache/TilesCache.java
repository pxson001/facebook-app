package com.facebook.nearby.data.cache;

import android.graphics.RectF;
import com.facebook.cache.FactoryMethodAutoProvider;
import com.facebook.cache.TrackedLruCache;
import com.facebook.cache.TrackedLruCache.Factory;
import com.facebook.graphql.model.GraphQLGeoRectangle;
import com.facebook.inject.InjectorLike;
import com.facebook.nearby.model.MapTile;
import com.facebook.nearby.model.TilesCacheRecord;
import com.google.common.base.Objects;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import java.util.List;
import java.util.Set;
import javax.annotation.concurrent.ThreadSafe;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
@ThreadSafe
/* compiled from: user_altitude_accuracy */
public class TilesCache {
    private static volatile TilesCache f329c;
    private TrackedLruCache<TileKey, TilesCacheRecord> f330a;
    private String f331b;

    /* compiled from: user_altitude_accuracy */
    class TileKey {
        public final Set<String> f323a;
        public final Set<Long> f324b;
        public final String f325c;
        public final GraphQLGeoRectangle f326d;
        public final float f327e;
        public final float f328f;

        public TileKey(Set<String> set, Set<Long> set2, String str, GraphQLGeoRectangle graphQLGeoRectangle, float f, float f2) {
            this.f323a = set;
            this.f324b = ImmutableSet.copyOf(set2);
            this.f325c = str;
            this.f326d = graphQLGeoRectangle;
            this.f327e = f2;
            this.f328f = f;
        }

        public int hashCode() {
            return Objects.hashCode(new Object[]{this.f323a, this.f324b, this.f325c, this.f326d, Float.valueOf(this.f328f), Float.valueOf(this.f327e)});
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof TileKey)) {
                return false;
            }
            TileKey tileKey = (TileKey) obj;
            if (Objects.equal(this.f323a, tileKey.f323a) && Objects.equal(this.f324b, tileKey.f324b) && Objects.equal(this.f325c, tileKey.f325c) && Objects.equal(this.f326d, tileKey.f326d) && Objects.equal(Float.valueOf(this.f328f), Float.valueOf(tileKey.f328f)) && Objects.equal(Float.valueOf(this.f327e), Float.valueOf(tileKey.f327e))) {
                return true;
            }
            return false;
        }
    }

    public static com.facebook.nearby.data.cache.TilesCache m417a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f329c;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.nearby.data.cache.TilesCache.class;
        monitor-enter(r1);
        r0 = f329c;	 Catch:{ all -> 0x003a }
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
        r0 = m419b(r0);	 Catch:{ all -> 0x0035 }
        f329c = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f329c;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.nearby.data.cache.TilesCache.a(com.facebook.inject.InjectorLike):com.facebook.nearby.data.cache.TilesCache");
    }

    private static TilesCache m419b(InjectorLike injectorLike) {
        return new TilesCache(FactoryMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public TilesCache(Factory factory) {
        this(factory, 100);
    }

    private TilesCache(Factory factory, int i) {
        this.f330a = factory.b(i, "tilesCache");
    }

    public final synchronized void m422a(Set<String> set, Set<Long> set2, List<MapTile> list, String str, long j) {
        if (!str.equals(this.f331b)) {
            m420c();
            this.f331b = str;
        }
        for (MapTile mapTile : list) {
            this.f330a.a(new TileKey(set, set2, mapTile.id, mapTile.bounds, mapTile.minZoom, mapTile.maxZoom), new TilesCacheRecord(mapTile, j, set, set2));
        }
    }

    public final synchronized List<MapTile> m421a(double d, Set<String> set, Set<Long> set2, RectF rectF) {
        List<MapTile> a;
        a = Lists.a();
        for (TileKey tileKey : this.f330a.c().keySet()) {
            if (tileKey.f324b.equals(set2) && tileKey.f323a.equals(set)) {
                RectF rectF2 = new RectF((float) tileKey.f326d.l(), (float) tileKey.f326d.j(), (float) tileKey.f326d.a(), (float) tileKey.f326d.k());
                if (((double) tileKey.f328f) < d && ((double) tileKey.f327e) > d && m418a(rectF, rectF2)) {
                    a.add(((TilesCacheRecord) this.f330a.a(tileKey)).m514a());
                }
            }
        }
        return a;
    }

    public final synchronized boolean m423a() {
        return this.f330a.b() == 0;
    }

    private synchronized void m420c() {
        this.f330a.a();
    }

    public final String m424b() {
        return this.f331b;
    }

    private static boolean m418a(RectF rectF, RectF rectF2) {
        return rectF.left <= rectF2.right && rectF.right >= rectF2.left && rectF.bottom <= rectF2.top && rectF.top >= rectF2.bottom;
    }
}
