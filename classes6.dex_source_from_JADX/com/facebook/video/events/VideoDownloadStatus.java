package com.facebook.video.events;

import java.util.HashMap;
import java.util.Map;

/* compiled from: composer_select_album */
public final class VideoDownloadStatus {
    public long f18949a;
    public long f18950b;
    public DownloadStatus f18951c;

    /* compiled from: composer_select_album */
    public enum DownloadStatus {
        DOWNLOAD_IN_PROGRESS(0),
        DOWNLOAD_PAUSED(1),
        DOWNLOAD_COMPLETED(2),
        DOWNLOAD_NOT_STARTED(3),
        DOWNLOAD_FAILED(4),
        DOWNLOAD_ABORTED(5),
        DOWNLOAD_NOT_REQUESTED(6);
        
        private static final Map<Integer, DownloadStatus> mReverseIndex = null;
        public final int mValue;

        static {
            mReverseIndex = new HashMap();
            DownloadStatus[] values = values();
            int length = values.length;
            int i;
            while (i < length) {
                DownloadStatus downloadStatus = values[i];
                mReverseIndex.put(Integer.valueOf(downloadStatus.mValue), downloadStatus);
                i++;
            }
        }

        private DownloadStatus(int i) {
            this.mValue = i;
        }

        public static DownloadStatus fromVal(int i) {
            if (mReverseIndex.containsKey(Integer.valueOf(i))) {
                return (DownloadStatus) mReverseIndex.get(Integer.valueOf(i));
            }
            throw new IllegalArgumentException("Invalid download status value");
        }
    }

    public VideoDownloadStatus(long j, long j2, DownloadStatus downloadStatus) {
        this.f18949a = j;
        this.f18950b = j2;
        this.f18951c = downloadStatus;
    }
}
