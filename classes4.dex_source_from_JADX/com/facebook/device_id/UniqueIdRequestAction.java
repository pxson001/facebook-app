package com.facebook.device_id;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.facebook.common.init.AppInitLockHelper;
import com.facebook.content.ActionReceiver;
import com.facebook.content.BroadcastReceiverLike;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.tools.dextr.runtime.LogUtils;
import javax.inject.Inject;

/* compiled from: sw_ec_mode */
public class UniqueIdRequestAction implements ActionReceiver {
    private static final Class<?> f1529c = UniqueIdRequestAction.class;
    @Inject
    @ShareDeviceId
    public Boolean f1530a;
    @Inject
    public FbSharedPreferences f1531b;

    public static void m1746a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        UniqueIdRequestAction uniqueIdRequestAction = (UniqueIdRequestAction) obj;
        Boolean a = Boolean_ShareDeviceIdMethodAutoProvider.m1202a(fbInjector);
        FbSharedPreferences fbSharedPreferences = (FbSharedPreferences) FbSharedPreferencesImpl.a(fbInjector);
        uniqueIdRequestAction.f1530a = a;
        uniqueIdRequestAction.f1531b = fbSharedPreferences;
    }

    UniqueIdRequestAction() {
    }

    public void onReceive(Context context, Intent intent, BroadcastReceiverLike broadcastReceiverLike) {
        int a = Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_START, 1650576020);
        AppInitLockHelper.a(context);
        Class cls = UniqueIdRequestAction.class;
        m1746a(this, context);
        if (this.f1530a.booleanValue()) {
            UniqueDeviceId uniqueDeviceId;
            if (broadcastReceiverLike.getResultCode() == -1) {
                uniqueDeviceId = new UniqueDeviceId(broadcastReceiverLike.getResultData(), broadcastReceiverLike.getResultExtras(true).getLong("device_id_generated_timestamp_ms", Long.MAX_VALUE));
            } else {
                uniqueDeviceId = null;
            }
            String a2 = this.f1531b.a(DeviceIdPrefKeys.a, null);
            long a3 = this.f1531b.a(DeviceIdPrefKeys.b, Long.MAX_VALUE);
            if (a2 == null || a3 == Long.MAX_VALUE) {
                LogUtils.e(633134704, a);
                return;
            } else if (uniqueDeviceId == null || a3 <= uniqueDeviceId.b) {
                broadcastReceiverLike.setResultCode(-1);
                broadcastReceiverLike.setResultData(a2);
                Bundle bundle = new Bundle();
                bundle.putLong("device_id_generated_timestamp_ms", a3);
                broadcastReceiverLike.setResultExtras(bundle);
                new StringBuilder("device id found: ").append(a2);
                LogUtils.e(378283618, a);
                return;
            } else {
                LogUtils.e(693839753, a);
                return;
            }
        }
        Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_END, 807856847, a);
    }
}
