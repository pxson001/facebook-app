package com.facebook.messaging.payment.value.util;

import android.app.Activity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import com.facebook.common.android.InputMethodManagerMethodAutoProvider;
import com.facebook.inject.InjectorLike;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: editPaymentCardParams */
public class PaymentsSoftInputUtil {
    private final InputMethodManager f15856a;

    public static PaymentsSoftInputUtil m16054b(InjectorLike injectorLike) {
        return new PaymentsSoftInputUtil(InputMethodManagerMethodAutoProvider.b(injectorLike));
    }

    @Inject
    public PaymentsSoftInputUtil(InputMethodManager inputMethodManager) {
        this.f15856a = inputMethodManager;
    }

    public final void m16055a(Activity activity) {
        View currentFocus = activity.getCurrentFocus();
        if (currentFocus != null) {
            this.f15856a.hideSoftInputFromWindow(currentFocus.getWindowToken(), 0);
        }
    }

    public final void m16056a(Activity activity, @Nullable View view) {
        if (view == null) {
            view = activity.getCurrentFocus();
        }
        if (view != null) {
            if (view.hasFocus()) {
                view.clearFocus();
            }
            view.requestFocus();
            this.f15856a.showSoftInput(view, 0);
        }
    }

    public static PaymentsSoftInputUtil m16053a(InjectorLike injectorLike) {
        return m16054b(injectorLike);
    }
}
