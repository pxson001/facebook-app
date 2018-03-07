package com.facebook.adspayments.validation;

/* compiled from: UPLOAD_IMAGE_TASKS */
public abstract class InputValidatorCallbackHandler {
    public InputValidatorCallback f23725a;

    public final void m25760a(boolean z) {
        InputValidatorCallback inputValidatorCallback = this.f23725a;
        if (inputValidatorCallback != null) {
            if (z) {
                inputValidatorCallback.mo1086a();
            } else {
                inputValidatorCallback.mo1087b();
            }
        }
    }
}
