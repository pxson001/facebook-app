package com.facebook.messaging.payment.protocol;

import com.facebook.common.util.TriState;
import com.facebook.fbservice.service.BlueServiceHandler;
import com.facebook.fbservice.service.DataFreshnessParam;
import com.facebook.fbservice.service.OperationParams;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.payment.cache.PaymentPlatformContextsCache;
import com.facebook.messaging.payment.cache.PaymentRecipientEligibilityCache;
import com.facebook.messaging.payment.cache.PaymentRequestCache;
import com.facebook.messaging.payment.cache.PaymentThemeListCache;
import com.facebook.messaging.payment.cache.PaymentTransactionCache;
import com.facebook.messaging.payment.model.PaymentTransaction;
import com.facebook.messaging.payment.model.graphql.PaymentGraphQLModels.PaymentRequestModel;
import com.facebook.messaging.payment.service.model.eligibility.FetchP2PSendEligibilityParams;
import com.facebook.messaging.payment.service.model.eligibility.FetchP2PSendEligibilityResult;
import com.facebook.messaging.payment.service.model.request.FetchPaymentRequestsParams;
import com.facebook.messaging.payment.service.model.request.FetchPaymentRequestsParams.QueryType;
import com.facebook.messaging.payment.service.model.request.FetchPaymentRequestsResult;
import com.facebook.messaging.payment.service.model.transactions.FetchPaymentTransactionParams;
import java.util.ArrayList;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: fref */
public class PaymentCacheServiceHandler extends AbstractBlueServiceHandlerFilter {
    private final Provider<Boolean> f14484a;
    private final PaymentTransactionCache f14485b;
    private final PaymentPlatformContextsCache f14486c;
    private final PaymentRequestCache f14487d;
    private final PaymentThemeListCache f14488e;
    private final PaymentsBroadcaster f14489f;
    private final PaymentRecipientEligibilityCache f14490g;

    public static PaymentCacheServiceHandler m14916b(InjectorLike injectorLike) {
        return new PaymentCacheServiceHandler(IdBasedProvider.a(injectorLike, 4184), PaymentTransactionCache.m13184a(injectorLike), PaymentPlatformContextsCache.m13170a(injectorLike), PaymentRequestCache.a(injectorLike), PaymentThemeListCache.m13179a(injectorLike), PaymentsBroadcaster.m15003a(injectorLike), PaymentRecipientEligibilityCache.m13174a(injectorLike));
    }

    @Inject
    public PaymentCacheServiceHandler(Provider<Boolean> provider, PaymentTransactionCache paymentTransactionCache, PaymentPlatformContextsCache paymentPlatformContextsCache, PaymentRequestCache paymentRequestCache, PaymentThemeListCache paymentThemeListCache, PaymentsBroadcaster paymentsBroadcaster, PaymentRecipientEligibilityCache paymentRecipientEligibilityCache) {
        super("PaymentCacheServiceHandler");
        this.f14484a = provider;
        this.f14485b = paymentTransactionCache;
        this.f14486c = paymentPlatformContextsCache;
        this.f14487d = paymentRequestCache;
        this.f14488e = paymentThemeListCache;
        this.f14489f = paymentsBroadcaster;
        this.f14490g = paymentRecipientEligibilityCache;
    }

    protected final OperationResult mo566j(OperationParams operationParams, BlueServiceHandler blueServiceHandler) {
        FetchP2PSendEligibilityParams fetchP2PSendEligibilityParams = (FetchP2PSendEligibilityParams) operationParams.c.getParcelable(FetchP2PSendEligibilityParams.f14660a);
        if (fetchP2PSendEligibilityParams.f14661b == DataFreshnessParam.PREFER_CACHE_IF_UP_TO_DATE) {
            TriState a = this.f14490g.m13177a(fetchP2PSendEligibilityParams.f14662c);
            if (a.isSet()) {
                return OperationResult.a(new FetchP2PSendEligibilityResult(Boolean.valueOf(a.asBoolean())));
            }
        }
        OperationResult a2 = blueServiceHandler.a(operationParams);
        this.f14490g.m13178a(fetchP2PSendEligibilityParams.f14662c, ((FetchP2PSendEligibilityResult) a2.h()).m15170a());
        return a2;
    }

    protected final OperationResult mo569w(OperationParams operationParams, BlueServiceHandler blueServiceHandler) {
        FetchPaymentRequestsParams fetchPaymentRequestsParams = (FetchPaymentRequestsParams) operationParams.c.getParcelable(FetchPaymentRequestsParams.f14718a);
        if (((Boolean) this.f14484a.get()).booleanValue() && fetchPaymentRequestsParams.f14719b == QueryType.INCOMING && this.f14487d.a() != null) {
            return OperationResult.a(new FetchPaymentRequestsResult(new ArrayList(this.f14487d.a())));
        }
        OperationResult a = blueServiceHandler.a(operationParams);
        if (((Boolean) this.f14484a.get()).booleanValue() && fetchPaymentRequestsParams.f14719b == QueryType.INCOMING) {
            this.f14487d.a(((FetchPaymentRequestsResult) a.h()).m15195a());
            this.f14489f.m15015g();
        }
        return a;
    }

    protected final OperationResult mo565d(OperationParams operationParams, BlueServiceHandler blueServiceHandler) {
        if (((Boolean) this.f14484a.get()).booleanValue()) {
            FetchPaymentTransactionParams fetchPaymentTransactionParams = (FetchPaymentTransactionParams) operationParams.c.getParcelable("fetchPaymentTransactionParams");
            PaymentTransaction a = this.f14485b.m13187a(fetchPaymentTransactionParams.f14742a);
            if (a != null && (fetchPaymentTransactionParams.f14743b == DataFreshnessParam.STALE_DATA_OKAY || a.f13234g.isTerminalStatus)) {
                return OperationResult.a(a);
            }
        }
        OperationResult a2 = blueServiceHandler.a(operationParams);
        PaymentTransaction paymentTransaction = (PaymentTransaction) a2.h();
        this.f14485b.m13190a(paymentTransaction);
        this.f14489f.m15007a(paymentTransaction.f13234g, Long.parseLong(paymentTransaction.f13229b));
        return a2;
    }

    protected final OperationResult mo568v(OperationParams operationParams, BlueServiceHandler blueServiceHandler) {
        OperationResult a = blueServiceHandler.a(operationParams);
        PaymentRequestModel paymentRequestModel = (PaymentRequestModel) a.h();
        this.f14487d.a(paymentRequestModel);
        this.f14489f.m15008a(paymentRequestModel.lw_());
        return a;
    }

    protected final OperationResult mo567s(OperationParams operationParams, BlueServiceHandler blueServiceHandler) {
        OperationResult a = blueServiceHandler.a(operationParams);
        this.f14486c.m13173a(a.i());
        this.f14489f.m15014f();
        return a;
    }

    protected final OperationResult mo564E(OperationParams operationParams, BlueServiceHandler blueServiceHandler) {
        if (this.f14488e.m13182a() != null) {
            return OperationResult.a(this.f14488e.m13182a());
        }
        OperationResult a = blueServiceHandler.a(operationParams);
        this.f14488e.m13183a(a.i());
        return a;
    }
}
