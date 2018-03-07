package com.facebook.device.datausage;

import android.os.Process;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.device.FbTrafficStats;
import com.facebook.device.resourcemonitor.DataUsageBytes;
import com.facebook.inject.InjectorLike;
import java.text.ParseException;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: null GraphQLResult */
public class DataUsageSyncer {
    private static volatile DataUsageSyncer f12047f;
    public final DataUsageStorageHandler f12048a;
    private final FbTrafficStats f12049b;
    private final AbstractFbErrorReporter f12050c;
    private final DateProvider f12051d;
    private final DataUsageFileLogWriter f12052e;

    public static com.facebook.device.datausage.DataUsageSyncer m17752a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f12047f;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.device.datausage.DataUsageSyncer.class;
        monitor-enter(r1);
        r0 = f12047f;	 Catch:{ all -> 0x003a }
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
        r0 = m17753b(r0);	 Catch:{ all -> 0x0035 }
        f12047f = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f12047f;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.device.datausage.DataUsageSyncer.a(com.facebook.inject.InjectorLike):com.facebook.device.datausage.DataUsageSyncer");
    }

    private static DataUsageSyncer m17753b(InjectorLike injectorLike) {
        return new DataUsageSyncer(DataUsageStorageHandler.m17755a(injectorLike), FbTrafficStats.m9228a(injectorLike), FbErrorReporterImpl.m2317a(injectorLike), DateProvider.m17778a(injectorLike), DataUsageFileLogWriter.m17789a(injectorLike));
    }

    @Inject
    public DataUsageSyncer(DataUsageStorageHandler dataUsageStorageHandler, FbTrafficStats fbTrafficStats, AbstractFbErrorReporter abstractFbErrorReporter, DateProvider dateProvider, DataUsageFileLogWriter dataUsageFileLogWriter) {
        this.f12048a = dataUsageStorageHandler;
        this.f12049b = fbTrafficStats;
        this.f12050c = abstractFbErrorReporter;
        this.f12051d = dateProvider;
        this.f12052e = dataUsageFileLogWriter;
    }

    public final synchronized void m17754a() {
        Object obj = 1;
        synchronized (this) {
            DataUsageBytes a = this.f12049b.m9239a(Process.myUid(), 0);
            DataUsageBytes a2 = this.f12048a.m17758a(1);
            this.f12052e.m17792a("current: " + a.m9248a() + " stored: " + a2.m9248a() + " diff: " + a.m9249a(a2).m9248a());
            String b = this.f12048a.m17762b(1);
            if (b == null) {
                this.f12048a.m17763c(1);
            } else {
                if (!b.equals(SqlUtils.m24789a(DateProvider.m17779a()))) {
                    try {
                        this.f12048a.m17761a(SqlUtils.m24790a(b), 1);
                        obj = null;
                    } catch (ParseException e) {
                        this.f12050c.m2340a("Failure to parse last sync date: %s", b);
                    }
                }
                obj = null;
            }
            if (DataUsageStorageHandler.m17756a(a, a2)) {
                this.f12048a.m17764d(1);
            }
            this.f12048a.m17759a(a, 1);
            if (obj != null) {
                this.f12048a.m17765e(1);
            }
        }
    }
}
