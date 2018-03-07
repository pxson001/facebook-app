package com.facebook.crudolib.netfb;

import com.facebook.auth.viewercontext.ViewerContext;
import com.facebook.crudolib.net.RequestMutator;
import com.facebook.crudolib.netengine.HttpEngineRequest$Builder;
import com.facebook.crudolib.netmodule.CrudoNetModule.C29132;

/* compiled from: ThreadsModel */
class OAuthRequestMutator implements RequestMutator {
    private final C29132 f24114a;

    public OAuthRequestMutator(C29132 c29132) {
        this.f24114a = c29132;
    }

    public final void mo1108a(HttpEngineRequest$Builder httpEngineRequest$Builder) {
        String str = ((ViewerContext) this.f24114a.f24118a.get()).mAuthToken;
        if (str != null) {
            httpEngineRequest$Builder.mo1111a("Authorization", "OAuth " + str);
        }
    }
}
