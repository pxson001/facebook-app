package com.facebook.feed.analytics;

import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.random.Random_InsecureRandomMethodAutoProvider;
import com.facebook.components.feed.api.ComponentPart;
import com.facebook.feed.analytics.abtest.ExperimentsForFeedAnalyticsModule;
import com.facebook.feed.environment.HasFeedListType;
import com.facebook.feed.rows.core.analytics.HasIsAsync;
import com.facebook.feed.rows.core.analytics.MultiRowPerfLogger;
import com.facebook.inject.InjectorLike;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.MultiRowPartWithIsNeeded;
import com.facebook.proxygen.HTTPTransportCallback;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.quicklog.QuickPerformanceLogger;
import com.facebook.quicklog.module.QuickPerformanceLoggerMethodAutoProvider;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Throwables;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;
import javax.annotation.concurrent.NotThreadSafe;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
@NotThreadSafe
/* compiled from: performanceLoggingEvent/mObservers cannot be null. */
public class MultiRowPerfLoggerImpl implements MultiRowPerfLogger {
    private static final String f10206a = MultiRowPerfLogger.class.getSimpleName();
    private static volatile MultiRowPerfLoggerImpl f10207i;
    public final int f10208b;
    public final int f10209c;
    private final String f10210d;
    private final boolean[] f10211e = new boolean[8];
    public final QuickPerformanceLogger f10212f;
    public final Random f10213g;
    private final AbstractFbErrorReporter f10214h;

    public static com.facebook.feed.analytics.MultiRowPerfLoggerImpl m15290a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f10207i;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.feed.analytics.MultiRowPerfLoggerImpl.class;
        monitor-enter(r1);
        r0 = f10207i;	 Catch:{ all -> 0x003a }
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
        r0 = m15294b(r0);	 Catch:{ all -> 0x0035 }
        f10207i = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f10207i;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.feed.analytics.MultiRowPerfLoggerImpl.a(com.facebook.inject.InjectorLike):com.facebook.feed.analytics.MultiRowPerfLoggerImpl");
    }

    private static MultiRowPerfLoggerImpl m15294b(InjectorLike injectorLike) {
        return new MultiRowPerfLoggerImpl(QuickPerformanceLoggerMethodAutoProvider.m2859a(injectorLike), FbErrorReporterImpl.m2317a(injectorLike), Random_InsecureRandomMethodAutoProvider.m2102a(injectorLike), QeInternalImplMethodAutoProvider.m3744a(injectorLike));
    }

    @Inject
    public MultiRowPerfLoggerImpl(QuickPerformanceLogger quickPerformanceLogger, AbstractFbErrorReporter abstractFbErrorReporter, Random random, QeAccessor qeAccessor) {
        this.f10212f = quickPerformanceLogger;
        this.f10214h = abstractFbErrorReporter;
        this.f10213g = random;
        this.f10208b = qeAccessor.mo572a(ExperimentsForFeedAnalyticsModule.f10216b, 0);
        this.f10209c = qeAccessor.mo572a(ExperimentsForFeedAnalyticsModule.f10215a, 0);
        this.f10210d = Integer.toString(this.f10209c);
        this.f10212f.mo463b(655502, this.f10208b);
        this.f10212f.mo463b(655504, this.f10208b);
        this.f10212f.mo463b(655505, this.f10208b);
        this.f10212f.mo463b(655506, this.f10208b);
    }

    public final void mo1983a(MultiRowPartWithIsNeeded multiRowPartWithIsNeeded, int i) {
        Object obj = null;
        if (this.f10209c != 0) {
            int i2;
            if (this.f10209c == 1) {
                i2 = 1;
            } else if (this.f10213g.nextInt(this.f10209c) == 0) {
                i2 = 1;
            }
        }
        if (obj != null) {
            this.f10211e[i] = true;
            int b = m15293b(i);
            this.f10212f.mo462b(b);
            if (this.f10212f.mo480f(b)) {
                this.f10212f.mo448a(b, multiRowPartWithIsNeeded.getClass().getName());
                this.f10212f.mo467b(b, "internal_sample_rate", this.f10210d);
                if (i == 1) {
                    this.f10212f.mo467b(655504, "is_component_pd", Boolean.toString(multiRowPartWithIsNeeded instanceof ComponentPart));
                }
            }
        }
    }

    public final void mo1980a(int i) {
        if (this.f10211e[i]) {
            this.f10212f.mo468b(m15293b(i), (short) 2);
            this.f10211e[i] = false;
        }
    }

    public final void mo1981a(int i, AnyEnvironment anyEnvironment) {
        if (this.f10211e[i]) {
            if (anyEnvironment instanceof HasIsAsync) {
                m15292a(i, (HasIsAsync) anyEnvironment);
            }
            if (anyEnvironment instanceof HasFeedListType) {
                m15291a(i, (HasFeedListType) anyEnvironment);
            }
        }
    }

    public final void mo1982a(int i, Callable<List<String>> callable) {
        if (this.f10211e[i]) {
            try {
                this.f10212f.mo467b(m15293b(i), "pd_parents", ((List) callable.call()).toString());
            } catch (Throwable e) {
                throw Throwables.propagate(e);
            }
        }
    }

    @VisibleForTesting
    private void m15292a(int i, HasIsAsync hasIsAsync) {
        this.f10212f.mo467b(m15293b(i), "is_async", hasIsAsync.hM_() ? "true" : "false");
    }

    @VisibleForTesting
    private void m15291a(int i, HasFeedListType hasFeedListType) {
        this.f10212f.mo467b(m15293b(i), "feed_type", AnalyticsHelper.m28995a(hasFeedListType.mo2446c()));
    }

    private int m15293b(int i) {
        switch (i) {
            case 0:
                return 655502;
            case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                return 655504;
            case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
                return 655505;
            case 3:
                return 655506;
            case HTTPTransportCallback.LAST_BODY_BYTE_FLUSHED /*4*/:
                return 655511;
            case 5:
                return 655512;
            case 6:
                return 655513;
            case 7:
                return 655514;
            default:
                this.f10214h.m2340a(f10206a, "Invalid internal markerId");
                return 655502;
        }
    }
}
