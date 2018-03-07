package com.facebook.feed.data.followup;

import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.util.CollectionUtil;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feedplugins.momentsupsell.MomentsUpsellImpressionHelper;
import com.facebook.feedplugins.momentsupsell.MomentsUpsellImpressionHelper.MediaListener;
import com.facebook.graphql.enums.GraphQLFollowUpFeedUnitActionType;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.graphql.model.GraphQLStoryAttachmentUtil;
import com.facebook.graphql.model.StoryAttachmentHelper;
import com.facebook.graphql.story.util.GraphQLStoryUtil;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.photos.mediafetcher.MediaFetcherFactory;
import com.facebook.photos.mediafetcher.interfaces.MediaFetcherConstructionRule;
import com.facebook.photos.mediafetcher.query.NodesMediaQueryProvider;
import com.facebook.photos.mediafetcher.query.param.MultiIdQueryParam;
import com.google.common.base.Optional;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import java.util.Collection;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: photo_upload_parallel */
public class FollowUpActionDecider {
    private static volatile FollowUpActionDecider f9944d;
    private final Lazy<FollowUpFeedUnitFetcher> f9945a;
    private final Lazy<GraphQLStoryUtil> f9946b;
    private final Lazy<MomentsUpsellImpressionHelper> f9947c;

    public static com.facebook.feed.data.followup.FollowUpActionDecider m14972a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f9944d;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.feed.data.followup.FollowUpActionDecider.class;
        monitor-enter(r1);
        r0 = f9944d;	 Catch:{ all -> 0x003a }
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
        r0 = m14973b(r0);	 Catch:{ all -> 0x0035 }
        f9944d = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f9944d;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.feed.data.followup.FollowUpActionDecider.a(com.facebook.inject.InjectorLike):com.facebook.feed.data.followup.FollowUpActionDecider");
    }

    private static FollowUpActionDecider m14973b(InjectorLike injectorLike) {
        return new FollowUpActionDecider(IdBasedLazy.m1808a(injectorLike, 5841), IdBasedSingletonScopeProvider.m1810b(injectorLike, 2198), IdBasedSingletonScopeProvider.m1810b(injectorLike, 1930));
    }

    @Inject
    public FollowUpActionDecider(Lazy<FollowUpFeedUnitFetcher> lazy, Lazy<GraphQLStoryUtil> lazy2, Lazy<MomentsUpsellImpressionHelper> lazy3) {
        this.f9945a = lazy;
        this.f9946b = lazy2;
        this.f9947c = lazy3;
    }

    public final void m14974a(FeedProps<GraphQLStory> feedProps, GraphQLFollowUpFeedUnitActionType graphQLFollowUpFeedUnitActionType, CallerContext callerContext) {
        GraphQLStory graphQLStory = (GraphQLStory) feedProps.f13444a;
        MomentsUpsellImpressionHelper momentsUpsellImpressionHelper = (MomentsUpsellImpressionHelper) this.f9947c.get();
        Collection a = Lists.m1296a();
        if (StoryAttachmentHelper.m28042o(graphQLStory) == null || !GraphQLStoryAttachmentUtil.m28053b(StoryAttachmentHelper.m28042o(graphQLStory)) || StoryAttachmentHelper.m28042o(graphQLStory).m23979r() == null) {
            if (!CollectionUtil.m29342a(StoryAttachmentHelper.m28036i(graphQLStory))) {
                for (GraphQLStoryAttachment graphQLStoryAttachment : StoryAttachmentHelper.m28036i(graphQLStory)) {
                    if (GraphQLStoryAttachmentUtil.m28053b(graphQLStoryAttachment)) {
                        a.add(graphQLStoryAttachment.m23979r().m24452b());
                    }
                }
            }
            if (graphQLStory != null) {
                this.f9946b.get();
                if (!GraphQLStoryUtil.m9582n(graphQLStory)) {
                    ((FollowUpFeedUnitFetcher) this.f9945a.get()).a(feedProps, graphQLFollowUpFeedUnitActionType, false, callerContext);
                }
            }
        }
        a.add(StoryAttachmentHelper.m28042o(graphQLStory).m23979r().m24452b());
        if (momentsUpsellImpressionHelper.f20301l != null) {
            momentsUpsellImpressionHelper.f20301l.b(momentsUpsellImpressionHelper.f20302m);
            momentsUpsellImpressionHelper.f20301l.c();
            momentsUpsellImpressionHelper.f20301l = null;
        }
        if (!a.isEmpty()) {
            momentsUpsellImpressionHelper.f20301l = ((MediaFetcherFactory) momentsUpsellImpressionHelper.f20292c.get()).m29268a(MediaFetcherConstructionRule.a(NodesMediaQueryProvider.class, new MultiIdQueryParam(ImmutableList.copyOf(a))), MomentsUpsellImpressionHelper.f20290b);
            momentsUpsellImpressionHelper.f20302m = new MediaListener(momentsUpsellImpressionHelper, graphQLStory, null);
            momentsUpsellImpressionHelper.f20301l.a(momentsUpsellImpressionHelper.f20302m);
            momentsUpsellImpressionHelper.f20301l.a(10, Optional.fromNullable(a.get(0)));
        }
        if (graphQLStory != null) {
            this.f9946b.get();
            if (!GraphQLStoryUtil.m9582n(graphQLStory)) {
                ((FollowUpFeedUnitFetcher) this.f9945a.get()).a(feedProps, graphQLFollowUpFeedUnitActionType, false, callerContext);
            }
        }
    }
}
