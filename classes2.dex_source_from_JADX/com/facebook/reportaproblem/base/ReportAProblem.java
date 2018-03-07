package com.facebook.reportaproblem.base;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import com.facebook.reportaproblem.base.dialog.ReportAProblemDialogFragment;
import com.facebook.reportaproblem.fb.FbReportAProblemConfigProvider;
import java.util.ArrayList;

/* compiled from: zero_rating2/clearable/backup_rewrite_rules */
public class ReportAProblem {
    private static FbReportAProblemConfigProvider f497a;

    public static synchronized void m1030a(FbReportAProblemConfigProvider fbReportAProblemConfigProvider) {
        synchronized (ReportAProblem.class) {
            f497a = fbReportAProblemConfigProvider;
        }
    }

    public static synchronized ReportAProblemConfig m1028a() {
        ReportAProblemConfig a;
        synchronized (ReportAProblem.class) {
            if (f497a == null) {
                throw new IllegalStateException("Config Provider should be set in the app's onCreate");
            }
            a = f497a.m1027a();
        }
        return a;
    }

    public static void m1029a(FragmentActivity fragmentActivity) {
        FragmentManager kO_ = fragmentActivity.kO_();
        if (kO_.mo841a(ReportAProblemDialogFragment.class.getSimpleName()) == null) {
            FragmentTransaction a = kO_.mo842a();
            Bundle bundle = new Bundle();
            m1028a();
            bundle.putString("com.facebook.reportaproblem.base.dialog.CurrentScreen", ReportAProblemConstants.a);
            Bundle bundle2 = new Bundle();
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            bundle2.putParcelableArrayList("param_key_bug_report_activity_files", arrayList);
            bundle2.putParcelableArrayList("param_key_bug_report_screenshot_files", arrayList2);
            bundle.putBundle("com.facebook.reportaproblem.base.dialog.ParamBundle", bundle2);
            ReportAProblemDialogFragment reportAProblemDialogFragment = new ReportAProblemDialogFragment();
            reportAProblemDialogFragment.m271g(bundle);
            ReportAProblemDialogFragment reportAProblemDialogFragment2 = reportAProblemDialogFragment;
            if (null != null) {
                reportAProblemDialogFragment2.as = null;
            }
            reportAProblemDialogFragment2.m208a(a, ReportAProblemDialogFragment.class.getSimpleName());
        }
    }
}
