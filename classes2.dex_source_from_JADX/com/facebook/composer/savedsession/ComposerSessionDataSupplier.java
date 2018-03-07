package com.facebook.composer.savedsession;

import com.facebook.common.errorreporting.FbCustomReportDataSupplier;
import com.facebook.inject.Lazy;
import javax.inject.Inject;

/* compiled from: trimToMinimum */
public class ComposerSessionDataSupplier implements FbCustomReportDataSupplier {
    private Lazy<ComposerInstanceTracker> f2237a;

    @Inject
    public ComposerSessionDataSupplier(Lazy<ComposerInstanceTracker> lazy) {
        this.f2237a = lazy;
    }

    public final String mo633a(Throwable th) {
        if (this.f2237a.get() != null) {
            return ((ComposerInstanceTracker) this.f2237a.get()).a();
        }
        return "none";
    }

    public final String mo632a() {
        return "composer_sessions";
    }
}
