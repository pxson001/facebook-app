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
import com.facebook.feed.rows.core.traversal.GroupPartHolder;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.graphql.model.GraphQLVideo;
import com.facebook.graphql.model.StoryAttachmentHelper;
import com.facebook.graphql.model.conversion.GraphQLMediaConversionHelper;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.BaseMultiRowSubParts;
import com.facebook.multirow.api.MultiRowGroupPartDefinition;
import com.facebook.video.channelfeed.ChannelFeedHeaderPartDefinition.Props;
import com.facebook.video.channelfeed.MultiShareChannelStoryUnit.Type;
import com.google.common.base.Preconditions;
import javax.annotation.Nullable;
import javax.inject.Inject;

@ContextScoped
/* compiled from: success_request_ride */
public class MultiShareChannelFeedPartDefinition<E extends HasContext & HasFeedListType & HasFullscreenPlayer & HasInvalidate & HasMenuButtonProvider & HasPersistentState & HasPlayerOrigin & HasPositionInformation & HasPrefetcher & HasRowKey & HasVideoAutoplay<ChannelFeedVideoAttachmentView> & CanFeedback & CanReusePlayer & CanShowVideoInFullScreen & HasSinglePublisherChannelInfo> implements MultiRowGroupPartDefinition<FeedProps<MultiShareChannelStoryUnit>, ChannelFeedDimmingController, E> {
    private static MultiShareChannelFeedPartDefinition f2624j;
    private static final Object f2625k = new Object();
    private final ChannelFeedSocialContextHeaderPartDefinition f2626a;
    private final ChannelFeedHeaderPartDefinition<E> f2627b;
    private final ChannelFeedVideoPartDefinition f2628c;
    private final ChannelFeedTextPartDefinition<E> f2629d;
    private final ChannelFeedFooterPartSelector<E> f2630e;
    private final MultiShareChannelFeedDividerPartDefinition f2631f;
    private final VideoDisplayedCoordinator<ChannelFeedVideoAttachmentView> f2632g;
    private final ChannelFeedStoryKeyProvider f2633h;
    private final ChannelFeedVideoPlaysBlingBarPartSelector f2634i;

    private static MultiShareChannelFeedPartDefinition m2536b(InjectorLike injectorLike) {
        return new MultiShareChannelFeedPartDefinition(ChannelFeedSocialContextHeaderPartDefinition.m2415a(injectorLike), ChannelFeedHeaderPartDefinition.m2269a(injectorLike), ChannelFeedVideoPartDefinition.m2334b(injectorLike), ChannelFeedTextPartDefinition.m2442a(injectorLike), ChannelFeedFooterPartSelector.m2191a(injectorLike), (VideoDisplayedCoordinatorProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(VideoDisplayedCoordinatorProvider.class), CenterDistanceVideoDisplaySelector.b(injectorLike), (ChannelFeedStoryKeyProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(ChannelFeedStoryKeyProvider.class), MultiShareChannelFeedDividerPartDefinition.m2529a(injectorLike), ChannelFeedVideoPlaysBlingBarPartSelector.m2476a(injectorLike));
    }

    public final Object m2537a(BaseMultiRowSubParts baseMultiRowSubParts, Object obj, AnyEnvironment anyEnvironment) {
        boolean z;
        Object obj2;
        HasContext hasContext = (HasContext) anyEnvironment;
        MultiShareChannelStoryUnit multiShareChannelStoryUnit = (MultiShareChannelStoryUnit) ((FeedProps) obj).a;
        GraphQLStory graphQLStory = multiShareChannelStoryUnit.f2635a;
        GraphQLVideo a = m2534a(graphQLStory);
        Preconditions.checkNotNull(a);
        FeedProps c = FeedProps.c(graphQLStory);
        ChannelFeedStoryPersistentState channelFeedStoryPersistentState = (ChannelFeedStoryPersistentState) ((HasPersistentState) hasContext).a(this.f2633h.m2425a(c, a), graphQLStory);
        InlineToChannelFeedTransitionManager inlineToChannelFeedTransitionManager = ((ChannelFeedEnvironment) hasContext).f2139s;
        if (inlineToChannelFeedTransitionManager == null || a.J() == null || !a.J().equals(inlineToChannelFeedTransitionManager.f2617j)) {
            z = false;
        } else {
            z = true;
        }
        channelFeedStoryPersistentState.f2508j = z;
        if (multiShareChannelStoryUnit.f2636b == Type.FIRST) {
            obj2 = 1;
        } else {
            obj2 = null;
        }
        if (obj2 != null) {
            baseMultiRowSubParts.a(this.f2626a, c.a);
            baseMultiRowSubParts.a(this.f2627b, new Props(c, true));
        }
        SubPartsSelector.a(baseMultiRowSubParts, this.f2628c, new ChannelFeedVideoPartDefinition.Props(c.a(StoryAttachmentHelper.o(graphQLStory)), channelFeedStoryPersistentState));
        baseMultiRowSubParts.a(this.f2629d, new ChannelFeedExpandingContentTextPartDefinition.Props(c));
        if (multiShareChannelStoryUnit.f2636b == Type.LAST) {
            obj2 = 1;
        } else {
            obj2 = null;
        }
        if (obj2 != null) {
            baseMultiRowSubParts.a(this.f2634i, c);
            baseMultiRowSubParts.a(this.f2630e, c);
        } else {
            baseMultiRowSubParts.a(this.f2631f, null);
        }
        return channelFeedStoryPersistentState.f2501c;
    }

    public final void m2538a(Object obj, Object obj2, AnyEnvironment anyEnvironment, GroupPartHolder groupPartHolder) {
        ChannelFeedDimmingController channelFeedDimmingController = (ChannelFeedDimmingController) obj2;
        if (groupPartHolder.a() instanceof ChannelFeedVideoAttachmentView) {
            this.f2632g.a((ChannelFeedVideoAttachmentView) groupPartHolder.a(), channelFeedDimmingController);
            channelFeedDimmingController.m2131a(((ChannelFeedVideoAttachmentView) groupPartHolder.a()).getRichVideoPlayer());
        }
        channelFeedDimmingController.m2130a(groupPartHolder.a());
    }

    public final boolean m2539a(Object obj) {
        GraphQLStory graphQLStory = ((MultiShareChannelStoryUnit) ((FeedProps) obj).a).f2635a;
        GraphQLStoryAttachment o = StoryAttachmentHelper.o(graphQLStory);
        return (o == null || o.r() == null || m2534a(graphQLStory) == null) ? false : true;
    }

    public final void m2540b(Object obj, Object obj2, AnyEnvironment anyEnvironment, GroupPartHolder groupPartHolder) {
        ChannelFeedDimmingController channelFeedDimmingController = (ChannelFeedDimmingController) obj2;
        channelFeedDimmingController.m2134b(groupPartHolder.a());
        channelFeedDimmingController.m2133b();
    }

    public static MultiShareChannelFeedPartDefinition m2535a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            MultiShareChannelFeedPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f2625k) {
                MultiShareChannelFeedPartDefinition multiShareChannelFeedPartDefinition;
                if (a2 != null) {
                    multiShareChannelFeedPartDefinition = (MultiShareChannelFeedPartDefinition) a2.a(f2625k);
                } else {
                    multiShareChannelFeedPartDefinition = f2624j;
                }
                if (multiShareChannelFeedPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m2536b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f2625k, b3);
                        } else {
                            f2624j = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = multiShareChannelFeedPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public MultiShareChannelFeedPartDefinition(ChannelFeedSocialContextHeaderPartDefinition channelFeedSocialContextHeaderPartDefinition, ChannelFeedHeaderPartDefinition channelFeedHeaderPartDefinition, ChannelFeedVideoPartDefinition channelFeedVideoPartDefinition, ChannelFeedTextPartDefinition channelFeedTextPartDefinition, ChannelFeedFooterPartSelector channelFeedFooterPartSelector, VideoDisplayedCoordinatorProvider videoDisplayedCoordinatorProvider, CenterDistanceVideoDisplaySelector centerDistanceVideoDisplaySelector, ChannelFeedStoryKeyProvider channelFeedStoryKeyProvider, MultiShareChannelFeedDividerPartDefinition multiShareChannelFeedDividerPartDefinition, ChannelFeedVideoPlaysBlingBarPartSelector channelFeedVideoPlaysBlingBarPartSelector) {
        this.f2626a = channelFeedSocialContextHeaderPartDefinition;
        this.f2627b = channelFeedHeaderPartDefinition;
        this.f2628c = channelFeedVideoPartDefinition;
        this.f2629d = channelFeedTextPartDefinition;
        this.f2630e = channelFeedFooterPartSelector;
        this.f2632g = videoDisplayedCoordinatorProvider.a(centerDistanceVideoDisplaySelector, true);
        this.f2633h = channelFeedStoryKeyProvider;
        this.f2631f = multiShareChannelFeedDividerPartDefinition;
        this.f2634i = channelFeedVideoPlaysBlingBarPartSelector;
    }

    @Nullable
    private static GraphQLVideo m2534a(GraphQLStory graphQLStory) {
        GraphQLStoryAttachment o = StoryAttachmentHelper.o(graphQLStory);
        return (o == null || o.r() == null) ? null : GraphQLMediaConversionHelper.b(o.r());
    }
}
