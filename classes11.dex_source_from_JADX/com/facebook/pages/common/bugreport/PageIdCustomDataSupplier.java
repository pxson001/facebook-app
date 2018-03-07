package com.facebook.pages.common.bugreport;

import com.facebook.acra.CustomReportDataSupplier;

/* compiled from: step_success */
public class PageIdCustomDataSupplier implements CustomReportDataSupplier {
    private final String f1358a;

    public PageIdCustomDataSupplier(String str) {
        this.f1358a = str;
    }

    public String getCustomData(Throwable th) {
        return this.f1358a != null ? this.f1358a : "n/a";
    }
}
