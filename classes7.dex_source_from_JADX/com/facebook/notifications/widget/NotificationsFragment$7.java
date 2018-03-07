package com.facebook.notifications.widget;

import com.facebook.notifications.sync.NotificationsSyncConstants.SyncSource;
import com.facebook.widget.refreshableview.RefreshableViewContainerLike.OnRefreshListener;

/* compiled from: method/mobile.zeroBalanceDetection */
class NotificationsFragment$7 extends OnRefreshListener {
    final /* synthetic */ NotificationsFragment f9050a;

    NotificationsFragment$7(NotificationsFragment notificationsFragment) {
        this.f9050a = notificationsFragment;
    }

    public final void m10877b(boolean z) {
        if (this.f9050a.aG.a()) {
            this.f9050a.a(SyncSource.PULL_TO_REFRESH);
        } else {
            this.f9050a.bd.getRefreshableContainerLike().b(2131230811);
        }
    }
}
