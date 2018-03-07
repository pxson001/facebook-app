package com.facebook.reportaproblem.base.bugreport;

import android.app.IntentService;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import com.facebook.reportaproblem.base.ReportAProblem;
import com.facebook.reportaproblem.base.ReportAProblemConfig;
import com.facebook.reportaproblem.base.bugreport.file.BugReportBackgroundDataProvider;
import com.facebook.reportaproblem.base.bugreport.file.BugReportFileFormatter;
import com.facebook.reportaproblem.base.bugreport.file.BugReportFileHelper;
import com.facebook.reportaproblem.base.bugreport.file.BugReportFileProvider;
import java.io.File;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/* compiled from: share_tracking */
public class BugReportUploadService extends IntentService {
    private static final Class<?> f4563a = BugReportUploadService.class;

    public BugReportUploadService() {
        super("BugReportUploadService");
    }

    protected void onHandleIntent(Intent intent) {
        ReportAProblemConfig a = ReportAProblem.a();
        Bundle extras = intent.getExtras();
        if (extras != null) {
            long b;
            String string = extras.getString("param_key_bug_report_description");
            String string2 = extras.getString("param_key_report_directory");
            String string3 = extras.getString("param_key_current_activity");
            Collection parcelableArrayList = extras.getParcelableArrayList("param_key_bug_report_screenshot_files");
            Collection parcelableArrayList2 = extras.getParcelableArrayList("param_key_bug_report_activity_files");
            Set hashSet = new HashSet();
            hashSet.addAll(parcelableArrayList);
            hashSet.addAll(parcelableArrayList2);
            BugReportCategoryInfo bugReportCategoryInfo = (BugReportCategoryInfo) extras.getParcelable("param_key_category_info");
            if (bugReportCategoryInfo == null) {
                b = ((BugReportCategoryInfo) a.m7020b().get(0)).m7037b();
            } else {
                b = bugReportCategoryInfo.m7037b();
            }
            File file = new File(string2);
            for (BugReportFileProvider bugReportFileProvider : a.mo321n()) {
                try {
                    hashSet.addAll(bugReportFileProvider.getFilesFromWorkerThread(file));
                } catch (Throwable e) {
                    Log.w(f4563a.getName(), "Failed to create file for provider: " + bugReportFileProvider.getClass().getSimpleName(), e);
                }
            }
            Map linkedHashMap = new LinkedHashMap();
            for (BugReportBackgroundDataProvider b2 : a.mo324q()) {
                linkedHashMap.putAll(b2.b());
            }
            try {
                hashSet.add(BugReportFileFormatter.a(file, "extra_data.txt", linkedHashMap));
            } catch (Throwable e2) {
                Log.w(f4563a.getName(), "Failed to save background data", e2);
            }
            a.mo316k().m7120a(new BugReportRequest(a.mo314i(), ReportAProblemConfig.m7015r(), a.mo315j(), m7047a(string, string3, b, a.mo320m()), hashSet));
            BugReportFileHelper.m7048a(file);
        }
    }

    private static Map<String, String> m7047a(String str, String str2, long j, Map<String, String> map) {
        Map<String, String> linkedHashMap = new LinkedHashMap(map);
        linkedHashMap.put("description", str);
        linkedHashMap.put("category_id", Long.toString(j));
        linkedHashMap.put("current_activity", str2);
        return linkedHashMap;
    }
}
