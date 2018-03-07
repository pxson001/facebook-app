package com.facebook.messaging.payment.protocol.shipping;

import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.util.JSONUtil;
import com.facebook.common.util.StringUtil;
import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.ApiRequest;
import com.facebook.http.protocol.ApiRequestBuilder;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.http.protocol.ApiResponseType;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.payment.service.model.shipping.AddShippingAddressParams;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;

/* compiled from: folder='%1$s' AND timestamp > %2$d */
public class AddShippingAddressMethod implements ApiMethod<AddShippingAddressParams, String> {
    public static AddShippingAddressMethod m15081a(InjectorLike injectorLike) {
        return new AddShippingAddressMethod();
    }

    public final ApiRequest m15082a(Object obj) {
        String str;
        AddShippingAddressParams addShippingAddressParams = (AddShippingAddressParams) obj;
        List arrayList = new ArrayList();
        arrayList.add(new BasicNameValuePair("addressee", addShippingAddressParams.f14721a.f18963a));
        arrayList.add(new BasicNameValuePair("label", addShippingAddressParams.f14721a.f18964b));
        arrayList.add(new BasicNameValuePair("street", addShippingAddressParams.f14721a.f18965c));
        if (!StringUtil.a(addShippingAddressParams.f14721a.f18966d)) {
            arrayList.add(new BasicNameValuePair("building", addShippingAddressParams.f14721a.f18966d));
        }
        arrayList.add(new BasicNameValuePair("city", addShippingAddressParams.f14721a.f18967e));
        arrayList.add(new BasicNameValuePair("state", addShippingAddressParams.f14721a.f18968f));
        arrayList.add(new BasicNameValuePair("postal_code", addShippingAddressParams.f14721a.f18969g));
        arrayList.add(new BasicNameValuePair("country_code", addShippingAddressParams.f14721a.f18970h.b()));
        String str2 = "default";
        if (addShippingAddressParams.f14721a.f18971i) {
            str = "1";
        } else {
            str = "0";
        }
        arrayList.add(new BasicNameValuePair(str2, str));
        ApiRequestBuilder newBuilder = ApiRequest.newBuilder();
        newBuilder.b = "p2p_add_shipping_address";
        newBuilder = newBuilder;
        newBuilder.c = "POST";
        newBuilder = newBuilder;
        newBuilder.d = StringFormatUtil.formatStrLocaleSafe("/%d/mailing_addresses", Long.valueOf(Long.parseLong(addShippingAddressParams.f14722b)));
        newBuilder = newBuilder;
        newBuilder.g = arrayList;
        newBuilder = newBuilder;
        newBuilder.k = ApiResponseType.JSON;
        return newBuilder.C();
    }

    public final Object m15083a(Object obj, ApiResponse apiResponse) {
        apiResponse.i();
        return JSONUtil.b(apiResponse.c().b("id"));
    }
}
