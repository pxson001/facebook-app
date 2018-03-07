package com.facebook.ui.images.fetch;

import com.facebook.widget.images.UrlImage.UrlImageProgressListener;
import javax.annotation.Nullable;

/* compiled from: recent_searches_network */
public class DownloadAndInsertIntoCacheProgressUpdate {
    @Nullable
    private final UrlImageProgressListener f3611a;
    private final long f3612b;
    private int f3613c = 0;

    public DownloadAndInsertIntoCacheProgressUpdate(@Nullable UrlImageProgressListener urlImageProgressListener, long j) {
        this.f3611a = urlImageProgressListener;
        this.f3612b = j;
    }

    public final void m4038a(long j) {
        if (this.f3612b > 0 && this.f3611a != null) {
            this.f3613c = ((int) ((50 * j) / this.f3612b)) + this.f3613c;
            this.f3611a.a(this.f3613c);
        }
    }

    public final void m4037a() {
        this.f3613c = 0;
    }
}
