package com.facebook.search.results.rows.sections.videos;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.util.ContextUtils;
import com.facebook.feed.autoplay.AutoplayStateManager;
import com.facebook.feed.autoplay.VideoPlayerView;
import com.facebook.feed.environment.HasFeedListType;
import com.facebook.feed.rows.core.props.AttachmentProps;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.core.props.StoryProps;
import com.facebook.feed.rows.core.props.TrackableFeedProps;
import com.facebook.feed.ui.imageloader.FeedImageLoader;
import com.facebook.feed.ui.imageloader.FeedImageLoader.FeedImageType;
import com.facebook.feed.video.FeedFullScreenParams;
import com.facebook.feed.video.FullScreenVideoPlayerHost;
import com.facebook.feed.video.ImmersiveVideoPlayer;
import com.facebook.feedplugins.attachments.video.FeedAnalyticsUtil;
import com.facebook.feedplugins.attachments.video.VideoZeroDialogPartDefinition;
import com.facebook.feedplugins.attachments.video.VideoZeroDialogPartDefinition.Props;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.facebook.graphql.model.GraphQLMedia;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.graphql.model.GraphQLVideo;
import com.facebook.graphql.model.conversion.GraphQLMediaConversionHelper;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.Lazy;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.BaseSinglePartDefinition;
import com.facebook.multirow.api.SinglePartDefinition;
import com.facebook.multirow.api.SubParts;
import com.facebook.search.logging.SearchResultsLogger;
import com.facebook.search.results.environment.HasSearchResultPosition;
import com.facebook.search.results.environment.HasSearchResultsContext;
import com.facebook.search.results.environment.videos.HasSearchResultsVideoStoryPersistentState;
import com.facebook.search.results.environment.videos.SearchResultsVideoStoryPersistentState;
import com.facebook.search.results.model.SearchResultsProps;
import com.facebook.search.results.protocol.SearchResultsEdgeUtil;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.video.analytics.VideoAnalytics.EventTriggerType;
import com.facebook.video.analytics.VideoAnalytics.ExternalLogType;
import com.facebook.video.analytics.VideoAnalyticsRequiredInfo;
import com.facebook.video.analytics.VideoFeedStoryInfo.Builder;
import com.facebook.video.engine.ExitFullScreenResult;
import com.facebook.video.player.FullScreenVideoListener;
import com.facebook.video.player.VideoTransitionNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.google.common.base.Preconditions;
import java.util.Locale;
import javax.annotation.Nullable;
import javax.inject.Inject;

@ContextScoped
/* compiled from: PLACE_SAVE_INTERACTION */
public class SearchResultsVideoFullscreenLauncherPartDefinition<E extends HasSearchResultsVideoStoryPersistentState & HasFeedListType & HasSearchResultPosition & HasSearchResultsContext, V extends View> extends BaseSinglePartDefinition<SearchResultsProps<FeedProps<GraphQLStoryAttachment>>, Void, E, V> {
    private static SearchResultsVideoFullscreenLauncherPartDefinition f25196e;
    private static final Object f25197f = new Object();
    private final FeedImageLoader f25198a;
    private final Lazy<VideoZeroDialogPartDefinition> f25199b;
    public final SearchResultsCenteredVideoAutoplayManager f25200c;
    public final Lazy<SearchResultsLogger> f25201d;

    private static SearchResultsVideoFullscreenLauncherPartDefinition m28468b(InjectorLike injectorLike) {
        return new SearchResultsVideoFullscreenLauncherPartDefinition(FeedImageLoader.a(injectorLike), IdBasedLazy.a(injectorLike, 1817), SearchResultsCenteredVideoAutoplayManager.m28411a(injectorLike), IdBasedSingletonScopeProvider.b(injectorLike, 10491));
    }

    public final Object m28469a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        SearchResultsProps searchResultsProps = (SearchResultsProps) obj;
        HasSearchResultsVideoStoryPersistentState hasSearchResultsVideoStoryPersistentState = (HasSearchResultsVideoStoryPersistentState) anyEnvironment;
        SearchResultsVideoStoryPersistentState d = hasSearchResultsVideoStoryPersistentState.mo1257d(searchResultsProps);
        FeedProps feedProps = (FeedProps) searchResultsProps.f23388a;
        GraphQLStoryAttachment graphQLStoryAttachment = (GraphQLStoryAttachment) feedProps.a;
        GraphQLVideo b = GraphQLMediaConversionHelper.b(graphQLStoryAttachment.r());
        ArrayNode a = TrackableFeedProps.a(feedProps);
        FeedProps e = AttachmentProps.e(feedProps);
        Preconditions.checkNotNull(e);
        boolean p = StoryProps.p(e);
        Builder builder = new Builder(a);
        builder.d = p;
        FeedFullScreenParams feedFullScreenParams = new FeedFullScreenParams(new VideoAnalyticsRequiredInfo.Builder(d.f22720a).a(), builder.a(), this.f25198a.a(graphQLStoryAttachment.r(), FeedImageType.Video), b, feedProps, ExternalLogType.SEARCH_RESULTS, ((HasSearchResultsContext) hasSearchResultsVideoStoryPersistentState).mo1248s().m27102v().mo595k());
        feedFullScreenParams.a(FeedAnalyticsUtil.a(((HasFeedListType) hasSearchResultsVideoStoryPersistentState).c()));
        subParts.a((SinglePartDefinition) this.f25199b.get(), new Props(m28464a(hasSearchResultsVideoStoryPersistentState, searchResultsProps, d, feedFullScreenParams)));
        return null;
    }

    public static SearchResultsVideoFullscreenLauncherPartDefinition m28465a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            SearchResultsVideoFullscreenLauncherPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f25197f) {
                SearchResultsVideoFullscreenLauncherPartDefinition searchResultsVideoFullscreenLauncherPartDefinition;
                if (a2 != null) {
                    searchResultsVideoFullscreenLauncherPartDefinition = (SearchResultsVideoFullscreenLauncherPartDefinition) a2.a(f25197f);
                } else {
                    searchResultsVideoFullscreenLauncherPartDefinition = f25196e;
                }
                if (searchResultsVideoFullscreenLauncherPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m28468b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f25197f, b3);
                        } else {
                            f25196e = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = searchResultsVideoFullscreenLauncherPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public SearchResultsVideoFullscreenLauncherPartDefinition(FeedImageLoader feedImageLoader, Lazy<VideoZeroDialogPartDefinition> lazy, SearchResultsCenteredVideoAutoplayManager searchResultsCenteredVideoAutoplayManager, Lazy<SearchResultsLogger> lazy2) {
        this.f25198a = feedImageLoader;
        this.f25199b = lazy;
        this.f25200c = searchResultsCenteredVideoAutoplayManager;
        this.f25201d = lazy2;
    }

    @Nullable
    private static String m28466a(FeedProps<GraphQLStoryAttachment> feedProps) {
        GraphQLMedia r = ((GraphQLStoryAttachment) feedProps.a).r();
        return r != null ? r.b() : null;
    }

    private OnClickListener m28464a(E e, SearchResultsProps<FeedProps<GraphQLStoryAttachment>> searchResultsProps, SearchResultsVideoStoryPersistentState searchResultsVideoStoryPersistentState, FeedFullScreenParams feedFullScreenParams) {
        final SearchResultsVideoStoryPersistentState searchResultsVideoStoryPersistentState2 = searchResultsVideoStoryPersistentState;
        final FeedFullScreenParams feedFullScreenParams2 = feedFullScreenParams;
        final SearchResultsProps<FeedProps<GraphQLStoryAttachment>> searchResultsProps2 = searchResultsProps;
        final E e2 = e;
        return new OnClickListener(this) {
            final /* synthetic */ SearchResultsVideoFullscreenLauncherPartDefinition f25195e;

            public void onClick(final View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, -1673276648);
                FullScreenVideoPlayerHost fullScreenVideoPlayerHost = (FullScreenVideoPlayerHost) ContextUtils.a(view.getContext(), FullScreenVideoPlayerHost.class);
                if (fullScreenVideoPlayerHost == null) {
                    Logger.a(2, EntryType.UI_INPUT_END, -583328088, a);
                    return;
                }
                ImmersiveVideoPlayer k = fullScreenVideoPlayerHost.k();
                k.a(new FullScreenVideoListener(this) {
                    final /* synthetic */ C26471 f25190b;

                    public final void m28462a(EventTriggerType eventTriggerType) {
                        AutoplayStateManager b = searchResultsVideoStoryPersistentState2.m26274b();
                        if (b != null) {
                            b.a();
                            b.h();
                        }
                        this.f25190b.f25195e.f25200c.f25115a.c();
                    }

                    public final void m28463a(EventTriggerType eventTriggerType, ExitFullScreenResult exitFullScreenResult) {
                        AutoplayStateManager b = searchResultsVideoStoryPersistentState2.m26274b();
                        searchResultsVideoStoryPersistentState2.m26273a(exitFullScreenResult.c);
                        if (b != null) {
                            b.a(exitFullScreenResult.b, exitFullScreenResult.a);
                        }
                        this.f25190b.f25195e.f25200c.f25115a.d();
                        view.requestLayout();
                    }
                });
                if (view instanceof VideoPlayerView) {
                    int seekPosition = ((VideoPlayerView) view).getSeekPosition();
                    feedFullScreenParams2.b(seekPosition);
                    feedFullScreenParams2.a(seekPosition);
                }
                if (view instanceof VideoTransitionNode) {
                    feedFullScreenParams2.h = (VideoTransitionNode) view;
                }
                k.a(feedFullScreenParams2);
                GraphQLMedia r = ((GraphQLStoryAttachment) ((FeedProps) searchResultsProps2.f23388a).a).r();
                SearchResultsVideoFullscreenLauncherPartDefinition.m28467a((SearchResultsLogger) this.f25195e.f25201d.get(), searchResultsProps2, r != null ? r.j() : null, (HasSearchResultPosition) e2);
                LogUtils.a(-526386174, a);
            }
        };
    }

    public static <E extends HasSearchResultPosition & HasSearchResultsContext> void m28467a(SearchResultsLogger searchResultsLogger, SearchResultsProps<FeedProps<GraphQLStoryAttachment>> searchResultsProps, GraphQLObjectType graphQLObjectType, E e) {
        if (searchResultsProps.m27108f()) {
            searchResultsLogger.m25482a(((HasSearchResultsContext) e).mo1248s(), searchResultsProps.m27106d(), (String) searchResultsProps.f23391d.orNull(), e.mo1246a((SearchResultsProps) searchResultsProps), searchResultsProps.f23389b, SearchResultsEdgeUtil.m9804f(searchResultsProps.f23390c), graphQLObjectType != null ? graphQLObjectType.e().toLowerCase(Locale.US) : null, m28466a((FeedProps) searchResultsProps.f23388a));
            return;
        }
        searchResultsLogger.m25476a(((HasSearchResultsContext) e).mo1248s(), e.mo1246a((SearchResultsProps) searchResultsProps), m28466a((FeedProps) searchResultsProps.f23388a));
    }
}
