package com.facebook.webrtc;

import com.facebook.common.executors.FbAsyncTask;
import com.facebook.debug.log.BLog;
import com.facebook.push.mqtt.service.MqttPushServiceClient;

/* compiled from: location_opt_in_google_play_location_success */
class WebrtcManager$3 extends FbAsyncTask<Void, Void, Boolean> {
    final /* synthetic */ Runnable f9842a;
    final /* synthetic */ WebrtcManager f9843b;

    WebrtcManager$3(WebrtcManager webrtcManager, Runnable runnable) {
        this.f9843b = webrtcManager;
        this.f9842a = runnable;
    }

    protected final Object m11555a(Object[] objArr) {
        boolean z = false;
        MqttPushServiceClient a = this.f9843b.g.a();
        try {
            long now = this.f9843b.e.now() + 10000;
            while (!a.b()) {
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                }
                if (this.f9843b.e.now() > now) {
                    Object valueOf = Boolean.valueOf(false);
                    return valueOf;
                }
            }
            z = true;
            a.f();
        } catch (Throwable e2) {
            BLog.b(WebrtcManager.a, "Exception waiting for mqtt to connect", e2);
        } finally {
            a.f();
        }
        return Boolean.valueOf(z);
    }

    protected void onPostExecute(Object obj) {
        if (!((Boolean) obj).booleanValue()) {
            BLog.b(WebrtcManager.a, "Could not connect to MQTT service in %d ms", new Object[]{Long.valueOf(10000)});
        }
        this.f9842a.run();
    }
}
