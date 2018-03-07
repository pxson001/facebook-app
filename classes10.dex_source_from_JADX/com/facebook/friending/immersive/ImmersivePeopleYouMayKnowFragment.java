package com.facebook.friending.immersive;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.facebook.base.fragment.FbFragment;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.common.i18n.RTLUtil;
import com.facebook.friending.immersive.ImmersivePeopleYouMayKnowAdapter.C28713;
import com.facebook.friending.immersive.ImmersivePeopleYouMayKnowAdapter.Type;
import com.facebook.friending.immersive.ImmersivePeopleYouMayKnowLoadingState.LoadingState;
import com.facebook.friends.FriendingCacheHandler;
import com.facebook.friends.FriendingCacheHandlerProvider;
import com.facebook.friends.FriendingClient;
import com.facebook.friends.constants.PeopleYouMayKnowLocation;
import com.facebook.friends.model.PersonYouMayKnow;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.ui.futures.TasksManager;
import com.facebook.widget.titlebar.FbTitleBar.OnToolbarButtonListener;
import com.facebook.widget.titlebar.HasTitleBar;
import com.facebook.widget.titlebar.TitleBarButtonSpec;
import com.facebook.widget.titlebar.TitleBarButtonSpec.Builder;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.List;
import java.util.concurrent.Callable;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: addMembersToGroup */
public class ImmersivePeopleYouMayKnowFragment extends FbFragment {
    public static final CallerContext f20230h = CallerContext.a(ImmersivePeopleYouMayKnowFragment.class);
    @Inject
    ImmersivePeopleYouMayKnowLoadingState f20231a;
    public GridLayoutManager al;
    private LinearLayoutManager am;
    public SwipeRefreshLayout an;
    public FriendingCacheHandler ao;
    private GridSpacingItemDecoration ap;
    public ImmersivePeopleYouMayKnowAdapter aq;
    public int ar;
    @Inject
    TasksManager f20232b;
    @Inject
    FriendingClient f20233c;
    @Inject
    ImmersivePeopleYouMayKnowAdapterProvider f20234d;
    @Inject
    GridSpacingItemDecorationProvider f20235e;
    @Inject
    FriendingCacheHandlerProvider f20236f;
    @Inject
    CardSpacingItemDecoration f20237g;
    private RecyclerView f20238i;

    /* compiled from: addMembersToGroup */
    class C28771 implements OnClickListener {
        final /* synthetic */ ImmersivePeopleYouMayKnowFragment f20221a;

        C28771(ImmersivePeopleYouMayKnowFragment immersivePeopleYouMayKnowFragment) {
            this.f20221a = immersivePeopleYouMayKnowFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 2140816734);
            ImmersivePeopleYouMayKnowFragment.ar(this.f20221a);
            Logger.a(2, EntryType.UI_INPUT_END, -6798848, a);
        }
    }

    /* compiled from: addMembersToGroup */
    class C28782 implements OnRefreshListener {
        final /* synthetic */ ImmersivePeopleYouMayKnowFragment f20222a;

        C28782(ImmersivePeopleYouMayKnowFragment immersivePeopleYouMayKnowFragment) {
            this.f20222a = immersivePeopleYouMayKnowFragment;
        }

        public final void m20511a() {
            ImmersivePeopleYouMayKnowFragment immersivePeopleYouMayKnowFragment = this.f20222a;
            ImmersivePeopleYouMayKnowFragment.m20520a(immersivePeopleYouMayKnowFragment, LoadingState.REFRESHING);
            immersivePeopleYouMayKnowFragment.ao.c(new C28814(immersivePeopleYouMayKnowFragment));
        }
    }

    /* compiled from: addMembersToGroup */
    public class C28793 extends OnScrollListener {
        final /* synthetic */ ImmersivePeopleYouMayKnowFragment f20223a;

        public C28793(ImmersivePeopleYouMayKnowFragment immersivePeopleYouMayKnowFragment) {
            this.f20223a = immersivePeopleYouMayKnowFragment;
        }

        public final void m20512a(RecyclerView recyclerView, int i, int i2) {
            if (i2 > 0) {
                int D = this.f20223a.al.D();
                int n = this.f20223a.al.n();
                if (this.f20223a.f20231a.f20241a == LoadingState.IDLE && n >= D - 4) {
                    ImmersivePeopleYouMayKnowFragment.ar(this.f20223a);
                }
            }
        }
    }

    /* compiled from: addMembersToGroup */
    public class C28814 implements FutureCallback {
        final /* synthetic */ ImmersivePeopleYouMayKnowFragment f20225a;

        /* compiled from: addMembersToGroup */
        class C28801 extends AbstractDisposableFutureCallback<List<PersonYouMayKnow>> {
            final /* synthetic */ C28814 f20224a;

            C28801(C28814 c28814) {
                this.f20224a = c28814;
            }

            protected final void m20513a(Object obj) {
                List list = (List) obj;
                this.f20224a.f20225a.an.setRefreshing(false);
                ImmersivePeopleYouMayKnowAdapter immersivePeopleYouMayKnowAdapter = this.f20224a.f20225a.aq;
                immersivePeopleYouMayKnowAdapter.f20210e.clear();
                immersivePeopleYouMayKnowAdapter.notifyDataSetChanged();
                this.f20224a.f20225a.aq.m20509a(list);
                ImmersivePeopleYouMayKnowFragment.m20520a(this.f20224a.f20225a, LoadingState.IDLE);
            }

            protected final void m20514a(Throwable th) {
                this.f20224a.f20225a.an.setRefreshing(false);
                ImmersivePeopleYouMayKnowFragment.m20520a(this.f20224a.f20225a, LoadingState.ERROR);
            }
        }

        public C28814(ImmersivePeopleYouMayKnowFragment immersivePeopleYouMayKnowFragment) {
            this.f20225a = immersivePeopleYouMayKnowFragment;
        }

        public void onSuccess(@Nullable Object obj) {
            this.f20225a.f20232b.c(TaskKey.FETCH_PYMK);
            this.f20225a.f20233c.h();
            ImmersivePeopleYouMayKnowFragment.m20519a(this.f20225a, new C28801(this));
        }

        public void onFailure(Throwable th) {
            ImmersivePeopleYouMayKnowFragment.m20520a(this.f20225a, LoadingState.IDLE);
        }
    }

    /* compiled from: addMembersToGroup */
    class C28825 extends AbstractDisposableFutureCallback<List<PersonYouMayKnow>> {
        final /* synthetic */ ImmersivePeopleYouMayKnowFragment f20226a;

        C28825(ImmersivePeopleYouMayKnowFragment immersivePeopleYouMayKnowFragment) {
            this.f20226a = immersivePeopleYouMayKnowFragment;
        }

        protected final void m20515a(Object obj) {
            this.f20226a.aq.m20509a((List) obj);
            ImmersivePeopleYouMayKnowFragment.m20520a(this.f20226a, LoadingState.IDLE);
        }

        protected final void m20516a(Throwable th) {
            ImmersivePeopleYouMayKnowFragment.m20520a(this.f20226a, LoadingState.ERROR);
        }
    }

    /* compiled from: addMembersToGroup */
    class C28836 implements Callable<ListenableFuture<List<PersonYouMayKnow>>> {
        final /* synthetic */ ImmersivePeopleYouMayKnowFragment f20227a;

        C28836(ImmersivePeopleYouMayKnowFragment immersivePeopleYouMayKnowFragment) {
            this.f20227a = immersivePeopleYouMayKnowFragment;
        }

        public Object call() {
            return this.f20227a.f20233c.a(20, Integer.valueOf(this.f20227a.ar), PeopleYouMayKnowLocation.IMMERSIVE, ImmersivePeopleYouMayKnowFragment.f20230h);
        }
    }

    /* compiled from: addMembersToGroup */
    class C28847 extends OnToolbarButtonListener {
        final /* synthetic */ ImmersivePeopleYouMayKnowFragment f20228a;

        C28847(ImmersivePeopleYouMayKnowFragment immersivePeopleYouMayKnowFragment) {
            this.f20228a = immersivePeopleYouMayKnowFragment;
        }

        public final void m20517a(View view, TitleBarButtonSpec titleBarButtonSpec) {
            ImmersivePeopleYouMayKnowFragment.au(this.f20228a);
            this.f20228a.aq.m20508a(Type.CARD);
            ImmersivePeopleYouMayKnowFragment.as(this.f20228a);
        }
    }

    /* compiled from: addMembersToGroup */
    class C28858 extends OnToolbarButtonListener {
        final /* synthetic */ ImmersivePeopleYouMayKnowFragment f20229a;

        C28858(ImmersivePeopleYouMayKnowFragment immersivePeopleYouMayKnowFragment) {
            this.f20229a = immersivePeopleYouMayKnowFragment;
        }

        public final void m20518a(View view, TitleBarButtonSpec titleBarButtonSpec) {
            ImmersivePeopleYouMayKnowFragment.at(this.f20229a);
            this.f20229a.aq.m20508a(Type.GRID);
            ImmersivePeopleYouMayKnowFragment.as(this.f20229a);
        }
    }

    /* compiled from: addMembersToGroup */
    enum TaskKey {
        FETCH_PYMK
    }

    public static void m20522a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((ImmersivePeopleYouMayKnowFragment) obj).m20521a(ImmersivePeopleYouMayKnowLoadingState.m20528a(fbInjector), TasksManager.b(fbInjector), FriendingClient.b(fbInjector), (ImmersivePeopleYouMayKnowAdapterProvider) fbInjector.getOnDemandAssistedProviderForStaticDi(ImmersivePeopleYouMayKnowAdapterProvider.class), (GridSpacingItemDecorationProvider) fbInjector.getOnDemandAssistedProviderForStaticDi(GridSpacingItemDecorationProvider.class), (FriendingCacheHandlerProvider) fbInjector.getOnDemandAssistedProviderForStaticDi(FriendingCacheHandlerProvider.class), new CardSpacingItemDecoration(ResourcesMethodAutoProvider.a(fbInjector)));
    }

    private void m20521a(ImmersivePeopleYouMayKnowLoadingState immersivePeopleYouMayKnowLoadingState, TasksManager tasksManager, FriendingClient friendingClient, ImmersivePeopleYouMayKnowAdapterProvider immersivePeopleYouMayKnowAdapterProvider, GridSpacingItemDecorationProvider gridSpacingItemDecorationProvider, FriendingCacheHandlerProvider friendingCacheHandlerProvider, CardSpacingItemDecoration cardSpacingItemDecoration) {
        this.f20231a = immersivePeopleYouMayKnowLoadingState;
        this.f20232b = tasksManager;
        this.f20233c = friendingClient;
        this.f20234d = immersivePeopleYouMayKnowAdapterProvider;
        this.f20235e = gridSpacingItemDecorationProvider;
        this.f20236f = friendingCacheHandlerProvider;
        this.f20237g = cardSpacingItemDecoration;
    }

    public final void m20526c(@Nullable Bundle bundle) {
        super.c(bundle);
        Class cls = ImmersivePeopleYouMayKnowFragment.class;
        m20522a((Object) this, getContext());
        this.ao = this.f20236f.a(this.f20232b);
        GridSpacingItemDecorationProvider gridSpacingItemDecorationProvider = this.f20235e;
        this.ap = new GridSpacingItemDecoration(ResourcesMethodAutoProvider.a(gridSpacingItemDecorationProvider), RTLUtil.a(gridSpacingItemDecorationProvider), 2);
        this.aq = this.f20234d.m20510a(new C28771(this));
    }

    public final View m20524a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1316746475);
        View inflate = layoutInflater.inflate(2130904844, viewGroup, false);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -336766069, a);
        return inflate;
    }

    public final void m20525a(View view, @Nullable Bundle bundle) {
        super.a(view, bundle);
        this.ar = jW_().getDisplayMetrics().widthPixels / 2;
        this.f20238i = (RecyclerView) e(2131563064);
        this.al = new GridLayoutManager(getContext(), 2);
        this.al.h = new C28713(this.aq);
        this.am = new LinearLayoutManager(getContext());
        this.f20238i.setAdapter(this.aq);
        this.f20238i.setItemAnimator(new DefaultItemAnimator());
        this.f20238i.a(new C28793(this));
        if (this.aq.f20209d == Type.GRID) {
            at(this);
        } else {
            au(this);
        }
        this.an = (SwipeRefreshLayout) e(2131563063);
        this.an.e = new C28782(this);
        ImmersivePeopleYouMayKnowAdapter immersivePeopleYouMayKnowAdapter = this.aq;
        immersivePeopleYouMayKnowAdapter.f20216k.a(immersivePeopleYouMayKnowAdapter.f20207b);
        immersivePeopleYouMayKnowAdapter.f20216k.a(immersivePeopleYouMayKnowAdapter.f20208c);
        ar(this);
    }

    public final void mY_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1953004733);
        ImmersivePeopleYouMayKnowAdapter immersivePeopleYouMayKnowAdapter = this.aq;
        immersivePeopleYouMayKnowAdapter.f20216k.b(immersivePeopleYouMayKnowAdapter.f20207b);
        immersivePeopleYouMayKnowAdapter.f20216k.b(immersivePeopleYouMayKnowAdapter.f20208c);
        this.f20232b.c();
        this.f20238i = null;
        this.al = null;
        this.an = null;
        super.mY_();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 104469454, a);
    }

    public final void m20523G() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 716207324);
        super.G();
        as(this);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1980936664, a);
    }

    public static void ar(ImmersivePeopleYouMayKnowFragment immersivePeopleYouMayKnowFragment) {
        if (immersivePeopleYouMayKnowFragment.f20233c.c()) {
            m20520a(immersivePeopleYouMayKnowFragment, LoadingState.LOADING);
            m20519a(immersivePeopleYouMayKnowFragment, new C28825(immersivePeopleYouMayKnowFragment));
            return;
        }
        m20520a(immersivePeopleYouMayKnowFragment, LoadingState.FINISHED);
    }

    public static void m20519a(ImmersivePeopleYouMayKnowFragment immersivePeopleYouMayKnowFragment, AbstractDisposableFutureCallback abstractDisposableFutureCallback) {
        immersivePeopleYouMayKnowFragment.f20232b.a(TaskKey.FETCH_PYMK, new C28836(immersivePeopleYouMayKnowFragment), abstractDisposableFutureCallback);
    }

    public static void m20520a(ImmersivePeopleYouMayKnowFragment immersivePeopleYouMayKnowFragment, LoadingState loadingState) {
        immersivePeopleYouMayKnowFragment.f20231a.f20241a = loadingState;
        immersivePeopleYouMayKnowFragment.aq.notifyDataSetChanged();
    }

    public static void as(ImmersivePeopleYouMayKnowFragment immersivePeopleYouMayKnowFragment) {
        HasTitleBar hasTitleBar = (HasTitleBar) immersivePeopleYouMayKnowFragment.a(HasTitleBar.class);
        if (hasTitleBar != null) {
            hasTitleBar.y_(2131233210);
            hasTitleBar.c(true);
            Builder a;
            if (immersivePeopleYouMayKnowFragment.aq.f20209d == Type.GRID) {
                a = TitleBarButtonSpec.a();
                a.i = 2130839755;
                a = a;
                a.j = immersivePeopleYouMayKnowFragment.jW_().getString(2131241963);
                hasTitleBar.a(a.a());
                hasTitleBar.a(new C28847(immersivePeopleYouMayKnowFragment));
                return;
            }
            a = TitleBarButtonSpec.a();
            a.i = 2130839912;
            a = a;
            a.j = immersivePeopleYouMayKnowFragment.jW_().getString(2131241962);
            hasTitleBar.a(a.a());
            hasTitleBar.a(new C28858(immersivePeopleYouMayKnowFragment));
        }
    }

    public static void at(ImmersivePeopleYouMayKnowFragment immersivePeopleYouMayKnowFragment) {
        immersivePeopleYouMayKnowFragment.f20238i.setLayoutManager(immersivePeopleYouMayKnowFragment.al);
        immersivePeopleYouMayKnowFragment.f20238i.b(immersivePeopleYouMayKnowFragment.f20237g);
        immersivePeopleYouMayKnowFragment.f20238i.a(immersivePeopleYouMayKnowFragment.ap);
    }

    public static void au(ImmersivePeopleYouMayKnowFragment immersivePeopleYouMayKnowFragment) {
        immersivePeopleYouMayKnowFragment.f20238i.setLayoutManager(immersivePeopleYouMayKnowFragment.am);
        immersivePeopleYouMayKnowFragment.f20238i.b(immersivePeopleYouMayKnowFragment.ap);
        immersivePeopleYouMayKnowFragment.f20238i.a(immersivePeopleYouMayKnowFragment.f20237g);
    }
}
