package com.facebook.powermanagement;

import com.facebook.common.hardware.NetworkActivityBroadcastManager;
import com.facebook.http.observer.AbstractFbHttpFlowObserver;
import com.facebook.http.observer.Stage;
import com.google.common.base.Preconditions;
import java.io.IOException;
import javax.annotation.Nullable;
import javax.inject.Inject;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.protocol.HttpContext;

/* compiled from: notif_type */
public class NetworkActivityFbHttpClientObserver extends AbstractFbHttpFlowObserver {
    private final NetworkActivityBroadcastManager f12143a;
    private boolean f12144b = false;

    @Inject
    public NetworkActivityFbHttpClientObserver(NetworkActivityBroadcastManager networkActivityBroadcastManager) {
        this.f12143a = networkActivityBroadcastManager;
    }

    public final void mo2285a(HttpResponse httpResponse, HttpContext httpContext) {
        this.f12143a.m17860a();
        this.f12144b = true;
    }

    public final void mo2282b(HttpResponse httpResponse, HttpContext httpContext) {
        Preconditions.checkState(this.f12144b);
        this.f12143a.m17861b();
    }

    public final void mo2281a(Stage stage, HttpRequest httpRequest, @Nullable HttpResponse httpResponse, HttpContext httpContext, IOException iOException) {
        if (this.f12144b) {
            this.f12143a.m17861b();
            this.f12144b = false;
        }
    }
}
