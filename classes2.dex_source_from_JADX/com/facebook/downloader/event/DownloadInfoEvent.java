package com.facebook.downloader.event;

import com.facebook.downloader.DownloadRequest.DownloadType;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: quickcam_photos_taken */
public class DownloadInfoEvent extends DownloadEvent {
    public final InfoEvent f8305c;
    public final String f8306d;

    public DownloadInfoEvent(DownloadType downloadType, @Nullable String str, InfoEvent infoEvent, @Nullable String str2) {
        super(downloadType, str);
        this.f8305c = infoEvent;
        this.f8306d = str2;
    }
}
