package com.facebook.pages.identity.cards.events;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.events.model.EventsCollection;
import com.facebook.graphql.enums.GraphQLEventsCalendarSubscriptionStatus;
import com.facebook.graphql.executor.GraphQLBatchRequest;
import com.facebook.graphql.executor.GraphQLCachePolicy;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.executor.GraphQLSubscriptionHolder;
import com.facebook.graphql.model.GraphQLEvent;
import com.facebook.http.interfaces.RequestPriority;
import com.facebook.inject.InjectorLike;
import com.facebook.pages.common.surface.cards.interfaces.PageCardType;
import com.facebook.pages.common.surface.cards.interfaces.PageCards.PageSecondaryCardView;
import com.facebook.pages.data.graphql.cards.EventCardGraphQL.EventCardQueryString;
import com.facebook.pages.data.graphql.cards.EventCardGraphQLModels.EventCardQueryModel;
import com.facebook.pages.data.model.pageheader.PageHeaderData;
import com.facebook.pages.identity.batching.PageCardsRenderScheduler;
import com.facebook.pages.identity.common.PageCardSpecifications.FetchType;
import com.facebook.pages.identity.common.PageCardSpecifications.PageBatchFetchingCardSpecification;
import com.facebook.pages.identity.common.PageViewPlaceHolder;
import com.facebook.pages.identity.ui.carousel.PageIdentityUpcomingEventsCardView;
import com.google.common.base.Absent;
import com.google.common.base.Optional;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.ExecutorService;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: privacy_checkup_intro_step_continue */
public class PageIdentityEventsCardSpecification implements PageBatchFetchingCardSpecification {
    private final Resources f3506a;
    public final GraphQLSubscriptionHolder f3507b;
    private final ExecutorService f3508c;
    private final Clock f3509d;

    public static PageIdentityEventsCardSpecification m4552b(InjectorLike injectorLike) {
        return new PageIdentityEventsCardSpecification(ResourcesMethodAutoProvider.a(injectorLike), GraphQLSubscriptionHolder.b(injectorLike), (ExecutorService) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(injectorLike), (Clock) SystemClockMethodAutoProvider.a(injectorLike));
    }

    public static PageIdentityEventsCardSpecification m4549a(InjectorLike injectorLike) {
        return m4552b(injectorLike);
    }

    static /* synthetic */ boolean m4551a(PageIdentityEventsCardSpecification pageIdentityEventsCardSpecification, EventCardQueryModel eventCardQueryModel) {
        boolean z = false;
        if (eventCardQueryModel != null) {
            if (eventCardQueryModel.k() != null && !eventCardQueryModel.k().a().isEmpty()) {
                z = true;
            } else if (eventCardQueryModel.a() && eventCardQueryModel.j() != GraphQLEventsCalendarSubscriptionStatus.NONE) {
                z = true;
            }
        }
        return z;
    }

    private GraphQLRequest<EventCardQueryModel> m4547a(long j) {
        GraphQLRequest a = GraphQLRequest.a((EventCardQueryString) new EventCardQueryString().a("page_id", String.valueOf(j)).a("events_max_num", Integer.valueOf(this.f3506a.getInteger(2131492912))));
        a.e = ImmutableSet.of("GraphQlPageCardTag");
        return a.a(RequestPriority.INTERACTIVE);
    }

    @Inject
    public PageIdentityEventsCardSpecification(Resources resources, GraphQLSubscriptionHolder graphQLSubscriptionHolder, ExecutorService executorService, Clock clock) {
        this.f3506a = resources;
        this.f3507b = graphQLSubscriptionHolder;
        this.f3508c = executorService;
        this.f3509d = clock;
    }

    public final boolean mo77a() {
        return true;
    }

    public static PageSecondaryCardView m4548a(Context context) {
        return new PageIdentityUpcomingEventsCardView(context);
    }

    public final PageCardType mo79b() {
        return PageCardType.EVENTS;
    }

    public final FetchType mo80c() {
        return FetchType.SECONDARY;
    }

    public final Optional<? extends ListenableFuture<? extends GraphQLResult<?>>> mo81a(long j, GraphQLBatchRequest graphQLBatchRequest, PageViewPlaceHolder pageViewPlaceHolder, Context context, LayoutInflater layoutInflater, PageHeaderData pageHeaderData, GraphQLCachePolicy graphQLCachePolicy, PageCardsRenderScheduler pageCardsRenderScheduler) {
        if (!pageHeaderData.g().y()) {
            return Absent.withType();
        }
        GraphQLRequest a = m4547a(j);
        if (a == null) {
            return Absent.withType();
        }
        a.a(graphQLCachePolicy);
        ListenableFuture b = graphQLBatchRequest.b(a);
        Futures.a(b, m4550a(j, pageViewPlaceHolder, context, layoutInflater, pageHeaderData, pageCardsRenderScheduler), this.f3508c);
        return Optional.of(b);
    }

    private FutureCallback<GraphQLResult<EventCardQueryModel>> m4550a(long j, PageViewPlaceHolder pageViewPlaceHolder, Context context, LayoutInflater layoutInflater, PageHeaderData pageHeaderData, PageCardsRenderScheduler pageCardsRenderScheduler) {
        final PageViewPlaceHolder pageViewPlaceHolder2 = pageViewPlaceHolder;
        final LayoutInflater layoutInflater2 = layoutInflater;
        final Context context2 = context;
        final long j2 = j;
        final PageHeaderData pageHeaderData2 = pageHeaderData;
        final PageCardsRenderScheduler pageCardsRenderScheduler2 = pageCardsRenderScheduler;
        return new FutureCallback<GraphQLResult<EventCardQueryModel>>(this) {
            final /* synthetic */ PageIdentityEventsCardSpecification f3505g;

            /* compiled from: privacy_checkup_intro_step_continue */
            class C04751 implements FutureCallback<GraphQLResult<GraphQLEvent>> {
                final /* synthetic */ C04771 f3496a;

                C04751(C04771 c04771) {
                    this.f3496a = c04771;
                }

                public void onSuccess(@Nullable Object obj) {
                    GraphQLResult graphQLResult = (GraphQLResult) obj;
                    View view = pageViewPlaceHolder2.f3791d;
                    if (view != null && graphQLResult != null && graphQLResult.e != null) {
                        GraphQLEvent graphQLEvent = (GraphQLEvent) graphQLResult.e;
                        PageIdentityEventsCarouselAdapter pageIdentityEventsCarouselAdapter = ((PageIdentityUpcomingEventsCardView) view).f4264a;
                        EventsCollection eventsCollection = pageIdentityEventsCarouselAdapter.f3516d;
                        Integer num = (Integer) eventsCollection.a.get(graphQLEvent.a());
                        if (num != null) {
                            eventsCollection.b.set(num.intValue(), graphQLEvent);
                        }
                        pageIdentityEventsCarouselAdapter.a(pageIdentityEventsCarouselAdapter.f3516d.b());
                    }
                }

                public void onFailure(Throwable th) {
                }
            }

            public void onSuccess(@Nullable Object obj) {
                GraphQLResult graphQLResult = (GraphQLResult) obj;
                if (graphQLResult != null) {
                    final EventCardQueryModel eventCardQueryModel = (EventCardQueryModel) graphQLResult.e;
                    if (PageIdentityEventsCardSpecification.m4551a(this.f3505g, eventCardQueryModel)) {
                        ImmutableList a = PageIdentityUpcomingEventsCardView.m5231a(eventCardQueryModel);
                        int size = a.size();
                        for (int i = 0; i < size; i++) {
                            GraphQLEvent graphQLEvent = (GraphQLEvent) a.get(i);
                            this.f3505g.f3507b.a(new C04751(this), graphQLEvent.as(), new GraphQLResult(graphQLEvent, graphQLResult.a(), graphQLResult.b(), ImmutableSet.of(graphQLEvent.as())));
                        }
                        pageCardsRenderScheduler2.m4244a(this.f3505g.mo79b(), new Runnable(this) {
                            final /* synthetic */ C04771 f3498b;

                            public void run() {
                                View view = pageViewPlaceHolder2.f3791d;
                                if (view == null) {
                                    view = (View) PageIdentityEventsCardSpecification.m4548a(context2);
                                    pageViewPlaceHolder2.m4758a(view);
                                }
                                ((PageIdentityUpcomingEventsCardView) view).m5235a(j2, pageHeaderData2.e.D(), eventCardQueryModel);
                            }
                        });
                    }
                }
            }

            public void onFailure(Throwable th) {
            }
        };
    }
}
