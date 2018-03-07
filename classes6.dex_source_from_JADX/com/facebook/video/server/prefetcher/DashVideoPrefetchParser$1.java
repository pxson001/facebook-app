package com.facebook.video.server.prefetcher;

import com.facebook.video.server.VideoResourceMetadata;

/* compiled from: com.google.android.maps.KeyHelper */
class DashVideoPrefetchParser$1 implements Runnable {
    final /* synthetic */ String f19580a;
    final /* synthetic */ VideoPrefetchList f19581b;
    final /* synthetic */ VideoResourceMetadata f19582c;
    final /* synthetic */ DashVideoPrefetchParser f19583d;

    DashVideoPrefetchParser$1(DashVideoPrefetchParser dashVideoPrefetchParser, String str, VideoPrefetchList videoPrefetchList, VideoResourceMetadata videoResourceMetadata) {
        this.f19583d = dashVideoPrefetchParser;
        this.f19580a = str;
        this.f19581b = videoPrefetchList;
        this.f19582c = videoResourceMetadata;
    }

    public void run() {
        DashVideoPrefetchParser.b(this.f19583d, this.f19580a, this.f19581b, this.f19582c);
    }
}
