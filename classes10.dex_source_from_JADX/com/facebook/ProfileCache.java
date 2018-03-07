package com.facebook;

import android.content.SharedPreferences;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: event/{%s}/invitegroup/{%s} */
public final class ProfileCache {
    public final SharedPreferences f13839a = FacebookSdk.m14051f().getSharedPreferences("com.facebook.AccessTokenManager.SharedPreferences", 0);

    ProfileCache() {
    }

    final Profile m14137a() {
        String string = this.f13839a.getString("com.facebook.ProfileManager.CachedProfile", null);
        if (string != null) {
            try {
                return new Profile(new JSONObject(string));
            } catch (JSONException e) {
            }
        }
        return null;
    }
}
