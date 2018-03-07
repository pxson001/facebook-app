package com.facebook.react.bridge.queue;

import android.os.Build.VERSION;
import com.facebook.infer.annotation.Assertions;
import javax.annotation.Nullable;

/* compiled from: getNodes */
public class ReactQueueConfigurationSpec {
    public final MessageQueueThreadSpec f11576a;
    public final MessageQueueThreadSpec f11577b;

    /* compiled from: getNodes */
    public class Builder {
        @Nullable
        private MessageQueueThreadSpec f11574a;
        @Nullable
        private MessageQueueThreadSpec f11575b;

        public final Builder m13586a(MessageQueueThreadSpec messageQueueThreadSpec) {
            Assertions.a(this.f11574a == null, "Setting native modules queue spec multiple times!");
            this.f11574a = messageQueueThreadSpec;
            return this;
        }

        public final Builder m13588b(MessageQueueThreadSpec messageQueueThreadSpec) {
            Assertions.a(this.f11575b == null, "Setting JS queue multiple times!");
            this.f11575b = messageQueueThreadSpec;
            return this;
        }

        public final ReactQueueConfigurationSpec m13587a() {
            return new ReactQueueConfigurationSpec((MessageQueueThreadSpec) Assertions.b(this.f11574a), (MessageQueueThreadSpec) Assertions.b(this.f11575b));
        }
    }

    public ReactQueueConfigurationSpec(MessageQueueThreadSpec messageQueueThreadSpec, MessageQueueThreadSpec messageQueueThreadSpec2) {
        this.f11576a = messageQueueThreadSpec;
        this.f11577b = messageQueueThreadSpec2;
    }

    public final MessageQueueThreadSpec m13591a() {
        return this.f11576a;
    }

    public final MessageQueueThreadSpec m13592b() {
        return this.f11577b;
    }

    private static Builder m13590d() {
        return new Builder();
    }

    public static ReactQueueConfigurationSpec m13589c() {
        return m13590d().m13588b(MessageQueueThreadSpec.m13572a("js")).m13586a(VERSION.SDK_INT < 21 ? MessageQueueThreadSpec.m13573a("native_modules", 2000000) : MessageQueueThreadSpec.m13572a("native_modules")).m13587a();
    }
}
