package com.facebook.reportaproblem.base.bugreport.file;

import android.app.Activity;
import com.facebook.bugreporter.activity.ComponentWithDebugInfo;
import java.util.Map;

/* compiled from: set_widest */
public class ComponentDebugInfoDataProvider implements BugReportUiDataProvider {
    public final Map<String, String> m7051a(Activity activity) {
        if (activity instanceof ComponentWithDebugInfo) {
            return ((ComponentWithDebugInfo) activity).getDebugInfo();
        }
        return null;
    }
}
