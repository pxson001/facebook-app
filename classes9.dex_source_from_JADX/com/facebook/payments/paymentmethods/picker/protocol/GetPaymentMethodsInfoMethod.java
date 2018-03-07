package com.facebook.payments.paymentmethods.picker.protocol;

import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.http.protocol.ApiRequest;
import com.facebook.http.protocol.ApiRequestBuilder;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.http.protocol.ApiResponseType;
import com.facebook.inject.InjectorLike;
import com.facebook.payments.common.PaymentNetworkOperationHelper;
import com.facebook.payments.common.UnrestrictedResultPaymentsNetworkOperation;
import com.facebook.payments.paymentmethods.model.PaymentMethodsInfo;
import com.facebook.payments.paymentmethods.picker.protocol.parser.MORPaymentMethodsInfoParser;
import com.facebook.payments.paymentmethods.picker.protocol.parser.NMORPaymentMethodsInfoParser;
import com.facebook.payments.paymentmethods.picker.protocol.parser.PaymentMethodsInfoParserManager;
import com.facebook.payments.util.PaymentItemTypeUtil;
import com.fasterxml.jackson.databind.JsonNode;
import com.google.common.base.Preconditions;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import org.apache.http.message.BasicNameValuePair;

/* compiled from: bitrate-mode */
public class GetPaymentMethodsInfoMethod extends UnrestrictedResultPaymentsNetworkOperation<GetPaymentMethodsInfoParams, GetPaymentMethodsInfoResult> {
    private final NMORPaymentMethodsInfoParser f18854c;
    private final MORPaymentMethodsInfoParser f18855d;

    public static GetPaymentMethodsInfoMethod m18858b(InjectorLike injectorLike) {
        return new GetPaymentMethodsInfoMethod(PaymentNetworkOperationHelper.a(injectorLike), new NMORPaymentMethodsInfoParser(PaymentMethodsInfoParserManager.m18884a(injectorLike)), new MORPaymentMethodsInfoParser(PaymentMethodsInfoParserManager.m18884a(injectorLike)));
    }

    public final ApiRequest m18859a(Object obj) {
        String str;
        GetPaymentMethodsInfoParams getPaymentMethodsInfoParams = (GetPaymentMethodsInfoParams) obj;
        List arrayList = new ArrayList();
        arrayList.add(new BasicNameValuePair("format", "json"));
        StringBuilder stringBuilder = new StringBuilder("payment_methods_info");
        List arrayList2 = new ArrayList();
        if (getPaymentMethodsInfoParams.f18856a.isNMORPayment()) {
            str = ".nmor_order_type(%s)";
        } else {
            str = ".payment_type(%s)";
        }
        stringBuilder.append(str);
        arrayList2.add(getPaymentMethodsInfoParams.f18856a.getValue());
        if (getPaymentMethodsInfoParams.f18859d != null) {
            stringBuilder.append(".country_code(%s)");
            arrayList2.add(getPaymentMethodsInfoParams.f18859d.b());
        }
        if (PaymentItemTypeUtil.a(getPaymentMethodsInfoParams.f18856a)) {
            boolean z;
            if ("0".equals(getPaymentMethodsInfoParams.f18857b)) {
                z = false;
            } else {
                z = true;
            }
            Preconditions.checkArgument(z, "Invalid account id");
            stringBuilder.append(".account_id(%s)");
            arrayList2.add(getPaymentMethodsInfoParams.f18857b);
        }
        if (getPaymentMethodsInfoParams.f18858c != null) {
            stringBuilder.append(".extra_data(%s)");
            arrayList2.add(getPaymentMethodsInfoParams.f18858c.toString());
        }
        arrayList.add(new BasicNameValuePair("fields", StringFormatUtil.a(stringBuilder.toString(), arrayList2.toArray())));
        ApiRequestBuilder newBuilder = ApiRequest.newBuilder();
        newBuilder.b = "get_payment_methods_info";
        newBuilder = newBuilder;
        newBuilder.c = "GET";
        newBuilder = newBuilder;
        newBuilder.d = "me";
        newBuilder = newBuilder;
        newBuilder.g = arrayList;
        newBuilder = newBuilder;
        newBuilder.k = ApiResponseType.JSON;
        return newBuilder.C();
    }

    public final Object m18860a(Object obj, ApiResponse apiResponse) {
        PaymentMethodsInfo a;
        GetPaymentMethodsInfoParams getPaymentMethodsInfoParams = (GetPaymentMethodsInfoParams) obj;
        apiResponse.i();
        JsonNode c = apiResponse.c();
        Preconditions.checkArgument(c.d("payment_methods_info"));
        c = c.b("payment_methods_info");
        if (getPaymentMethodsInfoParams.f18856a.isNMORPayment()) {
            a = this.f18854c.m18877a(c);
        } else {
            a = this.f18855d.m18877a(c);
        }
        return new GetPaymentMethodsInfoResult(a);
    }

    @Inject
    public GetPaymentMethodsInfoMethod(PaymentNetworkOperationHelper paymentNetworkOperationHelper, NMORPaymentMethodsInfoParser nMORPaymentMethodsInfoParser, MORPaymentMethodsInfoParser mORPaymentMethodsInfoParser) {
        super(paymentNetworkOperationHelper, GetPaymentMethodsInfoResult.class);
        this.f18854c = nMORPaymentMethodsInfoParser;
        this.f18855d = mORPaymentMethodsInfoParser;
    }

    protected final String m18861a() {
        return "get_payment_methods_Info";
    }
}
