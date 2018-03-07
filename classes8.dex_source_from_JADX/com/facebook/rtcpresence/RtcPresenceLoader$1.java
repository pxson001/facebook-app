package com.facebook.rtcpresence;

import com.facebook.mqtt.model.thrift.Callability;
import com.facebook.mqtt.model.thrift.CallabilityResponse;
import com.facebook.push.mqtt.service.MqttPushServiceClient;
import com.facebook.push.mqtt.service.response.MqttResponse;
import com.facebook.user.model.UserKey;
import com.google.common.collect.ImmutableSet;
import java.util.concurrent.Callable;

/* compiled from: notice_title_color */
public class RtcPresenceLoader$1 implements Callable<RtcPresenceResult> {
    final /* synthetic */ ImmutableSet f7812a;
    final /* synthetic */ RtcPresenceLoader f7813b;

    public RtcPresenceLoader$1(RtcPresenceLoader rtcPresenceLoader, ImmutableSet immutableSet) {
        this.f7813b = rtcPresenceLoader;
        this.f7812a = immutableSet;
    }

    public Object call() {
        RtcPresenceMqttHelper$RtcPresenceMqttResponseProcessor b = this.f7813b.l.b(this.f7812a);
        MqttPushServiceClient a = this.f7813b.i.a();
        try {
            RtcPresenceLoader.a(this.f7813b);
            MqttResponse a2 = a.a("/t_callability_req", RtcPresenceMqttHelper.a(this.f7812a), this.f7813b.k.a("/t_callability_resp", b));
            if (a2 == null) {
                throw new Exception("ipc call failed");
            } else if (!a2.a) {
                throw new Exception(a2.d);
            } else if (a2.b == null) {
                throw new Exception("empty response");
            } else {
                RtcPresenceResult rtcPresenceResult = new RtcPresenceResult();
                for (Callability callability : ((CallabilityResponse) a2.b).results) {
                    rtcPresenceResult.m8060a(UserKey.b(String.valueOf(callability.userId)), this.f7813b.m.a(callability));
                }
                return rtcPresenceResult;
            }
        } finally {
            a.f();
        }
    }
}
