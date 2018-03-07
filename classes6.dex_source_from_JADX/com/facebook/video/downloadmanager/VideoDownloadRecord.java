package com.facebook.video.downloadmanager;

import android.net.Uri;
import com.facebook.video.events.VideoDownloadStatus.DownloadStatus;

/* compiled from: connection_manager_bandwidth_kbps */
public class VideoDownloadRecord {
    public String f18725a;
    public Uri f18726b;
    public long f18727c;
    public long f18728d;
    public String f18729e;
    public DownloadStatus f18730f;

    public VideoDownloadRecord() {
        this.f18730f = DownloadStatus.DOWNLOAD_NOT_STARTED;
    }

    public VideoDownloadRecord(VideoDownloadRequest videoDownloadRequest) {
        this.f18725a = videoDownloadRequest.f18732b;
        this.f18727c = videoDownloadRequest.f18735e;
        String queryParameter = videoDownloadRequest.f18731a.getQueryParameter("remote-uri");
        if (queryParameter != null) {
            this.f18726b = Uri.parse(queryParameter);
        } else {
            this.f18726b = videoDownloadRequest.f18731a;
        }
        this.f18730f = DownloadStatus.DOWNLOAD_NOT_STARTED;
    }
}
