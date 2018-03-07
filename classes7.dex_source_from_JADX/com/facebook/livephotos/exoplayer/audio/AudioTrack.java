package com.facebook.livephotos.exoplayer.audio;

import android.annotation.TargetApi;
import android.media.AudioTimestamp;
import android.media.MediaFormat;
import android.media.PlaybackParams;
import android.os.ConditionVariable;
import android.os.SystemClock;
import android.util.Log;
import com.facebook.livephotos.exoplayer.C0610C;
import com.facebook.livephotos.exoplayer.util.Ac3Util;
import com.facebook.livephotos.exoplayer.util.Assertions;
import com.facebook.livephotos.exoplayer.util.Util;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;

@TargetApi(16)
/* compiled from: page_unlike_successful */
public final class AudioTrack {
    public static boolean f6917a = false;
    public static boolean f6918b = false;
    public int f6919A;
    private long f6920B;
    private long f6921C;
    private long f6922D;
    private float f6923E;
    private byte[] f6924F;
    private int f6925G;
    private int f6926H;
    public final AudioCapabilities f6927c;
    private final int f6928d;
    public final ConditionVariable f6929e;
    private final long[] f6930f;
    public final AudioTrackUtil f6931g;
    private android.media.AudioTrack f6932h;
    private android.media.AudioTrack f6933i;
    private int f6934j;
    private int f6935k;
    private int f6936l;
    private boolean f6937m;
    private int f6938n;
    private int f6939o;
    private long f6940p;
    private int f6941q;
    private int f6942r;
    private long f6943s;
    private long f6944t;
    private boolean f6945u;
    private long f6946v;
    private Method f6947w;
    private long f6948x;
    private long f6949y;
    private int f6950z;

    /* compiled from: page_unlike_successful */
    public class AudioTrackUtil {
        public android.media.AudioTrack f6902a;
        private boolean f6903b;
        private int f6904c;
        private long f6905d;
        private long f6906e;
        private long f6907f;
        public long f6908g;
        public long f6909h;
        public long f6910i;

        public void mo400a(android.media.AudioTrack audioTrack, boolean z) {
            this.f6902a = audioTrack;
            this.f6903b = z;
            this.f6908g = -1;
            this.f6905d = 0;
            this.f6906e = 0;
            this.f6907f = 0;
            if (audioTrack != null) {
                this.f6904c = audioTrack.getSampleRate();
            }
        }

        public final long m8776b() {
            if (this.f6908g != -1) {
                return Math.min(this.f6910i, ((((SystemClock.elapsedRealtime() * 1000) - this.f6908g) * ((long) this.f6904c)) / 1000000) + this.f6909h);
            }
            int playState = this.f6902a.getPlayState();
            if (playState == 1) {
                return 0;
            }
            long playbackHeadPosition = 4294967295L & ((long) this.f6902a.getPlaybackHeadPosition());
            if (this.f6903b) {
                if (playState == 2 && playbackHeadPosition == 0) {
                    this.f6907f = this.f6905d;
                }
                playbackHeadPosition += this.f6907f;
            }
            if (this.f6905d > playbackHeadPosition) {
                this.f6906e++;
            }
            this.f6905d = playbackHeadPosition;
            return playbackHeadPosition + (this.f6906e << 32);
        }

        public final long m8777c() {
            return (m8776b() * 1000000) / ((long) this.f6904c);
        }

        public boolean mo401d() {
            return false;
        }

        public long mo402e() {
            throw new UnsupportedOperationException();
        }

        public long mo403f() {
            throw new UnsupportedOperationException();
        }

        public void mo404a(PlaybackParams playbackParams) {
            throw new UnsupportedOperationException();
        }

        public float mo405g() {
            return 1.0f;
        }
    }

    @TargetApi(19)
    /* compiled from: page_unlike_successful */
    class AudioTrackUtilV19 extends AudioTrackUtil {
        private final AudioTimestamp f6911b = new AudioTimestamp();
        private long f6912c;
        private long f6913d;
        private long f6914e;

        public void mo400a(android.media.AudioTrack audioTrack, boolean z) {
            super.mo400a(audioTrack, z);
            this.f6912c = 0;
            this.f6913d = 0;
            this.f6914e = 0;
        }

        public final boolean mo401d() {
            boolean timestamp = this.f6902a.getTimestamp(this.f6911b);
            if (timestamp) {
                long j = this.f6911b.framePosition;
                if (this.f6913d > j) {
                    this.f6912c++;
                }
                this.f6913d = j;
                this.f6914e = j + (this.f6912c << 32);
            }
            return timestamp;
        }

        public final long mo402e() {
            return this.f6911b.nanoTime;
        }

        public final long mo403f() {
            return this.f6914e;
        }
    }

    @TargetApi(23)
    /* compiled from: page_unlike_successful */
    class AudioTrackUtilV23 extends AudioTrackUtilV19 {
        private PlaybackParams f6915b;
        private float f6916c = 1.0f;

        public final void mo400a(android.media.AudioTrack audioTrack, boolean z) {
            super.mo400a(audioTrack, z);
            m8786h();
        }

        public final void mo404a(PlaybackParams playbackParams) {
            if (playbackParams == null) {
                playbackParams = new PlaybackParams();
            }
            PlaybackParams allowDefaults = playbackParams.allowDefaults();
            this.f6915b = allowDefaults;
            this.f6916c = allowDefaults.getSpeed();
            m8786h();
        }

        public final float mo405g() {
            return this.f6916c;
        }

        private void m8786h() {
            if (this.f6902a != null && this.f6915b != null) {
                this.f6902a.setPlaybackParams(this.f6915b);
            }
        }
    }

    /* compiled from: page_unlike_successful */
    public final class InitializationException extends Exception {
        public final int audioTrackState;

        public InitializationException(int i, int i2, int i3, int i4) {
            super("AudioTrack init failed: " + i + ", Config(" + i2 + ", " + i3 + ", " + i4 + ")");
            this.audioTrackState = i;
        }
    }

    /* compiled from: page_unlike_successful */
    public final class InvalidAudioTrackTimestampException extends RuntimeException {
        public InvalidAudioTrackTimestampException(String str) {
            super(str);
        }
    }

    /* compiled from: page_unlike_successful */
    public final class WriteException extends Exception {
        public final int errorCode;

        public WriteException(int i) {
            super("AudioTrack write failed: " + i);
            this.errorCode = i;
        }
    }

    public AudioTrack() {
        this(null, 3);
    }

    public AudioTrack(AudioCapabilities audioCapabilities, int i) {
        this.f6927c = audioCapabilities;
        this.f6928d = i;
        this.f6929e = new ConditionVariable(true);
        if (Util.f7736a >= 18) {
            try {
                this.f6947w = android.media.AudioTrack.class.getMethod("getLatency", null);
            } catch (NoSuchMethodException e) {
            }
        }
        if (Util.f7736a >= 23) {
            this.f6931g = new AudioTrackUtilV23();
        } else if (Util.f7736a >= 19) {
            this.f6931g = new AudioTrackUtilV19();
        } else {
            this.f6931g = new AudioTrackUtil();
        }
        this.f6930f = new long[10];
        this.f6923E = 1.0f;
        this.f6919A = 0;
    }

    public final boolean m8810a() {
        return this.f6933i != null;
    }

    public final long m8807a(boolean z) {
        Object obj;
        if (!m8810a() || this.f6919A == 0) {
            obj = null;
        } else {
            obj = 1;
        }
        if (obj == null) {
            return Long.MIN_VALUE;
        }
        if (this.f6933i.getPlayState() == 3) {
            m8799o();
        }
        long nanoTime = System.nanoTime() / 1000;
        if (this.f6945u) {
            return m8795b(m8796c((long) (((float) (nanoTime - (this.f6931g.mo402e() / 1000))) * this.f6931g.mo405g())) + this.f6931g.mo403f()) + this.f6920B;
        }
        if (this.f6942r == 0) {
            nanoTime = this.f6931g.m8777c() + this.f6920B;
        } else {
            nanoTime = (nanoTime + this.f6943s) + this.f6920B;
        }
        if (z) {
            return nanoTime;
        }
        return nanoTime - this.f6922D;
    }

    public final void m8809a(MediaFormat mediaFormat, boolean z) {
        m8793a(mediaFormat, z, 0);
    }

    private void m8793a(MediaFormat mediaFormat, boolean z, int i) {
        int i2;
        int integer = mediaFormat.getInteger("channel-count");
        switch (integer) {
            case 1:
                i2 = 4;
                break;
            case 2:
                i2 = 12;
                break;
            case 3:
                i2 = 28;
                break;
            case 4:
                i2 = 204;
                break;
            case 5:
                i2 = 220;
                break;
            case 6:
                i2 = 252;
                break;
            case 7:
                i2 = 1276;
                break;
            case 8:
                i2 = C0610C.f6689a;
                break;
            default:
                throw new IllegalArgumentException("Unsupported channel count: " + integer);
        }
        int integer2 = mediaFormat.getInteger("sample-rate");
        int b = z ? m8794b(mediaFormat.getString("mime")) : 2;
        if (!m8810a() || this.f6934j != integer2 || this.f6935k != i2 || this.f6936l != b) {
            AudioTrack audioTrack;
            long j;
            m8819j();
            this.f6936l = b;
            this.f6937m = z;
            this.f6934j = integer2;
            this.f6935k = i2;
            this.f6938n = integer * 2;
            if (i != 0) {
                audioTrack = this;
            } else if (!z) {
                integer = android.media.AudioTrack.getMinBufferSize(integer2, i2, b);
                Assertions.m9297b(integer != -2);
                b = integer * 4;
                i = ((int) m8796c(250000)) * this.f6938n;
                i2 = (int) Math.max((long) integer, m8796c(750000) * ((long) this.f6938n));
                if (b < i) {
                    audioTrack = this;
                } else if (b > i2) {
                    i = i2;
                    audioTrack = this;
                } else {
                    i = b;
                    audioTrack = this;
                }
            } else if (b == 5 || b == 6) {
                i = 20480;
                audioTrack = this;
            } else {
                i = 49152;
                audioTrack = this;
            }
            audioTrack.f6939o = i;
            if (z) {
                j = -1;
            } else {
                j = m8795b(m8792a((long) this.f6939o));
            }
            this.f6940p = j;
        }
    }

    public final int m8811b() {
        return m8805a(0);
    }

    public final int m8805a(int i) {
        this.f6929e.block();
        if (i == 0) {
            this.f6933i = new android.media.AudioTrack(this.f6928d, this.f6934j, this.f6935k, this.f6936l, this.f6939o, 1);
        } else {
            this.f6933i = new android.media.AudioTrack(this.f6928d, this.f6934j, this.f6935k, this.f6936l, this.f6939o, 1, i);
        }
        m8800p();
        int audioSessionId = this.f6933i.getAudioSessionId();
        if (f6917a && Util.f7736a < 21) {
            if (!(this.f6932h == null || audioSessionId == this.f6932h.getAudioSessionId())) {
                m8798m();
            }
            if (this.f6932h == null) {
                this.f6932h = new android.media.AudioTrack(this.f6928d, 4000, 4, 2, 2, 0, audioSessionId);
            }
        }
        this.f6931g.mo400a(this.f6933i, m8803s());
        m8797l();
        return audioSessionId;
    }

    public final int m8812c() {
        return this.f6939o;
    }

    public final long m8813d() {
        return this.f6940p;
    }

    public final void m8814e() {
        if (m8810a()) {
            this.f6921C = System.nanoTime() / 1000;
            this.f6933i.play();
        }
    }

    public final void m8815f() {
        if (this.f6919A == 1) {
            this.f6919A = 2;
        }
    }

    public final int m8806a(ByteBuffer byteBuffer, int i, int i2, long j) {
        if (i2 == 0) {
            return 2;
        }
        int i3;
        if (m8803s()) {
            if (this.f6933i.getPlayState() == 2) {
                return 0;
            }
            if (this.f6933i.getPlayState() == 1 && this.f6931g.m8776b() != 0) {
                return 0;
            }
        }
        if (this.f6926H == 0) {
            this.f6926H = i2;
            byteBuffer.position(i);
            if (this.f6937m && this.f6950z == 0) {
                this.f6950z = m8790a(this.f6936l, byteBuffer);
            }
            long b = j - m8795b(this.f6937m ? (long) this.f6950z : m8792a((long) i2));
            if (this.f6919A == 0) {
                this.f6920B = Math.max(0, b);
                this.f6919A = 1;
                i3 = 0;
            } else {
                long b2 = this.f6920B + m8795b(m8801q());
                if (this.f6919A == 1 && Math.abs(b2 - b) > 200000) {
                    Log.e("AudioTrack", "Discontinuity detected [expected " + b2 + ", got " + b + "]");
                    this.f6919A = 2;
                }
                if (this.f6919A == 2) {
                    this.f6920B = (b - b2) + this.f6920B;
                    this.f6919A = 1;
                    i3 = 1;
                } else {
                    i3 = 0;
                }
            }
            if (Util.f7736a < 21) {
                if (this.f6924F == null || this.f6924F.length < i2) {
                    this.f6924F = new byte[i2];
                }
                byteBuffer.get(this.f6924F, 0, i2);
                this.f6925G = 0;
            }
        } else {
            i3 = 0;
        }
        int i4 = 0;
        if (Util.f7736a < 21) {
            int b3 = this.f6939o - ((int) (this.f6948x - (this.f6931g.m8776b() * ((long) this.f6938n))));
            if (b3 > 0) {
                i4 = this.f6933i.write(this.f6924F, this.f6925G, Math.min(this.f6926H, b3));
                if (i4 >= 0) {
                    this.f6925G += i4;
                }
            }
        } else {
            i4 = m8791a(this.f6933i, byteBuffer, this.f6926H);
        }
        if (i4 < 0) {
            throw new WriteException(i4);
        }
        this.f6926H -= i4;
        if (!this.f6937m) {
            this.f6948x += (long) i4;
        }
        if (this.f6926H != 0) {
            return i3;
        }
        if (this.f6937m) {
            this.f6949y += (long) this.f6950z;
        }
        return i3 | 2;
    }

    public final void m8816g() {
        if (m8810a()) {
            AudioTrackUtil audioTrackUtil = this.f6931g;
            long q = m8801q();
            audioTrackUtil.f6909h = audioTrackUtil.m8776b();
            audioTrackUtil.f6908g = SystemClock.elapsedRealtime() * 1000;
            audioTrackUtil.f6910i = q;
            audioTrackUtil.f6902a.stop();
        }
    }

    @TargetApi(21)
    private static int m8791a(android.media.AudioTrack audioTrack, ByteBuffer byteBuffer, int i) {
        return audioTrack.write(byteBuffer, i, 1);
    }

    public final boolean m8817h() {
        return m8810a() && (m8801q() > this.f6931g.m8776b() || m8804t());
    }

    public final void m8808a(float f) {
        if (this.f6923E != f) {
            this.f6923E = f;
            m8797l();
        }
    }

    private void m8797l() {
        if (!m8810a()) {
            return;
        }
        if (Util.f7736a >= 21) {
            this.f6933i.setVolume(this.f6923E);
            return;
        }
        android.media.AudioTrack audioTrack = this.f6933i;
        float f = this.f6923E;
        audioTrack.setStereoVolume(f, f);
    }

    public final void m8818i() {
        if (m8810a()) {
            m8802r();
            AudioTrackUtil audioTrackUtil = this.f6931g;
            if (audioTrackUtil.f6908g == -1) {
                audioTrackUtil.f6902a.pause();
            }
        }
    }

    public final void m8819j() {
        if (m8810a()) {
            this.f6948x = 0;
            this.f6949y = 0;
            this.f6950z = 0;
            this.f6926H = 0;
            this.f6919A = 0;
            this.f6922D = 0;
            m8802r();
            if (this.f6933i.getPlayState() == 3) {
                this.f6933i.pause();
            }
            final android.media.AudioTrack audioTrack = this.f6933i;
            this.f6933i = null;
            this.f6931g.mo400a(null, false);
            this.f6929e.close();
            new Thread(this) {
                final /* synthetic */ AudioTrack f6899b;

                public void run() {
                    try {
                        audioTrack.flush();
                        audioTrack.release();
                    } finally {
                        this.f6899b.f6929e.open();
                    }
                }
            }.start();
        }
    }

    public final void m8820k() {
        m8819j();
        m8798m();
    }

    private void m8798m() {
        if (this.f6932h != null) {
            final android.media.AudioTrack audioTrack = this.f6932h;
            this.f6932h = null;
            new Thread(this) {
                final /* synthetic */ AudioTrack f6901b;

                public void run() {
                    audioTrack.release();
                }
            }.start();
        }
    }

    private void m8799o() {
        long c = this.f6931g.m8777c();
        if (c != 0) {
            long nanoTime = System.nanoTime() / 1000;
            if (nanoTime - this.f6944t >= 30000) {
                this.f6930f[this.f6941q] = c - nanoTime;
                this.f6941q = (this.f6941q + 1) % 10;
                if (this.f6942r < 10) {
                    this.f6942r++;
                }
                this.f6944t = nanoTime;
                this.f6943s = 0;
                for (int i = 0; i < this.f6942r; i++) {
                    this.f6943s += this.f6930f[i] / ((long) this.f6942r);
                }
            }
            if (!m8803s() && nanoTime - this.f6946v >= 500000) {
                this.f6945u = this.f6931g.mo401d();
                if (this.f6945u) {
                    long e = this.f6931g.mo402e() / 1000;
                    long f = this.f6931g.mo403f();
                    if (e < this.f6921C) {
                        this.f6945u = false;
                    } else if (Math.abs(e - nanoTime) > 5000000) {
                        r0 = "Spurious audio timestamp (system clock mismatch): " + f + ", " + e + ", " + nanoTime + ", " + c;
                        if (f6918b) {
                            throw new InvalidAudioTrackTimestampException(r0);
                        }
                        Log.w("AudioTrack", r0);
                        this.f6945u = false;
                    } else if (Math.abs(m8795b(f) - c) > 5000000) {
                        r0 = "Spurious audio timestamp (frame position mismatch): " + f + ", " + e + ", " + nanoTime + ", " + c;
                        if (f6918b) {
                            throw new InvalidAudioTrackTimestampException(r0);
                        }
                        Log.w("AudioTrack", r0);
                        this.f6945u = false;
                    }
                }
                if (!(this.f6947w == null || this.f6937m)) {
                    try {
                        this.f6922D = (((long) ((Integer) this.f6947w.invoke(this.f6933i, null)).intValue()) * 1000) - this.f6940p;
                        this.f6922D = Math.max(this.f6922D, 0);
                        if (this.f6922D > 5000000) {
                            Log.w("AudioTrack", "Ignoring impossibly large audio latency: " + this.f6922D);
                            this.f6922D = 0;
                        }
                    } catch (Exception e2) {
                        this.f6947w = null;
                    }
                }
                this.f6946v = nanoTime;
            }
        }
    }

    private void m8800p() {
        int state = this.f6933i.getState();
        if (state != 1) {
            try {
                this.f6933i.release();
            } catch (Exception e) {
            } finally {
                this.f6933i = null;
            }
            throw new InitializationException(state, this.f6934j, this.f6935k, this.f6939o);
        }
    }

    private long m8792a(long j) {
        return j / ((long) this.f6938n);
    }

    private long m8795b(long j) {
        return (1000000 * j) / ((long) this.f6934j);
    }

    private long m8796c(long j) {
        return (((long) this.f6934j) * j) / 1000000;
    }

    private long m8801q() {
        return this.f6937m ? this.f6949y : m8792a(this.f6948x);
    }

    private void m8802r() {
        this.f6943s = 0;
        this.f6942r = 0;
        this.f6941q = 0;
        this.f6944t = 0;
        this.f6945u = false;
        this.f6946v = 0;
    }

    private boolean m8803s() {
        return Util.f7736a < 23 && (this.f6936l == 5 || this.f6936l == 6);
    }

    private boolean m8804t() {
        return m8803s() && this.f6933i.getPlayState() == 2 && this.f6933i.getPlaybackHeadPosition() == 0;
    }

    public static int m8794b(String str) {
        int i = -1;
        switch (str.hashCode()) {
            case -1095064472:
                if (str.equals("audio/vnd.dts")) {
                    i = 2;
                    break;
                }
                break;
            case 187078296:
                if (str.equals("audio/ac3")) {
                    i = 0;
                    break;
                }
                break;
            case 1504578661:
                if (str.equals("audio/eac3")) {
                    i = 1;
                    break;
                }
                break;
            case 1505942594:
                if (str.equals("audio/vnd.dts.hd")) {
                    i = 3;
                    break;
                }
                break;
        }
        switch (i) {
            case 0:
                return 5;
            case 1:
                return 6;
            case 2:
                return 7;
            case 3:
                return 8;
            default:
                return 0;
        }
    }

    private static int m8790a(int i, ByteBuffer byteBuffer) {
        int position;
        if (i == 7 || i == 8) {
            position = byteBuffer.position();
            return ((((byteBuffer.get(position + 5) & 252) >> 2) | ((byteBuffer.get(position + 4) & 1) << 6)) + 1) * 32;
        } else if (i == 5) {
            return 1536;
        } else {
            if (i == 6) {
                if (((byteBuffer.get(byteBuffer.position() + 4) & 192) >> 6) == 3) {
                    position = 6;
                } else {
                    position = Ac3Util.f7681a[(byteBuffer.get(byteBuffer.position() + 4) & 48) >> 4];
                }
                return position * 256;
            }
            throw new IllegalStateException("Unexpected audio encoding: " + i);
        }
    }
}
