package com.facebook.downloader.event;

/* compiled from: The favorite bookmark group was not found in BookmarkManager. */
public enum DownloadErrorEvent$ErrorCode {
    ERROR_NO_FREE_SPACE_TO_DOWNLOAD(1),
    ERROR_FAILED_TO_REMOVE_DOWNLOAD_ID(2),
    ERROR_EMPTY_DOWNLOAD_MANAGER_CURSOR(3),
    ERROR_DOWNLOAD_MANAGER_FAILURE(4),
    ERROR_DOWNLOAD_MANAGER_COMPLETION_EXCEPTION(5),
    ERROR_QUERYING_DOWNLOAD_SIZE(6);
    
    public final int value;

    private DownloadErrorEvent$ErrorCode(int i) {
        this.value = i;
    }
}
