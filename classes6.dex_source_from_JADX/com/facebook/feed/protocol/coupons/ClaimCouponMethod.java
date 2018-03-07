package com.facebook.feed.protocol.coupons;

import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.ApiRequest;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.http.protocol.ApiResponseType;
import com.google.common.collect.Lists;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;

/* compiled from: messenger_call_to_action_postback */
public class ClaimCouponMethod implements ApiMethod<ClaimCouponParams, Boolean> {
    public final ApiRequest m16496a(Object obj) {
        ClaimCouponParams claimCouponParams = (ClaimCouponParams) obj;
        List a = Lists.a();
        a.add(new BasicNameValuePair("offer_id", claimCouponParams.f10369a));
        return new ApiRequest("graphObjectCouponClaim", "POST", StringFormatUtil.a("me/%s", new Object[]{claimCouponParams.f10370b}), a, ApiResponseType.JSON);
    }

    public final Object m16497a(Object obj, ApiResponse apiResponse) {
        return Boolean.valueOf(apiResponse.c().F());
    }
}
