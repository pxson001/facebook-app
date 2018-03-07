package com.facebook.http.observer;

import java.io.IOException;
import javax.annotation.Nullable;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.protocol.HttpContext;

/* compiled from: null_GroupCommerceItemAttachment */
public interface FbHttpFlowObserver {
    void mo2281a(Stage stage, HttpRequest httpRequest, @Nullable HttpResponse httpResponse, HttpContext httpContext, IOException iOException);

    void mo2283a(HttpRequest httpRequest, HttpContext httpContext);

    void mo2284a(HttpRequest httpRequest, HttpContext httpContext, HttpFlowStatistics httpFlowStatistics);

    void mo2285a(HttpResponse httpResponse, HttpContext httpContext);

    void mo2282b(HttpResponse httpResponse, HttpContext httpContext);
}
