package com.facebook.zero.token.response;

import com.facebook.common.util.StringUtil;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.http.observer.AbstractFbHttpFlowObserver;
import com.facebook.http.observer.Stage;
import com.facebook.zero.service.FbZeroTokenManager.C02302;
import com.google.common.collect.ImmutableList;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Nullable;
import javax.inject.Inject;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.protocol.HttpContext;

/* compiled from: not_in_region */
public class ZeroTokenHttpResponseObserver extends AbstractFbHttpFlowObserver {
    private final GatekeeperStoreImpl f12168a;
    private final ZeroTokenHeaderResponseManager f12169b;

    @Inject
    public ZeroTokenHttpResponseObserver(GatekeeperStoreImpl gatekeeperStoreImpl, ZeroTokenHeaderResponseManager zeroTokenHeaderResponseManager) {
        this.f12168a = gatekeeperStoreImpl;
        this.f12169b = zeroTokenHeaderResponseManager;
    }

    public final void mo2285a(HttpResponse httpResponse, HttpContext httpContext) {
        super.mo2285a(httpResponse, httpContext);
        if (this.f12168a.m2189a(1193, false)) {
            Map hashMap = new HashMap();
            ImmutableList immutableList = ZeroHeaderParams.a;
            int size = immutableList.size();
            for (int i = 0; i < size; i++) {
                String str = (String) immutableList.get(i);
                if (httpResponse.containsHeader(str)) {
                    CharSequence value = httpResponse.getFirstHeader(str).getValue();
                    if (!StringUtil.m3589a(value)) {
                        hashMap.put(str, value);
                    }
                }
            }
            if (hashMap.isEmpty()) {
                HttpRequest httpRequest = (HttpRequest) httpContext.getAttribute("http.request");
                if (httpRequest != null && httpRequest.containsHeader("X-ZERO-STATE")) {
                    this.f12169b.m8017a();
                    return;
                }
                return;
            }
            for (C02302 c02302 : this.f12169b.f4343a) {
                c02302.f4363a.m7934a(hashMap);
            }
        }
    }

    public final void mo2281a(Stage stage, HttpRequest httpRequest, @Nullable HttpResponse httpResponse, HttpContext httpContext, IOException iOException) {
        super.mo2281a(stage, httpRequest, httpResponse, httpContext, iOException);
        if (this.f12168a.m2189a(1193, false) && httpRequest.containsHeader("X-ZERO-STATE")) {
            this.f12169b.m8017a();
        }
    }
}
