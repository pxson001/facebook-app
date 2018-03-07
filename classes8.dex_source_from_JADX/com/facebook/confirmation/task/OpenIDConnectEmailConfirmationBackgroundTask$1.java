package com.facebook.confirmation.task;

import com.facebook.growth.model.Contactpoint;
import com.google.common.base.Function;
import javax.annotation.Nullable;

/* compiled from: install_from_google_play */
class OpenIDConnectEmailConfirmationBackgroundTask$1 implements Function<Contactpoint, String> {
    final /* synthetic */ OpenIDConnectEmailConfirmationBackgroundTask f10797a;

    OpenIDConnectEmailConfirmationBackgroundTask$1(OpenIDConnectEmailConfirmationBackgroundTask openIDConnectEmailConfirmationBackgroundTask) {
        this.f10797a = openIDConnectEmailConfirmationBackgroundTask;
    }

    @Nullable
    public Object apply(@Nullable Object obj) {
        Contactpoint contactpoint = (Contactpoint) obj;
        return contactpoint != null ? contactpoint.normalized : null;
    }
}
