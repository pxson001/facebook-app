package com.facebook.pages.common.viewercontextutils;

import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.ApiRequest;
import com.facebook.http.protocol.ApiRequestBuilder;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.http.protocol.ApiResponseType;
import com.facebook.inject.Lazy;
import com.fasterxml.jackson.databind.JsonNode;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nullable;
import javax.inject.Inject;
import org.apache.http.message.BasicNameValuePair;

/* compiled from: copyright */
public class PageViewerContextApiMethod implements ApiMethod<String, PageViewerContextData> {
    private Lazy<FbErrorReporter> f16898a;

    @Nullable
    public final ApiRequest m20200a(Object obj) {
        String str = (String) obj;
        List arrayList = new ArrayList();
        arrayList.add(new BasicNameValuePair("format", "json"));
        arrayList.add(new BasicNameValuePair("q", StringFormatUtil.a("SELECT page_id, access_token FROM page WHERE page_id = \"%s\"", new Object[]{str})));
        ApiRequestBuilder newBuilder = ApiRequest.newBuilder();
        newBuilder.b = "fetchPageAccessToken";
        newBuilder = newBuilder;
        newBuilder.c = "GET";
        newBuilder = newBuilder;
        newBuilder.d = "fql";
        newBuilder = newBuilder;
        newBuilder.g = arrayList;
        ApiRequestBuilder apiRequestBuilder = newBuilder;
        apiRequestBuilder.k = ApiResponseType.JSON;
        return apiRequestBuilder.C();
    }

    public final Object m20201a(Object obj, ApiResponse apiResponse) {
        apiResponse.i();
        JsonNode b = apiResponse.c().b("data");
        if (b == null || b.e() <= 0) {
            m20199c("data");
            return null;
        }
        b = b.a(0);
        JsonNode b2 = b.b("page_id");
        if (b2 == null) {
            m20199c("page_id");
            return null;
        }
        b = b.b("access_token");
        if (b != null) {
            return new PageViewerContextData(Long.valueOf(b2.D()), b.B());
        }
        m20199c("access_token");
        return null;
    }

    @Inject
    public PageViewerContextApiMethod(Lazy<FbErrorReporter> lazy) {
        this.f16898a = lazy;
    }

    private void m20199c(String str) {
        ((AbstractFbErrorReporter) this.f16898a.get()).a(getClass().getSimpleName(), StringFormatUtil.formatStrLocaleSafe("Json node %s is null", str));
    }
}
