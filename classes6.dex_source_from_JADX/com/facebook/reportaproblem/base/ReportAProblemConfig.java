package com.facebook.reportaproblem.base;

import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.support.annotation.Nullable;
import com.facebook.reportaproblem.base.bugreport.BugReportCategoryInfo;
import com.facebook.reportaproblem.base.bugreport.BugReportMetadata;
import com.facebook.reportaproblem.base.bugreport.file.ANRTraceFileProvider;
import com.facebook.reportaproblem.base.bugreport.file.BugReportActivityFileProvider;
import com.facebook.reportaproblem.base.bugreport.file.BugReportBackgroundDataProvider;
import com.facebook.reportaproblem.base.bugreport.file.BugReportFileProvider;
import com.facebook.reportaproblem.base.bugreport.file.BugReportUiDataProvider;
import com.facebook.reportaproblem.base.bugreport.file.ComponentDebugInfoDataProvider;
import com.facebook.reportaproblem.base.bugreport.file.DeviceInfoBackgroundDataProvider;
import com.facebook.reportaproblem.base.bugreport.file.IntentExtrasDataProvider;
import com.facebook.reportaproblem.base.bugreport.file.ScreenshotActivityFileProvider;
import com.facebook.reportaproblem.base.bugreport.file.StackTraceFileProvider;
import com.facebook.reportaproblem.base.dialog.BugReportCategoryChooserScreenController;
import com.facebook.reportaproblem.base.dialog.BugReportComposerScreenController;
import com.facebook.reportaproblem.base.dialog.BugReportSaveActivityInfoScreenController;
import com.facebook.reportaproblem.base.dialog.GeneralFeedbackScreenController;
import com.facebook.reportaproblem.base.dialog.ReportAProblemBaseScreenController;
import com.facebook.reportaproblem.base.dialog.ReportAProblemForkScreenController;
import com.facebook.reportaproblem.base.dialog.ReportAProblemThankYouScreenController;
import com.facebook.reportaproblem.fb.FbBitmapDecoder;
import com.facebook.reportaproblem.fb.FbBugReportUploader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* compiled from: shortened */
public abstract class ReportAProblemConfig {
    public final Context f4526a;

    /* compiled from: shortened */
    class C02681 implements Comparator<BugReportCategoryInfo> {
        final /* synthetic */ ReportAProblemConfig f4525a;

        C02681(ReportAProblemConfig reportAProblemConfig) {
            this.f4525a = reportAProblemConfig;
        }

        public int compare(Object obj, Object obj2) {
            return ((BugReportCategoryInfo) obj).f4541a.compareTo(((BugReportCategoryInfo) obj2).f4541a);
        }
    }

    protected abstract List<BugReportCategoryInfo> mo312e();

    public abstract String mo314i();

    public abstract String mo315j();

    public abstract FbBugReportUploader mo316k();

    public abstract FbBitmapDecoder mo317l();

    public ReportAProblemConfig(Context context) {
        this.f4526a = context;
    }

    public List<ReportAProblemForkOption> m7018a() {
        List arrayList = new ArrayList();
        arrayList.add(new ReportAProblemForkOption(this.f4526a.getString(2131235884), ReportAProblemConstants.f4528b, 2130842859));
        return arrayList;
    }

    public final List<BugReportCategoryInfo> m7020b() {
        List<BugReportCategoryInfo> e = mo312e();
        if (mo313h()) {
            e.addAll(m7024f());
        } else {
            e.addAll(m7025g());
        }
        Collections.sort(e, m7022d());
        return e;
    }

    @Nullable
    protected String m7021c() {
        return null;
    }

    protected Comparator<BugReportCategoryInfo> m7022d() {
        return new C02681(this);
    }

    protected List<BugReportCategoryInfo> m7024f() {
        return new ArrayList();
    }

    protected List<BugReportCategoryInfo> m7025g() {
        return new ArrayList();
    }

    protected boolean mo313h() {
        return false;
    }

    public Map<String, String> mo320m() {
        String typeName;
        Context context = this.f4526a;
        Map<String, String> linkedHashMap = new LinkedHashMap();
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo != null) {
            typeName = activeNetworkInfo.getTypeName();
        } else {
            typeName = null;
        }
        String str = typeName;
        activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo != null) {
            typeName = activeNetworkInfo.getSubtypeName();
        } else {
            typeName = null;
        }
        String str2 = typeName;
        linkedHashMap.put("build_num", BugReportMetadata.m7038b(context));
        if (!(str == null || str.isEmpty())) {
            linkedHashMap.put("network_type", str);
        }
        if (!(str2 == null || str2.isEmpty())) {
            linkedHashMap.put("network_subtype", str2);
        }
        return linkedHashMap;
    }

    public List<BugReportFileProvider> mo321n() {
        List<BugReportFileProvider> arrayList = new ArrayList();
        arrayList.add(new StackTraceFileProvider());
        arrayList.add(new ANRTraceFileProvider());
        return arrayList;
    }

    public List<BugReportActivityFileProvider> mo322o() {
        List<BugReportActivityFileProvider> arrayList = new ArrayList();
        arrayList.add(new ScreenshotActivityFileProvider());
        return arrayList;
    }

    public List<BugReportUiDataProvider> mo323p() {
        List<BugReportUiDataProvider> arrayList = new ArrayList();
        arrayList.add(new IntentExtrasDataProvider());
        arrayList.add(new ComponentDebugInfoDataProvider());
        return arrayList;
    }

    public List<BugReportBackgroundDataProvider> mo324q() {
        List<BugReportBackgroundDataProvider> arrayList = new ArrayList();
        arrayList.add(new DeviceInfoBackgroundDataProvider());
        return arrayList;
    }

    public static String m7015r() {
        return ReportAProblemConstants.f4534h;
    }

    public final ReportAProblemBaseScreenController m7016a(String str) {
        if (str.equals(ReportAProblemConstants.f4527a)) {
            return new ReportAProblemForkScreenController(m7018a());
        }
        if (str.equals(ReportAProblemConstants.f4528b)) {
            return new BugReportSaveActivityInfoScreenController(mo322o(), mo323p());
        }
        if (str.equals(ReportAProblemConstants.f4533g)) {
            Object obj = 1;
            if (m7020b().size() <= 1) {
                obj = null;
            }
            return obj != null ? m7016a(ReportAProblemConstants.f4529c) : m7016a(ReportAProblemConstants.f4530d);
        } else if (str.equals(ReportAProblemConstants.f4529c)) {
            return new BugReportCategoryChooserScreenController(m7020b(), m7021c());
        } else {
            if (str.equals(ReportAProblemConstants.f4530d)) {
                return new BugReportComposerScreenController();
            }
            if (str.equals(ReportAProblemConstants.f4531e)) {
                return new GeneralFeedbackScreenController();
            }
            if (str.equals(ReportAProblemConstants.f4532f)) {
                return new ReportAProblemThankYouScreenController(null);
            }
            throw new IllegalArgumentException("No screen controller for unrecognized tag: " + str);
        }
    }

    public void mo319a(Uri uri, Activity activity) {
        throw new IllegalArgumentException("Your fork has uri's, you need to implement this");
    }

    public String mo318a(Activity activity) {
        return activity.getLocalClassName();
    }
}
