package com.facebook.adspayments.utils;

import android.app.Activity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: editPaymentCardParams */
public class PaymentsSoftInputUtil {
    public final InputMethodManager f23719a;

    @Inject
    public PaymentsSoftInputUtil(InputMethodManager inputMethodManager) {
        this.f23719a = inputMethodManager;
    }

    public final void m25755a(Activity activity, @Nullable View view) {
        if (view == null) {
            view = activity.getCurrentFocus();
        }
        if (view != null) {
            if (view.hasFocus()) {
                view.clearFocus();
            }
            view.requestFocus();
            this.f23719a.showSoftInput(view, 0);
        }
    }
}
