package com.facebook.adspayments.controller;

import android.content.res.Resources;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.widget.EditText;
import android.widget.TextView;
import com.facebook.adspayments.PaymentUiUtil;
import com.facebook.adspayments.PaymentsQeAccessor;
import com.facebook.adspayments.adinterfaces.abtest.AdsPaymentsExperimentsHelper;
import com.facebook.adspayments.adinterfaces.abtest.ExperimentsForAdsPaymentsModule;
import com.facebook.adspayments.analytics.PaymentsFlowContext;
import com.facebook.adspayments.utils.PostalCodeUtil;
import com.facebook.adspayments.validation.BillingZipInputValidator;
import com.facebook.adspayments.validation.CardInputFieldController;
import com.facebook.adspayments.validation.InputValidatorCallback;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.locale.Country;
import com.facebook.common.util.StringUtil;
import com.facebook.inject.InjectorLike;
import com.facebook.resources.ui.FbEditText;
import com.facebook.resources.ui.FbTextView;
import com.google.common.base.Preconditions;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: Unable to download to file  */
public class BillingZipInputController extends CardInputFieldController<BillingZipInputValidator> {
    private Country f23644c;
    private FbEditText f23645d;
    private FbTextView f23646e;
    private View f23647f;

    /* compiled from: Unable to download to file  */
    class C28441 implements InputValidatorCallback {
        final /* synthetic */ BillingZipInputController f23629a;

        C28441(BillingZipInputController billingZipInputController) {
            this.f23629a = billingZipInputController;
        }

        public final void mo1086a() {
            this.f23629a.m25626a(false);
        }

        public final void mo1087b() {
            this.f23629a.m25626a(true);
        }
    }

    /* compiled from: Unable to download to file  */
    class C28452 implements OnFocusChangeListener {
        final /* synthetic */ BillingZipInputController f23630a;

        C28452(BillingZipInputController billingZipInputController) {
            this.f23630a = billingZipInputController;
        }

        public void onFocusChange(View view, boolean z) {
            if (z) {
                this.f23630a.m25626a(false);
            } else {
                this.f23630a.m25631i();
            }
            BillingZipInputController.m25633b(this.f23630a, z);
        }
    }

    /* compiled from: Unable to download to file  */
    class C28463 implements TextWatcher {
        final /* synthetic */ BillingZipInputController f23631a;

        C28463(BillingZipInputController billingZipInputController) {
            this.f23631a = billingZipInputController;
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void afterTextChanged(Editable editable) {
            if (editable.length() >= 3) {
                this.f23631a.m25626a(false);
            }
        }
    }

    public static BillingZipInputController m25632b(InjectorLike injectorLike) {
        return new BillingZipInputController(new BillingZipInputValidator(PaymentsQeAccessor.m25554a(injectorLike)), ResourcesMethodAutoProvider.a(injectorLike), AdsPaymentsExperimentsHelper.m25609b(injectorLike), PaymentsQeAccessor.m25554a(injectorLike));
    }

    @Inject
    public BillingZipInputController(BillingZipInputValidator billingZipInputValidator, Resources resources, AdsPaymentsExperimentsHelper adsPaymentsExperimentsHelper, PaymentsQeAccessor paymentsQeAccessor) {
        super(billingZipInputValidator, resources, adsPaymentsExperimentsHelper, paymentsQeAccessor);
    }

    public final void m25635a(View view, @Nullable View view2, PaymentsFlowContext paymentsFlowContext, Country country) {
        this.f23644c = country;
        super.m25624a(view, view2, paymentsFlowContext);
    }

    protected final void mo1088a(View view) {
        Preconditions.checkNotNull(this.f23644c);
        View findViewById = view.findViewById(2131565789);
        this.f23645d = (FbEditText) view.findViewById(2131558761);
        this.f23646e = (FbTextView) view.findViewById(2131558762);
        this.f23647f = view.findViewById(2131565790);
        ((BillingZipInputValidator) this.f23637f).f23725a = new C28441(this);
        m25633b(this, this.f23645d.hasFocus());
        this.f23645d.setOnFocusChangeListener(new C28452(this));
        this.f23645d.addTextChangedListener(new C28463(this));
        if (!PostalCodeUtil.m25759b(this.f23644c) && this.f23632a.m25557a(ExperimentsForAdsPaymentsModule.f23627f)) {
            findViewById.setVisibility(8);
        }
    }

    public static void m25633b(BillingZipInputController billingZipInputController, boolean z) {
        PaymentUiUtil.m25553a(billingZipInputController.f23647f, z);
    }

    public final boolean mo1089a() {
        if (PostalCodeUtil.m25759b(this.f23644c) || !this.f23632a.m25557a(ExperimentsForAdsPaymentsModule.f23627f)) {
            Object obj;
            BillingZipInputValidator billingZipInputValidator = (BillingZipInputValidator) this.f23637f;
            CharSequence obj2 = this.f23645d.getText().toString();
            Country country = this.f23644c;
            if (!StringUtil.a(obj2) && obj2.length() >= 3) {
                Object obj3 = (!billingZipInputValidator.f23726a.m25557a(ExperimentsForAdsPaymentsModule.f23628g) || PostalCodeUtil.m25758a(obj2, country)) ? 1 : null;
                if (obj3 != null) {
                    obj = 1;
                    if (obj == null) {
                        return false;
                    }
                }
            }
            obj = null;
            if (obj == null) {
                return false;
            }
        }
        return true;
    }

    public final String mo1090b() {
        return "zip_code";
    }

    public final EditText mo1091c() {
        return this.f23645d;
    }

    protected final TextView mo1092d() {
        return this.f23646e;
    }
}
