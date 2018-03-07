package com.facebook.payments.paymentmethods.cardform.protocol.method;

import com.facebook.http.protocol.ApiRequest;
import com.facebook.http.protocol.ApiRequestBuilder;
import com.facebook.http.protocol.ApiResponseType;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.payments.common.PaymentNetworkOperationHelper;
import com.facebook.payments.common.PaymentsNetworkOperation;
import com.facebook.payments.paymentmethods.cardform.protocol.model.AddCreditCardParams;
import com.facebook.payments.paymentmethods.cardform.protocol.model.AddCreditCardResult;
import com.facebook.payments.util.PaymentsTokenProxyApiRequestBuilder;
import com.facebook.user.model.User;
import com.google.common.base.Preconditions;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: swipe_down */
public class AddCreditCardMethod extends PaymentsNetworkOperation<AddCreditCardParams, AddCreditCardResult> {
    private final Provider<User> f1906c;

    public static AddCreditCardMethod m2111b(InjectorLike injectorLike) {
        return new AddCreditCardMethod(PaymentNetworkOperationHelper.m1921a(injectorLike), IdBasedProvider.a(injectorLike, 3595));
    }

    public final ApiRequest m2112a(Object obj) {
        AddCreditCardParams addCreditCardParams = (AddCreditCardParams) obj;
        Preconditions.checkNotNull(this.f1906c.get());
        ApiRequestBuilder a = PaymentsTokenProxyApiRequestBuilder.m2251a("/%s/creditcards", ((User) this.f1906c.get()).a);
        a.b = "add_credit_card";
        a = a;
        a.c = "POST";
        a = a;
        a.g = addCreditCardParams.mo88a();
        a = a;
        a.k = ApiResponseType.JSONPARSER;
        return a.C();
    }

    @Inject
    public AddCreditCardMethod(PaymentNetworkOperationHelper paymentNetworkOperationHelper, Provider<User> provider) {
        super(paymentNetworkOperationHelper, AddCreditCardResult.class);
        this.f1906c = provider;
    }

    protected final String mo87a() {
        return "add_credit_card";
    }
}
