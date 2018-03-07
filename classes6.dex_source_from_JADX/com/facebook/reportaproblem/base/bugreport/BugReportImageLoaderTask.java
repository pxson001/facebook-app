package com.facebook.reportaproblem.base.bugreport;

import android.graphics.Bitmap;
import android.os.AsyncTask;
import com.facebook.reportaproblem.base.ReportAProblem;
import com.facebook.reportaproblem.base.dialog.BugReportComposerScreenController;
import java.io.File;

/* compiled from: shoebox */
public class BugReportImageLoaderTask extends AsyncTask<File, Void, Bitmap> {
    private BugReportComposerScreenController f4547a;
    private final int f4548b;
    private File f4549c;

    protected Object doInBackground(Object[] objArr) {
        File[] fileArr = (File[]) objArr;
        if (fileArr.length != 1) {
            throw new IllegalArgumentException("Pass in only one screenshot to be loaded");
        }
        this.f4549c = fileArr[0];
        return ReportAProblem.a().mo317l().m7115a(this.f4549c, this.f4548b, this.f4548b);
    }

    protected void onCancelled(Object obj) {
        this.f4547a = null;
        this.f4549c = null;
    }

    protected void onPostExecute(Object obj) {
        Bitmap bitmap = (Bitmap) obj;
        if (this.f4547a != null) {
            this.f4547a.m7073a(bitmap, this.f4549c, this);
        }
    }

    public BugReportImageLoaderTask(BugReportComposerScreenController bugReportComposerScreenController, int i) {
        this.f4547a = bugReportComposerScreenController;
        this.f4548b = i;
    }
}
