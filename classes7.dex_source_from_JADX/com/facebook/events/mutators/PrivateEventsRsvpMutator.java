package com.facebook.events.mutators;

import com.facebook.events.common.ActionMechanism;
import com.facebook.events.common.EventActionContext;
import com.facebook.events.common.EventAnalyticsParams;
import com.facebook.events.graphql.EventsGraphQLInterfaces.EventCommonFragment;
import com.facebook.events.graphql.EventsGraphQLModels.FetchEventPermalinkFragmentModel;
import com.facebook.events.graphql.EventsMutations;
import com.facebook.events.graphql.EventsMutations.EventRsvpMutationString;
import com.facebook.events.graphql.EventsMutationsModels.EventRsvpMutationModel;
import com.facebook.events.graphql.EventsMutationsModels.OptimisticRsvpEventModel;
import com.facebook.events.graphql.EventsMutationsModels.OptimisticRsvpEventModel.Builder;
import com.facebook.events.graphql.EventsMutationsModels.OptimisticRsvpEventModel.EventInviteesModel;
import com.facebook.events.graphql.EventsMutationsModels.OptimisticRsvpEventModel.EventMaybesModel;
import com.facebook.events.graphql.EventsMutationsModels.OptimisticRsvpEventModel.EventMembersModel;
import com.facebook.graphql.calls.EventRsvpInputData;
import com.facebook.graphql.calls.EventRsvpInputData.Context;
import com.facebook.graphql.calls.EventRsvpInputData.Context.EventActionHistory;
import com.facebook.graphql.calls.EventRsvpInputData.GuestStatus;
import com.facebook.graphql.enums.GraphQLEventGuestStatus;
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

/* compiled from: suggested_section */
public class PrivateEventsRsvpMutator {
    public final NotificationsFunnelLogger f2772a;
    private final GraphQLQueryExecutor f2773b;

    public static PrivateEventsRsvpMutator m3038b(InjectorLike injectorLike) {
        return new PrivateEventsRsvpMutator(NotificationsFunnelLogger.a(injectorLike), GraphQLQueryExecutor.a(injectorLike));
    }

    @Inject
    public PrivateEventsRsvpMutator(NotificationsFunnelLogger notificationsFunnelLogger, GraphQLQueryExecutor graphQLQueryExecutor) {
        this.f2772a = notificationsFunnelLogger;
        this.f2773b = graphQLQueryExecutor;
    }

    public static PrivateEventsRsvpMutator m3033a(InjectorLike injectorLike) {
        return m3038b(injectorLike);
    }

    public final ListenableFuture<GraphQLResult<EventRsvpMutationModel>> m3042a(String str, GraphQLEventGuestStatus graphQLEventGuestStatus, String str2, String str3, ActionMechanism actionMechanism) {
        return m3044a(str, graphQLEventGuestStatus, str2, "unknown".toString(), str3, actionMechanism != null ? actionMechanism.toString() : "unknown");
    }

    public final ListenableFuture<GraphQLResult<EventRsvpMutationModel>> m3044a(String str, GraphQLEventGuestStatus graphQLEventGuestStatus, String str2, String str3, String str4, String str5) {
        return m3036a(str, graphQLEventGuestStatus, new EventAnalyticsParams(EventActionContext.a, str2, str3, str4, null), str5);
    }

    public final ListenableFuture<GraphQLResult<EventRsvpMutationModel>> m3039a(EventCommonFragment eventCommonFragment, GraphQLEventGuestStatus graphQLEventGuestStatus, EventAnalyticsParams eventAnalyticsParams, ActionMechanism actionMechanism) {
        return m3037a(eventCommonFragment.dL_(), graphQLEventGuestStatus, m3032a(eventCommonFragment, graphQLEventGuestStatus, eventCommonFragment.o()), eventAnalyticsParams, actionMechanism != null ? actionMechanism.toString() : "unknown", null);
    }

    public final ListenableFuture<GraphQLResult<EventRsvpMutationModel>> m3040a(String str, GraphQLEventGuestStatus graphQLEventGuestStatus, EventAnalyticsParams eventAnalyticsParams, ActionMechanism actionMechanism) {
        return m3036a(str, graphQLEventGuestStatus, eventAnalyticsParams, actionMechanism.toString());
    }

    private ListenableFuture<GraphQLResult<EventRsvpMutationModel>> m3036a(String str, GraphQLEventGuestStatus graphQLEventGuestStatus, EventAnalyticsParams eventAnalyticsParams, String str2) {
        Builder builder = new Builder();
        builder.e = str;
        builder = builder;
        builder.g = false;
        builder = builder;
        builder.f = graphQLEventGuestStatus;
        return m3037a(str, graphQLEventGuestStatus, builder.a(), eventAnalyticsParams, str2, null);
    }

    public final ListenableFuture<GraphQLResult<EventRsvpMutationModel>> m3043a(String str, GraphQLEventGuestStatus graphQLEventGuestStatus, String str2, String str3, ActionMechanism actionMechanism, @Nullable String str4) {
        Builder builder = new Builder();
        builder.e = str;
        builder = builder;
        builder.g = false;
        builder = builder;
        builder.f = graphQLEventGuestStatus;
        return m3037a(str, graphQLEventGuestStatus, builder.a(), new EventAnalyticsParams(EventActionContext.a, str2.toString(), str3.toString(), null), actionMechanism.toString(), str4);
    }

    private ListenableFuture<GraphQLResult<EventRsvpMutationModel>> m3037a(String str, final GraphQLEventGuestStatus graphQLEventGuestStatus, OptimisticRsvpEventModel optimisticRsvpEventModel, EventAnalyticsParams eventAnalyticsParams, String str2, @Nullable String str3) {
        EventRsvpInputData a = new EventRsvpInputData().a(m3034a(str2, eventAnalyticsParams.c, eventAnalyticsParams.d, str3)).b(str).a(m3035a(graphQLEventGuestStatus));
        EventRsvpMutationString e = EventsMutations.e();
        e.a("input", a);
        ListenableFuture<GraphQLResult<EventRsvpMutationModel>> a2 = this.f2773b.a(GraphQLRequest.a(e).a(optimisticRsvpEventModel));
        Futures.a(a2, new FutureCallback<GraphQLResult<EventRsvpMutationModel>>(this) {
            final /* synthetic */ PrivateEventsRsvpMutator f2771b;

            public void onSuccess(@Nullable Object obj) {
                this.f2771b.f2772a.a(graphQLEventGuestStatus.name(), "private_event");
            }

            public void onFailure(Throwable th) {
            }
        }, DirectExecutor.INSTANCE);
        return a2;
    }

    public final ListenableFuture<GraphQLResult<EventRsvpMutationModel>> m3041a(String str, GraphQLEventGuestStatus graphQLEventGuestStatus, EventAnalyticsParams eventAnalyticsParams, ActionMechanism actionMechanism, @Nullable String str2) {
        EventRsvpInputData a = new EventRsvpInputData().a(m3034a(actionMechanism.toString(), eventAnalyticsParams.c, eventAnalyticsParams.d, str2)).b(str).a(m3035a(graphQLEventGuestStatus));
        EventRsvpMutationString e = EventsMutations.e();
        e.a("input", a);
        return this.f2773b.a(GraphQLRequest.a(e));
    }

    private static Context m3034a(String str, String str2, String str3, String str4) {
        EventActionHistory eventActionHistory = new EventActionHistory();
        eventActionHistory.a(str2);
        EventActionHistory eventActionHistory2 = new EventActionHistory();
        eventActionHistory2.a(str3);
        eventActionHistory2.b(str);
        if (str4 != null) {
            eventActionHistory2.c(str4);
        }
        Context context = new Context();
        context.a(ImmutableList.of(eventActionHistory, eventActionHistory2));
        return context;
    }

    private static GuestStatus m3035a(GraphQLEventGuestStatus graphQLEventGuestStatus) {
        if (graphQLEventGuestStatus == GraphQLEventGuestStatus.GOING) {
            return GuestStatus.GOING;
        }
        if (graphQLEventGuestStatus == GraphQLEventGuestStatus.MAYBE) {
            return GuestStatus.MAYBE;
        }
        if (graphQLEventGuestStatus == GraphQLEventGuestStatus.NOT_GOING) {
            return GuestStatus.NOT_GOING;
        }
        if (graphQLEventGuestStatus == GraphQLEventGuestStatus.UNSET_OR_UNRECOGNIZED_ENUM_VALUE) {
            return null;
        }
        throw new IllegalArgumentException("Unsupported guest status: " + graphQLEventGuestStatus);
    }

    private static OptimisticRsvpEventModel m3032a(EventCommonFragment eventCommonFragment, GraphQLEventGuestStatus graphQLEventGuestStatus, GraphQLEventGuestStatus graphQLEventGuestStatus2) {
        int i = 0;
        Builder builder = new Builder();
        builder.e = eventCommonFragment.dL_();
        builder = builder;
        builder.g = false;
        builder = builder;
        builder.f = graphQLEventGuestStatus;
        Builder builder2 = builder;
        if (eventCommonFragment instanceof FetchEventPermalinkFragmentModel) {
            FetchEventPermalinkFragmentModel fetchEventPermalinkFragmentModel = (FetchEventPermalinkFragmentModel) eventCommonFragment;
            int a = fetchEventPermalinkFragmentModel.ax() == null ? 0 : fetchEventPermalinkFragmentModel.ax().a();
            int a2 = fetchEventPermalinkFragmentModel.aw() == null ? 0 : fetchEventPermalinkFragmentModel.aw().a();
            if (graphQLEventGuestStatus == GraphQLEventGuestStatus.GOING) {
                EventMembersModel.Builder builder3 = new EventMembersModel.Builder();
                builder3.a = a + 1;
                builder2.c = builder3.a();
            } else if (graphQLEventGuestStatus == GraphQLEventGuestStatus.MAYBE) {
                EventMaybesModel.Builder builder4 = new EventMaybesModel.Builder();
                builder4.a = a2 + 1;
                builder2.b = builder4.a();
            }
            if (graphQLEventGuestStatus2 == GraphQLEventGuestStatus.GOING) {
                EventMembersModel.Builder builder5 = new EventMembersModel.Builder();
                builder5.a = a - 1;
                builder2.c = builder5.a();
            } else if (graphQLEventGuestStatus2 == GraphQLEventGuestStatus.MAYBE) {
                EventMaybesModel.Builder builder6 = new EventMaybesModel.Builder();
                builder6.a = a2 - 1;
                builder2.b = builder6.a();
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
}
