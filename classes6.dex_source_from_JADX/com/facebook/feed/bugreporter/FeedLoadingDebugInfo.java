package com.facebook.feed.bugreporter;

import android.text.format.Time;
import com.facebook.api.feed.FetchFeedResult;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.inject.InjectorLike;
import javax.annotation.concurrent.ThreadSafe;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
@ThreadSafe
/* compiled from: nameForShareLink */
public class FeedLoadingDebugInfo {
    private static volatile FeedLoadingDebugInfo f10143b;
    public final AbstractFbErrorReporter f10144a;

    public static com.facebook.feed.bugreporter.FeedLoadingDebugInfo m15821a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f10143b;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.feed.bugreporter.FeedLoadingDebugInfo.class;
        monitor-enter(r1);
        r0 = f10143b;	 Catch:{ all -> 0x003a }
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
        r0 = m15822b(r0);	 Catch:{ all -> 0x0035 }
        f10143b = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f10143b;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.feed.bugreporter.FeedLoadingDebugInfo.a(com.facebook.inject.InjectorLike):com.facebook.feed.bugreporter.FeedLoadingDebugInfo");
    }

    private static FeedLoadingDebugInfo m15822b(InjectorLike injectorLike) {
        return new FeedLoadingDebugInfo((AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike));
    }

    @Inject
    public FeedLoadingDebugInfo(AbstractFbErrorReporter abstractFbErrorReporter) {
        this.f10144a = abstractFbErrorReporter;
    }

    public final void m15824a(FetchFeedResult fetchFeedResult) {
        this.f10144a.c("LastNewerLoadSuccess", m15823e(fetchFeedResult));
    }

    public final void m15825b(FetchFeedResult fetchFeedResult) {
        this.f10144a.c("LastNewerLoadEmpty", m15823e(fetchFeedResult));
    }

    public final void m15826c(FetchFeedResult fetchFeedResult) {
        this.f10144a.c("LastOlderLoadSuccess", m15823e(fetchFeedResult));
    }

    public final void m15827d(FetchFeedResult fetchFeedResult) {
        this.f10144a.c("LastOlderLoadEmpty", m15823e(fetchFeedResult));
    }

    private static String m15823e(FetchFeedResult fetchFeedResult) {
        Time time = new Time();
        time.set(fetchFeedResult.clientTimeMs);
        return "(" + time.format3339(false) + ") " + fetchFeedResult.toString();
    }
}
