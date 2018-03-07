package com.facebook.search.results.rows.sections.videos;

import android.content.Context;
import android.view.View;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feedplugins.video.RichVideoAttachmentView;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.graphql.model.GraphQLStoryAttachmentUtil;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.BaseSinglePartDefinition;
import com.facebook.multirow.api.SubParts;
import com.facebook.search.results.environment.videos.HasSearchResultsVideoStoryPersistentState;
import com.facebook.search.results.model.SearchResultsProps;
import com.facebook.video.analytics.VideoAnalytics.EventTriggerType;
import com.facebook.video.analytics.VideoAnalytics.PlayerOrigin;
import com.facebook.video.channelfeed.ChannelFeedAdditionalRichVideoPlayerParamsBuilder;
import com.facebook.video.engine.VideoPlayerParams;
import com.facebook.video.player.RichVideoPlayer;
import com.facebook.video.player.RichVideoPlayerCallbackListener;
import com.facebook.video.player.RichVideoPlayerParams;
import com.facebook.video.player.RichVideoPlayerParams.Builder;
import com.facebook.video.player.environment.HasFeedMenuHelper;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import javax.inject.Inject;

@ContextScoped
/* compiled from: PLACE_CREATION_LOGGER */
public class SearchResultsVideoPlayerConfiguratorPartDefinition<E extends HasFeedMenuHelper & HasSearchResultsVideoStoryPersistentState> extends BaseSinglePartDefinition<Props, RichVideoPlayerParams, E, RichVideoAttachmentView> {
    private static SearchResultsVideoPlayerConfiguratorPartDefinition f25223b;
    private static final Object f25224c = new Object();
    private final ChannelFeedAdditionalRichVideoPlayerParamsBuilder f25225a;

    /* compiled from: PLACE_CREATION_LOGGER */
    public class Props {
        public final SearchResultsProps<FeedProps<GraphQLStoryAttachment>> f25220a;
        public final RichVideoPlayerCallbackListener f25221b;
        public final VideoPlayerParams f25222c;

        public Props(SearchResultsProps<FeedProps<GraphQLStoryAttachment>> searchResultsProps, RichVideoPlayerCallbackListener richVideoPlayerCallbackListener, VideoPlayerParams videoPlayerParams) {
            this.f25220a = searchResultsProps;
            this.f25221b = richVideoPlayerCallbackListener;
            this.f25222c = videoPlayerParams;
        }
    }

    private static SearchResultsVideoPlayerConfiguratorPartDefinition m28482b(InjectorLike injectorLike) {
        return new SearchResultsVideoPlayerConfiguratorPartDefinition(ChannelFeedAdditionalRichVideoPlayerParamsBuilder.b(injectorLike));
    }

    public final Object m28483a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        Props props = (Props) obj;
        HasFeedMenuHelper hasFeedMenuHelper = (HasFeedMenuHelper) anyEnvironment;
        FeedProps feedProps = (FeedProps) props.f25220a.f23388a;
        Preconditions.checkArgument(GraphQLStoryAttachmentUtil.d((GraphQLStoryAttachment) feedProps.a));
        feedProps = (FeedProps) Preconditions.checkNotNull(feedProps.b);
        ImmutableMap b = this.f25225a.a(feedProps).b("AutoplayStateManager", ((HasSearchResultsVideoStoryPersistentState) hasFeedMenuHelper).mo1254a(feedProps, props.f25220a.f23389b).m26274b()).b();
        Builder builder = new Builder();
        builder.a = props.f25222c;
        return builder.a(b).b();
    }

    public final /* bridge */ /* synthetic */ void m28484a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, 1628204080);
        Props props = (Props) obj;
        RichVideoPlayerParams richVideoPlayerParams = (RichVideoPlayerParams) obj2;
        HasFeedMenuHelper hasFeedMenuHelper = (HasFeedMenuHelper) anyEnvironment;
        RichVideoAttachmentView richVideoAttachmentView = (RichVideoAttachmentView) view;
        RichVideoPlayer richVideoPlayer = richVideoAttachmentView.getRichVideoPlayer();
        if (!props.f25222c.b.equals(richVideoPlayer.getVideoId())) {
            richVideoPlayer.g();
        }
        richVideoAttachmentView.b.a(richVideoPlayer, richVideoPlayerParams, hasFeedMenuHelper);
        richVideoPlayer.v = props.f25221b;
        richVideoPlayer.a(richVideoPlayerParams);
        richVideoPlayer.a(true, EventTriggerType.BY_AUTOPLAY);
        richVideoPlayer.setPlayerOrigin(PlayerOrigin.SEARCH_RESULTS);
        richVideoPlayer.setShouldCropToFit(true);
        Logger.a(8, EntryType.MARK_POP, 549683525, a);
    }

    @Inject
    public SearchResultsVideoPlayerConfiguratorPartDefinition(ChannelFeedAdditionalRichVideoPlayerParamsBuilder channelFeedAdditionalRichVideoPlayerParamsBuilder) {
        this.f25225a = channelFeedAdditionalRichVideoPlayerParamsBuilder;
    }

    public static SearchResultsVideoPlayerConfiguratorPartDefinition m28481a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            SearchResultsVideoPlayerConfiguratorPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f25224c) {
                SearchResultsVideoPlayerConfiguratorPartDefinition searchResultsVideoPlayerConfiguratorPartDefinition;
                if (a2 != null) {
                    searchResultsVideoPlayerConfiguratorPartDefinition = (SearchResultsVideoPlayerConfiguratorPartDefinition) a2.a(f25224c);
                } else {
                    searchResultsVideoPlayerConfiguratorPartDefinition = f25223b;
                }
                if (searchResultsVideoPlayerConfiguratorPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m28482b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f25224c, b3);
                        } else {
                            f25223b = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = searchResultsVideoPlayerConfiguratorPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
