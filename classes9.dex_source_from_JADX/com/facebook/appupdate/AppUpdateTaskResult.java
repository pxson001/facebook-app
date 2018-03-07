package com.facebook.appupdate;

import javax.annotation.Nullable;

/* compiled from: UNLINK_BUSINESS */
public class AppUpdateTaskResult {
    @Nullable
    public final AppUpdateState f23813a;
    @Nullable
    public final AppUpdateTask f23814b;
    public final long f23815c;

    public AppUpdateTaskResult() {
        this.f23813a = null;
        this.f23814b = null;
        this.f23815c = -1;
    }

    public AppUpdateTaskResult(AppUpdateState appUpdateState) {
        this.f23813a = appUpdateState;
        this.f23814b = null;
        this.f23815c = -1;
    }

    public AppUpdateTaskResult(AppUpdateState appUpdateState, AppUpdateTask appUpdateTask, long j) {
        this.f23813a = appUpdateState;
        this.f23814b = appUpdateTask;
        this.f23815c = j;
    }
}
