package com.facebook.device.datausage;

import android.os.Handler;
import com.facebook.common.executors.Handler_ForNonUiThreadMethodAutoProvider;
import com.facebook.device.resourcemonitor.DataUsageBytes;
import com.facebook.inject.InjectorLike;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import java.util.Date;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: ntt_discovered_device */
public class DataUsageStorageHandler {
    private static volatile DataUsageStorageHandler f12053f;
    private final Handler f12054a;
    public final DbDataUsageHandler f12055b;
    public final DataUsageSharedPrefHandler f12056c;
    private final DateProvider f12057d;
    private final DataUsageFileLogWriter f12058e;

    public static com.facebook.device.datausage.DataUsageStorageHandler m17755a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f12053f;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.device.datausage.DataUsageStorageHandler.class;
        monitor-enter(r1);
        r0 = f12053f;	 Catch:{ all -> 0x003a }
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
        r0 = m17757b(r0);	 Catch:{ all -> 0x0035 }
        f12053f = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f12053f;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.device.datausage.DataUsageStorageHandler.a(com.facebook.inject.InjectorLike):com.facebook.device.datausage.DataUsageStorageHandler");
    }

    private static DataUsageStorageHandler m17757b(InjectorLike injectorLike) {
        return new DataUsageStorageHandler(Handler_ForNonUiThreadMethodAutoProvider.m5523b(injectorLike), DbDataUsageHandler.m17766a(injectorLike), DataUsageSharedPrefHandler.m17781a(injectorLike), DateProvider.m17778a(injectorLike), DataUsageFileLogWriter.m17789a(injectorLike));
    }

    @Inject
    public DataUsageStorageHandler(Handler handler, DbDataUsageHandler dbDataUsageHandler, DataUsageSharedPrefHandler dataUsageSharedPrefHandler, DateProvider dateProvider, DataUsageFileLogWriter dataUsageFileLogWriter) {
        this.f12054a = handler;
        this.f12055b = dbDataUsageHandler;
        this.f12056c = dataUsageSharedPrefHandler;
        this.f12057d = dateProvider;
        this.f12058e = dataUsageFileLogWriter;
    }

    public final DataUsageBytes m17758a(int i) {
        return this.f12056c.m17786b(i);
    }

    public final String m17762b(int i) {
        return this.f12056c.f12075a.mo278a(DataUsageSharedPrefHandler.m17782a(DataUsagePrefConstants.f17615d, i), null);
    }

    public final void m17759a(DataUsageBytes dataUsageBytes, int i) {
        this.f12056c.f12075a.edit().mo1275a(DataUsageSharedPrefHandler.m17782a(DataUsagePrefConstants.f17613b, i), dataUsageBytes.f5370b).mo1275a(DataUsageSharedPrefHandler.m17782a(DataUsagePrefConstants.f17614c, i), dataUsageBytes.f5371c).mo1276a(DataUsageSharedPrefHandler.m17782a(DataUsagePrefConstants.f17615d, i), SqlUtils.m24789a(DateProvider.m17779a())).commit();
    }

    public final void m17763c(int i) {
        m17760a(new DataUsageBytes(0, 0), DateProvider.m17779a(), i);
    }

    public final void m17761a(Date date, int i) {
        m17760a(this.f12056c.m17785a(i), date, i);
        this.f12058e.m17792a("stored to db, date changed: " + this.f12056c.m17785a(i).f5370b + "date: " + DateProvider.m17779a());
        this.f12056c.m17788d(i);
    }

    public final void m17764d(int i) {
        m17760a(this.f12056c.m17785a(i), DateProvider.m17779a(), i);
        this.f12058e.m17792a("stored to db, reset: " + this.f12056c.m17785a(i).f5370b + "date: " + DateProvider.m17779a());
        this.f12056c.m17787c(i);
    }

    public final void m17760a(DataUsageBytes dataUsageBytes, Date date, int i) {
        HandlerDetour.a(this.f12054a, new 1(this, dataUsageBytes, date, i), -1344565553);
    }

    public static boolean m17756a(DataUsageBytes dataUsageBytes, DataUsageBytes dataUsageBytes2) {
        DataUsageBytes a = dataUsageBytes.m9249a(dataUsageBytes2);
        return a.f5371c < 0 || a.f5370b < 0;
    }

    public final void m17765e(int i) {
        this.f12056c.m17788d(i);
    }
}
