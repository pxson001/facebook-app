package com.facebook.adspayments;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;
import com.facebook.adspayments.AddressActivity.AddressActivityState;
import com.facebook.adspayments.AdsPaymentsActivity.ServerResponseFutureCallback;
import com.facebook.adspayments.adinterfaces.abtest.AdsPaymentsExperimentsHelper;
import com.facebook.adspayments.adinterfaces.abtest.ExperimentsForAdsPaymentsModule;
import com.facebook.adspayments.analytics.AdsPaymentsFlowContext;
import com.facebook.adspayments.analytics.PaymentsFlowContext;
import com.facebook.adspayments.analytics.PaymentsFlowState;
import com.facebook.adspayments.analytics.PaymentsLogEvent;
import com.facebook.adspayments.analytics.PaymentsLogger;
import com.facebook.adspayments.model.CvvPrepayCreditCard;
import com.facebook.adspayments.protocol.AddPaymentCardResult;
import com.facebook.adspayments.protocol.CvvPrepayData;
import com.facebook.adspayments.protocol.PaymentsProtocolHelper;
import com.facebook.adspayments.utils.AdsPaymentsPreconditions;
import com.facebook.adspayments.validation.CardInputFieldController;
import com.facebook.auth.annotations.LoggedInUserId;
import com.facebook.common.locale.Country;
import com.facebook.common.util.ExceptionUtil;
import com.facebook.common.util.Quartet;
import com.facebook.common.util.TriState;
import com.facebook.fbservice.ops.OperationResultFutureCallback;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.fbservice.service.ServiceException;
import com.facebook.http.protocol.ApiException;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.messaging.payment.dialog.PaymentDialogsBuilder;
import com.facebook.payments.model.CurrencyAmount;
import com.facebook.payments.paymentmethods.cardform.CardFormInput;
import com.facebook.payments.paymentmethods.cardform.CardFormInputBuilder;
import com.facebook.payments.paymentmethods.cardform.PaymentMethodInputFormattingUtils;
import com.facebook.payments.paymentmethods.model.CreditCard;
import com.facebook.payments.paymentmethods.model.FbPaymentCardType;
import com.facebook.qe.api.Liveness;
import com.facebook.rapidfeedback.RapidFeedbackController;
import com.facebook.ui.dialogs.FbAlertDialogBuilder;
import com.facebook.ui.futures.TasksManager;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.collect.Range;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Callable;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: Unexpected exception */
public class AddPaymentCardActivity extends PaymentCardActivity {
    private boolean f23463U = false;
    @Inject
    @LoggedInUserId
    Provider<String> f23464p;
    @Inject
    PaymentsProtocolHelper f23465q;
    @Inject
    AdsPaymentsExperimentsHelper f23466r;
    @Inject
    RapidFeedbackController f23467s;
    @Inject
    TasksManager f23468t;

    /* compiled from: Unexpected exception */
    class C27911 implements Runnable {
        final /* synthetic */ AddPaymentCardActivity f23412a;

        C27911(AddPaymentCardActivity addPaymentCardActivity) {
            this.f23412a = addPaymentCardActivity;
        }

        public void run() {
            this.f23412a.mo1076o();
        }
    }

    /* compiled from: Unexpected exception */
    class C27922 implements OnClickListener {
        final /* synthetic */ AddPaymentCardActivity f23413a;

        C27922(AddPaymentCardActivity addPaymentCardActivity) {
            this.f23413a = addPaymentCardActivity;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    /* compiled from: Unexpected exception */
    class C27933 implements OnClickListener {
        final /* synthetic */ AddPaymentCardActivity f23414a;

        C27933(AddPaymentCardActivity addPaymentCardActivity) {
            this.f23414a = addPaymentCardActivity;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            super.onBackPressed();
        }
    }

    /* compiled from: Unexpected exception */
    class C27955 implements OnClickListener {
        final /* synthetic */ AddPaymentCardActivity f23418a;

        C27955(AddPaymentCardActivity addPaymentCardActivity) {
            this.f23418a = addPaymentCardActivity;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            this.f23418a.m25360c("prepay_disclaimer");
            this.f23418a.m25388v();
        }
    }

    /* compiled from: Unexpected exception */
    public enum Operation {
        SAVE_CARD,
        FETCH_PREPAY_DATA
    }

    private static <T extends Context> void m25400a(Class<T> cls, T t) {
        m25401a((Object) t, (Context) t);
    }

    public static void m25401a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((AddPaymentCardActivity) obj).m25402a(IdBasedProvider.a(injectorLike, 4442), PaymentsProtocolHelper.m25732a(injectorLike), AdsPaymentsExperimentsHelper.m25609b(injectorLike), RapidFeedbackController.b(injectorLike), TasksManager.b(injectorLike));
    }

    private void m25402a(Provider<String> provider, PaymentsProtocolHelper paymentsProtocolHelper, AdsPaymentsExperimentsHelper adsPaymentsExperimentsHelper, RapidFeedbackController rapidFeedbackController, TasksManager tasksManager) {
        this.f23464p = provider;
        this.f23465q = paymentsProtocolHelper;
        this.f23466r = adsPaymentsExperimentsHelper;
        this.f23467s = rapidFeedbackController;
        this.f23468t = tasksManager;
    }

    public static Intent m25389a(Context context, PaymentsFlowContext paymentsFlowContext, Country country) {
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(paymentsFlowContext);
        Intent intent = new Intent(context, AddPaymentCardActivity.class);
        intent.putExtra("payments_flow_context_key", paymentsFlowContext);
        intent.putExtra("billing_iso_country", country);
        return intent;
    }

    protected final void mo1061a(Bundle bundle) {
        super.mo1061a(bundle);
        Class cls = AddPaymentCardActivity.class;
        m25401a((Object) this, (Context) this);
    }

    protected final void mo1071b(Bundle bundle) {
        super.mo1071b(bundle);
        if (this.f23449L.m25557a(ExperimentsForAdsPaymentsModule.f23624c)) {
            m25357a(getString(2131240128), new C27911(this));
        }
        if (this.f23429A.f3966a.equals("BOOST_POST_FLOW_NAME") && this.f23466r.m25613a()) {
            this.f23457T.setText(2131240129);
        }
    }

    protected final String mo1073i() {
        return "add_card";
    }

    protected final String mo1074j() {
        return PaymentsFlowState.ADD_CC_STATE.toString();
    }

    protected final void mo1072b(boolean z) {
        this.f23451N.setEnabled(z);
        this.f23452O.setEnabled(z);
        this.f23454Q.setEnabled(z);
        this.f23453P.setEnabled(z);
    }

    protected final int mo1075k() {
        return 2131240120;
    }

    protected final EditText mo1063l() {
        return this.f23451N;
    }

    protected final void mo1062b(String str) {
        this.f23451N.setText(str);
    }

    protected final FbPaymentCardType mo1064m() {
        return PaymentMethodInputFormattingUtils.a(this.f23451N.getText().toString());
    }

    public void onBackPressed() {
        PaymentDialogsBuilder.m13295a((Context) this, 2131240152, 2131240153, 2131230745, new C27922(this), 2131230742, new C27933(this)).show();
    }

    protected final void mo1065n() {
        m25387u();
        m25364f("payments_confirm_card_details");
        final FbPaymentCardType m = mo1064m();
        CardFormInputBuilder cardFormInputBuilder = new CardFormInputBuilder();
        cardFormInputBuilder.a = this.f23451N.getText().toString();
        cardFormInputBuilder = cardFormInputBuilder;
        cardFormInputBuilder.c = this.f23452O.getText().toString();
        cardFormInputBuilder = cardFormInputBuilder;
        cardFormInputBuilder.f = this.f23454Q.getText().toString();
        cardFormInputBuilder = cardFormInputBuilder;
        cardFormInputBuilder.g = this.f23453P.getText().toString();
        final CardFormInput h = cardFormInputBuilder.h();
        m25396a(h, new OperationResultFutureCallback(this) {
            final /* synthetic */ AddPaymentCardActivity f23417c;

            protected final void m25339a(Object obj) {
                this.f23417c.m25395a((AddPaymentCardResult) ((OperationResult) obj).k(), h);
            }

            protected final void m25338a(ServiceException serviceException) {
                this.f23417c.mo1070a(serviceException, m);
            }
        });
    }

    private void m25395a(@Nullable AddPaymentCardResult addPaymentCardResult, CardFormInput cardFormInput) {
        m25386t();
        if (addPaymentCardResult == null) {
            this.f23438x.m3882c("Add card result was null", this.f23429A);
            this.f23438x.m3879a((PaymentsLogEvent) mo1085g("payments_add_card_fail").m3870p(cardFormInput.a()).m3868o("Add card result was null"));
            m25388v();
            Toast.makeText(this, 2131240127, 1).show();
            this.f23437w.b(getClass().getName(), "Null result received when card is added successfully.");
            return;
        }
        CreditCard cvvPrepayCreditCard;
        String a = addPaymentCardResult.m25704a();
        TriState b = addPaymentCardResult.m25705b();
        Boolean asBooleanObject = b.asBooleanObject();
        PaymentsLogger paymentsLogger = this.f23438x;
        PaymentsLogEvent q = mo1085g("payments_add_card_success").m3870p(cardFormInput.a()).m3871q(a);
        q.a("is_tricky_bin", asBooleanObject);
        paymentsLogger.m3879a(q);
        CreditCard a2 = cardFormInput.a(a, asBooleanObject.booleanValue(), this.f23455R);
        boolean asBoolean = b.asBoolean(false);
        String c = addPaymentCardResult.m25706c();
        if (asBoolean) {
            cvvPrepayCreditCard = new CvvPrepayCreditCard(a2, c);
        } else {
            cvvPrepayCreditCard = a2;
        }
        if (asBoolean && m25409y().f3974c.isNUX()) {
            m25407w();
            m25398a(cvvPrepayCreditCard, c, this.f23465q.f23706g.b(Quartet.a(this.f23429A.f3969d, cvvPrepayCreditCard, m25408x(), Boolean.valueOf(m25409y().f3973b))));
            return;
        }
        this.f23438x.m3878a(PaymentsFlowState.DONE_STATE, this.f23429A);
        m25397a(cvvPrepayCreditCard);
    }

    private void m25407w() {
        PaymentsQeAccessor paymentsQeAccessor = this.f23449L;
        paymentsQeAccessor.f23579a.a(Liveness.Live, ExperimentsForAdsPaymentsModule.f23625d);
    }

    protected final void mo1070a(ServiceException serviceException, FbPaymentCardType fbPaymentCardType) {
        super.mo1070a(serviceException, fbPaymentCardType);
        if (m25403a((ApiException) ExceptionUtil.a(serviceException, ApiException.class))) {
            m25407w();
        }
    }

    private static boolean m25403a(@Nullable ApiException apiException) {
        return apiException != null && apiException.b().mErrorSubCode == 5001;
    }

    private void m25397a(CreditCard creditCard) {
        Intent intent = new Intent();
        intent.putExtra("encoded_credential_id", creditCard.a());
        intent.putExtra("credit_card", creditCard);
        m25359c(intent);
    }

    public static CreditCard m25404b(Intent intent) {
        return (CreditCard) intent.getParcelableExtra("credit_card");
    }

    private void m25398a(final CreditCard creditCard, final String str, final ListenableFuture<CvvPrepayData> listenableFuture) {
        new FbAlertDialogBuilder(this).b(getLayoutInflater().inflate(2130906367, null, false)).a(2131230745, new OnClickListener(this) {
            final /* synthetic */ AddPaymentCardActivity f23422d;

            public void onClick(DialogInterface dialogInterface, int i) {
                this.f23422d.m25362d("prepay_disclaimer");
                this.f23422d.m25399a(listenableFuture, str, creditCard);
            }
        }).b(2131230742, new C27955(this)).a(false).b();
        m25363e("prepay_disclaimer");
    }

    private void m25399a(ListenableFuture<CvvPrepayData> listenableFuture, final String str, final CreditCard creditCard) {
        this.f23468t.b(Operation.FETCH_PREPAY_DATA, listenableFuture, new ServerResponseFutureCallback<CvvPrepayData>(this) {
            final /* synthetic */ AddPaymentCardActivity f23426c;

            public final void m25342a(Object obj) {
                CvvPrepayData cvvPrepayData = (CvvPrepayData) obj;
                this.f23426c.m25388v();
                Range a = Range.a((Comparable) cvvPrepayData.second, (Comparable) cvvPrepayData.b);
                CvvPrepayCreditCard cvvPrepayCreditCard = new CvvPrepayCreditCard(creditCard, str, (CurrencyAmount) a.d(), (CurrencyAmount) a.g(), (CurrencyAmount) cvvPrepayData.a);
                if (((Boolean) cvvPrepayData.first).booleanValue()) {
                    this.f23426c.m25394a(cvvPrepayCreditCard);
                } else {
                    this.f23426c.m25406b(cvvPrepayCreditCard);
                }
            }

            public final void mo1060a(Throwable th) {
                this.f23426c.m25388v();
                super.mo1060a(th);
            }
        });
    }

    private void m25394a(CvvPrepayCreditCard cvvPrepayCreditCard) {
        m25361d(AddressActivity.m25425a(this, this.f23429A, AddressActivityState.BUSINESS_ADDRESS, this.f23455R, cvvPrepayCreditCard.f23683c, cvvPrepayCreditCard, false));
    }

    private CurrencyAmount m25408x() {
        return m25409y().f3972a;
    }

    private AdsPaymentsFlowContext m25409y() {
        return (AdsPaymentsFlowContext) AdsPaymentsPreconditions.m25754a(this.f23429A, AdsPaymentsFlowContext.class);
    }

    private void m25406b(CvvPrepayCreditCard cvvPrepayCreditCard) {
        m25361d(PrepayFlowFundingActivity.m25563a(this, this.f23429A, cvvPrepayCreditCard.f23683c, cvvPrepayCreditCard, this.f23455R, false));
    }

    private void m25396a(final CardFormInput cardFormInput, OperationResultFutureCallback operationResultFutureCallback) {
        this.f23468t.a(Operation.SAVE_CARD, new Callable<ListenableFuture<OperationResult>>(this) {
            final /* synthetic */ AddPaymentCardActivity f23428b;

            public Object call() {
                return this.f23428b.m25410a(cardFormInput);
            }
        }, operationResultFutureCallback);
    }

    @VisibleForTesting
    final ListenableFuture<OperationResult> m25410a(CardFormInput cardFormInput) {
        return this.f23465q.m25734a(cardFormInput, this.f23455R, (String) this.f23464p.get(), this.f23429A.f3969d, this.f23429A.f3967b, this.f23449L.m25558b(ExperimentsForAdsPaymentsModule.f23625d));
    }

    protected final void mo1076o() {
        Object obj = 1;
        int size = this.f23456S.size();
        int i = 0;
        while (i < size) {
            Object obj2;
            if (((CardInputFieldController) this.f23456S.get(i)).m25631i()) {
                obj2 = obj;
            } else {
                obj2 = null;
            }
            i++;
            obj = obj2;
        }
        if (obj != null) {
            mo1065n();
        }
    }

    public void onDestroy() {
        int a = Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_START, -1170473298);
        super.onDestroy();
        if (this.f23468t != null) {
            this.f23468t.c();
        }
        Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_END, -112108199, a);
    }
}
