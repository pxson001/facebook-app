package com.facebook.events.invite;

import com.facebook.interstitial.manager.BaseInterstitialController;
import com.facebook.interstitial.manager.InterstitialController.InterstitialControllerState;
import com.facebook.interstitial.manager.InterstitialTrigger;
import com.facebook.interstitial.manager.InterstitialTrigger.Action;
import com.google.common.collect.ImmutableList;

/* compiled from: collage_layout */
public class EventsExtendedInviteAddContactsButtonInterstitialController extends BaseInterstitialController {
    public static final InterstitialTrigger f17534a = new InterstitialTrigger(Action.EVENTS_EXTENDED_INVITE_IMPORT_CONTACTS_NUX);

    public final String m17907b() {
        return "4157";
    }

    public final InterstitialControllerState m17906a(InterstitialTrigger interstitialTrigger) {
        return InterstitialControllerState.ELIGIBLE;
    }

    public final ImmutableList<InterstitialTrigger> m17908c() {
        return ImmutableList.of(f17534a);
    }
}
