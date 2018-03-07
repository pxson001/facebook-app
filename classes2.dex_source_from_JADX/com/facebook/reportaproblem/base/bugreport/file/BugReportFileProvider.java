package com.facebook.reportaproblem.base.bugreport.file;

import java.io.File;
import java.util.List;

/* compiled from: proxy_connect */
public interface BugReportFileProvider {
    List<BugReportFile> getFilesFromWorkerThread(File file);
}
