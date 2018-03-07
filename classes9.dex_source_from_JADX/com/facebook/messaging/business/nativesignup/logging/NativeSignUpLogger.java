package com.facebook.messaging.business.nativesignup.logging;

import com.facebook.funnellogger.FunnelLoggerImpl;
import com.facebook.funnellogger.FunnelRegistry;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.business.nativesignup.model.NativeSignUpParams;
import com.facebook.messaging.business.ride.abtest.ExperimentsForRideAbtestModule;
import com.facebook.qe.api.ExposureLogging;
import com.facebook.qe.api.Liveness;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import javax.inject.Inject;

/* compiled from: muteThread */
public class NativeSignUpLogger {
    public final FunnelLoggerImpl f8875a;
    public final QeAccessor f8876b;

    public static NativeSignUpLogger m9158b(InjectorLike injectorLike) {
        return new NativeSignUpLogger(FunnelLoggerImpl.a(injectorLike), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public NativeSignUpLogger(FunnelLoggerImpl funnelLoggerImpl, QeAccessor qeAccessor) {
        this.f8875a = funnelLoggerImpl;
        this.f8876b = qeAccessor;
    }

    private void m9157a(String str, NativeSignUpParams nativeSignUpParams, char c) {
        if (str.equals(nativeSignUpParams.f8884a) && !Strings.isNullOrEmpty(nativeSignUpParams.f8890g)) {
            this.f8876b.a(Liveness.Live, c);
        }
    }

    public final void m9161b(String str, String str2) {
        this.f8875a.a(FunnelRegistry.p, str, str2);
    }

    public final void m9159a(String str) {
        this.f8875a.b(FunnelRegistry.p, str);
    }

    public final void m9160b(NativeSignUpParams nativeSignUpParams) {
        Preconditions.checkNotNull(nativeSignUpParams);
        if (nativeSignUpParams.f8884a.equals(this.f8876b.a(Liveness.Live, ExposureLogging.Off, ExperimentsForRideAbtestModule.f9052d, ""))) {
            this.f8876b.a(Liveness.Live, ExperimentsForRideAbtestModule.f9051c);
        }
        m9157a("uber", nativeSignUpParams, ExperimentsForRideAbtestModule.f9053e);
        m9157a("lyft", nativeSignUpParams, ExperimentsForRideAbtestModule.f9050b);
    }
}
