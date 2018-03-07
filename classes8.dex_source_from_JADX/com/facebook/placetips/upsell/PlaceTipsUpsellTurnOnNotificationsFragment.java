package com.facebook.placetips.upsell;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.facebook.base.fragment.FbFragment;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.common.uri.FbUriIntentHandler;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.InjectorLike;
import com.facebook.location.gmsupsell.GooglePlayLocationServicesSettingsManager.LocationSettingsRequestParams;
import com.facebook.location.gmsupsell.GooglePlayServicesLocationUpsellDialogController;
import com.facebook.location.gmsupsell.GooglePlayServicesLocationUpsellDialogController.GoogleLocationDialogResult;
import com.facebook.location.gmsupsell.GooglePlayServicesLocationUpsellDialogController.OnGooglePlayServicesLocationUpsellDialogFinishedListener;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.placetips.settings.PlaceTipsSettingsHelper;
import com.facebook.placetips.settings.graphql.GravitySettingsGraphQlFragmentInterfaces.GravitySettingsGraphQlFragment;
import com.facebook.placetips.upsell.PlaceTipsUpsellLocationHistoryUtil.C20471;
import com.facebook.placetips.upsell.PlaceTipsUpsellLocationHistoryUtil.C20482;
import com.facebook.resources.FbResources;
import com.facebook.resources.impl.DownloadedFbResources;
import com.facebook.resources.ui.FbButton;
import com.facebook.resources.ui.FbTextView;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.ui.futures.TasksManager;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.MoreExecutors;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: can_add_poll_option */
public class PlaceTipsUpsellTurnOnNotificationsFragment extends FbFragment implements OnGooglePlayServicesLocationUpsellDialogFinishedListener {
    @Inject
    FbResources f18532a;
    @Inject
    FbUriIntentHandler f18533b;
    @Inject
    public GooglePlayServicesLocationUpsellDialogController f18534c;
    @Inject
    PlaceTipsUpsellAnalyticsLogger f18535d;
    @Inject
    PlaceTipsUpsellLocationHistoryUtil f18536e;
    @Inject
    TasksManager f18537f;
    public boolean f18538g = false;
    private FrameLayout f18539h;

    /* compiled from: can_add_poll_option */
    class C20512 implements OnClickListener {
        final /* synthetic */ PlaceTipsUpsellTurnOnNotificationsFragment f18529a;

        C20512(PlaceTipsUpsellTurnOnNotificationsFragment placeTipsUpsellTurnOnNotificationsFragment) {
            this.f18529a = placeTipsUpsellTurnOnNotificationsFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1335012213);
            this.f18529a.f18535d.a(PlaceTipsUpsellAnalyticsEvent.LOCATION_OPT_IN_LH_NOTIFICATION_TURN_ON_TAPPED);
            PlaceTipsUpsellTurnOnNotificationsFragment.aq(this.f18529a);
            Logger.a(2, EntryType.UI_INPUT_END, -1763623161, a);
        }
    }

    /* compiled from: can_add_poll_option */
    class C20523 implements OnClickListener {
        final /* synthetic */ PlaceTipsUpsellTurnOnNotificationsFragment f18530a;

        C20523(PlaceTipsUpsellTurnOnNotificationsFragment placeTipsUpsellTurnOnNotificationsFragment) {
            this.f18530a = placeTipsUpsellTurnOnNotificationsFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 965590567);
            this.f18530a.f18535d.a(PlaceTipsUpsellAnalyticsEvent.LOCATION_OPT_IN_LH_NOTIFICATION_NOT_NOW_TAPPED);
            this.f18530a.m22454e().as();
            Logger.a(2, EntryType.UI_INPUT_END, -840537094, a);
        }
    }

    /* compiled from: can_add_poll_option */
    class C20534 extends AbstractDisposableFutureCallback<GravitySettingsGraphQlFragment> {
        final /* synthetic */ PlaceTipsUpsellTurnOnNotificationsFragment f18531a;

        C20534(PlaceTipsUpsellTurnOnNotificationsFragment placeTipsUpsellTurnOnNotificationsFragment) {
            this.f18531a = placeTipsUpsellTurnOnNotificationsFragment;
        }

        protected final void m22444a(Object obj) {
            PlaceTipsUpsellTurnOnNotificationsFragment placeTipsUpsellTurnOnNotificationsFragment = this.f18531a;
            placeTipsUpsellTurnOnNotificationsFragment.f18534c.a(new LocationSettingsRequestParams(), "surface_placetips_upsell", "mechanism_turn_on_button");
        }

        protected final void m22445a(Throwable th) {
            this.f18531a.m22454e().at();
        }
    }

    /* compiled from: can_add_poll_option */
    enum Task {
        SAVE_LH_AND_NOTIFICATION_SETTING
    }

    public static void m22447a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((PlaceTipsUpsellTurnOnNotificationsFragment) obj).m22446a((FbResources) DownloadedFbResources.a(injectorLike), FbUriIntentHandler.a(injectorLike), GooglePlayServicesLocationUpsellDialogController.b(injectorLike), PlaceTipsUpsellAnalyticsLogger.a(injectorLike), new PlaceTipsUpsellLocationHistoryUtil(PlaceTipsSettingsHelper.m3886a(injectorLike), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike), PlaceTipsUpsellAnalyticsLogger.a(injectorLike), IdBasedLazy.a(injectorLike, 3022)), TasksManager.b(injectorLike));
    }

    private void m22446a(FbResources fbResources, FbUriIntentHandler fbUriIntentHandler, GooglePlayServicesLocationUpsellDialogController googlePlayServicesLocationUpsellDialogController, PlaceTipsUpsellAnalyticsLogger placeTipsUpsellAnalyticsLogger, PlaceTipsUpsellLocationHistoryUtil placeTipsUpsellLocationHistoryUtil, TasksManager tasksManager) {
        this.f18532a = fbResources;
        this.f18533b = fbUriIntentHandler;
        this.f18534c = googlePlayServicesLocationUpsellDialogController;
        this.f18535d = placeTipsUpsellAnalyticsLogger;
        this.f18536e = placeTipsUpsellLocationHistoryUtil;
        this.f18537f = tasksManager;
    }

    public final void m22453c(Bundle bundle) {
        Class cls = PlaceTipsUpsellTurnOnNotificationsFragment.class;
        m22447a((Object) this, getContext());
        this.f18534c.a(this, this);
        super.c(bundle);
        this.f18535d.a(PlaceTipsUpsellAnalyticsEvent.LOCATION_OPT_IN_LH_NOTIFICATION_PAGE_IMPRESSION);
    }

    public final View m22450a(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -303545757);
        super.a(layoutInflater, viewGroup, bundle);
        View inflate = layoutInflater.inflate(2130906290, viewGroup, false);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -852212017, a);
        return inflate;
    }

    public final void m22451a(View view, @Nullable Bundle bundle) {
        this.f18539h = (FrameLayout) e(2131566070);
        ImageView imageView = (ImageView) e(2131566048);
        FbTextView fbTextView = (FbTextView) e(2131566050);
        FbTextView fbTextView2 = (FbTextView) e(2131566051);
        FbButton fbButton = (FbButton) e(2131566052);
        FbButton fbButton2 = (FbButton) e(2131566069);
        FbButton fbButton3 = (FbButton) e(2131566066);
        final UpsellPageConfig av = m22454e().av();
        fbTextView.setText(av.f18546b);
        fbTextView2.setText(av.f18547c);
        fbButton2.setText(av.f18549e);
        fbButton3.setText(av.f18548d);
        fbButton.setText(av.f18550f);
        imageView.setImageDrawable(this.f18532a.getDrawable(2130839628));
        fbButton.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ PlaceTipsUpsellTurnOnNotificationsFragment f18528b;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, -199720721);
                if (av.f18551g == null) {
                    Logger.a(2, EntryType.UI_INPUT_END, -1998541637, a);
                    return;
                }
                this.f18528b.f18535d.a(PlaceTipsUpsellAnalyticsEvent.LOCATION_OPT_IN_LH_NOTIFICATION_LEARN_MORE_TAPPED);
                this.f18528b.f18533b.a(this.f18528b.getContext(), av.f18551g);
                LogUtils.a(-1006269988, a);
            }
        });
        fbButton2.setOnClickListener(new C20512(this));
        fbButton3.setOnClickListener(new C20523(this));
        if (this.f18538g) {
            this.f18539h.setVisibility(0);
        }
        super.a(view, bundle);
    }

    public final void m22448G() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 510919583);
        super.G();
        if (this.f18538g) {
            this.f18538g = false;
            aq(this);
        }
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1756811585, a);
    }

    public final void m22449I() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -2132361048);
        this.f18537f.c(Task.SAVE_LH_AND_NOTIFICATION_SETTING);
        this.f18534c.a();
        super.I();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -945598806, a);
    }

    public final void m22452a(GoogleLocationDialogResult googleLocationDialogResult) {
        this.f18535d.a(googleLocationDialogResult);
        m22454e().aq();
    }

    public static void aq(PlaceTipsUpsellTurnOnNotificationsFragment placeTipsUpsellTurnOnNotificationsFragment) {
        placeTipsUpsellTurnOnNotificationsFragment.f18539h.setVisibility(0);
        TasksManager tasksManager = placeTipsUpsellTurnOnNotificationsFragment.f18537f;
        Task task = Task.SAVE_LH_AND_NOTIFICATION_SETTING;
        PlaceTipsUpsellLocationHistoryUtil placeTipsUpsellLocationHistoryUtil = placeTipsUpsellTurnOnNotificationsFragment.f18536e;
        ListenableFuture a = placeTipsUpsellLocationHistoryUtil.f18523b.m3888a(PlaceTipsUpsellLocationHistoryUtil.f18522a);
        Futures.a(a, new C20471(placeTipsUpsellLocationHistoryUtil), MoreExecutors.a());
        tasksManager.a(task, Futures.b(a, new C20482(placeTipsUpsellLocationHistoryUtil), MoreExecutors.a()), new C20534(placeTipsUpsellTurnOnNotificationsFragment));
    }

    protected final PlaceTipsUpsellController m22454e() {
        return (PlaceTipsUpsellController) Preconditions.checkNotNull(a(PlaceTipsUpsellController.class));
    }
}
