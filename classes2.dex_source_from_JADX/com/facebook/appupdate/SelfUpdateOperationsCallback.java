package com.facebook.appupdate;

/* compiled from: random_sampling */
public class SelfUpdateOperationsCallback implements AppUpdateOperation$StateCallback {
    private final AppUpdateOperationFactory f8293a;

    public SelfUpdateOperationsCallback(AppUpdateOperationFactory appUpdateOperationFactory) {
        this.f8293a = appUpdateOperationFactory;
    }

    public final void mo1727a(AppUpdateOperation appUpdateOperation, AppUpdateState appUpdateState) {
        if (appUpdateState.isSelfUpdate && appUpdateState.operationState == 4) {
            for (AppUpdateOperation appUpdateOperation2 : this.f8293a.m12801c()) {
                AppUpdateState c = appUpdateOperation2.c();
                if (appUpdateOperation2 != appUpdateOperation && c.isSelfUpdate && appUpdateState.releaseInfo.versionCode >= c.releaseInfo.versionCode) {
                    this.f8293a.m12799a(appUpdateOperation2);
                }
            }
        }
    }
}
