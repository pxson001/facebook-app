package com.facebook.messaging.media.upload;

import com.facebook.auth.userscope.UserScoped;
import com.facebook.base.broadcast.BaseFbBroadcastManager;
import com.facebook.base.broadcast.LocalFbBroadcastManager;
import com.facebook.common.util.JSONUtil;
import com.facebook.fbservice.service.BlueServiceHandler;
import com.facebook.fbservice.service.ErrorCode;
import com.facebook.fbservice.service.OperationParams;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.media.upload.util.MediaHashCache;
import com.facebook.push.mqtt.service.MqttPushServiceClient;
import com.facebook.push.mqtt.service.MqttPushServiceClientManagerImpl;
import com.facebook.push.mqtt.service.response.JsonMqttResponseProcessor.Callback;
import com.facebook.push.mqtt.service.response.MqttResponse;
import com.facebook.ui.media.attachments.MediaResource;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.google.common.base.Stopwatch;
import com.google.common.base.Strings;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;

@UserScoped
/* compiled from: location_attachment */
public class MediaGetFbidServiceHandler implements BlueServiceHandler {
    private static final Object f11841e = new Object();
    private final BaseFbBroadcastManager f11842a;
    private final MediaGetFbidAnalyticsLogger f11843b;
    private final MqttPushServiceClientManagerImpl f11844c;
    private final MediaHashCache f11845d;

    /* compiled from: location_attachment */
    class C13371 implements Callback<Long> {
        final /* synthetic */ MediaGetFbidServiceHandler f11840a;

        C13371(MediaGetFbidServiceHandler mediaGetFbidServiceHandler) {
            this.f11840a = mediaGetFbidServiceHandler;
        }

        public final boolean m12456a(JsonNode jsonNode) {
            return jsonNode.d("fbid");
        }

        public final Object m12457b(JsonNode jsonNode) {
            return Long.valueOf(JSONUtil.c(jsonNode.b("fbid")));
        }
    }

    /* compiled from: location_attachment */
    enum GetFbidStatus {
        UNKNOWN,
        VALID_FBID_RETURNED,
        NO_EXISTING_MEDIA_FOUND,
        INVALID_RESULT_RETURNED,
        SERVER_SIDE_FAILED,
        MQTT_FAILED,
        NO_HASH_AVAILABLE
    }

    private static MediaGetFbidServiceHandler m12460b(InjectorLike injectorLike) {
        return new MediaGetFbidServiceHandler((BaseFbBroadcastManager) LocalFbBroadcastManager.a(injectorLike), MediaGetFbidAnalyticsLogger.a(injectorLike), MqttPushServiceClientManagerImpl.a(injectorLike), MediaHashCache.a(injectorLike));
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.facebook.messaging.media.upload.MediaGetFbidServiceHandler m12458a(com.facebook.inject.InjectorLike r7) {
        /*
        r2 = com.facebook.inject.ScopeSet.a();
        r0 = com.facebook.auth.userscope.UserScope.class;
        r0 = r7.getInstance(r0);
        r0 = (com.facebook.auth.userscope.UserScope) r0;
        r1 = r7.getScopeAwareInjector();
        r1 = r1.b();
        if (r1 != 0) goto L_0x001e;
    L_0x0016:
        r0 = new com.facebook.inject.ProvisioningException;
        r1 = "Called user scoped provider outside of context scope";
        r0.<init>(r1);
        throw r0;
    L_0x001e:
        r3 = r0.a(r1);
        r4 = r3.b();	 Catch:{ all -> 0x006c }
        r1 = f11841e;	 Catch:{ all -> 0x006c }
        r1 = r4.get(r1);	 Catch:{ all -> 0x006c }
        r5 = com.facebook.auth.userscope.UserScope.a;	 Catch:{ all -> 0x006c }
        if (r1 != r5) goto L_0x0035;
    L_0x0030:
        r3.c();
        r0 = 0;
    L_0x0034:
        return r0;
    L_0x0035:
        if (r1 != 0) goto L_0x007c;
    L_0x0037:
        r1 = 4;
        r5 = r2.b(r1);	 Catch:{  }
        r6 = r0.a(r3);	 Catch:{ all -> 0x0067 }
        r0 = r6.e();	 Catch:{ all -> 0x0062 }
        r1 = m12460b(r0);	 Catch:{ all -> 0x0062 }
        com.facebook.auth.userscope.UserScope.a(r6);	 Catch:{  }
        if (r1 != 0) goto L_0x0071;
    L_0x004d:
        r0 = f11841e;	 Catch:{  }
        r6 = com.facebook.auth.userscope.UserScope.a;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r6);	 Catch:{  }
        r0 = (com.facebook.messaging.media.upload.MediaGetFbidServiceHandler) r0;	 Catch:{  }
    L_0x0057:
        if (r0 == 0) goto L_0x007a;
    L_0x0059:
        r2.c(r5);	 Catch:{  }
    L_0x005c:
        r0 = (com.facebook.messaging.media.upload.MediaGetFbidServiceHandler) r0;	 Catch:{  }
        r3.c();
        goto L_0x0034;
    L_0x0062:
        r0 = move-exception;
        com.facebook.auth.userscope.UserScope.a(r6);	 Catch:{  }
        throw r0;	 Catch:{  }
    L_0x0067:
        r0 = move-exception;
        r2.c(r5);	 Catch:{  }
        throw r0;	 Catch:{  }
    L_0x006c:
        r0 = move-exception;
        r3.c();
        throw r0;
    L_0x0071:
        r0 = f11841e;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r1);	 Catch:{  }
        r0 = (com.facebook.messaging.media.upload.MediaGetFbidServiceHandler) r0;	 Catch:{  }
        goto L_0x0057;
    L_0x007a:
        r0 = r1;
        goto L_0x0059;
    L_0x007c:
        r0 = r1;
        goto L_0x005c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.media.upload.MediaGetFbidServiceHandler.a(com.facebook.inject.InjectorLike):com.facebook.messaging.media.upload.MediaGetFbidServiceHandler");
    }

    public final OperationResult m12461a(OperationParams operationParams) {
        String str = operationParams.b;
        if ("media_get_fbid".equals(str)) {
            return m12459b(operationParams);
        }
        throw new IllegalArgumentException("Unknown operation type: " + str);
    }

    @Inject
    public MediaGetFbidServiceHandler(BaseFbBroadcastManager baseFbBroadcastManager, MediaGetFbidAnalyticsLogger mediaGetFbidAnalyticsLogger, MqttPushServiceClientManagerImpl mqttPushServiceClientManagerImpl, MediaHashCache mediaHashCache) {
        this.f11842a = baseFbBroadcastManager;
        this.f11843b = mediaGetFbidAnalyticsLogger;
        this.f11844c = mqttPushServiceClientManagerImpl;
        this.f11845d = mediaHashCache;
    }

    private OperationResult m12459b(OperationParams operationParams) {
        Throwable e;
        GetFbidStatus getFbidStatus;
        Stopwatch createStarted = Stopwatch.createStarted();
        MediaResource mediaResource = (MediaResource) operationParams.b().getParcelable("mediaResource");
        if (Strings.isNullOrEmpty(this.f11845d.b(mediaResource))) {
            this.f11843b.a(mediaResource, GetFbidStatus.NO_HASH_AVAILABLE.toString(), createStarted.elapsed(TimeUnit.MILLISECONDS), null);
            return OperationResult.a(ErrorCode.OTHER, "Failed to get hash for media resource");
        }
        this.f11843b.a(mediaResource);
        GetFbidStatus getFbidStatus2 = GetFbidStatus.UNKNOWN;
        MqttPushServiceClient a = this.f11844c.a();
        try {
            ObjectNode objectNode = new ObjectNode(JsonNodeFactory.a);
            objectNode.a("mhash", this.f11845d.b(mediaResource));
            MqttResponse a2 = a.a("/get_media", objectNode, "/get_media_resp", new C13371(this));
            if (a2.a) {
                OperationResult a3;
                GetFbidStatus getFbidStatus3;
                Long l = (Long) a2.b;
                GetFbidStatus getFbidStatus4;
                if (l.longValue() == -1) {
                    getFbidStatus4 = GetFbidStatus.SERVER_SIDE_FAILED;
                    try {
                        a3 = OperationResult.a(ErrorCode.MQTT_SEND_FAILURE, "MQTT failed to get response from server");
                        getFbidStatus3 = getFbidStatus4;
                    } catch (Exception e2) {
                        e = e2;
                        getFbidStatus = getFbidStatus4;
                        try {
                            this.f11843b.a(mediaResource, getFbidStatus.toString(), createStarted.elapsed(TimeUnit.MILLISECONDS), e);
                            throw e;
                        } catch (Throwable th) {
                            a.f();
                        }
                    }
                } else if (l.longValue() == 0) {
                    getFbidStatus4 = GetFbidStatus.NO_EXISTING_MEDIA_FOUND;
                    a3 = OperationResult.a(String.valueOf(l));
                    getFbidStatus3 = getFbidStatus4;
                } else if (l.longValue() > 0) {
                    getFbidStatus4 = GetFbidStatus.VALID_FBID_RETURNED;
                    a3 = OperationResult.a(String.valueOf(l));
                    this.f11842a.a(MediaUploadEvents.m12491c(mediaResource));
                    getFbidStatus3 = getFbidStatus4;
                } else {
                    getFbidStatus4 = GetFbidStatus.INVALID_RESULT_RETURNED;
                    a3 = OperationResult.a(ErrorCode.NO_ERROR, "Invalid result returned from MQTT get_media");
                    getFbidStatus3 = getFbidStatus4;
                }
                try {
                    this.f11843b.a(mediaResource, l.longValue(), getFbidStatus3.toString(), createStarted.elapsed(TimeUnit.MILLISECONDS));
                    a.f();
                    return a3;
                } catch (Exception e3) {
                    e = e3;
                    getFbidStatus = getFbidStatus3;
                    this.f11843b.a(mediaResource, getFbidStatus.toString(), createStarted.elapsed(TimeUnit.MILLISECONDS), e);
                    throw e;
                }
            }
            this.f11843b.a(mediaResource, GetFbidStatus.MQTT_FAILED.toString(), createStarted.elapsed(TimeUnit.MILLISECONDS), a2.d);
            OperationResult a4 = a2.a();
            a.f();
            return a4;
        } catch (Exception e4) {
            e = e4;
            getFbidStatus = getFbidStatus2;
            this.f11843b.a(mediaResource, getFbidStatus.toString(), createStarted.elapsed(TimeUnit.MILLISECONDS), e);
            throw e;
        }
    }
}
