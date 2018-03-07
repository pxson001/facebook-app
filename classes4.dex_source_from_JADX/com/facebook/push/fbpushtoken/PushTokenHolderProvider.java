package com.facebook.push.fbpushtoken;

import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.config.versioninfo.module.AppVersionInfoMethodAutoProvider;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.push.externalcloud.PushPrefKeysSelector;
import com.facebook.push.registration.ServiceType;

/* compiled from: inet_session_id */
public class PushTokenHolderProvider extends AbstractAssistedProvider<PushTokenHolder> {
    public final PushTokenHolder m10872a(ServiceType serviceType) {
        return new PushTokenHolder(serviceType, (FbSharedPreferences) FbSharedPreferencesImpl.a(this), IdBasedProvider.a(this, 4442), AppVersionInfoMethodAutoProvider.a(this), PushPrefKeysSelector.m10873a((InjectorLike) this), (Clock) SystemClockMethodAutoProvider.a(this));
    }
}
