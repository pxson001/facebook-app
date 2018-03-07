package com.facebook.push.mqtt.capability;

import com.facebook.common.util.BitmaskEnumUtil;
import com.facebook.inject.InjectorLike;
import com.facebook.mqtt.capabilities.MqttCapability;

/* compiled from: flat */
public class MqttVoipCapabilityImpl {
    public static MqttVoipCapabilityImpl m32007a(InjectorLike injectorLike) {
        return new MqttVoipCapabilityImpl();
    }

    public final boolean m32008a(long j) {
        Object obj;
        if ((BitmaskEnumUtil.m32026a(MqttCapability.VOIP) & j) != 0) {
            obj = 1;
        } else {
            obj = null;
        }
        if (obj == null) {
            if (((BitmaskEnumUtil.m32026a(MqttCapability.VOIP_WEB) & j) != 0 ? 1 : null) == null) {
                return false;
            }
        }
        return true;
    }
}
