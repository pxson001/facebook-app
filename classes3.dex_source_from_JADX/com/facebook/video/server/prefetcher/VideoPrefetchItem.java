package com.facebook.video.server.prefetcher;

import com.facebook.video.server.VideoResourceMetadata;

/* compiled from: RichVideoPlayerPartDefinition.prepare */
public class VideoPrefetchItem {
    public final boolean f377a;
    public final VideoResourceMetadata f378b;
    public final VideoPrefetchLocation f379c;

    public VideoPrefetchItem(VideoResourceMetadata videoResourceMetadata, VideoPrefetchLocation videoPrefetchLocation, boolean z) {
        this.f378b = videoResourceMetadata;
        this.f379c = videoPrefetchLocation;
        this.f377a = z;
    }

    public final VideoResourceMetadata m341a() {
        return this.f378b;
    }
}
