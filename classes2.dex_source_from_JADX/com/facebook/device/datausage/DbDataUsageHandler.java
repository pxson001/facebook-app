package com.facebook.device.datausage;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;
import com.facebook.database.sqlite.SqlExpression;
import com.facebook.database.sqlite.SqlExpression.Expression;
import com.facebook.device.datausage.DataUsageSchemaPart.TrafficStatsTable.Columns;
import com.facebook.device.resourcemonitor.DataUsageBytes;
import com.facebook.inject.InjectorLike;
import com.facebook.tools.dextr.runtime.detour.SQLiteDetour;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import javax.annotation.Nullable;
import javax.annotation.concurrent.ThreadSafe;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
@ThreadSafe
/* compiled from: nsp */
public class DbDataUsageHandler {
    private static final Class<DbDataUsageHandler> f12059a = DbDataUsageHandler.class;
    private static final String[] f12060b = new String[]{Columns.f12064a.toString(), Columns.f12065b.toString(), Columns.f12066c.toString(), Columns.f12067d.toString()};
    private static volatile DbDataUsageHandler f12061e;
    private final DataUsageDatabaseSupplier f12062c;
    private final DateProvider f12063d;

    public static com.facebook.device.datausage.DbDataUsageHandler m17766a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f12061e;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.device.datausage.DbDataUsageHandler.class;
        monitor-enter(r1);
        r0 = f12061e;	 Catch:{ all -> 0x003a }
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
        r0 = m17769b(r0);	 Catch:{ all -> 0x0035 }
        f12061e = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f12061e;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.device.datausage.DbDataUsageHandler.a(com.facebook.inject.InjectorLike):com.facebook.device.datausage.DbDataUsageHandler");
    }

    private static DbDataUsageHandler m17769b(InjectorLike injectorLike) {
        return new DbDataUsageHandler(DataUsageDatabaseSupplier.m17773a(injectorLike), DateProvider.m17778a(injectorLike));
    }

    @Inject
    public DbDataUsageHandler(DataUsageDatabaseSupplier dataUsageDatabaseSupplier, DateProvider dateProvider) {
        this.f12062c = dataUsageDatabaseSupplier;
        this.f12063d = dateProvider;
    }

    public final void m17772a(DataUsageBytes dataUsageBytes, Date date, int i) {
        SQLiteDatabase a = this.f12062c.mo2480a();
        DataUsageBytes a2 = m17771a(date, i);
        if (a2 != null) {
            dataUsageBytes = dataUsageBytes.m9251b(a2);
        } else {
            m17768a();
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put(Columns.f12064a.toString(), m17767a(date));
        contentValues.put(Columns.f12065b.toString(), Long.valueOf(dataUsageBytes.f5370b));
        contentValues.put(Columns.f12066c.toString(), Long.valueOf(dataUsageBytes.f5371c));
        contentValues.put(Columns.f12067d.toString(), String.valueOf(i));
        SQLiteDetour.a(-2016819568);
        a.replace("traffic_stats", "", contentValues);
        SQLiteDetour.a(-1021109284);
    }

    @Nullable
    public final synchronized DataUsageBytes m17771a(Date date, int i) {
        DataUsageBytes dataUsageBytes;
        SQLiteQueryBuilder sQLiteQueryBuilder = new SQLiteQueryBuilder();
        sQLiteQueryBuilder.setTables("traffic_stats");
        Expression a = SqlExpression.m10722a();
        a.m10741a(Columns.f12064a.m2090a(m17767a(date)));
        a.m10741a(Columns.f12067d.m2090a(String.valueOf(i)));
        Cursor query = sQLiteQueryBuilder.query(this.f12062c.mo2480a(), f12060b, a.mo1476a(), a.mo1477b(), null, null, null, "1");
        int a2 = Columns.f12065b.m2089a(query);
        int a3 = Columns.f12066c.m2089a(query);
        try {
            if (query.moveToNext()) {
                dataUsageBytes = new DataUsageBytes((long) query.getInt(a2), (long) query.getInt(a3));
            } else {
                dataUsageBytes = null;
            }
        } finally {
            query.close();
        }
        return dataUsageBytes;
    }

    private synchronized void m17768a() {
        Integer.valueOf(this.f12062c.mo2480a().delete("traffic_stats", Columns.f12064a.toString() + " <= '" + m17767a(m17770b(DateProvider.m17779a(), 30)) + "'", null));
    }

    private static String m17767a(Date date) {
        return new SimpleDateFormat("yyyy-MM-dd", Locale.US).format(date);
    }

    private static Date m17770b(Date date, int i) {
        Calendar instance = Calendar.getInstance();
        instance.setTime(date);
        instance.add(5, i * -1);
        return instance.getTime();
    }
}
