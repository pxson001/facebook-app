package com.facebook.events.permalink.guestlist;

import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.events.common.ActionMechanism;
import com.facebook.events.common.EventActionContext;
import com.facebook.events.graphql.EventsMutations.EventAdminRemoveGuestMutationString;
import com.facebook.events.graphql.EventsMutations.EventAdminRsvpMutationString;
import com.facebook.events.graphql.EventsMutationsModels.EventAdminRemoveGuestMutationModel;
import com.facebook.events.graphql.EventsMutationsModels.EventAdminRsvpMutationModel;
import com.facebook.events.graphql.EventsMutationsModels.EventGuestCountsMutationFragmentModel;
import com.facebook.events.graphql.EventsMutationsModels.EventGuestCountsMutationFragmentModel.EventDeclinesModel;
import com.facebook.events.graphql.EventsMutationsModels.EventGuestCountsMutationFragmentModel.EventInviteesModel;
import com.facebook.events.graphql.EventsMutationsModels.EventGuestCountsMutationFragmentModel.EventInviteesModel.Builder;
import com.facebook.events.graphql.EventsMutationsModels.EventGuestCountsMutationFragmentModel.EventMaybesModel;
import com.facebook.events.graphql.EventsMutationsModels.EventGuestCountsMutationFragmentModel.EventMembersModel;
import com.facebook.events.model.EventUser;
import com.facebook.events.permalink.guestlist.common.EventGuestListType;
import com.facebook.events.permalink.guestlist.common.EventGuestSingleListModel;
import com.facebook.graphql.calls.EventAdminRemoveGuestInputData;
import com.facebook.graphql.calls.EventAdminRsvpInputData;
import com.facebook.graphql.calls.EventAdminRsvpInputData.Context;
import com.facebook.graphql.calls.EventAdminRsvpInputData.Context.EventActionHistory;
import com.facebook.graphql.calls.EventAdminRsvpInputData.GuestStatus;
import com.facebook.graphql.calls.GraphQlCallInput;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.inject.Assisted;
import com.facebook.ui.futures.TasksManager;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.ListenableFuture;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: bot_review_update */
public class EventGuestListManagementController {
    public String f18391a;
    private EventGuestListType f18392b;
    public EventActionContext f18393c;
    private ImmutableList<EventGuestSingleListModel> f18394d;
    public ActionMechanism f18395e;
    private TasksManager f18396f;
    private GraphQLQueryExecutor f18397g;

    /* compiled from: bot_review_update */
    class C26091 extends AbstractDisposableFutureCallback<GraphQLResult<EventAdminRsvpMutationModel>> {
        final /* synthetic */ EventGuestListManagementController f18388a;

        C26091(EventGuestListManagementController eventGuestListManagementController) {
            this.f18388a = eventGuestListManagementController;
        }

        protected final void m18734a(Throwable th) {
        }
    }

    /* compiled from: bot_review_update */
    class C26102 extends AbstractDisposableFutureCallback<GraphQLResult<EventAdminRemoveGuestMutationModel>> {
        final /* synthetic */ EventGuestListManagementController f18389a;

        C26102(EventGuestListManagementController eventGuestListManagementController) {
            this.f18389a = eventGuestListManagementController;
        }

        protected final void m18736a(Throwable th) {
        }
    }

    /* compiled from: bot_review_update */
    /* synthetic */ class C26113 {
        static final /* synthetic */ int[] f18390a = new int[EventGuestListType.values().length];

        static {
            try {
                f18390a[EventGuestListType.PRIVATE_GOING.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f18390a[EventGuestListType.PRIVATE_MAYBE.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f18390a[EventGuestListType.PRIVATE_NOT_GOING.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    @Inject
    public EventGuestListManagementController(TasksManager tasksManager, GraphQLQueryExecutor graphQLQueryExecutor, @Assisted String str, @Assisted EventGuestListType eventGuestListType, @Assisted ImmutableList<EventGuestSingleListModel> immutableList, @Assisted EventActionContext eventActionContext, @Assisted ActionMechanism actionMechanism) {
        this.f18396f = tasksManager;
        this.f18397g = graphQLQueryExecutor;
        this.f18391a = str;
        this.f18392b = eventGuestListType;
        this.f18394d = immutableList;
        this.f18393c = eventActionContext;
        this.f18395e = actionMechanism;
    }

    public final void m18740a(EventUser eventUser, EventGuestListType eventGuestListType) {
        EventAdminRsvpInputData eventAdminRsvpInputData = new EventAdminRsvpInputData();
        EventActionHistory eventActionHistory = new EventActionHistory();
        eventActionHistory.a(this.f18393c.f.toString());
        EventActionHistory eventActionHistory2 = new EventActionHistory();
        eventActionHistory2.a(this.f18393c.e.toString());
        eventActionHistory2.a("mechanism", this.f18395e.toString());
        Context context = new Context();
        context.a("event_action_history", ImmutableList.of(eventActionHistory, eventActionHistory2));
        eventAdminRsvpInputData.a("context", context);
        GraphQlCallInput graphQlCallInput = eventAdminRsvpInputData;
        graphQlCallInput.a("event_id", this.f18391a);
        graphQlCallInput = graphQlCallInput;
        graphQlCallInput.a("target_id", eventUser.b);
        graphQlCallInput = graphQlCallInput;
        graphQlCallInput.a("guest_status", m18737a(eventGuestListType));
        graphQlCallInput = graphQlCallInput;
        EventGuestCountsMutationFragmentModel b = m18738b(eventGuestListType);
        GraphQlQueryString eventAdminRsvpMutationString = new EventAdminRsvpMutationString();
        eventAdminRsvpMutationString.a("input", graphQlCallInput);
        ListenableFuture a = this.f18397g.a(GraphQLRequest.a(eventAdminRsvpMutationString).a(b));
        this.f18396f.a("tasks-adminRsvpEvent:" + this.f18391a + ":" + eventUser.b + ":" + eventGuestListType.name(), a, new C26091(this));
    }

    public final void m18739a(EventUser eventUser) {
        EventAdminRemoveGuestInputData eventAdminRemoveGuestInputData = new EventAdminRemoveGuestInputData();
        EventAdminRemoveGuestInputData.Context.EventActionHistory eventActionHistory = new EventAdminRemoveGuestInputData.Context.EventActionHistory();
        eventActionHistory.a(this.f18393c.f.toString());
        EventAdminRemoveGuestInputData.Context.EventActionHistory eventActionHistory2 = new EventAdminRemoveGuestInputData.Context.EventActionHistory();
        eventActionHistory2.a(this.f18393c.e.toString());
        eventActionHistory2.a("mechanism", this.f18395e.toString());
        EventAdminRemoveGuestInputData.Context context = new EventAdminRemoveGuestInputData.Context();
        context.a("event_action_history", ImmutableList.of(eventActionHistory, eventActionHistory2));
        eventAdminRemoveGuestInputData.a("context", context);
        GraphQlCallInput graphQlCallInput = eventAdminRemoveGuestInputData;
        graphQlCallInput.a("event_id", this.f18391a);
        graphQlCallInput = graphQlCallInput;
        graphQlCallInput.a("target_id", eventUser.b);
        graphQlCallInput = graphQlCallInput;
        EventGuestCountsMutationFragmentModel b = m18738b(null);
        GraphQlQueryString eventAdminRemoveGuestMutationString = new EventAdminRemoveGuestMutationString();
        eventAdminRemoveGuestMutationString.a("input", graphQlCallInput);
        ListenableFuture a = this.f18397g.a(GraphQLRequest.a(eventAdminRemoveGuestMutationString).a(b));
        this.f18396f.a("tasks-adminRemoveGuestEvent:" + this.f18391a + ":" + eventUser.b, a, new C26102(this));
    }

    private static GuestStatus m18737a(EventGuestListType eventGuestListType) {
        switch (C26113.f18390a[eventGuestListType.ordinal()]) {
            case 1:
                return GuestStatus.GOING;
            case 2:
                return GuestStatus.MAYBE;
            case 3:
                return GuestStatus.NOT_GOING;
            default:
                throw new IllegalArgumentException("Unsupported guest status: " + eventGuestListType);
        }
    }

    private EventGuestCountsMutationFragmentModel m18738b(@Nullable EventGuestListType eventGuestListType) {
        int size = this.f18394d.size();
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        while (i < size) {
            int i6;
            EventGuestSingleListModel eventGuestSingleListModel = (EventGuestSingleListModel) this.f18394d.get(i);
            if (eventGuestSingleListModel.b != null) {
                int intValue = eventGuestSingleListModel.b.intValue();
                EventGuestListType eventGuestListType2 = eventGuestSingleListModel.a;
                if (this.f18392b == eventGuestListType2) {
                    i6 = intValue - 1;
                } else {
                    i6 = intValue;
                }
                if (eventGuestListType == eventGuestListType2) {
                    i6++;
                }
                int i7;
                if (eventGuestListType2 == EventGuestListType.PRIVATE_INVITED) {
                    i7 = i2;
                    i2 = i3;
                    i3 = i4;
                    i4 = i6;
                    i6 = i7;
                } else if (eventGuestListType2 == EventGuestListType.PRIVATE_MAYBE) {
                    i4 = i5;
                    i7 = i3;
                    i3 = i6;
                    i6 = i2;
                    i2 = i7;
                } else if (eventGuestListType2 == EventGuestListType.PRIVATE_GOING) {
                    i3 = i4;
                    i4 = i5;
                    i7 = i2;
                    i2 = i6;
                    i6 = i7;
                } else if (eventGuestListType2 == EventGuestListType.PRIVATE_NOT_GOING) {
                    i2 = i3;
                    i3 = i4;
                    i4 = i5;
                }
                i++;
                i5 = i4;
                i4 = i3;
                i3 = i2;
                i2 = i6;
            }
            i6 = i2;
            i2 = i3;
            i3 = i4;
            i4 = i5;
            i++;
            i5 = i4;
            i4 = i3;
            i3 = i2;
            i2 = i6;
        }
        Builder builder = new Builder();
        builder.a = i5;
        EventInviteesModel a = builder.a();
        EventMaybesModel.Builder builder2 = new EventMaybesModel.Builder();
        builder2.a = i4;
        EventMaybesModel a2 = builder2.a();
        EventMembersModel.Builder builder3 = new EventMembersModel.Builder();
        builder3.a = i3;
        EventMembersModel a3 = builder3.a();
        EventDeclinesModel.Builder builder4 = new EventDeclinesModel.Builder();
        builder4.a = i2;
        EventDeclinesModel a4 = builder4.a();
        EventGuestCountsMutationFragmentModel.Builder builder5 = new EventGuestCountsMutationFragmentModel.Builder();
        builder5.e = this.f18391a;
        builder5 = builder5;
        builder5.b = a;
        EventGuestCountsMutationFragmentModel.Builder builder6 = builder5;
        builder6.c = a2;
        builder6 = builder6;
        builder6.d = a3;
        builder6 = builder6;
        builder6.a = a4;
        return builder6.a();
    }
}
