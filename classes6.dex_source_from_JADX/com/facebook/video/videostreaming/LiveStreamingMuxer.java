package com.facebook.video.videostreaming;

import android.annotation.TargetApi;
import android.media.MediaCodec.BufferInfo;
import com.facebook.common.tempfile.TempFileManager;
import com.facebook.debug.log.BLog;
import com.facebook.inject.InjectorLike;
import com.facebook.videocodec.codecs.CodecBuffer;
import com.facebook.videocodec.codecs.MediaBaseCodecBuffer;
import com.facebook.videocodec.muxers.CodecMuxer;
import com.facebook.videocodec.resizer.CodecMuxerMethodAutoProvider;
import com.google.common.base.Preconditions;
import java.io.File;
import java.nio.ByteBuffer;
import javax.inject.Inject;

@TargetApi(18)
/* compiled from: save-profile-question */
public class LiveStreamingMuxer {
    public static final String f5374a = LiveStreamer.class.getName();
    public TempFileManager f5375b;
    private CodecMuxer f5376c;
    public File f5377d = null;
    public LiveStreamingEncoder f5378e;
    public LiveStreamingEncoder f5379f;
    public boolean f5380g = false;
    public long f5381h = -1;
    public boolean f5382i = false;

    public static LiveStreamingMuxer m8079b(InjectorLike injectorLike) {
        return new LiveStreamingMuxer(CodecMuxerMethodAutoProvider.m8263a(injectorLike), TempFileManager.a(injectorLike));
    }

    @Inject
    public LiveStreamingMuxer(CodecMuxer codecMuxer, TempFileManager tempFileManager) {
        this.f5376c = codecMuxer;
        this.f5375b = tempFileManager;
    }

    public final void m8085c() {
        if (this.f5380g) {
            try {
                this.f5376c.mo374b();
            } catch (Throwable e) {
                this.f5382i = true;
                BLog.b(f5374a, "LiveStreamMux Error stopping muxer ", e);
            }
        } else {
            BLog.a(f5374a, "LiveStreamMux Never started muxer...Nothing to stop ");
        }
        this.f5380g = false;
    }

    public final void m8083a(ByteBuffer byteBuffer, int i, int i2, int i3, int i4, int i5, BufferInfo bufferInfo) {
        MediaBaseCodecBuffer c = m8081c(byteBuffer, i, i2, i3, i4, i5, bufferInfo);
        if (bufferInfo.presentationTimeUs < this.f5381h) {
            BLog.a(f5374a, "LiveStreamMux Audio PTS OutOfOrder CurPresentationTime %d Last PresentationTime %d ", new Object[]{Long.valueOf(bufferInfo.presentationTimeUs), Long.valueOf(this.f5381h)});
            return;
        }
        this.f5381h = bufferInfo.presentationTimeUs;
        m8078a(c);
    }

    public final void m8084b(ByteBuffer byteBuffer, int i, int i2, int i3, int i4, int i5, BufferInfo bufferInfo) {
        m8080b(m8081c(byteBuffer, i, i2, i3, i4, i5, bufferInfo));
    }

    private synchronized void m8078a(MediaBaseCodecBuffer mediaBaseCodecBuffer) {
        if (!this.f5382i) {
            if (!this.f5380g) {
                m8082d();
            }
            if (this.f5380g) {
                try {
                    this.f5376c.mo372a((CodecBuffer) mediaBaseCodecBuffer);
                } catch (Throwable e) {
                    this.f5382i = true;
                    BLog.b(f5374a, "LiveStreamMux Error writing Audio samples ", e);
                }
            }
        }
    }

    private synchronized void m8080b(MediaBaseCodecBuffer mediaBaseCodecBuffer) {
        if (!this.f5382i) {
            if (!this.f5380g) {
                m8082d();
            }
            if (this.f5380g) {
                try {
                    this.f5376c.mo376b((CodecBuffer) mediaBaseCodecBuffer);
                } catch (Throwable e) {
                    this.f5382i = true;
                    BLog.b(f5374a, "LiveStreamMux Error writing Video samples ", e);
                }
            }
        }
    }

    private static MediaBaseCodecBuffer m8081c(ByteBuffer byteBuffer, int i, int i2, int i3, int i4, int i5, BufferInfo bufferInfo) {
        MediaBaseCodecBuffer mediaBaseCodecBuffer = new MediaBaseCodecBuffer(byteBuffer, i5, bufferInfo);
        mediaBaseCodecBuffer.mo364a(i, i2, (long) (i3 * 1000), i4);
        return mediaBaseCodecBuffer;
    }

    private void m8082d() {
        Preconditions.checkNotNull(this.f5377d);
        try {
            this.f5376c.mo373a(this.f5377d.getPath());
            this.f5376c.mo375b(this.f5379f.m8074e());
            this.f5376c.mo370a(0);
            this.f5376c.mo371a(this.f5378e.m8075f());
            this.f5376c.mo369a();
            this.f5380g = true;
        } catch (Throwable e) {
            this.f5382i = true;
            BLog.b(f5374a, "LiveStreamMux Error adding tracks and starting muxer ", e);
            this.f5380g = false;
        }
    }
}
