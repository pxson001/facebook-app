package com.facebook.video.server.prefetcher;

import android.net.Uri;
import com.facebook.common.eventbus.TypedHandler;
import com.facebook.video.analytics.PrefetchItemSequence;
import com.facebook.video.server.prefetcher.PrefetchItemSequenceLogger.Handler;

/* compiled from: ShowDeleteOptionKey */
public class PrefetchEvents$PrefetchItemBeginEvent extends PrefetchEvents$BasePrefetchEvent<Handler> {
    public Uri f370b;

    public final void m335a(TypedHandler typedHandler) {
        Handler handler = (Handler) typedHandler;
        if (handler.f368c == null) {
            handler.f368c = handler.f366a.f363a.a(PrefetchItemSequence.a);
            handler.f367b = this.f371a;
            handler.f369d = 0;
        }
    }

    public PrefetchEvents$PrefetchItemBeginEvent(int i, Uri uri) {
        super(i);
        this.f370b = uri;
    }
}
