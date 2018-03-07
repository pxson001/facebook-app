package com.facebook.orca.threadview;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.base.broadcast.BaseFbBroadcastManager;
import com.facebook.base.broadcast.BaseFbBroadcastManager.SelfRegistrableReceiverImpl;
import com.facebook.base.broadcast.FbBroadcastManager;
import com.facebook.base.broadcast.LocalFbBroadcastManager;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.common.util.StringUtil;
import com.facebook.content.ActionReceiver;
import com.facebook.content.BroadcastReceiverLike;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.fbservice.ops.ResultFutureCallback;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.fbservice.service.ServiceException;
import com.facebook.graphql.calls.CreateP2pPlatformContextInputData;
import com.facebook.graphql.enums.GraphQLPeerToPeerPaymentRequestStatus;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.messaging.model.messages.Message;
import com.facebook.messaging.model.messages.MessagesCollection;
import com.facebook.messaging.payment.abtest.ExperimentsForPaymentAbTestModule;
import com.facebook.messaging.payment.analytics.P2pPaymentsLogEvent;
import com.facebook.messaging.payment.analytics.P2pPaymentsLogEvent.Builder;
import com.facebook.messaging.payment.analytics.PaymentFlowType;
import com.facebook.messaging.payment.awareness.GroupCommerceAwarenessNuxController;
import com.facebook.messaging.payment.awareness.PaymentAwarenessActivity;
import com.facebook.messaging.payment.awareness.PaymentAwarenessMode;
import com.facebook.messaging.payment.awareness.PaymentAwarenessPrefKeys;
import com.facebook.messaging.payment.currency.CurrencyFormatType;
import com.facebook.messaging.payment.currency.PaymentCurrencyUtil;
import com.facebook.messaging.payment.dialog.PaymentDialogsBuilder;
import com.facebook.messaging.payment.method.verification.PaymentMethodVerificationController;
import com.facebook.messaging.payment.method.verification.PaymentMethodVerificationController.ResultCallback;
import com.facebook.messaging.payment.method.verification.PaymentMethodVerificationNuxDialogsHelper;
import com.facebook.messaging.payment.method.verification.PaymentMethodVerificationParams;
import com.facebook.messaging.payment.model.Amount;
import com.facebook.messaging.payment.model.MessengerPayEntityType;
import com.facebook.messaging.payment.model.PaymentCard;
import com.facebook.messaging.payment.model.PaymentTransaction;
import com.facebook.messaging.payment.model.VerificationFollowUpAction;
import com.facebook.messaging.payment.model.graphql.PaymentGraphQLModels.PaymentPlatformContextModel;
import com.facebook.messaging.payment.model.graphql.PaymentGraphQLModels.PaymentRequestModel;
import com.facebook.messaging.payment.model.graphql.PaymentMutations.CreateP2pPlatformContextCoreMutationString;
import com.facebook.messaging.payment.prefs.PaymentsPreferenceActivity;
import com.facebook.messaging.payment.prefs.receipts.PaymentReceiptActivity;
import com.facebook.messaging.payment.prefs.receipts.PaymentReceiptActivity.AnalyticsSource;
import com.facebook.messaging.payment.prefs.receipts.ThemeFullScreenCardActivity;
import com.facebook.messaging.payment.protocol.PaymentProtocolUtil;
import com.facebook.messaging.payment.protocol.PaymentProtocolUtil.14;
import com.facebook.messaging.payment.thread.model.ThreadPaymentTransactionData;
import com.facebook.messaging.payment.util.PaymentRequestUtil;
import com.facebook.messaging.payment.util.PaymentTransactionUtil;
import com.facebook.messaging.payment.value.input.EnterPaymentValueActivity;
import com.facebook.messaging.payment.value.input.OrionRequestAckMessengerPayLogger;
import com.facebook.messaging.threadview.rows.RowMessageItem;
import com.facebook.qe.api.Liveness;
import com.facebook.user.model.User;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.MoreExecutors;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: menu_management */
public class ThreadViewMessagesFragmentPaymentsHelper {
    public final Context f7884a;
    private final SecureContextHelper f7885b;
    public final AbstractFbErrorReporter f7886c;
    private final AnalyticsLogger f7887d;
    private final BaseFbBroadcastManager f7888e;
    public final Lazy<PaymentProtocolUtil> f7889f;
    private final Lazy<PaymentMethodVerificationController> f7890g;
    private final Lazy<ThreadPaymentRiskFlowHelper> f7891h;
    public final Lazy<PaymentMethodVerificationNuxDialogsHelper> f7892i;
    public final Executor f7893j;
    private final PaymentRequestUtil f7894k;
    public final Provider<User> f7895l;
    private final PaymentCurrencyUtil f7896m;
    private final GroupCommerceAwarenessNuxController f7897n;
    public final OrionRequestAckMessengerPayLogger f7898o;
    public ListenableFuture<OperationResult> f7899p;
    private final SelfRegistrableReceiverImpl f7900q;
    private String f7901r;
    public Listener f7902s;

    /* compiled from: menu_management */
    interface Listener {
        void mo328a();

        void mo329a(String str, PaymentFlowType paymentFlowType, @Nullable PaymentPlatformContextModel paymentPlatformContextModel);

        void mo330b(String str, PaymentFlowType paymentFlowType, @Nullable PaymentPlatformContextModel paymentPlatformContextModel);
    }

    /* compiled from: menu_management */
    class C11901 implements ActionReceiver {
        final /* synthetic */ ThreadViewMessagesFragmentPaymentsHelper f7873a;

        C11901(ThreadViewMessagesFragmentPaymentsHelper threadViewMessagesFragmentPaymentsHelper) {
            this.f7873a = threadViewMessagesFragmentPaymentsHelper;
        }

        public void onReceive(Context context, Intent intent, BroadcastReceiverLike broadcastReceiverLike) {
            int a = Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_START, -1522005646);
            this.f7873a.f7902s.mo328a();
            Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_END, 300004066, a);
        }
    }

    /* compiled from: menu_management */
    class C11912 implements ResultCallback {
        final /* synthetic */ ThreadViewMessagesFragmentPaymentsHelper f7874a;

        C11912(ThreadViewMessagesFragmentPaymentsHelper threadViewMessagesFragmentPaymentsHelper) {
            this.f7874a = threadViewMessagesFragmentPaymentsHelper;
        }

        public final void m7825a() {
            this.f7874a.f7886c.b("payment_card_verification", "A card already verified event received when accepting NUX payment.");
        }

        public final void m7826a(PaymentCard paymentCard, @Nullable VerificationFollowUpAction verificationFollowUpAction, boolean z, boolean z2) {
            ((PaymentMethodVerificationNuxDialogsHelper) this.f7874a.f7892i.get()).a(z, z2, verificationFollowUpAction);
        }

        public final void m7827b() {
        }

        public final void m7828c() {
        }
    }

    /* compiled from: menu_management */
    class C11934 implements OnClickListener {
        final /* synthetic */ ThreadViewMessagesFragmentPaymentsHelper f7877a;

        C11934(ThreadViewMessagesFragmentPaymentsHelper threadViewMessagesFragmentPaymentsHelper) {
            this.f7877a = threadViewMessagesFragmentPaymentsHelper;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.dismiss();
        }
    }

    /* compiled from: menu_management */
    public class C11945 implements OnClickListener {
        final /* synthetic */ PaymentRequestModel f7878a;
        final /* synthetic */ ThreadViewMessagesFragmentPaymentsHelper f7879b;

        public C11945(ThreadViewMessagesFragmentPaymentsHelper threadViewMessagesFragmentPaymentsHelper, PaymentRequestModel paymentRequestModel) {
            this.f7879b = threadViewMessagesFragmentPaymentsHelper;
            this.f7878a = paymentRequestModel;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            if (!(this.f7879b.f7899p == null || this.f7879b.f7899p.isDone())) {
                this.f7879b.f7899p.cancel(true);
            }
            dialogInterface.dismiss();
            ThreadViewMessagesFragmentPaymentsHelper threadViewMessagesFragmentPaymentsHelper = this.f7879b;
            PaymentRequestModel paymentRequestModel = this.f7878a;
            threadViewMessagesFragmentPaymentsHelper.f7898o.a("p2p_confirm_decline", paymentRequestModel);
            threadViewMessagesFragmentPaymentsHelper.f7899p = ((PaymentProtocolUtil) threadViewMessagesFragmentPaymentsHelper.f7889f.get()).a(threadViewMessagesFragmentPaymentsHelper.f7884a, String.valueOf(paymentRequestModel.lw_()), threadViewMessagesFragmentPaymentsHelper.f7884a.getResources().getString(2131240563));
            Futures.a(threadViewMessagesFragmentPaymentsHelper.f7899p, new C11967(threadViewMessagesFragmentPaymentsHelper, paymentRequestModel), threadViewMessagesFragmentPaymentsHelper.f7893j);
        }
    }

    /* compiled from: menu_management */
    public class C11956 implements OnClickListener {
        final /* synthetic */ ThreadViewMessagesFragmentPaymentsHelper f7880a;

        public C11956(ThreadViewMessagesFragmentPaymentsHelper threadViewMessagesFragmentPaymentsHelper) {
            this.f7880a = threadViewMessagesFragmentPaymentsHelper;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.dismiss();
        }
    }

    /* compiled from: menu_management */
    public class C11967 extends ResultFutureCallback<OperationResult> {
        final /* synthetic */ PaymentRequestModel f7881a;
        final /* synthetic */ ThreadViewMessagesFragmentPaymentsHelper f7882b;

        public C11967(ThreadViewMessagesFragmentPaymentsHelper threadViewMessagesFragmentPaymentsHelper, PaymentRequestModel paymentRequestModel) {
            this.f7882b = threadViewMessagesFragmentPaymentsHelper;
            this.f7881a = paymentRequestModel;
        }

        public final void m7829a(ServiceException serviceException) {
            this.f7882b.f7898o.a("p2p_decline_fail", this.f7881a);
            this.f7882b.f7886c.a("ThreadViewMessagesFragmentPaymentsHelper", "Failed to decline the request with id: " + this.f7881a.lw_());
        }

        public final void m7830a(Object obj) {
            this.f7882b.f7898o.a("p2p_decline_success", this.f7881a);
        }
    }

    /* compiled from: menu_management */
    /* synthetic */ class C11978 {
        static final /* synthetic */ int[] f7883a = new int[GraphQLPeerToPeerPaymentRequestStatus.values().length];

        static {
            try {
                f7883a[GraphQLPeerToPeerPaymentRequestStatus.INITED.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f7883a[GraphQLPeerToPeerPaymentRequestStatus.TRANSFER_FAILED.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f7883a[GraphQLPeerToPeerPaymentRequestStatus.DECLINED.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f7883a[GraphQLPeerToPeerPaymentRequestStatus.TRANSFER_INITED.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f7883a[GraphQLPeerToPeerPaymentRequestStatus.TRANSFER_COMPLETED.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                f7883a[GraphQLPeerToPeerPaymentRequestStatus.CANCELED.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
        }
    }

    private static ThreadViewMessagesFragmentPaymentsHelper m7836b(InjectorLike injectorLike) {
        return new ThreadViewMessagesFragmentPaymentsHelper((Context) injectorLike.getInstance(Context.class), (SecureContextHelper) DefaultSecureContextHelper.a(injectorLike), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike), AnalyticsLoggerMethodAutoProvider.a(injectorLike), (BaseFbBroadcastManager) LocalFbBroadcastManager.a(injectorLike), IdBasedSingletonScopeProvider.b(injectorLike, 8114), IdBasedLazy.a(injectorLike, 8061), IdBasedLazy.a(injectorLike, 8859), IdBasedLazy.a(injectorLike, 8062), (Executor) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(injectorLike), PaymentRequestUtil.a(injectorLike), IdBasedProvider.a(injectorLike, 3596), PaymentCurrencyUtil.a(injectorLike), GroupCommerceAwarenessNuxController.a(injectorLike), OrionRequestAckMessengerPayLogger.a(injectorLike));
    }

    public static ThreadViewMessagesFragmentPaymentsHelper m7832a(InjectorLike injectorLike) {
        return m7836b(injectorLike);
    }

    @Inject
    public ThreadViewMessagesFragmentPaymentsHelper(Context context, SecureContextHelper secureContextHelper, FbErrorReporter fbErrorReporter, AnalyticsLogger analyticsLogger, FbBroadcastManager fbBroadcastManager, Lazy<PaymentProtocolUtil> lazy, Lazy<PaymentMethodVerificationController> lazy2, Lazy<ThreadPaymentRiskFlowHelper> lazy3, Lazy<PaymentMethodVerificationNuxDialogsHelper> lazy4, Executor executor, PaymentRequestUtil paymentRequestUtil, Provider<User> provider, PaymentCurrencyUtil paymentCurrencyUtil, GroupCommerceAwarenessNuxController groupCommerceAwarenessNuxController, OrionRequestAckMessengerPayLogger orionRequestAckMessengerPayLogger) {
        this.f7884a = context;
        this.f7885b = secureContextHelper;
        this.f7886c = fbErrorReporter;
        this.f7887d = analyticsLogger;
        this.f7888e = fbBroadcastManager;
        this.f7889f = lazy;
        this.f7890g = lazy2;
        this.f7891h = lazy3;
        this.f7892i = lazy4;
        this.f7893j = executor;
        this.f7894k = paymentRequestUtil;
        this.f7895l = provider;
        this.f7896m = paymentCurrencyUtil;
        this.f7897n = groupCommerceAwarenessNuxController;
        this.f7898o = orionRequestAckMessengerPayLogger;
        C11901 c11901 = new C11901(this);
        this.f7900q = this.f7888e.a().a("com.facebook.messaging.payment.ACTION_PAYMENT_TRANSACTION_CACHE_UPDATED", c11901).a("com.facebook.messaging.payment.ACTION_PAYMENT_REQUEST_CACHE_UPDATED", c11901).a("com.facebook.messaging.payment.ACTION_PAYMENT_CARD_CACHE_UPDATED", c11901).a();
    }

    public final void m7850a(Listener listener) {
        this.f7902s = listener;
    }

    public final void m7844a() {
        this.f7900q.b();
    }

    public final void m7854b() {
        this.f7900q.c();
        if (this.f7899p != null) {
            this.f7899p.cancel(true);
            this.f7899p = null;
        }
    }

    public final void m7851a(ThreadViewMessagesInitParams threadViewMessagesInitParams) {
        this.f7901r = threadViewMessagesInitParams.f7905b;
        m7843f();
    }

    public final void m7857c() {
        if (!StringUtil.a(this.f7901r)) {
            PaymentProtocolUtil paymentProtocolUtil = (PaymentProtocolUtil) this.f7889f.get();
            String str = this.f7901r;
            GraphQlQueryString createP2pPlatformContextCoreMutationString = new CreateP2pPlatformContextCoreMutationString();
            CreateP2pPlatformContextInputData createP2pPlatformContextInputData = new CreateP2pPlatformContextInputData();
            createP2pPlatformContextInputData.a("group_commerce_product_item_id", str);
            createP2pPlatformContextCoreMutationString.a("input", createP2pPlatformContextInputData);
            ListenableFuture a = Futures.a(paymentProtocolUtil.c.a(GraphQLRequest.a(createP2pPlatformContextCoreMutationString)), new 14(paymentProtocolUtil), MoreExecutors.a());
            AnalyticsLogger analyticsLogger = this.f7887d;
            Builder d = P2pPaymentsLogEvent.d("p2p_c2c_platform_context_created", "p2p_group_commerce_send");
            d.a.b("group_commerce_sell_options_id", this.f7901r);
            analyticsLogger.a(d.a);
            this.f7901r = null;
        }
    }

    public final void m7858d() {
        this.f7901r = null;
    }

    public final void m7845a(int i, int i2, Intent intent) {
        ((PaymentMethodVerificationController) this.f7890g.get()).a(i, i2, intent);
    }

    public final void m7855b(int i, int i2, Intent intent) {
        ((PaymentMethodVerificationController) this.f7890g.get()).a(i, i2, intent);
    }

    public final void m7846a(Intent intent) {
        if (intent != null) {
            ((PaymentMethodVerificationNuxDialogsHelper) this.f7892i.get()).b(intent.getBooleanExtra("show_pin_nux", false), intent.getBooleanExtra("show_card_added_nux", false));
        }
    }

    public final void m7849a(RowMessageItem rowMessageItem) {
        m7856b(rowMessageItem);
    }

    public final void m7856b(RowMessageItem rowMessageItem) {
        Message message = rowMessageItem.f4732a;
        if (m7834a(rowMessageItem.f4743l)) {
            PaymentTransaction paymentTransaction = rowMessageItem.f4743l.c;
            this.f7885b.a(ThemeFullScreenCardActivity.a(this.f7884a, Long.parseLong(paymentTransaction.b), MessengerPayEntityType.PAYMENT_TRANSACTION, paymentTransaction.l.b(), paymentTransaction.j), this.f7884a);
        } else if (PaymentRequestUtil.f(rowMessageItem.f4744m)) {
            PaymentRequestModel paymentRequestModel = rowMessageItem.f4744m;
            this.f7885b.a(ThemeFullScreenCardActivity.a(this.f7884a, Long.parseLong(paymentRequestModel.lw_()), MessengerPayEntityType.PAYMENT_REQUEST, paymentRequestModel.ly_(), new Amount(paymentRequestModel.b().b(), paymentRequestModel.b().c(), paymentRequestModel.b().a())), this.f7884a);
        } else if (message.B != null) {
            this.f7885b.a(PaymentReceiptActivity.a(this.f7884a, message.B.a, AnalyticsSource.THREAD), this.f7884a);
        } else if (rowMessageItem.f4744m != null) {
            PaymentRequestModel paymentRequestModel2 = rowMessageItem.f4744m;
            Intent intent = null;
            if (this.f7894k.d(paymentRequestModel2)) {
                switch (C11978.f7883a[paymentRequestModel2.lx_().ordinal()]) {
                    case 1:
                    case 2:
                        intent = EnterPaymentValueActivity.b(this.f7884a, String.valueOf(paymentRequestModel2.lw_()));
                        break;
                    case 3:
                    case 4:
                    case 5:
                    case 6:
                        intent = PaymentReceiptActivity.b(this.f7884a, String.valueOf(paymentRequestModel2.lw_()), AnalyticsSource.THREAD);
                        break;
                }
            }
            intent = PaymentReceiptActivity.b(this.f7884a, String.valueOf(paymentRequestModel2.lw_()), AnalyticsSource.THREAD);
            if (intent != null) {
                this.f7885b.a(intent, this.f7884a);
            }
        }
    }

    public final void m7852a(ImmutableList<PaymentCard> immutableList, ThreadViewMessagesFragment threadViewMessagesFragment, String str, String str2) {
        C11912 c11912 = new C11912(this);
        PaymentMethodVerificationParams.Builder newBuilder = PaymentMethodVerificationParams.newBuilder();
        newBuilder.b = immutableList;
        newBuilder = newBuilder;
        newBuilder.e = PaymentFlowType.NUX;
        newBuilder = newBuilder;
        newBuilder.c = threadViewMessagesFragment;
        newBuilder = newBuilder;
        newBuilder.f = str;
        newBuilder = newBuilder;
        newBuilder.g = str2;
        ((PaymentMethodVerificationController) this.f7890g.get()).a(newBuilder.a(), c11912);
    }

    public final void m7859e() {
        this.f7885b.a(new Intent(this.f7884a, PaymentsPreferenceActivity.class), this.f7884a);
    }

    public final void m7853a(String str, String str2) {
        ThreadPaymentRiskFlowHelper threadPaymentRiskFlowHelper = (ThreadPaymentRiskFlowHelper) this.f7891h.get();
        threadPaymentRiskFlowHelper.f7433b.a(str, str2, this.f7884a);
    }

    public final void m7847a(@Nullable MessagesCollection messagesCollection, PaymentPlatformContextModel paymentPlatformContextModel) {
        Preconditions.checkNotNull(paymentPlatformContextModel.g());
        if (messagesCollection != null) {
            Object obj;
            if (this.f7895l.get() == null) {
                obj = 1;
            } else {
                Message message;
                ImmutableList immutableList = messagesCollection.b;
                int size = immutableList.size();
                for (int i = 0; i < size; i++) {
                    message = (Message) immutableList.get(i);
                    if (!((User) this.f7895l.get()).a.equals(message.e.b.b())) {
                        break;
                    }
                }
                message = null;
                if (message == null || message.c < paymentPlatformContextModel.c() * 1000) {
                    obj = null;
                } else {
                    int i2 = 1;
                }
            }
            if (obj != null) {
                m7839c(this, paymentPlatformContextModel);
                return;
            }
        }
        m7837b(paymentPlatformContextModel);
    }

    private void m7837b(final PaymentPlatformContextModel paymentPlatformContextModel) {
        PaymentDialogsBuilder.a(this.f7884a, this.f7884a.getString(2131240543), this.f7884a.getString(2131240544), this.f7884a.getString(2131240545), new OnClickListener(this) {
            final /* synthetic */ ThreadViewMessagesFragmentPaymentsHelper f7876b;

            public void onClick(DialogInterface dialogInterface, int i) {
                ThreadViewMessagesFragmentPaymentsHelper.m7839c(this.f7876b, paymentPlatformContextModel);
            }
        }, this.f7884a.getString(2131240546), new C11934(this)).show();
    }

    public static void m7839c(ThreadViewMessagesFragmentPaymentsHelper threadViewMessagesFragmentPaymentsHelper, PaymentPlatformContextModel paymentPlatformContextModel) {
        threadViewMessagesFragmentPaymentsHelper.f7902s.mo329a(threadViewMessagesFragmentPaymentsHelper.m7841d(paymentPlatformContextModel), PaymentFlowType.GROUP_COMMERCE, paymentPlatformContextModel);
    }

    public final void m7848a(PaymentPlatformContextModel paymentPlatformContextModel) {
        this.f7902s.mo330b(m7841d(paymentPlatformContextModel), PaymentFlowType.GROUP_COMMERCE, paymentPlatformContextModel);
    }

    private void m7843f() {
        GroupCommerceAwarenessNuxController groupCommerceAwarenessNuxController = this.f7897n;
        boolean z = this.f7901r == null ? false : (((Boolean) groupCommerceAwarenessNuxController.a.get()).booleanValue() && groupCommerceAwarenessNuxController.b.a(Liveness.Live, ExperimentsForPaymentAbTestModule.a, false)) ? groupCommerceAwarenessNuxController.c.a(PaymentAwarenessPrefKeys.c, 0) < 2 : false;
        if (z) {
            Intent intent = new Intent(this.f7884a, PaymentAwarenessActivity.class);
            intent.putExtra("payment_awareness_mode", PaymentAwarenessMode.GROUP_COMMERCE);
            this.f7885b.a(intent, this.f7884a);
            groupCommerceAwarenessNuxController = this.f7897n;
            groupCommerceAwarenessNuxController.c.edit().a(PaymentAwarenessPrefKeys.c, groupCommerceAwarenessNuxController.c.a(PaymentAwarenessPrefKeys.c, 0) + 1).commit();
        }
    }

    private static boolean m7834a(@Nullable ThreadPaymentTransactionData threadPaymentTransactionData) {
        if (threadPaymentTransactionData == null) {
            return false;
        }
        return PaymentTransactionUtil.e(threadPaymentTransactionData.c);
    }

    private String m7841d(PaymentPlatformContextModel paymentPlatformContextModel) {
        return this.f7896m.a(CurrencyFormatType.NO_CURRENCY_SYMBOL_OR_EMPTY_DECIMALS, paymentPlatformContextModel.g().lu_().a(), paymentPlatformContextModel.g().lu_().b());
    }
}
