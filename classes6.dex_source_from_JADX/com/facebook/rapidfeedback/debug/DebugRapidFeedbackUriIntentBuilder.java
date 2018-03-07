package com.facebook.rapidfeedback.debug;

import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.uri.UriIntentBuilder;
import com.facebook.common.uri.UriMapPattern;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
@UriMapPattern
/* compiled from: failed copy image to gallery */
public class DebugRapidFeedbackUriIntentBuilder extends UriIntentBuilder {
    public static final String f15397a = FBLinks.a("rapid_feedback_survey/?");
    public static final String f15398b = (f15397a + "survey_id=%s&" + "integration_point_id=%s");
    private static volatile DebugRapidFeedbackUriIntentBuilder f15399d;
    private final Provider<Boolean> f15400c;

    public static com.facebook.rapidfeedback.debug.DebugRapidFeedbackUriIntentBuilder m23009a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f15399d;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.rapidfeedback.debug.DebugRapidFeedbackUriIntentBuilder.class;
        monitor-enter(r1);
        r0 = f15399d;	 Catch:{ all -> 0x003a }
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
        r0 = m23010b(r0);	 Catch:{ all -> 0x0035 }
        f15399d = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f15399d;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.rapidfeedback.debug.DebugRapidFeedbackUriIntentBuilder.a(com.facebook.inject.InjectorLike):com.facebook.rapidfeedback.debug.DebugRapidFeedbackUriIntentBuilder");
    }

    private static DebugRapidFeedbackUriIntentBuilder m23010b(InjectorLike injectorLike) {
        return new DebugRapidFeedbackUriIntentBuilder(IdBasedProvider.a(injectorLike, 4297));
    }

    @Inject
    public DebugRapidFeedbackUriIntentBuilder(Provider<Boolean> provider) {
        this.f15400c = provider;
        a(StringFormatUtil.formatStrLocaleSafe(f15398b, m23011b("args_survey_id", "UNKNOWN"), m23011b("args_integration_point_id", "UNKNOWN")), DebugRapidFeedbackActivity.class);
    }

    protected final boolean m23012a() {
        return ((Boolean) this.f15400c.get()).booleanValue();
    }

    private static String m23011b(String str, String str2) {
        return StringFormatUtil.formatStrLocaleSafe("{%s %s}", str, str2);
    }
}
