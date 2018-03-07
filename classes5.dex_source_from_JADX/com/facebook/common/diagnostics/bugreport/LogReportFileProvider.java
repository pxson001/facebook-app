package com.facebook.common.diagnostics.bugreport;

import android.net.Uri;
import com.facebook.common.diagnostics.LogReportFetcher;
import com.facebook.reportaproblem.base.bugreport.file.BugReportFile;
import com.facebook.reportaproblem.base.bugreport.file.BugReportFileProvider;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.google.common.io.Files;
import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import javax.inject.Inject;

/* compiled from: store_context */
public class LogReportFileProvider implements BugReportFileProvider {
    private final LogReportFetcher f2523a;

    @Inject
    public LogReportFileProvider(LogReportFetcher logReportFetcher) {
        this.f2523a = logReportFetcher;
    }

    public List<BugReportFile> getFilesFromWorkerThread(File file) {
        Throwable th;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd-HHmmss", Locale.US);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("Etc/UTC"));
        List<BugReportFile> a = Lists.a();
        ImmutableList a2 = this.f2523a.m3640a(3);
        int size = a2.size();
        int i = 0;
        while (i < size) {
            FileOutputStream fileOutputStream;
            File file2 = (File) a2.get(i);
            try {
                String str = "debuglog-" + simpleDateFormat.format(new Date(file2.lastModified())) + ".txt";
                File file3 = new File(file, str);
                fileOutputStream = new FileOutputStream(file3);
                try {
                    Files.a(file2, fileOutputStream);
                    a.add(new BugReportFile(str, Uri.fromFile(file3).toString(), "text/plain"));
                    fileOutputStream.close();
                    i++;
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Throwable th3) {
                th = th3;
                fileOutputStream = null;
            }
        }
        return a;
        if (fileOutputStream != null) {
            fileOutputStream.close();
        }
        throw th;
    }
}
