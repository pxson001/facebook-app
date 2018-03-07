package com.facebook.zero.sdk.rewrite;

import com.facebook.common.json.AutoGenJsonHelper;
import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: simulate_3G */
public class ZeroUrlRewriteRuleSerializer extends JsonSerializer<ZeroUrlRewriteRule> {
    public final void m2322a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        ZeroUrlRewriteRule zeroUrlRewriteRule = (ZeroUrlRewriteRule) obj;
        if (zeroUrlRewriteRule == null) {
            jsonGenerator.h();
        }
        jsonGenerator.f();
        m2321b(zeroUrlRewriteRule, jsonGenerator, serializerProvider);
        jsonGenerator.g();
    }

    static {
        FbSerializerProvider.m277a(ZeroUrlRewriteRule.class, new ZeroUrlRewriteRuleSerializer());
    }

    private static void m2321b(ZeroUrlRewriteRule zeroUrlRewriteRule, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        AutoGenJsonHelper.m10234a(jsonGenerator, "matcher", zeroUrlRewriteRule.mMatcher);
        AutoGenJsonHelper.m10234a(jsonGenerator, "replacer", zeroUrlRewriteRule.mReplacer);
    }
}
