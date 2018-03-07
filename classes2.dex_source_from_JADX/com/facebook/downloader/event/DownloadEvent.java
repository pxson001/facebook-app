package com.facebook.downloader.event;

import com.facebook.content.event.FbEvent;
import com.facebook.downloader.DownloadRequest.DownloadType;
import javax.annotation.Nullable;

/* compiled from: quickinvite_send_invite */
public class DownloadEvent implements FbEvent {
    public final DownloadType f8300a;
    protected final String f8301b;

    public DownloadEvent(DownloadType downloadType, @Nullable String str) {
        this.f8300a = downloadType;
        this.f8301b = str;
    }
}
