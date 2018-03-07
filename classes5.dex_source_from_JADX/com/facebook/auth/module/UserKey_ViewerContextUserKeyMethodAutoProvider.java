package com.facebook.auth.module;

import com.facebook.inject.AbstractProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.user.model.UserKey;

/* compiled from: supports_region */
public class UserKey_ViewerContextUserKeyMethodAutoProvider extends AbstractProvider<UserKey> {
    public static UserKey m3201b(InjectorLike injectorLike) {
        return LoggedInUserModule.b(ViewerContextMethodAutoProvider.b(injectorLike));
    }

    public Object get() {
        return LoggedInUserModule.b(ViewerContextMethodAutoProvider.b(this));
    }

    public static UserKey m3200a(InjectorLike injectorLike) {
        return m3201b(injectorLike);
    }
}
