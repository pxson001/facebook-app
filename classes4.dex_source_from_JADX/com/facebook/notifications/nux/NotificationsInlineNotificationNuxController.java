package com.facebook.notifications.nux;

import com.facebook.interstitial.manager.BaseInterstitialController;
import com.facebook.interstitial.manager.InterstitialController.InterstitialControllerState;
import com.facebook.interstitial.manager.InterstitialTrigger;
import com.facebook.interstitial.manager.InterstitialTrigger.Action;
import com.facebook.notifications.abtest.ExperimentsForNotificationsAbtestModule;
import com.facebook.notifications.abtest.NotificationsJewelExperimentController;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;

/* compiled from: executor_concurrency */
public class NotificationsInlineNotificationNuxController extends BaseInterstitialController {
    public static final InterstitialTrigger f12683a = new InterstitialTrigger(Action.NOTIFICATIONS_ADAPTER_CREATION);
    private final NotificationsJewelExperimentController f12684b;

    @Inject
    public NotificationsInlineNotificationNuxController(NotificationsJewelExperimentController notificationsJewelExperimentController) {
        this.f12684b = notificationsJewelExperimentController;
    }

    public final String m13492b() {
        return "4127";
    }

    public final InterstitialControllerState m13491a(InterstitialTrigger interstitialTrigger) {
        return this.f12684b.f7750a.a(ExperimentsForNotificationsAbtestModule.f7780s, false) ? InterstitialControllerState.ELIGIBLE : InterstitialControllerState.INELIGIBLE;
    }

    public final ImmutableList<InterstitialTrigger> m13493c() {
        return ImmutableList.of(f12683a);
    }
}
