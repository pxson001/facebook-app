package com.facebook.messaging.payment.prefs.verification;

import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import com.facebook.base.fragment.FbFragment;
import com.facebook.common.util.FindViewUtil;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.messaging.payment.model.verification.ScreenData;
import com.facebook.messaging.payment.ui.PaymentHeaderSubheaderLayout;
import com.facebook.messaging.payment.value.util.PaymentsSoftInputUtil;
import com.facebook.payments.paymentmethods.cardform.PaymentFormEditTextView;
import com.facebook.payments.paymentmethods.cardform.controller.PaymentInputControllerFragment;
import com.facebook.payments.paymentmethods.cardform.controller.PaymentInputControllerFragment.Listener;
import com.facebook.payments.paymentmethods.cardform.formatting.SecurityCodeFormattingTextWatcher;
import com.facebook.payments.paymentmethods.cardform.validation.InputValidatorParams;
import com.facebook.payments.paymentmethods.cardform.validation.SecurityCodeInputValidator;
import com.facebook.payments.paymentmethods.cardform.validation.SecurityCodeInputValidatorParams;
import com.facebook.payments.paymentmethods.model.FbPaymentCardType;
import javax.inject.Inject;

/* compiled from: friend_going_count */
public class RiskSecurityCodeFragment extends FbFragment {
    @Inject
    public PaymentsSoftInputUtil f14475a;
    @Inject
    public SecurityCodeInputValidator f14476b;
    @Inject
    public SecurityCodeFormattingTextWatcher f14477c;
    public PaymentInputControllerFragment f14478d;
    private PaymentFormEditTextView f14479e;
    public MenuItem f14480f;
    public FbPaymentCardType f14481g;

    /* compiled from: friend_going_count */
    class C16541 implements TextWatcher {
        final /* synthetic */ RiskSecurityCodeFragment f14473a;

        C16541(RiskSecurityCodeFragment riskSecurityCodeFragment) {
            this.f14473a = riskSecurityCodeFragment;
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void afterTextChanged(Editable editable) {
            boolean z = true;
            if (RiskSecurityCodeFragment.m14875e(this.f14473a)) {
                this.f14473a.f14480f.setEnabled(true);
                this.f14473a.f14478d.b(false);
                return;
            }
            this.f14473a.f14480f.setEnabled(false);
            PaymentInputControllerFragment paymentInputControllerFragment = this.f14473a.f14478d;
            if (editable.length() < SecurityCodeInputValidator.a(this.f14473a.f14481g)) {
                z = false;
            }
            paymentInputControllerFragment.b(z);
        }
    }

    /* compiled from: friend_going_count */
    class C16552 implements Listener {
        final /* synthetic */ RiskSecurityCodeFragment f14474a;

        C16552(RiskSecurityCodeFragment riskSecurityCodeFragment) {
            this.f14474a = riskSecurityCodeFragment;
        }

        public final InputValidatorParams m14872a() {
            return RiskSecurityCodeFragment.aq(this.f14474a);
        }
    }

    public static void m14873a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        RiskSecurityCodeFragment riskSecurityCodeFragment = (RiskSecurityCodeFragment) obj;
        PaymentsSoftInputUtil b = PaymentsSoftInputUtil.m16054b(fbInjector);
        SecurityCodeInputValidator b2 = SecurityCodeInputValidator.b(fbInjector);
        SecurityCodeFormattingTextWatcher a = SecurityCodeFormattingTextWatcher.a(fbInjector);
        riskSecurityCodeFragment.f14475a = b;
        riskSecurityCodeFragment.f14476b = b2;
        riskSecurityCodeFragment.f14477c = a;
    }

    public final void m14880c(Bundle bundle) {
        super.c(bundle);
        Class cls = RiskSecurityCodeFragment.class;
        m14873a((Object) this, getContext());
        e(true);
    }

    public final View m14876a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -936047268);
        View inflate = layoutInflater.inflate(2130906908, viewGroup, false);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1771109466, a);
        return inflate;
    }

    public final void m14879a(View view, Bundle bundle) {
        ScreenData screenData = (ScreenData) this.s.get("screen_data");
        this.f14481g = FbPaymentCardType.forValue(screenData.m14076e());
        PaymentHeaderSubheaderLayout paymentHeaderSubheaderLayout = (PaymentHeaderSubheaderLayout) FindViewUtil.b(view, 2131567114);
        paymentHeaderSubheaderLayout.setHeader(2131240453);
        paymentHeaderSubheaderLayout.setSubheader(getContext().getString(this.f14481g == FbPaymentCardType.AMEX ? 2131240455 : 2131240454, new Object[]{screenData.m14076e(), screenData.m14077f()}));
        EditText editText = (EditText) FindViewUtil.b(view, 2131567128);
        editText.setText("•••• •••• •••• " + screenData.m14077f());
        editText.setFocusable(false);
        this.f14479e = (PaymentFormEditTextView) FindViewUtil.b(view, 2131567129);
        this.f14479e.setInputType(2);
        this.f14475a.m16056a(ao(), this.f14479e);
        m14874b();
    }

    public final void m14878a(Menu menu, MenuInflater menuInflater) {
        menuInflater.inflate(2131820586, menu);
        super.a(menu, menuInflater);
        this.f14480f = menu.findItem(2131568685);
    }

    public final void m14877a(Menu menu) {
        super.a(menu);
        this.f14480f.setEnabled(m14875e(this));
    }

    public final boolean a_(MenuItem menuItem) {
        if (menuItem.getItemId() == 2131568685) {
            ((PaymentRiskVerificationControllerFragment) this.G).m14835a(null, this.f14479e.getInputText());
        }
        return super.a_(menuItem);
    }

    private void m14874b() {
        this.f14478d = (PaymentInputControllerFragment) s().a("security_code_input_controller_fragment_tag");
        if (this.f14478d == null) {
            this.f14478d = new PaymentInputControllerFragment();
            s().a().a(this.f14478d, "security_code_input_controller_fragment_tag").b();
        }
        TextWatcher c16541 = new C16541(this);
        this.f14478d.a(this.f14479e, 2131558767);
        this.f14478d.b = this.f14477c;
        this.f14478d.c = this.f14476b;
        this.f14478d.d = c16541;
        this.f14478d.a = new C16552(this);
    }

    public static boolean m14875e(RiskSecurityCodeFragment riskSecurityCodeFragment) {
        return riskSecurityCodeFragment.f14476b.a(aq(riskSecurityCodeFragment));
    }

    public static SecurityCodeInputValidatorParams aq(RiskSecurityCodeFragment riskSecurityCodeFragment) {
        return new SecurityCodeInputValidatorParams(riskSecurityCodeFragment.f14479e.getInputText(), riskSecurityCodeFragment.f14481g);
    }
}
