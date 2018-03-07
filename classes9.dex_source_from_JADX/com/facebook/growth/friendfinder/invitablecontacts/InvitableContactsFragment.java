package com.facebook.growth.friendfinder.invitablecontacts;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import com.facebook.base.fragment.FbFragment;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.executors.ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.common.locale.Locales;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.common.util.StringUtil;
import com.facebook.device_id.UniqueIdForDeviceHolderMethodAutoProvider;
import com.facebook.fbui.dialog.AlertDialog;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.graphql.executor.GraphQLCachePolicy;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.growth.contactimporter.GrowthUtils;
import com.facebook.growth.contactimporter.SendInviteClient;
import com.facebook.growth.friendfinder.fetcher.InvitableContactsFetcher;
import com.facebook.growth.friendfinder.fetcher.InvitableContactsFetcher.C07911;
import com.facebook.growth.friendfinder.graphql.FetchInvitableContactsQueryGraphQL.InvitableContactsQueryString;
import com.facebook.growth.friendfinder.graphql.FetchInvitableContactsQueryGraphQLModels.InvitableContactsQueryModel.AddressbooksModel.EdgesModel.NodeModel.InvitableContactsModel.NodesModel;
import com.facebook.growth.friendfinder.invitablecontacts.InvitableContactsAdapter.State;
import com.facebook.growth.logging.FriendFinderAnalyticsLogger;
import com.facebook.growth.logging.FriendFinderAnalyticsLogger.ApiType;
import com.facebook.growth.logging.FriendFinderAnalyticsLogger.EventType;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectorLike;
import com.facebook.ipc.katana.findfriends.CIFlow;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.ui.futures.TasksManager;
import com.facebook.ui.keyboard.SmoothKeyboardFragmentBehavior;
import com.facebook.ui.search.SearchEditText;
import com.facebook.widget.listview.ScrollingViewProxy;
import com.facebook.widget.listview.ScrollingViewProxy.OnScrollListener;
import com.facebook.widget.loadingindicator.LoadingIndicator.RetryClickedListener;
import com.facebook.widget.loadingindicator.LoadingIndicatorView;
import com.facebook.widget.recyclerview.BetterLinearLayoutManager;
import com.facebook.widget.recyclerview.BetterRecyclerView;
import com.facebook.widget.recyclerview.BetterRecyclerView.OnTouchDownListener;
import com.facebook.widget.recyclerview.RecyclerViewProxy;
import com.facebook.widget.titlebar.HasTitleBar;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: page_actor_id */
public class InvitableContactsFragment extends FbFragment {
    private static final CallerContext f7378h = CallerContext.a(InvitableContactsFragment.class);
    @Inject
    Clock f7379a;
    private long aA = 0;
    private boolean aB = false;
    public boolean aC = true;
    private boolean aD = false;
    private final OnClickListener al = new C07951(this);
    private final RetryClickedListener am = new C07962(this);
    public BetterRecyclerView an;
    public SearchEditText ao;
    private TextView ap;
    private LoadingIndicatorView aq;
    private View ar;
    private View as;
    public View at;
    public InvitableContactsAdapter au;
    private InvitableContactsController av;
    public CIFlow aw;
    public RecyclerViewProxy ax;
    private TextWatcher ay;
    private long az;
    @Inject
    FriendFinderAnalyticsLogger f7380b;
    @Inject
    InvitableContactsAdapterProvider f7381c;
    @Inject
    InvitableContactsControllerProvider f7382d;
    @Inject
    InvitableContactsFetcher f7383e;
    @Inject
    GatekeeperStoreImpl f7384f;
    @Inject
    TasksManager f7385g;
    public final Set<String> f7386i = new HashSet();

    /* compiled from: page_actor_id */
    class C07951 implements OnClickListener {
        final /* synthetic */ InvitableContactsFragment f7369a;

        C07951(InvitableContactsFragment invitableContactsFragment) {
            this.f7369a = invitableContactsFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -1940505812);
            InvitableContactsFragment.m7707e(this.f7369a);
            Logger.a(2, EntryType.UI_INPUT_END, 852763206, a);
        }
    }

    /* compiled from: page_actor_id */
    class C07962 implements RetryClickedListener {
        final /* synthetic */ InvitableContactsFragment f7370a;

        C07962(InvitableContactsFragment invitableContactsFragment) {
            this.f7370a = invitableContactsFragment;
        }

        public final void m7698a() {
            InvitableContactsFragment.m7707e(this.f7370a);
        }
    }

    /* compiled from: page_actor_id */
    class C07973 implements OnTouchDownListener {
        final /* synthetic */ InvitableContactsFragment f7371a;

        C07973(InvitableContactsFragment invitableContactsFragment) {
            this.f7371a = invitableContactsFragment;
        }

        public final void m7699a() {
            this.f7371a.ao.c();
        }
    }

    /* compiled from: page_actor_id */
    public class C07984 implements TextWatcher {
        final /* synthetic */ InvitableContactsFragment f7372a;

        public C07984(InvitableContactsFragment invitableContactsFragment) {
            this.f7372a = invitableContactsFragment;
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void afterTextChanged(Editable editable) {
            this.f7372a.au.getFilter().filter(editable);
            if (this.f7372a.aC) {
                this.f7372a.at.setVisibility(StringUtil.a(editable) ? 0 : 8);
            }
        }
    }

    /* compiled from: page_actor_id */
    public class C07995 implements OnScrollListener {
        final /* synthetic */ InvitableContactsFragment f7373a;

        public C07995(InvitableContactsFragment invitableContactsFragment) {
            this.f7373a = invitableContactsFragment;
        }

        public final void m7700a(ScrollingViewProxy scrollingViewProxy, int i) {
        }

        public final void m7701a(ScrollingViewProxy scrollingViewProxy, int i, int i2, int i3) {
            int aZ_ = this.f7373a.au.aZ_();
            if (aZ_ != 0 && this.f7373a.au.f7344i == State.DEFAULT && (i + i2) + 5 >= aZ_) {
                InvitableContactsFragment.as(this.f7373a);
            }
        }
    }

    /* compiled from: page_actor_id */
    class C08006 implements Callable<ListenableFuture<ImmutableList<NodesModel>>> {
        final /* synthetic */ InvitableContactsFragment f7374a;

        C08006(InvitableContactsFragment invitableContactsFragment) {
            this.f7374a = invitableContactsFragment;
        }

        public Object call() {
            InvitableContactsFetcher invitableContactsFetcher = this.f7374a.f7383e;
            GraphQlQueryString invitableContactsQueryString = new InvitableContactsQueryString();
            invitableContactsQueryString.a("for_this_device", Boolean.valueOf(true)).a("first_devices", Integer.valueOf(1)).a("phone_id", invitableContactsFetcher.f7299d.a()).a("first_contacts", String.valueOf(200)).a("after", invitableContactsFetcher.f7296a.m7650a());
            GraphQLRequest a = GraphQLRequest.a(invitableContactsQueryString);
            a.a(GraphQLCachePolicy.a).a(600).b = true;
            return Futures.a(invitableContactsFetcher.f7297b.a(a), new C07911(invitableContactsFetcher), invitableContactsFetcher.f7298c);
        }
    }

    /* compiled from: page_actor_id */
    class C08017 extends AbstractDisposableFutureCallback<ImmutableList<NodesModel>> {
        final /* synthetic */ InvitableContactsFragment f7375a;

        C08017(InvitableContactsFragment invitableContactsFragment) {
            this.f7375a = invitableContactsFragment;
        }

        protected final void m7702a(Object obj) {
            ImmutableList immutableList = (ImmutableList) obj;
            this.f7375a.au.m7690a(State.DEFAULT);
            if (!immutableList.isEmpty()) {
                this.f7375a.f7380b.a(this.f7375a.aw.value, InvitableContactsFragment.ax(this.f7375a), immutableList.size(), InvitableContactsFragment.ay(this.f7375a), EventType.INVITES_PAGE_FETCHED);
                Builder builder = new Builder();
                int size = immutableList.size();
                for (int i = 0; i < size; i++) {
                    NodesModel nodesModel = (NodesModel) immutableList.get(i);
                    String k = nodesModel.m7645k();
                    if (!this.f7375a.f7386i.contains(k)) {
                        if (!StringUtil.a(new CharSequence[]{k, nodesModel.m7644j(), nodesModel.m7643a()})) {
                            InvitableContactsCandidate invitableContactsCandidate = new InvitableContactsCandidate(Long.parseLong(k), nodesModel.m7644j(), nodesModel.m7643a());
                            this.f7375a.f7386i.add(nodesModel.m7645k());
                            builder.c(invitableContactsCandidate);
                        }
                    }
                }
                InvitableContactsFragment.m7705a(this.f7375a, !this.f7375a.f7386i.isEmpty());
                InvitableContactsAdapter invitableContactsAdapter = this.f7375a.au;
                invitableContactsAdapter.f7336a.addAll(builder.b());
                invitableContactsAdapter.notifyDataSetChanged();
            } else if (this.f7375a.f7386i.isEmpty()) {
                InvitableContactsFragment.m7705a(this.f7375a, false);
            }
        }

        protected final void m7703a(Throwable th) {
            this.f7375a.au.m7690a(State.FAILURE);
            if (this.f7375a.f7386i.isEmpty()) {
                InvitableContactsFragment.m7705a(this.f7375a, false);
            }
            this.f7375a.f7380b.a(this.f7375a.aw.value, InvitableContactsFragment.ax(this.f7375a), this.f7375a.f7386i.size(), EventType.INVITES_FETCH_FAILED);
        }
    }

    /* compiled from: page_actor_id */
    public class C08028 implements OnClickListener {
        final /* synthetic */ InvitableContactsFragment f7376a;

        public C08028(InvitableContactsFragment invitableContactsFragment) {
            this.f7376a = invitableContactsFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 849569837);
            InvitableContactsFragment invitableContactsFragment = this.f7376a;
            new AlertDialog.Builder(invitableContactsFragment.getContext()).c(17301543).b(invitableContactsFragment.b(2131236384)).a(2131230735, new C08039(invitableContactsFragment)).b(2131230736, null).a(false).a().show();
            Logger.a(2, EntryType.UI_INPUT_END, -1700694231, a);
        }
    }

    /* compiled from: page_actor_id */
    public class C08039 implements DialogInterface.OnClickListener {
        final /* synthetic */ InvitableContactsFragment f7377a;

        public C08039(InvitableContactsFragment invitableContactsFragment) {
            this.f7377a = invitableContactsFragment;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            InvitableContactsFragment.aw(this.f7377a);
            dialogInterface.dismiss();
        }
    }

    public static void m7706a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((InvitableContactsFragment) obj).m7704a((Clock) SystemClockMethodAutoProvider.a(fbInjector), FriendFinderAnalyticsLogger.a(fbInjector), (InvitableContactsAdapterProvider) fbInjector.getOnDemandAssistedProviderForStaticDi(InvitableContactsAdapterProvider.class), (InvitableContactsControllerProvider) fbInjector.getOnDemandAssistedProviderForStaticDi(InvitableContactsControllerProvider.class), new InvitableContactsFetcher(GraphQLQueryExecutor.a(fbInjector), ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider.a(fbInjector), UniqueIdForDeviceHolderMethodAutoProvider.b(fbInjector)), GatekeeperStoreImplMethodAutoProvider.a(fbInjector), TasksManager.b(fbInjector));
    }

    public final void m7712c(@Nullable Bundle bundle) {
        super.c(bundle);
        Class cls = InvitableContactsFragment.class;
        m7706a((Object) this, getContext());
        a(new SmoothKeyboardFragmentBehavior());
        this.aw = this.s == null ? CIFlow.UNKNOWN : (CIFlow) this.s.getSerializable("ci_flow");
        this.aC = !this.f7384f.a(31, false);
        this.az = this.f7379a.a();
    }

    public final View m7710a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1459666899);
        View inflate = layoutInflater.inflate(2130904969, viewGroup, false);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1474514573, a);
        return inflate;
    }

    public final void m7711a(View view, @Nullable Bundle bundle) {
        super.a(view, bundle);
        this.as = e(2131563277);
        this.ay = new C07984(this);
        this.ao = (SearchEditText) e(2131563278);
        this.ao.addTextChangedListener(this.ay);
        this.at = e(2131563280);
        if (this.aC) {
            this.at.setOnClickListener(new C08028(this));
        }
        this.ar = e(16908292);
        this.ap = (TextView) e(2131562248);
        this.ap.setOnClickListener(this.al);
        this.aq = (LoadingIndicatorView) e(2131562249);
        if (this.au == null) {
            InjectorLike injectorLike = this.f7381c;
            this.au = new InvitableContactsAdapter((InvitableContactsListBinderProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(InvitableContactsListBinderProvider.class), GrowthUtils.m7382a(injectorLike), Locales.a(injectorLike), this.aw, getContext());
            this.au.f7345j = this.am;
            this.f7380b.a(this.aw.value, ax(this), EventType.INVITES_START_FETCHING);
            this.aq.a();
            at();
        } else {
            m7705a(this, !this.f7386i.isEmpty());
        }
        this.av = this.f7382d.m7697a(this.aw, this.au);
        this.an = (BetterRecyclerView) e(2131563279);
        this.an.setLayoutManager(new BetterLinearLayoutManager(view.getContext()));
        this.an.setAdapter(this.au);
        this.an.u = new C07973(this);
        this.ax = new RecyclerViewProxy(this.an);
        this.ax.a(new C07995(this));
    }

    public final void m7708G() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1885480437);
        super.G();
        this.aB = true;
        if (this.aD && this.au != null) {
            InvitableContactsAdapter invitableContactsAdapter = this.au;
            if (invitableContactsAdapter.f7343h && !invitableContactsAdapter.f7336a.isEmpty()) {
                invitableContactsAdapter.f7340e.m7385a();
                invitableContactsAdapter.f7343h = false;
            }
        }
        aq();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1532217495, a);
    }

    public final void m7709H() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1831328683);
        this.ao.c();
        this.aB = false;
        super.H();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 17211377, a);
    }

    public final void mY_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1524818317);
        this.f7385g.c();
        this.as = null;
        this.ao.removeTextChangedListener(this.ay);
        this.ao = null;
        this.an.u = null;
        this.an = null;
        this.ar = null;
        this.ap.setOnClickListener(null);
        this.ap = null;
        this.aq = null;
        this.ax.a(null);
        this.at.setOnClickListener(null);
        this.at = null;
        super.mY_();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1723798044, a);
    }

    public final void m7713g(boolean z) {
        super.g(z);
        if (z) {
            this.aD = true;
        }
        aq();
    }

    public static void m7705a(InvitableContactsFragment invitableContactsFragment, boolean z) {
        switch (invitableContactsFragment.au.f7344i) {
            case FAILURE:
                invitableContactsFragment.ar.setVisibility(0);
                invitableContactsFragment.ap.setVisibility(8);
                invitableContactsFragment.aq.a(invitableContactsFragment.b(2131230761), invitableContactsFragment.am);
                return;
            case DEFAULT:
                if (z) {
                    invitableContactsFragment.ar.setVisibility(8);
                    invitableContactsFragment.as.setVisibility(0);
                    if (invitableContactsFragment.aC) {
                        invitableContactsFragment.at.setVisibility(0);
                        return;
                    }
                    return;
                }
                invitableContactsFragment.ar.setVisibility(0);
                invitableContactsFragment.ap.setVisibility(0);
                invitableContactsFragment.aq.setVisibility(8);
                invitableContactsFragment.as.setVisibility(8);
                invitableContactsFragment.at.setVisibility(8);
                return;
            default:
                return;
        }
    }

    public static void m7707e(InvitableContactsFragment invitableContactsFragment) {
        invitableContactsFragment.au.m7690a(State.DEFAULT);
        invitableContactsFragment.ap.setVisibility(8);
        invitableContactsFragment.aq.setVisibility(0);
        invitableContactsFragment.aq.a();
        as(invitableContactsFragment);
    }

    private void aq() {
        if (D() && this.aB) {
            HasTitleBar hasTitleBar = (HasTitleBar) a(HasTitleBar.class);
            if (hasTitleBar != null) {
                hasTitleBar.a_(b(2131236389));
                hasTitleBar.c(true);
                hasTitleBar.a(null);
            }
        }
    }

    public static void as(InvitableContactsFragment invitableContactsFragment) {
        if (!invitableContactsFragment.f7385g.a() && invitableContactsFragment.f7383e.f7296a.m7652j()) {
            invitableContactsFragment.at();
        }
    }

    private void at() {
        this.aA = this.f7379a.a();
        this.au.m7690a(State.LOADING_MORE);
        this.f7385g.a("fetch_invitable_contacts", new C08006(this), new C08017(this));
    }

    private void m7704a(Clock clock, FriendFinderAnalyticsLogger friendFinderAnalyticsLogger, InvitableContactsAdapterProvider invitableContactsAdapterProvider, InvitableContactsControllerProvider invitableContactsControllerProvider, InvitableContactsFetcher invitableContactsFetcher, GatekeeperStoreImpl gatekeeperStoreImpl, TasksManager tasksManager) {
        this.f7379a = clock;
        this.f7380b = friendFinderAnalyticsLogger;
        this.f7381c = invitableContactsAdapterProvider;
        this.f7382d = invitableContactsControllerProvider;
        this.f7383e = invitableContactsFetcher;
        this.f7384f = gatekeeperStoreImpl;
        this.f7385g = tasksManager;
    }

    public static void aw(InvitableContactsFragment invitableContactsFragment) {
        InvitableContactsController invitableContactsController = invitableContactsFragment.av;
        CallerContext callerContext = f7378h;
        ImmutableList copyOf = ImmutableList.copyOf(invitableContactsFragment.au.f7336a);
        SendInviteClient a = invitableContactsController.f7361c.m7395a(invitableContactsFragment.aw);
        List arrayList = new ArrayList(copyOf.size());
        int size = copyOf.size();
        for (int i = 0; i < size; i++) {
            arrayList.add(((InvitableContactsCandidate) copyOf.get(i)).f7350c);
        }
        a.m7394a(arrayList, true, false, callerContext);
        invitableContactsFragment.au.m7691f();
        invitableContactsFragment.f7380b.a(invitableContactsFragment.aw.value, invitableContactsFragment.f7386i.size(), ApiType.INVITABLE_CONTACTS_API);
    }

    public static long ax(InvitableContactsFragment invitableContactsFragment) {
        return invitableContactsFragment.f7379a.a() - invitableContactsFragment.az;
    }

    public static long ay(InvitableContactsFragment invitableContactsFragment) {
        return invitableContactsFragment.f7379a.a() - invitableContactsFragment.aA;
    }
}
