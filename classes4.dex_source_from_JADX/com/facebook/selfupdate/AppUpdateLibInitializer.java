package com.facebook.selfupdate;

import com.facebook.appupdate.AppUpdateInitializer;
import com.facebook.appupdate.AppUpdateInjector;
import com.facebook.appupdate.Preconditions;
import com.facebook.common.init.INeedInit;
import com.facebook.inject.Lazy;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import javax.inject.Inject;

/* compiled from: likers_profile_image_size */
public class AppUpdateLibInitializer implements INeedInit {
    private final Lazy<AppUpdateInjector> f9343a;

    @Inject
    public AppUpdateLibInitializer(Lazy<AppUpdateInjector> lazy) {
        this.f9343a = lazy;
    }

    public void init() {
        this.f9343a.get();
        Preconditions.a(AppUpdateInjector.b());
        AppUpdateInjector appUpdateInjector = (AppUpdateInjector) this.f9343a.get();
        final AppUpdateInitializer d = appUpdateInjector.d();
        HandlerDetour.a(appUpdateInjector.j(), new Runnable(this) {
            final /* synthetic */ AppUpdateLibInitializer f11418b;

            public void run() {
                AppUpdateInitializer appUpdateInitializer = d;
                Preconditions.b();
                appUpdateInitializer.f11411a.a();
                appUpdateInitializer.f11411a.b();
                HandlerDetour.a(appUpdateInitializer.f11413c, appUpdateInitializer.f11412b, 1025254046);
            }
        }, -807481119);
    }
}
