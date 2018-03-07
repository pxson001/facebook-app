package com.facebook.katana.server.module;

import com.facebook.auth.login.AuthServiceHandler;
import com.facebook.fbservice.service.BlueServiceHandler;
import com.facebook.inject.AbstractProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.katana.login.Boolean_UseAuthLoginMethodAutoProvider;
import com.facebook.katana.server.handler.Fb4aAuthHandler;

/* compiled from: task_name */
public class BlueServiceHandler_AuthQueueMethodAutoProvider extends AbstractProvider<BlueServiceHandler> {
    public Object get() {
        return Fb4aServiceModule.m1616a(Boolean_UseAuthLoginMethodAutoProvider.m1514b(this), Fb4aAuthHandler.m1522b((InjectorLike) this), AuthServiceHandler.m1610a((InjectorLike) this));
    }
}
