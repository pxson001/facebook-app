package com.facebook.http.common;

import com.facebook.http.interfaces.RequestPriority;
import com.google.common.base.Preconditions;
import org.apache.http.HttpRequest;

/* compiled from: not a valid long value */
public class FbHttpParamsUtility {
    public static void m17905a(HttpRequest httpRequest, RequestPriority requestPriority) {
        Preconditions.checkNotNull(requestPriority);
        httpRequest.getParams().setIntParameter("priority", requestPriority.getNumericValue());
    }

    public static long m17904a(HttpRequest httpRequest) {
        Preconditions.checkNotNull(httpRequest);
        return httpRequest.getParams().getLongParameter("fb_request_creation_time", 0);
    }

    public static void m17906b(HttpRequest httpRequest, String str) {
        Preconditions.checkNotNull(httpRequest);
        httpRequest.getParams().setParameter("fb_request_call_path", str);
    }
}
