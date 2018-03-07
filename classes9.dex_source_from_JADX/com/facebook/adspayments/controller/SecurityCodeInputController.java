package com.facebook.adspayments.controller;

import android.content.res.Resources;
import android.text.Editable;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.facebook.adspayments.PaymentUiUtil;
import com.facebook.adspayments.PaymentUiUtil.AfterChangeTextWatcher;
import com.facebook.adspayments.PaymentsQeAccessor;
import com.facebook.adspayments.adinterfaces.abtest.AdsPaymentsExperimentsHelper;
import com.facebook.adspayments.validation.CardInputFieldController;
import com.facebook.adspayments.validation.InputValidatorCallback;
import com.facebook.adspayments.validation.SecurityCodeInputValidator;
import com.facebook.adspayments.validation.SecurityCodeInputValidator.C28711;
import com.facebook.common.util.StringUtil;
import com.facebook.payments.paymentmethods.cardform.formatting.SecurityCodeFormattingTextWatcher;
import com.facebook.payments.paymentmethods.model.FbPaymentCardType;
import com.facebook.resources.ui.FbEditText;
import com.facebook.resources.ui.FbTextView;
import java.util.concurrent.ExecutorService;

/* compiled from: Unable to deserialize PhotoQualityCacheItem collection */
public abstract class SecurityCodeInputController extends CardInputFieldController<SecurityCodeInputValidator> {
    private final SecurityCodeFormattingTextWatcher f23648c;
    public final ExecutorService f23649d;
    public FbEditText f23650e;
    private FbTextView f23651f;
    private ImageView f23652g;

    /* compiled from: Unable to deserialize PhotoQualityCacheItem collection */
    class C28541 implements InputValidatorCallback {
        final /* synthetic */ SecurityCodeInputController f23673a;

        C28541(SecurityCodeInputController securityCodeInputController) {
            this.f23673a = securityCodeInputController;
        }

        public final void mo1086a() {
            this.f23673a.m25626a(false);
        }

        public final void mo1087b() {
            this.f23673a.m25626a(true);
        }
    }

    /* compiled from: Unable to deserialize PhotoQualityCacheItem collection */
    class C28552 implements OnFocusChangeListener {
        final /* synthetic */ SecurityCodeInputController f23674a;

        C28552(SecurityCodeInputController securityCodeInputController) {
            this.f23674a = securityCodeInputController;
        }

        public void onFocusChange(View view, boolean z) {
            FbPaymentCardType e = this.f23674a.mo1094e();
            if (z) {
                this.f23674a.f23650e.setHint(e == FbPaymentCardType.AMEX ? 2131240124 : 2131240125);
                this.f23674a.m25626a(false);
                CardInputFieldController cardInputFieldController = this.f23674a;
                int a = SecurityCodeInputValidator.m25765a(e);
                cardInputFieldController.mo1091c().setFilters(new InputFilter[]{new LengthFilter(a)});
            } else {
                this.f23674a.f23650e.setHint(2131240123);
                this.f23674a.m25631i();
            }
            this.f23674a.m25641a(e, z);
        }
    }

    /* compiled from: Unable to deserialize PhotoQualityCacheItem collection */
    class C28563 extends AfterChangeTextWatcher {
        final /* synthetic */ SecurityCodeInputController f23675a;

        C28563(SecurityCodeInputController securityCodeInputController) {
            this.f23675a = securityCodeInputController;
        }

        public void afterTextChanged(Editable editable) {
            boolean a = this.f23675a.mo1089a();
            CardInputFieldController cardInputFieldController = this.f23675a;
            boolean z = !a && editable.length() >= SecurityCodeInputValidator.m25765a(this.f23675a.mo1094e());
            cardInputFieldController.m25626a(z);
            if (a && this.f23675a.f23633b != null) {
                this.f23675a.m25625a(this.f23675a.f23649d);
            }
        }
    }

    protected abstract FbPaymentCardType mo1094e();

    public SecurityCodeInputController(SecurityCodeFormattingTextWatcher securityCodeFormattingTextWatcher, SecurityCodeInputValidator securityCodeInputValidator, Resources resources, ExecutorService executorService, AdsPaymentsExperimentsHelper adsPaymentsExperimentsHelper, PaymentsQeAccessor paymentsQeAccessor) {
        super(securityCodeInputValidator, resources, adsPaymentsExperimentsHelper, paymentsQeAccessor);
        this.f23648c = securityCodeFormattingTextWatcher;
        this.f23649d = executorService;
    }

    protected void mo1088a(View view) {
        this.f23650e = (FbEditText) view.findViewById(2131565794);
        this.f23651f = (FbTextView) view.findViewById(2131565796);
        this.f23652g = (ImageView) view.findViewById(2131565795);
        m25641a(mo1094e(), this.f23650e.hasFocus());
        this.f23650e.setHint(2131240123);
        ((SecurityCodeInputValidator) this.f23637f).f23725a = new C28541(this);
        this.f23650e.setOnFocusChangeListener(new C28552(this));
        this.f23650e.addTextChangedListener(this.f23648c);
        this.f23650e.addTextChangedListener(new C28563(this));
    }

    public final boolean mo1089a() {
        String obj = this.f23650e.getText().toString();
        FbPaymentCardType e = mo1094e();
        boolean z = false;
        if (!StringUtil.a(obj) && obj.matches("\\d{3,4}")) {
            int length = obj.length();
            switch (C28711.f23731a[e.ordinal()]) {
                case 1:
                    if (length == 4) {
                        z = true;
                        break;
                    }
                    break;
                case 2:
                    if (length == 4 || length == 3) {
                        z = true;
                        break;
                    }
                default:
                    if (length == 3) {
                        z = true;
                        break;
                    }
                    break;
            }
        }
        return z;
    }

    public final String mo1090b() {
        return "security_code";
    }

    protected final void m25641a(FbPaymentCardType fbPaymentCardType, boolean z) {
        this.f23652g.setImageResource(fbPaymentCardType == FbPaymentCardType.AMEX ? 2130842563 : 2130842562);
        PaymentUiUtil.m25553a(this.f23652g, z);
    }

    protected final void mH_() {
        super.mH_();
        if (mo1094e() == FbPaymentCardType.AMEX) {
            this.f23651f.setText(2131240134);
        } else {
            this.f23651f.setText(2131240133);
        }
    }

    public final EditText mo1091c() {
        return this.f23650e;
    }

    protected final TextView mo1092d() {
        return this.f23651f;
    }
}
