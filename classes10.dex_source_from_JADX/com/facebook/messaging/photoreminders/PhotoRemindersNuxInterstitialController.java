package com.facebook.messaging.photoreminders;

import android.os.Parcelable;
import com.facebook.interstitial.manager.InterstitialController;
import com.facebook.interstitial.manager.InterstitialController.InterstitialControllerState;
import com.facebook.interstitial.manager.InterstitialTrigger;
import com.facebook.interstitial.manager.InterstitialTrigger.Action;
import com.facebook.interstitial.manager.InterstitialTriggerContext;
import com.google.common.collect.ImmutableList;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: release_package */
public class PhotoRemindersNuxInterstitialController implements InterstitialController {
    private static final InterstitialTrigger f3531a = new InterstitialTrigger(Action.MESSENGER_THREAD_LIST_BLOCKING);
    private final PhotoRemindersGatingUtil f3532b;
    private final PhotoRemindersNuxTriggerManager f3533c;

    @Inject
    public PhotoRemindersNuxInterstitialController(PhotoRemindersGatingUtil photoRemindersGatingUtil, PhotoRemindersNuxTriggerManager photoRemindersNuxTriggerManager) {
        this.f3532b = photoRemindersGatingUtil;
        this.f3533c = photoRemindersNuxTriggerManager;
    }

    public final String m3393b() {
        return "3923";
    }

    public final void m3392a(Parcelable parcelable) {
    }

    public final void m3391a(long j) {
    }

    public final InterstitialControllerState m3390a(InterstitialTrigger interstitialTrigger) {
        return (!this.f3533c.m3398a() || (!this.f3532b.g.a(ExperimentsForMessagingPhotoRemindersModule.f3509d, false) && m3389a(interstitialTrigger.a, "is_in_chat_head", true))) ? InterstitialControllerState.INELIGIBLE : InterstitialControllerState.ELIGIBLE;
    }

    private static boolean m3389a(@Nullable InterstitialTriggerContext interstitialTriggerContext, String str, boolean z) {
        if (interstitialTriggerContext == null) {
            return z;
        }
        String a = interstitialTriggerContext.a(str);
        return a != null ? Boolean.valueOf(a).booleanValue() : z;
    }

    public final ImmutableList<InterstitialTrigger> m3394c() {
        return ImmutableList.of(f3531a);
    }

    public final long hI_() {
        return 0;
    }
}
