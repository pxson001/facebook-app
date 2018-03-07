package com.facebook.interstitial.manager;

import com.facebook.common.executors.ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider;
import com.facebook.common.init.INeedInit;
import com.facebook.inject.InjectorLike;
import com.facebook.languages.switchercommonex.LocaleChangeController;
import com.facebook.languages.switchercommonex.LocaleChangeListener;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import java.util.Locale;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: malware_detector */
public class InterstitialDataCleaner implements INeedInit, LocaleChangeListener {
    private static volatile InterstitialDataCleaner f8395d;
    private final ListeningExecutorService f8396a;
    private final LocaleChangeController f8397b;
    public final InterstitialManager f8398c;

    public static com.facebook.interstitial.manager.InterstitialDataCleaner m8667a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f8395d;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.interstitial.manager.InterstitialDataCleaner.class;
        monitor-enter(r1);
        r0 = f8395d;	 Catch:{ all -> 0x003a }
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
        r0 = m8668b(r0);	 Catch:{ all -> 0x0035 }
        f8395d = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f8395d;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.interstitial.manager.InterstitialDataCleaner.a(com.facebook.inject.InjectorLike):com.facebook.interstitial.manager.InterstitialDataCleaner");
    }

    private static InterstitialDataCleaner m8668b(InjectorLike injectorLike) {
        return new InterstitialDataCleaner(ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider.a(injectorLike), LocaleChangeController.a(injectorLike), InterstitialManager.a(injectorLike));
    }

    @Inject
    public InterstitialDataCleaner(ListeningExecutorService listeningExecutorService, LocaleChangeController localeChangeController, InterstitialManager interstitialManager) {
        this.f8396a = listeningExecutorService;
        this.f8397b = localeChangeController;
        this.f8398c = interstitialManager;
    }

    public void init() {
        this.f8397b.a(this);
    }

    public final ListenableFuture m8669a(Locale locale) {
        return this.f8396a.a(new 1(this));
    }
}
