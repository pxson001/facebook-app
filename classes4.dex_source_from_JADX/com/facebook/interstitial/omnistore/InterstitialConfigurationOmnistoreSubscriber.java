package com.facebook.interstitial.omnistore;

import com.facebook.androidcompat.AndroidCompat;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.executors.ScheduledExecutorService_BackgroundExecutorServiceMethodAutoProvider;
import com.facebook.common.time.AwakeTimeSinceBootClockMethodAutoProvider;
import com.facebook.common.time.MonotonicClock;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.interstitial.api.FetchInterstitialResult;
import com.facebook.interstitial.manager.InterstitialManager;
import com.facebook.interstitial.manager.InterstitialRepository;
import com.facebook.omnistore.Collection;
import com.facebook.omnistore.Collection.SortDirection;
import com.facebook.omnistore.Cursor;
import com.facebook.omnistore.Omnistore;
import com.google.common.collect.ImmutableList.Builder;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: language_switcher_login_suggestions_failed */
public class InterstitialConfigurationOmnistoreSubscriber {
    private static final String f9633a = InterstitialConfigurationOmnistoreSubscriber.class.getSimpleName();
    private static volatile InterstitialConfigurationOmnistoreSubscriber f9634k;
    private final Lazy<Omnistore> f9635b;
    private final InterstitialManager f9636c;
    private final InterstitialRepository f9637d;
    private final ScheduledExecutorService f9638e;
    private final MonotonicClock f9639f;
    private final Lazy<FbErrorReporter> f9640g;
    private final Object f9641h = new Object();
    private long f9642i;
    @GuardedBy("this")
    @Nullable
    private Collection f9643j;

    public static com.facebook.interstitial.omnistore.InterstitialConfigurationOmnistoreSubscriber m10075a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f9634k;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.interstitial.omnistore.InterstitialConfigurationOmnistoreSubscriber.class;
        monitor-enter(r1);
        r0 = f9634k;	 Catch:{ all -> 0x003a }
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
        r0 = m10076b(r0);	 Catch:{ all -> 0x0035 }
        f9634k = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f9634k;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.interstitial.omnistore.InterstitialConfigurationOmnistoreSubscriber.a(com.facebook.inject.InjectorLike):com.facebook.interstitial.omnistore.InterstitialConfigurationOmnistoreSubscriber");
    }

    private static InterstitialConfigurationOmnistoreSubscriber m10076b(InjectorLike injectorLike) {
        return new InterstitialConfigurationOmnistoreSubscriber(IdBasedLazy.a(injectorLike, 2863), InterstitialManager.a(injectorLike), InterstitialRepository.a(injectorLike), ScheduledExecutorService_BackgroundExecutorServiceMethodAutoProvider.a(injectorLike), (MonotonicClock) AwakeTimeSinceBootClockMethodAutoProvider.a(injectorLike), IdBasedSingletonScopeProvider.b(injectorLike, 494));
    }

    @Inject
    public InterstitialConfigurationOmnistoreSubscriber(Lazy<Omnistore> lazy, InterstitialManager interstitialManager, InterstitialRepository interstitialRepository, ScheduledExecutorService scheduledExecutorService, MonotonicClock monotonicClock, Lazy<FbErrorReporter> lazy2) {
        this.f9635b = lazy;
        this.f9636c = interstitialManager;
        this.f9637d = interstitialRepository;
        this.f9638e = scheduledExecutorService;
        this.f9639f = monotonicClock;
        this.f9640g = lazy2;
    }

    public final synchronized void m10079a(@Nullable Collection collection) {
        this.f9643j = collection;
    }

    public final void m10078a() {
        synchronized (this.f9641h) {
            if (this.f9639f.now() - this.f9642i >= TimeUnit.SECONDS.toMillis(5)) {
                this.f9642i = this.f9639f.now();
                this.f9638e.schedule(new 1(this), 5, TimeUnit.SECONDS);
            }
        }
    }

    public static synchronized void m10077b(InterstitialConfigurationOmnistoreSubscriber interstitialConfigurationOmnistoreSubscriber) {
        Throwable th;
        Throwable th2;
        synchronized (interstitialConfigurationOmnistoreSubscriber) {
            Cursor query;
            if (interstitialConfigurationOmnistoreSubscriber.f9643j != null) {
                Builder builder = new Builder();
                query = interstitialConfigurationOmnistoreSubscriber.f9643j.query("00000000", 100, SortDirection.ASCENDING);
                th = null;
                while (query.step()) {
                    try {
                        UserNuxStatus a = UserNuxStatus.a(query.getBlob());
                        if (a == null) {
                            ((AbstractFbErrorReporter) interstitialConfigurationOmnistoreSubscriber.f9640g.get()).a("cannot convert flat buffer to interstitial", "Fetched an interstitial from omnistore colection whose all fields are not set");
                        } else {
                            FetchInterstitialResult a2 = interstitialConfigurationOmnistoreSubscriber.m10074a(a);
                            if (a2 != null) {
                                builder.c(a2);
                            }
                        }
                    } catch (Throwable th3) {
                        Throwable th4 = th3;
                        th3 = th2;
                        th2 = th4;
                    }
                }
                interstitialConfigurationOmnistoreSubscriber.f9636c.a(builder.b());
                if (query != null) {
                    query.close();
                }
            }
        }
        return;
        throw th2;
        if (query != null) {
            if (th3 != null) {
                try {
                    query.close();
                } catch (Throwable th5) {
                    AndroidCompat.addSuppressed(th3, th5);
                }
            } else {
                query.close();
            }
        }
        throw th2;
    }

    @Nullable
    private FetchInterstitialResult m10074a(UserNuxStatus userNuxStatus) {
        if (userNuxStatus.d() == 0) {
            return null;
        }
        String c;
        int a = userNuxStatus.m11443a(4);
        if (a != 0) {
            c = userNuxStatus.m11445c(a + userNuxStatus.f10990a);
        } else {
            c = null;
        }
        String str = c;
        a = userNuxStatus.m11443a(6);
        if (a != 0) {
            a = userNuxStatus.f10991b.getInt(a + userNuxStatus.f10990a);
        } else {
            a = 0;
        }
        int i = a;
        InterstitialRepository interstitialRepository = this.f9637d;
        a = userNuxStatus.m11443a(8);
        return new FetchInterstitialResult(i, str, interstitialRepository.a(a != 0 ? userNuxStatus.m11445c(a + userNuxStatus.f10990a) : null, str), userNuxStatus.d());
    }
}
