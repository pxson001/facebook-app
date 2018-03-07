package com.facebook.pages.fb4a.admin_activity.uri;

import android.content.Intent;
import android.support.v4.app.Fragment;
import com.facebook.common.fragmentfactory.IFragmentFactory;
import com.facebook.notifications.multirow.NotificationsFeedFragment;

/* compiled from: raw_file_size */
public class Fb4aPagesNotificationsFragmentFactory implements IFragmentFactory {
    public final Fragment m3758a(Intent intent) {
        return new NotificationsFeedFragment();
    }
}
