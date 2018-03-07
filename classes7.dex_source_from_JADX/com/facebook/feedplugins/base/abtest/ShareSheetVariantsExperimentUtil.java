package com.facebook.feedplugins.base.abtest;

import com.facebook.inject.InjectorLike;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import javax.inject.Inject;

/* compiled from: requested_orientation */
public class ShareSheetVariantsExperimentUtil {
    public QeAccessor f5244a;

    public static ShareSheetVariantsExperimentUtil m5667a(InjectorLike injectorLike) {
        return new ShareSheetVariantsExperimentUtil((QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public ShareSheetVariantsExperimentUtil(QeAccessor qeAccessor) {
        this.f5244a = qeAccessor;
    }

    public final boolean m5668a() {
        return this.f5244a.a(ExperimentsForBlingBarABTestModule.f5242l, false);
    }

    public final boolean m5669b() {
        return this.f5244a.a(ExperimentsForBlingBarABTestModule.f5233c, false);
    }

    public final boolean m5670c() {
        return this.f5244a.a(ExperimentsForBlingBarABTestModule.f5234d, false);
    }

    public final String m5671f() {
        return this.f5244a.a(ExperimentsForBlingBarABTestModule.f5238h, null);
    }

    public final String m5672g() {
        return this.f5244a.a(ExperimentsForBlingBarABTestModule.f5240j, null);
    }

    public final String m5673h() {
        return this.f5244a.a(ExperimentsForBlingBarABTestModule.f5231a, null);
    }
}
