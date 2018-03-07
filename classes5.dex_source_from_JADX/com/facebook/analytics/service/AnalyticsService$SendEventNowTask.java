package com.facebook.analytics.service;

import com.facebook.analytics.HoneyAnalyticsEvent;
import com.facebook.analytics.webmethod.AnalyticsServerResponse;
import com.facebook.common.executors.FbAsyncTask;
import com.facebook.debug.log.BLog;
import java.util.List;

/* compiled from: time_values */
class AnalyticsService$SendEventNowTask extends FbAsyncTask<List<HoneyAnalyticsEvent>, Void, Void> {
    final /* synthetic */ AnalyticsService f1911a;

    public AnalyticsService$SendEventNowTask(AnalyticsService analyticsService) {
        this.f1911a = analyticsService;
    }

    protected final Object m2595a(Object[] objArr) {
        AnalyticsServerResponse a;
        Throwable e;
        List[] listArr = (List[]) objArr;
        if (listArr.length == 1) {
            List list = listArr[0];
            try {
                a = ((HoneyAnalyticsUploadHandler) this.f1911a.h.get()).a(list);
                try {
                    AnalyticsService.b();
                } catch (Exception e2) {
                    e = e2;
                    BLog.a(AnalyticsService.a, "Error uploading immediate events. Falling back to regular event uploading pipeline.", e);
                    if (a == null) {
                        this.f1911a.g.a(list);
                    }
                    return null;
                }
            } catch (Exception e3) {
                e = e3;
                a = null;
                BLog.a(AnalyticsService.a, "Error uploading immediate events. Falling back to regular event uploading pipeline.", e);
                if (a == null) {
                    this.f1911a.g.a(list);
                }
                return null;
            }
            if (a == null) {
                this.f1911a.g.a(list);
            }
        }
        return null;
    }
}
