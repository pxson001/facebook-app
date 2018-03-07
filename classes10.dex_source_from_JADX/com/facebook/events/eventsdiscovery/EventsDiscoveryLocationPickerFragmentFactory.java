package com.facebook.events.eventsdiscovery;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import com.facebook.common.fragmentfactory.IFragmentFactory;

/* compiled from: com.facebook.katana.ProxyAuth */
public class EventsDiscoveryLocationPickerFragmentFactory implements IFragmentFactory {
    public final Fragment m17590a(Intent intent) {
        Bundle extras = intent.getExtras();
        EventsDiscoveryLocationPickerFragment eventsDiscoveryLocationPickerFragment = new EventsDiscoveryLocationPickerFragment();
        eventsDiscoveryLocationPickerFragment.g(extras);
        return eventsDiscoveryLocationPickerFragment;
    }
}
