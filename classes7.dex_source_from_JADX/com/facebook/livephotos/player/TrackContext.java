package com.facebook.livephotos.player;

import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import com.facebook.livephotos.egl.GLOffScreenSurface;
import com.facebook.livephotos.exoplayer.SampleSource;
import com.facebook.livephotos.exoplayer.TrackRenderer;
import com.facebook.livephotos.exoplayer.extractor.Extractor;
import com.facebook.livephotos.exoplayer.extractor.ExtractorSampleSource;
import com.facebook.livephotos.exoplayer.upstream.DefaultAllocator;
import com.facebook.livephotos.exoplayer.upstream.DefaultUriDataSource;

/* compiled from: onTouchStartCapture */
public class TrackContext<T extends TrackRenderer & HasUnknownDuration> {
    public float f7767a = 1.0f;
    public float f7768b = 1.0f;
    public boolean f7769c = false;
    public GLOffScreenSurface f7770d;
    public T f7771e;
    public T f7772f;

    public static TrackContext m9396a(Uri uri, Context context, Handler handler, VideoCompositionRenderer videoCompositionRenderer) {
        return new TrackContext(new PostrollTrackRenderer(context, m9395a(context, uri), handler, videoCompositionRenderer), null);
    }

    public TrackContext(T t, T t2) {
        this.f7771e = t;
        this.f7772f = t2;
    }

    public static SampleSource m9395a(Context context, Uri uri) {
        return new ExtractorSampleSource(uri, new DefaultUriDataSource(context, null, "LivePhotos"), new DefaultAllocator(32768), 4194304, new Extractor[0]);
    }
}
