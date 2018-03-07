package com.facebook.performancelogger;

import com.facebook.prefs.shared.PrefKey;
import com.facebook.prefs.shared.SharedPrefKeys;
import com.facebook.proguard.annotations.DoNotStrip;

@DoNotStrip
@Deprecated
/* compiled from: userId */
public interface PerformanceLogger {
    public static final PrefKey f1471a = ((PrefKey) SharedPrefKeys.f989c.m2011a("perfmarker_to_logcat"));

    void mo374a(int i, String str);

    void mo375a(int i, String str, double d);

    void mo376a(int i, String str, String str2);

    void mo377a(int i, String str, String str2, long j);

    void mo378a(int i, String str, String str2, String str3, String str4);

    void mo379a(int i, String str, String str2, String str3, boolean z);

    void mo380a(MarkerConfig markerConfig);

    void mo381a(MarkerConfig markerConfig, double d);

    void mo382a(MarkerConfig markerConfig, boolean z);

    void mo383a(String str);

    boolean mo384a();

    void mo385b(int i, String str);

    void mo386b(int i, String str, String str2);

    void mo387b(MarkerConfig markerConfig);

    boolean mo388b();

    void mo389c(int i, String str);

    void mo390c(int i, String str, String str2);

    void mo391c(MarkerConfig markerConfig);

    void mo392d(int i, String str);

    void mo393d(MarkerConfig markerConfig);

    boolean mo394d(int i, String str, String str2);

    void mo395e(int i, String str);

    boolean mo396e(MarkerConfig markerConfig);

    void mo397f(int i, String str);

    void mo398f(MarkerConfig markerConfig);

    boolean mo399g(int i, String str);

    boolean mo400h(int i, String str);
}
