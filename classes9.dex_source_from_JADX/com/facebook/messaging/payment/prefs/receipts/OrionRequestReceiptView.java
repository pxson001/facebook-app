package com.facebook.messaging.payment.prefs.receipts;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.executors.ForUiThread;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.fbservice.ops.DialogBasedProgressIndicator;
import com.facebook.fbservice.ops.ErrorPropagation;
import com.facebook.fbservice.ops.OperationResultFutureCallback;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.fbservice.service.ServiceException;
import com.facebook.graphql.enums.GraphQLPeerToPeerPaymentRequestStatus;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectorLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.messaging.payment.analytics.P2pPaymentsLogEvent;
import com.facebook.messaging.payment.connectivity.PaymentConnectivityDialogFactory;
import com.facebook.messaging.payment.model.PaymentUser;
import com.facebook.messaging.payment.model.graphql.PaymentGraphQLInterfaces.PaymentRequest;
import com.facebook.messaging.payment.model.graphql.PaymentGraphQLModels.PaymentRequestModel;
import com.facebook.messaging.payment.prefs.receipts.body.ReceiptAmountViewController;
import com.facebook.messaging.payment.prefs.receipts.footer.ReceiptFooterInfoView;
import com.facebook.messaging.payment.prefs.receipts.footer.ReceiptFooterInfoViewController;
import com.facebook.messaging.payment.prefs.receipts.footer.ReceiptMemoViewController;
import com.facebook.messaging.payment.prefs.receipts.header.ReceiptHeaderView;
import com.facebook.messaging.payment.prefs.receipts.header.ReceiptHeaderViewParams;
import com.facebook.messaging.payment.prefs.receipts.header.ReceiptHeaderViewParamsBuilder;
import com.facebook.messaging.payment.protocol.PaymentProtocolUtil;
import com.facebook.messaging.payment.service.model.request.CancelPaymentRequestParams;
import com.facebook.messaging.payment.ui.DollarIconEditText;
import com.facebook.messaging.payment.util.PaymentRequestUtil;
import com.facebook.messaging.payment.utils.PaymentViewUtil;
import com.facebook.payments.ui.FloatingLabelTextView;
import com.facebook.resources.ui.FbTextView;
import com.facebook.tools.dextr.runtime.detour.BlueServiceOperationFactoryDetour;
import com.facebook.widget.CustomLinearLayout;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: grid_view_scroll_position */
public class OrionRequestReceiptView extends CustomLinearLayout implements ReceiptView<PaymentRequest> {
    private static final Class<?> f13948j = OrionRequestReceiptView.class;
    @Inject
    public Context f13949a;
    @Inject
    PaymentRequestUtil f13950b;
    @Inject
    public PaymentViewUtil f13951c;
    @Inject
    public ReceiptAmountViewController f13952d;
    @Inject
    public ReceiptFooterInfoViewController f13953e;
    @Inject
    public ReceiptMemoViewController f13954f;
    @Inject
    PaymentProtocolUtil f13955g;
    @Inject
    @ForUiThread
    Executor f13956h;
    @Inject
    AnalyticsLogger f13957i;
    public ReceiptHeaderView f13958k;
    public DollarIconEditText f13959l;
    public FbTextView f13960m;
    public FbTextView f13961n;
    public FloatingLabelTextView f13962o;
    public FloatingLabelTextView f13963p;
    private FloatingLabelTextView f13964q;
    public ReceiptFooterInfoView f13965r;
    private ListenableFuture<OperationResult> f13966s;

    /* compiled from: grid_view_scroll_position */
    class C15872 extends OperationResultFutureCallback {
        final /* synthetic */ OrionRequestReceiptView f13946a;

        C15872(OrionRequestReceiptView orionRequestReceiptView) {
            this.f13946a = orionRequestReceiptView;
        }

        protected final void m14465a(ServiceException serviceException) {
            PaymentConnectivityDialogFactory.a(this.f13946a.f13949a, serviceException);
        }
    }

    /* compiled from: grid_view_scroll_position */
    public /* synthetic */ class C15883 {
        public static final /* synthetic */ int[] f13947a = new int[GraphQLPeerToPeerPaymentRequestStatus.values().length];

        static {
            try {
                f13947a[GraphQLPeerToPeerPaymentRequestStatus.DECLINED.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f13947a[GraphQLPeerToPeerPaymentRequestStatus.CANCELED.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f13947a[GraphQLPeerToPeerPaymentRequestStatus.INITED.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f13947a[GraphQLPeerToPeerPaymentRequestStatus.TRANSFER_INITED.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f13947a[GraphQLPeerToPeerPaymentRequestStatus.TRANSFER_FAILED.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                f13947a[GraphQLPeerToPeerPaymentRequestStatus.TRANSFER_COMPLETED.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
        }
    }

    private static <T extends View> void m14470a(Class<T> cls, T t) {
        m14471a((Object) t, t.getContext());
    }

    private static void m14471a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((OrionRequestReceiptView) obj).m14467a((Context) injectorLike.getInstance(Context.class), PaymentRequestUtil.a(injectorLike), PaymentViewUtil.m15542b(injectorLike), ReceiptAmountViewController.m14529a(injectorLike), ReceiptFooterInfoViewController.m14565a(injectorLike), ReceiptMemoViewController.m14579a(injectorLike), PaymentProtocolUtil.m14937a(injectorLike), (Executor) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(injectorLike), AnalyticsLoggerMethodAutoProvider.a(injectorLike));
    }

    public final void mo553a(Object obj, ReceiptFragment receiptFragment) {
        m14468a((PaymentRequestModel) obj);
    }

    public final /* synthetic */ void mo554b(Object obj, ReceiptFragment receiptFragment) {
        m14468a((PaymentRequestModel) obj);
    }

    private void m14467a(Context context, PaymentRequestUtil paymentRequestUtil, PaymentViewUtil paymentViewUtil, ReceiptAmountViewController receiptAmountViewController, ReceiptFooterInfoViewController receiptFooterInfoViewController, ReceiptMemoViewController receiptMemoViewController, PaymentProtocolUtil paymentProtocolUtil, Executor executor, AnalyticsLogger analyticsLogger) {
        this.f13949a = context;
        this.f13950b = paymentRequestUtil;
        this.f13951c = paymentViewUtil;
        this.f13952d = receiptAmountViewController;
        this.f13953e = receiptFooterInfoViewController;
        this.f13954f = receiptMemoViewController;
        this.f13955g = paymentProtocolUtil;
        this.f13956h = executor;
        this.f13957i = analyticsLogger;
    }

    public OrionRequestReceiptView(Context context) {
        super(context);
        m14473b();
    }

    public OrionRequestReceiptView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        m14473b();
    }

    protected OrionRequestReceiptView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m14473b();
    }

    private void m14473b() {
        m14470a(OrionRequestReceiptView.class, (View) this);
        setContentView(2130905936);
        this.f13958k = (ReceiptHeaderView) a(2131563922);
        this.f13959l = (DollarIconEditText) a(2131563921);
        this.f13960m = (FbTextView) a(2131565287);
        this.f13961n = (FbTextView) a(2131565286);
        this.f13962o = (FloatingLabelTextView) a(2131565285);
        this.f13963p = (FloatingLabelTextView) a(2131565033);
        this.f13964q = (FloatingLabelTextView) a(2131563919);
        this.f13965r = (ReceiptFooterInfoView) a(2131563920);
    }

    public final void mo551a() {
        if (this.f13966s != null) {
            this.f13966s.cancel(true);
            this.f13966s = null;
        }
    }

    public final void mo552a(int i, int i2, Intent intent) {
    }

    private void m14468a(final PaymentRequestModel paymentRequestModel) {
        int i;
        boolean e = this.f13950b.e(paymentRequestModel);
        PaymentUser a = PaymentRequestUtil.a(e ? paymentRequestModel.m13815j() : paymentRequestModel.m13816k());
        ReceiptHeaderView receiptHeaderView = this.f13958k;
        ReceiptHeaderViewParamsBuilder newBuilder = ReceiptHeaderViewParams.newBuilder();
        newBuilder.f14152a = a;
        newBuilder = newBuilder;
        newBuilder.f14153b = a.mo527c();
        newBuilder = newBuilder;
        Context context = this.f13949a;
        if (e) {
            i = 2131240333;
        } else {
            i = 2131240335;
        }
        newBuilder.f14154c = context.getString(i);
        ReceiptHeaderViewParamsBuilder receiptHeaderViewParamsBuilder = newBuilder;
        receiptHeaderViewParamsBuilder.f14155d = true;
        receiptHeaderView.setReceiptHeaderViewParams(receiptHeaderViewParamsBuilder.m14627e());
        this.f13952d.f14039e = this.f13959l;
        this.f13952d.m14534a((Object) paymentRequestModel);
        i = 8;
        if (e) {
            this.f13960m.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ OrionRequestReceiptView f13945b;

                public void onClick(View view) {
                    int a = Logger.a(2, EntryType.UI_INPUT_START, -1628648467);
                    OrionRequestReceiptView.m14475g(this.f13945b, paymentRequestModel);
                    Logger.a(2, EntryType.UI_INPUT_END, -268857354, a);
                }
            });
            FbTextView fbTextView = this.f13960m;
            if (!PaymentRequestUtil.b(paymentRequestModel)) {
                i = 0;
            }
            fbTextView.setVisibility(i);
        } else {
            this.f13960m.setVisibility(8);
        }
        this.f13961n.setVisibility(0);
        switch (C15883.f13947a[paymentRequestModel.lx_().ordinal()]) {
            case 1:
                this.f13961n.setText(e ? this.f13949a.getString(2131240571, new Object[]{paymentRequestModel.m13815j().lE_()}) : this.f13949a.getString(2131240572));
                break;
            case 2:
                this.f13961n.setText(e ? this.f13949a.getString(2131240573) : this.f13949a.getString(2131240574, new Object[]{paymentRequestModel.m13816k().lE_()}));
                break;
            case 3:
            case 4:
            case 5:
                this.f13961n.setText(this.f13949a.getString(2131240331));
                break;
            default:
                this.f13961n.setVisibility(8);
                break;
        }
        this.f13954f.f14107b = this.f13962o;
        this.f13954f.m14581a((Object) paymentRequestModel);
        this.f13963p.setVisibility(0);
        long m = 1000 * paymentRequestModel.m13818m();
        switch (C15883.f13947a[paymentRequestModel.lx_().ordinal()]) {
            case 1:
                this.f13951c.m15544a(this.f13963p, 2131240517, 2131240522, m);
                break;
            case 2:
            case 5:
                this.f13951c.m15544a(this.f13963p, 2131240517, 2131240521, m);
                break;
            case 3:
            case 4:
                this.f13963p.setHint(2131240517);
                this.f13963p.setText(2131240331);
                break;
            case 6:
                this.f13951c.m15544a(this.f13963p, 2131240517, 2131240523, m);
                break;
            default:
                this.f13963p.setVisibility(8);
                break;
        }
        m14474e(paymentRequestModel);
        this.f13953e.f14090a = this.f13965r;
        this.f13953e.m14568a((Object) paymentRequestModel);
    }

    private void m14474e(PaymentRequestModel paymentRequestModel) {
        this.f13951c.m15545a(this.f13964q, 2131240344, 1000 * paymentRequestModel.m13812c());
    }

    public static void m14475g(OrionRequestReceiptView orionRequestReceiptView, PaymentRequestModel paymentRequestModel) {
        if (m14472a(orionRequestReceiptView.f13966s)) {
            PaymentProtocolUtil paymentProtocolUtil = orionRequestReceiptView.f13955g;
            Context context = orionRequestReceiptView.f13949a;
            String lw_ = paymentRequestModel.lw_();
            String string = orionRequestReceiptView.f13949a.getString(2131240564);
            Bundle bundle = new Bundle();
            bundle.putParcelable(CancelPaymentRequestParams.f14704a, new CancelPaymentRequestParams(lw_));
            orionRequestReceiptView.f13966s = BlueServiceOperationFactoryDetour.a(paymentProtocolUtil.f14533a, "cancel_payment_request", bundle, ErrorPropagation.BY_ERROR_CODE, CallerContext.a(paymentProtocolUtil.getClass()), 498045791).a(new DialogBasedProgressIndicator(context, string)).a();
            Futures.a(orionRequestReceiptView.f13966s, new C15872(orionRequestReceiptView), orionRequestReceiptView.f13956h);
            orionRequestReceiptView.f13957i.a(P2pPaymentsLogEvent.d("p2p_cancel_request", "p2p_request").f(paymentRequestModel.lw_()).o(paymentRequestModel.m13815j().m13879c()).a);
        }
    }

    private static boolean m14472a(ListenableFuture listenableFuture) {
        return listenableFuture == null || listenableFuture.isDone();
    }
}
