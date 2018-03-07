package com.facebook.messaging.requestrouting;

import com.facebook.xconfig.core.XConfig;
import com.facebook.xconfig.core.XConfigName;
import com.facebook.xconfig.core.XConfigSetting;
import com.google.common.collect.ImmutableSet;
import javax.inject.Inject;

/* compiled from: state_preparing */
public final class RequestRoutingXConfig extends XConfig {
    public static final XConfigSetting f1831c = new XConfigSetting(f1833e, "messenger_region");
    public static final XConfigSetting f1832d = new XConfigSetting(f1833e, "messenger_mqtt_region");
    private static final XConfigName f1833e = new XConfigName("android_messenger_request_routing");

    @Inject
    public RequestRoutingXConfig() {
        super(f1833e, ImmutableSet.of(f1831c, f1832d));
    }
}
