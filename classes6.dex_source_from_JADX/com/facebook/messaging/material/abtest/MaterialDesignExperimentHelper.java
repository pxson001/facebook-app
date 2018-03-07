package com.facebook.messaging.material.abtest;

import com.facebook.inject.InjectorLike;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import javax.inject.Inject;

/* compiled from: is_full_res */
public class MaterialDesignExperimentHelper {
    public final QeAccessor f12071a;

    @Inject
    public MaterialDesignExperimentHelper(QeAccessor qeAccessor) {
        this.f12071a = qeAccessor;
    }

    public static MaterialDesignExperimentHelper m18988b(InjectorLike injectorLike) {
        return new MaterialDesignExperimentHelper((QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike));
    }

    public final boolean m18989a() {
        return this.f12071a.a(ExperimentsForMessengerMaterialAbTestModule.f12064a, false);
    }

    public final boolean m18990b() {
        return this.f12071a.a(ExperimentsForMessengerMaterialAbTestModule.f12065b, false);
    }

    public static MaterialDesignExperimentHelper m18987a(InjectorLike injectorLike) {
        return m18988b(injectorLike);
    }

    public final boolean m18991f() {
        if (!m18990b()) {
            return false;
        }
        return this.f12071a.a(ExperimentsForMessengerMaterialAbTestModule.f12070g, false);
    }
}
