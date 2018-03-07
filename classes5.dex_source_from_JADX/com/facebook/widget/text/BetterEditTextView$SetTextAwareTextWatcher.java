package com.facebook.widget.text;

import android.text.Editable;
import android.text.TextWatcher;

/* compiled from: com.facebook.messaging.annotations.ForIntentHandlerActivity */
class BetterEditTextView$SetTextAwareTextWatcher implements TextWatcher {
    final /* synthetic */ BetterEditTextView f5848a;

    public BetterEditTextView$SetTextAwareTextWatcher(BetterEditTextView betterEditTextView) {
        this.f5848a = betterEditTextView;
    }

    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        BetterEditTextView.a(this.f5848a, charSequence);
        if (this.f5848a.g) {
            this.f5848a.g = false;
        } else if (this.f5848a.c != null) {
            this.f5848a.c.m10594a(charSequence);
        }
    }

    public void afterTextChanged(Editable editable) {
    }
}
