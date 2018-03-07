package com.facebook.downloader.event;

import com.facebook.downloader.DownloadRequest.DownloadType;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: quickcam_videos_taken */
public class DownloadErrorEvent extends DownloadEvent {
    public final ErrorCode f8302c;
    public final Exception f8303d;
    public final long f8304e;

    public DownloadErrorEvent(DownloadType downloadType, @Nullable String str, ErrorCode errorCode, @Nullable Exception exception, long j) {
        super(downloadType, str);
        this.f8302c = errorCode;
        this.f8303d = exception;
        this.f8304e = j;
    }
}
