package com.facebook.device_id;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.facebook.common.time.Clock;
import com.facebook.debug.log.BLog;
import com.facebook.device_id.UniqueDeviceIdBroadcastSender.C00821;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.tools.dextr.runtime.LogUtils;
import javax.annotation.concurrent.ThreadSafe;
import javax.inject.Inject;

@ThreadSafe
/* compiled from: sync */
public class DeviceIdReceiver extends BroadcastReceiver {
    private static final Class<?> f1524a = DeviceIdReceiver.class;
    private final Clock f1525b;
    public volatile C00821 f1526c;

    @Inject
    public DeviceIdReceiver(Clock clock) {
        this.f1525b = clock;
    }

    public void onReceive(Context context, Intent intent) {
        UniqueDeviceId a;
        int a2 = Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_START, -1811600198);
        BLog.a(f1524a, "getting the id response");
        String resultData = getResultData();
        long j = getResultExtras(true).getLong("device_id_generated_timestamp_ms");
        if (getResultCode() != -1 || resultData == null) {
            a = UniqueIdForDeviceHolderImpl.a(this.f1525b);
            new StringBuilder("generating new id: ").append(a);
        } else {
            a = new UniqueDeviceId(resultData, j);
            new StringBuilder("response: ").append(a);
        }
        if (this.f1526c != null) {
            this.f1526c.m1745a(a);
        }
        LogUtils.a(intent, -714253992, a2);
    }
}
