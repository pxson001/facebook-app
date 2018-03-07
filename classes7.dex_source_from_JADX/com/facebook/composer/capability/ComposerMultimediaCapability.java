package com.facebook.composer.capability;

import com.facebook.composer.abtest.ExperimentsForComposerAbTestModule;
import com.facebook.inject.InjectorLike;
import com.facebook.ipc.composer.model.TargetType;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import javax.inject.Inject;

/* compiled from: cover_photo_uri */
public class ComposerMultimediaCapability {
    public final QeAccessor f16694a;

    public static ComposerMultimediaCapability m20726b(InjectorLike injectorLike) {
        return new ComposerMultimediaCapability((QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public ComposerMultimediaCapability(QeAccessor qeAccessor) {
        this.f16694a = qeAccessor;
    }

    public final boolean m20727a(TargetType targetType, boolean z) {
        if (!this.f16694a.a(ExperimentsForComposerAbTestModule.Q, false)) {
            return false;
        }
        Object obj;
        if (targetType != TargetType.UNDIRECTED) {
            boolean z2 = false;
            if (targetType == TargetType.EVENT && this.f16694a.a(ExperimentsForComposerAbTestModule.K, false)) {
                z2 = true;
            }
            if (!z2) {
                z2 = false;
                if (targetType == TargetType.GROUP && this.f16694a.a(ExperimentsForComposerAbTestModule.L, false)) {
                    z2 = true;
                }
                if (!z2) {
                    z2 = false;
                    if (targetType == TargetType.PAGE && this.f16694a.a(ExperimentsForComposerAbTestModule.M, false)) {
                        z2 = true;
                    }
                    if (!z2) {
                        obj = null;
                        if (obj != null) {
                            return false;
                        }
                        if (z || this.f16694a.a(ExperimentsForComposerAbTestModule.P, false)) {
                            return true;
                        }
                        return false;
                    }
                }
            }
        }
        obj = 1;
        if (obj != null) {
            return false;
        }
        if (z) {
        }
        return true;
    }

    public static ComposerMultimediaCapability m20725a(InjectorLike injectorLike) {
        return m20726b(injectorLike);
    }
}
