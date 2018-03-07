package com.facebook.account.recovery.helper;

import com.facebook.account.recovery.constants.AccountRecoveryPrefKeys;
import com.facebook.debug.log.BLog;
import com.facebook.growth.model.DeviceOwnerData;
import com.google.common.util.concurrent.FutureCallback;
import javax.annotation.Nullable;

/* compiled from: local_content_padding_top */
public class DeviceOwnerDataBackgroundHelper$1 implements FutureCallback<DeviceOwnerData> {
    final /* synthetic */ DeviceOwnerDataBackgroundHelper f10302a;

    public DeviceOwnerDataBackgroundHelper$1(DeviceOwnerDataBackgroundHelper deviceOwnerDataBackgroundHelper) {
        this.f10302a = deviceOwnerDataBackgroundHelper;
    }

    public void onSuccess(@Nullable Object obj) {
        DeviceOwnerData deviceOwnerData = (DeviceOwnerData) obj;
        if (deviceOwnerData != null) {
            this.f10302a.c.edit().a(AccountRecoveryPrefKeys.f10215a, DeviceOwnerDataBackgroundHelper.a(this.f10302a, deviceOwnerData)).commit();
        }
    }

    public void onFailure(Throwable th) {
        BLog.b(DeviceOwnerDataBackgroundHelper.a, "Account Recovery Parallel Search Device Data fetch failed", th);
    }
}
