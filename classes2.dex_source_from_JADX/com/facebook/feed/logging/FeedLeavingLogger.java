package com.facebook.feed.logging;

import android.util.Pair;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.HoneyAnalyticsEvent;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.api.feed.data.collections.ListItemCollection;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.core.props.StoryProps;
import com.facebook.feed.rows.core.props.TrackableFeedProps;
import com.facebook.feed.util.unit.FeedUnitHelper;
import com.facebook.graphql.model.FeedEdge;
import com.facebook.graphql.model.FeedUnit;
import com.facebook.graphql.model.GraphQLFeedUnitEdge;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.StoryAttachmentHelper;
import com.facebook.graphql.model.StoryHierarchyHelper;
import com.facebook.inject.InjectorLike;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: pokes */
public class FeedLeavingLogger {
    private static volatile FeedLeavingLogger f9517c;
    public ViewportLoggingHelper f9518a;
    private final AnalyticsLogger f9519b;

    public static com.facebook.feed.logging.FeedLeavingLogger m14504a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f9517c;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.feed.logging.FeedLeavingLogger.class;
        monitor-enter(r1);
        r0 = f9517c;	 Catch:{ all -> 0x003a }
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
        r0 = m14506b(r0);	 Catch:{ all -> 0x0035 }
        f9517c = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f9517c;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.feed.logging.FeedLeavingLogger.a(com.facebook.inject.InjectorLike):com.facebook.feed.logging.FeedLeavingLogger");
    }

    private static FeedLeavingLogger m14506b(InjectorLike injectorLike) {
        return new FeedLeavingLogger(ViewportLoggingHelper.m14168a(injectorLike), AnalyticsLoggerMethodAutoProvider.m3509a(injectorLike));
    }

    @Inject
    public FeedLeavingLogger(ViewportLoggingHelper viewportLoggingHelper, AnalyticsLogger analyticsLogger) {
        this.f9518a = viewportLoggingHelper;
        this.f9519b = analyticsLogger;
    }

    public final void m14508a(ListItemCollection<FeedEdge> listItemCollection, int i, boolean z) {
        HoneyAnalyticsEvent honeyClientEvent = new HoneyClientEvent("feed_user_left_app");
        m14507b(listItemCollection, honeyClientEvent, i, z);
        this.f9519b.mo526a(honeyClientEvent);
    }

    private Pair<Integer, Integer> m14503a(int i, int i2, ListItemCollection listItemCollection) {
        int i3 = 0;
        int i4 = i < i2 ? 1 : -1;
        int i5 = 0;
        int i6 = 0;
        while (i != i2) {
            boolean z;
            int i7;
            FeedUnit a = FeedUnitHelper.m21141a((GraphQLFeedUnitEdge) listItemCollection.mo1375a(i));
            if (a == null) {
                z = true;
            } else {
                z = this.f9518a.m14172b(a);
            }
            if (z) {
                i6 = 1;
                i7 = i5;
                i5 = i3;
                i3 = i7;
            } else {
                if (i6 == 0) {
                    i5++;
                }
                i7 = i3 + 1;
                i3 = i5;
                i5 = i7;
            }
            i += i4;
            i7 = i5;
            i5 = i3;
            i3 = i7;
        }
        return Pair.create(Integer.valueOf(i5), Integer.valueOf(i3));
    }

    private void m14505a(ListItemCollection<FeedEdge> listItemCollection, HoneyClientEvent honeyClientEvent, int i, boolean z) {
        if (i < listItemCollection.mo1374a()) {
            Pair a = m14503a(i, -1, (ListItemCollection) listItemCollection);
            Pair a2 = m14503a(i, listItemCollection.mo1374a(), (ListItemCollection) listItemCollection);
            honeyClientEvent.m5083a("current_position", i).m5083a("user_left_app", z ? 1 : 0).m5086a("closest_unseen_stories_above", a.first).m5086a("closest_unseen_stories_below", a2.first).m5086a("total_unseen_stories_above", a.second).m5086a("total_unseen_stories_below", a2.second).m5083a("total_stories_below", listItemCollection.mo1374a() - i);
        }
    }

    private void m14507b(ListItemCollection<FeedEdge> listItemCollection, HoneyClientEvent honeyClientEvent, int i, boolean z) {
        m14505a(listItemCollection, honeyClientEvent, i, z);
        String str = "unknown_story";
        if (i < listItemCollection.mo1374a()) {
            GraphQLFeedUnitEdge graphQLFeedUnitEdge = (GraphQLFeedUnitEdge) listItemCollection.mo1375a(i);
            if (graphQLFeedUnitEdge.mo2540c() instanceof GraphQLStory) {
                GraphQLStory graphQLStory = (GraphQLStory) graphQLFeedUnitEdge.mo2540c();
                if (StoryHierarchyHelper.m27438e(graphQLStory)) {
                    str = "edge_story";
                } else if (StoryAttachmentHelper.m28046s(graphQLStory)) {
                    str = "neko_ad";
                } else if (StoryProps.m27466p(FeedProps.m19802c(graphQLStory))) {
                    str = "sponsored_context";
                } else if (StoryAttachmentHelper.m28030b(graphQLStory)) {
                    str = "photo_story";
                } else if (StoryAttachmentHelper.m28037j(graphQLStory)) {
                    str = "video_story";
                } else if (StoryAttachmentHelper.m28034g(graphQLStory)) {
                    str = "external_url_attached_story";
                } else if (StoryHierarchyHelper.m27437d(graphQLStory)) {
                    str = "aggregated_story";
                } else {
                    str = "simple_story";
                }
                honeyClientEvent.m5090b("tracking_data", TrackableFeedProps.m27451a(FeedProps.m19802c(graphQLStory)).toString());
            }
            honeyClientEvent.m5090b("story_type", str);
        }
        honeyClientEvent.f3099c = "native_newsfeed";
    }
}
