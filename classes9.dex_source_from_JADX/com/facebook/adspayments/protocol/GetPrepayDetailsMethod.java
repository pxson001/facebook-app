package com.facebook.adspayments.protocol;

import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.util.Quartet;
import com.facebook.http.protocol.ApiRequest;
import com.facebook.http.protocol.ApiRequestBuilder;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.http.protocol.ApiResponseType;
import com.facebook.inject.InjectorLike;
import com.facebook.payments.common.PaymentNetworkOperationHelper;
import com.facebook.payments.common.UnrestrictedResultPaymentsNetworkOperation;
import com.facebook.payments.model.CurrencyAmount;
import com.facebook.payments.paymentmethods.model.PaymentMethod;
import com.fasterxml.jackson.databind.JsonNode;
import com.google.common.collect.ImmutableBiMap;
import javax.inject.Inject;

/* compiled from: USER_HEADER */
public class GetPrepayDetailsMethod extends UnrestrictedResultPaymentsNetworkOperation<Quartet<String, ? extends PaymentMethod, CurrencyAmount, Boolean>, CvvPrepayData> {
    public static GetPrepayDetailsMethod m25728b(InjectorLike injectorLike) {
        return new GetPrepayDetailsMethod(PaymentNetworkOperationHelper.a(injectorLike));
    }

    public final ApiRequest m25729a(Object obj) {
        Object obj2;
        Quartet quartet = (Quartet) obj;
        String str = (String) quartet.first;
        ApiRequestBuilder newBuilder = ApiRequest.newBuilder();
        newBuilder.d = StringFormatUtil.formatStrLocaleSafe("/act_%s", str);
        ApiRequestBuilder apiRequestBuilder = newBuilder;
        apiRequestBuilder.b = "get_account_details";
        apiRequestBuilder = apiRequestBuilder;
        apiRequestBuilder.c = "GET";
        newBuilder = apiRequestBuilder;
        String str2 = "fields";
        String str3 = "prepay_details.credential_id(%s).budget_currency(%s).budget_amount(%s).budget_type(%s){min_acceptable_amount, max_acceptable_amount, default_funding_amount, should_collect_business_details}";
        String a = ((PaymentMethod) quartet.second).a();
        String str4 = ((CurrencyAmount) quartet.b).b;
        String toPlainString = ((CurrencyAmount) quartet.b).c.toPlainString();
        if (((Boolean) quartet.a).booleanValue()) {
            obj2 = "daily_budget";
        } else {
            obj2 = "lifetime_budget";
        }
        apiRequestBuilder = newBuilder.a(ImmutableBiMap.b(str2, StringFormatUtil.formatStrLocaleSafe(str3, a, str4, toPlainString, obj2)));
        apiRequestBuilder.k = ApiResponseType.JSON;
        return apiRequestBuilder.C();
    }

    @Inject
    public GetPrepayDetailsMethod(PaymentNetworkOperationHelper paymentNetworkOperationHelper) {
        super(paymentNetworkOperationHelper, CvvPrepayData.class);
    }

    public final Object m25730a(Object obj, ApiResponse apiResponse) {
        JsonNode c = apiResponse.c();
        return new CvvPrepayData(Boolean.valueOf(UnrestrictedResultPaymentsNetworkOperation.a(apiResponse, "should_collect_business_details")).booleanValue(), m25727a(c.g("min_acceptable_amount")), m25727a(c.g("max_acceptable_amount")), m25727a(c.g("default_funding_amount")));
    }

    private static CurrencyAmount m25727a(JsonNode jsonNode) {
        return new CurrencyAmount(UnrestrictedResultPaymentsNetworkOperation.a(jsonNode, "currency"), Long.parseLong(UnrestrictedResultPaymentsNetworkOperation.a(jsonNode, "offsetted_amount")));
    }

    protected final String m25731a() {
        return "get_prepay_details";
    }
}
