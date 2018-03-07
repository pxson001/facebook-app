package com.facebook.apptab.state;

import com.facebook.common.json.AutoGenJsonHelper;
import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: is_subscribed */
public class NavigationImmersiveConfigSerializer extends JsonSerializer<NavigationImmersiveConfig> {
    public final void m10222a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        NavigationImmersiveConfig navigationImmersiveConfig = (NavigationImmersiveConfig) obj;
        if (navigationImmersiveConfig == null) {
            jsonGenerator.h();
        }
        jsonGenerator.f();
        m10221b(navigationImmersiveConfig, jsonGenerator, serializerProvider);
        jsonGenerator.g();
    }

    static {
        FbSerializerProvider.m277a(NavigationImmersiveConfig.class, new NavigationImmersiveConfigSerializer());
    }

    private static void m10221b(NavigationImmersiveConfig navigationImmersiveConfig, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        AutoGenJsonHelper.m10234a(jsonGenerator, "experiment_name", navigationImmersiveConfig.experimentName);
        AutoGenJsonHelper.m10234a(jsonGenerator, "experiment_group_name", navigationImmersiveConfig.experimentGroupName);
        AutoGenJsonHelper.m10234a(jsonGenerator, "fb_logo_badge_style", navigationImmersiveConfig.fbLogoBadgeStyle);
        AutoGenJsonHelper.m10234a(jsonGenerator, "fb_logo_badge_count", navigationImmersiveConfig.fbLogoBadgeCount);
        AutoGenJsonHelper.m10234a(jsonGenerator, "button_action", navigationImmersiveConfig.buttonAction);
        AutoGenJsonHelper.m10234a(jsonGenerator, "animation_speed", navigationImmersiveConfig.animationSpeed);
    }
}
