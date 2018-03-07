package com.facebook.appupdate;

/* compiled from: UNINVITED */
public class PersistNotStartedOperationTask implements AppUpdateTask {
    public final AppUpdateTaskResult mo1098a(AppUpdateState appUpdateState) {
        if (appUpdateState.operationState == 0) {
            return new AppUpdateTaskResult(appUpdateState);
        }
        return new AppUpdateTaskResult();
    }
}
