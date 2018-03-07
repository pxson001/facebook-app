package com.facebook.backstage.consumption;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewStub;
import com.facebook.backstage.StacksConstants;
import com.facebook.backstage.analytics.BackstageAnalyticsLogger;
import com.facebook.backstage.analytics.BackstageAnalyticsLogger.Event;
import com.facebook.backstage.camera.CameraHolder;
import com.facebook.backstage.camera.CameraHolderProvider;
import com.facebook.backstage.consumption.BackstageNavigatorApi.NavigationState;
import com.facebook.backstage.consumption.ProfilesDataProvider.BackstageProfileObserver;
import com.facebook.backstage.consumption.audience.HideFriendAlertDialogHelper;
import com.facebook.backstage.consumption.audience.HideFriendAlertDialogHelper.C04651;
import com.facebook.backstage.consumption.audience.HideFriendAlertDialogHelper.C04662;
import com.facebook.backstage.consumption.audience.PrivacySettingsView;
import com.facebook.backstage.consumption.camera.CameraFlowLauncher;
import com.facebook.backstage.consumption.camera.CameraFlowLauncherProvider;
import com.facebook.backstage.consumption.importflow.ImportFlowDataProvider;
import com.facebook.backstage.consumption.importflow.ImportFlowDataProvider.CallBack;
import com.facebook.backstage.consumption.importflow.ImportFlowGridView;
import com.facebook.backstage.consumption.importflow.ImportMedia;
import com.facebook.backstage.consumption.nux.BackstageNuxView;
import com.facebook.backstage.consumption.nux.BackstageNuxView.NuxState;
import com.facebook.backstage.consumption.nux.BackstageNuxViewHolder;
import com.facebook.backstage.consumption.nux.BackstageOnboardNuxHelper;
import com.facebook.backstage.consumption.reply.BackstageReplyThreadSummaryListView;
import com.facebook.backstage.consumption.reply.ReplyDataProvider;
import com.facebook.backstage.consumption.reply.ReplyDataProvider.ReplyThreadSummaryListObserver;
import com.facebook.backstage.consumption.stack.BackstageStoryModeView;
import com.facebook.backstage.data.BackstageProfile;
import com.facebook.backstage.data.ReplyThreadSummary;
import com.facebook.backstage.entry.BackstageOnboardInterstitialController;
import com.facebook.backstage.graphql.AudienceControlMutationHelper;
import com.facebook.backstage.graphql.BackstageBadgeCountGraphQLHelper;
import com.facebook.backstage.graphql.BackstageBadgeCountGraphQLHelper.C05562;
import com.facebook.backstage.graphql.FBBackstageMutationFragments.FBBackstageClearBadgeMutationString;
import com.facebook.backstage.ui.LazyView;
import com.facebook.backstage.ui.LazyView.OnInflateRunner;
import com.facebook.backstage.ui.ViewAnimator;
import com.facebook.backstage.util.LocaleNameUtil;
import com.facebook.common.identifiers.SafeUUIDGenerator;
import com.facebook.common.util.StringLocaleUtil;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.fbui.dialog.AlertDialog.Builder;
import com.facebook.fbui.glyph.GlyphView;
import com.facebook.graphql.calls.BackstageSpaceUpdateSeenTimeInputData;
import com.facebook.graphql.calls.GraphQlCallInput;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectorLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.notifications.common.JewelCounters;
import com.facebook.notifications.common.JewelCounters.Jewel;
import com.facebook.notifications.common.JewelCounters.OnJewelCountChangeListener;
import com.facebook.runtimepermissions.ActivityRuntimePermissionsManagerProvider;
import com.facebook.runtimepermissions.RuntimePermissionsUtil;
import com.facebook.ui.drawers.DrawerContentFragment;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.Futures;
import javax.inject.Inject;

@TargetApi(16)
/* compiled from: scrollPerfTag */
public class BackstageFragment extends DrawerContentFragment {
    public static final String f4496a = BackstageFragment.class.getSimpleName();
    private LazyView<BackstageReplyThreadSummaryListView> aA;
    private LazyView<PrivacySettingsView> aB;
    private BackstageNuxViewHolder aC;
    public BackstageActivityButton aD;
    private GlyphView aE;
    private View aF;
    public CameraHolder aG;
    public OnClickListener aH;
    public CameraFlowLauncher aI;
    @Inject
    public AudienceControlMutationHelper al;
    @Inject
    CameraHolderProvider am;
    @Inject
    BackstageNavigatorImplProvider an;
    private final BackstageProfileObserver ao = new C04291(this);
    private final OnJewelCountChangeListener ap = new C04302(this);
    public final C04323 aq = new C04323(this);
    private final CallBack ar = new C04334(this);
    private final ReplyThreadSummaryListObserver as = new C04345(this);
    private final BackstageLifeCycleHelper at = new BackstageLifeCycleHelper();
    public final BackstageNavigatorApi au = BackstageNavigatorApi.m4489a();
    public final HideFriendAlertDialogHelper av = new HideFriendAlertDialogHelper(this.aq);
    private BackstageNavigatorImpl aw;
    public BackstageGridView ax;
    public LazyView<BackstageStoryModeView> ay;
    private LazyView<ImportFlowGridView> az;
    @Inject
    JewelCounters f4497b;
    @Inject
    BackstageBadgeCountGraphQLHelper f4498c;
    @Inject
    BackstageAnalyticsLogger f4499d;
    @Inject
    ProfilesDataProvider f4500e;
    @Inject
    ActivityRuntimePermissionsManagerProvider f4501f;
    @Inject
    CameraFlowLauncherProvider f4502g;
    @Inject
    ImportFlowDataProvider f4503h;
    @Inject
    ReplyDataProvider f4504i;

    /* compiled from: scrollPerfTag */
    class C04291 implements BackstageProfileObserver {
        final /* synthetic */ BackstageFragment f4486a;

        C04291(BackstageFragment backstageFragment) {
            this.f4486a = backstageFragment;
        }

        public final void mo151a(ImmutableList<BackstageProfile> immutableList, ImmutableList<BackstageProfile> immutableList2) {
            this.f4486a.ax.m4482a(immutableList, immutableList2, this.f4486a.aq, true);
            this.f4486a.ax.setRefreshing(false);
        }
    }

    /* compiled from: scrollPerfTag */
    class C04302 extends OnJewelCountChangeListener {
        final /* synthetic */ BackstageFragment f4487a;

        C04302(BackstageFragment backstageFragment) {
            this.f4487a = backstageFragment;
        }

        public final void m4460a(Jewel jewel, int i) {
            if (jewel == Jewel.BACKSTAGE) {
                this.f4487a.f4500e.m4545a(true);
            }
        }
    }

    /* compiled from: scrollPerfTag */
    public class C04323 {
        public final /* synthetic */ BackstageFragment f4489a;

        /* compiled from: scrollPerfTag */
        public class C04311 implements AudienceControlMutationHelper.CallBack {
            final /* synthetic */ C04323 f4488a;

            public C04311(C04323 c04323) {
                this.f4488a = c04323;
            }

            public final void mo152a() {
                this.f4488a.f4489a.ax.setRefreshing(false);
                this.f4488a.f4489a.f4500e.m4545a(true);
            }
        }

        C04323(BackstageFragment backstageFragment) {
            this.f4489a = backstageFragment;
        }

        public final void m4463a(BackstageProfile backstageProfile) {
            Object obj;
            if (backstageProfile.f5117f.isEmpty()) {
                obj = null;
            } else {
                obj = 1;
            }
            if (obj != null) {
                ((BackstageStoryModeView) this.f4489a.ay.m5715a()).m4847a(this.f4489a.aG, this.f4489a.aI);
                ((BackstageStoryModeView) this.f4489a.ay.m5715a()).m4848a(backstageProfile);
            }
        }

        public final void m4464b(BackstageProfile backstageProfile) {
            HideFriendAlertDialogHelper hideFriendAlertDialogHelper = this.f4489a.av;
            Context context = this.f4489a.getContext();
            String d = backstageProfile.m4899d();
            String str = backstageProfile.f5112a;
            if (hideFriendAlertDialogHelper.f4668b == null) {
                Builder builder = new Builder(context);
                builder.b(context.getResources().getString(2131237528), new C04662(hideFriendAlertDialogHelper));
                hideFriendAlertDialogHelper.f4668b = builder.a();
            }
            hideFriendAlertDialogHelper.f4668b.a(StringLocaleUtil.a(context.getResources().getString(2131239941), new Object[]{LocaleNameUtil.m5776a(d)}));
            hideFriendAlertDialogHelper.f4668b.a(-1, context.getResources().getString(2131239940), new C04651(hideFriendAlertDialogHelper, str));
            hideFriendAlertDialogHelper.f4668b.show();
        }
    }

    /* compiled from: scrollPerfTag */
    class C04334 implements CallBack {
        final /* synthetic */ BackstageFragment f4490a;

        C04334(BackstageFragment backstageFragment) {
            this.f4490a = backstageFragment;
        }

        public final void mo153a(@Nullable ImmutableList<ImportMedia> immutableList) {
            this.f4490a.ax.m4481a(immutableList.size());
        }
    }

    /* compiled from: scrollPerfTag */
    class C04345 implements ReplyThreadSummaryListObserver {
        final /* synthetic */ BackstageFragment f4491a;

        C04345(BackstageFragment backstageFragment) {
            this.f4491a = backstageFragment;
        }

        public final void mo154a(ImmutableList<ReplyThreadSummary> immutableList) {
            int size = immutableList.size();
            int i = 0;
            int i2 = 0;
            while (i < size) {
                int i3;
                if (((ReplyThreadSummary) immutableList.get(i)).f5143e.getTime() >= this.f4491a.f4504i.f4962h.a(StacksConstants.f4258h, 0)) {
                    i3 = i2 + 1;
                } else {
                    i3 = i2;
                }
                i++;
                i2 = i3;
            }
            this.f4491a.aD.setBadgeCounter(i2);
        }
    }

    /* compiled from: scrollPerfTag */
    class C04356 implements OnRefreshListener {
        final /* synthetic */ BackstageFragment f4492a;

        C04356(BackstageFragment backstageFragment) {
            this.f4492a = backstageFragment;
        }

        public final void m4469a() {
            this.f4492a.f4500e.m4545a(true);
            this.f4492a.f4504i.m4805a(true);
        }
    }

    /* compiled from: scrollPerfTag */
    class C04367 implements OnInflateRunner<BackstageReplyThreadSummaryListView> {
        final /* synthetic */ BackstageFragment f4493a;

        C04367(BackstageFragment backstageFragment) {
            this.f4493a = backstageFragment;
        }

        public final void mo137a(View view) {
            ((BackstageReplyThreadSummaryListView) view).m4764a(this.f4493a.aG, this.f4493a.aI);
        }
    }

    /* compiled from: scrollPerfTag */
    class C04378 implements OnClickListener {
        final /* synthetic */ BackstageFragment f4494a;

        C04378(BackstageFragment backstageFragment) {
            this.f4494a = backstageFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -904902852);
            this.f4494a.au.m4492a(NavigationState.MAIN_LIST, NavigationState.AUDIENCE_CONTROL);
            Logger.a(2, EntryType.UI_INPUT_END, 911852575, a);
        }
    }

    /* compiled from: scrollPerfTag */
    class C04389 implements OnClickListener {
        final /* synthetic */ BackstageFragment f4495a;

        C04389(BackstageFragment backstageFragment) {
            this.f4495a = backstageFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1014346445);
            this.f4495a.au.m4492a(NavigationState.MAIN_LIST, NavigationState.REPLY);
            Logger.a(2, EntryType.UI_INPUT_END, 1750026279, a);
        }
    }

    public static void m4472a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((BackstageFragment) obj).m4471a(JewelCounters.a(injectorLike), BackstageBadgeCountGraphQLHelper.m4964b(injectorLike), BackstageAnalyticsLogger.m4259a(injectorLike), ProfilesDataProvider.m4540a(injectorLike), (ActivityRuntimePermissionsManagerProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(ActivityRuntimePermissionsManagerProvider.class), (CameraFlowLauncherProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(CameraFlowLauncherProvider.class), ImportFlowDataProvider.m4619b(injectorLike), ReplyDataProvider.m4801a(injectorLike), AudienceControlMutationHelper.m4962b(injectorLike), (CameraHolderProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(CameraHolderProvider.class), (BackstageNavigatorImplProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(BackstageNavigatorImplProvider.class));
    }

    private void m4471a(JewelCounters jewelCounters, BackstageBadgeCountGraphQLHelper backstageBadgeCountGraphQLHelper, BackstageAnalyticsLogger backstageAnalyticsLogger, ProfilesDataProvider profilesDataProvider, ActivityRuntimePermissionsManagerProvider activityRuntimePermissionsManagerProvider, CameraFlowLauncherProvider cameraFlowLauncherProvider, ImportFlowDataProvider importFlowDataProvider, ReplyDataProvider replyDataProvider, AudienceControlMutationHelper audienceControlMutationHelper, CameraHolderProvider cameraHolderProvider, BackstageNavigatorImplProvider backstageNavigatorImplProvider) {
        this.f4497b = jewelCounters;
        this.f4498c = backstageBadgeCountGraphQLHelper;
        this.f4499d = backstageAnalyticsLogger;
        this.f4500e = profilesDataProvider;
        this.f4501f = activityRuntimePermissionsManagerProvider;
        this.f4502g = cameraFlowLauncherProvider;
        this.f4503h = importFlowDataProvider;
        this.f4504i = replyDataProvider;
        this.al = audienceControlMutationHelper;
        this.am = cameraHolderProvider;
        this.an = backstageNavigatorImplProvider;
    }

    public final View m4475a(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1212131094);
        Class cls = BackstageFragment.class;
        m4472a((Object) this, getContext());
        CameraFlowLauncherProvider cameraFlowLauncherProvider = this.f4502g;
        this.aI = new CameraFlowLauncher(o(), (ActivityRuntimePermissionsManagerProvider) cameraFlowLauncherProvider.getOnDemandAssistedProviderForStaticDi(ActivityRuntimePermissionsManagerProvider.class), (Context) cameraFlowLauncherProvider.getInstance(Context.class), RuntimePermissionsUtil.b(cameraFlowLauncherProvider));
        Fresco.a(getContext());
        View inflate = layoutInflater.inflate(2130903756, null);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1886145096, a);
        return inflate;
    }

    public final void m4476a(View view, @Nullable Bundle bundle) {
        Object obj;
        super.a(view, bundle);
        this.aF = view;
        this.ax = (BackstageGridView) view.findViewById(2131560695);
        this.ax.setOnRefreshListener(new C04356(this));
        this.az = new LazyView((ViewStub) view.findViewById(2131560697));
        this.ay = new LazyView((ViewStub) view.findViewById(2131560696));
        this.aA = new LazyView((ViewStub) view.findViewById(2131560698), new C04367(this));
        this.aB = new LazyView((ViewStub) view.findViewById(2131560699));
        this.aC = new BackstageNuxViewHolder(o(), (ViewGroup) this.aF);
        ((BackstageOptionsView) view.findViewById(2131560694)).setOnClickListener(new C04378(this));
        this.aD = (BackstageActivityButton) view.findViewById(2131560693);
        this.aE = (GlyphView) view.findViewById(2131560692);
        this.aE.setGlyphColor(jW_().getColor(2131361867));
        this.aD.setOnClickListener(new C04389(this));
        BackstageNavigatorApi backstageNavigatorApi = this.au;
        if (backstageNavigatorApi.f4519c == null || backstageNavigatorApi.f4520d == null) {
            obj = null;
        } else {
            obj = 1;
        }
        if (obj == null) {
            if (bundle != null) {
                this.au.m4492a(NavigationState.COLD_START, BackstageNavigatorApi.m4490b(bundle));
            } else {
                this.au.m4492a(NavigationState.COLD_START, NavigationState.MAIN_LIST);
            }
        }
        this.aE.setOnClickListener(this.aH);
        this.aG = CameraHolderProvider.m4323a(o(), (ViewGroup) this.aF, this.at);
        this.aw = this.an.m4501a(this.ax, this.aD, this.az, this.aA, this.aB, this.aG, this.aI, new StatusBarColorChanger(o()), this.aC, this.f4501f.a(o()), this.aq);
    }

    public final void mi_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -534907296);
        super.mi_();
        this.f4497b.a(this.ap);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1484776630, a);
    }

    public final void ar() {
        this.at.m4486a(o());
        this.f4499d.m4262a();
    }

    public final void m4473G() {
        Object obj;
        Object obj2;
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1088424811);
        super.G();
        BackstageNavigatorImpl backstageNavigatorImpl = this.aw;
        if (backstageNavigatorImpl.f4527c.f4521e == NavigationState.COLD_START) {
            obj = 1;
        } else {
            obj = null;
        }
        if (obj != null) {
            BackstageOnboardNuxHelper backstageOnboardNuxHelper = backstageNavigatorImpl.f4528d;
            backstageOnboardNuxHelper.f4855c = (BackstageOnboardInterstitialController) backstageOnboardNuxHelper.f4854b.a("4063", BackstageOnboardInterstitialController.class);
            if (backstageOnboardNuxHelper.f4855c == null || !backstageOnboardNuxHelper.f4855c.m4955e()) {
                obj = null;
            } else {
                obj = 1;
            }
            if (obj != null) {
                obj2 = 1;
                if (obj2 != null) {
                    this.au.m4492a(NavigationState.COLD_START, NavigationState.NUX);
                }
                this.at.m4486a(o());
                this.f4499d.m4262a();
                this.f4500e.m4542a(this.ao);
                this.f4504i.m4804a(this.as);
                this.f4503h.m4621a(this.ar, true);
                backstageNavigatorImpl = this.aw;
                backstageNavigatorImpl.f4527c.m4494a(backstageNavigatorImpl.f4526b);
                Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -60586057, a);
            }
        }
        obj2 = null;
        if (obj2 != null) {
            this.au.m4492a(NavigationState.COLD_START, NavigationState.NUX);
        }
        this.at.m4486a(o());
        this.f4499d.m4262a();
        this.f4500e.m4542a(this.ao);
        this.f4504i.m4804a(this.as);
        this.f4503h.m4621a(this.ar, true);
        backstageNavigatorImpl = this.aw;
        backstageNavigatorImpl.f4527c.m4494a(backstageNavigatorImpl.f4526b);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -60586057, a);
    }

    public final void m4474H() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1067353865);
        this.at.m4488b(o());
        this.f4500e.m4546b(this.ao);
        this.f4504i.m4807b(this.as);
        this.f4499d.m4268b();
        this.aw.f4527c.m4494a(null);
        super.H();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -2058578625, a);
    }

    public final void as() {
        this.at.m4488b(o());
        this.f4499d.m4268b();
        BackstageBadgeCountGraphQLHelper backstageBadgeCountGraphQLHelper = this.f4498c;
        backstageBadgeCountGraphQLHelper.f5205d.a(Jewel.BACKSTAGE, 0);
        GraphQlQueryString fBBackstageClearBadgeMutationString = new FBBackstageClearBadgeMutationString();
        BackstageSpaceUpdateSeenTimeInputData backstageSpaceUpdateSeenTimeInputData = new BackstageSpaceUpdateSeenTimeInputData();
        backstageSpaceUpdateSeenTimeInputData.a("actor_id", (String) backstageBadgeCountGraphQLHelper.f5206e.get());
        GraphQlCallInput graphQlCallInput = backstageSpaceUpdateSeenTimeInputData;
        graphQlCallInput.a("client_mutation_id", SafeUUIDGenerator.a().toString());
        fBBackstageClearBadgeMutationString.a("0", graphQlCallInput);
        Futures.a(backstageBadgeCountGraphQLHelper.f5203b.a(GraphQLRequest.a(fBBackstageClearBadgeMutationString)), new C05562(backstageBadgeCountGraphQLHelper), backstageBadgeCountGraphQLHelper.f5204c);
    }

    public final void mj_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1172668823);
        this.f4497b.b(this.ap);
        super.mj_();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -917453871, a);
    }

    public final void m4477e(Bundle bundle) {
        BackstageNavigatorApi backstageNavigatorApi = this.au;
        if (!(backstageNavigatorApi.f4522f == null || backstageNavigatorApi.f4522f == NavigationState.MAIN_LIST)) {
            bundle.putString("NAVIGATION_RECORDING_KEY", backstageNavigatorApi.f4522f.name());
        }
        super.e(bundle);
    }

    public final boolean aq() {
        Object obj;
        if (this.aC.f4850c != null) {
            obj = 1;
        } else {
            obj = null;
        }
        if (obj != null) {
            BackstageNuxView c = this.aC.m4731c();
            if (c.f4845h == NuxState.SECOND_PANEL) {
                c.f4845h = NuxState.FIRST_PANEL;
                ViewAnimator e = ViewAnimator.m5752a(c.f4840c).m5761e();
                e.f5549z = 0;
                e = e.m5756b(c.f4840c.getX(), 0.0f);
                e.f5524A = 0;
                e.m5759d();
                e = ViewAnimator.m5752a(c.f4841d).m5761e();
                e.f5549z = 0;
                e = e.m5756b(0.0f, (float) c.f4838a.m4551a());
                e.f5524A = 8;
                e.m5759d();
                obj = 1;
            } else {
                c.f4839b.m4264a(Event.NUX_CANCEL);
                obj = null;
            }
            if (obj != null) {
                return true;
            }
        }
        if (this.ax.m4483a()) {
            return true;
        }
        if (this.aG.m4321b() && this.aG.m4322c().m4312a(true)) {
            return true;
        }
        if (this.az.m5716b() && ((ImportFlowGridView) this.az.m5715a()).m4642a()) {
            return true;
        }
        if (this.ay.m5716b() && ((BackstageStoryModeView) this.ay.m5715a()).m4849a()) {
            return true;
        }
        if (this.aA.m5716b() && ((BackstageReplyThreadSummaryListView) this.aA.m5715a()).m4766a()) {
            return true;
        }
        if (this.aB.m5716b() && ((PrivacySettingsView) this.aB.m5715a()).m4597b()) {
            return true;
        }
        return false;
    }
}
