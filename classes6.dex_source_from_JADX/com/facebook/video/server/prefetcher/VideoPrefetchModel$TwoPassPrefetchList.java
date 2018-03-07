package com.facebook.video.server.prefetcher;

import com.facebook.video.server.VideoResourceMetadata;

/* compiled from: com.google.android.location.LOCATION */
class VideoPrefetchModel$TwoPassPrefetchList implements VideoPrefetchList {
    private final VideoPrefetchListImpl f19584a;
    private final VideoPrefetchListImpl f19585b;

    public VideoPrefetchModel$TwoPassPrefetchList(VideoPrefetchListImpl videoPrefetchListImpl, VideoPrefetchListImpl videoPrefetchListImpl2) {
        this.f19584a = videoPrefetchListImpl;
        this.f19585b = videoPrefetchListImpl2;
    }

    public final void m28288a(VideoResourceMetadata... videoResourceMetadataArr) {
        this.f19584a.a(videoResourceMetadataArr);
        this.f19585b.a(videoResourceMetadataArr);
    }

    public final void m28291b(VideoResourceMetadata... videoResourceMetadataArr) {
        this.f19584a.b(videoResourceMetadataArr);
        this.f19585b.b(videoResourceMetadataArr);
    }

    public final void m28292c(VideoResourceMetadata... videoResourceMetadataArr) {
        this.f19584a.c(videoResourceMetadataArr);
        this.f19585b.c(videoResourceMetadataArr);
    }

    public final boolean m28289a() {
        return this.f19584a.a();
    }

    public final void m28287a(boolean z) {
        this.f19584a.a(z);
        this.f19585b.a(z);
    }

    public final void m28290b() {
        this.f19584a.b();
        this.f19585b.b();
    }
}
