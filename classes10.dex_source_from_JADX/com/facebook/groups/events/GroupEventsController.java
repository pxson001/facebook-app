package com.facebook.groups.events;

import android.content.res.Resources;
import com.facebook.auth.module.String_LoggedInUserIdMethodAutoProvider;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.events.graphql.EventsMutations.EventRsvpMutationString;
import com.facebook.events.graphql.EventsMutations.WatchEventMutationString;
import com.facebook.events.graphql.EventsMutationsModels.EventRsvpMutationModel;
import com.facebook.events.graphql.EventsMutationsModels.WatchEventMutationModel;
import com.facebook.events.model.EventRsvpMutation;
import com.facebook.graphql.calls.EventRsvpInputData;
import com.facebook.graphql.calls.EventRsvpInputData.Context;
import com.facebook.graphql.calls.EventRsvpInputData.Context.EventActionHistory;
import com.facebook.graphql.calls.EventRsvpInputData.GuestStatus;
import com.facebook.graphql.calls.EventUpdateExtendedViewerWatchStatusInputData;
import com.facebook.graphql.calls.EventUpdateExtendedViewerWatchStatusInputData.WatchStatus;
import com.facebook.graphql.enums.GraphQLEventGuestStatus;
import com.facebook.graphql.enums.GraphQLEventWatchStatus;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.inject.InjectorLike;
import com.facebook.ui.toaster.ToastBuilder;
import com.facebook.ui.toaster.Toaster;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import java.util.concurrent.ExecutorService;
import javax.inject.Inject;

/* compiled from: UPDATE_AUTO_APPROVAL */
public class GroupEventsController {
    private final String f21832a;
    private final ExecutorService f21833b;
    public final Resources f21834c;
    private final GraphQLQueryExecutor f21835d;
    public final Toaster f21836e;
    public GroupEventsControllerListener f21837f;

    /* compiled from: UPDATE_AUTO_APPROVAL */
    public interface GroupEventsControllerListener {
        void mo962a(EventRsvpMutation eventRsvpMutation);
    }

    /* compiled from: UPDATE_AUTO_APPROVAL */
    /* synthetic */ class C31223 {
        static final /* synthetic */ int[] f21830a = new int[GraphQLEventGuestStatus.values().length];
        static final /* synthetic */ int[] f21831b = new int[GraphQLEventWatchStatus.values().length];

        static {
            try {
                f21831b[GraphQLEventWatchStatus.GOING.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f21831b[GraphQLEventWatchStatus.WATCHED.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f21831b[GraphQLEventWatchStatus.DECLINED.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f21831b[GraphQLEventWatchStatus.UNWATCHED.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f21830a[GraphQLEventGuestStatus.GOING.ordinal()] = 1;
            } catch (NoSuchFieldError e5) {
            }
            try {
                f21830a[GraphQLEventGuestStatus.MAYBE.ordinal()] = 2;
            } catch (NoSuchFieldError e6) {
            }
            try {
                f21830a[GraphQLEventGuestStatus.NOT_GOING.ordinal()] = 3;
            } catch (NoSuchFieldError e7) {
            }
        }
    }

    public static GroupEventsController m22935b(InjectorLike injectorLike) {
        return new GroupEventsController(ResourcesMethodAutoProvider.a(injectorLike), String_LoggedInUserIdMethodAutoProvider.b(injectorLike), (ExecutorService) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(injectorLike), GraphQLQueryExecutor.a(injectorLike), Toaster.b(injectorLike));
    }

    @Inject
    public GroupEventsController(Resources resources, String str, ExecutorService executorService, GraphQLQueryExecutor graphQLQueryExecutor, Toaster toaster) {
        this.f21834c = resources;
        this.f21832a = str;
        this.f21833b = executorService;
        this.f21835d = graphQLQueryExecutor;
        this.f21836e = toaster;
    }

    public final void m22938b(GroupEventsControllerListener groupEventsControllerListener) {
        if (this.f21837f == groupEventsControllerListener) {
            this.f21837f = null;
        }
    }

    public final void m22936a(final EventRsvpMutation eventRsvpMutation, GraphQLEventGuestStatus graphQLEventGuestStatus) {
        Context a = new Context().a(ImmutableList.of(new EventActionHistory().a("group_events")));
        EventRsvpInputData eventRsvpInputData = new EventRsvpInputData();
        eventRsvpInputData.a("actor_id", this.f21832a);
        EventRsvpInputData a2 = eventRsvpInputData.a(a).b(eventRsvpMutation.a()).a(m22933a(graphQLEventGuestStatus));
        EventRsvpMutationString eventRsvpMutationString = new EventRsvpMutationString();
        eventRsvpMutationString.a("input", a2);
        Futures.a(this.f21835d.a(GraphQLRequest.a(eventRsvpMutationString)), new FutureCallback<GraphQLResult<EventRsvpMutationModel>>(this) {
            final /* synthetic */ GroupEventsController f21827b;

            public /* bridge */ /* synthetic */ void onSuccess(Object obj) {
            }

            public void onFailure(Throwable th) {
                if (this.f21827b.f21837f != null) {
                    this.f21827b.f21837f.mo962a(eventRsvpMutation);
                }
                this.f21827b.f21836e.b(new ToastBuilder(this.f21827b.f21834c.getString(2131242094)));
            }
        }, this.f21833b);
    }

    public final void m22937a(final EventRsvpMutation eventRsvpMutation, GraphQLEventWatchStatus graphQLEventWatchStatus) {
        EventUpdateExtendedViewerWatchStatusInputData.Context a = new EventUpdateExtendedViewerWatchStatusInputData.Context().a(ImmutableList.of(new EventUpdateExtendedViewerWatchStatusInputData.Context.EventActionHistory().a("group_events")));
        EventUpdateExtendedViewerWatchStatusInputData eventUpdateExtendedViewerWatchStatusInputData = new EventUpdateExtendedViewerWatchStatusInputData();
        eventUpdateExtendedViewerWatchStatusInputData.a("actor_id", this.f21832a);
        EventUpdateExtendedViewerWatchStatusInputData a2 = eventUpdateExtendedViewerWatchStatusInputData.a(a).b(eventRsvpMutation.a()).a(m22934a(graphQLEventWatchStatus));
        WatchEventMutationString watchEventMutationString = new WatchEventMutationString();
        watchEventMutationString.a("input", a2);
        Futures.a(this.f21835d.a(GraphQLRequest.a(watchEventMutationString)), new FutureCallback<GraphQLResult<WatchEventMutationModel>>(this) {
            final /* synthetic */ GroupEventsController f21829b;

            public /* bridge */ /* synthetic */ void onSuccess(Object obj) {
            }

            public void onFailure(Throwable th) {
                if (this.f21829b.f21837f != null) {
                    this.f21829b.f21837f.mo962a(eventRsvpMutation);
                }
                this.f21829b.f21836e.b(new ToastBuilder(this.f21829b.f21834c.getString(2131242094)));
            }
        }, this.f21833b);
    }

    private static GuestStatus m22933a(GraphQLEventGuestStatus graphQLEventGuestStatus) {
        switch (C31223.f21830a[graphQLEventGuestStatus.ordinal()]) {
            case 1:
                return GuestStatus.GOING;
            case 2:
                return GuestStatus.MAYBE;
            case 3:
                return GuestStatus.NOT_GOING;
            default:
                throw new IllegalArgumentException("Unsupported guest status: " + graphQLEventGuestStatus);
        }
    }

    private static WatchStatus m22934a(GraphQLEventWatchStatus graphQLEventWatchStatus) {
        switch (C31223.f21831b[graphQLEventWatchStatus.ordinal()]) {
            case 1:
                return WatchStatus.GOING;
            case 2:
                return WatchStatus.WATCHED;
            case 3:
                return WatchStatus.DECLINED;
            case 4:
                return WatchStatus.UNWATCHED;
            default:
                throw new IllegalArgumentException("Unsupported event watch status: " + graphQLEventWatchStatus);
        }
    }
}
