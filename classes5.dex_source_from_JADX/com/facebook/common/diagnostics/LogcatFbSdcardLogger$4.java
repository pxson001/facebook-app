package com.facebook.common.diagnostics;

import java.io.File;
import java.util.Comparator;

/* compiled from: stored_balance_status */
final class LogcatFbSdcardLogger$4 implements Comparator<File> {
    LogcatFbSdcardLogger$4() {
    }

    public final int compare(Object obj, Object obj2) {
        return Long.valueOf(((File) obj2).lastModified()).compareTo(Long.valueOf(((File) obj).lastModified()));
    }
}
