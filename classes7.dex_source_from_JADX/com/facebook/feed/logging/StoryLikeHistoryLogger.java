package com.facebook.feed.logging;

import com.facebook.bugreporter.BugReportExtraDataMapProvider;
import com.facebook.common.diagnostics.TraceLogger;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.time.AwakeTimeSinceBootClockMethodAutoProvider;
import com.facebook.common.time.MonotonicClock;
import com.facebook.inject.InjectorLike;
import com.facebook.reportaproblem.base.bugreport.file.BugReportBackgroundDataProvider;
import com.google.common.collect.ImmutableMap;
import java.util.Map;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: android.intent.action.DIAL */
public class StoryLikeHistoryLogger implements BugReportExtraDataMapProvider, BugReportBackgroundDataProvider {
    private static volatile StoryLikeHistoryLogger f19362c;
    private final MonotonicClock f19363a;
    private final TraceLogger f19364b = new TraceLogger(Integer.MAX_VALUE, 60);

    /* compiled from: android.intent.action.DIAL */
    public enum Type {
        CLICK,
        EVENT,
        SUCCESS,
        FAILURE,
        INVALID,
        NO_MATCH,
        ATTEMPT
    }

    public static com.facebook.feed.logging.StoryLikeHistoryLogger m22799a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f19362c;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.feed.logging.StoryLikeHistoryLogger.class;
        monitor-enter(r1);
        r0 = f19362c;	 Catch:{ all -> 0x003a }
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
        r0 = m22800b(r0);	 Catch:{ all -> 0x0035 }
        f19362c = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f19362c;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.feed.logging.StoryLikeHistoryLogger.a(com.facebook.inject.InjectorLike):com.facebook.feed.logging.StoryLikeHistoryLogger");
    }

    private static StoryLikeHistoryLogger m22800b(InjectorLike injectorLike) {
        return new StoryLikeHistoryLogger((MonotonicClock) AwakeTimeSinceBootClockMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public StoryLikeHistoryLogger(MonotonicClock monotonicClock) {
        this.f19363a = monotonicClock;
    }

    public final void m22801a(String str, Object obj, boolean z, @Nullable String str2, Type type) {
        this.f19364b.a(StringFormatUtil.a("{'%s', '%s', '%s', '%s', '%s', '%s'}", new Object[]{Long.valueOf(this.f19363a.now()), str, Boolean.valueOf(z), obj, str2, type}));
    }

    public final Map<String, String> m22802b() {
        return m22804d();
    }

    public final Map<String, String> m22803c() {
        return null;
    }

    public final Map<String, String> m22804d() {
        return ImmutableMap.builder().b("story_like_history", this.f19364b.toString()).b();
    }
}
