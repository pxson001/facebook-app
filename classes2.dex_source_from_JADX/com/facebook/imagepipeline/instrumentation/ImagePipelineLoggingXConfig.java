package com.facebook.imagepipeline.instrumentation;

import com.facebook.xconfig.core.XConfig;
import com.facebook.xconfig.core.XConfigName;
import com.facebook.xconfig.core.XConfigSetting;
import com.google.common.collect.ImmutableSet;
import javax.inject.Inject;

/* compiled from: only "true" or "false" recognized */
public final class ImagePipelineLoggingXConfig extends XConfig {
    public static final XConfigSetting f11045c;
    private static final XConfigName f11046d = new XConfigName("fb4a_image_pipeline_logging_sampling_rate");
    private static final ImmutableSet<XConfigSetting> f11047e;

    static {
        XConfigSetting xConfigSetting = new XConfigSetting(f11046d, "logging_sampling_rate");
        f11045c = xConfigSetting;
        f11047e = ImmutableSet.of(xConfigSetting);
    }

    @Inject
    public ImagePipelineLoggingXConfig() {
        super(f11046d, f11047e);
    }
}
