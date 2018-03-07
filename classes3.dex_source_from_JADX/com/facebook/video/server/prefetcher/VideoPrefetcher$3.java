package com.facebook.video.server.prefetcher;

import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import com.google.common.util.concurrent.FutureCallback;

/* compiled from: SubtitlesLocalesKey */
class VideoPrefetcher$3 implements FutureCallback<Void> {
    final /* synthetic */ VideoPrefetcher f365a;

    VideoPrefetcher$3(VideoPrefetcher videoPrefetcher) {
        this.f365a = videoPrefetcher;
    }

    public void onSuccess(Object obj) {
        if (VideoPrefetcher.j(this.f365a)) {
            HandlerDetour.a(this.f365a.l, this.f365a.D, 739315942);
        }
    }

    public void onFailure(Throwable th) {
        this.f365a.g.a(VideoPrefetcher.a, "Unexpected error in prefetching task", th);
    }
}
