package com.facebook.events.mutators;

import com.facebook.events.common.ActionMechanism;
import com.facebook.events.common.EventActionContext;
import com.facebook.events.common.EventAnalyticsParams;
import com.facebook.events.graphql.EventsGraphQLInterfaces.EventCommonFragment;
import com.facebook.events.graphql.EventsGraphQLModels.FetchEventPermalinkFragmentModel;
import com.facebook.events.graphql.EventsMutations;
import com.facebook.events.graphql.EventsMutations.WatchEventMutationString;
import com.facebook.events.graphql.EventsMutationsModels.OptimisticRsvpEventModel;
import com.facebook.events.graphql.EventsMutationsModels.OptimisticRsvpEventModel.Builder;
import com.facebook.events.graphql.EventsMutationsModels.OptimisticRsvpEventModel.EventInviteesModel;
import com.facebook.events.graphql.EventsMutationsModels.OptimisticRsvpEventModel.EventMembersModel;
import com.facebook.events.graphql.EventsMutationsModels.OptimisticRsvpEventModel.EventWatchersModel;
import com.facebook.events.graphql.EventsMutationsModels.WatchEventMutationModel;
import com.facebook.events.model.Event;
import com.facebook.graphql.calls.EventUpdateExtendedViewerWatchStatusInputData;
import com.facebook.graphql.calls.EventUpdateExtendedViewerWatchStatusInputData.Context;
import com.facebook.graphql.calls.EventUpdateExtendedViewerWatchStatusInputData.Context.EventActionHistory;
import com.facebook.graphql.calls.EventUpdateExtendedViewerWatchStatusInputData.WatchStatus;
import com.facebook.graphql.enums.GraphQLEventWatchStatus;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.inject.InjectorLike;
import com.facebook.notifications.logging.NotificationsFunnelLogger;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.MoreExecutors.DirectExecutor;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: suggested_recipients */
public class PublicEventsRsvpMutator {
    private final GraphQLQueryExecutor f2777a;
    public final NotificationsFunnelLogger f2778b;

    /* compiled from: suggested_recipients */
    public /* synthetic */ class C02442 {
        public static final /* synthetic */ int[] f2776a = new int[GraphQLEventWatchStatus.values().length];

        static {
            try {
                f2776a[GraphQLEventWatchStatus.WATCHED.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f2776a[GraphQLEventWatchStatus.GOING.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f2776a[GraphQLEventWatchStatus.UNWATCHED.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f2776a[GraphQLEventWatchStatus.DECLINED.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
        }
    }

    public static PublicEventsRsvpMutator m3049b(InjectorLike injectorLike) {
        return new PublicEventsRsvpMutator(GraphQLQueryExecutor.a(injectorLike), NotificationsFunnelLogger.a(injectorLike));
    }

    public static PublicEventsRsvpMutator m3046a(InjectorLike injectorLike) {
        return m3049b(injectorLike);
    }

    @Inject
    public PublicEventsRsvpMutator(GraphQLQueryExecutor graphQLQueryExecutor, NotificationsFunnelLogger notificationsFunnelLogger) {
        this.f2777a = graphQLQueryExecutor;
        this.f2778b = notificationsFunnelLogger;
    }

    public final ListenableFuture<GraphQLResult<WatchEventMutationModel>> m3052a(String str, GraphQLEventWatchStatus graphQLEventWatchStatus, String str2, String str3, ActionMechanism actionMechanism) {
        return m3053a(str, graphQLEventWatchStatus, str2, "unknown", str3, actionMechanism != null ? actionMechanism.toString() : "unknown");
    }

    public final ListenableFuture<GraphQLResult<WatchEventMutationModel>> m3053a(String str, GraphQLEventWatchStatus graphQLEventWatchStatus, String str2, String str3, String str4, String str5) {
        return m3047a(str, graphQLEventWatchStatus, new EventAnalyticsParams(EventActionContext.a, str2, str3, str4, null), str5);
    }

    public final ListenableFuture<GraphQLResult<WatchEventMutationModel>> m3050a(EventCommonFragment eventCommonFragment, GraphQLEventWatchStatus graphQLEventWatchStatus, EventAnalyticsParams eventAnalyticsParams, ActionMechanism actionMechanism) {
        return m3048a(eventCommonFragment.dL_(), graphQLEventWatchStatus, m3045a(eventCommonFragment, graphQLEventWatchStatus, eventCommonFragment.q()), eventAnalyticsParams, actionMechanism != null ? actionMechanism.toString() : "unknown");
    }

    private static OptimisticRsvpEventModel m3045a(EventCommonFragment eventCommonFragment, GraphQLEventWatchStatus graphQLEventWatchStatus, GraphQLEventWatchStatus graphQLEventWatchStatus2) {
        int i = 0;
        Builder builder = new Builder();
        builder.e = eventCommonFragment.dL_();
        builder = builder;
        builder.g = false;
        builder = builder;
        builder.h = graphQLEventWatchStatus;
        builder = builder;
        builder.f = Event.m2984a(graphQLEventWatchStatus);
        Builder builder2 = builder;
        if (eventCommonFragment instanceof FetchEventPermalinkFragmentModel) {
            FetchEventPermalinkFragmentModel fetchEventPermalinkFragmentModel = (FetchEventPermalinkFragmentModel) eventCommonFragment;
            int a = fetchEventPermalinkFragmentModel.ax() == null ? 0 : fetchEventPermalinkFragmentModel.ax().a();
            int a2 = fetchEventPermalinkFragmentModel.aG() == null ? 0 : fetchEventPermalinkFragmentModel.aG().a();
            if (graphQLEventWatchStatus == GraphQLEventWatchStatus.GOING) {
                EventMembersModel.Builder builder3 = new EventMembersModel.Builder();
                builder3.a = a + 1;
                builder2.c = builder3.a();
            } else if (graphQLEventWatchStatus == GraphQLEventWatchStatus.WATCHED) {
                EventWatchersModel.Builder builder4 = new EventWatchersModel.Builder();
                builder4.a = a2 + 1;
                builder2.d = builder4.a();
            }
            if (graphQLEventWatchStatus2 == GraphQLEventWatchStatus.GOING) {
                EventMembersModel.Builder builder5 = new EventMembersModel.Builder();
                builder5.a = a - 1;
                builder2.c = builder5.a();
            } else if (graphQLEventWatchStatus2 == GraphQLEventWatchStatus.WATCHED) {
                EventWatchersModel.Builder builder6 = new EventWatchersModel.Builder();
                builder6.a = a2 - 1;
                builder2.d = builder6.a();
            }
            if (fetchEventPermalinkFragmentModel.p()) {
                if (fetchEventPermalinkFragmentModel.av() != null) {
                    i = fetchEventPermalinkFragmentModel.av().a();
                }
                EventInviteesModel.Builder builder7 = new EventInviteesModel.Builder();
                builder7.a = i - 1;
                builder2.a = builder7.a();
            }
        }
        return builder2.a();
    }

    private ListenableFuture<GraphQLResult<WatchEventMutationModel>> m3047a(String str, GraphQLEventWatchStatus graphQLEventWatchStatus, EventAnalyticsParams eventAnalyticsParams, String str2) {
        Builder builder = new Builder();
        builder.e = str;
        builder = builder;
        builder.g = false;
        builder = builder;
        builder.h = graphQLEventWatchStatus;
        builder = builder;
        builder.f = Event.m2984a(graphQLEventWatchStatus);
        return m3048a(str, graphQLEventWatchStatus, builder.a(), eventAnalyticsParams, str2);
    }

    public final ListenableFuture<GraphQLResult<WatchEventMutationModel>> m3051a(String str, GraphQLEventWatchStatus graphQLEventWatchStatus, EventAnalyticsParams eventAnalyticsParams, ActionMechanism actionMechanism) {
        return m3047a(str, graphQLEventWatchStatus, eventAnalyticsParams, actionMechanism != null ? actionMechanism.toString() : "unknown");
    }

    private ListenableFuture<GraphQLResult<WatchEventMutationModel>> m3048a(String str, final GraphQLEventWatchStatus graphQLEventWatchStatus, OptimisticRsvpEventModel optimisticRsvpEventModel, EventAnalyticsParams eventAnalyticsParams, String str2) {
        WatchStatus watchStatus = null;
        if (graphQLEventWatchStatus != null) {
            switch (C02442.f2776a[graphQLEventWatchStatus.ordinal()]) {
                case 1:
                    watchStatus = WatchStatus.WATCHED;
                    break;
                case 2:
                    watchStatus = WatchStatus.GOING;
                    break;
                case 3:
                    watchStatus = WatchStatus.UNWATCHED;
                    break;
                case 4:
                    watchStatus = WatchStatus.DECLINED;
                    break;
                default:
                    break;
            }
        }
        WatchStatus watchStatus2 = watchStatus;
        EventUpdateExtendedViewerWatchStatusInputData eventUpdateExtendedViewerWatchStatusInputData = new EventUpdateExtendedViewerWatchStatusInputData();
        EventActionHistory eventActionHistory = new EventActionHistory();
        eventActionHistory.a(eventAnalyticsParams.c);
        if (eventAnalyticsParams.e != null) {
            eventActionHistory.b(eventAnalyticsParams.e);
        }
        EventActionHistory eventActionHistory2 = new EventActionHistory();
        eventActionHistory2.a(eventAnalyticsParams.d);
        eventActionHistory2.b(str2);
        Context context = new Context();
        context.a(ImmutableList.of(eventActionHistory, eventActionHistory2));
        EventUpdateExtendedViewerWatchStatusInputData a = eventUpdateExtendedViewerWatchStatusInputData.a(context).b(str).a(watchStatus2);
        if (eventAnalyticsParams.f != null) {
            a.a(ImmutableList.of(eventAnalyticsParams.f));
        }
        ListenableFuture<GraphQLResult<WatchEventMutationModel>> a2 = this.f2777a.a(GraphQLRequest.a((WatchEventMutationString) EventsMutations.d().a("input", a)).a(optimisticRsvpEventModel));
        Futures.a(a2, new FutureCallback<GraphQLResult<WatchEventMutationModel>>(this) {
            final /* synthetic */ PublicEventsRsvpMutator f2775b;

            public void onSuccess(@Nullable Object obj) {
                this.f2775b.f2778b.a(graphQLEventWatchStatus.name(), "public_event");
            }

            public void onFailure(Throwable th) {
            }
        }, DirectExecutor.INSTANCE);
        return a2;
    }
}
