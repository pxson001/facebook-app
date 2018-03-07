package com.facebook.adspayments;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.adspayments.AdsPaymentsActivity.ServerResponseFutureCallback;
import com.facebook.adspayments.PaymentUiUtil.AfterChangeTextWatcher;
import com.facebook.adspayments.adinterfaces.abtest.AdsPaymentsExperimentsHelper;
import com.facebook.adspayments.analytics.PaymentsFlowContext;
import com.facebook.adspayments.controller.StandaloneSecurityCodeInputController;
import com.facebook.adspayments.controller.StandaloneSecurityCodeInputControllerProvider;
import com.facebook.adspayments.model.CvvPrepayCreditCard;
import com.facebook.adspayments.protocol.GetCscTokenMethod;
import com.facebook.adspayments.protocol.PrepayFundMethod;
import com.facebook.adspayments.utils.PickerScreenUtils;
import com.facebook.adspayments.validation.SecurityCodeInputValidator;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.common.futures.FbFutures;
import com.facebook.common.locale.Country;
import com.facebook.common.util.ExceptionUtil;
import com.facebook.common.util.ParcelablePair;
import com.facebook.common.util.Quartet;
import com.facebook.http.protocol.ApiException;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectorLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.messaging.payment.dialog.PaymentDialogsBuilder;
import com.facebook.payments.model.CurrencyAmount;
import com.facebook.payments.paymentmethods.cardform.PaymentFormEditTextView;
import com.facebook.payments.paymentmethods.cardform.formatting.SecurityCodeFormattingTextWatcher;
import com.facebook.payments.paymentmethods.model.CreditCard;
import com.facebook.payments.paymentmethods.model.FbPaymentCardType;
import com.facebook.payments.paymentmethods.model.PaymentMethod;
import com.facebook.payments.paymentmethods.model.PaymentMethodsInfo;
import com.facebook.payments.paymentmethods.picker.PaymentMethodView;
import com.facebook.payments.paymentmethods.picker.PaymentMethodsInfoCache;
import com.facebook.payments.paymentmethods.picker.PickerScreenActivity;
import com.facebook.payments.paymentmethods.picker.model.PaymentMethodsPickerScreenFetcherParams;
import com.facebook.payments.paymentmethods.picker.model.PaymentMethodsPickerScreenFetcherParamsBuilder;
import com.facebook.ui.futures.TasksManager;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.collect.Iterables;
import com.google.common.collect.Range;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.MoreExecutors.DirectExecutor;
import java.math.BigDecimal;
import java.util.concurrent.ExecutorService;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: Unable to get group thread id for conference call */
public class PrepayFlowFundingActivity extends AdsPaymentsActivity {
    @VisibleForTesting
    TasksManager<TaskId> f23592D;
    public CurrencyAmount f23593E;
    public ListenableFuture<PaymentMethod> f23594F;
    private boolean f23595G = false;
    public boolean f23596H = false;
    public StandaloneSecurityCodeInputController f23597I;
    private View f23598J;
    private PaymentMethodView f23599K;
    @Nullable
    private CvvPrepayCreditCard f23600L;
    private Country f23601M;
    private final Runnable f23602N = new C28321(this);
    @Inject
    TasksManager f23603p;
    @Inject
    StandaloneSecurityCodeInputControllerProvider f23604q;
    @Inject
    PaymentMethodsInfoCache f23605r;
    @Inject
    GetCscTokenMethod f23606s;
    @Inject
    PrepayFundMethod f23607t;

    /* compiled from: Unable to get group thread id for conference call */
    class C28321 implements Runnable {
        final /* synthetic */ PrepayFlowFundingActivity f23580a;

        C28321(PrepayFlowFundingActivity prepayFlowFundingActivity) {
            this.f23580a = prepayFlowFundingActivity;
        }

        public void run() {
            PrepayFlowFundingActivity.m25589t(this.f23580a);
        }
    }

    /* compiled from: Unable to get group thread id for conference call */
    class C28332 implements Function<PaymentMethodsInfo, PaymentMethod> {
        final /* synthetic */ PrepayFlowFundingActivity f23581a;

        C28332(PrepayFlowFundingActivity prepayFlowFundingActivity) {
            this.f23581a = prepayFlowFundingActivity;
        }

        public Object apply(Object obj) {
            return (PaymentMethod) Preconditions.checkNotNull((PaymentMethod) Iterables.a(((PaymentMethodsInfo) obj).d, null), "Neither an explicitly provided payment method, nor one already on file found");
        }
    }

    /* compiled from: Unable to get group thread id for conference call */
    class C28343 extends ServerResponseFutureCallback<PaymentMethod> {
        final /* synthetic */ PrepayFlowFundingActivity f23582a;

        C28343(PrepayFlowFundingActivity prepayFlowFundingActivity) {
            this.f23582a = prepayFlowFundingActivity;
            super(prepayFlowFundingActivity);
        }

        protected final void m25559a(Object obj) {
            PaymentMethod paymentMethod = (PaymentMethod) obj;
            this.f23582a.m25371s();
            this.f23582a.m25569a(paymentMethod);
        }
    }

    /* compiled from: Unable to get group thread id for conference call */
    class C28354 implements OnClickListener {
        final /* synthetic */ PrepayFlowFundingActivity f23583a;

        C28354(PrepayFlowFundingActivity prepayFlowFundingActivity) {
            this.f23583a = prepayFlowFundingActivity;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 2064478776);
            PrepayFlowFundingActivity.m25586m(this.f23583a);
            Logger.a(2, EntryType.UI_INPUT_END, 1857128308, a);
        }
    }

    /* compiled from: Unable to get group thread id for conference call */
    class C28397 extends ServerResponseFutureCallback<String> {
        final /* synthetic */ PrepayFlowFundingActivity f23590a;

        /* compiled from: Unable to get group thread id for conference call */
        class C28381 implements DialogInterface.OnClickListener {
            final /* synthetic */ C28397 f23589a;

            C28381(C28397 c28397) {
                this.f23589a = c28397;
            }

            public void onClick(DialogInterface dialogInterface, int i) {
                this.f23589a.f23590a.m25371s();
                this.f23589a.f23590a.m25359c(null);
            }
        }

        C28397(PrepayFlowFundingActivity prepayFlowFundingActivity) {
            this.f23590a = prepayFlowFundingActivity;
            super(prepayFlowFundingActivity);
        }

        protected final void m25561a(Object obj) {
            PrepayFlowFundingActivity prepayFlowFundingActivity = this.f23590a;
            PaymentDialogsBuilder.m13299a(prepayFlowFundingActivity, prepayFlowFundingActivity.getString(2131240195), prepayFlowFundingActivity.getString(2131240196), prepayFlowFundingActivity.getString(2131230726), new C28381(this)).show();
        }

        protected final void mo1060a(Throwable th) {
            super.mo1060a(th);
            if (PrepayFlowFundingActivity.m25580c(th)) {
                this.f23590a.m25596b(true);
            }
        }
    }

    /* compiled from: Unable to get group thread id for conference call */
    class C28408 extends AfterChangeTextWatcher {
        final /* synthetic */ PrepayFlowFundingActivity f23591a;

        C28408(PrepayFlowFundingActivity prepayFlowFundingActivity) {
            this.f23591a = prepayFlowFundingActivity;
        }

        public void afterTextChanged(Editable editable) {
            if (!this.f23591a.f23597I.mo1089a()) {
                this.f23591a.f23597I.m25631i();
            }
            PrepayFlowFundingActivity.m25592w(this.f23591a);
        }
    }

    /* compiled from: Unable to get group thread id for conference call */
    enum TaskId {
        GET_DEFAULT_PAYMENT_METHOD,
        GET_CVV_TOKEN,
        CHARGE
    }

    private static <T extends Context> void m25571a(Class<T> cls, T t) {
        m25572a((Object) t, (Context) t);
    }

    public static void m25572a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((PrepayFlowFundingActivity) obj).m25570a(TasksManager.b(injectorLike), (StandaloneSecurityCodeInputControllerProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(StandaloneSecurityCodeInputControllerProvider.class), PaymentMethodsInfoCache.m18732a(injectorLike), GetCscTokenMethod.m25723b(injectorLike), PrepayFundMethod.m25745b(injectorLike));
    }

    @Nullable
    private CurrencyAmount m25566a(CharSequence charSequence) {
        BigDecimal bigDecimal;
        double b = CurrencyAmount.b(charSequence);
        if (Double.isNaN(b)) {
            bigDecimal = null;
        } else {
            bigDecimal = BigDecimal.valueOf(b);
        }
        BigDecimal bigDecimal2 = bigDecimal;
        return bigDecimal2 != null ? new CurrencyAmount(this.f23593E.b, bigDecimal2) : null;
    }

    public static Intent m25563a(Context context, PaymentsFlowContext paymentsFlowContext, CurrencyAmount currencyAmount, @Nullable CvvPrepayCreditCard cvvPrepayCreditCard, Country country, boolean z) {
        Intent intent = new Intent(context, PrepayFlowFundingActivity.class);
        intent.putExtra("payments_flow_context_key", paymentsFlowContext);
        intent.putExtra("amount", currencyAmount);
        intent.putExtra("card", cvvPrepayCreditCard);
        intent.putExtra("ask_cvv", z);
        intent.putExtra("country", country);
        return intent;
    }

    protected final void mo1061a(Bundle bundle) {
        super.mo1061a(bundle);
        Class cls = PrepayFlowFundingActivity.class;
        m25572a((Object) this, (Context) this);
        this.f23592D = this.f23603p;
    }

    protected final int mo1075k() {
        return 2131240170;
    }

    protected final String mo1073i() {
        return this.f23595G ? "funding_cvv" : "funding";
    }

    protected final void m25595b(Bundle bundle) {
        ListenableFuture a;
        super.b(bundle);
        Bundle extras = getIntent().getExtras();
        this.f23593E = (CurrencyAmount) extras.getParcelable("amount");
        this.f23600L = (CvvPrepayCreditCard) extras.getParcelable("card");
        this.f23601M = (Country) extras.getParcelable("country");
        boolean z = extras.getBoolean("ask_cvv");
        setContentView(2130906368);
        Object obj = this.f23600L != null ? 1 : null;
        if (obj != null) {
            a = Futures.a(this.f23600L);
        } else {
            a = Futures.a(m25585l(), new C28332(this), DirectExecutor.INSTANCE);
        }
        this.f23594F = a;
        m25592w(this);
        m25587n();
        m25579c(obj == null);
        m25581d(z);
        this.f23592D.a(TaskId.GET_DEFAULT_PAYMENT_METHOD, this.f23594F, new C28343(this));
    }

    private ListenableFuture<PaymentMethodsInfo> m25585l() {
        m25370r();
        return this.f23605r.m18736a(this.f23429A.f3967b, this.f23429A.f3969d, this.f23601M);
    }

    private void m25579c(boolean z) {
        this.f23599K = (PaymentMethodView) a(2131565784);
        this.f23599K.m18729a(z);
        if (z) {
            this.f23599K.setOnClickListener(new C28354(this));
        }
    }

    public static void m25586m(PrepayFlowFundingActivity prepayFlowFundingActivity) {
        String string = prepayFlowFundingActivity.getString(2131233858);
        PaymentsFlowContext paymentsFlowContext = prepayFlowFundingActivity.f23429A;
        PaymentMethodsPickerScreenFetcherParamsBuilder newBuilder = PaymentMethodsPickerScreenFetcherParams.newBuilder();
        newBuilder.f18852c = prepayFlowFundingActivity.f23601M;
        newBuilder = newBuilder;
        newBuilder.f18850a = true;
        prepayFlowFundingActivity.f23440z.a(PickerScreenActivity.m18779a((Context) prepayFlowFundingActivity, PickerScreenUtils.m25756a(string, paymentsFlowContext, newBuilder.m18855d(), true)), 0, prepayFlowFundingActivity);
    }

    private void m25569a(PaymentMethod paymentMethod) {
        boolean z;
        boolean z2 = true;
        this.f23599K.setPaymentMethod(paymentMethod);
        paymentMethod = paymentMethod instanceof CreditCard ? (CreditCard) paymentMethod : null;
        if (paymentMethod != null) {
            z = true;
        } else {
            z = false;
        }
        if (!(z && !(paymentMethod instanceof CvvPrepayCreditCard) && paymentMethod.h().booleanValue())) {
            z2 = false;
        }
        m25596b(z2);
        if (z) {
            this.f23597I.f23676c = paymentMethod.f();
        }
    }

    private void m25587n() {
        final PaymentFormEditTextView paymentFormEditTextView = (PaymentFormEditTextView) a(2131566208);
        paymentFormEditTextView.setInputText(this.f23593E.c());
        m25592w(this);
        paymentFormEditTextView.a(new AfterChangeTextWatcher(this) {
            final /* synthetic */ PrepayFlowFundingActivity f23585b;

            public void afterTextChanged(Editable editable) {
                int i;
                PrepayFlowFundingActivity prepayFlowFundingActivity;
                boolean z;
                CurrencyAmount a = this.f23585b.m25566a((CharSequence) editable);
                int i2 = a != null ? 1 : 0;
                PaymentMethod paymentMethod = (PaymentMethod) FbFutures.a(this.f23585b.f23594F);
                if (i2 != 0 && (paymentMethod instanceof CvvPrepayCreditCard)) {
                    Object obj;
                    CvvPrepayCreditCard cvvPrepayCreditCard = (CvvPrepayCreditCard) paymentMethod;
                    if (cvvPrepayCreditCard.f23682b == null || cvvPrepayCreditCard.f23682b.a(a)) {
                        obj = null;
                    } else {
                        obj = 1;
                    }
                    if (obj != null) {
                        i = 1;
                        prepayFlowFundingActivity = this.f23585b;
                        if (i2 == 0 && i == 0) {
                            z = true;
                        } else {
                            z = false;
                        }
                        prepayFlowFundingActivity.f23596H = z;
                        if (this.f23585b.f23596H) {
                            this.f23585b.f23593E = a;
                        }
                        PrepayFlowFundingActivity.m25592w(this.f23585b);
                        if (i == 0) {
                            Range range = (Range) Preconditions.checkNotNull(((CvvPrepayCreditCard) paymentMethod).f23682b);
                            paymentFormEditTextView.a(this.f23585b.getString(2131240194, new Object[]{range.d(), range.g()}));
                        }
                        paymentFormEditTextView.c();
                        return;
                    }
                }
                i = 0;
                prepayFlowFundingActivity = this.f23585b;
                if (i2 == 0) {
                }
                z = false;
                prepayFlowFundingActivity.f23596H = z;
                if (this.f23585b.f23596H) {
                    this.f23585b.f23593E = a;
                }
                PrepayFlowFundingActivity.m25592w(this.f23585b);
                if (i == 0) {
                    paymentFormEditTextView.c();
                    return;
                }
                Range range2 = (Range) Preconditions.checkNotNull(((CvvPrepayCreditCard) paymentMethod).f23682b);
                paymentFormEditTextView.a(this.f23585b.getString(2131240194, new Object[]{range2.d(), range2.g()}));
            }
        });
    }

    private void m25588o() {
        m25592w(this);
    }

    public static void m25589t(PrepayFlowFundingActivity prepayFlowFundingActivity) {
        prepayFlowFundingActivity.m25370r();
        final PaymentMethod u = prepayFlowFundingActivity.m25590u();
        final CurrencyAmount currencyAmount = prepayFlowFundingActivity.f23593E;
        prepayFlowFundingActivity.f23592D.a(TaskId.GET_CVV_TOKEN, prepayFlowFundingActivity.m25575b(u), new ServerResponseFutureCallback<String>(prepayFlowFundingActivity) {
            final /* synthetic */ PrepayFlowFundingActivity f23588c;

            protected final void m25560a(Object obj) {
                this.f23588c.m25594a(u, (String) obj, currencyAmount);
            }
        });
    }

    @Nullable
    private ListenableFuture<String> m25575b(PaymentMethod paymentMethod) {
        if (this.f23595G) {
            return this.f23606s.b(new ParcelablePair((CreditCard) paymentMethod, this.f23597I.mo1091c().getText().toString()));
        }
        return Futures.a(paymentMethod instanceof CvvPrepayCreditCard ? ((CvvPrepayCreditCard) paymentMethod).f23681a : null);
    }

    @VisibleForTesting
    final void m25594a(PaymentMethod paymentMethod, @Nullable String str, CurrencyAmount currencyAmount) {
        this.f23592D.a(TaskId.CHARGE, this.f23607t.b(Quartet.a(this.f23429A.f3969d, paymentMethod, currencyAmount, str)), new C28397(this));
    }

    private static boolean m25580c(Throwable th) {
        ApiException apiException = (ApiException) ExceptionUtil.a(th, ApiException.class);
        return apiException != null && apiException.b().a() == 2308;
    }

    private PaymentMethod m25590u() {
        ListenableFuture listenableFuture = this.f23594F;
        Preconditions.checkState(listenableFuture.isDone());
        return (PaymentMethod) Futures.a(listenableFuture);
    }

    private FbPaymentCardType m25591v() {
        PaymentMethod paymentMethod = (PaymentMethod) FbFutures.a(this.f23594F);
        return paymentMethod instanceof CreditCard ? ((CreditCard) paymentMethod).f() : FbPaymentCardType.UNKNOWN;
    }

    private void m25581d(boolean z) {
        this.f23598J = a(2131566210);
        InjectorLike injectorLike = this.f23604q;
        this.f23597I = new StandaloneSecurityCodeInputController(m25591v(), SecurityCodeFormattingTextWatcher.a(injectorLike), SecurityCodeInputValidator.m25766a(injectorLike), ResourcesMethodAutoProvider.a(injectorLike), (ExecutorService) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(injectorLike), AdsPaymentsExperimentsHelper.m25609b(injectorLike), PaymentsQeAccessor.m25554a(injectorLike));
        this.f23597I.m25624a(this.f23598J, null, this.f23429A);
        m25596b(z);
        this.f23597I.mo1091c().addTextChangedListener(new C28408(this));
    }

    private void m25570a(TasksManager tasksManager, StandaloneSecurityCodeInputControllerProvider standaloneSecurityCodeInputControllerProvider, PaymentMethodsInfoCache paymentMethodsInfoCache, GetCscTokenMethod getCscTokenMethod, PrepayFundMethod prepayFundMethod) {
        this.f23603p = tasksManager;
        this.f23604q = standaloneSecurityCodeInputControllerProvider;
        this.f23605r = paymentMethodsInfoCache;
        this.f23606s = getCscTokenMethod;
        this.f23607t = prepayFundMethod;
    }

    public static void m25592w(PrepayFlowFundingActivity prepayFlowFundingActivity) {
        Object obj = 1;
        Object obj2 = FbFutures.a(prepayFlowFundingActivity.f23594F) == null ? 1 : null;
        Object obj3;
        if (!prepayFlowFundingActivity.f23595G || prepayFlowFundingActivity.f23597I.mo1089a()) {
            obj3 = null;
        } else {
            obj3 = 1;
        }
        if (!(prepayFlowFundingActivity.f23596H && r3 == null && obj2 == null)) {
            obj = null;
        }
        prepayFlowFundingActivity.m25357a(prepayFlowFundingActivity.getString(2131240169), obj != null ? prepayFlowFundingActivity.f23602N : null);
    }

    public final void m25596b(boolean z) {
        this.f23595G = z;
        m25592w(this);
        PaymentUiUtil.m25553a(this.f23598J, z);
    }

    public void onDestroy() {
        int a = Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_START, 793158614);
        super.onDestroy();
        if (this.f23592D != null) {
            this.f23592D.c();
        }
        Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_END, -391273479, a);
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        if (i == 0 && i2 == -1) {
            m25578c(PickerScreenActivity.m18783b(intent));
        }
        super.onActivityResult(i, i2, intent);
    }

    private void m25578c(PaymentMethod paymentMethod) {
        this.f23592D.c(TaskId.GET_DEFAULT_PAYMENT_METHOD);
        this.f23594F = Futures.a(paymentMethod);
        m25569a(paymentMethod);
    }
}
