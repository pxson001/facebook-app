package com.facebook.notifications.widget;

import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.tools.dextr.runtime.LogUtils;

/* compiled from: method/mobile.zeroBalanceDetection */
class NotificationsFragment$8 implements OnClickListener {
    final /* synthetic */ NotificationsFragment f9051a;

    NotificationsFragment$8(NotificationsFragment notificationsFragment) {
        this.f9051a = notificationsFragment;
    }

    public void onClick(View view) {
        int a = Logger.a(2, EntryType.UI_INPUT_START, 645785524);
        int r = this.f9051a.n().r();
        int q = (r - this.f9051a.n().q()) + 1;
        int i = this.f9051a.bm - r;
        if (this.f9051a.bb.c() || i > q) {
            this.f9051a.n().c(r, 0);
        } else {
            this.f9051a.n().e(r + i);
        }
        LogUtils.a(-1232930338, a);
    }
}
