package com.facebook.analytics2.logger;

import android.os.Handler;
import android.os.Message;
import com.facebook.analytics2.logger.UploadSchedulerNoDelayHack.WakeLockReleaseHandler;
import com.facebook.analytics2.logger.UploadServiceLogic.StartServiceParams;

/* compiled from: theme_image */
class UploadServiceLogic$StartServiceParams$ServiceCallbackHandler extends Handler {
    private final WakeLockReleaseHandler f2086a;

    public UploadServiceLogic$StartServiceParams$ServiceCallbackHandler(WakeLockReleaseHandler wakeLockReleaseHandler) {
        this.f2086a = wakeLockReleaseHandler;
    }

    public void handleMessage(Message message) {
        this.f2086a.f2074a.release();
        StartServiceParams.h().remove(this);
    }
}
