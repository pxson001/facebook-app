package com.facebook.payments.paymentmethods.cardform.formatting;

import android.text.Editable;
import android.text.TextWatcher;

/* compiled from: tag_people_after_tag_place */
public abstract class NumberFormattingTextWatcher implements TextWatcher {
    private boolean f1892a;
    private String f1893b;

    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        if (!this.f1892a) {
            this.f1893b = charSequence.toString();
        }
    }

    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public void afterTextChanged(Editable editable) {
        if (!this.f1892a && !editable.toString().matches("[0-9]*")) {
            this.f1892a = true;
            editable.replace(0, editable.length(), this.f1893b);
            this.f1892a = false;
        }
    }
}
