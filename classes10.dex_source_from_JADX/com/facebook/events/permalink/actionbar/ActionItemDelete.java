package com.facebook.events.permalink.actionbar;

import android.content.ContentResolver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.facebook.common.android.ContentResolverMethodAutoProvider;
import com.facebook.common.executors.ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.events.common.ActionMechanism;
import com.facebook.events.common.EventAnalyticsParams;
import com.facebook.events.data.EventsCommonContract;
import com.facebook.events.eventsevents.EventsEventBus;
import com.facebook.events.eventsevents.EventsEvents.EventDeletedEvent;
import com.facebook.events.graphql.EventsMutationsModels.CancelEventMutationModel;
import com.facebook.events.model.Event;
import com.facebook.events.mutators.EventDeleteAndCancelMutator;
import com.facebook.fbui.dialog.ProgressDialog;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.inject.InjectorLike;
import com.facebook.tools.dextr.runtime.detour.ExecutorDetour;
import com.facebook.ui.dialogs.FbAlertDialogBuilder;
import com.facebook.ui.futures.TasksManager;
import com.google.common.util.concurrent.ListeningExecutorService;
import javax.inject.Inject;

/* compiled from: camera_roll_key */
public class ActionItemDelete {
    public Event f17936a;
    private EventAnalyticsParams f17937b;
    public ProgressDialog f17938c;
    public final Context f17939d;
    public final ContentResolver f17940e;
    public final EventsCommonContract f17941f;
    private final TasksManager f17942g;
    public final EventsEventBus f17943h;
    public final ListeningExecutorService f17944i;
    private final EventDeleteAndCancelMutator f17945j;

    /* compiled from: camera_roll_key */
    class C25412 extends AbstractDisposableFutureCallback<GraphQLResult<CancelEventMutationModel>> {
        final /* synthetic */ ActionItemDelete f17935a;

        /* compiled from: camera_roll_key */
        class C25401 implements Runnable {
            final /* synthetic */ C25412 f17934a;

            C25401(C25412 c25412) {
                this.f17934a = c25412;
            }

            public void run() {
                this.f17934a.f17935a.f17940e.delete(this.f17934a.f17935a.f17941f.c(this.f17934a.f17935a.f17936a.a), null, null);
            }
        }

        C25412(ActionItemDelete actionItemDelete) {
            this.f17935a = actionItemDelete;
        }

        protected final void m18338a(Object obj) {
            this.f17935a.f17943h.a(new EventDeletedEvent(this.f17935a.f17936a.a));
            ExecutorDetour.a(this.f17935a.f17944i, new C25401(this), 596632697);
            if (this.f17935a.f17938c != null) {
                this.f17935a.f17938c.dismiss();
                this.f17935a.f17938c = null;
            }
        }

        protected final void m18339a(Throwable th) {
            if (this.f17935a.f17938c != null) {
                this.f17935a.f17938c.dismiss();
                this.f17935a.f17938c = null;
            }
        }
    }

    public static ActionItemDelete m18341b(InjectorLike injectorLike) {
        return new ActionItemDelete((Context) injectorLike.getInstance(Context.class), ContentResolverMethodAutoProvider.b(injectorLike), EventsCommonContract.b(injectorLike), TasksManager.b(injectorLike), EventsEventBus.a(injectorLike), ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider.a(injectorLike), EventDeleteAndCancelMutator.b(injectorLike));
    }

    public static ActionItemDelete m18340a(InjectorLike injectorLike) {
        return m18341b(injectorLike);
    }

    @Inject
    public ActionItemDelete(Context context, ContentResolver contentResolver, EventsCommonContract eventsCommonContract, TasksManager tasksManager, EventsEventBus eventsEventBus, ListeningExecutorService listeningExecutorService, EventDeleteAndCancelMutator eventDeleteAndCancelMutator) {
        this.f17939d = context;
        this.f17940e = contentResolver;
        this.f17941f = eventsCommonContract;
        this.f17942g = tasksManager;
        this.f17943h = eventsEventBus;
        this.f17944i = listeningExecutorService;
        this.f17945j = eventDeleteAndCancelMutator;
    }

    public final void m18344a(Event event, EventAnalyticsParams eventAnalyticsParams) {
        this.f17936a = event;
        this.f17937b = eventAnalyticsParams;
    }

    public final void m18343a(final ActionMechanism actionMechanism) {
        new FbAlertDialogBuilder(this.f17939d).a(2131237054).b(2131237055).b(2131237057, null).a(2131237056, new OnClickListener(this) {
            final /* synthetic */ ActionItemDelete f17933b;

            public void onClick(DialogInterface dialogInterface, int i) {
                ActionItemDelete.m18342b(this.f17933b, actionMechanism);
            }
        }).b();
    }

    public static void m18342b(ActionItemDelete actionItemDelete, ActionMechanism actionMechanism) {
        if (actionItemDelete.f17936a != null) {
            if (actionItemDelete.f17937b == null || actionMechanism == null) {
                throw new IllegalStateException("EventActionContext or ActionMechanism not set");
            }
            actionItemDelete.f17938c = new ProgressDialog(actionItemDelete.f17939d);
            actionItemDelete.f17938c.d = 0;
            actionItemDelete.f17938c.a(actionItemDelete.f17939d.getText(2131237058));
            actionItemDelete.f17938c.a(true);
            actionItemDelete.f17938c.setCancelable(false);
            actionItemDelete.f17938c.show();
            actionItemDelete.f17942g.a("tasks-deleteEvent:" + actionItemDelete.f17936a.a, actionItemDelete.f17945j.a(actionItemDelete.f17936a.a, actionItemDelete.f17937b, actionMechanism.toString()), new C25412(actionItemDelete));
        }
    }
}
