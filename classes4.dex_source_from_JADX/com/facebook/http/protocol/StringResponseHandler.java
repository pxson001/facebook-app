package com.facebook.http.protocol;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ResponseHandler;
import org.apache.http.util.EntityUtils;

/* compiled from: fetchThreadParams */
public class StringResponseHandler implements ResponseHandler<String> {
    private final ApiResponseChecker f11679a;
    private HttpResponse f11680b;

    public /* synthetic */ Object handleResponse(HttpResponse httpResponse) {
        return m12224a(httpResponse);
    }

    public StringResponseHandler(ApiResponseChecker apiResponseChecker) {
        this.f11679a = apiResponseChecker;
    }

    public final String m12224a(HttpResponse httpResponse) {
        this.f11680b = httpResponse;
        this.f11679a.a(httpResponse);
        HttpEntity entity = httpResponse.getEntity();
        return entity != null ? EntityUtils.toString(entity) : null;
    }
}
