package com.facebook.notifications.action;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

/* compiled from: no-hide-descendants */
class NotificationsInlineNotificationNuxManager$3 implements AnimationListener {
    final /* synthetic */ NotificationsInlineNotificationNuxManager f8140a;

    NotificationsInlineNotificationNuxManager$3(NotificationsInlineNotificationNuxManager notificationsInlineNotificationNuxManager) {
        this.f8140a = notificationsInlineNotificationNuxManager;
    }

    public void onAnimationStart(Animation animation) {
        this.f8140a.p.setAlpha(0.5f);
    }

    public void onAnimationEnd(Animation animation) {
        this.f8140a.p.setAlpha(0.0f);
    }

    public void onAnimationRepeat(Animation animation) {
    }
}
