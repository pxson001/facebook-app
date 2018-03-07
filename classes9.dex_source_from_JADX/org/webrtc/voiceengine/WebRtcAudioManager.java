package org.webrtc.voiceengine;

import android.annotation.TargetApi;
import android.content.Context;
import android.media.AudioManager;
import android.media.AudioRecord;
import android.media.AudioTrack;
import android.os.Build;
import com.facebook.common.build.BuildConstants;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.proguard.annotations.DoNotStrip;

@DoNotStrip
/* compiled from: after_audience_id */
public class WebRtcAudioManager implements WebRtcEngineLoggerDelegate {
    private static final String[] f21171b = new String[]{"MODE_NORMAL", "MODE_RINGTONE", "MODE_IN_CALL", "MODE_IN_COMMUNICATION"};
    private final WebRtcEngineLogger f21172a = new WebRtcEngineLogger(this);
    private final long f21173c;
    private final Context f21174d;
    private final AudioManager f21175e;
    private boolean f21176f = false;
    private boolean f21177g;
    private int f21178h;
    private int f21179i;
    private int f21180j;
    private int f21181k;

    private native void nativeCacheAudioParameters(int i, int i2, boolean z, int i3, int i4, long j);

    @DoNotStrip
    private native void nativeEngineTrace(int i, String str);

    @DoNotStrip
    WebRtcAudioManager(Context context, long j) {
        this.f21172a.m21642a("ctor" + WebRtcAudioUtils.m21637e(), new Object[0]);
        this.f21174d = context;
        this.f21173c = j;
        this.f21175e = (AudioManager) context.getSystemService("audio");
        m21599a();
        nativeCacheAudioParameters(this.f21178h, this.f21179i, this.f21177g, this.f21180j, this.f21181k, j);
    }

    @DoNotStrip
    private boolean init() {
        this.f21172a.m21642a("init" + WebRtcAudioUtils.m21637e(), new Object[0]);
        if (!this.f21176f) {
            this.f21172a.m21642a("audio mode is: " + f21171b[this.f21175e.getMode()], new Object[0]);
            this.f21176f = true;
        }
        return true;
    }

    @DoNotStrip
    private void dispose() {
        this.f21172a.m21642a("dispose" + WebRtcAudioUtils.m21637e(), new Object[0]);
        if (!this.f21176f) {
        }
    }

    @DoNotStrip
    private boolean isCommunicationModeEnabled() {
        return this.f21175e.getMode() == 3;
    }

    private void m21599a() {
        this.f21179i = 1;
        this.f21178h = m21601b();
        this.f21177g = isLowLatencyOutputSupported();
        this.f21180j = this.f21177g ? m21604d() : m21598a(this.f21178h, this.f21179i);
        this.f21181k = m21602b(this.f21178h, this.f21179i);
    }

    @DoNotStrip
    private boolean isLowLatencyOutputSupported() {
        return this.f21174d.getPackageManager().hasSystemFeature("android.hardware.audio.low_latency");
    }

    private int m21601b() {
        Object obj;
        if (Build.HARDWARE.equals("goldfish") && Build.BRAND.startsWith("generic_")) {
            obj = 1;
        } else {
            obj = null;
        }
        if (obj != null) {
            this.f21172a.m21642a("Running emulator, overriding sample rate to 8 kHz.", new Object[0]);
            return 8000;
        } else if (WebRtcAudioUtils.m21638f()) {
            this.f21172a.m21642a("Default sample rate is overriden to " + WebRtcAudioUtils.m21639g() + " Hz", new Object[0]);
            return WebRtcAudioUtils.m21639g();
        } else {
            int c;
            if (WebRtcAudioUtils.m21635c()) {
                c = m21603c();
            } else {
                c = WebRtcAudioUtils.m21639g();
            }
            this.f21172a.m21642a("Sample rate is set to " + c + " Hz", new Object[0]);
            return c;
        }
    }

    @TargetApi(17)
    private int m21603c() {
        String property = this.f21175e.getProperty("android.media.property.OUTPUT_SAMPLE_RATE");
        return property == null ? WebRtcAudioUtils.m21639g() : Integer.parseInt(property);
    }

    @TargetApi(17)
    private int m21604d() {
        m21600a(isLowLatencyOutputSupported(), "low latency output not supported", new Object[0]);
        if (!WebRtcAudioUtils.m21635c()) {
            return 256;
        }
        String property = this.f21175e.getProperty("android.media.property.OUTPUT_FRAMES_PER_BUFFER");
        if (property != null) {
            return Integer.parseInt(property);
        }
        return 256;
    }

    private static int m21598a(int i, int i2) {
        int i3;
        int i4 = i2 * 2;
        if (i2 == 1) {
            i3 = 4;
        } else if (i2 != 2) {
            return -1;
        } else {
            i3 = 12;
        }
        return AudioTrack.getMinBufferSize(i, i3, 2) / i4;
    }

    private int m21602b(int i, int i2) {
        boolean z;
        int i3 = i2 * 2;
        if (i2 == 1) {
            z = true;
        } else {
            z = false;
        }
        m21600a(z, "numChannels is %d", Integer.valueOf(i2));
        return AudioRecord.getMinBufferSize(i, 16, 2) / i3;
    }

    private void m21600a(boolean z, String str, Object... objArr) {
        if (!z) {
            String a = StringFormatUtil.a(str, objArr);
            if (BuildConstants.i) {
                throw new AssertionError(a);
            }
            this.f21172a.m21644c(a, new Object[0]);
        }
    }

    public final void mo928a(int i, String str) {
        nativeEngineTrace(i, str);
    }

    @DoNotStrip
    private int getAudioMode() {
        return this.f21175e.getMode();
    }

    @DoNotStrip
    private void unmuteMicrophone() {
        this.f21172a.m21642a("unmuteMicrophone" + WebRtcAudioUtils.m21637e(), new Object[0]);
        if (this.f21175e.isMicrophoneMute()) {
            this.f21175e.setMicrophoneMute(false);
        }
    }

    @DoNotStrip
    private int getAudioManagerState() {
        int i = 1;
        this.f21172a.m21642a("getAudioManagerState" + WebRtcAudioUtils.m21637e(), new Object[0]);
        int i2 = this.f21175e.isMicrophoneMute() ? 1 : 0;
        if (!this.f21175e.isSpeakerphoneOn()) {
            i = this.f21175e.isBluetoothScoOn() ? 3 : this.f21175e.isBluetoothA2dpOn() ? 4 : 0;
        }
        return (i2 | (i << 1)) | ((this.f21175e.getMode() & 7) << 4);
    }
}
