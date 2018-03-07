package com.facebook.events.permalink.messagefriends;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import com.facebook.base.fragment.FbFragment;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.network.FbNetworkManager;
import com.facebook.common.util.FindViewUtil;
import com.facebook.events.graphql.EventFriendsGraphQLInterfaces.EventPreview;
import com.facebook.events.permalink.messagefriends.EventCreateGroupHandler.C26421;
import com.facebook.events.permalink.messagefriends.EventCreateGroupHandler.C26432;
import com.facebook.fbui.dialog.AlertDialog;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.Lazy;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.messaging.sharing.sendasmessage.SendAsMessageUtil;
import com.facebook.ui.dialogs.ProgressDialogFragment;
import com.facebook.ui.futures.TasksManager;
import com.facebook.widget.error.GenericErrorView;
import com.facebook.widget.error.GenericErrorViewStub;
import com.facebook.widget.recyclerview.BetterRecyclerView;
import com.facebook.widget.recyclerview.BetterRecyclerView.OnItemClickListener;
import com.facebook.widget.titlebar.FbTitleBar.OnToolbarButtonListener;
import com.facebook.widget.titlebar.HasTitleBar;
import com.facebook.widget.titlebar.TitleBarButtonSpec;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.ImmutableSet.Builder;
import com.google.common.collect.Iterables;
import java.util.Set;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: bio */
public class EventMessageFriendsFragment extends FbFragment {
    @Inject
    public SendAsMessageUtil f18630a;
    public GenericErrorViewStub al;
    @Nullable
    public EventMessageFriendsAdapter am;
    @Nullable
    private HasTitleBar an;
    private TitleBarButtonSpec ao;
    private TitleBarButtonSpec ap;
    private OnToolbarButtonListener aq;
    public GenericErrorView ar;
    @Inject
    public EventMessageFriendsDataFetcher f18631b;
    @Inject
    public Lazy<EventCreateGroupHandler> f18632c;
    @Inject
    public Lazy<FbNetworkManager> f18633d;
    public boolean f18634e;
    @Nullable
    public String f18635f;
    @Nullable
    public EventPreview f18636g;
    public ProgressBar f18637h;
    public BetterRecyclerView f18638i;

    /* compiled from: bio */
    class C26481 extends OnToolbarButtonListener {
        final /* synthetic */ EventMessageFriendsFragment f18626a;

        C26481(EventMessageFriendsFragment eventMessageFriendsFragment) {
            this.f18626a = eventMessageFriendsFragment;
        }

        public final void m18936a(View view, TitleBarButtonSpec titleBarButtonSpec) {
            EventMessageFriendsAdapter eventMessageFriendsAdapter = this.f18626a.am;
            Builder builder = ImmutableSet.builder();
            int size = eventMessageFriendsAdapter.f18616a.size();
            for (int i = 0; i < size; i++) {
                builder.b(Iterables.a(((EventFriendsSection) eventMessageFriendsAdapter.f18616a.get(i)).f18615d));
            }
            Set b = builder.b();
            if (b != null && !b.isEmpty()) {
                if (this.f18626a.f18634e) {
                    EventCreateGroupHandler eventCreateGroupHandler = (EventCreateGroupHandler) this.f18626a.f18632c.get();
                    Activity ao = this.f18626a.ao();
                    FragmentManager s = this.f18626a.s();
                    if (!eventCreateGroupHandler.f18606f.a("create_group_thread")) {
                        if (eventCreateGroupHandler.f18609i == null) {
                            eventCreateGroupHandler.f18609i = ProgressDialogFragment.a(2131237241, true, false, false);
                        }
                        eventCreateGroupHandler.f18609i.a(s, EventCreateGroupHandler.f18599a);
                        eventCreateGroupHandler.f18606f.a("create_group_thread", new C26421(eventCreateGroupHandler, b), new C26432(eventCreateGroupHandler, ao));
                        return;
                    }
                    return;
                }
                this.f18626a.m18944a(b);
            }
        }
    }

    /* compiled from: bio */
    public class C26492 implements OnItemClickListener {
        final /* synthetic */ EventMessageFriendsFragment f18627a;

        public C26492(EventMessageFriendsFragment eventMessageFriendsFragment) {
            this.f18627a = eventMessageFriendsFragment;
        }

        public final void m18937a(BetterRecyclerView betterRecyclerView, View view, int i, long j) {
            this.f18627a.am.m18932f(i);
        }
    }

    /* compiled from: bio */
    class C26503 implements OnClickListener {
        final /* synthetic */ EventMessageFriendsFragment f18628a;

        C26503(EventMessageFriendsFragment eventMessageFriendsFragment) {
            this.f18628a = eventMessageFriendsFragment;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            this.f18628a.ao().finish();
        }
    }

    /* compiled from: bio */
    class C26514 implements View.OnClickListener {
        final /* synthetic */ EventMessageFriendsFragment f18629a;

        C26514(EventMessageFriendsFragment eventMessageFriendsFragment) {
            this.f18629a = eventMessageFriendsFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 170139484);
            this.f18629a.ar.setVisibility(8);
            this.f18629a.f18637h.setVisibility(0);
            this.f18629a.f18631b.m18935a(this.f18629a.f18635f, this.f18629a);
            Logger.a(2, EntryType.UI_INPUT_END, -1628363219, a);
        }
    }

    public static void m18938a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        EventMessageFriendsFragment eventMessageFriendsFragment = (EventMessageFriendsFragment) obj;
        SendAsMessageUtil a = SendAsMessageUtil.a(fbInjector);
        EventMessageFriendsDataFetcher eventMessageFriendsDataFetcher = new EventMessageFriendsDataFetcher(GraphQLQueryExecutor.a(fbInjector), ResourcesMethodAutoProvider.a(fbInjector), TasksManager.b(fbInjector));
        Lazy a2 = IdBasedLazy.a(fbInjector, 5656);
        Lazy b = IdBasedSingletonScopeProvider.b(fbInjector, 585);
        eventMessageFriendsFragment.f18630a = a;
        eventMessageFriendsFragment.f18631b = eventMessageFriendsDataFetcher;
        eventMessageFriendsFragment.f18632c = a2;
        eventMessageFriendsFragment.f18633d = b;
    }

    public final void m18947c(@Nullable Bundle bundle) {
        super.c(bundle);
        Class cls = EventMessageFriendsFragment.class;
        m18938a((Object) this, getContext());
        this.f18634e = this.s.getBoolean("extra_message_as_group", false);
        this.f18635f = this.s.getString("event_id", null);
        if (this.f18635f != null) {
            this.f18631b.m18935a(this.f18635f, this);
        } else {
            m18946b();
        }
        TitleBarButtonSpec.Builder a = TitleBarButtonSpec.a();
        a.g = b(2131237197);
        a = a;
        a.h = -2;
        a = a;
        a.d = true;
        this.ao = a.a();
        a.d = false;
        this.ap = a.a();
        this.aq = new C26481(this);
    }

    protected final void m18944a(Set<String> set) {
        String b;
        Preconditions.checkNotNull(this.f18636g);
        SendAsMessageUtil sendAsMessageUtil = this.f18630a;
        Activity ao = ao();
        String d = this.f18636g.d();
        String g = this.f18636g.g();
        if (this.f18636g.b() != null) {
            b = this.f18636g.b().b();
        } else {
            b = null;
        }
        sendAsMessageUtil.a(ao, d, g, b, this.f18636g.c() != null ? this.f18636g.c().a() : null, this.f18636g.dJ_(), set, "event", 100);
    }

    public final View m18940a(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1811433540);
        super.a(layoutInflater, viewGroup, bundle);
        View inflate = layoutInflater.inflate(2130904047, viewGroup, false);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1559382462, a);
        return inflate;
    }

    public final void m18943a(View view, @Nullable Bundle bundle) {
        super.a(view, bundle);
        this.f18637h = (ProgressBar) FindViewUtil.b(view, 2131560407);
        this.f18638i = (BetterRecyclerView) FindViewUtil.b(view, 2131561330);
        this.al = (GenericErrorViewStub) FindViewUtil.b(view, 2131561331);
    }

    public final void mi_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1453925031);
        super.mi_();
        ar();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1946043042, a);
    }

    public final void m18942a(int i, int i2, Intent intent) {
        super.a(i, i2, intent);
        if (i == 100 && i2 == -1) {
            Activity ao = ao();
            if (ao != null) {
                ao.finish();
            }
        }
    }

    private void ar() {
        this.an = (HasTitleBar) a(HasTitleBar.class);
        if (this.an != null) {
            this.an.y_(this.f18634e ? 2131237237 : 2131237236);
            this.an.c(true);
            m18939b(false);
        }
    }

    private void m18939b(boolean z) {
        if (this.an != null) {
            if (z) {
                this.an.a(this.ao);
                this.an.a(this.aq);
                return;
            }
            this.an.a(this.ap);
            this.an.a(null);
        }
    }

    public final void m18941a() {
        new AlertDialog.Builder(getContext()).b(2131237247).a(2131230726, new C26503(this)).b();
    }

    public final void m18946b() {
        if (this.ar == null) {
            this.ar = (GenericErrorView) this.al.a();
        }
        this.f18637h.setVisibility(8);
        this.f18638i.setVisibility(8);
        this.ar.setVisibility(0);
        if (((FbNetworkManager) this.f18633d.get()).d()) {
            this.ar.b();
        } else {
            this.ar.a();
        }
        this.ar.setOnClickListener(new C26514(this));
    }

    public final void m18945a(boolean z) {
        m18939b(z);
    }
}
