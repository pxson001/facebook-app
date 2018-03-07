package com.facebook.adspayments.protocol;

import com.facebook.adspayments.model.BusinessAddressDetails;
import com.facebook.http.protocol.ApiRequest;
import com.facebook.http.protocol.ApiRequestBuilder;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.http.protocol.ApiResponseType;
import com.facebook.inject.InjectorLike;
import com.facebook.payments.common.PaymentNetworkOperationHelper;
import com.facebook.payments.common.PaymentsNetworkOperation;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;
import org.apache.http.message.BasicNameValuePair;

/* compiled from: USE_GRAPH_API */
public class GetBrazilianAddressDetailsMethod extends PaymentsNetworkOperation<GetBrazilianAddressDetailsParams, BusinessAddressDetails> {
    public static GetBrazilianAddressDetailsMethod m25718b(InjectorLike injectorLike) {
        return new GetBrazilianAddressDetailsMethod(PaymentNetworkOperationHelper.a(injectorLike));
    }

    public final ApiRequest m25720a(Object obj) {
        GetBrazilianAddressDetailsParams getBrazilianAddressDetailsParams = (GetBrazilianAddressDetailsParams) obj;
        ApiRequestBuilder newBuilder = ApiRequest.newBuilder();
        newBuilder.d = "/brazil_zip_details";
        newBuilder = newBuilder;
        newBuilder.b = "get_brazil_address_details";
        newBuilder = newBuilder;
        newBuilder.g = ImmutableList.of(new BasicNameValuePair("zip", getBrazilianAddressDetailsParams.f23698a));
        newBuilder = newBuilder;
        newBuilder.c = "GET";
        newBuilder = newBuilder;
        newBuilder.k = ApiResponseType.JSON;
        return newBuilder.C();
    }

    @Inject
    public GetBrazilianAddressDetailsMethod(PaymentNetworkOperationHelper paymentNetworkOperationHelper) {
        super(paymentNetworkOperationHelper, BusinessAddressDetails.class);
    }

    protected final String m25722a() {
        return "get_brazilian_address_details";
    }

    private static BusinessAddressDetails m25717a(ApiResponse apiResponse) {
        apiResponse.i();
        return new BusinessAddressDetails(apiResponse.c().b("data").a(0));
    }
}
