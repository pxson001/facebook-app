package com.facebook.reportaproblem.base.bugreport.file;

import android.net.Uri;
import com.facebook.reportaproblem.base.ReportAProblemConstants;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/* compiled from: share_preview */
public class ANRTraceFileProvider implements BugReportFileProvider {
    public List<BugReportFile> getFilesFromWorkerThread(File file) {
        List<BugReportFile> arrayList = new ArrayList();
        File file2 = new File(file, "traces.txt");
        BugReportFileHelper.m7049a(new File("/data/anr/traces.txt"), file2);
        arrayList.add(new BugReportFile("traces.txt", Uri.fromFile(file2).toString(), ReportAProblemConstants.f4535i));
        return arrayList;
    }
}
