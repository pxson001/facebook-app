package com.facebook.universalfeedback.debug;

import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.uri.UriIntentBuilder;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
/* compiled from: education_reminder */
public class DebugUniversalFeedbackUriIntentBuilder extends UriIntentBuilder {
    public static final String f15359a = FBLinks.a("universal_feedback/?");
    public static final String f15360b = (f15359a + "feedback_id=%s");
    private static volatile DebugUniversalFeedbackUriIntentBuilder f15361d;
    private final Provider<Boolean> f15362c;

    public static com.facebook.universalfeedback.debug.DebugUniversalFeedbackUriIntentBuilder m19359a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f15361d;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.universalfeedback.debug.DebugUniversalFeedbackUriIntentBuilder.class;
        monitor-enter(r1);
        r0 = f15361d;	 Catch:{ all -> 0x003a }
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
        r0 = m19360b(r0);	 Catch:{ all -> 0x0035 }
        f15361d = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f15361d;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.universalfeedback.debug.DebugUniversalFeedbackUriIntentBuilder.a(com.facebook.inject.InjectorLike):com.facebook.universalfeedback.debug.DebugUniversalFeedbackUriIntentBuilder");
    }

    private static DebugUniversalFeedbackUriIntentBuilder m19360b(InjectorLike injectorLike) {
        return new DebugUniversalFeedbackUriIntentBuilder(IdBasedProvider.a(injectorLike, 4360));
    }

    @Inject
    public DebugUniversalFeedbackUriIntentBuilder(Provider<Boolean> provider) {
        this.f15362c = provider;
        a(StringFormatUtil.formatStrLocaleSafe(f15360b, StringFormatUtil.formatStrLocaleSafe("{%s %s}", "args_feedback_id", "UNKNOWN")), DebugUniversalFeedbackActivity.class);
    }

    protected final boolean m19361a() {
        return ((Boolean) this.f15362c.get()).booleanValue();
    }
}
