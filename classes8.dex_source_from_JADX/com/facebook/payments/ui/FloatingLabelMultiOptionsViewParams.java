package com.facebook.payments.ui;

import com.facebook.payments.ui.FloatingLabelMultiOptionsView.Mode;
import com.google.common.base.Preconditions;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: subscription_confirmation_text */
public class FloatingLabelMultiOptionsViewParams {
    public final Mode f1963a;
    @Nullable
    public final String f1964b;
    @Nullable
    public final String f1965c;
    @Nullable
    public final String f1966d;

    public static FloatingLabelMultiOptionsViewParamsBuilder newBuilder() {
        return new FloatingLabelMultiOptionsViewParamsBuilder();
    }

    public FloatingLabelMultiOptionsViewParams(FloatingLabelMultiOptionsViewParamsBuilder floatingLabelMultiOptionsViewParamsBuilder) {
        this.f1963a = (Mode) Preconditions.checkNotNull(floatingLabelMultiOptionsViewParamsBuilder.f1967a);
        this.f1964b = floatingLabelMultiOptionsViewParamsBuilder.f1968b;
        this.f1965c = floatingLabelMultiOptionsViewParamsBuilder.f1969c;
        this.f1966d = floatingLabelMultiOptionsViewParamsBuilder.f1970d;
    }
}
