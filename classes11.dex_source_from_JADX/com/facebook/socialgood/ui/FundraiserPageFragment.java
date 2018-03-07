package com.facebook.socialgood.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.facebook.accessibility.AutomaticPhotoCaptioningUtils;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.auth.annotations.LoggedInUserId;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.executors.ForUiThreadImmediate;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadImmediateMethodAutoProvider;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.uri.FbUriIntentHandler;
import com.facebook.common.uri.UriIntentMapper;
import com.facebook.common.util.FindViewUtil;
import com.facebook.content.SecureContextHelper;
import com.facebook.flatbuffers.helpers.FlatBufferModelHelper;
import com.facebook.graphql.calls.ReactionTriggerInputTriggerData.Surface;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.querybuilder.common.GraphQlQueryDefaults;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.pages.common.util.PortraitOrientationController;
import com.facebook.reaction.ReactionQueryParams;
import com.facebook.reaction.ReactionSession;
import com.facebook.reaction.ReactionSessionHelper;
import com.facebook.reaction.ui.fragment.BaseFullscreenReactionFragment;
import com.facebook.socialgood.ipc.SocialGoodConstants.FundraiserActionType;
import com.facebook.socialgood.ipc.SocialGoodLogHelper;
import com.facebook.socialgood.protocol.FundraiserPage.FundraiserPageHeaderQueryString;
import com.facebook.socialgood.protocol.FundraiserPageModels.FundraiserPageHeaderQueryModel;
import com.facebook.ui.titlebar.Fb4aTitleBarSupplier;
import com.facebook.ultralight.Inject;
import com.facebook.ultralight.Lazy;
import com.facebook.ultralight.UltralightRuntime;
import com.facebook.widget.recyclerview.RecyclerViewProxy;
import com.facebook.widget.titlebar.FadingContentFragmentController;
import com.facebook.widget.titlebar.FadingContentView;
import com.facebook.widget.titlebar.FadingContentViewProvider;
import com.facebook.widget.titlebar.FbTitleBar;
import com.facebook.widget.titlebar.FbTitleBarSupplier;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import javax.annotation.Nullable;
import javax.inject.Provider;

/* compiled from: NullPointerException */
public class FundraiserPageFragment extends BaseFullscreenReactionFragment implements FadingContentViewProvider {
    private String aA;
    public String aB;
    public String aC;
    public FundraiserActionType aD;
    public FundraiserPageHeaderQueryModel aE;
    public boolean aF = true;
    public boolean aG;
    private PortraitOrientationController aH;
    private int aI;
    private ListenableFuture<GraphQLResult<FundraiserPageHeaderQueryModel>> aJ;
    private boolean aK;
    public RecyclerViewProxy aL;
    public FadingContentFragmentController aM;
    public FbTitleBar aN;
    @Inject
    @LoggedInUserId
    volatile Provider<String> am = UltralightRuntime.a;
    @Inject
    public AnalyticsLogger an;
    @Inject
    @Lazy
    public com.facebook.inject.Lazy<FbErrorReporter> ao = UltralightRuntime.b;
    @Inject
    @ForUiThreadImmediate
    private ExecutorService ap;
    @Inject
    public GraphQLQueryExecutor aq;
    @Inject
    private ReactionSessionHelper ar;
    @Inject
    public FbTitleBarSupplier as;
    @Inject
    @Lazy
    public com.facebook.inject.Lazy<SecureContextHelper> at = UltralightRuntime.b;
    @Inject
    public FbUriIntentHandler au;
    @Inject
    public AutomaticPhotoCaptioningUtils av;
    @Inject
    @Lazy
    public com.facebook.inject.Lazy<UriIntentMapper> aw = UltralightRuntime.b;
    @Inject
    public Context ax;
    private FundraiserPageHeaderView ay;
    private View az;

    /* compiled from: NullPointerException */
    public /* synthetic */ class C15132 {
        public static final /* synthetic */ int[] f12852a = new int[FundraiserActionType.values().length];

        static {
            try {
                f12852a[FundraiserActionType.INVITE.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f12852a[FundraiserActionType.NONE.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
        }
    }

    /* compiled from: NullPointerException */
    class FundraiserDataReceivedCallback implements FutureCallback<GraphQLResult<FundraiserPageHeaderQueryModel>> {
        final /* synthetic */ FundraiserPageFragment f12853a;

        public FundraiserDataReceivedCallback(FundraiserPageFragment fundraiserPageFragment) {
            this.f12853a = fundraiserPageFragment;
        }

        public void onSuccess(@Nullable Object obj) {
            GraphQLResult graphQLResult = (GraphQLResult) obj;
            if (graphQLResult != null) {
                FundraiserPageFragment.m13504a(this.f12853a, (FundraiserPageHeaderQueryModel) graphQLResult.e);
                if (this.f12853a.aN != null && this.f12853a.aE != null) {
                    this.f12853a.aN.setTitle(this.f12853a.aE.m13407k());
                }
            }
        }

        public void onFailure(Throwable th) {
            if (this.f12853a.aF) {
                ((AbstractFbErrorReporter) this.f12853a.ao.get()).a("fundraiser_page_fragment_error", "Failed initial fundraiser data fetch", th);
                this.f12853a.aF = false;
                FundraiserPageFragment.aZ(this.f12853a);
                return;
            }
            FundraiserPageFragment.m13505a(this.f12853a, "Failed retried fundraiser data fetch", th);
        }
    }

    public static void m13506a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((FundraiserPageFragment) obj).m13507a(IdBasedProvider.a(fbInjector, 4442), AnalyticsLoggerMethodAutoProvider.a(fbInjector), IdBasedSingletonScopeProvider.b(fbInjector, 494), (ExecutorService) ListeningScheduledExecutorService_ForUiThreadImmediateMethodAutoProvider.a(fbInjector), GraphQLQueryExecutor.a(fbInjector), ReactionSessionHelper.b(fbInjector), (FbTitleBarSupplier) Fb4aTitleBarSupplier.a(fbInjector), IdBasedSingletonScopeProvider.b(fbInjector, 968), FbUriIntentHandler.a(fbInjector), AutomaticPhotoCaptioningUtils.b(fbInjector), IdBasedSingletonScopeProvider.b(fbInjector, 2436), (Context) fbInjector.getInstance(Context.class));
    }

    public static void aZ(FundraiserPageFragment fundraiserPageFragment) {
        GraphQLRequest a = GraphQLRequest.a(new FundraiserPageHeaderQueryString());
        a.a(new FundraiserPageHeaderQueryString().a("campaign_id", fundraiserPageFragment.aB).a("default_image_scale", GraphQlQueryDefaults.a()).a("automatic_photo_captioning_enabled", Boolean.toString(fundraiserPageFragment.av.a())).a);
        fundraiserPageFragment.aJ = fundraiserPageFragment.aq.a(a);
        Futures.a(fundraiserPageFragment.aJ, new FundraiserDataReceivedCallback(fundraiserPageFragment), fundraiserPageFragment.ap);
    }

    public final String am_() {
        return "social_good";
    }

    public final void m13514c(@Nullable Bundle bundle) {
        Class cls = FundraiserPageFragment.class;
        m13506a((Object) this, getContext());
        m13510n(bundle);
        super.c(bundle);
        if (this.aD != null) {
            String formatStrLocaleSafe;
            switch (C15132.f12852a[this.aD.ordinal()]) {
                case 1:
                    formatStrLocaleSafe = StringFormatUtil.formatStrLocaleSafe(FBLinks.eX, this.aB);
                    break;
                default:
                    formatStrLocaleSafe = null;
                    break;
            }
            if (formatStrLocaleSafe != null) {
                Intent a = ((UriIntentMapper) this.aw.get()).a(this.ax, formatStrLocaleSafe);
                a.putExtra("source", this.aC);
                ((SecureContextHelper) this.at.get()).a(a, this.ax);
            }
            this.aD = FundraiserActionType.NONE;
        }
        this.aH = new PortraitOrientationController();
        a(this.aH);
    }

    private void m13510n(@Nullable Bundle bundle) {
        if (bundle != null) {
            this.aA = bundle.getString("post_id");
            this.aF = bundle.getBoolean("should_fetch_fundraiser_data", true);
            this.aG = bundle.getBoolean("has_logged_view", false);
            this.aE = (FundraiserPageHeaderQueryModel) FlatBufferModelHelper.a(bundle, "fundraiser_data_model");
            this.aD = FundraiserActionType.fromString(bundle.getString("action_type"));
        } else {
            this.aA = this.s.getString("post_id");
            this.aF = true;
            this.aG = false;
            this.aD = FundraiserActionType.fromString(this.s.getString("action_type"));
        }
        this.aB = this.s.getString("fundraiser_campaign_id");
        this.aC = this.s.getString("source", "unknown");
        if (TextUtils.isEmpty(this.aB)) {
            m13509c("No campaign ID passed in");
        }
    }

    protected final int aq() {
        return 2130904564;
    }

    protected final FrameLayout m13511a(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        FrameLayout a = super.a(layoutInflater.cloneInContext(new ContextThemeWrapper(layoutInflater.getContext(), 2131626662)), viewGroup);
        m13503a(a);
        return a;
    }

    private void m13503a(FrameLayout frameLayout) {
        this.ay = (FundraiserPageHeaderView) FindViewUtil.b(frameLayout, 2131562465);
        a(this.ay);
        this.ay.a();
        if (this.aE != null) {
            this.am.get();
            this.ay.m13520a(this.aE, this.aC);
            bd();
        }
    }

    protected final ReactionSession ax() {
        long j = 0;
        try {
            j = Long.parseLong(this.aB);
        } catch (Throwable e) {
            m13505a(this, "Could not parse campaign id", e);
        }
        return this.ar.a(Surface.ANDROID_FUNDRAISER_PAGE, new ReactionQueryParams().b(Long.valueOf(j)));
    }

    public final void m13516e(Bundle bundle) {
        super.e(bundle);
        bundle.putString("post_id", this.aA);
        bundle.putString("action_type", this.aD.toString());
        bundle.putBoolean("should_fetch_fundraiser_data", this.aF);
        bundle.putBoolean("has_logged_view", this.aG);
        FlatBufferModelHelper.a(bundle, "fundraiser_data_model", this.aE);
    }

    protected final void aW() {
        this.aI = this.ay.getMeasuredHeight();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void m13513a(android.view.View r9, @javax.annotation.Nullable android.os.Bundle r10) {
        /*
        r8 = this;
        if (r10 == 0) goto L_0x0076;
    L_0x0002:
        r0 = r8.aE;
        if (r0 == 0) goto L_0x0076;
    L_0x0006:
        r0 = r8.aE;
        r0 = r0.m13410n();
        if (r0 == 0) goto L_0x0076;
    L_0x000e:
        r0 = r8.aE;
        r0 = r0.m13410n();
        r0 = r0.m13384a();
        if (r0 == 0) goto L_0x0076;
    L_0x001a:
        r0 = r8.aE;
        r0 = r0.m13410n();
        r0 = r0.m13384a();
        r0 = r0.m13379b();
        r0 = android.text.TextUtils.isEmpty(r0);
        if (r0 != 0) goto L_0x0076;
    L_0x002e:
        r0 = r8.aE;
        r0 = com.facebook.socialgood.ui.SocialGoodDataModelHelper.m13523b(r0);
        if (r0 == 0) goto L_0x0052;
    L_0x0036:
        r1 = r8.aE;
        r1 = r1.m13411o();
        if (r1 == 0) goto L_0x004e;
    L_0x003e:
        r1 = r8.aE;
        r1 = r1.m13411o();
        r1 = r1.m13351k();
        r1 = android.text.TextUtils.isEmpty(r1);
        if (r1 == 0) goto L_0x00c4;
    L_0x004e:
        r1 = 1;
    L_0x004f:
        r0 = r1;
        if (r0 != 0) goto L_0x0076;
    L_0x0052:
        r0 = r8.aE;
        r0 = com.facebook.socialgood.ui.SocialGoodDataModelHelper.m13524c(r0);
        if (r0 == 0) goto L_0x0079;
    L_0x005a:
        r1 = r8.aE;
        r1 = r1.m13417u();
        if (r1 == 0) goto L_0x0072;
    L_0x0062:
        r1 = r8.aE;
        r1 = r1.m13417u();
        r1 = r1.m13362k();
        r1 = android.text.TextUtils.isEmpty(r1);
        if (r1 == 0) goto L_0x00c6;
    L_0x0072:
        r1 = 1;
    L_0x0073:
        r0 = r1;
        if (r0 == 0) goto L_0x0079;
    L_0x0076:
        aZ(r8);
    L_0x0079:
        r1 = 16908298; // 0x102000a float:2.3877257E-38 double:8.353809E-317;
        r1 = com.facebook.common.util.FindViewUtil.b(r9, r1);
        r1 = (com.facebook.widget.recyclerview.BetterRecyclerView) r1;
        r2 = new com.facebook.widget.recyclerview.RecyclerViewProxy;
        r2.<init>(r1);
        r0 = r2;
        r8.aL = r0;
        r0 = r8.as;
        r0 = r0.get();
        if (r0 == 0) goto L_0x00c3;
    L_0x0092:
        r0 = r8.aK;
        if (r0 != 0) goto L_0x00c3;
    L_0x0096:
        r1 = com.facebook.widget.titlebar.FadingTitlebarContent.class;
        r5 = r8.a(r1);
        r5 = (com.facebook.widget.titlebar.FadingTitlebarContent) r5;
        r1 = r8.aM;
        if (r1 != 0) goto L_0x00c3;
    L_0x00a2:
        if (r5 == 0) goto L_0x00c3;
    L_0x00a4:
        r1 = new com.facebook.widget.titlebar.FadingContentFragmentController;
        r1.<init>();
        r8.aM = r1;
        r1 = r8.as;
        r1 = r1.get();
        r1 = (com.facebook.widget.titlebar.FbTitleBar) r1;
        r8.aN = r1;
        r1 = r8.aM;
        r3 = r8.aN;
        r3 = (com.facebook.widget.titlebar.FadingFbTitleBar) r3;
        r4 = r8.aL;
        r6 = 1;
        r7 = 0;
        r2 = r8;
        r1.a(r2, r3, r4, r5, r6, r7);
    L_0x00c3:
        return;
    L_0x00c4:
        r1 = 0;
        goto L_0x004f;
    L_0x00c6:
        r1 = 0;
        goto L_0x0073;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.socialgood.ui.FundraiserPageFragment.a(android.view.View, android.os.Bundle):void");
    }

    public final void mY_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 837109241);
        if (this.ay != null) {
            this.ay.getDonateCallToActionButton().setOnClickListener(null);
        }
        this.az = null;
        this.ay = null;
        if (this.aJ != null) {
            this.aJ.cancel(true);
        }
        super.mY_();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1494862715, a);
    }

    public static void m13504a(FundraiserPageFragment fundraiserPageFragment, FundraiserPageHeaderQueryModel fundraiserPageHeaderQueryModel) {
        if (fundraiserPageFragment.m13508b(fundraiserPageHeaderQueryModel)) {
            fundraiserPageFragment.aE = fundraiserPageHeaderQueryModel;
            if (fundraiserPageFragment.ay != null) {
                fundraiserPageFragment.am.get();
                fundraiserPageFragment.ay.m13520a(fundraiserPageFragment.aE, fundraiserPageFragment.aC);
                fundraiserPageFragment.bd();
                if (fundraiserPageFragment.aB != null && !fundraiserPageFragment.aG) {
                    fundraiserPageFragment.aG = true;
                    AnalyticsLogger analyticsLogger = fundraiserPageFragment.an;
                    String str = fundraiserPageFragment.aB;
                    String str2 = fundraiserPageFragment.aC;
                    HoneyClientEvent honeyClientEvent = new HoneyClientEvent("fundraiser_page_view");
                    honeyClientEvent.c = "social_good";
                    analyticsLogger.a(honeyClientEvent.b("fundraiser_campaign_id", str).b("source", str2));
                }
            }
        }
    }

    private boolean m13508b(FundraiserPageHeaderQueryModel fundraiserPageHeaderQueryModel) {
        ArrayList arrayList = new ArrayList();
        if (fundraiserPageHeaderQueryModel == null) {
            arrayList.add("no_model");
        } else {
            if (TextUtils.isEmpty(fundraiserPageHeaderQueryModel.m13414r())) {
                arrayList.add("no_campaign_id");
            }
            if (TextUtils.isEmpty(fundraiserPageHeaderQueryModel.m13407k())) {
                arrayList.add("no_fundraiser_title");
            }
            if (fundraiserPageHeaderQueryModel.m13415s() == null) {
                arrayList.add("no_profile_picture");
            }
            if (fundraiserPageHeaderQueryModel.m13412p() == null || TextUtils.isEmpty(fundraiserPageHeaderQueryModel.m13412p().a())) {
                arrayList.add("no_charity_text");
            }
            if (fundraiserPageHeaderQueryModel.m13410n() == null || fundraiserPageHeaderQueryModel.m13410n().m13384a() == null) {
                arrayList.add("no_charity_page");
            } else if (TextUtils.isEmpty(fundraiserPageHeaderQueryModel.m13410n().m13384a().m13379b())) {
                arrayList.add("no_charity_page_id");
            }
            if (fundraiserPageHeaderQueryModel.m13406j() == null) {
                arrayList.add("unrecognized_graphql_type");
            } else if (SocialGoodDataModelHelper.m13523b(fundraiserPageHeaderQueryModel)) {
                if (fundraiserPageHeaderQueryModel.m13411o() == null) {
                    arrayList.add("no_fundraiser_page");
                } else if (TextUtils.isEmpty(fundraiserPageHeaderQueryModel.m13411o().m13351k())) {
                    arrayList.add("no_fundraiser_page_id");
                }
            } else if (!SocialGoodDataModelHelper.m13524c(fundraiserPageHeaderQueryModel)) {
                arrayList.add("unrecognized_graphql_type");
            } else if (fundraiserPageHeaderQueryModel.m13417u() == null) {
                arrayList.add("no_owner");
            } else if (TextUtils.isEmpty(fundraiserPageHeaderQueryModel.m13417u().m13362k())) {
                arrayList.add("no_owner_id");
            }
        }
        if (arrayList.isEmpty()) {
            return true;
        }
        HoneyClientEvent d = SocialGoodLogHelper.d(null);
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            d.a((String) arrayList.get(i), true);
        }
        if (this.aB != null) {
            d.b("fundraiser_campaign_id", this.aB);
        }
        this.an.a(d);
        m13509c(TextUtils.join(", ", arrayList));
        return false;
    }

    private void bd() {
        View donateCallToActionButton = this.ay.getDonateCallToActionButton();
        final Object t = this.aE.m13416t();
        if (TextUtils.isEmpty(t)) {
            donateCallToActionButton.setVisibility(8);
            return;
        }
        donateCallToActionButton.setVisibility(0);
        donateCallToActionButton.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ FundraiserPageFragment f12851b;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, 754497310);
                AnalyticsLogger analyticsLogger = this.f12851b.an;
                String str = this.f12851b.aB;
                String str2 = this.f12851b.aC;
                HoneyClientEvent honeyClientEvent = new HoneyClientEvent("fundraiser_page_tapped_donate");
                honeyClientEvent.c = "social_good";
                analyticsLogger.a(honeyClientEvent.b("fundraiser_campaign_id", str).b("source", str2));
                this.f12851b.au.a(this.f12851b.getContext(), t);
                Logger.a(2, EntryType.UI_INPUT_END, -256094803, a);
            }
        });
    }

    private void m13507a(Provider<String> provider, AnalyticsLogger analyticsLogger, com.facebook.inject.Lazy<FbErrorReporter> lazy, ExecutorService executorService, GraphQLQueryExecutor graphQLQueryExecutor, ReactionSessionHelper reactionSessionHelper, FbTitleBarSupplier fbTitleBarSupplier, com.facebook.inject.Lazy<SecureContextHelper> lazy2, FbUriIntentHandler fbUriIntentHandler, AutomaticPhotoCaptioningUtils automaticPhotoCaptioningUtils, com.facebook.inject.Lazy<UriIntentMapper> lazy3, Context context) {
        this.am = provider;
        this.an = analyticsLogger;
        this.ao = lazy;
        this.ap = executorService;
        this.aq = graphQLQueryExecutor;
        this.ar = reactionSessionHelper;
        this.as = fbTitleBarSupplier;
        this.at = lazy2;
        this.au = fbUriIntentHandler;
        this.av = automaticPhotoCaptioningUtils;
        this.aw = lazy3;
        this.ax = context;
    }

    protected final void m13515e() {
        this.aF = true;
        aZ(this);
        super.e();
    }

    protected final void m13512a(RecyclerView recyclerView) {
        if (aK() != 0) {
            this.ay.setTranslationY((float) (-this.aI));
            ar();
            return;
        }
        if (this.az == null) {
            this.az = recyclerView.getLayoutManager().c(0);
        }
        if (this.az != null) {
            int top = this.az.getTop();
            if (top == 0) {
                this.a.setEnabled(true);
            } else {
                ar();
            }
            this.ay.setTranslationY((float) Math.max(top, -this.aI));
        }
    }

    private void m13509c(String str) {
        ((AbstractFbErrorReporter) this.ao.get()).a("fundraiser_page_fragment_error", str);
        be();
    }

    public static void m13505a(FundraiserPageFragment fundraiserPageFragment, String str, Throwable th) {
        ((AbstractFbErrorReporter) fundraiserPageFragment.ao.get()).a("fundraiser_page_fragment_error", str, th);
        fundraiserPageFragment.be();
    }

    private void be() {
        if (this.ay != null) {
            this.ay.m13521b();
        }
        kp_();
    }

    public final FadingContentView m13517j() {
        if (this.ay == null) {
            return null;
        }
        return this.ay.f12854b;
    }

    public final boolean mk_() {
        return aK() == 0;
    }

    public final int ml_() {
        return mk_() ? this.az.getTop() : 0;
    }

    public final void m13518p() {
        this.aK = true;
    }
}
