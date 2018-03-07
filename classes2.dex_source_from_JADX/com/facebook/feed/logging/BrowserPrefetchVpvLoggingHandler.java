package com.facebook.feed.logging;

import android.net.Uri;
import com.facebook.browser.prefetch.BrowserPrefetcher;
import com.facebook.common.util.FacebookUriUtil;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.graphql.enums.GraphQLBrowserPrefetchType;
import com.facebook.graphql.model.GraphQLFeedbackContext;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.graphql.model.GraphQLStoryAttachmentUtil;
import com.facebook.graphql.model.StoryAttachmentHelper;
import com.facebook.graphql.story.util.GraphQLStoryUtil;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import com.google.common.annotations.VisibleForTesting;
import java.util.HashMap;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: pre_reg_push_token_registration */
public class BrowserPrefetchVpvLoggingHandler {
    private static volatile BrowserPrefetchVpvLoggingHandler f9311c;
    public final Lazy<BrowserPrefetcher> f9312a;
    public final HashMap<String, Runnable> f9313b = new HashMap();

    public static com.facebook.feed.logging.BrowserPrefetchVpvLoggingHandler m14278a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f9311c;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.feed.logging.BrowserPrefetchVpvLoggingHandler.class;
        monitor-enter(r1);
        r0 = f9311c;	 Catch:{ all -> 0x003a }
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
        r0 = m14280b(r0);	 Catch:{ all -> 0x0035 }
        f9311c = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f9311c;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.feed.logging.BrowserPrefetchVpvLoggingHandler.a(com.facebook.inject.InjectorLike):com.facebook.feed.logging.BrowserPrefetchVpvLoggingHandler");
    }

    private static BrowserPrefetchVpvLoggingHandler m14280b(InjectorLike injectorLike) {
        return new BrowserPrefetchVpvLoggingHandler(IdBasedSingletonScopeProvider.m1810b(injectorLike, 418));
    }

    @Inject
    public BrowserPrefetchVpvLoggingHandler(Lazy<BrowserPrefetcher> lazy) {
        this.f9312a = lazy;
    }

    @Nullable
    @VisibleForTesting
    private static String m14279a(GraphQLStoryAttachment graphQLStoryAttachment) {
        Uri parse = Uri.parse(graphQLStoryAttachment.m23966C());
        if (parse == null || !FacebookUriUtil.m20916a(parse)) {
            return null;
        }
        parse = FacebookUriUtil.m20918b(parse);
        if (parse != null) {
            return parse.toString();
        }
        return null;
    }

    public final void m14281a(FeedProps<GraphQLStory> feedProps) {
        GraphQLStory graphQLStory = (GraphQLStory) feedProps.f13444a;
        GraphQLStoryAttachment o = StoryAttachmentHelper.m28042o(graphQLStory);
        if (o != null && GraphQLStoryAttachmentUtil.m28059j(o)) {
            String a = m14279a(o);
            if (a != null) {
                BrowserPrefetcher browserPrefetcher = (BrowserPrefetcher) this.f9312a.get();
                if (!GraphQLStoryUtil.m9567a((FeedProps) feedProps) || browserPrefetcher.m14304g()) {
                    Object obj;
                    if (browserPrefetcher.m14303d() && browserPrefetcher.m14302c() == 2) {
                        obj = null;
                    } else {
                        obj = 1;
                    }
                    if (obj != null) {
                        browserPrefetcher.m14300b(a);
                        GraphQLFeedbackContext aa = graphQLStory.aa();
                        if (aa != null) {
                            int p = browserPrefetcher.m14303d() ? aa.m24206p() : aa.m24202l();
                            if (p > 0) {
                                GraphQLBrowserPrefetchType graphQLBrowserPrefetchType;
                                GraphQLFeedbackContext aa2 = graphQLStory.aa();
                                if (aa2 == null) {
                                    graphQLBrowserPrefetchType = GraphQLBrowserPrefetchType.HTML_ONLY;
                                } else {
                                    graphQLBrowserPrefetchType = aa2.m24201k();
                                }
                                1 1 = new 1(this, browserPrefetcher, a, graphQLBrowserPrefetchType);
                                this.f9313b.put(graphQLStory.mo2507g(), 1);
                                HandlerDetour.b(browserPrefetcher.f9324j, 1, (long) p, -1803646903);
                            }
                        }
                    }
                }
            }
        }
    }
}
