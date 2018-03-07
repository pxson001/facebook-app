package com.facebook.mqttlite;

import com.facebook.common.util.Hex;
import com.facebook.mqtt.model.thrift.ClientInfo;
import com.facebook.mqtt.model.thrift.ConnPublishMessage;
import com.facebook.mqtt.model.thrift.ConnectMessage;
import com.facebook.mqtt.model.thrift.SubscribeGenericTopic;
import com.facebook.mqtt.model.thrift.SubscribeMessage;
import com.facebook.mqtt.model.thrift.TopicType;
import com.facebook.mqtt.model.thrift.UnsubscribeMessage;
import com.facebook.rti.common.log.BLog;
import com.facebook.rti.mqtt.protocol.messages.ConnectMqttMessage;
import com.facebook.rti.mqtt.protocol.messages.ConnectPayload;
import com.facebook.rti.mqtt.protocol.messages.ConnectPayloadUserName;
import com.facebook.rti.mqtt.protocol.messages.ConnectVariableHeader;
import com.facebook.rti.mqtt.protocol.messages.FixedHeader;
import com.facebook.rti.mqtt.protocol.messages.MqttPublishRequestBody;
import com.facebook.rti.mqtt.protocol.messages.SubscribeTopic;
import com.facebook.rti.mqtt.protocol.serialization.EncoderUtils;
import com.facebook.rti.mqtt.protocol.serialization.MessagePayloadEncoder;
import com.facebook.rti.mqtt.protocol.serialization.MqttPayloadCompressionUtil;
import com.facebook.rti.mqtt.protocol.sync.SyncQueueTracker;
import com.facebook.thrift.TException;
import com.facebook.thrift.TSerializer;
import com.facebook.thrift.protocol.TCompactProtocol.Factory;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/* compiled from: force_fetch_gql_notifications_from_server */
public class ThriftPayloadEncoder implements MessagePayloadEncoder {
    private static final String f23485a = ThriftPayloadEncoder.class.getSimpleName();
    private static final Map<String, Integer> f23486b;
    private final MqttPayloadCompressionUtil f23487c;
    private SyncQueueTracker f23488d;

    static {
        Map hashMap = new HashMap();
        for (Entry entry : TopicType.f23490b.entrySet()) {
            hashMap.put("/" + ((String) entry.getValue()), entry.getKey());
        }
        f23486b = hashMap;
    }

    private static Integer m31791a(String str) {
        return (Integer) f23486b.get(str);
    }

    public ThriftPayloadEncoder(MqttPayloadCompressionUtil mqttPayloadCompressionUtil) {
        this.f23487c = mqttPayloadCompressionUtil;
    }

    public final int m31795a(DataOutputStream dataOutputStream, ConnectMqttMessage connectMqttMessage) {
        FixedHeader f = connectMqttMessage.f();
        ConnectVariableHeader a = connectMqttMessage.a();
        ConnectPayload b = connectMqttMessage.b();
        BLog.b(f23485a, "mSyncQueueTracker %s", new Object[]{this.f23488d});
        try {
            byte[] a2 = MqttPayloadCompressionUtil.a(new TSerializer(new Factory()).m31914a(new ConnectMessage(b.a, b.b, b.c, m31792b(b), b.e, this.f23488d != null ? this.f23488d.a() : null, null, m31794c(b))));
            int length = a2.length + 12;
            dataOutputStream.writeByte(EncoderUtils.a(f));
            int a3 = EncoderUtils.a(dataOutputStream, length) + 1;
            dataOutputStream.writeByte(0);
            dataOutputStream.writeByte(6);
            dataOutputStream.writeByte(77);
            dataOutputStream.writeByte(81);
            dataOutputStream.writeByte(84);
            dataOutputStream.writeByte(84);
            dataOutputStream.writeByte(111);
            dataOutputStream.writeByte(84);
            dataOutputStream.write(a.a);
            dataOutputStream.write(EncoderUtils.a(a));
            dataOutputStream.writeShort(a.h);
            dataOutputStream.write(a2, 0, a2.length);
            dataOutputStream.flush();
            return a3 + length;
        } catch (TException e) {
            throw new IOException(e);
        }
    }

    public final byte[] m31798a(List<SubscribeTopic> list) {
        List arrayList = new ArrayList();
        List arrayList2 = new ArrayList();
        for (SubscribeTopic subscribeTopic : list) {
            Integer a = m31791a(subscribeTopic.a);
            if (a != null) {
                arrayList.add(a);
            } else {
                arrayList2.add(new SubscribeGenericTopic(subscribeTopic.a, Integer.valueOf(subscribeTopic.b)));
            }
        }
        try {
            return new TSerializer(new Factory()).m31914a(new SubscribeMessage(arrayList, arrayList2));
        } catch (TException e) {
            throw new UnsupportedOperationException(e);
        }
    }

    public final byte[] m31799b(List<String> list) {
        List arrayList = new ArrayList();
        List arrayList2 = new ArrayList();
        for (String str : list) {
            Integer a = m31791a(str);
            if (a != null) {
                arrayList.add(a);
            } else {
                arrayList2.add(str);
            }
        }
        try {
            return new TSerializer(new Factory()).m31914a(new UnsubscribeMessage(arrayList, arrayList2));
        } catch (TException e) {
            throw new UnsupportedOperationException(e);
        }
    }

    public final List<SubscribeTopic> m31800c(List<SubscribeTopic> list) {
        List<SubscribeTopic> arrayList = new ArrayList();
        for (SubscribeTopic subscribeTopic : list) {
            if (m31791a(subscribeTopic.a) != null) {
                arrayList.add(subscribeTopic);
            }
        }
        return arrayList;
    }

    public final void m31796a(SyncQueueTracker syncQueueTracker) {
        this.f23488d = syncQueueTracker;
    }

    public final byte[] m31797a(ConnectPayload connectPayload) {
        try {
            return new TSerializer(new Factory()).m31914a(new ConnectMessage(connectPayload.a, connectPayload.b, connectPayload.c, m31792b(connectPayload), connectPayload.e, this.f23488d != null ? this.f23488d.a() : null, null, m31794c(connectPayload)));
        } catch (TException e) {
            throw new IOException(e);
        }
    }

    private static ClientInfo m31792b(ConnectPayload connectPayload) {
        ConnectPayloadUserName connectPayloadUserName = connectPayload.d;
        if (connectPayloadUserName == null) {
            throw new IOException("No user name to fill ClientInfo");
        }
        List arrayList = new ArrayList();
        for (String a : connectPayloadUserName.p) {
            Integer a2 = m31791a(a);
            if (a2 != null) {
                arrayList.add(a2);
            } else {
                BLog.d(f23485a, "Topic %s does not have an id!", new Object[]{a});
            }
        }
        return new ClientInfo(connectPayloadUserName.a, connectPayloadUserName.b, connectPayloadUserName.c, connectPayloadUserName.l, Integer.valueOf(connectPayloadUserName.m), connectPayloadUserName.h, connectPayloadUserName.g, connectPayloadUserName.i, connectPayloadUserName.k, connectPayloadUserName.e, connectPayloadUserName.f, connectPayloadUserName.d, null, arrayList, connectPayloadUserName.n, null, null, m31793b(connectPayloadUserName.r), connectPayloadUserName.s, connectPayloadUserName.j, connectPayloadUserName.x, connectPayloadUserName.t, connectPayloadUserName.u, connectPayloadUserName.v, connectPayloadUserName.w);
    }

    private static byte[] m31793b(String str) {
        if (str == null) {
            return null;
        }
        return Hex.m32194a(str);
    }

    private static List<ConnPublishMessage> m31794c(ConnectPayload connectPayload) {
        if (connectPayload.f == null) {
            return Collections.emptyList();
        }
        List<ConnPublishMessage> arrayList = new ArrayList(connectPayload.f.size());
        for (MqttPublishRequestBody mqttPublishRequestBody : connectPayload.f) {
            arrayList.add(new ConnPublishMessage(mqttPublishRequestBody.a, Integer.valueOf(mqttPublishRequestBody.b), mqttPublishRequestBody.c));
        }
        return arrayList;
    }
}
