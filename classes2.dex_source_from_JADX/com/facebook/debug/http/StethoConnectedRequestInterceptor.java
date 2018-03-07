package com.facebook.debug.http;

import com.facebook.http.common.FbHttpRequest;
import com.facebook.http.common.HttpRequestFilter;
import com.facebook.stetho.inspector.helper.ChromePeerManager;
import com.facebook.stetho.inspector.network.NetworkEventReporterImpl;
import com.facebook.stetho.inspector.network.NetworkPeerManager;
import org.apache.http.impl.client.RequestWrapper;

/* compiled from: registration_register_account */
public class StethoConnectedRequestInterceptor implements HttpRequestFilter {
    private final NetworkEventReporterImpl f7779a = NetworkEventReporterImpl.m12320b();

    public final void mo1680a(RequestWrapper requestWrapper, FbHttpRequest fbHttpRequest) {
        Object obj;
        NetworkEventReporterImpl networkEventReporterImpl = this.f7779a;
        ChromePeerManager b = NetworkPeerManager.m17684b();
        if (b == null || !b.m17685a()) {
            b = null;
        }
        if (b != null) {
            obj = 1;
        } else {
            obj = null;
        }
        if (obj != null) {
            requestWrapper.addHeader("x-fb-request-flatbuffer-schema", "true");
        }
    }

    public final int mo1679a() {
        return Integer.MAX_VALUE;
    }
}
