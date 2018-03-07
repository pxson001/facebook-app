package com.facebook.saved.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.base.fragment.FbFragment;
import com.facebook.common.identifiers.SafeUUIDGenerator;
import com.facebook.common.listenermanager.ListenerManager;
import com.facebook.composer.protocol.PostReviewParams;
import com.facebook.graphql.enums.GraphQLSavedDashboardSectionType;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectorLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.saved.analytics.SaveAnalyticsLogger;
import com.facebook.saved.analytics.SaveAnalyticsLogger.Referer;
import com.facebook.saved.common.data.RecentSaveInfo;
import com.facebook.saved.controller.SavedDashboardNavigationController;
import com.facebook.saved.controller.SavedDashboardNavigationControllerProvider;
import com.facebook.saved.controller.SavedDashboardTitleBarController;
import com.facebook.saved.controller.SavedDashboardTitleBarController.C13772;
import com.facebook.saved.helper.SavedSectionHelper;
import com.facebook.saved.interstitial.SavedDashboardInterstitialManagerProvider;
import com.facebook.saved.launcher.SavedActivityLauncherManager;
import com.facebook.saved.launcher.SavedReviewComposerLauncherWithResult;
import com.facebook.saved.launcher.SavedReviewComposerLauncherWithResult.C13961;
import com.facebook.saved.perf.SavedDashboardStartPerfLogger;
import com.facebook.ui.toaster.ToastBuilder;
import com.facebook.widget.titlebar.HasTitleBar;
import com.facebook.widget.titlebar.TitleBarButtonSpec;
import com.facebook.widget.titlebar.TitleBarButtonSpec.Builder;
import com.google.common.base.Optional;
import com.google.common.util.concurrent.ListenableFuture;
import javax.inject.Inject;

/* compiled from: invitee_ids */
public class SavedFragment extends FbFragment {
    @Inject
    SaveAnalyticsLogger f9134a;
    private SavedDashboardChildFragmentInstanceManager al;
    private SavedDashboardNavigationController am;
    private boolean an;
    public GraphQLSavedDashboardSectionType ao;
    public Optional<Referer> ap;
    @Inject
    SavedDashboardStartPerfLogger f9135b;
    @Inject
    SavedSectionHelper f9136c;
    @Inject
    RecentSaveInfo f9137d;
    @Inject
    SavedDashboardInterstitialManagerProvider f9138e;
    @Inject
    SavedActivityLauncherManager f9139f;
    @Inject
    SavedDashboardTitleBarController f9140g;
    @Inject
    SavedDashboardChildFragmentInstanceManagerProvider f9141h;
    @Inject
    SavedDashboardNavigationControllerProvider f9142i;

    public static void m9129a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((SavedFragment) obj).m9128a(SaveAnalyticsLogger.a(injectorLike), SavedDashboardStartPerfLogger.m9242a(injectorLike), SavedSectionHelper.m9180a(injectorLike), RecentSaveInfo.a(injectorLike), (SavedDashboardInterstitialManagerProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(SavedDashboardInterstitialManagerProvider.class), SavedActivityLauncherManager.m9213a(injectorLike), SavedDashboardTitleBarController.m9067a(injectorLike), (SavedDashboardChildFragmentInstanceManagerProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(SavedDashboardChildFragmentInstanceManagerProvider.class), (SavedDashboardNavigationControllerProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(SavedDashboardNavigationControllerProvider.class));
    }

    public final void m9135c(Bundle bundle) {
        Class cls = SavedFragment.class;
        m9129a((Object) this, getContext());
        SavedDashboardStartPerfLogger savedDashboardStartPerfLogger = this.f9135b;
        savedDashboardStartPerfLogger.f9233d = savedDashboardStartPerfLogger.f9231b.now();
        super.c(bundle);
        String string = this.s.getString("extra_section_name");
        if (string == null && bundle != null) {
            string = bundle.getString("extra_section_name");
        }
        this.ao = SavedSectionHelper.m9179a(string);
        this.ap = Referer.fromString(this.s.getString("extra_referer"));
        this.f9138e.m9212a(getContext()).m9211a();
        if (bundle == null) {
            SaveAnalyticsLogger saveAnalyticsLogger = this.f9134a;
            Referer referer = (Referer) this.ap.orNull();
            GraphQLSavedDashboardSectionType graphQLSavedDashboardSectionType = this.ao;
            HoneyClientEvent honeyClientEvent = new HoneyClientEvent("saved_dashboard_imp");
            honeyClientEvent.c = "saved_dashboard";
            saveAnalyticsLogger.a.a(honeyClientEvent.a("referer", referer).a("section_type", graphQLSavedDashboardSectionType).b("event_id", SafeUUIDGenerator.a().toString()));
        }
    }

    public final View m9132a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -123276175);
        this.an = false;
        View inflate = layoutInflater.inflate(2130906954, viewGroup, false);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1952049815, a);
        return inflate;
    }

    public final void m9134a(View view, Bundle bundle) {
        super.a(view, bundle);
        if (this.al == null) {
            this.al = new SavedDashboardChildFragmentInstanceManager(s(), Integer.valueOf(2131567233));
        }
        if (this.am == null) {
            InjectorLike injectorLike = this.f9142i;
            this.am = new SavedDashboardNavigationController(this.al, SaveAnalyticsLogger.a(injectorLike), SavedSectionHelper.m9180a(injectorLike));
        }
        ListenerManager listenerManager = this.f9140g.f9051c;
        listenerManager.a.add(this.am);
    }

    public final void mi_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1776088121);
        super.mi_();
        SavedDashboardTitleBarController savedDashboardTitleBarController = this.f9140g;
        savedDashboardTitleBarController.f9049a = (HasTitleBar) a(HasTitleBar.class);
        savedDashboardTitleBarController.f9049a.a_(savedDashboardTitleBarController.f9052d.getString(2131238120));
        savedDashboardTitleBarController.f9049a.c(true);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -587724118, a);
    }

    public final void m9130G() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1628343989);
        super.G();
        if (!this.an) {
            this.am.m9056a(this.ao);
            SavedDashboardTitleBarController savedDashboardTitleBarController = this.f9140g;
            savedDashboardTitleBarController.f9050b = savedDashboardTitleBarController.f9053e.m9183a(this.ao);
            HasTitleBar hasTitleBar = savedDashboardTitleBarController.f9049a;
            Builder a2 = TitleBarButtonSpec.a();
            a2.b = savedDashboardTitleBarController.f9052d.getDrawable(2130840359);
            a2 = a2;
            a2.j = savedDashboardTitleBarController.f9052d.getString(2131238173);
            hasTitleBar.a(a2.a());
            savedDashboardTitleBarController.f9049a.a(new C13772(savedDashboardTitleBarController));
            SavedDashboardTitleBarController.m9070a(savedDashboardTitleBarController, savedDashboardTitleBarController.f9050b);
            this.an = true;
        }
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -888291342, a);
    }

    public final void m9131H() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -2117881072);
        super.H();
        this.f9135b.m9265c();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 2030566851, a);
    }

    public final void mY_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -2021061399);
        this.f9140g.f9049a = null;
        ListenerManager listenerManager = this.f9140g.f9051c;
        listenerManager.a.remove(this.am);
        this.f9137d.c();
        super.mY_();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1021626032, a);
    }

    private void m9128a(SaveAnalyticsLogger saveAnalyticsLogger, SavedDashboardStartPerfLogger savedDashboardStartPerfLogger, SavedSectionHelper savedSectionHelper, RecentSaveInfo recentSaveInfo, SavedDashboardInterstitialManagerProvider savedDashboardInterstitialManagerProvider, SavedActivityLauncherManager savedActivityLauncherManager, SavedDashboardTitleBarController savedDashboardTitleBarController, SavedDashboardChildFragmentInstanceManagerProvider savedDashboardChildFragmentInstanceManagerProvider, SavedDashboardNavigationControllerProvider savedDashboardNavigationControllerProvider) {
        this.f9134a = saveAnalyticsLogger;
        this.f9135b = savedDashboardStartPerfLogger;
        this.f9136c = savedSectionHelper;
        this.f9137d = recentSaveInfo;
        this.f9138e = savedDashboardInterstitialManagerProvider;
        this.f9139f = savedActivityLauncherManager;
        this.f9140g = savedDashboardTitleBarController;
        this.f9141h = savedDashboardChildFragmentInstanceManagerProvider;
        this.f9142i = savedDashboardNavigationControllerProvider;
    }

    public final void m9136e(Bundle bundle) {
        bundle.putString("extra_section_name", this.am.m9055a().toString());
        super.e(bundle);
    }

    public final void m9133a(int i, int i2, Intent intent) {
        SavedReviewComposerLauncherWithResult savedReviewComposerLauncherWithResult = (SavedReviewComposerLauncherWithResult) this.f9139f.f9194a.get(Integer.valueOf(i));
        if (savedReviewComposerLauncherWithResult != null && i2 == -1) {
            PostReviewParams postReviewParams = (PostReviewParams) intent.getParcelableExtra("publishReviewParams");
            if (postReviewParams == null) {
                savedReviewComposerLauncherWithResult.f9205e.b(new ToastBuilder(savedReviewComposerLauncherWithResult.f9202b.getString(2131235329)));
                return;
            }
            ListenableFuture a = savedReviewComposerLauncherWithResult.f9204d.a(postReviewParams, null);
            C13961 c13961 = new C13961(savedReviewComposerLauncherWithResult, postReviewParams);
            savedReviewComposerLauncherWithResult.f9205e.b(new ToastBuilder(savedReviewComposerLauncherWithResult.f9202b.getString(2131235327)));
            savedReviewComposerLauncherWithResult.f9203c.a("task_key_saved_dashboard_post_review" + postReviewParams.b, a, c13961);
        }
    }
}
