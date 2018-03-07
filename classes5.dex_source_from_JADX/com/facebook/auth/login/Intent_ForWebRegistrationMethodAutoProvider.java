package com.facebook.auth.login;

import android.content.Intent;
import com.facebook.common.locale.Locales;
import com.facebook.config.application.FbAppType;
import com.facebook.inject.AbstractProvider;
import com.facebook.inject.InjectorLike;

/* compiled from: syncRegular */
public class Intent_ForWebRegistrationMethodAutoProvider extends AbstractProvider<Intent> {
    private static Intent m3189b(InjectorLike injectorLike) {
        return FacebookRegistrationIntentProvider.m3184a(Locales.a(injectorLike), (FbAppType) injectorLike.getInstance(FbAppType.class));
    }

    public Object get() {
        return FacebookRegistrationIntentProvider.m3184a(Locales.a(this), (FbAppType) getInstance(FbAppType.class));
    }
}
