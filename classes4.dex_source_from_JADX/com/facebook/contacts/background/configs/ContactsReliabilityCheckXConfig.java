package com.facebook.contacts.background.configs;

import com.facebook.xconfig.core.XConfig;
import com.facebook.xconfig.core.XConfigName;
import com.facebook.xconfig.core.XConfigSetting;
import com.google.common.collect.ImmutableSet;
import javax.inject.Inject;

/* compiled from: sticker_packs. */
public class ContactsReliabilityCheckXConfig extends XConfig {
    public static final XConfigName f1724c = new XConfigName("android_messenger_contact_reliability");
    public static final XConfigSetting f1725d = new XConfigSetting(f1724c, "contact_sampling_rate");
    public static final XConfigSetting f1726e = new XConfigSetting(f1724c, "is_reliability_check_enabled");
    private static final ImmutableSet<XConfigSetting> f1727f = ImmutableSet.of(f1725d, f1726e);

    @Inject
    public ContactsReliabilityCheckXConfig() {
        super(f1724c, f1727f);
    }
}
