package com.facebook.payments.paymentmethods.cardform;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.base.fragment.FbFragment;
import com.facebook.common.util.StringUtil;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectorLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.messaging.dialog.ConfirmActionParams;
import com.facebook.payments.dialog.PaymentsConfirmDialogFragment;
import com.facebook.payments.dialog.PaymentsConfirmDialogFragment.Listener;
import com.facebook.payments.model.FormFieldProperty;
import com.facebook.payments.paymentmethods.cardform.CardFormFragment.C01893;
import com.facebook.payments.paymentmethods.cardform.controller.CardNumberInputControllerFragment;
import com.facebook.payments.paymentmethods.cardform.controller.PaymentInputControllerFragment;
import com.facebook.payments.paymentmethods.cardform.formatting.BillingZipFormattingTextWatcher;
import com.facebook.payments.paymentmethods.cardform.formatting.CardFormattingTextWatcher;
import com.facebook.payments.paymentmethods.cardform.formatting.ExpDateFormattingTextWatcher;
import com.facebook.payments.paymentmethods.cardform.formatting.SecurityCodeFormattingTextWatcher;
import com.facebook.payments.paymentmethods.cardform.validation.BillingZipInputValidator;
import com.facebook.payments.paymentmethods.cardform.validation.CardNumberInputValidator;
import com.facebook.payments.paymentmethods.cardform.validation.CardNumberInputValidatorParams;
import com.facebook.payments.paymentmethods.cardform.validation.ExpDateInputValidator;
import com.facebook.payments.paymentmethods.cardform.validation.InputValidatorParams;
import com.facebook.payments.paymentmethods.cardform.validation.SecurityCodeInputValidator;
import com.facebook.payments.paymentmethods.cardform.validation.SecurityCodeInputValidatorParams;
import com.facebook.payments.paymentmethods.cardform.validation.SimpleInputValidatorParams;
import com.facebook.payments.paymentmethods.model.FbPaymentCard;
import com.facebook.payments.ui.SimplePaymentsComponentCallback;
import com.facebook.payments.util.PaymentMethodUtil;
import com.google.common.util.concurrent.ListenableFuture;
import javax.inject.Inject;

/* compiled from: tap_delete_confirm_button */
public class CardFormInputControllerFragment extends FbFragment {
    @Inject
    public CardNumberInputValidator f1822a;
    @Inject
    public AnalyticsLogger al;
    public CardFormParams am;
    public boolean an;
    private ListenableFuture ao;
    public C01893 ap;
    public SimplePaymentsComponentCallback aq;
    public PaymentFormEditTextView ar;
    public PaymentFormEditTextView as;
    public PaymentFormEditTextView at;
    public PaymentFormEditTextView au;
    public PaymentInputControllerFragment av;
    public PaymentInputControllerFragment aw;
    public PaymentInputControllerFragment ax;
    public PaymentInputControllerFragment ay;
    public final Listener az = new C01941(this);
    @Inject
    public CardFormattingTextWatcher f1823b;
    @Inject
    public ExpDateInputValidator f1824c;
    @Inject
    public ExpDateFormattingTextWatcher f1825d;
    @Inject
    public SecurityCodeInputValidator f1826e;
    @Inject
    public SecurityCodeFormattingTextWatcher f1827f;
    @Inject
    public BillingZipInputValidator f1828g;
    @Inject
    public BillingZipFormattingTextWatcher f1829h;
    @Inject
    public SimpleCardFormManager f1830i;

    /* compiled from: tap_delete_confirm_button */
    class C01941 implements Listener {
        final /* synthetic */ CardFormInputControllerFragment f1813a;

        C01941(CardFormInputControllerFragment cardFormInputControllerFragment) {
            this.f1813a = cardFormInputControllerFragment;
        }

        public final void mo84a() {
            this.f1813a.ar();
        }

        public final void mo72b() {
            this.f1813a.ar();
            if (this.f1813a.aq != null) {
                Intent c = this.f1813a.f1830i.m2075c(this.f1813a.am.mo78a().f1772a).m2064c(this.f1813a.am);
                if (c != null) {
                    this.f1813a.aq.mo82b(c);
                }
            }
        }

        public final void mo73c() {
            this.f1813a.ar();
        }
    }

    /* compiled from: tap_delete_confirm_button */
    public class C01952 implements OnEditorActionListener {
        final /* synthetic */ CardFormInputControllerFragment f1814a;

        public C01952(CardFormInputControllerFragment cardFormInputControllerFragment) {
            this.f1814a = cardFormInputControllerFragment;
        }

        public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
            if (i != 6) {
                return false;
            }
            this.f1814a.al.a(CardFormAnalyticsEvent.m1970c(this.f1814a.am.mo78a().f1773b.f1769b, this.f1814a.f1830i.m2074b(this.f1814a.am.mo78a().f1772a).m2058f(this.f1814a.am)));
            return this.f1814a.m2016b();
        }
    }

    /* compiled from: tap_delete_confirm_button */
    public class C01963 implements TextWatcher {
        final /* synthetic */ CardFormInputControllerFragment f1815a;

        public C01963(CardFormInputControllerFragment cardFormInputControllerFragment) {
            this.f1815a = cardFormInputControllerFragment;
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void afterTextChanged(Editable editable) {
            if (this.f1815a.ap != null) {
                this.f1815a.ap.m1990a();
            }
            Object obj = editable.toString();
            this.f1815a.av.m2096b(!this.f1815a.f1822a.m2130c(CardFormInputControllerFragment.aE(this.f1815a)));
            this.f1815a.f1830i.m2076d(this.f1815a.am.mo78a().f1772a).m2090a(this.f1815a.am, obj);
            CardFormInputControllerFragment cardFormInputControllerFragment = this.f1815a;
            if (StringUtil.a(obj) || cardFormInputControllerFragment.ar.f1858b || cardFormInputControllerFragment.f1822a.m2130c(CardFormInputControllerFragment.aE(cardFormInputControllerFragment))) {
                cardFormInputControllerFragment.an = false;
            } else if (cardFormInputControllerFragment.an) {
                PaymentsConfirmDialogFragment paymentsConfirmDialogFragment = (PaymentsConfirmDialogFragment) cardFormInputControllerFragment.s().a("unsupported_association_dialog");
                if (paymentsConfirmDialogFragment != null) {
                    paymentsConfirmDialogFragment.am = cardFormInputControllerFragment.az;
                } else {
                    ConfirmActionParams b = cardFormInputControllerFragment.f1830i.m2075c(cardFormInputControllerFragment.am.mo78a().f1772a).m2063b(cardFormInputControllerFragment.am);
                    if (b != null) {
                        paymentsConfirmDialogFragment = PaymentsConfirmDialogFragment.m1953b(b);
                        paymentsConfirmDialogFragment.am = cardFormInputControllerFragment.az;
                        paymentsConfirmDialogFragment.a(cardFormInputControllerFragment.s(), "unsupported_association_dialog");
                    }
                }
            } else {
                cardFormInputControllerFragment.an = true;
            }
            if (this.f1815a.f1822a.mo91a(CardFormInputControllerFragment.aE(this.f1815a))) {
                this.f1815a.as.requestFocus();
            } else if (obj.length() == 0) {
                this.f1815a.av.m2096b(false);
            }
            this.f1815a.ap.m1991a(this.f1815a.m2020e());
        }
    }

    /* compiled from: tap_delete_confirm_button */
    public class C01974 implements PaymentInputControllerFragment.Listener {
        final /* synthetic */ CardFormInputControllerFragment f1816a;

        public C01974(CardFormInputControllerFragment cardFormInputControllerFragment) {
            this.f1816a = cardFormInputControllerFragment;
        }

        public final InputValidatorParams mo83a() {
            return CardFormInputControllerFragment.aE(this.f1816a);
        }
    }

    /* compiled from: tap_delete_confirm_button */
    public class C01985 implements TextWatcher {
        final /* synthetic */ CardFormInputControllerFragment f1817a;

        public C01985(CardFormInputControllerFragment cardFormInputControllerFragment) {
            this.f1817a = cardFormInputControllerFragment;
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void afterTextChanged(Editable editable) {
            if (this.f1817a.ap != null) {
                this.f1817a.ap.m1990a();
            }
            if (this.f1817a.f1824c.mo91a(CardFormInputControllerFragment.aF(this.f1817a))) {
                this.f1817a.at.requestFocus();
            } else if (editable.length() < 5) {
                this.f1817a.ax.m2096b(false);
            } else {
                this.f1817a.ax.m2096b(true);
            }
            this.f1817a.ap.m1991a(this.f1817a.m2020e());
        }
    }

    /* compiled from: tap_delete_confirm_button */
    public class C01996 implements PaymentInputControllerFragment.Listener {
        final /* synthetic */ CardFormInputControllerFragment f1818a;

        public C01996(CardFormInputControllerFragment cardFormInputControllerFragment) {
            this.f1818a = cardFormInputControllerFragment;
        }

        public final InputValidatorParams mo83a() {
            return CardFormInputControllerFragment.aF(this.f1818a);
        }
    }

    /* compiled from: tap_delete_confirm_button */
    public class C02007 implements TextWatcher {
        final /* synthetic */ CardFormInputControllerFragment f1819a;

        public C02007(CardFormInputControllerFragment cardFormInputControllerFragment) {
            this.f1819a = cardFormInputControllerFragment;
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void afterTextChanged(Editable editable) {
            if (this.f1819a.ap != null) {
                this.f1819a.ap.m1990a();
            }
            String inputText = this.f1819a.ar.getInputText();
            if (this.f1819a.f1826e.mo91a(CardFormInputControllerFragment.aG(this.f1819a))) {
                this.f1819a.au.requestFocus();
            } else if (editable.length() < SecurityCodeInputValidator.m2137a(PaymentMethodInputFormattingUtils.m2044a(inputText))) {
                this.f1819a.aw.m2096b(false);
            } else {
                this.f1819a.aw.m2096b(true);
            }
            this.f1819a.ap.m1991a(this.f1819a.m2020e());
        }
    }

    /* compiled from: tap_delete_confirm_button */
    public class C02018 implements PaymentInputControllerFragment.Listener {
        final /* synthetic */ CardFormInputControllerFragment f1820a;

        public C02018(CardFormInputControllerFragment cardFormInputControllerFragment) {
            this.f1820a = cardFormInputControllerFragment;
        }

        public final InputValidatorParams mo83a() {
            return CardFormInputControllerFragment.aG(this.f1820a);
        }
    }

    /* compiled from: tap_delete_confirm_button */
    public class C02029 implements TextWatcher {
        final /* synthetic */ CardFormInputControllerFragment f1821a;

        public C02029(CardFormInputControllerFragment cardFormInputControllerFragment) {
            this.f1821a = cardFormInputControllerFragment;
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void afterTextChanged(Editable editable) {
            if (this.f1821a.ap != null) {
                this.f1821a.ap.m1990a();
            }
            if (editable.length() <= 5) {
                this.f1821a.ay.m2096b(false);
            }
            this.f1821a.ap.m1991a(this.f1821a.m2020e());
        }
    }

    public static void m2013a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((CardFormInputControllerFragment) obj).m2012a(new CardNumberInputValidator(SimpleCardFormManager.m2071a(injectorLike)), CardFormattingTextWatcher.m2102a(injectorLike), ExpDateInputValidator.m2134b(injectorLike), ExpDateFormattingTextWatcher.m2103a(injectorLike), SecurityCodeInputValidator.m2138b(injectorLike), SecurityCodeFormattingTextWatcher.m2104a(injectorLike), BillingZipInputValidator.m2124b(injectorLike), BillingZipFormattingTextWatcher.m2101a(injectorLike), SimpleCardFormManager.m2071a(injectorLike), AnalyticsLoggerMethodAutoProvider.a(injectorLike));
    }

    private void m2012a(CardNumberInputValidator cardNumberInputValidator, CardFormattingTextWatcher cardFormattingTextWatcher, ExpDateInputValidator expDateInputValidator, ExpDateFormattingTextWatcher expDateFormattingTextWatcher, SecurityCodeInputValidator securityCodeInputValidator, SecurityCodeFormattingTextWatcher securityCodeFormattingTextWatcher, BillingZipInputValidator billingZipInputValidator, BillingZipFormattingTextWatcher billingZipFormattingTextWatcher, SimpleCardFormManager simpleCardFormManager, AnalyticsLogger analyticsLogger) {
        this.f1822a = cardNumberInputValidator;
        this.f1823b = cardFormattingTextWatcher;
        this.f1824c = expDateInputValidator;
        this.f1825d = expDateFormattingTextWatcher;
        this.f1826e = securityCodeInputValidator;
        this.f1827f = securityCodeFormattingTextWatcher;
        this.f1828g = billingZipInputValidator;
        this.f1829h = billingZipFormattingTextWatcher;
        this.f1830i = simpleCardFormManager;
        this.al = analyticsLogger;
    }

    public final void m2017c(Bundle bundle) {
        super.c(bundle);
        Class cls = CardFormInputControllerFragment.class;
        m2013a(this, getContext());
    }

    public final void m2018d(@Nullable Bundle bundle) {
        boolean z;
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1934840090);
        super.d(bundle);
        this.am = (CardFormParams) this.s.getParcelable("card_form_params");
        this.f1830i.m2076d(this.am.mo78a().f1772a).mo85a(this.aq);
        OnEditorActionListener c01952 = new C01952(this);
        this.ar.setOnEditorActionListener(c01952);
        this.as.setOnEditorActionListener(c01952);
        this.at.setOnEditorActionListener(c01952);
        this.au.setOnEditorActionListener(c01952);
        this.av = (CardNumberInputControllerFragment) s().a("card_number_input_controller_fragment_tag");
        if (this.av == null) {
            this.av = new CardNumberInputControllerFragment();
            s().a().a(this.av, "card_number_input_controller_fragment_tag").b();
        }
        TextWatcher c01963 = new C01963(this);
        this.av.m2094a(this.ar, 2131558765);
        this.av.f1883b = this.f1823b;
        this.av.f1884c = this.f1822a;
        this.av.f1885d = c01963;
        this.av.f1882a = new C01974(this);
        this.ax = (PaymentInputControllerFragment) s().a("exp_date_input_controller_fragment_tag");
        if (this.ax == null) {
            this.ax = new PaymentInputControllerFragment();
            s().a().a(this.ax, "exp_date_input_controller_fragment_tag").b();
        }
        c01963 = new C01985(this);
        this.ax.m2094a(this.as, 2131558766);
        this.ax.f1883b = this.f1825d;
        this.ax.f1884c = this.f1824c;
        this.ax.f1885d = c01963;
        this.ax.f1882a = new C01996(this);
        this.aw = (PaymentInputControllerFragment) s().a("security_code_input_controller_fragment_tag");
        if (this.aw == null) {
            this.aw = new PaymentInputControllerFragment();
            s().a().a(this.aw, "security_code_input_controller_fragment_tag").b();
        }
        c01963 = new C02007(this);
        this.aw.m2094a(this.at, 2131558767);
        this.aw.f1883b = this.f1827f;
        this.aw.f1884c = this.f1826e;
        this.aw.f1885d = c01963;
        this.aw.f1882a = new C02018(this);
        this.ay = (PaymentInputControllerFragment) s().a("billing_zip_input_controller_fragment_tag");
        if (this.ay == null) {
            this.ay = new PaymentInputControllerFragment();
            s().a().a(this.ay, "billing_zip_input_controller_fragment_tag").b();
        }
        c01963 = new C02029(this);
        this.ay.m2094a(this.au, 2131558768);
        this.ay.f1883b = this.f1829h;
        this.ay.f1884c = this.f1828g;
        this.ay.f1885d = c01963;
        this.ay.f1882a = new PaymentInputControllerFragment.Listener(this) {
            final /* synthetic */ CardFormInputControllerFragment f1812a;

            {
                this.f1812a = r1;
            }

            public final InputValidatorParams mo83a() {
                return new SimpleInputValidatorParams(this.f1812a.au.getInputText());
            }
        };
        FormFieldProperty formFieldProperty = this.am.mo78a().f1774c.f1856d;
        PaymentInputControllerFragment paymentInputControllerFragment = this.ay;
        if (formFieldProperty == FormFieldProperty.HIDDEN || formFieldProperty == FormFieldProperty.OPTIONAL) {
            z = true;
        } else {
            z = false;
        }
        paymentInputControllerFragment.f1888g = z;
        FbPaymentCard fbPaymentCard = this.am.mo78a().f1775d;
        if (fbPaymentCard != null) {
            this.ar.setInputText(PaymentMethodInputFormattingUtils.m2046a(fbPaymentCard.mo99f(), fbPaymentCard.mo98e()));
            this.as.setInputText(PaymentMethodUtil.m2243a(fbPaymentCard));
            this.au.setInputText(fbPaymentCard.mo100i());
            this.ar.m2041b();
        }
        boolean z2 = true;
        SimpleCardFormConfigurator c = this.f1830i.m2075c(this.am.mo78a().f1772a);
        z = false;
        if (c.m2065d(this.am)) {
            this.ax.m2096b(true);
            z = true;
        }
        if (c.m2066e(this.am)) {
            this.aw.aq();
            this.aw.m2096b(true);
            z = true;
        }
        if (c.m2067f(this.am)) {
            this.ay.aq();
            this.ay.m2096b(true);
        } else {
            z2 = z;
        }
        if (z2 && this.ap != null) {
            this.ap.m1990a();
        }
        SimpleCardFormConfigurator c2 = this.f1830i.m2075c(this.am.mo78a().f1772a);
        this.as.setEnabled(c2.m2068g(this.am));
        this.at.setEnabled(c2.m2069h(this.am));
        this.au.setEnabled(c2.m2070i(this.am));
        PaymentsConfirmDialogFragment paymentsConfirmDialogFragment = (PaymentsConfirmDialogFragment) s().a("unsupported_association_dialog");
        if (paymentsConfirmDialogFragment != null) {
            paymentsConfirmDialogFragment.am = this.az;
        }
        if (bundle != null) {
            this.an = bundle.getBoolean("has_made_first_issuer_mistake");
            CharSequence string = bundle.getString("card_number_edit_text");
            CharSequence string2 = bundle.getString("expiration_date_edit_text");
            CharSequence string3 = bundle.getString("security_code_edit_text");
            CharSequence string4 = bundle.getString("billing_zip_edit_text");
            if (string != null) {
                this.ar.setInputText(string);
            }
            if (string2 != null) {
                this.as.setInputText(string2);
            }
            if (string3 != null) {
                this.at.setInputText(string3);
            }
            if (string4 != null) {
                this.au.setInputText(string4);
            }
        }
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -2116015349, a);
    }

    public final void m2019e(Bundle bundle) {
        bundle.putBoolean("has_made_first_issuer_mistake", this.an);
        if (this.ar.getInputText() != null) {
            bundle.putString("card_number_edit_text", this.ar.getInputText());
        }
        if (this.as.getInputText() != null) {
            bundle.putString("expiration_date_edit_text", this.as.getInputText());
        }
        if (this.at.getInputText() != null) {
            bundle.putString("security_code_edit_text", this.at.getInputText());
        }
        if (this.au.getInputText() != null) {
            bundle.putString("billing_zip_edit_text", this.au.getInputText());
        }
        super.e(bundle);
    }

    public final void m2014I() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1777869910);
        super.I();
        at();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 2001244011, a);
    }

    public final boolean m2016b() {
        this.av.ar();
        this.ax.ar();
        this.aw.ar();
        this.ay.ar();
        if (!m2020e()) {
            return false;
        }
        C01893 c01893 = this.ap;
        CardFormMutatorFragment cardFormMutatorFragment = c01893.f1784a.aq;
        CardFormInputBuilder cardFormInputBuilder = new CardFormInputBuilder();
        cardFormInputBuilder.f1805a = c01893.f1784a.f1796g.getInputText();
        cardFormInputBuilder = cardFormInputBuilder;
        cardFormInputBuilder.f1807c = c01893.f1784a.f1797h.getInputText();
        cardFormInputBuilder = cardFormInputBuilder;
        cardFormInputBuilder.f1810f = c01893.f1784a.f1798i.getInputText();
        cardFormInputBuilder = cardFormInputBuilder;
        cardFormInputBuilder.f1811g = c01893.f1784a.al.getInputText();
        cardFormMutatorFragment.m2031a(cardFormInputBuilder.m2003h());
        return true;
    }

    public final boolean m2020e() {
        return this.av.as() && this.ax.as() && this.aw.as() && this.ay.as();
    }

    public final void m2015a(boolean z) {
        this.ar.setEnabled(z);
        this.as.setEnabled(z);
        this.at.setEnabled(z);
        this.au.setEnabled(z);
    }

    public final void ar() {
        this.an = false;
        at();
        this.av.aq();
        this.ax.aq();
        this.aw.aq();
        this.ay.aq();
    }

    private void at() {
        if (this.ao != null) {
            this.ao.cancel(true);
            this.ao = null;
        }
    }

    public static CardNumberInputValidatorParams aE(CardFormInputControllerFragment cardFormInputControllerFragment) {
        return new CardNumberInputValidatorParams(cardFormInputControllerFragment.ar.getInputText(), cardFormInputControllerFragment.am);
    }

    public static InputValidatorParams aF(CardFormInputControllerFragment cardFormInputControllerFragment) {
        return new SimpleInputValidatorParams(cardFormInputControllerFragment.as.getInputText());
    }

    public static SecurityCodeInputValidatorParams aG(CardFormInputControllerFragment cardFormInputControllerFragment) {
        return new SecurityCodeInputValidatorParams(cardFormInputControllerFragment.at.getInputText(), cardFormInputControllerFragment.am.mo78a().f1775d != null ? cardFormInputControllerFragment.am.mo78a().f1775d.mo99f() : PaymentMethodInputFormattingUtils.m2044a(cardFormInputControllerFragment.ar.getInputText()));
    }
}
