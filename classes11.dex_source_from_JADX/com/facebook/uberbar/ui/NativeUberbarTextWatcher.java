package com.facebook.uberbar.ui;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.ImageButton;
import com.facebook.uberbar.analytics.UberbarResultsAnalyticHelper;

/* compiled from: nearby_tiles_index */
public class NativeUberbarTextWatcher implements TextWatcher {
    private final NativeUberbarDelegate f5095a;
    private ImageButton f5096b;

    public NativeUberbarTextWatcher(NativeUberbarDelegate nativeUberbarDelegate, ImageButton imageButton) {
        this.f5095a = nativeUberbarDelegate;
        this.f5096b = imageButton;
    }

    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        if (i == 0 && i2 > 1 && i3 == 0) {
            this.f5095a.mo145a().b(charSequence.toString());
        }
        if (i == 0 && i3 == 0) {
            this.f5096b.setContentDescription(this.f5096b.getContext().getString(2131236543));
        }
        if (i == 0 && i2 == 0 && i3 > 0) {
            this.f5096b.setContentDescription(this.f5096b.getContext().getString(2131236544));
        }
    }

    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        UberbarResultsAnalyticHelper a = this.f5095a.mo145a();
        int length = charSequence.length();
        a.c += Math.abs(a.d - length);
        a.d = length;
    }

    public void afterTextChanged(Editable editable) {
        this.f5095a.m6372a(editable);
    }
}
