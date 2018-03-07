package com.facebook.rtc.voicemail;

import com.facebook.xconfig.core.XConfig;
import com.facebook.xconfig.core.XConfigName;
import com.facebook.xconfig.core.XConfigSetting;
import com.google.common.collect.ImmutableSet;
import javax.inject.Inject;

/* compiled from: starve_in_audio_window_ms */
public class RtcVoicemailConfig extends XConfig {
    public static final XConfigName f1880c = new XConfigName("android_messenger_voicemail");
    public static final XConfigSetting f1881d = new XConfigSetting(f1880c, "urls");

    @Inject
    public RtcVoicemailConfig() {
        super(f1880c, ImmutableSet.of(f1881d));
    }
}
