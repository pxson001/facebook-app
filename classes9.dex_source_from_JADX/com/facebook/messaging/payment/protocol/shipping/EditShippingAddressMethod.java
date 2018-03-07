package com.facebook.messaging.payment.protocol.shipping;

import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.util.StringUtil;
import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.ApiRequest;
import com.facebook.http.protocol.ApiRequestBuilder;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.http.protocol.ApiResponseType;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.payment.service.model.shipping.EditShippingAddressParams;
import com.facebook.payments.shipping.model.ShippingAddressFormInput;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;

/* compiled from: folder='%1$s' AND archived=0 AND timestamp <= %2$d */
public class EditShippingAddressMethod implements ApiMethod<EditShippingAddressParams, Boolean> {
    public static EditShippingAddressMethod m15084a(InjectorLike injectorLike) {
        return new EditShippingAddressMethod();
    }

    public final ApiRequest m15085a(Object obj) {
        EditShippingAddressParams editShippingAddressParams = (EditShippingAddressParams) obj;
        List arrayList = new ArrayList();
        if (editShippingAddressParams.f14723a != null) {
            ShippingAddressFormInput shippingAddressFormInput = editShippingAddressParams.f14723a;
            arrayList.add(new BasicNameValuePair("addressee", shippingAddressFormInput.f18963a));
            arrayList.add(new BasicNameValuePair("label", shippingAddressFormInput.f18964b));
            arrayList.add(new BasicNameValuePair("street", shippingAddressFormInput.f18965c));
            if (!StringUtil.a(shippingAddressFormInput.f18966d)) {
                arrayList.add(new BasicNameValuePair("building", shippingAddressFormInput.f18966d));
            }
            arrayList.add(new BasicNameValuePair("city", shippingAddressFormInput.f18967e));
            arrayList.add(new BasicNameValuePair("state", shippingAddressFormInput.f18968f));
            arrayList.add(new BasicNameValuePair("postal_code", shippingAddressFormInput.f18969g));
            arrayList.add(new BasicNameValuePair("country_code", shippingAddressFormInput.f18970h.b()));
        }
        if (editShippingAddressParams.f14725c) {
            arrayList.add(new BasicNameValuePair("default", "1"));
        }
        String str = editShippingAddressParams.f14726d ? "DELETE" : "POST";
        ApiRequestBuilder newBuilder = ApiRequest.newBuilder();
        newBuilder.b = "p2p_edit_shipping_address";
        newBuilder = newBuilder;
        newBuilder.c = str;
        ApiRequestBuilder apiRequestBuilder = newBuilder;
        apiRequestBuilder.d = StringFormatUtil.formatStrLocaleSafe("/%d", Long.valueOf(Long.parseLong(editShippingAddressParams.f14724b)));
        apiRequestBuilder = apiRequestBuilder;
        apiRequestBuilder.g = arrayList;
        apiRequestBuilder = apiRequestBuilder;
        apiRequestBuilder.k = ApiResponseType.JSON;
        return apiRequestBuilder.C();
    }

    public final Object m15086a(Object obj, ApiResponse apiResponse) {
        apiResponse.i();
        return Boolean.valueOf(apiResponse.c().F());
    }
}
