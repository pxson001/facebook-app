package com.facebook.fbreact.fb4a;

import com.facebook.common.build.BuildConstants;
import com.facebook.common.build.SignatureType;
import com.facebook.events.gating.ExperimentsForEventsGatingModule;
import com.facebook.qe.api.Liveness;
import com.facebook.qe.api.QeAccessor;
import com.facebook.react.JSCConfig;
import com.facebook.react.bridge.WritableNativeMap;
import javax.inject.Inject;

/* compiled from: f46a9aad576edadc2344759f41679415 */
public class Fb4aJSCConfig implements JSCConfig {
    private final QeAccessor f7283a;
    private final SignatureType f7284b;

    @Inject
    public Fb4aJSCConfig(QeAccessor qeAccessor, SignatureType signatureType) {
        this.f7283a = qeAccessor;
        this.f7284b = signatureType;
    }

    public final WritableNativeMap m8503a() {
        boolean z = false;
        WritableNativeMap writableNativeMap = new WritableNativeMap();
        writableNativeMap.putBoolean("GCTimers", this.f7283a.a(Liveness.Live, ExperimentsForEventsGatingModule.P, false));
        writableNativeMap.putBoolean("PreparsingStringRef", this.f7283a.a(Liveness.Live, ExperimentsForEventsGatingModule.U, false));
        writableNativeMap.putBoolean("CacheBytecode", this.f7283a.a(Liveness.Live, ExperimentsForEventsGatingModule.K, false));
        String str = "VerifyBytecode";
        if (BuildConstants.i && this.f7284b == SignatureType.DEBUG) {
            z = true;
        }
        writableNativeMap.putBoolean(str, z);
        return writableNativeMap;
    }
}
