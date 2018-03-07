package com.facebook.messaging.payment.value.input;

import android.text.Editable;
import android.text.TextWatcher;
import com.facebook.messaging.payment.currency.PaymentCurrencyUtil;
import com.facebook.messaging.payment.value.input.EnterPaymentValueTextController.C17801;
import javax.inject.Inject;

/* compiled from: error_number */
public class PaymentValueFormattingTextWatcher implements TextWatcher {
    private final PaymentCurrencyUtil f15691a;
    private boolean f15692b = false;
    private boolean f15693c;
    private String f15694d;
    public C17801 f15695e;
    private boolean f15696f;
    private int f15697g;

    @Inject
    public PaymentValueFormattingTextWatcher(PaymentCurrencyUtil paymentCurrencyUtil) {
        this.f15691a = paymentCurrencyUtil;
    }

    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        if (!this.f15692b) {
            this.f15694d = charSequence.toString();
        }
    }

    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        this.f15697g = i + i3;
        if (!this.f15693c) {
            this.f15696f = i3 > i2;
        }
    }

    public void afterTextChanged(Editable editable) {
        if (!this.f15692b) {
            String a = m15863a(editable.toString());
            if (a.matches("([1-9]\\d*)?0?(\\.\\d{0,2})?")) {
                if (this.f15691a.m13203b(a) > 1000000) {
                    this.f15695e.f15304a.f15314f.vibrate(50);
                    m15865a(editable, this.f15694d);
                    this.f15695e.m15663d();
                } else if (a.equals(".")) {
                    this.f15692b = true;
                    editable.insert(0, "0");
                    this.f15692b = false;
                    m15864a();
                } else if (a.equals("0") && this.f15694d.equals("0.")) {
                    this.f15692b = true;
                    editable.clear();
                    this.f15692b = false;
                    m15864a();
                } else {
                    CharSequence b = m15866b(a);
                    this.f15692b = true;
                    this.f15693c = true;
                    editable.replace(0, editable.length(), b);
                    this.f15692b = false;
                    this.f15693c = false;
                    m15864a();
                }
            } else if (a.matches("^0[1-9]$")) {
                m15865a(editable, a.substring(1));
                this.f15696f = true;
                m15864a();
            } else {
                m15865a(editable, this.f15694d);
                this.f15695e.m15663d();
            }
        }
    }

    private void m15864a() {
        if (this.f15695e != null) {
            C17801 c17801 = this.f15695e;
            c17801.f15304a.f15317i.mo625a(c17801.f15304a.f15316h.getText().toString());
            if (this.f15696f) {
                c17801 = this.f15695e;
                int i = this.f15697g;
                c17801.f15304a.f15313e.m15533b();
                if (c17801.f15304a.f15320l) {
                    EnterPaymentValueTextController.m15665a(c17801.f15304a, i);
                    return;
                }
                return;
            }
            this.f15695e.f15304a.f15313e.m15534c();
        }
    }

    private static String m15863a(String str) {
        if (str.endsWith(",")) {
            return str;
        }
        return str.replaceFirst(",", "");
    }

    private static String m15866b(String str) {
        int indexOf = str.indexOf(".");
        if (indexOf == -1) {
            indexOf = str.length();
        }
        indexOf -= 3;
        if (indexOf <= 0) {
            return str;
        }
        StringBuilder stringBuilder = new StringBuilder(str);
        stringBuilder.insert(indexOf, ",");
        return stringBuilder.toString();
    }

    private void m15865a(Editable editable, String str) {
        this.f15692b = true;
        editable.replace(0, editable.length(), str);
        this.f15692b = false;
    }
}
