package com.facebook.events.permalink.actionbar;

import com.facebook.analytics.CurationMechanism;
import com.facebook.analytics.CurationSurface;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.events.eventsevents.EventsEventBus;
import com.facebook.events.eventsevents.EventsEvents.EventSavingEvent;
import com.facebook.events.eventsevents.EventsEvents.EventUnsavingEvent;
import com.facebook.events.eventsevents.EventsEvents.EventUpdatedEvent;
import com.facebook.events.model.Event;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.feed.server.timeline.TimelineGraphPostService;
import com.facebook.inject.InjectorLike;
import com.facebook.story.UpdateTimelineAppCollectionParams.Action;
import com.facebook.story.UpdateTimelineAppCollectionParams.Builder;
import com.facebook.ui.futures.TasksManager;
import com.google.common.util.concurrent.ListenableFuture;
import javax.inject.Inject;

/* compiled from: caller_reason */
public class ActionItemSave {
    public Event f18047a;
    public String f18048b;
    public String f18049c;
    private TimelineGraphPostService f18050d;
    private TasksManager f18051e;
    public EventsEventBus f18052f;

    /* compiled from: caller_reason */
    class C25561 extends AbstractDisposableFutureCallback<OperationResult> {
        final /* synthetic */ ActionItemSave f18045a;

        C25561(ActionItemSave actionItemSave) {
            this.f18045a = actionItemSave;
        }

        protected final void m18411a(Object obj) {
            this.f18045a.f18052f.a(new EventUpdatedEvent(this.f18045a.f18047a.a));
        }

        protected final void m18412a(Throwable th) {
        }
    }

    /* compiled from: caller_reason */
    /* synthetic */ class C25572 {
        static final /* synthetic */ int[] f18046a = new int[Action.values().length];

        static {
            try {
                f18046a[Action.ADD.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f18046a[Action.REMOVE.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
        }
    }

    public static ActionItemSave m18413a(InjectorLike injectorLike) {
        return new ActionItemSave(TimelineGraphPostService.b(injectorLike), TasksManager.b(injectorLike), EventsEventBus.a(injectorLike));
    }

    @Inject
    public ActionItemSave(TimelineGraphPostService timelineGraphPostService, TasksManager tasksManager, EventsEventBus eventsEventBus) {
        this.f18050d = timelineGraphPostService;
        this.f18051e = tasksManager;
        this.f18052f = eventsEventBus;
    }

    public final void m18415a() {
        m18414a(Action.ADD);
    }

    public final void m18416b() {
        m18414a(Action.REMOVE);
    }

    private void m18414a(Action action) {
        if (this.f18047a != null && this.f18048b != null && this.f18049c != null) {
            Builder builder = new Builder();
            builder.a = this.f18048b;
            builder = builder;
            builder.b = this.f18047a.a;
            builder = builder;
            builder.c = action;
            builder = builder;
            builder.d = CurationSurface.NATIVE_EVENT;
            builder = builder;
            builder.e = CurationMechanism.TOGGLE_BUTTON;
            builder = builder;
            builder.g = this.f18049c;
            builder = builder;
            builder.j = true;
            ListenableFuture a = this.f18050d.a(builder.a());
            C25561 c25561 = new C25561(this);
            Object obj = null;
            switch (C25572.f18046a[action.ordinal()]) {
                case 1:
                    obj = "tasks-saveEvent:" + this.f18047a.a;
                    this.f18052f.a(new EventSavingEvent());
                    break;
                case 2:
                    obj = "tasks-removeEvent:" + this.f18047a.a;
                    this.f18052f.a(new EventUnsavingEvent());
                    break;
            }
            this.f18051e.a(obj, a, c25561);
        }
    }
}
