package com.facebook.pages.common.reaction.protocol.methods;

import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.http.interfaces.RequestPriority;
import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.ApiRequest;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.http.protocol.ApiResponseType;
import com.facebook.inject.InjectorLike;
import com.facebook.pages.common.reaction.protocol.methods.model.PageNuxExposuresCallArguments;
import com.google.common.collect.Lists;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;

/* compiled from: see_all_click */
public class PageNuxExposuresMethod implements ApiMethod<PageNuxExposuresCallArguments, Void> {
    public static PageNuxExposuresMethod m3156a(InjectorLike injectorLike) {
        return new PageNuxExposuresMethod();
    }

    public final ApiRequest m3157a(Object obj) {
        PageNuxExposuresCallArguments pageNuxExposuresCallArguments = (PageNuxExposuresCallArguments) obj;
        List a = Lists.a();
        a.add(new BasicNameValuePair("type", pageNuxExposuresCallArguments.f2133b));
        return new ApiRequest("PageNuxExposures", "POST", StringFormatUtil.a("%s/page_nux_exposures", new Object[]{pageNuxExposuresCallArguments.f2132a}), RequestPriority.NON_INTERACTIVE, a, ApiResponseType.JSON);
    }

    public final Object m3158a(Object obj, ApiResponse apiResponse) {
        apiResponse.i();
        return null;
    }
}
