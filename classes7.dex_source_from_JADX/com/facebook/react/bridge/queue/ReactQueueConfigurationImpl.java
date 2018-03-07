package com.facebook.react.bridge.queue;

import android.os.Looper;
import com.facebook.react.common.MapBuilder;
import java.util.Map;

/* compiled from: getProfilePictureExpirationTimeSeconds is meaningless for a non-expiring picture */
public class ReactQueueConfigurationImpl implements ReactQueueConfiguration {
    private final MessageQueueThreadImpl f11571a;
    private final MessageQueueThreadImpl f11572b;
    private final MessageQueueThreadImpl f11573c;

    private ReactQueueConfigurationImpl(MessageQueueThreadImpl messageQueueThreadImpl, MessageQueueThreadImpl messageQueueThreadImpl2, MessageQueueThreadImpl messageQueueThreadImpl3) {
        this.f11571a = messageQueueThreadImpl;
        this.f11572b = messageQueueThreadImpl2;
        this.f11573c = messageQueueThreadImpl3;
    }

    public final MessageQueueThread mo707a() {
        return this.f11571a;
    }

    public final MessageQueueThread mo708b() {
        return this.f11572b;
    }

    public final MessageQueueThread mo709c() {
        return this.f11573c;
    }

    public final void m13585d() {
        if (this.f11572b.f11559b != Looper.getMainLooper()) {
            this.f11572b.quitSynchronous();
        }
        if (this.f11573c.f11559b != Looper.getMainLooper()) {
            this.f11573c.quitSynchronous();
        }
    }

    public static ReactQueueConfigurationImpl m13581a(ReactQueueConfigurationSpec reactQueueConfigurationSpec, QueueThreadExceptionHandler queueThreadExceptionHandler) {
        MessageQueueThreadImpl a;
        Map a2 = MapBuilder.m13603a();
        MessageQueueThreadSpec messageQueueThreadSpec = MessageQueueThreadSpec.f11564a;
        MessageQueueThreadImpl a3 = MessageQueueThreadImpl.m13564a(messageQueueThreadSpec, queueThreadExceptionHandler);
        a2.put(messageQueueThreadSpec, a3);
        MessageQueueThreadImpl messageQueueThreadImpl = (MessageQueueThreadImpl) a2.get(reactQueueConfigurationSpec.f11577b);
        if (messageQueueThreadImpl == null) {
            a = MessageQueueThreadImpl.m13564a(reactQueueConfigurationSpec.f11577b, queueThreadExceptionHandler);
        } else {
            a = messageQueueThreadImpl;
        }
        messageQueueThreadImpl = (MessageQueueThreadImpl) a2.get(reactQueueConfigurationSpec.f11576a);
        if (messageQueueThreadImpl == null) {
            messageQueueThreadImpl = MessageQueueThreadImpl.m13564a(reactQueueConfigurationSpec.f11576a, queueThreadExceptionHandler);
        }
        return new ReactQueueConfigurationImpl(a3, messageQueueThreadImpl, a);
    }
}
