package com.facebook.mqttlite;

import com.facebook.fbtrace.FbTraceEvent;
import com.facebook.fbtrace.FbTraceEventAnnotations;
import com.facebook.fbtrace.FbTraceEventAnnotationsUtil;
import com.facebook.fbtrace.FbTraceNode;
import com.facebook.fbtrace.FbTracer;
import com.facebook.messaging.sync.model.thrift.MqttThriftHeader;
import com.facebook.rti.common.fbtrace.FbTraceLogger;
import com.facebook.thrift.TException;
import com.facebook.thrift.TSerializer;
import com.facebook.thrift.protocol.TCompactProtocol.Factory;
import com.facebook.thrift.transport.TIOStreamTransport;
import java.io.ByteArrayInputStream;
import javax.inject.Provider;

/* compiled from: fonts/Roboto-Light.ttf */
public class MqttFbTraceLogger implements FbTraceLogger {
    private final FbTracer f23510a;
    private final Provider<Boolean> f23511b;

    public MqttFbTraceLogger(FbTracer fbTracer, Provider<Boolean> provider) {
        this.f23510a = fbTracer;
        this.f23511b = provider;
    }

    public final Object m31830a(String str, byte[] bArr) {
        if (!str.startsWith("/t_")) {
            return FbTraceNode.f7566a;
        }
        try {
            MqttThriftHeader a = m31828a(bArr);
            if (a.traceInfo == null || a.traceInfo.length() != 22) {
                return FbTraceNode.f7566a;
            }
            FbTraceNode b = this.f23510a.m31714b(a.traceInfo);
            FbTraceEventAnnotations a2 = FbTraceEventAnnotationsUtil.a(b);
            a2.put("op", "mqtt_publish_received");
            a2.put("service", "receiver_mqtt_client");
            a2.put("appfg", this.f23511b.get());
            this.f23510a.m31713a(b, FbTraceEvent.REQUEST_RECEIVE, a2);
            FbTraceNode a3 = FbTracer.m31707a(b);
            String a4 = a3.m12159a();
            if (a4.length() != a.traceInfo.length() && !a4.equals(a.traceInfo)) {
                return FbTraceNode.f7566a;
            }
            this.f23510a.m31713a(a3, FbTraceEvent.REQUEST_SEND, FbTraceEventAnnotationsUtil.a(a3));
            Object a5 = m31829a(new MqttThriftHeader(a4));
            System.arraycopy(a5, 0, bArr, 0, a5.length);
            this.f23510a.m31713a(a3, FbTraceEvent.RESPONSE_RECEIVE, null);
            return b;
        } catch (TException e) {
            return FbTraceNode.f7566a;
        }
    }

    public final void m31831a(Object obj, boolean z, String str) {
        FbTraceNode fbTraceNode = (FbTraceNode) obj;
        FbTraceEventAnnotations a = FbTraceEventAnnotationsUtil.a(fbTraceNode);
        a.put("success", z ? "true" : "false");
        if (str != null) {
            a.put("error_code", str);
        }
        this.f23510a.m31713a(fbTraceNode, FbTraceEvent.RESPONSE_SEND, a);
    }

    public final Object m31832b(String str, byte[] bArr) {
        if (!str.startsWith("/t_")) {
            return FbTraceNode.f7566a;
        }
        try {
            MqttThriftHeader a = m31828a(bArr);
            if (a.traceInfo == null || a.traceInfo.length() != 22) {
                return FbTraceNode.f7566a;
            }
            FbTraceNode b = this.f23510a.m31714b(a.traceInfo);
            FbTraceEventAnnotations a2 = FbTraceEventAnnotationsUtil.a(b);
            a2.put("op", "mqtt_publish_send");
            a2.put("service", "sender_mqtt_client");
            this.f23510a.m31713a(b, FbTraceEvent.REQUEST_RECEIVE, a2);
            FbTraceNode a3 = FbTracer.m31707a(b);
            String a4 = a3.m12159a();
            if (a4.length() != a.traceInfo.length()) {
                return FbTraceNode.f7566a;
            }
            FbTraceEventAnnotations a5 = FbTraceEventAnnotationsUtil.a(a3);
            a5.put("op", "proxygen_publish_send");
            this.f23510a.m31713a(a3, FbTraceEvent.REQUEST_SEND, a5);
            Object a6 = m31829a(new MqttThriftHeader(a4));
            System.arraycopy(a6, 0, bArr, 0, a6.length);
            return b;
        } catch (TException e) {
            return FbTraceNode.f7566a;
        }
    }

    public final void m31833b(Object obj, boolean z, String str) {
        FbTraceNode fbTraceNode = (FbTraceNode) obj;
        FbTraceEventAnnotations a = FbTraceEventAnnotationsUtil.a(fbTraceNode);
        a.put("success", z ? "true" : "false");
        if (str != null) {
            a.put("error_code", str);
        }
        this.f23510a.m31713a(fbTraceNode, FbTraceEvent.RESPONSE_SEND, a);
    }

    private static MqttThriftHeader m31828a(byte[] bArr) {
        return MqttThriftHeader.b(new Factory().mo3465a(new TIOStreamTransport(new ByteArrayInputStream(bArr))));
    }

    private static byte[] m31829a(MqttThriftHeader mqttThriftHeader) {
        return new TSerializer(new Factory()).m31914a(mqttThriftHeader);
    }
}
