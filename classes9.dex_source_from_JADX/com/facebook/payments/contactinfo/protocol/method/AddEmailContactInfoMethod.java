package com.facebook.payments.contactinfo.protocol.method;

import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.http.protocol.ApiRequest;
import com.facebook.http.protocol.ApiRequestBuilder;
import com.facebook.http.protocol.ApiResponseType;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.payments.common.PaymentNetworkOperationHelper;
import com.facebook.payments.common.PaymentsNetworkOperation;
import com.facebook.payments.contactinfo.protocol.model.AddEmailContactInfoParams;
import com.facebook.payments.contactinfo.protocol.model.ContactInfoProtocolResult;
import com.facebook.user.model.User;
import com.google.common.base.Preconditions;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Provider;
import org.apache.http.message.BasicNameValuePair;

/* compiled from: bp */
public class AddEmailContactInfoMethod extends PaymentsNetworkOperation<AddEmailContactInfoParams, ContactInfoProtocolResult> {
    private final Provider<User> f18696c;

    public static AddEmailContactInfoMethod m18708b(InjectorLike injectorLike) {
        return new AddEmailContactInfoMethod(PaymentNetworkOperationHelper.a(injectorLike), IdBasedProvider.a(injectorLike, 3595));
    }

    public final ApiRequest m18709a(Object obj) {
        AddEmailContactInfoParams addEmailContactInfoParams = (AddEmailContactInfoParams) obj;
        Preconditions.checkNotNull(this.f18696c.get());
        List arrayList = new ArrayList();
        arrayList.add(new BasicNameValuePair("user_input_email", addEmailContactInfoParams.f18701c));
        arrayList.add(new BasicNameValuePair("default", addEmailContactInfoParams.f18698a ? "1" : "0"));
        ApiRequestBuilder newBuilder = ApiRequest.newBuilder();
        newBuilder.b = "add_email_contact_info";
        newBuilder = newBuilder;
        newBuilder.c = "POST";
        ApiRequestBuilder apiRequestBuilder = newBuilder;
        apiRequestBuilder.d = StringFormatUtil.formatStrLocaleSafe("%d/payment_account_emails", Long.valueOf(Long.parseLong(((User) this.f18696c.get()).a)));
        newBuilder = apiRequestBuilder;
        newBuilder.g = arrayList;
        newBuilder = newBuilder;
        newBuilder.k = ApiResponseType.JSONPARSER;
        return newBuilder.C();
    }

    @Inject
    public AddEmailContactInfoMethod(PaymentNetworkOperationHelper paymentNetworkOperationHelper, Provider<User> provider) {
        super(paymentNetworkOperationHelper, ContactInfoProtocolResult.class);
        this.f18696c = provider;
    }

    protected final String m18710a() {
        return "add_email_contact_info";
    }
}
