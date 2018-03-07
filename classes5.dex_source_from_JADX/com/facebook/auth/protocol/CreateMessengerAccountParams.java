package com.facebook.auth.protocol;

import javax.annotation.Nullable;

/* compiled from: supported_action_types */
public class CreateMessengerAccountParams {
    public final CreateMessengerAccountCredentials f2321a;
    public final boolean f2322b;
    public final boolean f2323c;
    public final String f2324d;
    @Nullable
    public final String f2325e;

    public CreateMessengerAccountParams(CreateMessengerAccountCredentials createMessengerAccountCredentials, boolean z, boolean z2, String str, @Nullable String str2) {
        this.f2321a = createMessengerAccountCredentials;
        this.f2322b = z;
        this.f2323c = z2;
        this.f2324d = str;
        this.f2325e = str2;
    }
}
