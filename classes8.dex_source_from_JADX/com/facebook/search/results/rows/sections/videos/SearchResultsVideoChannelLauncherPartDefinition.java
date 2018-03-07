package com.facebook.search.results.rows.sections.videos;

import android.content.Context;
import android.view.View;
import com.facebook.attachments.videos.ui.BaseChannelFeedLauncherInfo;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.autoplay.AutoplayStateManager;
import com.facebook.feed.rows.core.props.AttachmentProps;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feedplugins.attachments.video.FullscreenTransitionListener;
import com.facebook.graphql.model.GraphQLMedia;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.Lazy;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.BaseSinglePartDefinition;
import com.facebook.multirow.api.SubParts;
import com.facebook.search.logging.SearchResultsLogger;
import com.facebook.search.results.environment.HasSearchResultPosition;
import com.facebook.search.results.environment.HasSearchResultsContext;
import com.facebook.search.results.environment.videos.HasSearchResultsVideoStoryPersistentState;
import com.facebook.search.results.environment.videos.SearchResultsVideoStoryPersistentState;
import com.facebook.search.results.model.SearchResultsProps;
import com.facebook.video.analytics.VideoAnalytics.ExternalLogType;
import com.facebook.video.channelfeed.ChannelFeedFromVideoLauncherPartDefinition;
import com.facebook.video.channelfeed.ChannelFeedFromVideoLauncherPartDefinition.Props;
import com.facebook.video.channelfeed.LaunchChannelFeedClickListener$OnLaunchCallback;
import com.facebook.video.engine.ExitFullScreenResult;
import java.util.concurrent.atomic.AtomicReference;
import javax.inject.Inject;

@ContextScoped
/* compiled from: PLACE_TAGGING */
public class SearchResultsVideoChannelLauncherPartDefinition<E extends HasSearchResultsVideoStoryPersistentState & HasSearchResultsContext & HasSearchResultPosition> extends BaseSinglePartDefinition<SearchResultsProps<FeedProps<GraphQLStoryAttachment>>, Void, E, View> {
    private static SearchResultsVideoChannelLauncherPartDefinition f25185c;
    private static final Object f25186d = new Object();
    private final ChannelFeedFromVideoLauncherPartDefinition f25187a;
    public final Lazy<SearchResultsLogger> f25188b;

    private static SearchResultsVideoChannelLauncherPartDefinition m28460b(InjectorLike injectorLike) {
        return new SearchResultsVideoChannelLauncherPartDefinition(ChannelFeedFromVideoLauncherPartDefinition.a(injectorLike), IdBasedSingletonScopeProvider.b(injectorLike, 10491));
    }

    public final Object m28461a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        final SearchResultsProps searchResultsProps = (SearchResultsProps) obj;
        final HasSearchResultsVideoStoryPersistentState hasSearchResultsVideoStoryPersistentState = (HasSearchResultsVideoStoryPersistentState) anyEnvironment;
        final SearchResultsVideoStoryPersistentState a = hasSearchResultsVideoStoryPersistentState.mo1254a(AttachmentProps.e((FeedProps) searchResultsProps.f23388a), -1);
        subParts.a(this.f25187a, new Props((FeedProps) searchResultsProps.f23388a, new AtomicReference(new FullscreenTransitionListener(this) {
            final /* synthetic */ SearchResultsVideoChannelLauncherPartDefinition f25181b;

            public final void m28457a(ExitFullScreenResult exitFullScreenResult) {
                a.a(exitFullScreenResult.c);
                AutoplayStateManager b = a.b();
                if (b != null) {
                    b.a(exitFullScreenResult.b, exitFullScreenResult.a);
                }
            }
        }), new BaseChannelFeedLauncherInfo(a), null, new LaunchChannelFeedClickListener$OnLaunchCallback(this) {
            final /* synthetic */ SearchResultsVideoChannelLauncherPartDefinition f25184c;

            public final void mo1335a() {
                GraphQLMedia r = ((GraphQLStoryAttachment) ((FeedProps) searchResultsProps.f23388a).a).r();
                SearchResultsVideoFullscreenLauncherPartDefinition.m28467a((SearchResultsLogger) this.f25184c.f25188b.get(), searchResultsProps, r != null ? r.j() : null, (HasSearchResultPosition) hasSearchResultsVideoStoryPersistentState);
            }
        }, ExternalLogType.SEARCH_RESULTS, ((HasSearchResultsContext) hasSearchResultsVideoStoryPersistentState).mo1248s().m27102v() != null ? ((HasSearchResultsContext) hasSearchResultsVideoStoryPersistentState).mo1248s().m27102v().mo595k() : null));
        return null;
    }

    @Inject
    public SearchResultsVideoChannelLauncherPartDefinition(ChannelFeedFromVideoLauncherPartDefinition channelFeedFromVideoLauncherPartDefinition, Lazy<SearchResultsLogger> lazy) {
        this.f25187a = channelFeedFromVideoLauncherPartDefinition;
        this.f25188b = lazy;
    }

    public static SearchResultsVideoChannelLauncherPartDefinition m28459a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            SearchResultsVideoChannelLauncherPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f25186d) {
                SearchResultsVideoChannelLauncherPartDefinition searchResultsVideoChannelLauncherPartDefinition;
                if (a2 != null) {
                    searchResultsVideoChannelLauncherPartDefinition = (SearchResultsVideoChannelLauncherPartDefinition) a2.a(f25186d);
                } else {
                    searchResultsVideoChannelLauncherPartDefinition = f25185c;
                }
                if (searchResultsVideoChannelLauncherPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m28460b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f25186d, b3);
                        } else {
                            f25185c = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = searchResultsVideoChannelLauncherPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
