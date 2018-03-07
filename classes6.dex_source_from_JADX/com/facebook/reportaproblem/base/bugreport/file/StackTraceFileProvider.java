package com.facebook.reportaproblem.base.bugreport.file;

import android.net.Uri;
import com.facebook.reportaproblem.base.ReportAProblemConstants;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;

/* compiled from: setTopicFeedId */
public class StackTraceFileProvider implements BugReportFileProvider {
    public List<BugReportFile> getFilesFromWorkerThread(File file) {
        FileOutputStream fileOutputStream;
        Throwable th;
        List<BugReportFile> arrayList = new ArrayList();
        File file2 = new File(file, "stacktrace-dump.txt");
        try {
            fileOutputStream = new FileOutputStream(file2);
            try {
                m7056a(fileOutputStream);
                fileOutputStream.close();
                arrayList.add(new BugReportFile("stacktrace-dump.txt", Uri.fromFile(file2).toString(), ReportAProblemConstants.f4535i));
                return arrayList;
            } catch (Throwable th2) {
                th = th2;
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            fileOutputStream = null;
            if (fileOutputStream != null) {
                fileOutputStream.close();
            }
            throw th;
        }
    }

    private static void m7056a(OutputStream outputStream) {
        PrintWriter printWriter = new PrintWriter(outputStream);
        for (Entry entry : Thread.getAllStackTraces().entrySet()) {
            printWriter.print(entry.getKey());
            printWriter.print(" ");
            printWriter.print(((Thread) entry.getKey()).getState());
            printWriter.println(":");
            for (Object println : (StackTraceElement[]) entry.getValue()) {
                printWriter.println(println);
            }
            printWriter.println();
        }
        printWriter.flush();
    }
}
