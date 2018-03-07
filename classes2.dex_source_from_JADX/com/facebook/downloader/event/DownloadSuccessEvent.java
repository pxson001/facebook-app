package com.facebook.downloader.event;

import com.facebook.downloader.DownloadRequest.DownloadType;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: quick_share_publish_success */
public class DownloadSuccessEvent extends DownloadEvent {
    private final int f8307c;
    public final String f8308d;
    public final long f8309e;

    public DownloadSuccessEvent(DownloadType downloadType, @Nullable String str, long j, String str2, int i) {
        super(downloadType, str);
        this.f8309e = j;
        this.f8308d = str2;
        this.f8307c = i;
    }
}
