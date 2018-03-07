package com.facebook.push.externalcloud;

import com.facebook.common.util.StringUtil;
import com.facebook.inject.InjectorLike;
import com.facebook.push.fbpushtoken.PushTokenHolder;
import com.facebook.push.registration.ServiceType;
import javax.inject.Inject;

/* compiled from: hit_back */
public class PrimaryPushTokenHolder {
    private final PushPreferenceSelector f11255a;
    private final PushServiceSelector f11256b;

    public static PrimaryPushTokenHolder m13161b(InjectorLike injectorLike) {
        return new PrimaryPushTokenHolder(PushPreferenceSelector.a(injectorLike), PushServiceSelector.a(injectorLike));
    }

    @Inject
    public PrimaryPushTokenHolder(PushPreferenceSelector pushPreferenceSelector, PushServiceSelector pushServiceSelector) {
        this.f11255a = pushPreferenceSelector;
        this.f11256b = pushServiceSelector;
    }

    @Deprecated
    public final String m13162a() {
        ServiceType serviceType;
        PushPreferenceSelector pushPreferenceSelector = this.f11255a;
        PushServiceSelector pushServiceSelector = this.f11256b;
        if (PushServiceSelector.e()) {
            serviceType = ServiceType.ADM;
        } else if (PushServiceSelector.f()) {
            serviceType = ServiceType.NNA;
        } else {
            serviceType = ServiceType.GCM;
        }
        PushTokenHolder a = pushPreferenceSelector.a(serviceType);
        CharSequence charSequence = (String) a.c.get();
        if (StringUtil.a(charSequence)) {
            charSequence = a.i();
        }
        return charSequence;
    }

    public static PrimaryPushTokenHolder m13160a(InjectorLike injectorLike) {
        return m13161b(injectorLike);
    }
}
