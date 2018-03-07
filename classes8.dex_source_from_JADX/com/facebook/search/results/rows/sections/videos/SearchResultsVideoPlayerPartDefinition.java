package com.facebook.search.results.rows.sections.videos;

import android.content.Context;
import android.view.View;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.autoplay.AutoplayStateManager;
import com.facebook.feed.environment.HasFeedListType;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.props.AttachmentProps;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.core.props.StoryProps;
import com.facebook.feed.rows.core.props.TrackableFeedProps;
import com.facebook.feedplugins.attachments.video.ChannelFeedEligibilityUtil;
import com.facebook.feedplugins.attachments.video.VideoPrefetchPartDefinition;
import com.facebook.feedplugins.attachments.video.VideoPrefetchPartDefinition.Props;
import com.facebook.feedplugins.video.RichVideoAttachmentView;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.graphql.model.GraphQLVideo;
import com.facebook.graphql.model.conversion.GraphQLMediaConversionHelper;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import com.facebook.search.results.environment.HasSearchResultPosition;
import com.facebook.search.results.environment.HasSearchResultsContext;
import com.facebook.search.results.environment.videos.HasSearchResultsVideoStoryPersistentState;
import com.facebook.search.results.environment.videos.SearchResultsVideoStoryPersistentState;
import com.facebook.search.results.model.SearchResultsProps;
import com.facebook.video.analytics.ChannelEligibility;
import com.facebook.video.analytics.VideoAnalytics.PlayerOrigin;
import com.facebook.video.analytics.VideoDisplayedInfo;
import com.facebook.video.analytics.VideoFeedStoryInfo;
import com.facebook.video.analytics.VideoFeedStoryInfo.Builder;
import com.facebook.video.engine.VideoPlayerParams;
import com.facebook.video.feed.FeedVideoPlayerParamBuilderProvider;
import com.facebook.video.player.RichVideoPlayerCallbackListener;
import com.facebook.video.player.environment.HasFeedMenuHelper;
import com.facebook.video.player.events.RVPErrorEvent;
import com.facebook.video.player.events.RVPStreamCompleteEvent;
import com.fasterxml.jackson.databind.node.ArrayNode;
import javax.inject.Inject;

@ContextScoped
/* compiled from: PLACE_CREATION */
public class SearchResultsVideoPlayerPartDefinition<E extends HasFeedListType & HasFeedMenuHelper & HasSearchResultPosition & HasSearchResultsVideoStoryPersistentState & HasSearchResultsContext> extends MultiRowSinglePartDefinition<SearchResultsProps<FeedProps<GraphQLStoryAttachment>>, Void, E, RichVideoAttachmentView> {
    public static final ViewType<RichVideoAttachmentView> f25228a = new C26481();
    private static SearchResultsVideoPlayerPartDefinition f25229h;
    private static final Object f25230i = new Object();
    private final FeedVideoPlayerParamBuilderProvider f25231b;
    private final VideoPrefetchPartDefinition f25232c;
    private final SearchResultsVideoPlayerConfiguratorPartDefinition<E> f25233d;
    private final SearchResultsVideoAutoplayPartDefinition f25234e;
    private final SearchResultsVideoFullscreenLauncherPartDefinition<E, RichVideoAttachmentView> f25235f;
    private final ChannelFeedEligibilityUtil f25236g;

    /* compiled from: PLACE_CREATION */
    final class C26481 extends ViewType<RichVideoAttachmentView> {
        C26481() {
        }

        public final View m28485a(Context context) {
            return new RichVideoAttachmentView(context);
        }
    }

    private static SearchResultsVideoPlayerPartDefinition m28490b(InjectorLike injectorLike) {
        return new SearchResultsVideoPlayerPartDefinition((FeedVideoPlayerParamBuilderProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(FeedVideoPlayerParamBuilderProvider.class), VideoPrefetchPartDefinition.a(injectorLike), SearchResultsVideoPlayerConfiguratorPartDefinition.m28481a(injectorLike), SearchResultsVideoAutoplayPartDefinition.m28446a(injectorLike), SearchResultsVideoFullscreenLauncherPartDefinition.m28465a(injectorLike), ChannelFeedEligibilityUtil.a(injectorLike));
    }

    public final Object m28492a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        SearchResultsProps searchResultsProps = (SearchResultsProps) obj;
        HasFeedListType hasFeedListType = (HasFeedListType) anyEnvironment;
        FeedProps feedProps = (FeedProps) searchResultsProps.f23388a;
        subParts.a(this.f25232c, new Props(feedProps, -1));
        GraphQLVideo b = GraphQLMediaConversionHelper.b(((GraphQLStoryAttachment) feedProps.a).r());
        FeedProps e = AttachmentProps.e(feedProps);
        final SearchResultsVideoStoryPersistentState d = ((HasSearchResultsVideoStoryPersistentState) hasFeedListType).mo1257d(searchResultsProps);
        boolean p = StoryProps.p(e);
        VideoPlayerParams a = this.f25231b.a(feedProps, b).a();
        ArrayNode a2 = TrackableFeedProps.a(e);
        ChannelEligibility a3 = this.f25236g.a(feedProps, hasFeedListType.c().a());
        Builder builder = new Builder(a2);
        builder.d = p;
        Builder builder2 = builder;
        builder2.c = a3;
        VideoFeedStoryInfo a4 = builder2.a();
        subParts.a(this.f25233d, new SearchResultsVideoPlayerConfiguratorPartDefinition.Props(searchResultsProps, new RichVideoPlayerCallbackListener(this) {
            final /* synthetic */ SearchResultsVideoPlayerPartDefinition f25227b;

            public final void m28488a(RVPStreamCompleteEvent rVPStreamCompleteEvent) {
                AutoplayStateManager b = d.m26274b();
                if (b != null) {
                    b.f();
                }
            }

            public final void m28486a() {
            }

            public final void m28487a(RVPErrorEvent rVPErrorEvent) {
                AutoplayStateManager b = d.m26274b();
                if (b != null) {
                    b.i();
                }
            }
        }, a));
        subParts.a(this.f25234e, new SearchResultsVideoAutoplayPartDefinition.Props(searchResultsProps, (GraphQLStory) e.a, new VideoDisplayedInfo(), a, a4, PlayerOrigin.SEARCH_RESULTS));
        subParts.a(this.f25235f, searchResultsProps);
        return null;
    }

    public static SearchResultsVideoPlayerPartDefinition m28489a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            SearchResultsVideoPlayerPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f25230i) {
                SearchResultsVideoPlayerPartDefinition searchResultsVideoPlayerPartDefinition;
                if (a2 != null) {
                    searchResultsVideoPlayerPartDefinition = (SearchResultsVideoPlayerPartDefinition) a2.a(f25230i);
                } else {
                    searchResultsVideoPlayerPartDefinition = f25229h;
                }
                if (searchResultsVideoPlayerPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m28490b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f25230i, b3);
                        } else {
                            f25229h = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = searchResultsVideoPlayerPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public SearchResultsVideoPlayerPartDefinition(FeedVideoPlayerParamBuilderProvider feedVideoPlayerParamBuilderProvider, VideoPrefetchPartDefinition videoPrefetchPartDefinition, SearchResultsVideoPlayerConfiguratorPartDefinition searchResultsVideoPlayerConfiguratorPartDefinition, SearchResultsVideoAutoplayPartDefinition searchResultsVideoAutoplayPartDefinition, SearchResultsVideoFullscreenLauncherPartDefinition searchResultsVideoFullscreenLauncherPartDefinition, ChannelFeedEligibilityUtil channelFeedEligibilityUtil) {
        this.f25231b = feedVideoPlayerParamBuilderProvider;
        this.f25232c = videoPrefetchPartDefinition;
        this.f25233d = searchResultsVideoPlayerConfiguratorPartDefinition;
        this.f25234e = searchResultsVideoAutoplayPartDefinition;
        this.f25235f = searchResultsVideoFullscreenLauncherPartDefinition;
        this.f25236g = channelFeedEligibilityUtil;
    }

    public final ViewType<RichVideoAttachmentView> m28491a() {
        return f25228a;
    }

    public final boolean m28493a(Object obj) {
        return true;
    }
}
