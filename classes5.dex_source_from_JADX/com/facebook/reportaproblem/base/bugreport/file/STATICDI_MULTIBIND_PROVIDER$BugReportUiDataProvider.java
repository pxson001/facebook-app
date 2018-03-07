package com.facebook.reportaproblem.base.bugreport.file;

import com.facebook.inject.Injector;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.MultiBindIndexedProvider;
import com.facebook.inject.MultiBinderSet;
import com.facebook.reportaproblem.fb.dataprovider.AnalyticsTagDataProvider;
import java.util.Set;
import javax.inject.Provider;

/* compiled from: transaction_status_display */
public final class STATICDI_MULTIBIND_PROVIDER$BugReportUiDataProvider implements MultiBindIndexedProvider<BugReportUiDataProvider>, Provider<Set<BugReportUiDataProvider>> {
    private final InjectorLike f5247a;

    private STATICDI_MULTIBIND_PROVIDER$BugReportUiDataProvider(InjectorLike injectorLike) {
        this.f5247a = injectorLike;
    }

    public final Object get() {
        return new MultiBinderSet(this.f5247a.getScopeAwareInjector(), this);
    }

    public static Provider<Set<BugReportUiDataProvider>> m10150a(InjectorLike injectorLike) {
        return new STATICDI_MULTIBIND_PROVIDER$BugReportUiDataProvider(injectorLike.getScopeAwareInjector());
    }

    public final int size() {
        return 1;
    }

    public final Object provide(Injector injector, int i) {
        switch (i) {
            case 0:
                return new AnalyticsTagDataProvider();
            default:
                throw new IllegalArgumentException("Invalid binding index");
        }
    }
}
