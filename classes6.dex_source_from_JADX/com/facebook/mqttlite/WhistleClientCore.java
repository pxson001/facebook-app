package com.facebook.mqttlite;

import com.facebook.debug.log.BLog;
import com.facebook.mqttlite.ThreadSafeMqttClient.C01452;
import com.facebook.mqttlite.ThreadSafeMqttClient.C01463;
import com.facebook.mqttlite.ThreadSafeMqttClient.C01474;
import com.facebook.mqttlite.ThreadSafeMqttClient.C01485;
import com.facebook.mqttlite.ThreadSafeMqttClient.C01497;
import com.facebook.mqttlite.ThreadSafeMqttClient.C01508;
import com.facebook.mqttlite.ThreadSafeMqttClient.C01519;
import com.facebook.proxygen.ConnectionParams;
import com.facebook.proxygen.ConnectionParams.PublishFormat;
import com.facebook.proxygen.MQTTClient;
import com.facebook.proxygen.MQTTClientCallback;
import com.facebook.proxygen.MQTTClientError;
import com.facebook.proxygen.MQTTClientError.MQTTErrorType;
import com.facebook.proxygen.MQTTClientFactory;
import com.facebook.rti.common.time.SystemClock;
import com.facebook.rti.common.util.StringUtil;
import com.facebook.rti.mqtt.common.analytics.DisconnectDetailReason;
import com.facebook.rti.mqtt.common.analytics.MqttAnalyticsLogger;
import com.facebook.rti.mqtt.credentials.MqttAuthenticationKeySecretPair;
import com.facebook.rti.mqtt.credentials.MqttDeviceIdAndSecret;
import com.facebook.rti.mqtt.protocol.ConnectResult;
import com.facebook.rti.mqtt.protocol.ConnectionFailureReason;
import com.facebook.rti.mqtt.protocol.ConnectionState;
import com.facebook.rti.mqtt.protocol.MqttClient.1;
import com.facebook.rti.mqtt.protocol.MqttClient.2;
import com.facebook.rti.mqtt.protocol.MqttClientCore;
import com.facebook.rti.mqtt.protocol.Operation;
import com.facebook.rti.mqtt.protocol.messages.ConnAckPayload;
import com.facebook.rti.mqtt.protocol.messages.ConnectPayload;
import com.facebook.rti.mqtt.protocol.messages.FixedHeader;
import com.facebook.rti.mqtt.protocol.messages.MessageIdVariableHeader;
import com.facebook.rti.mqtt.protocol.messages.MessageType;
import com.facebook.rti.mqtt.protocol.messages.MqttMessage;
import com.facebook.rti.mqtt.protocol.messages.PubAckMessage;
import com.facebook.rti.mqtt.protocol.messages.PublishMqttMessage;
import com.facebook.rti.mqtt.protocol.messages.PublishVariableHeader;
import com.facebook.rti.mqtt.protocol.messages.SubscribeTopic;
import com.facebook.rti.mqtt.protocol.sync.SyncQueueTracker;
import com.facebook.tools.dextr.runtime.detour.ExecutorDetour;
import java.io.EOFException;
import java.io.IOException;
import java.net.SocketException;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.zip.DataFormatException;

/* compiled from: time_position */
public class WhistleClientCore implements MqttClientCore {
    public static final String f3042a = WhistleClientCore.class.getSimpleName();
    private ThreadSafeMqttClient f3043b;
    private final ThriftPayloadEncoder f3044c;
    public final SystemClock f3045d;
    private final MQTTClientCallback f3046e = new C01521(this);
    public 2 f3047f;
    private WhistleByteLogger f3048g;

    /* compiled from: time_position */
    class C01521 implements MQTTClientCallback {
        final /* synthetic */ WhistleClientCore f3039a;

        public void onConnectFailure(MQTTClientError mQTTClientError) {
            ConnectionFailureReason connectionFailureReason;
            String str = WhistleClientCore.f3042a;
            this.f3039a.m4030a();
            byte b = (byte) mQTTClientError.mConnAckCode;
            switch (b) {
                case (byte) 4:
                    connectionFailureReason = ConnectionFailureReason.FAILED_CONNECTION_REFUSED_BAD_USER_NAME_OR_PASSWORD;
                    break;
                case (byte) 5:
                    connectionFailureReason = ConnectionFailureReason.FAILED_CONNECTION_REFUSED_NOT_AUTHORIZED;
                    break;
                case (byte) 17:
                    connectionFailureReason = ConnectionFailureReason.FAILED_CONNECTION_REFUSED_SERVER_SHEDDING_LOAD;
                    break;
                case (byte) 19:
                    connectionFailureReason = ConnectionFailureReason.FAILED_CONNECTION_UNKNOWN_CONNECT_HASH;
                    break;
                default:
                    connectionFailureReason = ConnectionFailureReason.FAILED_CONNECTION_REFUSED;
                    break;
            }
            this.f3039a.f3047f.a(new ConnectResult(connectionFailureReason, b));
        }

        public void onPingRequestFailure(MQTTClientError mQTTClientError) {
            String str = WhistleClientCore.f3042a;
            Throwable a = WhistleClientCore.m4027a(this.f3039a, mQTTClientError);
            this.f3039a.f3047f.a(DisconnectDetailReason.getFromWriteException(a), Operation.PING, a);
        }

        public void onPingRequestSent() {
            String str = WhistleClientCore.f3042a;
            this.f3039a.f3047f.a(MessageType.PINGREQ.name(), "");
        }

        public void onPingResponse() {
            String str = WhistleClientCore.f3042a;
            this.f3039a.f3047f.a(WhistleClientCore.m4026a(this.f3039a, MessageType.PINGRESP, 0));
        }

        public void onPublishAck(int i) {
            String str = WhistleClientCore.f3042a;
            Integer.valueOf(i);
            this.f3039a.f3047f.a(WhistleClientCore.m4026a(this.f3039a, MessageType.PUBACK, i));
        }

        public void onPublishAckFailure(MQTTClientError mQTTClientError) {
            String str = WhistleClientCore.f3042a;
            Throwable a = WhistleClientCore.m4027a(this.f3039a, mQTTClientError);
            this.f3039a.f3047f.a(DisconnectDetailReason.getFromWriteException(a), Operation.PUBACK, a);
        }

        public void onPublishFailure(int i, MQTTClientError mQTTClientError) {
            String str = WhistleClientCore.f3042a;
            Integer.valueOf(i);
            Throwable a = WhistleClientCore.m4027a(this.f3039a, mQTTClientError);
            this.f3039a.f3047f.a(DisconnectDetailReason.getFromWriteException(a), Operation.PUBLISH, a);
        }

        public void onPublishSent(String str, int i) {
            String str2 = WhistleClientCore.f3042a;
            Integer.valueOf(i);
            this.f3039a.f3047f.a(MessageType.PUBLISH.name(), str);
        }

        public void onUnsubscribeAck(int i) {
            String str = WhistleClientCore.f3042a;
            Integer.valueOf(i);
            this.f3039a.f3047f.a(WhistleClientCore.m4026a(this.f3039a, MessageType.UNSUBACK, i));
        }

        public void onUnsubscribeFailure(int i, MQTTClientError mQTTClientError) {
            String str = WhistleClientCore.f3042a;
            Integer.valueOf(i);
            Throwable a = WhistleClientCore.m4027a(this.f3039a, mQTTClientError);
            this.f3039a.f3047f.a(DisconnectDetailReason.getFromWriteException(a), Operation.UNSUBSCRIBE, a);
        }

        C01521(WhistleClientCore whistleClientCore) {
            this.f3039a = whistleClientCore;
        }

        public void onConnectSuccess(byte[] bArr) {
            WhistleClientCore.f3042a;
            try {
                MqttDeviceIdAndSecret mqttDeviceIdAndSecret;
                ConnAckPayload a = ConnAckPayload.a(new String(bArr, "UTF-8"));
                this.f3039a.f3047f.a(a.e);
                if (StringUtil.a(a.c) || StringUtil.a(a.d)) {
                    mqttDeviceIdAndSecret = MqttDeviceIdAndSecret.a;
                } else {
                    mqttDeviceIdAndSecret = new MqttDeviceIdAndSecret(a.c, a.d, this.f3039a.f3045d.a());
                }
                ConnectResult connectResult = new ConnectResult(MqttAuthenticationKeySecretPair.a(StringUtil.c(a.a), StringUtil.c(a.b)), mqttDeviceIdAndSecret);
                this.f3039a.f3047f.b(ConnectionState.CONNECTED);
                this.f3039a.f3047f.b();
                this.f3039a.f3047f.a(connectResult);
            } catch (Exception e) {
                WhistleClientCore.f3042a;
                new Object[1][0] = Arrays.toString(bArr);
                this.f3039a.f3047f.a(new ConnectResult(ConnectionFailureReason.FAILED_CONNACK_READ, e));
            }
        }

        @Deprecated
        public void onSubscribeAck(int i) {
            BLog.b(WhistleClientCore.f3042a, "SubAck msgId=%d, messageId");
            this.f3039a.f3047f.a(WhistleClientCore.m4026a(this.f3039a, MessageType.SUBACK, i));
        }

        @Deprecated
        public void onSubscribeFailure(int i, MQTTClientError mQTTClientError) {
            BLog.b(WhistleClientCore.f3042a, "Subscribe should not be used");
            Throwable a = WhistleClientCore.m4027a(this.f3039a, mQTTClientError);
            this.f3039a.f3047f.a(DisconnectDetailReason.getFromWriteException(a), Operation.SUBSCRIBE, a);
        }

        public void onPublish(String str, byte[] bArr, int i, int i2) {
            PublishMqttMessage publishMqttMessage = new PublishMqttMessage(new FixedHeader(MessageType.PUBLISH, i), new PublishVariableHeader(str, i2), bArr);
            String str2 = WhistleClientCore.f3042a;
            Integer.valueOf(i);
            Integer.valueOf(i2);
            this.f3039a.f3047f.a(publishMqttMessage);
        }

        public void onError(MQTTClientError mQTTClientError) {
            BLog.a(WhistleClientCore.f3042a, "onError=%s", new Object[]{mQTTClientError});
            if (mQTTClientError.mErrType.equals(MQTTErrorType.DISCONNECT)) {
                this.f3039a.f3047f.a(DisconnectDetailReason.DISCONNECT_FROM_SERVER, Operation.NETWORK_THREAD_LOOP, null);
            } else if (mQTTClientError.mErrType.equals(MQTTErrorType.STOPPED_BEFORE_MQTT_CONNECT)) {
                this.f3039a.f3047f.a(DisconnectDetailReason.ABORTED_PREEMPTIVE_RECONNECT, Operation.NETWORK_THREAD_LOOP, null);
            } else {
                Throwable a = WhistleClientCore.m4027a(this.f3039a, mQTTClientError);
                this.f3039a.f3047f.a(DisconnectDetailReason.getFromReadException(a), Operation.NETWORK_THREAD_LOOP, a);
            }
        }
    }

    /* compiled from: time_position */
    public /* synthetic */ class C01532 {
        public static final /* synthetic */ int[] f3041b = new int[MessageType.values().length];

        static {
            try {
                f3041b[MessageType.PUBACK.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            f3040a = new int[MQTTErrorType.values().length];
            try {
                f3040a[MQTTErrorType.PARSE_ERROR.ordinal()] = 1;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f3040a[MQTTErrorType.CONNECTION_CLOSED.ordinal()] = 2;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f3040a[MQTTErrorType.TRANSPORT_CONNECT_ERROR.ordinal()] = 3;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f3040a[MQTTErrorType.WRITE_ERROR.ordinal()] = 4;
            } catch (NoSuchFieldError e5) {
            }
            try {
                f3040a[MQTTErrorType.COMPRESSION_ERROR.ordinal()] = 5;
            } catch (NoSuchFieldError e6) {
            }
            try {
                f3040a[MQTTErrorType.READ_ERROR.ordinal()] = 6;
            } catch (NoSuchFieldError e7) {
            }
            try {
                f3040a[MQTTErrorType.EOF.ordinal()] = 7;
            } catch (NoSuchFieldError e8) {
            }
        }
    }

    static /* synthetic */ Throwable m4027a(WhistleClientCore whistleClientCore, MQTTClientError mQTTClientError) {
        Throwable dataFormatException;
        String str = mQTTClientError.mErrMsg;
        switch (mQTTClientError.mErrType) {
            case PARSE_ERROR:
                dataFormatException = new DataFormatException(str);
                break;
            case CONNECTION_CLOSED:
                dataFormatException = new SocketException(str);
                break;
            case TRANSPORT_CONNECT_ERROR:
                dataFormatException = new SocketException(str);
                break;
            case WRITE_ERROR:
            case COMPRESSION_ERROR:
                dataFormatException = new DataFormatException(str);
                break;
            case READ_ERROR:
                dataFormatException = new IOException(str);
                break;
            case EOF:
                dataFormatException = new EOFException(str);
                break;
            default:
                dataFormatException = new RuntimeException(str);
                break;
        }
        return dataFormatException;
    }

    public WhistleClientCore(int i, int i2, MQTTClientFactory mQTTClientFactory, SystemClock systemClock, boolean z, MqttAnalyticsLogger mqttAnalyticsLogger, Executor executor, boolean z2) {
        PublishFormat publishFormat;
        this.f3045d = systemClock;
        this.f3044c = new ThriftPayloadEncoder(null);
        ConnectionParams connectionParams = new ConnectionParams();
        switch (i) {
            case 1:
                publishFormat = PublishFormat.ZLIB;
                break;
            case 2:
                publishFormat = PublishFormat.ZLIB_OPTIONAL;
                break;
            default:
                publishFormat = PublishFormat.NONE;
                break;
        }
        connectionParams.publishFormat = publishFormat;
        connectionParams.keepaliveSecs = i2;
        connectionParams.clientId = "";
        connectionParams.enableTopicEncoding = z2;
        MQTTClient mQTTClient = new MQTTClient(mQTTClientFactory, this.f3046e, connectionParams);
        if (z) {
            mQTTClient.mLogger = new WhistleAnalyticsLogger(mqttAnalyticsLogger);
            this.f3048g = new WhistleByteLogger();
            mQTTClient.mByteEventLogger = this.f3048g;
        }
        mQTTClient.init();
        this.f3043b = new ThreadSafeMqttClient(mQTTClient, executor);
    }

    public final void m4033a(SyncQueueTracker syncQueueTracker) {
        this.f3044c.a(syncQueueTracker);
    }

    public final void m4032a(2 2, 1 1) {
        this.f3047f = 2;
        if (this.f3048g != null) {
            this.f3048g.f3038a = 1;
        }
    }

    public final void m4034a(String str, int i, boolean z, ConnectPayload connectPayload, int i2, boolean z2) {
        int i3 = 1;
        try {
            Object[] objArr = new Object[]{str, Integer.valueOf(i), Boolean.valueOf(z), Integer.valueOf(i2), Boolean.valueOf(z2)};
            byte[] a = this.f3044c.a(connectPayload);
            this.f3043b.m4025a(str, i, a, 0, a.length, z2);
        } catch (Throwable e) {
            Object[] objArr2 = new Object[i3];
            objArr2[0] = connectPayload;
            BLog.a(f3042a, e, "Failed to encode connectPayload=%s", objArr2);
            this.f3047f.a(new ConnectResult(ConnectionFailureReason.FAILED_CONNECT_MESSAGE, e));
        }
    }

    public final void m4030a() {
        ThreadSafeMqttClient threadSafeMqttClient = this.f3043b;
        ExecutorDetour.a(threadSafeMqttClient.f3035c, new C01485(threadSafeMqttClient), -1174877512);
        threadSafeMqttClient = this.f3043b;
        ExecutorDetour.a(threadSafeMqttClient.f3035c, new C01519(threadSafeMqttClient), 496678445);
        this.f3047f.b(ConnectionState.DISCONNECTED);
        this.f3047f.b();
    }

    @Deprecated
    public final void m4036a(List<SubscribeTopic> list, int i) {
        String[] strArr = new String[list.size()];
        int[] iArr = new int[list.size()];
        for (int i2 = 0; i2 < list.size(); i2++) {
            SubscribeTopic subscribeTopic = (SubscribeTopic) list.get(i2);
            strArr[i2] = subscribeTopic.a;
            iArr[i2] = subscribeTopic.b;
        }
        ThreadSafeMqttClient threadSafeMqttClient = this.f3043b;
        ExecutorDetour.a(threadSafeMqttClient.f3035c, new C01452(threadSafeMqttClient, strArr, iArr), 2090114271);
    }

    public final void m4038b(List<String> list, int i) {
        String[] strArr = new String[list.size()];
        list.toArray(strArr);
        Arrays.toString(strArr);
        Integer.valueOf(i);
        ThreadSafeMqttClient threadSafeMqttClient = this.f3043b;
        ExecutorDetour.a(threadSafeMqttClient.f3035c, new C01463(threadSafeMqttClient, strArr, i), 633107089);
    }

    public final void m4035a(String str, byte[] bArr, int i, int i2) {
        Integer.valueOf(i);
        Integer.valueOf(i2);
        ThreadSafeMqttClient threadSafeMqttClient = this.f3043b;
        ExecutorDetour.a(threadSafeMqttClient.f3035c, new C01474(threadSafeMqttClient, str, bArr, i, i2), -211729750);
    }

    public final void m4039c() {
        ThreadSafeMqttClient threadSafeMqttClient = this.f3043b;
        ExecutorDetour.a(threadSafeMqttClient.f3035c, new C01497(threadSafeMqttClient), -890984697);
    }

    public final void m4031a(int i, Object obj) {
    }

    public final String m4040d() {
        return "";
    }

    public final String m4041e() {
        return "";
    }

    public final void m4037b() {
        ThreadSafeMqttClient threadSafeMqttClient = this.f3043b;
        ExecutorDetour.a(threadSafeMqttClient.f3035c, new C01508(threadSafeMqttClient), -378647603);
    }

    public final String m4029a(PublishMqttMessage publishMqttMessage) {
        return publishMqttMessage.a().a;
    }

    public final byte m4042f() {
        return (byte) 4;
    }

    static /* synthetic */ MqttMessage m4026a(WhistleClientCore whistleClientCore, MessageType messageType, int i) {
        MqttMessage pubAckMessage;
        FixedHeader fixedHeader = new FixedHeader(messageType);
        MessageIdVariableHeader messageIdVariableHeader = new MessageIdVariableHeader(i);
        switch (C01532.f3041b[messageType.ordinal()]) {
            case 1:
                pubAckMessage = new PubAckMessage(fixedHeader, messageIdVariableHeader);
                break;
            default:
                pubAckMessage = new MqttMessage(fixedHeader, messageIdVariableHeader, null);
                break;
        }
        return pubAckMessage;
    }
}
