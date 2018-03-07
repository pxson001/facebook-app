package com.facebook.analytics.service;

import com.facebook.analytics.service.AnalyticsEventUploader.AlarmAction;

/* compiled from: time_zone */
class AnalyticsEventUploader$AlarmAction$UploadLogsRunnable implements Runnable {
    final /* synthetic */ AlarmAction f1910a;

    public AnalyticsEventUploader$AlarmAction$UploadLogsRunnable(AlarmAction alarmAction) {
        this.f1910a = alarmAction;
    }

    public void run() {
        AnalyticsEventUploader.k(this.f1910a.a);
    }
}
