package com.facebook.common.errorreporting;

import android.net.Uri;
import com.facebook.acra.ErrorReporter;
import com.facebook.reportaproblem.base.bugreport.file.BugReportFile;
import com.facebook.reportaproblem.base.bugreport.file.BugReportFileProvider;
import com.google.common.collect.Lists;
import com.google.common.io.Closeables;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

/* compiled from: sticky_megaphone */
public class ACRAReportFileProvider implements BugReportFileProvider {
    public List<BugReportFile> getFilesFromWorkerThread(File file) {
        Throwable e;
        List<BugReportFile> a = Lists.a();
        File file2 = new File(file, "acra_log.txt");
        Closeable fileOutputStream;
        try {
            fileOutputStream = new FileOutputStream(file2);
            try {
                ErrorReporter.getInstance().writeReportToStream(null, fileOutputStream);
                a.add(new BugReportFile("acra_log.txt", Uri.fromFile(file2).toString(), "text/plain"));
                Closeables.a(fileOutputStream, false);
                return a;
            } catch (Exception e2) {
                e = e2;
                try {
                    throw new IOException("Failed to write ACRA log for bug report", e);
                } catch (Throwable th) {
                    e = th;
                    if (fileOutputStream != null) {
                        Closeables.a(fileOutputStream, false);
                    }
                    throw e;
                }
            }
        } catch (Exception e3) {
            e = e3;
            fileOutputStream = null;
            throw new IOException("Failed to write ACRA log for bug report", e);
        } catch (Throwable th2) {
            e = th2;
            fileOutputStream = null;
            if (fileOutputStream != null) {
                Closeables.a(fileOutputStream, false);
            }
            throw e;
        }
    }
}
