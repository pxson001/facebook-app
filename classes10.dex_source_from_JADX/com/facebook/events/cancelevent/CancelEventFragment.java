package com.facebook.events.cancelevent;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import com.facebook.auth.annotations.LoggedInUser;
import com.facebook.base.fragment.CanHandleBackPressed;
import com.facebook.base.fragment.FbFragment;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.common.futures.DisposableFutureCallback;
import com.facebook.common.util.StringUtil;
import com.facebook.events.common.ActionMechanism;
import com.facebook.events.common.EventAnalyticsParams;
import com.facebook.events.eventsevents.EventsEventBus;
import com.facebook.events.eventsevents.EventsEvents.EventCanceledEvent;
import com.facebook.events.eventsevents.EventsEvents.EventStatus;
import com.facebook.events.graphql.EventsMutations.EventSoftCancelMutationString;
import com.facebook.events.graphql.EventsMutationsModels.CancelEventMutationModel;
import com.facebook.events.graphql.EventsMutationsModels.EventSoftCancelMutationModel;
import com.facebook.events.mutators.EventDeleteAndCancelMutator;
import com.facebook.fbui.widget.contentview.CheckedContentView;
import com.facebook.fbui.widget.contentview.ContentView;
import com.facebook.graphql.calls.EventSoftCancelInputData;
import com.facebook.graphql.calls.EventSoftCancelInputData.Context.EventActionHistory;
import com.facebook.graphql.calls.GraphQlCallInput;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedProvider;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.resources.ui.FbButton;
import com.facebook.tagging.ui.MentionsAutoCompleteTextView;
import com.facebook.ui.dialogs.ProgressDialogFragment;
import com.facebook.ui.futures.TasksManager;
import com.facebook.ui.titlebar.Fb4aTitleBarSupplier;
import com.facebook.user.model.User;
import com.facebook.widget.titlebar.FbTitleBar;
import com.facebook.widget.titlebar.FbTitleBarSupplier;
import com.google.common.collect.ImmutableList;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: container_cover_media */
public class CancelEventFragment extends FbFragment implements CanHandleBackPressed {
    @Inject
    EventDeleteAndCancelMutator f15960a;
    public int al;
    public MentionsAutoCompleteTextView am;
    private ContentView an;
    public CheckedContentView ao;
    public CheckedContentView ap;
    private FbButton aq;
    public DialogFragment ar;
    private final DisposableFutureCallback<GraphQLResult<CancelEventMutationModel>> as = new C22271(this);
    private final DisposableFutureCallback<GraphQLResult<EventSoftCancelMutationModel>> at = new C22282(this);
    @Inject
    FbTitleBarSupplier f15961b;
    @Inject
    @LoggedInUser
    Provider<User> f15962c;
    @Inject
    TasksManager f15963d;
    @Inject
    EventsEventBus f15964e;
    private String f15965f;
    private EventAnalyticsParams f15966g;
    private User f15967h;
    public int f15968i;

    /* compiled from: container_cover_media */
    class C22271 extends AbstractDisposableFutureCallback<GraphQLResult<CancelEventMutationModel>> {
        final /* synthetic */ CancelEventFragment f15955a;

        C22271(CancelEventFragment cancelEventFragment) {
            this.f15955a = cancelEventFragment;
        }

        protected final void m16396a(Object obj) {
            this.f15955a.f15968i = this.f15955a.al;
            CancelEventFragment.as(this.f15955a);
        }

        protected final void m16397a(Throwable th) {
            CancelEventFragment.as(this.f15955a);
        }
    }

    /* compiled from: container_cover_media */
    class C22282 extends AbstractDisposableFutureCallback<GraphQLResult<EventSoftCancelMutationModel>> {
        final /* synthetic */ CancelEventFragment f15956a;

        C22282(CancelEventFragment cancelEventFragment) {
            this.f15956a = cancelEventFragment;
        }

        protected final void m16398a(Object obj) {
            this.f15956a.f15968i = this.f15956a.al;
            this.f15956a.f15964e.a(new EventCanceledEvent(EventStatus.SUCCESS));
            CancelEventFragment.as(this.f15956a);
        }

        protected final void m16399a(Throwable th) {
            CancelEventFragment.as(this.f15956a);
        }
    }

    /* compiled from: container_cover_media */
    class C22293 implements OnClickListener {
        final /* synthetic */ CancelEventFragment f15957a;

        C22293(CancelEventFragment cancelEventFragment) {
            this.f15957a = cancelEventFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1012853752);
            CancelEventFragment cancelEventFragment = this.f15957a;
            ((InputMethodManager) cancelEventFragment.ao().getSystemService("input_method")).hideSoftInputFromWindow(cancelEventFragment.am.getWindowToken(), 0);
            CancelEventFragment.aq(this.f15957a);
            Logger.a(2, EntryType.UI_INPUT_END, 242434599, a);
        }
    }

    /* compiled from: container_cover_media */
    public class C22304 implements OnClickListener {
        final /* synthetic */ CancelEventFragment f15958a;

        public C22304(CancelEventFragment cancelEventFragment) {
            this.f15958a = cancelEventFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1482624718);
            this.f15958a.ao.setChecked(true);
            this.f15958a.ap.setChecked(false);
            this.f15958a.am.setVisibility(0);
            this.f15958a.al = 1;
            Logger.a(2, EntryType.UI_INPUT_END, 2103529567, a);
        }
    }

    /* compiled from: container_cover_media */
    public class C22315 implements OnClickListener {
        final /* synthetic */ CancelEventFragment f15959a;

        public C22315(CancelEventFragment cancelEventFragment) {
            this.f15959a = cancelEventFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -223195760);
            this.f15959a.ao.setChecked(false);
            this.f15959a.ap.setChecked(true);
            this.f15959a.am.setVisibility(8);
            this.f15959a.al = 2;
            Logger.a(2, EntryType.UI_INPUT_END, -1695363028, a);
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    /* compiled from: container_cover_media */
    public @interface EventCancelState {
    }

    public static void m16401a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((CancelEventFragment) obj).m16400a(EventDeleteAndCancelMutator.b(fbInjector), (FbTitleBarSupplier) Fb4aTitleBarSupplier.a(fbInjector), IdBasedProvider.a(fbInjector, 3595), TasksManager.b(fbInjector), EventsEventBus.a(fbInjector));
    }

    private void m16400a(EventDeleteAndCancelMutator eventDeleteAndCancelMutator, FbTitleBarSupplier fbTitleBarSupplier, Provider<User> provider, TasksManager tasksManager, EventsEventBus eventsEventBus) {
        this.f15960a = eventDeleteAndCancelMutator;
        this.f15961b = fbTitleBarSupplier;
        this.f15962c = provider;
        this.f15963d = tasksManager;
        this.f15964e = eventsEventBus;
    }

    public final void m16404c(Bundle bundle) {
        super.c(bundle);
        Class cls = CancelEventFragment.class;
        m16401a((Object) this, getContext());
        this.f15965f = this.s.getString("event_id");
        this.f15966g = (EventAnalyticsParams) this.s.getParcelable("extras_event_analytics_params");
        this.f15967h = (User) this.f15962c.get();
        this.f15968i = this.s.getBoolean("extra_is_event_canceled") ? 1 : 0;
        this.al = this.f15968i;
    }

    public final View m16402a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1321238421);
        View inflate = layoutInflater.inflate(2130903498, viewGroup, false);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1008928788, a);
        return inflate;
    }

    public final void m16403a(View view, Bundle bundle) {
        super.a(view, bundle);
        this.an = (ContentView) e(2131560194);
        this.an.setTitleText(this.f15967h.j());
        this.an.setThumbnailUri(this.f15967h.x());
        this.ao = (CheckedContentView) e(2131560192);
        this.ap = (CheckedContentView) e(2131560193);
        this.ao.setOnClickListener(new C22304(this));
        this.ap.setOnClickListener(new C22315(this));
        this.am = (MentionsAutoCompleteTextView) e(2131560195);
        this.aq = (FbButton) e(2131560196);
        this.aq.setOnClickListener(new C22293(this));
    }

    public final void mi_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -879857803);
        super.mi_();
        ((FbTitleBar) this.f15961b.get()).setTitle(2131241881);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 250354071, a);
    }

    public final boolean O_() {
        this.at.jc_();
        this.as.jc_();
        return false;
    }

    public static void aq(CancelEventFragment cancelEventFragment) {
        if (cancelEventFragment.al != cancelEventFragment.f15968i) {
            if (cancelEventFragment.f15966g == null) {
                throw new IllegalStateException("EventActionContext not set");
            }
            cancelEventFragment.ar = ProgressDialogFragment.a(cancelEventFragment.al == 1 ? 2131241889 : 2131237058, true, false);
            cancelEventFragment.ar.a(cancelEventFragment.kO_(), "progress_dialog");
            if (cancelEventFragment.al == 1) {
                EventDeleteAndCancelMutator eventDeleteAndCancelMutator = cancelEventFragment.f15960a;
                String str = cancelEventFragment.f15965f;
                Object encodedText = cancelEventFragment.am.getEncodedText();
                EventAnalyticsParams eventAnalyticsParams = cancelEventFragment.f15966g;
                String actionMechanism = ActionMechanism.CANCEL_EVENT_FLOW.toString();
                EventActionHistory eventActionHistory = new EventActionHistory();
                eventActionHistory.a(eventAnalyticsParams.c);
                EventActionHistory eventActionHistory2 = new EventActionHistory();
                eventActionHistory2.a(eventAnalyticsParams.d);
                eventActionHistory2.a("mechanism", actionMechanism);
                EventSoftCancelInputData.Context context = new EventSoftCancelInputData.Context();
                context.a("event_action_history", ImmutableList.of(eventActionHistory, eventActionHistory2));
                EventSoftCancelInputData eventSoftCancelInputData = new EventSoftCancelInputData();
                eventSoftCancelInputData.a("event_id", str);
                GraphQlCallInput graphQlCallInput = eventSoftCancelInputData;
                graphQlCallInput.a("context", context);
                graphQlCallInput = graphQlCallInput;
                if (!StringUtil.a(encodedText)) {
                    graphQlCallInput.a("cancellation_reason", encodedText);
                }
                cancelEventFragment.f15963d.a("cancel_event_task" + cancelEventFragment.f15965f, eventDeleteAndCancelMutator.a.a(GraphQLRequest.a((EventSoftCancelMutationString) new EventSoftCancelMutationString().a("input", graphQlCallInput))), cancelEventFragment.at);
            } else if (cancelEventFragment.al == 2) {
                cancelEventFragment.f15963d.a("cancel_event_task" + cancelEventFragment.f15965f, cancelEventFragment.f15960a.a(cancelEventFragment.f15965f, cancelEventFragment.f15966g, ActionMechanism.CANCEL_EVENT_FLOW.toString()), cancelEventFragment.as);
            }
        }
    }

    public static final void as(CancelEventFragment cancelEventFragment) {
        if (cancelEventFragment.ar != null) {
            cancelEventFragment.ar.b();
            cancelEventFragment.ar = null;
        }
        Intent intent = new Intent();
        intent.putExtra("extra_event_cancel_state", cancelEventFragment.f15968i);
        FragmentActivity o = cancelEventFragment.o();
        if (o != null) {
            o.setResult(-1, intent);
            o.finish();
        }
    }
}
