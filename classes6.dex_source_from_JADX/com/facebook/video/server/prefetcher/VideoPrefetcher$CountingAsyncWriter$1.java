package com.facebook.video.server.prefetcher;

import com.facebook.common.iolite.ProgressOutputStream;
import com.facebook.ui.media.cache.FileMetadata;
import com.facebook.video.server.AsyncWriter$Handler;
import com.facebook.video.server.prefetcher.VideoPrefetcher.CountingAsyncWriter;
import java.io.IOException;
import java.io.OutputStream;

/* compiled from: com.google.android.gms.maps.model.internal.ITileProviderDelegate */
class VideoPrefetcher$CountingAsyncWriter$1 implements AsyncWriter$Handler {
    final /* synthetic */ AsyncWriter$Handler f19588a;
    final /* synthetic */ CountingAsyncWriter f19589b;
    private OutputStream f19590c;

    VideoPrefetcher$CountingAsyncWriter$1(CountingAsyncWriter countingAsyncWriter, AsyncWriter$Handler asyncWriter$Handler) {
        this.f19589b = countingAsyncWriter;
        this.f19588a = asyncWriter$Handler;
    }

    public final void mo1419a(IOException iOException) {
        this.f19588a.mo1419a(iOException);
    }

    public final OutputStream mo1418a(FileMetadata fileMetadata) {
        this.f19590c = this.f19588a.mo1418a(fileMetadata);
        if (this.f19590c == null) {
            return null;
        }
        return new ProgressOutputStream(this.f19590c, this.f19589b);
    }

    public final void mo1420a(OutputStream outputStream, IOException iOException) {
        this.f19588a.mo1420a(this.f19590c, iOException);
    }
}
