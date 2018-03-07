package com.facebook.http.common;

import com.facebook.xconfig.core.XConfig;
import com.facebook.xconfig.core.XConfigName;
import com.facebook.xconfig.core.XConfigSetting;
import com.google.common.collect.ImmutableSet;
import javax.inject.Inject;

/* compiled from: num_dismiss_since_last_clipboard_prompt_post */
public class RequestSamplingConfig extends XConfig {
    public static final XConfigSetting f11974c = new XConfigSetting(f11975d, "sampling_weight");
    private static final XConfigName f11975d = new XConfigName("request_sampling");

    @Inject
    public RequestSamplingConfig() {
        super(f11975d, ImmutableSet.of(f11974c));
    }
}
