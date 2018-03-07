package com.facebook.livephotos.exoplayer;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaCodec.CodecException;
import android.media.MediaCodec.CryptoException;
import android.media.MediaCodec.CryptoInfo;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Handler;
import android.os.SystemClock;
import com.facebook.livephotos.exoplayer.drm.DrmInitData;
import com.facebook.livephotos.exoplayer.drm.DrmSessionManager;
import com.facebook.livephotos.exoplayer.util.Assertions;
import com.facebook.livephotos.exoplayer.util.NalUnitUtil;
import com.facebook.livephotos.exoplayer.util.TraceUtil;
import com.facebook.livephotos.exoplayer.util.Util;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

@TargetApi(16)
/* compiled from: par */
public abstract class MediaCodecTrackRenderer extends SampleSourceTrackRenderer {
    public boolean f6755A;
    public int f6756B;
    public int f6757C;
    public boolean f6758D;
    public boolean f6759E;
    public int f6760F;
    private boolean f6761G;
    private boolean f6762H;
    public boolean f6763I;
    public boolean f6764J;
    public final CodecCounters f6765a;
    public final Handler f6766b;
    private final MediaCodecSelector f6767c;
    private final DrmSessionManager f6768d;
    private final boolean f6769e;
    private final SampleHolder f6770f;
    public final MediaFormatHolder f6771g;
    public final List<Long> f6772h;
    private final BufferInfo f6773i;
    public final EventListener f6774j;
    private final boolean f6775k;
    public MediaFormat f6776l;
    private DrmInitData f6777m;
    public MediaCodec f6778n;
    private boolean f6779o;
    private boolean f6780p;
    public boolean f6781q;
    private boolean f6782r;
    public boolean f6783s;
    private boolean f6784t;
    private ByteBuffer[] f6785u;
    private ByteBuffer[] f6786v;
    public long f6787w;
    public int f6788x;
    public int f6789y;
    private boolean f6790z;

    /* compiled from: par */
    public interface EventListener {
    }

    /* compiled from: par */
    public class DecoderInitializationException extends Exception {
        public final String decoderName;
        public final String diagnosticInfo;
        public final String mimeType;
        public final boolean secureDecoderRequired;

        public DecoderInitializationException(MediaFormat mediaFormat, Throwable th, boolean z, int i) {
            super("Decoder init failed: [" + i + "], " + mediaFormat, th);
            this.mimeType = mediaFormat.f6847b;
            this.secureDecoderRequired = z;
            this.decoderName = null;
            this.diagnosticInfo = "com.facebook.livephotos.exoplayer.MediaCodecTrackRenderer_" + (i < 0 ? "neg_" : "") + Math.abs(i);
        }

        public DecoderInitializationException(MediaFormat mediaFormat, Throwable th, boolean z, String str) {
            super("Decoder init failed: " + str + ", " + mediaFormat, th);
            this.mimeType = mediaFormat.f6847b;
            this.secureDecoderRequired = z;
            this.decoderName = str;
            this.diagnosticInfo = Util.f7736a >= 21 ? m8699a(th) : null;
        }

        @TargetApi(21)
        private static String m8699a(Throwable th) {
            if (th instanceof CodecException) {
                return ((CodecException) th).getDiagnosticInfo();
            }
            return null;
        }
    }

    protected abstract void mo385a(MediaCodec mediaCodec, boolean z, MediaFormat mediaFormat, MediaCrypto mediaCrypto);

    protected abstract boolean mo387a(long j, long j2, MediaCodec mediaCodec, ByteBuffer byteBuffer, BufferInfo bufferInfo, int i, boolean z);

    protected abstract boolean mo388a(MediaCodecSelector mediaCodecSelector, MediaFormat mediaFormat);

    public MediaCodecTrackRenderer(SampleSource sampleSource, MediaCodecSelector mediaCodecSelector, DrmSessionManager drmSessionManager, boolean z, Handler handler, EventListener eventListener) {
        this(new SampleSource[]{sampleSource}, mediaCodecSelector, drmSessionManager, z, handler, eventListener);
    }

    public MediaCodecTrackRenderer(SampleSource[] sampleSourceArr, MediaCodecSelector mediaCodecSelector, DrmSessionManager drmSessionManager, boolean z, Handler handler, EventListener eventListener) {
        boolean z2;
        super(sampleSourceArr);
        Assertions.m9297b(Util.f7736a >= 16);
        this.f6767c = (MediaCodecSelector) Assertions.m9293a((Object) mediaCodecSelector);
        this.f6768d = drmSessionManager;
        this.f6769e = z;
        this.f6766b = handler;
        this.f6774j = eventListener;
        if (Util.f7736a <= 22 && "foster".equals(Util.f7737b) && "NVIDIA".equals(Util.f7738c)) {
            z2 = true;
        } else {
            z2 = false;
        }
        this.f6775k = z2;
        this.f6765a = new CodecCounters();
        this.f6770f = new SampleHolder(0);
        this.f6771g = new MediaFormatHolder();
        this.f6772h = new ArrayList();
        this.f6773i = new BufferInfo();
        this.f6756B = 0;
        this.f6757C = 0;
    }

    private MediaFormat m8649b(MediaFormat mediaFormat) {
        if (mediaFormat.f6866u == null) {
            MediaFormat mediaFormat2 = new MediaFormat();
            mediaFormat2.setString("mime", mediaFormat.f6847b);
            String str = "language";
            String str2 = mediaFormat.f6863r;
            if (str2 != null) {
                mediaFormat2.setString(str, str2);
            }
            MediaFormat.m8745a(mediaFormat2, "max-input-size", mediaFormat.f6849d);
            MediaFormat.m8745a(mediaFormat2, "width", mediaFormat.f6853h);
            MediaFormat.m8745a(mediaFormat2, "height", mediaFormat.f6854i);
            MediaFormat.m8745a(mediaFormat2, "rotation-degrees", mediaFormat.f6857l);
            MediaFormat.m8745a(mediaFormat2, "max-width", mediaFormat.f6855j);
            MediaFormat.m8745a(mediaFormat2, "max-height", mediaFormat.f6856k);
            MediaFormat.m8745a(mediaFormat2, "channel-count", mediaFormat.f6859n);
            MediaFormat.m8745a(mediaFormat2, "sample-rate", mediaFormat.f6860o);
            MediaFormat.m8745a(mediaFormat2, "encoder-delay", mediaFormat.f6861p);
            MediaFormat.m8745a(mediaFormat2, "encoder-padding", mediaFormat.f6862q);
            for (int i = 0; i < mediaFormat.f6851f.size(); i++) {
                mediaFormat2.setByteBuffer("csd-" + i, ByteBuffer.wrap((byte[]) mediaFormat.f6851f.get(i)));
            }
            if (mediaFormat.f6850e != -1) {
                mediaFormat2.setLong("durationUs", mediaFormat.f6850e);
            }
            mediaFormat.f6866u = mediaFormat2;
        }
        MediaFormat mediaFormat3 = mediaFormat.f6866u;
        if (this.f6775k) {
            mediaFormat3.setInteger("auto-frc", 0);
        }
        return mediaFormat3;
    }

    protected final boolean mo377a(MediaFormat mediaFormat) {
        return mo388a(this.f6767c, mediaFormat);
    }

    protected DecoderInfo mo383a(MediaCodecSelector mediaCodecSelector, String str, boolean z) {
        return mediaCodecSelector.mo391a(str, z);
    }

    public final void m8673i() {
        if (mo399j()) {
            boolean z;
            MediaCrypto mediaCrypto;
            DecoderInfo a;
            String str = this.f6776l.f6847b;
            if (this.f6777m == null) {
                z = false;
                mediaCrypto = null;
            } else if (this.f6768d == null) {
                throw new ExoPlaybackException("Media requires a DrmSessionManager");
            } else {
                if (!this.f6790z) {
                    this.f6790z = true;
                }
                int a2 = this.f6768d.m8821a();
                if (a2 == 0) {
                    throw new ExoPlaybackException(this.f6768d.m8824d());
                } else if (a2 == 3 || a2 == 4) {
                    MediaCrypto b = this.f6768d.m8822b();
                    z = this.f6768d.m8823c();
                    mediaCrypto = b;
                } else {
                    return;
                }
            }
            try {
                a = mo383a(this.f6767c, str, z);
            } catch (Throwable e) {
                m8643a(new DecoderInitializationException(this.f6776l, e, z, -49998));
                a = null;
            }
            if (a == null) {
                m8643a(new DecoderInitializationException(this.f6776l, null, z, -49999));
            }
            String str2 = a.f6706a;
            this.f6779o = a.f6707b;
            this.f6780p = m8647a(str2, this.f6776l);
            this.f6781q = m8646a(str2);
            this.f6782r = m8651b(str2);
            this.f6783s = m8653c(str2);
            this.f6784t = m8652b(str2, this.f6776l);
            try {
                long elapsedRealtime = SystemClock.elapsedRealtime();
                TraceUtil.m9359a("createByCodecName(" + str2 + ")");
                this.f6778n = MediaCodec.createByCodecName(str2);
                TraceUtil.m9358a();
                TraceUtil.m9359a("configureCodec");
                mo385a(this.f6778n, a.f6707b, m8649b(this.f6776l), mediaCrypto);
                TraceUtil.m9358a();
                TraceUtil.m9359a("codec.start()");
                this.f6778n.start();
                TraceUtil.m9358a();
                long elapsedRealtime2 = SystemClock.elapsedRealtime();
                m8644a(str2, elapsedRealtime2, elapsedRealtime2 - elapsedRealtime);
                this.f6785u = this.f6778n.getInputBuffers();
                this.f6786v = this.f6778n.getOutputBuffers();
            } catch (Throwable e2) {
                m8643a(new DecoderInitializationException(this.f6776l, e2, z, str2));
            }
            this.f6787w = m8620s() == 3 ? SystemClock.elapsedRealtime() : -1;
            this.f6788x = -1;
            this.f6789y = -1;
            this.f6764J = true;
            CodecCounters codecCounters = this.f6765a;
            codecCounters.f6690a++;
        }
    }

    protected boolean mo399j() {
        return this.f6778n == null && this.f6776l != null;
    }

    protected void mo369g() {
        this.f6776l = null;
        this.f6777m = null;
        try {
            m8675l();
            try {
                if (this.f6790z) {
                    this.f6790z = false;
                }
                super.mo369g();
            } catch (Throwable th) {
                super.mo369g();
            }
        } catch (Throwable th2) {
            super.mo369g();
        }
    }

    public final void m8675l() {
        if (this.f6778n != null) {
            this.f6787w = -1;
            this.f6788x = -1;
            this.f6789y = -1;
            this.f6763I = false;
            this.f6772h.clear();
            this.f6785u = null;
            this.f6786v = null;
            this.f6755A = false;
            this.f6758D = false;
            this.f6779o = false;
            this.f6780p = false;
            this.f6781q = false;
            this.f6782r = false;
            this.f6783s = false;
            this.f6784t = false;
            this.f6759E = false;
            this.f6756B = 0;
            this.f6757C = 0;
            CodecCounters codecCounters = this.f6765a;
            codecCounters.f6691b++;
            try {
                this.f6778n.stop();
                try {
                    this.f6778n.release();
                } finally {
                    this.f6778n = null;
                }
            } catch (Throwable th) {
                this.f6778n.release();
            } finally {
                this.f6778n = null;
            }
        }
    }

    protected void mo375a(long j) {
        this.f6760F = 0;
        this.f6761G = false;
        this.f6762H = false;
        if (this.f6778n != null) {
            this.f6787w = -1;
            this.f6788x = -1;
            this.f6789y = -1;
            this.f6764J = true;
            this.f6763I = false;
            this.f6772h.clear();
            if (this.f6781q || (this.f6783s && this.f6759E)) {
                m8675l();
                m8673i();
            } else if (this.f6757C != 0) {
                m8675l();
                m8673i();
            } else {
                this.f6778n.flush();
                this.f6758D = false;
            }
            if (this.f6755A && this.f6776l != null) {
                this.f6756B = 1;
            }
        }
    }

    protected void mo378c() {
    }

    protected void mo379d() {
    }

    protected void mo376a(long j, long j2, boolean z) {
        int i = z ? this.f6760F == 0 ? 1 : this.f6760F : 0;
        this.f6760F = i;
        if (this.f6776l == null && m8625a(j, this.f6771g, null) == -4) {
            mo397a(this.f6771g);
        }
        m8673i();
        if (this.f6778n != null) {
            TraceUtil.m9359a("drainAndFeed");
            do {
            } while (m8650b(j, j2));
            if (m8645a(j, true)) {
                do {
                } while (m8645a(j, false));
            }
            TraceUtil.m9358a();
        }
        synchronized (this.f6765a) {
        }
    }

    private boolean m8645a(long j, boolean z) {
        if (this.f6761G || this.f6757C == 2) {
            return false;
        }
        if (this.f6788x < 0) {
            this.f6788x = this.f6778n.dequeueInputBuffer(0);
            if (this.f6788x < 0) {
                return false;
            }
            this.f6770f.f6870b = this.f6785u[this.f6788x];
            this.f6770f.m8753d();
        }
        if (this.f6757C == 1) {
            if (!this.f6782r) {
                this.f6759E = true;
                this.f6778n.queueInputBuffer(this.f6788x, 0, 0, 0, 4);
                this.f6788x = -1;
            }
            this.f6757C = 2;
            return false;
        }
        int i;
        int i2;
        if (this.f6763I) {
            i = -3;
        } else {
            if (this.f6756B == 1) {
                for (i2 = 0; i2 < this.f6776l.f6851f.size(); i2++) {
                    this.f6770f.f6870b.put((byte[]) this.f6776l.f6851f.get(i2));
                }
                this.f6756B = 2;
            }
            i = m8625a(j, this.f6771g, this.f6770f);
            if (z && this.f6760F == 1 && i == -2) {
                this.f6760F = 2;
            }
        }
        if (i == -2) {
            return false;
        }
        if (i == -4) {
            if (this.f6756B == 2) {
                this.f6770f.m8753d();
                this.f6756B = 1;
            }
            mo397a(this.f6771g);
            return true;
        } else if (i == -1) {
            if (this.f6756B == 2) {
                this.f6770f.m8753d();
                this.f6756B = 1;
            }
            this.f6761G = true;
            if (this.f6758D) {
                try {
                    if (this.f6782r) {
                        return false;
                    }
                    this.f6759E = true;
                    this.f6778n.queueInputBuffer(this.f6788x, 0, 0, 0, 4);
                    this.f6788x = -1;
                    return false;
                } catch (Throwable e) {
                    m8642a((CryptoException) e);
                    throw new ExoPlaybackException(e);
                }
            }
            m8640A();
            return false;
        } else {
            if (this.f6764J) {
                if (this.f6770f.m8752c()) {
                    this.f6764J = false;
                } else {
                    this.f6770f.m8753d();
                    if (this.f6756B == 2) {
                        this.f6756B = 1;
                    }
                    return true;
                }
            }
            boolean a = this.f6770f.m8750a();
            this.f6763I = m8648a(a);
            if (this.f6763I) {
                return false;
            }
            if (this.f6780p && !a) {
                NalUnitUtil.m9315a(this.f6770f.f6870b);
                if (this.f6770f.f6870b.position() == 0) {
                    return true;
                }
                this.f6780p = false;
            }
            try {
                int position = this.f6770f.f6870b.position();
                i2 = position - this.f6770f.f6871c;
                long j2 = this.f6770f.f6873e;
                if (this.f6770f.m8751b()) {
                    this.f6772h.add(Long.valueOf(j2));
                }
                if (a) {
                    this.f6778n.queueSecureInputBuffer(this.f6788x, 0, m8641a(this.f6770f, i2), j2, 0);
                } else {
                    this.f6778n.queueInputBuffer(this.f6788x, 0, position, j2, 0);
                }
                this.f6788x = -1;
                this.f6758D = true;
                this.f6756B = 0;
                CodecCounters codecCounters = this.f6765a;
                codecCounters.f6692c++;
                return true;
            } catch (Throwable e2) {
                m8642a((CryptoException) e2);
                throw new ExoPlaybackException(e2);
            }
        }
    }

    private static CryptoInfo m8641a(SampleHolder sampleHolder, int i) {
        CryptoInfo cryptoInfo = sampleHolder.f6869a.f6705g;
        if (i != 0) {
            if (cryptoInfo.numBytesOfClearData == null) {
                cryptoInfo.numBytesOfClearData = new int[1];
            }
            int[] iArr = cryptoInfo.numBytesOfClearData;
            iArr[0] = iArr[0] + i;
        }
        return cryptoInfo;
    }

    private boolean m8648a(boolean z) {
        if (!this.f6790z) {
            return false;
        }
        int a = this.f6768d.m8821a();
        if (a == 0) {
            throw new ExoPlaybackException(this.f6768d.m8824d());
        } else if (a == 4) {
            return false;
        } else {
            if (z || !this.f6769e) {
                return true;
            }
            return false;
        }
    }

    public void mo397a(MediaFormatHolder mediaFormatHolder) {
        MediaFormat mediaFormat = this.f6776l;
        this.f6776l = mediaFormatHolder.f6867a;
        this.f6777m = mediaFormatHolder.f6868b;
        if (this.f6778n != null && mo398a(this.f6779o, mediaFormat, this.f6776l)) {
            this.f6755A = true;
            this.f6756B = 1;
        } else if (this.f6758D) {
            this.f6757C = 1;
        } else {
            m8675l();
            m8673i();
        }
    }

    protected void mo386a(MediaFormat mediaFormat) {
    }

    protected void mo390h() {
    }

    protected boolean mo398a(boolean z, MediaFormat mediaFormat, MediaFormat mediaFormat2) {
        return false;
    }

    protected boolean mo380e() {
        return this.f6762H;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected boolean mo381f() {
        /*
        r7 = this;
        r0 = r7.f6776l;
        if (r0 == 0) goto L_0x0023;
    L_0x0004:
        r0 = r7.f6763I;
        if (r0 != 0) goto L_0x0023;
    L_0x0008:
        r0 = r7.f6760F;
        if (r0 != 0) goto L_0x0021;
    L_0x000c:
        r0 = r7.f6789y;
        if (r0 >= 0) goto L_0x0021;
    L_0x0010:
        r1 = android.os.SystemClock.elapsedRealtime();
        r3 = r7.f6787w;
        r5 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
        r3 = r3 + r5;
        r1 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1));
        if (r1 >= 0) goto L_0x0025;
    L_0x001d:
        r1 = 1;
    L_0x001e:
        r0 = r1;
        if (r0 == 0) goto L_0x0023;
    L_0x0021:
        r0 = 1;
    L_0x0022:
        return r0;
    L_0x0023:
        r0 = 0;
        goto L_0x0022;
    L_0x0025:
        r1 = 0;
        goto L_0x001e;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.livephotos.exoplayer.MediaCodecTrackRenderer.f():boolean");
    }

    private static long m8655y() {
        return 0;
    }

    private boolean m8650b(long j, long j2) {
        if (this.f6762H) {
            return false;
        }
        if (this.f6789y < 0) {
            this.f6789y = this.f6778n.dequeueOutputBuffer(this.f6773i, m8655y());
        }
        if (this.f6789y == -2) {
            m8656z();
            return true;
        } else if (this.f6789y == -3) {
            this.f6786v = this.f6778n.getOutputBuffers();
            CodecCounters codecCounters = this.f6765a;
            codecCounters.f6694e++;
            return true;
        } else if (this.f6789y < 0) {
            if (!this.f6782r || (!this.f6761G && this.f6757C != 2)) {
                return false;
            }
            m8640A();
            return true;
        } else if ((this.f6773i.flags & 4) != 0) {
            m8640A();
            return false;
        } else {
            int f = m8654f(this.f6773i.presentationTimeUs);
            if (!mo387a(j, j2, this.f6778n, this.f6786v[this.f6789y], this.f6773i, this.f6789y, f != -1)) {
                return false;
            }
            long j3 = this.f6773i.presentationTimeUs;
            if (f != -1) {
                this.f6772h.remove(f);
            }
            this.f6789y = -1;
            return true;
        }
    }

    private void m8656z() {
        MediaFormat outputFormat = this.f6778n.getOutputFormat();
        if (this.f6784t) {
            outputFormat.setInteger("channel-count", 1);
        }
        mo386a(outputFormat);
        CodecCounters codecCounters = this.f6765a;
        codecCounters.f6693d++;
    }

    private void m8640A() {
        if (this.f6757C == 2) {
            m8675l();
            m8673i();
            return;
        }
        this.f6762H = true;
        mo390h();
    }

    private void m8643a(final DecoderInitializationException decoderInitializationException) {
        if (!(this.f6766b == null || this.f6774j == null)) {
            HandlerDetour.a(this.f6766b, new Runnable(this) {
                final /* synthetic */ MediaCodecTrackRenderer f6802b;

                public void run() {
                }
            }, -23496146);
        }
        throw new ExoPlaybackException((Throwable) decoderInitializationException);
    }

    private void m8642a(final CryptoException cryptoException) {
        if (this.f6766b != null && this.f6774j != null) {
            HandlerDetour.a(this.f6766b, new Runnable(this) {
                final /* synthetic */ MediaCodecTrackRenderer f6804b;

                public void run() {
                }
            }, 5418096);
        }
    }

    private void m8644a(String str, long j, long j2) {
        if (this.f6766b != null && this.f6774j != null) {
            final String str2 = str;
            final long j3 = j;
            final long j4 = j2;
            HandlerDetour.a(this.f6766b, new Runnable(this) {
                final /* synthetic */ MediaCodecTrackRenderer f6808d;

                public void run() {
                }
            }, -42695549);
        }
    }

    private int m8654f(long j) {
        int size = this.f6772h.size();
        for (int i = 0; i < size; i++) {
            if (((Long) this.f6772h.get(i)).longValue() == j) {
                return i;
            }
        }
        return -1;
    }

    private static boolean m8646a(String str) {
        return Util.f7736a < 18 || ((Util.f7736a == 18 && ("OMX.SEC.avc.dec".equals(str) || "OMX.SEC.avc.dec.secure".equals(str))) || (Util.f7736a == 19 && Util.f7739d.startsWith("SM-G800") && ("OMX.Exynos.avc.dec".equals(str) || "OMX.Exynos.avc.dec.secure".equals(str))));
    }

    private static boolean m8647a(String str, MediaFormat mediaFormat) {
        return Util.f7736a < 21 && mediaFormat.f6851f.isEmpty() && "OMX.MTK.VIDEO.DECODER.AVC".equals(str);
    }

    private static boolean m8651b(String str) {
        return Util.f7736a <= 17 && "OMX.rk.video_decoder.avc".equals(str);
    }

    private static boolean m8653c(String str) {
        return Util.f7736a <= 23 && "OMX.google.vorbis.decoder".equals(str);
    }

    private static boolean m8652b(String str, MediaFormat mediaFormat) {
        if (Util.f7736a <= 18 && mediaFormat.f6859n == 1 && "OMX.MTK.AUDIO.DECODER.MP3".equals(str)) {
            return true;
        }
        return false;
    }
}
