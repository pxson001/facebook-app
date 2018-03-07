package com.facebook.reportaproblem.base.bugreport.file;

import android.net.Uri;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Map;

/* compiled from: content */
public class BugReportFileFormatter {
    public static BugReportFile m10145a(File file, String str, Map<String, String> map) {
        BufferedWriter bufferedWriter;
        Throwable th;
        File file2 = new File(file, str);
        try {
            bufferedWriter = new BufferedWriter(new FileWriter(file2, true), 1048576);
            try {
                for (String str2 : map.keySet()) {
                    bufferedWriter.write(str2);
                    bufferedWriter.write(" = ");
                    bufferedWriter.write((String) map.get(str2));
                    bufferedWriter.write("\n");
                }
                bufferedWriter.close();
                return new BugReportFile(str, Uri.fromFile(file2).toString(), "text/plain");
            } catch (Throwable th2) {
                th = th2;
                if (bufferedWriter != null) {
                    bufferedWriter.close();
                }
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            bufferedWriter = null;
            if (bufferedWriter != null) {
                bufferedWriter.close();
            }
            throw th;
        }
    }
}
