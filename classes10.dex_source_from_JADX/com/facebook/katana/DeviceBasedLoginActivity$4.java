package com.facebook.katana;

import com.facebook.debug.log.BLog;
import com.facebook.fbservice.service.OperationResult;
import com.google.common.util.concurrent.FutureCallback;

/* compiled from: SEGMENT_UPLOADING_FAILURE */
class DeviceBasedLoginActivity$4 implements FutureCallback<OperationResult> {
    final /* synthetic */ DeviceBasedLoginActivity f24176a;

    DeviceBasedLoginActivity$4(DeviceBasedLoginActivity deviceBasedLoginActivity) {
        this.f24176a = deviceBasedLoginActivity;
    }

    public void onSuccess(Object obj) {
        if (DeviceBasedLoginActivity.r(this.f24176a)) {
            DeviceBasedLoginActivity.p(this.f24176a).b();
            DeviceBasedLoginActivity.n(this.f24176a);
        }
    }

    public void onFailure(Throwable th) {
        BLog.b(DeviceBasedLoginActivity.O, "Fetch nonce operation failed");
        if (DeviceBasedLoginActivity.r(this.f24176a)) {
            DeviceBasedLoginActivity.p(this.f24176a).b();
            DeviceBasedLoginActivity.n(this.f24176a);
        }
    }
}
