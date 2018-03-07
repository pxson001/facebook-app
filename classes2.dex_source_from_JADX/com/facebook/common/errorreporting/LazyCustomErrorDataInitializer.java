package com.facebook.common.errorreporting;

import com.facebook.common.init.INeedInit;
import com.facebook.inject.Lazy;
import java.util.Set;
import javax.inject.Inject;

/* compiled from: uf_android */
public class LazyCustomErrorDataInitializer implements INeedInit {
    AbstractFbErrorReporter f2064a;
    Lazy<Set<FbCustomReportDataSupplier>> f2065b;

    @Inject
    public LazyCustomErrorDataInitializer(FbErrorReporter fbErrorReporter, Lazy<Set<FbCustomReportDataSupplier>> lazy) {
        this.f2064a = fbErrorReporter;
        this.f2065b = lazy;
    }

    public void init() {
        for (FbCustomReportDataSupplier fbCustomReportDataSupplier : (Set) this.f2065b.get()) {
            this.f2064a.mo338a(fbCustomReportDataSupplier.mo632a(), fbCustomReportDataSupplier);
        }
    }
}
