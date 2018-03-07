package com.facebook.events.dashboard.suggestions;

import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.events.carousel.EventsCarouselPagerAdapter;
import com.facebook.events.graphql.EventsGraphQL.FetchSuggestionsForForCutTypeString;
import com.facebook.events.graphql.EventsGraphQL.FetchUserSuggestionsString;
import com.facebook.events.graphql.EventsGraphQLInterfaces.EventCommonFragment;
import com.facebook.events.graphql.EventsGraphQLModels.FetchSuggestionsForForCutTypeModel;
import com.facebook.events.graphql.EventsGraphQLModels.FetchUserSuggestionsModel;
import com.facebook.events.graphql.EventsGraphQLModels.SuggestedEventCutModel;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.executor.GraphQLSubscriptionHolder;
import com.facebook.inject.InjectorLike;
import com.facebook.ui.futures.TasksManager;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Callable;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: commerce/shop/{#%s} */
public class EventsSuggestionsPager {
    public final GraphQLQueryExecutor f17227a;
    public final TasksManager f17228b;
    private final GraphQLSubscriptionHolder f17229c;
    private final FutureCallback<GraphQLResult<EventCommonFragment>> f17230d = new C24161(this);
    public EventsCarouselPagerAdapter f17231e;

    /* compiled from: commerce/shop/{#%s} */
    public interface EventsSuggestionsCallback {
        void mo783a();

        void mo784a(@Nonnull SuggestedEventCutModel suggestedEventCutModel);
    }

    /* compiled from: commerce/shop/{#%s} */
    class C24161 implements FutureCallback<GraphQLResult<EventCommonFragment>> {
        final /* synthetic */ EventsSuggestionsPager f17214a;

        C24161(EventsSuggestionsPager eventsSuggestionsPager) {
            this.f17214a = eventsSuggestionsPager;
        }

        public void onSuccess(@Nullable Object obj) {
            GraphQLResult graphQLResult = (GraphQLResult) obj;
            if (graphQLResult != null) {
                EventCommonFragment eventCommonFragment = (EventCommonFragment) graphQLResult.e;
                if (this.f17214a.f17231e != null) {
                    this.f17214a.f17231e.m16432a(eventCommonFragment);
                }
            }
        }

        public void onFailure(Throwable th) {
        }
    }

    /* compiled from: commerce/shop/{#%s} */
    public class C24172 implements Callable<ListenableFuture<GraphQLResult<FetchUserSuggestionsModel>>> {
        final /* synthetic */ int f17215a;
        final /* synthetic */ int f17216b;
        final /* synthetic */ EventsSuggestionsPager f17217c;

        public C24172(EventsSuggestionsPager eventsSuggestionsPager, int i, int i2) {
            this.f17217c = eventsSuggestionsPager;
            this.f17215a = i;
            this.f17216b = i2;
        }

        public Object call() {
            GraphQLRequest a = GraphQLRequest.a(new FetchUserSuggestionsString());
            a.a(new FetchUserSuggestionsString().a("cuts_count", String.valueOf(this.f17215a)).a("per_cut_count", String.valueOf(this.f17216b)).a);
            return this.f17217c.f17227a.a(a);
        }
    }

    /* compiled from: commerce/shop/{#%s} */
    public class C24183 extends AbstractDisposableFutureCallback<GraphQLResult<FetchUserSuggestionsModel>> {
        final /* synthetic */ EventsSuggestionsCallback f17218a;
        final /* synthetic */ EventsSuggestionsPager f17219b;

        public C24183(EventsSuggestionsPager eventsSuggestionsPager, EventsSuggestionsCallback eventsSuggestionsCallback) {
            this.f17219b = eventsSuggestionsPager;
            this.f17218a = eventsSuggestionsCallback;
        }

        protected final void m17534a(Object obj) {
            GraphQLResult graphQLResult = (GraphQLResult) obj;
            if (!(graphQLResult.e == null || ((FetchUserSuggestionsModel) graphQLResult.e).a() == null)) {
                ImmutableList a = ((FetchUserSuggestionsModel) graphQLResult.e).a().a();
                int size = a.size();
                int i = 0;
                while (i < size) {
                    SuggestedEventCutModel suggestedEventCutModel = (SuggestedEventCutModel) a.get(i);
                    if (suggestedEventCutModel.c() == null || suggestedEventCutModel.c().a().isEmpty()) {
                        i++;
                    } else {
                        this.f17218a.mo784a(suggestedEventCutModel);
                        EventsSuggestionsPager.m17539a(this.f17219b, suggestedEventCutModel, graphQLResult);
                        return;
                    }
                }
            }
            m17533b();
        }

        protected final void m17535a(Throwable th) {
            m17533b();
        }

        private void m17533b() {
            this.f17218a.mo783a();
        }
    }

    /* compiled from: commerce/shop/{#%s} */
    public enum EventsSuggestionsFetcherTask {
        FETCH_EVENTS_SUGGESTIONS_CUTS,
        FETCH_EVENTS_SUGGESTIONS_FOR_CUT
    }

    public static EventsSuggestionsPager m17540b(InjectorLike injectorLike) {
        return new EventsSuggestionsPager(GraphQLQueryExecutor.a(injectorLike), TasksManager.b(injectorLike), GraphQLSubscriptionHolder.b(injectorLike));
    }

    @Inject
    public EventsSuggestionsPager(GraphQLQueryExecutor graphQLQueryExecutor, TasksManager tasksManager, GraphQLSubscriptionHolder graphQLSubscriptionHolder) {
        this.f17227a = graphQLQueryExecutor;
        this.f17228b = tasksManager;
        this.f17229c = graphQLSubscriptionHolder;
    }

    public final void m17542a(int i, int i2, @Nonnull String str, String str2, final EventsSuggestionsCallback eventsSuggestionsCallback) {
        final String str3 = str;
        final String str4 = str2;
        final int i3 = i2;
        final int i4 = i;
        this.f17228b.a(EventsSuggestionsFetcherTask.FETCH_EVENTS_SUGGESTIONS_FOR_CUT, new Callable<ListenableFuture<GraphQLResult<FetchSuggestionsForForCutTypeModel>>>(this) {
            final /* synthetic */ EventsSuggestionsPager f17224e;

            public Object call() {
                GraphQLRequest a = GraphQLRequest.a(new FetchSuggestionsForForCutTypeString());
                a.a(new FetchSuggestionsForForCutTypeString().a("cut_type", Lists.a(new String[]{str3})).a("end_cursor", str4).a("per_cut_count", String.valueOf(i3)).a("profile_image_size", String.valueOf(i4)).a);
                return this.f17224e.f17227a.a(a);
            }
        }, new AbstractDisposableFutureCallback<GraphQLResult<FetchSuggestionsForForCutTypeModel>>(this) {
            final /* synthetic */ EventsSuggestionsPager f17226b;

            protected final void m17537a(Object obj) {
                GraphQLResult graphQLResult = (GraphQLResult) obj;
                if (!(graphQLResult.e == null || ((FetchSuggestionsForForCutTypeModel) graphQLResult.e).a() == null)) {
                    ImmutableList a = ((FetchSuggestionsForForCutTypeModel) graphQLResult.e).a().a();
                    int size = a.size();
                    int i = 0;
                    while (i < size) {
                        SuggestedEventCutModel suggestedEventCutModel = (SuggestedEventCutModel) a.get(i);
                        if (suggestedEventCutModel.c() == null || suggestedEventCutModel.c().a().isEmpty()) {
                            i++;
                        } else {
                            eventsSuggestionsCallback.mo784a(suggestedEventCutModel);
                            return;
                        }
                    }
                }
                m17536b();
            }

            protected final void m17538a(Throwable th) {
                m17536b();
            }

            private void m17536b() {
                eventsSuggestionsCallback.mo783a();
            }
        });
    }

    public final void m17541a() {
        this.f17228b.c();
    }

    public static void m17539a(EventsSuggestionsPager eventsSuggestionsPager, SuggestedEventCutModel suggestedEventCutModel, GraphQLResult graphQLResult) {
        ImmutableList a = suggestedEventCutModel.c().a();
        int size = a.size();
        for (int i = 0; i < size; i++) {
            EventCommonFragment eventCommonFragment = (EventCommonFragment) a.get(i);
            eventsSuggestionsPager.f17229c.a(eventsSuggestionsPager.f17230d, eventCommonFragment.dL_(), new GraphQLResult(eventCommonFragment, graphQLResult.freshness, graphQLResult.clientTimeMs, ImmutableSet.of(eventCommonFragment.dL_())));
        }
    }
}
