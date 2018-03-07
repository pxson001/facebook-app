package com.facebook.offers.fragment;

import android.content.Context;
import android.graphics.Point;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.analytics.tagging.AnalyticsFragment;
import com.facebook.auth.annotations.LoggedInUserId;
import com.facebook.base.fragment.FbFragment;
import com.facebook.common.android.ActivityMethodAutoProvider;
import com.facebook.common.executors.AndroidThreadUtil;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.common.uri.UriIntentMapper;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.debug.log.BLog;
import com.facebook.fbui.popover.PopoverMenuWindow;
import com.facebook.fbui.popover.PopoverMenuWindow.OnMenuItemClickListener;
import com.facebook.graphql.executor.GraphQLCachePolicy;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.katana.urimap.Fb4aUriIntentMapper;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.offers.fetcher.OffersWalletFetcher;
import com.facebook.offers.graphql.OfferMutationsModels.OfferClaimEnableNotificationsMutationModel;
import com.facebook.offers.graphql.OfferMutationsModels.OfferClaimMarkAsUsedMutationModel;
import com.facebook.offers.graphql.OfferQueries.OffersWalletQueryString;
import com.facebook.offers.graphql.OfferQueriesInterfaces.OfferClaimData;
import com.facebook.offers.graphql.OfferQueriesModels.OffersWalletQueryModel;
import com.facebook.offers.graphql.OfferQueriesModels.OffersWalletQueryModel.ActorModel.ClaimedCouponsModel;
import com.facebook.offers.graphql.OfferQueriesModels.OffersWalletQueryModel.ActorModel.ClaimedOffersModel.EdgesModel;
import com.facebook.offers.logging.OffersEventUtil;
import com.facebook.offers.model.OfferOrCoupon;
import com.facebook.quicklog.QuickPerformanceLogger;
import com.facebook.quicklog.module.QuickPerformanceLoggerMethodAutoProvider;
import com.facebook.resources.ui.FbTextView;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.ui.toaster.ToastThreadUtil;
import com.facebook.widget.FbSwipeRefreshLayout;
import com.facebook.widget.recyclerview.BetterLinearLayoutManager;
import com.facebook.widget.recyclerview.BetterRecyclerView;
import com.facebook.widget.recyclerview.RecyclerViewAdapterWithHeadersAndFooters;
import com.facebook.widget.titlebar.HasTitleBar;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: current_url */
public class OffersWalletFragment extends FbFragment implements AnalyticsFragment {
    public static final ArrayList<View> f16306i = new ArrayList(0);
    @Inject
    public OffersWalletFetcher f16307a;
    public FbSwipeRefreshLayout al;
    private BetterRecyclerView am;
    public RecyclerViewAdapterWithHeadersAndFooters an;
    public View ao;
    public View ap;
    public int aq;
    public boolean ar = true;
    public BetterLinearLayoutManager as;
    private Set<String> at = new HashSet();
    public boolean au = false;
    @Inject
    DefaultAndroidThreadUtil f16308b;
    @Inject
    OffersWalletAdapter f16309c;
    @Inject
    AnalyticsLogger f16310d;
    @Inject
    OffersEventUtil f16311e;
    @Inject
    @LoggedInUserId
    public Provider<String> f16312f;
    @Inject
    ToastThreadUtil f16313g;
    @Inject
    QuickPerformanceLogger f16314h;

    /* compiled from: current_url */
    class C17612 implements OnRefreshListener {
        final /* synthetic */ OffersWalletFragment f16284a;

        C17612(OffersWalletFragment offersWalletFragment) {
            this.f16284a = offersWalletFragment;
        }

        public final void m19030a() {
            OffersWalletFragment.m19037b(this.f16284a, true);
        }
    }

    /* compiled from: current_url */
    class C17623 extends OnScrollListener {
        final /* synthetic */ OffersWalletFragment f16285a;
        private int f16286b;
        private int f16287c;

        C17623(OffersWalletFragment offersWalletFragment) {
            this.f16285a = offersWalletFragment;
        }

        public final void m19031a(RecyclerView recyclerView, int i) {
        }

        public final void m19032a(RecyclerView recyclerView, int i, int i2) {
            int l = this.f16285a.as.l();
            int n = this.f16285a.as.n();
            if (l != this.f16286b || n != this.f16287c) {
                OffersWalletFragment.m19035a(this.f16285a, l, n);
                this.f16286b = l;
                this.f16287c = n;
            }
        }
    }

    /* compiled from: current_url */
    public class C17664 {
        public final /* synthetic */ OffersWalletFragment f16292a;

        /* compiled from: current_url */
        public class C17651 implements FutureCallback<GraphQLResult<OfferClaimMarkAsUsedMutationModel>> {
            final /* synthetic */ OfferClaimData f16290a;
            final /* synthetic */ C17664 f16291b;

            /* compiled from: current_url */
            class C17631 implements Runnable {
                final /* synthetic */ C17651 f16288a;

                C17631(C17651 c17651) {
                    this.f16288a = c17651;
                }

                public void run() {
                    OffersWalletFragment.m19037b(this.f16288a.f16291b.f16292a, true);
                }
            }

            /* compiled from: current_url */
            class C17642 implements Runnable {
                final /* synthetic */ C17651 f16289a;

                C17642(C17651 c17651) {
                    this.f16289a = c17651;
                }

                public void run() {
                    this.f16289a.f16291b.f16292a.m19040a(false);
                }
            }

            public C17651(C17664 c17664, OfferClaimData offerClaimData) {
                this.f16291b = c17664;
                this.f16290a = offerClaimData;
            }

            public void onSuccess(@Nullable Object obj) {
                GraphQLResult graphQLResult = (GraphQLResult) obj;
                if (graphQLResult != null && graphQLResult.e != null && ((OfferClaimMarkAsUsedMutationModel) graphQLResult.e).m19058a() != null) {
                    this.f16291b.f16292a.f16308b.a(new C17631(this));
                    this.f16291b.f16292a.f16310d.a(this.f16291b.f16292a.f16311e.m19447a(this.f16290a.mo1007v() ? "mark_as_used" : "mark_as_unused", OfferOrCoupon.m19448a(this.f16290a), "permalink"));
                }
            }

            public void onFailure(Throwable th) {
                this.f16291b.f16292a.f16313g.a(this.f16291b.f16292a.getContext().getString(2131236841), 0);
                this.f16291b.f16292a.f16308b.a(new C17642(this));
            }
        }

        C17664(OffersWalletFragment offersWalletFragment) {
            this.f16292a = offersWalletFragment;
        }
    }

    /* compiled from: current_url */
    public class C17705 {
        final /* synthetic */ OffersWalletFragment f16297a;

        C17705(OffersWalletFragment offersWalletFragment) {
            this.f16297a = offersWalletFragment;
        }

        public final void m19033a(final OfferClaimData offerClaimData) {
            ListenableFuture b = this.f16297a.f16307a.m18996b(offerClaimData.mo1003g(), offerClaimData, this.f16297a.aq, !offerClaimData.mo1008w(), (String) this.f16297a.f16312f.get());
            this.f16297a.m19040a(true);
            Futures.a(b, new FutureCallback<GraphQLResult<OfferClaimEnableNotificationsMutationModel>>(this) {
                final /* synthetic */ C17705 f16296b;

                /* compiled from: current_url */
                class C17671 implements Runnable {
                    final /* synthetic */ C17691 f16293a;

                    C17671(C17691 c17691) {
                        this.f16293a = c17691;
                    }

                    public void run() {
                        OffersWalletFragment.m19037b(this.f16293a.f16296b.f16297a, true);
                    }
                }

                /* compiled from: current_url */
                class C17682 implements Runnable {
                    final /* synthetic */ C17691 f16294a;

                    C17682(C17691 c17691) {
                        this.f16294a = c17691;
                    }

                    public void run() {
                        this.f16294a.f16296b.f16297a.m19040a(false);
                    }
                }

                public void onSuccess(@Nullable Object obj) {
                    GraphQLResult graphQLResult = (GraphQLResult) obj;
                    if (graphQLResult != null && graphQLResult.e != null && ((OfferClaimEnableNotificationsMutationModel) graphQLResult.e).m19053a() != null) {
                        this.f16296b.f16297a.f16308b.a(new C17671(this));
                        this.f16296b.f16297a.f16310d.a(this.f16296b.f16297a.f16311e.m19447a(offerClaimData.mo1008w() ? "notifications_enabled" : "notifications_disabled", OfferOrCoupon.m19448a(offerClaimData), "permalink"));
                    }
                }

                public void onFailure(Throwable th) {
                    this.f16296b.f16297a.f16313g.a(this.f16296b.f16297a.getContext().getString(2131236844), 0);
                    this.f16296b.f16297a.f16308b.a(new C17682(this));
                }
            });
        }
    }

    /* compiled from: current_url */
    class C17766 implements FutureCallback<GraphQLResult<OffersWalletQueryModel>> {
        final /* synthetic */ OffersWalletFragment f16303a;

        /* compiled from: current_url */
        class C17711 implements Comparator<OfferOrCoupon> {
            final /* synthetic */ C17766 f16298a;

            C17711(C17766 c17766) {
                this.f16298a = c17766;
            }

            public int compare(Object obj, Object obj2) {
                OfferOrCoupon offerOrCoupon = (OfferOrCoupon) obj;
                OfferOrCoupon offerOrCoupon2 = (OfferOrCoupon) obj2;
                if (this.f16298a.f16303a.ar) {
                    return Long.compare(offerOrCoupon.m19459h(), offerOrCoupon2.m19459h());
                }
                return Long.compare(offerOrCoupon2.m19459h(), offerOrCoupon.m19459h());
            }
        }

        /* compiled from: current_url */
        class C17722 implements Runnable {
            final /* synthetic */ C17766 f16299a;

            C17722(C17766 c17766) {
                this.f16299a = c17766;
            }

            public void run() {
                OffersWalletFragment offersWalletFragment = this.f16299a.f16303a;
                ArrayList arrayList = new ArrayList(1);
                arrayList.add(offersWalletFragment.ao);
                offersWalletFragment.an.b(arrayList);
            }
        }

        /* compiled from: current_url */
        class C17733 implements Runnable {
            final /* synthetic */ C17766 f16300a;

            C17733(C17766 c17766) {
                this.f16300a = c17766;
            }

            public void run() {
                this.f16300a.f16303a.an.notifyDataSetChanged();
                this.f16300a.f16303a.m19040a(false);
                this.f16300a.f16303a.f16314h.b(9109505, (short) 2);
            }
        }

        /* compiled from: current_url */
        class C17744 implements Runnable {
            final /* synthetic */ C17766 f16301a;

            C17744(C17766 c17766) {
                this.f16301a = c17766;
            }

            public void run() {
                OffersWalletFragment.m19035a(this.f16301a.f16303a, this.f16301a.f16303a.as.l(), this.f16301a.f16303a.as.n());
            }
        }

        /* compiled from: current_url */
        class C17755 implements Runnable {
            final /* synthetic */ C17766 f16302a;

            C17755(C17766 c17766) {
                this.f16302a = c17766;
            }

            public void run() {
                OffersWalletFragment offersWalletFragment = this.f16302a.f16303a;
                ArrayList arrayList = new ArrayList(1);
                arrayList.add(offersWalletFragment.ap);
                if (1 != 0) {
                    offersWalletFragment.an.a(arrayList);
                } else {
                    offersWalletFragment.an.b(arrayList);
                }
                this.f16302a.f16303a.an.notifyDataSetChanged();
                this.f16302a.f16303a.m19040a(false);
                this.f16302a.f16303a.f16314h.b(9109505, (short) 97);
            }
        }

        C17766(OffersWalletFragment offersWalletFragment) {
            this.f16303a = offersWalletFragment;
        }

        public void onSuccess(Object obj) {
            GraphQLResult graphQLResult = (GraphQLResult) obj;
            int i = 0;
            if (!(graphQLResult == null || graphQLResult.e == null || ((OffersWalletQueryModel) graphQLResult.e).m19343a() == null)) {
                int i2;
                ImmutableList a;
                List arrayList;
                int i3;
                String str;
                List arrayList2 = new ArrayList();
                if (((OffersWalletQueryModel) graphQLResult.e).m19343a().m19338k() == null || ((OffersWalletQueryModel) graphQLResult.e).m19343a().m19338k().m19327a() == null) {
                    i2 = 0;
                } else {
                    i2 = ((OffersWalletQueryModel) graphQLResult.e).m19343a().m19338k().m19327a().size();
                    a = ((OffersWalletQueryModel) graphQLResult.e).m19343a().m19338k().m19327a();
                    arrayList = new ArrayList(a.size());
                    for (i3 = 0; i3 < a.size(); i3++) {
                        arrayList.add(OfferOrCoupon.m19448a(((EdgesModel) a.get(i3)).m19315a()));
                    }
                    arrayList2.addAll(arrayList);
                }
                if (!(((OffersWalletQueryModel) graphQLResult.e).m19343a().m19337j() == null || ((OffersWalletQueryModel) graphQLResult.e).m19343a().m19337j().m19309a() == null)) {
                    i = ((OffersWalletQueryModel) graphQLResult.e).m19343a().m19337j().m19309a().size();
                    a = ((OffersWalletQueryModel) graphQLResult.e).m19343a().m19337j().m19309a();
                    arrayList = new ArrayList(a.size());
                    for (i3 = 0; i3 < a.size(); i3++) {
                        arrayList.add(new OfferOrCoupon(null, ((ClaimedCouponsModel.EdgesModel) a.get(i3)).m19297a()));
                    }
                    arrayList2.addAll(arrayList);
                }
                Collections.sort(arrayList2, new C17711(this));
                this.f16303a.f16309c.f16274b = arrayList2;
                new StringBuilder("Results: ").append(arrayList2.size());
                if (arrayList2.isEmpty()) {
                    this.f16303a.f16308b.a(new C17722(this));
                }
                AnalyticsLogger analyticsLogger = this.f16303a.f16310d;
                OffersEventUtil offersEventUtil = this.f16303a.f16311e;
                if (this.f16303a.ar) {
                    str = "viewed_wallet_active";
                } else {
                    str = "viewed_wallet_inactive";
                }
                HoneyClientEvent honeyClientEvent = new HoneyClientEvent(str);
                honeyClientEvent.c = "offers";
                honeyClientEvent.b("user_fbid", (String) offersEventUtil.f16521b.get());
                honeyClientEvent.a("coupons_shown", i);
                honeyClientEvent.a("offers_shown", i2);
                honeyClientEvent.a("total_shown", i + i2);
                analyticsLogger.a(honeyClientEvent);
            }
            this.f16303a.f16308b.a(new C17733(this));
            this.f16303a.f16308b.a(new C17744(this));
        }

        public void onFailure(Throwable th) {
            BLog.b("OffersWalletFragment", "Error loading offers", th);
            this.f16303a.f16308b.a(new C17755(this));
        }
    }

    public static void m19036a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((OffersWalletFragment) obj).m19034a(OffersWalletFetcher.m18991a(injectorLike), DefaultAndroidThreadUtil.b(injectorLike), new OffersWalletAdapter(ActivityMethodAutoProvider.b(injectorLike), (UriIntentMapper) Fb4aUriIntentMapper.a(injectorLike), (SecureContextHelper) DefaultSecureContextHelper.a(injectorLike), OfferRenderingUtils.m19015a(injectorLike)), AnalyticsLoggerMethodAutoProvider.a(injectorLike), OffersEventUtil.m19445b(injectorLike), IdBasedProvider.a(injectorLike, 4442), ToastThreadUtil.b(injectorLike), QuickPerformanceLoggerMethodAutoProvider.a(injectorLike));
    }

    private void m19034a(OffersWalletFetcher offersWalletFetcher, AndroidThreadUtil androidThreadUtil, OffersWalletAdapter offersWalletAdapter, AnalyticsLogger analyticsLogger, OffersEventUtil offersEventUtil, Provider<String> provider, ToastThreadUtil toastThreadUtil, QuickPerformanceLogger quickPerformanceLogger) {
        this.f16307a = offersWalletFetcher;
        this.f16308b = androidThreadUtil;
        this.f16309c = offersWalletAdapter;
        this.f16310d = analyticsLogger;
        this.f16311e = offersEventUtil;
        this.f16312f = provider;
        this.f16313g = toastThreadUtil;
        this.f16314h = quickPerformanceLogger;
    }

    public final void m19041c(Bundle bundle) {
        Class cls = OffersWalletFragment.class;
        m19036a(this, getContext());
        this.f16314h.b(9109505);
        super.c(bundle);
        this.an = new RecyclerViewAdapterWithHeadersAndFooters(this.f16309c);
        Display defaultDisplay = o().getWindowManager().getDefaultDisplay();
        Point point = new Point();
        defaultDisplay.getSize(point);
        this.aq = point.x;
    }

    public final View m19039a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1833122332);
        View inflate = layoutInflater.inflate(2130905531, viewGroup, false);
        final FbTextView fbTextView = (FbTextView) inflate.findViewById(2131564364);
        fbTextView.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ OffersWalletFragment f16283b;

            /* compiled from: current_url */
            class C17591 implements OnMenuItemClickListener {
                final /* synthetic */ C17601 f16281a;

                C17591(C17601 c17601) {
                    this.f16281a = c17601;
                }

                public final boolean m19029a(MenuItem menuItem) {
                    boolean z;
                    int itemId = menuItem.getItemId();
                    boolean z2 = this.f16281a.f16283b.ar;
                    if (itemId == 2131568654) {
                        fbTextView.setText(2131236795);
                        z = true;
                    } else {
                        this.f16281a.f16283b.f16309c.f16274b = Collections.emptyList();
                        fbTextView.setText(2131236796);
                        z = false;
                    }
                    if (this.f16281a.f16283b.ar != z) {
                        this.f16281a.f16283b.f16309c.f16274b = Collections.emptyList();
                        this.f16281a.f16283b.ar = z;
                    }
                    OffersWalletFragment.m19037b(this.f16281a.f16283b, this.f16281a.f16283b.au);
                    this.f16281a.f16283b.au = false;
                    return true;
                }
            }

            public void onClick(View view) {
                boolean z = true;
                int a = Logger.a(2, EntryType.UI_INPUT_START, 1899481015);
                PopoverMenuWindow popoverMenuWindow = new PopoverMenuWindow(view.getContext());
                popoverMenuWindow.b(2131820570);
                popoverMenuWindow.c().getItem(0).setChecked(this.f16283b.ar);
                MenuItem item = popoverMenuWindow.c().getItem(1);
                if (this.f16283b.ar) {
                    z = false;
                }
                item.setChecked(z);
                popoverMenuWindow.p = new C17591(this);
                popoverMenuWindow.c(view);
                popoverMenuWindow.d();
                LogUtils.a(-228083541, a);
            }
        });
        this.al = (FbSwipeRefreshLayout) inflate.findViewById(2131564365);
        this.al.e = new C17612(this);
        this.am = (BetterRecyclerView) inflate.findViewById(2131564366);
        this.am.v = true;
        this.as = new BetterLinearLayoutManager(getContext());
        this.am.setLayoutManager(this.as);
        this.am.setAdapter(this.an);
        HasTitleBar hasTitleBar = (HasTitleBar) a(HasTitleBar.class);
        if (hasTitleBar != null) {
            hasTitleBar.y_(2131236794);
            hasTitleBar.c(true);
        }
        this.ao = layoutInflater.inflate(2130905530, viewGroup, false);
        this.ap = layoutInflater.inflate(2130905529, viewGroup, false);
        this.am.setOnScrollListener(new C17623(this));
        this.f16309c.f16279g = new C17664(this);
        this.f16309c.f16280h = new C17705(this);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -81372966, a);
        return inflate;
    }

    public static void m19035a(OffersWalletFragment offersWalletFragment, int i, int i2) {
        while (i <= i2) {
            if (offersWalletFragment.f16309c.f16274b != null && !offersWalletFragment.f16309c.f16274b.isEmpty() && i >= 0 && i < offersWalletFragment.f16309c.f16274b.size()) {
                OfferOrCoupon offerOrCoupon = (OfferOrCoupon) offersWalletFragment.f16309c.getItem(i);
                if (!offersWalletFragment.at.contains(offerOrCoupon.m19462k())) {
                    String str = "viewed_offer";
                    if (offerOrCoupon.m19471v()) {
                        str = "viewed_coupon";
                    }
                    offersWalletFragment.f16310d.a(offersWalletFragment.f16311e.m19447a(str, offerOrCoupon, "wallet"));
                    offersWalletFragment.at.add(offerOrCoupon.m19462k());
                }
            }
            i++;
        }
    }

    public final void m19038G() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1688764588);
        super.G();
        m19037b(this, false);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -692771659, a);
    }

    public static void m19037b(OffersWalletFragment offersWalletFragment, boolean z) {
        GraphQLCachePolicy graphQLCachePolicy;
        if (1 != null) {
            offersWalletFragment.an.a(f16306i);
        } else {
            offersWalletFragment.an.b(f16306i);
        }
        offersWalletFragment.an.b(f16306i);
        OffersWalletFetcher offersWalletFetcher = offersWalletFragment.f16307a;
        int i = offersWalletFragment.aq;
        boolean z2 = offersWalletFragment.ar;
        GraphQLCachePolicy graphQLCachePolicy2 = GraphQLCachePolicy.a;
        if (z) {
            graphQLCachePolicy = GraphQLCachePolicy.d;
        } else {
            graphQLCachePolicy = graphQLCachePolicy2;
        }
        Futures.a(offersWalletFetcher.f16186a.a(GraphQLRequest.a((OffersWalletQueryString) new OffersWalletQueryString().a("count", Integer.valueOf(30)).a("active", Boolean.valueOf(z2)).a("profile_pic_width", Integer.valueOf(Math.max(100, i / 4))).a("creative_img_size", Integer.valueOf(i))).a(graphQLCachePolicy).a(600)), new C17766(offersWalletFragment));
        offersWalletFragment.m19040a(true);
    }

    public final void m19040a(final boolean z) {
        this.al.post(new Runnable(this) {
            final /* synthetic */ OffersWalletFragment f16305b;

            public void run() {
                this.f16305b.al.setRefreshing(z);
            }
        });
    }

    public final String am_() {
        return "offers_wallet";
    }
}
