package com.facebook.goodwill.analytics;

import com.facebook.inject.InjectorLike;
import com.facebook.sequencelogger.AbstractSequenceDefinition;
import com.facebook.sequencelogger.Sequence;
import com.facebook.sequencelogger.SequenceLogger;
import com.facebook.sequencelogger.SequenceLoggerImpl;
import com.facebook.tools.dextr.runtime.detour.SequenceLoggerDetour;
import com.google.common.collect.ImmutableSet;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: {review_id} */
public class GoodwillPerformanceLogger {
    public static final ThrowbackFeedTTISequenceDefinition f39a = new ThrowbackFeedTTISequenceDefinition();
    private static volatile GoodwillPerformanceLogger f40c;
    public final SequenceLogger f41b;

    /* compiled from: {review_id} */
    public final class ThrowbackFeedTTISequenceDefinition extends AbstractSequenceDefinition {
        public ThrowbackFeedTTISequenceDefinition() {
            super(4915201, "ThrowbackFeedTTI", false, ImmutableSet.of("com.facebook.goodwill.throwback.feed.ui.ThrowbackFeedFragment"));
        }
    }

    public static com.facebook.goodwill.analytics.GoodwillPerformanceLogger m29a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f40c;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.goodwill.analytics.GoodwillPerformanceLogger.class;
        monitor-enter(r1);
        r0 = f40c;	 Catch:{ all -> 0x003a }
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
        r0 = m30b(r0);	 Catch:{ all -> 0x0035 }
        f40c = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f40c;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.goodwill.analytics.GoodwillPerformanceLogger.a(com.facebook.inject.InjectorLike):com.facebook.goodwill.analytics.GoodwillPerformanceLogger");
    }

    private static GoodwillPerformanceLogger m30b(InjectorLike injectorLike) {
        return new GoodwillPerformanceLogger((SequenceLogger) SequenceLoggerImpl.a(injectorLike));
    }

    @Inject
    public GoodwillPerformanceLogger(SequenceLogger sequenceLogger) {
        this.f41b = sequenceLogger;
    }

    public final void m31b() {
        Sequence e = this.f41b.e(f39a);
        if (e != null) {
            SequenceLoggerDetour.a(SequenceLoggerDetour.b(e, "ThrowbackFeedViewCreation", -1484900569), "ThrowbackFeedDataFetch", -2067646427);
        }
    }

    public final void m32c() {
        Sequence e = this.f41b.e(f39a);
        if (e != null) {
            SequenceLoggerDetour.b(e, "ThrowbackFeedDataFetch", -897483427);
        }
        this.f41b.b(f39a);
    }
}
