package com.facebook.richdocument.logging;

import com.facebook.common.errorreporting.FbCustomReportDataSupplier;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.richdocument.RichDocumentConstants;
import javax.inject.Inject;

/* compiled from: trace_tags */
public class RichDocumentReportDataSupplier implements FbCustomReportDataSupplier {
    private final FbSharedPreferences f2286a;

    @Inject
    public RichDocumentReportDataSupplier(FbSharedPreferences fbSharedPreferences) {
        this.f2286a = fbSharedPreferences;
    }

    public final String mo633a(Throwable th) {
        return this.f2286a.mo278a(RichDocumentConstants.b, null);
    }

    public final String mo632a() {
        return "instant_articles";
    }
}
