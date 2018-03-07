package com.facebook.facecast.abtest;

import com.facebook.inject.InjectorLike;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import javax.inject.Inject;

/* compiled from: subtitleText is empty or null */
public class FacecastEndScreenQEHelper {
    public final QeAccessor f2806a;

    public static FacecastEndScreenQEHelper m3061b(InjectorLike injectorLike) {
        return new FacecastEndScreenQEHelper((QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public FacecastEndScreenQEHelper(QeAccessor qeAccessor) {
        this.f2806a = qeAccessor;
    }

    public final boolean m3062b() {
        return this.f2806a.a(ExperimentsForFacecastAbtestModule.f2794o, false);
    }

    public final boolean m3063c() {
        return this.f2806a.a(ExperimentsForFacecastAbtestModule.f2792m, false);
    }

    public static FacecastEndScreenQEHelper m3060a(InjectorLike injectorLike) {
        return m3061b(injectorLike);
    }
}
