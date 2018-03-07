package com.facebook.adspayments;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import com.facebook.adspayments.analytics.PaymentsLogEvent;
import com.facebook.adspayments.protocol.PaymentsProtocolHelper;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.fbservice.ops.OperationResultFutureCallback;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.fbservice.service.ServiceException;
import com.facebook.inject.FbInjector;
import com.facebook.payments.paymentmethods.cardform.PaymentMethodInputFormattingUtils;
import com.facebook.payments.paymentmethods.model.FbPaymentCardType;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import javax.inject.Inject;

/* compiled from: Unable to get mime type for %s */
public class EditPaymentCardActivity extends PaymentCardActivity {
    private int f23564U;
    private String f23565V;
    private ListenableFuture<OperationResult> f23566W;
    @Inject
    public PaymentsProtocolHelper f23567p;
    private String f23568q;
    private String f23569r;
    private FbPaymentCardType f23570s;
    private int f23571t;

    /* compiled from: Unable to get mime type for %s */
    class C28251 extends OperationResultFutureCallback {
        final /* synthetic */ EditPaymentCardActivity f23563a;

        C28251(EditPaymentCardActivity editPaymentCardActivity) {
            this.f23563a = editPaymentCardActivity;
        }

        protected final void m25533a(ServiceException serviceException) {
            this.f23563a.mo1070a(serviceException, this.f23563a.mo1064m());
        }

        protected final void m25534a(Object obj) {
            this.f23563a.m25386t();
            this.f23563a.m25364f("payments_add_card_success");
            this.f23563a.setResult(-1, new Intent());
            this.f23563a.finish();
        }
    }

    private static <T extends Context> void m25536a(Class<T> cls, T t) {
        m25537a((Object) t, (Context) t);
    }

    public static void m25537a(Object obj, Context context) {
        ((EditPaymentCardActivity) obj).f23567p = PaymentsProtocolHelper.m25732a(FbInjector.get(context));
    }

    private void m25535a(PaymentsProtocolHelper paymentsProtocolHelper) {
        this.f23567p = paymentsProtocolHelper;
    }

    protected final void mo1061a(Bundle bundle) {
        super.mo1061a(bundle);
        Class cls = EditPaymentCardActivity.class;
        m25537a((Object) this, (Context) this);
    }

    protected final void mo1072b(boolean z) {
        this.f23452O.setEnabled(z);
        this.f23454Q.setEnabled(z);
        this.f23453P.setEnabled(z);
    }

    protected final int mo1075k() {
        return 2131240148;
    }

    protected final EditText mo1063l() {
        return this.f23454Q;
    }

    protected final void mo1062b(String str) {
        throw new IllegalStateException("Card number can not be changed for edit card operation.");
    }

    protected final FbPaymentCardType mo1064m() {
        return this.f23570s;
    }

    protected final void mo1076o() {
        if (this.f23444G.m25631i() && this.f23443F.m25631i() && this.f23445H.m25631i()) {
            mo1065n();
        }
    }

    protected final void mo1065n() {
        m25387u();
        m25364f("payments_confirm_card_details");
        String[] split = this.f23452O.getText().toString().split("/");
        int parseInt = Integer.parseInt(split[0]);
        int parseInt2 = Integer.parseInt(split[1]);
        String obj = this.f23454Q.getText().toString();
        String obj2 = this.f23453P.getText().toString();
        C28251 c28251 = new C28251(this);
        if (this.f23566W == null || this.f23566W.isDone()) {
            this.f23566W = this.f23567p.m25735a(this.f23568q, this.f23429A.f3967b, obj, parseInt, parseInt2, obj2, this.f23455R);
            Futures.a(this.f23566W, c28251, this.f23439y);
        }
    }

    protected final void mo1071b(Bundle bundle) {
        super.mo1071b(bundle);
        Intent intent = getIntent();
        this.f23568q = intent.getStringExtra("encoded_credential_id");
        this.f23569r = intent.getStringExtra("payment_last_four");
        this.f23570s = (FbPaymentCardType) intent.getSerializableExtra("payment_card_type");
        this.f23571t = Integer.parseInt(intent.getStringExtra("payment_expiry_month"));
        this.f23564U = Integer.parseInt(intent.getStringExtra("payment_expiry_year"));
        this.f23565V = intent.getStringExtra("payment_zip_code");
        this.f23451N.setText(PaymentMethodInputFormattingUtils.a(this.f23570s, this.f23569r));
        this.f23451N.setEnabled(false);
        this.f23442E.m25626a(false);
        this.f23442E.m25655a(this.f23570s);
        this.f23452O.setText(StringFormatUtil.formatStrLocaleSafe("%02d/%02d", Integer.valueOf(this.f23571t), Integer.valueOf(this.f23564U % 100)));
        this.f23453P.setText(this.f23565V);
    }

    protected final PaymentsLogEvent mo1085g(String str) {
        return super.mo1085g(str).m3871q(this.f23568q);
    }

    protected final String mo1073i() {
        return "edit_card";
    }
}
