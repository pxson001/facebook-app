package com.facebook.messaging.events.banner;

import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.common.util.StringUtil;
import com.facebook.graphql.calls.LightweightEventCreateInputData;
import com.facebook.graphql.calls.LightweightEventRsvpInputData;
import com.facebook.graphql.calls.LightweightEventRsvpInputData.GuestListState;
import com.facebook.graphql.calls.LightweightEventUpdateInputData;
import com.facebook.graphql.calls.LightweightEventUpdateInputData.Context;
import com.facebook.graphql.calls.LightweightEventUpdateInputData.Context.EventActionHistory;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.events.graphql.EventRemindersMutation;
import com.facebook.messaging.events.graphql.EventRemindersMutation.LightweightEventCreateString;
import com.facebook.messaging.events.graphql.EventRemindersMutation.LightweightEventRsvpString;
import com.facebook.messaging.events.graphql.EventRemindersMutation.LightweightEventUpdateString;
import com.facebook.messaging.events.graphql.EventRemindersMutationModels.LightweightEventCreateModel;
import com.facebook.messaging.events.graphql.EventRemindersMutationModels.LightweightEventDeleteModel;
import com.facebook.messaging.events.graphql.EventRemindersMutationModels.LightweightEventRsvpModel;
import com.facebook.messaging.events.graphql.EventRemindersMutationModels.LightweightEventUpdateModel;
import com.facebook.ui.futures.TasksManager;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: socksHost */
public class EventReminderMutator {
    public GraphQLQueryExecutor f2326a;
    public final TasksManager f2327b;

    /* compiled from: socksHost */
    public class C03901 extends AbstractDisposableFutureCallback<GraphQLResult<LightweightEventDeleteModel>> {
        final /* synthetic */ EventReminderMutator f2322a;

        public C03901(EventReminderMutator eventReminderMutator) {
            this.f2322a = eventReminderMutator;
        }

        protected final void m2180a(Throwable th) {
        }
    }

    /* compiled from: socksHost */
    class C03912 extends AbstractDisposableFutureCallback<GraphQLResult<LightweightEventUpdateModel>> {
        final /* synthetic */ EventReminderMutator f2323a;

        C03912(EventReminderMutator eventReminderMutator) {
            this.f2323a = eventReminderMutator;
        }

        protected final void m2182a(Throwable th) {
        }
    }

    /* compiled from: socksHost */
    class C03923 extends AbstractDisposableFutureCallback<GraphQLResult<LightweightEventRsvpModel>> {
        final /* synthetic */ EventReminderMutator f2324a;

        C03923(EventReminderMutator eventReminderMutator) {
            this.f2324a = eventReminderMutator;
        }

        protected final void m2184a(Throwable th) {
        }
    }

    /* compiled from: socksHost */
    class C03934 extends AbstractDisposableFutureCallback<GraphQLResult<LightweightEventCreateModel>> {
        final /* synthetic */ EventReminderMutator f2325a;

        C03934(EventReminderMutator eventReminderMutator) {
            this.f2325a = eventReminderMutator;
        }

        protected final void m2186a(Throwable th) {
        }
    }

    public static EventReminderMutator m2188b(InjectorLike injectorLike) {
        return new EventReminderMutator(GraphQLQueryExecutor.a(injectorLike), TasksManager.b(injectorLike));
    }

    @Inject
    public EventReminderMutator(GraphQLQueryExecutor graphQLQueryExecutor, TasksManager tasksManager) {
        this.f2326a = graphQLQueryExecutor;
        this.f2327b = tasksManager;
    }

    final void m2190a(@Nullable String str, String str2, String str3, String str4) {
        m2187a(str, str2, null, str3, str4);
    }

    public final void m2191a(@Nullable String str, Calendar calendar, String str2, String str3) {
        m2187a(str, null, calendar, str2, str3);
    }

    private void m2187a(@Nullable String str, @Nullable String str2, @Nullable Calendar calendar, String str3, String str4) {
        if (!Strings.isNullOrEmpty(str)) {
            LightweightEventUpdateInputData lightweightEventUpdateInputData = new LightweightEventUpdateInputData();
            lightweightEventUpdateInputData.a("event_id", str);
            EventActionHistory a = new EventActionHistory().a("messenger_thread");
            EventActionHistory a2 = new EventActionHistory().a(str3);
            a2.a("mechanism", str4);
            a2 = a2;
            Context context = new Context();
            context.a("event_action_history", ImmutableList.of(a, a2));
            lightweightEventUpdateInputData.a("context", context);
            if (calendar != null) {
                lightweightEventUpdateInputData.a("event_time", Integer.valueOf((int) TimeUnit.MILLISECONDS.toSeconds(calendar.getTimeInMillis())));
            }
            if (str2 != null) {
                lightweightEventUpdateInputData.a("title", str2);
            }
            this.f2327b.a("tasks-updateEvent:" + str, this.f2326a.a(GraphQLRequest.a((LightweightEventUpdateString) EventRemindersMutation.m2213b().a("input", lightweightEventUpdateInputData))), new C03912(this));
        }
    }

    final void m2189a(@Nullable String str, GuestListState guestListState) {
        if (!Strings.isNullOrEmpty(str)) {
            if (guestListState == GuestListState.DECLINED || guestListState == GuestListState.GOING) {
                GraphQLQueryExecutor graphQLQueryExecutor = this.f2326a;
                LightweightEventRsvpInputData lightweightEventRsvpInputData = new LightweightEventRsvpInputData();
                lightweightEventRsvpInputData.a("event_id", str);
                LightweightEventRsvpInputData.Context.EventActionHistory b = new LightweightEventRsvpInputData.Context.EventActionHistory().a("messenger_thread").b("event_reminder_banner");
                LightweightEventRsvpInputData.Context.EventActionHistory b2 = new LightweightEventRsvpInputData.Context.EventActionHistory().a("event_reminder_settings").b("event_reminder_settings");
                LightweightEventRsvpInputData.Context context = new LightweightEventRsvpInputData.Context();
                context.a("event_action_history", ImmutableList.of(b, b2));
                lightweightEventRsvpInputData.a("context", context);
                lightweightEventRsvpInputData.a("guest_list_state", guestListState);
                this.f2327b.a("tasks-rsvpEvent:" + str, graphQLQueryExecutor.a(GraphQLRequest.a((LightweightEventRsvpString) new LightweightEventRsvpString().a("input", lightweightEventRsvpInputData))), new C03923(this));
            }
        }
    }

    public final void m2192b(@Nullable String str, Calendar calendar, String str2, String str3) {
        if (!StringUtil.a(str) && calendar != null) {
            LightweightEventCreateInputData lightweightEventCreateInputData = new LightweightEventCreateInputData();
            LightweightEventCreateInputData.Context.EventActionHistory a = new LightweightEventCreateInputData.Context.EventActionHistory().a("messenger_thread");
            LightweightEventCreateInputData.Context.EventActionHistory a2 = new LightweightEventCreateInputData.Context.EventActionHistory().a(str2);
            a2.a("mechanism", str3);
            a2 = a2;
            LightweightEventCreateInputData.Context context = new LightweightEventCreateInputData.Context();
            context.a("event_action_history", ImmutableList.of(a, a2));
            lightweightEventCreateInputData.a("context", context);
            lightweightEventCreateInputData.a("thread_id", str);
            lightweightEventCreateInputData.a("event_time", Integer.valueOf((int) TimeUnit.MILLISECONDS.toSeconds(calendar.getTimeInMillis())));
            this.f2327b.a("tasks-createEvent:" + str, this.f2326a.a(GraphQLRequest.a((LightweightEventCreateString) new LightweightEventCreateString().a("input", lightweightEventCreateInputData))), new C03934(this));
        }
    }
}
