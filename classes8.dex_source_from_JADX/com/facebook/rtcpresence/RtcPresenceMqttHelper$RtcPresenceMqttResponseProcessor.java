package com.facebook.rtcpresence;

import com.facebook.mqtt.model.thrift.Callability;
import com.facebook.mqtt.model.thrift.CallabilityResponse;
import com.facebook.push.mqtt.service.response.ThriftMqttResponseProcessor.Callback;
import com.facebook.sync.model.thrift.MqttThriftHeader;
import com.facebook.thrift.TException;
import com.facebook.thrift.protocol.TCompactProtocol.Factory;
import com.facebook.thrift.protocol.TProtocol;
import com.facebook.thrift.transport.TIOStreamTransport;
import com.facebook.user.model.UserKey;
import com.google.common.collect.ImmutableSet;
import java.io.ByteArrayInputStream;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* compiled from: notice_title */
public class RtcPresenceMqttHelper$RtcPresenceMqttResponseProcessor implements Callback<CallabilityResponse> {
    final /* synthetic */ RtcPresenceMqttHelper f7818a;
    private final Set<Long> f7819b = new HashSet();
    private CallabilityResponse f7820c;

    public RtcPresenceMqttHelper$RtcPresenceMqttResponseProcessor(RtcPresenceMqttHelper rtcPresenceMqttHelper, ImmutableSet<UserKey> immutableSet) {
        this.f7818a = rtcPresenceMqttHelper;
        Iterator it = immutableSet.iterator();
        while (it.hasNext()) {
            this.f7819b.add(Long.valueOf(Long.parseLong(((UserKey) it.next()).b())));
        }
    }

    public final void m8056a(byte[] bArr) {
        this.f7820c = m8055b(bArr);
    }

    public final boolean m8057a() {
        if (this.f7820c == null || this.f7820c.results == null) {
            return false;
        }
        for (Callability callability : this.f7820c.results) {
            if (!this.f7819b.contains(callability.userId)) {
                return false;
            }
        }
        return true;
    }

    public final Object m8058b() {
        return this.f7820c;
    }

    private static CallabilityResponse m8055b(byte[] bArr) {
        TProtocol a = new Factory().a(new TIOStreamTransport(new ByteArrayInputStream(bArr)));
        try {
            MqttThriftHeader.b(a);
            return CallabilityResponse.b(a);
        } catch (TException e) {
            return null;
        }
    }
}
