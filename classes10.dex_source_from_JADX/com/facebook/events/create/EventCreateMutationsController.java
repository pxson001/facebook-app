package com.facebook.events.create;

import android.net.Uri;
import android.os.Handler;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentManager;
import com.facebook.analytics.InteractionLogger;
import com.facebook.analytics.event.HoneyClientEventFast;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.common.time.AwakeTimeSinceBootClockMethodAutoProvider;
import com.facebook.common.time.MonotonicClock;
import com.facebook.debug.log.BLog;
import com.facebook.events.common.ActionMechanism;
import com.facebook.events.common.EventAnalyticsParams;
import com.facebook.events.create.protocol.EventCreationMutations;
import com.facebook.events.create.protocol.EventCreationMutations.CreateEventCoreMutationString;
import com.facebook.events.create.protocol.EventCreationMutationsModels.CreateEventCoreMutationFieldsModel;
import com.facebook.events.create.protocol.EventCreationMutationsModels.CreateEventCoreMutationFieldsModel.EventModel;
import com.facebook.events.logging.EventEventLogger;
import com.facebook.graphql.calls.EventCreateInputData;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.inject.InjectorLike;
import com.facebook.ui.dialogs.ProgressDialogFragment;
import com.facebook.ui.futures.TasksManager;
import com.facebook.ui.toaster.ToastBuilder;
import com.facebook.ui.toaster.Toaster;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Map;
import javax.inject.Inject;

/* compiled from: content_search_back */
public class EventCreateMutationsController {
    public static final Class<?> f16088a = EventCreateMutationsController.class;
    public final CreateEventPerformanceLogger f16089b;
    public final EventEventLogger f16090c;
    private final InteractionLogger f16091d;
    private final MonotonicClock f16092e;
    private final TasksManager f16093f;
    public final Toaster f16094g;
    private final GraphQLQueryExecutor f16095h;
    public final EventCoverPhotoUploadHandler f16096i;
    private long f16097j;

    /* compiled from: content_search_back */
    public interface EventCreateMutationsControllerListener {
        void mo773a(long j);
    }

    public static EventCreateMutationsController m16465b(InjectorLike injectorLike) {
        return new EventCreateMutationsController(CreateEventPerformanceLogger.m16442a(injectorLike), EventEventLogger.m18119b(injectorLike), InteractionLogger.a(injectorLike), (MonotonicClock) AwakeTimeSinceBootClockMethodAutoProvider.a(injectorLike), TasksManager.b(injectorLike), Toaster.b(injectorLike), GraphQLQueryExecutor.a(injectorLike), EventCoverPhotoUploadHandler.m16454a(injectorLike));
    }

    public static EventCreateMutationsController m16462a(InjectorLike injectorLike) {
        return m16465b(injectorLike);
    }

    @Inject
    public EventCreateMutationsController(CreateEventPerformanceLogger createEventPerformanceLogger, EventEventLogger eventEventLogger, InteractionLogger interactionLogger, MonotonicClock monotonicClock, TasksManager tasksManager, Toaster toaster, GraphQLQueryExecutor graphQLQueryExecutor, EventCoverPhotoUploadHandler eventCoverPhotoUploadHandler) {
        this.f16089b = createEventPerformanceLogger;
        this.f16090c = eventEventLogger;
        this.f16091d = interactionLogger;
        this.f16092e = monotonicClock;
        this.f16093f = tasksManager;
        this.f16094g = toaster;
        this.f16095h = graphQLQueryExecutor;
        this.f16096i = eventCoverPhotoUploadHandler;
    }

    public final void m16466a(FragmentManager fragmentManager, EventCreateInputData eventCreateInputData, EventCreateMutationsControllerListener eventCreateMutationsControllerListener, Handler handler, Uri uri, EventAnalyticsParams eventAnalyticsParams, ActionMechanism actionMechanism, HoneyClientEventFast honeyClientEventFast) {
        final DialogFragment a = ProgressDialogFragment.a(2131236921, true, false);
        m16463a(fragmentManager, a);
        ListenableFuture a2 = this.f16095h.a(GraphQLRequest.a((CreateEventCoreMutationString) EventCreationMutations.m16642a().a("input", eventCreateInputData)));
        final HoneyClientEventFast honeyClientEventFast2 = honeyClientEventFast;
        final EventCreateMutationsControllerListener eventCreateMutationsControllerListener2 = eventCreateMutationsControllerListener;
        final Uri uri2 = uri;
        final Handler handler2 = handler;
        final EventAnalyticsParams eventAnalyticsParams2 = eventAnalyticsParams;
        final ActionMechanism actionMechanism2 = actionMechanism;
        C22431 c22431 = new AbstractDisposableFutureCallback<GraphQLResult<CreateEventCoreMutationFieldsModel>>(this) {
            final /* synthetic */ EventCreateMutationsController f16087h;

            protected final void m16460a(Object obj) {
                GraphQLResult graphQLResult = (GraphQLResult) obj;
                EventCreateMutationsController.m16464a(this.f16087h, a);
                EventModel a = ((CreateEventCoreMutationFieldsModel) graphQLResult.e).m16655a();
                if (a == null || a.m16652j() == null) {
                    m16459b();
                    return;
                }
                long parseLong = Long.parseLong(a.m16652j());
                if (parseLong > 0) {
                    if (honeyClientEventFast2 == null || !honeyClientEventFast2.a()) {
                        this.f16087h.f16090c.m18138b();
                    } else {
                        honeyClientEventFast2.b();
                    }
                    eventCreateMutationsControllerListener2.mo773a(parseLong);
                    if (uri2 != null) {
                        this.f16087h.f16096i.m16458a(handler2, uri2, parseLong, eventAnalyticsParams2, actionMechanism2);
                        return;
                    }
                    return;
                }
                m16459b();
            }

            private void m16459b() {
                this.f16087h.f16090c.m18140c();
                this.f16087h.f16089b.m16445b();
            }

            protected final void m16461a(Throwable th) {
                EventCreateMutationsController.m16464a(this.f16087h, a);
                this.f16087h.f16094g.b(new ToastBuilder(2131236922));
                BLog.b(EventCreateMutationsController.f16088a, "Error creating event", th);
                m16459b();
            }
        };
        Map b = eventCreateInputData.b();
        this.f16093f.a("tasks-createEvent" + b.get("name") + "@" + b.get("start_time"), a2, c22431);
    }

    public static void m16464a(EventCreateMutationsController eventCreateMutationsController, DialogFragment dialogFragment) {
        if (dialogFragment != null && dialogFragment.mx_()) {
            dialogFragment.b();
        }
        if (eventCreateMutationsController.f16097j != 0) {
            eventCreateMutationsController.f16091d.a(eventCreateMutationsController.f16092e.now() - eventCreateMutationsController.f16097j);
            eventCreateMutationsController.f16097j = 0;
        }
    }

    private void m16463a(FragmentManager fragmentManager, DialogFragment dialogFragment) {
        dialogFragment.a(fragmentManager, "progress_dialog");
        this.f16097j = this.f16092e.now();
        this.f16091d.a(true);
    }
}
