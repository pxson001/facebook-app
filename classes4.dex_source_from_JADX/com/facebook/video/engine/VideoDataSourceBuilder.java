package com.facebook.video.engine;

import android.graphics.RectF;
import android.net.Uri;
import com.facebook.video.analytics.VideoAnalytics.StreamSourceType;
import com.facebook.video.engine.VideoDataSource.VideoMirroringMode;

/* compiled from: photoreminder */
public class VideoDataSourceBuilder {
    public Uri f4824a;
    public Uri f4825b;
    public Uri f4826c;
    public Uri f4827d;
    public String f4828e;
    public StreamSourceType f4829f;
    public RectF f4830g = VideoDataSource.f4815a;
    public VideoMirroringMode f4831h = VideoMirroringMode.NONE;

    public final VideoDataSourceBuilder m5251a(Uri uri) {
        this.f4824a = uri;
        return this;
    }

    public final VideoDataSourceBuilder m5253b(Uri uri) {
        this.f4825b = uri;
        return this;
    }

    public final VideoDataSourceBuilder m5252a(StreamSourceType streamSourceType) {
        this.f4829f = streamSourceType;
        return this;
    }

    public final VideoDataSource m5254i() {
        return new VideoDataSource(this);
    }
}
