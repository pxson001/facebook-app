package com.facebook.offers.fragment;

import android.content.Context;
import android.graphics.Point;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.UiThread;
import android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.analytics.tagging.AnalyticsFragment;
import com.facebook.auth.annotations.LoggedInUserId;
import com.facebook.base.fragment.FbFragment;
import com.facebook.browser.lite.products.offers.OfferBrowserUtils;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.executors.AndroidThreadUtil;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.util.StringUtil;
import com.facebook.debug.log.BLog;
import com.facebook.drawee.drawable.ScalingUtils.ScaleType;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.fbui.glyph.GlyphColorizer;
import com.facebook.graphql.executor.GraphQLCachePolicy;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.offers.fetcher.OffersWalletFetcher;
import com.facebook.offers.fragment.OfferRenderingUtils.C17573;
import com.facebook.offers.graphql.OfferMutationsModels.OfferClaimMarkAsUsedMutationModel;
import com.facebook.offers.graphql.OfferMutationsModels.OfferClaimToWalletMutationModel;
import com.facebook.offers.graphql.OfferMutationsModels.OfferViewClaimToWalletMutationModel;
import com.facebook.offers.graphql.OfferMutationsModels.OfferViewRemoveFromWalletMutationModel;
import com.facebook.offers.graphql.OfferQueries.OfferDetailQueryString;
import com.facebook.offers.graphql.OfferQueriesInterfaces.OfferClaimData;
import com.facebook.offers.graphql.OfferQueriesModels.CouponDataModel;
import com.facebook.offers.graphql.OfferQueriesModels.OfferClaimDataModel;
import com.facebook.offers.graphql.OfferQueriesModels.OfferDetailQueryModel;
import com.facebook.offers.logging.OffersEventUtil;
import com.facebook.offers.model.OfferOrCoupon;
import com.facebook.offers.views.OfferExpirationTimerView;
import com.facebook.quicklog.QuickPerformanceLogger;
import com.facebook.quicklog.module.QuickPerformanceLoggerMethodAutoProvider;
import com.facebook.resources.ui.FbTextView;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.ui.toaster.ToastThreadUtil;
import com.facebook.video.analytics.VideoAnalytics.EventTriggerType;
import com.facebook.video.player.RichVideoPlayer;
import com.facebook.widget.FbSwipeRefreshLayout;
import com.facebook.widget.recyclerview.BetterLinearLayoutManager;
import com.facebook.widget.recyclerview.BetterRecyclerView;
import com.facebook.widget.titlebar.HasTitleBar;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: custom_cta_change_cta_type_mobile */
public class OfferDetailPageFragment extends FbFragment implements AnalyticsFragment {
    private static final CallerContext al = CallerContext.a(OfferDetailPageFragment.class);
    @Inject
    OffersWalletFetcher f16228a;
    private View aA;
    private ViewGroup aB;
    private FbTextView aC;
    private FbTextView aD;
    private FbTextView aE;
    private ViewGroup aF;
    private FbTextView aG;
    public FbTextView aH;
    private ViewGroup aI;
    private FbTextView aJ;
    private OfferExpirationTimerView aK;
    private FbTextView aL;
    private FbTextView aM;
    private FbTextView aN;
    private View aO;
    public View aP;
    public String aQ = null;
    public boolean aR = true;
    public String aS = null;
    public String aT = null;
    public String aU = null;
    public String aV = null;
    public int aW;
    public boolean aX = false;
    public OfferOrCoupon aY;
    public boolean aZ = true;
    public FbSwipeRefreshLayout am;
    private View an;
    private FbDraweeView ao;
    private BetterRecyclerView ap;
    private OfferDetailHeaderCarouselAdapter aq;
    private RichVideoPlayer ar;
    private LinearLayout as;
    private FbTextView at;
    private FbTextView au;
    private LinearLayout av;
    private FbTextView aw;
    private FbTextView ax;
    public GenericDraweeHierarchy ay;
    private ViewGroup az;
    @Inject
    public DefaultAndroidThreadUtil f16229b;
    public String ba = null;
    private boolean bb = false;
    @Inject
    GlyphColorizer f16230c;
    @Inject
    ToastThreadUtil f16231d;
    @Inject
    OfferRenderingUtils f16232e;
    @Inject
    @LoggedInUserId
    Provider<String> f16233f;
    @Inject
    public AnalyticsLogger f16234g;
    @Inject
    public OffersEventUtil f16235h;
    @Inject
    QuickPerformanceLogger f16236i;

    /* compiled from: custom_cta_change_cta_type_mobile */
    class C17341 implements OnRefreshListener {
        final /* synthetic */ OfferDetailPageFragment f16196a;

        C17341(OfferDetailPageFragment offerDetailPageFragment) {
            this.f16196a = offerDetailPageFragment;
        }

        public final void m19000a() {
            OfferDetailPageFragment.m19005a(this.f16196a, true, true);
        }
    }

    /* compiled from: custom_cta_change_cta_type_mobile */
    class C17382 implements OnClickListener {
        final /* synthetic */ OfferDetailPageFragment f16200a;

        /* compiled from: custom_cta_change_cta_type_mobile */
        class C17371 implements FutureCallback<GraphQLResult<OfferViewRemoveFromWalletMutationModel>> {
            final /* synthetic */ C17382 f16199a;

            /* compiled from: custom_cta_change_cta_type_mobile */
            class C17351 implements Runnable {
                final /* synthetic */ C17371 f16197a;

                C17351(C17371 c17371) {
                    this.f16197a = c17371;
                }

                public void run() {
                    OfferDetailPageFragment.m19008e(this.f16197a.f16199a.f16200a);
                }
            }

            /* compiled from: custom_cta_change_cta_type_mobile */
            class C17362 implements Runnable {
                final /* synthetic */ C17371 f16198a;

                C17362(C17371 c17371) {
                    this.f16198a = c17371;
                }

                public void run() {
                    this.f16198a.f16199a.f16200a.f16231d.a(this.f16198a.f16199a.f16200a.b(2131236840));
                    OfferDetailPageFragment.m19008e(this.f16198a.f16199a.f16200a);
                }
            }

            C17371(C17382 c17382) {
                this.f16199a = c17382;
            }

            public void onSuccess(@Nullable Object obj) {
                this.f16199a.f16200a.aR = false;
                this.f16199a.f16200a.f16234g.a(this.f16199a.f16200a.f16235h.m19447a("claim_deleted", this.f16199a.f16200a.aY, "permalink"));
                this.f16199a.f16200a.f16229b.a(new C17351(this));
            }

            public void onFailure(Throwable th) {
                this.f16199a.f16200a.aR = true;
                BLog.b("OfferDetailPageFragment", "Unable to remove offer claim", th);
                this.f16199a.f16200a.f16229b.a(new C17362(this));
            }
        }

        C17382(OfferDetailPageFragment offerDetailPageFragment) {
            this.f16200a = offerDetailPageFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 384454911);
            if (this.f16200a.aR) {
                if (!(this.f16200a.aY == null || this.f16200a.aY.f16522a == null || this.f16200a.aY.f16522a.mo1011z() == null)) {
                    Futures.a(this.f16200a.f16228a.m18994a(this.f16200a.aY.f16522a.mo1011z().m19289b(), (String) this.f16200a.f16233f.get()), new C17371(this));
                }
            } else if (!(this.f16200a.aY == null || this.f16200a.aY.f16522a == null)) {
                String a2 = OffersEventUtil.m19444a(this.f16200a.aY.f16522a);
                if (StringUtil.a(a2)) {
                    a2 = this.f16200a.ba;
                }
                String jQ_ = this.f16200a.aY.m19469t().jQ_();
                String b = this.f16200a.aY.f16522a.mo1011z() != null ? this.f16200a.aY.f16522a.mo1011z().m19289b() : null;
                OfferDetailPageFragment offerDetailPageFragment = this.f16200a;
                if (b != null) {
                    jQ_ = null;
                }
                offerDetailPageFragment.m19007a(jQ_, b, a2, null, null, null, false, false);
            }
            LogUtils.a(776688330, a);
        }
    }

    /* compiled from: custom_cta_change_cta_type_mobile */
    class C17393 implements OnClickListener {
        final /* synthetic */ OfferDetailPageFragment f16201a;

        C17393(OfferDetailPageFragment offerDetailPageFragment) {
            this.f16201a = offerDetailPageFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 584209745);
            if (this.f16201a.aY != null) {
                OfferBrowserUtils.a(this.f16201a.ao(), this.f16201a.aY.m19461j(), this.f16201a.aH);
                this.f16201a.f16234g.a(this.f16201a.f16235h.m19447a("code_copied", this.f16201a.aY, "permalink"));
            }
            Logger.a(2, EntryType.UI_INPUT_END, 361241692, a);
        }
    }

    /* compiled from: custom_cta_change_cta_type_mobile */
    class C17404 implements OnClickListener {
        final /* synthetic */ OfferDetailPageFragment f16202a;

        C17404(OfferDetailPageFragment offerDetailPageFragment) {
            this.f16202a = offerDetailPageFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -160484311);
            OfferRenderingUtils offerRenderingUtils = this.f16202a.f16232e;
            Context context = this.f16202a.getContext();
            offerRenderingUtils.f16253e.a(offerRenderingUtils.f16258j.a(context, FBLinks.fp), context);
            Logger.a(2, EntryType.UI_INPUT_END, -669548111, a);
        }
    }

    /* compiled from: custom_cta_change_cta_type_mobile */
    class C17549 implements OnClickListener {
        final /* synthetic */ OfferDetailPageFragment f16227a;

        /* compiled from: custom_cta_change_cta_type_mobile */
        class C17531 implements FutureCallback<GraphQLResult<OfferClaimMarkAsUsedMutationModel>> {
            final /* synthetic */ C17549 f16226a;

            /* compiled from: custom_cta_change_cta_type_mobile */
            class C17521 implements Runnable {
                final /* synthetic */ C17531 f16225a;

                C17521(C17531 c17531) {
                    this.f16225a = c17531;
                }

                public void run() {
                    OfferDetailPageFragment.m19008e(this.f16225a.f16226a.f16227a);
                }
            }

            C17531(C17549 c17549) {
                this.f16226a = c17549;
            }

            public void onSuccess(@Nullable Object obj) {
                GraphQLResult graphQLResult = (GraphQLResult) obj;
                if (graphQLResult != null && graphQLResult.e != null && ((OfferClaimMarkAsUsedMutationModel) graphQLResult.e).m19058a() != null) {
                    OfferClaimData a = ((OfferClaimMarkAsUsedMutationModel) graphQLResult.e).m19058a();
                    if (this.f16226a.f16227a.aQ.equals(a.mo1003g())) {
                        this.f16226a.f16227a.aY = OfferOrCoupon.m19448a(a);
                        this.f16226a.f16227a.f16229b.a(new C17521(this));
                        this.f16226a.f16227a.f16234g.a(this.f16226a.f16227a.f16235h.m19447a(this.f16226a.f16227a.aY.m19464n() ? "mark_as_used" : "mark_as_unused", this.f16226a.f16227a.aY, "permalink"));
                    }
                }
            }

            public void onFailure(Throwable th) {
                this.f16226a.f16227a.f16231d.a(this.f16226a.f16227a.getContext().getString(2131236841), 0);
            }
        }

        C17549(OfferDetailPageFragment offerDetailPageFragment) {
            this.f16227a = offerDetailPageFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 2118125758);
            if (this.f16227a.aR) {
                boolean z;
                OffersWalletFetcher offersWalletFetcher = this.f16227a.f16228a;
                String k = this.f16227a.aY.m19462k();
                OfferClaimData offerClaimData = this.f16227a.aY.f16522a;
                int i = this.f16227a.aW;
                if (this.f16227a.aY.m19464n()) {
                    z = false;
                } else {
                    z = true;
                }
                Futures.a(offersWalletFetcher.m18993a(k, offerClaimData, i, z, (String) this.f16227a.f16233f.get()), new C17531(this));
                OfferDetailPageFragment.m19005a(this.f16227a, false, false);
                LogUtils.a(-412135068, a);
                return;
            }
            Logger.a(2, EntryType.UI_INPUT_END, 97447229, a);
        }
    }

    /* compiled from: custom_cta_change_cta_type_mobile */
    enum TitleState {
        SHOW_TOP,
        SHOW_BOTTOM
    }

    public static void m19006a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((OfferDetailPageFragment) obj).m19001a(OffersWalletFetcher.m18991a(injectorLike), DefaultAndroidThreadUtil.b(injectorLike), GlyphColorizer.a(injectorLike), ToastThreadUtil.b(injectorLike), OfferRenderingUtils.m19015a(injectorLike), IdBasedProvider.a(injectorLike, 4442), AnalyticsLoggerMethodAutoProvider.a(injectorLike), OffersEventUtil.m19445b(injectorLike), QuickPerformanceLoggerMethodAutoProvider.a(injectorLike));
    }

    private void m19001a(OffersWalletFetcher offersWalletFetcher, AndroidThreadUtil androidThreadUtil, GlyphColorizer glyphColorizer, ToastThreadUtil toastThreadUtil, OfferRenderingUtils offerRenderingUtils, Provider<String> provider, AnalyticsLogger analyticsLogger, OffersEventUtil offersEventUtil, QuickPerformanceLogger quickPerformanceLogger) {
        this.f16228a = offersWalletFetcher;
        this.f16229b = androidThreadUtil;
        this.f16230c = glyphColorizer;
        this.f16231d = toastThreadUtil;
        this.f16232e = offerRenderingUtils;
        this.f16233f = provider;
        this.f16234g = analyticsLogger;
        this.f16235h = offersEventUtil;
        this.f16236i = quickPerformanceLogger;
    }

    public final void m19012c(Bundle bundle) {
        Class cls = OfferDetailPageFragment.class;
        m19006a(this, getContext());
        this.f16236i.b(9109506);
        super.c(bundle);
        Display defaultDisplay = o().getWindowManager().getDefaultDisplay();
        Point point = new Point();
        defaultDisplay.getSize(point);
        this.aW = point.x;
    }

    public final void m19009G() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 2093600830);
        super.G();
        Bundle bundle = this.s;
        this.aQ = bundle.getString("offer_claim_id");
        this.aS = bundle.getString("coupon_id");
        this.ba = bundle.getString("share_id");
        this.aT = bundle.getString("notif_trigger");
        this.aU = bundle.getString("notif_medium");
        this.aV = bundle.getString("rule");
        if (this.aQ == null && this.aS == null) {
            m19007a(bundle.getString("offer_id"), bundle.getString("offer_view_id"), this.ba, this.aT, this.aU, this.aV, "1".equals(bundle.getString("redirect")), true);
        } else {
            m19005a(this, false, true);
        }
        this.aX = false;
        LogUtils.f(-807383671, a);
    }

    public final void m19014e(Bundle bundle) {
        super.e(bundle);
        bundle.putString("offer_claim_id", this.aQ);
        bundle.putString("coupon_id", this.aS);
        bundle.putBoolean("is_offer_claimed", this.aR);
    }

    public final void m19013d(@android.support.annotation.Nullable Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1074413970);
        super.d(bundle);
        if (bundle != null) {
            this.aQ = bundle.getString("offer_claim_id");
            this.aS = bundle.getString("coupon_id");
            this.aR = bundle.getBoolean("is_offer_claimed");
        }
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1452467374, a);
    }

    public final View m19010a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -536926293);
        View inflate = layoutInflater.inflate(2130905528, viewGroup, false);
        this.an = inflate.findViewById(2131564336);
        this.am = (FbSwipeRefreshLayout) inflate.findViewById(2131564335);
        this.am.e = new C17341(this);
        this.ao = (FbDraweeView) inflate.findViewById(2131564334);
        FbDraweeView fbDraweeView = this.ao;
        if (this.ay == null) {
            this.ay = GenericDraweeHierarchyBuilder.a(jW_()).f(jW_().getDrawable(2130841765)).e(ScaleType.g).u();
        }
        fbDraweeView.setHierarchy(this.ay);
        this.ao.setAspectRatio(1.91f);
        this.ao.setMinimumWidth(this.aW);
        this.ap = (BetterRecyclerView) inflate.findViewById(2131564337);
        this.aq = new OfferDetailHeaderCarouselAdapter(getContext(), true);
        this.ap.setAdapter(this.aq);
        this.ar = (RichVideoPlayer) inflate.findViewById(2131564338);
        this.ar.a(this.f16232e.m19023b(getContext()));
        this.ap.setLayoutManager(new BetterLinearLayoutManager(getContext(), 0, false));
        this.as = (LinearLayout) inflate.findViewById(2131564339);
        this.at = (FbTextView) inflate.findViewById(2131564340);
        this.au = (FbTextView) inflate.findViewById(2131564341);
        this.au.setCompoundDrawablesWithIntrinsicBounds(this.f16230c.a(2130839883, -1), null, null, null);
        this.av = (LinearLayout) inflate.findViewById(2131564342);
        this.aw = (FbTextView) inflate.findViewById(2131564343);
        this.ax = (FbTextView) inflate.findViewById(2131564344);
        this.ax.setCompoundDrawablesWithIntrinsicBounds(this.f16230c.a(2130839883, -1), null, null, null);
        this.aB = (ViewGroup) inflate.findViewById(2131564349);
        this.az = (ViewGroup) inflate.findViewById(2131564351);
        this.aA = inflate.findViewById(2131564355);
        this.aD = (FbTextView) this.az.findViewById(2131564353);
        this.aC = (FbTextView) this.az.findViewById(2131564352);
        this.aC.setOnClickListener(new C17382(this));
        this.aE = (FbTextView) this.az.findViewById(2131564354);
        this.aE.setCompoundDrawablesWithIntrinsicBounds(null, this.f16230c.a(2130840097, -5066062), null, null);
        this.aF = (ViewGroup) inflate.findViewById(2131564345);
        this.aG = (FbTextView) this.aF.findViewById(2131564346);
        this.aH = (FbTextView) this.aF.findViewById(2131564348);
        this.aF.setOnClickListener(new C17393(this));
        this.aI = (ViewGroup) inflate.findViewById(2131564356);
        this.aJ = (FbTextView) inflate.findViewById(2131564357);
        this.aJ.setOnClickListener(new C17404(this));
        this.aK = (OfferExpirationTimerView) inflate.findViewById(2131564358);
        this.aL = (FbTextView) inflate.findViewById(2131564359);
        this.aM = (FbTextView) inflate.findViewById(2131564360);
        this.aN = (FbTextView) inflate.findViewById(2131564362);
        this.aO = inflate.findViewById(2131564361);
        aq();
        this.aP = inflate.findViewById(2131564363);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1894289929, a);
        return inflate;
    }

    public static void m19005a(OfferDetailPageFragment offerDetailPageFragment, boolean z, final boolean z2) {
        String str;
        GraphQLCachePolicy graphQLCachePolicy;
        OffersWalletFetcher offersWalletFetcher = offerDetailPageFragment.f16228a;
        int i = offerDetailPageFragment.aW;
        if (offerDetailPageFragment.aQ != null) {
            str = offerDetailPageFragment.aQ;
        } else {
            str = offerDetailPageFragment.aS;
        }
        GraphQLCachePolicy graphQLCachePolicy2 = GraphQLCachePolicy.a;
        if (z) {
            graphQLCachePolicy = GraphQLCachePolicy.d;
        } else {
            graphQLCachePolicy = graphQLCachePolicy2;
        }
        Futures.a(offersWalletFetcher.f16186a.a(GraphQLRequest.a((OfferDetailQueryString) new OfferDetailQueryString().a("profile_pic_width", Integer.valueOf(Math.max(100, i / 4))).a("creative_img_size", Integer.valueOf(i)).a("id", str)).a(graphQLCachePolicy).a(600)), new FutureCallback<GraphQLResult<OfferDetailQueryModel>>(offerDetailPageFragment) {
            final /* synthetic */ OfferDetailPageFragment f16207b;

            /* compiled from: custom_cta_change_cta_type_mobile */
            class C17411 implements Runnable {
                final /* synthetic */ C17445 f16203a;

                C17411(C17445 c17445) {
                    this.f16203a = c17445;
                }

                public void run() {
                    OfferDetailPageFragment.m19008e(this.f16203a.f16207b);
                    if (z2) {
                        this.f16203a.f16207b.m19011a(false);
                    }
                    this.f16203a.f16207b.f16236i.b(9109506, (short) 2);
                }
            }

            /* compiled from: custom_cta_change_cta_type_mobile */
            class C17422 implements Runnable {
                final /* synthetic */ C17445 f16204a;

                C17422(C17445 c17445) {
                    this.f16204a = c17445;
                }

                public void run() {
                    OfferDetailPageFragment.as(this.f16204a.f16207b);
                    this.f16204a.f16207b.m19011a(false);
                    this.f16204a.f16207b.f16236i.b(9109506, (short) 3);
                }
            }

            /* compiled from: custom_cta_change_cta_type_mobile */
            class C17433 implements Runnable {
                final /* synthetic */ C17445 f16205a;

                C17433(C17445 c17445) {
                    this.f16205a = c17445;
                }

                public void run() {
                    OfferDetailPageFragment.as(this.f16205a.f16207b);
                    this.f16205a.f16207b.m19011a(false);
                    this.f16205a.f16207b.f16236i.b(9109506, (short) 97);
                }
            }

            public void onSuccess(Object obj) {
                GraphQLResult graphQLResult = (GraphQLResult) obj;
                if (graphQLResult == null || graphQLResult.e == null) {
                    this.f16207b.f16229b.a(new C17422(this));
                    return;
                }
                new StringBuilder("Results: ").append(graphQLResult.e);
                if (this.f16207b.aS != null) {
                    this.f16207b.aY = new OfferOrCoupon(null, CouponDataModel.m19122a((OfferDetailQueryModel) graphQLResult.e));
                } else {
                    this.f16207b.aY = new OfferOrCoupon(OfferClaimDataModel.m19156a((OfferDetailQueryModel) graphQLResult.e), null);
                }
                OfferDetailPageFragment.au(this.f16207b);
                this.f16207b.f16229b.a(new C17411(this));
            }

            public void onFailure(Throwable th) {
                BLog.b("OfferDetailPageFragment", "Error loading offers", th);
                this.f16207b.f16229b.a(new C17433(this));
            }
        });
        if (z2) {
            offerDetailPageFragment.m19011a(true);
            offerDetailPageFragment.an.setVisibility(8);
        }
    }

    private void m19007a(@Nullable String str, @Nullable String str2, String str3, @Nullable String str4, @Nullable String str5, @Nullable String str6, boolean z, boolean z2) {
        final String str7;
        final String str8;
        final String str9;
        final boolean z3;
        if (str != null) {
            str7 = str4;
            str8 = str5;
            str9 = str6;
            z3 = z;
            Futures.a(this.f16228a.m18995a(str, str3, this.aW, (String) this.f16233f.get()), new FutureCallback<GraphQLResult<OfferClaimToWalletMutationModel>>(this) {
                final /* synthetic */ OfferDetailPageFragment f16214e;

                /* compiled from: custom_cta_change_cta_type_mobile */
                class C17451 implements Runnable {
                    final /* synthetic */ C17476 f16208a;

                    C17451(C17476 c17476) {
                        this.f16208a = c17476;
                    }

                    public void run() {
                        OfferDetailPageFragment.as(this.f16208a.f16214e);
                        this.f16208a.f16214e.m19011a(false);
                        this.f16208a.f16214e.f16236i.b(9109506, (short) 3);
                    }
                }

                /* compiled from: custom_cta_change_cta_type_mobile */
                class C17462 implements Runnable {
                    final /* synthetic */ C17476 f16209a;

                    C17462(C17476 c17476) {
                        this.f16209a = c17476;
                    }

                    public void run() {
                        OfferDetailPageFragment.as(this.f16209a.f16214e);
                        this.f16209a.f16214e.m19011a(false);
                        this.f16209a.f16214e.f16236i.b(9109506, (short) 97);
                    }
                }

                public void onSuccess(Object obj) {
                    GraphQLResult graphQLResult = (GraphQLResult) obj;
                    if (graphQLResult == null || graphQLResult.e == null || ((OfferClaimToWalletMutationModel) graphQLResult.e).m19063a() == null) {
                        this.f16214e.f16229b.a(new C17451(this));
                        return;
                    }
                    OfferDetailPageFragment.m19003a(this.f16214e, ((OfferClaimToWalletMutationModel) graphQLResult.e).m19063a(), str7, str8, str9, z3);
                    OfferDetailPageFragment.au(this.f16214e);
                }

                public void onFailure(Throwable th) {
                    BLog.b("OfferDetailPageFragment", "Error loading offers", th);
                    this.f16214e.f16229b.a(new C17462(this));
                }
            });
        } else {
            str7 = str4;
            str8 = str5;
            str9 = str6;
            z3 = z;
            Futures.a(this.f16228a.m18997b(str2, str3, this.aW, (String) this.f16233f.get()), new FutureCallback<GraphQLResult<OfferViewClaimToWalletMutationModel>>(this) {
                final /* synthetic */ OfferDetailPageFragment f16221e;

                /* compiled from: custom_cta_change_cta_type_mobile */
                class C17481 implements Runnable {
                    final /* synthetic */ C17507 f16215a;

                    C17481(C17507 c17507) {
                        this.f16215a = c17507;
                    }

                    public void run() {
                        OfferDetailPageFragment.as(this.f16215a.f16221e);
                        this.f16215a.f16221e.m19011a(false);
                        this.f16215a.f16221e.f16236i.b(9109506, (short) 3);
                    }
                }

                /* compiled from: custom_cta_change_cta_type_mobile */
                class C17492 implements Runnable {
                    final /* synthetic */ C17507 f16216a;

                    C17492(C17507 c17507) {
                        this.f16216a = c17507;
                    }

                    public void run() {
                        OfferDetailPageFragment.as(this.f16216a.f16221e);
                        this.f16216a.f16221e.m19011a(false);
                        this.f16216a.f16221e.f16236i.b(9109506, (short) 97);
                    }
                }

                public void onSuccess(Object obj) {
                    GraphQLResult graphQLResult = (GraphQLResult) obj;
                    if (graphQLResult == null || graphQLResult.e == null || ((OfferViewClaimToWalletMutationModel) graphQLResult.e).m19068a() == null) {
                        this.f16221e.f16229b.a(new C17481(this));
                    } else {
                        OfferDetailPageFragment.m19003a(this.f16221e, ((OfferViewClaimToWalletMutationModel) graphQLResult.e).m19068a(), str7, str8, str9, z3);
                    }
                }

                public void onFailure(Throwable th) {
                    BLog.b("OfferDetailPageFragment", "Error loading offers", th);
                    this.f16221e.f16229b.a(new C17492(this));
                }
            });
        }
        if (z2) {
            m19011a(true);
            this.an.setVisibility(8);
        }
    }

    static /* synthetic */ void m19003a(OfferDetailPageFragment offerDetailPageFragment, final OfferClaimData offerClaimData, String str, String str2, String str3, final boolean z) {
        new StringBuilder("Results: ").append(offerClaimData);
        offerDetailPageFragment.aY = OfferOrCoupon.m19448a(offerClaimData);
        offerDetailPageFragment.aQ = offerClaimData.mo1003g();
        offerDetailPageFragment.aR = true;
        offerDetailPageFragment.f16229b.a(new Runnable(offerDetailPageFragment) {
            final /* synthetic */ OfferDetailPageFragment f16224c;

            public void run() {
                OfferDetailPageFragment.m19008e(this.f16224c);
                this.f16224c.m19011a(false);
                this.f16224c.f16236i.b(9109506, (short) 2);
                if (z && this.f16224c.aZ) {
                    String b;
                    this.f16224c.aZ = false;
                    OfferRenderingUtils offerRenderingUtils = this.f16224c.f16232e;
                    Context context = this.f16224c.getContext();
                    String i = this.f16224c.aY.m19460i();
                    String j = this.f16224c.aY.m19461j();
                    String f = this.f16224c.aY.m19457f();
                    String jQ_ = offerClaimData.mo1009x().jQ_();
                    if (offerClaimData.mo1011z() != null) {
                        b = offerClaimData.mo1011z().m19289b();
                    } else {
                        b = null;
                    }
                    offerRenderingUtils.m19019a(context, i, j, f, jQ_, b, OffersEventUtil.m19444a(offerClaimData));
                }
            }
        });
        if (offerDetailPageFragment.aT != null || str2 != null || str3 != null) {
            offerDetailPageFragment.f16234g.a(offerDetailPageFragment.f16235h.m19446a(offerDetailPageFragment.aY, offerDetailPageFragment.aT, offerDetailPageFragment.aU, offerDetailPageFragment.aV));
        }
    }

    public final void dE_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 272530930);
        super.dE_();
        this.bb = true;
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1212788613, a);
    }

    public final void a_(Context context) {
        super.a_(context);
        this.bb = false;
    }

    @UiThread
    public static void m19008e(OfferDetailPageFragment offerDetailPageFragment) {
        if (offerDetailPageFragment.aY == null) {
            BLog.c("OfferDetailPageFragment", "Tried to rebind Detail view with null Offer");
        } else if (!offerDetailPageFragment.bb) {
            String c;
            offerDetailPageFragment.aq();
            int c2 = offerDetailPageFragment.aY.m19454c();
            int d = offerDetailPageFragment.aY.m19455d();
            if (c2 > 1) {
                offerDetailPageFragment.aq.f16192d = offerDetailPageFragment.aY.m19453b();
                offerDetailPageFragment.ap.setVisibility(0);
                offerDetailPageFragment.m19002a(TitleState.SHOW_BOTTOM);
                offerDetailPageFragment.ao.setVisibility(8);
                offerDetailPageFragment.ar.setVisibility(8);
                offerDetailPageFragment.ar.a(true, EventTriggerType.BY_AUTOPLAY);
            } else if (c2 == 1) {
                offerDetailPageFragment.ao.a(Uri.parse(offerDetailPageFragment.aY.m19451a().m19151a()), al);
                offerDetailPageFragment.ao.setVisibility(0);
                offerDetailPageFragment.m19002a(TitleState.SHOW_BOTTOM);
                offerDetailPageFragment.ap.setVisibility(8);
                offerDetailPageFragment.ar.setVisibility(8);
                offerDetailPageFragment.ar.a(true, EventTriggerType.BY_AUTOPLAY);
            } else if (d > 0) {
                offerDetailPageFragment.ar.setVisibility(0);
                offerDetailPageFragment.ar.a(offerDetailPageFragment.aY.m19452a(0, true));
                offerDetailPageFragment.ar.a(EventTriggerType.BY_USER);
                offerDetailPageFragment.ar.a(false, EventTriggerType.BY_AUTOPLAY);
                offerDetailPageFragment.m19002a(TitleState.SHOW_TOP);
                offerDetailPageFragment.ao.setVisibility(8);
                offerDetailPageFragment.ap.setVisibility(8);
            } else {
                offerDetailPageFragment.ao.a(null, al);
                offerDetailPageFragment.ao.setVisibility(0);
                offerDetailPageFragment.m19002a(TitleState.SHOW_BOTTOM);
                offerDetailPageFragment.ap.setVisibility(8);
                offerDetailPageFragment.ar.setVisibility(8);
                offerDetailPageFragment.ar.a(true, EventTriggerType.BY_AUTOPLAY);
            }
            offerDetailPageFragment.at.setText(offerDetailPageFragment.aY.m19457f());
            offerDetailPageFragment.aw.setText(offerDetailPageFragment.aY.m19457f());
            if (offerDetailPageFragment.aY.m19463m() > 0) {
                offerDetailPageFragment.au.setText(offerDetailPageFragment.getContext().getString(2131236802, new Object[]{Integer.valueOf(offerDetailPageFragment.aY.m19463m())}));
                offerDetailPageFragment.au.setVisibility(0);
                offerDetailPageFragment.ax.setVisibility(0);
            } else {
                offerDetailPageFragment.au.setVisibility(8);
                offerDetailPageFragment.ax.setVisibility(8);
            }
            if (StringUtil.a(offerDetailPageFragment.aY.m19461j()) || offerDetailPageFragment.aY.m19464n() || offerDetailPageFragment.f16232e.m19022a(offerDetailPageFragment.aY)) {
                offerDetailPageFragment.aF.setVisibility(8);
            } else {
                offerDetailPageFragment.aF.setVisibility(0);
                offerDetailPageFragment.aG.setText(offerDetailPageFragment.aY.m19461j());
            }
            if (offerDetailPageFragment.f16232e.m19022a(offerDetailPageFragment.aY) || offerDetailPageFragment.aY.m19464n()) {
                offerDetailPageFragment.aB.setVisibility(0);
                offerDetailPageFragment.f16232e.m19020a(offerDetailPageFragment.aB, offerDetailPageFragment.aY);
            } else {
                offerDetailPageFragment.aB.setVisibility(8);
            }
            offerDetailPageFragment.aH.setText(2131236824);
            if (offerDetailPageFragment.aY == null || offerDetailPageFragment.aY.f16522a == null || !offerDetailPageFragment.aR) {
                offerDetailPageFragment.aC.setCompoundDrawablesWithIntrinsicBounds(null, offerDetailPageFragment.f16230c.a(2130841763, -5066062), null, null);
                offerDetailPageFragment.aC.setTextColor(offerDetailPageFragment.getContext().getResources().getColor(2131362107));
                offerDetailPageFragment.aC.setText(2131236804);
                offerDetailPageFragment.aI.setVisibility(8);
            } else {
                offerDetailPageFragment.aC.setCompoundDrawablesWithIntrinsicBounds(null, offerDetailPageFragment.f16230c.a(2130841763, -12425294), null, null);
                offerDetailPageFragment.aC.setTextColor(offerDetailPageFragment.getContext().getResources().getColor(2131362081));
                offerDetailPageFragment.aC.setText(2131236805);
                if (offerDetailPageFragment.aY.m19464n() || offerDetailPageFragment.f16232e.m19022a(offerDetailPageFragment.aY)) {
                    offerDetailPageFragment.aI.setVisibility(8);
                } else {
                    offerDetailPageFragment.aI.setVisibility(0);
                }
            }
            if (offerDetailPageFragment.aY.m19467r()) {
                offerDetailPageFragment.aD.setOnClickListener(new C17549(offerDetailPageFragment));
                offerDetailPageFragment.aD.setVisibility(0);
            } else {
                offerDetailPageFragment.aD.setVisibility(8);
            }
            if (offerDetailPageFragment.aY.m19464n()) {
                offerDetailPageFragment.aD.setCompoundDrawablesWithIntrinsicBounds(null, offerDetailPageFragment.f16230c.a(2130839774, -12425294), null, null);
                offerDetailPageFragment.aD.setTextColor(offerDetailPageFragment.getContext().getResources().getColor(2131362081));
                offerDetailPageFragment.aD.setText(2131236812);
            } else {
                offerDetailPageFragment.aD.setCompoundDrawablesWithIntrinsicBounds(null, offerDetailPageFragment.f16230c.a(2130839774, -5066062), null, null);
                offerDetailPageFragment.aD.setTextColor(offerDetailPageFragment.getContext().getResources().getColor(2131362107));
                offerDetailPageFragment.aD.setText(2131236813);
            }
            offerDetailPageFragment.aK.setExpiresOn(offerDetailPageFragment.aY.m19459h());
            offerDetailPageFragment.aL.setText(offerDetailPageFragment.aY.m19458g());
            FbTextView fbTextView = offerDetailPageFragment.aM;
            OfferOrCoupon offerOrCoupon = offerDetailPageFragment.aY;
            if (offerOrCoupon.m19467r()) {
                c = offerOrCoupon.m19469t().m19187c();
            } else {
                c = offerOrCoupon.f16523b.mo985b().toString();
            }
            String str = c;
            if (StringUtil.a(str)) {
                fbTextView.setText(2131236821);
            } else if ("online".equals(str) || "ONLINE_ONLY".equals(str)) {
                fbTextView.setText(2131236818);
            } else if ("offline".equals(str) || "INSTORE_ONLY".equals(str)) {
                fbTextView.setText(2131236819);
            } else {
                fbTextView.setText(2131236820);
            }
            OfferOrCoupon offerOrCoupon2 = offerDetailPageFragment.aY;
            if (offerOrCoupon2.m19467r()) {
                c = offerOrCoupon2.m19469t().m19193m();
            } else {
                c = offerOrCoupon2.f16523b.mo999q();
            }
            String str2 = c;
            if (StringUtil.a(str2)) {
                offerDetailPageFragment.aO.setVisibility(8);
            } else {
                offerDetailPageFragment.aO.setVisibility(0);
            }
            offerDetailPageFragment.aO.setOnClickListener(new OnClickListener(offerDetailPageFragment) {
                final /* synthetic */ OfferDetailPageFragment f16193a;

                {
                    this.f16193a = r1;
                }

                public void onClick(View view) {
                    int a = Logger.a(2, EntryType.UI_INPUT_START, 575618460);
                    this.f16193a.aX = true;
                    OfferDetailPageFragment.m19008e(this.f16193a);
                    Logger.a(2, EntryType.UI_INPUT_END, -1235268822, a);
                }
            });
            if (offerDetailPageFragment.aX) {
                offerDetailPageFragment.aN.setText(str2);
            } else {
                offerDetailPageFragment.aN.setText(2131236845);
            }
            if (offerDetailPageFragment.aY.m19467r()) {
                if (offerDetailPageFragment.aY.f16522a.mo1001A() != null) {
                    OfferRenderingUtils offerRenderingUtils = offerDetailPageFragment.f16232e;
                    FbTextView fbTextView2 = offerDetailPageFragment.aE;
                    fbTextView2.setOnClickListener(new C17573(offerRenderingUtils, fbTextView2.getContext(), offerDetailPageFragment.aY, "permalink"));
                }
                if (!offerDetailPageFragment.aR || offerDetailPageFragment.aY.m19464n()) {
                    offerDetailPageFragment.aA.setVisibility(0);
                } else {
                    offerDetailPageFragment.aA.setVisibility(8);
                }
                offerDetailPageFragment.az.setVisibility(0);
            } else {
                offerDetailPageFragment.aA.setVisibility(8);
                offerDetailPageFragment.az.setVisibility(8);
            }
            offerDetailPageFragment.an.setVisibility(0);
        }
    }

    @UiThread
    private void aq() {
        String b;
        if (this.aY == null || this.aY.m19456e() == null) {
            b = b(2131236800);
        } else {
            b = a(2131236799, new Object[]{this.aY.m19456e().m19245d()});
        }
        HasTitleBar hasTitleBar = (HasTitleBar) a(HasTitleBar.class);
        if (hasTitleBar != null) {
            hasTitleBar.a_(b);
            hasTitleBar.c(true);
        }
    }

    public final void m19011a(final boolean z) {
        this.am.post(new Runnable(this) {
            final /* synthetic */ OfferDetailPageFragment f16195b;

            public void run() {
                this.f16195b.am.setRefreshing(z);
            }
        });
        if (z) {
            this.aP.setVisibility(8);
        }
    }

    public final String am_() {
        return "offers_detail_page";
    }

    @UiThread
    public static void as(OfferDetailPageFragment offerDetailPageFragment) {
        offerDetailPageFragment.aP.setVisibility(0);
    }

    public static void au(OfferDetailPageFragment offerDetailPageFragment) {
        String str = "viewed_offer";
        if (offerDetailPageFragment.aY.m19471v()) {
            str = "viewed_coupon";
        }
        HoneyClientEvent a = offerDetailPageFragment.f16235h.m19447a(str, offerDetailPageFragment.aY, "permalink");
        a.b("offer_location", "permalink");
        offerDetailPageFragment.f16234g.a(a);
    }

    @UiThread
    private void m19002a(TitleState titleState) {
        if (TitleState.SHOW_TOP.equals(titleState)) {
            this.as.setVisibility(8);
            this.av.setVisibility(0);
            return;
        }
        this.av.setVisibility(8);
        this.as.setVisibility(0);
    }
}
