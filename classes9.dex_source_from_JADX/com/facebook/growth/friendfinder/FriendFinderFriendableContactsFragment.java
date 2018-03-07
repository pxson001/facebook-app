package com.facebook.growth.friendfinder;

import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import com.facebook.api.growth.contactimporter.PhonebookLookupResultContact;
import com.facebook.base.fragment.FbFragment;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.executors.ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.common.identifiers.SafeUUIDGenerator;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.common.uri.FbUriIntentHandler;
import com.facebook.device_id.UniqueIdForDeviceHolderMethodAutoProvider;
import com.facebook.fbservice.ops.DefaultBlueServiceOperationFactory;
import com.facebook.fbservice.ops.ErrorPropagation;
import com.facebook.fbservice.ops.OperationResultFutureCallback;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.fbservice.service.ServiceException;
import com.facebook.friends.constants.FriendRequestMakeRef;
import com.facebook.graphql.executor.GraphQLCachePolicy;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.graphql.querybuilder.common.GraphQlQueryDefaults;
import com.facebook.graphql.util.GraphQLImageHelper;
import com.facebook.growth.friendfinder.FriendFinderAddFriendsAdapter.State;
import com.facebook.growth.friendfinder.fetcher.FriendFinderFriendableContactsFetcher;
import com.facebook.growth.friendfinder.fetcher.FriendFinderFriendableContactsFetcher.C07901;
import com.facebook.growth.friendfinder.graphql.FetchFriendableContactsQueryGraphQL.FetchFriendableContactsQueryString;
import com.facebook.growth.friendfinder.graphql.FetchFriendableContactsQueryGraphQLModels.FetchFriendableContactsQueryModel.AddressbooksModel.EdgesModel.NodeModel.FriendableContactsModel.NodesModel;
import com.facebook.growth.friendfinder.graphql.FetchFriendableContactsQueryGraphQLModels.FetchFriendableContactsQueryModel.AddressbooksModel.EdgesModel.NodeModel.FriendableContactsModel.NodesModel.MutualFriendsModel;
import com.facebook.growth.friendfinder.graphql.FetchFriendableContactsQueryGraphQLModels.FetchFriendableContactsQueryModel.AddressbooksModel.EdgesModel.NodeModel.FriendableContactsModel.NodesModel.ProfilePictureModel;
import com.facebook.growth.logging.FriendFinderAnalyticsLogger;
import com.facebook.growth.logging.FriendFinderAnalyticsLogger.ApiType;
import com.facebook.growth.logging.FriendFinderAnalyticsLogger.EventType;
import com.facebook.growth.protocol.FriendFinderPYMKMethod.Params;
import com.facebook.growth.protocol.FriendFinderPYMKMethod.Result;
import com.facebook.inject.FbInjector;
import com.facebook.ipc.katana.findfriends.CIFlow;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.timeline.intent.ModelBundle;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.tools.dextr.runtime.detour.BlueServiceOperationFactoryDetour;
import com.facebook.ui.futures.TasksManager;
import com.facebook.ui.keyboard.SmoothKeyboardFragmentBehavior;
import com.facebook.ui.search.SearchEditText;
import com.facebook.widget.listview.BetterListView;
import com.facebook.widget.listview.BetterListView.OnTouchDownListener;
import com.facebook.widget.listview.ListViewProxy;
import com.facebook.widget.listview.ScrollingViewProxy;
import com.facebook.widget.listview.ScrollingViewProxy.OnItemClickListener;
import com.facebook.widget.listview.ScrollingViewProxy.OnScrollListener;
import com.facebook.widget.loadingindicator.LoadingIndicator.RetryClickedListener;
import com.facebook.widget.loadingindicator.LoadingIndicatorView;
import com.facebook.widget.titlebar.HasTitleBar;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.Lists;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: pay_button_name */
public class FriendFinderFriendableContactsFragment extends FbFragment {
    private static final Class<?> f7214h;
    private static final CallerContext f7215i;
    @Inject
    DefaultBlueServiceOperationFactory f7216a;
    public boolean aA = false;
    public boolean aB = false;
    public int aC = 0;
    private long aD = 0;
    private long aE = 0;
    public final Set<String> al = new LinkedHashSet();
    private final String am = SafeUUIDGenerator.a().toString();
    private final OnClickListener an = new C07701(this);
    private final RetryClickedListener ao = new C07712(this);
    public View ap;
    public SearchEditText aq;
    public TextView ar;
    public LoadingIndicatorView as;
    public FriendFinderAddFriendsAdapter at;
    public int au;
    public CIFlow av;
    public ScrollingViewProxy aw;
    private long ax;
    private boolean ay = false;
    private boolean az = false;
    @Inject
    Clock f7217b;
    @Inject
    public FbUriIntentHandler f7218c;
    @Inject
    FriendFinderAddFriendsAdapterProvider f7219d;
    @Inject
    FriendFinderAnalyticsLogger f7220e;
    @Inject
    FriendFinderFriendableContactsFetcher f7221f;
    @Inject
    TasksManager f7222g;

    /* compiled from: pay_button_name */
    class C07701 implements OnClickListener {
        final /* synthetic */ FriendFinderFriendableContactsFragment f7205a;

        C07701(FriendFinderFriendableContactsFragment friendFinderFriendableContactsFragment) {
            this.f7205a = friendFinderFriendableContactsFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -1481885895);
            FriendFinderFriendableContactsFragment.ar(this.f7205a);
            Logger.a(2, EntryType.UI_INPUT_END, 732386046, a);
        }
    }

    /* compiled from: pay_button_name */
    class C07712 implements RetryClickedListener {
        final /* synthetic */ FriendFinderFriendableContactsFragment f7206a;

        C07712(FriendFinderFriendableContactsFragment friendFinderFriendableContactsFragment) {
            this.f7206a = friendFinderFriendableContactsFragment;
        }

        public final void m7477a() {
            FriendFinderFriendableContactsFragment.ar(this.f7206a);
        }
    }

    /* compiled from: pay_button_name */
    class C07723 implements OnTouchDownListener {
        final /* synthetic */ FriendFinderFriendableContactsFragment f7207a;

        C07723(FriendFinderFriendableContactsFragment friendFinderFriendableContactsFragment) {
            this.f7207a = friendFinderFriendableContactsFragment;
        }

        public final void m7478a() {
            this.f7207a.aq.c();
        }
    }

    /* compiled from: pay_button_name */
    public class C07734 implements TextWatcher {
        final /* synthetic */ FriendFinderFriendableContactsFragment f7208a;

        public C07734(FriendFinderFriendableContactsFragment friendFinderFriendableContactsFragment) {
            this.f7208a = friendFinderFriendableContactsFragment;
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void afterTextChanged(Editable editable) {
            this.f7208a.at.getFilter().filter(editable);
        }
    }

    /* compiled from: pay_button_name */
    public class C07745 implements OnScrollListener {
        final /* synthetic */ FriendFinderFriendableContactsFragment f7209a;

        public C07745(FriendFinderFriendableContactsFragment friendFinderFriendableContactsFragment) {
            this.f7209a = friendFinderFriendableContactsFragment;
        }

        public final void m7479a(ScrollingViewProxy scrollingViewProxy, int i) {
        }

        public final void m7480a(ScrollingViewProxy scrollingViewProxy, int i, int i2, int i3) {
            int i4 = 1;
            if (!this.f7209a.at.isEmpty() && this.f7209a.at.f7162n == State.DEFAULT) {
                this.f7209a.aC = Math.max(this.f7209a.aC, (i + i2) - 1);
                if (this.f7209a.ap.getVisibility() == 8) {
                    this.f7209a.ap.setVisibility(0);
                }
                int size = this.f7209a.at.f7153e.size();
                int i5 = i + i2 <= size + 3 ? 1 : 0;
                if ((i + i2) + 5 < size || i5 == 0) {
                    i4 = 0;
                }
                if (i4 != 0) {
                    FriendFinderFriendableContactsFragment.at(this.f7209a);
                }
            }
        }
    }

    /* compiled from: pay_button_name */
    public class C07756 implements OnItemClickListener {
        final /* synthetic */ FriendFinderFriendableContactsFragment f7210a;

        public C07756(FriendFinderFriendableContactsFragment friendFinderFriendableContactsFragment) {
            this.f7210a = friendFinderFriendableContactsFragment;
        }

        public final void m7481a(int i) {
            FriendFinderFriendableContactsFragment friendFinderFriendableContactsFragment = this.f7210a;
            Object item = friendFinderFriendableContactsFragment.at.getItem(i);
            if (item instanceof FriendFinderFriendCandidate) {
                FriendFinderFriendCandidate friendFinderFriendCandidate = (FriendFinderFriendCandidate) item;
                String formatStrLocaleSafe = StringFormatUtil.formatStrLocaleSafe(FBLinks.aX, Long.valueOf(friendFinderFriendCandidate.m7467a()));
                Bundle bundle = new Bundle();
                bundle.putSerializable("timeline_friend_request_ref", FriendRequestMakeRef.CONTACT_IMPORTER);
                ModelBundle.a(bundle, String.valueOf(friendFinderFriendCandidate.m7467a()), friendFinderFriendCandidate.m7472d(), friendFinderFriendCandidate.m7469b(), null, null);
                friendFinderFriendableContactsFragment.f7218c.a(friendFinderFriendableContactsFragment.getContext(), formatStrLocaleSafe, bundle);
            }
        }
    }

    /* compiled from: pay_button_name */
    class C07767 implements Callable<ListenableFuture<ImmutableList<NodesModel>>> {
        final /* synthetic */ FriendFinderFriendableContactsFragment f7211a;

        C07767(FriendFinderFriendableContactsFragment friendFinderFriendableContactsFragment) {
            this.f7211a = friendFinderFriendableContactsFragment;
        }

        public Object call() {
            FriendFinderFriendableContactsFetcher friendFinderFriendableContactsFetcher = this.f7211a.f7221f;
            int i = this.f7211a.au;
            GraphQlQueryString fetchFriendableContactsQueryString = new FetchFriendableContactsQueryString();
            fetchFriendableContactsQueryString.a("for_this_device", Boolean.valueOf(true)).a("first_devices", Integer.valueOf(1)).a("phone_id", friendFinderFriendableContactsFetcher.f7294e.a()).a("first_contacts", String.valueOf(50)).a("size_param", String.valueOf(i)).a("after", friendFinderFriendableContactsFetcher.f7290a.m7591a()).a("media_type", friendFinderFriendableContactsFetcher.f7291b.b());
            GraphQLRequest a = GraphQLRequest.a(fetchFriendableContactsQueryString);
            a.a(GraphQLCachePolicy.c).b = true;
            return Futures.a(friendFinderFriendableContactsFetcher.f7292c.a(a), new C07901(friendFinderFriendableContactsFetcher), friendFinderFriendableContactsFetcher.f7293d);
        }
    }

    /* compiled from: pay_button_name */
    class C07778 extends AbstractDisposableFutureCallback<ImmutableList<NodesModel>> {
        final /* synthetic */ FriendFinderFriendableContactsFragment f7212a;

        C07778(FriendFinderFriendableContactsFragment friendFinderFriendableContactsFragment) {
            this.f7212a = friendFinderFriendableContactsFragment;
        }

        protected final void m7482a(Object obj) {
            ImmutableList immutableList = (ImmutableList) obj;
            this.f7212a.at.m7431a(State.DEFAULT);
            if (!this.f7212a.aB) {
                this.f7212a.aB = true;
                this.f7212a.f7220e.a(this.f7212a.av.value, FriendFinderFriendableContactsFragment.ax(this.f7212a), immutableList.size(), FriendFinderFriendableContactsFragment.az(this.f7212a));
            }
            if (immutableList.isEmpty()) {
                FriendFinderFriendableContactsFragment.aw(this.f7212a);
                return;
            }
            this.f7212a.f7220e.a(this.f7212a.av.value, FriendFinderFriendableContactsFragment.ax(this.f7212a), immutableList.size(), FriendFinderFriendableContactsFragment.az(this.f7212a), EventType.FRIENDABLE_CONTACTS_PAGE_FETCHED);
            Builder builder = new Builder();
            int size = immutableList.size();
            for (int i = 0; i < size; i++) {
                NodesModel nodesModel = (NodesModel) immutableList.get(i);
                if (!this.f7212a.al.contains(nodesModel.m7582j())) {
                    String a;
                    int a2;
                    long parseLong = Long.parseLong(nodesModel.m7582j());
                    ProfilePictureModel m = nodesModel.m7585m();
                    MutualFriendsModel k = nodesModel.m7583k();
                    FriendFinderFriendCandidate.Builder builder2 = new FriendFinderFriendCandidate.Builder();
                    builder2.f7193a = parseLong;
                    FriendFinderFriendCandidate.Builder builder3 = builder2;
                    if (m != null) {
                        a = m.m7575a();
                    } else {
                        a = null;
                    }
                    builder3.f7194b = a;
                    FriendFinderFriendCandidate.Builder builder4 = builder3;
                    builder4.f7195c = nodesModel.m7584l();
                    builder3 = builder4;
                    if (k != null) {
                        a2 = k.m7567a();
                    } else {
                        a2 = 0;
                    }
                    builder3.f7196d = a2;
                    builder4 = builder3;
                    builder4.f7197e = false;
                    FriendFinderFriendCandidate friendFinderFriendCandidate = new FriendFinderFriendCandidate(builder4);
                    this.f7212a.al.add(nodesModel.m7582j());
                    builder.c(friendFinderFriendCandidate);
                }
            }
            this.f7212a.at.m7432a(builder.b());
        }

        protected final void m7483a(Throwable th) {
            this.f7212a.at.m7431a(State.FAILURE);
            this.f7212a.f7220e.a(this.f7212a.av.value, FriendFinderFriendableContactsFragment.ax(this.f7212a), this.f7212a.al.size(), EventType.FRIENDABLE_CONTACTS_FETCH_FAILED);
            if (this.f7212a.al.isEmpty()) {
                FriendFinderFriendableContactsFragment.m7489e(this.f7212a);
            }
        }
    }

    /* compiled from: pay_button_name */
    class C07789 extends OperationResultFutureCallback {
        final /* synthetic */ FriendFinderFriendableContactsFragment f7213a;

        C07789(FriendFinderFriendableContactsFragment friendFinderFriendableContactsFragment) {
            this.f7213a = friendFinderFriendableContactsFragment;
        }

        protected final void m7485a(Object obj) {
            OperationResult operationResult = (OperationResult) obj;
            FriendFinderFriendableContactsFragment.m7487a(this.f7213a, operationResult == null ? null : (Result) operationResult.h());
            FriendFinderFriendableContactsFragment friendFinderFriendableContactsFragment = this.f7213a;
            friendFinderFriendableContactsFragment.ar.setVisibility(0);
            friendFinderFriendableContactsFragment.as.setVisibility(8);
        }

        protected final void m7484a(ServiceException serviceException) {
            FriendFinderAnalyticsLogger friendFinderAnalyticsLogger = this.f7213a.f7220e;
            String str = this.f7213a.av.value;
            long ax = FriendFinderFriendableContactsFragment.ax(this.f7213a);
            friendFinderAnalyticsLogger.a.a(FriendFinderAnalyticsLogger.b(EventType.PYMK_FETCH_FAILED.getEventName()).b("ci_flow", str).a("time_since_creation", ax).a("fetched_candidates_size", this.f7213a.al.size()));
            if (this.f7213a.al.isEmpty()) {
                FriendFinderFriendableContactsFragment.m7489e(this.f7213a);
            }
        }
    }

    public static void m7488a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((FriendFinderFriendableContactsFragment) obj).m7486a(DefaultBlueServiceOperationFactory.b(fbInjector), (Clock) SystemClockMethodAutoProvider.a(fbInjector), FbUriIntentHandler.a(fbInjector), (FriendFinderAddFriendsAdapterProvider) fbInjector.getOnDemandAssistedProviderForStaticDi(FriendFinderAddFriendsAdapterProvider.class), FriendFinderAnalyticsLogger.a(fbInjector), new FriendFinderFriendableContactsFetcher(GraphQLImageHelper.a(fbInjector), GraphQLQueryExecutor.a(fbInjector), ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider.a(fbInjector), UniqueIdForDeviceHolderMethodAutoProvider.b(fbInjector)), TasksManager.b(fbInjector));
    }

    private void m7486a(DefaultBlueServiceOperationFactory defaultBlueServiceOperationFactory, Clock clock, FbUriIntentHandler fbUriIntentHandler, FriendFinderAddFriendsAdapterProvider friendFinderAddFriendsAdapterProvider, FriendFinderAnalyticsLogger friendFinderAnalyticsLogger, FriendFinderFriendableContactsFetcher friendFinderFriendableContactsFetcher, TasksManager tasksManager) {
        this.f7216a = defaultBlueServiceOperationFactory;
        this.f7217b = clock;
        this.f7218c = fbUriIntentHandler;
        this.f7219d = friendFinderAddFriendsAdapterProvider;
        this.f7220e = friendFinderAnalyticsLogger;
        this.f7221f = friendFinderFriendableContactsFetcher;
        this.f7222g = tasksManager;
    }

    static {
        Class cls = FriendFinderFriendableContactsFragment.class;
        f7214h = cls;
        f7215i = CallerContext.a(cls, "friend_finder_add_friends_fragment");
    }

    public final void m7494c(@Nullable Bundle bundle) {
        boolean z;
        super.c(bundle);
        a(new SmoothKeyboardFragmentBehavior());
        Class cls = FriendFinderFriendableContactsFragment.class;
        m7488a((Object) this, getContext());
        this.au = GraphQlQueryDefaults.c();
        this.av = this.s == null ? CIFlow.UNKNOWN : (CIFlow) this.s.getSerializable("ci_flow");
        if (this.s == null || !this.s.getBoolean("go_to_profile_enabled")) {
            z = false;
        } else {
            z = true;
        }
        this.aA = z;
        this.ax = this.f7217b.a();
        this.f7220e.a.c(FriendFinderAnalyticsLogger.b(EventType.OPENED.getEventName()).b("api", ApiType.FRIENDABLE_CONTACTS_API.getApiName()).b("ci_flow", this.av.value));
    }

    public final View m7492a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1720806885);
        View inflate = layoutInflater.inflate(2130904470, viewGroup, false);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1515469022, a);
        return inflate;
    }

    public final void m7493a(View view, @Nullable Bundle bundle) {
        super.a(view, bundle);
        this.ap = e(2131562246);
        this.ar = (TextView) e(2131562248);
        this.ar.setOnClickListener(this.an);
        this.as = (LoadingIndicatorView) e(2131562249);
        this.aq = (SearchEditText) e(2131562247);
        this.aq.addTextChangedListener(new C07734(this));
        if (this.at == null) {
            this.at = this.f7219d.m7438a(getContext());
            this.at.f7163o = this.ao;
            this.f7220e.a(this.av.value, ax(this), EventType.FRIENDABLE_CONTACTS_START_FETCHING);
            this.as.a();
            au();
        }
        BetterListView betterListView = (BetterListView) e(16908298);
        betterListView.setEmptyView(e(16908292));
        betterListView.setAdapter(this.at);
        betterListView.setStickyHeaderEnabled(true);
        betterListView.y = new C07723(this);
        this.aw = new ListViewProxy(betterListView);
        this.aw.a(this.at);
        this.aw.a(new C07745(this));
        if (this.aA) {
            this.aw.a(new C07756(this));
        }
    }

    public final void m7490G() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1864765200);
        super.G();
        this.ay = true;
        as();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1882973256, a);
    }

    public final void m7491H() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 613075630);
        this.aq.c();
        this.ay = false;
        super.H();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1240686954, a);
    }

    public final void mj_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -674099157);
        if (!this.al.isEmpty() || this.aB) {
            this.f7220e.a(this.av.value, ax(this), this.al.size(), this.at.m7427a(this.aC));
        } else {
            FriendFinderAnalyticsLogger friendFinderAnalyticsLogger = this.f7220e;
            String str = this.av.value;
            friendFinderAnalyticsLogger.a.c(FriendFinderAnalyticsLogger.b(EventType.CANCELED.getEventName()).b("api", ApiType.FRIENDABLE_CONTACTS_API.getApiName()).b("ci_flow", str).a("time_since_creation", ax(this)));
        }
        super.mj_();
        LogUtils.f(376034663, a);
    }

    public final void mY_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1289135515);
        this.f7222g.c();
        this.at.m7429a();
        this.ap = null;
        this.aq = null;
        this.as = null;
        this.ar.setOnClickListener(null);
        this.ar = null;
        this.aw.a(null);
        super.mY_();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -2143089118, a);
    }

    public final void m7495g(boolean z) {
        super.g(z);
        as();
    }

    public static void m7489e(FriendFinderFriendableContactsFragment friendFinderFriendableContactsFragment) {
        friendFinderFriendableContactsFragment.ar.setVisibility(8);
        friendFinderFriendableContactsFragment.as.a(friendFinderFriendableContactsFragment.b(2131230761), friendFinderFriendableContactsFragment.ao);
        friendFinderFriendableContactsFragment.ap.setVisibility(8);
    }

    public static void ar(FriendFinderFriendableContactsFragment friendFinderFriendableContactsFragment) {
        friendFinderFriendableContactsFragment.at.m7431a(State.DEFAULT);
        friendFinderFriendableContactsFragment.ar.setVisibility(8);
        friendFinderFriendableContactsFragment.as.setVisibility(0);
        friendFinderFriendableContactsFragment.as.a();
        at(friendFinderFriendableContactsFragment);
    }

    private void as() {
        if (D() && this.ay) {
            HasTitleBar hasTitleBar = (HasTitleBar) a(HasTitleBar.class);
            if (hasTitleBar != null) {
                hasTitleBar.a_(b(2131236380));
                hasTitleBar.c(true);
                hasTitleBar.a(null);
            }
        }
    }

    public static void at(FriendFinderFriendableContactsFragment friendFinderFriendableContactsFragment) {
        if (!friendFinderFriendableContactsFragment.f7222g.a()) {
            if (friendFinderFriendableContactsFragment.f7221f.f7290a.m7593j()) {
                friendFinderFriendableContactsFragment.au();
            } else {
                aw(friendFinderFriendableContactsFragment);
            }
        }
    }

    private void au() {
        this.aE = this.f7217b.a();
        this.at.m7431a(State.LOADING_MORE);
        this.f7222g.a("fetch_friendable_contacts", new C07767(this), new C07778(this));
    }

    private void av() {
        Bundle bundle = new Bundle();
        bundle.putParcelable("growthFriendFinderPYMKParamsKey", new Params(this.au, this.am, this.av, Lists.a(this.al)));
        this.f7222g.a(null, BlueServiceOperationFactoryDetour.a(this.f7216a, "growth_friend_finder_pymk", bundle, ErrorPropagation.BY_EXCEPTION, f7215i, 1627450325).a(), new C07789(this));
    }

    public static void m7487a(FriendFinderFriendableContactsFragment friendFinderFriendableContactsFragment, Result result) {
        int size = friendFinderFriendableContactsFragment.al.size();
        if (result == null) {
            friendFinderFriendableContactsFragment.f7220e.a(friendFinderFriendableContactsFragment.av.value, ax(friendFinderFriendableContactsFragment), friendFinderFriendableContactsFragment.ay(), -1, size);
            return;
        }
        List<PhonebookLookupResultContact> a = result.m7817a();
        int size2 = a.size();
        friendFinderFriendableContactsFragment.f7220e.a(friendFinderFriendableContactsFragment.av.value, ax(friendFinderFriendableContactsFragment), friendFinderFriendableContactsFragment.ay(), size2, size);
        if (!a.isEmpty()) {
            List arrayList = new ArrayList(size2);
            for (PhonebookLookupResultContact phonebookLookupResultContact : a) {
                String l = Long.toString(phonebookLookupResultContact.userId);
                if (!friendFinderFriendableContactsFragment.al.contains(l)) {
                    arrayList.add(FriendFinderFriendCandidate.m7466b(phonebookLookupResultContact));
                    friendFinderFriendableContactsFragment.al.add(l);
                }
            }
            friendFinderFriendableContactsFragment.at.m7434b(arrayList);
        }
    }

    public static void aw(FriendFinderFriendableContactsFragment friendFinderFriendableContactsFragment) {
        if (!friendFinderFriendableContactsFragment.az) {
            friendFinderFriendableContactsFragment.aD = friendFinderFriendableContactsFragment.f7217b.a();
            FriendFinderAnalyticsLogger friendFinderAnalyticsLogger = friendFinderFriendableContactsFragment.f7220e;
            String str = friendFinderFriendableContactsFragment.av.value;
            long ax = ax(friendFinderFriendableContactsFragment);
            friendFinderAnalyticsLogger.a.a(FriendFinderAnalyticsLogger.b(EventType.PYMK_START_FETCHING.getEventName()).b("ci_flow", str).a("time_since_creation", ax).a("fetched_candidates_size", friendFinderFriendableContactsFragment.al.size()));
            friendFinderFriendableContactsFragment.av();
            friendFinderFriendableContactsFragment.az = true;
        }
    }

    public static long ax(FriendFinderFriendableContactsFragment friendFinderFriendableContactsFragment) {
        return friendFinderFriendableContactsFragment.f7217b.a() - friendFinderFriendableContactsFragment.ax;
    }

    private long ay() {
        return this.f7217b.a() - this.aD;
    }

    public static long az(FriendFinderFriendableContactsFragment friendFinderFriendableContactsFragment) {
        return friendFinderFriendableContactsFragment.f7217b.a() - friendFinderFriendableContactsFragment.aE;
    }
}
