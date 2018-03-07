package com.facebook.composer.analytics;

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
/* compiled from: place_picker_minutiae_shown */
public class WithTagPerformanceLogger {
    public static final WithTagTTISequenceDefinition f7791a = new WithTagTTISequenceDefinition();
    private static volatile WithTagPerformanceLogger f7792c;
    public final SequenceLogger f7793b;

    /* compiled from: place_picker_minutiae_shown */
    public final class WithTagTTISequenceDefinition extends AbstractSequenceDefinition {
        public WithTagTTISequenceDefinition() {
            super(917507, "SuggestionsAppearanceSequence", false, ImmutableSet.of("com.facebook.composer.activity.ComposerFragment", "com.facebook.composer.activity.ComposerActivity", "com.facebook.tagging.conversion.FriendSuggestionsAndSelectorFragment", "com.facebook.tagging.conversion.FriendSuggestionsAndSelectorActivity"));
        }
    }

    public static com.facebook.composer.analytics.WithTagPerformanceLogger m11169a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f7792c;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.composer.analytics.WithTagPerformanceLogger.class;
        monitor-enter(r1);
        r0 = f7792c;	 Catch:{ all -> 0x003a }
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
        r0 = m11171b(r0);	 Catch:{ all -> 0x0035 }
        f7792c = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f7792c;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.composer.analytics.WithTagPerformanceLogger.a(com.facebook.inject.InjectorLike):com.facebook.composer.analytics.WithTagPerformanceLogger");
    }

    private static WithTagPerformanceLogger m11171b(InjectorLike injectorLike) {
        return new WithTagPerformanceLogger((SequenceLogger) SequenceLoggerImpl.a(injectorLike));
    }

    @Inject
    public WithTagPerformanceLogger(SequenceLogger sequenceLogger) {
        this.f7793b = sequenceLogger;
    }

    public final void m11173a() {
        this.f7793b.a(f7791a);
        m11170a("ComposerFragmentPausing");
    }

    public final void m11174b() {
        m11172c("ComposerFragmentPausing");
    }

    public final void m11175c() {
        String str = "WithTagPressed";
        Sequence e = this.f7793b.e(f7791a);
        if (e != null) {
            SequenceLoggerDetour.e(e, str, 221319357);
        }
    }

    public final void m11176d() {
        m11170a("FragmentInjection");
    }

    public final void m11177e() {
        m11172c("FragmentInjection");
    }

    public final void m11178f() {
        m11170a("CreateView");
    }

    public final void m11179g() {
        m11172c("CreateView");
    }

    public final void m11180h() {
        m11170a("QueryFriends");
    }

    public final void m11181i() {
        m11172c("QueryFriends");
    }

    public final void m11182k() {
        m11170a("UpdateContactList");
    }

    public final void m11183l() {
        m11172c("UpdateContactList");
    }

    public final void m11184m() {
        this.f7793b.b(f7791a);
    }

    private void m11170a(String str) {
        Sequence e = this.f7793b.e(f7791a);
        if (e != null) {
            SequenceLoggerDetour.a(e, str, 1332629233);
        }
    }

    private void m11172c(String str) {
        Sequence e = this.f7793b.e(f7791a);
        if (e != null) {
            SequenceLoggerDetour.b(e, str, 637525734);
        }
    }
}
