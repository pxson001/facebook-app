package com.facebook.messaging.sms.abtest;

import android.os.Build.VERSION;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.sms.prefs.SmsPrefKeys;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.qe.api.ExposureLogging;
import com.facebook.qe.api.Liveness;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.api.manager.Authority;
import com.facebook.qe.api.manager.QeManager;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableBiMap;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.RegularImmutableBiMap;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: edit_story_privacy_discard */
public class SmsTakeoverMultiverseExperimentHelper {
    public final QeAccessor f13322a;
    private final QeManager f13323b;
    public final FbSharedPreferences f13324c;
    private final SmsGatekeepers f13325d;

    public static SmsTakeoverMultiverseExperimentHelper m14202b(InjectorLike injectorLike) {
        return new SmsTakeoverMultiverseExperimentHelper((QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike), (QeManager) QeInternalImplMethodAutoProvider.a(injectorLike), (FbSharedPreferences) FbSharedPreferencesImpl.a(injectorLike), SmsGatekeepers.m10502b(injectorLike));
    }

    @Inject
    public SmsTakeoverMultiverseExperimentHelper(QeAccessor qeAccessor, QeManager qeManager, FbSharedPreferences fbSharedPreferences, SmsGatekeepers smsGatekeepers) {
        this.f13322a = qeAccessor;
        this.f13323b = qeManager;
        this.f13324c = fbSharedPreferences;
        this.f13325d = smsGatekeepers;
    }

    private boolean m14201a(String str) {
        return VERSION.SDK_INT >= 19 && this.f13323b.a(Authority.EFFECTIVE, str);
    }

    @Nullable
    private String m14203b(String str) {
        if (m14201a(str)) {
            return this.f13323b.b(Authority.EFFECTIVE, str);
        }
        return null;
    }

    public final ImmutableMap<String, String> m14204a() {
        if (m14201a("android_messenger_sms_takeover_optin_variations")) {
            return ImmutableMap.of("qe_group_optin_variations", Strings.nullToEmpty(m14203b("android_messenger_sms_takeover_optin_variations")), "qe_group_inbox_filter", Strings.nullToEmpty(m14203b("android_messenger_sms_takeover_inbox_filter")));
        }
        if (m14201a("android_messenger_sms_integration_upsell")) {
            return ImmutableBiMap.b("qe_group_upsell", Strings.nullToEmpty(m14203b("android_messenger_sms_integration_upsell")));
        }
        if (m14201a("android_messenger_sms_takeover_permanent_contacts")) {
            return ImmutableBiMap.b("qe_group_contacts", Strings.nullToEmpty(m14203b("android_messenger_sms_takeover_permanent_contacts")));
        }
        return RegularImmutableBiMap.a;
    }

    public final boolean m14206b() {
        if (!m14201a("android_messenger_sms_takeover_optin_variations")) {
            return false;
        }
        if (m14208e() || m14205a(true) || m14211m()) {
            return true;
        }
        return false;
    }

    public final boolean m14207c() {
        return this.f13324c.a(SmsPrefKeys.f13598u) || this.f13324c.a(SmsPrefKeys.f13597t, false) || this.f13324c.a(SmsPrefKeys.f13596s, false) || this.f13324c.a(SmsPrefKeys.f13564B, false);
    }

    public final boolean m14208e() {
        return this.f13322a.a(ExperimentsForSmsTakeoverAbTestModule.f13654r, false);
    }

    public final boolean m14205a(boolean z) {
        return this.f13322a.a(Liveness.Cached, z ? ExposureLogging.On : ExposureLogging.Off, ExperimentsForSmsTakeoverAbTestModule.f13649m, false);
    }

    @Nullable
    public final String m14209j() {
        return this.f13322a.a(ExperimentsForSmsTakeoverAbTestModule.f13648l, null);
    }

    public final int m14210k() {
        return this.f13322a.a(ExperimentsForSmsTakeoverAbTestModule.f13651o, 4);
    }

    public final boolean m14211m() {
        return this.f13322a.a(ExperimentsForSmsTakeoverAbTestModule.f13640d, false);
    }

    public final ReadonlyModeNotificationType m14212p() {
        return (ReadonlyModeNotificationType) this.f13322a.a(ExperimentsForSmsTakeoverAbTestModule.f13636N, ReadonlyModeNotificationType.class, ReadonlyModeNotificationType.CHATHEAD_SYSTEM_NOTIFICATIONS_OFF);
    }

    public final boolean m14213t() {
        return !m14205a(false) && this.f13322a.a(ExperimentsForSmsTakeoverAbTestModule.f13628F, false);
    }

    public final boolean m14214u() {
        return !m14205a(false) && this.f13322a.a(ExperimentsForSmsTakeoverAbTestModule.f13627E, false);
    }

    public final boolean m14215v() {
        return !m14205a(false) && this.f13322a.a(ExperimentsForSmsTakeoverAbTestModule.f13626D, false);
    }
}
