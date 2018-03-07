package com.facebook.auth.login;

import android.content.Intent;
import com.facebook.common.locale.Locales;
import com.facebook.inject.AbstractProvider;
import com.facebook.inject.InjectorLike;

/* compiled from: syncSessionless */
public class Intent_ForWebPasswordRecoveryMethodAutoProvider extends AbstractProvider<Intent> {
    private static Intent m3188b(InjectorLike injectorLike) {
        return LoginModule.a(Locales.a(injectorLike));
    }

    public Object get() {
        return LoginModule.a(Locales.a(this));
    }
}
