package com.facebook.auth.module;

import com.facebook.auth.datastore.impl.LoggedInUserSessionManager;
import com.facebook.common.util.TriState;
import com.facebook.inject.AbstractProvider;
import com.facebook.inject.InjectorLike;

/* compiled from: supports_time_slices */
public class TriState_IsPartialAccountMethodAutoProvider extends AbstractProvider<TriState> {
    public static TriState m3198b(InjectorLike injectorLike) {
        return LoggedInUserModule.b(LoggedInUserSessionManager.a(injectorLike));
    }

    public Object get() {
        return LoggedInUserModule.b(LoggedInUserSessionManager.a(this));
    }
}
