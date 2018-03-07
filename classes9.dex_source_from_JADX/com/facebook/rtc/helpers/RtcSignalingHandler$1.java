package com.facebook.rtc.helpers;

import com.facebook.common.executors.FbAsyncTask;

/* compiled from: application/vnd.wap.uaprof */
class RtcSignalingHandler$1 extends FbAsyncTask<Void, Void, Void> {
    final /* synthetic */ RtcSignalingHandler f19796a;

    RtcSignalingHandler$1(RtcSignalingHandler rtcSignalingHandler) {
        this.f19796a = rtcSignalingHandler;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected final java.lang.Object m19555a(java.lang.Object[] r5) {
        /*
        r4 = this;
        r0 = r4.f19796a;
        r0 = r0.d;
        r0 = r0.get();
        r0 = (com.facebook.push.mqtt.service.MqttPushServiceClientManagerImpl) r0;
        r1 = r0.a();
        r0 = r1.a();	 Catch:{ RemoteException -> 0x0025 }
        if (r0 != 0) goto L_0x0020;
    L_0x0014:
        r0 = "RtcSignalingHandler";
        r2 = "mqtt is not connected";
        com.facebook.debug.log.BLog.a(r0, r2);	 Catch:{ RemoteException -> 0x0025 }
        r0 = r4.f19796a;	 Catch:{ RemoteException -> 0x0025 }
        com.facebook.rtc.helpers.RtcSignalingHandler.d(r0);	 Catch:{ RemoteException -> 0x0025 }
    L_0x0020:
        r1.f();
    L_0x0023:
        r0 = 0;
        return r0;
    L_0x0025:
        r0 = move-exception;
        r2 = "RtcSignalingHandler";
        r3 = "Could not connect to mqtt";
        com.facebook.debug.log.BLog.b(r2, r3, r0);	 Catch:{ all -> 0x0031 }
        r1.f();
        goto L_0x0023;
    L_0x0031:
        r0 = move-exception;
        r1.f();
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.rtc.helpers.RtcSignalingHandler$1.a(java.lang.Object[]):java.lang.Object");
    }
}
