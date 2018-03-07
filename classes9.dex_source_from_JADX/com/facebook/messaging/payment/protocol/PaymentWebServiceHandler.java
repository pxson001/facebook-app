package com.facebook.messaging.payment.protocol;

import com.facebook.fbservice.service.BlueServiceHandler;
import com.facebook.fbservice.service.OperationParams;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.http.protocol.ApiMethodRunner;
import com.facebook.http.protocol.ApiMethodRunnerImpl;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.payment.model.PaymentCard;
import com.facebook.messaging.payment.model.PaymentTransaction;
import com.facebook.messaging.payment.model.TransferStatus;
import com.facebook.messaging.payment.model.graphql.PaymentGraphQLModels.PaymentAccountEnabledStatusModel;
import com.facebook.messaging.payment.model.graphql.PaymentGraphQLModels.PaymentRequestModel;
import com.facebook.messaging.payment.protocol.cards.AddPaymentCardMethod;
import com.facebook.messaging.payment.protocol.cards.DeletePaymentCardMethod;
import com.facebook.messaging.payment.protocol.cards.EditPaymentCardMethod;
import com.facebook.messaging.payment.protocol.cards.FetchPaymentCardsMethod;
import com.facebook.messaging.payment.protocol.cards.SetPrimaryCardMethod;
import com.facebook.messaging.payment.protocol.cards.ValidatePaymentCardBinMethod;
import com.facebook.messaging.payment.protocol.eligibility.FetchP2PSendEligibilityMethod;
import com.facebook.messaging.payment.protocol.eligibility.FetchPaymentAccountEnabledStatusMethod;
import com.facebook.messaging.payment.protocol.moneypenny.MoneyPennyPlaceOrderMethod;
import com.facebook.messaging.payment.protocol.pay.SendPaymentMethod;
import com.facebook.messaging.payment.protocol.request.CancelPaymentRequestMethod;
import com.facebook.messaging.payment.protocol.request.CreatePaymentRequestMethod;
import com.facebook.messaging.payment.protocol.request.DeclinePaymentRequestMethod;
import com.facebook.messaging.payment.protocol.request.FetchPaymentRequestMethod;
import com.facebook.messaging.payment.protocol.request.FetchPaymentRequestsMethod;
import com.facebook.messaging.payment.protocol.shipping.AddShippingAddressMethod;
import com.facebook.messaging.payment.protocol.shipping.EditShippingAddressMethod;
import com.facebook.messaging.payment.protocol.shipping.FetchShippingAddressesMethod;
import com.facebook.messaging.payment.protocol.theme.FetchThemeListMethod;
import com.facebook.messaging.payment.protocol.transactions.CancelPaymentTransactionMethod;
import com.facebook.messaging.payment.protocol.transactions.DeclinePaymentMethod;
import com.facebook.messaging.payment.protocol.transactions.FetchMoreTransactionsMethod;
import com.facebook.messaging.payment.protocol.transactions.FetchPaymentPlatformContextMethod;
import com.facebook.messaging.payment.protocol.transactions.FetchPaymentPlatformContextsMethod;
import com.facebook.messaging.payment.protocol.transactions.FetchPaymentTransactionMethod;
import com.facebook.messaging.payment.protocol.transactions.FetchTransactionListMethod;
import com.facebook.messaging.payment.protocol.transactions.FetchTransactionPaymentCardMethod;
import com.facebook.messaging.payment.protocol.transactions.MutatePaymentPlatformContextMethod;
import com.facebook.messaging.payment.protocol.transactions.SendCampaignPaymentMessageMethod;
import com.facebook.messaging.payment.protocol.transactions.SendPaymentMessageMethod;
import com.facebook.messaging.payment.protocol.userinfo.FetchPrimaryEmailAddressMethod;
import com.facebook.messaging.payment.protocol.verification.VerifyPaymentMethod;
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
import com.facebook.messaging.payment.service.model.request.CancelPaymentRequestParams;
import com.facebook.messaging.payment.service.model.request.CreatePaymentRequestParams;
import com.facebook.messaging.payment.service.model.request.DeclinePaymentRequestParams;
import com.facebook.messaging.payment.service.model.request.FetchPaymentRequestParams;
import com.facebook.messaging.payment.service.model.request.FetchPaymentRequestsParams;
import com.facebook.messaging.payment.service.model.request.FetchPaymentRequestsResult;
import com.facebook.messaging.payment.service.model.shipping.AddShippingAddressParams;
import com.facebook.messaging.payment.service.model.shipping.EditShippingAddressParams;
import com.facebook.messaging.payment.service.model.transactions.CancelPaymentTransactionParams;
import com.facebook.messaging.payment.service.model.transactions.DeclinePaymentParams;
import com.facebook.messaging.payment.service.model.transactions.FetchMoreTransactionsParams;
import com.facebook.messaging.payment.service.model.transactions.FetchMoreTransactionsResult;
import com.facebook.messaging.payment.service.model.transactions.FetchPaymentTransactionParams;
import com.facebook.messaging.payment.service.model.transactions.FetchTransactionListParams;
import com.facebook.messaging.payment.service.model.transactions.FetchTransactionListResult;
import com.facebook.messaging.payment.service.model.transactions.FetchTransactionPaymentCardParams;
import com.facebook.messaging.payment.service.model.transactions.MutatePaymentPlatformContextParams;
import com.facebook.messaging.payment.service.model.transactions.SendCampaignPaymentMessageParams;
import com.facebook.messaging.payment.service.model.transactions.SendCampaignPaymentMessageResult;
import com.facebook.messaging.payment.service.model.transactions.SendPaymentMessageParams;
import com.facebook.messaging.payment.service.model.transactions.SendPaymentMessageResult;
import com.facebook.messaging.payment.service.model.verification.VerifyPaymentParams;
import com.facebook.messaging.payment.service.model.verification.VerifyPaymentResult;
import java.util.ArrayList;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: formatted_minimum_fare */
public class PaymentWebServiceHandler extends AbstractBlueServiceHandlerFilter {
    private final CancelPaymentRequestMethod f14539A;
    private final CancelPaymentTransactionMethod f14540B;
    private final MutatePaymentPlatformContextMethod f14541C;
    private final AddShippingAddressMethod f14542D;
    private final EditShippingAddressMethod f14543E;
    private final FetchShippingAddressesMethod f14544F;
    private final FetchThemeListMethod f14545G;
    private final FetchPaymentAccountEnabledStatusMethod f14546H;
    private final PaymentsBroadcaster f14547I;
    private final ApiMethodRunnerImpl f14548a;
    private final Provider<Boolean> f14549b;
    private final FetchTransactionPaymentCardMethod f14550c;
    private final FetchPaymentCardsMethod f14551d;
    private final FetchPaymentTransactionMethod f14552e;
    private final DeclinePaymentMethod f14553f;
    private final AddPaymentCardMethod f14554g;
    private final EditPaymentCardMethod f14555h;
    private final DeletePaymentCardMethod f14556i;
    private final SetPrimaryCardMethod f14557j;
    private final FetchP2PSendEligibilityMethod f14558k;
    private final FetchPrimaryEmailAddressMethod f14559l;
    private final FetchTransactionListMethod f14560m;
    private final FetchMoreTransactionsMethod f14561n;
    private final SendCampaignPaymentMessageMethod f14562o;
    private final ValidatePaymentCardBinMethod f14563p;
    private final MoneyPennyPlaceOrderMethod f14564q;
    private final SendPaymentMessageMethod f14565r;
    private final SendPaymentMethod f14566s;
    private final VerifyPaymentMethod f14567t;
    private final FetchPaymentPlatformContextsMethod f14568u;
    private final FetchPaymentPlatformContextMethod f14569v;
    private final CreatePaymentRequestMethod f14570w;
    private final FetchPaymentRequestMethod f14571x;
    private final FetchPaymentRequestsMethod f14572y;
    private final DeclinePaymentRequestMethod f14573z;

    public static PaymentWebServiceHandler m14970b(InjectorLike injectorLike) {
        return new PaymentWebServiceHandler(ApiMethodRunnerImpl.a(injectorLike), IdBasedProvider.a(injectorLike, 4184), FetchTransactionPaymentCardMethod.m15135a(injectorLike), FetchPaymentCardsMethod.m15026a(injectorLike), FetchPaymentTransactionMethod.m15123a(injectorLike), DeclinePaymentMethod.m15104a(injectorLike), AddPaymentCardMethod.m15016a(injectorLike), EditPaymentCardMethod.m15023a(injectorLike), DeletePaymentCardMethod.m15020a(injectorLike), SetPrimaryCardMethod.m15030a(injectorLike), FetchP2PSendEligibilityMethod.m15049a(injectorLike), FetchPrimaryEmailAddressMethod.m15150a(injectorLike), FetchTransactionListMethod.m15128a(injectorLike), FetchMoreTransactionsMethod.m15107a(injectorLike), SendCampaignPaymentMessageMethod.m15143a(injectorLike), ValidatePaymentCardBinMethod.m15033a(injectorLike), MoneyPennyPlaceOrderMethod.m15057a(injectorLike), SendPaymentMessageMethod.m15147a(injectorLike), SendPaymentMethod.m15060a(injectorLike), VerifyPaymentMethod.m15154a(injectorLike), FetchPaymentPlatformContextsMethod.m15118a(injectorLike), FetchPaymentPlatformContextMethod.m15113a(injectorLike), CreatePaymentRequestMethod.m15066a(injectorLike), FetchPaymentRequestMethod.m15072a(injectorLike), FetchPaymentRequestsMethod.m15077a(injectorLike), DeclinePaymentRequestMethod.m15069a(injectorLike), CancelPaymentRequestMethod.m15063a(injectorLike), CancelPaymentTransactionMethod.m15101a(injectorLike), MutatePaymentPlatformContextMethod.m15138a(injectorLike), AddShippingAddressMethod.m15081a(injectorLike), EditShippingAddressMethod.m15084a(injectorLike), FetchShippingAddressesMethod.m15087a(injectorLike), FetchThemeListMethod.m15096a(injectorLike), FetchPaymentAccountEnabledStatusMethod.m15052a(injectorLike), PaymentsBroadcaster.m15003a(injectorLike));
    }

    protected final OperationResult mo577A(OperationParams operationParams, BlueServiceHandler blueServiceHandler) {
        this.f14548a.a(this.f14541C, (MutatePaymentPlatformContextParams) operationParams.c.getParcelable("mutatePaymentPlatformContextParams"));
        return OperationResult.a;
    }

    protected final OperationResult mo578B(OperationParams operationParams, BlueServiceHandler blueServiceHandler) {
        return OperationResult.a((String) this.f14548a.a(this.f14542D, (AddShippingAddressParams) operationParams.c.getParcelable("addShippingAddressParams")));
    }

    protected final OperationResult mo579C(OperationParams operationParams, BlueServiceHandler blueServiceHandler) {
        this.f14548a.a(this.f14543E, (EditShippingAddressParams) operationParams.c.getParcelable("editShippingAddressParams"));
        return OperationResult.a;
    }

    protected final OperationResult mo581G(OperationParams operationParams, BlueServiceHandler blueServiceHandler) {
        return OperationResult.a((SendPaymentResult) this.f14548a.a(this.f14566s, (SendPaymentParams) operationParams.c.getParcelable("SendPaymentParams")));
    }

    protected final OperationResult mo572c(OperationParams operationParams, BlueServiceHandler blueServiceHandler) {
        return OperationResult.a((PaymentCard) this.f14548a.a(this.f14550c, (FetchTransactionPaymentCardParams) operationParams.c.getParcelable("fetchTransactionPaymentCardParams")));
    }

    protected final OperationResult mo565d(OperationParams operationParams, BlueServiceHandler blueServiceHandler) {
        return OperationResult.a((PaymentTransaction) this.f14548a.a(this.f14552e, (FetchPaymentTransactionParams) operationParams.c.getParcelable("fetchPaymentTransactionParams")));
    }

    protected final OperationResult mo582e(OperationParams operationParams, BlueServiceHandler blueServiceHandler) {
        DeclinePaymentParams declinePaymentParams = (DeclinePaymentParams) operationParams.c.getParcelable(DeclinePaymentParams.f14734a);
        this.f14548a.a(this.f14553f, declinePaymentParams);
        if (!((Boolean) this.f14549b.get()).booleanValue()) {
            this.f14547I.m15007a(TransferStatus.R_CANCELED_DECLINED, Long.parseLong(declinePaymentParams.f14736c));
        }
        return OperationResult.a;
    }

    protected final OperationResult mo583f(OperationParams operationParams, BlueServiceHandler blueServiceHandler) {
        return OperationResult.a((AddPaymentCardResult) this.f14548a.a(this.f14554g, (AddPaymentCardParams) operationParams.c.getParcelable("addPaymentCardParams")));
    }

    protected final OperationResult mo584g(OperationParams operationParams, BlueServiceHandler blueServiceHandler) {
        return OperationResult.a((String) this.f14548a.a(this.f14555h, (EditPaymentCardParams) operationParams.c.getParcelable("editPaymentCardParams")));
    }

    protected final OperationResult mo573h(OperationParams operationParams, BlueServiceHandler blueServiceHandler) {
        this.f14548a.a(this.f14556i, (DeletePaymentCardParams) operationParams.c.getParcelable(DeletePaymentCardParams.f14626a));
        return OperationResult.a;
    }

    protected final OperationResult mo574i(OperationParams operationParams, BlueServiceHandler blueServiceHandler) {
        this.f14548a.a(this.f14557j, (SetPrimaryCardParams) operationParams.c.getParcelable(SetPrimaryCardParams.f14653a));
        this.f14547I.m15010b();
        return OperationResult.a;
    }

    protected final OperationResult mo566j(OperationParams operationParams, BlueServiceHandler blueServiceHandler) {
        return OperationResult.a((FetchP2PSendEligibilityResult) this.f14548a.a(this.f14558k, (FetchP2PSendEligibilityParams) operationParams.c.getParcelable(FetchP2PSendEligibilityParams.f14660a)));
    }

    protected final OperationResult mo575l(OperationParams operationParams, BlueServiceHandler blueServiceHandler) {
        return OperationResult.a((FetchTransactionListResult) this.f14548a.a(this.f14560m, (FetchTransactionListParams) operationParams.c.getParcelable("fetchTransactionListParams")));
    }

    protected final OperationResult mo576m(OperationParams operationParams, BlueServiceHandler blueServiceHandler) {
        return OperationResult.a((FetchMoreTransactionsResult) this.f14548a.a(this.f14561n, (FetchMoreTransactionsParams) operationParams.c.getParcelable("fetchMoreTransactionsParams")));
    }

    protected final OperationResult mo586n(OperationParams operationParams, BlueServiceHandler blueServiceHandler) {
        if (operationParams.c == null) {
            return OperationResult.a(new NullPointerException("null params bundle received"));
        }
        return OperationResult.a((SendCampaignPaymentMessageResult) this.f14548a.a(this.f14562o, (SendCampaignPaymentMessageParams) operationParams.c.getParcelable(SendCampaignPaymentMessageParams.f14753a)));
    }

    protected final OperationResult mo587o(OperationParams operationParams, BlueServiceHandler blueServiceHandler) {
        return OperationResult.a((ValidatePaymentCardBinResult) this.f14548a.a(this.f14563p, (ValidatePaymentCardBinParams) operationParams.c.getParcelable(ValidatePaymentCardBinParams.f14657a)));
    }

    protected final OperationResult mo588p(OperationParams operationParams, BlueServiceHandler blueServiceHandler) {
        return OperationResult.a((MoneyPennyPlaceOrderResult) this.f14548a.a(this.f14564q, (MoneyPennyPlaceOrderParams) operationParams.c.getParcelable(MoneyPennyPlaceOrderParams.f14664a)));
    }

    protected final OperationResult mo589q(OperationParams operationParams, BlueServiceHandler blueServiceHandler) {
        return OperationResult.a((SendPaymentMessageResult) this.f14548a.a(this.f14565r, (SendPaymentMessageParams) operationParams.c.getParcelable(SendPaymentMessageParams.f14759a)));
    }

    protected final OperationResult mo590r(OperationParams operationParams, BlueServiceHandler blueServiceHandler) {
        return OperationResult.a((VerifyPaymentResult) this.f14548a.a(this.f14567t, (VerifyPaymentParams) operationParams.c.getParcelable(VerifyPaymentParams.f14789a)));
    }

    protected final OperationResult mo591t(OperationParams operationParams, BlueServiceHandler blueServiceHandler) {
        return OperationResult.a(this.f14548a.a(this.f14569v, operationParams.c.getString("platform_context_id")));
    }

    protected final OperationResult mo592u(OperationParams operationParams, BlueServiceHandler blueServiceHandler) {
        return OperationResult.a((String) this.f14548a.a(this.f14570w, (CreatePaymentRequestParams) operationParams.c.getParcelable(CreatePaymentRequestParams.f14706a)));
    }

    protected final OperationResult mo568v(OperationParams operationParams, BlueServiceHandler blueServiceHandler) {
        if (operationParams.c == null) {
            return OperationResult.a(new NullPointerException("Null params provided"));
        }
        return OperationResult.a((PaymentRequestModel) this.f14548a.a(this.f14571x, (FetchPaymentRequestParams) operationParams.c.getParcelable(FetchPaymentRequestParams.f14716a)));
    }

    protected final OperationResult mo569w(OperationParams operationParams, BlueServiceHandler blueServiceHandler) {
        if (operationParams.c == null) {
            return OperationResult.a(new NullPointerException("Null params provided"));
        }
        return OperationResult.a((FetchPaymentRequestsResult) this.f14548a.a(this.f14572y, (FetchPaymentRequestsParams) operationParams.c.getParcelable(FetchPaymentRequestsParams.f14718a)));
    }

    protected final OperationResult mo593x(OperationParams operationParams, BlueServiceHandler blueServiceHandler) {
        this.f14548a.a(this.f14573z, (DeclinePaymentRequestParams) operationParams.c.getParcelable(DeclinePaymentRequestParams.f14714a));
        return OperationResult.a;
    }

    protected final OperationResult mo594y(OperationParams operationParams, BlueServiceHandler blueServiceHandler) {
        this.f14548a.a(this.f14539A, (CancelPaymentRequestParams) operationParams.c.getParcelable(CancelPaymentRequestParams.f14704a));
        return OperationResult.a;
    }

    protected final OperationResult mo595z(OperationParams operationParams, BlueServiceHandler blueServiceHandler) {
        this.f14548a.a(this.f14540B, (CancelPaymentTransactionParams) operationParams.c.getParcelable(CancelPaymentTransactionParams.f14732a));
        return OperationResult.a;
    }

    @Inject
    public PaymentWebServiceHandler(ApiMethodRunner apiMethodRunner, Provider<Boolean> provider, FetchTransactionPaymentCardMethod fetchTransactionPaymentCardMethod, FetchPaymentCardsMethod fetchPaymentCardsMethod, FetchPaymentTransactionMethod fetchPaymentTransactionMethod, DeclinePaymentMethod declinePaymentMethod, AddPaymentCardMethod addPaymentCardMethod, EditPaymentCardMethod editPaymentCardMethod, DeletePaymentCardMethod deletePaymentCardMethod, SetPrimaryCardMethod setPrimaryCardMethod, FetchP2PSendEligibilityMethod fetchP2PSendEligibilityMethod, FetchPrimaryEmailAddressMethod fetchPrimaryEmailAddressMethod, FetchTransactionListMethod fetchTransactionListMethod, FetchMoreTransactionsMethod fetchMoreTransactionsMethod, SendCampaignPaymentMessageMethod sendCampaignPaymentMessageMethod, ValidatePaymentCardBinMethod validatePaymentCardBinMethod, MoneyPennyPlaceOrderMethod moneyPennyPlaceOrderMethod, SendPaymentMessageMethod sendPaymentMessageMethod, SendPaymentMethod sendPaymentMethod, VerifyPaymentMethod verifyPaymentMethod, FetchPaymentPlatformContextsMethod fetchPaymentPlatformContextsMethod, FetchPaymentPlatformContextMethod fetchPaymentPlatformContextMethod, CreatePaymentRequestMethod createPaymentRequestMethod, FetchPaymentRequestMethod fetchPaymentRequestMethod, FetchPaymentRequestsMethod fetchPaymentRequestsMethod, DeclinePaymentRequestMethod declinePaymentRequestMethod, CancelPaymentRequestMethod cancelPaymentRequestMethod, CancelPaymentTransactionMethod cancelPaymentTransactionMethod, MutatePaymentPlatformContextMethod mutatePaymentPlatformContextMethod, AddShippingAddressMethod addShippingAddressMethod, EditShippingAddressMethod editShippingAddressMethod, FetchShippingAddressesMethod fetchShippingAddressesMethod, FetchThemeListMethod fetchThemeListMethod, FetchPaymentAccountEnabledStatusMethod fetchPaymentAccountEnabledStatusMethod, PaymentsBroadcaster paymentsBroadcaster) {
        super("PaymentWebServiceHandler");
        this.f14548a = apiMethodRunner;
        this.f14549b = provider;
        this.f14550c = fetchTransactionPaymentCardMethod;
        this.f14551d = fetchPaymentCardsMethod;
        this.f14552e = fetchPaymentTransactionMethod;
        this.f14553f = declinePaymentMethod;
        this.f14554g = addPaymentCardMethod;
        this.f14555h = editPaymentCardMethod;
        this.f14556i = deletePaymentCardMethod;
        this.f14557j = setPrimaryCardMethod;
        this.f14558k = fetchP2PSendEligibilityMethod;
        this.f14559l = fetchPrimaryEmailAddressMethod;
        this.f14560m = fetchTransactionListMethod;
        this.f14561n = fetchMoreTransactionsMethod;
        this.f14562o = sendCampaignPaymentMessageMethod;
        this.f14563p = validatePaymentCardBinMethod;
        this.f14564q = moneyPennyPlaceOrderMethod;
        this.f14565r = sendPaymentMessageMethod;
        this.f14566s = sendPaymentMethod;
        this.f14567t = verifyPaymentMethod;
        this.f14568u = fetchPaymentPlatformContextsMethod;
        this.f14569v = fetchPaymentPlatformContextMethod;
        this.f14570w = createPaymentRequestMethod;
        this.f14571x = fetchPaymentRequestMethod;
        this.f14572y = fetchPaymentRequestsMethod;
        this.f14573z = declinePaymentRequestMethod;
        this.f14539A = cancelPaymentRequestMethod;
        this.f14540B = cancelPaymentTransactionMethod;
        this.f14541C = mutatePaymentPlatformContextMethod;
        this.f14542D = addShippingAddressMethod;
        this.f14543E = editShippingAddressMethod;
        this.f14544F = fetchShippingAddressesMethod;
        this.f14545G = fetchThemeListMethod;
        this.f14546H = fetchPaymentAccountEnabledStatusMethod;
        this.f14547I = paymentsBroadcaster;
    }

    protected final OperationResult mo571b(OperationParams operationParams, BlueServiceHandler blueServiceHandler) {
        return OperationResult.a((FetchPaymentCardsResult) this.f14548a.a(this.f14551d, null));
    }

    protected final OperationResult mo585k(OperationParams operationParams, BlueServiceHandler blueServiceHandler) {
        return OperationResult.a((String) this.f14548a.a(this.f14559l, null));
    }

    protected final OperationResult mo567s(OperationParams operationParams, BlueServiceHandler blueServiceHandler) {
        return OperationResult.a((ArrayList) this.f14548a.a(this.f14568u, null));
    }

    protected final OperationResult mo580D(OperationParams operationParams, BlueServiceHandler blueServiceHandler) {
        return OperationResult.a((ArrayList) this.f14548a.a(this.f14544F, null));
    }

    protected final OperationResult mo564E(OperationParams operationParams, BlueServiceHandler blueServiceHandler) {
        return OperationResult.a((ArrayList) this.f14548a.a(this.f14545G, null));
    }

    protected final OperationResult mo570F(OperationParams operationParams, BlueServiceHandler blueServiceHandler) {
        return OperationResult.a((PaymentAccountEnabledStatusModel) this.f14548a.a(this.f14546H, null));
    }
}
