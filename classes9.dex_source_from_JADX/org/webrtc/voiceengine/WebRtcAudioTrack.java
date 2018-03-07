package org.webrtc.voiceengine;

import android.content.Context;
import android.media.AudioTrack;
import android.os.Process;
import com.facebook.common.build.BuildConstants;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.proguard.annotations.DoNotStrip;
import java.nio.ByteBuffer;

@DoNotStrip
/* compiled from: affected_users */
class WebRtcAudioTrack implements WebRtcEngineLoggerDelegate {
    public final WebRtcEngineLogger f21198a = new WebRtcEngineLogger(this);
    private final Context f21199b;
    public final long f21200c;
    public ByteBuffer f21201d = null;
    public AudioTrack f21202e = null;
    private AudioTrackThread f21203f = null;

    /* compiled from: affected_users */
    class AudioTrackThread extends Thread {
        final /* synthetic */ WebRtcAudioTrack f21196a;
        private volatile boolean f21197b = true;

        public AudioTrackThread(WebRtcAudioTrack webRtcAudioTrack, String str) {
            this.f21196a = webRtcAudioTrack;
            super(str);
        }

        public void run() {
            boolean z;
            Process.setThreadPriority(-19);
            this.f21196a.f21198a.m21642a("AudioTrackThread %s", WebRtcAudioUtils.m21637e());
            this.f21196a.m21626a(this.f21196a.f21202e.getPlayState() == 3, "AudioTrack is not int play state in processing thread", new Object[0]);
            int capacity = this.f21196a.f21201d.capacity();
            while (this.f21197b) {
                int write;
                this.f21196a.nativeGetPlayoutData(capacity, this.f21196a.f21200c);
                this.f21196a.m21626a(capacity <= this.f21196a.f21201d.remaining(), "Invalid buffer size %d > %d", Integer.valueOf(capacity), Integer.valueOf(this.f21196a.f21201d.remaining()));
                if (WebRtcAudioUtils.m21636d()) {
                    write = this.f21196a.f21202e.write(this.f21196a.f21201d, capacity, 0);
                } else {
                    write = this.f21196a.f21202e.write(this.f21196a.f21201d.array(), this.f21196a.f21201d.arrayOffset(), capacity);
                }
                if (write != capacity) {
                    this.f21196a.f21198a.m21644c("AudioTrack.write failed: %d", Integer.valueOf(write));
                    if (write == -3) {
                        this.f21197b = false;
                    }
                }
                this.f21196a.f21201d.rewind();
            }
            try {
                this.f21196a.f21202e.stop();
            } catch (Throwable e) {
                this.f21196a.f21198a.m21641a("AudioTrack.stop illegal state", e);
            } catch (Throwable e2) {
                this.f21196a.f21198a.m21641a("AudioTrack.stop unknown exception", e2);
            }
            this.f21196a.f21202e.flush();
            WebRtcAudioTrack webRtcAudioTrack = this.f21196a;
            if (this.f21196a.f21202e.getPlayState() == 1) {
                z = true;
            } else {
                z = false;
            }
            webRtcAudioTrack.m21626a(z, "AudioTrack is not stopped properly %d", Integer.valueOf(this.f21196a.f21202e.getPlayState()));
        }

        public final void m21622a() {
            this.f21197b = false;
            while (isAlive()) {
                try {
                    join();
                } catch (InterruptedException e) {
                }
            }
        }
    }

    @DoNotStrip
    private native void nativeCacheDirectPlayoutBufferAddress(ByteBuffer byteBuffer, long j);

    @DoNotStrip
    private native void nativeCachePlayoutAudioParameters(int i, int i2, boolean z, int i3, long j);

    @DoNotStrip
    private native void nativeEngineTrace(int i, String str);

    @DoNotStrip
    private native void nativeGetPlayoutData(int i, long j);

    @DoNotStrip
    WebRtcAudioTrack(Context context, long j) {
        this.f21199b = context;
        this.f21200c = j;
    }

    @DoNotStrip
    public boolean initPlayout(int i, int i2) {
        this.f21198a.m21642a("initPlayout(sampleRate=%d, channels=%d)", Integer.valueOf(i), Integer.valueOf(i2));
        this.f21201d = ByteBuffer.allocateDirect((i2 * 2) * (i / 100));
        this.f21198a.m21642a("mByteBuffer.capacity: %d", Integer.valueOf(this.f21201d.capacity()));
        nativeCacheDirectPlayoutBufferAddress(this.f21201d, this.f21200c);
        this.f21198a.m21642a("AudioTrack.getMinBufferSize: %d", Integer.valueOf(AudioTrack.getMinBufferSize(i, 4, 2)));
        int i3 = r0 * 2;
        if (this.f21202e != null) {
            this.f21198a.m21643b("initPlayout() called twice without stopPlayout()", new Object[0]);
            this.f21202e.release();
            this.f21202e = null;
        }
        m21626a(this.f21201d.capacity() < i3, "Buffer size too small %d >= %d", Integer.valueOf(this.f21201d.capacity()), Integer.valueOf(i3));
        try {
            this.f21202e = new AudioTrack(0, i, 4, 2, i3, 1);
        } catch (Throwable e) {
            this.f21198a.m21641a("new AudioTrack illegal argument", e);
        } catch (Throwable e2) {
            this.f21198a.m21641a("new AudioTrack Unknown excption", e2);
        }
        if (this.f21202e == null) {
            this.f21198a.m21644c("Failed to create a new AudioTrack instance", new Object[0]);
            return false;
        } else if (this.f21202e.getState() != 1) {
            this.f21198a.m21644c("AudioTrack is not initialized (%d)", Integer.valueOf(this.f21202e.getState()));
            this.f21202e.release();
            this.f21202e = null;
            return false;
        } else {
            boolean z;
            m21626a(this.f21202e.getPlayState() == 1, "Incorrect play state %d", Integer.valueOf(this.f21202e.getPlayState()));
            if (this.f21202e.getStreamType() == 0) {
                z = true;
            } else {
                z = false;
            }
            m21626a(z, "Incorrect stream typei %d", Integer.valueOf(this.f21202e.getStreamType()));
            this.f21198a.m21642a("AudioTrack audio format: %d channels: %d sample rate: %d", Integer.valueOf(this.f21202e.getAudioFormat()), Integer.valueOf(this.f21202e.getChannelCount()), Integer.valueOf(this.f21202e.getSampleRate()));
            nativeCachePlayoutAudioParameters(this.f21202e.getSampleRate(), this.f21202e.getChannelCount(), WebRtcAudioUtils.m21632a(this.f21199b), i3, this.f21200c);
            return true;
        }
    }

    @DoNotStrip
    public boolean startPlayout() {
        this.f21198a.m21642a("startPlayout", new Object[0]);
        if (this.f21202e == null) {
            this.f21198a.m21644c("AudioTrack is null", new Object[0]);
            return false;
        }
        try {
            boolean z;
            this.f21202e.play();
            if (this.f21202e.getPlayState() == 3) {
                z = true;
            } else {
                z = false;
            }
            m21626a(z, "AudioTrack is not in play state after play()", new Object[0]);
            if (this.f21203f == null) {
                z = true;
            } else {
                z = false;
            }
            m21626a(z, "Playout thread was not destroyed properly", new Object[0]);
            this.f21203f = new AudioTrackThread(this, "AudioTrackJavaThread");
            this.f21203f.start();
            return true;
        } catch (Throwable e) {
            this.f21198a.m21641a("AudioTrack.play illegal state", e);
            return false;
        } catch (Throwable e2) {
            this.f21198a.m21641a("AudioTrack.play unknown exception", e2);
            return false;
        }
    }

    @DoNotStrip
    public boolean stopPlayout() {
        this.f21198a.m21642a("stopPlayout", new Object[0]);
        if (this.f21203f != null) {
            this.f21203f.m21622a();
            this.f21203f = null;
        }
        if (this.f21202e != null) {
            this.f21202e.release();
            this.f21202e = null;
        }
        return true;
    }

    @DoNotStrip
    public void setNativeTraceLevel(int i) {
        this.f21198a.f21206a = i;
    }

    private void m21626a(boolean z, String str, Object... objArr) {
        if (!z) {
            String a = StringFormatUtil.a(str, objArr);
            if (BuildConstants.i) {
                throw new AssertionError(a);
            }
            this.f21198a.m21644c(a, new Object[0]);
        }
    }

    public final void mo928a(int i, String str) {
        nativeEngineTrace(i, str);
    }
}
