package com.facebook.notifications.fragmentfactory;

import android.content.Intent;
import android.support.v4.app.Fragment;
import com.facebook.common.fragmentfactory.IFragmentFactory;
import com.facebook.notifications.connectioncontroller.NotificationsConnectionControllerFragment;
import com.facebook.notifications.multirow.NotificationsFeedFragment;
import com.facebook.notifications.widget.NotificationsFragment;
import com.facebook.today.abtest.TodayExperimentController;
import javax.inject.Inject;

/* compiled from: extra/ */
public class NotificationsFragmentFactory implements IFragmentFactory {
    private final TodayExperimentController f12542a;

    @Inject
    public NotificationsFragmentFactory(TodayExperimentController todayExperimentController) {
        this.f12542a = todayExperimentController;
    }

    public final Fragment m13287a(Intent intent) {
        if (this.f12542a.v()) {
            return new NotificationsConnectionControllerFragment();
        }
        if (this.f12542a.z()) {
            return new NotificationsFeedFragment();
        }
        return new NotificationsFragment();
    }
}
