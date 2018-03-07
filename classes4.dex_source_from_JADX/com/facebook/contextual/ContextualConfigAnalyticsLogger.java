package com.facebook.contextual;

import com.facebook.analytics.event.HoneyClientEventFast;
import com.facebook.analytics.logger.AnalyticsLogger;
import java.util.Map.Entry;
import java.util.Random;
import javax.annotation.Nullable;

/* compiled from: spt */
public class ContextualConfigAnalyticsLogger implements ContextualConfigLogger {
    private final AnalyticsLogger f1935a;
    private final Random f1936b = new Random();

    public ContextualConfigAnalyticsLogger(AnalyticsLogger analyticsLogger) {
        this.f1935a = analyticsLogger;
    }

    public final void mo135a(RawConfig rawConfig, ContextualConfigEvaluationResult contextualConfigEvaluationResult) {
        int i = 0;
        DebugContextualConfigLogger.b(rawConfig, contextualConfigEvaluationResult);
        HoneyClientEventFast a = this.f1935a.a("contextual_config_exposure", false);
        if (a.a()) {
            m2000a(a, rawConfig);
            if (contextualConfigEvaluationResult.f1948b != null) {
                a.a("context", contextualConfigEvaluationResult.f1948b.f1922a);
            }
            if (contextualConfigEvaluationResult.f1949c != null) {
                a.a("context_value", contextualConfigEvaluationResult.f1949c.m1979c());
            }
            if (contextualConfigEvaluationResult.f1950d != null) {
                a.a("bucket", contextualConfigEvaluationResult.f1950d);
            }
            StringBuilder stringBuilder = new StringBuilder();
            ContextValue[] contextValueArr = contextualConfigEvaluationResult.f1951e;
            int length = contextValueArr.length;
            int i2 = 0;
            while (i < length) {
                ContextValue contextValue = contextValueArr[i];
                if (i2 > 0) {
                    stringBuilder.append(",");
                }
                stringBuilder.append(contextValue.m1979c());
                i2++;
                i++;
            }
            a.a("result", stringBuilder.toString());
            if (this.f1936b.nextInt(10) == 0) {
                a.a("json", rawConfig.a);
            }
            a.b();
        }
    }

    public final void mo136a(@Nullable RawConfig rawConfig, String str) {
        DebugContextualConfigLogger.b(rawConfig, str);
        HoneyClientEventFast a = this.f1935a.a("contextual_config_exposure", false);
        if (a.a()) {
            m2000a(a, rawConfig);
            a.a("exception", str);
            if (rawConfig != null && this.f1936b.nextInt(10) == 0) {
                a.a("json", rawConfig.a);
            }
            a.b();
        }
    }

    private static void m2000a(HoneyClientEventFast honeyClientEventFast, RawConfig rawConfig) {
        if (rawConfig != null) {
            for (Entry entry : rawConfig.b.entrySet()) {
                honeyClientEventFast.a((String) entry.getKey(), (String) entry.getValue());
            }
        }
    }
}
