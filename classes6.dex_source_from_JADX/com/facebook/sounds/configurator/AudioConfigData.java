package com.facebook.sounds.configurator;

import com.facebook.sounds.configurator.AudioConfigRegistry.AudioConfig;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMap.Builder;
import java.util.Map;

/* compiled from: event_rsvp */
public abstract class AudioConfigData {
    public ImmutableMap<DeviceProfile, DeviceSoundProfile> f15971a;

    public abstract DeviceSoundProfile mo1234c(DeviceProfile deviceProfile);

    public AudioConfigData() {
        Builder builder = new Builder();
        for (DeviceProfile deviceProfile : DeviceProfile.values()) {
            builder.b(deviceProfile, mo1234c(deviceProfile));
        }
        this.f15971a = builder.b();
    }

    public final Map<Integer, AudioConfig> m23606a(DeviceProfile deviceProfile) {
        if (this.f15971a.get(deviceProfile) != null) {
            return ((DeviceSoundProfile) this.f15971a.get(deviceProfile)).f16008b;
        }
        return null;
    }

    public final float m23607b(DeviceProfile deviceProfile) {
        if (this.f15971a.get(deviceProfile) != null) {
            return ((DeviceSoundProfile) this.f15971a.get(deviceProfile)).f16007a;
        }
        return 0.0f;
    }
}
