package com.facebook.video.settings;

import com.facebook.common.util.TriState;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.video.settings.VideoPrefs.AutoPlaySettingValue;

/* compiled from: is_employee */
public class VideoAutoPlayListPreferenceSettings {
    public static AutoPlaySettingValue m26900a(AutoPlaySettingValue autoPlaySettingValue, FbSharedPreferences fbSharedPreferences, boolean z) {
        String a = m26901a(autoPlaySettingValue, fbSharedPreferences);
        if (a.equalsIgnoreCase(AutoPlaySettingValue.DEFAULT.toString())) {
            fbSharedPreferences.edit().putBoolean(VideoPrefs.f19185i, false).commit();
            fbSharedPreferences.edit().mo1276a(VideoPrefs.f19183g, autoPlaySettingValue.toString()).commit();
            return autoPlaySettingValue;
        }
        AutoPlaySettingValue valueOf = AutoPlaySettingValue.valueOf(a);
        if (!fbSharedPreferences.mo287b(VideoPrefs.f19185i).isSet()) {
            if (valueOf == autoPlaySettingValue) {
                fbSharedPreferences.edit().putBoolean(VideoPrefs.f19185i, false).commit();
            } else {
                fbSharedPreferences.edit().putBoolean(VideoPrefs.f19185i, true).commit();
            }
        }
        boolean a2 = fbSharedPreferences.mo286a(VideoPrefs.f19185i, false);
        if (!z || a2 || valueOf == autoPlaySettingValue) {
            return valueOf;
        }
        m26905b(fbSharedPreferences, valueOf);
        return autoPlaySettingValue;
    }

    public static String m26901a(AutoPlaySettingValue autoPlaySettingValue, FbSharedPreferences fbSharedPreferences) {
        return fbSharedPreferences.mo278a(VideoPrefs.f19183g, autoPlaySettingValue.toString());
    }

    public static synchronized void m26902a(FbSharedPreferences fbSharedPreferences, AutoPlaySettingValue autoPlaySettingValue) {
        synchronized (VideoAutoPlayListPreferenceSettings.class) {
            fbSharedPreferences.edit().mo1276a(VideoPrefs.f19183g, autoPlaySettingValue.toString()).commit();
        }
    }

    public static synchronized void m26905b(FbSharedPreferences fbSharedPreferences, AutoPlaySettingValue autoPlaySettingValue) {
        synchronized (VideoAutoPlayListPreferenceSettings.class) {
            fbSharedPreferences.edit().mo1276a(VideoPrefs.f19184h, autoPlaySettingValue.toString()).commit();
        }
    }

    public static synchronized void m26903a(FbSharedPreferences fbSharedPreferences, boolean z) {
        synchronized (VideoAutoPlayListPreferenceSettings.class) {
            fbSharedPreferences.edit().putBoolean(VideoPrefs.f19185i, z).commit();
        }
    }

    public static synchronized TriState m26904b(FbSharedPreferences fbSharedPreferences) {
        TriState b;
        synchronized (VideoAutoPlayListPreferenceSettings.class) {
            b = fbSharedPreferences.mo287b(VideoPrefs.f19185i);
        }
        return b;
    }
}
