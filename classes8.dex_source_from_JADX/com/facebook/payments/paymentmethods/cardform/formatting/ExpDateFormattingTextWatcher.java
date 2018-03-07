package com.facebook.payments.paymentmethods.cardform.formatting;

import android.text.Editable;
import android.text.Selection;
import android.text.TextWatcher;
import com.facebook.inject.InjectorLike;
import com.facebook.payments.paymentmethods.cardform.PaymentMethodInputFormattingUtils;

/* compiled from: tab_type */
public class ExpDateFormattingTextWatcher implements TextWatcher {
    private boolean f1899a;
    private boolean f1900b;
    private int f1901c;

    public static ExpDateFormattingTextWatcher m2103a(InjectorLike injectorLike) {
        return new ExpDateFormattingTextWatcher();
    }

    public synchronized void afterTextChanged(Editable editable) {
        if (!this.f1899a) {
            this.f1899a = true;
            if (this.f1900b && this.f1901c > 0 && this.f1901c - 1 < editable.length()) {
                if (this.f1901c - 2 < 0 || this.f1901c - 2 >= editable.length() || editable.charAt(this.f1901c - 2) != '0') {
                    editable.delete(this.f1901c - 1, this.f1901c);
                } else {
                    editable.delete(this.f1901c - 2, this.f1901c);
                }
            }
            PaymentMethodInputFormattingUtils.m2048a(editable);
            this.f1899a = false;
        }
    }

    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        if (!this.f1899a) {
            int selectionStart = Selection.getSelectionStart(charSequence);
            int selectionEnd = Selection.getSelectionEnd(charSequence);
            if (charSequence.length() > 1 && i2 == 1 && i3 == 0 && charSequence.charAt(i) == '/' && selectionStart == selectionEnd) {
                this.f1900b = true;
                this.f1901c = i;
                return;
            }
            this.f1900b = false;
        }
    }

    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }
}
