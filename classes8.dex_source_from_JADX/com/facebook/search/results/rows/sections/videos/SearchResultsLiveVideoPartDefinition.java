package com.facebook.search.results.rows.sections.videos;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.HasContext;
import com.facebook.feed.environment.HasFeedListType;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feedplugins.attachments.video.FullscreenTransitionListener;
import com.facebook.graphql.calls.EntryPointInputVideoChannelEntryPoint;
import com.facebook.graphql.model.GraphQLActor;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.graphql.model.StoryAttachmentHelper;
import com.facebook.graphql.model.StoryHierarchyHelper;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.Lazy;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import com.facebook.search.logging.SearchResultsLogger;
import com.facebook.search.logging.api.SearchResultsAnalytics.InlineActionName;
import com.facebook.search.logging.api.SearchResultsAnalytics.InlineActionType;
import com.facebook.search.results.environment.HasSearchResultPosition;
import com.facebook.search.results.environment.HasSearchResultsContext;
import com.facebook.search.results.environment.videos.HasSearchResultsVideoStoryPersistentState;
import com.facebook.search.results.model.SearchResultsProps;
import com.facebook.video.analytics.VideoAnalytics.EventTriggerType;
import com.facebook.video.analytics.VideoAnalytics.PlayerOrigin;
import com.facebook.video.channelfeed.ChannelFeedGenericLauncherPartDefinition;
import com.facebook.video.channelfeed.ChannelFeedHeaderParamsFactory;
import com.facebook.video.channelfeed.ChannelFeedParams;
import com.facebook.video.channelfeed.LaunchChannelFeedClickListener$OnLaunchCallback;
import com.facebook.video.channelfeed.PublisherInfoPartDefinition;
import com.facebook.video.channelfeed.PublisherInfoPartDefinition.Props;
import com.facebook.video.channelfeed.PublisherInfoPartDefinition.Props.Builder;
import com.facebook.video.channelfeed.VideoChannelHelper;
import com.facebook.video.player.environment.HasFeedMenuHelper;
import com.google.common.base.Preconditions;
import java.util.concurrent.atomic.AtomicReference;
import javax.annotation.Nullable;
import javax.inject.Inject;

@ContextScoped
/* compiled from: PLAYBACK_START */
public class SearchResultsLiveVideoPartDefinition<E extends HasContext & HasFeedListType & HasFeedMenuHelper & HasSearchResultPosition & HasSearchResultsContext & HasSearchResultsVideoStoryPersistentState> extends MultiRowSinglePartDefinition<SearchResultsProps<FeedProps<GraphQLStoryAttachment>>, Void, E, View> {
    public static final ViewType<View> f25137a = new C26411();
    private static final AtomicReference<FullscreenTransitionListener> f25138b = new AtomicReference();
    private static SearchResultsLiveVideoPartDefinition f25139h;
    private static final Object f25140i = new Object();
    private final ChannelFeedGenericLauncherPartDefinition<E, View> f25141c;
    private final ChannelFeedHeaderParamsFactory f25142d;
    private final PublisherInfoPartDefinition<E> f25143e;
    public final Lazy<SearchResultsLogger> f25144f;
    private final SearchResultsVideoPlayerPartDefinition<E> f25145g;

    /* compiled from: PLAYBACK_START */
    final class C26411 extends ViewType<View> {
        C26411() {
        }

        public final View m28428a(Context context) {
            return LayoutInflater.from(context).inflate(2130905103, null, false);
        }
    }

    private static SearchResultsLiveVideoPartDefinition m28433b(InjectorLike injectorLike) {
        return new SearchResultsLiveVideoPartDefinition(ChannelFeedGenericLauncherPartDefinition.a(injectorLike), ChannelFeedHeaderParamsFactory.a(injectorLike), PublisherInfoPartDefinition.a(injectorLike), IdBasedSingletonScopeProvider.b(injectorLike, 10491), SearchResultsVideoPlayerPartDefinition.m28489a(injectorLike));
    }

    public final Object m28435a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        SearchResultsProps searchResultsProps = (SearchResultsProps) obj;
        HasContext hasContext = (HasContext) anyEnvironment;
        subParts.a(2131568378, this.f25145g, searchResultsProps);
        GraphQLStory graphQLStory = (GraphQLStory) ((FeedProps) Preconditions.checkNotNull(((FeedProps) searchResultsProps.f23388a).b)).a;
        PublisherInfoPartDefinition publisherInfoPartDefinition = this.f25143e;
        Builder builder = new Builder(graphQLStory);
        builder.b = searchResultsProps.m27108f();
        builder = builder;
        builder.c = StoryHierarchyHelper.b(graphQLStory);
        Builder builder2 = builder;
        subParts.a(2131560329, publisherInfoPartDefinition, new Props(builder2.a, builder2.b, builder2.c));
        ChannelFeedGenericLauncherPartDefinition.Props a = m28432a(searchResultsProps, hasContext);
        if (a != null) {
            subParts.a(2131560329, this.f25141c, a);
        }
        return null;
    }

    public static SearchResultsLiveVideoPartDefinition m28431a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            SearchResultsLiveVideoPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f25140i) {
                SearchResultsLiveVideoPartDefinition searchResultsLiveVideoPartDefinition;
                if (a2 != null) {
                    searchResultsLiveVideoPartDefinition = (SearchResultsLiveVideoPartDefinition) a2.a(f25140i);
                } else {
                    searchResultsLiveVideoPartDefinition = f25139h;
                }
                if (searchResultsLiveVideoPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m28433b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f25140i, b3);
                        } else {
                            f25139h = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = searchResultsLiveVideoPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public SearchResultsLiveVideoPartDefinition(ChannelFeedGenericLauncherPartDefinition channelFeedGenericLauncherPartDefinition, ChannelFeedHeaderParamsFactory channelFeedHeaderParamsFactory, PublisherInfoPartDefinition publisherInfoPartDefinition, Lazy<SearchResultsLogger> lazy, SearchResultsVideoPlayerPartDefinition searchResultsVideoPlayerPartDefinition) {
        this.f25141c = channelFeedGenericLauncherPartDefinition;
        this.f25142d = channelFeedHeaderParamsFactory;
        this.f25143e = publisherInfoPartDefinition;
        this.f25144f = lazy;
        this.f25145g = searchResultsVideoPlayerPartDefinition;
    }

    @Nullable
    private ChannelFeedGenericLauncherPartDefinition.Props m28432a(final SearchResultsProps<FeedProps<GraphQLStoryAttachment>> searchResultsProps, final E e) {
        final GraphQLActor a = StoryAttachmentHelper.a((GraphQLStoryAttachment) ((FeedProps) searchResultsProps.f23388a).a);
        if (a == null) {
            return null;
        }
        ChannelFeedParams.Builder builder = new ChannelFeedParams.Builder();
        builder.k = ChannelFeedHeaderParamsFactory.a(a);
        builder = builder.b(VideoChannelHelper.a(a));
        builder.d = EntryPointInputVideoChannelEntryPoint.SEARCH;
        builder = builder;
        builder.h = EventTriggerType.BY_USER;
        builder = builder;
        builder.g = PlayerOrigin.SEARCH_RESULTS;
        ChannelFeedParams.Builder builder2 = builder;
        builder2.m = ((HasSearchResultsContext) e).mo1248s().m27102v().mo595k();
        return new ChannelFeedGenericLauncherPartDefinition.Props(builder2.a(), f25138b, new LaunchChannelFeedClickListener$OnLaunchCallback(this) {
            final /* synthetic */ SearchResultsLiveVideoPartDefinition f25136d;

            public final void mo1335a() {
                ((SearchResultsLogger) this.f25136d.f25144f.get()).m25484a(((HasSearchResultsContext) e).mo1248s(), InlineActionType.NAVIGATION, InlineActionName.OPEN_CHANNEL_FEED, a.H(), searchResultsProps.m27106d(), a.b(), null);
            }
        });
    }

    public final ViewType<View> m28434a() {
        return f25137a;
    }

    public final boolean m28436a(Object obj) {
        return true;
    }
}
