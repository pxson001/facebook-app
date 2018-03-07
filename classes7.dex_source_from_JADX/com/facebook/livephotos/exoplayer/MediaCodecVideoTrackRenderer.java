package com.facebook.livephotos.exoplayer;

import android.annotation.TargetApi;
import android.content.Context;
import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaFormat;
import android.os.Handler;
import android.os.SystemClock;
import android.view.Surface;
import com.facebook.livephotos.exoplayer.MediaCodecTrackRenderer.EventListener;
import com.facebook.livephotos.exoplayer.drm.DrmSessionManager;
import com.facebook.livephotos.exoplayer.util.MimeTypes;
import com.facebook.livephotos.exoplayer.util.TraceUtil;
import com.facebook.livephotos.exoplayer.util.Util;
import com.facebook.livephotos.player.VideoCompositionRenderer;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import java.nio.ByteBuffer;

@TargetApi(16)
/* compiled from: pagination_size */
public class MediaCodecVideoTrackRenderer extends MediaCodecTrackRenderer {
    private final VideoFrameReleaseTimeHelper f6824c;
    public final VideoCompositionRenderer f6825d;
    private final long f6826e;
    private final int f6827f;
    private final int f6828g;
    public Surface f6829h;
    public boolean f6830i;
    private boolean f6831j;
    private long f6832k;
    private long f6833l;
    private int f6834m;
    private int f6835n;
    private int f6836o;
    private float f6837p;
    private int f6838q;
    private int f6839r;
    private int f6840s;
    private float f6841t;
    private int f6842u;
    private int f6843v;
    private int f6844w;
    private float f6845x;

    public MediaCodecVideoTrackRenderer(Context context, SampleSource sampleSource, MediaCodecSelector mediaCodecSelector, int i, long j, Handler handler, VideoCompositionRenderer videoCompositionRenderer, int i2) {
        this(context, sampleSource, mediaCodecSelector, i, j, null, false, handler, videoCompositionRenderer, i2);
    }

    private MediaCodecVideoTrackRenderer(Context context, SampleSource sampleSource, MediaCodecSelector mediaCodecSelector, int i, long j, DrmSessionManager drmSessionManager, boolean z, Handler handler, VideoCompositionRenderer videoCompositionRenderer, int i2) {
        super(sampleSource, mediaCodecSelector, drmSessionManager, z, handler, (EventListener) videoCompositionRenderer);
        this.f6824c = new VideoFrameReleaseTimeHelper(context);
        this.f6827f = i;
        this.f6826e = 1000 * j;
        this.f6825d = videoCompositionRenderer;
        this.f6828g = i2;
        this.f6832k = -1;
        this.f6838q = -1;
        this.f6839r = -1;
        this.f6841t = -1.0f;
        this.f6837p = -1.0f;
        this.f6842u = -1;
        this.f6843v = -1;
        this.f6845x = -1.0f;
    }

    protected final boolean mo388a(MediaCodecSelector mediaCodecSelector, MediaFormat mediaFormat) {
        String str = mediaFormat.f6847b;
        if (!MimeTypes.m9305b(str)) {
            return false;
        }
        if ("video/x-unknown".equals(str) || mediaCodecSelector.mo391a(str, false) != null) {
            return true;
        }
        return false;
    }

    protected final void mo365a(int i, long j, boolean z) {
        super.mo365a(i, j, z);
        if (z && this.f6826e > 0) {
            this.f6832k = (SystemClock.elapsedRealtime() * 1000) + this.f6826e;
        }
        VideoFrameReleaseTimeHelper videoFrameReleaseTimeHelper = this.f6824c;
        videoFrameReleaseTimeHelper.f6891h = false;
        if (videoFrameReleaseTimeHelper.f6885b) {
            videoFrameReleaseTimeHelper.f6884a.f6880c.sendEmptyMessage(1);
        }
    }

    protected final void mo375a(long j) {
        super.mo375a(j);
        this.f6831j = false;
        this.f6835n = 0;
        this.f6832k = -1;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected final boolean mo381f() {
        /*
        r9 = this;
        r0 = 1;
        r1 = 0;
        r6 = -1;
        r2 = super.mo381f();
        if (r2 == 0) goto L_0x001f;
    L_0x000a:
        r2 = r9.f6831j;
        if (r2 != 0) goto L_0x001c;
    L_0x000e:
        r8 = r9.f6778n;
        if (r8 == 0) goto L_0x0038;
    L_0x0012:
        r8 = 1;
    L_0x0013:
        r2 = r8;
        if (r2 == 0) goto L_0x001c;
    L_0x0016:
        r8 = r9.f6760F;
        r2 = r8;
        r3 = 2;
        if (r2 != r3) goto L_0x001f;
    L_0x001c:
        r9.f6832k = r6;
    L_0x001e:
        return r0;
    L_0x001f:
        r2 = r9.f6832k;
        r2 = (r2 > r6 ? 1 : (r2 == r6 ? 0 : -1));
        if (r2 != 0) goto L_0x0027;
    L_0x0025:
        r0 = r1;
        goto L_0x001e;
    L_0x0027:
        r2 = android.os.SystemClock.elapsedRealtime();
        r4 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
        r2 = r2 * r4;
        r4 = r9.f6832k;
        r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1));
        if (r2 < 0) goto L_0x001e;
    L_0x0034:
        r9.f6832k = r6;
        r0 = r1;
        goto L_0x001e;
    L_0x0038:
        r8 = 0;
        goto L_0x0013;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.livephotos.exoplayer.MediaCodecVideoTrackRenderer.f():boolean");
    }

    protected final void mo378c() {
        super.mo378c();
        this.f6834m = 0;
        this.f6833l = SystemClock.elapsedRealtime();
    }

    protected final void mo379d() {
        this.f6832k = -1;
        m8723y();
        super.mo379d();
    }

    protected final void mo369g() {
        this.f6838q = -1;
        this.f6839r = -1;
        this.f6841t = -1.0f;
        this.f6837p = -1.0f;
        this.f6842u = -1;
        this.f6843v = -1;
        this.f6845x = -1.0f;
        VideoFrameReleaseTimeHelper videoFrameReleaseTimeHelper = this.f6824c;
        if (videoFrameReleaseTimeHelper.f6885b) {
            videoFrameReleaseTimeHelper.f6884a.f6880c.sendEmptyMessage(2);
        }
        super.mo369g();
    }

    public final void mo384a(int i, Object obj) {
        if (i == 1) {
            Surface surface = (Surface) obj;
            if (this.f6829h != surface) {
                this.f6829h = surface;
                this.f6830i = false;
                int i2 = this.f6748a;
                if (i2 == 2 || i2 == 3) {
                    m8675l();
                    m8673i();
                    return;
                }
                return;
            }
            return;
        }
        super.mo384a(i, obj);
    }

    protected final boolean mo399j() {
        return super.mo399j() && this.f6829h != null && this.f6829h.isValid();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected final void mo385a(android.media.MediaCodec r10, boolean r11, android.media.MediaFormat r12, android.media.MediaCrypto r13) {
        /*
        r9 = this;
        r5 = 4;
        r4 = 2;
        r2 = "max-input-size";
        r2 = r12.containsKey(r2);
        if (r2 == 0) goto L_0x0016;
    L_0x000a:
        r0 = r9.f6829h;
        r1 = 0;
        r10.configure(r12, r0, r13, r1);
        r0 = r9.f6827f;
        r10.setVideoScalingMode(r0);
        return;
    L_0x0016:
        r2 = "height";
        r2 = r12.getInteger(r2);
        if (r11 == 0) goto L_0x0030;
    L_0x001e:
        r3 = "max-height";
        r3 = r12.containsKey(r3);
        if (r3 == 0) goto L_0x0030;
    L_0x0026:
        r3 = "max-height";
        r3 = r12.getInteger(r3);
        r2 = java.lang.Math.max(r2, r3);
    L_0x0030:
        r3 = "width";
        r3 = r12.getInteger(r3);
        if (r11 == 0) goto L_0x004a;
    L_0x0038:
        r6 = "max-width";
        r6 = r12.containsKey(r6);
        if (r6 == 0) goto L_0x004a;
    L_0x0040:
        r3 = "max-width";
        r3 = r12.getInteger(r3);
        r3 = java.lang.Math.max(r2, r3);
    L_0x004a:
        r6 = "mime";
        r7 = r12.getString(r6);
        r6 = -1;
        r8 = r7.hashCode();
        switch(r8) {
            case -1664118616: goto L_0x006b;
            case -1662541442: goto L_0x0093;
            case 1187890754: goto L_0x0075;
            case 1331836730: goto L_0x007f;
            case 1599127256: goto L_0x0089;
            case 1599127257: goto L_0x009d;
            default: goto L_0x0058;
        };
    L_0x0058:
        switch(r6) {
            case 0: goto L_0x005c;
            case 1: goto L_0x005c;
            case 2: goto L_0x00a7;
            case 3: goto L_0x00c1;
            case 4: goto L_0x00c5;
            case 5: goto L_0x00c5;
            default: goto L_0x005b;
        };
    L_0x005b:
        goto L_0x000a;
    L_0x005c:
        r2 = r2 * r3;
        r3 = r2;
        r2 = r4;
    L_0x005f:
        r3 = r3 * 3;
        r2 = r2 * 2;
        r2 = r3 / r2;
        r3 = "max-input-size";
        r12.setInteger(r3, r2);
        goto L_0x000a;
    L_0x006b:
        r8 = "video/3gpp";
        r7 = r7.equals(r8);
        if (r7 == 0) goto L_0x0058;
    L_0x0073:
        r6 = 0;
        goto L_0x0058;
    L_0x0075:
        r8 = "video/mp4v-es";
        r7 = r7.equals(r8);
        if (r7 == 0) goto L_0x0058;
    L_0x007d:
        r6 = 1;
        goto L_0x0058;
    L_0x007f:
        r8 = "video/avc";
        r7 = r7.equals(r8);
        if (r7 == 0) goto L_0x0058;
    L_0x0087:
        r6 = r4;
        goto L_0x0058;
    L_0x0089:
        r8 = "video/x-vnd.on2.vp8";
        r7 = r7.equals(r8);
        if (r7 == 0) goto L_0x0058;
    L_0x0091:
        r6 = 3;
        goto L_0x0058;
    L_0x0093:
        r8 = "video/hevc";
        r7 = r7.equals(r8);
        if (r7 == 0) goto L_0x0058;
    L_0x009b:
        r6 = r5;
        goto L_0x0058;
    L_0x009d:
        r8 = "video/x-vnd.on2.vp9";
        r7 = r7.equals(r8);
        if (r7 == 0) goto L_0x0058;
    L_0x00a5:
        r6 = 5;
        goto L_0x0058;
    L_0x00a7:
        r5 = "BRAVIA 4K 2015";
        r6 = com.facebook.livephotos.exoplayer.util.Util.f7739d;
        r5 = r5.equals(r6);
        if (r5 != 0) goto L_0x000a;
    L_0x00b1:
        r3 = r3 + 15;
        r3 = r3 / 16;
        r2 = r2 + 15;
        r2 = r2 / 16;
        r2 = r2 * r3;
        r2 = r2 * 16;
        r2 = r2 * 16;
        r3 = r2;
        r2 = r4;
        goto L_0x005f;
    L_0x00c1:
        r2 = r2 * r3;
        r3 = r2;
        r2 = r4;
        goto L_0x005f;
    L_0x00c5:
        r2 = r2 * r3;
        r3 = r2;
        r2 = r5;
        goto L_0x005f;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.livephotos.exoplayer.MediaCodecVideoTrackRenderer.a(android.media.MediaCodec, boolean, android.media.MediaFormat, android.media.MediaCrypto):void");
    }

    protected final void mo397a(MediaFormatHolder mediaFormatHolder) {
        super.mo397a(mediaFormatHolder);
        this.f6837p = mediaFormatHolder.f6867a.f6858m == -1.0f ? 1.0f : mediaFormatHolder.f6867a.f6858m;
        this.f6836o = mediaFormatHolder.f6867a.f6857l == -1 ? 0 : mediaFormatHolder.f6867a.f6857l;
    }

    protected final void mo386a(MediaFormat mediaFormat) {
        int integer;
        Object obj = (mediaFormat.containsKey("crop-right") && mediaFormat.containsKey("crop-left") && mediaFormat.containsKey("crop-bottom") && mediaFormat.containsKey("crop-top")) ? 1 : null;
        if (obj != null) {
            integer = (mediaFormat.getInteger("crop-right") - mediaFormat.getInteger("crop-left")) + 1;
        } else {
            integer = mediaFormat.getInteger("width");
        }
        this.f6838q = integer;
        if (obj != null) {
            integer = (mediaFormat.getInteger("crop-bottom") - mediaFormat.getInteger("crop-top")) + 1;
        } else {
            integer = mediaFormat.getInteger("height");
        }
        this.f6839r = integer;
        this.f6841t = this.f6837p;
        if (Util.f7736a < 21) {
            this.f6840s = this.f6836o;
        } else if (this.f6836o == 90 || this.f6836o == 270) {
            integer = this.f6838q;
            this.f6838q = this.f6839r;
            this.f6839r = integer;
            this.f6841t = 1.0f / this.f6841t;
        }
    }

    protected final boolean mo398a(boolean z, MediaFormat mediaFormat, MediaFormat mediaFormat2) {
        return mediaFormat2.f6847b.equals(mediaFormat.f6847b) && (z || (mediaFormat.f6853h == mediaFormat2.f6853h && mediaFormat.f6854i == mediaFormat2.f6854i));
    }

    protected final boolean mo387a(long j, long j2, MediaCodec mediaCodec, ByteBuffer byteBuffer, BufferInfo bufferInfo, int i, boolean z) {
        if (z) {
            m8718a(mediaCodec, i);
            this.f6835n = 0;
            return true;
        } else if (!this.f6831j) {
            if (Util.f7736a >= 21) {
                m8719a(mediaCodec, i, System.nanoTime());
            } else {
                m8721c(mediaCodec, i);
            }
            this.f6835n = 0;
            return true;
        } else if (m8620s() != 3) {
            return false;
        } else {
            long elapsedRealtime = (bufferInfo.presentationTimeUs - j) - ((SystemClock.elapsedRealtime() * 1000) - j2);
            long nanoTime = System.nanoTime();
            elapsedRealtime = this.f6824c.m8773a(bufferInfo.presentationTimeUs, (elapsedRealtime * 1000) + nanoTime);
            nanoTime = (elapsedRealtime - nanoTime) / 1000;
            if (nanoTime < -30000) {
                m8720b(mediaCodec, i);
                return true;
            }
            if (Util.f7736a >= 21) {
                if (nanoTime < 50000) {
                    m8719a(mediaCodec, i, elapsedRealtime);
                    this.f6835n = 0;
                    return true;
                }
            } else if (nanoTime < 30000) {
                if (nanoTime > 11000) {
                    try {
                        Thread.sleep((nanoTime - 10000) / 1000);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
                m8721c(mediaCodec, i);
                this.f6835n = 0;
                return true;
            }
            return false;
        }
    }

    private void m8718a(MediaCodec mediaCodec, int i) {
        TraceUtil.m9359a("skipVideoBuffer");
        mediaCodec.releaseOutputBuffer(i, false);
        TraceUtil.m9358a();
        CodecCounters codecCounters = this.f6765a;
        codecCounters.f6696g++;
    }

    private void m8720b(MediaCodec mediaCodec, int i) {
        TraceUtil.m9359a("dropVideoBuffer");
        mediaCodec.releaseOutputBuffer(i, false);
        TraceUtil.m9358a();
        CodecCounters codecCounters = this.f6765a;
        codecCounters.f6697h++;
        this.f6834m++;
        this.f6835n++;
        this.f6765a.f6698i = Math.max(this.f6835n, this.f6765a.f6698i);
        if (this.f6834m == this.f6828g) {
            m8723y();
        }
    }

    private void m8721c(MediaCodec mediaCodec, int i) {
        m8717a();
        TraceUtil.m9359a("releaseOutputBuffer");
        mediaCodec.releaseOutputBuffer(i, true);
        TraceUtil.m9358a();
        CodecCounters codecCounters = this.f6765a;
        codecCounters.f6695f++;
        this.f6831j = true;
        mo446x();
    }

    @TargetApi(21)
    private void m8719a(MediaCodec mediaCodec, int i, long j) {
        m8717a();
        TraceUtil.m9359a("releaseOutputBuffer");
        mediaCodec.releaseOutputBuffer(i, j);
        TraceUtil.m9358a();
        CodecCounters codecCounters = this.f6765a;
        codecCounters.f6695f++;
        this.f6831j = true;
        mo446x();
    }

    private void m8717a() {
        if (this.f6766b != null && this.f6825d != null) {
            if (this.f6842u != this.f6838q || this.f6843v != this.f6839r || this.f6844w != this.f6840s || this.f6845x != this.f6841t) {
                final int i = this.f6838q;
                final int i2 = this.f6839r;
                final int i3 = this.f6840s;
                final float f = this.f6841t;
                HandlerDetour.a(this.f6766b, new Runnable(this) {
                    final /* synthetic */ MediaCodecVideoTrackRenderer f6818e;

                    public void run() {
                        this.f6818e.f6825d.f7779d = ((float) i2) / ((float) i);
                    }
                }, 996855673);
                this.f6842u = i;
                this.f6843v = i2;
                this.f6844w = i3;
                this.f6845x = f;
            }
        }
    }

    private void mo446x() {
        if (this.f6766b != null && this.f6825d != null && !this.f6830i) {
            final Surface surface = this.f6829h;
            HandlerDetour.a(this.f6766b, new Runnable(this) {
                final /* synthetic */ MediaCodecVideoTrackRenderer f6820b;

                public void run() {
                }
            }, -1654138270);
            this.f6830i = true;
        }
    }

    private void m8723y() {
        if (this.f6766b != null && this.f6825d != null && this.f6834m != 0) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            final int i = this.f6834m;
            final long j = elapsedRealtime - this.f6833l;
            HandlerDetour.a(this.f6766b, new Runnable(this) {
                final /* synthetic */ MediaCodecVideoTrackRenderer f6823c;

                public void run() {
                }
            }, 1281340131);
            this.f6834m = 0;
            this.f6833l = elapsedRealtime;
        }
    }
}
