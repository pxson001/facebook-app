package com.facebook.downloader.event;

import com.facebook.downloader.DownloadRequest.DownloadType;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: radii should have exactly 8 values */
public class DownloadBroadcastEvent extends DownloadEvent {
    public final long f8299c;

    public DownloadBroadcastEvent(DownloadType downloadType, @Nullable String str, long j) {
        super(downloadType, str);
        this.f8299c = j;
    }
}
