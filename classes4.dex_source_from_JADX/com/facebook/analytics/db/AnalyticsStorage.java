package com.facebook.analytics.db;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.facebook.auth.event.AuthEvent;
import com.facebook.auth.event.AuthEventBus;
import com.facebook.auth.event.AuthEventSubscriber;
import com.facebook.auth.event.AuthLoggedOutEvent;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.executors.ScheduledExecutorService_BackgroundExecutorServiceMethodAutoProvider;
import com.facebook.common.identifiers.SafeUUIDGenerator;
import com.facebook.config.versioninfo.AppVersionInfo;
import com.facebook.config.versioninfo.module.AppVersionInfoMethodAutoProvider;
import com.facebook.content.event.FbEvent;
import com.facebook.inject.InjectorLike;
import com.facebook.tools.dextr.runtime.detour.SQLiteDetour;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: thread_image */
public class AnalyticsStorage {
    private static final String[] f1163a = new String[]{"_id", "data", "timestamp", "app_version_name", "app_version_code"};
    private static final String[] f1164b = new String[]{"_id"};
    private static final String[] f1165c = new String[]{"session_id"};
    private static volatile AnalyticsStorage f1166k;
    public final AnalyticsDatabaseSupplier f1167d;
    private final AnalyticsSessionManager f1168e;
    private final AppVersionInfo f1169f;
    public final ScheduledExecutorService f1170g;
    private final AuthEventSubscriber<AuthLoggedOutEvent> f1171h = new C00711(this);
    private final AuthEventBus f1172i;
    private final AbstractFbErrorReporter f1173j;

    /* compiled from: thread_image */
    class C00711 extends AuthEventSubscriber<AuthLoggedOutEvent> {
        final /* synthetic */ AnalyticsStorage f1186a;

        C00711(AnalyticsStorage analyticsStorage) {
            this.f1186a = analyticsStorage;
        }

        public final /* synthetic */ void mo58a(AuthEvent authEvent) {
            m1446b();
        }

        public final /* bridge */ /* synthetic */ void mo59b(FbEvent fbEvent) {
            m1446b();
        }

        private void m1446b() {
            this.f1186a.f1170g.schedule(new 1(this, "AnalyticsStorage", "clearUserData"), 10000, TimeUnit.MILLISECONDS);
        }

        public final Class<AuthLoggedOutEvent> m1447a() {
            return AuthLoggedOutEvent.class;
        }
    }

    public static com.facebook.analytics.db.AnalyticsStorage m1421a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f1166k;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.analytics.db.AnalyticsStorage.class;
        monitor-enter(r1);
        r0 = f1166k;	 Catch:{ all -> 0x003a }
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
        r0 = m1422b(r0);	 Catch:{ all -> 0x0035 }
        f1166k = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f1166k;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.analytics.db.AnalyticsStorage.a(com.facebook.inject.InjectorLike):com.facebook.analytics.db.AnalyticsStorage");
    }

    private static AnalyticsStorage m1422b(InjectorLike injectorLike) {
        return new AnalyticsStorage(AnalyticsDatabaseSupplier.m1291a(injectorLike), AnalyticsSessionManager.m1434a(injectorLike), AppVersionInfoMethodAutoProvider.a(injectorLike), AuthEventBus.a(injectorLike), ScheduledExecutorService_BackgroundExecutorServiceMethodAutoProvider.a(injectorLike), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike));
    }

    private static int m1423c() {
        return 50;
    }

    @Inject
    public AnalyticsStorage(AnalyticsDatabaseSupplier analyticsDatabaseSupplier, AnalyticsSessionManager analyticsSessionManager, AppVersionInfo appVersionInfo, AuthEventBus authEventBus, ScheduledExecutorService scheduledExecutorService, AbstractFbErrorReporter abstractFbErrorReporter) {
        this.f1167d = analyticsDatabaseSupplier;
        this.f1168e = analyticsSessionManager;
        this.f1169f = appVersionInfo;
        this.f1172i = authEventBus;
        this.f1170g = scheduledExecutorService;
        this.f1173j = abstractFbErrorReporter;
        this.f1172i.a(this.f1171h);
    }

    public final void m1430a(java.util.List<? extends com.facebook.analytics.AnalyticsEvent> r9) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:37)
	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:61)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:33)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r8 = this;
        r0 = r8.f1167d;
        r1 = r0.a();
        r0 = "INSERT INTO events (session_id, app_version_name, app_version_code, flush_tag, data, timestamp) VALUES (?, ?, ?, ?, ?, ?) ";
        r2 = r1.compileStatement(r0);
        r0 = 1759053060; // 0x68d90504 float:8.1987684E24 double:8.69087686E-315;
        com.facebook.tools.dextr.runtime.detour.SQLiteDetour.a(r1, r0);
        r3 = r9.iterator();	 Catch:{ Exception -> 0x006e }
    L_0x0016:
        r0 = r3.hasNext();	 Catch:{ Exception -> 0x006e }
        if (r0 == 0) goto L_0x0080;	 Catch:{ Exception -> 0x006e }
    L_0x001c:
        r0 = r3.next();	 Catch:{ Exception -> 0x006e }
        r0 = (com.facebook.analytics.HoneyAnalyticsEvent) r0;	 Catch:{ Exception -> 0x006e }
        r2.clearBindings();	 Catch:{ Exception -> 0x006e }
        r4 = 1;	 Catch:{ Exception -> 0x006e }
        r5 = r0.c();	 Catch:{ Exception -> 0x006e }
        r2.bindString(r4, r5);	 Catch:{ Exception -> 0x006e }
        r4 = 2;	 Catch:{ Exception -> 0x006e }
        r5 = r8.f1169f;	 Catch:{ Exception -> 0x006e }
        r5 = r5.a();	 Catch:{ Exception -> 0x006e }
        r2.bindString(r4, r5);	 Catch:{ Exception -> 0x006e }
        r4 = 3;	 Catch:{ Exception -> 0x006e }
        r5 = r8.f1169f;	 Catch:{ Exception -> 0x006e }
        r5 = r5.b();	 Catch:{ Exception -> 0x006e }
        r6 = (long) r5;	 Catch:{ Exception -> 0x006e }
        r2.bindLong(r4, r6);	 Catch:{ Exception -> 0x006e }
        r4 = "flush_tag";	 Catch:{ Exception -> 0x006e }
        r4 = r0.c(r4);	 Catch:{ Exception -> 0x006e }
        if (r4 == 0) goto L_0x004e;	 Catch:{ Exception -> 0x006e }
    L_0x004a:
        r5 = 4;	 Catch:{ Exception -> 0x006e }
        r2.bindString(r5, r4);	 Catch:{ Exception -> 0x006e }
    L_0x004e:
        r4 = r0.e();	 Catch:{ Exception -> 0x006e }
        r5 = 5;	 Catch:{ Exception -> 0x006e }
        r2.bindString(r5, r4);	 Catch:{ Exception -> 0x006e }
        r4 = 6;	 Catch:{ Exception -> 0x006e }
        r6 = r0.a();	 Catch:{ Exception -> 0x006e }
        r2.bindLong(r4, r6);	 Catch:{ Exception -> 0x006e }
        r0 = 2119378016; // 0x7e532460 float:7.0163994E37 double:1.0471118683E-314;	 Catch:{ Exception -> 0x006e }
        com.facebook.tools.dextr.runtime.detour.SQLiteDetour.a(r0);	 Catch:{ Exception -> 0x006e }
        r2.executeInsert();	 Catch:{ Exception -> 0x006e }
        r0 = 1914054997; // 0x72162955 float:2.974254E30 double:9.456688183E-315;	 Catch:{ Exception -> 0x006e }
        com.facebook.tools.dextr.runtime.detour.SQLiteDetour.a(r0);	 Catch:{ Exception -> 0x006e }
        goto L_0x0016;
    L_0x006e:
        r0 = move-exception;
        r3 = "AnalyticsStorage";	 Catch:{ all -> 0x0096 }
        r4 = "Failed to write to analytics db.";	 Catch:{ all -> 0x0096 }
        com.facebook.debug.log.BLog.b(r3, r4, r0);	 Catch:{ all -> 0x0096 }
        r0 = -1354566557; // 0xffffffffaf42f463 float:-1.7731021E-10 double:NaN;
        com.facebook.tools.dextr.runtime.detour.SQLiteDetour.b(r1, r0);	 Catch:{ SQLiteFullException -> 0x00a3 }
        r2.close();	 Catch:{ SQLiteFullException -> 0x00a3 }
    L_0x007f:
        return;
    L_0x0080:
        r1.setTransactionSuccessful();	 Catch:{  }
        r0 = r9.size();	 Catch:{  }
        java.lang.Integer.valueOf(r0);	 Catch:{  }
        r0 = 1431280160; // 0x554f9a20 float:1.42663043E13 double:7.071463566E-315;
        com.facebook.tools.dextr.runtime.detour.SQLiteDetour.b(r1, r0);	 Catch:{ SQLiteFullException -> 0x0094 }
        r2.close();	 Catch:{ SQLiteFullException -> 0x0094 }
        goto L_0x007f;
    L_0x0094:
        r0 = move-exception;
        goto L_0x007f;
    L_0x0096:
        r0 = move-exception;
        r3 = -996962741; // 0xffffffffc4938e4b float:-1180.4467 double:NaN;
        com.facebook.tools.dextr.runtime.detour.SQLiteDetour.b(r1, r3);	 Catch:{ SQLiteFullException -> 0x00a1 }
        r2.close();	 Catch:{ SQLiteFullException -> 0x00a1 }
    L_0x00a0:
        throw r0;
    L_0x00a1:
        r1 = move-exception;
        goto L_0x00a0;
    L_0x00a3:
        r0 = move-exception;
        goto L_0x007f;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.analytics.db.AnalyticsStorage.a(java.util.List):void");
    }

    public final int m1425a() {
        Cursor query = this.f1167d.a().query("events", f1164b, null, null, null, null, null);
        try {
            int count = query.getCount();
            return count;
        } finally {
            query.close();
        }
    }

    public final int m1426a(long j) {
        long j2 = j - 604800000;
        return this.f1167d.a().delete("events", "timestamp<?", new String[]{Long.toString(j2)});
    }

    public final int m1431b(long j) {
        return this.f1167d.a().delete("events", "_id <= ?", new String[]{String.valueOf(j)});
    }

    public final int m1427a(ImmutableList<Long> immutableList) {
        SQLiteDatabase a = this.f1167d.a();
        SQLiteDetour.a(a, -1845207696);
        int size = immutableList.size();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            long longValue = ((Long) immutableList.get(i2)).longValue();
            i += a.delete("events", "_id = ?", new String[]{String.valueOf(longValue)});
        }
        a.setTransactionSuccessful();
        SQLiteDetour.b(a, 195788015);
        return i;
    }

    public final EventBatch m1428a(String str) {
        Preconditions.checkNotNull(str);
        return m1420a("session_id=?", new String[]{str}, m1424c(str), str, this.f1168e.m1445c());
    }

    public final EventBatch m1429a(String str, long j, int i) {
        Preconditions.checkNotNull(str);
        return m1420a("session_id=? AND _id > ?", new String[]{str, String.valueOf(j)}, m1424c(str), str, this.f1168e.m1445c() + i);
    }

    private int m1424c(String str) {
        if (str.equals(this.f1168e.m1441a())) {
            return 50;
        }
        return 0;
    }

    public final EventBatch m1432b(String str) {
        return m1420a("flush_tag=?", new String[]{str}, 0, SafeUUIDGenerator.a().toString(), 1);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.facebook.analytics.db.AnalyticsStorage.EventBatch m1420a(java.lang.String r19, java.lang.String[] r20, int r21, java.lang.String r22, int r23) {
        /*
        r18 = this;
        r0 = r18;
        r2 = r0.f1167d;
        r2 = r2.a();
        r16 = com.google.common.collect.ImmutableList.builder();
        r17 = com.google.common.collect.ImmutableList.builder();
        r14 = -1;
        r13 = 0;
        r12 = 0;
        r11 = 0;
        r3 = "events";
        r4 = f1163a;	 Catch:{ all -> 0x00ae }
        r7 = 0;
        r8 = 0;
        r9 = "_id";
        r5 = m1423c();	 Catch:{ all -> 0x00ae }
        r10 = java.lang.String.valueOf(r5);	 Catch:{ all -> 0x00ae }
        r5 = r19;
        r6 = r20;
        r3 = r2.query(r3, r4, r5, r6, r7, r8, r9, r10);	 Catch:{ all -> 0x00ae }
        if (r21 == 0) goto L_0x0037;
    L_0x002f:
        r2 = r3.getCount();	 Catch:{ all -> 0x0083 }
        r0 = r21;
        if (r2 < r0) goto L_0x008a;
    L_0x0037:
        r2 = r3.moveToNext();	 Catch:{ all -> 0x0083 }
        if (r2 == 0) goto L_0x008a;
    L_0x003d:
        r2 = 0;
        r4 = r3.getLong(r2);	 Catch:{ all -> 0x0083 }
        r2 = java.lang.Long.valueOf(r4);	 Catch:{ all -> 0x0083 }
        r0 = r16;
        r0.c(r2);	 Catch:{ all -> 0x0083 }
        r2 = 1;
        r2 = r3.getString(r2);	 Catch:{ all -> 0x0083 }
        r0 = r17;
        r0.c(r2);	 Catch:{ all -> 0x0083 }
        r2 = 2;
        r4 = r3.getLong(r2);	 Catch:{ all -> 0x0083 }
        r2 = 3;
        r8 = r3.getString(r2);	 Catch:{ all -> 0x0083 }
        r2 = 4;
        r9 = r3.getInt(r2);	 Catch:{ all -> 0x0083 }
    L_0x0064:
        r2 = r3.moveToNext();	 Catch:{ all -> 0x0083 }
        if (r2 == 0) goto L_0x008d;
    L_0x006a:
        r2 = 0;
        r6 = r3.getLong(r2);	 Catch:{ all -> 0x0083 }
        r2 = java.lang.Long.valueOf(r6);	 Catch:{ all -> 0x0083 }
        r0 = r16;
        r0.c(r2);	 Catch:{ all -> 0x0083 }
        r2 = 1;
        r2 = r3.getString(r2);	 Catch:{ all -> 0x0083 }
        r0 = r17;
        r0.c(r2);	 Catch:{ all -> 0x0083 }
        goto L_0x0064;
    L_0x0083:
        r2 = move-exception;
    L_0x0084:
        if (r3 == 0) goto L_0x0089;
    L_0x0086:
        r3.close();
    L_0x0089:
        throw r2;
    L_0x008a:
        r9 = r12;
        r8 = r13;
        r4 = r14;
    L_0x008d:
        if (r3 == 0) goto L_0x0092;
    L_0x008f:
        r3.close();
    L_0x0092:
        r2 = -1;
        r2 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1));
        if (r2 != 0) goto L_0x009a;
    L_0x0098:
        r2 = 0;
    L_0x0099:
        return r2;
    L_0x009a:
        r2 = new com.facebook.analytics.db.AnalyticsStorage$EventBatch;
        r10 = r16.b();
        r11 = r17.b();
        r3 = r18;
        r6 = r22;
        r7 = r23;
        r2.<init>(r3, r4, r6, r7, r8, r9, r10, r11);
        goto L_0x0099;
    L_0x00ae:
        r2 = move-exception;
        r3 = r11;
        goto L_0x0084;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.analytics.db.AnalyticsStorage.a(java.lang.String, java.lang.String[], int, java.lang.String, int):com.facebook.analytics.db.AnalyticsStorage$EventBatch");
    }

    public final String m1433b() {
        Throwable th;
        Cursor cursor = null;
        try {
            Cursor query = this.f1167d.a().query("events", f1165c, "session_id is not null", null, null, null, "_id", "1");
            try {
                if (query.moveToNext()) {
                    String string = query.getString(0);
                    if (query == null) {
                        return string;
                    }
                    query.close();
                    return string;
                }
                if (query != null) {
                    query.close();
                }
                return null;
            } catch (Throwable th2) {
                th = th2;
                cursor = query;
                if (cursor != null) {
                    cursor.close();
                }
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }
}
