package com.facebook.payments.contactinfo.protocol.method;

import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.http.protocol.ApiRequest;
import com.facebook.http.protocol.ApiRequestBuilder;
import com.facebook.http.protocol.ApiResponseType;
import com.facebook.inject.InjectorLike;
import com.facebook.payments.common.PaymentNetworkOperationHelper;
import com.facebook.payments.common.PaymentsNetworkOperation;
import com.facebook.payments.contactinfo.protocol.model.ContactInfoProtocolResult;
import com.facebook.payments.contactinfo.protocol.model.EditEmailContactInfoParams;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import org.apache.http.message.BasicNameValuePair;

/* compiled from: bottom_sheet_showed */
public class EditEmailContactInfoMethod extends PaymentsNetworkOperation<EditEmailContactInfoParams, ContactInfoProtocolResult> {
    public static EditEmailContactInfoMethod m18711b(InjectorLike injectorLike) {
        return new EditEmailContactInfoMethod(PaymentNetworkOperationHelper.a(injectorLike));
    }

    public final ApiRequest m18712a(Object obj) {
        EditEmailContactInfoParams editEmailContactInfoParams = (EditEmailContactInfoParams) obj;
        List arrayList = new ArrayList();
        if (editEmailContactInfoParams.f18712e != null) {
            arrayList.add(new BasicNameValuePair("user_input_email", editEmailContactInfoParams.f18712e));
        }
        if (editEmailContactInfoParams.f18708b) {
            arrayList.add(new BasicNameValuePair("default", "1"));
        }
        String str = editEmailContactInfoParams.f18709c ? "DELETE" : "POST";
        ApiRequestBuilder newBuilder = ApiRequest.newBuilder();
        newBuilder.b = "add_email_contact_info";
        newBuilder = newBuilder;
        newBuilder.c = str;
        ApiRequestBuilder apiRequestBuilder = newBuilder;
        apiRequestBuilder.d = StringFormatUtil.formatStrLocaleSafe("%d", Long.valueOf(Long.parseLong(editEmailContactInfoParams.f18707a)));
        apiRequestBuilder = apiRequestBuilder;
        apiRequestBuilder.g = arrayList;
        apiRequestBuilder = apiRequestBuilder;
        apiRequestBuilder.k = ApiResponseType.JSONPARSER;
        return apiRequestBuilder.C();
    }

    @Inject
    public EditEmailContactInfoMethod(PaymentNetworkOperationHelper paymentNetworkOperationHelper) {
        super(paymentNetworkOperationHelper, ContactInfoProtocolResult.class);
    }

    protected final String m18713a() {
        return "edit_email_contact_info";
    }
}
