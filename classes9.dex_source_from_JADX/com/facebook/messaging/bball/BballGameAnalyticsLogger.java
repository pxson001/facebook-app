package com.facebook.messaging.bball;

import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.model.messages.MessageUtil;
import com.facebook.messaging.model.threadkey.ThreadKey;
import javax.inject.Inject;

/* compiled from: opaque */
public class BballGameAnalyticsLogger {
    public final AnalyticsLogger f8166a;
    public final MessageUtil f8167b;

    /* compiled from: opaque */
    public class FinishParams {
        public final ThreadKey f8161a;
        public final int f8162b;
        public final boolean f8163c;
        public final boolean f8164d;
        public final int f8165e;

        /* compiled from: opaque */
        public class Builder {
            public ThreadKey f8156a;
            public int f8157b;
            public boolean f8158c;
            public boolean f8159d;
            public int f8160e;
        }

        public FinishParams(Builder builder) {
            this.f8161a = builder.f8156a;
            this.f8162b = builder.f8157b;
            this.f8163c = builder.f8158c;
            this.f8164d = builder.f8159d;
            this.f8165e = builder.f8160e;
        }
    }

    public static BballGameAnalyticsLogger m8409b(InjectorLike injectorLike) {
        return new BballGameAnalyticsLogger(AnalyticsLoggerMethodAutoProvider.a(injectorLike), MessageUtil.a(injectorLike));
    }

    @Inject
    public BballGameAnalyticsLogger(AnalyticsLogger analyticsLogger, MessageUtil messageUtil) {
        this.f8166a = analyticsLogger;
        this.f8167b = messageUtil;
    }

    public static BballGameAnalyticsLogger m8408a(InjectorLike injectorLike) {
        return m8409b(injectorLike);
    }

    public static HoneyClientEvent m8407a(String str) {
        HoneyClientEvent honeyClientEvent = new HoneyClientEvent(str);
        honeyClientEvent.c = "messenger_basketball";
        return honeyClientEvent;
    }
}
