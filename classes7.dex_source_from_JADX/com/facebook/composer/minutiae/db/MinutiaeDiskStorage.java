package com.facebook.composer.minutiae.db;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.SQLException;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.event.HoneyClientEventFast;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.common.executors.ListeningExecutorService_BackgroundExecutorServiceMethodAutoProvider;
import com.facebook.common.executors.ListeningExecutorService_ForegroundExecutorServiceMethodAutoProvider;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.composer.minutiae.db.MinutiaeSchema.VerbTable;
import com.facebook.composer.minutiae.db.MinutiaeSchema.VerbTable.Columns;
import com.facebook.composer.minutiae.db.MinutiaeVerbDatabaseModel.MinutiaeDatabaseModelBuilder;
import com.facebook.composer.minutiae.protocol.MinutiaeVerbModelEdge;
import com.facebook.database.sqlite.SqlColumn;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.tools.dextr.runtime.detour.ExecutorDetour;
import com.facebook.tools.dextr.runtime.detour.SQLiteDetour;
import com.facebook.user.model.User;
import com.google.common.base.Absent;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.util.concurrent.ListeningExecutorService;
import java.util.concurrent.ExecutorService;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
/* compiled from: topLoadingStart */
public class MinutiaeDiskStorage {
    private static volatile MinutiaeDiskStorage f1471g;
    private final MinutiaeDatabaseSupplier f1472a;
    private final AnalyticsLogger f1473b;
    private final ExecutorService f1474c;
    private final ListeningExecutorService f1475d;
    private final Provider<User> f1476e;
    private final Clock f1477f;

    public static com.facebook.composer.minutiae.db.MinutiaeDiskStorage m1565a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f1471g;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.composer.minutiae.db.MinutiaeDiskStorage.class;
        monitor-enter(r1);
        r0 = f1471g;	 Catch:{ all -> 0x003a }
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
        r0 = m1571b(r0);	 Catch:{ all -> 0x0035 }
        f1471g = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f1471g;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.composer.minutiae.db.MinutiaeDiskStorage.a(com.facebook.inject.InjectorLike):com.facebook.composer.minutiae.db.MinutiaeDiskStorage");
    }

    private static MinutiaeDiskStorage m1571b(InjectorLike injectorLike) {
        return new MinutiaeDiskStorage(MinutiaeDatabaseSupplier.m1563a(injectorLike), AnalyticsLoggerMethodAutoProvider.a(injectorLike), (ExecutorService) ListeningExecutorService_BackgroundExecutorServiceMethodAutoProvider.a(injectorLike), ListeningExecutorService_ForegroundExecutorServiceMethodAutoProvider.a(injectorLike), IdBasedProvider.a(injectorLike, 3595), (Clock) SystemClockMethodAutoProvider.a(injectorLike));
    }

    private static String m1566a(Cursor cursor, SqlColumn sqlColumn) {
        return cursor.getString(cursor.getColumnIndex(sqlColumn.d));
    }

    private static int m1570b(Cursor cursor, SqlColumn sqlColumn) {
        return cursor.getInt(cursor.getColumnIndex(sqlColumn.d));
    }

    @Inject
    public MinutiaeDiskStorage(MinutiaeDatabaseSupplier minutiaeDatabaseSupplier, AnalyticsLogger analyticsLogger, ExecutorService executorService, ListeningExecutorService listeningExecutorService, Provider<User> provider, Clock clock) {
        this.f1472a = minutiaeDatabaseSupplier;
        this.f1473b = analyticsLogger;
        this.f1474c = executorService;
        this.f1475d = listeningExecutorService;
        this.f1476e = provider;
        this.f1477f = clock;
    }

    public final Optional<ImmutableList<MinutiaeVerbModelEdge>> m1573a(String str) {
        Cursor query = this.f1472a.a().query("minutiae_verb_table", null, Columns.f1490m.d + " = ? AND " + Columns.f1491n.d + " = ?", new String[]{str, ((User) this.f1476e.get()).a}, null, null, null, null);
        Builder builder = ImmutableList.builder();
        if (query.getCount() == 0) {
            m1568a("minutiae_disk_storage_get_activities_not_found", str);
            query.close();
            return Absent.INSTANCE;
        }
        query.moveToFirst();
        if (this.f1477f.a() - query.getLong(query.getColumnIndex(Columns.f1492o.d)) > 31536000000L) {
            m1567a();
            return Absent.INSTANCE;
        }
        while (!query.isClosed()) {
            MinutiaeDatabaseModelBuilder minutiaeDatabaseModelBuilder = new MinutiaeDatabaseModelBuilder();
            minutiaeDatabaseModelBuilder.f1499c = m1566a(query, Columns.f1478a);
            minutiaeDatabaseModelBuilder = minutiaeDatabaseModelBuilder;
            minutiaeDatabaseModelBuilder.f1500d = m1566a(query, Columns.f1479b);
            minutiaeDatabaseModelBuilder = minutiaeDatabaseModelBuilder;
            minutiaeDatabaseModelBuilder.f1501e = m1566a(query, Columns.f1480c);
            minutiaeDatabaseModelBuilder = minutiaeDatabaseModelBuilder;
            minutiaeDatabaseModelBuilder.f1502f = m1566a(query, Columns.f1481d);
            minutiaeDatabaseModelBuilder = minutiaeDatabaseModelBuilder;
            minutiaeDatabaseModelBuilder.f1503g = m1572d(query, Columns.f1482e);
            minutiaeDatabaseModelBuilder = minutiaeDatabaseModelBuilder;
            minutiaeDatabaseModelBuilder.f1504h = m1572d(query, Columns.f1483f);
            minutiaeDatabaseModelBuilder = minutiaeDatabaseModelBuilder;
            minutiaeDatabaseModelBuilder.f1506j = m1572d(query, Columns.f1484g);
            minutiaeDatabaseModelBuilder = minutiaeDatabaseModelBuilder;
            minutiaeDatabaseModelBuilder.f1505i = m1572d(query, Columns.f1485h);
            minutiaeDatabaseModelBuilder = minutiaeDatabaseModelBuilder;
            minutiaeDatabaseModelBuilder.f1507k = m1566a(query, Columns.f1486i);
            minutiaeDatabaseModelBuilder = minutiaeDatabaseModelBuilder;
            minutiaeDatabaseModelBuilder.f1508l = m1566a(query, Columns.f1487j);
            minutiaeDatabaseModelBuilder = minutiaeDatabaseModelBuilder;
            minutiaeDatabaseModelBuilder.f1498b = m1570b(query, Columns.f1488k);
            minutiaeDatabaseModelBuilder = minutiaeDatabaseModelBuilder;
            minutiaeDatabaseModelBuilder.f1497a = m1570b(query, Columns.f1489l);
            builder.c(minutiaeDatabaseModelBuilder.m1579a().m1581a());
            if (query.isLast()) {
                query.close();
            } else {
                query.moveToNext();
            }
        }
        m1568a("minutiae_disk_storage_get_activities_found", str);
        return Optional.of(builder.b());
    }

    public final void m1574a(final ImmutableList<MinutiaeVerbModelEdge> immutableList, final String str) {
        ExecutorDetour.a(this.f1474c, new Runnable(this) {
            final /* synthetic */ MinutiaeDiskStorage f1470c;

            public void run() {
                this.f1470c.m1575b(immutableList, str);
            }
        }, 232407014);
    }

    public final boolean m1575b(ImmutableList<MinutiaeVerbModelEdge> immutableList, String str) {
        if (this.f1476e.get() == null) {
            return false;
        }
        m1567a();
        if (m1569b() > 60) {
            return false;
        }
        boolean z;
        SQLiteDetour.a(this.f1472a.a(), -1183271212);
        int i = 0;
        while (i < immutableList.size()) {
            try {
                ContentValues contentValues = new ContentValues(VerbTable.f1493a);
                MinutiaeVerbDatabaseModel a = MinutiaeVerbDatabaseModel.m1580a(i, (MinutiaeVerbModelEdge) immutableList.get(i));
                contentValues.put(Columns.f1478a.a(), a.f1509a);
                contentValues.put(Columns.f1479b.a(), a.f1510b);
                contentValues.put(Columns.f1480c.a(), a.f1511c);
                contentValues.put(Columns.f1481d.a(), a.f1512d);
                contentValues.put(Columns.f1482e.a(), Boolean.valueOf(a.f1513e));
                contentValues.put(Columns.f1483f.a(), Boolean.valueOf(a.f1514f));
                contentValues.put(Columns.f1484g.a(), Boolean.valueOf(a.f1516h));
                contentValues.put(Columns.f1485h.a(), Boolean.valueOf(a.f1515g));
                contentValues.put(Columns.f1486i.a(), a.f1517i);
                contentValues.put(Columns.f1487j.a(), a.f1518j);
                contentValues.put(Columns.f1488k.a(), Integer.valueOf(a.f1520l));
                contentValues.put(Columns.f1489l.a(), Integer.valueOf(a.f1519k));
                contentValues.put(Columns.f1490m.a(), str);
                contentValues.put(Columns.f1491n.a(), ((User) this.f1476e.get()).d());
                contentValues.put(Columns.f1492o.a(), Long.valueOf(this.f1477f.a()));
                SQLiteDetour.a(13487693);
                long insertOrThrow = this.f1472a.a().insertOrThrow("minutiae_verb_table", null, contentValues);
                SQLiteDetour.a(-625925669);
                if (insertOrThrow == -1) {
                    z = false;
                    break;
                }
                i++;
            } catch (SQLException e) {
                m1568a("minutiae_disk_storage_write_activities_failed", str);
                SQLiteDetour.b(this.f1472a.a(), 655400204);
                z = false;
            } catch (Throwable th) {
                m1568a("minutiae_disk_storage_write_activities_succeeded", str);
                this.f1472a.a().setTransactionSuccessful();
                SQLiteDetour.b(this.f1472a.a(), 2105077981);
            }
        }
        z = true;
        if (z) {
            m1568a("minutiae_disk_storage_write_activities_succeeded", str);
            this.f1472a.a().setTransactionSuccessful();
        } else {
            m1568a("minutiae_disk_storage_write_activities_failed", str);
        }
        SQLiteDetour.b(this.f1472a.a(), 1322238134);
        return z;
    }

    private void m1567a() {
        SQLiteDetour.a(this.f1472a.a(), 503459562);
        this.f1472a.a().delete("minutiae_verb_table", Columns.f1491n.d + " = ?", new String[]{((User) this.f1476e.get()).a});
        this.f1472a.a().setTransactionSuccessful();
        SQLiteDetour.b(this.f1472a.a(), -261522213);
    }

    private int m1569b() {
        SQLiteDetour.a(this.f1472a.a(), 1899125920);
        Cursor rawQuery = this.f1472a.a().rawQuery("SELECT COUNT(*) FROM minutiae_verb_table", null);
        rawQuery.moveToFirst();
        int i = rawQuery.getInt(0);
        rawQuery.close();
        this.f1472a.a().setTransactionSuccessful();
        SQLiteDetour.b(this.f1472a.a(), -137566011);
        return i;
    }

    private boolean m1572d(Cursor cursor, SqlColumn sqlColumn) {
        return m1570b(cursor, sqlColumn) == 1;
    }

    private void m1568a(String str, String str2) {
        Preconditions.checkNotNull(str2);
        HoneyClientEventFast a = this.f1473b.a(str, false);
        if (a.a()) {
            a.a("CACHE_KEY", str2);
            a.b();
        }
    }
}
