package com.facebook.notifications.fragmentfactory;

import android.content.Intent;
import android.support.v4.app.Fragment;
import com.facebook.common.fragmentfactory.IFragmentFactory;
import com.facebook.notifications.widget.NotificationSettingsFragment;

/* compiled from: time_since_register */
public class NotificationSettingsFragmentFactory implements IFragmentFactory {
    public final Fragment m1225a(Intent intent) {
        return new NotificationSettingsFragment();
    }
}
