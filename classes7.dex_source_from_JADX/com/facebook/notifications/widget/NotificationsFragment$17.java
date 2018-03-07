package com.facebook.notifications.widget;

import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;

/* compiled from: method/mobile.zeroBalanceDetection */
class NotificationsFragment$17 implements OnClickListener {
    final /* synthetic */ NotificationsFragment f9049a;

    NotificationsFragment$17(NotificationsFragment notificationsFragment) {
        this.f9049a = notificationsFragment;
    }

    public void onClick(View view) {
        int a = Logger.a(2, EntryType.UI_INPUT_START, 174796573);
        this.f9049a.aK.a(this.f9049a.bg, FBLinks.ck);
        Logger.a(2, EntryType.UI_INPUT_END, 1623663027, a);
    }
}
