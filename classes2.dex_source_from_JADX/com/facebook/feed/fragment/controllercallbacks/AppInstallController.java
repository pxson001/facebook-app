package com.facebook.feed.fragment.controllercallbacks;

import android.view.View;
import android.view.ViewStub;
import com.facebook.base.fragment.FbFragment;
import com.facebook.controllercallbacks.api.BaseController;
import com.facebook.controllercallbacks.api.Holder;
import com.facebook.controllercallbacks.fragment.ResumePauseCallbacks;
import com.facebook.controllercallbacks.fragment.ViewCreatedDestroyedCallbacks;
import com.facebook.feed.animation.AnimationCallback;
import com.facebook.feed.platformads.ApplicationPoller;
import com.facebook.feed.platformads.listener.AppInstalledListener$AppInstalledListenerLocation;
import com.facebook.feed.platformads.listener.AppInstalledListener.InstalledAppInfo;
import com.facebook.feed.ui.InstallNotificationBeeper;
import com.facebook.inject.InjectorLike;
import com.facebook.ultralight.Inject;

/* compiled from: photos-upload- */
public class AppInstallController<Dispatcher extends AnimationCallback> extends BaseController implements ResumePauseCallbacks, ViewCreatedDestroyedCallbacks, AnimationCallback {
    @Inject
    public ApplicationPoller f9916a;
    public Dispatcher f9917b;
    public Holder<FbFragment> f9918c;
    public InstallNotificationBeeper f9919d;
    public ViewStub f9920e;

    public static AppInstallController m14947a(InjectorLike injectorLike) {
        AppInstallController appInstallController = new AppInstallController();
        appInstallController.f9916a = ApplicationPoller.m14954a(injectorLike);
        return appInstallController;
    }

    public final void mo1264c() {
        ApplicationPoller applicationPoller = this.f9916a;
        applicationPoller.f9934m.put(AppInstalledListener$AppInstalledListenerLocation.NEWSFEED, this);
        this.f9916a.m14962a();
    }

    public final void mo1265d() {
        this.f9916a.m14964b();
        ApplicationPoller applicationPoller = this.f9916a;
        AppInstalledListener$AppInstalledListenerLocation appInstalledListener$AppInstalledListenerLocation = AppInstalledListener$AppInstalledListenerLocation.NEWSFEED;
        if (applicationPoller.f9934m != null) {
            applicationPoller.f9934m.remove(appInstalledListener$AppInstalledListenerLocation);
        }
    }

    public final void mo1886a(View view) {
        this.f9920e = (ViewStub) view.findViewById(2131562164);
    }

    public final void kG_() {
        this.f9920e = null;
    }

    public final void mo1899b(View view) {
        if (view != this.f9919d && this.f9919d != null) {
            this.f9919d.a();
        }
    }

    public final void m14949a(InstalledAppInfo installedAppInfo) {
        if (installedAppInfo != null) {
            ((FbFragment) this.f9918c.f10429a).ao().runOnUiThread(new 1(this, installedAppInfo));
        }
    }
}
