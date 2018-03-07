package com.facebook.events.composition;

import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentManager;
import com.facebook.analytics.InteractionLogger;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.common.time.AwakeTimeSinceBootClockMethodAutoProvider;
import com.facebook.common.time.MonotonicClock;
import com.facebook.debug.log.BLog;
import com.facebook.events.activity.EventCreationActivity.C22197;
import com.facebook.events.common.ActionMechanism;
import com.facebook.events.common.EventAnalyticsParams;
import com.facebook.events.create.CreateEventPerformanceLogger;
import com.facebook.events.logging.EventEventLogger;
import com.facebook.events.permalink.actionbar.ActionItemInvite;
import com.facebook.events.protocol.CreateEventParams;
import com.facebook.fbservice.ops.BlueServiceOperationFactory.OperationFuture;
import com.facebook.fbservice.ops.DefaultBlueServiceOperationFactory;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.inject.InjectorLike;
import com.facebook.tools.dextr.runtime.detour.BlueServiceOperationFactoryDetour;
import com.facebook.ui.dialogs.ProgressDialogFragment;
import com.facebook.ui.futures.TasksManager;
import com.facebook.ui.toaster.ToastBuilder;
import com.facebook.ui.toaster.Toaster;
import com.google.common.collect.ImmutableSet;
import com.google.common.primitives.Longs;
import javax.inject.Inject;

/* compiled from: contact_upload_upsell_start */
public class EventCreateController {
    public static final Class<?> f16030a = EventCreateController.class;
    public final ActionItemInvite f16031b;
    private final DefaultBlueServiceOperationFactory f16032c;
    public final CreateEventPerformanceLogger f16033d;
    public final EventEventLogger f16034e;
    public final InteractionLogger f16035f;
    public final MonotonicClock f16036g;
    private final TasksManager f16037h;
    public final Toaster f16038i;
    public long f16039j;

    public static EventCreateController m16440b(InjectorLike injectorLike) {
        return new EventCreateController(ActionItemInvite.m18355a(injectorLike), DefaultBlueServiceOperationFactory.b(injectorLike), CreateEventPerformanceLogger.m16442a(injectorLike), EventEventLogger.m18119b(injectorLike), InteractionLogger.a(injectorLike), (MonotonicClock) AwakeTimeSinceBootClockMethodAutoProvider.a(injectorLike), TasksManager.b(injectorLike), Toaster.b(injectorLike));
    }

    @Inject
    public EventCreateController(ActionItemInvite actionItemInvite, DefaultBlueServiceOperationFactory defaultBlueServiceOperationFactory, CreateEventPerformanceLogger createEventPerformanceLogger, EventEventLogger eventEventLogger, InteractionLogger interactionLogger, MonotonicClock monotonicClock, TasksManager tasksManager, Toaster toaster) {
        this.f16031b = actionItemInvite;
        this.f16032c = defaultBlueServiceOperationFactory;
        this.f16033d = createEventPerformanceLogger;
        this.f16034e = eventEventLogger;
        this.f16035f = interactionLogger;
        this.f16036g = monotonicClock;
        this.f16037h = tasksManager;
        this.f16038i = toaster;
    }

    public final void m16441a(FragmentManager fragmentManager, CreateEventParams createEventParams, long[] jArr, C22197 c22197) {
        Bundle bundle = new Bundle();
        bundle.putParcelable("createEventParams", createEventParams);
        final DialogFragment a = ProgressDialogFragment.a(2131236921, true, false);
        OperationFuture a2 = BlueServiceOperationFactoryDetour.a(this.f16032c, "create_event", bundle, -94996306).a();
        final long[] jArr2 = jArr;
        final CreateEventParams createEventParams2 = createEventParams;
        final C22197 c221972 = c22197;
        C22371 c22371 = new AbstractDisposableFutureCallback<OperationResult>(this) {
            final /* synthetic */ EventCreateController f16029e;

            protected final void m16437a(Object obj) {
                OperationResult operationResult = (OperationResult) obj;
                EventCreateController.m16439a(this.f16029e, a);
                Long valueOf = Long.valueOf(operationResult.d.getBundle("result").getLong("createEventResult"));
                if (valueOf.longValue() > 0) {
                    this.f16029e.f16034e.m18138b();
                    if (jArr2 != null && jArr2.length > 0) {
                        this.f16029e.f16031b.f17957a = new EventAnalyticsParams(createEventParams2.f19019a);
                        this.f16029e.f16031b.m18369a(valueOf.toString(), ActionMechanism.EVENT_CREATE.toString(), ImmutableSet.copyOf(Longs.a(jArr2)));
                    }
                    c221972.m16339a(valueOf.longValue());
                    return;
                }
                this.f16029e.f16034e.m18140c();
                this.f16029e.f16033d.m16445b();
            }

            protected final void m16438a(Throwable th) {
                this.f16029e.f16034e.m18140c();
                EventCreateController.m16439a(this.f16029e, a);
                this.f16029e.f16038i.b(new ToastBuilder(2131236922));
                BLog.b(EventCreateController.f16030a, "Error creating event", th);
                this.f16029e.f16033d.m16445b();
            }
        };
        a.a(fragmentManager, null);
        this.f16039j = this.f16036g.now();
        this.f16035f.a(true);
        this.f16037h.a("tasks-createEvent:" + createEventParams.f19034b + "@" + createEventParams.f19037e, a2, c22371);
    }

    public static void m16439a(EventCreateController eventCreateController, DialogFragment dialogFragment) {
        dialogFragment.a();
        if (eventCreateController.f16039j != 0) {
            eventCreateController.f16035f.a(eventCreateController.f16036g.now() - eventCreateController.f16039j);
            eventCreateController.f16039j = 0;
        }
    }
}
