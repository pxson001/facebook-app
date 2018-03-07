package com.facebook.notifications.widget;

import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.notifications.sync.NotificationsSyncConstants.SyncSource;
import com.facebook.tools.dextr.runtime.LogUtils;

/* compiled from: method/mobile.zeroBalanceDetection */
class NotificationsFragment$13 implements OnClickListener {
    final /* synthetic */ NotificationsFragment f9043a;

    NotificationsFragment$13(NotificationsFragment notificationsFragment) {
        this.f9043a = notificationsFragment;
    }

    public void onClick(View view) {
        int a = Logger.a(2, EntryType.UI_INPUT_START, -1023397941);
        this.f9043a.bp.b();
        if (this.f9043a.aG.a()) {
            this.f9043a.a(SyncSource.PULL_TO_REFRESH);
        } else {
            NotificationsFragment.aq(this.f9043a);
            NotificationsFragment.aI(this.f9043a);
        }
        LogUtils.a(1249356604, a);
    }
}
