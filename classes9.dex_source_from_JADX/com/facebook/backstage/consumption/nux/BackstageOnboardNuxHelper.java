package com.facebook.backstage.consumption.nux;

import com.facebook.backstage.consumption.BackstageNavigatorApi;
import com.facebook.backstage.entry.BackstageOnboardInterstitialController;
import com.facebook.inject.InjectorLike;
import com.facebook.interstitial.manager.InterstitialManager;
import javax.inject.Inject;

/* compiled from: ride_request_triggered */
public class BackstageOnboardNuxHelper {
    private static final String f4853a = BackstageOnboardNuxHelper.class.getSimpleName();
    public final InterstitialManager f4854b;
    public BackstageOnboardInterstitialController f4855c;

    /* compiled from: ride_request_triggered */
    public class C05001 {
        public final /* synthetic */ BackstageNavigatorApi f4851a;
        public final /* synthetic */ BackstageOnboardNuxHelper f4852b;

        public C05001(BackstageOnboardNuxHelper backstageOnboardNuxHelper, BackstageNavigatorApi backstageNavigatorApi) {
            this.f4852b = backstageOnboardNuxHelper;
            this.f4851a = backstageNavigatorApi;
        }
    }

    public static BackstageOnboardNuxHelper m4732a(InjectorLike injectorLike) {
        return new BackstageOnboardNuxHelper(InterstitialManager.a(injectorLike));
    }

    @Inject
    public BackstageOnboardNuxHelper(InterstitialManager interstitialManager) {
        this.f4854b = interstitialManager;
    }
}
