package com.facebook.adspayments.protocol;

import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.http.protocol.ApiRequest;
import com.facebook.http.protocol.ApiRequestBuilder;
import com.facebook.http.protocol.ApiResponseType;
import com.facebook.inject.InjectorLike;
import com.facebook.payments.common.PaymentNetworkOperationHelper;
import com.facebook.payments.common.VoidResultPaymentsNetworkOperation;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;
import org.apache.http.message.BasicNameValuePair;

/* compiled from: URI Test Widget */
public class VerifyBrazilianTaxIdMethod extends VoidResultPaymentsNetworkOperation<VerifyBrazilianTaxIdParams> {
    public final ApiRequest m25750a(Object obj) {
        VerifyBrazilianTaxIdParams verifyBrazilianTaxIdParams = (VerifyBrazilianTaxIdParams) obj;
        ApiRequestBuilder newBuilder = ApiRequest.newBuilder();
        newBuilder.b = "brazil_tax";
        newBuilder = newBuilder;
        newBuilder.c = "POST";
        newBuilder = newBuilder;
        newBuilder.d = StringFormatUtil.formatStrLocaleSafe("act_%s/brazil_tax", verifyBrazilianTaxIdParams.f23717a);
        newBuilder = newBuilder;
        newBuilder.g = ImmutableList.of(new BasicNameValuePair("tax_id", verifyBrazilianTaxIdParams.f23718b));
        newBuilder = newBuilder;
        newBuilder.k = ApiResponseType.STRING;
        return newBuilder.C();
    }

    public static VerifyBrazilianTaxIdMethod m25749b(InjectorLike injectorLike) {
        return new VerifyBrazilianTaxIdMethod(PaymentNetworkOperationHelper.a(injectorLike));
    }

    @Inject
    public VerifyBrazilianTaxIdMethod(PaymentNetworkOperationHelper paymentNetworkOperationHelper) {
        super(paymentNetworkOperationHelper);
    }

    protected final String m25751a() {
        return "verify_brazilian_tax_id";
    }
}
