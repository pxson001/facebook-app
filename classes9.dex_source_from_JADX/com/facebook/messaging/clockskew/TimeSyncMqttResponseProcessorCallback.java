package com.facebook.messaging.clockskew;

import com.facebook.debug.log.BLog;
import com.facebook.mqtt.model.thrift.TimeSyncResponse;
import com.facebook.push.mqtt.service.response.ThriftMqttResponseProcessor.Callback;
import com.facebook.sync.model.thrift.MqttThriftHeader;
import com.facebook.thrift.TException;
import com.facebook.thrift.protocol.TCompactProtocol.Factory;
import com.facebook.thrift.protocol.TProtocol;
import com.facebook.thrift.protocol.TProtocolFactory;
import com.facebook.thrift.transport.TIOStreamTransport;
import java.io.ByteArrayInputStream;

/* compiled from: messenger_pay_amount */
public class TimeSyncMqttResponseProcessorCallback implements Callback<TimeSyncResponse> {
    private final TProtocolFactory f9783a = new Factory();
    private TimeSyncResponse f9784b;

    public final void m10352a(byte[] bArr) {
        TProtocol a = this.f9783a.a(new TIOStreamTransport(new ByteArrayInputStream(bArr)));
        try {
            MqttThriftHeader.b(a);
            this.f9784b = TimeSyncResponse.b(a);
        } catch (TException e) {
            BLog.b("TimeSyncMqttResponseProcessorCallback", e, "setPayload failed", new Object[0]);
        }
    }

    public final boolean m10353a() {
        return this.f9784b != null;
    }

    public final Object m10354b() {
        return this.f9784b;
    }
}
