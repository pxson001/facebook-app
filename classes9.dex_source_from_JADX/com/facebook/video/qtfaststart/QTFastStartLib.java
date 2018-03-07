package com.facebook.video.qtfaststart;

import com.facebook.soloader.SoLoader;

/* compiled from: android_button */
class QTFastStartLib {
    private static boolean f20420a;

    QTFastStartLib() {
    }

    static synchronized void m19996a() {
        synchronized (QTFastStartLib.class) {
            if (!f20420a) {
                SoLoader.a("fb_qt-faststart_jni");
                f20420a = true;
            }
        }
    }
}
