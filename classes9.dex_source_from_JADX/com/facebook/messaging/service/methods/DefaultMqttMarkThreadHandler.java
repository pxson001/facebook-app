package com.facebook.messaging.service.methods;

import com.facebook.common.time.AwakeTimeSinceBootClockMethodAutoProvider;
import com.facebook.common.time.MonotonicClock;
import com.facebook.common.util.JSONUtil;
import com.facebook.debug.log.BLog;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.abtest.SendMessageParametersExperiment.Config;
import com.facebook.messaging.model.threadkey.ThreadKey.Type;
import com.facebook.messaging.service.model.Mark;
import com.facebook.messaging.service.model.MarkThreadFields;
import com.facebook.messaging.sync.model.thrift.MqttThriftHeader;
import com.facebook.mqtt.model.thrift.MarkThread;
import com.facebook.mqtt.model.thrift.MarkThreadResponse;
import com.facebook.push.mqtt.service.MqttPushServiceClient;
import com.facebook.push.mqtt.service.MqttPushServiceClientManager;
import com.facebook.push.mqtt.service.MqttPushServiceClientManagerImpl;
import com.facebook.push.mqtt.service.response.JsonMqttResponseProcessor.Callback;
import com.facebook.push.mqtt.service.response.MqttResponse;
import com.facebook.push.mqtt.service.response.MqttResponseManager;
import com.facebook.push.mqtt.service.response.ThriftMqttResponseProcessor;
import com.facebook.thrift.TException;
import com.facebook.thrift.TSerializer;
import com.facebook.thrift.protocol.TCompactProtocol.Factory;
import com.facebook.thrift.protocol.TProtocol;
import com.facebook.thrift.protocol.TProtocolFactory;
import com.facebook.thrift.transport.TIOStreamTransport;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.google.common.base.Absent;
import com.google.common.base.Optional;
import java.io.ByteArrayInputStream;
import java.util.Arrays;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: dateTaken */
public class DefaultMqttMarkThreadHandler {
    private final MqttPushServiceClientManagerImpl f16871a;
    private final MonotonicClock f16872b;
    private final MqttResponseManager f16873c;
    private final Provider<Boolean> f16874d;
    private final Provider<Boolean> f16875e;

    /* compiled from: dateTaken */
    class C19871 implements Callback<MqttMarkThreadResponse> {
        final /* synthetic */ DefaultMqttMarkThreadHandler f16868a;

        public final Object m16871b(JsonNode jsonNode) {
            return new MqttMarkThreadResponse(JSONUtil.g(jsonNode.b("succeeded")), JSONUtil.b(jsonNode.b("err_str")));
        }

        C19871(DefaultMqttMarkThreadHandler defaultMqttMarkThreadHandler) {
            this.f16868a = defaultMqttMarkThreadHandler;
        }

        public final boolean m16870a(JsonNode jsonNode) {
            return jsonNode.d("succeeded");
        }
    }

    /* compiled from: dateTaken */
    class ThriftMarkThreadProcessorCallback implements ThriftMqttResponseProcessor.Callback<MqttMarkThreadResponse> {
        private final TProtocolFactory f16869a = new Factory();
        private MarkThreadResponse f16870b;

        public final void m16872a(byte[] bArr) {
            TProtocol a = this.f16869a.a(new TIOStreamTransport(new ByteArrayInputStream(bArr)));
            try {
                MqttThriftHeader.b(a);
                this.f16870b = MarkThreadResponse.b(a);
            } catch (TException e) {
                BLog.b("DefaultMqttMarkThreadHandler", e, "setPayload failed", new Object[0]);
            }
        }

        public final boolean m16873a() {
            return this.f16870b != null;
        }

        public final Object m16874b() {
            MarkThreadResponse markThreadResponse = this.f16870b;
            return new MqttMarkThreadResponse(markThreadResponse.isSucceeded.booleanValue(), markThreadResponse.errStr);
        }
    }

    public static DefaultMqttMarkThreadHandler m16875b(InjectorLike injectorLike) {
        return new DefaultMqttMarkThreadHandler(MqttPushServiceClientManagerImpl.a(injectorLike), (MonotonicClock) AwakeTimeSinceBootClockMethodAutoProvider.a(injectorLike), MqttResponseManager.a(injectorLike), IdBasedProvider.a(injectorLike, 4075), IdBasedProvider.a(injectorLike, 4077));
    }

    @Inject
    public DefaultMqttMarkThreadHandler(MqttPushServiceClientManager mqttPushServiceClientManager, MonotonicClock monotonicClock, MqttResponseManager mqttResponseManager, Provider<Boolean> provider, Provider<Boolean> provider2) {
        this.f16871a = mqttPushServiceClientManager;
        this.f16872b = monotonicClock;
        this.f16873c = mqttResponseManager;
        this.f16874d = provider;
        this.f16875e = provider2;
    }

    public final MqttResponse<MqttMarkThreadResponse> m16877a(Mark mark, MarkThreadFields markThreadFields) {
        try {
            MqttPushServiceClient a = this.f16871a.a();
            try {
                MqttResponse<MqttMarkThreadResponse> a2;
                if (((Boolean) this.f16875e.get()).booleanValue()) {
                    a2 = a.a("/t_mt_req", m16876c(mark, markThreadFields), this.f16873c.a("/t_mt_resp", new ThriftMarkThreadProcessorCallback()));
                    return a2;
                }
                ObjectNode objectNode = new ObjectNode(JsonNodeFactory.a);
                if (markThreadFields.f17204a.a == Type.ONE_TO_ONE) {
                    objectNode.a("otherUserFbId", markThreadFields.f17204a.d);
                } else {
                    objectNode.a("threadFbId", markThreadFields.f17204a.b);
                }
                objectNode.a("mark", mark.getApiName());
                objectNode.a("state", markThreadFields.f17205b);
                if (markThreadFields.f17208e != -1) {
                    objectNode.a("watermarkTimestamp", markThreadFields.f17208e);
                } else if (!((Boolean) this.f16874d.get()).booleanValue() || markThreadFields.f17207d == -1) {
                    objectNode.a("actionId", markThreadFields.f17206c);
                } else {
                    objectNode.a("syncSeqId", markThreadFields.f17207d);
                }
                a2 = a.a("/mark_thread", objectNode, this.f16873c.a("/mark_thread_response", new C19871(this)));
                a.f();
                return a2;
            } finally {
                a.f();
            }
        } catch (Exception e) {
            return MqttResponse.a(e, this.f16872b.now());
        }
    }

    public final boolean m16878b(Mark mark, MarkThreadFields markThreadFields) {
        try {
            MqttPushServiceClient a = this.f16871a.a();
            try {
                boolean a2 = a.a("/t_mt_req", m16876c(mark, markThreadFields), new Config().f7622a, 0);
                return a2;
            } finally {
                a.f();
            }
        } catch (Exception e) {
            return false;
        }
    }

    private byte[] m16876c(Mark mark, MarkThreadFields markThreadFields) {
        Optional of;
        Optional optional;
        Optional of2;
        TSerializer tSerializer = new TSerializer(new Factory());
        Optional withType = Absent.withType();
        Optional withType2 = Absent.withType();
        if (markThreadFields.f17204a.a == Type.ONE_TO_ONE) {
            of = Optional.of(Long.valueOf(markThreadFields.f17204a.d));
            optional = withType;
        } else {
            of = withType2;
            optional = Optional.of(Long.valueOf(markThreadFields.f17204a.b));
        }
        String apiName = mark.getApiName();
        Boolean valueOf = Boolean.valueOf(markThreadFields.f17205b);
        Optional withType3 = Absent.withType();
        Optional withType4 = Absent.withType();
        Optional withType5 = Absent.withType();
        Optional withType6 = Absent.withType();
        Optional withType7 = Absent.withType();
        Optional withType8 = Absent.withType();
        Optional withType9 = Absent.withType();
        if (markThreadFields.f17208e != -1) {
            withType3 = withType5;
            of2 = Optional.of(Long.valueOf(markThreadFields.f17208e));
        } else if (!((Boolean) this.f16874d.get()).booleanValue() || markThreadFields.f17207d == -1) {
            withType4 = Optional.of(Long.valueOf(markThreadFields.f17206c));
            of2 = withType3;
            withType3 = withType5;
        } else {
            of2 = withType3;
            withType3 = Optional.of(Long.valueOf(markThreadFields.f17207d));
        }
        MarkThread markThread = new MarkThread(apiName, valueOf, (String) withType6.orNull(), (Long) withType4.orNull(), (Long) withType3.orNull(), (Long) optional.orNull(), (Long) of.orNull(), (Long) withType7.orNull(), (Long) of2.orNull(), (String) withType8.orNull(), (Boolean) withType9.orNull());
        byte[] a = tSerializer.a(new MqttThriftHeader(null));
        Object a2 = tSerializer.a(markThread);
        Object copyOf = Arrays.copyOf(a, a.length + a2.length);
        System.arraycopy(a2, 0, copyOf, a.length, a2.length);
        return copyOf;
    }
}
