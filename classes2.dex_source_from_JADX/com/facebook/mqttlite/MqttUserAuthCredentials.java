package com.facebook.mqttlite;

import com.facebook.auth.credentials.UserTokenCredentials;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.rti.mqtt.credentials.MqttAuthenticationKeySecretPair;
import com.facebook.rti.mqtt.credentials.MqttCredentials;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: fql */
public class MqttUserAuthCredentials implements MqttCredentials {
    private final Provider<UserTokenCredentials> f23377a;
    private final FbSharedPreferences f23378b;

    public static MqttUserAuthCredentials m31644a(InjectorLike injectorLike) {
        return new MqttUserAuthCredentials(IdBasedProvider.m1811a(injectorLike, 334), FbSharedPreferencesImpl.m1826a(injectorLike));
    }

    @Inject
    public MqttUserAuthCredentials(Provider<UserTokenCredentials> provider, FbSharedPreferences fbSharedPreferences) {
        this.f23377a = provider;
        this.f23378b = fbSharedPreferences;
    }

    public final MqttAuthenticationKeySecretPair m31645a() {
        UserTokenCredentials userTokenCredentials = (UserTokenCredentials) this.f23377a.get();
        if (userTokenCredentials == null) {
            return MqttAuthenticationKeySecretPair.a;
        }
        return MqttAuthenticationKeySecretPair.a(userTokenCredentials.f23603a, userTokenCredentials.f23604b);
    }

    public final String m31648b() {
        return "";
    }

    public final boolean m31647a(MqttAuthenticationKeySecretPair mqttAuthenticationKeySecretPair) {
        return false;
    }

    public final void m31649c() {
    }

    public final String m31650d() {
        return this.f23378b.mo278a(MqttPrefKeys.f23399a, "");
    }

    public final void m31646a(String str) {
        this.f23378b.edit().mo1276a(MqttPrefKeys.f23399a, str).commit();
    }

    public final void m31651e() {
        this.f23378b.edit().mo1271a(MqttPrefKeys.f23399a).commit();
    }
}
