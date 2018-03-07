package com.facebook.common.errorreporting.init;

import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.device_id.DeviceIdChangedCallback;
import com.facebook.device_id.DeviceIdChangedCallback.ChangeType;
import com.facebook.device_id.UniqueDeviceId;
import javax.inject.Inject;

/* compiled from: UINT64 */
public class ErrorReporterDeviceIdChangedCallback implements DeviceIdChangedCallback {
    private final AbstractFbErrorReporter f23841a;

    public final void m25846a(UniqueDeviceId uniqueDeviceId, UniqueDeviceId uniqueDeviceId2, ChangeType changeType, String str) {
        String str2 = uniqueDeviceId2.a;
        if (str2 != null) {
            this.f23841a.c("marauder_device_id", str2);
            new StringBuilder("ErrorReporter DEVICE_ID_KEY set to: ").append(str2);
        }
    }

    @Inject
    public ErrorReporterDeviceIdChangedCallback(AbstractFbErrorReporter abstractFbErrorReporter) {
        this.f23841a = abstractFbErrorReporter;
    }
}
