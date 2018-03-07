package com.facebook.perftestutils.logger;

import com.facebook.proguard.annotations.DoNotStrip;
import com.facebook.soloader.SoLoader;

@DoNotStrip
/* compiled from: push_invalid_topic */
public class BufferedPerfTestLogger {
    public static native int checkOverflow();

    @DoNotStrip
    public static native void clear();

    @DoNotStrip
    public static native void flush(LogProcessor logProcessor);

    @DoNotStrip
    public static native boolean log(String str, String str2);

    @DoNotStrip
    public static native boolean log(String str, String str2, long j, long j2);

    @DoNotStrip
    public static native boolean log(String str, String str2, String str3, String str4, long j, long j2);

    @DoNotStrip
    public static native boolean log(String str, String str2, String str3, String str4, long j, long j2, String str5);

    @DoNotStrip
    public static native void resizeBuffer(int i);

    static {
        SoLoader.a("perftestlogger");
    }
}
