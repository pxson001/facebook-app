package com.facebook.http.engine;

import com.facebook.http.common.FbRequestState;
import com.facebook.http.observer.HttpFlowStatistics;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.protocol.HttpContext;

/* compiled from: readForegroundParamsQEData */
public interface HttpRequestExecutor {
    HttpResponse mo1702a(HttpUriRequest httpUriRequest, FbRequestState fbRequestState, HttpContext httpContext, HttpFlowStatistics httpFlowStatistics);

    void mo1703a();

    String mo1704b();

    boolean mo1705c();
}
