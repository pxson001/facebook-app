package com.facebook.video.scrubber;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.RectF;
import android.graphics.SurfaceTexture;
import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.net.Uri;
import android.opengl.GLES20;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Looper;
import android.os.SystemClock;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.references.CloseableReference;
import com.facebook.common.time.Clock;
import com.facebook.debug.log.BLog;
import com.facebook.inject.Assisted;
import com.facebook.timeline.profilevideo.ProfileVideoEditFragment;
import com.facebook.tools.dextr.runtime.detour.ExecutorDetour;
import com.facebook.videocodec.base.VideoMetadata;
import com.facebook.videocodec.base.VideoMetadataExtractor;
import com.facebook.videocodec.effects.GLRenderer;
import com.facebook.videocodec.policy.VideoMirroringMode;
import com.google.common.base.Preconditions;
import java.io.File;
import java.io.IOException;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.concurrent.ExecutorService;
import javax.inject.Inject;
import javax.inject.Provider;

@TargetApi(17)
/* compiled from: display_style */
public class GLFrameRetriever {
    private static final String f15727a = GLFrameRetriever.class.getCanonicalName();
    private static final long f15728j;
    private Uri f15729b;
    private VideoMirroringMode f15730c;
    public ProfileVideoEditFragment f15731d;
    private int f15732e;
    private int f15733f = 0;
    private long f15734g = -1;
    private long f15735h = -1;
    private long f15736i = -1;
    public boolean f15737k = false;
    private boolean f15738l = false;
    private boolean f15739m = false;
    private ExecutorService f15740n;
    private List<GLRenderer> f15741o;
    private Clock f15742p;
    private AbstractFbErrorReporter f15743q;
    private MediaCodec f15744r = null;
    public CodecOutputSurface f15745s = null;
    public MediaExtractor f15746t = null;
    private CodecOutputSurfaceProvider f15747u;
    private VideoMetadataExtractor f15748v;
    private VideoMetadata f15749w;

    /* compiled from: display_style */
    class C12051 implements Runnable {
        final /* synthetic */ GLFrameRetriever f15726a;

        C12051(GLFrameRetriever gLFrameRetriever) {
            this.f15726a = gLFrameRetriever;
        }

        public void run() {
            ProfileVideoEditFragment profileVideoEditFragment = this.f15726a.f15731d;
            profileVideoEditFragment.al = true;
            ProfileVideoEditFragment.as(profileVideoEditFragment);
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    /* compiled from: display_style */
    public @interface DecodeReturn {
    }

    @Retention(RetentionPolicy.SOURCE)
    /* compiled from: display_style */
    public @interface ExtractReturn {
    }

    static {
        long j = (Build.MODEL.equalsIgnoreCase("SAMSUNG-SGH-I747") && VERSION.SDK_INT == 16) ? 50000 : 0;
        f15728j = j;
    }

    @Inject
    public GLFrameRetriever(@Assisted Uri uri, @Assisted FrameRetrieverDelegate frameRetrieverDelegate, @Assisted List<GLRenderer> list, @Assisted VideoMirroringMode videoMirroringMode, ExecutorService executorService, Clock clock, CodecOutputSurfaceProvider codecOutputSurfaceProvider, VideoMetadataExtractor videoMetadataExtractor, Provider<FbErrorReporter> provider) {
        this.f15741o = list;
        this.f15729b = uri;
        this.f15731d = frameRetrieverDelegate;
        this.f15730c = videoMirroringMode;
        this.f15742p = clock;
        this.f15740n = executorService;
        this.f15748v = videoMetadataExtractor;
        this.f15747u = codecOutputSurfaceProvider;
        this.f15743q = (AbstractFbErrorReporter) provider.get();
    }

    public final CloseableReference<Bitmap> m19670a(int i, float f) {
        return m19659a(i, m19658a(f));
    }

    private CloseableReference<Bitmap> m19659a(int i, RectF rectF) {
        long a = this.f15742p.a();
        this.f15739m = false;
        try {
            return m19660a((long) (i * 1000), rectF, a);
        } catch (Throwable e) {
            this.f15743q.a("profile_video_frame_retriever", "Unable to extract image. Something may be wrong with the video or decoder", e);
            return null;
        }
    }

    private RectF m19658a(float f) {
        float f2;
        float f3 = 0.0f;
        VideoMetadata b = m19666b();
        Object obj = b.d % 180 != 0 ? 1 : null;
        float f4 = (float) b.b;
        float f5 = (float) b.c;
        if (obj != null) {
            f2 = f4;
        } else {
            f2 = f5;
            f5 = f4;
        }
        f4 = f5 / f;
        float f6 = f2 * f;
        if (f4 < f2) {
            f2 = ((f2 - f4) / 2.0f) / f2;
        } else {
            f3 = ((f5 - f6) / 2.0f) / f5;
            f2 = 0.0f;
        }
        return new RectF(f3, f2, 1.0f - f3, 1.0f - f2);
    }

    private VideoMetadata m19666b() {
        if (this.f15749w == null) {
            this.f15749w = this.f15748v.a(this.f15729b);
        }
        return this.f15749w;
    }

    private CloseableReference<Bitmap> m19660a(long j, RectF rectF, long j2) {
        m19664a(rectF);
        this.f15745s.m19651c();
        return m19665b(j, rectF, j2);
    }

    private void m19664a(RectF rectF) {
        if (!this.f15737k) {
            boolean z;
            if (Looper.myLooper() != Looper.getMainLooper()) {
                z = true;
            } else {
                z = false;
            }
            Preconditions.checkArgument(z);
            File file = new File(this.f15729b.getPath());
            if (file.canRead()) {
                this.f15746t = new MediaExtractor();
                try {
                    this.f15746t.setDataSource(file.toString());
                    this.f15732e = m19656a(this.f15746t);
                    if (this.f15732e < 0) {
                        throw new RuntimeException("No video track found in " + file);
                    }
                    this.f15746t.selectTrack(this.f15732e);
                    MediaFormat trackFormat = this.f15746t.getTrackFormat(this.f15732e);
                    trackFormat.setInteger("max-input-size", 0);
                    if (this.f15745s != null) {
                        this.f15745s.m19649a();
                    }
                    if (this.f15745s == null) {
                        this.f15745s = this.f15747u.m19654a(m19666b(), rectF, this.f15730c, this.f15741o);
                    }
                    String string = trackFormat.getString("mime");
                    try {
                        m19669e();
                        this.f15744r = MediaCodec.createDecoderByType(string);
                        this.f15744r.configure(trackFormat, this.f15745s.m19650b(), null, 0);
                        this.f15744r.start();
                        this.f15737k = true;
                        return;
                    } catch (IOException e) {
                        throw new IllegalArgumentException("Unable to determine decoder: " + e);
                    }
                } catch (IOException e2) {
                    throw new IllegalArgumentException("Unable to set the data source: " + e2);
                }
            }
            throw new IllegalArgumentException("Unable to read " + file);
        }
    }

    private void m19663a(long j) {
        if (this.f15735h == -1 || this.f15736i == -1 || j < this.f15735h || j >= this.f15736i || this.f15734g >= j) {
            if (this.f15738l) {
                this.f15744r.flush();
                this.f15738l = false;
            }
            this.f15734g = -1;
            long min = Math.min((m19666b().a * 1000) - 200000, j);
            this.f15746t.seekTo(min, 1);
            this.f15736i = this.f15746t.getSampleTime();
            if (this.f15736i < j) {
                this.f15736i = 1 + j;
            }
            do {
                this.f15746t.seekTo(min, min <= f15728j ? 2 : 0);
                this.f15735h = this.f15746t.getSampleTime();
                min -= 200000;
                if (this.f15735h >= 0) {
                    return;
                }
            } while (min >= 0);
            return;
        }
        this.f15743q.a("profile_video_frame_retriever", "Not seeking!");
    }

    private CloseableReference<Bitmap> m19665b(long j, RectF rectF, long j2) {
        int a;
        ByteBuffer[] inputBuffers = this.f15744r.getInputBuffers();
        BufferInfo bufferInfo = new BufferInfo();
        this.f15733f = 0;
        m19663a(j);
        Object obj = null;
        int i = 0;
        long uptimeMillis = SystemClock.uptimeMillis();
        boolean z = false;
        while (obj == null) {
            Object obj2 = null;
            m19667b(j2);
            if (!z) {
                a = m19657a(inputBuffers, j);
                z = a == 1;
                obj2 = a != 2 ? 1 : null;
            }
            int a2 = m19655a(bufferInfo, j);
            obj = a2 == 1 ? 1 : null;
            Object obj3 = a2 != 2 ? 1 : null;
            if (a2 != 3) {
                if (obj2 == null && obj3 == null) {
                    long uptimeMillis2 = SystemClock.uptimeMillis() - uptimeMillis;
                    a = i + 1;
                    if (a > 5 && uptimeMillis2 > 300) {
                        BLog.a(f15727a, "Resetting decoder after %d ms", new Object[]{Long.valueOf(uptimeMillis2)});
                        m19671a();
                        m19662a(50);
                        m19664a(rectF);
                        m19662a(200);
                        this.f15736i = -1;
                        this.f15735h = -1;
                        this.f15734g = -1;
                        this.f15738l = false;
                        break;
                    }
                    i = a;
                } else {
                    uptimeMillis = SystemClock.uptimeMillis();
                    i = 0;
                }
            } else {
                CloseableReference<Bitmap> a3 = m19661a(z, j);
                if (!z) {
                    return a3;
                }
                m19671a();
                return a3;
            }
        }
        a = i;
        if (z) {
            m19671a();
        } else if (a >= 5) {
            BLog.b(f15727a, "Unable to provide an image due to stuck input/output");
            throw new IllegalStateException("Stuck on input/output streams");
        }
        return null;
    }

    private void m19667b(long j) {
        if (this.f15731d != null && !this.f15739m && this.f15742p.a() - j > 300) {
            this.f15739m = true;
            ExecutorDetour.a(this.f15740n, new C12051(this), 1276231266);
        }
    }

    private static void m19662a(int i) {
        try {
            Thread.sleep((long) i);
        } catch (InterruptedException e) {
        }
    }

    private int m19657a(ByteBuffer[] byteBufferArr, long j) {
        int dequeueInputBuffer = this.f15744r.dequeueInputBuffer(10000);
        if (dequeueInputBuffer < 0) {
            return 2;
        }
        this.f15738l = true;
        ByteBuffer byteBuffer = byteBufferArr[dequeueInputBuffer];
        int readSampleData = this.f15746t.readSampleData(byteBuffer, 0);
        long sampleTime = this.f15746t.getSampleTime();
        byteBuffer.clear();
        if (readSampleData < 0) {
            this.f15744r.queueInputBuffer(dequeueInputBuffer, 0, 0, sampleTime, 4);
            return 1;
        }
        if (this.f15746t.getSampleTrackIndex() != this.f15732e) {
            BLog.a(f15727a, "WEIRD: got sample from track %d, expected %d", new Object[]{Integer.valueOf(this.f15746t.getSampleTrackIndex()), Integer.valueOf(this.f15732e)});
        }
        this.f15744r.queueInputBuffer(dequeueInputBuffer, 0, readSampleData, sampleTime, 0);
        Object[] objArr = new Object[]{Integer.valueOf(this.f15733f), Integer.valueOf(readSampleData)};
        this.f15733f++;
        this.f15734g = this.f15746t.getSampleTime();
        objArr = new Object[]{Long.valueOf(this.f15734g), Long.valueOf(j)};
        this.f15746t.advance();
        return 0;
    }

    private int m19655a(BufferInfo bufferInfo, long j) {
        int dequeueOutputBuffer = this.f15744r.dequeueOutputBuffer(bufferInfo, 10000);
        if (!(dequeueOutputBuffer == -1 || dequeueOutputBuffer == -3)) {
            if (dequeueOutputBuffer == -2) {
                Object[] objArr = new Object[]{this.f15744r.getOutputFormat()};
            } else if (dequeueOutputBuffer < 0) {
                throw new RuntimeException("unexpected result from decoder.dequeueOutputBuffer: " + dequeueOutputBuffer);
            } else {
                boolean z;
                this.f15738l = true;
                Object[] objArr2 = new Object[]{Integer.valueOf(dequeueOutputBuffer), Integer.valueOf(bufferInfo.size)};
                if ((bufferInfo.flags & 4) != 0) {
                    z = true;
                } else {
                    z = false;
                }
                z = j - this.f15734g <= 10000 || z;
                if (!z) {
                    Object[] objArr3 = new Object[]{Integer.valueOf(bufferInfo.size), Long.valueOf(j - this.f15734g)};
                }
                this.f15744r.releaseOutputBuffer(dequeueOutputBuffer, z);
                if (z) {
                    return 3;
                }
                return 0;
            }
        }
        return 2;
    }

    private CloseableReference<Bitmap> m19661a(boolean z, long j) {
        this.f15745s.m19652d();
        CodecOutputSurface codecOutputSurface = this.f15745s;
        STextureRender sTextureRender = codecOutputSurface.f15709b;
        SurfaceTexture surfaceTexture = codecOutputSurface.f15710c;
        Preconditions.checkNotNull(sTextureRender.f15753d);
        Preconditions.checkArgument(!sTextureRender.f15753d.isEmpty());
        GLES20.glClearColor(0.0f, 1.0f, 0.0f, 1.0f);
        GLES20.glClear(16384);
        for (GLRenderer a : sTextureRender.f15753d) {
            a.a(surfaceTexture, sTextureRender.f15754e, sTextureRender.f15751b, sTextureRender.f15752c);
        }
        GLES20.glBindTexture(36197, 0);
        if (z) {
            m19668c();
        }
        return this.f15745s.m19653e();
    }

    private static int m19656a(MediaExtractor mediaExtractor) {
        int trackCount = mediaExtractor.getTrackCount();
        for (int i = 0; i < trackCount; i++) {
            if (mediaExtractor.getTrackFormat(i).getString("mime").startsWith("video/")) {
                return i;
            }
        }
        return -1;
    }

    private void m19668c() {
        this.f15746t.selectTrack(this.f15732e);
        this.f15744r.flush();
        this.f15744r.start();
    }

    private void m19669e() {
        if (this.f15744r != null) {
            try {
                this.f15744r.stop();
                this.f15744r.release();
            } catch (Throwable e) {
                BLog.b(f15727a, "Oddly, the decoder ran into issues releasing", e);
            } finally {
                this.f15744r = null;
            }
        }
    }

    public final void m19671a() {
        m19669e();
        if (this.f15746t != null) {
            this.f15746t.release();
            this.f15746t = null;
        }
        this.f15737k = false;
        if (this.f15745s != null) {
            this.f15745s.m19649a();
            this.f15745s = null;
        }
        this.f15738l = false;
        this.f15737k = false;
    }
}
