package com.facebook.feed.logging.bugreport;

import android.support.v4.app.Fragment;
import com.facebook.bugreporter.BugReportExtraDataMapProvider;
import com.facebook.common.diagnostics.TraceLogger;
import com.facebook.common.errorreporting.FbCustomReportDataSupplier;
import com.facebook.reportaproblem.base.bugreport.file.BugReportBackgroundDataProvider;
import com.google.common.collect.ImmutableMap;
import java.util.Map;
import javax.inject.Singleton;

@Singleton
/* compiled from: trigger */
public class NewsFeedEventLogger implements BugReportExtraDataMapProvider, FbCustomReportDataSupplier, BugReportBackgroundDataProvider {
    private static volatile NewsFeedEventLogger f2247c;
    private TraceLogger f2248a = new TraceLogger(Integer.MAX_VALUE, 100);
    private StringBuilder f2249b = new StringBuilder();

    /* compiled from: trigger */
    public enum FreshFeedEvent {
        INITIALIZED,
        NOT_INITIALIZED,
        LOAD_NEW_DATA_FROM_NETWORK,
        LOAD_MORE_DATA_FROM_NETWORK,
        LOAD_DATA_FROM_CACHE,
        END_OF_FEED,
        STORIES_FOR_FEED,
        STORIES_FOR_UI,
        STORIES_READ_FROM_DB,
        NETWORK_ERROR,
        NETWORK_SUCCESS,
        NETWORK_NEXT,
        START_NEW_SESSION,
        FETCH_FRESH_STORIES,
        EMPTY_COLLECTION
    }

    /* compiled from: trigger */
    public enum Event {
        FRAGMENT_CREATED,
        FRAGMENT_RESUMED,
        VIEW_CREATED,
        GOT_PERSISTED_DATA_LOADER,
        GOT_TRANSIENT_DATA_LOADER,
        RELEASED_LOADER,
        FRAGMENT_DESTROYED,
        VIEW_DESTROYED,
        REACHED_TOP,
        HEAD_FETCH,
        HEAD_FETCH_CANCELED,
        HEAD_FETCH_FAILED,
        HEAD_FETCH_SUCCEED,
        HEAD_FETCH_CHUNKED_SUCCEED,
        HEAD_FETCH_ALREADY_HAPPENING,
        TAIL_FETCH,
        TAIL_FETCH_CANCELED,
        TAIL_FETCH_FAILED,
        TAIL_FETCH_SUCCEED,
        TAIL_FETCH_BACKGROUND_SUCCEED,
        TAIL_FETCH_SKIP_GAP_SCHEDULED,
        TAIL_FETCH_SKIP_FINISHED_WITH_RESULTS,
        TAIL_FETCH_SKIP_FINISHED_WITH_NO_RESULTS,
        DATA_LOADED,
        STATUS_CHANGED,
        COLD_START_RERANKING_START,
        COLD_START_RERANKING_COMPLETE,
        PTR_RERANKING_SCHEDULED,
        PTR_RERANKING_COMPLETE,
        PTR_RERANKING_NO_RESULTS,
        PTR_RERANKING_FAILURE,
        NO_NETWORK_DATA_PTR_RERANKING_START,
        ON_FAILURE_PTR_RERANKING_START,
        WARM_START_RERANKING_START,
        WARM_START_RERANKING_COMPLETE,
        NEW_STORY_PILL_SHOWN,
        NEW_STORY_PILL_TAPPED,
        NEW_STORY_PILL_HIDDEN,
        LOADING_INDICATOR_SHOWN,
        LOADING_INDICATOR_HIDDEN,
        SKIP_TAIL_GAP_FUTURE_CLEARED,
        SWIPE_LAYOUT_NULL
    }

    public static com.facebook.feed.logging.bugreport.NewsFeedEventLogger m4405a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find immediate dominator for block B:24:0x003a in {17, 19, 21, 23, 26, 28} preds:[]
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
        r0 = f2247c;
        if (r0 != 0) goto L_0x0031;
    L_0x0004:
        r1 = com.facebook.feed.logging.bugreport.NewsFeedEventLogger.class;
        monitor-enter(r1);
        r0 = f2247c;	 Catch:{ all -> 0x0039 }
        if (r0 != 0) goto L_0x0030;	 Catch:{ all -> 0x0039 }
    L_0x000b:
        if (r5 == 0) goto L_0x0030;	 Catch:{ all -> 0x0039 }
    L_0x000d:
        r2 = com.facebook.inject.ScopeSet.m1499a();	 Catch:{ all -> 0x0039 }
        r3 = r2.m1503b();	 Catch:{ all -> 0x0039 }
        r0 = com.facebook.inject.SingletonScope.class;	 Catch:{ all -> 0x0039 }
        r0 = r5.getInstance(r0);	 Catch:{ all -> 0x0039 }
        r0 = (com.facebook.inject.SingletonScope) r0;	 Catch:{ all -> 0x0039 }
        r4 = r0.enterScope();	 Catch:{ all -> 0x0039 }
        r5.getApplicationInjector();	 Catch:{ all -> 0x0034 }
        r0 = m4406e();	 Catch:{ all -> 0x0034 }
        f2247c = r0;	 Catch:{ all -> 0x0034 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0030:
        monitor-exit(r1);	 Catch:{  }
    L_0x0031:
        r0 = f2247c;
        return r0;
    L_0x0034:
        r0 = move-exception;
        com.facebook.inject.SingletonScope.m1338a(r4);	 Catch:{ all -> 0x0034 }
        throw r0;	 Catch:{ all -> 0x0034 }
    L_0x0039:
        r0 = move-exception;
        r2.m1505c(r3);	 Catch:{ all -> 0x0039 }
        throw r0;	 Catch:{ all -> 0x0039 }
    L_0x003e:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x0039 }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.feed.logging.bugreport.NewsFeedEventLogger.a(com.facebook.inject.InjectorLike):com.facebook.feed.logging.bugreport.NewsFeedEventLogger");
    }

    private static NewsFeedEventLogger m4406e() {
        return new NewsFeedEventLogger();
    }

    public final Map<String, String> mo639b() {
        return mo641d();
    }

    public final Map<String, String> mo640c() {
        return null;
    }

    public final Map<String, String> mo641d() {
        return ImmutableMap.builder().m609b("news_feed_events", this.f2248a.toString()).m610b();
    }

    public final void m4410a(String str, Event event) {
        m4411a(str, event, "");
    }

    public final void m4411a(String str, Event event, String str2) {
        m4415a(str, event.name(), str2);
    }

    public final void m4415a(String str, String str2, String str3) {
        this.f2249b.setLength(0);
        this.f2249b.append("[" + str + "] ").append(str2).append(", ").append(str3);
        this.f2248a.m4284a(this.f2249b.toString());
    }

    public final void m4414a(String str, String str2) {
        m4415a(str, str2, "");
    }

    public final void m4412a(String str, FreshFeedEvent freshFeedEvent) {
        m4415a(str, freshFeedEvent.name(), "");
    }

    public final void m4413a(String str, FreshFeedEvent freshFeedEvent, String str2) {
        m4415a(str, freshFeedEvent.name(), str2);
    }

    public final void m4409a(Fragment fragment, Event event) {
        m4415a("NewsFeedFragment (" + fragment.f104H + ")", event.name(), "");
    }

    public final String mo633a(Throwable th) {
        if (th instanceof IllegalStateException) {
            return this.f2248a.toString();
        }
        return null;
    }

    public final String mo632a() {
        return "news_feed_events";
    }
}
