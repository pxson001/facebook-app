package com.facebook.reportaproblem.base.bugreport.file;

import com.facebook.auth.module.TriState_IsMeUserAnEmployeeMethodAutoProvider;
import com.facebook.fbui.viewdescriptionbuilder.ViewDescriptionBuilder;
import com.facebook.inject.Injector;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.MultiBindIndexedProvider;
import com.facebook.inject.MultiBinderSet;
import com.facebook.reportaproblem.fb.fileprovider.ViewHierarchyActivityFileProvider;
import java.util.Set;
import javax.inject.Provider;

/* compiled from: transaction_status_display */
public final class STATICDI_MULTIBIND_PROVIDER$BugReportActivityFileProvider implements MultiBindIndexedProvider<BugReportActivityFileProvider>, Provider<Set<BugReportActivityFileProvider>> {
    private final InjectorLike f5244a;

    private STATICDI_MULTIBIND_PROVIDER$BugReportActivityFileProvider(InjectorLike injectorLike) {
        this.f5244a = injectorLike;
    }

    public final Object get() {
        return new MultiBinderSet(this.f5244a.getScopeAwareInjector(), this);
    }

    public static Provider<Set<BugReportActivityFileProvider>> m10147a(InjectorLike injectorLike) {
        return new STATICDI_MULTIBIND_PROVIDER$BugReportActivityFileProvider(injectorLike.getScopeAwareInjector());
    }

    public final int size() {
        return 1;
    }

    public final Object provide(Injector injector, int i) {
        switch (i) {
            case 0:
                return new ViewHierarchyActivityFileProvider(ViewDescriptionBuilder.b(injector), TriState_IsMeUserAnEmployeeMethodAutoProvider.b(injector));
            default:
                throw new IllegalArgumentException("Invalid binding index");
        }
    }
}
