package com.facebook.messaging.payment.protocol;

import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.common.util.TriState;
import com.facebook.fbservice.service.BlueServiceHandler;
import com.facebook.fbservice.service.DataFreshnessParam;
import com.facebook.fbservice.service.OperationParams;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.payment.analytics.P2pPaymentsLogEvent;
import com.facebook.messaging.payment.analytics.P2pPaymentsLogEvent.Builder;
import com.facebook.messaging.payment.cache.PaymentCardCacheResult;
import com.facebook.messaging.payment.cache.PaymentCardCacheResult.State;
import com.facebook.messaging.payment.cache.PaymentCardListCacheResult;
import com.facebook.messaging.payment.database.DbPaymentsProperties;
import com.facebook.messaging.payment.database.DbPaymentsPropertyUtil;
import com.facebook.messaging.payment.database.handler.CacheFetchPaymentCardHandler;
import com.facebook.messaging.payment.database.handler.CacheFetchTransactionPaymentCardHandler;
import com.facebook.messaging.payment.database.handler.CacheInsertPaymentCardHandler;
import com.facebook.messaging.payment.database.handler.CacheInsertTransactionPaymentCardHandler;
import com.facebook.messaging.payment.database.handler.DbFetchPaymentRequestHandler;
import com.facebook.messaging.payment.database.handler.DbFetchPaymentTransactionHandler;
import com.facebook.messaging.payment.database.handler.DbInsertPaymentRequestsHandler;
import com.facebook.messaging.payment.database.handler.DbInsertPaymentTransactionsHandler;
import com.facebook.messaging.payment.database.handler.DbRecipientEligibilityHandler;
import com.facebook.messaging.payment.model.PaymentCard;
import com.facebook.messaging.payment.model.PaymentTransaction;
import com.facebook.messaging.payment.model.TransferStatus;
import com.facebook.messaging.payment.model.graphql.PaymentGraphQLModels.PaymentAccountEnabledStatusModel;
import com.facebook.messaging.payment.model.graphql.PaymentGraphQLModels.PaymentRequestModel;
import com.facebook.messaging.payment.service.model.cards.DeletePaymentCardParams;
import com.facebook.messaging.payment.service.model.cards.FetchPaymentCardsResult;
import com.facebook.messaging.payment.service.model.cards.SetPrimaryCardParams;
import com.facebook.messaging.payment.service.model.eligibility.FetchP2PSendEligibilityParams;
import com.facebook.messaging.payment.service.model.eligibility.FetchP2PSendEligibilityResult;
import com.facebook.messaging.payment.service.model.request.FetchPaymentRequestParams;
import com.facebook.messaging.payment.service.model.request.FetchPaymentRequestsParams;
import com.facebook.messaging.payment.service.model.request.FetchPaymentRequestsParams.QueryType;
import com.facebook.messaging.payment.service.model.request.FetchPaymentRequestsResult;
import com.facebook.messaging.payment.service.model.transactions.FetchMoreTransactionsParams;
import com.facebook.messaging.payment.service.model.transactions.FetchMoreTransactionsResult;
import com.facebook.messaging.payment.service.model.transactions.FetchPaymentTransactionParams;
import com.facebook.messaging.payment.service.model.transactions.FetchTransactionListParams;
import com.facebook.messaging.payment.service.model.transactions.FetchTransactionListResult;
import com.facebook.messaging.payment.service.model.transactions.FetchTransactionPaymentCardParams;
import com.google.common.base.Absent;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: free_call_acceptance */
public class PaymentDbServiceHandler extends AbstractBlueServiceHandlerFilter {
    private final Provider<Boolean> f14491a;
    private final AnalyticsLogger f14492b;
    private final PaymentsBroadcaster f14493c;
    private final CacheFetchPaymentCardHandler f14494d;
    private final CacheInsertPaymentCardHandler f14495e;
    private final CacheFetchTransactionPaymentCardHandler f14496f;
    private final CacheInsertTransactionPaymentCardHandler f14497g;
    private final DbRecipientEligibilityHandler f14498h;
    private final DbFetchPaymentRequestHandler f14499i;
    private final DbFetchPaymentTransactionHandler f14500j;
    private final DbInsertPaymentTransactionsHandler f14501k;
    private final DbPaymentsPropertyUtil f14502l;
    private final DbInsertPaymentRequestsHandler f14503m;

    public static PaymentDbServiceHandler m14924b(InjectorLike injectorLike) {
        return new PaymentDbServiceHandler(IdBasedProvider.a(injectorLike, 4184), AnalyticsLoggerMethodAutoProvider.a(injectorLike), PaymentsBroadcaster.m15003a(injectorLike), CacheFetchPaymentCardHandler.m13220b(injectorLike), CacheInsertPaymentCardHandler.m13223b(injectorLike), CacheFetchTransactionPaymentCardHandler.m13221b(injectorLike), CacheInsertTransactionPaymentCardHandler.m13227b(injectorLike), DbRecipientEligibilityHandler.m13280a(injectorLike), DbFetchPaymentRequestHandler.m13234a(injectorLike), DbInsertPaymentRequestsHandler.m13258a(injectorLike), DbFetchPaymentTransactionHandler.m13242a(injectorLike), DbPaymentsPropertyUtil.m13206a(injectorLike), DbInsertPaymentTransactionsHandler.m13264a(injectorLike));
    }

    protected final OperationResult mo572c(OperationParams operationParams, BlueServiceHandler blueServiceHandler) {
        long parseLong = Long.parseLong(((FetchTransactionPaymentCardParams) operationParams.c.getParcelable("fetchTransactionPaymentCardParams")).f14750a);
        if (((Boolean) this.f14491a.get()).booleanValue()) {
            Optional c;
            CacheFetchTransactionPaymentCardHandler cacheFetchTransactionPaymentCardHandler = this.f14496f;
            Long a = cacheFetchTransactionPaymentCardHandler.f12933b.m13248a(parseLong);
            if (a != null) {
                c = cacheFetchTransactionPaymentCardHandler.f12932a.m13168c(a.longValue());
            } else {
                c = Absent.INSTANCE;
            }
            Optional optional = c;
            if (optional.isPresent()) {
                return OperationResult.a(optional.get());
            }
        }
        OperationResult a2 = blueServiceHandler.a(operationParams);
        PaymentCard paymentCard = (PaymentCard) a2.k();
        if (paymentCard != null) {
            this.f14497g.m13228a(parseLong, paymentCard);
        }
        return a2;
    }

    protected final OperationResult mo566j(OperationParams operationParams, BlueServiceHandler blueServiceHandler) {
        FetchP2PSendEligibilityParams fetchP2PSendEligibilityParams = (FetchP2PSendEligibilityParams) operationParams.c.getParcelable(FetchP2PSendEligibilityParams.f14660a);
        if (fetchP2PSendEligibilityParams.f14661b == DataFreshnessParam.PREFER_CACHE_IF_UP_TO_DATE) {
            TriState a = this.f14498h.m13282a(fetchP2PSendEligibilityParams.f14662c);
            if (a.isSet()) {
                return OperationResult.a(new FetchP2PSendEligibilityResult(Boolean.valueOf(a.asBoolean())));
            }
        }
        OperationResult a2 = blueServiceHandler.a(operationParams);
        this.f14498h.m13283a(fetchP2PSendEligibilityParams.f14662c, ((FetchP2PSendEligibilityResult) a2.h()).m15170a());
        return a2;
    }

    protected final OperationResult mo575l(OperationParams operationParams, BlueServiceHandler blueServiceHandler) {
        FetchTransactionListParams fetchTransactionListParams = (FetchTransactionListParams) operationParams.c.getParcelable("fetchTransactionListParams");
        OperationResult a = blueServiceHandler.a(operationParams);
        this.f14501k.m13269a(fetchTransactionListParams, (FetchTransactionListResult) a.h());
        return a;
    }

    protected final OperationResult mo576m(OperationParams operationParams, BlueServiceHandler blueServiceHandler) {
        FetchMoreTransactionsParams fetchMoreTransactionsParams = (FetchMoreTransactionsParams) operationParams.c.getParcelable("fetchMoreTransactionsParams");
        OperationResult a = blueServiceHandler.a(operationParams);
        this.f14501k.m13268a(fetchMoreTransactionsParams, (FetchMoreTransactionsResult) a.h());
        return a;
    }

    protected final OperationResult mo569w(OperationParams operationParams, BlueServiceHandler blueServiceHandler) {
        if (operationParams.c == null) {
            return OperationResult.a(new NullPointerException("Null params provided"));
        }
        FetchPaymentRequestsParams fetchPaymentRequestsParams = (FetchPaymentRequestsParams) operationParams.c.getParcelable(FetchPaymentRequestsParams.f14718a);
        if (((Boolean) this.f14491a.get()).booleanValue() && fetchPaymentRequestsParams.f14719b == QueryType.INCOMING) {
            ImmutableList a = this.f14499i.m13241a();
            if (a != null) {
                return OperationResult.a(new FetchPaymentRequestsResult(new ArrayList(a)));
            }
        }
        OperationResult a2 = blueServiceHandler.a(operationParams);
        if (fetchPaymentRequestsParams.f14719b == QueryType.INCOMING) {
            this.f14503m.m13262a(((FetchPaymentRequestsResult) a2.h()).m15195a());
        }
        return a2;
    }

    @Inject
    public PaymentDbServiceHandler(Provider<Boolean> provider, AnalyticsLogger analyticsLogger, PaymentsBroadcaster paymentsBroadcaster, CacheFetchPaymentCardHandler cacheFetchPaymentCardHandler, CacheInsertPaymentCardHandler cacheInsertPaymentCardHandler, CacheFetchTransactionPaymentCardHandler cacheFetchTransactionPaymentCardHandler, CacheInsertTransactionPaymentCardHandler cacheInsertTransactionPaymentCardHandler, DbRecipientEligibilityHandler dbRecipientEligibilityHandler, DbFetchPaymentRequestHandler dbFetchPaymentRequestHandler, DbInsertPaymentRequestsHandler dbInsertPaymentRequestsHandler, DbFetchPaymentTransactionHandler dbFetchPaymentTransactionHandler, DbPaymentsPropertyUtil dbPaymentsPropertyUtil, DbInsertPaymentTransactionsHandler dbInsertPaymentTransactionsHandler) {
        super("PaymentDbServiceHandler");
        this.f14491a = provider;
        this.f14492b = analyticsLogger;
        this.f14493c = paymentsBroadcaster;
        this.f14494d = cacheFetchPaymentCardHandler;
        this.f14495e = cacheInsertPaymentCardHandler;
        this.f14497g = cacheInsertTransactionPaymentCardHandler;
        this.f14496f = cacheFetchTransactionPaymentCardHandler;
        this.f14498h = dbRecipientEligibilityHandler;
        this.f14499i = dbFetchPaymentRequestHandler;
        this.f14503m = dbInsertPaymentRequestsHandler;
        this.f14500j = dbFetchPaymentTransactionHandler;
        this.f14502l = dbPaymentsPropertyUtil;
        this.f14501k = dbInsertPaymentTransactionsHandler;
    }

    protected final OperationResult mo565d(OperationParams operationParams, BlueServiceHandler blueServiceHandler) {
        TransferStatus transferStatus = null;
        if (((Boolean) this.f14491a.get()).booleanValue()) {
            FetchPaymentTransactionParams fetchPaymentTransactionParams = (FetchPaymentTransactionParams) operationParams.c.getParcelable("fetchPaymentTransactionParams");
            PaymentTransaction a = this.f14500j.m13245a(Long.parseLong(fetchPaymentTransactionParams.f14742a));
            if (a != null) {
                transferStatus = a.f13234g;
                if (fetchPaymentTransactionParams.f14743b == DataFreshnessParam.STALE_DATA_OKAY || a.f13234g.isTerminalStatus) {
                    return OperationResult.a(a);
                }
            }
        }
        OperationResult a2 = blueServiceHandler.a(operationParams);
        PaymentTransaction paymentTransaction = (PaymentTransaction) a2.h();
        if (!(transferStatus == null || transferStatus == paymentTransaction.f13234g)) {
            AnalyticsLogger analyticsLogger = this.f14492b;
            Builder g = P2pPaymentsLogEvent.d("p2p_inconsistent_status", "p2p_settings").g(paymentTransaction.f13229b);
            g.a.b("local_status_on_client", transferStatus.toString());
            Builder builder = g;
            builder.a.b("status_from_server", paymentTransaction.f13234g.toString());
            analyticsLogger.a(builder.a);
        }
        this.f14501k.m13270b(paymentTransaction);
        return a2;
    }

    protected final OperationResult mo568v(OperationParams operationParams, BlueServiceHandler blueServiceHandler) {
        if (((Boolean) this.f14491a.get()).booleanValue()) {
            PaymentRequestModel a = this.f14499i.m13240a(Long.parseLong(((FetchPaymentRequestParams) operationParams.c.getParcelable(FetchPaymentRequestParams.f14716a)).f14717b));
            if (a != null) {
                return OperationResult.a(PaymentRequestModel.m13801a(a));
            }
        }
        OperationResult a2 = blueServiceHandler.a(operationParams);
        this.f14503m.m13263b((PaymentRequestModel) a2.h());
        return a2;
    }

    protected final OperationResult mo571b(OperationParams operationParams, BlueServiceHandler blueServiceHandler) {
        if (!((Boolean) this.f14491a.get()).booleanValue()) {
            return m14923H(operationParams, blueServiceHandler);
        }
        PaymentCardCacheResult paymentCardCacheResult;
        Object obj;
        CacheFetchPaymentCardHandler cacheFetchPaymentCardHandler = this.f14494d;
        Optional a = cacheFetchPaymentCardHandler.f12930a.m13161a();
        if (a != null && a.isPresent()) {
            PaymentCard paymentCard = (PaymentCard) a.get();
            Preconditions.checkNotNull(paymentCard);
            paymentCardCacheResult = new PaymentCardCacheResult(paymentCard, State.CARD_EXISTS_AND_IN_CACHE);
        } else if (cacheFetchPaymentCardHandler.f12931b.m13233b() == null) {
            paymentCardCacheResult = PaymentCardCacheResult.f12824d;
        } else {
            paymentCardCacheResult = PaymentCardCacheResult.f12823c;
        }
        PaymentCardCacheResult paymentCardCacheResult2 = paymentCardCacheResult;
        if (paymentCardCacheResult2.f12826b != State.CARD_EXISTS_BUT_NOT_IN_CACHE) {
            obj = 1;
        } else {
            obj = null;
        }
        if (obj == null) {
            return m14923H(operationParams, blueServiceHandler);
        }
        PaymentCardListCacheResult paymentCardListCacheResult;
        PaymentCard paymentCard2 = paymentCardCacheResult2.f12825a;
        CacheFetchPaymentCardHandler cacheFetchPaymentCardHandler2 = this.f14494d;
        Optional b = cacheFetchPaymentCardHandler2.f12930a.m13165b();
        ImmutableList a2 = cacheFetchPaymentCardHandler2.f12931b.m13232a();
        if (!b.isPresent()) {
            paymentCardListCacheResult = PaymentCardListCacheResult.f12827c;
        } else if (((ImmutableList) b.get()).size() != a2.size()) {
            paymentCardListCacheResult = PaymentCardListCacheResult.f12827c;
        } else if (((ImmutableList) b.get()).isEmpty()) {
            paymentCardListCacheResult = PaymentCardListCacheResult.f12828d;
        } else {
            ImmutableList immutableList = (ImmutableList) b.get();
            Preconditions.checkNotNull(immutableList);
            Preconditions.checkArgument(!immutableList.isEmpty());
            paymentCardListCacheResult = new PaymentCardListCacheResult(immutableList, PaymentCardListCacheResult.State.CARDS_EXIST_AND_ALL_IN_CACHE);
        }
        PaymentCardListCacheResult paymentCardListCacheResult2 = paymentCardListCacheResult;
        if (paymentCardListCacheResult2.f12830b != PaymentCardListCacheResult.State.CARDS_EXIST_BUT_NOT_ALL_IN_CACHE) {
            obj = 1;
        } else {
            obj = null;
        }
        if (obj == null) {
            return m14923H(operationParams, blueServiceHandler);
        }
        List list = paymentCardListCacheResult2.f12829a;
        this.f14493c.m15011c();
        return OperationResult.a(new FetchPaymentCardsResult(paymentCard2, list));
    }

    private OperationResult m14923H(OperationParams operationParams, BlueServiceHandler blueServiceHandler) {
        OperationResult a = blueServiceHandler.a(operationParams);
        FetchPaymentCardsResult fetchPaymentCardsResult = (FetchPaymentCardsResult) a.h();
        if (fetchPaymentCardsResult.f14635b != null) {
            this.f14495e.m13225a(fetchPaymentCardsResult.f14635b);
        } else {
            this.f14495e.m13224a();
        }
        this.f14495e.m13226a(fetchPaymentCardsResult.f14636c);
        this.f14493c.m15011c();
        return a;
    }

    protected final OperationResult mo574i(OperationParams operationParams, BlueServiceHandler blueServiceHandler) {
        OperationResult a = blueServiceHandler.a(operationParams);
        SetPrimaryCardParams setPrimaryCardParams = (SetPrimaryCardParams) operationParams.c.getParcelable(SetPrimaryCardParams.f14653a);
        CacheInsertPaymentCardHandler cacheInsertPaymentCardHandler = this.f14495e;
        long j = setPrimaryCardParams.f14654b;
        cacheInsertPaymentCardHandler.f12935b.m13254a(j);
        Optional a2 = cacheInsertPaymentCardHandler.f12934a.m13162a(j);
        if (a2.isPresent()) {
            cacheInsertPaymentCardHandler.f12934a.m13163a((PaymentCard) a2.get());
        }
        return a;
    }

    protected final OperationResult mo573h(OperationParams operationParams, BlueServiceHandler blueServiceHandler) {
        OperationResult a = blueServiceHandler.a(operationParams);
        DeletePaymentCardParams deletePaymentCardParams = (DeletePaymentCardParams) operationParams.c.getParcelable(DeletePaymentCardParams.f14626a);
        CacheInsertPaymentCardHandler cacheInsertPaymentCardHandler = this.f14495e;
        long j = deletePaymentCardParams.f14627b;
        cacheInsertPaymentCardHandler.f12935b.m13257b(j);
        cacheInsertPaymentCardHandler.f12934a.m13166b(j);
        return a;
    }

    protected final OperationResult mo570F(OperationParams operationParams, BlueServiceHandler blueServiceHandler) {
        TriState b = this.f14502l.b(DbPaymentsProperties.f12854j);
        if (b != TriState.UNSET) {
            PaymentAccountEnabledStatusModel.Builder builder = new PaymentAccountEnabledStatusModel.Builder();
            builder.f13306a = b.asBoolean();
            PaymentAccountEnabledStatusModel.Builder builder2 = builder;
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            flatBufferBuilder.c(1);
            flatBufferBuilder.a(0, builder2.f13306a);
            flatBufferBuilder.d(flatBufferBuilder.d());
            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
            wrap.position(0);
            return OperationResult.a(new PaymentAccountEnabledStatusModel(new MutableFlatBuffer(wrap, null, null, true, null)));
        }
        OperationResult a = blueServiceHandler.a(operationParams);
        this.f14502l.a(DbPaymentsProperties.f12854j, TriState.valueOf(((PaymentAccountEnabledStatusModel) a.h()).m13688a()));
        return a;
    }
}
