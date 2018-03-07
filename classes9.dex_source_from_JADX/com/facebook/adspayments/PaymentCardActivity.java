package com.facebook.adspayments;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import android.widget.Toast;
import com.facebook.adspayments.analytics.PaymentsFlowContext;
import com.facebook.adspayments.analytics.PaymentsLogEvent;
import com.facebook.adspayments.controller.BillingZipInputController;
import com.facebook.adspayments.controller.CardFormSecurityCodeInputController;
import com.facebook.adspayments.controller.CardNumberInputController;
import com.facebook.adspayments.controller.ExpDateInputController;
import com.facebook.adspayments.utils.PaymentsSoftInputUtil;
import com.facebook.adspayments.utils.PostalCodeUtil;
import com.facebook.adspayments.validation.CardInputFieldController;
import com.facebook.common.android.InputMethodManagerMethodAutoProvider;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.locale.Country;
import com.facebook.fbservice.service.ServiceException;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.messaging.payment.dialog.PaymentDialogsBuilder;
import com.facebook.payments.cardio.cardiobase.DefaultPaymentsCardIO;
import com.facebook.payments.cardio.cardiobase.PaymentsCardIO;
import com.facebook.payments.cardio.cardiobase.PaymentsCardIO.ScanResultStatus;
import com.facebook.payments.dialog.PaymentsConfirmDialogFragment;
import com.facebook.payments.dialog.PaymentsConfirmDialogFragment.SimpleListener;
import com.facebook.payments.paymentmethods.model.FbPaymentCardType;
import com.facebook.payments.paymentmethods.picker.PaymentMethodsInfoCache;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;

/* compiled from: Unexpected ViewType */
public abstract class PaymentCardActivity extends AdsPaymentsActivity {
    @Inject
    PaymentsSoftInputUtil f23441D;
    @Inject
    CardNumberInputController f23442E;
    @Inject
    CardFormSecurityCodeInputController f23443F;
    @Inject
    ExpDateInputController f23444G;
    @Inject
    BillingZipInputController f23445H;
    @Inject
    Resources f23446I;
    @Inject
    DefaultPaymentsCardIO f23447J;
    @Inject
    protected Lazy<PaymentDialogsBuilder> f23448K;
    @Inject
    protected PaymentsQeAccessor f23449L;
    @Inject
    PaymentMethodsInfoCache f23450M;
    protected EditText f23451N;
    protected EditText f23452O;
    protected EditText f23453P;
    protected EditText f23454Q;
    protected Country f23455R;
    protected ImmutableList<CardInputFieldController<?>> f23456S;
    protected TextView f23457T;
    private LinearLayout f23458p;
    private ProgressBar f23459q;
    public SimpleListener f23460r;
    public boolean f23461s = false;
    private ImageView f23462t;

    /* compiled from: Unexpected ViewType */
    class C28261 extends SimpleListener {
        final /* synthetic */ PaymentCardActivity f23572a;

        C28261(PaymentCardActivity paymentCardActivity) {
            this.f23572a = paymentCardActivity;
        }

        public final void m25549a() {
            this.f23572a.mo1065n();
        }
    }

    /* compiled from: Unexpected ViewType */
    class C28272 implements OnClickListener {
        final /* synthetic */ PaymentCardActivity f23573a;

        C28272(PaymentCardActivity paymentCardActivity) {
            this.f23573a = paymentCardActivity;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 2086410330);
            this.f23573a.m25364f("payments_add_card_save_button_click");
            this.f23573a.mo1076o();
            Logger.a(2, EntryType.UI_INPUT_END, 660342625, a);
        }
    }

    /* compiled from: Unexpected ViewType */
    class C28283 implements OnEditorActionListener {
        final /* synthetic */ PaymentCardActivity f23574a;

        C28283(PaymentCardActivity paymentCardActivity) {
            this.f23574a = paymentCardActivity;
        }

        public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
            if (i != 6) {
                return false;
            }
            this.f23574a.m25364f("payments_add_card_done_button_click");
            this.f23574a.mo1076o();
            return true;
        }
    }

    /* compiled from: Unexpected ViewType */
    class C28294 implements OnClickListener {
        final /* synthetic */ PaymentCardActivity f23575a;

        C28294(PaymentCardActivity paymentCardActivity) {
            this.f23575a = paymentCardActivity;
        }

        public void onClick(View view) {
            boolean z;
            int a = Logger.a(2, EntryType.UI_INPUT_START, -958586285);
            PaymentCardActivity paymentCardActivity = this.f23575a;
            if (this.f23575a.f23461s) {
                z = false;
            } else {
                z = true;
            }
            paymentCardActivity.f23461s = z;
            this.f23575a.m25375w();
            this.f23575a.m25364f("payments_zip_code_keyboard_switcher_tapped");
            LogUtils.a(-1399982016, a);
        }
    }

    /* compiled from: Unexpected ViewType */
    /* synthetic */ class C28306 {
        static final /* synthetic */ int[] f23576a = new int[ScanResultStatus.values().length];

        static {
            try {
                f23576a[ScanResultStatus.SCAN_NOT_AVAILABLE.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f23576a[ScanResultStatus.SCAN_FAILED.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f23576a[ScanResultStatus.SCAN_SUCCESSFUL.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    public static void m25373a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((PaymentCardActivity) obj).m25372a(new PaymentsSoftInputUtil(InputMethodManagerMethodAutoProvider.b(injectorLike)), CardNumberInputController.m25652b(injectorLike), CardFormSecurityCodeInputController.m25647b(injectorLike), ExpDateInputController.m25662b(injectorLike), BillingZipInputController.m25632b(injectorLike), ResourcesMethodAutoProvider.a(injectorLike), DefaultPaymentsCardIO.a(injectorLike), IdBasedLazy.a(injectorLike, 8039), PaymentsQeAccessor.m25554a(injectorLike), PaymentMethodsInfoCache.m18732a(injectorLike));
    }

    protected abstract void mo1062b(String str);

    protected abstract void mo1072b(boolean z);

    protected abstract EditText mo1063l();

    protected abstract FbPaymentCardType mo1064m();

    protected abstract void mo1065n();

    protected abstract void mo1076o();

    private void m25372a(PaymentsSoftInputUtil paymentsSoftInputUtil, CardNumberInputController cardNumberInputController, CardFormSecurityCodeInputController cardFormSecurityCodeInputController, ExpDateInputController expDateInputController, BillingZipInputController billingZipInputController, Resources resources, PaymentsCardIO paymentsCardIO, Lazy<PaymentDialogsBuilder> lazy, PaymentsQeAccessor paymentsQeAccessor, PaymentMethodsInfoCache paymentMethodsInfoCache) {
        this.f23441D = paymentsSoftInputUtil;
        this.f23442E = cardNumberInputController;
        this.f23443F = cardFormSecurityCodeInputController;
        this.f23444G = expDateInputController;
        this.f23445H = billingZipInputController;
        this.f23446I = resources;
        this.f23447J = paymentsCardIO;
        this.f23448K = lazy;
        this.f23449L = paymentsQeAccessor;
        this.f23450M = paymentMethodsInfoCache;
    }

    protected final void m25386t() {
        this.f23450M.a();
    }

    protected void mo1061a(Bundle bundle) {
        super.mo1061a(bundle);
        Class cls = PaymentCardActivity.class;
        m25373a((Object) this, (Context) this);
        this.f23456S = ImmutableList.of(this.f23442E, this.f23444G, this.f23443F, this.f23445H);
    }

    protected void mo1071b(Bundle bundle) {
        super.b(bundle);
        getWindow().addFlags(8192);
        setContentView(2130906141);
        this.A = (PaymentsFlowContext) getIntent().getParcelableExtra("payments_flow_context_key");
        this.f23438x.m3880a("payments_initiate_add_card", this.f23429A);
        this.f23460r = new C28261(this);
        this.f23458p = (LinearLayout) a(2131565785);
        this.f23451N = (EditText) a(2131565786);
        this.f23452O = (EditText) a(2131558759);
        this.f23454Q = (EditText) a(2131565794);
        this.f23453P = (EditText) a(2131558761);
        this.f23462t = (ImageView) a(2131565790);
        this.f23459q = (ProgressBar) a(2131565792);
        this.f23455R = (Country) getIntent().getParcelableExtra("billing_iso_country");
        ((SecurityFooterView) a(2131565791)).m25604a();
        View findViewById = findViewById(16908290);
        this.f23442E.m25624a(findViewById, this.f23452O, this.f23429A);
        this.f23444G.m25624a(findViewById, this.f23454Q, this.f23429A);
        this.f23443F.m25624a(findViewById, this.f23453P, this.f23429A);
        this.f23445H.m25635a(findViewById, null, this.f23429A, this.f23455R);
        this.f23457T = (TextView) a(2131565820);
        this.f23457T.setTextColor(this.f23446I.getColor(2131362847));
        this.f23457T.setOnClickListener(new C28272(this));
        OnEditorActionListener c28283 = new C28283(this);
        this.f23461s = PostalCodeUtil.f23720a.contains(this.f23455R.b());
        m25375w();
        this.f23462t.setOnClickListener(new C28294(this));
        int size = this.f23456S.size();
        for (int i = 0; i < size; i++) {
            ((CardInputFieldController) this.f23456S.get(i)).mo1091c().setOnEditorActionListener(c28283);
        }
        this.f23441D.m25755a(this, mo1063l());
        PaymentsConfirmDialogFragment paymentsConfirmDialogFragment = (PaymentsConfirmDialogFragment) kO_().a("add_card_retry_dialog");
        if (paymentsConfirmDialogFragment != null) {
            paymentsConfirmDialogFragment.am = this.f23460r;
        }
    }

    private void m25375w() {
        int i;
        EditText editText = this.f23453P;
        if (this.f23461s) {
            i = 528385;
        } else {
            i = 20;
        }
        editText.setInputType(i);
        this.f23462t.setImageResource(this.f23461s ? 2130841735 : 2130837505);
    }

    protected void onSaveInstanceState(Bundle bundle) {
        int size = this.f23456S.size();
        for (int i = 0; i < size; i++) {
            CardInputFieldController cardInputFieldController = (CardInputFieldController) this.f23456S.get(i);
            bundle.putBoolean(cardInputFieldController.mo1090b() + "_input_has_error", cardInputFieldController.f23642k);
        }
        super.onSaveInstanceState(bundle);
    }

    protected void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        int size = this.f23456S.size();
        for (int i = 0; i < size; i++) {
            CardInputFieldController cardInputFieldController = (CardInputFieldController) this.f23456S.get(i);
            cardInputFieldController.m25626a(bundle.getBoolean(cardInputFieldController.mo1090b() + "_input_has_error", false));
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        switch (i) {
            case 1:
                switch (C28306.f23576a[this.f23447J.d().ordinal()]) {
                    case 1:
                        Toast.makeText(this, 2131240149, 0).show();
                        break;
                    case 2:
                        break;
                    case 3:
                        mo1062b(this.f23447J.c());
                        m25364f("payments_card_scanner_success");
                        return;
                    default:
                        return;
                }
                m25364f("payments_card_scanner_fail");
                return;
            default:
                super.onActivityResult(i, i2, intent);
                return;
        }
    }

    protected final void mo1069p() {
        super.mo1069p();
        PaymentsLogEvent p = mo1085g("payments_cancel_add_card").m3870p(mo1064m().getHumanReadableName());
        int size = this.f23456S.size();
        for (int i = 0; i < size; i++) {
            CardInputFieldController cardInputFieldController = (CardInputFieldController) this.f23456S.get(i);
            p.a(cardInputFieldController.mo1090b() + "_is_empty", TextUtils.isEmpty(cardInputFieldController.mo1091c().getText()));
            p.a(cardInputFieldController.mo1090b() + "_is_valid", cardInputFieldController.mo1089a());
        }
        this.f23438x.m3879a(p);
    }

    public void onPause() {
        int a = Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_START, 1435971661);
        super.onPause();
        PaymentsSoftInputUtil paymentsSoftInputUtil = this.f23441D;
        View currentFocus = getCurrentFocus();
        if (currentFocus != null) {
            paymentsSoftInputUtil.f23719a.hideSoftInputFromWindow(currentFocus.getWindowToken(), 0);
        }
        Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_END, 1333766232, a);
    }

    protected void mo1070a(ServiceException serviceException, FbPaymentCardType fbPaymentCardType) {
        m25388v();
        this.f23438x.m3877a((Throwable) serviceException, this.f23429A);
        this.f23438x.m3879a((PaymentsLogEvent) mo1085g("payments_add_card_fail").m3870p(fbPaymentCardType.getHumanReadableName()).m3866a(serviceException));
        this.f23437w.a("PAYMENT_CARD_ADD_FAILED", "Attempted to add a PaymentCard, but received a response with an error", serviceException);
        PaymentDialogsBuilder.m13303a(this, serviceException, getString(2131240136), getString(2131240137));
    }

    protected final void m25387u() {
        this.f23459q.setVisibility(0);
        this.f23458p.setAlpha(0.2f);
        mo1072b(false);
        setRequestedOrientation(14);
    }

    protected final void m25388v() {
        this.f23459q.setVisibility(8);
        this.f23458p.setAlpha(1.0f);
        mo1072b(true);
        setRequestedOrientation(2);
    }
}
