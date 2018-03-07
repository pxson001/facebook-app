package com.facebook.bugreporter;

import java.io.File;
import java.util.Map;

/* compiled from: proxy_host */
public interface BugReportExtraFileMapProvider {
    Map<String, String> getExtraFileFromWorkerThread(File file);

    void prepareDataForWriting();

    boolean shouldSendAsync();
}
