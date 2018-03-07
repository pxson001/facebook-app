package com.facebook.reportaproblem.base.bugreport.file;

import android.app.Activity;
import android.content.Intent;
import java.util.HashMap;
import java.util.Map;

/* compiled from: setUseOptimisticPosting */
public class IntentExtrasDataProvider implements BugReportUiDataProvider {
    public final Map<String, String> m7053a(Activity activity) {
        Map<String, String> hashMap = new HashMap();
        Intent intent = activity.getIntent();
        if (!(intent == null || intent.getExtras() == null)) {
            hashMap.put("intent_extras", intent.getExtras().toString());
        }
        return hashMap;
    }
}
