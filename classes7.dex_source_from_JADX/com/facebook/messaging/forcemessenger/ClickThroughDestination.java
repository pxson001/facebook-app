package com.facebook.messaging.forcemessenger;

import com.facebook.interstitial.manager.InterstitialTrigger;
import com.facebook.interstitial.manager.InterstitialTrigger.Action;

/* compiled from: onErrorPersistedRelayQuery */
public enum ClickThroughDestination {
    THREAD_LIST(new InterstitialTrigger(Action.MESSAGES_DIODE_TAB)),
    CANONICAL_THREAD(new InterstitialTrigger(Action.MESSAGES_DIODE_CANONICAL_THREAD)),
    GROUP_THREAD(new InterstitialTrigger(Action.MESSAGES_DIODE_GROUP_THREAD)),
    LEGACY_THREAD_ID(new InterstitialTrigger(Action.MESSAGES_DIODE_CANONICAL_THREAD)),
    THREAD_LIST_JEWEL(new InterstitialTrigger(Action.MESSAGES_DIODE_TAB)),
    CREATE_THREAD(new InterstitialTrigger(Action.MESSAGES_DIODE_CREATE_THREAD));
    
    private final InterstitialTrigger mTrigger;

    private ClickThroughDestination(InterstitialTrigger interstitialTrigger) {
        this.mTrigger = interstitialTrigger;
    }

    public final InterstitialTrigger getTriggerForDestination() {
        return this.mTrigger;
    }
}
