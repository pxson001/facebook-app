package com.facebook.commerce.productdetails.api;

import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.ApiRequest;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.http.protocol.ApiResponseType;
import com.fasterxml.jackson.databind.JsonNode;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;

/* compiled from: deleteThreadDialog */
public class SubmitItemForCheckoutMethod implements ApiMethod<CheckoutParams, String> {
    public final ApiRequest m15667a(Object obj) {
        CheckoutParams checkoutParams = (CheckoutParams) obj;
        List arrayList = new ArrayList();
        arrayList.add(new BasicNameValuePair("item_id", checkoutParams.f15132a));
        arrayList.add(new BasicNameValuePair("quantity", Integer.toString(checkoutParams.f15133b)));
        return new ApiRequest("checkout_item", "POST", "me/commerce_cart_items", arrayList, ApiResponseType.JSON);
    }

    public final Object m15668a(Object obj, ApiResponse apiResponse) {
        JsonNode c = apiResponse.c();
        apiResponse.i();
        if (c.b("checkout_path") != null) {
            return c.b("checkout_path").B();
        }
        return null;
    }
}
