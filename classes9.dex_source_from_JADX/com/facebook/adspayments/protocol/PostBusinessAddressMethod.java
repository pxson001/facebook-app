package com.facebook.adspayments.protocol;

import com.facebook.common.locale.Country;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.http.protocol.ApiRequest;
import com.facebook.http.protocol.ApiRequestBuilder;
import com.facebook.http.protocol.ApiResponseType;
import com.facebook.inject.InjectorLike;
import com.facebook.payments.common.PaymentNetworkOperationHelper;
import com.facebook.payments.common.VoidResultPaymentsNetworkOperation;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import org.apache.http.message.BasicNameValuePair;

/* compiled from: URLS_EQUAL */
public class PostBusinessAddressMethod extends VoidResultPaymentsNetworkOperation<PostBusinessAddressParams> {
    public final ApiRequest m25741a(Object obj) {
        PostBusinessAddressParams postBusinessAddressParams = (PostBusinessAddressParams) obj;
        ApiRequestBuilder newBuilder = ApiRequest.newBuilder();
        newBuilder.b = "tax_info";
        newBuilder = newBuilder;
        newBuilder.c = "POST";
        newBuilder = newBuilder;
        newBuilder.d = StringFormatUtil.formatStrLocaleSafe("act_%s/tax_info", postBusinessAddressParams.f23707a);
        newBuilder = newBuilder;
        List arrayList = new ArrayList();
        PostBusinessAddressParams.m25743a(arrayList, "business_name", postBusinessAddressParams.f23708b);
        arrayList.add(new BasicNameValuePair("business_address", postBusinessAddressParams.f23709c.m25694f()));
        PostBusinessAddressParams.m25743a(arrayList, "tax_id", postBusinessAddressParams.f23710d);
        if (!postBusinessAddressParams.f23709c.m25693e().equals(Country.a("BR"))) {
            arrayList.add(new BasicNameValuePair("is_agency_representing_client", String.valueOf(postBusinessAddressParams.f23714h)));
            arrayList.add(new BasicNameValuePair("is_client_based_in_france", String.valueOf(postBusinessAddressParams.f23715i)));
            if (postBusinessAddressParams.f23714h && postBusinessAddressParams.f23715i) {
                PostBusinessAddressParams.m25743a(arrayList, "client_business_name", postBusinessAddressParams.f23711e);
                PostBusinessAddressParams.m25743a(arrayList, "client_email", postBusinessAddressParams.f23713g);
                arrayList.add(new BasicNameValuePair("client_address", postBusinessAddressParams.f23712f.m25694f()));
                arrayList.add(new BasicNameValuePair("is_client_paying_invoices", String.valueOf(postBusinessAddressParams.f23716j)));
                arrayList.add(new BasicNameValuePair("business_mandate_received", "true"));
            }
        }
        newBuilder.g = arrayList;
        newBuilder = newBuilder;
        newBuilder.k = ApiResponseType.STRING;
        return newBuilder.C();
    }

    public static PostBusinessAddressMethod m25740b(InjectorLike injectorLike) {
        return new PostBusinessAddressMethod(PaymentNetworkOperationHelper.a(injectorLike));
    }

    @Inject
    public PostBusinessAddressMethod(PaymentNetworkOperationHelper paymentNetworkOperationHelper) {
        super(paymentNetworkOperationHelper);
    }

    protected final String m25742a() {
        return "post_business_address";
    }
}
