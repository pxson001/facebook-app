package com.facebook.pages.fb4a.admin_activity.fragment;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.facebook.base.fragment.FbFragment;
import com.facebook.common.appchoreographer.AppChoreographer;
import com.facebook.common.appchoreographer.AppChoreographer.Priority;
import com.facebook.common.appchoreographer.AppChoreographer.ThreadType;
import com.facebook.common.appchoreographer.DefaultAppChoreographer;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.uri.FbUriIntentHandler;
import com.facebook.common.util.FindViewUtil;
import com.facebook.content.event.FbEvent;
import com.facebook.device.ScreenUtil;
import com.facebook.device.yearclass.YearClass;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStore;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.graphql.enums.GraphQLBoostedComponentStatus;
import com.facebook.graphql.enums.GraphQLPageCallToActionType;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.Lazy;
import com.facebook.interstitial.manager.InterstitialManager;
import com.facebook.ipc.pages.ProfilePermissions;
import com.facebook.ipc.pages.ProfilePermissions.Permission;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.pages.common.abtest.PagesCommonAbTestGatekeepers;
import com.facebook.pages.common.abtest.qe.PagesExperimentUtils;
import com.facebook.pages.common.constants.PagesAsyncTaskType;
import com.facebook.pages.common.eventbus.PageEventBus;
import com.facebook.pages.common.eventbus.PageEvents.PagesActivityDataChangeEventSubscriber;
import com.facebook.pages.common.logging.analytics.PagesAnalytics;
import com.facebook.pages.common.protocol.graphql.FetchPageActivityGraphQL;
import com.facebook.pages.common.protocol.graphql.FetchPageActivityGraphQL.FetchPageActivityQueryString;
import com.facebook.pages.common.protocol.graphql.FetchPageActivityGraphQLModels.FetchPageActivityQueryModel;
import com.facebook.pages.common.protocol.graphql.FetchPageActivityGraphQLModels.FetchPageActivityQueryModel.ActivityAdminInfoModel;
import com.facebook.pages.common.protocol.graphql.FetchPageActivityGraphQLModels.FetchPageActivityQueryModel.ActivityAdminInfoModel.BoostedLocalAwarenessPromotionsModel.NodesModel;
import com.facebook.pages.common.surfaceinterfaces.PagesSurfaceTabFragment;
import com.facebook.pages.common.util.PagesScrollUtils;
import com.facebook.pages.deeplinking.PageAdminUtils;
import com.facebook.pages.fb4a.admin_activity.views.PageActivityInsightsUniController;
import com.facebook.pages.fb4a.admin_activity.views.PageActivityInsightsWithUniButtonCardView;
import com.facebook.pages.fb4a.admin_activity.views.PageActivityLAUpsellCardView;
import com.facebook.pages.fb4a.admin_activity.views.PageAdminPrimaryLinksCardView;
import com.facebook.pages.fb4a.admin_activity.views.PageAdminSecondaryLinksCardView;
import com.facebook.pages.fb4a.admin_activity.views.PageAdminUpsellCardView;
import com.facebook.pages.fb4a.admin_activity.views.PageIdentityLinkView;
import com.facebook.pages.fb4a.admintabs.PageIdentityAdminTabsView;
import com.facebook.pages.identity.fragments.surface.PagesSurfaceFragment;
import com.facebook.pages.identity.fragments.surface.PagesSurfaceFragment.C05581;
import com.facebook.reaction.ui.recyclerview.ReactionHeaderTouchDelegateView;
import com.facebook.reaction.ui.recyclerview.ReactionHeaderViewWithTouchDelegate;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.ui.futures.TasksManager;
import com.facebook.widget.ScrollingAwareScrollView;
import com.facebook.widget.ScrollingAwareScrollView.OnScrollListener;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Callable;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: reactVpvEvent */
public class PageActivityFragment extends FbFragment implements PagesSurfaceTabFragment {
    public static final int[] aL = new int[2];
    @Inject
    Lazy<FbUriIntentHandler> f2758a;
    private UpdateViewListener aA = new UpdateViewListener(this);
    public boolean aB = true;
    private boolean aC;
    public ReactionHeaderTouchDelegateView aD;
    private ReactionHeaderViewWithTouchDelegate aE;
    public View aF;
    public PagesSurfaceFragment aG;
    private boolean aH = false;
    public int aI;
    private int aJ;
    private int aK = -1;
    public boolean aM = false;
    public boolean aN = false;
    private final PagesActivityDataChangeEventSubscriber aO = new C03641(this);
    @Inject
    PageAdminUtils al;
    @Inject
    ScreenUtil am;
    @Inject
    PagesExperimentUtils an;
    @Inject
    GatekeeperStoreImpl ao;
    public ScrollingAwareScrollView ap;
    private PageAdminPrimaryLinksCardView aq;
    private PageAdminSecondaryLinksCardView ar;
    private PageIdentityLinkView as;
    private PageAdminUpsellCardView at;
    private PageActivityLAUpsellCardView au;
    private LinearLayout av;
    private boolean aw;
    public ImmutableList<String> ax;
    public long ay;
    public FetchPageActivityQueryModel az;
    @Inject
    TasksManager f2759b;
    @Inject
    PageActivityInsightsUniController f2760c;
    @Inject
    PageEventBus f2761d;
    @Inject
    Context f2762e;
    @Inject
    DefaultAppChoreographer f2763f;
    @Inject
    GraphQLQueryExecutor f2764g;
    @Inject
    Lazy<PagesAnalytics> f2765h;
    @Inject
    Lazy<InterstitialManager> f2766i;

    /* compiled from: reactVpvEvent */
    class C03641 extends PagesActivityDataChangeEventSubscriber {
        final /* synthetic */ PageActivityFragment f2751a;

        C03641(PageActivityFragment pageActivityFragment) {
            this.f2751a = pageActivityFragment;
        }

        public final void m3737b(FbEvent fbEvent) {
            if (this.f2751a.z()) {
                PageActivityFragment.at(this.f2751a);
            } else {
                this.f2751a.aB = true;
            }
        }
    }

    /* compiled from: reactVpvEvent */
    class C03652 implements OnScrollListener {
        final /* synthetic */ PageActivityFragment f2752a;

        C03652(PageActivityFragment pageActivityFragment) {
            this.f2752a = pageActivityFragment;
        }

        public final void m3738a(int i, int i2) {
            if (this.f2752a.aD != null && (!this.f2752a.aM || this.f2752a.aN)) {
                Pair a = PagesScrollUtils.a(this.f2752a.aF, this.f2752a.ap, i < this.f2752a.aD.getMeasuredHeight() ? 0 : 1, PageActivityFragment.aL, this.f2752a.am.d());
                this.f2752a.aM = ((Boolean) a.a).booleanValue();
                if (this.f2752a.aM) {
                    this.f2752a.E_(((Integer) a.b).intValue());
                    this.f2752a.aN = false;
                }
            }
            if (this.f2752a.aI != i && this.f2752a.aG != null && this.f2752a.aD != null && this.f2752a.D()) {
                if (i < this.f2752a.aD.getMeasuredHeight()) {
                    this.f2752a.aG.m5039a(this.f2752a.ap, 0);
                } else {
                    this.f2752a.aG.m5039a(this.f2752a.ap, 1);
                }
                this.f2752a.aI = i;
            }
        }
    }

    /* compiled from: reactVpvEvent */
    class C03663 implements Runnable {
        final /* synthetic */ PageActivityFragment f2753a;

        C03663(PageActivityFragment pageActivityFragment) {
            this.f2753a = pageActivityFragment;
        }

        public void run() {
            if (this.f2753a.aB) {
                PageActivityFragment.at(this.f2753a);
            }
        }
    }

    /* compiled from: reactVpvEvent */
    class C03674 implements OnClickListener {
        final /* synthetic */ PageActivityFragment f2754a;

        C03674(PageActivityFragment pageActivityFragment) {
            this.f2754a = pageActivityFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1987525357);
            ((PagesAnalytics) this.f2754a.f2765h.get()).b(this.f2754a.ay, true);
            String a2 = StringFormatUtil.a(FBLinks.an, new Object[]{Long.valueOf(this.f2754a.ay)});
            Bundle bundle = new Bundle();
            bundle.putLong("com.facebook.katana.profile.id", this.f2754a.ay);
            ((FbUriIntentHandler) this.f2754a.f2758a.get()).a(this.f2754a.getContext(), a2, bundle);
            Logger.a(2, EntryType.UI_INPUT_END, 630210703, a);
        }
    }

    /* compiled from: reactVpvEvent */
    class C03685 implements Callable<ListenableFuture<GraphQLResult<FetchPageActivityQueryModel>>> {
        final /* synthetic */ PageActivityFragment f2755a;

        C03685(PageActivityFragment pageActivityFragment) {
            this.f2755a = pageActivityFragment;
        }

        public Object call() {
            return this.f2755a.f2764g.a(GraphQLRequest.a((FetchPageActivityQueryString) FetchPageActivityGraphQL.m2688a().a("page_id", String.valueOf(this.f2755a.ay))));
        }
    }

    /* compiled from: reactVpvEvent */
    class C03696 extends AbstractDisposableFutureCallback<GraphQLResult<FetchPageActivityQueryModel>> {
        final /* synthetic */ PageActivityFragment f2756a;

        C03696(PageActivityFragment pageActivityFragment) {
            this.f2756a = pageActivityFragment;
        }

        protected final void m3739a(Object obj) {
            FetchPageActivityQueryModel fetchPageActivityQueryModel;
            GraphQLResult graphQLResult = (GraphQLResult) obj;
            PageActivityFragment pageActivityFragment = this.f2756a;
            if (graphQLResult == null) {
                fetchPageActivityQueryModel = null;
            } else {
                fetchPageActivityQueryModel = (FetchPageActivityQueryModel) graphQLResult.e;
            }
            pageActivityFragment.az = fetchPageActivityQueryModel;
            PageActivityFragment.as(this.f2756a);
            this.f2756a.aB = false;
            this.f2756a.aN = true;
        }

        protected final void m3740a(Throwable th) {
        }
    }

    /* compiled from: reactVpvEvent */
    public class UpdateViewListener {
        final /* synthetic */ PageActivityFragment f2757a;

        public UpdateViewListener(PageActivityFragment pageActivityFragment) {
            this.f2757a = pageActivityFragment;
        }

        public final void m3741a() {
            this.f2757a.aB = true;
        }
    }

    public static void m3743a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((PageActivityFragment) obj).m3742a(IdBasedSingletonScopeProvider.b(fbInjector, 616), TasksManager.b(fbInjector), PageActivityInsightsUniController.m3772a(fbInjector), PageEventBus.m2423a(fbInjector), (Context) fbInjector.getInstance(Context.class), DefaultAppChoreographer.a(fbInjector), GraphQLQueryExecutor.a(fbInjector), IdBasedSingletonScopeProvider.b(fbInjector, 8930), IdBasedSingletonScopeProvider.b(fbInjector, 2360), PageAdminUtils.a(fbInjector), ScreenUtil.a(fbInjector), PagesExperimentUtils.a(fbInjector), GatekeeperStoreImplMethodAutoProvider.a(fbInjector));
    }

    private void m3742a(Lazy<FbUriIntentHandler> lazy, TasksManager tasksManager, PageActivityInsightsUniController pageActivityInsightsUniController, PageEventBus pageEventBus, Context context, AppChoreographer appChoreographer, GraphQLQueryExecutor graphQLQueryExecutor, Lazy<PagesAnalytics> lazy2, Lazy<InterstitialManager> lazy3, PageAdminUtils pageAdminUtils, ScreenUtil screenUtil, PagesExperimentUtils pagesExperimentUtils, GatekeeperStore gatekeeperStore) {
        this.f2758a = lazy;
        this.f2759b = tasksManager;
        this.f2760c = pageActivityInsightsUniController;
        this.f2761d = pageEventBus;
        this.f2762e = context;
        this.f2763f = appChoreographer;
        this.f2764g = graphQLQueryExecutor;
        this.f2765h = lazy2;
        this.f2766i = lazy3;
        this.al = pageAdminUtils;
        this.am = screenUtil;
        this.an = pagesExperimentUtils;
        this.ao = gatekeeperStore;
    }

    public final void m3754c(@Nullable Bundle bundle) {
        super.c(bundle);
        Class cls = PageActivityFragment.class;
        m3743a((Object) this, getContext());
        this.aw = this.ao.a(PagesCommonAbTestGatekeepers.a, false);
        this.ay = this.s.getLong("com.facebook.katana.profile.id", -1);
        Preconditions.checkArgument(this.ay > 0, "Invalid page id: " + this.ay);
        if (bundle != null && bundle.containsKey("extra_viewer_profile_permissions")) {
            this.ax = ImmutableList.copyOf(bundle.getStringArrayList("extra_viewer_profile_permissions"));
        }
        this.aH = this.s.getBoolean("extra_is_inside_page_surface_tab", false);
        this.f2761d.a(this.aO);
    }

    public final void m3749a(View view, @Nullable Bundle bundle) {
        super.a(view, bundle);
        this.ap.a(new C03652(this));
        if (this.aH) {
            this.ap.setVerticalScrollBarEnabled(false);
            this.av.setPadding(0, 0, 0, 0);
        }
        aw();
        D_(this.aJ);
    }

    public final View m3748a(LayoutInflater layoutInflater, ViewGroup viewGroup, @Nullable Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1863682652);
        super.a(layoutInflater, viewGroup, bundle);
        this.ap = (ScrollingAwareScrollView) layoutInflater.inflate(2130904438, viewGroup, false);
        this.aq = (PageAdminPrimaryLinksCardView) this.ap.findViewById(2131562197);
        this.as = (PageIdentityLinkView) this.ap.findViewById(2131562198);
        this.ar = (PageAdminSecondaryLinksCardView) this.ap.findViewById(2131562199);
        this.at = (PageAdminUpsellCardView) this.ap.findViewById(2131562200);
        this.au = (PageActivityLAUpsellCardView) this.ap.findViewById(2131562201);
        this.av = (LinearLayout) this.ap.findViewById(2131562195);
        PageActivityInsightsUniController pageActivityInsightsUniController = this.f2760c;
        LinearLayout linearLayout = this.av;
        Activity ao = ao();
        pageActivityInsightsUniController.f2788e = linearLayout;
        pageActivityInsightsUniController.f2791h = ao;
        this.aF = FindViewUtil.b(this.ap, 2131559242);
        E_(this.aK);
        aq();
        if (!this.aB) {
            as(this);
        }
        ScrollingAwareScrollView scrollingAwareScrollView = this.ap;
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 147314244, a);
        return scrollingAwareScrollView;
    }

    public final void m3745G() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1718070796);
        super.G();
        this.f2760c.m3777a();
        E_(this.aK);
        if (m3744e()) {
            at(this);
        } else if (this.aB) {
            long activityBadgeCount;
            PageIdentityAdminTabsView pageIdentityAdminTabsView = (PageIdentityAdminTabsView) a(PageIdentityAdminTabsView.class);
            if (pageIdentityAdminTabsView != null) {
                activityBadgeCount = pageIdentityAdminTabsView.getActivityBadgeCount();
            } else {
                activityBadgeCount = 0;
            }
            if (activityBadgeCount > 0 || YearClass.a(this.f2762e) >= 2012) {
                this.f2763f.a("Preloading Page Activity tab", new C03663(this), Priority.APPLICATION_LOADED_UI_IDLE, ThreadType.UI);
            }
        }
        LogUtils.f(-1597337754, a);
    }

    public final void m3746H() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -669576934);
        super.H();
        this.f2759b.c();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1521790599, a);
    }

    public final void m3755e(Bundle bundle) {
        if (this.ax != null) {
            bundle.putStringArrayList("extra_viewer_profile_permissions", Lists.a(this.ax));
        }
    }

    public final void m3756g(boolean z) {
        super.g(z);
        this.aC = z;
        if (m3744e() && this.f2759b != null) {
            at(this);
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        PageActivityInsightsUniController pageActivityInsightsUniController = this.f2760c;
        if (pageActivityInsightsUniController.f2789f instanceof PageActivityInsightsWithUniButtonCardView) {
            ((PageActivityInsightsWithUniButtonCardView) pageActivityInsightsUniController.f2789f).onConfigurationChanged(configuration);
        }
    }

    public final void m3753a(ImmutableList<String> immutableList) {
        this.ax = immutableList;
        aq();
    }

    private boolean m3744e() {
        return this.aB && this.aC;
    }

    private void aq() {
        if (this.aq != null) {
            ActivityAdminInfoModel j;
            PageAdminPrimaryLinksCardView pageAdminPrimaryLinksCardView = this.aq;
            long j2 = this.ay;
            if (this.az != null) {
                j = this.az.m2781j();
            } else {
                j = null;
            }
            pageAdminPrimaryLinksCardView.m3835a(j2, j, Optional.of(this.aA), PageAdminUtils.a(this.ax));
        }
        if (this.at != null) {
            this.at.m3851a(this.ay, this.ax);
        }
    }

    public final void m3747I() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -395403020);
        super.I();
        this.f2761d.b(this.aO);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 2002739853, a);
    }

    public final void mY_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 280928183);
        super.mY_();
        this.f2760c.m3779b();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1541034349, a);
    }

    public static void as(PageActivityFragment pageActivityFragment) {
        int i = 1;
        if (pageActivityFragment.az != null) {
            int i2;
            int a;
            int i3;
            ActivityAdminInfoModel j = pageActivityFragment.az.m2781j();
            if (pageActivityFragment.az.m2783l() == null || pageActivityFragment.az.m2783l().m3705a() == null || pageActivityFragment.az.m2783l().m3705a().m3701a() == null) {
                i2 = 0;
            } else {
                i2 = pageActivityFragment.az.m2783l().m3705a().m3701a().m3688a();
            }
            if (pageActivityFragment.az.m2785n() != null) {
                a = pageActivityFragment.az.m2785n().m3709a();
            } else {
                a = 0;
            }
            if (pageActivityFragment.az.m2783l() == null || pageActivityFragment.az.m2783l().m3705a() == null || pageActivityFragment.az.m2783l().m3705a().m3702j() == null) {
                i3 = 0;
            } else {
                i3 = pageActivityFragment.az.m2783l().m3705a().m3702j().m3694a();
            }
            pageActivityFragment.aq.m3834a(a, i3);
            pageActivityFragment.aq.m3837b(j);
            pageActivityFragment.aq.m3836a(j);
            if (pageActivityFragment.au != null) {
                if (j == null || !j.m2751l()) {
                    pageActivityFragment.au.setVisibility(8);
                } else {
                    GraphQLBoostedComponentStatus graphQLBoostedComponentStatus = null;
                    if (!(j.m2750k() == null || j.m2750k().m2710a() == null || j.m2750k().m2710a().isEmpty())) {
                        graphQLBoostedComponentStatus = ((NodesModel) j.m2750k().m2710a().get(0)).m2705a();
                    }
                    pageActivityFragment.au.setVisibility(0);
                    pageActivityFragment.au.m3810a(pageActivityFragment.ay, graphQLBoostedComponentStatus);
                    pageActivityFragment.au.setPromoteLabel(j.m2749j());
                }
            }
            i2 += i3;
            PageIdentityAdminTabsView pageIdentityAdminTabsView = (PageIdentityAdminTabsView) pageActivityFragment.a(PageIdentityAdminTabsView.class);
            if (pageIdentityAdminTabsView != null) {
                pageIdentityAdminTabsView.setActivityBadgeCount((long) i2);
            }
            if (pageActivityFragment.az.m2784m() == null || pageActivityFragment.az.m2784m().m2771j() != GraphQLPageCallToActionType.CONTACT_US || pageActivityFragment.az.m2784m().m2770a() == null) {
                a = 0;
            } else {
                a = 1;
            }
            boolean a2 = new ProfilePermissions(pageActivityFragment.ax).a(Permission.MODERATE_CONTENT);
            if (j == null || j.m2752m() == null || j.m2752m().m2725a() <= 0) {
                i = 0;
            }
            if (pageActivityFragment.aw && a2 && !(r0 == 0 && r4 == 0)) {
                pageActivityFragment.as.setOnClickListener(new C03674(pageActivityFragment));
                pageActivityFragment.as.setVisibility(0);
            }
            pageActivityFragment.f2760c.m3778a(pageActivityFragment.ay, j, Optional.of(pageActivityFragment.aA));
            if (pageActivityFragment.ar != null) {
                Object obj = null;
                if (!(pageActivityFragment.az == null || pageActivityFragment.az.m2782k() == null || pageActivityFragment.az.m2782k().isEmpty())) {
                    obj = 1;
                }
                if (obj != null) {
                    pageActivityFragment.ar.setVisibility(0);
                    pageActivityFragment.ar.m3843a(pageActivityFragment.ay, pageActivityFragment.az.m2782k(), Optional.of(pageActivityFragment.aA));
                    if (pageActivityFragment.aC) {
                        pageActivityFragment.ar.m3844b();
                        return;
                    }
                    return;
                }
                pageActivityFragment.ar.setVisibility(8);
                pageActivityFragment.ar.m3842a();
            }
        }
    }

    public static void at(PageActivityFragment pageActivityFragment) {
        pageActivityFragment.f2759b.a(PagesAsyncTaskType.FETCH_PAGE_IDENTITY_ACTIVITY_DATA, new C03685(pageActivityFragment), new C03696(pageActivityFragment));
    }

    public final void m3751a(PagesSurfaceFragment pagesSurfaceFragment) {
        this.aG = pagesSurfaceFragment;
    }

    public final void m3757j() {
        at(this);
    }

    public final void m3752a(ReactionHeaderViewWithTouchDelegate reactionHeaderViewWithTouchDelegate) {
        this.aE = reactionHeaderViewWithTouchDelegate;
        aw();
    }

    private void aw() {
        if (this.aE != null && this.av != null) {
            if (this.aD != null) {
                this.av.removeView(this.aD);
            }
            this.aD = new ReactionHeaderTouchDelegateView(this.aE);
            this.aD.c = true;
            this.av.addView(this.aD, 0);
            this.aE.a(this.aD);
            this.ap.setBackgroundResource(0);
            this.av.setBackgroundResource(0);
        }
    }

    public final void D_(int i) {
        this.aJ = i;
        PagesScrollUtils.a(this.ap, this.aJ);
    }

    public final void E_(int i) {
        if (this.aK < 0 || i <= this.aK) {
            this.aK = i;
            if (this.aF != null) {
                this.aF.setLayoutParams(new LayoutParams(-1, this.aK));
            }
        }
    }

    public final void m3750a(C05581 c05581) {
    }
}
