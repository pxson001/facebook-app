package com.facebook.adspayments;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.widget.LinearLayout;
import com.facebook.adspayments.AdsPaymentsActivity.ServerResponseFutureCallback;
import com.facebook.adspayments.PaymentUiUtil.AfterChangeTextWatcher;
import com.facebook.adspayments.analytics.PaymentsFlowContext;
import com.facebook.adspayments.model.BusinessAddressDetails;
import com.facebook.adspayments.protocol.GetBrazilianAddressDetailsParams;
import com.facebook.adspayments.protocol.PaymentsProtocolHelper;
import com.facebook.adspayments.protocol.PostBusinessAddressParams;
import com.facebook.adspayments.utils.FieldRequirementSuffix;
import com.facebook.adspayments.utils.PostalCodeUtil;
import com.facebook.auth.annotations.LoggedInUser;
import com.facebook.common.locale.Country;
import com.facebook.common.util.StringUtil;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedProvider;
import com.facebook.ui.futures.TasksManager;
import com.facebook.user.model.User;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import java.util.Iterator;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: Unable to locate ' */
public class BrazilianAddressActivity extends AdsPaymentsActivity {
    public TextInputLayout f23534D;
    private TextInputLayout f23535E;
    private TextInputLayout f23536F;
    public TextInputLayout f23537G;
    public TextInputLayout f23538H;
    public TextInputLayout f23539I;
    private LinearLayout f23540J;
    public String f23541K;
    public Country f23542L;
    private ImmutableSet<TextInputLayout> f23543M;
    private ImmutableList<TextInputLayout> f23544N;
    @Inject
    TasksManager f23545p;
    @Inject
    PaymentsProtocolHelper f23546q;
    @Inject
    @LoggedInUser
    Provider<User> f23547r;
    private TextInputLayout f23548s;
    public TextInputLayout f23549t;

    /* compiled from: Unable to locate ' */
    class C28131 implements Runnable {
        final /* synthetic */ BrazilianAddressActivity f23527a;

        C28131(BrazilianAddressActivity brazilianAddressActivity) {
            this.f23527a = brazilianAddressActivity;
        }

        public void run() {
            BrazilianAddressActivity.m25506m(this.f23527a);
        }
    }

    /* compiled from: Unable to locate ' */
    class C28142 implements OnFocusChangeListener {
        final /* synthetic */ BrazilianAddressActivity f23528a;

        C28142(BrazilianAddressActivity brazilianAddressActivity) {
            this.f23528a = brazilianAddressActivity;
        }

        public void onFocusChange(View view, boolean z) {
            this.f23528a.m25493b(z);
        }
    }

    /* compiled from: Unable to locate ' */
    class C28153 implements OnFocusChangeListener {
        final /* synthetic */ BrazilianAddressActivity f23529a;

        C28153(BrazilianAddressActivity brazilianAddressActivity) {
            this.f23529a = brazilianAddressActivity;
        }

        public void onFocusChange(View view, boolean z) {
            BrazilianAddressActivity.m25495c(this.f23529a, z);
        }
    }

    /* compiled from: Unable to locate ' */
    class C28164 extends AfterChangeTextWatcher {
        final /* synthetic */ BrazilianAddressActivity f23530a;

        C28164(BrazilianAddressActivity brazilianAddressActivity) {
            this.f23530a = brazilianAddressActivity;
        }

        public void afterTextChanged(Editable editable) {
            String a = PaymentUiUtil.m25550a(this.f23530a.f23549t);
            if (PostalCodeUtil.m25758a(a, BrazilianTaxIdActivity.f23556p)) {
                BrazilianAddressActivity.m25491b(this.f23530a, a);
            } else {
                BrazilianAddressActivity.m25508o(this.f23530a);
            }
        }
    }

    /* compiled from: Unable to locate ' */
    class C28175 extends AfterChangeTextWatcher {
        final /* synthetic */ BrazilianAddressActivity f23531a;

        C28175(BrazilianAddressActivity brazilianAddressActivity) {
            this.f23531a = brazilianAddressActivity;
        }

        public void afterTextChanged(Editable editable) {
            BrazilianAddressActivity.m25505l(this.f23531a);
        }
    }

    /* compiled from: Unable to locate ' */
    class C28186 extends ServerResponseFutureCallback<BusinessAddressDetails> {
        final /* synthetic */ BrazilianAddressActivity f23532a;

        C28186(BrazilianAddressActivity brazilianAddressActivity) {
            this.f23532a = brazilianAddressActivity;
            super(brazilianAddressActivity);
        }

        protected final void m25481a(Object obj) {
            BusinessAddressDetails businessAddressDetails = (BusinessAddressDetails) obj;
            this.f23532a.m25371s();
            PaymentUiUtil.m25551a(this.f23532a.f23534D, businessAddressDetails.m25689a());
            PaymentUiUtil.m25551a(this.f23532a.f23537G, businessAddressDetails.m25691c());
            PaymentUiUtil.m25551a(this.f23532a.f23538H, businessAddressDetails.m25690b());
            PaymentUiUtil.m25551a(this.f23532a.f23539I, businessAddressDetails.m25692d());
            BrazilianAddressActivity.m25505l(this.f23532a);
            BrazilianAddressActivity.m25507n(this.f23532a);
        }
    }

    /* compiled from: Unable to locate ' */
    class C28197 extends ServerResponseFutureCallback<Void> {
        final /* synthetic */ BrazilianAddressActivity f23533a;

        C28197(BrazilianAddressActivity brazilianAddressActivity) {
            this.f23533a = brazilianAddressActivity;
            super(brazilianAddressActivity);
        }

        protected final void m25482a(Object obj) {
            this.f23533a.m25371s();
            this.f23533a.m25355a(this.f23533a.f23542L, this.f23533a.f23541K);
        }
    }

    /* compiled from: Unable to locate ' */
    public enum Operation {
        SEND_POSTAL_CODE,
        SEND_BUSINESS_ADDRESS
    }

    private static <T extends Context> void m25488a(Class<T> cls, T t) {
        m25489a((Object) t, (Context) t);
    }

    public static void m25489a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((BrazilianAddressActivity) obj).m25487a(TasksManager.b(fbInjector), PaymentsProtocolHelper.m25732a(fbInjector), IdBasedProvider.a(fbInjector, 3595));
    }

    private void m25487a(TasksManager tasksManager, PaymentsProtocolHelper paymentsProtocolHelper, Provider<User> provider) {
        this.f23545p = tasksManager;
        this.f23546q = paymentsProtocolHelper;
        this.f23547r = provider;
    }

    public static Intent m25483a(Context context, PaymentsFlowContext paymentsFlowContext, Country country, String str) {
        Intent intent = new Intent(context, BrazilianAddressActivity.class);
        intent.putExtra("payments_flow_context_key", paymentsFlowContext);
        intent.putExtra("billing_iso_country", country);
        intent.putExtra("tax_id", str);
        return intent;
    }

    protected final void mo1061a(Bundle bundle) {
        super.mo1061a(bundle);
        Class cls = BrazilianAddressActivity.class;
        m25489a((Object) this, (Context) this);
    }

    protected final void m25511b(Bundle bundle) {
        super.b(bundle);
        setContentView(2130903433);
        this.f23542L = (Country) getIntent().getParcelableExtra("billing_iso_country");
        this.f23541K = getIntent().getStringExtra("tax_id");
        m25356a(new C28131(this));
        m25353a(0, false);
        this.f23548s = (TextInputLayout) a(2131559990);
        this.f23549t = (TextInputLayout) a(2131559991);
        this.f23534D = (TextInputLayout) a(2131559992);
        this.f23535E = (TextInputLayout) a(2131559993);
        m25493b(false);
        this.f23535E.setOnFocusChangeListener(new C28142(this));
        this.f23536F = (TextInputLayout) a(2131559994);
        m25495c(this, false);
        this.f23536F.setOnFocusChangeListener(new C28153(this));
        this.f23537G = (TextInputLayout) a(2131559995);
        this.f23538H = (TextInputLayout) a(2131559997);
        this.f23539I = (TextInputLayout) a(2131559998);
        this.f23540J = (LinearLayout) a(2131559996);
        this.f23543M = ImmutableSet.of(this.f23548s, this.f23534D, this.f23535E);
        this.f23544N = ImmutableList.of(this.f23548s, this.f23549t, this.f23534D, this.f23535E, this.f23536F, this.f23537G);
        this.f23549t.a.addTextChangedListener(new C28164(this));
        TextWatcher c28175 = new C28175(this);
        Iterator it = this.f23543M.iterator();
        while (it.hasNext()) {
            ((TextInputLayout) it.next()).a.addTextChangedListener(c28175);
        }
        this.f23548s.a.setText(((User) this.f23547r.get()).j());
        m25509t();
    }

    private void m25493b(boolean z) {
        PaymentUiUtil.m25552a(this.f23535E, getString(2131240160), FieldRequirementSuffix.REQUIRED, this, z);
    }

    public static void m25495c(BrazilianAddressActivity brazilianAddressActivity, boolean z) {
        PaymentUiUtil.m25552a(brazilianAddressActivity.f23536F, brazilianAddressActivity.getString(2131240161), FieldRequirementSuffix.OPTIONAL, brazilianAddressActivity, z);
    }

    public static void m25505l(BrazilianAddressActivity brazilianAddressActivity) {
        Iterator it = brazilianAddressActivity.f23543M.iterator();
        boolean z = true;
        while (it.hasNext()) {
            boolean z2;
            if (StringUtil.a(PaymentUiUtil.m25550a((TextInputLayout) it.next()))) {
                z2 = false;
            } else {
                z2 = z;
            }
            z = z2;
        }
        brazilianAddressActivity.m25353a(0, z);
    }

    public static void m25491b(BrazilianAddressActivity brazilianAddressActivity, String str) {
        brazilianAddressActivity.m25370r();
        brazilianAddressActivity.f23545p.a(Operation.SEND_POSTAL_CODE, brazilianAddressActivity.f23546q.f23704e.b(new GetBrazilianAddressDetailsParams(str)), new C28186(brazilianAddressActivity));
    }

    public static void m25506m(BrazilianAddressActivity brazilianAddressActivity) {
        brazilianAddressActivity.m25370r();
        PaymentsProtocolHelper paymentsProtocolHelper = brazilianAddressActivity.f23546q;
        brazilianAddressActivity.f23545p.a(Operation.SEND_BUSINESS_ADDRESS, paymentsProtocolHelper.f23705f.c(new PostBusinessAddressParams(brazilianAddressActivity.f23429A.f3969d, PaymentUiUtil.m25550a(brazilianAddressActivity.f23548s), new BusinessAddressDetails(PaymentUiUtil.m25550a(brazilianAddressActivity.f23534D), PaymentUiUtil.m25550a(brazilianAddressActivity.f23535E), PaymentUiUtil.m25550a(brazilianAddressActivity.f23536F), PaymentUiUtil.m25550a(brazilianAddressActivity.f23537G), PaymentUiUtil.m25550a(brazilianAddressActivity.f23538H), PaymentUiUtil.m25550a(brazilianAddressActivity.f23539I), PaymentUiUtil.m25550a(brazilianAddressActivity.f23549t), brazilianAddressActivity.f23542L), brazilianAddressActivity.f23541K)), new C28197(brazilianAddressActivity));
    }

    private void m25497d(boolean z) {
        PaymentUiUtil.m25553a(this.f23534D, z);
        PaymentUiUtil.m25553a(this.f23535E, z);
        PaymentUiUtil.m25553a(this.f23536F, z);
        PaymentUiUtil.m25553a(this.f23537G, z);
        PaymentUiUtil.m25553a(this.f23540J, z);
    }

    public static void m25507n(BrazilianAddressActivity brazilianAddressActivity) {
        brazilianAddressActivity.m25497d(true);
        brazilianAddressActivity.m25509t();
    }

    public static void m25508o(BrazilianAddressActivity brazilianAddressActivity) {
        brazilianAddressActivity.m25497d(false);
        PaymentUiUtil.m25551a(brazilianAddressActivity.f23534D, "");
        PaymentUiUtil.m25551a(brazilianAddressActivity.f23535E, "");
        PaymentUiUtil.m25551a(brazilianAddressActivity.f23536F, "");
        PaymentUiUtil.m25551a(brazilianAddressActivity.f23537G, "");
    }

    private void m25509t() {
        int size = this.f23544N.size();
        for (int i = 0; i < size; i++) {
            TextInputLayout textInputLayout = (TextInputLayout) this.f23544N.get(i);
            if (textInputLayout.getVisibility() == 0 && StringUtil.a(PaymentUiUtil.m25550a(textInputLayout))) {
                textInputLayout.requestFocus();
                return;
            }
        }
    }

    protected final int mo1075k() {
        return 2131240171;
    }

    protected final String mo1073i() {
        return "brazilian_address";
    }
}
