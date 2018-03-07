package com.facebook.video.channelfeed;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.autoplay.CenterDistanceVideoDisplaySelector;
import com.facebook.feed.autoplay.HasVideoAutoplay;
import com.facebook.feed.autoplay.VideoDisplayedCoordinator;
import com.facebook.feed.autoplay.VideoDisplayedCoordinatorProvider;
import com.facebook.feed.environment.CanFeedback;
import com.facebook.feed.environment.CanShowVideoInFullScreen;
import com.facebook.feed.environment.HasContext;
import com.facebook.feed.environment.HasFeedListType;
import com.facebook.feed.environment.HasInvalidate;
import com.facebook.feed.environment.HasMenuButtonProvider;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.environment.HasPrefetcher;
import com.facebook.feed.environment.HasRowKey;
import com.facebook.feed.rows.core.parts.SubPartsSelector;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.core.props.StoryProps;
import com.facebook.feed.rows.core.traversal.GroupPartHolder;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.graphql.model.GraphQLVideo;
import com.facebook.graphql.model.StoryAttachmentHelper;
import com.facebook.graphql.model.conversion.GraphQLMediaConversionHelper;
import com.facebook.graphql.story.util.GraphQLStoryUtil;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.BaseMultiRowSubParts;
import com.facebook.multirow.api.MultiRowGroupPartDefinition;
import com.facebook.multirow.api.MultiRowSubParts;
import com.facebook.video.channelfeed.ChannelFeedVideoPartDefinition.Props;
import com.facebook.video.channelfeed.abtest.ChannelFeedConfig;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList.Builder;
import javax.annotation.Nullable;
import javax.inject.Inject;

@ContextScoped
/* compiled from: target_spec_extra */
public class ChannelFeedGroupPartDefinition<E extends HasContext & HasFeedListType & HasFullscreenPlayer & HasInvalidate & HasMenuButtonProvider & HasPersistentState & HasPlayerOrigin & HasPositionInformation & HasPrefetcher & HasRowKey & HasVideoAutoplay<ChannelFeedVideoAttachmentView> & CanFeedback & CanReusePlayer & CanShowVideoInFullScreen & HasSinglePublisherChannelInfo> implements MultiRowGroupPartDefinition<FeedProps<GraphQLStory>, ChannelFeedDimmingController, E> {
    private static ChannelFeedGroupPartDefinition f2233m;
    private static final Object f2234n = new Object();
    public final ChannelFeedSocialContextHeaderPartDefinition f2235a;
    private final ChannelFeedHeaderPartDefinition<E> f2236b;
    private final ChannelFeedReuseVideoPartDefinition<E> f2237c;
    private final ChannelFeedVideoPartDefinition f2238d;
    private final ChannelFeedTextPartDefinition<E> f2239e;
    private final ChannelFeedVideoPlaysBlingBarPartSelector f2240f;
    private final ChannelFeedBlingBarPartDefinition<E> f2241g;
    private final ChannelFeedFooterPartSelector<E> f2242h;
    private final VideoDisplayedCoordinator<ChannelFeedVideoAttachmentView> f2243i;
    private final ChannelFeedStoryKeyProvider f2244j;
    private final GraphQLStoryUtil f2245k;
    private final ChannelFeedConfig f2246l;

    private static ChannelFeedGroupPartDefinition m2253b(InjectorLike injectorLike) {
        return new ChannelFeedGroupPartDefinition(ChannelFeedSocialContextHeaderPartDefinition.m2415a(injectorLike), ChannelFeedHeaderPartDefinition.m2269a(injectorLike), ChannelFeedReuseVideoPartDefinition.m2342a(injectorLike), ChannelFeedVideoPartDefinition.m2334b(injectorLike), ChannelFeedTextPartDefinition.m2442a(injectorLike), ChannelFeedVideoPlaysBlingBarPartSelector.m2476a(injectorLike), ChannelFeedBlingBarPartDefinition.m2113a(injectorLike), ChannelFeedFooterPartSelector.m2191a(injectorLike), (VideoDisplayedCoordinatorProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(VideoDisplayedCoordinatorProvider.class), CenterDistanceVideoDisplaySelector.b(injectorLike), (ChannelFeedStoryKeyProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(ChannelFeedStoryKeyProvider.class), GraphQLStoryUtil.a(injectorLike), ChannelFeedConfig.a(injectorLike));
    }

    public final Object m2256a(BaseMultiRowSubParts baseMultiRowSubParts, Object obj, AnyEnvironment anyEnvironment) {
        GraphQLStory graphQLStory;
        boolean z;
        FeedProps feedProps = (FeedProps) obj;
        HasContext hasContext = (HasContext) anyEnvironment;
        GraphQLStory graphQLStory2 = (GraphQLStory) feedProps.a;
        FeedProps j = StoryProps.j(feedProps);
        GraphQLStory graphQLStory3 = (GraphQLStory) j.a;
        FeedProps b = m2252b(feedProps);
        if (b != null) {
            graphQLStory = (GraphQLStory) b.a;
        } else {
            graphQLStory = null;
        }
        GraphQLVideo a = m2246a(graphQLStory3);
        Preconditions.checkNotNull(a);
        ChannelFeedStoryPersistentState channelFeedStoryPersistentState = (ChannelFeedStoryPersistentState) ((HasPersistentState) hasContext).a(this.f2244j.m2425a(j, a), graphQLStory3);
        InlineToChannelFeedTransitionManager inlineToChannelFeedTransitionManager = ((ChannelFeedEnvironment) hasContext).f2139s;
        if (inlineToChannelFeedTransitionManager == null || a.J() == null || !a.J().equals(inlineToChannelFeedTransitionManager.f2617j)) {
            z = false;
        } else {
            z = true;
        }
        channelFeedStoryPersistentState.f2508j = z;
        baseMultiRowSubParts.a(this.f2235a, graphQLStory2);
        m2250a(baseMultiRowSubParts, graphQLStory3, graphQLStory);
        m2249a(baseMultiRowSubParts, j, channelFeedStoryPersistentState);
        m2248a(baseMultiRowSubParts, j, b);
        m2254b(baseMultiRowSubParts, j, b);
        m2255c(baseMultiRowSubParts, j, b);
        return channelFeedStoryPersistentState.f2501c;
    }

    public final void m2257a(Object obj, Object obj2, AnyEnvironment anyEnvironment, GroupPartHolder groupPartHolder) {
        ChannelFeedDimmingController channelFeedDimmingController = (ChannelFeedDimmingController) obj2;
        if (groupPartHolder.a() instanceof ChannelFeedVideoAttachmentView) {
            this.f2243i.a((ChannelFeedVideoAttachmentView) groupPartHolder.a(), channelFeedDimmingController);
            channelFeedDimmingController.m2131a(((ChannelFeedVideoAttachmentView) groupPartHolder.a()).getRichVideoPlayer());
        }
        channelFeedDimmingController.m2130a(groupPartHolder.a());
    }

    public final boolean m2258a(Object obj) {
        return m2246a((GraphQLStory) StoryProps.j((FeedProps) obj).a) != null;
    }

    public final void m2259b(Object obj, Object obj2, AnyEnvironment anyEnvironment, GroupPartHolder groupPartHolder) {
        ChannelFeedDimmingController channelFeedDimmingController = (ChannelFeedDimmingController) obj2;
        channelFeedDimmingController.m2134b(groupPartHolder.a());
        channelFeedDimmingController.m2133b();
    }

    public static ChannelFeedGroupPartDefinition m2247a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ChannelFeedGroupPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f2234n) {
                ChannelFeedGroupPartDefinition channelFeedGroupPartDefinition;
                if (a2 != null) {
                    channelFeedGroupPartDefinition = (ChannelFeedGroupPartDefinition) a2.a(f2234n);
                } else {
                    channelFeedGroupPartDefinition = f2233m;
                }
                if (channelFeedGroupPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m2253b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f2234n, b3);
                        } else {
                            f2233m = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = channelFeedGroupPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public ChannelFeedGroupPartDefinition(ChannelFeedSocialContextHeaderPartDefinition channelFeedSocialContextHeaderPartDefinition, ChannelFeedHeaderPartDefinition channelFeedHeaderPartDefinition, ChannelFeedReuseVideoPartDefinition channelFeedReuseVideoPartDefinition, ChannelFeedVideoPartDefinition channelFeedVideoPartDefinition, ChannelFeedTextPartDefinition channelFeedTextPartDefinition, ChannelFeedVideoPlaysBlingBarPartSelector channelFeedVideoPlaysBlingBarPartSelector, ChannelFeedBlingBarPartDefinition channelFeedBlingBarPartDefinition, ChannelFeedFooterPartSelector channelFeedFooterPartSelector, VideoDisplayedCoordinatorProvider videoDisplayedCoordinatorProvider, CenterDistanceVideoDisplaySelector centerDistanceVideoDisplaySelector, ChannelFeedStoryKeyProvider channelFeedStoryKeyProvider, GraphQLStoryUtil graphQLStoryUtil, ChannelFeedConfig channelFeedConfig) {
        this.f2235a = channelFeedSocialContextHeaderPartDefinition;
        this.f2236b = channelFeedHeaderPartDefinition;
        this.f2237c = channelFeedReuseVideoPartDefinition;
        this.f2238d = channelFeedVideoPartDefinition;
        this.f2239e = channelFeedTextPartDefinition;
        this.f2240f = channelFeedVideoPlaysBlingBarPartSelector;
        this.f2241g = channelFeedBlingBarPartDefinition;
        this.f2242h = channelFeedFooterPartSelector;
        this.f2243i = videoDisplayedCoordinatorProvider.a(centerDistanceVideoDisplaySelector, true);
        this.f2244j = channelFeedStoryKeyProvider;
        this.f2245k = graphQLStoryUtil;
        this.f2246l = channelFeedConfig;
    }

    private void m2249a(MultiRowSubParts<E> multiRowSubParts, FeedProps<GraphQLStory> feedProps, ChannelFeedStoryPersistentState channelFeedStoryPersistentState) {
        GraphQLStory graphQLStory = (GraphQLStory) feedProps.a;
        SubPartsSelector.a(multiRowSubParts, this.f2237c, new Props(feedProps.a(StoryAttachmentHelper.o(graphQLStory)), channelFeedStoryPersistentState)).a(this.f2238d, new Props(feedProps.a(StoryAttachmentHelper.o(graphQLStory)), channelFeedStoryPersistentState));
    }

    @Nullable
    private static FeedProps<GraphQLStory> m2252b(FeedProps<GraphQLStory> feedProps) {
        if (((GraphQLStory) feedProps.a).l() != null) {
            return feedProps;
        }
        GraphQLStory graphQLStory = (GraphQLStory) feedProps.a;
        Builder builder = new Builder();
        while (graphQLStory.L() != null && graphQLStory.l() == null) {
            builder.c(graphQLStory);
            graphQLStory = graphQLStory.L();
        }
        return graphQLStory.l() != null ? FeedProps.a(graphQLStory, builder.b().reverse()) : null;
    }

    @Nullable
    private static GraphQLVideo m2246a(GraphQLStory graphQLStory) {
        GraphQLStoryAttachment o = StoryAttachmentHelper.o(graphQLStory);
        return (o == null || o.r() == null) ? null : GraphQLMediaConversionHelper.b(o.r());
    }

    private void m2250a(MultiRowSubParts<E> multiRowSubParts, GraphQLStory graphQLStory, @Nullable GraphQLStory graphQLStory2) {
        boolean z = !m2251a() || graphQLStory2 == graphQLStory || graphQLStory2 == null;
        if (!m2251a() || graphQLStory2 == null) {
            graphQLStory2 = graphQLStory;
        }
        multiRowSubParts.a(this.f2236b, new ChannelFeedHeaderPartDefinition.Props(FeedProps.c(graphQLStory2), z));
    }

    private void m2248a(MultiRowSubParts<E> multiRowSubParts, FeedProps<GraphQLStory> feedProps, @Nullable FeedProps<GraphQLStory> feedProps2) {
        if (!m2251a() || feedProps2 == null) {
            feedProps2 = feedProps;
        }
        multiRowSubParts.a(this.f2239e, new ChannelFeedExpandingContentTextPartDefinition.Props(feedProps2));
    }

    private void m2254b(MultiRowSubParts<E> multiRowSubParts, FeedProps<GraphQLStory> feedProps, @Nullable FeedProps<GraphQLStory> feedProps2) {
        SubPartsSelector.a(multiRowSubParts, this.f2241g, new ChannelFeedBlingBarPartDefinition.Props((GraphQLStory) feedProps.a, feedProps2, m2251a())).a(this.f2240f, feedProps);
    }

    private void m2255c(MultiRowSubParts<E> multiRowSubParts, FeedProps<GraphQLStory> feedProps, @Nullable FeedProps<GraphQLStory> feedProps2) {
        ChannelFeedFooterPartSelector channelFeedFooterPartSelector = this.f2242h;
        if (!m2251a() || feedProps2 == null) {
            feedProps2 = feedProps;
        }
        multiRowSubParts.a(channelFeedFooterPartSelector, feedProps2);
    }

    private boolean m2251a() {
        return this.f2246l.m;
    }
}
