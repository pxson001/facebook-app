package com.facebook.zero.upsell.methods;

import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.ApiRequest;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.http.protocol.ApiResponseType;
import com.facebook.iorg.common.upsell.model.ZeroPromoParams;
import com.facebook.iorg.common.upsell.server.ZeroPromoResult;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONObject;

/* compiled from: visit_page_tab */
public class ZeroBuyPromoMethod implements ApiMethod<ZeroPromoParams, ZeroPromoResult> {
    private static final Class<?> f283a = ZeroBuyPromoMethod.class;

    public final ApiRequest m329a(Object obj) {
        ZeroPromoParams zeroPromoParams = (ZeroPromoParams) obj;
        List a = Lists.a();
        Map c = Maps.c();
        c.put("enc_phone", zeroPromoParams.a);
        c.put("promo_id", zeroPromoParams.b);
        c.put("location", zeroPromoParams.c.getParamName());
        c.put("format", "json");
        for (Entry entry : c.entrySet()) {
            a.add(new BasicNameValuePair((String) entry.getKey(), (String) entry.getValue()));
        }
        return new ApiRequest("zeroBuyPromo", "GET", "method/mobile.zeroBuyPromo", a, ApiResponseType.JSON);
    }

    public final Object m330a(Object obj, ApiResponse apiResponse) {
        apiResponse.i();
        return ZeroPromoResult.a(new JSONObject(apiResponse.c().toString()));
    }
}
