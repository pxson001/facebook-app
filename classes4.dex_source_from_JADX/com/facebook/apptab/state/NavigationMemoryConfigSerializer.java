package com.facebook.apptab.state;

import com.facebook.common.json.AutoGenJsonHelper;
import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: is_sent_succeed */
public class NavigationMemoryConfigSerializer extends JsonSerializer<NavigationMemoryConfig> {
    public final void m10238a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        NavigationMemoryConfig navigationMemoryConfig = (NavigationMemoryConfig) obj;
        if (navigationMemoryConfig == null) {
            jsonGenerator.h();
        }
        jsonGenerator.f();
        m10237b(navigationMemoryConfig, jsonGenerator, serializerProvider);
        jsonGenerator.g();
    }

    static {
        FbSerializerProvider.m277a(NavigationMemoryConfig.class, new NavigationMemoryConfigSerializer());
    }

    private static void m10237b(NavigationMemoryConfig navigationMemoryConfig, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        AutoGenJsonHelper.m10234a(jsonGenerator, "experiment_name", navigationMemoryConfig.experimentName);
        AutoGenJsonHelper.m10234a(jsonGenerator, "experiment_group_name", navigationMemoryConfig.experimentGroupName);
        AutoGenJsonHelper.m10232a(jsonGenerator, "low_memory_optimization_threshold_mb", Integer.valueOf(navigationMemoryConfig.lowMemoryOptimizationThresholdMb));
    }
}
