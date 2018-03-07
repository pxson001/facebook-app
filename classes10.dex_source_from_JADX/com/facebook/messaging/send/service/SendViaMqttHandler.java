package com.facebook.messaging.send.service;

import android.os.RemoteException;
import com.facebook.common.network.FbNetworkManager;
import com.facebook.common.time.AwakeTimeSinceBootClockMethodAutoProvider;
import com.facebook.common.time.Clock;
import com.facebook.common.time.MonotonicClock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.debug.log.BLog;
import com.facebook.fbservice.results.DataFreshnessResult;
import com.facebook.fbtrace.FbTraceEvent;
import com.facebook.fbtrace.FbTraceEventAnnotations;
import com.facebook.fbtrace.FbTraceEventAnnotationsUtil;
import com.facebook.fbtrace.FbTraceNode;
import com.facebook.fbtrace.FbTracer;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.abtest.SendMessageParametersExperiment.Config;
import com.facebook.messaging.analytics.perf.LatencyLogger;
import com.facebook.messaging.analytics.reliability.MessagesReliabilityLogger;
import com.facebook.messaging.cache.MessagesBroadcaster;
import com.facebook.messaging.database.threads.DbClock;
import com.facebook.messaging.model.messages.Message;
import com.facebook.messaging.model.messages.Message.SendChannel;
import com.facebook.messaging.model.messages.MessageType;
import com.facebook.messaging.model.threads.ActionIdHelper;
import com.facebook.messaging.send.service.SendViaMqttResult.Details;
import com.facebook.messaging.service.model.NewMessageResult;
import com.facebook.messaging.service.model.SendMessageParams;
import com.facebook.push.mqtt.SendMessageMqttResponse;
import com.facebook.push.mqtt.external.RefCode;
import com.facebook.push.mqtt.service.MqttPushServiceClient;
import com.facebook.push.mqtt.service.MqttPushServiceClientManagerImpl;
import com.facebook.push.mqtt.service.response.MqttResponseProcessor;
import com.google.common.base.Throwables;
import java.io.IOException;
import javax.inject.Inject;

/* compiled from: recent_item_image_height */
public class SendViaMqttHandler {
    private static final Class<?> f3950a = SendViaMqttHandler.class;
    private final MqttPushServiceClientManagerImpl f3951b;
    private final MessagesBroadcaster f3952c;
    private final MonotonicClock f3953d;
    private final Clock f3954e;
    private final Clock f3955f;
    private final FbNetworkManager f3956g;
    private final MessagesReliabilityLogger f3957h;
    private final LatencyLogger f3958i;
    private final MqttSendMessageSerializer f3959j;
    private final MqttSendMessageResponseProcessorFactory f3960k;
    private final FbTracer f3961l;
    private final RefCode f3962m;

    public static SendViaMqttHandler m3693a(InjectorLike injectorLike) {
        return new SendViaMqttHandler(MqttPushServiceClientManagerImpl.a(injectorLike), MessagesBroadcaster.a(injectorLike), (MonotonicClock) AwakeTimeSinceBootClockMethodAutoProvider.a(injectorLike), (Clock) DbClock.a(injectorLike), (Clock) SystemClockMethodAutoProvider.a(injectorLike), FbNetworkManager.a(injectorLike), MessagesReliabilityLogger.b(injectorLike), LatencyLogger.a(injectorLike), MqttSendMessageSerializer.m3631b(injectorLike), MqttSendMessageResponseProcessorFactory.m3625b(injectorLike), FbTracer.a(injectorLike), RefCode.a(injectorLike));
    }

    @Inject
    public SendViaMqttHandler(MqttPushServiceClientManagerImpl mqttPushServiceClientManagerImpl, MessagesBroadcaster messagesBroadcaster, MonotonicClock monotonicClock, Clock clock, Clock clock2, FbNetworkManager fbNetworkManager, MessagesReliabilityLogger messagesReliabilityLogger, LatencyLogger latencyLogger, MqttSendMessageSerializer mqttSendMessageSerializer, MqttSendMessageResponseProcessorFactory mqttSendMessageResponseProcessorFactory, FbTracer fbTracer, RefCode refCode) {
        this.f3951b = mqttPushServiceClientManagerImpl;
        this.f3952c = messagesBroadcaster;
        this.f3953d = monotonicClock;
        this.f3954e = clock;
        this.f3955f = clock2;
        this.f3956g = fbNetworkManager;
        this.f3957h = messagesReliabilityLogger;
        this.f3958i = latencyLogger;
        this.f3959j = mqttSendMessageSerializer;
        this.f3960k = mqttSendMessageResponseProcessorFactory;
        this.f3961l = fbTracer;
        this.f3962m = refCode;
    }

    public final SendViaMqttResult m3696a(SendMessageParams sendMessageParams, Config config, int i, long j) {
        return m3694a(sendMessageParams, config, i, MqttSendMessageProtocol.THRIFT, j);
    }

    private SendViaMqttResult m3694a(SendMessageParams sendMessageParams, Config config, int i, MqttSendMessageProtocol mqttSendMessageProtocol, long j) {
        try {
            MqttPushServiceClient a = this.f3951b.a();
            try {
                SendViaMqttResult a2 = m3695a(sendMessageParams, config, a, i, mqttSendMessageProtocol, j);
                return a2;
            } finally {
                a.f();
            }
        } catch (Throwable e) {
            Exception exception = e;
            for (Throwable e2 : Throwables.getCausalChain(exception)) {
                if (e2 instanceof Exception) {
                    Exception exception2 = (Exception) e2;
                    if (exception2 instanceof RemoteException) {
                        return SendViaMqttResult.m3702a(exception, Details.MQTT_REMOTEEXCEPTION.errorCode);
                    }
                    if (exception2 instanceof IOException) {
                        return SendViaMqttResult.m3702a(exception, Details.MQTT_IOEXCEPTION.errorCode);
                    }
                }
                throw Throwables.propagate(e2);
            }
            BLog.b(f3950a, "Exception while sending message over mqtt", exception);
            return SendViaMqttResult.m3702a(exception, Details.MQTT_EXCEPTION.errorCode);
        }
    }

    private SendViaMqttResult m3695a(SendMessageParams sendMessageParams, Config config, MqttPushServiceClient mqttPushServiceClient, int i, MqttSendMessageProtocol mqttSendMessageProtocol, long j) {
        MqttResponseProcessor a = this.f3960k.m3626a(Long.parseLong(sendMessageParams.a.n), mqttSendMessageProtocol);
        a.c();
        try {
            long j2 = config.a;
            long j3 = config.b;
            long now = this.f3953d.now();
            Integer num = (Integer) this.f3962m.get();
            SendViaMqttResult a2;
            try {
                FbTraceNode a3 = FbTracer.a(sendMessageParams.c);
                byte[] a4 = this.f3959j.m3632a(sendMessageParams, a3, mqttSendMessageProtocol, num);
                FbTraceEventAnnotations a5 = FbTraceEventAnnotationsUtil.a(a3);
                a5.put("op", "mqtt_send_attempt");
                a5.put("attempt_number", Integer.valueOf(i));
                this.f3961l.a(a3, FbTraceEvent.REQUEST_SEND, a5);
                try {
                    if (mqttPushServiceClient.a(mqttSendMessageProtocol.getRequestTopic(), a4, j2, j, num)) {
                        this.f3961l.a(a3, FbTraceEvent.RESPONSE_RECEIVE, null);
                        this.f3952c.a(sendMessageParams.a.b, sendMessageParams.a.n);
                        this.f3957h.a(sendMessageParams, this.f3953d.now() - now);
                        this.f3958i.a(sendMessageParams.a.n);
                        long now2 = (j2 + j3) - (this.f3953d.now() - now);
                        if (a.e() == null && now2 < 0) {
                            a2 = SendViaMqttResult.m3700a(Details.SEND_FAILED_TIMED_OUT_AFTER_PUBLISH, Details.SEND_FAILED_TIMED_OUT_AFTER_PUBLISH.errorCode, true);
                            a.d();
                            return a2;
                        } else if (!a.a(now2)) {
                            now2 = (j2 + j3) - (this.f3953d.now() - now);
                            if (now2 > 0) {
                                this.f3956g.a(now2);
                            }
                            a2 = SendViaMqttResult.m3700a(Details.SEND_FAILED_TIMED_OUT_WAITING_FOR_RESPONSE, Details.SEND_FAILED_TIMED_OUT_WAITING_FOR_RESPONSE.errorCode, true);
                            a.d();
                            return a2;
                        } else if (((SendMessageMqttResponse) a.e()).a) {
                            a.d();
                            now2 = this.f3954e.a();
                            return SendViaMqttResult.m3701a(new NewMessageResult(DataFreshnessResult.FROM_SERVER, Message.newBuilder().a(sendMessageParams.a).a(MessageType.REGULAR).a(now2).a(SendChannel.MQTT).c(ActionIdHelper.a(now2)).R(), null, null, this.f3955f.a()), true);
                        } else if (((SendMessageMqttResponse) a.e()).c) {
                            a2 = SendViaMqttResult.m3700a(Details.SEND_FAILED_SERVER_RETURNED_FAILURE, ((SendMessageMqttResponse) a.e()).b, true);
                            a.d();
                            return a2;
                        } else {
                            a2 = SendViaMqttResult.m3697a(((SendMessageMqttResponse) a.e()).b, true, ((SendMessageMqttResponse) a.e()).d);
                            a.d();
                            return a2;
                        }
                    }
                    a2 = SendViaMqttResult.m3699a(Details.SEND_FAILED_PUBLISH_FAILED, Details.SEND_FAILED_PUBLISH_FAILED.errorCode, null, false);
                    return a2;
                } catch (RemoteException e) {
                    a2 = SendViaMqttResult.m3699a(Details.SEND_FAILED_PUBLISH_FAILED_WITH_EXCEPTION, Details.SEND_FAILED_PUBLISH_FAILED_WITH_EXCEPTION.errorCode, e.getMessage(), false);
                    a.d();
                    return a2;
                }
            } catch (SendViaMqttException e2) {
                a2 = e2.mMqttResult;
                a.d();
                return a2;
            }
        } finally {
            a.d();
        }
    }
}
