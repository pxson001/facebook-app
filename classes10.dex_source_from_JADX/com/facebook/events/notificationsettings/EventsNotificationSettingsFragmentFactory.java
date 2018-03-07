package com.facebook.events.notificationsettings;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import com.facebook.common.fragmentfactory.IFragmentFactory;

/* compiled from: catalog_id */
public class EventsNotificationSettingsFragmentFactory implements IFragmentFactory {
    public final Fragment m18157a(Intent intent) {
        Bundle extras = intent.getExtras();
        EventsNotificationSettingsFragment eventsNotificationSettingsFragment = new EventsNotificationSettingsFragment();
        eventsNotificationSettingsFragment.g(extras);
        return eventsNotificationSettingsFragment;
    }
}
