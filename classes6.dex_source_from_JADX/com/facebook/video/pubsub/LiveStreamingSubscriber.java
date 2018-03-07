package com.facebook.video.pubsub;

import com.facebook.debug.log.BLog;
import com.facebook.rti.shared.skywalker.SkywalkerSubscriptionConnector;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.util.concurrent.FutureCallback;
import java.io.IOException;
import javax.annotation.Nullable;

/* compiled from: commerce_store_front */
public class LiveStreamingSubscriber {
    public static final String f19438a = LiveStreamingSubscriber.class.getSimpleName();
    private final String f19439b;
    public final String f19440c = ("video_broadcast/interrupt_" + this.f19439b);
    public final SkywalkerSubscriptionConnector f19441d;
    public InterruptedMessage f19442e;
    public ObjectMapper f19443f;

    /* compiled from: commerce_store_front */
    class C14511 implements FutureCallback<JsonNode> {
        final /* synthetic */ LiveStreamingSubscriber f19433a;

        public void onFailure(Throwable th) {
            String str = LiveStreamingSubscriber.f19438a;
        }

        C14511(LiveStreamingSubscriber liveStreamingSubscriber) {
            this.f19433a = liveStreamingSubscriber;
        }

        public void onSuccess(@Nullable Object obj) {
            JsonNode jsonNode = (JsonNode) obj;
            if (jsonNode != null) {
                String str = LiveStreamingSubscriber.f19438a;
                jsonNode.B();
                this.f19433a.f19442e = InterruptedMessage.m28203a(this.f19433a.f19443f, jsonNode.B());
            }
        }
    }

    /* compiled from: commerce_store_front */
    public class InterruptedMessage {
        public static String f19434a = "broadcast_id";
        public static String f19435b = "time_position";
        public final String f19436c;
        public final long f19437d;

        private InterruptedMessage(String str, long j) {
            this.f19436c = str;
            this.f19437d = j;
        }

        public static InterruptedMessage m28203a(ObjectMapper objectMapper, String str) {
            JsonNode b;
            Throwable e;
            JsonNode jsonNode = null;
            try {
                JsonNode a = objectMapper.a(str);
                b = a.b(f19434a);
                try {
                    jsonNode = a.b(f19435b);
                } catch (IOException e2) {
                    e = e2;
                    BLog.a(LiveStreamingSubscriber.f19438a, e, "failed to parse payload: %s", new Object[]{str});
                    return new InterruptedMessage(b != null ? "" : b.B(), jsonNode != null ? 0 : jsonNode.D());
                }
            } catch (Throwable e3) {
                e = e3;
                b = jsonNode;
                BLog.a(LiveStreamingSubscriber.f19438a, e, "failed to parse payload: %s", new Object[]{str});
                if (b != null) {
                }
                if (jsonNode != null) {
                }
                return new InterruptedMessage(b != null ? "" : b.B(), jsonNode != null ? 0 : jsonNode.D());
            }
            if (b != null) {
            }
            if (jsonNode != null) {
            }
            return new InterruptedMessage(b != null ? "" : b.B(), jsonNode != null ? 0 : jsonNode.D());
        }
    }

    public LiveStreamingSubscriber(String str, SkywalkerSubscriptionConnector skywalkerSubscriptionConnector, ObjectMapper objectMapper) {
        this.f19439b = str;
        this.f19441d = skywalkerSubscriptionConnector;
        this.f19443f = objectMapper;
    }

    public final InterruptedMessage m28204a() {
        return this.f19442e;
    }

    public final void m28205b() {
        this.f19441d.a(this.f19440c, new C14511(this));
    }
}
