package com.facebook.video.videostreaming;

import android.annotation.TargetApi;
import android.media.AudioRecord;
import com.facebook.inject.InjectorLike;

@TargetApi(18)
/* compiled from: sampleRate */
public class MicrophoneSetup {
    static int f5383a = 1;
    static int f5384b = 44100;
    static int f5385c = 16;
    static int f5386d = 2;
    static int f5387e = 409600;

    public static MicrophoneSetup m8087a(InjectorLike injectorLike) {
        return new MicrophoneSetup();
    }

    public static AudioRecord m8086a() {
        return new AudioRecord(f5383a, f5384b, f5385c, f5386d, f5387e);
    }

    public static void m8088a(AudioRecord audioRecord) {
        if (audioRecord != null) {
            audioRecord.release();
        }
    }
}
