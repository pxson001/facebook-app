package com.facebook;

import android.content.SharedPreferences;
import android.os.Bundle;
import com.facebook.internal.Validate;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: event_buy_tickets_purchase_button_tapped */
public class AccessTokenCache {
    public final SharedPreferences f13716a;
    private final SharedPreferencesTokenCachingStrategyFactory f13717b;
    private LegacyTokenHelper f13718c;

    /* compiled from: event_buy_tickets_purchase_button_tapped */
    class SharedPreferencesTokenCachingStrategyFactory {
        SharedPreferencesTokenCachingStrategyFactory() {
        }

        public static LegacyTokenHelper m14016a() {
            return new LegacyTokenHelper(FacebookSdk.m14051f());
        }
    }

    private AccessTokenCache(SharedPreferences sharedPreferences, SharedPreferencesTokenCachingStrategyFactory sharedPreferencesTokenCachingStrategyFactory) {
        this.f13716a = sharedPreferences;
        this.f13717b = sharedPreferencesTokenCachingStrategyFactory;
    }

    public AccessTokenCache() {
        this(FacebookSdk.m14051f().getSharedPreferences("com.facebook.AccessTokenManager.SharedPreferences", 0), new SharedPreferencesTokenCachingStrategyFactory());
    }

    public final AccessToken m14020a() {
        if (this.f13716a.contains("com.facebook.AccessTokenManager.CachedAccessToken")) {
            return m14017d();
        }
        if (!FacebookSdk.f13774k) {
            return null;
        }
        AccessToken f = m14018f();
        if (f == null) {
            return f;
        }
        m14021a(f);
        m14019g().m14130b();
        return f;
    }

    public final void m14021a(AccessToken accessToken) {
        Validate.m25366a((Object) accessToken, "accessToken");
        try {
            this.f13716a.edit().putString("com.facebook.AccessTokenManager.CachedAccessToken", accessToken.m14015j().toString()).apply();
        } catch (JSONException e) {
        }
    }

    public final void m14022b() {
        this.f13716a.edit().remove("com.facebook.AccessTokenManager.CachedAccessToken").apply();
        if (FacebookSdk.f13774k) {
            m14019g().m14130b();
        }
    }

    private AccessToken m14017d() {
        AccessToken accessToken = null;
        String string = this.f13716a.getString("com.facebook.AccessTokenManager.CachedAccessToken", accessToken);
        if (string != null) {
            try {
                accessToken = AccessToken.m14006a(new JSONObject(string));
            } catch (JSONException e) {
            }
        }
        return accessToken;
    }

    private AccessToken m14018f() {
        Bundle a = m14019g().m14129a();
        if (a == null) {
            return null;
        }
        Object obj = null;
        if (a != null) {
            String string = a.getString("com.facebook.TokenCachingStrategy.Token");
            if (!(string == null || string.length() == 0 || a.getLong("com.facebook.TokenCachingStrategy.ExpirationDate", 0) == 0)) {
                obj = 1;
            }
        }
        if (obj != null) {
            return AccessToken.m14005a(a);
        }
        return null;
    }

    private LegacyTokenHelper m14019g() {
        if (this.f13718c == null) {
            synchronized (this) {
                if (this.f13718c == null) {
                    this.f13718c = SharedPreferencesTokenCachingStrategyFactory.m14016a();
                }
            }
        }
        return this.f13718c;
    }
}
