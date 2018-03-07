package com.facebook.adspayments.protocol;

import com.facebook.adspayments.utils.AdsPaymentsPreconditions;
import com.facebook.common.util.TriState;
import com.facebook.http.protocol.ApiRequest;
import com.facebook.http.protocol.ApiRequestBuilder;
import com.facebook.http.protocol.ApiResponseType;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.payments.common.PaymentNetworkOperationHelper;
import com.facebook.payments.common.PaymentsNetworkOperation;
import com.facebook.payments.common.UnrestrictedResultPaymentsNetworkOperation;
import com.facebook.payments.model.PaymentItemType;
import com.facebook.payments.util.PaymentsTokenProxyApiRequestBuilder;
import com.google.common.base.Predicates;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: formatted_high_fare */
public class AddPaymentCardMethod extends PaymentsNetworkOperation<AddPaymentCardParams, AddPaymentCardResult> {
    private final Provider<TriState> f23684c;

    public static AddPaymentCardMethod m25699b(InjectorLike injectorLike) {
        return new AddPaymentCardMethod(PaymentNetworkOperationHelper.a(injectorLike), IdBasedProvider.a(injectorLike, 627));
    }

    public final ApiRequest m25701a(Object obj) {
        ApiRequestBuilder a;
        AddPaymentCardParams addPaymentCardParams = (AddPaymentCardParams) obj;
        List f = addPaymentCardParams.m25703f();
        UnrestrictedResultPaymentsNetworkOperation.a(f, "creditCardNumber", addPaymentCardParams.f23691a);
        if (addPaymentCardParams.f23685a == PaymentItemType.INVOICE && ((TriState) this.f23684c.get()).asBoolean(false)) {
            int i = 1;
        } else {
            boolean z = false;
        }
        if (i != 0) {
            a = PaymentsTokenProxyApiRequestBuilder.a("/act_%s/creditcards", new Object[]{m25700b(addPaymentCardParams)});
        } else {
            a = PaymentsTokenProxyApiRequestBuilder.a("/%d/creditcards", new Object[]{Long.valueOf(Long.parseLong(addPaymentCardParams.f23692b))});
        }
        if (i != 0) {
            UnrestrictedResultPaymentsNetworkOperation.a(f, "should_support_tricky_bin", Boolean.valueOf(addPaymentCardParams.f23694d));
        } else {
            UnrestrictedResultPaymentsNetworkOperation.a(f, "account_id", m25700b(addPaymentCardParams));
        }
        a.b = "add_credit_cards";
        a = a;
        a.c = "POST";
        a = a;
        a.g = f;
        a = a;
        a.k = ApiResponseType.JSONPARSER;
        return a.C();
    }

    @Inject
    public AddPaymentCardMethod(PaymentNetworkOperationHelper paymentNetworkOperationHelper, Provider<TriState> provider) {
        super(paymentNetworkOperationHelper, AddPaymentCardResult.class);
        this.f23684c = provider;
    }

    private static String m25700b(AddPaymentCardParams addPaymentCardParams) {
        return (String) AdsPaymentsPreconditions.m25753a(addPaymentCardParams.f23693c, Predicates.not(Predicates.equalTo("0")), "AccountId can NOT be 0 for Ads invoice", new Object[0]);
    }

    protected final String m25702a() {
        return "add_payments_card";
    }
}
