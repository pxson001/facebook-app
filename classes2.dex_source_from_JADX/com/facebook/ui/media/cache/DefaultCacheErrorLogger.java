package com.facebook.ui.media.cache;

import com.facebook.cache.common.CacheErrorLogger;
import com.facebook.cache.common.CacheErrorLogger.CacheErrorCategory;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.errorreporting.SoftError;
import com.facebook.common.errorreporting.SoftErrorBuilder;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.inject.InjectorLike;
import com.google.common.annotations.VisibleForTesting;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: outdated_thread_key */
public class DefaultCacheErrorLogger implements CacheErrorLogger {
    private static volatile DefaultCacheErrorLogger f10663d;
    private final AbstractFbErrorReporter f10664a;
    private final CacheExceptionFlightRecorderDataSupplier f10665b;
    private final ReadInvalidEntryCacheErrorLogger f10666c;

    public static com.facebook.ui.media.cache.DefaultCacheErrorLogger m15941a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f10663d;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.ui.media.cache.DefaultCacheErrorLogger.class;
        monitor-enter(r1);
        r0 = f10663d;	 Catch:{ all -> 0x003a }
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
        r0 = m15943b(r0);	 Catch:{ all -> 0x0035 }
        f10663d = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f10663d;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ui.media.cache.DefaultCacheErrorLogger.a(com.facebook.inject.InjectorLike):com.facebook.ui.media.cache.DefaultCacheErrorLogger");
    }

    private static DefaultCacheErrorLogger m15943b(InjectorLike injectorLike) {
        return new DefaultCacheErrorLogger(FbErrorReporterImpl.m2317a(injectorLike), CacheExceptionFlightRecorderDataSupplier.m15946a(injectorLike), ReadInvalidEntryCacheErrorLogger.m15950a(injectorLike));
    }

    @Inject
    public DefaultCacheErrorLogger(AbstractFbErrorReporter abstractFbErrorReporter, CacheExceptionFlightRecorderDataSupplier cacheExceptionFlightRecorderDataSupplier, ReadInvalidEntryCacheErrorLogger readInvalidEntryCacheErrorLogger) {
        this.f10664a = abstractFbErrorReporter;
        this.f10665b = cacheExceptionFlightRecorderDataSupplier;
        this.f10666c = readInvalidEntryCacheErrorLogger;
    }

    public final void mo2056a(CacheErrorCategory cacheErrorCategory, Class<?> cls, String str, @Nullable Throwable th) {
        SoftError b = m15942b(cacheErrorCategory, cls, str, th);
        this.f10664a.mo336a(b);
        this.f10665b.f10670c.m4284a(StringFormatUtil.formatStrLocaleSafe("%s %s %s", b.a, b.c, b.b));
        this.f10666c.m15952a(cacheErrorCategory, cls, str);
    }

    @VisibleForTesting
    private static SoftError m15942b(CacheErrorCategory cacheErrorCategory, Class<?> cls, String str, @Nullable Throwable th) {
        SoftErrorBuilder a = SoftError.a("MEDIACACHE_ERROR_" + cacheErrorCategory.name(), cls.getName() + ":" + str);
        if (th != null) {
            a.c = th;
        }
        return a.g();
    }
}
