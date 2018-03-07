package com.facebook.search.results.rows.sections.videos;

import android.content.Context;
import android.view.View;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.autoplay.DefaultVideoAutoplayControllerProvider;
import com.facebook.feed.autoplay.VideoViewController;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feedplugins.video.RichVideoAttachmentView;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.GraphQLStoryAttachment;
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
import com.facebook.search.results.environment.videos.HasSearchResultsVideoStoryPersistentState;
import com.facebook.search.results.environment.videos.SearchResultsVideoStoryPersistentState;
import com.facebook.search.results.model.SearchResultsProps;
import com.facebook.video.analytics.VideoAnalytics.PlayerOrigin;
import com.facebook.video.analytics.VideoDisplayedInfo;
import com.facebook.video.analytics.VideoFeedStoryInfo;
import com.facebook.video.engine.VideoPlayerParams;
import javax.annotation.concurrent.Immutable;
import javax.inject.Inject;

@ContextScoped
/* compiled from: PLACE_TIPS */
public class SearchResultsVideoAutoplayPartDefinition extends BaseSinglePartDefinition<Props, Void, HasSearchResultsVideoStoryPersistentState, RichVideoAttachmentView> {
    private static SearchResultsVideoAutoplayPartDefinition f25160c;
    private static final Object f25161d = new Object();
    private final SearchResultsCenteredVideoAutoplayManager f25162a;
    private final DefaultVideoAutoplayControllerProvider f25163b;

    @Immutable
    /* compiled from: PLACE_TIPS */
    public final class Props {
        public final SearchResultsProps<FeedProps<GraphQLStoryAttachment>> f25154a;
        public final GraphQLStory f25155b;
        public final VideoDisplayedInfo f25156c;
        public final VideoPlayerParams f25157d;
        public final VideoFeedStoryInfo f25158e;
        public final PlayerOrigin f25159f;

        public Props(SearchResultsProps<FeedProps<GraphQLStoryAttachment>> searchResultsProps, GraphQLStory graphQLStory, VideoDisplayedInfo videoDisplayedInfo, VideoPlayerParams videoPlayerParams, VideoFeedStoryInfo videoFeedStoryInfo, PlayerOrigin playerOrigin) {
            this.f25154a = searchResultsProps;
            this.f25155b = graphQLStory;
            this.f25156c = videoDisplayedInfo;
            this.f25157d = videoPlayerParams;
            this.f25158e = videoFeedStoryInfo;
            this.f25159f = playerOrigin;
        }
    }

    private static SearchResultsVideoAutoplayPartDefinition m28448b(InjectorLike injectorLike) {
        return new SearchResultsVideoAutoplayPartDefinition(SearchResultsCenteredVideoAutoplayManager.m28411a(injectorLike), (DefaultVideoAutoplayControllerProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(DefaultVideoAutoplayControllerProvider.class));
    }

    public final /* bridge */ /* synthetic */ void m28449a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, -169875140);
        m28447a((Props) obj, (HasSearchResultsVideoStoryPersistentState) anyEnvironment, (RichVideoAttachmentView) view);
        Logger.a(8, EntryType.MARK_POP, 661902899, a);
    }

    public final void m28450b(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        RichVideoAttachmentView richVideoAttachmentView = (RichVideoAttachmentView) view;
        VideoViewController videoViewController = ((HasSearchResultsVideoStoryPersistentState) anyEnvironment).mo1257d(((Props) obj).f25154a).f22722c;
        this.f25162a.f25115a.a(richVideoAttachmentView);
    }

    public static SearchResultsVideoAutoplayPartDefinition m28446a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            SearchResultsVideoAutoplayPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f25161d) {
                SearchResultsVideoAutoplayPartDefinition searchResultsVideoAutoplayPartDefinition;
                if (a2 != null) {
                    searchResultsVideoAutoplayPartDefinition = (SearchResultsVideoAutoplayPartDefinition) a2.a(f25161d);
                } else {
                    searchResultsVideoAutoplayPartDefinition = f25160c;
                }
                if (searchResultsVideoAutoplayPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m28448b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f25161d, b3);
                        } else {
                            f25160c = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = searchResultsVideoAutoplayPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public SearchResultsVideoAutoplayPartDefinition(SearchResultsCenteredVideoAutoplayManager searchResultsCenteredVideoAutoplayManager, DefaultVideoAutoplayControllerProvider defaultVideoAutoplayControllerProvider) {
        this.f25162a = searchResultsCenteredVideoAutoplayManager;
        this.f25163b = defaultVideoAutoplayControllerProvider;
    }

    private void m28447a(Props props, HasSearchResultsVideoStoryPersistentState hasSearchResultsVideoStoryPersistentState, RichVideoAttachmentView richVideoAttachmentView) {
        SearchResultsVideoStoryPersistentState d = hasSearchResultsVideoStoryPersistentState.mo1257d(props.f25154a);
        VideoViewController videoViewController = d.f22722c;
        if (videoViewController == null) {
            videoViewController = this.f25163b.a(props.f25157d.b, d, props.f25156c, props.f25157d, props.f25158e, props.f25159f);
            d.f22722c = videoViewController;
        }
        richVideoAttachmentView.a();
        this.f25162a.f25115a.a(richVideoAttachmentView, videoViewController);
    }
}
