package com.facebook.backgroundlocation.reporting;

import android.content.Context;
import android.content.Intent;
import com.facebook.backgroundlocation.reporting.abtest.ExperimentsForBackgroundLocationReportingModule;
import com.facebook.content.ActionReceiver;
import com.facebook.content.BroadcastReceiverLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.qe.api.ExposureLogging;
import com.facebook.qe.api.Liveness;

/* compiled from: discover_list */
class BackgroundLocationReportingNewImplManager$1 implements ActionReceiver {
    final /* synthetic */ BackgroundLocationReportingNewImplManager f14891a;

    BackgroundLocationReportingNewImplManager$1(BackgroundLocationReportingNewImplManager backgroundLocationReportingNewImplManager) {
        this.f14891a = backgroundLocationReportingNewImplManager;
    }

    public void onReceive(Context context, Intent intent, BroadcastReceiverLike broadcastReceiverLike) {
        int a = Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_START, -1299971285);
        if (intent.getBooleanExtra("extra_has_explicit_place", false) && this.f14891a.d.a(Liveness.Live, ExposureLogging.On, ExperimentsForBackgroundLocationReportingModule.r, false)) {
            this.f14891a.a();
        }
        Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_END, 1449153349, a);
    }
}
