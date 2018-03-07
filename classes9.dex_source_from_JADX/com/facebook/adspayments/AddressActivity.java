package com.facebook.adspayments;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.widget.ArrayAdapter;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import com.facebook.adspayments.AdsPaymentsActivity.ServerResponseFutureCallback;
import com.facebook.adspayments.analytics.PaymentsFlowContext;
import com.facebook.adspayments.model.BusinessAddressDetails;
import com.facebook.adspayments.model.CvvPrepayCreditCard;
import com.facebook.adspayments.protocol.PaymentsProtocolHelper;
import com.facebook.adspayments.utils.FieldRequirementSuffix;
import com.facebook.common.locale.Country;
import com.facebook.inject.FbInjector;
import com.facebook.messaging.payment.dialog.PaymentDialogsBuilder;
import com.facebook.payments.model.CurrencyAmount;
import com.facebook.payments.paymentmethods.cardform.PaymentFormEditTextView;
import com.facebook.resources.ui.FbTextView;
import com.facebook.ui.futures.TasksManager;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.ListenableFuture;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: Unexpected InvalidHeaderValueException. */
public class AddressActivity extends AdsPaymentsActivity {
    private static final ImmutableList<String> ad = ImmutableList.of("AT", "BE", "BU", "CY", "CZ", "DE", "DK", "EE", "ES", "FI", "FR", "GB", new String[]{"EL", "HR", "HU", "IR", "IT", "LT", "LU", "LV", "MT", "NL", "PL", "PT", "RO", "SE", "SI", "SK"});
    private PaymentFormEditTextView f23475D;
    public PaymentFormEditTextView f23476E;
    private PaymentFormEditTextView f23477F;
    private PaymentFormEditTextView f23478G;
    private PaymentFormEditTextView f23479H;
    private PaymentFormEditTextView f23480I;
    private Spinner f23481J;
    private PaymentFormEditTextView f23482K;
    private FbTextView f23483L;
    private RadioGroup f23484M;
    private FbTextView f23485N;
    private RadioGroup f23486O;
    private AddressActivityState f23487P;
    private Country f23488Q;
    private CurrencyAmount f23489R;
    private CvvPrepayCreditCard f23490S;
    private boolean f23491T;
    private String f23492U;
    private String f23493V;
    private String f23494W;
    private String f23495X;
    private String f23496Y;
    private String f23497Z;
    private String aa;
    private String ab;
    private Boolean ac;
    private final Runnable ae = new C27991(this);
    @Inject
    TasksManager f23498p;
    @Inject
    PaymentsProtocolHelper f23499q;
    private FbTextView f23500r;
    private PaymentFormEditTextView f23501s;
    public PaymentFormEditTextView f23502t;

    /* compiled from: Unexpected InvalidHeaderValueException. */
    class C27991 implements Runnable {
        final /* synthetic */ AddressActivity f23469a;

        C27991(AddressActivity addressActivity) {
            this.f23469a = addressActivity;
        }

        public void run() {
            AddressActivity.m25447t(this.f23469a);
        }
    }

    /* compiled from: Unexpected InvalidHeaderValueException. */
    class C28002 implements OnFocusChangeListener {
        final /* synthetic */ AddressActivity f23470a;

        C28002(AddressActivity addressActivity) {
            this.f23470a = addressActivity;
        }

        public void onFocusChange(View view, boolean z) {
            boolean i = AddressActivity.m25442i(this.f23470a.f23502t.getInputText());
            if (z || i) {
                this.f23470a.f23502t.setErrorEnabled(false);
            } else {
                this.f23470a.f23502t.setError(this.f23470a.getString(2131240181));
                this.f23470a.f23502t.setErrorEnabled(true);
            }
            AddressActivity.m25435b(this.f23470a, i);
        }
    }

    /* compiled from: Unexpected InvalidHeaderValueException. */
    class C28013 implements OnFocusChangeListener {
        final /* synthetic */ AddressActivity f23471a;

        C28013(AddressActivity addressActivity) {
            this.f23471a = addressActivity;
        }

        public void onFocusChange(View view, boolean z) {
            PaymentUiUtil.m25552a(this.f23471a.f23476E, this.f23471a.getString(2131240183), FieldRequirementSuffix.OPTIONAL, this.f23471a, z);
        }
    }

    /* compiled from: Unexpected InvalidHeaderValueException. */
    class C28024 implements OnClickListener {
        final /* synthetic */ AddressActivity f23472a;

        C28024(AddressActivity addressActivity) {
            this.f23472a = addressActivity;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            AddressActivity.m25448u(this.f23472a);
        }
    }

    /* compiled from: Unexpected InvalidHeaderValueException. */
    class C28035 implements OnClickListener {
        final /* synthetic */ AddressActivity f23473a;

        C28035(AddressActivity addressActivity) {
            this.f23473a = addressActivity;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            AddressActivity.m25444m(this.f23473a);
        }
    }

    /* compiled from: Unexpected InvalidHeaderValueException. */
    class C28046 extends ServerResponseFutureCallback<Void> {
        final /* synthetic */ AddressActivity f23474a;

        C28046(AddressActivity addressActivity) {
            this.f23474a = addressActivity;
            super(addressActivity);
        }

        protected final void m25423a(Object obj) {
            this.f23474a.m25371s();
            AddressActivity.m25445n(this.f23474a);
        }
    }

    /* compiled from: Unexpected InvalidHeaderValueException. */
    public enum AddressActivityState {
        BUSINESS_ADDRESS,
        CLIENT_ADDRESS;

        public static AddressActivityState find(String str) {
            for (AddressActivityState addressActivityState : values()) {
                if (addressActivityState.toString().equals(str)) {
                    return addressActivityState;
                }
            }
            throw new IllegalArgumentException(str + " not a valid " + AddressActivityState.class.getSimpleName());
        }
    }

    /* compiled from: Unexpected InvalidHeaderValueException. */
    public enum Operation {
        SEND_BUSINESS_ADDRESS
    }

    private static <T extends Context> void m25432a(Class<T> cls, T t) {
        m25433a((Object) t, (Context) t);
    }

    public static void m25433a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((AddressActivity) obj).m25430a(TasksManager.b(fbInjector), PaymentsProtocolHelper.m25732a(fbInjector));
    }

    private void m25430a(TasksManager tasksManager, PaymentsProtocolHelper paymentsProtocolHelper) {
        this.f23498p = tasksManager;
        this.f23499q = paymentsProtocolHelper;
    }

    private static Intent m25424a(Context context, PaymentsFlowContext paymentsFlowContext, AddressActivityState addressActivityState, Country country) {
        Intent intent = new Intent(context, AddressActivity.class);
        intent.putExtra("payments_flow_context_key", paymentsFlowContext);
        intent.putExtra("address_activity_state", addressActivityState.toString());
        intent.putExtra("address_country", country);
        return intent;
    }

    public static Intent m25425a(Context context, PaymentsFlowContext paymentsFlowContext, AddressActivityState addressActivityState, Country country, CurrencyAmount currencyAmount, @Nullable CvvPrepayCreditCard cvvPrepayCreditCard, boolean z) {
        Intent a = m25424a(context, paymentsFlowContext, addressActivityState, country);
        a.putExtra("amount", currencyAmount);
        a.putExtra("card", cvvPrepayCreditCard);
        a.putExtra("ask_cvv", z);
        return a;
    }

    protected final void mo1061a(Bundle bundle) {
        super.mo1061a(bundle);
        Class cls = AddressActivity.class;
        m25433a((Object) this, (Context) this);
    }

    protected final void m25453b(Bundle bundle) {
        m25441h("address_activity_state");
        this.f23487P = AddressActivityState.find(getIntent().getStringExtra("address_activity_state"));
        m25441h("address_country");
        this.f23488Q = (Country) getIntent().getParcelableExtra("address_country");
        this.f23489R = (CurrencyAmount) getIntent().getExtras().getParcelable("amount");
        this.f23490S = (CvvPrepayCreditCard) getIntent().getExtras().getParcelable("card");
        this.f23491T = getIntent().getExtras().getBoolean("ask_cvv");
        super.b(bundle);
        setContentView(2130903176);
        this.f23500r = (FbTextView) a(2131559382);
        this.f23501s = (PaymentFormEditTextView) a(2131559383);
        this.f23502t = (PaymentFormEditTextView) a(2131559384);
        this.f23475D = (PaymentFormEditTextView) a(2131559385);
        this.f23476E = (PaymentFormEditTextView) a(2131559386);
        this.f23477F = (PaymentFormEditTextView) a(2131559387);
        this.f23478G = (PaymentFormEditTextView) a(2131559388);
        this.f23479H = (PaymentFormEditTextView) a(2131559389);
        this.f23480I = (PaymentFormEditTextView) a(2131559390);
        this.f23481J = (Spinner) a(2131559391);
        SpinnerAdapter arrayAdapter = new ArrayAdapter(this, 17367048, ad);
        arrayAdapter.setDropDownViewResource(17367049);
        this.f23481J.setAdapter(arrayAdapter);
        this.f23482K = (PaymentFormEditTextView) a(2131559392);
        this.f23483L = (FbTextView) a(2131559393);
        this.f23484M = (RadioGroup) a(2131559394);
        this.f23485N = (FbTextView) a(2131559397);
        this.f23486O = (RadioGroup) a(2131559398);
        PaymentUiUtil.m25552a(this.f23476E, getString(2131240183), FieldRequirementSuffix.OPTIONAL, this, false);
        PaymentUiUtil.m25551a(this.f23480I, this.f23488Q.a());
        m25443l();
        m25451x();
        this.f23502t.setOnFocusChangeListener(new C28002(this));
        this.f23476E.setOnFocusChangeListener(new C28013(this));
    }

    protected final int mo1075k() {
        if (this.f23487P.equals(AddressActivityState.BUSINESS_ADDRESS)) {
            return 2131240174;
        }
        return 2131240175;
    }

    protected final String mo1073i() {
        return "business_info";
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        if (this.f23487P.equals(AddressActivityState.BUSINESS_ADDRESS) && i == 0 && i2 == -1) {
            this.f23492U = intent.getStringExtra("client_name");
            this.f23493V = intent.getStringExtra("client_email");
            this.f23494W = intent.getStringExtra("client_address");
            this.f23495X = intent.getStringExtra("client_apt");
            this.f23496Y = intent.getStringExtra("client_city");
            this.f23497Z = intent.getStringExtra("client_postal_code");
            this.aa = intent.getStringExtra("client_state");
            this.ab = intent.getStringExtra("client_country");
            this.ac = Boolean.valueOf(intent.getBooleanExtra("is_client_paying_for_invoices", false));
            m25449v();
        }
        super.onActivityResult(i, i2, intent);
    }

    private void m25443l() {
        if (this.f23487P.equals(AddressActivityState.BUSINESS_ADDRESS)) {
            this.f23500r.setText(2131240176);
            this.f23501s.setHint(getString(2131240178));
            this.f23502t.setVisibility(8);
            this.f23481J.setVisibility(0);
            this.f23482K.setVisibility(0);
            this.f23483L.setVisibility(0);
            this.f23484M.setVisibility(0);
            this.f23485N.setVisibility(8);
            this.f23486O.setVisibility(8);
            return;
        }
        this.f23500r.setText(2131240177);
        this.f23501s.setHint(getString(2131240179));
        this.f23502t.setVisibility(0);
        this.f23481J.setVisibility(8);
        this.f23482K.setVisibility(8);
        this.f23483L.setVisibility(8);
        this.f23484M.setVisibility(8);
        this.f23485N.setVisibility(0);
        this.f23486O.setVisibility(0);
    }

    public static void m25444m(AddressActivity addressActivity) {
        addressActivity.f23440z.a(m25424a(addressActivity, addressActivity.f23429A, AddressActivityState.CLIENT_ADDRESS, Country.a("FR")), 0, addressActivity);
    }

    public static void m25445n(AddressActivity addressActivity) {
        addressActivity.m25361d(PrepayFlowFundingActivity.m25563a(addressActivity, addressActivity.f23429A, addressActivity.f23489R, addressActivity.f23490S, addressActivity.f23488Q, addressActivity.f23491T));
    }

    private void m25446o() {
        boolean z;
        Intent intent = new Intent();
        intent.putExtra("client_name", this.f23501s.getInputText());
        intent.putExtra("client_email", this.f23502t.getInputText());
        intent.putExtra("client_address", this.f23475D.getInputText());
        intent.putExtra("client_apt", this.f23476E.getInputText());
        intent.putExtra("client_city", this.f23477F.getInputText());
        intent.putExtra("client_postal_code", this.f23478G.getInputText());
        intent.putExtra("client_state", this.f23479H.getInputText());
        intent.putExtra("client_country", this.f23488Q.b());
        String str = "is_client_paying_for_invoices";
        if (this.f23486O.getCheckedRadioButtonId() == 2131559400) {
            z = true;
        } else {
            z = false;
        }
        intent.putExtra(str, Boolean.valueOf(z));
        setResult(-1, intent);
        finish();
    }

    public static void m25447t(AddressActivity addressActivity) {
        if (!addressActivity.f23487P.equals(AddressActivityState.BUSINESS_ADDRESS)) {
            addressActivity.m25446o();
        } else if (addressActivity.f23484M.getCheckedRadioButtonId() == 2131559395) {
            m25448u(addressActivity);
        } else {
            PaymentDialogsBuilder.m13296a((Context) addressActivity, 2131240190, 2131230736, new C28024(addressActivity), 2131230735, new C28035(addressActivity)).show();
        }
    }

    public static void m25448u(AddressActivity addressActivity) {
        boolean z;
        PaymentsProtocolHelper paymentsProtocolHelper = addressActivity.f23499q;
        String str = addressActivity.f23429A.f3969d;
        String inputText = addressActivity.f23501s.getInputText();
        BusinessAddressDetails businessAddressDetails = new BusinessAddressDetails(addressActivity.f23475D.getInputText(), addressActivity.f23476E.getInputText(), addressActivity.f23477F.getInputText(), addressActivity.f23479H.getInputText(), addressActivity.f23478G.getInputText(), addressActivity.f23488Q.b());
        String w = addressActivity.m25450w();
        if (addressActivity.f23484M.getCheckedRadioButtonId() == 2131559396) {
            z = true;
        } else {
            z = false;
        }
        addressActivity.m25431a(paymentsProtocolHelper.m25736a(str, inputText, businessAddressDetails, w, z, false));
    }

    private void m25449v() {
        boolean z;
        PaymentsProtocolHelper paymentsProtocolHelper = this.f23499q;
        String e = this.f23429A.m3863e();
        String inputText = this.f23501s.getInputText();
        BusinessAddressDetails businessAddressDetails = new BusinessAddressDetails(this.f23475D.getInputText(), this.f23476E.getInputText(), this.f23477F.getInputText(), this.f23479H.getInputText(), this.f23478G.getInputText(), this.f23488Q.b());
        String w = m25450w();
        if (this.f23484M.getCheckedRadioButtonId() == 2131559396) {
            z = true;
        } else {
            z = false;
        }
        m25431a(paymentsProtocolHelper.m25737a(e, inputText, businessAddressDetails, w, z, true, this.f23492U, new BusinessAddressDetails(this.f23494W, this.f23495X, this.f23496Y, this.aa, this.f23497Z, this.ab), this.f23493V, this.ac.booleanValue()));
    }

    private String m25450w() {
        return this.f23481J.getSelectedItem().toString() + this.f23482K.getInputText();
    }

    private void m25431a(ListenableFuture<Void> listenableFuture) {
        m25370r();
        this.f23498p.a(Operation.SEND_BUSINESS_ADDRESS, listenableFuture, new C28046(this));
    }

    private static void m25427a(Intent intent, String str, String str2) {
        intent.putExtra(str, str2);
    }

    private static void m25426a(Intent intent, String str, Boolean bool) {
        intent.putExtra(str, bool);
    }

    private void m25441h(String str) {
        Preconditions.checkState(getIntent().hasExtra(str), "Need %s to start the activity", new Object[]{str});
    }

    public static boolean m25442i(String str) {
        return Patterns.EMAIL_ADDRESS.matcher(str).matches();
    }

    private void m25451x() {
        m25435b(this, m25442i(this.f23502t.getInputText()));
    }

    public static void m25435b(AddressActivity addressActivity, boolean z) {
        Object obj = (addressActivity.f23502t.getVisibility() == 8 || z) ? 1 : null;
        addressActivity.m25356a(obj != null ? addressActivity.ae : null);
    }
}
