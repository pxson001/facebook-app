package com.facebook.reportaproblem.base.bugreport.file;

import android.os.AsyncTask;
import java.io.File;

/* compiled from: shareTracking */
public class BugReportDeleteDirectoryTask extends AsyncTask<File, Void, Void> {
    protected Object doInBackground(Object[] objArr) {
        BugReportFileHelper.m7048a(((File[]) objArr)[0]);
        return null;
    }
}
