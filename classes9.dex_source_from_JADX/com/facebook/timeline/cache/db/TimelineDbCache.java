package com.facebook.timeline.cache.db;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteFullException;
import com.facebook.androidcompat.AndroidCompat;
import com.facebook.cache.DiskCacheManager;
import com.facebook.common.disk.DiskTrimmable;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.common.userinteraction.DefaultUserInteractionController;
import com.facebook.common.userinteraction.UserInteractionController;
import com.facebook.debug.log.BLog;
import com.facebook.fbservice.results.DataFreshnessResult;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.Flattenable;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.executor.cache.GraphQLRequestDiskCache;
import com.facebook.graphql.executor.cachekey.KeyFactory;
import com.facebook.graphql.executor.filemap.DefaultFlatBufferCorruptionHandler;
import com.facebook.graphql.executor.filemap.DefaultFlatBufferCorruptionHandlerProvider;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.timeline.abtest.ExperimentsForTimelineAbTestModule;
import com.facebook.timeline.prefs.TimelinePreferencesKeys;
import com.facebook.tools.dextr.runtime.detour.SQLiteDetour;
import com.google.common.annotations.VisibleForTesting;
import java.nio.ByteBuffer;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
/* compiled from: url2 */
public class TimelineDbCache implements DiskTrimmable, GraphQLRequestDiskCache {
    private static volatile TimelineDbCache f810j;
    @VisibleForTesting
    protected final TimelineDatabaseSupplier f811a;
    private final Clock f812b;
    private final DefaultFlatBufferCorruptionHandlerProvider f813c;
    private final Lazy<KeyFactory> f814d;
    private final DefaultUserInteractionController f815e;
    private final Lazy<FbErrorReporter> f816f;
    private final QeAccessor f817g;
    private final Provider<TimelineDeletedRowsAnalyticsLogger> f818h;
    @Nullable
    private DefaultFlatBufferCorruptionHandler f819i;

    public static com.facebook.timeline.cache.db.TimelineDbCache m851a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f810j;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.timeline.cache.db.TimelineDbCache.class;
        monitor-enter(r1);
        r0 = f810j;	 Catch:{ all -> 0x003a }
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
        r0 = m854b(r0);	 Catch:{ all -> 0x0035 }
        f810j = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f810j;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.timeline.cache.db.TimelineDbCache.a(com.facebook.inject.InjectorLike):com.facebook.timeline.cache.db.TimelineDbCache");
    }

    private static TimelineDbCache m854b(InjectorLike injectorLike) {
        return new TimelineDbCache(TimelineDatabaseSupplier.m845a(injectorLike), (Clock) SystemClockMethodAutoProvider.a(injectorLike), (DefaultFlatBufferCorruptionHandlerProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(DefaultFlatBufferCorruptionHandlerProvider.class), IdBasedLazy.a(injectorLike, 2186), DefaultUserInteractionController.a(injectorLike), IdBasedSingletonScopeProvider.b(injectorLike, 494), DiskCacheManager.a(injectorLike), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike), IdBasedSingletonScopeProvider.a(injectorLike, 11159));
    }

    @Inject
    public TimelineDbCache(TimelineDatabaseSupplier timelineDatabaseSupplier, Clock clock, DefaultFlatBufferCorruptionHandlerProvider defaultFlatBufferCorruptionHandlerProvider, Lazy<KeyFactory> lazy, UserInteractionController userInteractionController, Lazy<FbErrorReporter> lazy2, DiskCacheManager diskCacheManager, QeAccessor qeAccessor, Provider<TimelineDeletedRowsAnalyticsLogger> provider) {
        this.f811a = timelineDatabaseSupplier;
        this.f812b = clock;
        this.f813c = defaultFlatBufferCorruptionHandlerProvider;
        this.f814d = lazy;
        this.f815e = userInteractionController;
        this.f816f = lazy2;
        this.f818h = provider;
        diskCacheManager.a(this);
        this.f817g = qeAccessor;
    }

    public final boolean m863d(GraphQLRequest graphQLRequest) {
        Throwable th;
        Throwable th2;
        boolean z = true;
        Cursor a = m849a(this.f811a.a(), graphQLRequest, new String[]{TimelineContract$CacheTable$Columns.f805b.a()});
        try {
            if (a.moveToFirst()) {
                if (this.f812b.a() - a.getLong(TimelineContract$CacheTable$Columns.f805b.a(a)) >= graphQLRequest.d) {
                    z = false;
                }
                if (a == null) {
                    return z;
                }
                a.close();
                return z;
            }
            if (a != null) {
                a.close();
            }
            return false;
        } catch (Throwable th22) {
            Throwable th3 = th22;
            th22 = th;
            th = th3;
        }
        throw th;
        if (a != null) {
            if (th22 != null) {
                try {
                    a.close();
                } catch (Throwable th4) {
                    AndroidCompat.addSuppressed(th22, th4);
                }
            } else {
                a.close();
            }
        }
        throw th;
    }

    @Nullable
    public final <T> GraphQLResult<T> m860b(GraphQLRequest<T> graphQLRequest) {
        Throwable th;
        Throwable th2;
        try {
            Cursor a = m849a(this.f811a.a(), graphQLRequest, new String[]{TimelineContract$CacheTable$Columns.f805b.a(), TimelineContract$CacheTable$Columns.f806c.a()});
            try {
                if (a.getCount() <= 0) {
                    if (a != null) {
                        a.close();
                    }
                    return null;
                }
                Object a2;
                long j;
                int a3 = TimelineContract$CacheTable$Columns.f806c.a(a);
                int a4 = TimelineContract$CacheTable$Columns.f805b.a(a);
                if (a.moveToNext()) {
                    byte[] blob = a.getBlob(a3);
                    long j2 = a.getLong(a4);
                    a2 = m850a(blob, graphQLRequest.n());
                    j = j2;
                } else {
                    j = 0;
                    a2 = null;
                }
                if (a.moveToNext()) {
                    BLog.b("TimelineDbCache", "Multiple rows in timeline db with same primary key!");
                }
                if (a != null) {
                    a.close();
                }
                if (a2 == null) {
                    return null;
                }
                return new GraphQLResult(a2, Long.valueOf(this.f812b.a() - j).longValue() < graphQLRequest.d ? DataFreshnessResult.FROM_CACHE_UP_TO_DATE : DataFreshnessResult.FROM_CACHE_STALE, j);
            } catch (Throwable th3) {
                Throwable th4 = th3;
                th3 = th2;
                th2 = th4;
            }
            throw th2;
            if (a != null) {
                if (th3 != null) {
                    try {
                        a.close();
                    } catch (Throwable th5) {
                        AndroidCompat.addSuppressed(th3, th5);
                    }
                } else {
                    a.close();
                }
            }
            throw th2;
        } catch (Throwable th22) {
            th3 = th22;
            ((AbstractFbErrorReporter) this.f816f.get()).a("TimelineDbCache", "fetchFromDb failed", th3);
            return null;
        } catch (Throwable th222) {
            th3 = th222;
            ((AbstractFbErrorReporter) this.f816f.get()).a("TimelineDbCache", "fetchFromDb failed", th3);
            return null;
        }
    }

    private Cursor m849a(SQLiteDatabase sQLiteDatabase, GraphQLRequest<?> graphQLRequest, String[] strArr) {
        String str = TimelineContract$CacheTable$Columns.f804a.d + "= ?";
        return sQLiteDatabase.query("cache", strArr, str, new String[]{graphQLRequest.a((KeyFactory) this.f814d.get())}, null, null, null, null);
    }

    private Flattenable m850a(byte[] bArr, Class cls) {
        return MutableFlatBuffer.a(ByteBuffer.wrap(bArr), cls, m855c());
    }

    @VisibleForTesting
    private boolean m853a(GraphQLRequest<?> graphQLRequest, Flattenable flattenable) {
        Throwable th = null;
        boolean z = false;
        this.f815e.c();
        ContentValues contentValues = new ContentValues();
        contentValues.put(TimelineContract$CacheTable$Columns.f804a.a(), graphQLRequest.a((KeyFactory) this.f814d.get()));
        contentValues.put(TimelineContract$CacheTable$Columns.f805b.a(), Long.valueOf(this.f812b.a()));
        contentValues.put(TimelineContract$CacheTable$Columns.f806c.a(), FlatBufferBuilder.b(flattenable));
        if (this.f817g.a(ExperimentsForTimelineAbTestModule.ba, false) && graphQLRequest.e.contains("self_profile")) {
            contentValues.put(TimelineContract$CacheTable$Columns.f807d.a(), Integer.valueOf(1));
        } else {
            contentValues.put(TimelineContract$CacheTable$Columns.f807d.a(), Integer.valueOf(0));
        }
        StringBuilder stringBuilder = new StringBuilder();
        SQLiteDatabase a = this.f811a.a();
        int i = 0;
        while (i < 3) {
            try {
                SQLiteDetour.a(-1892896111);
                a.replaceOrThrow("cache", null, contentValues);
                SQLiteDetour.a(2040732718);
                z = true;
                if (i > 1) {
                    ((AbstractFbErrorReporter) this.f816f.get()).a("TimelineDbCache", stringBuilder.toString(), th);
                }
                return z;
            } catch (Throwable e) {
                try {
                    Thread.sleep(30);
                } catch (InterruptedException e2) {
                }
                stringBuilder.append(" saveToDb attempt #").append(i).append(" failed: ").append(e.toString()).append(" ").append(e.getMessage());
                switch (i) {
                    case 0:
                        if (!(e instanceof SQLiteFullException) || m857e() != 0) {
                            try {
                                stringBuilder.append(m852a(0.6d));
                                break;
                            } catch (SQLiteException e3) {
                                stringBuilder.append(" Failed to purge table: ").append(e3.getMessage());
                                break;
                            }
                        }
                        return false;
                    case 1:
                        try {
                            stringBuilder.append(" Successfully deleted table with ").append(a.delete("cache", "1", null)).append(" rows. ");
                            break;
                        } catch (SQLiteException e32) {
                            stringBuilder.append(" Failed to delete table: ").append(e32.getMessage());
                            break;
                        }
                    default:
                        break;
                }
                i++;
                th = e;
            }
        }
        if (i > 1) {
            ((AbstractFbErrorReporter) this.f816f.get()).a("TimelineDbCache", stringBuilder.toString(), th);
        }
        return z;
    }

    public final <T> void m862b(GraphQLRequest<T> graphQLRequest, GraphQLResult<T> graphQLResult) {
        m853a((GraphQLRequest) graphQLRequest, (Flattenable) graphQLResult.e);
    }

    private synchronized DefaultFlatBufferCorruptionHandler m855c() {
        if (this.f819i == null) {
            this.f819i = this.f813c.a(TimelinePreferencesKeys.d);
        }
        return this.f819i;
    }

    @VisibleForTesting
    private String m852a(double d) {
        int g = m859g();
        double f = m858f();
        String str = "No deletion occurred";
        int i = 0;
        SQLiteDatabase a = this.f811a.a();
        double d2 = f;
        int i2 = g;
        while (d2 >= 0.01d + d && i2 > 0 && i < 2 && d2 > 0.0d) {
            String str2;
            int i3 = i + 1;
            i = i2 - ((int) Math.floor((((double) i2) * d) / d2));
            if (i == i2) {
                str = m856d();
                ((TimelineDeletedRowsAnalyticsLogger) this.f818h.get()).m874a(a);
                str2 = str;
            } else {
                i--;
                if (i < 0) {
                    i2 = 0;
                } else {
                    i2 = i;
                }
                str = StringFormatUtil.a("DELETE FROM cache WHERE " + TimelineContract$CacheTable$Columns.f805b.a() + " <= ( SELECT " + TimelineContract$CacheTable$Columns.f805b.a() + " FROM cache" + " ORDER BY " + TimelineContract$CacheTable$Columns.f805b.a() + " ASC LIMIT 1 OFFSET " + i2 + ") AND " + TimelineContract$CacheTable$Columns.f807d.a() + " != 1", new Object[0]);
                ((TimelineDeletedRowsAnalyticsLogger) this.f818h.get()).m875a(a, i2);
                str2 = str;
            }
            SQLiteDetour.a(1078988631);
            a.execSQL(str2);
            SQLiteDetour.a(1335021106);
            int g2 = m859g();
            d2 = m858f();
            i2 = g2;
            str = str2;
            i = i3;
        }
        if (i > 0 && a != null) {
            SQLiteDetour.a(-1318615451);
            a.execSQL("VACUUM");
            SQLiteDetour.a(1606522692);
        }
        return StringFormatUtil.a("TimelineDbCache.purge() initial state: numRows=%d dbPercentage=%f   Final state: numRows=%d dbPercentage=%f   Final deletion command: [%s]  ", new Object[]{Integer.valueOf(g), Double.valueOf(f), Integer.valueOf(i2), Double.valueOf(d2), str});
    }

    private static String m856d() {
        return StringFormatUtil.a("DELETE FROM cache", new Object[0]);
    }

    public final void ai_() {
        if (m858f() > 0.2d) {
            m852a(0.1d);
        }
    }

    public final void m861b() {
        SQLiteDatabase a = this.f811a.a();
        ((TimelineDeletedRowsAnalyticsLogger) this.f818h.get()).m874a(a);
        String d = m856d();
        SQLiteDetour.a(1483471552);
        a.execSQL(d);
        SQLiteDetour.a(884834603);
        SQLiteDetour.a(282793533);
        a.execSQL("VACUUM");
        SQLiteDetour.a(-805305313);
    }

    private long m857e() {
        try {
            return this.f811a.d();
        } catch (Exception e) {
            return this.f811a.m847b();
        }
    }

    private double m858f() {
        return ((double) m857e()) / ((double) this.f811a.m847b());
    }

    @VisibleForTesting
    private int m859g() {
        Cursor cursor = null;
        int i = -1;
        try {
            cursor = this.f811a.a().rawQuery("SELECT Count(*) FROM cache", null);
            cursor.moveToFirst();
            i = cursor.getInt(0);
            if (cursor != null) {
                cursor.close();
            }
        } catch (Exception e) {
            if (cursor != null) {
                cursor.close();
            }
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
        }
        return i;
    }
}
