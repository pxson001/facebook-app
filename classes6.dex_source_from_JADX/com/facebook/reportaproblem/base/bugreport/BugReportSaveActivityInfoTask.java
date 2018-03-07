package com.facebook.reportaproblem.base.bugreport;

import android.app.Activity;
import android.os.AsyncTask;
import android.util.Log;
import com.facebook.reportaproblem.base.ReportAProblemConstants;
import com.facebook.reportaproblem.base.bugreport.file.BugReportActivityFileProvider;
import com.facebook.reportaproblem.base.bugreport.file.BugReportFile;
import com.facebook.reportaproblem.base.bugreport.file.BugReportFileFormatter;
import com.facebook.reportaproblem.base.bugreport.file.BugReportUiDataProvider;
import com.facebook.reportaproblem.base.bugreport.file.ScreenshotActivityFileProvider;
import com.facebook.reportaproblem.base.dialog.BugReportSaveActivityInfoScreenController;
import com.facebook.reportaproblem.base.dialog.ReportAProblemBaseScreenController;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* compiled from: sharedposts */
public class BugReportSaveActivityInfoTask extends AsyncTask<Void, BugReportFile, List<BugReportFile>> {
    private static final Class<?> f4555a = BugReportSaveActivityInfoTask.class;
    private BugReportSaveActivityInfoScreenController f4556b;
    private final File f4557c;
    private final List<BugReportActivityFileProvider> f4558d;
    private final Map<String, String> f4559e = new LinkedHashMap();
    private final List<BugReportUiDataProvider> f4560f;
    private final WeakReference<Activity> f4561g;

    protected void onPostExecute(Object obj) {
        List list = (List) obj;
        if (this.f4556b != null) {
            ReportAProblemBaseScreenController reportAProblemBaseScreenController = this.f4556b;
            reportAProblemBaseScreenController.f4566a.ap().getParcelableArrayList("param_key_bug_report_activity_files").addAll(list);
            reportAProblemBaseScreenController.f4566a.m7090a(ReportAProblemConstants.f4533g);
        }
    }

    protected void onProgressUpdate(Object[] objArr) {
        BugReportFile[] bugReportFileArr = (BugReportFile[]) objArr;
        if (this.f4556b != null) {
            ReportAProblemBaseScreenController reportAProblemBaseScreenController = this.f4556b;
            reportAProblemBaseScreenController.f4566a.ar().add(bugReportFileArr[0]);
        }
    }

    public BugReportSaveActivityInfoTask(BugReportSaveActivityInfoScreenController bugReportSaveActivityInfoScreenController, File file, List<BugReportActivityFileProvider> list, List<BugReportUiDataProvider> list2, Activity activity) {
        this.f4556b = bugReportSaveActivityInfoScreenController;
        this.f4557c = file;
        this.f4558d = list;
        this.f4560f = list2;
        this.f4561g = new WeakReference(activity);
    }

    protected void onPreExecute() {
        Activity activity = (Activity) this.f4561g.get();
        if (activity != null) {
            for (BugReportActivityFileProvider a : this.f4558d) {
                a.a(activity);
            }
            for (BugReportUiDataProvider a2 : this.f4560f) {
                Map a3 = a2.a(activity);
                if (a3 != null) {
                    this.f4559e.putAll(a3);
                }
            }
        }
    }

    protected Object doInBackground(Object[] objArr) {
        List arrayList = new ArrayList();
        m7042a(arrayList);
        m7043b(arrayList);
        return arrayList;
    }

    private void m7042a(List<BugReportFile> list) {
        for (BugReportActivityFileProvider bugReportActivityFileProvider : this.f4558d) {
            if (!isCancelled()) {
                try {
                    BugReportFile a = bugReportActivityFileProvider.a(this.f4557c);
                    if (bugReportActivityFileProvider instanceof ScreenshotActivityFileProvider) {
                        publishProgress(new BugReportFile[]{a});
                    } else if (a != null) {
                        list.add(a);
                    }
                } catch (Throwable e) {
                    Log.w(f4555a.getName(), "Failed to save file for provider: " + bugReportActivityFileProvider.getClass().getSimpleName(), e);
                }
            }
        }
    }

    private void m7043b(List<BugReportFile> list) {
        try {
            list.add(BugReportFileFormatter.a(this.f4557c, "extra_data.txt", this.f4559e));
        } catch (Throwable e) {
            Log.w(f4555a.getName(), "Failed to save extra_data_ui", e);
        }
    }

    protected void onCancelled(Object obj) {
        this.f4556b = null;
    }
}
