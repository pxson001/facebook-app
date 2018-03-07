package com.facebook.messaging.payment.value.input;

import android.text.Editable;
import android.text.TextWatcher;
import com.facebook.messaging.payment.value.input.MemoInputView.C18011;

/* compiled from: existing_account_callback */
public class MemoInputTextWatcher implements TextWatcher {
    public boolean f15433a;
    public C18011 f15434b;
    public String f15435c;

    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        if (!this.f15433a) {
            this.f15435c = charSequence.toString();
        }
    }

    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public void afterTextChanged(Editable editable) {
        if (!this.f15433a) {
            if (editable.length() > 36) {
                this.f15434b.m15734b();
                this.f15433a = true;
                editable.replace(0, editable.length(), this.f15435c);
                this.f15433a = false;
                return;
            }
            this.f15434b.m15733a();
        }
    }
}
