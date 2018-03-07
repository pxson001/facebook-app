package com.facebook.prefs.shared;

import com.facebook.common.util.TriState;
import com.facebook.proguard.annotations.DoNotStrip;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import javax.annotation.Nullable;

@DoNotStrip
/* compiled from: wait_time */
public interface FbSharedPreferences {

    /* compiled from: wait_time */
    public interface OnSharedPreferenceChangeListener {
        void mo668a(FbSharedPreferences fbSharedPreferences, PrefKey prefKey);
    }

    /* compiled from: wait_time */
    public interface Editor {
        Editor mo1271a(PrefKey prefKey);

        Editor mo1272a(PrefKey prefKey, double d);

        Editor mo1273a(PrefKey prefKey, float f);

        Editor mo1274a(PrefKey prefKey, int i);

        Editor mo1275a(PrefKey prefKey, long j);

        Editor mo1276a(PrefKey prefKey, String str);

        Editor mo1277a(Map<PrefKey, Object> map);

        Editor mo1278b(PrefKey prefKey);

        @DoNotStrip
        void commit();

        @DoNotStrip
        Editor putBoolean(PrefKey prefKey, boolean z);
    }

    double mo274a(PrefKey prefKey, double d);

    float mo275a(PrefKey prefKey, float f);

    int mo276a(PrefKey prefKey, int i);

    long mo277a(PrefKey prefKey, long j);

    String mo278a(PrefKey prefKey, @Nullable String str);

    void mo279a(PrefKey prefKey, OnSharedPreferenceChangeListener onSharedPreferenceChangeListener);

    void mo280a(Runnable runnable);

    void mo281a(String str, OnSharedPreferenceChangeListener onSharedPreferenceChangeListener);

    void mo282a(Set<PrefKey> set);

    void mo283a(Set<PrefKey> set, OnSharedPreferenceChangeListener onSharedPreferenceChangeListener);

    boolean mo284a();

    boolean mo285a(PrefKey prefKey);

    boolean mo286a(PrefKey prefKey, boolean z);

    TriState mo287b(PrefKey prefKey);

    void mo288b();

    void mo289b(PrefKey prefKey, OnSharedPreferenceChangeListener onSharedPreferenceChangeListener);

    void mo290b(Set<PrefKey> set, OnSharedPreferenceChangeListener onSharedPreferenceChangeListener);

    Object mo291c(PrefKey prefKey);

    void mo292c();

    void mo293c(PrefKey prefKey, OnSharedPreferenceChangeListener onSharedPreferenceChangeListener);

    Set<PrefKey> mo294d(PrefKey prefKey);

    void mo295d();

    void mo296d(PrefKey prefKey, OnSharedPreferenceChangeListener onSharedPreferenceChangeListener);

    SortedMap<PrefKey, Object> mo297e(PrefKey prefKey);

    @DoNotStrip
    Editor edit();
}
