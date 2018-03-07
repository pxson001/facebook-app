package com.facebook.messaging.business.commerceui.config;

import com.facebook.user.model.User;
import com.facebook.xconfig.core.XConfigReader;
import com.google.common.base.Strings;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Pattern;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: numbertype */
public class WifiNotificationConfigHelper {
    public final XConfigReader f8368a;
    private final Provider<User> f8369b;

    /* compiled from: numbertype */
    public class LocalNotification {
        public final String f8366a;
        public final String f8367b;

        public LocalNotification(String str, String str2) {
            this.f8366a = str;
            this.f8367b = str2;
        }
    }

    @Inject
    public WifiNotificationConfigHelper(XConfigReader xConfigReader, Provider<User> provider) {
        this.f8368a = xConfigReader;
        this.f8369b = provider;
    }

    public final Map<String, String> m8661a() {
        String a = this.f8368a.a(WifiNotificationXConfig.c, "");
        Map hashMap = new HashMap();
        try {
            JSONArray jSONArray = new JSONArray(a);
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                String optString = jSONObject.optString("thread_id");
                JSONArray optJSONArray = jSONObject.optJSONArray("bssids");
                if (!(Strings.isNullOrEmpty(optString) || optJSONArray == null)) {
                    for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                        String a2 = m8660a(optJSONArray.getString(i2));
                        if (!Strings.isNullOrEmpty(a2)) {
                            hashMap.put(a2, optString);
                        }
                    }
                }
            }
        } catch (JSONException e) {
        }
        return hashMap;
    }

    @Nullable
    public static String m8660a(String str) {
        if (Pattern.matches("^([A-Fa-f0-9]{2}[:-]){5}[A-Fa-f0-9]{2}$", str)) {
            return str.replace("-", ":").substring(0, str.length() - 1).toLowerCase(Locale.US);
        }
        return null;
    }

    @Nullable
    public final LocalNotification m8662d() {
        String a = this.f8368a.a(WifiNotificationXConfig.f, "");
        if (Strings.isNullOrEmpty(a)) {
            return null;
        }
        LocalNotification localNotification;
        try {
            JSONObject jSONObject = new JSONObject(a);
            String string = jSONObject.getString("title");
            String string2 = jSONObject.getString("content");
            if (Strings.isNullOrEmpty(string) || Strings.isNullOrEmpty(string2) || this.f8369b.get() == null) {
                return null;
            }
            localNotification = new LocalNotification(string, string2.replace("<first_name>", ((User) this.f8369b.get()).h()));
            return localNotification;
        } catch (JSONException e) {
            localNotification = null;
        }
    }
}
