package com.facebook.payments.contactinfo.protocol;

import com.facebook.http.protocol.ApiMethodRunnerImpl;
import com.facebook.inject.InjectorLike;
import com.facebook.payments.common.PaymentNetworkOperationHandler;
import com.facebook.payments.common.UnrestrictedResultPaymentsNetworkOperation;
import com.facebook.payments.contactinfo.protocol.method.AddEmailContactInfoMethod;
import com.facebook.payments.contactinfo.protocol.method.EditEmailContactInfoMethod;
import javax.inject.Inject;

/* compiled from: brazil_tax */
public class ContactInfoWebServiceHandler extends PaymentNetworkOperationHandler {
    public static ContactInfoWebServiceHandler m18707b(InjectorLike injectorLike) {
        return new ContactInfoWebServiceHandler(ApiMethodRunnerImpl.a(injectorLike), EditEmailContactInfoMethod.m18711b(injectorLike), AddEmailContactInfoMethod.m18708b(injectorLike));
    }

    @Inject
    public ContactInfoWebServiceHandler(ApiMethodRunnerImpl apiMethodRunnerImpl, EditEmailContactInfoMethod editEmailContactInfoMethod, AddEmailContactInfoMethod addEmailContactInfoMethod) {
        super(apiMethodRunnerImpl, new UnrestrictedResultPaymentsNetworkOperation[]{editEmailContactInfoMethod, addEmailContactInfoMethod});
    }
}
