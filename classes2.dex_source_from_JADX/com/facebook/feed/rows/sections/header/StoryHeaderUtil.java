package com.facebook.feed.rows.sections.header;

import android.content.res.Resources;
import com.facebook.api.feedcache.memory.optimisticstory.OptimisticStoryStateCache;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.feed.rows.abtest.ExperimentsForMultipleRowsStoriesAbtestModule;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.core.props.StoryProps;
import com.facebook.feed.rows.sections.header.ui.MenuConfig;
import com.facebook.feed.rows.styling.BackgroundPartDefinition.StylingData;
import com.facebook.feed.rows.styling.BackgroundStyler$Position;
import com.facebook.feed.rows.styling.PaddingStyle;
import com.facebook.feed.ui.api.FeedMenuHelper;
import com.facebook.feed.util.story.FeedStoryUtil;
import com.facebook.graphql.enums.GraphQLFeedOptimisticPublishState;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.story.util.GraphQLStoryUtil;
import com.facebook.inject.InjectorLike;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: identitygrowth_save_profile_question */
public class StoryHeaderUtil {
    private static volatile StoryHeaderUtil f20586f;
    private final GraphQLStoryUtil f20587a;
    private final FeedStoryUtil f20588b;
    private final OptimisticStoryStateCache f20589c;
    private final QeAccessor f20590d;
    private final Resources f20591e;

    public static com.facebook.feed.rows.sections.header.StoryHeaderUtil m28330a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f20586f;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.feed.rows.sections.header.StoryHeaderUtil.class;
        monitor-enter(r1);
        r0 = f20586f;	 Catch:{ all -> 0x003a }
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
        r0 = m28331b(r0);	 Catch:{ all -> 0x0035 }
        f20586f = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f20586f;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.feed.rows.sections.header.StoryHeaderUtil.a(com.facebook.inject.InjectorLike):com.facebook.feed.rows.sections.header.StoryHeaderUtil");
    }

    private static StoryHeaderUtil m28331b(InjectorLike injectorLike) {
        return new StoryHeaderUtil(GraphQLStoryUtil.m9565a(injectorLike), FeedStoryUtil.m18578a(injectorLike), OptimisticStoryStateCache.m9726a(injectorLike), ResourcesMethodAutoProvider.m6510a(injectorLike), QeInternalImplMethodAutoProvider.m3744a(injectorLike));
    }

    @Inject
    public StoryHeaderUtil(GraphQLStoryUtil graphQLStoryUtil, FeedStoryUtil feedStoryUtil, OptimisticStoryStateCache optimisticStoryStateCache, Resources resources, QeAccessor qeAccessor) {
        this.f20587a = graphQLStoryUtil;
        this.f20588b = feedStoryUtil;
        this.f20589c = optimisticStoryStateCache;
        this.f20591e = resources;
        this.f20590d = qeAccessor;
    }

    public final StylingData m28334a(FeedProps<GraphQLStory> feedProps) {
        PaddingStyle paddingStyle = (this.f20587a.m9600i(feedProps) > 0 ? 1 : null) != null ? PaddingStyle.f13081k : PaddingStyle.f13079i;
        BackgroundStyler$Position backgroundStyler$Position = (GraphQLStoryUtil.m9578j((FeedProps) feedProps) && this.f20587a.m9599h(StoryProps.m27455b(feedProps))) ? BackgroundStyler$Position.TOP : null;
        return new StylingData(feedProps, paddingStyle, backgroundStyler$Position);
    }

    private boolean m28332d(FeedProps<GraphQLStory> feedProps) {
        return this.f20587a.m9602m((FeedProps) feedProps) > 0 && this.f20590d.mo596a(ExperimentsForMultipleRowsStoriesAbtestModule.f6724n, false);
    }

    public final int m28335b(FeedProps<GraphQLStory> feedProps) {
        return m28332d(feedProps) ? this.f20591e.getDimensionPixelSize(2131430367) : this.f20591e.getDimensionPixelSize(2131427598);
    }

    public final int m28336c(FeedProps<GraphQLStory> feedProps) {
        return m28332d(feedProps) ? this.f20591e.getDimensionPixelSize(2131430366) : this.f20591e.getDimensionPixelSize(2131427599);
    }

    public final MenuConfig m28333a(FeedProps<GraphQLStory> feedProps, @Nullable FeedMenuHelper feedMenuHelper) {
        if (!this.f20588b.m18588a(feedProps, feedProps, feedMenuHelper, false)) {
            return MenuConfig.HIDDEN;
        }
        GraphQLFeedOptimisticPublishState a = this.f20589c.m9728a((GraphQLStory) feedProps.f13444a);
        Object obj = (a == GraphQLFeedOptimisticPublishState.POSTING || a == GraphQLFeedOptimisticPublishState.FAILED) ? null : 1;
        return obj != null ? MenuConfig.CLICKABLE : MenuConfig.VISIBLE;
    }
}
