package com.facebook.location.gmsupsell;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.BaseAnalyticsConfig;
import com.facebook.base.activity.FbFragmentActivity;
import com.facebook.base.fragment.FbFragment;
import com.facebook.common.activitylistener.AbstractFbActivityListener;
import com.facebook.common.activitylistener.FbActivityListener;
import com.facebook.common.executors.ForUiThread;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.inject.InjectorLike;
import com.facebook.katana.orca.FbAnalyticsConfig;
import com.facebook.location.gmsupsell.GooglePlayLocationServicesSettingsManager.LocationSettingsRequestParams;
import com.facebook.location.gmsupsell.GooglePlayLocationServicesSettingsManager.LocationStatusResult;
import com.facebook.tools.dextr.runtime.detour.ExecutorDetour;
import com.facebook.ui.futures.TasksManager;
import com.google.common.base.Preconditions;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: {page} */
public class GooglePlayServicesLocationUpsellDialogController {
    private final FbActivityListener f93a = new C00121(this);
    private final GooglePlayLocationServicesSettingsManager f94b;
    @ForUiThread
    public final Executor f95c;
    private final TasksManager<Task> f96d;
    private final GooglePlayServicesLocationUpsellDialogLogger f97e;
    public FbFragmentActivity f98f;
    private OnGooglePlayServicesLocationUpsellDialogFinishedListener f99g;
    public boolean f100h = false;
    @Nullable
    public GoogleLocationDialogResult f101i;
    private String f102j;
    private String f103k;

    /* compiled from: {page} */
    class C00121 extends AbstractFbActivityListener {
        final /* synthetic */ GooglePlayServicesLocationUpsellDialogController f90a;

        /* compiled from: {page} */
        class C00111 implements Runnable {
            final /* synthetic */ C00121 f89a;

            C00111(C00121 c00121) {
                this.f89a = c00121;
            }

            public void run() {
                GooglePlayServicesLocationUpsellDialogController googlePlayServicesLocationUpsellDialogController = this.f89a.f90a;
                if (googlePlayServicesLocationUpsellDialogController.f101i != null) {
                    GooglePlayServicesLocationUpsellDialogController.m69a(googlePlayServicesLocationUpsellDialogController, googlePlayServicesLocationUpsellDialogController.f101i);
                    googlePlayServicesLocationUpsellDialogController.f101i = null;
                }
            }
        }

        C00121(GooglePlayServicesLocationUpsellDialogController googlePlayServicesLocationUpsellDialogController) {
            this.f90a = googlePlayServicesLocationUpsellDialogController;
        }

        public final void m62a(Bundle bundle) {
            GooglePlayServicesLocationUpsellDialogController googlePlayServicesLocationUpsellDialogController = this.f90a;
            boolean z = false;
            if (bundle != null && bundle.getBoolean("GooglePlayServicesLocationUpsellDialogController:waiting_for_dialog_result", false)) {
                z = true;
            }
            googlePlayServicesLocationUpsellDialogController.f100h = z;
        }

        public final void m61a(Activity activity, int i, int i2, Intent intent) {
            GooglePlayServicesLocationUpsellDialogController googlePlayServicesLocationUpsellDialogController = this.f90a;
            if (googlePlayServicesLocationUpsellDialogController.f100h && i == 4975) {
                googlePlayServicesLocationUpsellDialogController.f100h = false;
                googlePlayServicesLocationUpsellDialogController.f101i = i2 == -1 ? GoogleLocationDialogResult.DIALOG_SUCCESS : GoogleLocationDialogResult.DIALOG_CANCEL;
            }
        }

        public final void m64c(Activity activity) {
            ExecutorDetour.a(this.f90a.f95c, new C00111(this), -713590548);
        }

        public final void m63b(Bundle bundle) {
            if (this.f90a.f100h) {
                bundle.putBoolean("GooglePlayServicesLocationUpsellDialogController:waiting_for_dialog_result", true);
            }
        }
    }

    /* compiled from: {page} */
    class C00132 extends AbstractDisposableFutureCallback<LocationStatusResult> {
        final /* synthetic */ GooglePlayServicesLocationUpsellDialogController f91a;

        C00132(GooglePlayServicesLocationUpsellDialogController googlePlayServicesLocationUpsellDialogController) {
            this.f91a = googlePlayServicesLocationUpsellDialogController;
        }

        protected final void m65a(Object obj) {
            LocationStatusResult locationStatusResult = (LocationStatusResult) obj;
            GooglePlayServicesLocationUpsellDialogController googlePlayServicesLocationUpsellDialogController = this.f91a;
            if (!googlePlayServicesLocationUpsellDialogController.f100h && googlePlayServicesLocationUpsellDialogController.f101i == null) {
                Preconditions.checkNotNull(locationStatusResult);
                switch (locationStatusResult.f84b) {
                    case LOCATION_SETTINGS_OK:
                        GooglePlayServicesLocationUpsellDialogController.m69a(googlePlayServicesLocationUpsellDialogController, GoogleLocationDialogResult.DIALOG_NOT_NEEDED);
                        return;
                    case EASY_RESOLUTION_POSSIBLE:
                        if (locationStatusResult.m56a(googlePlayServicesLocationUpsellDialogController.f98f, 4975)) {
                            googlePlayServicesLocationUpsellDialogController.f100h = true;
                            return;
                        } else {
                            GooglePlayServicesLocationUpsellDialogController.m69a(googlePlayServicesLocationUpsellDialogController, GoogleLocationDialogResult.UNKNOWN_FAILURE);
                            return;
                        }
                    default:
                        GooglePlayServicesLocationUpsellDialogController.m69a(googlePlayServicesLocationUpsellDialogController, GoogleLocationDialogResult.DIALOG_NOT_POSSIBLE);
                        return;
                }
            }
        }

        protected final void m66a(Throwable th) {
            GooglePlayServicesLocationUpsellDialogController.m69a(this.f91a, GoogleLocationDialogResult.UNKNOWN_FAILURE);
        }
    }

    /* compiled from: {page} */
    public enum GoogleLocationDialogResult {
        DIALOG_SUCCESS,
        DIALOG_CANCEL,
        DIALOG_NOT_NEEDED,
        DIALOG_NOT_POSSIBLE,
        UNKNOWN_FAILURE
    }

    /* compiled from: {page} */
    public interface OnGooglePlayServicesLocationUpsellDialogFinishedListener {
        void mo1a(GoogleLocationDialogResult googleLocationDialogResult);
    }

    /* compiled from: {page} */
    enum Task {
        GMS_SETTINGS_LOOKUP_TASK
    }

    public static GooglePlayServicesLocationUpsellDialogController m70b(InjectorLike injectorLike) {
        return new GooglePlayServicesLocationUpsellDialogController(GooglePlayLocationServicesSettingsManager.m59b(injectorLike), new GooglePlayServicesLocationUpsellDialogLogger((BaseAnalyticsConfig) FbAnalyticsConfig.a(injectorLike), AnalyticsLoggerMethodAutoProvider.a(injectorLike)), (Executor) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(injectorLike), TasksManager.b(injectorLike));
    }

    public static GooglePlayServicesLocationUpsellDialogController m68a(InjectorLike injectorLike) {
        return m70b(injectorLike);
    }

    @Inject
    public GooglePlayServicesLocationUpsellDialogController(GooglePlayLocationServicesSettingsManager googlePlayLocationServicesSettingsManager, GooglePlayServicesLocationUpsellDialogLogger googlePlayServicesLocationUpsellDialogLogger, Executor executor, TasksManager tasksManager) {
        this.f94b = googlePlayLocationServicesSettingsManager;
        this.f95c = executor;
        this.f96d = tasksManager;
        this.f97e = googlePlayServicesLocationUpsellDialogLogger;
    }

    public final void m73a(FbFragment fbFragment, OnGooglePlayServicesLocationUpsellDialogFinishedListener onGooglePlayServicesLocationUpsellDialogFinishedListener) {
        FragmentActivity o = fbFragment.o();
        Preconditions.checkNotNull(o);
        Preconditions.checkArgument(o instanceof FbFragmentActivity);
        m72a((FbFragmentActivity) o, onGooglePlayServicesLocationUpsellDialogFinishedListener);
    }

    public final void m72a(FbFragmentActivity fbFragmentActivity, OnGooglePlayServicesLocationUpsellDialogFinishedListener onGooglePlayServicesLocationUpsellDialogFinishedListener) {
        this.f98f = (FbFragmentActivity) Preconditions.checkNotNull(fbFragmentActivity);
        this.f99g = (OnGooglePlayServicesLocationUpsellDialogFinishedListener) Preconditions.checkNotNull(onGooglePlayServicesLocationUpsellDialogFinishedListener);
        this.f98f.a(this.f93a);
    }

    public final void m71a() {
        this.f96d.c(Task.GMS_SETTINGS_LOOKUP_TASK);
        if (this.f98f != null) {
            this.f98f.b(this.f93a);
        }
        this.f98f = null;
        this.f99g = null;
    }

    public final void m74a(LocationSettingsRequestParams locationSettingsRequestParams, String str, String str2) {
        if (!this.f100h && this.f101i == null) {
            Preconditions.checkNotNull(this.f98f);
            Preconditions.checkNotNull(this.f99g);
            Preconditions.checkNotNull(locationSettingsRequestParams);
            Preconditions.checkNotNull(str);
            Preconditions.checkNotNull(str2);
            this.f102j = str;
            this.f103k = str2;
            this.f97e.m76a(this.f102j, this.f103k);
            this.f96d.a(Task.GMS_SETTINGS_LOOKUP_TASK, this.f94b.m60a(locationSettingsRequestParams), new C00132(this));
        }
    }

    public static void m69a(GooglePlayServicesLocationUpsellDialogController googlePlayServicesLocationUpsellDialogController, GoogleLocationDialogResult googleLocationDialogResult) {
        googlePlayServicesLocationUpsellDialogController.f97e.m77a(googlePlayServicesLocationUpsellDialogController.f102j, googlePlayServicesLocationUpsellDialogController.f103k, googleLocationDialogResult.toString());
        googlePlayServicesLocationUpsellDialogController.f99g.mo1a(googleLocationDialogResult);
    }
}
