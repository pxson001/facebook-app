package com.facebook.auth.protocol;

import javax.annotation.Nullable;

/* compiled from: suggestion_identifier */
public class LoginBypassWithMessengerCredentialsParams {
    public final ConfirmedMessengerCredentials f2361a;
    public final boolean f2362b;
    @Nullable
    public final String f2363c;

    public LoginBypassWithMessengerCredentialsParams(ConfirmedMessengerCredentials confirmedMessengerCredentials, boolean z, @Nullable String str) {
        this.f2361a = confirmedMessengerCredentials;
        this.f2362b = z;
        this.f2363c = str;
    }
}
