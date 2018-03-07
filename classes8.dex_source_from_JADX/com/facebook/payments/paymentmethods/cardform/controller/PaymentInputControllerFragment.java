package com.facebook.payments.paymentmethods.cardform.controller;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import com.facebook.base.fragment.FbFragment;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.payments.paymentmethods.cardform.PaymentFormEditTextView;
import com.facebook.payments.paymentmethods.cardform.validation.InputValidatorParams;
import com.facebook.payments.paymentmethods.cardform.validation.SimpleInputValidator;
import com.facebook.payments.paymentmethods.cardform.validation.TextInputValidator;
import com.google.common.base.Preconditions;

/* compiled from: tap_edit_button */
public class PaymentInputControllerFragment extends FbFragment {
    public Listener f1882a;
    public TextWatcher f1883b;
    public TextInputValidator f1884c;
    public TextWatcher f1885d;
    public PaymentFormEditTextView f1886e;
    private boolean f1887f = false;
    public boolean f1888g = false;

    /* compiled from: tap_edit_button */
    public interface Listener {
        InputValidatorParams mo83a();
    }

    /* compiled from: tap_edit_button */
    class C02091 implements OnFocusChangeListener {
        final /* synthetic */ PaymentInputControllerFragment f1889a;

        C02091(PaymentInputControllerFragment paymentInputControllerFragment) {
            this.f1889a = paymentInputControllerFragment;
        }

        public void onFocusChange(View view, boolean z) {
            if (!z) {
                this.f1889a.ar();
            }
        }
    }

    /* compiled from: tap_edit_button */
    public class C02102 implements TextWatcher {
        final /* synthetic */ PaymentInputControllerFragment f1890a;

        public C02102(PaymentInputControllerFragment paymentInputControllerFragment) {
            this.f1890a = paymentInputControllerFragment;
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void afterTextChanged(Editable editable) {
        }
    }

    /* compiled from: tap_edit_button */
    public class C02113 implements TextWatcher {
        final /* synthetic */ PaymentInputControllerFragment f1891a;

        public C02113(PaymentInputControllerFragment paymentInputControllerFragment) {
            this.f1891a = paymentInputControllerFragment;
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void afterTextChanged(Editable editable) {
            this.f1891a.m2096b(false);
        }
    }

    public final void m2094a(PaymentFormEditTextView paymentFormEditTextView, int i) {
        this.f1886e = paymentFormEditTextView;
        paymentFormEditTextView.setInputId(i);
    }

    public final void aq() {
        this.f1886e.setInputText("");
        this.f1887f = false;
    }

    public final void m2092G() {
        TextWatcher textWatcher;
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1480618195);
        super.G();
        Preconditions.checkNotNull(this.f1886e);
        this.f1883b = this.f1883b != null ? this.f1883b : new C02102(this);
        this.f1884c = this.f1884c != null ? this.f1884c : new SimpleInputValidator();
        if (this.f1885d != null) {
            textWatcher = this.f1885d;
        } else {
            textWatcher = new C02113(this);
        }
        this.f1885d = textWatcher;
        this.f1886e.setOnFocusChangeListener(new C02091(this));
        this.f1886e.m2038a(this.f1883b);
        this.f1886e.m2038a(this.f1885d);
        m2096b(this.f1887f);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -753407538, a);
    }

    public final void m2093H() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 632509572);
        super.H();
        this.f1886e.m2042b(this.f1883b);
        this.f1886e.m2042b(this.f1885d);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1851782010, a);
    }

    public final void m2098e(Bundle bundle) {
        bundle.putBoolean("form_input_has_error", this.f1887f);
        super.e(bundle);
    }

    public final void m2097d(Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1877085347);
        super.d(bundle);
        if (bundle != null) {
            this.f1887f = bundle.getBoolean("form_input_has_error", false);
        }
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 363686176, a);
    }

    public final void ar() {
        m2096b(!as());
    }

    public final boolean as() {
        if (this.f1882a == null || this.f1886e.f1858b) {
            return true;
        }
        InputValidatorParams a = this.f1882a.mo83a();
        if (this.f1888g && a.mo93a().isEmpty()) {
            return true;
        }
        return this.f1884c.mo91a(a);
    }

    public final void m2096b(boolean z) {
        this.f1887f = z;
        if (!this.f1887f || this.f1882a == null) {
            this.f1886e.m2043c();
        } else {
            this.f1886e.m2039a(this.f1884c.mo92b(this.f1882a.mo83a()));
        }
    }

    public int mo86b() {
        return this.f1886e.getInputText().length();
    }
}
