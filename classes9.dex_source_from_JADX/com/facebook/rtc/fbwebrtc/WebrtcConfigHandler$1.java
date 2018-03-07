package com.facebook.rtc.fbwebrtc;

import android.os.AsyncTask;
import com.facebook.debug.log.BLog;
import com.facebook.http.protocol.ApiMethodRunnerParams;
import com.facebook.webrtc.TurnAllocatorCallback;
import java.net.URLDecoder;

/* compiled from: audio/amr */
class WebrtcConfigHandler$1 extends AsyncTask<Void, Void, Void> {
    final /* synthetic */ String f19384a;
    final /* synthetic */ String f19385b;
    final /* synthetic */ String f19386c;
    final /* synthetic */ ApiMethodRunnerParams f19387d;
    final /* synthetic */ TurnAllocatorCallback f19388e;
    final /* synthetic */ WebrtcConfigHandler f19389f;

    WebrtcConfigHandler$1(WebrtcConfigHandler webrtcConfigHandler, String str, String str2, String str3, ApiMethodRunnerParams apiMethodRunnerParams, TurnAllocatorCallback turnAllocatorCallback) {
        this.f19389f = webrtcConfigHandler;
        this.f19384a = str;
        this.f19385b = str2;
        this.f19386c = str3;
        this.f19387d = apiMethodRunnerParams;
        this.f19388e = turnAllocatorCallback;
    }

    protected Object doInBackground(Object[] objArr) {
        String str;
        try {
            str = (String) this.f19389f.o.a(this.f19389f.p, new WebrtcTurnAllocationParams(this.f19384a, URLDecoder.decode(this.f19385b, "UTF8"), URLDecoder.decode(this.f19386c, "UTF8")), this.f19387d, WebrtcConfigHandler.ab);
        } catch (Throwable e) {
            BLog.a(WebrtcConfigHandler.a, "failed to read turn config. partial data will be returned", e);
            str = null;
        }
        if (str != null) {
            this.f19388e.turnAllocationSuccess(str);
        } else {
            this.f19388e.turnAllocationFailure();
        }
        return null;
    }
}
