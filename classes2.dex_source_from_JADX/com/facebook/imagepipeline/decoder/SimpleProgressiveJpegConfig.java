package com.facebook.imagepipeline.decoder;

import com.facebook.common.internal.Preconditions;
import java.util.List;

/* compiled from: org.iii.romulus.meridian.playbackcomplete */
public class SimpleProgressiveJpegConfig {
    public final DynamicValueConfig f10771a;

    /* compiled from: org.iii.romulus.meridian.playbackcomplete */
    public interface DynamicValueConfig {
        List<Integer> mo2065a();

        int mo2066b();
    }

    public SimpleProgressiveJpegConfig() {
        this(new DefaultDynamicValueConfig());
    }

    public SimpleProgressiveJpegConfig(DynamicValueConfig dynamicValueConfig) {
        this.f10771a = (DynamicValueConfig) Preconditions.a(dynamicValueConfig);
    }

    public final int m16016a(int i) {
        List a = this.f10771a.mo2065a();
        if (a == null || a.isEmpty()) {
            return i + 1;
        }
        for (int i2 = 0; i2 < a.size(); i2++) {
            if (((Integer) a.get(i2)).intValue() > i) {
                return ((Integer) a.get(i2)).intValue();
            }
        }
        return Integer.MAX_VALUE;
    }
}
