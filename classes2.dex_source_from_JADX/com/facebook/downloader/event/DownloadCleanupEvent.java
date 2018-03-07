package com.facebook.downloader.event;

import com.facebook.downloader.DownloadRequest.DownloadType;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: quickinvite_send_batch_invite */
public class DownloadCleanupEvent extends DownloadEvent {
    public DownloadCleanupEvent(DownloadType downloadType, @Nullable String str) {
        super(downloadType, str);
    }
}
