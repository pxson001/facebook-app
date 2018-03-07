package com.facebook.contextual;

import com.facebook.debug.log.BLog;
import javax.annotation.Nullable;

/* compiled from: overflow_link */
public class DebugContextualConfigLogger implements ContextualConfigLogger {
    private RawConfig f8514a;
    private ContextualConfigEvaluationResult f8515b;
    private String f8516c;

    public final void m12332a(RawConfig rawConfig, ContextualConfigEvaluationResult contextualConfigEvaluationResult) {
        m12330b(rawConfig, contextualConfigEvaluationResult);
        this.f8514a = rawConfig;
        this.f8515b = contextualConfigEvaluationResult;
        this.f8516c = null;
    }

    public final void m12333a(@Nullable RawConfig rawConfig, String str) {
        m12331b(rawConfig, str);
        this.f8514a = rawConfig;
        this.f8516c = str;
        this.f8515b = null;
    }

    public static void m12330b(RawConfig rawConfig, ContextualConfigEvaluationResult contextualConfigEvaluationResult) {
        int i = 0;
        if (BLog.b(3)) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("RESULT - ");
            stringBuilder.append(rawConfig.m12342a());
            stringBuilder.append(" - ");
            if (contextualConfigEvaluationResult.b != null) {
                stringBuilder.append(" context: " + contextualConfigEvaluationResult.b.a);
            }
            if (contextualConfigEvaluationResult.c != null) {
                stringBuilder.append(" , value: " + contextualConfigEvaluationResult.c.c());
            }
            if (contextualConfigEvaluationResult.d != null) {
                stringBuilder.append(" , bucket: " + contextualConfigEvaluationResult.d);
            }
            stringBuilder.append(" , result: [");
            ContextValue[] contextValueArr = contextualConfigEvaluationResult.e;
            int length = contextValueArr.length;
            int i2 = 0;
            while (i < length) {
                ContextValue contextValue = contextValueArr[i];
                if (i2 > 0) {
                    stringBuilder.append(",");
                }
                stringBuilder.append(contextValue.c());
                i2++;
                i++;
            }
            stringBuilder.append("]");
            stringBuilder.append(" , json: " + rawConfig.f8536a);
        }
    }

    public static void m12331b(@Nullable RawConfig rawConfig, String str) {
        if (BLog.b(3) && rawConfig != null) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("ERROR - ");
            stringBuilder.append(rawConfig.m12342a());
            stringBuilder.append(" - exception: " + str);
            stringBuilder.append(" , json: " + rawConfig.f8536a);
        }
    }
}
