package com.facebook.messaging.payment.pin.protocol;

import com.facebook.fbservice.service.BlueServiceHandler;
import com.facebook.fbservice.service.OperationParams;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.payment.pin.database.DbFetchPaymentPinHandler;
import com.facebook.messaging.payment.pin.database.DbInsertPaymentPinHandler;
import com.facebook.messaging.payment.pin.model.PaymentPin;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: guide_fragment_tti_marker_extra */
public class PaymentPinDbServiceHandler extends AbstractBlueServiceHandlerFilter {
    private final Provider<Boolean> f13734a;
    private final DbFetchPaymentPinHandler f13735b;
    private final DbInsertPaymentPinHandler f13736c;

    public static PaymentPinDbServiceHandler m14275b(InjectorLike injectorLike) {
        return new PaymentPinDbServiceHandler(IdBasedProvider.a(injectorLike, 4184), DbFetchPaymentPinHandler.m14245a(injectorLike), DbInsertPaymentPinHandler.m14248a(injectorLike));
    }

    @Inject
    public PaymentPinDbServiceHandler(Provider<Boolean> provider, DbFetchPaymentPinHandler dbFetchPaymentPinHandler, DbInsertPaymentPinHandler dbInsertPaymentPinHandler) {
        super("PaymentDbServiceHandler");
        this.f13734a = provider;
        this.f13735b = dbFetchPaymentPinHandler;
        this.f13736c = dbInsertPaymentPinHandler;
    }

    protected final OperationResult mo533c(OperationParams operationParams, BlueServiceHandler blueServiceHandler) {
        if (((Boolean) this.f13734a.get()).booleanValue()) {
            PaymentPin a = this.f13735b.m14247a();
            if (a != null) {
                return OperationResult.a(a);
            }
        }
        OperationResult a2 = blueServiceHandler.a(operationParams);
        this.f13736c.m14251a((PaymentPin) a2.h());
        return a2;
    }

    protected final OperationResult mo532b(OperationParams operationParams, BlueServiceHandler blueServiceHandler) {
        OperationResult a = blueServiceHandler.a(operationParams);
        this.f13736c.m14251a((PaymentPin) a.h());
        return a;
    }

    protected final OperationResult mo534e(OperationParams operationParams, BlueServiceHandler blueServiceHandler) {
        blueServiceHandler.a(operationParams);
        this.f13736c.m14251a(PaymentPin.f13711a);
        return OperationResult.a;
    }
}
