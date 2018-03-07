package com.facebook.appinvites.installtracking;

import android.content.Context;
import android.content.Intent;
import com.facebook.common.util.StringUtil;
import com.facebook.content.ActionReceiver;
import com.facebook.content.BroadcastReceiverLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.tools.dextr.runtime.LogUtils;

/* compiled from: editFavorites */
class AppInvitesInstallTracker$1 implements ActionReceiver {
    final /* synthetic */ AppInvitesInstallTracker f14606a;

    AppInvitesInstallTracker$1(AppInvitesInstallTracker appInvitesInstallTracker) {
        this.f14606a = appInvitesInstallTracker;
    }

    public void onReceive(Context context, Intent intent, BroadcastReceiverLike broadcastReceiverLike) {
        int a = Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_START, -1492033906);
        String str = null;
        if (intent.getData() != null) {
            str = intent.getData().getSchemeSpecificPart();
        }
        if (StringUtil.a(str)) {
            Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_END, 2068500891, a);
            return;
        }
        this.f14606a.b.b(str);
        AppInvitesInstallTrackingDataStore$AppInvitesTrackedApp b = this.f14606a.e.b(str);
        if (b != null) {
            if (this.f14606a.f.a() - b.f14609c > 86400000) {
                AppInvitesInstallTracker.a(this.f14606a, b.f14608b);
            } else {
                AppInvitesInstallTracker.a(this.f14606a, b);
            }
        }
        LogUtils.e(1846839783, a);
    }
}
