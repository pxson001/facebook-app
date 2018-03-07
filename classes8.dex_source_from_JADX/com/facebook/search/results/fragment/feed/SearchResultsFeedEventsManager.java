package com.facebook.search.results.fragment.feed;

import com.facebook.content.event.FbEvent;
import com.facebook.controller.mutation.FeedbackMutationHelper;
import com.facebook.controller.mutation.MutationCallback;
import com.facebook.fbservice.service.ServiceException;
import com.facebook.feed.rows.LikeProcessor;
import com.facebook.feed.rows.core.events.Action;
import com.facebook.feed.rows.core.events.EventsStream;
import com.facebook.feed.rows.core.events.Subscription;
import com.facebook.feed.rows.core.props.StoryProps;
import com.facebook.feed.util.event.FeedEventBus;
import com.facebook.feed.util.event.StoryEvents.FeedUnitMutatedEvent;
import com.facebook.feedback.reactions.api.ReactionsMutationController;
import com.facebook.graphql.model.FeedUnit;
import com.facebook.graphql.model.GraphQLFeedback;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.inject.Assisted;
import com.facebook.search.common.errors.GraphSearchError;
import com.facebook.search.common.errors.GraphSearchErrorReporter;
import com.facebook.search.logging.SearchResultsLogger;
import com.facebook.search.logging.api.SearchResultsAnalytics.StoryAction;
import com.facebook.search.results.environment.SearchResultsFeedEnvironmentGenerated;
import com.facebook.search.results.model.SearchResultsFeedCollection;
import com.facebook.search.results.model.SearchResultsMutableContext;
import com.facebook.search.results.model.contract.SearchResultsGraphQLStoryFeedUnit;
import com.facebook.search.results.mutator.SearchResultsStoryLikeMutator;
import com.facebook.search.results.rows.events.SearchResultsFeedUnitUpdateEvent;
import com.facebook.search.results.rows.events.SearchResultsStoryLikeEvent;
import com.facebook.search.results.rows.events.SearchResultsStoryReactionUpdatedEvent;
import com.facebook.ultralight.Lazy;
import com.facebook.ultralight.UltralightRuntime;
import com.google.common.base.Absent;
import com.google.common.base.Optional;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

@Deprecated
/* compiled from: SHARE_PHOTO_TO_PAGE_TAP */
public class SearchResultsFeedEventsManager {
    public final EventsStream f23014a;
    public final FeedEventBus f23015b;
    @Inject
    @Lazy
    public com.facebook.inject.Lazy<SearchResultsStoryLikeMutator> f23016c = UltralightRuntime.b;
    public final SearchResultsFeedEnvironmentGenerated f23017d;
    public final SearchResultsFeedCollection f23018e;
    public final SearchResultsLogger f23019f;
    public final List<Subscription> f23020g;
    public final SearchResultsMutableContext f23021h;
    public final GraphSearchErrorReporter f23022i;
    @Inject
    @Lazy
    public com.facebook.inject.Lazy<FeedbackMutationHelper> f23023j = UltralightRuntime.b;
    @Inject
    @Lazy
    public com.facebook.inject.Lazy<ReactionsMutationController> f23024k = UltralightRuntime.b;
    @Inject
    @Lazy
    public com.facebook.inject.Lazy<LikeProcessor> f23025l = UltralightRuntime.b;
    public FeedUnitMutatedEventSubscriber f23026m;

    /* compiled from: SHARE_PHOTO_TO_PAGE_TAP */
    public class FeedUnitMutatedEventSubscriber extends com.facebook.feed.util.event.StoryEvents.FeedUnitMutatedEventSubscriber {
        final /* synthetic */ SearchResultsFeedEventsManager f23011a;

        public FeedUnitMutatedEventSubscriber(SearchResultsFeedEventsManager searchResultsFeedEventsManager) {
            this.f23011a = searchResultsFeedEventsManager;
        }

        public final void m26642b(FbEvent fbEvent) {
            FeedUnitMutatedEvent feedUnitMutatedEvent = (FeedUnitMutatedEvent) fbEvent;
            if ((feedUnitMutatedEvent.a instanceof GraphQLStory) && this.f23011a.f23017d.mo1244a(feedUnitMutatedEvent.a)) {
                this.f23011a.f23017d.mo1242a((GraphQLStory) feedUnitMutatedEvent.a);
                this.f23011a.f23017d.hL_();
            }
        }
    }

    /* compiled from: SHARE_PHOTO_TO_PAGE_TAP */
    public class SearchResultsStoryLikeEventAction implements Action<SearchResultsStoryLikeEvent> {
        final /* synthetic */ SearchResultsFeedEventsManager f23012a;

        public SearchResultsStoryLikeEventAction(SearchResultsFeedEventsManager searchResultsFeedEventsManager) {
            this.f23012a = searchResultsFeedEventsManager;
        }

        public final void m26644a(Object obj) {
            SearchResultsStoryLikeEvent searchResultsStoryLikeEvent = (SearchResultsStoryLikeEvent) obj;
            FeedUnit feedUnit = (GraphQLStory) searchResultsStoryLikeEvent.f23590a.a;
            SearchResultsStoryLikeMutator searchResultsStoryLikeMutator = (SearchResultsStoryLikeMutator) this.f23012a.f23016c.get();
            FeedUnit d = StoryProps.d(searchResultsStoryLikeMutator.f23557a.a(searchResultsStoryLikeEvent.f23590a, searchResultsStoryLikeMutator.f23558b, searchResultsStoryLikeEvent.f23591b));
            Optional a = this.f23012a.f23018e.m27055a(feedUnit);
            if (a.isPresent()) {
                SearchResultsGraphQLStoryFeedUnit a2 = ((SearchResultsGraphQLStoryFeedUnit) a.get()).mo1332a(d);
                m26643a(feedUnit, this.f23012a.f23018e.m27064b((FeedUnit) a.get()), searchResultsStoryLikeEvent.f23591b);
                SearchResultsFeedEventsManager.m26648a(this.f23012a, searchResultsStoryLikeEvent, (FeedUnit) a.get(), a2);
                return;
            }
            FeedUnit c = StoryProps.c(searchResultsStoryLikeEvent.f23590a);
            if (c != null) {
                a = this.f23012a.f23018e.m27055a(c);
            } else {
                a = Absent.INSTANCE;
            }
            if (a.isPresent()) {
                d = ((SearchResultsGraphQLStoryFeedUnit) a.get()).mo1332a(d);
            }
            c = a.isPresent() ? (FeedUnit) a.get() : feedUnit;
            m26643a(feedUnit, this.f23012a.f23018e.m27064b(c), searchResultsStoryLikeEvent.f23591b);
            SearchResultsFeedEventsManager.m26648a(this.f23012a, searchResultsStoryLikeEvent, c, d);
        }

        private void m26643a(GraphQLStory graphQLStory, int i, boolean z) {
            this.f23012a.f23019f.m25477a(this.f23012a.f23021h, i, graphQLStory.g(), z ? StoryAction.LIKED : StoryAction.UNLIKED, this.f23012a.f23018e.m27054a(graphQLStory), this.f23012a.f23018e.m27066b(graphQLStory));
        }
    }

    /* compiled from: SHARE_PHOTO_TO_PAGE_TAP */
    public class SearchResultsStoryReactionUpdatedEventAction implements Action<SearchResultsStoryReactionUpdatedEvent> {
        final /* synthetic */ SearchResultsFeedEventsManager f23013a;

        public SearchResultsStoryReactionUpdatedEventAction(SearchResultsFeedEventsManager searchResultsFeedEventsManager) {
            this.f23013a = searchResultsFeedEventsManager;
        }

        public final void m26646a(Object obj) {
            SearchResultsStoryReactionUpdatedEvent searchResultsStoryReactionUpdatedEvent = (SearchResultsStoryReactionUpdatedEvent) obj;
            FeedUnit feedUnit = (GraphQLStory) searchResultsStoryReactionUpdatedEvent.f23592a.a;
            FeedUnit a = ((ReactionsMutationController) this.f23013a.f23024k.get()).a(feedUnit, searchResultsStoryReactionUpdatedEvent.f23593b, searchResultsStoryReactionUpdatedEvent.f23594c);
            Optional a2 = this.f23013a.f23018e.m27055a(feedUnit);
            if (a2.isPresent()) {
                SearchResultsGraphQLStoryFeedUnit a3 = ((SearchResultsGraphQLStoryFeedUnit) a2.get()).mo1332a(a);
                m26645a(feedUnit, this.f23013a.f23018e.m27064b((FeedUnit) a2.get()), searchResultsStoryReactionUpdatedEvent.f23594c.e);
                SearchResultsFeedEventsManager.m26647a(this.f23013a, (FeedUnit) a2.get(), a3);
                return;
            }
            FeedUnit c = StoryProps.c(searchResultsStoryReactionUpdatedEvent.f23592a);
            if (c != null) {
                a2 = this.f23013a.f23018e.m27055a(c);
            } else {
                a2 = Absent.INSTANCE;
            }
            if (a2.isPresent()) {
                a = ((SearchResultsGraphQLStoryFeedUnit) a2.get()).mo1332a(a);
            }
            c = a2.isPresent() ? (FeedUnit) a2.get() : feedUnit;
            m26645a(feedUnit, this.f23013a.f23018e.m27064b(c), searchResultsStoryReactionUpdatedEvent.f23594c.e);
            SearchResultsFeedEventsManager.m26647a(this.f23013a, c, a);
        }

        private void m26645a(GraphQLStory graphQLStory, int i, int i2) {
            this.f23013a.f23019f.m25477a(this.f23013a.f23021h, i, graphQLStory.g(), i2 != 0 ? StoryAction.REACTED : StoryAction.UNREACTED, this.f23013a.f23018e.m27054a(graphQLStory), this.f23013a.f23018e.m27066b(graphQLStory));
        }
    }

    public static void m26648a(SearchResultsFeedEventsManager searchResultsFeedEventsManager, SearchResultsStoryLikeEvent searchResultsStoryLikeEvent, final FeedUnit feedUnit, final FeedUnit feedUnit2) {
        if (((GraphQLStory) searchResultsStoryLikeEvent.f23590a.a).B() != searchResultsStoryLikeEvent.f23591b) {
            ((FeedbackMutationHelper) searchResultsFeedEventsManager.f23023j.get()).a(((GraphQLStory) searchResultsStoryLikeEvent.f23590a.a).l(), null, false, new MutationCallback<GraphQLFeedback>(searchResultsFeedEventsManager) {
                final /* synthetic */ SearchResultsFeedEventsManager f23010c;

                public final /* bridge */ /* synthetic */ void m26640b(Object obj) {
                }

                public final /* bridge */ /* synthetic */ void m26641c(Object obj) {
                }

                public final void m26638a(Object obj) {
                    SearchResultsFeedEventsManager.m26647a(this.f23010c, feedUnit, feedUnit2);
                }

                public final void m26639a(Object obj, ServiceException serviceException) {
                    this.f23010c.f23022i.a(GraphSearchError.FAILED_MUTATION, serviceException);
                    SearchResultsFeedEventsManager.m26647a(this.f23010c, feedUnit2, feedUnit);
                }
            });
        }
    }

    @Inject
    public SearchResultsFeedEventsManager(@Assisted SearchResultsMutableContext searchResultsMutableContext, @Assisted SearchResultsFeedCollection searchResultsFeedCollection, @Assisted SearchResultsFeedEnvironmentGenerated searchResultsFeedEnvironmentGenerated, EventsStream eventsStream, FeedEventBus feedEventBus, SearchResultsLogger searchResultsLogger, GraphSearchErrorReporter graphSearchErrorReporter) {
        this.f23021h = searchResultsMutableContext;
        this.f23018e = searchResultsFeedCollection;
        this.f23017d = searchResultsFeedEnvironmentGenerated;
        this.f23014a = eventsStream;
        this.f23015b = feedEventBus;
        this.f23020g = new ArrayList();
        this.f23019f = searchResultsLogger;
        this.f23022i = graphSearchErrorReporter;
    }

    public final void m26649b() {
        for (Subscription a : this.f23020g) {
            this.f23014a.a(a);
        }
        this.f23015b.b(this.f23026m);
        this.f23020g.clear();
    }

    public static void m26647a(SearchResultsFeedEventsManager searchResultsFeedEventsManager, FeedUnit feedUnit, FeedUnit feedUnit2) {
        searchResultsFeedEventsManager.f23018e.m27059a(feedUnit, feedUnit2);
        searchResultsFeedEventsManager.f23014a.a(new SearchResultsFeedUnitUpdateEvent(feedUnit));
    }
}
