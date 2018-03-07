package com.facebook.reportaproblem.fb.dataprovider;

import android.app.Activity;
import com.facebook.analytics.tagging.AnalyticsActivity;
import com.facebook.reportaproblem.base.bugreport.file.BugReportUiDataProvider;
import com.google.common.collect.Maps;
import java.util.Map;

/* compiled from: setMinutiaeObjectTag */
public class AnalyticsTagDataProvider implements BugReportUiDataProvider {
    public final Map<String, String> m7135a(Activity activity) {
        Map<String, String> c = Maps.c();
        if (activity instanceof AnalyticsActivity) {
            String am_ = ((AnalyticsActivity) activity).am_();
            if (am_ != null) {
                c.put("activity_analytics_tag", am_.toString());
            }
        }
        return c;
    }
}
