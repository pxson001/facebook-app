package org.webrtc.voiceengine;

import android.annotation.TargetApi;
import android.content.Context;
import android.media.AudioRecord;
import android.media.audiofx.AcousticEchoCanceler;
import android.media.audiofx.AudioEffect.Descriptor;
import android.media.audiofx.AutomaticGainControl;
import android.media.audiofx.NoiseSuppressor;
import android.os.Process;
import com.facebook.common.build.BuildConstants;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.proguard.annotations.DoNotStrip;
import java.nio.ByteBuffer;

@DoNotStrip
/* compiled from: after make current */
class WebRtcAudioRecord implements WebRtcEngineLoggerDelegate {
    public final WebRtcEngineLogger f21184a = new WebRtcEngineLogger(this);
    public final long f21185b;
    private final Context f21186c;
    public ByteBuffer f21187d = null;
    public AudioRecord f21188e = null;
    private AudioRecordThread f21189f = null;
    private AcousticEchoCanceler f21190g = null;
    private AutomaticGainControl f21191h = null;
    private NoiseSuppressor f21192i = null;
    private boolean f21193j = true;
    private boolean f21194k = true;
    private boolean f21195l = true;

    /* compiled from: after make current */
    class AudioRecordThread extends Thread {
        final /* synthetic */ WebRtcAudioRecord f21182a;
        private volatile boolean f21183b = true;

        public AudioRecordThread(WebRtcAudioRecord webRtcAudioRecord, String str) {
            this.f21182a = webRtcAudioRecord;
            super(str);
        }

        public void run() {
            boolean z;
            Process.setThreadPriority(-19);
            this.f21182a.f21184a.m21642a("AudioRecordThread %s", WebRtcAudioUtils.m21637e());
            this.f21182a.m21611a(this.f21182a.f21188e.getRecordingState() == 3, "AudioRecord is not in recording state", new Object[0]);
            while (this.f21183b) {
                int read = this.f21182a.f21188e.read(this.f21182a.f21187d, this.f21182a.f21187d.capacity());
                if (read == this.f21182a.f21187d.capacity()) {
                    this.f21182a.nativeDataIsRecorded(read, this.f21182a.f21185b);
                } else {
                    this.f21182a.f21184a.m21644c("AudioRecord.read failed: %d", Integer.valueOf(read));
                    if (read == -3) {
                        this.f21182a.f21184a.m21644c("AudioRecord.read invalid operation", new Object[0]);
                        this.f21183b = false;
                    }
                }
            }
            try {
                this.f21182a.f21188e.stop();
            } catch (Throwable e) {
                this.f21182a.f21184a.m21641a("AudioRecord.stop illegal state", e);
            } catch (Throwable e2) {
                this.f21182a.f21184a.m21641a("AudioRecord.stop unknown exception", e2);
            }
            WebRtcAudioRecord webRtcAudioRecord = this.f21182a;
            if (this.f21182a.f21188e.getRecordingState() == 1) {
                z = true;
            } else {
                z = false;
            }
            webRtcAudioRecord.m21611a(z, "AudioRecord has not stopped %d", Integer.valueOf(this.f21182a.f21188e.getRecordingState()));
        }

        public final void m21606a() {
            this.f21183b = false;
            while (isAlive()) {
                try {
                    join();
                } catch (InterruptedException e) {
                }
            }
        }
    }

    @DoNotStrip
    private native void nativeCacheDirectRecordBufferAddress(ByteBuffer byteBuffer, long j);

    @DoNotStrip
    private native void nativeCacheRecordAudioParameters(int i, int i2, boolean z, int i3, long j);

    @DoNotStrip
    private native void nativeDataIsRecorded(int i, long j);

    @DoNotStrip
    private native void nativeEngineTrace(int i, String str);

    @DoNotStrip
    WebRtcAudioRecord(Context context, long j) {
        this.f21186c = context;
        this.f21185b = j;
    }

    @DoNotStrip
    public int initRecording(int i, int i2) {
        this.f21184a.m21642a("initRecording(sampleRate=%d, channels=%d)", Integer.valueOf(i), Integer.valueOf(i2));
        if (WebRtcAudioUtils.m21633a(this.f21186c, "android.permission.RECORD_AUDIO")) {
            if (this.f21188e != null) {
                this.f21184a.m21643b("initRecording() called twice without stopRecording()", new Object[0]);
                this.f21188e.release();
                this.f21188e = null;
            }
            int i3 = i / 100;
            this.f21187d = ByteBuffer.allocateDirect((i2 * 2) * i3);
            this.f21184a.m21642a("mByteBuffer.capacity: %d", Integer.valueOf(this.f21187d.capacity()));
            nativeCacheDirectRecordBufferAddress(this.f21187d, this.f21185b);
            int minBufferSize = AudioRecord.getMinBufferSize(i, 16, 2);
            if (minBufferSize == -1 || minBufferSize == -2) {
                this.f21184a.m21644c("AudioRecord.getMinBufferSize failed: %d", Integer.valueOf(minBufferSize));
                return -1;
            }
            int i4;
            this.f21184a.m21642a("AudioRecord.getMinBufferSize: %d", Integer.valueOf(minBufferSize));
            int max = Math.max(this.f21187d.capacity(), minBufferSize * 2);
            this.f21184a.m21642a("bufferSizeInBytes: %d", Integer.valueOf(max));
            if (WebRtcAudioUtils.m21631a()) {
                i4 = 7;
            } else {
                i4 = 1;
            }
            try {
                this.f21188e = new AudioRecord(i4, i, 16, 2, max);
            } catch (Throwable e) {
                this.f21184a.m21641a("new AudioRecord illegal argument", e);
            } catch (Throwable e2) {
                this.f21184a.m21641a("new AudioRecord unknown exception", e2);
            }
            if (this.f21188e == null) {
                this.f21184a.m21644c("Failed to create a new AudioRecord instance", new Object[0]);
                return -1;
            } else if (this.f21188e.getState() != 1) {
                this.f21184a.m21644c("AudioRecord is not intialized (%d)", Integer.valueOf(this.f21188e.getState()));
                this.f21188e.release();
                this.f21188e = null;
                return -1;
            } else {
                boolean z;
                m21611a(this.f21188e.getRecordingState() == 1, "Incorrect recording state %d", Integer.valueOf(this.f21188e.getRecordingState()));
                if (this.f21188e.getAudioSource() == i4) {
                    z = true;
                } else {
                    z = false;
                }
                m21611a(z, "Incorrect audio source %d != %d", Integer.valueOf(i4), Integer.valueOf(this.f21188e.getAudioSource()));
                if (i4 == 7 && WebRtcAudioUtils.m21634b()) {
                    m21613b();
                    m21615c();
                    m21617d();
                }
                this.f21184a.m21642a("AudioRecord audio format: %d channels: %d sample rate: %d", Integer.valueOf(this.f21188e.getAudioFormat()), Integer.valueOf(this.f21188e.getChannelCount()), Integer.valueOf(this.f21188e.getSampleRate()));
                nativeCacheRecordAudioParameters(this.f21188e.getSampleRate(), this.f21188e.getChannelCount(), WebRtcAudioUtils.m21632a(this.f21186c), max, this.f21185b);
                return i3;
            }
        }
        this.f21184a.m21644c("RECORD_AUDIO permission is missing", new Object[0]);
        return -1;
    }

    @DoNotStrip
    public boolean startRecording() {
        this.f21184a.m21642a("startRecording", new Object[0]);
        if (this.f21188e == null) {
            this.f21184a.m21644c("AudioRecord is null", new Object[0]);
            return false;
        }
        try {
            boolean z;
            this.f21188e.startRecording();
            if (this.f21188e.getRecordingState() == 3) {
                z = true;
            } else {
                z = false;
            }
            m21611a(z, "AudioRecord is not in recording state after startRecording", new Object[0]);
            if (this.f21189f == null) {
                z = true;
            } else {
                z = false;
            }
            m21611a(z, "Recording thread was not destroyed properly", new Object[0]);
            this.f21189f = new AudioRecordThread(this, "AudioRecordJavaThread");
            this.f21189f.start();
            return true;
        } catch (Throwable e) {
            this.f21184a.m21641a("AudioRecord.startRecording() illegal state", e);
            return false;
        } catch (Throwable e2) {
            this.f21184a.m21641a("AudioRecord.startRecording() unkonwn excption", e2);
            return false;
        }
    }

    @DoNotStrip
    public boolean stopRecording() {
        this.f21184a.m21642a("stopRecording", new Object[0]);
        if (this.f21189f != null) {
            this.f21189f.m21606a();
            this.f21189f = null;
        }
        if (WebRtcAudioUtils.m21634b()) {
            m21608a();
        }
        if (this.f21188e != null) {
            this.f21188e.release();
            this.f21188e = null;
        }
        return true;
    }

    @DoNotStrip
    public void setNativeTraceLevel(int i) {
        this.f21184a.f21206a = i;
    }

    @DoNotStrip
    public boolean enableBuiltInAEC(boolean z) {
        this.f21184a.m21642a("enableBuiltInAEC(%b)", Boolean.valueOf(z));
        this.f21193j = z;
        if (WebRtcAudioUtils.m21634b()) {
            return m21613b();
        }
        return false;
    }

    @DoNotStrip
    public boolean enableBuiltInAGC(boolean z) {
        this.f21184a.m21642a("enableBuiltInAGC(%b)", Boolean.valueOf(z));
        this.f21194k = z;
        if (WebRtcAudioUtils.m21634b()) {
            return m21615c();
        }
        return false;
    }

    @DoNotStrip
    public boolean enableBuiltInNS(boolean z) {
        this.f21184a.m21642a("enableBuiltInNS(%b)", Boolean.valueOf(z));
        this.f21195l = z;
        if (WebRtcAudioUtils.m21634b()) {
            return m21617d();
        }
        return false;
    }

    @TargetApi(16)
    private void m21608a() {
        if (this.f21190g != null) {
            this.f21190g.release();
            this.f21190g = null;
        }
        if (this.f21191h != null) {
            this.f21191h.release();
            this.f21191h = null;
        }
        if (this.f21192i != null) {
            this.f21192i.release();
            this.f21192i = null;
        }
    }

    @TargetApi(16)
    private boolean m21613b() {
        if (this.f21190g == null) {
            try {
                if (!AcousticEchoCanceler.isAvailable()) {
                    this.f21184a.m21642a("AcousticEchoCanceler api is not supported", new Object[0]);
                    return false;
                } else if (this.f21188e == null) {
                    return false;
                } else {
                    this.f21190g = AcousticEchoCanceler.create(this.f21188e.getAudioSessionId());
                    if (this.f21190g == null) {
                        this.f21184a.m21644c("AcousticEchoCanceler.create failed", new Object[0]);
                        return false;
                    }
                    Descriptor descriptor = this.f21190g.getDescriptor();
                    this.f21184a.m21642a("AcousticEchoCanceler name: %s implementor: %s uuid: %s", descriptor.name, descriptor.implementor, descriptor.uuid);
                }
            } catch (Throwable e) {
                this.f21184a.m21641a("AEC Creation exception", e);
                return false;
            }
        }
        if (this.f21190g != null) {
            this.f21184a.m21642a("Default AEC: %b", Boolean.valueOf(this.f21190g.getEnabled()));
            if (!(this.f21193j == this.f21190g.getEnabled() || this.f21190g.setEnabled(this.f21193j) == 0)) {
                this.f21184a.m21644c("AcousticEchoCanceler.setEnabled failed", new Object[0]);
                return false;
            }
        }
        return true;
    }

    @TargetApi(16)
    private boolean m21615c() {
        if (this.f21191h == null) {
            try {
                if (!AutomaticGainControl.isAvailable()) {
                    this.f21184a.m21642a("AutomaticGainControl api is not supported", new Object[0]);
                    return false;
                } else if (this.f21188e == null) {
                    return false;
                } else {
                    this.f21191h = AutomaticGainControl.create(this.f21188e.getAudioSessionId());
                    if (this.f21191h == null) {
                        this.f21184a.m21644c("AutomaticGainControl.create failed", new Object[0]);
                        return false;
                    }
                    Descriptor descriptor = this.f21191h.getDescriptor();
                    this.f21184a.m21642a("AutomaticGainControl name: %s implementor: %s uuid: %s", descriptor.name, descriptor.implementor, descriptor.uuid);
                }
            } catch (Throwable e) {
                this.f21184a.m21641a("AGC Creation exception", e);
                return false;
            }
        }
        if (this.f21191h != null) {
            this.f21184a.m21642a("Default AGC: %b", Boolean.valueOf(this.f21191h.getEnabled()));
            if (!(this.f21194k == this.f21191h.getEnabled() || this.f21191h.setEnabled(this.f21194k) == 0)) {
                this.f21184a.m21644c("AutomaticGainControl.setEnabled failed", new Object[0]);
                return false;
            }
        }
        return true;
    }

    @TargetApi(16)
    private boolean m21617d() {
        if (this.f21192i == null) {
            try {
                if (!NoiseSuppressor.isAvailable()) {
                    this.f21184a.m21642a("NoiseSuppressor api is not supported", new Object[0]);
                    return false;
                } else if (this.f21188e == null) {
                    return false;
                } else {
                    this.f21192i = NoiseSuppressor.create(this.f21188e.getAudioSessionId());
                    if (this.f21192i == null) {
                        this.f21184a.m21644c("NoiseSuppressor.create failed", new Object[0]);
                        return false;
                    }
                    Descriptor descriptor = this.f21192i.getDescriptor();
                    this.f21184a.m21642a("NoiseSuppressor name: %s implementor: %s uuid: %s", descriptor.name, descriptor.implementor, descriptor.uuid);
                }
            } catch (Throwable e) {
                this.f21184a.m21641a("NS Creation exception", e);
                return false;
            }
        }
        if (this.f21192i != null) {
            this.f21184a.m21642a("Default NS: %b", Boolean.valueOf(this.f21192i.getEnabled()));
            if (!(this.f21195l == this.f21192i.getEnabled() || this.f21192i.setEnabled(this.f21195l) == 0)) {
                this.f21184a.m21644c("NoiseSuppressor.setEnabled failed", new Object[0]);
                return false;
            }
        }
        return true;
    }

    @DoNotStrip
    public boolean isBuiltInAECEnabled() {
        if (WebRtcAudioUtils.m21634b()) {
            return m21618e();
        }
        return false;
    }

    @DoNotStrip
    public boolean isBuiltInAGCEnabled() {
        if (WebRtcAudioUtils.m21634b()) {
            return m21619f();
        }
        return false;
    }

    @DoNotStrip
    public boolean isBuiltInNSEnabled() {
        if (WebRtcAudioUtils.m21634b()) {
            return m21620g();
        }
        return false;
    }

    @TargetApi(16)
    private boolean m21618e() {
        return this.f21190g != null && this.f21190g.getEnabled();
    }

    @TargetApi(16)
    private boolean m21619f() {
        return this.f21191h != null && this.f21191h.getEnabled();
    }

    @TargetApi(16)
    private boolean m21620g() {
        return this.f21192i != null && this.f21192i.getEnabled();
    }

    private void m21611a(boolean z, String str, Object... objArr) {
        if (!z) {
            String a = StringFormatUtil.a(str, objArr);
            if (BuildConstants.i) {
                throw new AssertionError(a);
            }
            this.f21184a.m21644c(a, new Object[0]);
        }
    }

    public final void mo928a(int i, String str) {
        nativeEngineTrace(i, str);
    }
}
