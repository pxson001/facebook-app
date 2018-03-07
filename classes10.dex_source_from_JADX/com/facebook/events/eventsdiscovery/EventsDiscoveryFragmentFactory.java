package com.facebook.events.eventsdiscovery;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import com.facebook.common.fragmentfactory.IFragmentFactory;
import com.facebook.gk.store.GatekeeperStoreImpl;
import javax.inject.Inject;

/* compiled from: com.facebook.messaging.composer.QUICK_REPLY */
public class EventsDiscoveryFragmentFactory implements IFragmentFactory {
    private final GatekeeperStoreImpl f17281a;

    @Inject
    public EventsDiscoveryFragmentFactory(GatekeeperStoreImpl gatekeeperStoreImpl) {
        this.f17281a = gatekeeperStoreImpl;
    }

    public final Fragment m17577a(Intent intent) {
        if (this.f17281a.a(646, false)) {
            Bundle extras = intent.getExtras();
            EventsDiscoveryFragment eventsDiscoveryFragment = new EventsDiscoveryFragment();
            eventsDiscoveryFragment.g(extras);
            return eventsDiscoveryFragment;
        }
        extras = intent.getExtras();
        EventsDiscoveryReactionFragment eventsDiscoveryReactionFragment = new EventsDiscoveryReactionFragment();
        eventsDiscoveryReactionFragment.g(extras);
        return eventsDiscoveryReactionFragment;
    }
}
