package com.facebook.photos.progressiveimagequality.datausage;

import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.device.datausage.DataUsageStorageHandler;
import com.facebook.device.datausage.DateProvider;
import com.facebook.device.datausage.SqlUtils;
import com.facebook.device.resourcemonitor.DataUsageBytes;
import com.facebook.inject.InjectorLike;
import java.text.ParseException;
import java.util.Date;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: seen_in_group */
public class CompressionSavingsStorageHandler {
    private static volatile CompressionSavingsStorageHandler f2873e;
    private final DataUsageStorageHandler f2874a;
    private final AbstractFbErrorReporter f2875b;
    private final DateProvider f2876c;
    private final CompressionSavingsAnalyticsLogger f2877d;

    public static com.facebook.photos.progressiveimagequality.datausage.CompressionSavingsStorageHandler m3138a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f2873e;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.photos.progressiveimagequality.datausage.CompressionSavingsStorageHandler.class;
        monitor-enter(r1);
        r0 = f2873e;	 Catch:{ all -> 0x003a }
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
        r0 = m3139b(r0);	 Catch:{ all -> 0x0035 }
        f2873e = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f2873e;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.photos.progressiveimagequality.datausage.CompressionSavingsStorageHandler.a(com.facebook.inject.InjectorLike):com.facebook.photos.progressiveimagequality.datausage.CompressionSavingsStorageHandler");
    }

    private static CompressionSavingsStorageHandler m3139b(InjectorLike injectorLike) {
        return new CompressionSavingsStorageHandler(DataUsageStorageHandler.a(injectorLike), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike), DateProvider.a(injectorLike), CompressionSavingsAnalyticsLogger.m3141a(injectorLike));
    }

    @Inject
    public CompressionSavingsStorageHandler(DataUsageStorageHandler dataUsageStorageHandler, AbstractFbErrorReporter abstractFbErrorReporter, DateProvider dateProvider, CompressionSavingsAnalyticsLogger compressionSavingsAnalyticsLogger) {
        this.f2874a = dataUsageStorageHandler;
        this.f2875b = abstractFbErrorReporter;
        this.f2876c = dateProvider;
        this.f2877d = compressionSavingsAnalyticsLogger;
    }

    public final synchronized void m3140a(long j, boolean z) {
        int a = m3137a(z);
        DataUsageBytes dataUsageBytes = new DataUsageBytes(j, 0);
        String b = this.f2874a.b(a);
        if (b == null) {
            this.f2874a.c(a);
        } else if (!b.equals(SqlUtils.a(DateProvider.a()))) {
            try {
                DataUsageBytes a2 = this.f2874a.a(a);
                Date a3 = SqlUtils.a(b);
                this.f2874a.a(a2, a3, a);
                if (z) {
                    this.f2877d.m3144a(a2.a(), a3);
                }
                this.f2874a.a(new DataUsageBytes(0, 0), a);
            } catch (ParseException e) {
                this.f2875b.a("Failure to parse last sync date: %s", b);
            }
        }
        this.f2874a.a(this.f2874a.a(a).b(dataUsageBytes), a);
    }

    private static int m3137a(boolean z) {
        return z ? 2 : 3;
    }
}
