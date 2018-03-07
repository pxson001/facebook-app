package com.facebook.search.logging.perf;

import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.perf.InteractionTTILogger;
import com.facebook.search.bootstrap.db.DbBootstrapPerformanceLogger;
import com.facebook.sequencelogger.SequenceLogger;
import com.facebook.sequencelogger.SequenceLoggerImpl;
import javax.annotation.concurrent.NotThreadSafe;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
@NotThreadSafe
/* compiled from: Take Survey */
public class SearchPerfLoggerImpl implements SearchPerfLogger {
    private static volatile SearchPerfLoggerImpl f22015f;
    private final SequenceLogger f22016a;
    private final InteractionTTILogger f22017b;
    private final SearchWaterfallLogger f22018c;
    private final Provider<DbBootstrapPerformanceLogger> f22019d;
    private final NullStatePerformanceLogger f22020e;

    public static com.facebook.search.logging.perf.SearchPerfLoggerImpl m25573a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f22015f;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.search.logging.perf.SearchPerfLoggerImpl.class;
        monitor-enter(r1);
        r0 = f22015f;	 Catch:{ all -> 0x003a }
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
        r0 = m25574b(r0);	 Catch:{ all -> 0x0035 }
        f22015f = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f22015f;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.search.logging.perf.SearchPerfLoggerImpl.a(com.facebook.inject.InjectorLike):com.facebook.search.logging.perf.SearchPerfLoggerImpl");
    }

    private static SearchPerfLoggerImpl m25574b(InjectorLike injectorLike) {
        return new SearchPerfLoggerImpl((SequenceLogger) SequenceLoggerImpl.a(injectorLike), InteractionTTILogger.a(injectorLike), SearchWaterfallLogger.m25591a(injectorLike), IdBasedSingletonScopeProvider.a(injectorLike, 10461), NullStatePerformanceLogger.a(injectorLike));
    }

    @Inject
    public SearchPerfLoggerImpl(SequenceLogger sequenceLogger, InteractionTTILogger interactionTTILogger, SearchWaterfallLogger searchWaterfallLogger, Provider<DbBootstrapPerformanceLogger> provider, NullStatePerformanceLogger nullStatePerformanceLogger) {
        this.f22016a = sequenceLogger;
        this.f22017b = interactionTTILogger;
        this.f22018c = searchWaterfallLogger;
        this.f22019d = provider;
        this.f22020e = nullStatePerformanceLogger;
    }

    public final void mo1204a() {
        this.f22017b.a("on_search_icon_click");
        this.f22018c.m25597a();
        ((DbBootstrapPerformanceLogger) this.f22019d.get()).a();
        this.f22020e.a();
    }

    public final void mo1205b() {
        this.f22020e.b();
    }

    public final void mo1206c() {
        this.f22020e.c();
    }

    public final void mo1207d() {
        this.f22020e.d();
    }

    public final void mo1208e() {
        this.f22020e.e();
    }

    public final void mo1209f() {
        this.f22020e.f();
        this.f22018c.m25599b();
        this.f22017b.b("SearchTypeahead");
    }

    public final void mo1210g() {
        this.f22018c.m25600c();
    }
}
