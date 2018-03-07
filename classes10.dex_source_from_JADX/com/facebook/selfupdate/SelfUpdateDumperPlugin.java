package com.facebook.selfupdate;

import com.facebook.appupdate.AppUpdateOperationFactory;
import com.facebook.appupdate.SelfUpdateLauncher;
import com.facebook.inject.InjectorLike;
import javax.inject.Inject;

/* compiled from: has_seen_checkout_nux */
public class SelfUpdateDumperPlugin {
    private final SelfUpdateStartOperationTask f9971a;
    private final SelfUpdateLauncher f9972b;
    private final FbandroidAppConfiguration f9973c;
    private final AppUpdateOperationFactory f9974d;

    private static SelfUpdateDumperPlugin m10076b(InjectorLike injectorLike) {
        return new SelfUpdateDumperPlugin(SelfUpdateStartOperationTask.b(injectorLike), SelfUpdateLauncherMethodAutoProvider.b(injectorLike), FbandroidAppConfiguration.b(injectorLike), SelfUpdateModule.b(AppUpdateInjectorMethodAutoProvider.a(injectorLike)));
    }

    @Inject
    public SelfUpdateDumperPlugin(SelfUpdateStartOperationTask selfUpdateStartOperationTask, SelfUpdateLauncher selfUpdateLauncher, FbandroidAppConfiguration fbandroidAppConfiguration, AppUpdateOperationFactory appUpdateOperationFactory) {
        this.f9971a = selfUpdateStartOperationTask;
        this.f9972b = selfUpdateLauncher;
        this.f9973c = fbandroidAppConfiguration;
        this.f9974d = appUpdateOperationFactory;
    }
}
