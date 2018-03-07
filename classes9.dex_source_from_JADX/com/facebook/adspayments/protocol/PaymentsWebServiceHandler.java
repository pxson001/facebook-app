package com.facebook.adspayments.protocol;

import com.facebook.fbservice.service.BlueServiceHandler;
import com.facebook.fbservice.service.OperationParams;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.http.protocol.ApiMethodRunnerImpl;
import com.facebook.inject.InjectorLike;
import com.facebook.payments.common.PaymentNetworkOperationHandler;
import com.facebook.payments.common.UnrestrictedResultPaymentsNetworkOperation;
import com.facebook.tools.dextr.runtime.detour.TracerDetour;
import javax.inject.Inject;

/* compiled from: USER_CANCELLED */
public class PaymentsWebServiceHandler extends PaymentNetworkOperationHandler {
    public static PaymentsWebServiceHandler m25738b(InjectorLike injectorLike) {
        return new PaymentsWebServiceHandler(ApiMethodRunnerImpl.a(injectorLike), AddPaymentCardMethod.m25699b(injectorLike), EditPaymentCardMethod.m25709b(injectorLike), VerifyBrazilianTaxIdMethod.m25749b(injectorLike), GetBrazilianAddressDetailsMethod.m25718b(injectorLike), GetAccountDetailsMethod.m25712b(injectorLike), PostBusinessAddressMethod.m25740b(injectorLike), GetCscTokenMethod.m25723b(injectorLike), PrepayFundMethod.m25745b(injectorLike), GetPrepayDetailsMethod.m25728b(injectorLike));
    }

    @Inject
    public PaymentsWebServiceHandler(ApiMethodRunnerImpl apiMethodRunnerImpl, AddPaymentCardMethod addPaymentCardMethod, EditPaymentCardMethod editPaymentCardMethod, VerifyBrazilianTaxIdMethod verifyBrazilianTaxIdMethod, GetBrazilianAddressDetailsMethod getBrazilianAddressDetailsMethod, GetAccountDetailsMethod getAccountDetailsMethod, PostBusinessAddressMethod postBusinessAddressMethod, GetCscTokenMethod getCscTokenMethod, PrepayFundMethod prepayFundMethod, GetPrepayDetailsMethod getPrepayDetailsMethod) {
        super(apiMethodRunnerImpl, new UnrestrictedResultPaymentsNetworkOperation[]{addPaymentCardMethod, editPaymentCardMethod, verifyBrazilianTaxIdMethod, getBrazilianAddressDetailsMethod, getAccountDetailsMethod, postBusinessAddressMethod, getCscTokenMethod, prepayFundMethod, getAccountDetailsMethod, getPrepayDetailsMethod});
    }

    public final OperationResult m25739a(OperationParams operationParams, BlueServiceHandler blueServiceHandler) {
        TracerDetour.a("PaymentsWebServiceHandler", 476413855);
        try {
            OperationResult a = super.a(operationParams, blueServiceHandler);
            return a;
        } finally {
            TracerDetour.a(517609451);
        }
    }
}
