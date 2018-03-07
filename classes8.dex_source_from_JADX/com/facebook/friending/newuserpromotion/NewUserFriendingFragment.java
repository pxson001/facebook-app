package com.facebook.friending.newuserpromotion;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.base.broadcast.BaseFbBroadcastManager.SelfRegistrableReceiverImpl;
import com.facebook.base.fragment.FbFragment;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.common.network.NetworkMonitor;
import com.facebook.common.network.NetworkMonitor.State;
import com.facebook.common.util.CollectionUtil;
import com.facebook.friending.newuserpromotion.NewUserFriendingAdapter.NewUserFriendingFragmentRow;
import com.facebook.friending.newuserpromotion.NewUserFriendingAdapter.RowType;
import com.facebook.friends.FriendingClient;
import com.facebook.friends.constants.FriendingLocation;
import com.facebook.friends.model.FriendRequest;
import com.facebook.friends.model.PersonYouMayKnow;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.ui.futures.TasksManager;
import com.facebook.widget.recyclerview.BetterLinearLayoutManager;
import com.facebook.widget.recyclerview.BetterRecyclerView;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.List;
import java.util.concurrent.Callable;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: fig_button_layout */
public class NewUserFriendingFragment extends FbFragment {
    public static final CallerContext f13364e = CallerContext.a(NewUserFriendingFragment.class);
    @Inject
    public NewUserFriendingAdapterProvider f13365a;
    public SelfRegistrableReceiverImpl al;
    @Inject
    public FriendingClient f13366b;
    @Inject
    public TasksManager f13367c;
    @Inject
    public NetworkMonitor f13368d;
    private BetterRecyclerView f13369f;
    public BetterLinearLayoutManager f13370g;
    public NewUserFriendingAdapter f13371h;
    public FriendingLocation f13372i;

    /* compiled from: fig_button_layout */
    class C14161 extends OnScrollListener {
        final /* synthetic */ NewUserFriendingFragment f13358a;

        C14161(NewUserFriendingFragment newUserFriendingFragment) {
            this.f13358a = newUserFriendingFragment;
        }

        public final void m15000a(RecyclerView recyclerView, int i, int i2) {
            super.a(recyclerView, i, i2);
            if (i2 >= 0) {
                if (this.f13358a.f13370g.n() + 3 > this.f13358a.f13371h.aZ_()) {
                    NewUserFriendingFragment.m15006e(this.f13358a);
                }
            }
        }
    }

    /* compiled from: fig_button_layout */
    public class C14172 implements Callable<ListenableFuture<List<FriendRequest>>> {
        final /* synthetic */ NewUserFriendingFragment f13359a;

        public C14172(NewUserFriendingFragment newUserFriendingFragment) {
            this.f13359a = newUserFriendingFragment;
        }

        public Object call() {
            return this.f13359a.f13366b.a(10, NewUserFriendingFragment.f13364e);
        }
    }

    /* compiled from: fig_button_layout */
    public class C14183 extends AbstractDisposableFutureCallback<List<FriendRequest>> {
        final /* synthetic */ NewUserFriendingFragment f13360a;

        public C14183(NewUserFriendingFragment newUserFriendingFragment) {
            this.f13360a = newUserFriendingFragment;
        }

        protected final void m15001a(Object obj) {
            List list = (List) obj;
            this.f13360a.f13371h.m14996a(list);
            if (CollectionUtil.a(list)) {
                NewUserFriendingFragment.m15006e(this.f13360a);
            }
        }

        protected final void m15002a(Throwable th) {
        }
    }

    /* compiled from: fig_button_layout */
    public class C14194 implements Callable<ListenableFuture<List<PersonYouMayKnow>>> {
        final /* synthetic */ NewUserFriendingFragment f13361a;

        public C14194(NewUserFriendingFragment newUserFriendingFragment) {
            this.f13361a = newUserFriendingFragment;
        }

        public Object call() {
            return this.f13361a.f13366b.a(10, this.f13361a.f13372i.peopleYouMayKnowLocation, NewUserFriendingFragment.f13364e);
        }
    }

    /* compiled from: fig_button_layout */
    public class C14205 extends AbstractDisposableFutureCallback<List<PersonYouMayKnow>> {
        final /* synthetic */ NewUserFriendingFragment f13362a;

        public C14205(NewUserFriendingFragment newUserFriendingFragment) {
            this.f13362a = newUserFriendingFragment;
        }

        protected final void m15003a(Object obj) {
            this.f13362a.f13371h.m14997b((List) obj);
        }

        protected final void m15004a(Throwable th) {
        }
    }

    /* compiled from: fig_button_layout */
    public class C14216 implements Runnable {
        final /* synthetic */ NewUserFriendingFragment f13363a;

        public C14216(NewUserFriendingFragment newUserFriendingFragment) {
            this.f13363a = newUserFriendingFragment;
        }

        public void run() {
            NewUserFriendingFragment.m15006e(this.f13363a);
        }
    }

    public static void m15005a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        NewUserFriendingFragment newUserFriendingFragment = (NewUserFriendingFragment) obj;
        NewUserFriendingAdapterProvider newUserFriendingAdapterProvider = (NewUserFriendingAdapterProvider) fbInjector.getOnDemandAssistedProviderForStaticDi(NewUserFriendingAdapterProvider.class);
        FriendingClient b = FriendingClient.b(fbInjector);
        TasksManager b2 = TasksManager.b(fbInjector);
        NetworkMonitor a = NetworkMonitor.a(fbInjector);
        newUserFriendingFragment.f13365a = newUserFriendingAdapterProvider;
        newUserFriendingFragment.f13366b = b;
        newUserFriendingFragment.f13367c = b2;
        newUserFriendingFragment.f13368d = a;
    }

    public final void m15009c(@Nullable Bundle bundle) {
        super.c(bundle);
        Class cls = NewUserFriendingFragment.class;
        m15005a((Object) this, getContext());
        this.f13372i = (FriendingLocation) this.s.getSerializable("FRIENDING_LOCATION");
        this.f13371h = this.f13365a.m14998a(getContext(), this.f13367c, this.f13372i);
    }

    public final View m15007a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1647600526);
        View inflate = layoutInflater.inflate(2130905445, viewGroup, false);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1925876177, a);
        return inflate;
    }

    public final void m15008a(View view, @Nullable Bundle bundle) {
        super.a(view, bundle);
        this.f13369f = (BetterRecyclerView) e(2131564231);
        this.f13370g = new BetterLinearLayoutManager(this.f13369f.getContext());
        this.f13369f.setLayoutManager(this.f13370g);
        this.f13369f.setAdapter(this.f13371h);
        this.f13369f.setItemAnimator(null);
        this.f13369f.setOnScrollListener(new C14161(this));
        m15006e(this);
        this.al = this.f13368d.a(State.CONNECTED, new C14216(this));
    }

    public final void mY_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1981055930);
        this.f13367c.c();
        this.al.c();
        super.mY_();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1129182579, a);
    }

    public static void m15006e(NewUserFriendingFragment newUserFriendingFragment) {
        if (!newUserFriendingFragment.f13367c.a()) {
            if (newUserFriendingFragment.f13366b.b()) {
                newUserFriendingFragment.f13367c.a("FETCH_FRIEND_REQUESTS_TASK", new C14172(newUserFriendingFragment), new C14183(newUserFriendingFragment));
            } else if (newUserFriendingFragment.f13366b.c()) {
                newUserFriendingFragment.f13367c.a("FETCH_PYMK_TASK", new C14194(newUserFriendingFragment), new C14205(newUserFriendingFragment));
            } else {
                NewUserFriendingAdapter newUserFriendingAdapter = newUserFriendingFragment.f13371h;
                if (CollectionUtil.b(newUserFriendingAdapter.f13348i)) {
                    int size = newUserFriendingAdapter.f13348i.size() - 1;
                    if (((NewUserFriendingFragmentRow) newUserFriendingAdapter.f13348i.get(size)).f13338a == RowType.PROGRESS_BAR) {
                        newUserFriendingAdapter.f13348i.remove(size);
                        newUserFriendingAdapter.l_(size);
                    }
                }
            }
        }
    }
}
