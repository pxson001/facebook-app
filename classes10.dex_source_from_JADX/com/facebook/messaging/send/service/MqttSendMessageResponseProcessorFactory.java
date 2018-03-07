package com.facebook.messaging.send.service;

import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.errorreporting.SoftError;
import com.facebook.common.util.StringUtil;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.send.service.SendViaMqttResult.Details;
import com.facebook.mqtt.model.thrift.SendMessageResponse;
import com.facebook.push.mqtt.SendMessageMqttResponse;
import com.facebook.push.mqtt.service.response.MqttResponseManager;
import com.facebook.push.mqtt.service.response.MqttResponseProcessor;
import com.facebook.push.mqtt.service.response.ThriftMqttResponseProcessor.Callback;
import com.facebook.sync.model.MqttThriftHeaderDeserialization;
import com.facebook.thrift.TException;
import com.facebook.thrift.protocol.TCompactProtocol.Factory;
import com.facebook.thrift.transport.TIOStreamTransport;
import java.io.ByteArrayInputStream;
import javax.inject.Inject;

/* compiled from: redirect_to_app_store */
public class MqttSendMessageResponseProcessorFactory {
    public static final Class<?> f3860a = MqttSendMessageResponseProcessorFactory.class;
    public final AbstractFbErrorReporter f3861b;
    public final MqttResponseManager f3862c;
    private final MqttThriftHeaderDeserialization f3863d;

    public static MqttSendMessageResponseProcessorFactory m3625b(InjectorLike injectorLike) {
        return new MqttSendMessageResponseProcessorFactory((AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike), MqttResponseManager.a(injectorLike), MqttThriftHeaderDeserialization.a(injectorLike));
    }

    @Inject
    public MqttSendMessageResponseProcessorFactory(AbstractFbErrorReporter abstractFbErrorReporter, MqttResponseManager mqttResponseManager, MqttThriftHeaderDeserialization mqttThriftHeaderDeserialization) {
        this.f3861b = abstractFbErrorReporter;
        this.f3862c = mqttResponseManager;
        this.f3863d = mqttThriftHeaderDeserialization;
    }

    public final MqttResponseProcessor<SendMessageMqttResponse> m3626a(final long j, MqttSendMessageProtocol mqttSendMessageProtocol) {
        switch (mqttSendMessageProtocol) {
            case THRIFT:
                return this.f3862c.a(MqttSendMessageProtocol.THRIFT.getResponseTopic(), new Callback<SendMessageMqttResponse>(this) {
                    final /* synthetic */ MqttSendMessageResponseProcessorFactory f3857b;
                    private SendMessageResponse f3858c;

                    public final void m3622a(byte[] bArr) {
                        try {
                            int i = MqttThriftHeaderDeserialization.a(bArr).b;
                            this.f3858c = SendMessageResponse.b(new Factory().a(new TIOStreamTransport(new ByteArrayInputStream(bArr, i, bArr.length - i))));
                        } catch (TException e) {
                            this.f3857b.f3861b.a(SoftError.a(MqttSendMessageResponseProcessorFactory.f3860a.getSimpleName(), "Failed to read SendMessageResponse").g());
                        }
                    }

                    public final boolean m3623a() {
                        if (this.f3858c == null || this.f3858c.sendSucceeded == null) {
                            return false;
                        }
                        Long l = this.f3858c.offlineThreadingId;
                        if (l == null || l.longValue() == -1 || l.longValue() != j) {
                            return false;
                        }
                        return true;
                    }

                    public final Object m3624b() {
                        boolean booleanValue;
                        SendMessageMqttResponse sendMessageMqttResponse;
                        MqttSendMessageResponseProcessorFactory mqttSendMessageResponseProcessorFactory = this.f3857b;
                        SendMessageResponse sendMessageResponse = this.f3858c;
                        boolean booleanValue2 = sendMessageResponse.sendSucceeded.booleanValue();
                        int intValue = sendMessageResponse.errno != null ? sendMessageResponse.errno.intValue() : Details.NONE.errorCode;
                        if (sendMessageResponse.isRetryable != null) {
                            booleanValue = sendMessageResponse.isRetryable.booleanValue();
                        } else {
                            booleanValue = true;
                        }
                        Object obj = sendMessageResponse.errStr != null ? sendMessageResponse.errStr : "";
                        String str = sendMessageResponse.fbTraceMeta != null ? sendMessageResponse.fbTraceMeta : "";
                        if (!(booleanValue2 || booleanValue || !StringUtil.a(obj))) {
                            mqttSendMessageResponseProcessorFactory.f3861b.a(SoftError.a(MqttSendMessageResponseProcessorFactory.f3860a.getSimpleName(), "Empty errStr for mqtt NO_RETRY error").g());
                        }
                        if (booleanValue2) {
                            sendMessageMqttResponse = new SendMessageMqttResponse(true, Details.NONE.errorCode, false, "", str);
                        } else {
                            sendMessageMqttResponse = new SendMessageMqttResponse(false, intValue, booleanValue, obj, str);
                        }
                        return sendMessageMqttResponse;
                    }
                });
            default:
                throw new UnsupportedOperationException();
        }
    }
}
