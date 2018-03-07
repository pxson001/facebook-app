package com.facebook.adspayments;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import com.facebook.adspayments.AdsPaymentsActivity.ServerResponseFutureCallback;
import com.facebook.adspayments.PaymentUiUtil.AfterChangeTextWatcher;
import com.facebook.adspayments.analytics.PaymentsFlowContext;
import com.facebook.adspayments.model.BrazilianTaxIdType;
import com.facebook.adspayments.protocol.PaymentsProtocolHelper;
import com.facebook.adspayments.protocol.PostBusinessAddressMethod;
import com.facebook.adspayments.protocol.PostBusinessAddressParams;
import com.facebook.adspayments.protocol.VerifyBrazilianTaxIdParams;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.common.locale.Country;
import com.facebook.inject.FbInjector;
import com.facebook.payments.paymentmethods.picker.SelectBillingCountryView.OnCountryChange;
import com.facebook.resources.ui.FbEditText;
import com.facebook.ui.futures.TasksManager;
import com.google.common.annotations.VisibleForTesting;
import javax.inject.Inject;

/* compiled from: Unable to get or create thread key */
public class BrazilianTaxIdActivity extends AdsPaymentsActivity {
    public static final Country f23556p = Country.a("BR");
    @Inject
    TasksManager f23557D;
    private FbEditText f23558E;
    @VisibleForTesting
    AdsBillingCountrySelectorView f23559q;
    @VisibleForTesting
    Country f23560r;
    @Inject
    PaymentsProtocolHelper f23561s;
    @Inject
    PostBusinessAddressMethod f23562t;

    /* compiled from: Unable to get or create thread key */
    class C28201 implements Runnable {
        final /* synthetic */ BrazilianTaxIdActivity f23550a;

        C28201(BrazilianTaxIdActivity brazilianTaxIdActivity) {
            this.f23550a = brazilianTaxIdActivity;
        }

        public void run() {
            BrazilianTaxIdActivity.m25527n(this.f23550a);
        }
    }

    /* compiled from: Unable to get or create thread key */
    class C28212 extends AfterChangeTextWatcher {
        final /* synthetic */ BrazilianTaxIdActivity f23551a;

        C28212(BrazilianTaxIdActivity brazilianTaxIdActivity) {
            this.f23551a = brazilianTaxIdActivity;
        }

        public void afterTextChanged(Editable editable) {
            boolean z;
            AdsPaymentsActivity adsPaymentsActivity = this.f23551a;
            if (BrazilianTaxIdType.ofTaxIdOrNull(editable.toString()) != null) {
                z = true;
            } else {
                z = false;
            }
            adsPaymentsActivity.m25353a(0, z);
        }
    }

    /* compiled from: Unable to get or create thread key */
    class C28233 implements OnCountryChange {
        final /* synthetic */ BrazilianTaxIdActivity f23553a;

        /* compiled from: Unable to get or create thread key */
        class C28221 extends AbstractDisposableFutureCallback<Void> {
            final /* synthetic */ C28233 f23552a;

            C28221(C28233 c28233) {
                this.f23552a = c28233;
            }

            protected final void m25515a(Throwable th) {
                this.f23552a.f23553a.m25358b(th);
            }
        }

        C28233(BrazilianTaxIdActivity brazilianTaxIdActivity) {
            this.f23553a = brazilianTaxIdActivity;
        }

        public final void mo751a(Country country) {
            this.f23553a.f23560r = country;
            if (!this.f23553a.f23560r.equals(BrazilianTaxIdActivity.f23556p)) {
                this.f23553a.f23557D.a(com.facebook.adspayments.AddressActivity.Operation.SEND_BUSINESS_ADDRESS, this.f23553a.f23562t.c(new PostBusinessAddressParams(this.f23553a.f23429A.f3969d, country)), new C28221(this));
                this.f23553a.m25355a(this.f23553a.f23560r, null);
            }
        }
    }

    /* compiled from: Unable to get or create thread key */
    public enum Operation {
        SEND_BRAZILIAN_TAX_ID
    }

    private static <T extends Context> void m25521a(Class<T> cls, T t) {
        m25522a((Object) t, (Context) t);
    }

    public static void m25522a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((BrazilianTaxIdActivity) obj).m25520a(PaymentsProtocolHelper.m25732a(fbInjector), PostBusinessAddressMethod.m25740b(fbInjector), TasksManager.b(fbInjector));
    }

    private void m25520a(PaymentsProtocolHelper paymentsProtocolHelper, PostBusinessAddressMethod postBusinessAddressMethod, TasksManager tasksManager) {
        this.f23561s = paymentsProtocolHelper;
        this.f23562t = postBusinessAddressMethod;
        this.f23557D = tasksManager;
    }

    public static Intent m25518a(Context context, PaymentsFlowContext paymentsFlowContext) {
        Intent intent = new Intent(context, BrazilianTaxIdActivity.class);
        intent.putExtra("payments_flow_context_key", paymentsFlowContext);
        return intent;
    }

    protected final void mo1061a(Bundle bundle) {
        super.mo1061a(bundle);
        Class cls = BrazilianTaxIdActivity.class;
        m25522a((Object) this, (Context) this);
    }

    protected final void m25530b(Bundle bundle) {
        super.b(bundle);
        setContentView(2130903434);
        m25356a(new C28201(this));
        m25353a(0, false);
        this.f23560r = f23556p;
        this.f23559q = (AdsBillingCountrySelectorView) a(2131559999);
        this.f23559q.m25463a(this.f23560r, m25526m(), this.f23429A);
        this.f23558E = (FbEditText) a(2131560000);
        this.f23558E.addTextChangedListener(new C28212(this));
    }

    public static void m25525l(BrazilianTaxIdActivity brazilianTaxIdActivity) {
        brazilianTaxIdActivity.m25361d(BrazilianAddressActivity.m25483a(brazilianTaxIdActivity, brazilianTaxIdActivity.f23429A, brazilianTaxIdActivity.f23560r, m25528o(brazilianTaxIdActivity)));
    }

    protected final int mo1075k() {
        return 2131240157;
    }

    protected final String mo1073i() {
        return "brazilian_tax_id";
    }

    private OnCountryChange m25526m() {
        return new C28233(this);
    }

    public static void m25527n(BrazilianTaxIdActivity brazilianTaxIdActivity) {
        brazilianTaxIdActivity.m25370r();
        final BrazilianTaxIdType ofTaxId = BrazilianTaxIdType.ofTaxId(m25528o(brazilianTaxIdActivity));
        PaymentsProtocolHelper paymentsProtocolHelper = brazilianTaxIdActivity.f23561s;
        brazilianTaxIdActivity.f23557D.a(Operation.SEND_BRAZILIAN_TAX_ID, paymentsProtocolHelper.f23703d.c(new VerifyBrazilianTaxIdParams(brazilianTaxIdActivity.f23429A.f3969d, m25528o(brazilianTaxIdActivity))), new ServerResponseFutureCallback<Void>(brazilianTaxIdActivity) {
            final /* synthetic */ BrazilianTaxIdActivity f23555b;

            protected final void m25517a(Object obj) {
                this.f23555b.m25371s();
                if (ofTaxId == BrazilianTaxIdType.CNPJ) {
                    this.f23555b.m25355a(this.f23555b.f23560r, BrazilianTaxIdActivity.m25528o(this.f23555b));
                } else {
                    BrazilianTaxIdActivity.m25525l(this.f23555b);
                }
            }
        });
    }

    public static String m25528o(BrazilianTaxIdActivity brazilianTaxIdActivity) {
        return brazilianTaxIdActivity.f23558E.getText().toString();
    }
}
