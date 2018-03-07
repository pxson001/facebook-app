package com.facebook.bugreporter;

import com.google.common.annotations.VisibleForTesting;

@VisibleForTesting
/* compiled from: android.permission.READ_EXTERNAL_STORAGE */
public class BugReportOperationLogger$EventRecord {
    @VisibleForTesting
    public final long f10474a;
    @VisibleForTesting
    final String f10475b;
    @VisibleForTesting
    final BugReportCategory f10476c;

    @VisibleForTesting
    BugReportOperationLogger$EventRecord(long j, String str, BugReportCategory bugReportCategory) {
        this.f10474a = j;
        this.f10475b = str;
        this.f10476c = bugReportCategory;
    }
}
