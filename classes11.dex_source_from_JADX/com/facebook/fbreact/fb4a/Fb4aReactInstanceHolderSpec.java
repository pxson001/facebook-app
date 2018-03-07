package com.facebook.fbreact.fb4a;

import com.facebook.common.build.SignatureType;
import com.facebook.config.application.SignatureTypeMethodAutoProvider;
import com.facebook.fbreact.exceptionmanager.FbReactExceptionManager;
import com.facebook.inject.InjectorLike;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import javax.inject.Inject;

/* compiled from: f39bf6c4053e667e3660011633994d29 */
public class Fb4aReactInstanceHolderSpec {
    public final Fb4aJSCConfig f7285a;
    public final Fb4aReactPackage f7286b;
    public final FbReactExceptionManager f7287c;
    public final SignatureType f7288d;
    public final QeAccessor f7289e;

    public static Fb4aReactInstanceHolderSpec m8504b(InjectorLike injectorLike) {
        return new Fb4aReactInstanceHolderSpec(new Fb4aJSCConfig((QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike), SignatureTypeMethodAutoProvider.b(injectorLike)), Fb4aReactPackage.m8507a(injectorLike), FbReactExceptionManager.a(injectorLike), SignatureTypeMethodAutoProvider.b(injectorLike), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public Fb4aReactInstanceHolderSpec(Fb4aJSCConfig fb4aJSCConfig, Fb4aReactPackage fb4aReactPackage, FbReactExceptionManager fbReactExceptionManager, SignatureType signatureType, QeAccessor qeAccessor) {
        this.f7285a = fb4aJSCConfig;
        this.f7286b = fb4aReactPackage;
        this.f7287c = fbReactExceptionManager;
        this.f7288d = signatureType;
        this.f7289e = qeAccessor;
    }
}
