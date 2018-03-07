package com.facebook.events.invite;

import com.facebook.interstitial.manager.BaseInterstitialController;
import com.facebook.interstitial.manager.InterstitialController.InterstitialControllerState;
import com.facebook.interstitial.manager.InterstitialTrigger;
import com.facebook.interstitial.manager.InterstitialTrigger.Action;
import com.google.common.collect.ImmutableList;

/* compiled from: reg_profile_photo_step_seen/ */
public class EventsExtendedInviteNoteInterstitialController extends BaseInterstitialController {
    public static final InterstitialTrigger f3530a = new InterstitialTrigger(Action.EVENTS_EXTENDED_INVITE_NOTE_NUX);

    public final String m3885b() {
        return "4159";
    }

    public final InterstitialControllerState m3884a(InterstitialTrigger interstitialTrigger) {
        return InterstitialControllerState.ELIGIBLE;
    }

    public final ImmutableList<InterstitialTrigger> m3886c() {
        return ImmutableList.of(f3530a);
    }
}
