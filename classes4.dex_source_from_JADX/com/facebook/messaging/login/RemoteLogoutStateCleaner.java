package com.facebook.messaging.login;

import com.facebook.auth.component.AbstractAuthComponent;
import com.facebook.auth.component.AuthenticationResult;
import com.facebook.prefs.shared.FbSharedPreferences;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: sync_photo_start */
public class RemoteLogoutStateCleaner extends AbstractAuthComponent {
    private final FbSharedPreferences f1426a;

    @Inject
    public RemoteLogoutStateCleaner(FbSharedPreferences fbSharedPreferences) {
        this.f1426a = fbSharedPreferences;
    }

    public final void m1668a(@Nullable AuthenticationResult authenticationResult) {
        this.f1426a.edit().a(LoginPrefKeys.f13108b).commit();
    }

    public final void m1669h() {
        this.f1426a.edit().a(LoginPrefKeys.f13108b).commit();
    }
}
