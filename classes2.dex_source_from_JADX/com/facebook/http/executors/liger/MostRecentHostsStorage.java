package com.facebook.http.executors.liger;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteFullException;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.executors.C0055x2995691a;
import com.facebook.http.executors.liger.MostRecentHostsSchemaPart.MostRecentHostsTable.Columns;
import com.facebook.http.qe.ExperimentsForHttpQeModule;
import com.facebook.inject.InjectorLike;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.tools.dextr.runtime.detour.ExecutorDetour;
import com.facebook.tools.dextr.runtime.detour.SQLiteDetour;
import com.google.common.base.Preconditions;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: progress_spinner_time */
public class MostRecentHostsStorage {
    private static final String f8778a = MostRecentHostsStorage.class.getSimpleName();
    private static volatile MostRecentHostsStorage f8779h;
    private final MostRecentHostsDatabaseSupplier f8780b;
    private final ExecutorService f8781c;
    private final AbstractFbErrorReporter f8782d;
    private final QeAccessor f8783e;
    private final ThreadLocal<ContentValues> f8784f = new ThreadLocal();
    public final AtomicBoolean f8785g = new AtomicBoolean(false);

    public static com.facebook.http.executors.liger.MostRecentHostsStorage m13631a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f8779h;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.http.executors.liger.MostRecentHostsStorage.class;
        monitor-enter(r1);
        r0 = f8779h;	 Catch:{ all -> 0x003a }
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
        r0 = m13632b(r0);	 Catch:{ all -> 0x0035 }
        f8779h = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f8779h;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.http.executors.liger.MostRecentHostsStorage.a(com.facebook.inject.InjectorLike):com.facebook.http.executors.liger.MostRecentHostsStorage");
    }

    private static MostRecentHostsStorage m13632b(InjectorLike injectorLike) {
        return new MostRecentHostsStorage(MostRecentHostsDatabaseSupplier.m13636a(injectorLike), C0055x2995691a.m1881a(injectorLike), QeInternalImplMethodAutoProvider.m3744a(injectorLike), FbErrorReporterImpl.m2317a(injectorLike));
    }

    @Inject
    public MostRecentHostsStorage(MostRecentHostsDatabaseSupplier mostRecentHostsDatabaseSupplier, ExecutorService executorService, QeAccessor qeAccessor, AbstractFbErrorReporter abstractFbErrorReporter) {
        this.f8780b = mostRecentHostsDatabaseSupplier;
        this.f8781c = executorService;
        this.f8783e = qeAccessor;
        this.f8782d = abstractFbErrorReporter;
    }

    public final void m13635a(String str) {
        Preconditions.checkNotNull(str);
        if (this.f8783e.mo596a(ExperimentsForHttpQeModule.aY, false) && this.f8785g.compareAndSet(false, true)) {
            ExecutorDetour.a(this.f8781c, new 1(this, str), -555798620);
        }
    }

    public final List<String> m13634a(int i) {
        if (!this.f8783e.mo596a(ExperimentsForHttpQeModule.aY, false)) {
            return Collections.emptyList();
        }
        try {
            Cursor query = this.f8780b.mo2480a().query("most_recent_hosts_table", new String[]{Columns.f8789b.m2091a()}, null, null, null, null, Columns.f8788a.m2100e(), Integer.toString(i));
            try {
                List<String> arrayList = new ArrayList();
                while (query.moveToNext()) {
                    arrayList.add(query.getString(0));
                }
                return arrayList;
            } finally {
                query.close();
            }
        } catch (Throwable e) {
            this.f8782d.m2352b(f8778a, e);
            return Collections.emptyList();
        }
    }

    public static synchronized void m13633b(MostRecentHostsStorage mostRecentHostsStorage, String str) {
        synchronized (mostRecentHostsStorage) {
            ContentValues contentValues;
            ContentValues contentValues2 = (ContentValues) mostRecentHostsStorage.f8784f.get();
            if (contentValues2 == null) {
                contentValues = new ContentValues();
            } else {
                contentValues = contentValues2;
            }
            contentValues.put(Columns.f8789b.m2091a(), str);
            try {
                SQLiteDatabase a = mostRecentHostsStorage.f8780b.mo2480a();
                try {
                    SQLiteDetour.a(1405252834);
                    a.insertWithOnConflict("most_recent_hosts_table", null, contentValues, 5);
                    SQLiteDetour.a(225143895);
                } catch (SQLiteFullException e) {
                    a.delete("most_recent_hosts_table", null, null);
                }
            } catch (Throwable e2) {
                mostRecentHostsStorage.f8782d.m2352b(f8778a, e2);
                try {
                    mostRecentHostsStorage.f8780b.mo2481e();
                } catch (SQLException e3) {
                }
            }
            mostRecentHostsStorage.f8784f.set(contentValues);
        }
    }
}
