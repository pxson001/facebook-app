package com.facebook.messaging.payment.protocol;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.fbservice.ops.BlueServiceOperationFactory.Operation;
import com.facebook.fbservice.ops.DefaultBlueServiceOperationFactory;
import com.facebook.fbservice.ops.DialogBasedProgressIndicator;
import com.facebook.fbservice.ops.ErrorPropagation;
import com.facebook.fbservice.service.DataFreshnessParam;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.graphql.calls.CreateCommerceCartP2pPlatformContextInputData;
import com.facebook.graphql.calls.P2pPlatformContextSetShippingAddressInputData;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.payment.model.PaymentCard;
import com.facebook.messaging.payment.model.PaymentTransaction;
import com.facebook.messaging.payment.model.PaymentTransactionQueryType;
import com.facebook.messaging.payment.model.graphql.PaymentGraphQLInterfaces.MailingAddressInfo;
import com.facebook.messaging.payment.model.graphql.PaymentGraphQLInterfaces.PaymentAccountEnabledStatus;
import com.facebook.messaging.payment.model.graphql.PaymentGraphQLInterfaces.PaymentPlatformContext;
import com.facebook.messaging.payment.model.graphql.PaymentGraphQLInterfaces.PaymentRequest;
import com.facebook.messaging.payment.model.graphql.PaymentGraphQLInterfaces.Theme;
import com.facebook.messaging.payment.model.graphql.PaymentGraphQLModels.PaymentAccountEnabledStatusModel;
import com.facebook.messaging.payment.model.graphql.PaymentGraphQLModels.PaymentPlatformContextModel;
import com.facebook.messaging.payment.model.graphql.PaymentGraphQLModels.PaymentRequestModel;
import com.facebook.messaging.payment.model.graphql.PaymentMutations.CreateCommerceCartP2pPlatformContextCoreMutationString;
import com.facebook.messaging.payment.model.graphql.PaymentMutations.P2pPlatformContextSetShippingAddressMutationString;
import com.facebook.messaging.payment.model.graphql.PaymentMutationsModels.CreateCommerceCartP2pPlatformContextCoreMutationModel;
import com.facebook.messaging.payment.model.graphql.PaymentMutationsModels.P2pPlatformContextSetShippingAddressMutationModel;
import com.facebook.messaging.payment.model.verification.UserInput;
import com.facebook.messaging.payment.service.model.cards.AddPaymentCardParams;
import com.facebook.messaging.payment.service.model.cards.AddPaymentCardResult;
import com.facebook.messaging.payment.service.model.cards.DeletePaymentCardParams;
import com.facebook.messaging.payment.service.model.cards.EditPaymentCardParams;
import com.facebook.messaging.payment.service.model.cards.FetchPaymentCardsResult;
import com.facebook.messaging.payment.service.model.cards.SetPrimaryCardParams;
import com.facebook.messaging.payment.service.model.cards.ValidatePaymentCardBinParams;
import com.facebook.messaging.payment.service.model.cards.ValidatePaymentCardBinResult;
import com.facebook.messaging.payment.service.model.eligibility.FetchP2PSendEligibilityParams;
import com.facebook.messaging.payment.service.model.eligibility.FetchP2PSendEligibilityResult;
import com.facebook.messaging.payment.service.model.moneypenny.MoneyPennyPlaceOrderParams;
import com.facebook.messaging.payment.service.model.moneypenny.MoneyPennyPlaceOrderResult;
import com.facebook.messaging.payment.service.model.pay.SendPaymentParams;
import com.facebook.messaging.payment.service.model.pay.SendPaymentResult;
import com.facebook.messaging.payment.service.model.request.CreatePaymentRequestParams;
import com.facebook.messaging.payment.service.model.request.DeclinePaymentRequestParams;
import com.facebook.messaging.payment.service.model.request.FetchPaymentRequestParams;
import com.facebook.messaging.payment.service.model.request.FetchPaymentRequestsParams;
import com.facebook.messaging.payment.service.model.request.FetchPaymentRequestsParams.QueryType;
import com.facebook.messaging.payment.service.model.request.FetchPaymentRequestsResult;
import com.facebook.messaging.payment.service.model.shipping.AddShippingAddressParams;
import com.facebook.messaging.payment.service.model.shipping.EditShippingAddressParams;
import com.facebook.messaging.payment.service.model.shipping.EditShippingAddressParamsBuilder;
import com.facebook.messaging.payment.service.model.transactions.FetchMoreTransactionsParams;
import com.facebook.messaging.payment.service.model.transactions.FetchMoreTransactionsResult;
import com.facebook.messaging.payment.service.model.transactions.FetchPaymentTransactionParams;
import com.facebook.messaging.payment.service.model.transactions.FetchTransactionListParams;
import com.facebook.messaging.payment.service.model.transactions.FetchTransactionListResult;
import com.facebook.messaging.payment.service.model.transactions.FetchTransactionPaymentCardParams;
import com.facebook.messaging.payment.service.model.transactions.MutatePaymentPlatformContextParams;
import com.facebook.messaging.payment.service.model.transactions.MutatePaymentPlatformContextParams.Mutation;
import com.facebook.messaging.payment.service.model.transactions.SendPaymentMessageParams;
import com.facebook.messaging.payment.service.model.transactions.SendPaymentMessageResult;
import com.facebook.messaging.payment.service.model.verification.VerifyPaymentParams;
import com.facebook.messaging.payment.service.model.verification.VerifyPaymentResult;
import com.facebook.payments.shipping.model.ShippingAddressFormInput;
import com.facebook.tools.dextr.runtime.detour.BlueServiceOperationFactoryDetour;
import com.google.common.base.Function;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.common.util.concurrent.MoreExecutors.DirectExecutor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: fragment_params */
public class PaymentProtocolUtil {
    private static volatile PaymentProtocolUtil f14532g;
    public final DefaultBlueServiceOperationFactory f14533a;
    public final DefaultAndroidThreadUtil f14534b;
    public final GraphQLQueryExecutor f14535c;
    private final Executor f14536d;
    public final HashMap<String, ListenableFuture> f14537e = new HashMap();
    private ListenableFuture<FetchPaymentCardsResult> f14538f;

    /* compiled from: fragment_params */
    class C16561 implements Function<OperationResult, FetchPaymentCardsResult> {
        final /* synthetic */ PaymentProtocolUtil f14513a;

        C16561(PaymentProtocolUtil paymentProtocolUtil) {
            this.f14513a = paymentProtocolUtil;
        }

        public Object apply(Object obj) {
            return (FetchPaymentCardsResult) ((OperationResult) obj).h();
        }
    }

    /* compiled from: fragment_params */
    class C16572 implements Function<OperationResult, FetchP2PSendEligibilityResult> {
        final /* synthetic */ PaymentProtocolUtil f14524a;

        C16572(PaymentProtocolUtil paymentProtocolUtil) {
            this.f14524a = paymentProtocolUtil;
        }

        public Object apply(Object obj) {
            return (FetchP2PSendEligibilityResult) ((OperationResult) obj).h();
        }
    }

    /* compiled from: fragment_params */
    class C16583 implements Function<OperationResult, PaymentCard> {
        final /* synthetic */ PaymentProtocolUtil f14525a;

        C16583(PaymentProtocolUtil paymentProtocolUtil) {
            this.f14525a = paymentProtocolUtil;
        }

        @Nullable
        public Object apply(@Nullable Object obj) {
            OperationResult operationResult = (OperationResult) obj;
            if (operationResult == null) {
                return null;
            }
            return (PaymentCard) operationResult.k();
        }
    }

    /* compiled from: fragment_params */
    class C16594 implements Function<OperationResult, AddPaymentCardResult> {
        final /* synthetic */ PaymentProtocolUtil f14526a;

        C16594(PaymentProtocolUtil paymentProtocolUtil) {
            this.f14526a = paymentProtocolUtil;
        }

        public Object apply(Object obj) {
            return (AddPaymentCardResult) ((OperationResult) obj).h();
        }
    }

    /* compiled from: fragment_params */
    class C16605 implements Function<OperationResult, String> {
        final /* synthetic */ PaymentProtocolUtil f14527a;

        C16605(PaymentProtocolUtil paymentProtocolUtil) {
            this.f14527a = paymentProtocolUtil;
        }

        public Object apply(Object obj) {
            return ((OperationResult) obj).c;
        }
    }

    /* compiled from: fragment_params */
    class C16616 implements Function<OperationResult, String> {
        final /* synthetic */ PaymentProtocolUtil f14528a;

        C16616(PaymentProtocolUtil paymentProtocolUtil) {
            this.f14528a = paymentProtocolUtil;
        }

        public Object apply(Object obj) {
            return ((OperationResult) obj).c;
        }
    }

    /* compiled from: fragment_params */
    class C16627 implements Function<OperationResult, PaymentTransaction> {
        final /* synthetic */ PaymentProtocolUtil f14529a;

        C16627(PaymentProtocolUtil paymentProtocolUtil) {
            this.f14529a = paymentProtocolUtil;
        }

        public Object apply(Object obj) {
            return (PaymentTransaction) ((OperationResult) obj).h();
        }
    }

    public static com.facebook.messaging.payment.protocol.PaymentProtocolUtil m14937a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find immediate dominator for block B:24:0x003b in {17, 19, 21, 23, 26, 28} preds:[]
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.computeDominators(BlockProcessor.java:129)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.processBlocksTree(BlockProcessor.java:48)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.rerun(BlockProcessor.java:44)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.visit(BlockFinallyExtract.java:57)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r0 = f14532g;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.messaging.payment.protocol.PaymentProtocolUtil.class;
        monitor-enter(r1);
        r0 = f14532g;	 Catch:{ all -> 0x003a }
        if (r0 != 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000b:
        if (r5 == 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000d:
        r2 = com.facebook.inject.ScopeSet.a();	 Catch:{ all -> 0x003a }
        r3 = r2.b();	 Catch:{ all -> 0x003a }
        r0 = com.facebook.inject.SingletonScope.class;	 Catch:{ all -> 0x003a }
        r0 = r5.getInstance(r0);	 Catch:{ all -> 0x003a }
        r0 = (com.facebook.inject.SingletonScope) r0;	 Catch:{ all -> 0x003a }
        r4 = r0.enterScope();	 Catch:{ all -> 0x003a }
        r0 = r5.getApplicationInjector();	 Catch:{ all -> 0x0035 }
        r0 = m14939b(r0);	 Catch:{ all -> 0x0035 }
        f14532g = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f14532g;
        return r0;
    L_0x0035:
        r0 = move-exception;
        com.facebook.inject.SingletonScope.a(r4);	 Catch:{ all -> 0x0035 }
        throw r0;	 Catch:{ all -> 0x0035 }
    L_0x003a:
        r0 = move-exception;
        r2.c(r3);	 Catch:{ all -> 0x003a }
        throw r0;	 Catch:{ all -> 0x003a }
    L_0x003f:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x003a }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.payment.protocol.PaymentProtocolUtil.a(com.facebook.inject.InjectorLike):com.facebook.messaging.payment.protocol.PaymentProtocolUtil");
    }

    private static PaymentProtocolUtil m14939b(InjectorLike injectorLike) {
        return new PaymentProtocolUtil(DefaultBlueServiceOperationFactory.b(injectorLike), DefaultAndroidThreadUtil.b(injectorLike), GraphQLQueryExecutor.a(injectorLike), (Executor) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(injectorLike));
    }

    public final ListenableFuture<PaymentPlatformContext> m14966d(String str) {
        GraphQlQueryString createCommerceCartP2pPlatformContextCoreMutationString = new CreateCommerceCartP2pPlatformContextCoreMutationString();
        CreateCommerceCartP2pPlatformContextInputData createCommerceCartP2pPlatformContextInputData = new CreateCommerceCartP2pPlatformContextInputData();
        createCommerceCartP2pPlatformContextInputData.a("item_id", str);
        createCommerceCartP2pPlatformContextCoreMutationString.a("input", createCommerceCartP2pPlatformContextInputData);
        return Futures.a(this.f14535c.a(GraphQLRequest.a(createCommerceCartP2pPlatformContextCoreMutationString)), new Function<GraphQLResult<CreateCommerceCartP2pPlatformContextCoreMutationModel>, PaymentPlatformContext>(this) {
            final /* synthetic */ PaymentProtocolUtil f14508a;

            {
                this.f14508a = r1;
            }

            public Object apply(Object obj) {
                return ((CreateCommerceCartP2pPlatformContextCoreMutationModel) ((GraphQLResult) obj).e).m14041a();
            }
        }, MoreExecutors.a());
    }

    @Inject
    public PaymentProtocolUtil(DefaultBlueServiceOperationFactory defaultBlueServiceOperationFactory, DefaultAndroidThreadUtil defaultAndroidThreadUtil, GraphQLQueryExecutor graphQLQueryExecutor, Executor executor) {
        this.f14533a = defaultBlueServiceOperationFactory;
        this.f14534b = defaultAndroidThreadUtil;
        this.f14535c = graphQLQueryExecutor;
        this.f14536d = executor;
    }

    public final ListenableFuture<PaymentPlatformContext> m14959a(String str, String str2) {
        GraphQlQueryString p2pPlatformContextSetShippingAddressMutationString = new P2pPlatformContextSetShippingAddressMutationString();
        P2pPlatformContextSetShippingAddressInputData p2pPlatformContextSetShippingAddressInputData = new P2pPlatformContextSetShippingAddressInputData();
        p2pPlatformContextSetShippingAddressInputData.a("p2p_platform_context_id", str);
        p2pPlatformContextSetShippingAddressInputData.a("shipping_address_id", str2);
        p2pPlatformContextSetShippingAddressMutationString.a("input", p2pPlatformContextSetShippingAddressInputData);
        return Futures.a(this.f14535c.a(GraphQLRequest.a(p2pPlatformContextSetShippingAddressMutationString)), new Function<GraphQLResult<P2pPlatformContextSetShippingAddressMutationModel>, PaymentPlatformContext>(this) {
            final /* synthetic */ PaymentProtocolUtil f14509a;

            {
                this.f14509a = r1;
            }

            public Object apply(Object obj) {
                return ((P2pPlatformContextSetShippingAddressMutationModel) ((GraphQLResult) obj).e).m14064a();
            }
        }, MoreExecutors.a());
    }

    public final ListenableFuture<FetchPaymentCardsResult> m14940a() {
        if (this.f14538f != null && !this.f14538f.isDone()) {
            return this.f14538f;
        }
        this.f14538f = Futures.a(BlueServiceOperationFactoryDetour.a(this.f14533a, "fetch_payment_cards", new Bundle(), ErrorPropagation.BY_ERROR_CODE, CallerContext.a(getClass()), 524296174).a(), new C16561(this), MoreExecutors.a());
        return this.f14538f;
    }

    public final ListenableFuture<FetchP2PSendEligibilityResult> m14948a(DataFreshnessParam dataFreshnessParam, String str) {
        Bundle bundle = new Bundle();
        bundle.putParcelable(FetchP2PSendEligibilityParams.f14660a, new FetchP2PSendEligibilityParams(dataFreshnessParam, str));
        ListenableFuture a = m14938a(bundle, "fetch_p2p_send_eligibility");
        if (dataFreshnessParam != DataFreshnessParam.CHECK_SERVER_FOR_NEW_DATA) {
            m14948a(DataFreshnessParam.CHECK_SERVER_FOR_NEW_DATA, str);
        }
        return Futures.a(a, new C16572(this), MoreExecutors.a());
    }

    public final ListenableFuture<PaymentCard> m14955a(String str) {
        Bundle bundle = new Bundle();
        bundle.putParcelable("fetchTransactionPaymentCardParams", new FetchTransactionPaymentCardParams(str));
        return Futures.a(m14938a(bundle, "fetch_transaction_payment_card"), new C16583(this), MoreExecutors.a());
    }

    public final ListenableFuture<AddPaymentCardResult> m14956a(String str, int i, int i2, String str2, String str3, String str4, String str5, @Nullable String str6) {
        Bundle bundle = new Bundle();
        bundle.putParcelable("addPaymentCardParams", new AddPaymentCardParams(str, i, i2, str2, str3, str4, str5, str6));
        return Futures.a(m14938a(bundle, "add_payment_card"), new C16594(this), MoreExecutors.a());
    }

    public final ListenableFuture<String> m14945a(Context context, String str, int i, int i2, String str2, String str3) {
        Bundle bundle = new Bundle();
        bundle.putParcelable("editPaymentCardParams", new EditPaymentCardParams(str, i, i2, str2, null, true));
        return Futures.a(BlueServiceOperationFactoryDetour.a(this.f14533a, "edit_payment_card", bundle, ErrorPropagation.BY_ERROR_CODE, CallerContext.a(getClass()), 381237118).a(new DialogBasedProgressIndicator(context, str3)).a(), new C16605(this), MoreExecutors.a());
    }

    public final ListenableFuture<String> m14957a(String str, int i, int i2, String str2, String str3, boolean z) {
        Bundle bundle = new Bundle();
        bundle.putParcelable("editPaymentCardParams", new EditPaymentCardParams(str, i, i2, str2, str3, z));
        return Futures.a(m14938a(bundle, "edit_payment_card"), new C16616(this), MoreExecutors.a());
    }

    public final ListenableFuture<OperationResult> m14941a(long j) {
        Bundle bundle = new Bundle();
        bundle.putParcelable(DeletePaymentCardParams.f14626a, new DeletePaymentCardParams(j));
        return m14938a(bundle, "delete_payment_card");
    }

    public final ListenableFuture<OperationResult> m14942a(long j, String str, @Nullable String str2) {
        Bundle bundle = new Bundle();
        bundle.putParcelable(SetPrimaryCardParams.f14653a, new SetPrimaryCardParams(j, str, str2));
        return m14938a(bundle, "set_primary_payment_card");
    }

    public final ListenableFuture<PaymentTransaction> m14958a(final String str, DataFreshnessParam dataFreshnessParam) {
        if (this.f14537e.containsKey(str)) {
            return (ListenableFuture) this.f14537e.get(str);
        }
        Parcelable fetchPaymentTransactionParams = new FetchPaymentTransactionParams(str, dataFreshnessParam);
        Bundle bundle = new Bundle();
        bundle.putParcelable("fetchPaymentTransactionParams", fetchPaymentTransactionParams);
        ListenableFuture<PaymentTransaction> a = Futures.a(m14938a(bundle, "fetch_payment_transaction"), new C16627(this), MoreExecutors.a());
        this.f14534b.a();
        this.f14537e.put(str, a);
        Futures.a(a, new FutureCallback<PaymentTransaction>(this) {
            final /* synthetic */ PaymentProtocolUtil f14531b;

            public void onSuccess(Object obj) {
                this.f14531b.f14534b.a();
                this.f14531b.f14537e.remove(str);
            }

            public void onFailure(Throwable th) {
                this.f14531b.f14534b.a();
                this.f14531b.f14537e.remove(str);
            }
        }, this.f14536d);
        return a;
    }

    public final ListenableFuture<ValidatePaymentCardBinResult> m14963b(String str) {
        Parcelable validatePaymentCardBinParams = new ValidatePaymentCardBinParams(str);
        Bundle bundle = new Bundle();
        bundle.putParcelable(ValidatePaymentCardBinParams.f14657a, validatePaymentCardBinParams);
        return Futures.a(m14938a(bundle, "validate_payment_card_bin"), new Function<OperationResult, ValidatePaymentCardBinResult>(this) {
            final /* synthetic */ PaymentProtocolUtil f14504a;

            {
                this.f14504a = r1;
            }

            public Object apply(Object obj) {
                return (ValidatePaymentCardBinResult) ((OperationResult) obj).h();
            }
        });
    }

    private ListenableFuture<OperationResult> m14938a(Bundle bundle, String str) {
        return BlueServiceOperationFactoryDetour.a(this.f14533a, str, bundle, ErrorPropagation.BY_ERROR_CODE, CallerContext.a(getClass()), 840893150).a();
    }

    public final ListenableFuture<FetchTransactionListResult> m14949a(PaymentTransactionQueryType paymentTransactionQueryType, int i) {
        Parcelable fetchTransactionListParams = new FetchTransactionListParams(paymentTransactionQueryType, i);
        Bundle bundle = new Bundle();
        bundle.putParcelable("fetchTransactionListParams", fetchTransactionListParams);
        return Futures.a(m14938a(bundle, "fetch_transaction_list"), new Function<OperationResult, FetchTransactionListResult>(this) {
            final /* synthetic */ PaymentProtocolUtil f14505a;

            {
                this.f14505a = r1;
            }

            public Object apply(Object obj) {
                return (FetchTransactionListResult) ((OperationResult) obj).h();
            }
        }, MoreExecutors.a());
    }

    public final ListenableFuture<FetchMoreTransactionsResult> m14950a(PaymentTransactionQueryType paymentTransactionQueryType, long j) {
        Parcelable fetchMoreTransactionsParams = new FetchMoreTransactionsParams(paymentTransactionQueryType, j);
        Bundle bundle = new Bundle();
        bundle.putParcelable("fetchMoreTransactionsParams", fetchMoreTransactionsParams);
        return Futures.a(m14938a(bundle, "fetch_more_transactions"), new Function<OperationResult, FetchMoreTransactionsResult>(this) {
            final /* synthetic */ PaymentProtocolUtil f14506a;

            {
                this.f14506a = r1;
            }

            public Object apply(Object obj) {
                return (FetchMoreTransactionsResult) ((OperationResult) obj).h();
            }
        }, MoreExecutors.a());
    }

    public final ListenableFuture<MoneyPennyPlaceOrderResult> m14947a(Context context, String str, String str2, String str3, long j, long j2, String str4, @Nullable String str5) {
        Parcelable moneyPennyPlaceOrderParams = new MoneyPennyPlaceOrderParams(str, str2, str3, j, j2, str4);
        Bundle bundle = new Bundle();
        bundle.putParcelable(MoneyPennyPlaceOrderParams.f14664a, moneyPennyPlaceOrderParams);
        Operation a = BlueServiceOperationFactoryDetour.a(this.f14533a, "money_penny_place_order", bundle, ErrorPropagation.BY_ERROR_CODE, CallerContext.a(getClass()), -1925196016);
        if (str5 != null) {
            a.a(new DialogBasedProgressIndicator(context, str5));
        }
        return Futures.a(a.a(), new Function<OperationResult, MoneyPennyPlaceOrderResult>(this) {
            final /* synthetic */ PaymentProtocolUtil f14510a;

            {
                this.f14510a = r1;
            }

            public Object apply(Object obj) {
                return (MoneyPennyPlaceOrderResult) ((OperationResult) obj).h();
            }
        }, this.f14536d);
    }

    public final ListenableFuture<SendPaymentMessageResult> m14944a(Context context, SendPaymentMessageParams sendPaymentMessageParams, @Nullable String str) {
        Bundle bundle = new Bundle();
        bundle.putParcelable(SendPaymentMessageParams.f14759a, sendPaymentMessageParams);
        Operation a = BlueServiceOperationFactoryDetour.a(this.f14533a, "mc_place_order", bundle, ErrorPropagation.BY_ERROR_CODE, CallerContext.a(getClass()), -1677571732);
        if (str != null) {
            a.a(new DialogBasedProgressIndicator(context, str));
        }
        return Futures.a(a.a(), new Function<OperationResult, SendPaymentMessageResult>(this) {
            final /* synthetic */ PaymentProtocolUtil f14511a;

            {
                this.f14511a = r1;
            }

            public Object apply(Object obj) {
                return (SendPaymentMessageResult) ((OperationResult) obj).h();
            }
        }, this.f14536d);
    }

    public final ListenableFuture<SendPaymentResult> m14943a(Context context, SendPaymentParams sendPaymentParams, String str) {
        Bundle bundle = new Bundle();
        bundle.putParcelable("SendPaymentParams", sendPaymentParams);
        return Futures.a(BlueServiceOperationFactoryDetour.a(this.f14533a, "send_payment", bundle, ErrorPropagation.BY_ERROR_CODE, CallerContext.a(getClass()), -186866812).a(new DialogBasedProgressIndicator(context, str)).a(), new Function<OperationResult, SendPaymentResult>(this) {
            final /* synthetic */ PaymentProtocolUtil f14512a;

            {
                this.f14512a = r1;
            }

            public Object apply(Object obj) {
                return (SendPaymentResult) ((OperationResult) obj).h();
            }
        }, this.f14536d);
    }

    public final ListenableFuture<VerifyPaymentResult> m14960a(String str, @Nullable String str2, @Nullable UserInput userInput, @Nullable String str3, String str4) {
        Parcelable verifyPaymentParams = new VerifyPaymentParams(str, str2, userInput, str3, str4);
        Bundle bundle = new Bundle();
        bundle.putParcelable(VerifyPaymentParams.f14789a, verifyPaymentParams);
        return Futures.a(m14938a(bundle, "verify_payment"), new Function<OperationResult, VerifyPaymentResult>(this) {
            final /* synthetic */ PaymentProtocolUtil f14514a;

            {
                this.f14514a = r1;
            }

            public Object apply(Object obj) {
                return (VerifyPaymentResult) ((OperationResult) obj).h();
            }
        }, this.f14536d);
    }

    public final ListenableFuture<ArrayList<PaymentPlatformContext>> m14962b() {
        return Futures.a(m14938a(new Bundle(), "payment_platform_contexts"), new Function<OperationResult, ArrayList<PaymentPlatformContext>>(this) {
            final /* synthetic */ PaymentProtocolUtil f14515a;

            {
                this.f14515a = r1;
            }

            public Object apply(Object obj) {
                return ((OperationResult) obj).i();
            }
        }, MoreExecutors.a());
    }

    public final ListenableFuture<PaymentPlatformContext> m14968e(String str) {
        Bundle bundle = new Bundle();
        bundle.putString("platform_context_id", str);
        return Futures.a(m14938a(bundle, "payment_platform_context"), new Function<OperationResult, PaymentPlatformContext>(this) {
            final /* synthetic */ PaymentProtocolUtil f14516a;

            {
                this.f14516a = r1;
            }

            public Object apply(Object obj) {
                return (PaymentPlatformContextModel) ((OperationResult) obj).h();
            }
        }, this.f14536d);
    }

    public final ListenableFuture<OperationResult> m14961a(String str, String str2, String str3, String str4, String str5, @Nullable String str6, @Nullable String str7) {
        Bundle bundle = new Bundle();
        bundle.putParcelable(CreatePaymentRequestParams.f14706a, new CreatePaymentRequestParams(str, str2, str3, str4, str5, str6, str7));
        return BlueServiceOperationFactoryDetour.a(this.f14533a, "create_payment_request", bundle, ErrorPropagation.BY_ERROR_CODE, CallerContext.a(getClass()), -1473726895).a();
    }

    public final ListenableFuture<PaymentRequest> m14969f(String str) {
        Parcelable fetchPaymentRequestParams = new FetchPaymentRequestParams(str);
        Bundle bundle = new Bundle();
        bundle.putParcelable(FetchPaymentRequestParams.f14716a, fetchPaymentRequestParams);
        return Futures.a(m14938a(bundle, "fetch_payment_request"), new Function<OperationResult, PaymentRequest>(this) {
            final /* synthetic */ PaymentProtocolUtil f14517a;

            {
                this.f14517a = r1;
            }

            public Object apply(Object obj) {
                return (PaymentRequestModel) ((OperationResult) obj).h();
            }
        }, MoreExecutors.a());
    }

    public final ListenableFuture<FetchPaymentRequestsResult> m14951a(QueryType queryType) {
        Parcelable fetchPaymentRequestsParams = new FetchPaymentRequestsParams(queryType);
        Bundle bundle = new Bundle();
        bundle.putParcelable(FetchPaymentRequestsParams.f14718a, fetchPaymentRequestsParams);
        return Futures.a(m14938a(bundle, "fetch_payment_requests"), new Function<OperationResult, FetchPaymentRequestsResult>(this) {
            final /* synthetic */ PaymentProtocolUtil f14518a;

            {
                this.f14518a = r1;
            }

            public Object apply(Object obj) {
                return (FetchPaymentRequestsResult) ((OperationResult) obj).h();
            }
        }, MoreExecutors.a());
    }

    public final ListenableFuture<OperationResult> m14946a(Context context, String str, String str2) {
        Bundle bundle = new Bundle();
        bundle.putParcelable(DeclinePaymentRequestParams.f14714a, new DeclinePaymentRequestParams(str));
        return BlueServiceOperationFactoryDetour.a(this.f14533a, "decline_payment_request", bundle, ErrorPropagation.BY_ERROR_CODE, CallerContext.a(getClass()), 928682497).a(new DialogBasedProgressIndicator(context, str2)).a();
    }

    public final ListenableFuture<OperationResult> m14952a(Mutation mutation, String str) {
        Parcelable mutatePaymentPlatformContextParams = new MutatePaymentPlatformContextParams(mutation, str);
        Bundle bundle = new Bundle();
        bundle.putParcelable("mutatePaymentPlatformContextParams", mutatePaymentPlatformContextParams);
        return m14938a(bundle, "mutate_payment_platform_context");
    }

    public final ListenableFuture<String> m14953a(ShippingAddressFormInput shippingAddressFormInput, String str) {
        Bundle bundle = new Bundle();
        bundle.putParcelable("addShippingAddressParams", new AddShippingAddressParams(shippingAddressFormInput, str));
        return Futures.a(m14938a(bundle, "add_shipping_address"), new Function<OperationResult, String>(this) {
            final /* synthetic */ PaymentProtocolUtil f14519a;

            {
                this.f14519a = r1;
            }

            public Object apply(Object obj) {
                return ((OperationResult) obj).c;
            }
        }, MoreExecutors.a());
    }

    public final ListenableFuture<OperationResult> m14954a(ShippingAddressFormInput shippingAddressFormInput, String str, boolean z, boolean z2) {
        Bundle bundle = new Bundle();
        EditShippingAddressParamsBuilder editShippingAddressParamsBuilder = new EditShippingAddressParamsBuilder();
        editShippingAddressParamsBuilder.f14727a = shippingAddressFormInput;
        editShippingAddressParamsBuilder = editShippingAddressParamsBuilder;
        editShippingAddressParamsBuilder.f14728b = str;
        editShippingAddressParamsBuilder = editShippingAddressParamsBuilder;
        editShippingAddressParamsBuilder.f14729c = z;
        editShippingAddressParamsBuilder = editShippingAddressParamsBuilder;
        editShippingAddressParamsBuilder.f14730d = z2;
        bundle.putParcelable("editShippingAddressParams", new EditShippingAddressParams(editShippingAddressParamsBuilder));
        return Futures.a(m14938a(bundle, "edit_shipping_address"), new Function<OperationResult, OperationResult>(this) {
            final /* synthetic */ PaymentProtocolUtil f14520a;

            {
                this.f14520a = r1;
            }

            public Object apply(Object obj) {
                return (OperationResult) obj;
            }
        }, MoreExecutors.a());
    }

    public final ListenableFuture<ArrayList<MailingAddressInfo>> m14964c() {
        return Futures.a(m14938a(new Bundle(), "fetch_shipping_addresses"), new Function<OperationResult, ArrayList<MailingAddressInfo>>(this) {
            final /* synthetic */ PaymentProtocolUtil f14521a;

            {
                this.f14521a = r1;
            }

            public Object apply(Object obj) {
                return ((OperationResult) obj).i();
            }
        }, MoreExecutors.a());
    }

    public final ListenableFuture<ArrayList<Theme>> m14965d() {
        return Futures.a(m14938a(new Bundle(), "fetch_theme_list"), new Function<OperationResult, ArrayList<Theme>>(this) {
            final /* synthetic */ PaymentProtocolUtil f14522a;

            {
                this.f14522a = r1;
            }

            public Object apply(Object obj) {
                return ((OperationResult) obj).i();
            }
        }, DirectExecutor.INSTANCE);
    }

    public final ListenableFuture<PaymentAccountEnabledStatus> m14967e() {
        return Futures.a(m14938a(new Bundle(), "fetch_payment_account_enabled_status"), new Function<OperationResult, PaymentAccountEnabledStatus>(this) {
            final /* synthetic */ PaymentProtocolUtil f14523a;

            {
                this.f14523a = r1;
            }

            public Object apply(Object obj) {
                return (PaymentAccountEnabledStatusModel) ((OperationResult) obj).h();
            }
        }, this.f14536d);
    }
}
