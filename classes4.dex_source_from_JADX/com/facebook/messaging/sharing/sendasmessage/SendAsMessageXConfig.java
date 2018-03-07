package com.facebook.messaging.sharing.sendasmessage;

import com.facebook.xconfig.core.XConfig;
import com.facebook.xconfig.core.XConfigName;
import com.facebook.xconfig.core.XConfigSetting;
import com.google.common.collect.ImmutableSet;
import javax.inject.Inject;

/* compiled from: state_prepared */
public class SendAsMessageXConfig extends XConfig {
    public static final XConfigSetting f1834c = new XConfigSetting(f1836e, "min_messenger_version_for_secure_browser_share");
    public static final XConfigSetting f1835d = new XConfigSetting(f1836e, "min_messenger_version_for_secure_browser_share_from_chrome");
    private static final XConfigName f1836e = new XConfigName("fb4a_send_as_message_version");
    private static final ImmutableSet<XConfigSetting> f1837f = ImmutableSet.of(f1834c, f1835d);

    @Inject
    public SendAsMessageXConfig() {
        super(f1836e, f1837f);
    }
}
