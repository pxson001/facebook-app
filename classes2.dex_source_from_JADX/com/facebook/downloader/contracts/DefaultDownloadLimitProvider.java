package com.facebook.downloader.contracts;

import com.facebook.downloader.DownloadRequest.DownloadType;

/* compiled from: reachable */
public class DefaultDownloadLimitProvider {
    public final long m12731a(DownloadType downloadType) {
        if (downloadType == DownloadType.VIDEOAD) {
            return 52428800;
        }
        return -1;
    }

    public final long m12732b(DownloadType downloadType) {
        if (downloadType == DownloadType.VIDEOAD) {
            return 10485760;
        }
        return -1;
    }
}
