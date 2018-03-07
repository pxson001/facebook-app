package org.webrtc.voiceengine;

import android.content.Context;
import android.os.Build.VERSION;
import android.os.Process;

/* compiled from: advertisement */
public final class WebRtcAudioUtils {
    private static int f21204a = 16000;
    private static boolean f21205b = false;

    public static boolean m21631a() {
        return VERSION.SDK_INT >= 11;
    }

    public static boolean m21634b() {
        return VERSION.SDK_INT >= 16;
    }

    public static boolean m21635c() {
        return VERSION.SDK_INT >= 17;
    }

    public static boolean m21636d() {
        return VERSION.SDK_INT >= 21;
    }

    public static String m21637e() {
        return "@[name=" + Thread.currentThread().getName() + ", id=" + Thread.currentThread().getId() + "]";
    }

    public static boolean m21632a(Context context) {
        return context.getPackageManager().hasSystemFeature("android.hardware.audio.low_latency");
    }

    public static boolean m21633a(Context context, String str) {
        return context.checkPermission(str, Process.myPid(), Process.myUid()) == 0;
    }

    public static synchronized boolean m21638f() {
        boolean z;
        synchronized (WebRtcAudioUtils.class) {
            z = f21205b;
        }
        return z;
    }

    public static synchronized int m21639g() {
        int i;
        synchronized (WebRtcAudioUtils.class) {
            i = f21204a;
        }
        return i;
    }
}
