package com.facebook.notifications.action;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

/* compiled from: no-hide-descendants */
class NotificationsInlineNotificationNuxManager$4 implements OnTouchListener {
    final /* synthetic */ NotificationsInlineNotificationNuxManager f8141a;

    NotificationsInlineNotificationNuxManager$4(NotificationsInlineNotificationNuxManager notificationsInlineNotificationNuxManager) {
        this.f8141a = notificationsInlineNotificationNuxManager;
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.f8141a.h();
        }
        return false;
    }
}
