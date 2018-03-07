package com.facebook.checkpoint;

import com.facebook.common.util.StringUtil;
import com.facebook.http.observer.AbstractFbHttpFlowObserver;
import javax.inject.Inject;
import org.apache.http.HttpResponse;
import org.apache.http.protocol.HttpContext;

/* compiled from: notifications_friending */
public class CheckpointHttpObserver extends AbstractFbHttpFlowObserver {
    private CheckpointBroadcaster f12093a;

    @Inject
    public CheckpointHttpObserver(CheckpointBroadcaster checkpointBroadcaster) {
        this.f12093a = checkpointBroadcaster;
    }

    public final void mo2285a(HttpResponse httpResponse, HttpContext httpContext) {
        super.mo2285a(httpResponse, httpContext);
        if (httpResponse != null && httpResponse.containsHeader("X-FB-Checkpoint")) {
            String value = httpResponse.getFirstHeader("X-FB-Checkpoint").getValue();
            if (!StringUtil.m3589a((CharSequence) value)) {
                this.f12093a.m8846a(value);
            }
        }
    }
}
