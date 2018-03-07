package com.facebook.zero.upsell.methods;

import android.content.res.Resources;
import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.ApiRequest;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.http.protocol.ApiResponseType;
import com.facebook.iorg.common.upsell.server.ZeroRecommendedPromoParams;
import com.facebook.iorg.common.upsell.server.ZeroRecommendedPromoResult;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import javax.inject.Inject;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONObject;

/* compiled from: visit_page */
public class ZeroGetRecommendedPromoMethod implements ApiMethod<ZeroRecommendedPromoParams, ZeroRecommendedPromoResult> {
    private static final Class<?> f284a = ZeroGetRecommendedPromoMethod.class;
    private final Resources f285b;

    public final ApiRequest m331a(Object obj) {
        ZeroRecommendedPromoParams zeroRecommendedPromoParams = (ZeroRecommendedPromoParams) obj;
        List a = Lists.a();
        Resources resources = this.f285b;
        Map c = Maps.c();
        if (zeroRecommendedPromoParams.a != 0) {
            c.put("limit", Integer.toString(zeroRecommendedPromoParams.a));
        }
        c.put("scale", zeroRecommendedPromoParams.b);
        c.put("refresh", Boolean.toString(zeroRecommendedPromoParams.c));
        c.put("location", zeroRecommendedPromoParams.a());
        c.put("shortcut_icon_px", Integer.toString(resources.getDimensionPixelSize(2131428369)));
        c.put("alert_icon_px", Integer.toString(resources.getDimensionPixelSize(2131428370)));
        c.put("interstitial_context", zeroRecommendedPromoParams.b());
        c.put("format", "json");
        for (Entry entry : c.entrySet()) {
            a.add(new BasicNameValuePair((String) entry.getKey(), (String) entry.getValue()));
        }
        return new ApiRequest("zeroGetRecommendedPromo", "GET", "method/mobile.zeroGetRecommendedPromo", a, ApiResponseType.JSON);
    }

    @Inject
    public ZeroGetRecommendedPromoMethod(Resources resources) {
        this.f285b = resources;
    }

    public final Object m332a(Object obj, ApiResponse apiResponse) {
        apiResponse.i();
        return ZeroRecommendedPromoResult.a(new JSONObject(apiResponse.c().toString()));
    }
}
