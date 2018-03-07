package com.facebook.backstage.consumption;

import android.annotation.TargetApi;
import com.facebook.backstage.StacksConstants;
import com.facebook.backstage.analytics.BackstageAnalyticsLogger.Event;
import com.facebook.backstage.camera.CameraHolder;
import com.facebook.backstage.consumption.BackstageFragment.C04323;
import com.facebook.backstage.consumption.BackstageFragment.FragmentActionListener;
import com.facebook.backstage.consumption.BackstageNavigatorApi.Action;
import com.facebook.backstage.consumption.BackstageNavigatorApi.NavigationState;
import com.facebook.backstage.consumption.audience.PrivacySettingsView;
import com.facebook.backstage.consumption.camera.CameraFlowLauncher;
import com.facebook.backstage.consumption.camera.CameraOptions;
import com.facebook.backstage.consumption.importflow.ImportFlowGridView;
import com.facebook.backstage.consumption.importflow.ImportFlowLauncher;
import com.facebook.backstage.consumption.nux.BackstageNuxView;
import com.facebook.backstage.consumption.nux.BackstageNuxView.NuxState;
import com.facebook.backstage.consumption.nux.BackstageNuxViewHolder;
import com.facebook.backstage.consumption.nux.BackstageOnboardNuxHelper;
import com.facebook.backstage.consumption.nux.BackstageOnboardNuxHelper.C05001;
import com.facebook.backstage.consumption.reply.BackstageReplyThreadSummaryListView;
import com.facebook.backstage.consumption.reply.ReplyDataProvider;
import com.facebook.backstage.ui.LazyView;
import com.facebook.inject.Assisted;
import com.facebook.runtimepermissions.ActivityRuntimePermissionsManager;
import com.google.common.collect.RegularImmutableList;
import javax.inject.Inject;

@TargetApi(16)
/* compiled from: saved_collection_id */
public class BackstageNavigatorImpl {
    private static final String f4525a = BackstageNavigatorImpl.class.getSimpleName();
    public final C04391 f4526b = new C04391(this);
    public final BackstageNavigatorApi f4527c = BackstageNavigatorApi.m4489a();
    public final BackstageOnboardNuxHelper f4528d;
    private final ProfilesDataProvider f4529e;
    private final ReplyDataProvider f4530f;
    private final ImportFlowLauncher f4531g;
    public final BackstageGridView f4532h;
    private final BackstageActivityButton f4533i;
    private final LazyView<ImportFlowGridView> f4534j;
    private final LazyView<BackstageReplyThreadSummaryListView> f4535k;
    public final LazyView<PrivacySettingsView> f4536l;
    private final CameraHolder f4537m;
    private final CameraFlowLauncher f4538n;
    private final StatusBarColorChanger f4539o;
    private final ActivityRuntimePermissionsManager f4540p;
    private final C04323 f4541q;
    public final BackstageNuxViewHolder f4542r;

    /* compiled from: saved_collection_id */
    public class C04391 {
        public final /* synthetic */ BackstageNavigatorImpl f4523a;

        C04391(BackstageNavigatorImpl backstageNavigatorImpl) {
            this.f4523a = backstageNavigatorImpl;
        }
    }

    @Inject
    public BackstageNavigatorImpl(ReplyDataProvider replyDataProvider, ProfilesDataProvider profilesDataProvider, BackstageOnboardNuxHelper backstageOnboardNuxHelper, ImportFlowLauncher importFlowLauncher, @Assisted BackstageGridView backstageGridView, @Assisted BackstageActivityButton backstageActivityButton, @Assisted LazyView<ImportFlowGridView> lazyView, @Assisted LazyView<BackstageReplyThreadSummaryListView> lazyView2, @Assisted LazyView<PrivacySettingsView> lazyView3, @Assisted CameraHolder cameraHolder, @Assisted CameraFlowLauncher cameraFlowLauncher, @Assisted StatusBarColorChanger statusBarColorChanger, @Assisted BackstageNuxViewHolder backstageNuxViewHolder, @Assisted ActivityRuntimePermissionsManager activityRuntimePermissionsManager, @Assisted FragmentActionListener fragmentActionListener) {
        this.f4529e = profilesDataProvider;
        this.f4530f = replyDataProvider;
        this.f4528d = backstageOnboardNuxHelper;
        this.f4531g = importFlowLauncher;
        this.f4532h = backstageGridView;
        this.f4533i = backstageActivityButton;
        this.f4534j = lazyView;
        this.f4535k = lazyView2;
        this.f4536l = lazyView3;
        this.f4537m = cameraHolder;
        this.f4538n = cameraFlowLauncher;
        this.f4539o = statusBarColorChanger;
        this.f4542r = backstageNuxViewHolder;
        this.f4540p = activityRuntimePermissionsManager;
        this.f4541q = fragmentActionListener;
    }

    public static void m4495a(BackstageNavigatorImpl backstageNavigatorImpl, NavigationState navigationState, NavigationState navigationState2, Action action) {
        navigationState.name();
        navigationState2.name();
        action.name();
        switch (navigationState2) {
            case NUX:
                backstageNavigatorImpl.m4500i();
                BackstageOnboardNuxHelper backstageOnboardNuxHelper = backstageNavigatorImpl.f4528d;
                BackstageNavigatorApi backstageNavigatorApi = backstageNavigatorImpl.f4527c;
                BackstageNuxView c = backstageNavigatorImpl.f4542r.m4731c();
                c.f4846i = new C05001(backstageOnboardNuxHelper, backstageNavigatorApi);
                c.f4845h = NuxState.FIRST_PANEL;
                c.f4840c.setVisibility(0);
                c.f4841d.setVisibility(8);
                c.setVisibility(0);
                c.f4839b.m4264a(Event.NUX_START);
                return;
            case MAIN_LIST:
                boolean z = navigationState == NavigationState.AUDIENCE_CONTROL || action == Action.REFRESH;
                backstageNavigatorImpl.m4497a(z);
                return;
            case TEXT_ONLY:
                backstageNavigatorImpl.m4496a(CameraOptions.m4602a());
                return;
            case CAMERA:
                if (navigationState == NavigationState.MAIN_LIST) {
                    backstageNavigatorImpl.m4500i();
                }
                backstageNavigatorImpl.m4496a(CameraOptions.m4604b());
                return;
            case IMPORT:
                backstageNavigatorImpl.f4532h.m4485c();
                if (navigationState == NavigationState.COLD_START) {
                    backstageNavigatorImpl.m4500i();
                }
                backstageNavigatorImpl.m4499g();
                return;
            case AUDIENCE_CONTROL:
                ((PrivacySettingsView) backstageNavigatorImpl.f4536l.m5715a()).m4596a();
                return;
            case REPLY:
                backstageNavigatorImpl.m4498e();
                return;
            default:
                throw new UnsupportedOperationException("Invalid from : " + navigationState + " and to " + navigationState2);
        }
    }

    private void m4498e() {
        ReplyDataProvider replyDataProvider = this.f4530f;
        replyDataProvider.f4962h.edit().a(StacksConstants.f4258h, replyDataProvider.f4963i.a()).commit();
        this.f4533i.m4457a();
        ((BackstageReplyThreadSummaryListView) this.f4535k.m5715a()).m4765a(this.f4527c, this.f4539o);
    }

    private void m4499g() {
        this.f4531g.m4648a(this.f4540p, this.f4527c, this.f4539o, this.f4534j, this.f4532h.getImportButton());
    }

    private void m4496a(CameraOptions cameraOptions) {
        this.f4538n.m4601a(this.f4537m, cameraOptions, null);
    }

    private void m4497a(boolean z) {
        if (z) {
            this.f4532h.setRefreshing(true);
            this.f4529e.m4545a(z);
        } else if (this.f4532h.m4484b()) {
            this.f4532h.setRefreshing(true);
            this.f4529e.m4545a(z);
        }
    }

    private void m4500i() {
        this.f4532h.m4482a(RegularImmutableList.a, RegularImmutableList.a, this.f4541q, false);
    }
}
