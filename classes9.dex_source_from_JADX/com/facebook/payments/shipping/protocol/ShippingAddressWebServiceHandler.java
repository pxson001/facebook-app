package com.facebook.payments.shipping.protocol;

import com.facebook.http.protocol.ApiMethodRunnerImpl;
import com.facebook.inject.InjectorLike;
import com.facebook.payments.common.PaymentNetworkOperationHandler;
import com.facebook.payments.common.UnrestrictedResultPaymentsNetworkOperation;
import javax.inject.Inject;

/* compiled from: backstage_audience_select_all */
public class ShippingAddressWebServiceHandler extends PaymentNetworkOperationHandler {
    public static ShippingAddressWebServiceHandler m19022b(InjectorLike injectorLike) {
        return new ShippingAddressWebServiceHandler(ApiMethodRunnerImpl.a(injectorLike), GetMailingAddressesMethod.m19007b(injectorLike));
    }

    @Inject
    public ShippingAddressWebServiceHandler(ApiMethodRunnerImpl apiMethodRunnerImpl, GetMailingAddressesMethod getMailingAddressesMethod) {
        super(apiMethodRunnerImpl, new UnrestrictedResultPaymentsNetworkOperation[]{getMailingAddressesMethod});
    }
}
