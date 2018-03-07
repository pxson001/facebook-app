package com.facebook.messaging.business.nativesignup.view.model;

import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: msg_id=? */
public class NativeSignUpRowViewParams {
    @Nullable
    public final String f9023a;
    @Nullable
    public final String f9024b;
    @Nullable
    public final CharSequence f9025c;

    public NativeSignUpRowViewParams(NativeSignUpRowViewParamsBuilder nativeSignUpRowViewParamsBuilder) {
        this.f9023a = nativeSignUpRowViewParamsBuilder.f9026a;
        this.f9024b = nativeSignUpRowViewParamsBuilder.f9027b;
        this.f9025c = nativeSignUpRowViewParamsBuilder.f9028c;
    }

    public static NativeSignUpRowViewParamsBuilder newBuilder() {
        return new NativeSignUpRowViewParamsBuilder();
    }
}
