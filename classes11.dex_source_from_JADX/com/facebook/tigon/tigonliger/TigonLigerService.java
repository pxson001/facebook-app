package com.facebook.tigon.tigonliger;

import com.facebook.common.jniexecutors.AndroidAsyncExecutorFactory;
import com.facebook.common.jniexecutors.AndroidAsyncExecutorFactory_DefaultExecutorServiceMethodAutoProvider;
import com.facebook.debug.log.BLog;
import com.facebook.http.executors.liger.LigerInitializationException;
import com.facebook.http.executors.liger.LigerLibraryLoader;
import com.facebook.http.executors.liger.LigerRequestExecutor;
import com.facebook.http.executors.liger.iface.LibraryLoader;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.jni.HybridData;
import com.facebook.liger.LigerHttpClientProvider;
import com.facebook.proguard.annotations.DoNotStrip;
import com.facebook.proxygen.EventBase;
import com.facebook.proxygen.HTTPClient;
import com.facebook.soloader.SoLoader;
import com.facebook.tigon.tigonapi.ITigonXplatService;
import com.facebook.tigon.tigonapi.TigonXplatService;
import javax.inject.Inject;
import javax.inject.Singleton;

@DoNotStrip
@Singleton
/* compiled from: need_profile_pic */
public class TigonLigerService extends TigonXplatService implements ITigonXplatService {
    private static final Class<?> f5081a = TigonLigerService.class;
    private static volatile TigonLigerService f5082c;
    private LigerRequestExecutor f5083b;

    public static com.facebook.tigon.tigonliger.TigonLigerService m6368a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f5082c;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.tigon.tigonliger.TigonLigerService.class;
        monitor-enter(r1);
        r0 = f5082c;	 Catch:{ all -> 0x003a }
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
        r0 = m6369b(r0);	 Catch:{ all -> 0x0035 }
        f5082c = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f5082c;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.tigon.tigonliger.TigonLigerService.a(com.facebook.inject.InjectorLike):com.facebook.tigon.tigonliger.TigonLigerService");
    }

    private static native HybridData initHybrid(EventBase eventBase, HTTPClient hTTPClient, TigonLigerConfig tigonLigerConfig, AndroidAsyncExecutorFactory androidAsyncExecutorFactory, TigonLigerCrashReporter tigonLigerCrashReporter);

    public native void cancelAllRequests();

    public native void reconfigure(TigonLigerConfig tigonLigerConfig);

    private static TigonLigerService m6369b(InjectorLike injectorLike) {
        return new TigonLigerService(LigerLibraryLoader.b(injectorLike), IdBasedSingletonScopeProvider.b(injectorLike, 2255), TigonLigerConfig.m6364a(injectorLike), AndroidAsyncExecutorFactory_DefaultExecutorServiceMethodAutoProvider.a(injectorLike), TigonLigerCrashReporter.m6366b(injectorLike));
    }

    static {
        SoLoader.a("tigonliger");
    }

    @Inject
    public TigonLigerService(LibraryLoader libraryLoader, Lazy<LigerHttpClientProvider> lazy, TigonLigerConfig tigonLigerConfig, AndroidAsyncExecutorFactory androidAsyncExecutorFactory, TigonLigerCrashReporter tigonLigerCrashReporter) {
        super(m6367a(libraryLoader, lazy, tigonLigerConfig, androidAsyncExecutorFactory, tigonLigerCrashReporter));
        try {
            this.f5083b = (LigerRequestExecutor) lazy.get();
        } catch (Throwable e) {
            BLog.a(f5081a, "Can't initialize tigon", e);
        }
    }

    private static HybridData m6367a(LibraryLoader libraryLoader, Lazy<LigerHttpClientProvider> lazy, TigonLigerConfig tigonLigerConfig, AndroidAsyncExecutorFactory androidAsyncExecutorFactory, TigonLigerCrashReporter tigonLigerCrashReporter) {
        if (libraryLoader.a()) {
            try {
                HTTPClient d = ((LigerRequestExecutor) lazy.get()).d();
                HybridData initHybrid = initHybrid(d.getEventBase(), d, tigonLigerConfig, androidAsyncExecutorFactory, tigonLigerCrashReporter);
                if (initHybrid != null) {
                    return initHybrid;
                }
                BLog.a(f5081a, "Can't load liger pointers");
                return new HybridData();
            } catch (LigerInitializationException e) {
                BLog.a(f5081a, "Can't initialize liger", e);
                return new HybridData();
            }
        }
        BLog.a(f5081a, "Can't load liger");
        return new HybridData();
    }

    protected final void mo144b() {
        this.f5083b.e();
    }
}
