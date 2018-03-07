package com.facebook.phoneid;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.facebook.device_id.DefaultPhoneIdStore;
import com.facebook.device_id.DefaultPhoneIdUpdatedCallback;
import com.facebook.device_id.DeviceIdChangedCallback;
import com.facebook.device_id.DeviceIdChangedCallback.ChangeType;
import com.facebook.device_id.FbPhoneIdSyncStatsReporter;
import com.facebook.device_id.UniqueDeviceId;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.tools.dextr.runtime.LogUtils;

/* compiled from: total_deleted */
public class PhoneIdResponseReceiver extends BroadcastReceiver {
    private final DefaultPhoneIdStore f896a;
    private final DefaultPhoneIdUpdatedCallback f897b;
    private final FbPhoneIdSyncStatsReporter f898c;
    private final Response f899d;

    public PhoneIdResponseReceiver(DefaultPhoneIdStore defaultPhoneIdStore, DefaultPhoneIdUpdatedCallback defaultPhoneIdUpdatedCallback, FbPhoneIdSyncStatsReporter fbPhoneIdSyncStatsReporter, Response response) {
        this.f896a = defaultPhoneIdStore;
        this.f897b = defaultPhoneIdUpdatedCallback;
        this.f898c = fbPhoneIdSyncStatsReporter;
        this.f899d = response;
    }

    public void onReceive(Context context, Intent intent) {
        int a = Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_START, -1072907436);
        this.f899d.f895f = System.currentTimeMillis();
        if (getResultCode() == -1) {
            String resultData = getResultData();
            long j = getResultExtras(true).getLong("timestamp", Long.MAX_VALUE);
            this.f899d.f891b = new PhoneId(resultData, j);
            m1226a();
        } else {
            this.f899d.f893d = Status.FAILED;
        }
        if (this.f898c != null) {
            this.f898c.m1216a(this.f899d);
        }
        LogUtils.a(intent, 668942137, a);
    }

    private void m1226a() {
        if (this.f899d.f891b.f887a == null) {
            this.f899d.f893d = Status.NULL;
            return;
        }
        Object obj = null;
        PhoneId b = this.f896a.m1207b();
        if (this.f899d.f891b.f888b < b.f888b) {
            this.f896a.m1205a(this.f899d.f891b);
            this.f899d.f893d = Status.OLDER;
            obj = 1;
        } else if (this.f899d.f891b.f888b == b.f888b && this.f899d.f891b.f887a.equals(b.f887a)) {
            this.f899d.f893d = Status.SAME;
        } else {
            this.f899d.f893d = Status.NEWER;
        }
        if (obj != null) {
            DefaultPhoneIdUpdatedCallback defaultPhoneIdUpdatedCallback = this.f897b;
            PhoneId phoneId = this.f899d.f891b;
            String str = this.f899d.f890a;
            UniqueDeviceId uniqueDeviceId = new UniqueDeviceId(b.f887a, b.f888b);
            UniqueDeviceId uniqueDeviceId2 = new UniqueDeviceId(phoneId.f887a, phoneId.f888b);
            for (DeviceIdChangedCallback a : defaultPhoneIdUpdatedCallback.f876a) {
                a.a(uniqueDeviceId, uniqueDeviceId2, ChangeType.GLOBAL_SYNC, str);
            }
        }
    }
}
