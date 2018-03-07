package com.facebook.pages.common.actionbar.blueservice;

import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.ApiRequest;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.http.protocol.ApiResponseType;
import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;

/* compiled from: stickerFBID */
public class ReportPlaceMethod implements ApiMethod<ReportPlaceParams, Void> {
    public final ApiRequest m2001a(Object obj) {
        ReportPlaceParams reportPlaceParams = (ReportPlaceParams) obj;
        List a = Lists.a();
        Preconditions.checkNotNull(reportPlaceParams.f1354a, "Invalid place id!");
        String formatStrLocaleSafe = StringFormatUtil.formatStrLocaleSafe("%s/flags", reportPlaceParams.f1354a);
        a.add(new BasicNameValuePair("flag", reportPlaceParams.f1355b));
        a.add(new BasicNameValuePair("value", "1"));
        a.add(new BasicNameValuePair("entry_point", reportPlaceParams.f1356c.getFullName()));
        a.add(new BasicNameValuePair("endpoint", reportPlaceParams.f1357d.getFullName()));
        return new ApiRequest("reportPlace", "POST", formatStrLocaleSafe, a, ApiResponseType.JSON);
    }

    public final Object m2002a(Object obj, ApiResponse apiResponse) {
        apiResponse.i();
        return null;
    }
}
