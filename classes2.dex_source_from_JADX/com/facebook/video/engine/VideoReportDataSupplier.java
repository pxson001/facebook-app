package com.facebook.video.engine;

import android.os.Build.VERSION;
import com.facebook.common.errorreporting.FbCustomReportDataSupplier;
import com.facebook.inject.Lazy;
import com.google.android.exoplayer.DecoderInfo;
import com.google.android.exoplayer.MediaCodecUtil;
import com.google.android.exoplayer.MediaCodecUtil.DecoderQueryException;
import javax.inject.Inject;

/* compiled from: trace_id */
public class VideoReportDataSupplier implements FbCustomReportDataSupplier {
    private static String f2287a;
    private Lazy<VideoPlayerManager> f2288b;

    @Inject
    public VideoReportDataSupplier(Lazy<VideoPlayerManager> lazy) {
        this.f2288b = lazy;
    }

    public final String mo633a(Throwable th) {
        StringBuffer stringBuffer = new StringBuffer();
        if (this.f2288b.get() != null) {
            stringBuffer.append(((VideoPlayerManager) this.f2288b.get()).m13934b());
        }
        stringBuffer.append("exo_video_decoder=" + m4472b() + "\n");
        return stringBuffer.toString();
    }

    private static String m4472b() {
        if (f2287a == null) {
            f2287a = "not_supported";
            if (VERSION.SDK_INT >= 16) {
                try {
                    DecoderInfo a = MediaCodecUtil.a("video/avc", false);
                    String str = (a == null || a.a == null) ? "unknown" : a.a;
                    f2287a = str;
                } catch (DecoderQueryException e) {
                }
            }
        }
        return f2287a;
    }

    public final String mo632a() {
        return "video_state";
    }
}
