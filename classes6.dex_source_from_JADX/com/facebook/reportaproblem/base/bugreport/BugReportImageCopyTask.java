package com.facebook.reportaproblem.base.bugreport;

import android.content.ContentResolver;
import android.net.Uri;
import android.os.AsyncTask;
import android.util.Log;
import com.facebook.reportaproblem.base.bugreport.file.BugReportFileHelper;
import com.facebook.reportaproblem.base.dialog.BugReportComposerScreenController;
import java.io.File;
import java.io.FileOutputStream;

/* compiled from: shopping */
public class BugReportImageCopyTask extends AsyncTask<Uri, Void, File> {
    private final File f4544a;
    private final ContentResolver f4545b;
    private BugReportComposerScreenController f4546c;

    protected Object doInBackground(Object[] objArr) {
        Uri[] uriArr = (Uri[]) objArr;
        File file = new File(this.f4544a, "screenshot" + Long.toString(System.currentTimeMillis()));
        try {
            BugReportFileHelper.m7050a(this.f4545b.openInputStream(uriArr[0]), new FileOutputStream(file));
            return file;
        } catch (Throwable e) {
            Log.w("", "Failed to copy image to bugreport folder", e);
            return null;
        }
    }

    protected void onPostExecute(Object obj) {
        File file = (File) obj;
        if (this.f4546c != null) {
            this.f4546c.m7074a(file, this);
        }
    }

    public BugReportImageCopyTask(File file, ContentResolver contentResolver, BugReportComposerScreenController bugReportComposerScreenController) {
        this.f4544a = file;
        this.f4545b = contentResolver;
        this.f4546c = bugReportComposerScreenController;
    }

    protected void onCancelled() {
        this.f4546c = null;
    }
}
