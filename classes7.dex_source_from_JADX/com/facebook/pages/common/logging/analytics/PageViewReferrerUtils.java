package com.facebook.pages.common.logging.analytics;

import com.facebook.analytics.tagging.CurrentModuleHolder;
import com.facebook.inject.InjectorLike;
import com.facebook.ipc.pages.PageViewReferrer;
import com.google.common.collect.ImmutableMap;
import java.util.Map;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: media_router */
public class PageViewReferrerUtils {
    public static final Map<String, PageViewReferrer> f9107a = ImmutableMap.builder().b("native_newsfeed", PageViewReferrer.NEWSFEED).b("bookmarks", PageViewReferrer.BOOKMARK).b("story_view", PageViewReferrer.PERMALINK).b("newsfeed_attached_story_view", PageViewReferrer.PERMALINK).b("timeline", PageViewReferrer.USER_TIMELINE).b("story_feedback_flyout", PageViewReferrer.PERMALINK).b("pages_public_view", PageViewReferrer.PAGE).b("pages_posts_by_others_module_name", PageViewReferrer.PAGE).b("notifications", PageViewReferrer.NOTIFICATION).b("event_permalink", PageViewReferrer.EVENT).b("event_feed", PageViewReferrer.EVENT).b("group_feed", PageViewReferrer.GROUP).b("group_product_feed", PageViewReferrer.GROUP).b("graph_search_results_page", PageViewReferrer.SEARCH_RESULTS).b("graph_search_results_page_blended", PageViewReferrer.SEARCH_RESULTS).b("graph_search_results_page_page", PageViewReferrer.SEARCH_RESULTS).b("today", PageViewReferrer.TODAY).b("pages_launchpoint", PageViewReferrer.LAUNCH_POINT).b();
    private static volatile PageViewReferrerUtils f9108c;
    public final CurrentModuleHolder f9109b;

    public static com.facebook.pages.common.logging.analytics.PageViewReferrerUtils m10913a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f9108c;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.pages.common.logging.analytics.PageViewReferrerUtils.class;
        monitor-enter(r1);
        r0 = f9108c;	 Catch:{ all -> 0x003a }
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
        r0 = m10914b(r0);	 Catch:{ all -> 0x0035 }
        f9108c = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f9108c;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.pages.common.logging.analytics.PageViewReferrerUtils.a(com.facebook.inject.InjectorLike):com.facebook.pages.common.logging.analytics.PageViewReferrerUtils");
    }

    private static PageViewReferrerUtils m10914b(InjectorLike injectorLike) {
        return new PageViewReferrerUtils(CurrentModuleHolder.a(injectorLike));
    }

    @Inject
    public PageViewReferrerUtils(CurrentModuleHolder currentModuleHolder) {
        this.f9109b = currentModuleHolder;
    }
}
