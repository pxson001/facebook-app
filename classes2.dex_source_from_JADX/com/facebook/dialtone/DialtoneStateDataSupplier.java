package com.facebook.dialtone;

import com.facebook.common.errorreporting.FbCustomReportDataSupplier;
import com.facebook.nodex.startup.signal.DialtoneSignalFile;
import javax.inject.Inject;

/* compiled from: trimStartTimeMs */
public class DialtoneStateDataSupplier implements FbCustomReportDataSupplier {
    private final DialtoneSignalFile f2238a;

    @Inject
    public DialtoneStateDataSupplier(DialtoneAsyncSignalFile dialtoneAsyncSignalFile) {
        this.f2238a = dialtoneAsyncSignalFile;
    }

    public final String mo633a(Throwable th) {
        return String.valueOf(this.f2238a.m4404c());
    }

    public final String mo632a() {
        return "dialtone_enabled";
    }
}
