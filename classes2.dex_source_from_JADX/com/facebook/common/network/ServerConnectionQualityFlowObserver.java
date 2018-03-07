package com.facebook.common.network;

import com.facebook.http.observer.AbstractFbHttpFlowObserver;
import javax.inject.Inject;
import org.apache.http.HttpResponse;
import org.apache.http.protocol.HttpContext;

/* compiled from: notifications_enabled */
public class ServerConnectionQualityFlowObserver extends AbstractFbHttpFlowObserver {
    ServerConnectionQualityManager f12094a;

    @Inject
    public ServerConnectionQualityFlowObserver(ServerConnectionQualityManager serverConnectionQualityManager) {
        this.f12094a = serverConnectionQualityManager;
    }

    public final void mo2285a(HttpResponse httpResponse, HttpContext httpContext) {
        super.mo2285a(httpResponse, httpContext);
        this.f12094a.m4106a(httpResponse);
    }
}
