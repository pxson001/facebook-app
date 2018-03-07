package com.facebook.messaging.payment.pin.protocol;

import com.facebook.common.identifiers.UniqueIdGenerator;
import com.facebook.fbservice.service.BlueServiceHandler;
import com.facebook.fbservice.service.OperationParams;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.http.protocol.ApiMethodRunnerImpl;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.payment.model.graphql.PaymentGraphQLModels.PageInfoModel;
import com.facebook.messaging.payment.model.graphql.PaymentGraphQLModels.PaymentPinStatusModel;
import com.facebook.messaging.payment.pin.model.CheckPaymentPinParams;
import com.facebook.messaging.payment.pin.model.DeletePaymentPinParams;
import com.facebook.messaging.payment.pin.model.FetchPageInfoParams;
import com.facebook.messaging.payment.pin.model.PaymentPin;
import com.facebook.messaging.payment.pin.model.SetPaymentPinParams;
import com.facebook.messaging.payment.pin.model.UpdatePaymentPinStatusParams;
import com.facebook.messaging.payment.pin.protocol.method.CheckPaymentPinMethod;
import com.facebook.messaging.payment.pin.protocol.method.DeletePaymentPinMethod;
import com.facebook.messaging.payment.pin.protocol.method.FetchPageInfoMethod;
import com.facebook.messaging.payment.pin.protocol.method.FetchPaymentPinMethod;
import com.facebook.messaging.payment.pin.protocol.method.FetchPaymentPinStatusMethod;
import com.facebook.messaging.payment.pin.protocol.method.SetPaymentPinMethod;
import com.facebook.messaging.payment.pin.protocol.method.UpdatePaymentPinStatusMethod;
import javax.inject.Inject;

/* compiled from: growthUsersInviteParamsKey */
public class PaymentPinWebServiceHandler extends AbstractBlueServiceHandlerFilter {
    private final ApiMethodRunnerImpl f13742a;
    private final SetPaymentPinMethod f13743b;
    private final FetchPaymentPinMethod f13744c;
    private final UpdatePaymentPinStatusMethod f13745d;
    private final DeletePaymentPinMethod f13746e;
    private final CheckPaymentPinMethod f13747f;
    private final FetchPaymentPinStatusMethod f13748g;
    private final FetchPageInfoMethod f13749h;

    public static PaymentPinWebServiceHandler m14291b(InjectorLike injectorLike) {
        return new PaymentPinWebServiceHandler(ApiMethodRunnerImpl.a(injectorLike), new SetPaymentPinMethod(UniqueIdGenerator.a(injectorLike)), FetchPaymentPinMethod.m14308a(injectorLike), new UpdatePaymentPinStatusMethod(), new DeletePaymentPinMethod(), new CheckPaymentPinMethod(), FetchPaymentPinStatusMethod.m14312a(injectorLike), FetchPageInfoMethod.m14303a(injectorLike));
    }

    @Inject
    public PaymentPinWebServiceHandler(ApiMethodRunnerImpl apiMethodRunnerImpl, SetPaymentPinMethod setPaymentPinMethod, FetchPaymentPinMethod fetchPaymentPinMethod, UpdatePaymentPinStatusMethod updatePaymentPinStatusMethod, DeletePaymentPinMethod deletePaymentPinMethod, CheckPaymentPinMethod checkPaymentPinMethod, FetchPaymentPinStatusMethod fetchPaymentPinStatusMethod, FetchPageInfoMethod fetchPageInfoMethod) {
        super("PaymentPinWebServiceHandler");
        this.f13742a = apiMethodRunnerImpl;
        this.f13743b = setPaymentPinMethod;
        this.f13744c = fetchPaymentPinMethod;
        this.f13745d = updatePaymentPinStatusMethod;
        this.f13746e = deletePaymentPinMethod;
        this.f13747f = checkPaymentPinMethod;
        this.f13748g = fetchPaymentPinStatusMethod;
        this.f13749h = fetchPageInfoMethod;
    }

    protected final OperationResult mo532b(OperationParams operationParams, BlueServiceHandler blueServiceHandler) {
        return OperationResult.a((PaymentPin) this.f13742a.a(this.f13743b, (SetPaymentPinParams) operationParams.c.getParcelable(SetPaymentPinParams.f13713a)));
    }

    protected final OperationResult mo535d(OperationParams operationParams, BlueServiceHandler blueServiceHandler) {
        this.f13742a.a(this.f13745d, (UpdatePaymentPinStatusParams) operationParams.c.getParcelable(UpdatePaymentPinStatusParams.f13722a));
        return OperationResult.a;
    }

    protected final OperationResult mo534e(OperationParams operationParams, BlueServiceHandler blueServiceHandler) {
        this.f13742a.a(this.f13746e, (DeletePaymentPinParams) operationParams.c.getParcelable(DeletePaymentPinParams.f13705a));
        return OperationResult.a;
    }

    protected final OperationResult mo536f(OperationParams operationParams, BlueServiceHandler blueServiceHandler) {
        return OperationResult.a((PaymentPin) this.f13742a.a(this.f13747f, (CheckPaymentPinParams) operationParams.c.getParcelable(CheckPaymentPinParams.f13702a)));
    }

    protected final OperationResult mo538h(OperationParams operationParams, BlueServiceHandler blueServiceHandler) {
        return OperationResult.a((PageInfoModel) this.f13742a.a(this.f13749h, (FetchPageInfoParams) operationParams.c.getParcelable(FetchPageInfoParams.f13709a)));
    }

    protected final OperationResult mo533c(OperationParams operationParams, BlueServiceHandler blueServiceHandler) {
        return OperationResult.a((PaymentPin) this.f13742a.a(this.f13744c, null));
    }

    protected final OperationResult mo537g(OperationParams operationParams, BlueServiceHandler blueServiceHandler) {
        return OperationResult.a((PaymentPinStatusModel) this.f13742a.a(this.f13748g, null));
    }
}
