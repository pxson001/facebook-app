package com.facebook.loom.module;

import com.facebook.common.errorreporting.FbCustomReportDataSupplier;
import com.facebook.inject.Lazy;
import com.facebook.xconfig.core.XConfigReader;
import javax.inject.Inject;

/* compiled from: transparent */
public class LoomConfigDataSupplier implements FbCustomReportDataSupplier {
    private Lazy<XConfigReader> f2265a;

    @Inject
    public LoomConfigDataSupplier(Lazy<XConfigReader> lazy) {
        this.f2265a = lazy;
    }

    public final String mo633a(Throwable th) {
        return ((XConfigReader) this.f2265a.get()).m2685a(LoomXConfig.d, "<no config>");
    }

    public final String mo632a() {
        return "loom_config";
    }
}
