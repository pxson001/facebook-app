package com.facebook.messaging.clockskew;

import android.content.ContentValues;
import android.database.Cursor;
import com.facebook.database.sqlite.SqlExpression;
import com.facebook.database.sqlite.SqlExpression.Expression;
import com.facebook.debug.log.BLog;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.clockskew.EstimatedServerClock.State;
import com.facebook.messaging.clockskew.SkewedTimestampDbSchema.TimeSkewTable.Columns;
import com.facebook.messaging.database.threads.DbClock;
import com.facebook.tools.dextr.runtime.detour.SQLiteDetour;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: messenger_pay_entity */
public class SkewedTimestampHandler {
    private static final String[] f9776d = new String[]{Columns.f9771b.d};
    private static final String[] f9777e = new String[]{Columns.f9772c.d};
    private static volatile SkewedTimestampHandler f9778f;
    public final TimeSkewDatabaseSupplier f9779a;
    private final DbClock f9780b;
    private final EstimatedServerClock f9781c;

    public static com.facebook.messaging.clockskew.SkewedTimestampHandler m10342a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f9778f;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.messaging.clockskew.SkewedTimestampHandler.class;
        monitor-enter(r1);
        r0 = f9778f;	 Catch:{ all -> 0x003a }
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
        r0 = m10344b(r0);	 Catch:{ all -> 0x0035 }
        f9778f = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f9778f;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.clockskew.SkewedTimestampHandler.a(com.facebook.inject.InjectorLike):com.facebook.messaging.clockskew.SkewedTimestampHandler");
    }

    private static SkewedTimestampHandler m10344b(InjectorLike injectorLike) {
        return new SkewedTimestampHandler(TimeSkewDatabaseSupplier.m10350a(injectorLike), DbClock.a(injectorLike), EstimatedServerClock.a(injectorLike));
    }

    @Inject
    public SkewedTimestampHandler(TimeSkewDatabaseSupplier timeSkewDatabaseSupplier, DbClock dbClock, EstimatedServerClock estimatedServerClock) {
        this.f9779a = timeSkewDatabaseSupplier;
        this.f9780b = dbClock;
        this.f9781c = estimatedServerClock;
    }

    public final long m10348a(long j, long j2) {
        long a;
        if (this.f9781c.g != State.UNKNOWN) {
            a = this.f9781c.a();
        } else {
            a = this.f9780b.a();
        }
        if (a > j2) {
            return j2;
        }
        if (m10345b(j, j2)) {
            m10343a(j, a, j2);
            return a;
        }
        a = m10346c(j);
        return a != -1 ? a : j2;
    }

    private boolean m10345b(long j, long j2) {
        return m10347d(j) != j2;
    }

    private void m10343a(long j, long j2, long j3) {
        ContentValues contentValues = new ContentValues(3);
        contentValues.put(Columns.f9770a.d, Long.valueOf(j));
        contentValues.put(Columns.f9771b.d, Long.valueOf(j2));
        contentValues.put(Columns.f9772c.d, Long.valueOf(j3));
        SQLiteDetour.a(1061992069);
        this.f9779a.a().insertWithOnConflict("time_skew", null, contentValues, 5);
        SQLiteDetour.a(-450154509);
    }

    public final void m10349a(long j) {
        Expression a = SqlExpression.a(Columns.f9770a.d, Long.toString(j));
        this.f9779a.a().delete("time_skew", a.a(), a.b());
    }

    private long m10346c(long j) {
        Expression a = SqlExpression.a(Columns.f9770a.a(), Long.toString(j));
        Cursor query = this.f9779a.a().query("time_skew", f9776d, a.a(), a.b(), null, null, null);
        long c;
        try {
            if (query.moveToNext()) {
                c = Columns.f9771b.c(query);
                return c;
            }
            query.close();
            return -1;
        } catch (Exception e) {
            c = e;
            BLog.b("SkewedTimestampHandler", c, "Error checking time skew", new Object[0]);
        } finally {
            query.close();
        }
    }

    private long m10347d(long j) {
        long c;
        Expression a = SqlExpression.a(Columns.f9770a.a(), Long.toString(j));
        Cursor query = this.f9779a.a().query("time_skew", f9777e, a.a(), a.b(), null, null, null);
        try {
            if (query.moveToNext()) {
                c = Columns.f9772c.c(query);
                return c;
            }
            query.close();
            return -1;
        } catch (Exception e) {
            c = e;
            BLog.b("SkewedTimestampHandler", c, "Error checking time skew", new Object[0]);
        } finally {
            query.close();
        }
    }
}
