package com.facebook.events.invite;

import com.facebook.interstitial.manager.BaseInterstitialController;
import com.facebook.interstitial.manager.InterstitialController.InterstitialControllerState;
import com.facebook.interstitial.manager.InterstitialTrigger;
import com.facebook.interstitial.manager.InterstitialTrigger.Action;
import com.google.common.collect.ImmutableList;

/* compiled from: reg_terms_contacts_end_v1 */
public class EventsExtendedInviteAddNoteButtonInterstitialController extends BaseInterstitialController {
    public static final InterstitialTrigger f3529a = new InterstitialTrigger(Action.EVENTS_EXTENDED_INVITE_ADD_NOTE_BUTTON_NUX);

    public final String m3882b() {
        return "4158";
    }

    public final InterstitialControllerState m3881a(InterstitialTrigger interstitialTrigger) {
        return InterstitialControllerState.ELIGIBLE;
    }

    public final ImmutableList<InterstitialTrigger> m3883c() {
        return ImmutableList.of(f3529a);
    }
}
