package com.facebook.payments.paymentmethods.cardform.formatting;

import android.text.Editable;
import android.text.Selection;
import android.text.TextWatcher;
import com.facebook.inject.InjectorLike;
import com.facebook.payments.paymentmethods.cardform.PaymentMethodInputFormattingUtils;

/* compiled from: tabs_override */
public class CardFormattingTextWatcher implements TextWatcher {
    public char f1894a = '-';
    private boolean f1895b;
    private boolean f1896c;
    private int f1897d;
    private boolean f1898e;

    public static CardFormattingTextWatcher m2102a(InjectorLike injectorLike) {
        return new CardFormattingTextWatcher();
    }

    public synchronized void afterTextChanged(Editable editable) {
        if (!this.f1895b) {
            this.f1895b = true;
            if (this.f1896c && this.f1897d > 0) {
                if (this.f1898e && this.f1897d - 1 < editable.length()) {
                    editable.delete(this.f1897d - 1, this.f1897d);
                } else if (this.f1897d < editable.length()) {
                    editable.delete(this.f1897d, this.f1897d + 1);
                }
            }
            PaymentMethodInputFormattingUtils.m2049a(editable, this.f1894a);
            this.f1895b = false;
        }
    }

    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        if (!this.f1895b) {
            int selectionStart = Selection.getSelectionStart(charSequence);
            int selectionEnd = Selection.getSelectionEnd(charSequence);
            if (charSequence.length() > 1 && i2 == 1 && i3 == 0 && charSequence.charAt(i) == this.f1894a && selectionStart == selectionEnd) {
                this.f1896c = true;
                this.f1897d = i;
                if (selectionStart == i + 1) {
                    this.f1898e = true;
                    return;
                } else {
                    this.f1898e = false;
                    return;
                }
            }
            this.f1896c = false;
        }
    }

    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }
}
