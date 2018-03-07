package com.facebook.events.dashboard;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import com.facebook.common.fragmentfactory.IFragmentFactory;

/* compiled from: com.gau.go.launcherex */
public class EventsDiscoveryUpcomingEventsFragmentFactory implements IFragmentFactory {
    public final Fragment m17266a(Intent intent) {
        Bundle extras = intent.getExtras();
        EventsDiscoveryUpcomingEventsFragment eventsDiscoveryUpcomingEventsFragment = new EventsDiscoveryUpcomingEventsFragment();
        eventsDiscoveryUpcomingEventsFragment.g(extras);
        return eventsDiscoveryUpcomingEventsFragment;
    }
}
